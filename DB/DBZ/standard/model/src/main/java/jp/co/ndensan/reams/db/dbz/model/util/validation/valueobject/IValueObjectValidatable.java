/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ValueObjectに対するバリデーションができることを表します。
 *
 * @author N3327 三浦 凌
 * @param <V>
 */
public interface IValueObjectValidatable<V extends IValueObject> {

    /**
     * 引数のValueObjectをチェックして、{@link IValidationMessages バリデーションメッセージ}を返します。
     *
     * @param v ValueObject
     * @return バリデーションメッセージ
     */
    IValidationMessages validate(V v);
}
