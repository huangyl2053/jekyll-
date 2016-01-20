/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;

/**
 * DBZのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum Dbzmn00000ErrorMessages implements IValidationMessage {

    終了日が開始日以前(1, "終了日が開始日以前。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private Dbzmn00000ErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
