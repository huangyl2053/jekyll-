/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBDの質問メッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbdQuestionMessages implements IMessageGettable {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    ダミーメッセージ(0, "");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("Q", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
