/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validation.validators.LetterValidator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 文字の種類をチェックできるオブジェクトの列挙です。
 *
 * @author N3327 三浦 凌
 */
public enum CharType implements IValueObjectCheckable<RString> {

    /**
     * 文字列が「半角数のみ」かをチェックします。
     */
    半角数のみ(ValidationMessages.半角数のみ) {

                @Override
                public boolean isValid(IValueObject<RString> v) {
                    return LetterValidator.半角数字のみ().isValid(v);
                }

                @Override
                public IValidationMessages check(IValueObject<RString> value, IValueObjectInfo objInfo) {
                    IValidationMessages messages = ValidationMessagesFactory.createInstance();
                    if (!isValid(value)) {
                        messages.add(getMessage());//, objInfo.getDisplayName().toString(), "半角数字のみ");
                    }
                    return messages;
                }
            },
    /**
     * 文字列が「半角英数のみ」かをチェックします。
     */
    半角英数のみ(ValidationMessages.半角英数のみ) {

                @Override
                public boolean isValid(IValueObject<RString> v) {
                    return LetterValidator.半角英数のみ().isValid(v);
                }

                @Override
                public IValidationMessages check(IValueObject<RString> value, IValueObjectInfo objInfo) {
                    IValidationMessages messages = ValidationMessagesFactory.createInstance();
                    if (!isValid(value)) {
                        messages.add(getMessage());//, objInfo.getDisplayName().toString(), "半角英数のみ");
                    }
                    return messages;
                }
            };
    private final IValidationMessage message;

    private CharType(ValidationMessages message) {
        this.message = message;
    }

    /**
     * バリデーションメッセージを返します。
     *
     * @return バリデーションメッセージ
     */
    protected IValidationMessage getMessage() {
        return this.message;
    }
}
