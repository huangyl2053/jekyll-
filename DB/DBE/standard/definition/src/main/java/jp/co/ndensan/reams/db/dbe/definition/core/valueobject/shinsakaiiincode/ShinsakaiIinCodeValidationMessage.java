/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShinsakaiIinCode}のバリデーションメッセージです。
 */
public enum ShinsakaiIinCodeValidationMessage implements IValidationMessage {

    /**
     * 桁数が8桁であること。
     */
    桁数が8桁ではないこと(ShinsakaiIinCodeErrorMessage.桁数が8桁ではないこと);
    private final Message message;

    private ShinsakaiIinCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShinsakaiIinCode}のErroroMessageです。
     */
    public enum ShinsakaiIinCodeErrorMessage implements IMessageGettable {

        /**
         * 桁数が8桁でないこと。
         */
        桁数が8桁ではないこと(1, "審査会委員コードは8桁で指定してください。");
        private final int no;
        private final RString message;

        private ShinsakaiIinCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShinsakaiIinCodeError", no), this.message.toString());
        }
    }
}
