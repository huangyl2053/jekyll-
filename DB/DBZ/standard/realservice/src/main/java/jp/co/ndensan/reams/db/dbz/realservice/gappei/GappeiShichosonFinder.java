/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HokenshaKoseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.GappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.config.GappeiJohoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.realservice.search.GappeiJohoSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.search.GappeiShichosonSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.search.KoseiShichosonMasterSearchItem;
import jp.co.ndensan.reams.ur.urz.realservice.search.FlexibleDateOperator;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合併市町村情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonFinder implements IGappeiShichosonFinder {

    private final GappeiJohoDac gappeiJohoDac;
    private final GappeiShichosonDac gappeiShichosonDac;
    private final KoseiShichosonMasterDac koseiShichosonDac;
    private final GappeiJohoConfig gappeiJohoConfig;
    private final HokenshaJohoConfig hokenshaJohoConfig;

    private static final RString 表示対象 = new RString("1");

    /**
     * コンストラクタです。
     */
    public GappeiShichosonFinder() {
        gappeiJohoDac = InstanceProvider.create(GappeiJohoDac.class);
        gappeiShichosonDac = InstanceProvider.createWithCustomize(GappeiShichosonDac.class);
        koseiShichosonDac = InstanceProvider.createWithCustomize(KoseiShichosonMasterDac.class);
        gappeiJohoConfig = new GappeiJohoConfig();
        hokenshaJohoConfig = new HokenshaJohoConfig();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param gappeiJohoDac 合併情報Dac
     * @param gappeiShichosonDac 合併市町村Dac
     * @param koseiShichosonDac 構成市町村Dac
     * @param gappeiJohoConfig 合併情報Config
     * @param hokenshaJohoConfig 保険者情報Config
     */
    GappeiShichosonFinder(
            GappeiJohoDac gappeiJohoDac, GappeiShichosonDac gappeiShichosonDac, KoseiShichosonMasterDac koseiShichosonDac,
            GappeiJohoConfig gappeiJohoConfig, HokenshaJohoConfig hokenshaJohoConfig) {
        this.gappeiJohoDac = gappeiJohoDac;
        this.gappeiShichosonDac = gappeiShichosonDac;
        this.koseiShichosonDac = koseiShichosonDac;
        this.gappeiJohoConfig = gappeiJohoConfig;
        this.hokenshaJohoConfig = hokenshaJohoConfig;
    }

    @Override
    public boolean is合併あり() {
        return gappeiJohoConfig.get合併情報区分() == GappeiJohoKubun.合併あり;
    }

    @Override
    public IOptional<FlexibleDate> get旧市町村情報付与終了日() {
        IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.selectAll();
        if (!合併情報List.isEmpty()) {
            return DbOptional.of(合併情報List.asList().get(合併情報List.size() - 1).get旧市町村情報付与終了日());
        }
        return DbOptional.empty();
    }

    @Override
    public IItemList<GappeiShichosonJoho> get合併市町村情報(boolean 表示対象のみ) {

        if (!is合併あり()) {
            return ItemList.empty();
        }

        IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.selectAll();
        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報List(合併情報List.asList(), 表示対象のみ);

        return ItemList.of(合併市町村情報List);
    }

    @Override
    public IItemList<GappeiShichosonJoho> get合併市町村情報(LasdecCode 旧市町村コード) {

        ITrueFalseCriteria 合併市町村検索条件 = make合併市町村Key(旧市町村コード);
        ITrueFalseCriteria 構成市町村検索条件 = make構成市町村Key(旧市町村コード);
        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報List(合併市町村検索条件, 構成市町村検索条件);

        return ItemList.of(合併市町村情報List);
    }

    @Override
    public IItemList<GappeiShichosonJoho> get合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号) {

        ITrueFalseCriteria 合併市町村検索条件 = make合併市町村Key(旧保険者番号);
        ITrueFalseCriteria 構成市町村検索条件 = make構成市町村Key(旧保険者番号);
        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報List(合併市町村検索条件, 構成市町村検索条件);

        return ItemList.of(合併市町村情報List);
    }

    @Override
    public IOptional<GappeiShichosonJoho> get最新合併市町村情報(LasdecCode 市町村コード) {
        return get最新合併市町村情報(make合併情報Key(市町村コード));
    }

    @Override
    public IOptional<GappeiShichosonJoho> get最新合併市町村情報(ShoKisaiHokenshaNo 保険者番号) {
        return get最新合併市町村情報(make合併情報Key(保険者番号));
    }

    @Override
    public IOptional<GappeiShichosonJoho> get最新合併市町村情報(ShoKisaiHokenshaNo 保険者番号, FlexibleYearMonth 基準年月) {
        return get最新合併市町村情報(make合併情報Key(保険者番号, 基準年月));
    }

    @Override
    public IOptional<GappeiShichosonJoho> get最古合併市町村情報(LasdecCode 旧市町村コード) {

        ITrueFalseCriteria 合併市町村検索条件 = make合併市町村Key(旧市町村コード);
        ITrueFalseCriteria 構成市町村検索条件 = make構成市町村Key(旧市町村コード);
        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報List(合併市町村検索条件, 構成市町村検索条件);

        if (!合併市町村情報List.isEmpty()) {
            return DbOptional.of(合併市町村情報List.get(0));
        }

        return DbOptional.empty();
    }

    @Override
    public IOptional<GappeiShichosonJoho> get直近合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号) {

        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報(旧保険者番号).asList();

        if (!合併市町村情報List.isEmpty()) {
            return DbOptional.of(合併市町村情報List.get(合併市町村情報List.size() - 1));
        }

        return DbOptional.empty();
    }

    @Override
    public IOptional<GappeiShichosonJoho> get直近合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号, FlexibleYearMonth 基準年月) {

        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報(旧保険者番号).asList();

        for (GappeiShichosonJoho 合併市町村情報 : 合併市町村情報List) {
            if (基準年月.isBefore(合併市町村情報.get合併情報().get().get国保連データ連携開始日().getYearMonth())) {
                return DbOptional.of(合併市町村情報);
            }
        }

        return DbOptional.empty();
    }

    @Override
    public IOptional<GappeiShichosonJoho> get市町村情報(LasdecCode 市町村コード) {

        HokenshaKoseiKubun 保険者構成区分;
        List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
        List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();

        if (is単一市町村()) {
            保険者構成区分 = HokenshaKoseiKubun.単一市町村;
            ITrueFalseCriteria 検索条件 = make合併市町村Key(市町村コード);
            合併市町村List = gappeiShichosonDac.select(検索条件).asList();
        } else {
            保険者構成区分 = HokenshaKoseiKubun.広域保険者;
            ITrueFalseCriteria 検索条件 = make構成市町村Key(市町村コード);
            構成市町村List = koseiShichosonDac.select(検索条件).asList();
        }

        return create合併市町村情報(null, 保険者構成区分, 合併市町村List, 構成市町村List);
    }

    @Override
    public IOptional<GappeiShichosonJoho> get市町村情報(ShoKisaiHokenshaNo 保険者番号) {

        HokenshaKoseiKubun 保険者構成区分;
        List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
        List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();

        if (is単一市町村()) {
            保険者構成区分 = HokenshaKoseiKubun.単一市町村;
            ITrueFalseCriteria 検索条件 = make合併市町村Key(保険者番号);
            合併市町村List = gappeiShichosonDac.select(検索条件).asList();
        } else {
            保険者構成区分 = HokenshaKoseiKubun.広域保険者;
            ITrueFalseCriteria 検索条件 = make構成市町村Key(保険者番号);
            構成市町村List = koseiShichosonDac.select(検索条件).asList();
        }

        return create合併市町村情報(null, 保険者構成区分, 合併市町村List, 構成市町村List);
    }

    @Override
    public IOptional<GappeiShichosonJoho> get最古市町村情報(LasdecCode 市町村コード) {

        HokenshaKoseiKubun 保険者構成区分;
        List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
        List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();

        if (is単一市町村()) {
            保険者構成区分 = HokenshaKoseiKubun.単一市町村;
            ITrueFalseCriteria 検索条件 = make合併市町村Key(市町村コード);
            List<IGappeiShichoson> list = gappeiShichosonDac.select(検索条件).asList();
            if (!list.isEmpty()) {
                合併市町村List.add(list.get(0));
            }
        } else {
            保険者構成区分 = HokenshaKoseiKubun.広域保険者;
            ITrueFalseCriteria 検索条件 = make構成市町村Key(市町村コード);
            List<IKoikiKoseiShichoson> list = 構成市町村List = koseiShichosonDac.select(検索条件).asList();
            if (!list.isEmpty()) {
                構成市町村List.add(list.get(0));
            }
        }

        return create合併市町村情報(null, 保険者構成区分, 合併市町村List, 構成市町村List);
    }

    @Override
    public IItemList<GappeiShichosonJoho> find合併市町村情報(ISearchCondition 検索条件, boolean 表示対象のみ) {

        if (!is合併あり()) {
            return ItemList.empty();
        }

        IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.select(検索条件.makeSearchCondition());
        List<GappeiShichosonJoho> 合併市町村情報List = get合併市町村情報List(合併情報List.asList(), 表示対象のみ);

        return ItemList.of(合併市町村情報List);
    }

    private boolean is単一市町村() {
        return hokenshaJohoConfig.get保険者構成() == HokenshaKoseiKubun.単一市町村;
    }

    private IOptional<GappeiShichosonJoho> get最新合併市町村情報(ITrueFalseCriteria 検索条件) {

        IGappeiJoho 合併情報 = get最新合併情報(検索条件);
        if (合併情報 == null) {
            return DbOptional.empty();
        }

        HokenshaKoseiKubun 保険者構成区分;
        List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
        List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();

        if (is単一市町村()) {
            保険者構成区分 = HokenshaKoseiKubun.単一市町村;
            合併市町村List = get最新合併市町村List(合併情報);
        } else {
            保険者構成区分 = HokenshaKoseiKubun.広域保険者;
            構成市町村List = get最新構成市町村List(合併情報);
        }

        return create合併市町村情報(合併情報, 保険者構成区分, 合併市町村List, 構成市町村List);
    }

    private IGappeiJoho get最新合併情報(ITrueFalseCriteria 検索条件) {
        IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.select(検索条件);
        if (合併情報List.isEmpty()) {
            return null;
        }
        return 合併情報List.asList().get(合併情報List.size() - 1);
    }

    private List<IGappeiShichoson> get最新合併市町村List(IGappeiJoho 合併情報) {
        List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
        ITrueFalseCriteria 検索条件 = make合併市町村Key(合併情報.get合併日(), 合併情報.get地域番号(), 合併情報.get市町村コード(), false);
        IItemList<IGappeiShichoson> list = gappeiShichosonDac.select(検索条件);
        if (!list.isEmpty()) {
            合併市町村List.add(list.asList().get(list.size() - 1));
        }
        return 合併市町村List;
    }

    private List<IKoikiKoseiShichoson> get最新構成市町村List(IGappeiJoho 合併情報) {
        List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();
        ITrueFalseCriteria 検索条件 = make構成市町村Key(合併情報.get市町村コード());
        IItemList<IKoikiKoseiShichoson> list = koseiShichosonDac.select(検索条件);
        if (!list.isEmpty()) {
            構成市町村List.add(list.asList().get(list.size() - 1));
        }
        return 構成市町村List;
    }

    private List<GappeiShichosonJoho> get合併市町村情報List(List<IGappeiJoho> 合併情報List, boolean 表示対象のみ) {

        List<GappeiShichosonJoho> 合併市町村情報List = new ArrayList<>();

        for (IGappeiJoho 合併情報 : 合併情報List) {

            HokenshaKoseiKubun 保険者構成区分;
            List<IGappeiShichoson> 合併市町村List = new ArrayList<>();
            List<IKoikiKoseiShichoson> 構成市町村List = new ArrayList<>();

            if (is単一市町村()) {
                保険者構成区分 = HokenshaKoseiKubun.単一市町村;
                ITrueFalseCriteria 検索条件 = make合併市町村Key(合併情報.get合併日(), 合併情報.get地域番号(), 合併情報.get市町村コード(), 表示対象のみ);
                合併市町村List = gappeiShichosonDac.select(検索条件).asList();
            } else {
                保険者構成区分 = HokenshaKoseiKubun.広域保険者;
                ITrueFalseCriteria 検索条件 = make構成市町村Key(合併情報.get地域番号(), 表示対象のみ);
                構成市町村List = koseiShichosonDac.select(検索条件).asList();
            }

            IOptional<GappeiShichosonJoho> 合併市町村情報 = create合併市町村情報(合併情報, 保険者構成区分, 合併市町村List, 構成市町村List);
            合併市町村情報List.add(合併市町村情報.get());
        }

        return 合併市町村情報List;
    }

    private List<GappeiShichosonJoho> get合併市町村情報List(ITrueFalseCriteria 合併市町村検索条件, ITrueFalseCriteria 構成市町村検索条件) {

        Map<FlexibleDate, GappeiShichosonJoho> map = new TreeMap<>();

        if (is単一市町村()) {
            IItemList<IGappeiShichoson> 合併市町村List = gappeiShichosonDac.select(合併市町村検索条件);
            for (IGappeiShichoson 合併市町村 : 合併市町村List) {
                ITrueFalseCriteria 検索条件 = make合併情報Key(合併市町村.get合併日(), 合併市町村.get地域番号(), 合併市町村.get旧市町村コード());
                IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.select(検索条件);
                if (合併情報List.isEmpty()) {
                    continue;
                }
                IGappeiJoho 合併情報 = 合併情報List.asList().get(0);
                List<IGappeiShichoson> list = new ArrayList<>();
                list.add(合併市町村);
                IOptional<GappeiShichosonJoho> 合併市町村情報 = create合併市町村情報(
                        合併情報, HokenshaKoseiKubun.単一市町村, list, new ArrayList<IKoikiKoseiShichoson>());
                map.put(合併情報.get国保連データ連携開始日(), 合併市町村情報.get());
            }

        } else {
            IItemList<IKoikiKoseiShichoson> 構成市町村List = koseiShichosonDac.select(構成市町村検索条件);
            for (IKoikiKoseiShichoson 構成市町村 : 構成市町村List) {
                ITrueFalseCriteria 検索条件 = make合併情報Key(構成市町村.get合併情報地域番号());
                IItemList<IGappeiJoho> 合併情報List = gappeiJohoDac.select(検索条件);
                if (合併情報List.isEmpty()) {
                    continue;
                }
                IGappeiJoho 合併情報 = 合併情報List.asList().get(0);
                List<IKoikiKoseiShichoson> list = new ArrayList<>();
                list.add(構成市町村);
                IOptional<GappeiShichosonJoho> 合併市町村情報 = create合併市町村情報(
                        合併情報, HokenshaKoseiKubun.広域保険者, new ArrayList<IGappeiShichoson>(), list);
                map.put(合併情報.get国保連データ連携開始日(), 合併市町村情報.get());
            }
        }

        return (List) Arrays.asList(map.values().toArray());
    }

    private IOptional<GappeiShichosonJoho> create合併市町村情報(
            IGappeiJoho 合併情報, HokenshaKoseiKubun 保険者構成区分, List<IGappeiShichoson> 合併市町村List, List<IKoikiKoseiShichoson> 構成市町村List) {
        GappeiShichosonJoho 合併市町村情報 = new GappeiShichosonJoho(
                DbOptional.ofNullable(合併情報), 保険者構成区分, ItemList.of(合併市町村List), ItemList.of(構成市町村List));
        return DbOptional.of(合併市町村情報);
    }

    private ITrueFalseCriteria make合併情報Key(FlexibleDate 合併日, RString 地域番号, LasdecCode 市町村コード) {
        return get合併情報Key(合併日, 地域番号, 市町村コード, null, null).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併情報Key(RString 地域番号) {
        return get合併情報Key(null, 地域番号, null, null, null).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併情報Key(LasdecCode 市町村コード) {
        return get合併情報Key(null, null, 市町村コード, null, null).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併情報Key(ShoKisaiHokenshaNo 保険者番号) {
        return get合併情報Key(null, null, null, 保険者番号, null).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併情報Key(ShoKisaiHokenshaNo 保険者番号, FlexibleYearMonth 基準年月) {
        return get合併情報Key(null, null, null, 保険者番号, 基準年月).makeSearchCondition();
    }

    private INewSearchCondition get合併情報Key(
            FlexibleDate 合併日, RString 地域番号, LasdecCode 市町村コード, ShoKisaiHokenshaNo 保険者番号, FlexibleYearMonth 基準年月) {

        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (合併日 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiJohoSearchItem.合併日, FlexibleDateOperator.等しい, 合併日));
        }
        if (地域番号 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiJohoSearchItem.地域番号, StringOperator.完全一致, 地域番号));
        }
        if (市町村コード != null) {
            条件List.add(SearchConditionFactory.condition(GappeiJohoSearchItem.市町村コード, StringOperator.完全一致, 市町村コード.value()));
        }
        if (保険者番号 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiJohoSearchItem.保険者番号, StringOperator.完全一致, 保険者番号.value()));
        }
        if (基準年月 != null) {
            FlexibleDate 基準日 = new FlexibleDate(基準年月.getYearValue(), 基準年月.getMonthValue(), 基準年月.getLastDay());
            条件List.add(SearchConditionFactory.condition(GappeiJohoSearchItem.国保連データ連携開始日, FlexibleDateOperator.以前, 基準日));
        }

        return and検索条件(条件List);
    }

    private ITrueFalseCriteria make合併市町村Key(FlexibleDate 合併日, RString 地域番号, LasdecCode 旧市町村コード, boolean 表示対象のみ) {
        return get合併市町村Key(合併日, 地域番号, 旧市町村コード, null, 表示対象のみ).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併市町村Key(LasdecCode 旧市町村コード) {
        return get合併市町村Key(null, null, 旧市町村コード, null, false).makeSearchCondition();
    }

    private ITrueFalseCriteria make合併市町村Key(ShoKisaiHokenshaNo 旧保険者番号) {
        return get合併市町村Key(null, null, null, 旧保険者番号, false).makeSearchCondition();
    }

    private INewSearchCondition get合併市町村Key(
            FlexibleDate 合併日, RString 地域番号, LasdecCode 旧市町村コード, ShoKisaiHokenshaNo 旧保険者番号, boolean 表示対象のみ) {

        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (合併日 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiShichosonSearchItem.合併日, FlexibleDateOperator.等しい, 合併日));
        }
        if (地域番号 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiShichosonSearchItem.地域番号, StringOperator.完全一致, 地域番号));
        }
        if (旧市町村コード != null) {
            条件List.add(SearchConditionFactory.condition(GappeiShichosonSearchItem.旧市町村コード, StringOperator.完全一致, 旧市町村コード.value()));
        }
        if (旧保険者番号 != null) {
            条件List.add(SearchConditionFactory.condition(GappeiShichosonSearchItem.旧保険者番号, StringOperator.完全一致, 旧保険者番号.value()));
        }
        if (表示対象のみ) {
            条件List.add(SearchConditionFactory.condition(GappeiShichosonSearchItem.表示有無, StringOperator.完全一致, 表示対象));
        }

        return and検索条件(条件List);
    }

    private ITrueFalseCriteria make構成市町村Key(RString 地域番号, boolean 表示対象のみ) {
        return get構成市町村Key(地域番号, null, null, 表示対象のみ).makeSearchCondition();
    }

    private ITrueFalseCriteria make構成市町村Key(LasdecCode 市町村コード) {
        return get構成市町村Key(null, 市町村コード, null, false).makeSearchCondition();
    }

    private ITrueFalseCriteria make構成市町村Key(ShoKisaiHokenshaNo 保険者番号) {
        return get構成市町村Key(null, null, 保険者番号, false).makeSearchCondition();
    }

    private INewSearchCondition get構成市町村Key(
            RString 地域番号, LasdecCode 市町村コード, ShoKisaiHokenshaNo 保険者番号, boolean 表示対象のみ) {

        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (地域番号 != null) {
            条件List.add(SearchConditionFactory.condition(KoseiShichosonMasterSearchItem.合併情報地域番号, StringOperator.完全一致, 地域番号));
        }
        if (市町村コード != null) {
            条件List.add(SearchConditionFactory.condition(KoseiShichosonMasterSearchItem.市町村コード, StringOperator.完全一致, 市町村コード.value()));
        }
        if (保険者番号 != null) {
            条件List.add(SearchConditionFactory.condition(KoseiShichosonMasterSearchItem.証記載保険者番号, StringOperator.完全一致, 保険者番号.value()));
        }
        if (表示対象のみ) {
            条件List.add(SearchConditionFactory.condition(KoseiShichosonMasterSearchItem.合併旧市町村表示有無, StringOperator.完全一致, 表示対象));
        }

        return and検索条件(条件List);
    }

    private INewSearchCondition and検索条件(List<INewSearchCondition> 検索条件List) {
        INewSearchCondition 検索条件 = null;
        for (INewSearchCondition 条件 : 検索条件List) {
            if (検索条件 == null) {
                検索条件 = 条件;
            } else {
                検索条件.and(条件);
            }
        }
        return 検索条件;
    }
}
