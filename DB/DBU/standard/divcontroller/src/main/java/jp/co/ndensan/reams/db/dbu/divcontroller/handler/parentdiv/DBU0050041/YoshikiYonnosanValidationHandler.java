/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050041;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.YoshikiYonnosanDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.YoshikiYonnosanSpec;
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
 * 介護保険特別会計経理状況登録_様式４の３のチェッククラスです。
 */
public class YoshikiYonnosanValidationHandler {

    /**
     * 報告年度の必須チェック取得処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param div YoshikiYonnosanDiv
     */
    public void 報告年度の必須チェック(ValidationMessageControlPairs validPairs, YoshikiYonnosanDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnosanSpec.報告年度必須チェック)
                .thenAdd(RRVMessages.Validate報告年度必須).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.Validate報告年度必須, div.getYoshikiYonnosanMeisai().getTxtHokokuYM()).build().check(messages));
    }

    /**
     * 前年度以前_合計値チェック_合計２処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param div YoshikiYonnosanDiv
     */
    public void 前年度以前_合計値チェック_合計２(ValidationMessageControlPairs validPairs, YoshikiYonnosanDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnosanSpec.前年度以前_合計値チェック_合計２)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnosanMeisai().getTxtsaishutsugokei()).build().check(messages));
    }

    /**
     * 前年度以前_合計値チェック_合計１処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param div YoshikiYonnosanDiv
     */
    public void 前年度以前_合計値チェック_合計１(ValidationMessageControlPairs validPairs, YoshikiYonnosanDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnosanSpec.前年度以前_合計値チェック_合計１)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnosanMeisai().getTxtshiyohigokei()).build().check(messages));
    }

    /**
     * 今年度_合計値チェック_合計１処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param div YoshikiYonnosanDiv
     */
    public void 今年度_合計値チェック_合計１(ValidationMessageControlPairs validPairs, YoshikiYonnosanDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnosanSpec.今年度_合計値チェック_合計１)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnosanMeisai().getTxtkoshiyohigokei()).build().check(messages));
    }

    /**
     * 今年度_合計値チェック_合計２処理です。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param div YoshikiYonnosanDiv
     */
    public void 今年度_合計値チェック_合計２(ValidationMessageControlPairs validPairs, YoshikiYonnosanDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(YoshikiYonnosanSpec.今年度_合計値チェック_合計２)
                .thenAdd(RRVMessages.入力値が不正).messages());
        validPairs.add(new ValidationMessageControlDictionaryBuilder().add(
                RRVMessages.入力値が不正, div.getYoshikiYonnosanMeisai().getTxtkosaishutsugokei()).build().check(messages));
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate報告年度必須(UrErrorMessages.必須, "報告年度"),
        入力値が不正(UrErrorMessages.入力値が不正);
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
