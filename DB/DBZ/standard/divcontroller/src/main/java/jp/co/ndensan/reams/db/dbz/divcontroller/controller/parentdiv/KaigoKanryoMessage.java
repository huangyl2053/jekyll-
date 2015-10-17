/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigokanryomessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護でラップして作成した、完了メッセージ共有子Divの処理クラスです。
 *
 * @author n8178 城間篤人
 */
public final class KaigoKanryoMessage {

    /**
     * インスタンス化防止のプライベートコンストラクタです。
     */
    private KaigoKanryoMessage() {
    }

    /**
     * 親画面から完了メッセージを引き渡す時の処理を行います。
     *
     * @param messageDiv 完了メッセージ共有子Div
     * @param messageMain 完了メッセージメイン
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     */
    public static void setMessage(KaigoKanryoMessageDiv messageDiv, RString messageMain, RString messageTaisho1, RString messageTaisho2) {
        //TODO n3327 プロダクトなのに実装が無いのはおかしい。必要ないならば削除し、使用するならば修正する。
    }

    /**
     * 親画面から完了メッセージを引き渡す時の処理を行います。<br/>
     * 対象情報のメッセージを省略した形で、完了メッセージが出力されます。
     *
     * @param messageDiv 完了メッセージ共有子Div
     * @param messageMain 完了メッセージメイン
     */
    public static void setMessage(KaigoKanryoMessageDiv messageDiv, RString messageMain) {
        //TODO n3327 プロダクトなのに実装が無いのはおかしい。必要ないならば削除し、使用するならば修正する。
    }
}
