/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

/**
 * ふたつの引数を受け取って、結果を返さない処理であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 第1引数の型
 * @param <U> 第2引数の型
 */
public interface IBiConsumer<T, U> {

    /**
     * 処理を実行します。
     *
     * @param t 第1引数
     * @param u 第2引数
     */
    void accept(T t, U u);
}
