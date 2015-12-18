/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.validation;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 連絡先情報のバリデーションメッセージを定義している列挙型です。
 *
 * @author n8235 船山洋介
 */
public enum NinteiInputValidationMessage implements IValidationMessage {

    /**
     * 対象データなし を表す列挙体です。
     */
    対象データなし(UrErrorMessages.対象データなし);

    private final Message message;

    private NinteiInputValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
