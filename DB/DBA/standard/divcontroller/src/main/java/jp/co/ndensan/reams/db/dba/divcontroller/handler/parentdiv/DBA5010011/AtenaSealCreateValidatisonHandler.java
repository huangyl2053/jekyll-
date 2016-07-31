/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA5010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011.AtenaSealCreateDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 宛名シール作成の入力チェックです。
 *
 * @reamsid_L DBA-1210-010 zhengsongling
 */
public class AtenaSealCreateValidatisonHandler {

    private final AtenaSealCreateDiv div;

    /**
     * コンストラクタです。
     *
     * @param div AtenaSealCreateDiv
     */
    public AtenaSealCreateValidatisonHandler(AtenaSealCreateDiv div) {
        this.div = div;
    }

    /**
     * 宛名シール作成の抽出期間チェック、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 抽出期間チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        抽出期間チェック(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs 抽出期間チェック(ValidationMessageControlPairs validPairs) {
        FlexibleDate fromDate = div.getCyushutsuJoken().getTxtShikakuTokusoFrom().getValue();
        FlexibleDate toDate = div.getCyushutsuJoken().getTxtShikakuTokusoTo().getValue();
        if (!fromDate.isEmpty() && !toDate.isEmpty() && !fromDate.isBeforeOrEquals(toDate)) {
            validPairs.add(new ValidationMessageControlPair(AtenaSealCreateValidatisonHandler.RRVMessages.Validate終了日が開始日以前,
                    div.getCyushutsuJoken().getTxtShikakuTokusoFrom(),
                    div.getCyushutsuJoken().getTxtShikakuTokusoTo()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate終了日が開始日以前(UrErrorMessages.終了日が開始日以前);
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
