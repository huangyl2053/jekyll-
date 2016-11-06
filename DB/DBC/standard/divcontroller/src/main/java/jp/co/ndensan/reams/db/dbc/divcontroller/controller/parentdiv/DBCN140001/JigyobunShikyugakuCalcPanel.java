/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBCN140001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020070.DBC020070_JigyobunShikyugakuKeisanParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001.JigyobunShikyugakuCalcPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN140001.JigyobunShikyugakuCalcPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN140001.JigyobunShikyugakuCalcPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNN1004_事業分支給額計算
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class JigyobunShikyugakuCalcPanel {

    private static final RString イベント_対象者特定 = new RString("DBZ0200001_対象者特定");
    private static final RString 被保険者台帳TXT = new RString("被保険者台帳");

    /**
     * 画面初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onLoad(JigyobunShikyugakuCalcPanelDiv div) {
        getHandler(div).initialize画面();
        return ResponseData.of(div).respond();
    }

    /**
     * onActionイベントです。
     *
     * @param div JigyobunShikyugakuCalcPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onActive(JigyobunShikyugakuCalcPanelDiv div) {
        RString イベント名 = ResponseHolder.getBeforeEvent();
        if (イベント_対象者特定.equals(イベント名) && ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class)) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保番号 = 資格対象者.get被保険者番号();
            if (被保番号 != null && !被保番号.isEmpty()) {
                div.getChushutsuJoken().getTxtHihokenshaNo().setValue(資格対象者.get被保険者番号().getColumnValue());
                getHandler(div).get被保険者氏名(資格対象者.get識別コード());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「受取年月指定RAD」イベントです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onChange_radTaishoshaSearch(
            JigyobunShikyugakuCalcPanelDiv div) {
        getHandler(div).set受取年月指定RAD状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保険者指定RAD」イベントです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onChange_radHihokenshaNoShitei(
            JigyobunShikyugakuCalcPanelDiv div) {
        getHandler(div).set被保険者指定RAD状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「開始年月日TXT」イベントです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onBlur_txtKaishiDate(
            JigyobunShikyugakuCalcPanelDiv div) {
        getHandler(div).set開始年月日の曜日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「終了年月日TXT」イベントです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onBlur_txtShuryoDate(
            JigyobunShikyugakuCalcPanelDiv div) {
        getHandler(div).set終了年月日の曜日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保険者番号TXT」ボタンです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onBlur_txtHihokenshaNo(
            JigyobunShikyugakuCalcPanelDiv div) {
        if (div.getChushutsuJoken().getTxtHihokenshaNo().getValue() != null
                && !div.getChushutsuJoken().getTxtHihokenshaNo().getValue().isEmpty()) {
            HihokenshaDaicho 被保険者台帳 = HihokenshaDaichoManager.createInstance().selectByHihokenshaNo(
                    new HihokenshaNo(div.getChushutsuJoken().getTxtHihokenshaNo().getValue()));
            if (被保険者台帳 == null) {
                throw new ApplicationException(
                        UrErrorMessages.存在しない.getMessage().replace(被保険者台帳TXT.toString()));
            } else {
                getHandler(div).get被保険者氏名(被保険者台帳.get識別コード());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドます。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onClick_beforeCheck(JigyobunShikyugakuCalcPanelDiv div) {
        ValidationMessageControlPairs pairs = getCheckHandler(div).get入力値の妥当性チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (getHandler(div).is警告メッセージの表示() && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.受取年月指定かつ再処理時_登録済みデータ削除確認.getMessage().getCode(),
                    DbcWarningMessages.受取年月指定かつ再処理時_登録済みデータ削除確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン
     *
     * @param div KanendoFukaDiv
     * @return ResponseData
     */
    public ResponseData<DBC020070_JigyobunShikyugakuKeisanParameter> onClick_btnExecute(
            JigyobunShikyugakuCalcPanelDiv div) {
        DBC020070_JigyobunShikyugakuKeisanParameter parameter = getHandler(div).setBatchParam();
        return ResponseData.of(parameter).respond();
    }

    private JigyobunShikyugakuCalcPanelHandler getHandler(JigyobunShikyugakuCalcPanelDiv div) {
        return new JigyobunShikyugakuCalcPanelHandler(div);
    }

    private JigyobunShikyugakuCalcPanelValidationHandler getCheckHandler(JigyobunShikyugakuCalcPanelDiv div) {
        return new JigyobunShikyugakuCalcPanelValidationHandler(div);
    }

}
