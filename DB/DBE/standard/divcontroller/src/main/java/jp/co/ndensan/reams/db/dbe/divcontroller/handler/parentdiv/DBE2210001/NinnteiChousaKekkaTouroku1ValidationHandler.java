/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1DivSpec;
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
 * 認定調査結果登録1のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
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
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.調査実施日の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate()).build().check(messages));
        return pairs;
    }
    
    /**
     * 調査実施日の妥当性入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor調査実施日の妥当性入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.調査実施日の妥当性チェック)
                .thenAdd(NoInputMessages.調査実施日の妥当性入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.調査実施日の妥当性入力,
                div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate()).build().check(messages));
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
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.実施場所の必須入力,
                div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho()).build().check(messages));
        return pairs;
    }

    /**
     * 実施場所名称の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor実施場所名称の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.実施場所名称の非空チェック)
                .thenAdd(NoInputMessages.実施場所名称の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.実施場所名称の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho()).build().check(messages));
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
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.所属機関の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode()).build().check(messages));
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
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.記入者の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtKinyushaCode()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第1群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第1群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第1群の非空チェック)
                .thenAdd(NoInputMessages.第1群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第1群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa1()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第2群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第2群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第2群の非空チェック)
                .thenAdd(NoInputMessages.第2群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第2群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa2()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第3群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第3群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第3群の非空チェック)
                .thenAdd(NoInputMessages.第3群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第3群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa3()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第4群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第4群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第4群の非空チェック)
                .thenAdd(NoInputMessages.第4群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第4群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa4()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第5群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第5群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第5群の非空チェック)
                .thenAdd(NoInputMessages.第5群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第5群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa5()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の生活自立度の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor生活自立度の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.生活自立度の非空チェック)
                .thenAdd(NoInputMessages.生活自立度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.生活自立度の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa7()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        調査実施日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "調査実施日"),
        調査実施日の妥当性入力(UrErrorMessages.前後関係逆転, "認定申請日", "調査実施日"),
        実施場所の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "実施場所"),
        実施場所名称の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "実施場所名称"),
        所属機関の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "所属機関"),
        記入者の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "記入者"),
        第1群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第1群"),
        第2群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第2群"),
        第3群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第3群"),
        第4群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第4群"),
        第5群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第5群"),
        生活自立度の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の生活自立度");
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
