/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険料徴収猶予画面
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoJuminKihonValidationHandler {

    private final ChoshuYuyoJuminKihonDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険料徴収猶予画面Div
     */
    public ChoshuYuyoJuminKihonValidationHandler(ChoshuYuyoJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化場合 全賦課履歴情報.表示件数＝0件の場合時、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 賦課情報の存在チェック() {
        IValidationMessages messages = new ControlValidator(div).賦課情報の存在チェック();
        return createDictionary賦課情報の存在チェック().check(messages);
    }

    private ValidationDictionary createDictionary賦課情報の存在チェック() {
        return new ValidationDictionaryBuilder()
                .add(ChoshuYuyoJuminKihonValidationHandler.ChoshuYuyoJuminKihonValidationMessages.賦課情報の存在チェック,
                        div.getChoshuYuyoFukaRirekiAll())
                .build();
    }

    /**
     * 画面初期化場合 納付額を取得して普徴の納付額合計 ≦０円の場合時、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 処理可能チェック() {
        IValidationMessages messages = new ControlValidator(div).処理可能チェック();
        return createDictionary処理可能チェック().check(messages);
    }

    private ValidationDictionary createDictionary処理可能チェック() {
        return new ValidationDictionaryBuilder()
                .add(ChoshuYuyoJuminKihonValidationHandler.ChoshuYuyoJuminKihonValidationMessages.処理可能チェック,
                        div.getChoshuYuyoMain().getFuchoTablePanel().getLblFuchoNofuGakuTotal())
                .build();
    }

    private static class ControlValidator {

        private final ChoshuYuyoJuminKihonDiv div;

        public ControlValidator(ChoshuYuyoJuminKihonDiv div) {
            this.div = div;
        }

        /**
         * 画面初期化場合 全賦課履歴情報.表示件数＝0件の場合時、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 賦課情報の存在チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ChoshuYuyoJuminKihonSpec.エラーチェック)
                    .thenAdd(ChoshuYuyoJuminKihonValidationMessages.賦課情報の存在チェック)
                    .messages());
            return messages;
        }

        /**
         * 画面初期化場合 納付額を取得して普徴の納付額合計 ≦０円の場合時、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 処理可能チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ChoshuYuyoJuminKihonSpec.エラーチェック)
                    .thenAdd(ChoshuYuyoJuminKihonValidationMessages.処理可能チェック)
                    .messages());
            return messages;
        }
    }

    private static enum ChoshuYuyoJuminKihonValidationMessages implements IValidationMessage {

        賦課情報の存在チェック(DbbErrorMessages.賦課情報なし),
        処理可能チェック(DbbErrorMessages.普徴納付額0円);

        private final Message message;

        ChoshuYuyoJuminKihonValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
