/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatableWithContext;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiValidator implements IValidatable {

    private final CheckBoxList 同月過誤分;
    private final CheckBoxList 通常分;
    private final long 出力順;

    public KokuhorenJohoTorikomiValidator(CheckBoxList 同月過誤分, CheckBoxList 通常分, Long 出力順) {
        this.同月過誤分 = 同月過誤分;
        this.通常分 = 通常分;
        this.出力順 = 出力順;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        if (同月過誤分.getSelectedItems().isEmpty() && 通常分.getSelectedItems().isEmpty()) {
            validationMessages.add(DbzErrorMessages.選択されていない);
        }

        return validationMessages;
    }

}
