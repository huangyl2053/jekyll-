/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 異動チェックリストの抽象ValidationHandlerクラスです。
 */
public class IdochekkurisutoValidationHandler {

    /**
     * 今回開始日と今回終了日の順番の整合性チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getKashiAfterShuryoMsg() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.期間が不正_未来日付不可));
        return validationMessages;
    }

    /**
     * 今回開始日と終了日の必須チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getRequiredKashiShuryoMsg() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.必須));
        return validationMessages;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        必須(UrErrorMessages.必須, "今回開始日と終了日両方"),
        期間が不正_未来日付不可(DbzErrorMessages.期間が不正_未来日付不可, "開始日", "終了日");

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
