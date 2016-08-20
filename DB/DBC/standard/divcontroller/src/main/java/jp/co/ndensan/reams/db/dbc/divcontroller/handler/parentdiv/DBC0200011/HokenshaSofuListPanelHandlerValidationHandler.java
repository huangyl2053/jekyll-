/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.HokenshaSofuListPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面入力のチェックHandler。
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class HokenshaSofuListPanelHandlerValidationHandler {

    private final HokenshaSofuListPanelDiv div;
    private static final RString 処理年月 = new RString("処理年月");

    /**
     * コンストラクタです。
     *
     * @param div HokenshaSofuListPanelDiv
     */
    public HokenshaSofuListPanelHandlerValidationHandler(HokenshaSofuListPanelDiv div) {
        this.div = div;
    }

    /**
     * validateFor処理年月未入力チェック
     *
     * @return バリデーション結果 ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor処理年月未入力チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuhorenTorikomiListSpec.必須入力項目_処理年月).
                thenAdd(IdocheckMessages.必須入力項目_処理年月).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder().
                add(IdocheckMessages.必須入力項目_処理年月, div.getBtnHyojisuru()).
                build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<HokenshaSofuListPanelDiv> {

        必須入力項目_処理年月 {
                    @Override
                    public boolean apply(HokenshaSofuListPanelDiv div) {
                        return false;
                    }
                }
    }

    private enum IdocheckMessages implements IValidationMessage {

        必須入力項目_処理年月(UrErrorMessages.必須, 処理年月.toString());
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
