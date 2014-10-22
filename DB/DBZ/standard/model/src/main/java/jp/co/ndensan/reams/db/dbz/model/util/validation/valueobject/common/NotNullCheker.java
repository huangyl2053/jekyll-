/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * nullでないことをチェックします。
 *
 * @author N3327 三浦 凌
 * @param <T> valueObjectの型
 */
public final class NotNullCheker<T> implements IValueObjectCheckable<T> {

    private static final NotNullCheker<?> INSTANCE;

    static {
        INSTANCE = new NotNullCheker<>();
    }

    /**
     * インスタンスを取得します。
     *
     * @param <T> チェックするvalueObjectが保持する値の型
     * @param clazz チェックするvalueObjectが保持する値のclass
     * @return NotNullChekerのインスタンス
     */
    public static <T> NotNullCheker<T> getInstance(Class<T> clazz) {
        return (NotNullCheker<T>) INSTANCE;
    }

    private NotNullCheker() {
    }

    @Override
    public boolean isValid(IValueObject<T> v) {
        return v != null;
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
