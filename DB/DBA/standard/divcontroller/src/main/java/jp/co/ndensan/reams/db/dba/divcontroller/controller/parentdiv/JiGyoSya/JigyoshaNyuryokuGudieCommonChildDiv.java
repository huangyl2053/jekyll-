/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.JiGyoSya;

import jp.co.ndensan.reams.db.dba.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.JiGyoSyaHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.JigyoshaNyuryokuGudieCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv.ValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 事業者・施設選択入力ガイドのクラス。
 */
public class JigyoshaNyuryokuGudieCommonChildDiv {

    private JigyoshaMode mode;

    /**
     * 事業者・施設選択入力ガイドの初期化。<br/>
     *
     * @param requestDiv JigyoshaNyuryokuGudieCommonChildDivDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onLoad(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> responseData = new ResponseData<>();

        mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);
        createHandlerOf(requestDiv).load(mode);
        responseData.data = requestDiv;

        return responseData;
    }

    /**
     * 対象事業者を検索する。<br/>
     *
     * @param requestDiv JigyoshaNyuryokuGudieCommonChildDivDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onclick_BtnTaishoJigyoshaKensaku(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        if (requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue() != null
                && requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue() != null) {

            if (!requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue().
                    isBefore(requestDiv.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue())) {

                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(ValidationHandler.終了日が開始日以前のチェック());
                return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
            }
        }
        createHandlerOf(requestDiv).search_Jigyosya(DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class));
        return createResponseData(requestDiv);
    }

    /**
     * 県コードと郡市コードの連動。<br/>
     *
     * @param requestDiv JigyoshaNyuryokuGudieCommonChildDivDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv> onChange_BtnKenCode(JigyoshaNyuryokuGudieCommonChildDivDiv requestDiv) {

        mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);
        createHandlerOf(requestDiv).search_GunshiCode(mode);
        return createResponseData(requestDiv);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param requestDiv JigyoshaNyuryokuGudieCommonChildDivDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
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
