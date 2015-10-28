/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.shisetsucode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShisetsuCode}のバリデーションメッセージクラスです。
 */
public enum ShisetsuCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(ShisetsuCodeErrorMessage.コードがNullであること);
    private final Message message;

    private ShisetsuCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShisetsuCode}のErroroMessageです。
     */
    public enum ShisetsuCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "エラーコードを指定してください。");
        private final int no;
        private final RString message;

        private ShisetsuCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShisetsuCodeError", no), this.message.toString());
        }
    }
}
