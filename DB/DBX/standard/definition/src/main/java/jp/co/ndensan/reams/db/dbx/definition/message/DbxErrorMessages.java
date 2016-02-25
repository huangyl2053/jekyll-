/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.message;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBXのエラーメッセージ定義列挙型です。
 */
public enum DbxErrorMessages implements IMessageGettable, IValidationMessage {

    業務コンフィグなし(1, "業務コンフィグがありません。：?");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbxErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBXE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
