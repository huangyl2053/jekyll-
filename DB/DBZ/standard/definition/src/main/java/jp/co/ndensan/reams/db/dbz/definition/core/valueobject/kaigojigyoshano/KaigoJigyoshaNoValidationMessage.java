/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link KaigoJigyoshaNo}のバリデーションメッセージです。
 */
public enum KaigoJigyoshaNoValidationMessage implements IValidationMessage {

    /**
     * 番号がNullであること
     */
    番号がNullであること(KaigoJigyoshaNoErrorMessage.番号がNullであること);
    private final Message message;

    private KaigoJigyoshaNoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link KaigoJigyoshaNo}のErroroMessageです。
     */
    public enum KaigoJigyoshaNoErrorMessage implements IMessageGettable {

        /**
         * 番号がNullであること
         */
        番号がNullであること(1, "介護事業者番号を指定してください。");
        private final int no;
        private final RString message;

        private KaigoJigyoshaNoErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("KaigoJigyoshaNoError", no), this.message.toString());
        }
    }
}
