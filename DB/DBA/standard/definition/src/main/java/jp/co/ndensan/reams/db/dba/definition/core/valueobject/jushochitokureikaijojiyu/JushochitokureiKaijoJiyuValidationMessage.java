/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.jushochitokureikaijojiyu;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link JushochitokureiKaijoJiyu}のバリデーションメッセージです。
 */
public enum JushochitokureiKaijoJiyuValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(JushochitokureiKaijoJiyuErrorMessage.コードがNullであること),
    /**
     * 名称がNullであること。
     */
    名称がNullであること(JushochitokureiKaijoJiyuErrorMessage.名称がNullであること);
    private final Message message;

    private JushochitokureiKaijoJiyuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link JushochitokureiKaijoJiyu}のErroroMessageです。
     */
    public enum JushochitokureiKaijoJiyuErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "コードを指定してください。"),
        /**
         * 名称がNullであること。
         */
        名称がNullであること(2, "名称を指定してください。");
        private final int no;
        private final RString message;

        private JushochitokureiKaijoJiyuErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("JushochitokureiKaijoJiyuError", no), this.message.toString());
        }
    }
}
