/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.comparator.GappeiJohoComparators;
import jp.co.ndensan.reams.db.dbz.business.comparator.KoikiKoseiShichosonComparators;
import jp.co.ndensan.reams.db.dbz.business.comparator.MultiComparator;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IKoikiGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.KoikiGappeiShichosonJohoModel;
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
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    private static final RString 表示対象 = new RString("1");

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public GappeiShichosonFinder() {
        gappeiJohoDac = InstanceProvider.create(GappeiJohoDac.class);
        gappeiShichosonDac = InstanceProvider.createWithCustomize(GappeiShichosonDac.class);
        koseiShichosonDac = InstanceProvider.createWithCustomize(KoseiShichosonMasterDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param gappeiJohoDac 合併情報Dac
     * @param gappeiShichosonDac 合併市町村Dac
     * @param koseiShichosonDac 構成市町村Dac
     */
    GappeiShichosonFinder(
            GappeiJohoDac gappeiJohoDac,
            GappeiShichosonDac gappeiShichosonDac,
            KoseiShichosonMasterDac koseiShichosonDac) {
        this.gappeiJohoDac = gappeiJohoDac;
        this.gappeiShichosonDac = gappeiShichosonDac;
        this.koseiShichosonDac = koseiShichosonDac;
    }

    @Override
    public boolean is合併あり() {

        // TODO
        // 「コンフィグ.合併市町村管理_合併情報区分」の設定に従って、以下の処理を行う。
        // 「0：合併なし」の場合、falseを返す。
        // 「1：合併あり」の場合、trueを返す。
        //
        return true;
    }

    @Override
    public IOptional<FlexibleDate> get旧市町村情報付与終了日() {

        // TODO
        // 最新の合併情報を取得し、旧市町村情報付与終了日を返却する。
        //
        IOptional<IGappeiJoho> gappeiJoho = get最新合併情報(gappeiJohoDac.selectAll());
        return DbOptional.ofNullable(gappeiJoho.isPresent() ? gappeiJoho.get().get旧市町村情報付与終了日() : null);
    }

    @Override
    public IItemList<IGappeiShichosonJoho> get全合併市町村(boolean 表示対象のみ) {

        // TODO
        // 合併ありかどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 全合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　取得した合併情報が含む合併市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と合併市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return ItemList.empty();
        }
        List<IGappeiShichosonJoho> 合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = gappeiJohoDac.selectAll();
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For合併市町村(合併情報.get地域番号(), 表示対象のみ);
            IItemList<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.select(searchKey);
            合併市町村情報リスト.add(new GappeiShichosonJohoModel(DbOptional.of(合併情報), 合併市町村リスト));
        }
        return ItemList.of(合併市町村情報リスト);
    }

    @Override
    public IItemList<IGappeiShichoson> get全旧市町村() {

        // TODO
        // 全合併市町村情報を取得する。
        // 取得した合併市町村情報の中に旧市町村コードが同一の情報がある場合は、最新の情報のみを対象とする。
        // 取得した合併市町村情報のリストを返却する。
        //
        IItemList<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.selectAll();
        return get最新合併市町村リスト(合併市町村リスト);
    }

    @Override
    public IItemList<IGappeiShichosonJoho> find合併市町村(ISearchCondition 検索条件, boolean 表示対象のみ) {

        // TODO
        // 合併市町村かどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 引数の検索条件に該当する合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む合併市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と合併市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return ItemList.empty();
        }
        List<IGappeiShichosonJoho> 合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = gappeiJohoDac.select(検索条件.makeSearchCondition());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For合併市町村(合併情報.get地域番号(), 表示対象のみ);
            IItemList<IGappeiShichoson> 合併市町村リスト = gappeiShichosonDac.select(searchKey);
            合併市町村情報リスト.add(new GappeiShichosonJohoModel(DbOptional.of(合併情報), 合併市町村リスト));
        }
        return ItemList.of(合併市町村情報リスト);
    }

    @Override
    public IItemList<IKoikiGappeiShichosonJoho> get全広域合併市町村(boolean 表示対象のみ) {

        // TODO
        // 合併ありかどうかを判定する。
        // 　　「合併なし」の場合は、空のリストを返却する。
        // 　　「合併あり」の場合は、以降の処理を継続する。
        // 全合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む構成市町村情報を取得する。
        // 　　引数の表示フラグがtrueの場合は、表示対象のデータのみを対象とし、falseの場合は、全てのデータを対象とする。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return ItemList.empty();
        }
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = gappeiJohoDac.selectAll();
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), 表示対象のみ);
            IItemList<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(DbOptional.of(合併情報), 広域構成市町村リスト));
        }
        return ItemList.of(広域合併市町村情報リスト);
    }

    @Override
    public IItemList<IKoikiGappeiShichosonJoho> get地域ごとの最新広域合併市町村() {

        // TODO
        // 地域数分、以下の処理を行う。
        // 　　最新の合併情報を取得する。
        // 　　取得した合併情報の市町村コードに該当する構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = get最新合併情報リスト(gappeiJohoDac.selectAll());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併情報.get市町村コード());
            IOptional<IKoikiKoseiShichoson> 広域構成市町村 = get最新広域構成市町村(koseiShichosonDac.select(searchKey));
            List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
            広域構成市町村リスト.add(広域構成市町村.get());
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(DbOptional.of(合併情報), ItemList.of(広域構成市町村リスト)));
        }
        return ItemList.of(広域合併市町村情報リスト);
    }

    @Override
    public IOptional<IKoikiGappeiShichosonJoho> get地域ごとの広域合併市町村(RString 合併後の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最新の合併情報を取得する。
        // 取得した合併情報が含む構成市町村情報を取得する。
        // 合併情報と構成市町村情報を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor合併情報(合併後の市町村コード);
        IOptional<IGappeiJoho> 合併情報 = get最新合併情報(gappeiJohoDac.select(searchKey));
        if (!合併情報.isPresent()) {
            return DbOptional.empty();
        }
        searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get().get地域番号(), false);
        IItemList<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
        return DbOptional.of((IKoikiGappeiShichosonJoho) new KoikiGappeiShichosonJohoModel(合併情報, 広域構成市町村リスト));
    }

    @Override
    public IItemList<IKoikiGappeiShichosonJoho> get全地域の広域合併市町村() {

        // TODO
        // 地域数分、以下の処理を行う。
        // 　　最新の合併情報を取得する。
        // 　　取得した合併情報が含む構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = get最新合併情報リスト(gappeiJohoDac.selectAll());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), false);
            IItemList<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(DbOptional.of(合併情報), 広域構成市町村リスト));
        }
        return ItemList.of(広域合併市町村情報リスト);
    }

    @Override
    public IItemList<IKoikiGappeiShichosonJoho> find広域合併市町村(ISearchCondition 検索条件) {

        // TODO
        // 引数の検索条件に該当する合併情報を取得する。
        // 取得した合併情報分、以下の処理を行う。
        // 　　合併情報が含む構成市町村情報を取得する。
        // 　　合併情報と構成市町村情報を合わせて返却値のリストに追加する。
        // 作成したリストを返却する。
        //
        if (!is合併あり()) {
            return ItemList.empty();
        }
        List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト = new ArrayList<>();
        IItemList<IGappeiJoho> 合併情報リスト = gappeiJohoDac.select(検索条件.makeSearchCondition());
        for (IGappeiJoho 合併情報 : 合併情報リスト) {
            ITrueFalseCriteria searchKey = makeSearchKeyBy地域番号For構成市町村(合併情報.get地域番号(), false);
            IItemList<IKoikiKoseiShichoson> 広域構成市町村リスト = koseiShichosonDac.select(searchKey);
            広域合併市町村情報リスト.add(new KoikiGappeiShichosonJohoModel(DbOptional.of(合併情報), 広域構成市町村リスト));
        }
        return ItemList.of(広域合併市町村情報リスト);
    }

    @Override
    public IOptional<IKoikiGappeiShichosonJoho> find広域合併市町村By合併後市町村コード(RString 合併後の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最新の構成市町村情報を取得する。
        // 取得した構成市町村情報を含む最新の合併情報を取得する。
        // 取得した合併情報と構成市町村を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併後の市町村コード);
        IOptional<IKoikiKoseiShichoson> 広域構成市町村 = get最新広域構成市町村(koseiShichosonDac.select(searchKey));
        if (!広域構成市町村.isPresent()) {
            return DbOptional.empty();
        }
        searchKey = makeSearchKeyBy地域番号For合併情報(広域構成市町村.get().get合併情報地域番号());
        IOptional<IGappeiJoho> 合併情報 = get最新合併情報(gappeiJohoDac.select(searchKey));
        List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
        広域構成市町村リスト.add(広域構成市町村.get());
        return DbOptional.of((IKoikiGappeiShichosonJoho) new KoikiGappeiShichosonJohoModel(合併情報, ItemList.of(広域構成市町村リスト)));
    }

    @Override
    public IOptional<IKoikiGappeiShichosonJoho> find広域合併市町村By合併元市町村コード(RString 合併元の市町村コード) {

        // TODO
        // 引数の市町村コードに該当する最古の構成市町村情報を取得する。
        // 取得した構成市町村情報を含む最新の合併情報を取得する。
        // 合併情報と構成市町村情報を合わせて返却する。
        //
        ITrueFalseCriteria searchKey = makeSearchKeyBy市町村コードFor構成市町村(合併元の市町村コード);
        IOptional<IKoikiKoseiShichoson> 広域構成市町村 = get最古広域構成市町村(koseiShichosonDac.select(searchKey));
        if (!広域構成市町村.isPresent()) {
            return DbOptional.empty();
        }
        searchKey = makeSearchKeyBy地域番号For合併情報(広域構成市町村.get().get合併情報地域番号());
        IOptional<IGappeiJoho> 合併情報 = get最新合併情報(gappeiJohoDac.select(searchKey));
        List<IKoikiKoseiShichoson> 広域構成市町村リスト = new ArrayList<>();
        広域構成市町村リスト.add(広域構成市町村.get());
        return DbOptional.of((IKoikiGappeiShichosonJoho) new KoikiGappeiShichosonJohoModel(合併情報, ItemList.of(広域構成市町村リスト)));
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For合併情報(RString 地域番号) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                GappeiJohoSearchItem.地域番号, StringOperator.完全一致, 地域番号);
        return 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy市町村コードFor合併情報(RString 市町村コード) {
        INewSearchCondition 市町村コード条件 = SearchConditionFactory.condition(
                GappeiJohoSearchItem.市町村コード, StringOperator.完全一致, 市町村コード);
        return 市町村コード条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For合併市町村(RString 地域番号, boolean 表示対象のみ) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                GappeiShichosonSearchItem.地域番号, StringOperator.完全一致, 地域番号);
        INewSearchCondition 表示有無条件 = SearchConditionFactory.condition(
                GappeiShichosonSearchItem.表示有無, StringOperator.完全一致, 表示対象);
        return 表示対象のみ ? 地域番号条件.and(表示有無条件).makeSearchCondition() : 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy地域番号For構成市町村(RString 地域番号, boolean 表示対象のみ) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.合併情報地域番号, StringOperator.完全一致, 地域番号);
        INewSearchCondition 表示有無条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.合併旧市町村表示有無, StringOperator.完全一致, 表示対象);
        return 表示対象のみ ? 地域番号条件.and(表示有無条件).makeSearchCondition() : 地域番号条件.makeSearchCondition();
    }

    private ITrueFalseCriteria makeSearchKeyBy市町村コードFor構成市町村(RString 市町村コード) {
        INewSearchCondition 地域番号条件 = SearchConditionFactory.condition(
                KoseiShichosonMasterSearchItem.市町村コード, StringOperator.完全一致, 市町村コード);
        return 地域番号条件.makeSearchCondition();
    }

    private IOptional<IGappeiJoho> get最新合併情報(IItemList<IGappeiJoho> list) {
        return DbOptional.ofNullable(!list.isEmpty()
                ? list.sortBy(new MultiComparator<>(GappeiJohoComparators.ChiikiNoComparator.DESC, GappeiJohoComparators.GappeiYMDComparator.DESC))
                .asList().get(0) : null);
    }

    private IOptional<IKoikiKoseiShichoson> get最新広域構成市町村(IItemList<IKoikiKoseiShichoson> list) {
        return DbOptional.ofNullable(!list.isEmpty()
                ? list.sortBy(KoikiKoseiShichosonComparators.ChiikiNoComparator.DESC)
                .asList().get(0) : null);
    }

    private IOptional<IKoikiKoseiShichoson> get最古広域構成市町村(IItemList<IKoikiKoseiShichoson> list) {
        return DbOptional.ofNullable(!list.isEmpty()
                ? list.sortBy(KoikiKoseiShichosonComparators.ChiikiNoComparator.ASC)
                .asList().get(0) : null);
    }

    private IItemList<IGappeiJoho> get最新合併情報リスト(IItemList<IGappeiJoho> list) {
        Map<RString, IGappeiJoho> map = new HashMap<>();
        for (IGappeiJoho newData : list) {
            IGappeiJoho oldData = map.get(newData.get地域番号());
            if (oldData == null || oldData.get合併日().isBefore(newData.get合併日())) {
                map.put(newData.get地域番号(), newData);
            }
        }
        return ItemList.of((List) Arrays.asList(map.values().toArray()));
    }

    private IItemList<IGappeiShichoson> get最新合併市町村リスト(IItemList<IGappeiShichoson> list) {
        Map<RString, IGappeiShichoson> map = new HashMap<>();
        for (IGappeiShichoson newData : list) {
            IGappeiShichoson oldData = map.get(newData.get旧市町村コード());
            if (oldData == null || oldData.get合併日().isBefore(newData.get合併日())) {
                map.put(newData.get旧市町村コード(), newData);
            }
        }
        return ItemList.of((List) Arrays.asList(map.values().toArray()));
    }
}
