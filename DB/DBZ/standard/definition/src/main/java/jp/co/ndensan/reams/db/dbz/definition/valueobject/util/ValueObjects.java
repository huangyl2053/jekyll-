/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

import java.util.Arrays;
import java.util.List;
import static jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages.不正;
import static jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages.項目に対する制約;
import static jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages.値がnull;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * ValueObjectに関するユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class ValueObjects {

    private ValueObjects() {
    }

//<editor-fold defaultstate="collapsed" desc="    /* ErrorMessage関係 */ ">
    /**
     * exceptionのメッセージに用いる定数群です。
     */
    private enum Literal {

        value("value"),
        length("length"),
        桁("桁");

        private final RString theValue;

        private Literal(String value) {
            this.theValue = new RString(value);
        }

        @Override
        public String toString() {
            return this.theValue.toString();
        }
    }

    /**
     * ValueObjectsがスローするexceptionで用いるメッセージです。
     */
    private enum MyErrorMessages {

        半角数字のみにしろ(項目に対する制約, Literal.value.toString(), "半角数字のみ"),
        半角英数のみにしろ(項目に対する制約, Literal.value.toString(), "半角英数字のみ"),
        桁数が不正だ(不正, Literal.value.toString()),
        lengthは0以上にしろ(項目に対する制約, Literal.length.toString(), "0以上"),
        lengthは1以上にしろ(項目に対する制約, Literal.length.toString(), "1以上");
        private final Message message;
        private final List<String> replaces;

        private MyErrorMessages(IMessageGettable mg, String... replaces) {
            this.replaces = Arrays.asList(replaces);
            this.message = mg.getMessage();
        }

        /**
         * Exceptionの発生原因によるメッセージを返します。
         *
         * @return message
         */
        Message getMessage() {
            return this.message.replace(replaces.toArray(new String[replaces.size()]));
        }
    }

    private static Message createErrorMessageFor(ILengthOfValueMatcher matcher) {
        StringBuilder digits = new StringBuilder().append(matcher.specifiedLength()).append(Literal.桁);
        switch (matcher.type()) {
            case equal:
                return 項目に対する制約.getMessage().replace(Literal.value.toString(), digits.toString());
            case lessThan:
                return 項目に対する制約.getMessage().replace(Literal.value.toString(), digits.append("未満").toString());
            case lessOrEqual:
                return 項目に対する制約.getMessage().replace(Literal.value.toString(), digits.append("以下").toString());
            default:
                return MyErrorMessages.桁数が不正だ.getMessage();
        }
    }

    private static Message createErrorMessageFrom(int specifiedLength, IValidLengthMathcer mathcer) {
        StringBuilder digits = new StringBuilder().append(specifiedLength).append(Literal.桁);
        switch (mathcer.requestType()) {
            case equal:
                return 項目に対する制約.getMessage().replace(Literal.value.name(), digits.toString());
            case lessThan:
                return 項目に対する制約.getMessage().replace(Literal.value.name(), digits.append("超過").toString());
            case lessOrEqual:
                return 項目に対する制約.getMessage().replace(Literal.value.name(), digits.append("以上").toString());
            default:
                return MyErrorMessages.桁数が不正だ.getMessage();
        }
    }
//</editor-fold>

    /**
     * 引数がnullでない場合は引数をそのまま返し、nullの場合は{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     * ValueObjectのコンストラクタにおけるチェックでのみ使用してください。
     *
     * @param <T> 引数の型
     * @param value 検査対象
     * @return 引数がnullでない場合は引数
     * @throws IllegalInitialValueException 引数がnullの場合
     */
    public static <T> T requireNonNull(T value) throws IllegalInitialValueException {
        if (value != null) {
            return value;
        }
        throw new IllegalInitialValueException(値がnull.getReplacedMessage(Literal.value.name()));
    }

    /**
     * 引数のvalueObjectが保持する文字列が半角数字のみかどうかをチェックします。
     * 半角数字のみの場合は引数の値をそのまま返し、そうでない場合は{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param <V> 文字列を保持するvalueObject
     * @param value 検査対象
     * @return 引数のvalueObjectが保持する文字列が半角数字のみの場合は、引数のvalueObjectをそのまま
     * @throws IllegalInitialValueException 引数が保持する値に半角数字以外が含まれる場合
     */
    public static <V extends IValueObject<RString>> V requireHalfSizeNumberOnly(V value) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (RStringUtil.isHalfsizeNumberOnly(value.value())) {
            return value;
        }
        throw new IllegalInitialValueException(MyErrorMessages.半角数字のみにしろ.getMessage());
    }

    /**
     * 引数の文字列が半角数字のみかどうかをチェックします。
     * 半角数字のみの場合は引数の値をそのまま返し、そうでない場合は{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param value 検査対象
     * @return 引数の文字列が半角数字のみの場合は、引数の文字列
     * @throws IllegalInitialValueException 引数が保持する値に半角数字以外が含まれる場合
     */
    public static RString requireHalfSizeNumberOnly(RString value) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (RStringUtil.isHalfsizeNumberOnly(value)) {
            return value;
        }
        throw new IllegalInitialValueException(MyErrorMessages.半角数字のみにしろ.getMessage());
    }

    /**
     * 引数のvalueObjectが保持する文字列が半角英数字のみかどうかをチェックします。
     * 半角英数字のみの場合は引数の値をそのまま返し、そうでない場合は{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param <V> 文字列を保持するvalueObject
     * @param value 検査対象
     * @return 引数のvalueObjectが保持する文字列が半角英数字のみの場合は、引数のvalueObjectをそのまま
     * @throws IllegalInitialValueException 引数が保持する値に半角英数字以外が含まれる場合
     */
    public static <V extends IValueObject<RString>> V requireAlphabetAndHalfsizeNumberOnly(V value) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (RStringUtil.isAlphabetAndHalfsizeNumberOnly(value.value())) {
            return value;
        }
        throw new IllegalInitialValueException(MyErrorMessages.半角英数のみにしろ.getMessage());

    }

    /**
     * 引数の文字列が半角英数字のみかどうかをチェックします。
     * 半角英数字のみの場合は引数の値をそのまま返し、そうでない場合は{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param value 検査対象
     * @return 引数の文字列が半角英数字のみの場合は、引数の文字列
     * @throws IllegalInitialValueException 引数が保持する値に半角英数字以外が含まれる場合
     */
    public static RString requireAlphabetAndHalfsizeNumberOnly(RString value) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (RStringUtil.isAlphabetAndHalfsizeNumberOnly(value)) {
            return value;
        }
        throw new IllegalInitialValueException(MyErrorMessages.半角英数のみにしろ.getMessage());

    }

//<editor-fold defaultstate="collapsed" desc="    public enum LengthCheckType{}">
    /**
     * 文字列の長さチェックの種類です。
     */
    public enum LengthCheckType {

        /**
         * 未満
         */
        lessThan {
                    @Override
                    boolean check(RString rstr, int length) {
                        if (rstr == null) {
                            return true;
                        }
                        return rstr.length() < length;
                    }

                    @Override
                    boolean check(int length, RString rstr) {
                        if (rstr == null) {
                            return true;
                        }
                        return length < rstr.length();
                    }
                },
        /**
         * 同じ
         */
        equal {
                    @Override
                    boolean check(RString rstr, int length) {
                        if (rstr == null) {
                            return true;
                        }
                        return rstr.length() == length;
                    }

                    @Override
                    boolean check(int length, RString rstr) {
                        if (rstr == null) {
                            return true;
                        }
                        return length == rstr.length();
                    }
                },
        /**
         * 以下
         */
        lessOrEqual {
                    @Override
                    boolean check(RString rstr, int length) {
                        if (rstr == null) {
                            return true;
                        }
                        return rstr.length() <= length;
                    }

                    @Override
                    boolean check(int length, RString rstr) {
                        if (rstr == null) {
                            return true;
                        }
                        return length <= rstr.length();
                    }
                };

        abstract boolean check(RString rstr, int length);

        abstract boolean check(int length, RString rstr);
    }
//</editor-fold>

    /**
     * 引数の文字列について、{@link  ILengthOfValueMatcher mather}の内容を満たすかどうかを調べます。
     * matherの内容を満たす場合には検査対象の文字列を返し、満たさない場合には{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param value 文字列
     * @param matcher valueと比較するmather
     * @return matherの内容を満たす場合は、検査対象の文字列
     * @throws IllegalInitialValueException matherの内容を満たさない場合
     */
    public static RString requireLength(RString value, ILengthOfValueMatcher matcher) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (matcher.matchesIn(value)) {
            return value;
        }
        throw new IllegalInitialValueException(createErrorMessageFor(matcher));
    }

    /**
     * 引数のvalueOjbectが保持する文字列について、{@link ILengthOfValueMatcher mather}の内容を満たすかどうかを調べます。
     * matherの内容を満たす場合には検査対象の文字列をもつvalueObjectを返し、満たさない場合には{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param <V> 文字列を保持するvalueObjectの型
     * @param value 文字列を保持するvalueObject
     * @param matcher valueと比較するmather
     * @return matherの内容を満たす場合は、検査対象の文字列をもつvalueObject
     * @throws IllegalInitialValueException matherの内容を満たさない場合
     */
    public static <V extends IValueObject<RString>> V requireLength(V value, ILengthOfValueMatcher matcher) throws IllegalInitialValueException {
        if (value == null) {
            return value;
        }
        if (matcher.matchesIn(value.value())) {
            return value;
        }
        throw new IllegalInitialValueException(createErrorMessageFor(matcher));

    }

    /**
     * 値ベースで、文字列の長さについて判定できることを表します。
     */
    public interface ILengthOfValueMatcher {

        /**
         * 引数の文字列の長さと{@link #specifiedLength() specifiedLength}を比較して、
         * 妥当な場合には{@code true}、そうでない場合には{@code false}を返します。
         *
         * @param v 検査対象の文字列
         * @return 妥当な場合には{@code true}, そうでない場合には{@code false}
         */
        boolean matchesIn(RString v);

        /**
         * 文字列の長さと比較する値です。
         *
         * @return 文字列の長さと比較する値
         */
        int specifiedLength();

        /**
         * 比較の種類を返します。
         *
         * @return 比較の種類
         */
        LengthCheckType type();
    }

//<editor-fold defaultstate="collapsed" desc="    private static class _LengthOfValueMathcher implements ILengthOfValueMatcher{}">
    private static final class _LengthOfValueMathcher implements ILengthOfValueMatcher {

        private final int theLength;
        private final LengthCheckType theType;

        private _LengthOfValueMathcher(int length, LengthCheckType type) {
            this.theLength = length;
            this.theType = type;
        }

        @Override
        public int specifiedLength() {
            return this.theLength;
        }

        @Override
        public LengthCheckType type() {
            return this.theType;
        }

        @Override
        public boolean matchesIn(RString v) {
            return this.theType.check(v, specifiedLength());
        }
    }
//</editor-fold>

    /**
     * 文字列の長さが引数の値と一致するかどうかを調べる{@link ILengthOfValueMatcher matcher}を返します。
     *
     * @param length 文字列に期待する長さの基準
     * @return 文字列の長さが引数の値と一致するかどうかを調べる{@link ILengthOfValueMatcher matcher}
     */
    public static ILengthOfValueMatcher equal(final int length) {
        if (length < 0) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは0以上にしろ.getMessage().evaluate());
        }
        return new _LengthOfValueMathcher(length, LengthCheckType.equal);
    }

    /**
     * 文字列の長さが引数の値より小さいかどうかを調べる{@link ILengthOfValueMatcher matcher}を返します。
     *
     * @param length 文字列に期待する長さの基準
     * @return 文字列の長さが引数の値より小さいかどうかを調べる{@link ILengthOfValueMatcher matcher}
     */
    public static ILengthOfValueMatcher lessThan(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは1以上にしろ.getMessage().evaluate());
        }
        return new _LengthOfValueMathcher(length, LengthCheckType.lessThan);
    }

    /**
     * 文字列の長さが引数の値以下かどうかを調べる{@link ILengthOfValueMatcher matcher}を返します。
     *
     * @param length 文字列に期待する長さの基準
     * @return 文字列の長さが引数の値以下かどうかを調べる{@link ILengthOfValueMatcher matcher}
     */
    public static ILengthOfValueMatcher lessOrEqual(final int length) {
        if (length < 0) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは0以上にしろ.getMessage().evaluate());
        }
        return new _LengthOfValueMathcher(length, LengthCheckType.lessOrEqual);
    }

    /**
     * 引数のlengthについて、{@link IRStringValidLengthMathcher mather}の内容を満たすかどうかを調べます。
     * matherの内容を満たす場合には検査対象の文字列を返し、満たさない場合には{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param length 文字列に期待する長さの基準
     * @param matcher lengthと比較するmather
     * @return matherの内容を満たす場合は、検査対象の文字列
     * @throws IllegalInitialValueException matherの内容を満たさない場合
     * @throws IllegalArgumentException
     * mahterのタイプが{@link LengthCheckType#lessThan lessThan}でlengthが1より小さい時、もしくは、lengthが0より小さい時
     */
    public static RString requireLength(int length, IRStringValidLengthMathcher matcher)
            throws IllegalInitialValueException, IllegalArgumentException {
        if (matcher.requestType() == LengthCheckType.lessThan && length < 1) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは1以上にしろ.getMessage().evaluate());
        }
        if (length < 0) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは0以上にしろ.getMessage().evaluate());
        }
        if (matcher.matches(length)) {
            return matcher.value();
        }
        throw new IllegalInitialValueException(createErrorMessageFrom(length, matcher));
    }

    /**
     * 引数のlengthについて、{@link IRStringValidLengthMathcher mather}の内容を満たすかどうかを調べます。
     * matherの内容を満たす場合には検査対象の文字列をもつvalueObjectを返し、満たさない場合には{@link IllegalInitialValueException IllegalInitialValueException}をスローします。
     *
     * @param <V> 文字列を保持するvalueObject
     * @param length 文字列に期待する長さの基準
     * @param matcher lengthと比較するmather
     * @return matherの内容を満たす場合は、検査対象の文字列をもつvalueObject
     * @throws IllegalInitialValueException matherの内容を満たさない場合
     * @throws IllegalArgumentException
     * mahterのタイプが{@link LengthCheckType#lessThan lessThan}でlengthが1より小さい時、もしくは、lengthが0より小さい時
     */
    public static <V extends IValueObject<RString>> V requireLength(int length, IValueObjectValidLengthMatcher<V> matcher)
            throws IllegalInitialValueException, IllegalArgumentException {
        if (matcher.requestType() == LengthCheckType.lessThan && length < 1) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは1以上にしろ.getMessage().evaluate());
        }
        if (length < 0) {
            throw new IllegalArgumentException(MyErrorMessages.lengthは0以上にしろ.getMessage().evaluate());
        }
        if (matcher.matches(length)) {
            return matcher.value();
        }
        throw new IllegalInitialValueException(createErrorMessageFrom(length, matcher));

    }

    /**
     * 文字列ベースで、文字列の長さについて判定できることを表します。
     *
     * @param <V> 検査対象の型
     */
    private interface IValidLengthMathcer<V> {

        /**
         * 検査対象の文字列を返します。
         *
         * @return 検査対象の文字列
         */
        V value();

        /**
         * 比較の種類を返します。
         *
         * @return 比較の種類
         */
        LengthCheckType requestType();

        /**
         * 引数の文字列の長さと{@link #value() value}の文字列を比較して、
         * 妥当な場合には{@code true}、そうでない場合には{@code false}を返します。
         *
         * @param length 検査対象の文字列の長さ
         * @return 妥当な場合には{@code true}, そうでない場合には{@code false}
         */
        boolean matches(int length);
    }

    /**
     * RStringの長さについて判定できることを表します。
     */
    public interface IRStringValidLengthMathcher extends IValidLengthMathcer<RString> {

        /**
         * 検査対象の文字列を返します。
         *
         * @return 検査対象の文字列
         */
        @Override
        RString value();
    }

//<editor-fold defaultstate="collapsed" desc="    private static class _RStringValidLengthMathcher implements IRStringValidLengthMathcher {}">
    private static final class _RStringValidLengthMathcher implements IRStringValidLengthMathcher {

        private final RString theValue;
        private final LengthCheckType type;

        private _RStringValidLengthMathcher(RString value, LengthCheckType type) {
            this.theValue = value;
            this.type = type;
        }

        @Override
        public RString value() {
            return this.theValue;
        }

        @Override
        public boolean matches(int length) {
            return this.type.check(length, value());
        }

        @Override
        public LengthCheckType requestType() {
            return this.type;
        }
    }
//</editor-fold>

    /**
     * 期待する値と引数の文字列の長さが一致するかどうかを調べる{@link IRStringValidLengthMathcher matcher}を返します。
     *
     * @param value 文字列
     * @return
     * 期待する値と引数の文字列の長さが一致するかどうかを調べる{@link IRStringValidLengthMathcher matcher}
     */
    public static IRStringValidLengthMathcher equal(final RString value) {
        return new _RStringValidLengthMathcher(value, LengthCheckType.equal);
    }

    /**
     * 期待する値が引数の文字列の長さより小さいかどうかを調べる{@link IRStringValidLengthMathcher matcher}を返します。
     *
     * @param value 文字列
     * @return
     * 待する値が引数の文字列の長さより小さいかどうかを調べる{@link IRStringValidLengthMathcher matcher}
     */
    public static IRStringValidLengthMathcher lessThan(final RString value) {
        return new _RStringValidLengthMathcher(value, LengthCheckType.lessThan);
    }

    /**
     * 期待する値が引数の文字列の長さ以下かどうかを調べる{@link IRStringValidLengthMathcher matcher}を返します。
     *
     * @param value 文字列
     * @return
     * 期待する値が引数の文字列の長さ以下かどうかを調べる{@link IRStringValidLengthMathcher matcher}
     */
    public static IRStringValidLengthMathcher lessOrEqual(final RString value) {
        return new _RStringValidLengthMathcher(value, LengthCheckType.lessOrEqual);

    }

    /**
     * {@link RString RString}を保持する{@link IValueObject valueObject}について判定できることを表します。
     *
     * @param <V> {@link RString RString}を保持する{@link IValueObject valueObject}の型
     */
    public interface IValueObjectValidLengthMatcher<V extends IValueObject<RString>> extends IValidLengthMathcer<V> {

        /**
         * 検査対象の{@link RString 文字列}を保持する{@link IValueObject valueObject}を返します。
         *
         * @return 検査対象の{@link RString 文字列}を保持する{@link IValueObject valueObject}
         */
        @Override
        V value();

        /**
         * 引数の文字列の長さと{@link #value() value}が保持する文字列を比較して、
         * 妥当な場合には{@code true}、そうでない場合には{@code false}を返します。
         *
         * @param length 検査対象の文字列の長さ
         * @return 妥当な場合には{@code true}, そうでない場合には{@code false}
         */
        @Override
        boolean matches(int length);

    }

//<editor-fold defaultstate="collapsed" desc="    private static class _ValueObjectValidLengthMatcher implements IValueObjectValidLengthMatcher{}">
    private static final class _ValueObjectValidLengthMatcher<V extends IValueObject<RString>>
            implements IValueObjectValidLengthMatcher<V> {

        private final V theValue;
        private final LengthCheckType type;

        private _ValueObjectValidLengthMatcher(V value, LengthCheckType type) {
            this.theValue = value;
            this.type = type;
        }

        @Override
        public V value() {
            return this.theValue;
        }

        protected RString valueAsRString() {
            if (theValue == null) {
                return null;
            }
            return ((IValueObject<RString>) this.theValue).value();
        }

        @Override
        public boolean matches(int length) {
            return this.type.check(length, valueAsRString());
        }

        @Override
        public LengthCheckType requestType() {
            return this.type;
        }

    }
//</editor-fold>

    /**
     * 期待する値が引数のvalueObjectが持つ文字列の長さと一致するかどうかを調べる{@link IValueObjectValidLengthMatcher matcher}を返します。
     *
     * @param <V> 文字列を持つvalueObjectの型
     * @param value 文字列を持つvalueObject
     * @return
     * 期待する値が引数のvalueObjectが持つ文字列の長さと一致するかどうかを調べる{@link IValueObjectValidLengthMatcher matcher}
     */
    public static <V extends IValueObject<RString>> IValueObjectValidLengthMatcher<V> equal(final V value) {
        return new _ValueObjectValidLengthMatcher<>(value, LengthCheckType.equal);
    }

    /**
     * 期待する値が引数のvalueObjectが持つ文字列の長さより小さいかどうかを調べる{@link IValueObjectValidLengthMatcher matcher}を返します。
     *
     * @param <V> 文字列を持つvalueObjectの型
     * @param value 文字列を持つvalueObject
     * @return
     * 期待する値が引数のvalueObjectが持つ文字列の長さより小さいかどうかを調べる{@link IValueObjectValidLengthMatcher matcher}
     */
    public static <V extends IValueObject<RString>> IValueObjectValidLengthMatcher<V> lessThan(final V value) {
        return new _ValueObjectValidLengthMatcher(value, LengthCheckType.lessThan);
    }

    /**
     * 期待する値が引数のvalueObjectが持つ文字列の長さ以下かどうかを調べる{@link IValueObjectValidLengthMatcher matcher}を返します。
     *
     * @param <V> 文字列を持つvalueObjectの型
     * @param value 文字列を持つvalueObject
     * @return
     * 期待する値が引数のvalueObjectが持つ文字列の長さ以下かどうかを調べる{@link IValueObjectValidLengthMatcher matcher}
     */
    public static <V extends IValueObject<RString>> IValueObjectValidLengthMatcher<V> lessOrEqual(final V value) {
        return new _ValueObjectValidLengthMatcher(value, LengthCheckType.lessOrEqual);
    }
}
