/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 介護支援専門員登録画面 の入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public enum KaigoSienSenmonkaTorokuValidationMessage implements IValidationMessage {

    /**
     * 被保険者名全角文字で入力してください
     */
    介護支援専門員番号の重複チェック(UrErrorMessages.既に存在, "介護支援専門員番号");

    private final Message message;

    /**
     * エラーメッセージを取得する。
     *
     * @return エラーメッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

    private KaigoSienSenmonkaTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
