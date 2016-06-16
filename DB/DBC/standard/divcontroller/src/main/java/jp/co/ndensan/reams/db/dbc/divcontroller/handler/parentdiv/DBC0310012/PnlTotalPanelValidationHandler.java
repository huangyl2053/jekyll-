/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
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
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録画面入力のチェックHandler。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
public class PnlTotalPanelValidationHandler {

    private final PnlTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div PnlTotalPanelDiv
     */
    public PnlTotalPanelValidationHandler(PnlTotalPanelDiv div) {
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
                .add(PnlTotalPanelValidationMessages.金額不整合チェック,
                        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku(),
                        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku())
                .build();
    }

    private static class ControlValidator {

        private final PnlTotalPanelDiv div;

        public ControlValidator(PnlTotalPanelDiv div) {
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
                    .ifNot(PnlTotalPanelSpec.金額)
                    .thenAdd(PnlTotalPanelValidationMessages.金額不整合チェック)
                    .messages());
            return messages;
        }
    }

    private static enum PnlTotalPanelValidationMessages implements IValidationMessage {

        金額不整合チェック(UrErrorMessages.入力値が不正);
        private final Message message;

        PnlTotalPanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
