/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1020011;

import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsushikakuido.NenreitotatsuJoken;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido.NenreitotatsuShikakuIdoBatchFlowParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1020011.NenReiTotatsuSearchConditionDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1020011.NenReiTotatsuSearchConditionHandler;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsushikakuido.NenreitotatsuShikakuIdo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢到達取得のクラスです。
 *
 * @reamsid_L DBA-0330-050 wangkun
 */
public class NenReiTotatsuSearchCondition {

    /**
     * 年齢到達取得の初期化します。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenReiTotatsuSearchConditionDiv> onLoad(NenReiTotatsuSearchConditionDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("BatchRegister"), true);
        createHandler(div).load(new NenreitotatsuJoken(new NenreitotatsuShikakuIdo().getNenreitotatsuJoken()));
        return createResponse(div);
    }

    /**
     * 修正するボタンを押下の処理します。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenReiTotatsuSearchConditionDiv> onClick_btnUpdate(NenReiTotatsuSearchConditionDiv div) {
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setDisabled(false);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setDisabled(false);
        return createResponse(div);
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenReiTotatsuSearchConditionDiv> onClick_btnCheck(NenReiTotatsuSearchConditionDiv div) {
        ValidationMessageControlPairs validPairs = createHandler(div).必須チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return createResponse(div);
    }

    /**
     * 実行するボタンを押下の処理します。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenreitotatsuShikakuIdoBatchFlowParameter> batchRegister(NenReiTotatsuSearchConditionDiv div) {
        ResponseData<NenreitotatsuShikakuIdoBatchFlowParameter> response = new ResponseData<>();
        NenreitotatsuShikakuIdoBatchFlowParameter param = new NenreitotatsuShikakuIdo()
                .getNenreitotatsuJokenBatchParameter(div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue(),
                        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue());
        response.data = param;
        return response;
    }

    private ResponseData<NenReiTotatsuSearchConditionDiv> createResponse(NenReiTotatsuSearchConditionDiv div) {
        ResponseData<NenReiTotatsuSearchConditionDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private NenReiTotatsuSearchConditionHandler createHandler(NenReiTotatsuSearchConditionDiv div) {
        return new NenReiTotatsuSearchConditionHandler(div);
    }
}
