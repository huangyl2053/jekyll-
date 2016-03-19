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
 * MishinsaShikyuShinseiListPanelValidator
 */
public class MishinsaShikyuShinseiListPanelValidator implements IValidatable {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;

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
                .messages());
        return messages;
    }
}
