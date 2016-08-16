/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011.JikoFutangakuKeisanIkkatsuPanelDiv;
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
 * 画面設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のクラスです。
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
public class JikoFutangakuKeisanIkkatsuPanelValidationHandler {
     private final JikoFutangakuKeisanIkkatsuPanelDiv div;
      private static final RString 出力順 = new RString("出力順");
    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public JikoFutangakuKeisanIkkatsuPanelValidationHandler(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        this.div = div;
    }

    /**
     * validateFor出力順未設定チェック
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor出力順未設定チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuhorenTorikomiListSpec.必須設定項目_出力順).
                thenAdd(IdocheckMessages.必須設定項目_出力順).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder().
                add(IdocheckMessages.必須設定項目_出力順, div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish()).
                build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<JikoFutangakuKeisanIkkatsuPanelDiv> {

        必須設定項目_出力順 {
                    @Override
                    public boolean apply(JikoFutangakuKeisanIkkatsuPanelDiv div) {
                       return div.getCcdChohyoShutsuryokujun().get出力順ID() != null 
                               && div.getCcdChohyoShutsuryokujun().get出力順ID() != 0;
                    }
        }
    }

    private enum IdocheckMessages implements IValidationMessage {

        必須設定項目_出力順(UrErrorMessages.出力順序を指定);
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
