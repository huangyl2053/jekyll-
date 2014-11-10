/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 *
 * @author N3327 三浦 凌
 */
public class ValueObjectValidations {

    private ValueObjectValidations() {
    }

    public static <T, V extends IValueObject<T>> IValueObjectValidatable<V> createValidationFor(Class<V> clazz, IValueObjectValidationSpec<T> spec) {
        return new _ValueObjectValidator<>(spec);
    }
}
