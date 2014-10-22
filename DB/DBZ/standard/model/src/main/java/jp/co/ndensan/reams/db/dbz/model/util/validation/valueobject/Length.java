/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validations.validators.LengthValidator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
class Length implements IValueObjectCheckable<RString> {

    private final Type type;
    private final int length;

    private Length(Type type, int length) {
        this.type = type;
        this.length = length;
    }

    static IValueObjectCheckable<RString> greaterOrEqual(int length) {
        return new Length(Type.GreaterOrEqual, length);
    }

    static IValueObjectCheckable<RString> equal(int length) {
        return new Length(Type.Equal, length);
    }

    static IValueObjectCheckable<RString> LessOrEqual(int length) {
        return new Length(Type.LessOrEqual, length);
    }

    static IValueObjectCheckable<RString> LessThan(int length) {
        return new Length(Type.LessThan, length);
    }

    @Override
    public boolean isValid(IValueObject<RString> v) {
        switch (this.type) {
            case GreaterOrEqual:
                return LengthValidator.桁数が以上.isValid(v, length);
            case Equal:
                return LengthValidator.桁数が等しい.isValid(v, length);
            case LessOrEqual:
                return LengthValidator.桁数が以下.isValid(v, length);
            case LessThan:
                return LengthValidator.桁数が未満.isValid(v, length);
            default:
                return true;
        }
    }

    @Override
    public IValidationMessages check(IValueObject<RString> v, ValueObjectInfo objInfo) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (!isValid(v)) {
            List<String> replacement = createReplacement(objInfo);
            messages.add(type.getMessage(), replacement.toArray(new String[replacement.size()]));
        }
        return messages;
    }

    private List<String> createReplacement(ValueObjectInfo objInfo) {
        List<String> list = new ArrayList<>();
        switch (this.type) {
            case GreaterOrEqual:
                list.add(objInfo.name().toString());
                list.add(new StringBuilder().append(objInfo.unit().name()).append("以上").toString());
                break;
            case Equal:
                list.add(objInfo.name().toString());
                list.add(new StringBuilder().append(objInfo.unit().name()).toString());
                break;
            case LessOrEqual:
                list.add(objInfo.name().toString());
                list.add(new StringBuilder().append(objInfo.unit().name()).append("以下").toString());
                break;
            case LessThan:
                list.add(objInfo.name().toString());
                list.add(new StringBuilder().append(objInfo.unit().name()).append("未満").toString());
            default:
                break;
        }
        return list;

    }

    private enum Type {

        GreaterOrEqual(ValidationMessages.指定文字数以上),
        Equal(ValidationMessages.指定文字数と一致),
        LessOrEqual(ValidationMessages.指定文字数以下),
        LessThan(ValidationMessages.指定文字数未満);
        private final IValidationMessage message;

        private Type(IValidationMessage message) {
            this.message = message;
        }

        private IValidationMessage getMessage() {
            return this.message;
        }
    }
}
