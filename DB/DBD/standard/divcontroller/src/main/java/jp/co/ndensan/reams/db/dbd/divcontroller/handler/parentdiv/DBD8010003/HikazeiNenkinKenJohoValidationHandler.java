/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.HikazeiNenkinKenJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.HikazeiNenkinKenJohoSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 非課税年金対象者情報登録画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-4930-010 wangjie2
 */
public class HikazeiNenkinKenJohoValidationHandler {

    /**
     * 年金保険者コードの未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 年金保険者コードの未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.年金保険者コードの非空チェック)
                .thenAdd(NoInputMessages.年金保険者コードの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.年金保険者コードの必須入力, div.getTbNenkinHokenshaCode()).build().check(messages));
        return pairs;
    }

    /**
     * 基礎年金番号の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 基礎年金番号の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.基礎年金番号の非空チェック)
                .thenAdd(NoInputMessages.基礎年金番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.基礎年金番号の必須入力, div.getTbKisoNenkinNo()).build().check(messages));
        return pairs;
    }

    /**
     * 年金コードの未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 年金コードの未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.年金コードの非空チェック)
                .thenAdd(NoInputMessages.年金コードの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.年金コードの必須入力, div.getTbNenkinCode()).build().check(messages));
        return pairs;
    }

    /**
     * 現基礎年金番号の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 現基礎年金番号の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.現基礎年金番号の非空チェック)
                .thenAdd(NoInputMessages.現基礎年金番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.現基礎年金番号の必須入力, div.getTbGenkisoNenkinNo()).build().check(messages));
        return pairs;
    }

    /**
     * 月の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 月の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.月の非空チェック)
                .thenAdd(NoInputMessages.月の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.月の必須入力, div.getDdlTsuki()).build().check(messages));
        return pairs;
    }

    /**
     * 金額の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 金額の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.金額の非空チェック)
                .thenAdd(NoInputMessages.金額の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.金額の必須入力, div.getTbKingaku()).build().check(messages));
        return pairs;
    }

    /**
     * 作成年月日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 作成年月日の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.作成年月日の非空チェック)
                .thenAdd(NoInputMessages.作成年月日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.作成年月日の必須入力, div.getTbCreateDate()).build().check(messages));
        return pairs;
    }

    /**
     * 対象年の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象年の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.対象年の非空チェック)
                .thenAdd(NoInputMessages.対象年の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象年の必須入力, div.getTbTaishoNen()).build().check(messages));
        return pairs;
    }

    /**
     * 氏名カナの未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 氏名カナの未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.氏名カナの非空チェック)
                .thenAdd(NoInputMessages.氏名カナの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.氏名カナの必須入力, div.getTbNameKana()).build().check(messages));
        return pairs;
    }

    /**
     * 性別の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 性別の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.性別の非空チェック)
                .thenAdd(NoInputMessages.性別の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.性別の必須入力, div.getDdlSex()).build().check(messages));
        return pairs;
    }

    /**
     * 生年月日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 生年月日の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.生年月日の非空チェック)
                .thenAdd(NoInputMessages.生年月日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.生年月日の必須入力, div.getTbBirthday()).build().check(messages));
        return pairs;
    }

    /**
     * 氏名漢字の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 氏名漢字の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.氏名漢字の非空チェック)
                .thenAdd(NoInputMessages.氏名漢字の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.氏名漢字の必須入力, div.getTbNameKanji()).build().check(messages));
        return pairs;
    }

    /**
     * 住所漢字の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 住所漢字の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.住所漢字の非空チェック)
                .thenAdd(NoInputMessages.住所漢字の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.住所漢字の必須入力, div.getTbAddressKanji()).build().check(messages));
        return pairs;
    }

    /**
     * 登録区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HikazeiNenkinKenJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 登録区分の未入力チェック(ValidationMessageControlPairs pairs, HikazeiNenkinKenJohoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinKenJohoSpec.登録区分の非空チェック)
                .thenAdd(NoInputMessages.登録区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.登録区分の必須入力, div.getTbLoadCata()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        年金保険者コードの必須入力(UrErrorMessages.必須.getMessage(), "年金保険者コード"),
        基礎年金番号の必須入力(UrErrorMessages.必須.getMessage(), "基礎年金番号"),
        年金コードの必須入力(UrErrorMessages.必須.getMessage(), "年金コード"),
        現基礎年金番号の必須入力(UrErrorMessages.必須.getMessage(), "現基礎年金番号"),
        月の必須入力(UrErrorMessages.必須.getMessage(), "月"),
        金額の必須入力(UrErrorMessages.必須.getMessage(), "金額"),
        作成年月日の必須入力(UrErrorMessages.必須.getMessage(), "作成年月日"),
        対象年の必須入力(UrErrorMessages.必須.getMessage(), "対象年"),
        氏名カナの必須入力(UrErrorMessages.必須.getMessage(), "氏名カナ"),
        性別の必須入力(UrErrorMessages.必須.getMessage(), "性別"),
        生年月日の必須入力(UrErrorMessages.必須.getMessage(), "生年月日"),
        氏名漢字の必須入力(UrErrorMessages.必須.getMessage(), "氏名漢字"),
        住所漢字の必須入力(UrErrorMessages.必須.getMessage(), "住所漢字"),
        登録区分の必須入力(UrErrorMessages.必須.getMessage(), "登録区分");
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
