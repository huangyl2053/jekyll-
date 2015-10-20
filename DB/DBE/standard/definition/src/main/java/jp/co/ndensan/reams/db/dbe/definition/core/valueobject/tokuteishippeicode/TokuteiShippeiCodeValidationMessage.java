/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.tokuteishippeicode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link TokuteiShippeiCode}のバリデーションメッセージです。
 */
public enum TokuteiShippeiCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(TokuteiShippeiCodeErrorMessage.コードがNullであること);
    private final Message message;

    private TokuteiShippeiCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link TokuteiShippeiCode}のErroroMessageです。
     */
    public enum TokuteiShippeiCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "特定疾病コードを指定してください。");
        private final int no;
        private final RString message;

        private TokuteiShippeiCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("TokuteiShippeiCodeError", no), this.message.toString());
        }
    }
}
