/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020002;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenkolist.ShiharaiHohoHenkoListFlowParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002.ShiharaiHohoKanriListMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020002.ShiharaiHohoKanriListMainHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 支払方法変更管理リストのイベントを定義したDivControllerです。
 *
 * @reamsid_L DBD-3630-010 zhulx
 *
 */
public class ShiharaiHohoKanriListMain {

    /**
     * 支払方法変更管理リストDivの初期化を表します。
     *
     * @param div ShiharaiHohoKanriListMainDiv
     * @return ResponseData
     */
    public ResponseData<ShiharaiHohoKanriListMainDiv> onLoad(ShiharaiHohoKanriListMainDiv div) {

        createHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    private ShiharaiHohoKanriListMainHandler createHandler(ShiharaiHohoKanriListMainDiv div) {
        return new ShiharaiHohoKanriListMainHandler(div);
    }

    /**
     * 登録者の「選択」処理です。
     *
     * @param div ShiharaiHohoKanriListMainDiv のクラスファイル
     * @return ResponseData<ShiharaiHohoKanriListMainDiv>
     */
    public ResponseData<ShiharaiHohoKanriListMainDiv> onChange_radTorokusha(ShiharaiHohoKanriListMainDiv div) {
        createHandler(div).onChange_radTorokusha();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン押下の処理です。
     *
     * @param div ShiharaiHohoKanriListMainDiv のクラスファイル
     * @return ResponseData<ShiharaiHohoKanriListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoListFlowParameter> onClick_batchParameter(ShiharaiHohoKanriListMainDiv div) {
        ResponseData<ShiharaiHohoHenkoListFlowParameter> responseData = new ResponseData<>();
        responseData.data = createBusiness(div).createShiharaiHohoHenkoKanriIchiranParameter();
        return responseData;
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ShiharaiHohoKanriListMainDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<ShiharaiHohoKanriListMainDiv> onClick_btnCheck(ShiharaiHohoKanriListMainDiv div) {
        ValidationMessageControlPairs validPairs = createHandler(div).必須チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return createResponse(div);
    }

    private ResponseData<ShiharaiHohoKanriListMainDiv> createResponse(ShiharaiHohoKanriListMainDiv div) {
        ResponseData<ShiharaiHohoKanriListMainDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private ShiharaiHohoHenkoKanriIchiran createBusiness(ShiharaiHohoKanriListMainDiv div) {
        return new ShiharaiHohoHenkoKanriIchiran(div);
    }
}
