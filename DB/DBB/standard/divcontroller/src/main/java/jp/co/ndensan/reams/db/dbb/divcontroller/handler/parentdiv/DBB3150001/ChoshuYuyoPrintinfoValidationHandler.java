/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
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
 * 画面設計_DBBGM62001_1_更新結果確認
 *
 * @reamsid_L DBB-1680-050 lihang
 */
public class ChoshuYuyoPrintinfoValidationHandler {

    private final ChoshuYuyoJuminKihonDiv div;
    private static final RString 出力対象チェックMESSAGE = new RString("作成帳票を");

    /**
     * コンストラクタです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     */
    public ChoshuYuyoPrintinfoValidationHandler(ChoshuYuyoJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * 「発行する」ボタンをクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 未指定のValidate() {
        IValidationMessages messages = new ChoshuYuyoPrintinfoValidationHandler.ControlValidator(div).validate未指定();
        return createDictionary未指定().check(messages);
    }

    private ValidationDictionary createDictionary未指定() {
        return new ValidationDictionaryBuilder()
                .add(ChoshuYuyoPrintinfoValidationHandler.ChoshuYuyoJuminKihonValidationMessages.未指定チェック,
                        div.getChoshuYuyoPrintinfo().getPritPublish1())
                .build();
    }

    private static class ControlValidator {

        private final ChoshuYuyoJuminKihonDiv div;

        public ControlValidator(ChoshuYuyoJuminKihonDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate未指定() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ChoshuYuyoPrintinfoSpec.未指定)
                    .thenAdd(ChoshuYuyoPrintinfoValidationHandler.ChoshuYuyoJuminKihonValidationMessages.未指定チェック)
                    .messages());
            return messages;
        }
    }

    private static enum ChoshuYuyoJuminKihonValidationMessages implements IValidationMessage {

        未指定チェック(UrErrorMessages.未指定, 出力対象チェックMESSAGE.toString());
        private final Message message;

        ChoshuYuyoJuminKihonValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
