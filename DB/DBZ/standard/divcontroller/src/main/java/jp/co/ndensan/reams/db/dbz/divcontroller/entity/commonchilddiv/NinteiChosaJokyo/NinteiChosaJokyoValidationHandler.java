/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「認定調査状況」のValidationHandlerクラスです。
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public class NinteiChosaJokyoValidationHandler {

    private final NinteiChosaJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 条件検索画面div
     */
    public NinteiChosaJokyoValidationHandler(NinteiChosaJokyoDiv div) {
        this.div = div;
    }

    /**
     * バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        FlexibleDate fromValue = div.getTxtNinteiYukoKikanFrom().getValue();
        FlexibleDate toValue = div.getTxtNinteiYukoKikanTo().getValue();
        if (fromValue != null && toValue != null && toValue.compareTo(fromValue) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.前後関係逆転,
                            "認定有効期間From", "認定有効期間To"),
                    div.getTxtNinteiYukoKikanFrom()));
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
