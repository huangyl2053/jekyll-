/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoCompleteDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入退所処理の完了、更新処理を行うDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuNyutaishoComplete {

    /**
     * 完了メッセージを出力します。
     *
     * @param completeDiv 処理完了Div
     * @param taishoshaJohoDiv 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(ShisetsuNyutaishoCompleteDiv completeDiv, ShisetsuNyutaishoKanriTaishoshaJohoDiv taishoshaJohoDiv) {
        ResponseData<ShisetsuNyutaishoCompleteDiv> response = new ResponseData<>();

        AtenaShokaiSimpleDiv atena = taishoshaJohoDiv.getAtenaJoho();

        KaigoKanryoMessage.setMessage(completeDiv.getComplete(), new RString("施設入退所異動を更新しました。"));//,
//                atena.getTxtShikibetsuCode().getValue(), atena.getTxtAtenaMeisho().getValue());

        response.data = completeDiv;
        return response;
    }
}
