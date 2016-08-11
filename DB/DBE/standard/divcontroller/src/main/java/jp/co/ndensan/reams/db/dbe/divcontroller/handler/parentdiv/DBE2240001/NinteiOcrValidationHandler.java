/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author soft863
 */
public class NinteiOcrValidationHandler {

    /**
     * 取込みファイル内容一覧対象未選択チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check一覧対象未選択() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new NinteiOcrValidationHandler.CheckMessages(UrErrorMessages.選択されていない,
                "取込み対象")));
        return validationMessages;
    }

    /**
     * NGの対象を選択チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check対象を選択() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new NinteiOcrValidationHandler.CheckMessages(UrErrorMessages.更新不可_汎用,
                "NGのデータを選択する")));
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
