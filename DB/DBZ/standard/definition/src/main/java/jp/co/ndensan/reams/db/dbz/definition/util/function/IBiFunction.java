/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

/**
 * ふたつの引数を受け取って、結果を生成する処理であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 第1引数の型
 * @param <U> 第2引数の型
 * @param <R> 結果の型
 */
public interface IBiFunction<T, U, R> {

    /**
     * 指定された引数に、処理を適用します。
     *
     * @param t 第1引数
     * @param u 第2引数
     * @return 処理の結果
     */
    R apply(T t, U u);
}
