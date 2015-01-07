/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.util.SearchResult;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TaishoshaRelateDac;
import jp.co.ndensan.reams.ur.urz.business.psm.KojinSearchEntityHolder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;

/**
 * 対象者を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class TaishoshaFinder {

    private final TaishoshaRelateDac dac;

    /**
     * コンストラクタです。
     */
    public TaishoshaFinder() {
        this.dac = InstanceProvider.create(TaishoshaRelateDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 被保険者台帳ViewDoc
     */
    TaishoshaFinder(TaishoshaRelateDac dac) {
        this.dac = dac;
    }

    /**
     * 条件に該当する資格対象者を取得します。
     *
     * @param 条件 介護の検索条件
     * @param 除外条件 介護の検索除外条件
     * @param 宛名キー 宛名の検索キー
     * @param 最大件数 最大取得件数
     * @return 資格対象者
     */
    public SearchResult get資格対象者(ISearchCondition 条件, ISearchCondition 除外条件, IShikibetsuTaishoSearchKey 宛名キー, int 最大件数) {

        ITrueFalseCriteria 介護条件 = getCriteria(条件, 除外条件);
        IPsmCriteria 宛名psm = getPsmCriteria(宛名キー);
        boolean is内部結合 = (介護条件 != null);
        IItemList<TaishoshaModel> result = dac.select資格対象者(介護条件, 宛名psm, is内部結合, 最大件数);

        int totalCount = result.size();
        if (result.size() == 最大件数) {
            totalCount = dac.get資格対象者Count(介護条件, 宛名psm, is内部結合);
        }

        return SearchResult.of(result, totalCount, (最大件数 < totalCount));
    }

    /**
     * 条件に該当する賦課対象者を取得します。
     *
     * @param 条件 介護の検索条件
     * @param 除外条件 介護の検索除外条件
     * @param 宛名キー 宛名の検索キー
     * @param 最大件数 最大取得件数
     * @return 賦課対象者
     */
    public SearchResult get賦課対象者(ISearchCondition 条件, ISearchCondition 除外条件, IShikibetsuTaishoSearchKey 宛名キー, int 最大件数) {

        FukaSearchMenu menu = FukaSearchMenu.toValue(UrControlDataFactory.createInstance().getMenuID());
        ITrueFalseCriteria 介護条件 = getCriteria(条件, 除外条件);
        IPsmCriteria 宛名psm = getPsmCriteria(宛名キー);
        boolean is内部結合 = (menu.is(FukaSearchMenuGroup.照会系) || menu.is(FukaSearchMenuGroup.更正計算系));
        IItemList<FukaTaishoshaModel> result = dac.select賦課対象者(介護条件, 宛名psm, is内部結合, 最大件数);

        int totalCount = result.size();
        if (result.size() == 最大件数) {
            totalCount = dac.get資格対象者Count(介護条件, 宛名psm, is内部結合);
        }

        return SearchResult.of(result, totalCount, (最大件数 < totalCount));
    }

    private ITrueFalseCriteria getCriteria(ISearchCondition 条件, ISearchCondition 除外条件) {
        return (条件 != null && 除外条件 != null) ? and(条件.makeSearchCondition(), not(除外条件.makeSearchCondition()))
                : (条件 != null) ? 条件.makeSearchCondition()
                : (除外条件 != null) ? not(除外条件.makeSearchCondition())
                : null;
    }

    private IPsmCriteria getPsmCriteria(IShikibetsuTaishoSearchKey 条件) {
        return new KojinSearchEntityHolder(条件).getCriteria();
    }
}
