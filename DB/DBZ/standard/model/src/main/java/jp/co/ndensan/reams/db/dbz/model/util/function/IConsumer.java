/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function;

/**
 * ひとつの引数を受け取って結果を返さない処理を表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 入力の型
 */
public interface IConsumer<T> {

    /**
     * 指定の値で処理を実行します。
     *
     * @param t 入力値
     */
    void accept(T t);
}
