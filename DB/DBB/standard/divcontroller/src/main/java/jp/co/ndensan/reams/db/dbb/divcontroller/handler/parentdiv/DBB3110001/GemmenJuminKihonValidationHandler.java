/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
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
 * 介護保険料減免画面のバリデーションハンドラークラス。
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenJuminKihonValidationHandler {

    private final GemmenJuminKihonDiv div;
    private static final RString 出力対象チェックMESSAGE = new RString("作成帳票を");

    /**
     * コンストラクタです。
     *
     * @param div 介護保険料減免画面Div
     */
    public GemmenJuminKihonValidationHandler(GemmenJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * 「発行する」ボタンをクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 未指定のValidate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.未指定チェック,
                        div.getGemmenPrintinfo().getPrintInfo())
                .build();
    }

    private static class ControlValidator {

        private final GemmenJuminKihonDiv div;

        public ControlValidator(GemmenJuminKihonDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @param 特徴開始通知書Flag boolean
         * @param 決定変更通知書Flag boolean
         * @param 納入通知書Flag boolean
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.未指定)
                    .thenAdd(GemmenJuminKihonValidationMessages.未指定チェック)
                    .messages());
            return messages;
        }

    }

    private static enum GemmenJuminKihonValidationMessages implements IValidationMessage {

        未指定チェック(UrErrorMessages.未指定, 出力対象チェックMESSAGE.toString());
        private final Message message;

        GemmenJuminKihonValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
