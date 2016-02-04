/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1020011;

import jp.co.ndensan.reams.db.dba.business.nenreitotatsushikakuido.NenreitotatsuJoken;
import jp.co.ndensan.reams.db.dba.definition.batchprm.dbamn71001.Dbamn71001BatchFlowParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1020011.NenReiTotatsuSearchConditionDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1020011.NenReiTotatsuSearchConditionHandler;
import jp.co.ndensan.reams.db.dba.service.dbamn71001.NenreitotatsuShikakuIdo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 */
public class NenReiTotatsuSearchCondition {

    /**
     * 画面初期化の処理を行います。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenReiTotatsuSearchConditionDiv> onLoad(NenReiTotatsuSearchConditionDiv div) {

        createHandler(div).load(new NenreitotatsuJoken(new NenreitotatsuShikakuIdo().getNenreitotatsuJoken()));
        return createResponse(div);
    }

    /**
     * 修正するボタンを押下の処理を行います。
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
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<NenReiTotatsuSearchConditionDiv> batchRegisterCheck(NenReiTotatsuSearchConditionDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            new NenreitotatsuShikakuIdo()
                    .checkKaishibiShuryobiJunban(div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue(),
                            div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue());
            new NenreitotatsuShikakuIdo()
                    .checkKaishibiShuryobiJunban(div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().getValue(),
                            div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().getValue());
            new NenreitotatsuShikakuIdo()
                    .checkKaishibiShuryobiKikanJufuku(div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().getValue(),
                            div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().getValue(),
                            div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().getValue(),
                            div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().getValue());

        }
        return createResponse(div);
    }

    /**
     * 実行するボタンを押下の処理を行います。
     *
     * @param div NenReiTotatsuSearchCondition のクラスファイル。
     * @return ResponseData
     */
    public ResponseData<Dbamn71001BatchFlowParameter> batchRegister(NenReiTotatsuSearchConditionDiv div) {
        ResponseData<Dbamn71001BatchFlowParameter> response = new ResponseData<>();
        Dbamn71001BatchFlowParameter param = new NenreitotatsuShikakuIdo()
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
