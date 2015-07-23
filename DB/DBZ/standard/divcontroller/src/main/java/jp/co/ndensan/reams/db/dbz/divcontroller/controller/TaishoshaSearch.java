/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.TaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.dgGaitoshaList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.util.SearchResult;
import jp.co.ndensan.reams.db.dbz.realservice.search.ShikakuSearchItem;
import jp.co.ndensan.reams.db.dbz.realservice.TaishoshaFinder;
import jp.co.ndensan.reams.ua.uax.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatis.param.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.FlexibleDateOperator;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.DBZ0200001StateName.該当者一覧;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.DBZ0200001TransitionEventName.対象者特定;

/**
 * 対象者検索のコントローラークラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaSearch {

    private static final ISearchCondition 条件無 = null;
    private static final int 最近処理者検索数 = 1;

    /**
     * 「検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnSearch(TaishoshaSearchDiv div) {

        //TODO n3317塚田　遷移させるために空行を作成
//        SearchResult<TaishoshaModel> result = get対象者(div.getSearchCondition().getCcdSearchCondition());
//        div.getGaitoshaList().getDgGaitoshaList().setDataSource(toRowList(result));
        List<dgGaitoshaList_Row> rowList = new ArrayList<>();
        rowList.add(new dgGaitoshaList_Row());
        div.getGaitoshaList().getDgGaitoshaList().setDataSource(rowList);

        if (rowList.size() == 1) {
            return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
        } else {
            return ResponseData.of(div).setState(該当者一覧);
        }
    }

    /**
     * 「再検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnReSearch(TaishoshaSearchDiv div) {

        div.getGaitoshaList().getDgGaitoshaList().setDataSource(Collections.EMPTY_LIST);

        return ResponseData.of(div).respond();
    }

    /**
     * 「該当者一覧」選択時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onSelect_dgGaitoshaList(TaishoshaSearchDiv div) {

        put対象者Key(create対象者Key(div));
        save最近処理者(div);

        return ResponseData.of(div).respond();
    }

    /**
     * 「表示する」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnSaikinShorishaHyoji(TaishoshaSearchDiv div) {

        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getSearchCondition().getCcdSearchCondition().get最近処理者());

        IShikibetsuTaishoGyomuHanteiKey 業務判定キー
                = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoSearchKey 検索キー = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                .set識別コード(識別コード)
                .build();

        TaishoshaFinder finder = new TaishoshaFinder();
        SearchResult<TaishoshaModel> 対象者 = finder.get資格対象者(条件無, 条件無, 検索キー, 最近処理者検索数);

        if (!対象者.records().isEmpty()) {
            put対象者Key(create対象者Key(対象者.records().findFirst().get()));
        }

        return ResponseData.of(div).respond();
    }

    private SearchResult<TaishoshaModel> get対象者(IHihokenshaFinderDiv div) {
        TaishoshaFinder finder = new TaishoshaFinder();
        return finder.get資格対象者(get介護条件(div), get介護除外条件(div), div.get宛名条件(), div.get最大表示件数());
    }

    private ISearchCondition get介護条件(IHihokenshaFinderDiv div) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (div.get被保険者番号() != null) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.被保険者番号, StringOperator.完全一致, div.get被保険者番号()));
        }
        if (div.is住所地特例者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.住所地特例フラグ, StringOperator.完全一致, JushochitokureishaKubun.住所地特例者.code()));
        }

        ISearchCondition 介護条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護条件 = (介護条件 == null) ? 条件 : 条件.and(介護条件);
        }

        return 介護条件;
    }

    private ISearchCondition get介護除外条件(IHihokenshaFinderDiv div) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (div.is被保険者台帳登録者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.被保険者番号, StringOperator.完全一致, RString.EMPTY));
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.資格喪失日, FlexibleDateOperator.等しい, FlexibleDate.EMPTY));
        }

        ISearchCondition 介護条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護条件 = (介護条件 == null) ? 条件 : 条件.or(介護条件);
        }

        return 介護条件;
    }

    private TaishoshaKey create対象者Key(TaishoshaSearchDiv div) {
        dgGaitoshaList_Row row = div.getGaitoshaList().getDgGaitoshaList().getClickedItem();
        return new TaishoshaKey(
                new HihokenshaNo(row.getHihokenshaNo()),
                new ShikibetsuCode(row.getShikibetsuCode()),
                new SetaiCode(row.getSetaiCode()));
    }

    private TaishoshaKey create対象者Key(TaishoshaModel model) {
        return new TaishoshaKey(
                model.get被保険者番号(),
                model.get識別コード(),
                model.get世帯コード());
    }

    private void put対象者Key(TaishoshaKey key) {
        ViewStates.access().valueAssignedTo(ViewStateKey.資格対象者, TaishoshaKey.class).put(key);
    }

    private void save最近処理者(TaishoshaSearchDiv div) {
        dgGaitoshaList_Row row = div.getGaitoshaList().getDgGaitoshaList().getClickedItem();
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(
                new ShikibetsuCode(row.getShikibetsuCode()), new AtenaMeisho(row.getShimei()));
    }

    private List<dgGaitoshaList_Row> toRowList(SearchResult<TaishoshaModel> result) {
        List<dgGaitoshaList_Row> rowList = new ArrayList<>();
        for (TaishoshaModel 対象者 : result.records()) {
            rowList.add(new dgGaitoshaList_Row(
                    対象者.get被保険者番号() != null ? 対象者.get被保険者番号().value() : RString.EMPTY,
                    対象者.get識別コード() != null ? 対象者.get識別コード().value() : RString.EMPTY,
                    対象者.get被保区分().getName(),
                    対象者.get氏名() != null ? 対象者.get氏名().value() : RString.EMPTY,
                    対象者.getカナ氏名() != null ? 対象者.getカナ氏名().value() : RString.EMPTY,
                    (対象者.get氏名() != null && 対象者.getカナ氏名() != null) ? 対象者.get氏名().value().concat(対象者.getカナ氏名().value()) : RString.EMPTY,
                    対象者.get性別() != null ? 対象者.get性別().getName().getShortJapanese() : RString.EMPTY,
                    対象者.get生年月日() != null ? 対象者.get生年月日().wareki().toDateString() : RString.EMPTY,
                    対象者.get郵便番号() != null ? 対象者.get郵便番号().getEditedYubinNo() : RString.EMPTY,
                    対象者.get住所() != null ? 対象者.get住所().value() : RString.EMPTY,
                    対象者.get個人番号() != null ? 対象者.get個人番号().value() : RString.EMPTY,
                    対象者.get住民種別() != null ? 対象者.get住民種別().toRString() : RString.EMPTY,
                    対象者.get世帯コード() != null ? 対象者.get世帯コード().value() : RString.EMPTY));
        }
        return rowList;
    }
}
