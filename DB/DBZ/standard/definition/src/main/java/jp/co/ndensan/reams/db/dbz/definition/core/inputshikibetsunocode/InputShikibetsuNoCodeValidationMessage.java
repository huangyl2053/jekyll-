/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.inputshikibetsunocode;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link InputShikibetsuNoCode}のバリデーションメッセージクラスです。
 */
public enum InputShikibetsuNoCodeValidationMessage implements IValidationMessage {

    /**
     * メッセージ:TODO 一つ目の要素が定義されたらこの要素は削除する。
     */
    ダミーメッセージ(UrInformationMessages.該当データなし);
    private final Message message;

    private InputShikibetsuNoCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link InputShikibetsuNoCode}のErroroMessageです。
     */
    public enum InputShikibetsuNoCodeErrorMessage implements IMessageGettable {

        /**
         * コードがNullであること。
         */
        コードがNullであること(1, "入力識別番号コードを指定してください。");
        private final int no;
        private final RString message;

        private InputShikibetsuNoCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("InputShikibetsuNoCodeError", no), this.message.toString());
        }
    }
}
