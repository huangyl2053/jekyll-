/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.kaigoninteichosainno;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link KaigoNinteichosainNo}のバリデーションメッセージです。
 */
public enum KaigoNinteichosainNoValidationMessage implements IValidationMessage {

    /**
     * 番号がNullであること。
     */
    番号がNullであること(KaigoNinteichosainNoErrorMessage.番号がNullであること);
    private final Message message;

    private KaigoNinteichosainNoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link KaigoNinteichosainNo}のErroroMessageです。
     */
    public enum KaigoNinteichosainNoErrorMessage implements IMessageGettable {

        /**
         * 番号がNullであること。
         */
        番号がNullであること(1, "介護調査員番号を指定してください。");
        private final int no;
        private final RString message;

        private KaigoNinteichosainNoErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("KaigoNinteichosainNoError", no), this.message.toString());
        }
    }
}
