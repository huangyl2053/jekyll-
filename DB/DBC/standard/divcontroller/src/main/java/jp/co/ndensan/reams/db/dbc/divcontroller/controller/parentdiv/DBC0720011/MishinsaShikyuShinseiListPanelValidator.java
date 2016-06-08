/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * MishinsaShikyuShinseiListPanelValidator
 *
 * @reamsid_L DBC-0991-030 surun
 */
public class MishinsaShikyuShinseiListPanelValidator implements IValidatable {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;
    private static final RString メッセージ_決定日 = new RString("決定日");

    /**
     * コンストラクタです
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     */
    public MishinsaShikyuShinseiListPanelValidator(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.データ選択のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.決定日のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.決定日のチェック)
                .messages());
        return messages;
    }

    private static enum JutakuKaishuhiShikyuShinseiErrorMessages implements IValidationMessage {

        データ選択のチェック(UrErrorMessages.対象行を選択),
        決定日のチェック(UrErrorMessages.必須項目_追加メッセージあり, メッセージ_決定日.toString());

        private final Message message;

        private JutakuKaishuhiShikyuShinseiErrorMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }
}
