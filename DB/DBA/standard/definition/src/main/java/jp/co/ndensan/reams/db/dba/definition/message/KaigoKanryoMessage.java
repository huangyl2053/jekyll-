/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 介護完了メッセージのビジネスクラス。
 */
public enum KaigoKanryoMessage implements IMessageGettable {

    更新終了(4, "更新は正常に終了しました。"),
    削除終了(5, "削除は正常に終了しました。");
    private final Message message;

    private KaigoKanryoMessage(int no, String message) {
        this.message = new InformationMessage(toCode("DBZI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
