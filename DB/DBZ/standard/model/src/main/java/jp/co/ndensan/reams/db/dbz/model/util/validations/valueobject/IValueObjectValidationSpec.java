/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

/**
 * ValueObjectのバリデーションの定義であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> valueObjectの型
 */
public interface IValueObjectValidationSpec<T> {

    /**
     * ValueObjectの情報を返します。
     *
     * @return ValueObjectの情報
     */
    IValueObjectInfo getValueObjectInfo();

    /**
     * ValueObjectに対するチェック項目の一覧を返します。
     *
     * @return ValueObjectに対するチェック項目の一覧
     */
    ValueObjectCheckList<T> getCheckList();
}
