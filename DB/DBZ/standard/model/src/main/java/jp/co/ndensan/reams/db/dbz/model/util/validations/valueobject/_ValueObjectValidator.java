/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationChain;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ValueObjectに対するバリデーションが可能なオブジェクトの基底クラスです。
 *
 * @author N3327 三浦 凌
 * @param <T> ValueObjectが保持する型
 * @param <V> ValueObjectの型
 */
class _ValueObjectValidator<T, V extends IValueObject<T>> implements IValueObjectValidatable<V> {

    private final IValueObjectInfo objInfo;
    private final ValueObjectCheckList<T> checklist;

    _ValueObjectValidator(IValueObjectValidationSpec<T> spec) {
        Objects.requireNonNull(spec);
        this.objInfo = spec.getValueObjectInfo();
        this.checklist = spec.getCheckList();
    }

    @Override
    public IValidationMessages validate(V v) {
        ValidationChain chain = ValidationChain.validateFollowingItems();
        for (IValueObjectCheckable<T> checkItem : this.checklist) {
            chain.then(checkItem.check(v, objInfo));
        }
        return chain.end();
    }
}
