/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hihokenshakubuncode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link HihokenshaKubunCode}のバリデーションメッセージです。
 */
public enum HihokenshaKubunCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(HihokenshaKubunCodeErrorMessage.コードがNullであること);
    private final Message message;

    private HihokenshaKubunCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link HihokenshaKubunCode}のErroroMessageです。
     */
    public enum HihokenshaKubunCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "被保険者区分コードを指定してください。");
        private final int no;
        private final RString message;

        private HihokenshaKubunCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("HihokenshaKubunCodeError", no), this.message.toString());
        }
    }
}
