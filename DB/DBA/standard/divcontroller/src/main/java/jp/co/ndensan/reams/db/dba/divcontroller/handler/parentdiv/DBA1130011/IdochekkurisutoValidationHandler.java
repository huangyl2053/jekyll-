/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011.IdochekkurisutoDiv;
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

    private final IdochekkurisutoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IdochekkurisutoDiv
     */
    public IdochekkurisutoValidationHandler(IdochekkurisutoDiv div) {
        this.div = div;
    }

    /**
     * 今回開始日と今回終了日の順番の整合性をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkKashiAfterShuryoMsg() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtkonkaishuryo().getValue().isBefore(div.getTxtkonkaikaishi().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(
                    IdocheckMessages.期間が不正_未来日付不可, div.getTxtkonkaikaishi()));
        }
        return validationMessages;
    }

    /**
     * 今回開始日と終了日の必須をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkRequiredKashiShuryoMsg() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtkonkaishuryo().getValue().isEmpty()
                && div.getTxtkonkaikaishi().getValue().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    IdocheckMessages.開始日と終了日必須, div.getTxtkonkaikaishi()));
        }
        return validationMessages;
    }

    /**
     * 対象台帳の必須をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkRequiredChktaishodaicho() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getChktaishodaicho().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    IdocheckMessages.対象台帳必須, div.getChktaishodaicho()));
        }
        return validationMessages;
    }

    /**
     * 出力順帳の必須をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkRequiredChohyoShu() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        // TODO 内部QA：509 Redmine：#74262(画面項目がない、実装しない)
        if (div.getCcdChohyoShutsuryokujun().isDisabled()) {
//            validationMessages.add(new ValidationMessageControlPair(IdocheckMessages.出力順必須));
        }
        return validationMessages;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        開始日と終了日必須(UrErrorMessages.必須, "今回開始日と終了日両方"),
        期間が不正_未来日付不可(DbzErrorMessages.期間が不正_未来日付不可, "開始日", "終了日"),
        対象台帳必須(UrErrorMessages.必須, "対象台帳"),
        出力順必須(UrErrorMessages.必須, "出力順"),
        今回開始日必須(UrErrorMessages.必須, "今回開始日"),
        今回終了日必須(UrErrorMessages.必須, "今回終了日");

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
