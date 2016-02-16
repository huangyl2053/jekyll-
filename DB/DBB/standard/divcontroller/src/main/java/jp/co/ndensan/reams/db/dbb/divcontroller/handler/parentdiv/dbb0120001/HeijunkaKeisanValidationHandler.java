/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0120001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特徴平準化（特徴6月分）のバリデーションハンドラークラスです。
 */
public class HeijunkaKeisanValidationHandler {


    /**
     * 保存するボタンを押下するとき、完了メッセージを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の必須入力() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(new ValidationMessageControlPair(HeijunkaKeisanValidationHandler.NoInputMessages.発行日の必須入力));
        return validPairs;
    }


    private static enum NoInputMessages implements IValidationMessage {

        発行日の必須入力(UrErrorMessages.必須, "発行日");
        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
