/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
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
 * 総合事業種類支給限度額登録のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiShikyuGendogakuValidationHandler {

    private final SogojigyoShuruiShikyuGendogakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     */
    public SogojigyoShuruiShikyuGendogakuValidationHandler(SogojigyoShuruiShikyuGendogakuDiv div) {
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
                .add(SogoJigyoKubunShikyuGendogakuValidationMessage.各必須入力項目未入力, div)
                .add(SogoJigyoKubunShikyuGendogakuValidationMessage.適用期間重複入力, div)
                .build().check(messages);
    }

    private static class ControlValidator {

        private final SogojigyoShuruiShikyuGendogakuDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div SogojigyoShuruiShikyuGendogakuDiv
         */
        public ControlValidator(SogojigyoShuruiShikyuGendogakuDiv div) {
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
                    .ifNot(SogojigyoShuruiShikyuGendogakuSpec.各必須入力項目未入力の場合)
                    .thenAdd(SogoJigyoKubunShikyuGendogakuValidationMessage.各必須入力項目未入力)
                    .ifNot(SogojigyoShuruiShikyuGendogakuSpec.適用期間重複入力の場合)
                    .thenAdd(SogoJigyoKubunShikyuGendogakuValidationMessage.適用期間重複入力)
                    .messages());
            return messages;
        }
    }

    private static enum SogoJigyoKubunShikyuGendogakuValidationMessage implements IValidationMessage {

        各必須入力項目未入力(UrErrorMessages.必須, "*が付いてる各項目"),
        適用期間重複入力(UrErrorMessages.期間が重複);

        private final Message message;

        SogoJigyoKubunShikyuGendogakuValidationMessage(IMessageGettable message, String... replacements) {
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
