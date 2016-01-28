/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 証交付回収情報のチェッククラスです。
 */
public class ValidationHandler {

    public static ValidationMessageControlPairs 交付日と有効期限の整合性チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateA));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 交付事由の必須チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate必須));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 交付理由の最大桁数() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate桁数));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 回収理由のの最大桁数() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate桁数2));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 交付日と回収日の順番の整合性チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate順番));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 交付日がセットになっているかの入力チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate交付日));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 交付事由がセットになっているかの入力チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate交付事由));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 回収日がセットになっているかの入力チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate回収日));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 回収事由がセットになっているかの入力チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate回収事由));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        ValidateA(DbzErrorMessages.期間が不正_過去日付不可, "有効期限", "交付日"),
        Validate必須(UrErrorMessages.必須, "交付事由"),
        Validate桁数(UrErrorMessages.桁数が不正, "交付理由", "256"),
        Validate桁数2(UrErrorMessages.桁数が不正, "回収理由", "256"),
        Validate順番(UrErrorMessages.期間が不正_追加メッセージあり２, "交付日", "回収日"),
        Validate交付日(UrErrorMessages.存在しない, "交付日"),
        Validate交付事由(UrErrorMessages.存在しない, "交付事由"),
        Validate回収日(UrErrorMessages.存在しない, "回収日"),
        Validate回収事由(UrErrorMessages.存在しない, "回収事由");
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
