/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValidationMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validations.validators.LengthValidator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 文字列の長さをチェックします。
 *
 * @author N3327 三浦 凌
 */
public final class Length implements IValueObjectCheckable<RString> {

    private static final RString PARAM_NAME;
    private static final RString MUST_BE_GREATER_OR_EQUAL_0;
    private static final RString MUST_BE_GREATER_OR_EQUAL_1;

    static {
        PARAM_NAME = new RString("length");
        MUST_BE_GREATER_OR_EQUAL_0 = new RString("0以上");
        MUST_BE_GREATER_OR_EQUAL_1 = new RString("1以上");
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
    private final Type type;
    private final int theLength;

    private Length(Type type, int length) {
        this.type = type;
        this.theLength = length;
    }

    /**
     * 文字列の長さが、引数の数以上かどうかをチェックする Length を生成します。
     *
     * @param length 指定文字数
     * @return 文字列の長さが、引数の数以上かどうかをチェックする Length
     * @throws IllegalArgumentException 引数が0より小さい時
     */
    public static IValueObjectCheckable<RString> greaterOrEqual(int length) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException(
                    UrErrorMessages.項目に対する制約.getMessage()
                    .replace(PARAM_NAME.toString(), MUST_BE_GREATER_OR_EQUAL_0.toString())
                    .evaluate()
            );
        }
        return new Length(Type.GreaterOrEqual, length);
    }

    /**
     * 文字列の長さが、引数と一致するかどうかをチェックする Length を生成します。
     *
     * @param length 指定文字数
     * @return 文字列の長さが、引数と一致するかどうかをチェックする Length
     * @throws IllegalArgumentException 引数が0より小さい時
     */
    public static IValueObjectCheckable<RString> equal(int length) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException(
                    UrErrorMessages.項目に対する制約.getMessage()
                    .replace(PARAM_NAME.toString(), MUST_BE_GREATER_OR_EQUAL_0.toString())
                    .evaluate()
            );
        }
        return new Length(Type.Equal, length);
    }

    /**
     * 文字列の長さが、引数の数以下かどうかをチェックする Length を生成します。
     *
     * @param length 指定文字数
     * @return 文字列の長さが、引数の数以下かどうかをチェックする Length
     * @throws IllegalArgumentException 引数が0より小さい時
     */
    public static IValueObjectCheckable<RString> lessOrEqual(int length) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException(
                    UrErrorMessages.項目に対する制約.getMessage()
                    .replace(PARAM_NAME.toString(), MUST_BE_GREATER_OR_EQUAL_0.toString())
                    .evaluate()
            );
        }
        return new Length(Type.LessOrEqual, length);
    }

    /**
     * 文字列の長さが、引数の数未満かどうかをチェックする Length を生成します。
     *
     * @param length 指定文字数
     * @return 文字列の長さが、引数の数未満かどうかをチェックする Length
     * @throws IllegalArgumentException 引数が0以下の時
     */
    public static IValueObjectCheckable<RString> lessThan(int length) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException(
                    UrErrorMessages.項目に対する制約.getMessage()
                    .replace(PARAM_NAME.toString(), MUST_BE_GREATER_OR_EQUAL_1.toString())
                    .evaluate()
            );
        }
        return new Length(Type.LessThan, length);
    }

    @Override
    public boolean isValid(IValueObject<RString> v) {
        switch (this.type) {
            case GreaterOrEqual:
                return LengthValidator.桁数が以上.isValid(v, theLength);
            case Equal:
                return LengthValidator.桁数が等しい.isValid(v, theLength);
            case LessOrEqual:
                return LengthValidator.桁数が以下.isValid(v, theLength);
            case LessThan:
                return LengthValidator.桁数が未満.isValid(v, theLength);
            default:
                return true;
        }
    }

    @Override
    public IValidationMessages check(IValueObject<RString> v, IValueObjectInfo objInfo) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (!isValid(v)) {
            List<String> replacement = createReplacement(objInfo);
            messages.add(type.getMessage(), replacement.toArray(new String[replacement.size()]));
        }
        return messages;
    }

    private List<String> createReplacement(IValueObjectInfo objInfo) {
        List<String> list = new ArrayList<>();
        switch (this.type) {
            case GreaterOrEqual:
                list.add(objInfo.getName().toString());
                list.add(new StringBuilder().append(objInfo.getUnit().name()).append("以上").toString());
                break;
            case Equal:
                list.add(objInfo.getName().toString());
                list.add(new StringBuilder().append(objInfo.getUnit().name()).toString());
                break;
            case LessOrEqual:
                list.add(objInfo.getName().toString());
                list.add(new StringBuilder().append(objInfo.getUnit().name()).append("以下").toString());
                break;
            case LessThan:
                list.add(objInfo.getName().toString());
                list.add(new StringBuilder().append(objInfo.getUnit().name()).append("未満").toString());
            default:
                break;
        }
        return list;
    }
}
