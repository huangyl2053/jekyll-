/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.validation;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 共通のバリデーションメッセージを定義している列挙型です。
 *
 */
public enum CommonValidationMessage implements IValidationMessage {

    /**
     * 「検索条件未指定」を表す列挙体です。
     */
    検索条件未指定(UrErrorMessages.未指定.getMessage().replace("検索条件を"));

    private final transient Message message;

    private CommonValidationMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
