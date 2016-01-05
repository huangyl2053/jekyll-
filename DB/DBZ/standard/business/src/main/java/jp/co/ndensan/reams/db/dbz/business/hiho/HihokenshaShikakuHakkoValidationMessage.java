/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hiho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 被保険者証・資格者証発行のバリデーションメッセージです。
 *
 * @author N8187 久保田 英男
 */
public enum HihokenshaShikakuHakkoValidationMessage implements IValidationMessage {

    /**
     * 交付事由が未選択します。
     */
    交付事由が未選択(UrErrorMessages.必須項目);

    private final Message message;

    private HihokenshaShikakuHakkoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
