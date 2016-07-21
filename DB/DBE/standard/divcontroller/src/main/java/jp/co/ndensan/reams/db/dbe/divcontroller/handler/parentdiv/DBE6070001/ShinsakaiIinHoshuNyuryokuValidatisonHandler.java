/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6070001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinhoshunyuryoku.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 審査会委員報酬入力クラスです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinHoshuNyuryokuValidatisonHandler {

    private final ShinsakaiIinHoshuNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiIinHoshuNyuryokuDiv
     */
    public ShinsakaiIinHoshuNyuryokuValidatisonHandler(ShinsakaiIinHoshuNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 審査会委員報酬入力の件数が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validateForMaxCount(validPairs);
        return validPairs;
    }

    /**
     * 最大表示件数の必須入力チェックを実施します。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForMaxCount(ValidationMessageControlPairs validPairs) {
        if (div.getTextBoxNum().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(ShinsakaiIinHoshuNyuryokuValidatisonHandler.RRVMessages.Validate最大表示件数の必須入力チェック,
                    div.getTextBoxNum()));
        }
        return validPairs;
    }

    /**
     * 実績一覧データ空チェック
     *
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor実績一覧データ空チェック(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (shinsakaiIinHoshuNyuryoku.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(ShinsakaiIinHoshuNyuryokuValidatisonHandler.RRVMessages.Validate審査会実績一覧未表示,
                    div.getDgShinsakaiIin()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate審査会実績一覧未表示(UrErrorMessages.該当データなし),
        Validate最大表示件数の必須入力チェック(UrErrorMessages.必須, "最大表示件数");
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
