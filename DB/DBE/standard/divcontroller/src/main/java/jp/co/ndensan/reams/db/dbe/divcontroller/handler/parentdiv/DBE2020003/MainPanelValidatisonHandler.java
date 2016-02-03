/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * MainPaneValidationMessageバリデーションメッセージを定義している列挙型です。
 *
 * @author ludm
 */
public class MainPanelValidatisonHandler {

    /**
     * 画面で認定申請日Fromと認定申請日To全て入力時、認定申請日From＞認定申請日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定申請日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(new ValidationMessageControlPair(RRVMessages.認定申請日の前後順));
        return validPairs;
    }

    /**
     * 画面で認定調査日Fromと認定調査日To全て入力時、認定調査日From＞認定調査日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定調査日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(new ValidationMessageControlPair(RRVMessages.認定調査日の前後順));
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        認定申請日の前後順(UrErrorMessages.終了日が開始日以前),
        認定調査日の前後順(UrErrorMessages.終了日が開始日以前);
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
