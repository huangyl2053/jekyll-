/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6060001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.NinteiChosaHoshuShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査報酬照会のチェッククラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteiChosaHoshuShokaiValidationHandler {

    private final NinteiChosaHoshuShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     */
    public NinteiChosaHoshuShokaiValidationHandler(NinteiChosaHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 調査依頼日終了が開始日以前のチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgNinteiChosaHoshu().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象者を選択)));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
