/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectInfo.IValueObjectInfoBuilder;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ValueObjectに対するバリデーションを取得します。
 *
 * @author N3327 三浦 凌
 */
public final class ValueObjectValidations {

    private ValueObjectValidations() {
    }

    /**
     * 指定のValueObjectに対するバリデーションを、指定の定義から生成します。
     *
     * @param <T> ValueObjectが保持する値の型
     * @param <V> ValueObjectの型
     * @param clazz ValueObjectのclass
     * @return 指定の定義から生成した、指定のValueObjectに対するバリデーション
     */
    public static <T, V extends IValueObject<T>> IValueObjectValidators<T, V> createFor(Class<V> clazz) {
        return new _ValueObjectValidatiorBuilder<>();
    }

    /**
     * ValueObjectに対して、どのようなチェックを行うかを定義した{@link IValueObjectValidationSpec IValueObjectValidationSpec}を指定して、
     * それを用いたバリデーションチェックを行う{@link IValueObjectValidatable IValueObjectValidatable}のインスタンスを生成する機能を持ちます。
     *
     * @param <T> ValueObjectが保持する値の型
     * @param <V> ValueObjectの型
     */
    public interface IValueObjectValidators<T, V extends IValueObject<T>> {

        /**
         * 指定した内容のバリデーションチェックを行う{@link IValueObjectValidatable IValueObjectValidatable}のインスタンスを生成し返します。
         *
         * @param spec バリデーションの定義
         * @return バリデーションロジック
         */
        IValueObjectValidatable<V> spec(IValueObjectValidationSpec<T> spec);

        /**
         * 指定した内容のバリデーションチェックを行う{@link IValueObjectValidatable IValueObjectValidatable}のインスタンスを生成し返します。
         *
         * @param builder
         * {@link IValueObjectInfoBuilder ValueObjectの情報を生成するビルダー}
         * @param checkList {@link ValueObjectCheckList チェックリスト}
         * @return バリデーションロジック
         */
        IValueObjectValidatable<V> spec(IValueObjectInfoBuilder builder, ValueObjectCheckList<T> checkList);

        /**
         * 指定した内容のバリデーションチェックを行う{@link IValueObjectValidatable IValueObjectValidatable}のインスタンスを生成し返します。
         *
         * @param name ValueObjectの名前
         * @param unit ValueObjectの桁(の表現)
         * @param checkList {@link ValueObjectCheckList チェックリスト}
         * @return バリデーションロジック
         */
        IValueObjectValidatable<V> spec(String name, Unit unit, ValueObjectCheckList<T> checkList);
    }

    private static class _ValueObjectValidatiorBuilder<T, V extends IValueObject<T>>
            implements IValueObjectValidators<T, V> {

        @Override
        public IValueObjectValidatable<V> spec(IValueObjectValidationSpec<T> spec) {
            return new _ValueObjectValidator<>(spec);
        }

        @Override
        public IValueObjectValidatable<V> spec(IValueObjectInfoBuilder builder, ValueObjectCheckList<T> checkList) {
            IValueObjectInfo info = Objects.requireNonNull(builder).build();
            IValueObjectValidationSpec<T> spec = new _ValueObjecValidationSpec<>(info, Objects.requireNonNull(checkList));
            return new _ValueObjectValidator<>(spec);
        }

        @Override
        public IValueObjectValidatable<V> spec(String name, Unit unit, ValueObjectCheckList<T> checkList) {
            IValueObjectInfo info = ValueObjectInfo.of(name, unit);
            IValueObjectValidationSpec<T> spec = new _ValueObjecValidationSpec<>(info, Objects.requireNonNull(checkList));
            return new _ValueObjectValidator<>(spec);
        }
    }

    private static class _ValueObjecValidationSpec<T> implements IValueObjectValidationSpec<T> {

        private final IValueObjectInfo info;
        private final ValueObjectCheckList<T> checkList;

        private _ValueObjecValidationSpec(IValueObjectInfo info, ValueObjectCheckList<T> checkList) {
            this.info = info;
            this.checkList = checkList;
        }

        @Override
        public IValueObjectInfo getValueObjectInfo() {
            return this.info;
        }

        @Override
        public ValueObjectCheckList<T> getCheckList() {
            return this.checkList;
        }
    }
}
