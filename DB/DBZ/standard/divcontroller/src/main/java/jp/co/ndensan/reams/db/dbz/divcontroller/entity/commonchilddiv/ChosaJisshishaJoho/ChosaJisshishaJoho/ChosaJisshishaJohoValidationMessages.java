/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 調査実施者情報共有子Divのバリデーションメッセージクラスです。
 */
public enum ChosaJisshishaJohoValidationMessages implements IValidationMessage {

    所属機関コードに該当するデータなし(DbzErrorMessages.所属機関コードに該当データなし),
    記入者コードに該当するデータなし(DbzErrorMessages.認定調査員コードに該当データなし);
    private final Message message;

    private ChosaJisshishaJohoValidationMessages(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
