/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikenshoitemno;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShujiiIkenshoItemNo}のバリデーションメッセージです。
 */
public enum ShujiiIkenshoItemNoValidationMessage implements IValidationMessage {

    /**
     * 番号がNullであること
     */
    番号がNullであること(ShujiiIkenshoItemNoErrorMessage.番号がNullであること);
    private final Message message;

    private ShujiiIkenshoItemNoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShujiiIkenshoItemNo}のErroroMessageです。
     */
    public enum ShujiiIkenshoItemNoErrorMessage implements IMessageGettable {

        /**
         * 番号がNullであること
         */
        番号がNullであること(1, "項目番号を指定してください。");
        private final int no;
        private final RString message;

        private ShujiiIkenshoItemNoErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShujiiIkenshoItemNoError", no), this.message.toString());
        }
    }
}
