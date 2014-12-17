/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

/**
 * 検査対象がある条件を満たすかどうかを調べる機能を持つことを、表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 検査対象の型
 */
public interface IPredicate<T> {

    /**
     * 引数をチェックして、{@code true} か{@code flase}を返します。
     *
     * @param t 検査対象
     * @return {@code true} か{@code flase}
     */
    boolean evaluate(T t);
}
