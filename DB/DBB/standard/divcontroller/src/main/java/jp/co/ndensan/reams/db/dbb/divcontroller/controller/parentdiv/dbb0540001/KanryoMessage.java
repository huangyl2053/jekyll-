/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.KanryoMessageDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0540001.KanryoMessageHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 徴収方法変更_介護完了メッセージエリアのクラスです。
 */
public class KanryoMessage {

    /**
     * 画面初期化
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<KanryoMessageDiv> onLoad(KanryoMessageDiv div) {

        KanryoMessageHandler handler = new KanryoMessageHandler(div);
        handler.set初期状態の介護完了メッセージエリア();

        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<KanryoMessageDiv> onClick_btnUpdate(KanryoMessageDiv div) {

        KanryoMessageHandler handler = new KanryoMessageHandler(div);
        handler.set完了状態の介護完了メッセージエリア();

        return ResponseData.of(div).respond();
    }

}
