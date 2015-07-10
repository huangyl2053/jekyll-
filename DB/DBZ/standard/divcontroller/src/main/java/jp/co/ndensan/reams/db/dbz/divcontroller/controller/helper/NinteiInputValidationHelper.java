/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.helper;

import jp.co.ndensan.reams.db.dbz.business.NinteiInputValidator;
import jp.co.ndensan.reams.db.dbz.business.validation.NinteiInputValidationMessage;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定入力のバリデーションマッピングクラスです。
 *
 * @author n8235 船山洋介
 */
public final class NinteiInputValidationHelper {

    private NinteiInputValidationHelper() {
    }

    /**
     * バリデーションを行います。
     *
     * @param txtYukoKaishiYMD 有効開始日
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate有効開始日(TextBoxFlexibleDate txtYukoKaishiYMD) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionary(
                new ValidationMessageControlPair(NinteiInputValidationMessage.対象データなし, txtYukoKaishiYMD));

        IValidationMessages messages = new NinteiInputValidator(txtYukoKaishiYMD.getValue()).validate();

        return dictionary.check(messages);
    }
}
