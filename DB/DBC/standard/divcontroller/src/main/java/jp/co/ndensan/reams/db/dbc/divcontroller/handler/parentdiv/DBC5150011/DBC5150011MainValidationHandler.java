/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.DBC5150011MainDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNJ2006_サービスコード一覧表のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class DBC5150011MainValidationHandler {

    private final DBC5150011MainDiv div;
    private static final RString サービス種類コード = new RString("サービス種類コード");
    private static final RString 桁数_2 = new RString("2");
    private static final RString サービス分類を１つ以上 = new RString("サービス分類を１つ以上");
    private static final RString 出力方法 = new RString("出力方法を");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public DBC5150011MainValidationHandler(DBC5150011MainDiv div) {
        this.div = div;
    }

    /**
     * サービス種類コード_桁数チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs サービス種類コード_桁数チェック() {
        IValidationMessages messages = new ControlValidator(div).サービス種類コードvalidate();
        return createサービス種類コードDictionary().check(messages);
    }

    private ValidationDictionary createサービス種類コードDictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBC5150011MainValidationHandler.IdocheckMessages.桁数チェック)
                .build();
    }

    /**
     * サービス分類_指定なしチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs サービス分類_指定なしチェック() {
        IValidationMessages messages = new ControlValidator(div).サービス分類validate();
        return createサービス分類Dictionary().check(messages);
    }

    private ValidationDictionary createサービス分類Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBC5150011MainValidationHandler.IdocheckMessages.サービス分類, div.getDgServiceBunruiList())
                .build();
    }

    /**
     * 出力方法_指定なしチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 出力方法_指定なしチェック() {
        IValidationMessages messages = new ControlValidator(div).出力方法validate();
        return create出力方法Dictionary().check(messages);
    }

    private ValidationDictionary create出力方法Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBC5150011MainValidationHandler.IdocheckMessages.出力方法指定, div.getChkShutsuryokuTaisho())
                .build();
    }

    private static class ControlValidator {

        private final DBC5150011MainDiv div;

        public ControlValidator(DBC5150011MainDiv div) {
            this.div = div;
        }

        /**
         * サービス種類コードバリデーションチェックです。
         *
         * @return バリデーション
         */
        public IValidationMessages サービス種類コードvalidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(DBC5150011MainMainSpec.サービス種類コード_桁数チェック)
                    .thenAdd(IdocheckMessages.桁数チェック)
                    .messages());
            return messages;
        }

        /**
         * サービス分類バリデーションチェックです。
         *
         * @return バリデーション
         */
        public IValidationMessages サービス分類validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(DBC5150011MainMainSpec.サービス分類_指定なしチェック)
                    .thenAdd(IdocheckMessages.サービス分類)
                    .messages());
            return messages;
        }

        /**
         * 出力方法バリデーションチェックです。
         *
         * @return バリデーション
         */
        public IValidationMessages 出力方法validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(DBC5150011MainMainSpec.出力方法_指定なしチェック)
                    .thenAdd(IdocheckMessages.出力方法指定)
                    .messages());
            return messages;
        }
    }

    private static enum IdocheckMessages implements IValidationMessage {

        桁数チェック(UrErrorMessages.桁数が不正, サービス種類コード.toString(), 桁数_2.toString()),
        サービス分類(UrErrorMessages.未指定, サービス分類を１つ以上.toString()),
        出力方法指定(UrErrorMessages.未指定, 出力方法.toString());
        private final Message message;

        IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
