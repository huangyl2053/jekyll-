/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaichiku;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link ShinsakaiKaisaiChiku}のバリデーションメッセージです。
 */
public enum ShinsakaiKaisaiChikuValidationMessage implements IValidationMessage {

    /**
     * 名称がNullであること。
     */
    名称がNullであること(ShinsakaiKaisaiChikuErrorMessage.名称がNullであること);
    private final Message message;

    private ShinsakaiKaisaiChikuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link ShinsakaiKaisaiChiku}のErroroMessageです。
     */
    public enum ShinsakaiKaisaiChikuErrorMessage implements IMessageGettable {

        /**
         * 名称がNullであること。
         */
        名称がNullであること(1, "名称を指定してください。");
        private final int no;
        private final RString message;

        private ShinsakaiKaisaiChikuErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("ShinsakaiKaisaiChikuError", no), this.message.toString());
        }
    }
}
