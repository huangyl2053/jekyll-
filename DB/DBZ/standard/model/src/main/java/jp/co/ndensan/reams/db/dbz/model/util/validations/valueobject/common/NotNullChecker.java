/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * nullでないことをチェックします。
 *
 * @author N3327 三浦 凌
 * @param <T> valueObjectの型
 */
public final class NotNullChecker<T> implements IValueObjectCheckable<T> {

    private static final NotNullChecker<?> INSTANCE;

    static {
        INSTANCE = new NotNullChecker<>();
    }

    /**
     * インスタンスを取得します。
     *
     * @param <T> チェックするvalueObjectが保持する値の型
     * @param clazz チェックするvalueObjectが保持する値のclass
     * @return NotNullCheckerのインスタンス
     */
    public static <T> NotNullChecker<T> getInstance(Class<T> clazz) {
        return (NotNullChecker<T>) INSTANCE;
    }

    private NotNullChecker() {
    }

    @Override
    public boolean isValid(IValueObject<T> v) {
        if (v == null) {
            return false;
        }
        return v.value() != null;
    }

    @Override
    public IValidationMessages check(IValueObject<T> v, IValueObjectInfo objInfo) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (!isValid(v)) {
            messages.add(ValidationMessages.必須入力項目, objInfo.getName().toString());
        }
        return messages;
    }
}
