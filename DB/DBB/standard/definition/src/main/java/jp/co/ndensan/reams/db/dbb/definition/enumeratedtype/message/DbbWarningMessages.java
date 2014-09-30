/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import static jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBBの警告メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbbWarningMessages implements IMessageGettable {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    ダミーメッセージ(0, "");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("W", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
