/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;

/**
 * Listを保持する{@link IItems IItems}です。
 * {@link IItems IItems}に加え、並び替えができる{@link #sorted(java.util.Comparator) sorted()}を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持する要素の型
 */
public interface IItemList<E> extends IItems<E> {

    /**
     * 指定の条件に該当する要素だけを保持する{@link IItemList IItemList}を返します。
     *
     * @param condition 条件
     * @return 指定の条件に該当する要素だけを保持する{@link IItemList IItemList}
     */
    @Override
    IItemList<E> filter(ICondition<? super E> condition);

    /**
     * 保持する要素をすべて{@link IFunction mapper}により変換し、
     * その結果をもった新しい{@link IItemList IItemList}を返します。
     *
     * @param <R> 変換後の{@link IItemList IItemList}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return mapperにより変換された結果を保持した{@link IItemList ItemList}
     */
    @Override
    <R> IItemList<R> map(IFunction<? super E, ? extends R> mapper);

    /**
     * 引数のcomparatorで保持する要素をソートした結果から構成される、新しい{@link IItemList IItemList}を返します。
     *
     * @param comparator ソートに用いるcomparator
     * @return ソート結果から構成される{@link IItemList IItemList}
     */
    IItemList<E> sorted(Comparator<? super E> comparator);

    /**
     * 保持する要素を自然順序順にソートした結果から構成される、新しい{@link IItemList IItemList}を返します。
     * ただし、保持する要素が{@link Comparable Comparable}でない、{@link ClassCastException}がスローされる可能性があります。
     *
     * @return ソート結果から構成される{@link IItemList IItemList}
     */
    IItemList<E> sorted();
}
