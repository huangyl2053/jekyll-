/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB5140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.NoufuGakuDataSakuseiDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 納付額データ作成Divのハンドラクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuGakuDataSakuseiValidationHandler {

    private final NoufuGakuDataSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     *
     * @param div NoufuGakuDataSakuseiDiv
     */
    public NoufuGakuDataSakuseiValidationHandler(NoufuGakuDataSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 単一チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate単一チェック() {
        IValidationMessages message = new ControlValidator(div).validate単一チェック();
        return create単一チェックDictionary().check(message);
    }

    private ValidationDictionary create単一チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NoufuGakuDataSakuseiValidationMessages.抽出終了日_12月31日補正の範囲チェック)
                .build();
    }

    /**
     * 単一チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate広域チェック() {
        IValidationMessages message = new ControlValidator(div).validate広域チェック();
        return create広域チェックDictionary().check(message);
    }

    private ValidationDictionary create広域チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NoufuGakuDataSakuseiValidationMessages.抽出終了日_12月31日補正の範囲チェック)
                .build();
    }

    private static class ControlValidator {

        private final NoufuGakuDataSakuseiDiv div;

        public ControlValidator(NoufuGakuDataSakuseiDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate単一チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NoufuGakuDataSakuseiSpec.単一チェック)
                    .thenAdd(NoufuGakuDataSakuseiValidationMessages.抽出終了日_12月31日補正の範囲チェック)
                    .messages());
            return messages;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate広域チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NoufuGakuDataSakuseiSpec.広域チェック)
                    .thenAdd(NoufuGakuDataSakuseiValidationMessages.抽出終了日_12月31日補正の範囲チェック)
                    .messages());
            return messages;
        }

    }

    private static enum NoufuGakuDataSakuseiValidationMessages implements IValidationMessage {

        抽出終了日_12月31日補正の範囲チェック(UrErrorMessages.項目に対する制約, "補正の設定値", "-99 ～ +99 までの範囲");
        private final Message message;

        NoufuGakuDataSakuseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
