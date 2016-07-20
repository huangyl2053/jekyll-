/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.FukaTaishoshaRelateBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.TaishoshaRelateBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.FukaTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.relate.TaishoshaRelateDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.SearchResult;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Restrictions;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

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
    @Transaction
    public SearchResult<TaishoshaRelateBusiness> get資格対象者(ISearchCondition 条件, ISearchCondition 除外条件, IShikibetsuTaishoSearchKey 宛名キー, int 最大件数) {

        ITrueFalseCriteria 介護条件 = getCriteria(条件, 除外条件);
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(宛名キー.getPSMSearchKey());

        if (条件 != null && 条件.isEvaluatable()) {
            IItemList<ShikibetsuCode> shikibetsuCodeList = dac.get資格対象識別コードリスト(介護条件);

            builder.set識別コードリスト(shikibetsuCodeList.toList());
        }

        IPsmCriteria 宛名psm = getPsmCriteria(builder.build());
        boolean is内部結合 = (介護条件 != null);
        IItemList<TaishoshaRelateEntity> result = dac.select資格対象者(介護条件, 宛名psm, is内部結合, 最大件数);

        int totalCount = result.size();
        if (result.size() == 最大件数) {
            totalCount = dac.get資格対象者Count(介護条件, 宛名psm, is内部結合);
        }

        List<TaishoshaRelateBusiness> list = new ArrayList<>();

        for (TaishoshaRelateEntity entity : result) {
            list.add(new TaishoshaRelateBusiness(entity));
        }

        IItemList<TaishoshaRelateBusiness> resultB = ItemList.of(list);

        return SearchResult.of(resultB, totalCount, (最大件数 < totalCount));
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
    @Transaction
    public SearchResult<FukaTaishoshaRelateBusiness> get賦課対象者(ISearchCondition 条件, ISearchCondition 除外条件, IShikibetsuTaishoSearchKey 宛名キー, int 最大件数) {

        FukaSearchMenu menu = FukaSearchMenu.toValue(ResponseHolder.getMenuID());
//        FukaSearchMenu menu = FukaSearchMenu.toValue(new RString("DBBMN11001"));
//        FukaSearchMenu menu = FukaSearchMenu.toValue(ctrlData.getMenuID());
        ITrueFalseCriteria 介護条件 = getCriteria(条件, 除外条件);
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(宛名キー.getPSMSearchKey());

        if (条件 != null && 条件.isEvaluatable()) {
            IItemList<ShikibetsuCode> shikibetsuCodeList = dac.get賦課対象識別コードリスト(介護条件);
            builder.set識別コードリスト(shikibetsuCodeList.toList());
        }

        IPsmCriteria 宛名psm = getPsmCriteria(builder.build());
        boolean is内部結合 = (menu.is(FukaSearchMenuGroup.照会系) || menu.is(FukaSearchMenuGroup.更正計算系));
        IItemList<FukaTaishoshaRelateEntity> result = dac.select賦課対象者(介護条件, 宛名psm, is内部結合, 最大件数);

        int totalCount = result.size();
        if (result.size() == 最大件数) {
            totalCount = dac.get賦課対象者Count(介護条件, 宛名psm, is内部結合);
        }

        List<FukaTaishoshaRelateBusiness> list = new ArrayList<>();

        for (FukaTaishoshaRelateEntity entity : result) {

            list.add(new FukaTaishoshaRelateBusiness(entity));
        }

        IItemList<FukaTaishoshaRelateBusiness> resultB = ItemList.of(list);

        return SearchResult.of(resultB, totalCount, (最大件数 < totalCount));
    }

    private ITrueFalseCriteria getCriteria(ISearchCondition 条件, ISearchCondition 除外条件) {
        return (条件 != null && 除外条件 != null) ? and(条件.makeSearchCondition(), not(除外条件.makeSearchCondition()))
                : (条件 != null) ? 条件.makeSearchCondition()
                : (除外条件 != null) ? not(除外条件.makeSearchCondition())
                : null;
    }

    private IPsmCriteria getPsmCriteria(IShikibetsuTaishoSearchKey 条件) {
        return Restrictions.PSM(new UaFt200FindShikibetsuTaishoFunction(条件.getPSMSearchKey()));
    }
}
