/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

/**
 * ふたつの同じ型の引数を受け取って、同じ型の結果を返す処理です。
 *
 * @author N3327 三浦 凌
 * @param <T> 入力と結果の型
 */
public interface IBinaryOperator<T> extends IBiFunction<T, T, T> {
}
