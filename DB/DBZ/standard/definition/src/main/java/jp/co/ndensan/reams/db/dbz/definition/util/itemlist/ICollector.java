/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;

/**
 * いくつかの要素をある形へ集積する方法の定義であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 集積する元要素の型
 * @param <A> 集積先のオブジェクトの型
 * @param <R> 結果の型
 */
public interface ICollector<T, A, R> {

    /**
     * 集積用のオブジェクトを生成する supplier を返します。
     *
     * @return 集積用のオブジェクトを生成する supplier
     */
    ISupplier<A> container();

    /**
     * 集積用のオブジェクトへ、入力の要素を集積する処理の定義を返します。
     *
     * @return 集積用のオブジェクトへ，入力の要素を集積する処理の定義
     */
    IBiConsumer<A, T> accumulator();

    /**
     * 集積用のオブジェクトを、結果のオブジェクトへ変換する処理の定義を返します。
     *
     * @return 集積用のオブジェクトを、結果のオブジェクトへ変換する処理の定義
     */
    IFunction<A, R> finisher();
}
