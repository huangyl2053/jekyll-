/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.JiGyoSyaHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.JigyoshaNyuryokuGudieCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.validationHandler;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 *
 */
public class JigyoshaNyuryokuGudieCommonChildDiv {

    private JigyoshaMode mode;

    /**
     * 該当事業者一覧。<br/>
     *
     * @param requestDiv 該当事業者一覧Div
     * @return レスポンス
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onLoad(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> responseData = new ResponseData<>();

        JiGyoSyaHandler handler = createHandlerOf(requestDiv);
        mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);
        handler.load(mode);
        responseData.data = requestDiv;

        return responseData;
    }

    /**
     * 対象事業者を検索する。<br/>
     *
     * @param requestDiv 該当事業者一覧Div
     * @return レスポンス
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onclick_BtnTaishoJigyoshaKensaku(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        if (requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue() != null
                && requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue() != null) {

            if (!requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue().
                    isBefore(requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue())) {

                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(validationHandler.終了日が開始日以前のチェック());
                return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
            }
        }

        JiGyoSyaHandler handler = createHandlerOf(requestDiv);

        handler.search_Jigyosya(DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class));
        return createResponseData(requestDiv);
    }

    /**
     * 県コードと郡市コードの連動。<br/>
     *
     * @param requestDiv 該当事業者一覧Div
     * @return レスポンス
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onChange_BtnKenCode(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        JiGyoSyaHandler handler = createHandlerOf(requestDiv);
        mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);
        handler.search_GunshiCode(mode);
        return createResponseData(requestDiv);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param requestDiv 該当事業者一覧Div
     * @return レスポンス
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> select_BtnSenTaKu(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);
        mode.setJigyoshaNo(new KaigoJigyoshaNo(requestDiv.getJigyoshaItirann().getDgJigyoshaItiran().getSelectedItems().get(0).getTxtJigyoshaNo()));
        mode.setJigyoshaName(new AtenaMeisho(requestDiv.getJigyoshaItirann().getDgJigyoshaItiran().getSelectedItems().get(0).getTxtMeisho()));
        requestDiv.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return createResponseData(requestDiv);
    }

    private JiGyoSyaHandler createHandlerOf(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {
        return new JiGyoSyaHandler(requestDiv);
    }

    private ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> createResponseData(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {
        ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }
}
