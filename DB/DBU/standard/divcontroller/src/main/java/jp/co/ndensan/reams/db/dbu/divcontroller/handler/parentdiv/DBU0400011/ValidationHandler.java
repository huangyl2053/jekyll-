/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0400011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.db.dbu.definition.message.DbuErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護保険被保険者証一括作成チェッククラスです。
 *
 * @reamsid_L DBU-0420-010 duanzhanli
 *
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
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateA, div.getTxtKonkaiChushutsuFromYMD()));
        return validationMessages;
    }

    /**
     * 終了日＜今回基準日の場合、メッセージを表示します。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 終了日変更のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateB, div.getTxtKonkaiChushutsuToYMD()));
        return validationMessages;
    }

    /**
     * 開始日＞終了日の場合、メッセージを表示します。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 開始日と終了日の比較チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateC, div.getTxtKonkaiChushutsuFromYMD()));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        ValidateA(DbuErrorMessages.期間が不正_未来日時入力不可, "開始日時に", "前回の基準日時"),
        ValidateB(DbuErrorMessages.期間が不正_過去日時入力不可, "終了日時に", "今回の基準日時"),
        ValidateC(DbuErrorMessages.期間が不正_未来日時入力不可, "開始日時に", "終了日時");
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
