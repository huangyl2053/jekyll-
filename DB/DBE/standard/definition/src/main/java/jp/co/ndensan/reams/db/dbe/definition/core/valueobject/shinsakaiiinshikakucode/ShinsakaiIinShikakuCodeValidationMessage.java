/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiinshikakucode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShinsakaiIinShikakuCode}のバリデーションメッセージです。
 */
public enum ShinsakaiIinShikakuCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(ShinsakaiIinShikakuCodeErrorMessage.コードがNullであること);
    private final Message message;

    private ShinsakaiIinShikakuCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShinsakaiIinShikakuCode}のErroroMessageです。
     */
    public enum ShinsakaiIinShikakuCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "審査会委員資格コードを指定してください。");
        private final int no;
        private final RString message;

        private ShinsakaiIinShikakuCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShinsakaiIinShikakuCodeError", no), this.message.toString());
        }
    }
}
