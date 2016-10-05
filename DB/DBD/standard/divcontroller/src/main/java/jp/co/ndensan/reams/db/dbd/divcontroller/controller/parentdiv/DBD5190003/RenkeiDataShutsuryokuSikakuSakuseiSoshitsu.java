/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5190003;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519003.DBD519003_YokaigoNinteiSoshitsuDataSakusei;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格喪失（死亡）データ作成画面のDivControllerです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class RenkeiDataShutsuryokuSikakuSakuseiSoshitsu {

    /**
     * 資格喪失（死亡）データ作成画面の初期化。
     *
     * @param div RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv
     *
     * @return ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv>
     */
    public ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv> onLoad(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * IF種別　ラジオボタン変えるの表示。
     *
     * @param div RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv
     *
     * @return ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv>
     */
    public ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv> onClick_radIfShubetu(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        getHandler(div).onClick_radIfShubetu();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェック　と　操作実施確認ボタン。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv}
     * @return ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv>
     */
    public ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv> onClick_onBeforeBatchRegister(
            RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
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
     * @param div ドメインオブジェクトを取り出したい {@link RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv}
     * @return ResponseData<RenkeiDataShutsuryokuSikakuSakuseiSoshitsuBatchParameter>
     */
    public ResponseData<DBD519003_YokaigoNinteiSoshitsuDataSakusei> onClick_btnBatchRegister(
            RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        DBD519003_YokaigoNinteiSoshitsuDataSakusei parameter = getHandler(div).createParameter();
        return ResponseData.of(parameter).respond();
    }

    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuHandler getHandler(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        return new RenkeiDataShutsuryokuSikakuSakuseiSoshitsuHandler(div);
    }

    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationHandler getValidationHandler(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        return new RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationHandler(div);
    }

}
