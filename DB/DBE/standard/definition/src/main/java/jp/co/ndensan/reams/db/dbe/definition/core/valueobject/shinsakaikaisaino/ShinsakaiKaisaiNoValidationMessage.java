/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaino;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShinsakaiKaisaiNo}のバリデーションメッセージです。
 */
public enum ShinsakaiKaisaiNoValidationMessage implements IValidationMessage {

    /**
     * 番号がNullであること。
     */
    番号がNullであること(ShinsakaiKaisaiNoErrorMessage.番号がNullであること);
    private final Message message;

    private ShinsakaiKaisaiNoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShinsakaiKaisaiNo}のErroroMessageです。
     */
    public enum ShinsakaiKaisaiNoErrorMessage implements IMessageGettable {

        /**
         * 番号がNullであること。
         */
        番号がNullであること(1, "審査会開催番号を指定してください。");
        private final int no;
        private final RString message;

        private ShinsakaiKaisaiNoErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShinsakaiKaisaiNoError", no), this.message.toString());
        }
    }
}
