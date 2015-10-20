/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link KaigoIryoKikanCode}のバリデーションメッセージです。
 */
public enum KaigoIryoKikanCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(KaigoIryoKikanCodeErrorMessage.コードがNullであること);
    private final Message message;

    private KaigoIryoKikanCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link KaigoIryoKikanCode}のErroroMessageです。
     */
    public enum KaigoIryoKikanCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "介護医療機関コードを指定してください。");
        private final int no;
        private final RString message;

        private KaigoIryoKikanCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("KaigoIryoKikanCodeError", no), this.message.toString());
        }
    }
}
