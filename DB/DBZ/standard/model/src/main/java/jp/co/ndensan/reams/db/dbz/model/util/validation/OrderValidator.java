/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation;

import jp.co.ndensan.reams.uz.uza.lang.IOrderComparable;

/**
 * {@link IOrderComparable IOrderComparable}から派生したオブジェクト同士の、前後関係をチェックします。
 * <p>
 * 使用例1：
 * <pre>
 * FlexibleDate ymd1, ymd2;
 *
 * // ymd1 ＜ ymd2 なら true
 * OrderValidator.from(ymd1).after(ymd2).isValid();
 *
 * // ymd1 ≦ ymd2 なら true
 * OrderValidator.from(ymd1).afterOrEquals(ymd2).isValid();
 * </pre>
 * </p>
 * <p>
 * 使用例2：
 * <pre>
 * RDate date1, date2, date3;
 *
 * // date1 ≦ date2 ≦ date3 なら true
 * OrderValidator.from(date1).afterOrEquals(date2).afterOrEquals(date3).isValid();
 *
 * // date1 ＜ date2 ≦ date3 なら true
 * OrderValidator.from(date1).after(date2).afterOrEquals(date3).isValid();
 * </pre>
 * </p>
 * 3件以上の場合も、同じようにメソッドを連結することで、チェックすることができます。
 *
 * @author N3327 三浦 凌
 * @deprecated
 * {@link jp.co.ndensan.reams.ur.urz.model.validations.validators.OrderValidator}を利用してください。
 */
@Deprecated
public final class OrderValidator {

    private OrderValidator() {
    }

    /**
     * {@link IOrderComparable IOrderComparable}から派生したオブジェクトのインスタンスを本来あるべき順序通りに並べた上で、
     * その並びとインスタンスが保持する値同士の関係が正しいかどうかをチェックします。
     *
     * @param <T> {@link IOrderComparable IOrderComparable}から派生した、前後比較可能なオブジェクト
     * @param fromValue (順序の定義としての)最初の値
     * @return 「本来あるべき順序」を定義するためのオブジェクト
     */
    public static <T extends IOrderComparable<T>> IOrderDefiner<T> from(T fromValue) {
        return new _OrderValidator<>(fromValue);
    }

    /**
     * {@link IOrderComparable IOrderComparable}から派生したオブジェクトのインスタンス同士の関係をチェックするために、順序を定義します。
     *
     * @param <T> {@link IOrderComparable IOrderComparable}から派生した、前後比較可能なオブジェクト
     */
    public interface IOrderDefiner<T extends IOrderComparable<T>> {

        /**
         * 前に設定した物よりも、後ろにあるべきオブジェクトを設定します。
         *
         * @param value 前に設定した物よりも、後ろにあるべきオブジェクト
         * @return さらなる順序の定義と、最終的な判定が可能なオブジェクト
         */
        IOrderValidator<T> after(T value);

        /**
         * 前に設定した物と同じか、後ろにあるべきオブジェクトを設定します。
         *
         * @param value 前に設定した物と同じか、後ろにあるべきオブジェクト
         * @return さらなる順序の定義と、最終的な判定が可能なオブジェクト
         */
        IOrderValidator<T> afterOrEquals(T value);
    }

    /**
     * さらなる順序の定義や、その並びと設定したインスタンスが保持する値の関係のチェックを行います。
     *
     * @param <T> {@link IOrderComparable IOrderComparable}から派生した、前後比較可能なオブジェクト
     */
    public interface IOrderValidator<T extends IOrderComparable<T>> extends IOrderDefiner<T> {

        /**
         * 定義した順序と設定された値の関係が、正しい時にはtrue、正しくない時にはfalseを返します。<br/>
         * ただし、nullの物が含まれている場合、nullの前後は「正しい関係」と判定されます。
         *
         * @return 正しい時にはtrue、正しくない時にはfalse
         */
        boolean isValid();

        /**
         * {@link #isValid() isValid()}と反対の結果を返します。<br/>
         * つまり、定義した順序と設定された値の関係が、正しくない時にはtrue、正しい時にはfalseを返します。<br/>
         * nullの扱いも同じです。
         *
         * @return 正しくない時にはtrue、正しい時にはfalse
         */
        boolean isInvalid();
    }

    /**
     * {@link IOrderValidator IOrderValidator}の実装です。
     *
     * @param <T> {@link IOrderComparable IOrderComparable}から派生した、前後比較可能なオブジェクト
     */
    private static final class _OrderValidator<T extends IOrderComparable<T>> implements IOrderValidator<T> {

        private boolean isCorrectOrder;
        private T beforeValue;

        private _OrderValidator(T value) {
            this.beforeValue = value;
            this.isCorrectOrder = true;
        }

        @Override
        public IOrderValidator<T> after(T value) {
            this.isCorrectOrder &= isAfter(value);
            this.beforeValue = value;
            return this;
        }

        private boolean isAfter(T value) {
            return shouldSkipValidation(this.beforeValue, value)
                    ? true
                    : this.beforeValue.isBefore(value);
        }

        @Override
        public IOrderValidator<T> afterOrEquals(T value) {
            this.isCorrectOrder &= isAfterOrEqulas(value);
            this.beforeValue = value;
            return this;
        }

        private boolean isAfterOrEqulas(T value) {
            return shouldSkipValidation(this.beforeValue, value)
                    ? true
                    : this.beforeValue.isBeforeOrEquals(value);
        }

        @Override
        public boolean isValid() {
            return this.isCorrectOrder;
        }

        @Override
        public boolean isInvalid() {
            return !isValid();
        }

        private boolean shouldSkipValidation(T beforeValue, T value) {
            return isNull(beforeValue) || isNull(value);
        }

        private boolean isNull(T obj) {
            return obj == null;
        }
    }
}
