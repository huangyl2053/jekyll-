/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.NotificationMessage;

/**
 * DBEの通知メッセージ定義列挙型です。
 */
public enum DbeNotificationMessages implements IMessageGettable {

    審査会結果登録_未判定被保険者表示(1, "未判定の被保険者を表示しました。<br><br>　審査会順序：?<br>　被保番号：?<br>　氏名：?"),
    全審査結果登録完了(2, "すべての被保険者の判定結果が設定されました。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbeNotificationMessages(int no, String message) {
        this.message = new NotificationMessage(toCode("DBEN", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
