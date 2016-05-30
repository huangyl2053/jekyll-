/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.DBC0030011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.DBC0030011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchKogakuHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchYMDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011.KogakuServicehiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011.KogakuServicehiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額介護サービス費照会（対象者検索）画面
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiPanel {

    private static final RString 指定_被保険者 = new RString("hihokenshaShitei");
    private static final RString 指定_年月 = new RString("YMShitei");
    private static final RString 高額介護サービス費照会_メニューID = new RString("DBCMN11004");
    private static final RString 画面フラグ_対象者検索 = new RString("対象者検索");
    private static final RString 画面フラグ_照会 = new RString("高額介護サービス費照会");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onLoad(KogakuServicehiPanelDiv div) {
        getHandler(div).click条件をクリアする();
        RString メニューID = ResponseHolder.getMenuID();
        RString 画面フラグ = ViewStateHolder.get(ViewStateKeys.画面フラグ, RString.class);
        if (高額介護サービス費照会_メニューID.equals(メニューID)) {
            ViewStateHolder.put(ViewStateKeys.画面フラグ, 画面フラグ_対象者検索);
            return ResponseData.of(div).setState(DBC0030011StateName.検索条件);
        } else if (画面フラグ_照会.equals(画面フラグ)) {
            ViewStateHolder.put(ViewStateKeys.画面フラグ, 画面フラグ_対象者検索);
            KogakuServicehiPanelValidationHandler validationHandler = new KogakuServicehiPanelValidationHandler(div);
            ValidationMessageControlPairs pairs;
            if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
                pairs = validationHandler.validate被保険者を指定入力();
                pairs.add(validationHandler.validate提供年月());
                pairs.add(validationHandler.validate申請年月());
                pairs.add(validationHandler.validate決定年月());
            } else {
                pairs = validationHandler.validate年月を指定入力();
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            KogakuShokaiTaishoshaKensakuSearch searchCondition = set検索条件(div);
            getHandler(div).set該当者一覧エリア(searchCondition);
            return ResponseData.of(div).setState(DBC0030011StateName.該当者一覧);
        } else {
            // TODO このdialogは問題があります。
            ViewStateHolder.put(ViewStateKeys.画面フラグ, 画面フラグ_対象者検索);
        }
        return createResponse(div);
    }

    /**
     * 「該当者検索」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 該当者検索画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onClick_btnSearchHihokensha(KogakuServicehiPanelDiv div) {
        put指定_被保険者ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0030011TransitionEventName.該当者検索へ).respond();
    }

    /**
     * 検索条件エリアの検索条件のonChange事件です。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 該当者検索画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onChange_radSearchKubun(KogakuServicehiPanelDiv div) {
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtKetteiYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtShinseiYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtTeikyoYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(true);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(false);
        } else {
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoNo().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoName().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(false);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(true);
        }
        return createResponse(div);
    }

    /**
     * 「条件をクリアする」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onClick_btnClear(KogakuServicehiPanelDiv div) {
        getHandler(div).click条件をクリアする();
        return createResponse(div);
    }

    /**
     * 「該当者を検索する」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onClick_btnSearch(KogakuServicehiPanelDiv div) {
        KogakuServicehiPanelValidationHandler validationHandler = new KogakuServicehiPanelValidationHandler(div);
        ValidationMessageControlPairs pairs;
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            pairs = validationHandler.validate被保険者を指定入力();
            pairs.add(validationHandler.validate提供年月());
            pairs.add(validationHandler.validate申請年月());
            pairs.add(validationHandler.validate決定年月());
        } else {
            pairs = validationHandler.validate年月を指定入力();
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).load該当者一覧情報();
        return ResponseData.of(div).setState(DBC0030011StateName.該当者一覧);
    }

    /**
     * 「再検索する」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onClick_btnResearch(KogakuServicehiPanelDiv div) {
        return ResponseData.of(div).setState(DBC0030011StateName.検索条件);
    }

    /**
     * データグリッドの「選択」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiPanelDiv
     * @return 高額介護サービス費照会画面
     */
    public ResponseData<KogakuServicehiPanelDiv> onClick_ShowDetail(KogakuServicehiPanelDiv div) {
        dgKogakuServicehiRireki_Row row = div.getKogakuServicehiListPanel().getDgKogakuServicehiRireki().getClickedItem();
        RString 被保険者番号R = row.getTxtHihoNo();
        HihokenshaNo 被保険者番号 = 被保険者番号R == null || 被保険者番号R.isEmpty() ? null : new HihokenshaNo(被保険者番号R);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        RString サービス提供年月R = row.getTxtTeikyoYM();
        FlexibleYearMonth サービス提供年月 = サービス提供年月R == null || サービス提供年月R.isEmpty()
                ? null : new FlexibleYearMonth(サービス提供年月R);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス提供年月);
        RString 履歴番号R = row.getTxtRirekiNo();
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号R);
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            put指定_被保険者ViewState(div);
        } else {
            put指定_年月ViewState(div);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0030011TransitionEventName.連絡票変更).respond();
    }

    private void put指定_被保険者ViewState(KogakuServicehiPanelDiv div) {
        SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
        ViewStateHolder.put(ViewStateKeys.ラジオ_指定, 指定_被保険者);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, panel.getTxtHihoNo().getValue());
        ViewStateHolder.put(ViewStateKeys.提供年月From, panel.getTxtTeikyoYMRange().getFromValue());
        ViewStateHolder.put(ViewStateKeys.提供年月To, panel.getTxtTeikyoYMRange().getToValue());
        ViewStateHolder.put(ViewStateKeys.申請年月From, panel.getTxtShinseiYMRange().getFromValue());
        ViewStateHolder.put(ViewStateKeys.申請年月To, panel.getTxtShinseiYMRange().getToValue());
        ViewStateHolder.put(ViewStateKeys.決定年月From, panel.getTxtKetteiYMRange().getFromValue());
        ViewStateHolder.put(ViewStateKeys.決定年月To, panel.getTxtKetteiYMRange().getToValue());
    }

    private void put指定_年月ViewState(KogakuServicehiPanelDiv div) {
        SearchYMDiv panel = div.getSearchKogakuServicehiPanel().getSearchYM();
        ViewStateHolder.put(ViewStateKeys.ラジオ_指定, 指定_年月);
        ViewStateHolder.put(ViewStateKeys.提供年月, panel.getTxtTeikyoYM().getValue());
        ViewStateHolder.put(ViewStateKeys.申請年月, panel.getTxtTeikyoYM().getValue());
        ViewStateHolder.put(ViewStateKeys.決定年月, panel.getTxtTeikyoYM().getValue());
    }

    private KogakuShokaiTaishoshaKensakuSearch set検索条件(KogakuServicehiPanelDiv div) {
        KogakuShokaiTaishoshaKensakuSearch searchCondition;
        RString ラジオ_指定 = ViewStateHolder.get(ViewStateKeys.ラジオ_指定, RString.class);
        if (指定_被保険者.equals(ラジオ_指定)) {
            div.getSearchKogakuServicehiPanel().getRadSearchKubun().setSelectedKey(指定_被保険者);
            SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
            RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
            RDate 提供年月From = ViewStateHolder.get(ViewStateKeys.提供年月From, RDate.class);
            RDate 提供年月To = ViewStateHolder.get(ViewStateKeys.提供年月To, RDate.class);
            RDate 申請年月From = ViewStateHolder.get(ViewStateKeys.申請年月From, RDate.class);
            RDate 申請年月To = ViewStateHolder.get(ViewStateKeys.申請年月To, RDate.class);
            RDate 決定年月From = ViewStateHolder.get(ViewStateKeys.決定年月From, RDate.class);
            RDate 決定年月To = ViewStateHolder.get(ViewStateKeys.決定年月To, RDate.class);
            panel.getTxtHihoNo().setValue(被保険者番号);
            panel.getTxtTeikyoYMRange().setFromValue(提供年月From);
            panel.getTxtTeikyoYMRange().setToValue(提供年月To);
            panel.getTxtShinseiYMRange().setFromValue(申請年月From);
            panel.getTxtShinseiYMRange().setToValue(申請年月To);
            panel.getTxtKetteiYMRange().setFromValue(決定年月From);
            panel.getTxtKetteiYMRange().setToValue(決定年月To);
            searchCondition = getHandler(div).getパラメータ(Boolean.TRUE, 被保険者番号, 提供年月From, 提供年月To, 申請年月From, 申請年月To,
                    決定年月From, 決定年月To, null, null, null);
        } else {
            div.getSearchKogakuServicehiPanel().getRadSearchKubun().setSelectedKey(指定_年月);
            RDate 提供年月 = ViewStateHolder.get(ViewStateKeys.提供年月, RDate.class);
            RDate 申請年月 = ViewStateHolder.get(ViewStateKeys.申請年月, RDate.class);
            RDate 決定年月 = ViewStateHolder.get(ViewStateKeys.決定年月, RDate.class);
            searchCondition = getHandler(div).getパラメータ(Boolean.FALSE, null, null, null, null, null, null, null, 提供年月, 申請年月, 決定年月);
        }
        return searchCondition;
    }

    private KogakuServicehiPanelHandler getHandler(KogakuServicehiPanelDiv div) {
        return new KogakuServicehiPanelHandler(div);
    }

    private ResponseData<KogakuServicehiPanelDiv> createResponse(KogakuServicehiPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
