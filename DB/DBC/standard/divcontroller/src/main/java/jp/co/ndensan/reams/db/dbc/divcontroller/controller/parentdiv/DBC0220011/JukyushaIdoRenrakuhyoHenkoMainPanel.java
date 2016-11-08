/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensaku.TaishoshaKensakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.DBC0220011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.DBC0220011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoMainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0220011.JukyushaIdoRenrakuhyoHenkoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.taishoshaichiran.TaishoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.service.core.taishoshakensaku.TaishoshaKensaku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoMainPanel {

    private static final RString 修正モード = new RString("修正");
    private static final RString 選択モード = new RString("選択");
    private static final RString KEY = new RString("isDeletedDataSearch");
    private static final RString 受給者異動_訂正連絡票発行 = new RString("DBCMN83001");
    private static final RString イベント_対象者特定 = new RString("DBZ0200001_対象者特定");
    private static final RString イベント_終了 = new RString("DBZ0200001_終了");

    /**
     * 申請情報検索_画面初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onLoad(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        RString メニューID = ResponseHolder.getMenuID();
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
        TaishoshaIchiranParameter parameter = ViewStateHolder.get(
                ViewStateKeys.退避用データ, TaishoshaIchiranParameter.class);
        if (parameter != null && parameter.get異動日From() != null && !parameter.get異動日From().isEmpty()) {
            div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().
                    setFromValue(new RDate(parameter.get異動日From().toString()));
        }
        if (parameter != null && parameter.get異動日To() != null && !parameter.get異動日To().isEmpty()) {
            div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().
                    setToValue(new RDate(parameter.get異動日To().toString()));
        }
        if (parameter != null && parameter.get被保番号() != null && !parameter.get被保番号().isEmpty()) {
            div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtSearchHihoNo().setValue(parameter.get被保番号().value());
        }
        set検索条件(div);
        if (parameter != null && new RString(Boolean.TRUE.toString()).equals(parameter.get削除データ検索())) {
            List<RString> list = new ArrayList();
            list.add(KEY);
            div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getChkIsSearchDeletedData().setSelectedItemsByKey(list);
        }
        if (修正モード.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))
                || 選択モード.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            FlexibleDate 異動日From = FlexibleDate.EMPTY;
            FlexibleDate 異動日To = FlexibleDate.EMPTY;
            HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
            boolean 削除データ = false;
            if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getFromValue() != null) {
                異動日From = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getTxtIdoDateRange().getFromValue().toString());
            }
            if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue() != null) {
                異動日To = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getTxtIdoDateRange().getToValue().toString());
            }
            if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtSearchHihoNo().getValue() != null
                    && !div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtSearchHihoNo().getValue().isEmpty()) {
                被保険者番号 = new HihokenshaNo(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getTxtSearchHihoNo().getValue());
            }
            if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getChkIsSearchDeletedData().isAllSelected()) {
                削除データ = true;
            }
            List<TaishoshaKensakuResult> 異動対象者一覧情報 = TaishoshaKensaku.createInstance().
                    selectJukyushaIdoTaishosha(異動日From, 異動日To, 被保険者番号, 削除データ);
            getエラー(異動対象者一覧情報);
            getHandler(div).initialize対象者一覧(メニューID, 異動日From, 異動日To, 被保険者番号, 異動対象者一覧情報);
            return ResponseData.of(ResponseData.of(div).setState(
                    DBC0220011StateName.対象者一覧).data).rootTitle(getHandler(div).getTitle(メニューID)).respond();
        }
        return ResponseData.of(ResponseData.of(div).setState(
                DBC0220011StateName.対象者検索).data).rootTitle(getHandler(div).getTitle(メニューID)).respond();
    }

    private void getエラー(List<TaishoshaKensakuResult> 異動対象者一覧情報) {
        if (異動対象者一覧情報 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
    }

    private void set検索条件(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        RString イベント名 = ResponseHolder.getBeforeEvent();
        if (イベント_対象者特定.equals(イベント名) || イベント_終了.equals(イベント名)) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保番号 = 資格対象者.get被保険者番号();
            JukyushaIdoRenrakuhyoHenkoParameter parameter = ViewStateHolder.get(ViewStateKeys.検索退避用,
                    JukyushaIdoRenrakuhyoHenkoParameter.class);
            if (被保番号 != null && !被保番号.isEmpty()) {
                div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getTxtSearchHihoNo().setValue(資格対象者.get被保険者番号().getColumnValue());
            }
            if (parameter != null && parameter.get異動日From() != null && !parameter.get異動日From().isEmpty()) {
                div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().
                        setFromValue(new RDate(parameter.get異動日From().toString()));
            }
            if (parameter != null && parameter.get異動日To() != null && !parameter.get異動日To().isEmpty()) {
                div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().
                        setToValue(new RDate(parameter.get異動日To().toString()));
            }
            if (parameter != null && parameter.is削除データ検索()) {
                List<RString> list = new ArrayList();
                list.add(KEY);
                div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                        getChkIsSearchDeletedData().setSelectedItemsByKey(list);
            }
        }
    }

    /**
     * 「検索する」ボタンです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnSearch(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        FlexibleDate 異動日From = FlexibleDate.EMPTY;
        FlexibleDate 異動日To = FlexibleDate.EMPTY;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        boolean 削除データ = false;
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getFromValue() != null) {
            異動日From = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtIdoDateRange().getFromValue().toString());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue() != null) {
            異動日To = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtIdoDateRange().getToValue().toString());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtSearchHihoNo().getValue() != null
                && !div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                getTxtSearchHihoNo().getValue().isEmpty()) {
            被保険者番号 = new HihokenshaNo(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtSearchHihoNo().getValue());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getChkIsSearchDeletedData().isAllSelected()) {
            削除データ = true;
        }
        List<TaishoshaKensakuResult> 異動対象者一覧情報 = TaishoshaKensaku.createInstance().
                selectJukyushaIdoTaishosha(異動日From, 異動日To, 被保険者番号, 削除データ);
        if (異動対象者一覧情報 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        RString メニューID = ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
        getHandler(div).initialize対象者一覧(メニューID, 異動日From, 異動日To, 被保険者番号, 異動対象者一覧情報);
        return ResponseData.of(div).setState(DBC0220011StateName.対象者一覧);
    }

    /**
     * 「「再検索する」ボタン」押下
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnResearch(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        return ResponseData.of(div).setState(DBC0220011StateName.対象者検索);
    }

    /**
     * 「条件をクリアする」押下
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnClearSearchCondition(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        getHandler(div).clearSearchCondition();
        return ResponseData.of(div).setState(DBC0220011StateName.対象者検索);
    }

    /**
     * 「選択ボタン」押下
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnSelect(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, 選択モード);
        if (ResponseHolder.getMenuID().equals(受給者異動_訂正連絡票発行)) {
            return ResponseData.of(div).forwardWithEventName(DBC0220011TransitionEventName.連絡票変更).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBC0220011TransitionEventName.連絡票情報照会).respond();
    }

    /**
     * 「「該当者を検索する」ボタン」押下
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnSearchHihokensha(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        FlexibleDate 異動日From = FlexibleDate.EMPTY;
        FlexibleDate 異動日To = FlexibleDate.EMPTY;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        boolean 削除データ = false;
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getFromValue() != null) {
            異動日From = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtIdoDateRange().getFromValue().toString());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().getToValue() != null) {
            異動日To = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtIdoDateRange().getToValue().toString());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtSearchHihoNo().getValue() != null
                && !div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                getTxtSearchHihoNo().getValue().isEmpty()) {
            被保険者番号 = new HihokenshaNo(div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                    getTxtSearchHihoNo().getValue());
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getChkIsSearchDeletedData().isAllSelected()) {
            削除データ = true;
        }
        JukyushaIdoRenrakuhyoHenkoParameter parameter = new JukyushaIdoRenrakuhyoHenkoParameter(
                異動日From, 異動日To, 被保険者番号, 削除データ);
        ViewStateHolder.put(ViewStateKeys.検索退避用, parameter);
        return ResponseData.of(div).forwardWithEventName(DBC0220011TransitionEventName.該当者検索).respond();
    }

    /**
     * 「修正ボタン」押下
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoMainPanelDiv> onClick_btnModify(
            JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, 修正モード);
        return ResponseData.of(div).forwardWithEventName(DBC0220011TransitionEventName.連絡票変更).respond();
    }

    private JukyushaIdoRenrakuhyoHenkoMainPanelHandler getHandler(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        return new JukyushaIdoRenrakuhyoHenkoMainPanelHandler(div);
    }

    private JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler
            getCheckHandler(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        return new JukyushaIdoRenrakuhyoHenkoMainPanelValidationHandler(div);
    }
}
