/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 福祉用具商品名入力ガイドのチェッククラスです。
 */
public class ValidationHandler {

    public static ValidationMessageControlPairs 管理日Fromの必須チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate管理日必須));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 商品名の必須チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate商品名必須));
        return validationMessages;
    }

    public static ValidationMessageControlPairs 管理日Fromと管理日Toの整合性チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate整合性));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate管理日必須(UrErrorMessages.必須, "管理日From"),
        Validate商品名必須(UrErrorMessages.必須, "商品名"),
        Validate整合性(DbzErrorMessages.期間が不正_未来日付不可, "管理日From", "管理日To");
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
