/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link KeiyakuNo}のバリデーションメッセージです。
 */
public enum KeiyakuNoValidationMessage implements IValidationMessage {

    /**
     * 番号がNullであること。
     */
    番号がNullであること(KeiyakuNoErrorMessage.番号がNullであること);
    private final Message message;

    private KeiyakuNoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link KeiyakuNo}のErroroMessageです。
     */
    public enum KeiyakuNoErrorMessage implements IMessageGettable {

        /**
         * 番号がNullであること。
         */
        番号がNullであること(1, "契約番号を指定してください。");
        private final int no;
        private final RString message;

        private KeiyakuNoErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("KeiyakuNoError", no), this.message.toString());
        }
    }
}
