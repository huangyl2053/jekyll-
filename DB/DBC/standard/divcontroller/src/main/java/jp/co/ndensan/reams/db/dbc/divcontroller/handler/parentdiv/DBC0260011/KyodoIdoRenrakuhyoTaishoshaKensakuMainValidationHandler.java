/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv;
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
 * 共同処理用受給者訂正連絡票登録（対象者検索）のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationHandler {

    private final KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div;
    private static final RString 異動日または被保番号KEY = new RString("異動日または被保番号");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationHandler(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        this.div = div;
    }

    /**
     * 異動日と被保番号バリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 異動日と被保番号Validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationMessages.関連チェック)
                .build();
    }

    private static class ControlValidator {

        private final KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div;

        public ControlValidator(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
            this.div = div;
        }

        /**
         * 異動日と被保番号バリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KyodoIdoRenrakuhyoTaishoshaKensakuMainSpec.異動日と被保番号の関連チェック)
                    .thenAdd(KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationMessages.関連チェック)
                    .messages());
            return messages;
        }
    }

    private static enum KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationMessages implements IValidationMessage {

        関連チェック(UrErrorMessages.必須項目_追加メッセージあり, 異動日または被保番号KEY.toString());

        private final Message message;

        KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
