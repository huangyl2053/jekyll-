/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 調査委託先＆調査員入力共有子Divのバリデーションメッセージクラスです。
 */
public enum ChosaItakusakiAndChosainInputValidationMessages implements IValidationMessage {

    委託先コードに該当するデータなし(DbzErrorMessages.認定調査委託先コードに該当データなし),
    調査員コードに該当するデータなし(DbzErrorMessages.認定調査員コードに該当データなし);
    private final Message message;

    private ChosaItakusakiAndChosainInputValidationMessages(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
