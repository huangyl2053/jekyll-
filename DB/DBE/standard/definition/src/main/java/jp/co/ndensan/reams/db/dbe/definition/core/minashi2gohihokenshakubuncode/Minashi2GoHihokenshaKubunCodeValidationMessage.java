/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.minashi2gohihokenshakubuncode;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link Minashi2GoHihokenshaKubunCode}のバリデーションメッセージです。
 */
public enum Minashi2GoHihokenshaKubunCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(Minashi2GoHihokenshaKubunCodeErrorMessage.コードがNullであること);
    private final Message message;

    private Minashi2GoHihokenshaKubunCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link Minashi2GoHihokenshaKubunCode}のErroroMessageです。
     */
    public enum Minashi2GoHihokenshaKubunCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "みなし2号被保険者区分コードを指定してください。");
        private final int no;
        private final RString message;

        private Minashi2GoHihokenshaKubunCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("Minashi2GoHihokenshaKubunCodeError", no), this.message.toString());
        }
    }
}
