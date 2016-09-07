/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelDiv;
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
 * 受給者異動連絡票（追加）登録です。
 *
 * @reamsid_L DBC-2100-010 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoTorokuPanelValidationHandler {

    private final JukyushaIdoRenrakuhyoTorokuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KubunShikyuGendogakuDiv
     */
    public JukyushaIdoRenrakuhyoTorokuPanelValidationHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
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
                .add(JukyushaIdoRenrakuhyoTorokuPanelValidationMessage.発行日の必須チェック)
                .build();
    }

    private static class ControlValidator {

        private final JukyushaIdoRenrakuhyoTorokuPanelDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div JukyushaIdoRenrakuhyoTorokuPanelDiv
         */
        public ControlValidator(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
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
                    .ifNot(JukyushaIdoRenrakuhyoTorokuPanelSpec.発行日の必須チェック)
                    .thenAdd(JukyushaIdoRenrakuhyoTorokuPanelValidationMessage.発行日の必須チェック)
                    .messages());
            return messages;
        }

    }

    private static enum JukyushaIdoRenrakuhyoTorokuPanelValidationMessage implements IValidationMessage {

        発行日の必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "発行日");

        private final Message message;

        JukyushaIdoRenrakuhyoTorokuPanelValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
