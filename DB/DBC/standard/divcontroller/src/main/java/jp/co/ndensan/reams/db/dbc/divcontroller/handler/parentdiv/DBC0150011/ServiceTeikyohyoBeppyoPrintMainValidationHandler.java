/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
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
 * 画面設計_DBC0150011_サービス提供票別表のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class ServiceTeikyohyoBeppyoPrintMainValidationHandler {

    private final ServiceTeikyohyoBeppyoPrintMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     */
    public ServiceTeikyohyoBeppyoPrintMainValidationHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
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
                .add(ServiceTeikyohyoBeppyoPrintMainValidationMessage.作成年月日必須チェック, div.getTxtSakuseiYmd())
                .add(ServiceTeikyohyoBeppyoPrintMainValidationMessage.自己作成計画年月必須チェック,
                        div.getTxtJikoSakuseiKeikakuYm())
                .build().check(messages);
    }

    private static class ControlValidator {

        private final ServiceTeikyohyoBeppyoPrintMainDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div ServiceTeikyohyoBeppyoPrintMainDiv
         */
        public ControlValidator(ServiceTeikyohyoBeppyoPrintMainDiv div) {
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
                    .ifNot(ServiceTeikyohyoBeppyoPrintMainSpec.作成年月日必須チェックの場合)
                    .thenAdd(ServiceTeikyohyoBeppyoPrintMainValidationMessage.作成年月日必須チェック)
                    .ifNot(ServiceTeikyohyoBeppyoPrintMainSpec.自己作成計画年月必須チェックの場合)
                    .thenAdd(ServiceTeikyohyoBeppyoPrintMainValidationMessage.自己作成計画年月必須チェック)
                    .messages());
            return messages;
        }
    }

    private static enum ServiceTeikyohyoBeppyoPrintMainValidationMessage implements IValidationMessage {

        作成年月日必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "作成年月日"),
        自己作成計画年月必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "自己作成計画年月");

        private final Message message;

        ServiceTeikyohyoBeppyoPrintMainValidationMessage(IMessageGettable message, String... replacements) {
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
