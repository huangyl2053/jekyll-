/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoKanryoMessage;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;

/**
 * 介護完了メッセージのHandlerクラスです。
 *
 */
public class KaigoKanryoMessageHandler {

    private final KaigoKanryoMessageDiv div;

    /**
     * コンストラクタです
     *
     * @param kaigoKanryoMessageDiv 介護完了メッセージDiv
     */
    public KaigoKanryoMessageHandler(KaigoKanryoMessageDiv kaigoKanryoMessageDiv) {
        div = kaigoKanryoMessageDiv;
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：文字列の場合）を行います。<br/>
     * 完了メッセージ文字を取得して、共通部品「完了メッセージ」のsetMessageメソッドを行います。
     *
     * @param message 完了メッセージ文字列
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    public void setMessage(RString message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        div.getCcdKanryoMessage().setMessage(message, messageTaisho1, messageTaisho2, isSuccess);
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」の場合）を行います。<br/>
     * 完了メッセージを取得するのMessageクラスに保持するメッセージ文字を取得して、<br/>
     * 共通部品「完了メッセージ」のsetMessageメソッドを行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess) {
        div.getCcdKanryoMessage().setMessage(new RString(message.getMessage().evaluate()), messageTaisho1,
                messageTaisho2, isSuccess);
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」、<br/>
     * 且つ置換文字列があるの場合）を行います。<br/>
     * 完了メッセージを取得するのMessageクラスに引数のメッセージ置換文字列でreplaceを実行する後、<br/>
     * 保持するメッセージ文字を取得して、共通部品「完了メッセージ」のsetMessageメソッドを行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     * @param replaces メッセージ置換文字列
     */
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess, String... replaces) {
        div.getCcdKanryoMessage().setMessage(new RString(message.getMessage().replace(replaces).evaluate()),
                messageTaisho1, messageTaisho2, isSuccess);
    }

}
