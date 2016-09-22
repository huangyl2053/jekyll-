/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4000011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011MainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC4000011_サービス内容登録のSpecクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class DBC4000011MainValidationHandler {

    private final DBC4000011MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DBC4000011MainDiv
     */
    public DBC4000011MainValidationHandler(DBC4000011MainDiv div) {
        this.div = div;
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBC4000011MainValidationMessage.提供期間の重複)
                .build();
    }

    private static class ControlValidator {

        private final DBC4000011MainDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div DBC4000011MainDiv
         */
        public ControlValidator(DBC4000011MainDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(DBC4000011MainSpec.提供期間の重複チェック)
                    .thenAdd(DBC4000011MainValidationMessage.提供期間の重複)
                    .messages());
            return messages;
        }

    }

    private static enum DBC4000011MainValidationMessage implements IValidationMessage {

        提供期間の重複(UrErrorMessages.期間が重複);

        private final Message message;

        DBC4000011MainValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
