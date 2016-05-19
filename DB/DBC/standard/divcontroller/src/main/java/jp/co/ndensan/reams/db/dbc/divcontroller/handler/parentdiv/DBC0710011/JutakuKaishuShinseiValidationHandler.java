/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.JutakuKaishuShinseiDiv;
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
 * バリデーションハンドラークラスです
 *
 * @reamsid_L DBC-0992-100 yebangqiang
 */
public final class JutakuKaishuShinseiValidationHandler {

    private final JutakuKaishuShinseiDiv div;

    private JutakuKaishuShinseiValidationHandler(JutakuKaishuShinseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return バリデーションハンドラークラス
     */
    public static JutakuKaishuShinseiValidationHandler of(JutakuKaishuShinseiDiv div) {
        return new JutakuKaishuShinseiValidationHandler(div);
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
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月が未入力,
                        div.getJutakuKaishuShinseiList().getTxtServiceYM()).build();
    }

    private static class ControlValidator {

        private final JutakuKaishuShinseiDiv div;

        public ControlValidator(JutakuKaishuShinseiDiv div) {
            this.div = div;
        }

        /**
         * 保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JutakuKaishuShinseiSpec.サービス年月が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月が未入力)
                    .messages());
            return messages;
        }
    }

    private static enum JutakuKaishuShinseiJyohoTorokuValidationMessages implements IValidationMessage {

        サービス年月が未入力(UrErrorMessages.必須, "サービス年月");
        private final Message message;

        JutakuKaishuShinseiJyohoTorokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
