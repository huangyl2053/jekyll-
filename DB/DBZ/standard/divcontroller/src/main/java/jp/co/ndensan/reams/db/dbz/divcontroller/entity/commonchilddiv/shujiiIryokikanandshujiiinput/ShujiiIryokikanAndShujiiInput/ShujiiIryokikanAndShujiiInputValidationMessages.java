/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 主治医医療機関＆主治医入力共有子Divのバリデーションメッセージクラスです。
 */
public enum ShujiiIryokikanAndShujiiInputValidationMessages implements IValidationMessage {

    医療機関コードに該当するデータなし(DbzErrorMessages.医療機関コードに該当データなし),
    主治医コードに該当するデータなし(DbzErrorMessages.主治医コードに該当データなし);

    private final Message message;

    private ShujiiIryokikanAndShujiiInputValidationMessages(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
