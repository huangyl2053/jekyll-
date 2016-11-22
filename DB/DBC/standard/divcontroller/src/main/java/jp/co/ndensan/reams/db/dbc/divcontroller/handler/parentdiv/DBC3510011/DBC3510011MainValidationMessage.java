/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 保険者情報送付のバリデーションです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public enum DBC3510011MainValidationMessage implements IValidationMessage {

    /**
     * ダウンロード対象選択チェック
     */
    ダウンロード対象選択チェック(UrErrorMessages.選択されていない, "ダウンロード対象");

    private final Message message;

    private DBC3510011MainValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private DBC3510011MainValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
