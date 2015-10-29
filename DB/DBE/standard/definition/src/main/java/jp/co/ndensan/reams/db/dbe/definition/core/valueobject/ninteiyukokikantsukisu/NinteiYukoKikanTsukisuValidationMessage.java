/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteiyukokikantsukisu;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link NinteiYukoKikanTsukisu}のバリデーションメッセージです。
 */
public enum NinteiYukoKikanTsukisuValidationMessage implements IValidationMessage {

    /**
     * 認定有効期間月数がNullであること。
     */
    認定有効期間月数がNullであること(NinteiYukoKikanTsukisuErrorMessage.認定有効期間月数がNullであること);
    private final Message message;

    private NinteiYukoKikanTsukisuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link NinteiYukoKikanTsukisu}のErroroMessageです。
     */
    public enum NinteiYukoKikanTsukisuErrorMessage implements IMessageGettable {

        /**
         * 認定有効期間月数がNullであること。
         */
        認定有効期間月数がNullであること(1, "認定有効期間月数を指定してください。");
        private final int no;
        private final RString message;

        private NinteiYukoKikanTsukisuErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("NinteiYukoKikanTsukisuError", no), this.message.toString());
        }
    }
}
