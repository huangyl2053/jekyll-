/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.NotificationMessage;

/**
 * DBZの通知メッセージ定義列挙型です。
 */
public enum DbzNotificationMessage implements IMessageGettable {

    該当データなし(1, "該当データはありませんでした。"),;

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzNotificationMessage(int no, String message) {
        this.message = new NotificationMessage(toCode("DBZN", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
