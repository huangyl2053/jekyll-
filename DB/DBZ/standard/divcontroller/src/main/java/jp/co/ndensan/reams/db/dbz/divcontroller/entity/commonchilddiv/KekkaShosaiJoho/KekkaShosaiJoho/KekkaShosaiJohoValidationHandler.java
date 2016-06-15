/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author zuotao
 */
public class KekkaShosaiJohoValidationHandler {

    private final KekkaShosaiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiInputDiv
     */
    public KekkaShosaiJohoValidationHandler(KekkaShosaiJohoDiv div) {
        this.div = div;
    }

    /**
     * 有効開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 有効開始日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getCcdNinteiInput().getNaiyo().get有効終了年月日() == null) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation有効開始日));
        }
        return validationMessage;
    }

    /**
     * 有効開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 有効終了日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getCcdNinteiInput().getNaiyo().get有効終了年月日() == null) {
            validationMessage.add(new ValidationMessageControlPair(KekkaShosaiJohoCheckMessages.validation有効終了日));
        }
        return validationMessage;
    }

    private static enum KekkaShosaiJohoCheckMessages implements IValidationMessage {

        validation有効開始日(UrErrorMessages.対象データなし_追加メッセージあり, "開始日"),
        validation有効終了日(UrWarningMessages.未入力, "終了日");
        private final Message message;

        private KekkaShosaiJohoCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
