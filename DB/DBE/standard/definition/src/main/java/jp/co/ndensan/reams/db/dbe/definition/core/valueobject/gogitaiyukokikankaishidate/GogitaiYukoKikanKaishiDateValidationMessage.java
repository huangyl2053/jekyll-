/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

public enum GogitaiYukoKikanKaishiDateValidationMessage implements IValidationMessage {

    /**
     * 開始年月日がNullであること
     */
    開始年月日がNullであること(GogitaichoKubunCodeErrorMessage.開始年月日がNullであること);
    private final Message message;

    private GogitaiYukoKikanKaishiDateValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link GogitaichoKubunCode}のErroroMessageです。
     */
    public enum GogitaichoKubunCodeErrorMessage implements IMessageGettable {

        /**
         * 開始年月日がNullであること
         */
        開始年月日がNullであること(1, "合議体長区分コードを指定してください。");
        private final int no;
        private final RString message;

        private GogitaichoKubunCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("GogitaichoKubunCodeError", no), this.message.toString());
        }
    }
}
