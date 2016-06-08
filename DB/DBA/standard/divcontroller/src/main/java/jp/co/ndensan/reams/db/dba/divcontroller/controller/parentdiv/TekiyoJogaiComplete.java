/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.TekiyoJogaiCompleteDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.TekiyoJogaiTaishoshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiComplete {

    /**
     * 完了メッセージを出力します。
     *
     * @param completeDiv 処理完了Div
     * @param taishoshaJohoDiv 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(TekiyoJogaiCompleteDiv completeDiv, TekiyoJogaiTaishoshaJohoDiv taishoshaJohoDiv) {
        ResponseData<TekiyoJogaiCompleteDiv> response = new ResponseData<>();

//        AtenaShokaiSimpleDiv atena = taishoshaJohoDiv.getAtenaJoho();
        completeDiv.getComplete().setSuccessMessage(new RString("適用除外登録を更新しました。")); //,
//                atena.getTxtShikibetsuCode().getValue(), atena.getTxtAtenaMeisho().getValue());

        response.data = completeDiv;
        return response;
    }

}
