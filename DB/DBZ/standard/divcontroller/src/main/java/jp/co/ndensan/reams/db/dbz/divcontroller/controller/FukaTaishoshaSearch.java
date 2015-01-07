/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0300001.dgFukaGaitoshaList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0300001.FukaTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.util.SearchResult;
import jp.co.ndensan.reams.db.dbz.realservice.search.FukaSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.TaishoshaFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.FlexibleYearOperator;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者検索のコントローラークラスです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaSearch {

    /**
     * 「検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnSearch(FukaTaishoshaSearchDiv div) {

        set賦課年度(div);
        SearchResult result = get対象者(div.getSearchCondition().getCcdSearchCondition());
        div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(toRowList(result));

        return ResponseDatas.createSettingDataTo(div);
    }

    /**
     * 「再検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnReSearch(FukaTaishoshaSearchDiv div) {

        div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(Collections.EMPTY_LIST);

        return ResponseDatas.createSettingDataTo(div);
    }

    /**
     * 「該当者一覧」選択時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onSelect_dgGaitoshaList(FukaTaishoshaSearchDiv div) {

        ViewStates.access().valueAssignedTo(ViewStateKey.賦課対象者, FukaTaishoshaKey.class).put(create対象者Key(div));
        save最近処理者(div);

        return ResponseDatas.createSettingDataTo(div);
    }

    private void set賦課年度(FukaTaishoshaSearchDiv div) {
        boolean is全年度 = div.getCcdSearchCondition().get賦課年度().isMaxOrMin();
        div.getGaitoshaList().getTxtFukanendo().setVisible(!is全年度);
        div.getGaitoshaList().getTxtFukanendo().setDisplayNone(is全年度);
        div.getGaitoshaList().getTxtFukanendo().setValue(new RDate(div.getCcdSearchCondition().get賦課年度().toString()));
    }

    private SearchResult get対象者(IHihokenshaFinderDiv div) {
        TaishoshaFinder finder = new TaishoshaFinder();
        FukaSearchMenu menu = FukaSearchMenu.toValue(UrControlDataFactory.createInstance().getMenuID());
        return finder.get賦課対象者(get介護条件(div, menu), get介護除外条件(div, menu), div.get宛名条件(), div.get最大表示件数());
    }

    private ISearchCondition get介護条件(IHihokenshaFinderDiv div, FukaSearchMenu menu) {

        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (div.get被保険者番号() != null) {
            INewSearchCondition 被保険者番号条件 = SearchConditionFactory.condition(
                    FukaSearchItem.賦課マスタ_被保険者番号, StringOperator.完全一致, div.get被保険者番号());
            if (menu.is(FukaSearchMenuGroup.更正計算系)) {
                被保険者番号条件 = SearchConditionFactory.where(被保険者番号条件.or(SearchConditionFactory.condition(
                        FukaSearchItem.被保険者台帳_被保険者番号, StringOperator.完全一致, div.get被保険者番号())));
            }
            条件List.add(被保険者番号条件);
        }
        if (div.get通知書番号() != null) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.通知書番号, StringOperator.完全一致, div.get通知書番号()));
        }
        if (!div.get賦課年度().isMaxOrMin()) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.賦課年度, FlexibleYearOperator.等しい, div.get賦課年度()));
        }

        ISearchCondition 介護条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護条件 = (介護条件 == null) ? 条件 : 条件.and(介護条件);
        }

        return 介護条件;
    }

    private ISearchCondition get介護除外条件(IHihokenshaFinderDiv div, FukaSearchMenu menu) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (menu.is(FukaSearchMenuGroup.照会系)) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.通知書番号, StringOperator.完全一致, RString.EMPTY));
        }

        ISearchCondition 介護条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護条件 = (介護条件 == null) ? 条件 : 条件.or(介護条件);
        }

        return 介護条件;
    }

    private FukaTaishoshaKey create対象者Key(FukaTaishoshaSearchDiv div) {
        dgFukaGaitoshaList_Row row = div.getGaitoshaList().getDgFukaGaitoshaList().getClickedItem();
        return new FukaTaishoshaKey(
                new HihokenshaNo(row.getTxtHihoNo()),
                new ShikibetsuCode(row.getTxtShikbetsuCode()),
                new SetaiCode(row.getTxtSetaiCode()),
                new FlexibleYear(row.getTxtFukaNendo()),
                new TsuchishoNo(row.getTxtTsuchiNo()));
    }

    private void save最近処理者(FukaTaishoshaSearchDiv div) {
        dgFukaGaitoshaList_Row row = div.getGaitoshaList().getDgFukaGaitoshaList().getClickedItem();
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(row.getTxtShikbetsuCode(), row.getTxtName());
    }

    private List<dgFukaGaitoshaList_Row> toRowList(SearchResult result) {
        List<dgFukaGaitoshaList_Row> rowList = new ArrayList<>();
        for (FukaTaishoshaModel 対象者 : (IItemList<FukaTaishoshaModel>) result.records()) {
            rowList.add(new dgFukaGaitoshaList_Row(
                    対象者.get調定年度() != null ? 対象者.get調定年度().wareki().toDateString() : RString.EMPTY,
                    対象者.get賦課年度() != null ? 対象者.get賦課年度().wareki().toDateString() : RString.EMPTY,
                    対象者.get通知書番号() != null ? 対象者.get通知書番号().value() : RString.EMPTY,
                    対象者.get被保険者番号() != null ? 対象者.get被保険者番号().value() : RString.EMPTY,
                    対象者.get氏名() != null ? 対象者.get氏名().value() : RString.EMPTY,
                    対象者.get生年月日() != null ? 対象者.get生年月日().wareki().toDateString() : RString.EMPTY,
                    対象者.get性別() != null ? 対象者.get性別().getName().getShortJapanese() : RString.EMPTY,
                    対象者.get住民種別() != null ? 対象者.get住民種別().toRString() : RString.EMPTY,
                    対象者.get住所() != null ? 対象者.get住所().value() : RString.EMPTY,
                    対象者.get識別コード() != null ? 対象者.get識別コード().value() : RString.EMPTY,
                    対象者.get世帯コード() != null ? 対象者.get世帯コード().value() : RString.EMPTY));
        }
        return rowList;
    }
}
