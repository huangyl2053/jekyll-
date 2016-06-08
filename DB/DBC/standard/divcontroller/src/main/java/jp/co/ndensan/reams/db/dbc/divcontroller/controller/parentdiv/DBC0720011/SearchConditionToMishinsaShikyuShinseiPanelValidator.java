/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
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
 * SearchConditionToMishinsaShikyuShinseiPanelValidator
 *
 * @reamsid_L DBC-0991-030 surun
 */
public class SearchConditionToMishinsaShikyuShinseiPanelValidator implements IValidatable {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;
    private static final RString メッセージ_申請日 = new RString("支給申請日（FROM)と支給申請日（TO)");
    private static final RString メッセージ_申請日FROM = new RString("支給申請日（FROM)");
    private static final RString メッセージ_申請日TO = new RString("支給申請日（TO)");

    /**
     * コンストラクタです
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     */
    public SearchConditionToMishinsaShikyuShinseiPanelValidator(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.支給申請日入力)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの必須チェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.支給申請日有効性)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの有効性チェック)
                .messages());
        return messages;
    }

    private static enum JutakuKaishuhiShikyuShinseiErrorMessages implements IValidationMessage {

        支給申請日FROMと支給申請日TOの必須チェック(UrErrorMessages.必須項目_追加メッセージあり, メッセージ_申請日.toString()),
        支給申請日FROMと支給申請日TOの有効性チェック(DbzErrorMessages.期間が不正_未来日付不可, メッセージ_申請日FROM.toString(),
                メッセージ_申請日TO.toString());

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
