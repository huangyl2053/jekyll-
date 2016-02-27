/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410012;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * @author n3331
 */
public enum KokuhorenJohoValidationMessage implements IValidationMessage {

    /**
     * 処理対象情報が未選択
     */
    処理対象情報が未選択(UrErrorMessages.選択されていない, "処理対象情報"),
    /**
     * 出力順序未指定
     */
    出力順序未指定(UrErrorMessages.出力順序を指定);
    private final Message message;

    private KokuhorenJohoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
