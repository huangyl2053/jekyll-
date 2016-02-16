/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiChosaIkkatsuInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「NinteiChosaIkkatsuInput」の抽象ValidationHandlerクラスです。
 *
 */
public class NinteiChosaIkkatsuInputValidationHandler {

    private final NinteiChosaIkkatsuInputDiv div;

    public NinteiChosaIkkatsuInputValidationHandler(NinteiChosaIkkatsuInputDiv div) {
        this.div = div;
    }

    /**
     * 確認するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getChkDay().getSelectedItems().isEmpty()) {
            validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.validation曜日));
        }
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        validation曜日(UrErrorMessages.選択されていない, "曜日");

        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
