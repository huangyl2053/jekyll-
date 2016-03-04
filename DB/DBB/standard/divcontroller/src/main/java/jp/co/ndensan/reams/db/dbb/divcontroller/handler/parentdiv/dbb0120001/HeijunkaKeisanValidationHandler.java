/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0120001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特徴平準化（特徴6月分）のバリデーションハンドラークラスです。
 */
public class HeijunkaKeisanValidationHandler {

    /**
     * 発行日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の必須入力(ValidationMessageControlPairs pairs, HeijunkaKeisanDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HeijunkaKeisanDivSpec.発行日の非空チェック)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getTokuchoHeijunkaChohyoHakko().getTxtHeijunkaHenkoTsuchiHakkoYMD()).build().check(messages));
        return pairs;
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
