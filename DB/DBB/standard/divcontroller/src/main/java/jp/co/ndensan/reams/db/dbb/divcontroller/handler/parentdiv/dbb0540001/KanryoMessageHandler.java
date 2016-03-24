/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.KanryoMessageDiv;

/**
 * 徴収方法変更_介護完了メッセージエリアのハンドラクラスです。
 */
public class KanryoMessageHandler {

    private final KanryoMessageDiv div;

    /**
     * KanryoMessageHandler
     *
     * @param div KanryoMessageDiv
     */
    public KanryoMessageHandler(KanryoMessageDiv div) {
        this.div = div;
    }

    /**
     * 初期状態の介護完了メッセージエリアの設定
     */
    public void set初期状態の介護完了メッセージエリア() {
        div.setVisible(false);
    }

    /**
     * 完了状態の介護完了メッセージエリアの設定
     */
    public void set完了状態の介護完了メッセージエリア() {
        div.setVisible(true);
    }

}
