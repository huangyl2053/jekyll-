/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2800011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110810.DBC110810_JukyushaTotsugoIraiOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2800011.JukyushaTotsugoIraiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2800011.JukyushaTotsugoIraiJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2800011.JukyushaTotsugoIraiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC2800011_受給者突合依頼情報作成クラスです。
 *
 * @reamsid_L DBC-2750-010 xuyongchao
 */
public class JukyushaTotsugoIraiJohoSakusei {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv>
     */
    public ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv> onLoad(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出区分処理です。
     *
     * @param div 画面情報
     * @return ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv>
     */
    public ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv> onClick_ddlChushutsuKubun(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        getHandler(div).setActive();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<DBC110810_JukyushaTotsugoIraiOutParameter>
     */
    public ResponseData<DBC110810_JukyushaTotsugoIraiOutParameter> onClick_Jikkou(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv>
     */
    public ResponseData<JukyushaTotsugoIraiJohoSakuseiDiv> onClick_Check(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).認定年月チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).対象開始年月チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).対象終了年月チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    private JukyushaTotsugoIraiJohoSakuseiHandler getHandler(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        return new JukyushaTotsugoIraiJohoSakuseiHandler(div);
    }

    private JukyushaTotsugoIraiValidationHandler getValidationHandler(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        return new JukyushaTotsugoIraiValidationHandler(div);
    }
}
