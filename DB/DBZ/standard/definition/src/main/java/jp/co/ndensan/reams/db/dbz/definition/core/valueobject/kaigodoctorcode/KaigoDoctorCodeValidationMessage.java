/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigodoctorcode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link KaigoDoctorCode}のバリデーションメッセージです。
 */
public enum KaigoDoctorCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(KaigoDoctorCodeErrorMessage.コードがNullであること);
    private final Message message;

    private KaigoDoctorCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link KaigoDoctorCode}のErroroMessageです。
     */
    public enum KaigoDoctorCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "介護医師コードを指定してください。");
        private final int no;
        private final RString message;

        private KaigoDoctorCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("KaigoDoctorCodeError", no), this.message.toString());
        }
    }
}
