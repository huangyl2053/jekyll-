/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ValueObjectについて、値の妥当性をチェックしたり、その内容をメッセージとして返すことができることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> ValueObjectが保持する型
 */
public interface IValueObjectCheckable<T> {

    /**
     * 引数のvalueObjectに問題がないかを調べます。 問題がなければ{@code true}、問題があれば{@code false}を返します。
     *
     * @param v 調べる対象の値
     * @return 引数の値に、問題がなければ{@code true}、問題があれば{@code false}
     */
    boolean isValid(IValueObject<T> v);

    /**
     * 引数のvalueをチェックした結果、問題があれば、
     * その内容を{@link IValidationMessages message}にaddして返します。
     *
     * @param v 対象のValueObjectの値
     * @param objInfo ValueObjectの情報(messageで用いる)
     * @return 問題点があれば、その内容がaddされた{@link IValidationMessages message}
     */
    IValidationMessages check(IValueObject<T> v, IValueObjectInfo objInfo);
}
