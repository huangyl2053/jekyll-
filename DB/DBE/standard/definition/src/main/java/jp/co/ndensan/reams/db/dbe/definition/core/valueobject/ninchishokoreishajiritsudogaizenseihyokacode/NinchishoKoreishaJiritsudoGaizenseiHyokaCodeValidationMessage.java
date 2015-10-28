/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudogaizenseihyokacode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link NinchishoKoreishaJiritsudoGaizenseiHyokaCode}のバリデーションメッセージです。
 */
public enum NinchishoKoreishaJiritsudoGaizenseiHyokaCodeValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(NinchishoKoreishaJiritsudoGaizenseiHyokaCodeErrorMessage.コードがNullであること);
    private final Message message;

    private NinchishoKoreishaJiritsudoGaizenseiHyokaCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link NinchishoKoreishaJiritsudoGaizenseiHyokaCode}のErroroMessageです。
     */
    public enum NinchishoKoreishaJiritsudoGaizenseiHyokaCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "認知症高齢者自立度の蓋然性評価コードを指定してください。");
        private final int no;
        private final RString message;

        private NinchishoKoreishaJiritsudoGaizenseiHyokaCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("NinchishoKoreishaJiritsudoGaizenseiHyokaCodeError", no), this.message.toString());
        }
    }
}
