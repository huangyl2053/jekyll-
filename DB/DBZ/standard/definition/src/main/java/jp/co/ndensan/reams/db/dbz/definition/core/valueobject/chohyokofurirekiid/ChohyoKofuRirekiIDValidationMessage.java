/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.chohyokofurirekiid;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ChohyoKofuRirekiID}のバリデーションメッセージクラスです。
 */
public enum ChohyoKofuRirekiIDValidationMessage implements IValidationMessage {

    /**
     * コードがNullであること。
     */
    コードがNullであること(ChohyoKofuRirekiIDErrorMessage.コードがNullであること);
    private final Message message;

    private ChohyoKofuRirekiIDValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ChohyoKofuRirekiID}のErroroMessageです。
     */
    public enum ChohyoKofuRirekiIDErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "帳票交付履歴IDを指定してください。");
        private final int no;
        private final RString message;

        private ChohyoKofuRirekiIDErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ChohyoKofuRirekiIDError", no), this.message.toString());
        }
    }
}
