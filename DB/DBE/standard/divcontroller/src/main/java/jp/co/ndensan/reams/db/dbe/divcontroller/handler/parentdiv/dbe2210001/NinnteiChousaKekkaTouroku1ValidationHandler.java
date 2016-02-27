/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1DivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査結果登録1のバリデーションハンドラークラスです。
 */
public class NinnteiChousaKekkaTouroku1ValidationHandler {

    /**
     * 調査実施日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor調査実施日の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.調査実施日の非空チェック)
                .thenAdd(NoInputMessages.調査実施日の必須入力).messages());
//        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                NoInputMessages.調査実施日の必須入力,
//                div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi()).build().check(messages));  TODO get値
        return pairs;
    }

    /**
     * 実施場所の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor実施場所の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.実施場所の非空チェック)
                .thenAdd(NoInputMessages.実施場所の必須入力).messages());
//        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                NoInputMessages.実施場所の必須入力,
//                div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi()).build().check(messages));  TODO get値
        return pairs;
    }

    /**
     * 所属機関の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor所属機関の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.所属機関の非空チェック)
                .thenAdd(NoInputMessages.所属機関の必須入力).messages());
//        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                NoInputMessages.所属機関の必須入力,
//                div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi()).build().check(messages));  TODO get値
        return pairs;
    }

    /**
     * 記入者の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor記入者の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.記入者の非空チェック)
                .thenAdd(NoInputMessages.記入者の必須入力).messages());
//        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                NoInputMessages.記入者の必須入力,
//                div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi()).build().check(messages));  TODO get値
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        調査実施日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "調査実施日"),
        実施場所の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "実施場所"),
        所属機関の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "所属機関"),
        記入者の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "記入者");
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
