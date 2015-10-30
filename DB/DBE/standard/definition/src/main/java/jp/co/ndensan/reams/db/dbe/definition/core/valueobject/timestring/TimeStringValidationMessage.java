/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.timestring;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link TimeString}のバリデーションメッセージです。
 */
public enum TimeStringValidationMessage implements IValidationMessage {

    /**
     * 桁数が4桁でないこと。
     */
    桁数が4桁でないこと(TimeStringErrorMessage.桁数が4桁でないこと);
    private final Message message;

    private TimeStringValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link TimeString}のErroroMessageです。
     */
    public enum TimeStringErrorMessage implements IMessageGettable {

        /**
         * 桁数が4桁ではないこと。
         */
        桁数が4桁でないこと(1, "時間は4桁で指定してください");
        private final int no;
        private final RString message;

        private TimeStringErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("TimeStringError", no), this.message.toString());
        }
    }
}
