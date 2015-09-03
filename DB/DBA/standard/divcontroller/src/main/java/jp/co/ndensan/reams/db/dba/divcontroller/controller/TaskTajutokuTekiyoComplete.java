/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.TaskTajutokuTaishosaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.TaskTajutokuTekiyoCompleteDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class TaskTajutokuTekiyoComplete {

    /**
     * 完了メッセージを出力します。
     *
     * @param completeDiv 処理完了Div
     * @param taishoshaJohoDiv 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(TaskTajutokuTekiyoCompleteDiv completeDiv, TaskTajutokuTaishosaJohoDiv taishoshaJohoDiv) {
        ResponseData<TaskTajutokuTekiyoCompleteDiv> response = new ResponseData<>();

        //TODO getAtenaJohoが存在しない
//        AtenaShokaiSimpleDiv atena = taishoshaJohoDiv.getAtenaJoho();
        KaigoKanryoMessage.setMessage(completeDiv.getComplete(), new RString("他市町村住所地特例適用を更新しました。"));//,
//                atena.getTxtShikibetsuCode().getValue(), atena.getTxtAtenaMeisho().getValue());

        response.data = completeDiv;
        return response;
    }

}
