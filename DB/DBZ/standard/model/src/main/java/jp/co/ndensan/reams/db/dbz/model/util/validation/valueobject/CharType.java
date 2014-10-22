/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validations.validators.LetterValidator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
enum CharType implements IValueObjectCheckable<RString> {

    半角数のみ(ValidationMessages.半角数のみ) {

                @Override
                public boolean isValid(IValueObject<RString> v) {
                    return LetterValidator.半角数字のみ.isValid(v);
                }

                @Override
                public IValidationMessages check(IValueObject<RString> value, ValueObjectInfo objInfo) {
                    IValidationMessages messages = ValidationMessagesFactory.createInstance();
                    if (!isValid(value)) {
                        messages.add(ValidationMessages.半角数のみ, objInfo.name().toString(), "半角数字のみ");
                    }
                    return messages;
                }
            },
    半角英数のみ(ValidationMessages.半角英数のみ) {

                final RString description;

                {
                    description = new RString("半角英数のみ");
                }

                @Override
                public boolean isValid(IValueObject<RString> v) {
                    return LetterValidator.半角英数のみ.isValid(v);
                }

                @Override
                public IValidationMessages check(IValueObject<RString> value, ValueObjectInfo objInfo) {
                    IValidationMessages messages = ValidationMessagesFactory.createInstance();
                    if (!isValid(value)) {
                        messages.add(ValidationMessages.半角英数のみ, objInfo.name().toString(), "半角英数のみ");
                    }
                    return messages;
                }
            };
    protected final IValidationMessage message;

    private CharType(ValidationMessages message) {
        this.message = message;
    }
}
