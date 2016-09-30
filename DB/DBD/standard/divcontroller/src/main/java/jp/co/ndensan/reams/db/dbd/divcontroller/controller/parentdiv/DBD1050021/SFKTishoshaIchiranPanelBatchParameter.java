/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1050021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD206010.DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行画面のControllerクラスです
 *
 * @reamsid_L DBD-3810-010 xuejm
 */
public class SFKTishoshaIchiranPanelBatchParameter {

    /**
     * 画面初期化処理です。
     *
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     * @return ResponseData<SFKTishoshaIchiranPanelBatchParameterDiv>
     */
    public ResponseData<SFKTishoshaIchiranPanelBatchParameterDiv> onLoad(SFKTishoshaIchiranPanelBatchParameterDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のチェック処理します。
     *
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     * @return ResponseData<SFKTishoshaIchiranPanelBatchParameterDiv>
     */
    public ResponseData<SFKTishoshaIchiranPanelBatchParameterDiv> onBeforeCilck_batchcheck(
            SFKTishoshaIchiranPanelBatchParameterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力順未設定チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のバッチパラメータ作成。
     *
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     * @return ResponseData<DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter>
     */
    public ResponseData<DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter> onCilck_btnBatchRegister(
            SFKTishoshaIchiranPanelBatchParameterDiv div) {
        DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter parameter
                = new DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter();
        getHandler(div).onCilck_btnBatchRegister(div, parameter);
        return ResponseData.of(parameter).respond();
    }

    private SFKTishoshaIchiranPanelBatchParameterHandler getHandler(SFKTishoshaIchiranPanelBatchParameterDiv div) {
        return new SFKTishoshaIchiranPanelBatchParameterHandler(div);
    }

    private SFKTishoshaIchiranPanelBatchParameterValidationHandler getValidationHandler() {
        return new SFKTishoshaIchiranPanelBatchParameterValidationHandler();
    }
}
