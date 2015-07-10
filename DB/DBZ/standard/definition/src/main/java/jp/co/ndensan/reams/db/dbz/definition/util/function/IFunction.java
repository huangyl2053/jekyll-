/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

/**
 * ひとつのパラメータから、何らかの結果を作る機能を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <T> パラメータの型
 * @param <R> 結果の型
 */
public interface IFunction<T, R> {

    /**
     * ひとつのパラメータをもとに、ひとつの結果を返します。
     *
     * @param t パラメータ
     * @return 結果
     */
    R apply(T t);
}
