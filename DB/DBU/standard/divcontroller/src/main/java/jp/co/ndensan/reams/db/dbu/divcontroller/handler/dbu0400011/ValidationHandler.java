/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護保険被保険者証一括作成チェッククラスです。
 */
public class ValidationHandler {

    private final HihokenshaShoBatchPrmDiv div;

    /**
     * ValidationHandlerの引入です。
     *
     * @param div 護保険被保険者証一括作成Div
     */
    public ValidationHandler(HihokenshaShoBatchPrmDiv div) {
        this.div = div;
    }

    /**
     * 開始日＞前回の基準日時の場合、メッセージを表示します。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 開始日変更のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        //TODO QA278メーセジ確認　 張紅麗　まで12/29　開始日には前回の基準日より未来の日時を入力することはできません。 DBZE00006
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateA));
        return validationMessages;
    }

    /**
     * 終了日＜今回基準日の場合、メッセージを表示します。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 終了日変更のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        //TODO QA278メーセジ確認 張紅麗　まで12/29 終了日時には今回の基準日時より過去の日時を入力することはできません。 DBZE00008
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateB));
        return validationMessages;
    }

    /**
     * 開始日＞終了日の場合、メッセージを表示します。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 開始日と終了日の比較チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        //TODO QA278メーセジ確認 張紅麗　まで12/29 開始日には終了日時より未来の日時を入力することはできません。 DBZE00006
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateC));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        ValidateA(DbzErrorMessages.期間が不正_未来日付不可, "開始日に", "前回の基準日"),
        ValidateB(DbzErrorMessages.期間が不正_未来日付不可, "終了日時に", "今回の基準日時"),
        ValidateC(DbzErrorMessages.期間が不正_未来日付不可, "開始日に", "終了日時");
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
