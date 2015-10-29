/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.jotaianteiseicode;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * {@link JotaiAnteiseiCode}のバリデーションメッセージです。
 */
public enum JotaiAnteiseiCodeValidationMessage implements IValidationMessage {

    テスト用(JotaiAnteiseiCodeErrorMessage.テスト用);
    private final Message message;

    private JotaiAnteiseiCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * {@link JotaiAnteiseiCode}のErroroMessageです。
     */
    public enum JotaiAnteiseiCodeErrorMessage implements IMessageGettable {

        テスト用(1, "");
        private final int no;
        private final RString message;

        private JotaiAnteiseiCodeErrorMessage(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("JotaiAnteiseiCodeError", no), this.message.toString());
        }
    }
}
