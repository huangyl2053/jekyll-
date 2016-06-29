/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteiinput;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 連絡先情報ののバリデーションクラスです。
 *
 * @author n8235 船山洋介
 */
public class NinteiInputValidator implements IValidatable {

    private final FlexibleDate 有効開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 有効開始年月日 有効開始年月日
     */
    public NinteiInputValidator(FlexibleDate 有効開始年月日) {
        this.有効開始年月日 = 有効開始年月日;

    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        validationMessages.add(
                ValidateChain.validateStart(有効開始年月日)
                .ifNot(NinteiInputSpec.入力がEmptyでないこと)
                .thenAdd(NinteiInputValidationMessage.対象データなし)
                .messages());
        return validationMessages;
    }
}
