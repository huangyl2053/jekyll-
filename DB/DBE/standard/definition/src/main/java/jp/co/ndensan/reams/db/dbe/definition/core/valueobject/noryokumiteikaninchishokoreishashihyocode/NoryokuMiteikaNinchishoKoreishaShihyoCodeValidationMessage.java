/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.noryokumiteikaninchishokoreishashihyocode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link NoryokuMiteikaNinchishoKoreishaShihyoCode}のバリデーションメッセージです。
 */
public enum NoryokuMiteikaNinchishoKoreishaShihyoCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること
     */
    コードがNullであること(NoryokuMiteikaNinchishoKoreishaShihyoCodeErrorMessage.コードがNullであること);
    private final Message message;

    private NoryokuMiteikaNinchishoKoreishaShihyoCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link NoryokuMiteikaNinchishoKoreishaShihyoCode}のErroroMessageです。
     */
    public enum NoryokuMiteikaNinchishoKoreishaShihyoCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること
         */
        コードがNullであること(1, "運動能力未低下認知症高齢者の指標コードを指定してください。");
        private final int no;
        private final RString message;

        private NoryokuMiteikaNinchishoKoreishaShihyoCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("NoryokuMiteikaNinchishoKoreishaShihyoCodeError", no), this.message.toString());
        }
    }
}
