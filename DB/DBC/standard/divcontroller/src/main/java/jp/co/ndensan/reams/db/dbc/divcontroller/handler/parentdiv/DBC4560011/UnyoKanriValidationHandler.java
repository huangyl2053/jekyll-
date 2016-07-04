/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4560011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.UnyoKanriDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（利用者負担割合）のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class UnyoKanriValidationHandler {

    private final UnyoKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div UnyoKanriDiv
     */
    public UnyoKanriValidationHandler(UnyoKanriDiv div) {
        this.div = div;
    }

    /**
     * 入力ェックを行います。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {

        IValidationMessages messages = new ControlValidator(div).validate();
        return new ValidationDictionaryBuilder().add(UnyoKanriValidationMessage.更新対象のデータがない)
                .build().check(messages);
    }

    private static class ControlValidator {

        private final UnyoKanriDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div UnyoKanriDiv
         */
        public ControlValidator(UnyoKanriDiv div) {
            this.div = div;
        }

        /**
         * 入力チェックを行います。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(UnyoKanriSpec.変更内容がない)
                    .thenAdd(UnyoKanriValidationMessage.更新対象のデータがない)
                    .messages());
            return messages;
        }
    }

    private static enum UnyoKanriValidationMessage implements IValidationMessage {

        更新対象のデータがない(UrErrorMessages.更新対象のデータがない);

        private final Message message;

        UnyoKanriValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        /**
         * メッセージ取得を行います。
         *
         * @return メッセージ
         */
        @Override
        public Message getMessage() {
            return message;
        }
    }
}
