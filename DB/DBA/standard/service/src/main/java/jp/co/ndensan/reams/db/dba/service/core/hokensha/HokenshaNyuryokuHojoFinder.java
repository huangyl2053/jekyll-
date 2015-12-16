/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hokensha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoSearchShurui;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJusho;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaSearchItem;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import static jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory.where;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 保険者入力補助サービスクラスです。
 */
public class HokenshaNyuryokuHojoFinder {

    private final IHokenjaFinder hokenshafinder;
    private final IZenkokuJushoFinder kokuFinder;

    /**
     * コンストラクタです。
     */
    HokenshaNyuryokuHojoFinder() {
        this.hokenshafinder = HokenjaFinderFactory.createInstance();
        this.kokuFinder = ZenkokuJushoFinderFactory.createInstance();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param UrT0101ZenkokuJushoDac urT0101Dac
     * @param UrT0507HokenjaDac urT0507Dac
     * @paramMapperProvider mapperProvider
     */
    HokenshaNyuryokuHojoFinder(IHokenjaFinder hokenshafinder, IZenkokuJushoFinder kokuFinder) {
        this.hokenshafinder = hokenshafinder;
        this.kokuFinder = kokuFinder;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンス
     */
    public static HokenshaNyuryokuHojoFinder createInstance() {
        return InstanceProvider.create(HokenshaNyuryokuHojoFinder.class);
    }

    /**
     * 保険者情報を特定して取得します。
     *
     * @param parameter 保険者情報のパラメータ
     * @return　Hokensha　保険者情報
     */
    @Transaction
    public Hokensha getHokensha(HokenshaMapperParameter parameter) {
        Hokenja entity = hokenshafinder.get保険者(parameter.getHokenjaNo(), new HokenjaShubetsu(new RString("08")));
        if (entity == null) {
            return null;
        }
        return new Hokensha(entity.toEntity());
    }

    /**
     * 県コード取得リストを取得します。
     *
     * @return SearchResult<KenCodeJigyoshaInputGuide>　県コードオブジェクトの検索結果
     */
    @Transaction
    public SearchResult<KenCodeJigyoshaInputGuide> getKenCodeJigyoshaInputGuide() {
        List<KenCodeJigyoshaInputGuide> kenCodeList = new ArrayList<>();
        ITrueFalseCriteria result = and(not(eq(UrT0101ZenkokuJusho.isDeleted, true)), eq(UrT0101ZenkokuJusho.dataKubun, ZenkokuJushoSearchShurui.都道府県.getDataKubun()));
        List<ZenkokuJushoItem> zenkokuJushoItemList = kokuFinder.get全国住所(result);
        if (zenkokuJushoItemList == null || zenkokuJushoItemList.isEmpty()) {
            return SearchResult.of(Collections.< KenCodeJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (ZenkokuJushoItem Item : zenkokuJushoItemList) {
            kenCodeList.add(new KenCodeJigyoshaInputGuide(Item.toEntity()));
        }
        return SearchResult.of(kenCodeList, 0, false);
    }

    /**
     * 保険者情報リストを取得します。
     *
     * @param parameter 保険者情報のパラメータ
     * @return SearchResult<Hokensha> 保険者情報の検索結果
     */
    @Transaction
    public SearchResult<Hokensha> getHokenshaList(HokenshaMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者情報のパラメータ"));
        List<Hokensha> hokenshaList = new ArrayList<>();
        INewSearchCondition 保険者番号 = SearchConditionFactory.condition(HokenjaSearchItem.保険者番号, StringOperator.前方一致, parameter.getKenCode());
        INewSearchCondition 保険者種別 = SearchConditionFactory.condition(HokenjaSearchItem.保険者種別, StringOperator.完全一致, new RString("08"));
        ISearchCondition result = where(保険者番号).and(保険者種別);
        List<Hokenja> hokenjaList = hokenshafinder.get保険者一覧(result);
        if (hokenjaList == null || hokenjaList.isEmpty()) {
            return SearchResult.of(Collections.< Hokensha>emptyList(), 0, false);
        }
        for (Hokenja hokenja : hokenjaList) {
            hokenshaList.add(new Hokensha(hokenja.toEntity()));
        }
        return SearchResult.of(hokenshaList, 0, false);
    }
}
