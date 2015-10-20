/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.yokaigojotaikubuncode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link YokaigoJotaiKubunCode}のバリデーションメッセージです。
 */
public enum YokaigoJotaiKubunCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(YokaigoJotaiKubunCodeErrorMessage.コードがNullであること);
    private final Message message;

    private YokaigoJotaiKubunCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link YokaigoJotaiKubunCode}のErroroMessageです。
     */
    public enum YokaigoJotaiKubunCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "要介護状態区分コードを指定してください。");
        private final int no;
        private final RString message;

        private YokaigoJotaiKubunCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("YokaigoJotaiKubunCodeError", no), this.message.toString());
        }
    }
}
