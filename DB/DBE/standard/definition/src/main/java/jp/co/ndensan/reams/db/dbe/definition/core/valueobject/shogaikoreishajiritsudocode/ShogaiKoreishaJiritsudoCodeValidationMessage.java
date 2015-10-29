/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shogaikoreishajiritsudocode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShogaiKoreishaJiritsudoCode}のバリデーションメッセージです。
 */
public enum ShogaiKoreishaJiritsudoCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(ShogaiKoreishaJiritsudoCodeErrorMessage.コードがNullであること);
    private final Message message;

    private ShogaiKoreishaJiritsudoCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShogaiKoreishaJiritsudoCode}のErroroMessageです。
     */
    public enum ShogaiKoreishaJiritsudoCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "介護事業者番号を指定してください。");
        private final int no;
        private final RString message;

        private ShogaiKoreishaJiritsudoCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShogaiKoreishaJiritsudoCodeError", no), this.message.toString());
        }
    }
}
