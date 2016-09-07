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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNN1004_事業分支給額計算
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class JigyobunShikyugakuCalcPanel {

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
     * 「被保険者番号入力補助」ボタンです。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuCalcPanelDiv> onClick_btnHihokenshaSearch(
            JigyobunShikyugakuCalcPanelDiv div) {
        //TODO QA1458
        if (div.getChushutsuJoken().getHihokenshaNo() != null && !div.getChushutsuJoken().getHihokenshaNo().isEmpty()) {
            div.getChushutsuJoken().getTxtHihokenshaNo().setValue(div.getChushutsuJoken().getHihokenshaNo());
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
