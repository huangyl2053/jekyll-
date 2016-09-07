/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBC4210011_種類支給限度額登録のバリデーションです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMainValidationHandler {

    private static final RString 要支援1 = new RString("要支援1");
    private static final RString 要支援2 = new RString("要支援2");

    /**
     * 標準適用開始年月チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 標準適用開始年月チェック(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.標準適用開始年月チェック)
                .thenAdd(GetMessages.適用期間_重複_開始年月不正).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.適用期間_重複_開始年月不正,
                div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange()).build().check(messages));
        return pairs;
    }

    /**
     * サービス提供期間チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs サービス提供期間チェック(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.サービス提供期間チェック)
                .thenAdd(GetMessages.種類支給限度額_サービス提供期間外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.種類支給限度額_サービス提供期間外,
                div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange()).build().check(messages));
        return pairs;
    }

    /**
     * 種類支給限度額認定対象チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 種類支給限度額認定対象チェック(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.種類支給限度額認定対象チェック)
                .thenAdd(GetMessages.種類支給限度額_認定可能対象外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.種類支給限度額_認定可能対象外,
                div.getShuruiShikyuGendogakuShosai()).build().check(messages));
        return pairs;
    }

    /**
     * 要支援1入力警告チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 要支援1入力チェック警告(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.要支援1入力チェック警告)
                .thenAdd(GetMessages.要支援1未入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.要支援1未入力,
                div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku()).build().check(messages));
        return pairs;
    }

    /**
     * 要支援1入力エラーチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 要支援1入力チェックエラー(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.要支援1入力チェックエラー)
                .thenAdd(GetMessages.要支援1入力チェックエラー).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.要支援1入力チェックエラー,
                div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku()).build().check(messages));
        return pairs;
    }

    /**
     * 要支援2必須チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 要支援2入力チェック警告(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.要支援2入力チェック警告)
                .thenAdd(GetMessages.要支援2必須).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.要支援2必須,
                div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku()).build().check(messages));
        return pairs;
    }

    /**
     * 要支援2入力エラーチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 要支援2入力チェックエラー(ValidationMessageControlPairs pairs, ShuruiShikyuGendogakuMainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShuruiShikyuGendogakuMainSpec.要支援2入力チェックエラー)
                .thenAdd(GetMessages.要支援2入力チェックエラー).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                GetMessages.要支援2入力チェックエラー,
                div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku()).build().check(messages));
        return pairs;
    }

    private static enum GetMessages implements IValidationMessage {

        適用期間_重複_開始年月不正(DbcErrorMessages.適用期間_重複_開始年月不正.getMessage()),
        種類支給限度額_サービス提供期間外(DbcErrorMessages.種類支給限度額_サービス提供期間外.getMessage()),
        種類支給限度額_認定可能対象外(DbcErrorMessages.種類支給限度額_認定可能対象外.getMessage()),
        要支援1未入力(UrWarningMessages.未入力, 要支援1.toString()),
        要支援1入力チェックエラー(DbcErrorMessages.種類支給限度額_要介護状態区分入力不可.getMessage(), 要支援1.toString()),
        要支援2必須(UrWarningMessages.未入力, 要支援2.toString()),
        要支援2入力チェックエラー(DbcErrorMessages.種類支給限度額_要介護状態区分入力不可.getMessage(), 要支援2.toString());
        private final Message message;

        private GetMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        private GetMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
