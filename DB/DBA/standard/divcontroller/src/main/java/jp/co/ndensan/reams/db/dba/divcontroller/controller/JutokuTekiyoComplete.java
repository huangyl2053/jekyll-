/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2030011.JutokuTekiyoCompleteDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2030011.JutokuTekiyoTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例処理の完了を行うDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class JutokuTekiyoComplete {

    /**
     * 完了メッセージを出力します。
     *
     * @param completeDiv 処理完了Div
     * @param taishoshaJohoDiv 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(JutokuTekiyoCompleteDiv completeDiv, JutokuTekiyoTaishoshaJohoDiv taishoshaJohoDiv) {
        ResponseData<JutokuTekiyoCompleteDiv> response = new ResponseData<>();

        AtenaShokaiSimpleDiv atena = taishoshaJohoDiv.getJutokuTekiyoCommonJoho().getAtenaInfo();

        KaigoKanryoMessage.setMessage(completeDiv.getComplete(), new RString("住所地特例適用処理を完了しました。"),
                atena.getTxtShikibetsuCode().getValue(), atena.getTxtAtenaMeisho().getValue());

        response.data = completeDiv;
        return response;
    }
}
