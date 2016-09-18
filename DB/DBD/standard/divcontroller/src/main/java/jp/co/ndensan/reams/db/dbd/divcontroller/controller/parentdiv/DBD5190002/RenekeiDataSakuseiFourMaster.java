/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5190002;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519002.DBD519002Parameter;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定関連データ作成画面のDivControllerです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class RenekeiDataSakuseiFourMaster {

    /**
     * 要介護認定関連データ作成画面の初期化。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     *
     * @return ResponseData<RenekeiDataSakuseiFourMasterDiv>
     */
    public ResponseData<RenekeiDataSakuseiFourMasterDiv> onLoad(RenekeiDataSakuseiFourMasterDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件ラジオボタンのonClick事件。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     * @return ResponseData<RenekeiDataSakuseiFourMasterDiv>
     */
    public ResponseData<RenekeiDataSakuseiFourMasterDiv> onClick_radChushutsuJoken(RenekeiDataSakuseiFourMasterDiv div) {
        getHandler(div).radChushutsuJoken_onClick();
        return ResponseData.of(div).respond();
    }

    /**
     * IF種別　ラジオボタンのonClick事件。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     * @return ResponseData<RenekeiDataSakuseiFourMasterDiv>
     */
    public ResponseData<RenekeiDataSakuseiFourMasterDiv> onClick_radIfShubetu(RenekeiDataSakuseiFourMasterDiv div) {
        getHandler(div).radIfShubetu_onClick();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェック　と　操作実施確認ボタン。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     * @return ResponseData<RenekeiDataSakuseiFourMasterDiv>
     */
    public ResponseData<RenekeiDataSakuseiFourMasterDiv> onClick_onBeforeBatchRegister(RenekeiDataSakuseiFourMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs errorMessagePairs = getValidationHandler(div).validate();
            if (errorMessagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(errorMessagePairs).respond();
            }
            return ResponseData.of(div).addMessage(DbdQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ処理実行。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     * @return ResponseData<RenekeiDataSakuseiFourMasterBatchParameter>
     */
    public ResponseData<DBD519002Parameter> onClick_btnBatchRegister(RenekeiDataSakuseiFourMasterDiv div) {
        DBD519002Parameter parameter = getHandler(div).createParameter();
        return ResponseData.of(parameter).respond();
    }

    private RenekeiDataSakuseiFourMasterHandler getHandler(RenekeiDataSakuseiFourMasterDiv div) {
        return new RenekeiDataSakuseiFourMasterHandler(div);
    }

    private RenekeiDataSakuseiFourMasterValidationHandler getValidationHandler(RenekeiDataSakuseiFourMasterDiv div) {
        return new RenekeiDataSakuseiFourMasterValidationHandler(div);
    }
}
