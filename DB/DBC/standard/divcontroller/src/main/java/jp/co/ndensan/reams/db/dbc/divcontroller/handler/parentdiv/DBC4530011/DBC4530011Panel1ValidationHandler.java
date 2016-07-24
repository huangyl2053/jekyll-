/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011Panel1Div;
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
 * 高額合算自己負担額補正・支払場所のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public class DBC4530011Panel1ValidationHandler {

    private final DBC4530011Panel1Div div;

    /**
     * コンストラクタです。
     *
     * @param div DBC4530011Panel1Div
     */
    public DBC4530011Panel1ValidationHandler(DBC4530011Panel1Div div) {
        this.div = div;
    }

    /**
     * 入力ェックを行います。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return new ValidationDictionaryBuilder()
                .add(DBC4530011Panel1ValidationMessage.全角桁数超過64位, div.getTxtShiharaiBasho())
                .build().check(messages);
    }

    private static class ControlValidator {

        private final DBC4530011Panel1Div div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div DBC4530011Panel1Div
         */
        public ControlValidator(DBC4530011Panel1Div div) {
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
                    .ifNot(DBC4530011Panel1Spec.全角桁数超過64位の場合)
                    .thenAdd(DBC4530011Panel1ValidationMessage.全角桁数超過64位)
                    .messages());
            return messages;
        }
    }

    private static enum DBC4530011Panel1ValidationMessage implements IValidationMessage {

        全角桁数超過64位(UrErrorMessages.桁数超過, "全角64位");

        private final Message message;

        DBC4530011Panel1ValidationMessage(IMessageGettable message, String... replacements) {
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
