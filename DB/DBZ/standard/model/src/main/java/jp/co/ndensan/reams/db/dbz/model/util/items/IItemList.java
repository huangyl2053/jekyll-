/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;

/**
 * Listを保持する{@link IItems IItems}です。
 * {@link IItems IItems}に加え、comparatorによる並び替えができる{@link #sortBy(java.util.Comparator) sortBy()}を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持する要素の型
 */
public interface IItemList<E> extends IItems<E> {

    /**
     * 保持する要素をすべて{@link IFunction IFunction}により変換し、
     * その結果をもった新しい{@link IItemList IItemList}を返します。
     *
     * @param <R> 変換後の{@link IItemList IItemList}が保持する型
     * @param mapper 変換に用いる{@link IFunction IFunction}
     * @return applyerにより変換された結果を保持した{@link IItemList ItemList}
     */
    @Override
    <R> IItemList<R> map(IFunction<? super E, ? extends R> mapper);

    /**
     * 引数のcomparatorで保持する要素をソートした結果を、新しい{@link IItems IItems}として返します。
     *
     * @param comparator ソートに用いるcomparator
     * @return ソート結果の{@link IItems IItems}
     */
    IItemList<E> sortBy(Comparator<? super E> comparator);
}
