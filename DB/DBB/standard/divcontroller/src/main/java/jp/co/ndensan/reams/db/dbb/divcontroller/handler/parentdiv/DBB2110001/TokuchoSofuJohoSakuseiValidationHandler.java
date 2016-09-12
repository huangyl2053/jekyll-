/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiDiv;
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
 * 画面設計_DBBGM82001_1_特徴送付情報作成のバリデーションハンドラークラス
 *
 * @reamsid_L DBB-1840-010 zhangrui
 */
public class TokuchoSofuJohoSakuseiValidationHandler {

    private static final RString 処理対象月メッセージ = new RString("処理対象月");

    private final TokuchoSofuJohoSakuseiDiv div;

    /**
     * コンストラクタ
     *
     * @param div TokuchoSofuJohoSakuseiDiv
     */
    public TokuchoSofuJohoSakuseiValidationHandler(TokuchoSofuJohoSakuseiDiv div) {
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
                .add(TokuchoSofuJohoSakuseiValidationMessages.処理対象月のチェック, div.getTbldgTokuchoIdoJoho())
                .build();
    }

    private static class ControlValidator {

        private final TokuchoSofuJohoSakuseiDiv div;

        public ControlValidator(TokuchoSofuJohoSakuseiDiv div) {
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
                    .ifNot(TokuchoSofuJohoSakuseiSpec.処理対象月)
                    .thenAdd(TokuchoSofuJohoSakuseiValidationMessages.処理対象月のチェック)
                    .messages());
            return messages;
        }

    }

    private static enum TokuchoSofuJohoSakuseiValidationMessages implements IValidationMessage {

        処理対象月のチェック(UrErrorMessages.選択されていない, 処理対象月メッセージ.toString());
        private final Message message;

        TokuchoSofuJohoSakuseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
