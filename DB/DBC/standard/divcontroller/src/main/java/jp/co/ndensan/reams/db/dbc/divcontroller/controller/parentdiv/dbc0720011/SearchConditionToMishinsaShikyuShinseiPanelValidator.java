/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011;

import jp.co.ndensan.reams.db.dbc.definition.message.jutakukaishuhishikyushinsei.JutakuKaishuhiShikyuShinseiErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelSpec;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * SearchConditionToMishinsaShikyuShinseiPanelValidator
 */
public class SearchConditionToMishinsaShikyuShinseiPanelValidator implements IValidatable {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;

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

}
