/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.GenmenPanelDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
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
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class GenmenPanelValidationHandler {

    private final GenmenPanelDiv div;
    private static final RString 決定日 = new RString("決定日");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public GenmenPanelValidationHandler(GenmenPanelDiv div) {
        this.div = div;
    }

    /**
     * validateFor決定日が未入力
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor決定日が未入力() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuhorenTorikomiListSpec.必須設定項目_決定日).
                thenAdd(IdocheckMessages.必須設定項目_決定日).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder().
                add(IdocheckMessages.必須設定項目_決定日, div.getTextBoxKette()).
                build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<GenmenPanelDiv> {

        必須設定項目_決定日 {
            @Override
            public boolean apply(GenmenPanelDiv div) {
                return div.getTextBoxKette().getValue() != null;
            }
        }
    }

    private enum IdocheckMessages implements IValidationMessage {

        必須設定項目_決定日(DbzErrorMessages.必須パラメータ未設定, 決定日.toString());
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
