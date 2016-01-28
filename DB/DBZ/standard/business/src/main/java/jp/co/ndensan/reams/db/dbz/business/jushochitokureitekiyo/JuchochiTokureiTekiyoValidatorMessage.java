/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureitekiyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住所地特例異動処理で使用されるバリデーションメッセージです。
 *
 * @author n8178 城間篤人
 */
public enum JuchochiTokureiTekiyoValidatorMessage implements IValidationMessage {

    /**
     * 住所地特例適用日が、最新履歴の取得日・変更日・住所地特例解除日より前します。
     */
    //TODO n8178 欲しいエラーがDBAのため見れない（DBAE00002）。対応を相談する。
    住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前(UrErrorMessages.不正, "住所地特例適用日");

    private final Message message;

    private JuchochiTokureiTekiyoValidatorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
