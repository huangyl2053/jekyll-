/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
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
 * サービス種類登録ValidationHandlerです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuValidationHandler {

    private final KubunShikyuGendogakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KubunShikyuGendogakuDiv
     */
    public KubunShikyuGendogakuValidationHandler(KubunShikyuGendogakuDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KubunShikyuGendogakuValidationMessage.各項目が未入力の場合)
                .add(KubunShikyuGendogakuValidationMessage.適用期間が一部でも重複する場合)
                .build();
    }

    private static class ControlValidator {

        private final KubunShikyuGendogakuDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public ControlValidator(KubunShikyuGendogakuDiv div) {
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
                    .ifNot(KubunShikyuGendogakuSpec.必須入力項目の必須入力チェック場合)
                    .thenAdd(KubunShikyuGendogakuValidationMessage.各項目が未入力の場合)
                    .ifNot(KubunShikyuGendogakuSpec.重複の入力チェック)
                    .thenAdd(KubunShikyuGendogakuValidationMessage.適用期間が一部でも重複する場合)
                    .messages());
            return messages;
        }

    }

    private static enum KubunShikyuGendogakuValidationMessage implements IValidationMessage {

        適用期間が一部でも重複する場合(UrErrorMessages.期間が重複),
        各項目が未入力の場合(UrErrorMessages.必須, "*が付いてる各項目");

        private final Message message;

        KubunShikyuGendogakuValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
