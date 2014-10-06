/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.message.MessageCreateHelper.toCode;

/**
 * DBUのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbuErrorMessages implements IMessageGettable {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    ダミーメッセージ(0, "");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbuErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
