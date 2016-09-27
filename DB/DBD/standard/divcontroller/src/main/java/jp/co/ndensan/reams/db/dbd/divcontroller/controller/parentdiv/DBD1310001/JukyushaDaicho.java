/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710010.DBD710010_HanyoListJukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001.JukyushaDaichoPanelHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001.JukyushaDaichoPanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class JukyushaDaicho {

    /**
     * 汎用リスト出力(受給者台帳)画面の初期化。
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     *
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onLoad(JukyushaDaichoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件の保存 入力チェック
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onClick_onBeforeBatchParamSave(JukyushaDaichoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs errorMessagePairs = getValidationHandler(div).validate();
            if (errorMessagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(errorMessagePairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 条件の保存
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_saveBatchParameterSave(JukyushaDaichoDiv div) {
        BatchParameterMap batchParameterMap = new BatchParameterMap(getHandler(div).getBatchParameter());
        return ResponseData.of(batchParameterMap).respond();
    }

    /**
     * 条件の復元
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onClick_restoreBatchParameter(JukyushaDaichoDiv div) {
        getHandler(div).restoreBatchParameter();
        return ResponseData.of(div).respond();
    }

    /**
     * 基準日RbGr onSelect画面制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onSelect_radChushutsuTaisho(JukyushaDaichoDiv div) {
        getHandler(div).onSelect_radChushutsuTaisho();
        return ResponseData.of(div).respond();
    }

    /**
     * 有効データ内最新Cb onChange画面制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onChange_chkSaisin(JukyushaDaichoDiv div) {
        getHandler(div).onChange_chkSaisin();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン 入力チェック　と　操作実施確認ボタン
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoDiv}
     * @return ResponseData<JukyushaDaichoDiv>
     */
    public ResponseData<JukyushaDaichoDiv> onClick_onBeforeBatchParameterRegister(JukyushaDaichoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs messagePairs = getValidationHandler(div).validate();
            if (messagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(messagePairs).respond();
            }

            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設入退所「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710150_HanyoListShisetsuNyutaishoParameter>
     */
    public ResponseData<DBD710010_HanyoListJukyushaDaichoParameter> onClick_btnBatchParameterRegister(JukyushaDaichoDiv div) {
        return ResponseData.of(getHandler(div).getBatchParameter()).respond();
    }

    private JukyushaDaichoPanelHandler getHandler(JukyushaDaichoDiv div) {
        return new JukyushaDaichoPanelHandler(div);
    }

    private JukyushaDaichoPanelValidationHandler getValidationHandler(JukyushaDaichoDiv div) {
        return new JukyushaDaichoPanelValidationHandler(div);
    }
}
