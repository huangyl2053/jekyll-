/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2270001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001.NinteiChosaDataOutputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査データ出力（モバイル）のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public class NinteiChosaDataOutputValidationHandler {

    /**
     * 認定調査一覧が０件の場合、該当データが存在チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs checkデータ存在() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.該当データなし)));
        return validationMessages;
    }

    /**
     * 認定調査一覧が何れかでも未選択の場合、対象行選択チェックを行う。
     *
     * @param div div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check対象行選択(NinteiChosaDataOutputDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiChosaData().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.対象行を選択)));
        }
        return validationMessages;
    }

    private static class CheckMessages implements IValidationMessage {

        private final Message message;

        public CheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
