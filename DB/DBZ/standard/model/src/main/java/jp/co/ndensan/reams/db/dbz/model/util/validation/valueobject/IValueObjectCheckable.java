/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ValueObject用のバリデーションロジックです。
 *
 * @author N3327 三浦 凌
 */
interface IValueObjectCheckable<T> {

    /**
     *
     * @param v
     * @return
     */
    boolean isValid(IValueObject<T> v);

    /**
     * 引数のvalueをチェックした結果、問題があれば、その内容を{@link IValidationMessages message}にaddして返します。
     *
     * @param v 対象のValueObjectの値
     * @param objInfo ValueObjectの情報(messageで用いる)
     * @return 問題点があれば、その内容がaddされた{@link IValidationMessages message}
     */
    IValidationMessages check(IValueObject<T> v, ValueObjectInfo objInfo);
}
