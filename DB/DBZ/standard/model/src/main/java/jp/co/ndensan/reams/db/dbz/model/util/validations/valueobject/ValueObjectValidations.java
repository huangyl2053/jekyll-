/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import java.util.Objects;
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
     * @param spec バリデーションの定義
     * @return 指定の定義から生成した、指定のValueObjectに対するバリデーション
     */
    public static <T, V extends IValueObject<T>> IValueObjectValidatable<V>
            createValidationFor(Class<V> clazz, IValueObjectValidationSpec<T> spec) {
        return new _ValueObjectValidator<>(Objects.requireNonNull(spec));
    }
}
