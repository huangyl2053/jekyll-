/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.validations;

import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 賦課エラー画面で使用するバリデーションメッセージです。
 *
 * @author n8178 城間篤人
 */
public enum FukaErrorValidationMessage implements IValidationMessage {

    更正対象が未処理状態ではないため実行不可(UrErrorMessages.実行不可);

    private final Message message;

    private FukaErrorValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
