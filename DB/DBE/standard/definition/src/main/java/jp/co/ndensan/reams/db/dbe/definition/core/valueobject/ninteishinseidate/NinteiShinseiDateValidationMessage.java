/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteishinseidate;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link NinteiShinseiDate}のバリデーションメッセージです。
 */
public enum NinteiShinseiDateValidationMessage implements IValidationMessage {

    /**
     * 認定申請年月日がNullであること。
     */
    認定申請年月日がNullであること(NinteiShinseiDateErrorMessage.認定申請年月日がNullであること);
    private final Message message;

    private NinteiShinseiDateValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link NinteiShinseiDate}のErroroMessageです。
     */
    public enum NinteiShinseiDateErrorMessage implements IMessageGettable {

        /**
         * 認定申請年月日がNullであること。
         */
        認定申請年月日がNullであること(1, "認定申請年月日を指定してください。");
        private final int no;
        private final RString message;

        private NinteiShinseiDateErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("NinteiShinseiDateError", no), this.message.toString());
        }
    }
}
