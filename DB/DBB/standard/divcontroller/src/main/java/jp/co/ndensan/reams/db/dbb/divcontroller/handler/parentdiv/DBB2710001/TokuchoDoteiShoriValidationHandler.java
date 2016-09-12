/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.TokuchoDoteiShoriDiv;
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
 * 画面設計_DBBGM81002_1_特徴対象者同定（一括）のバリデーションハンドラークラス
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class TokuchoDoteiShoriValidationHandler {

    private static final RString 処理続行不可メッセージ = new RString("処理対象");

    private final TokuchoDoteiShoriDiv div;

    /**
     * コンストラクタ
     *
     * @param div TokuchoDoteiShoriDiv
     */
    public TokuchoDoteiShoriValidationHandler(TokuchoDoteiShoriDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TokuchoDoteiShoriValidationMessages.処理続行不可のチェック)
                .build();
    }

    private static class ControlValidator {

        private final TokuchoDoteiShoriDiv div;

        public ControlValidator(TokuchoDoteiShoriDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TokuchoDoteiShoriSpec.処理続行不可)
                    .thenAdd(TokuchoDoteiShoriValidationMessages.処理続行不可のチェック)
                    .messages());
            return messages;
        }

    }

    private static enum TokuchoDoteiShoriValidationMessages implements IValidationMessage {

        処理続行不可のチェック(UrErrorMessages.存在しない, 処理続行不可メッセージ.toString());
        private final Message message;

        TokuchoDoteiShoriValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
