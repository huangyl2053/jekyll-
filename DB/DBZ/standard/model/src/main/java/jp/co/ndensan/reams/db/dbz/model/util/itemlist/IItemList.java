/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.itemlist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * オブジェクトの集合であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持する要素の型
 */
public interface IItemList<E> extends Iterable<E> {

    /**
     * 保持するすべての値をListとして返します。
     *
     * @return 保持するすべての値のlist
     */
    List<E> asList();

    /**
     * 保持する要素をすべて{@link IFunction mapper}により変換し、
     * その結果をもった新しい{@link IItemList IItemList}を返します。
     *
     * @param <R> 変換後の{@link IItemList IItemList}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return mapperにより変換された結果を保持した{@link IItemList IItemList}
     */
    <R> IItemList<R> map(IFunction<? super E, ? extends R> mapper);

    /**
     * 指定の条件に該当する要素だけを保持する{@link IItemList IItemList}を返します。
     *
     * @param condition 条件
     * @return 指定の条件に該当する要素だけを保持する{@link IItemList IItemList}
     */
    IItemList<E> filter(ICondition<? super E> condition);

    /**
     * 保持する要素がない空のとき{@code true}を返します。
     *
     * @return 保持する要素がないとき{@code true}
     */
    boolean isEmpty();

    /**
     * 保持する要素の数を返します。
     *
     * @return 保持する要素の数
     */
    int size();

    /**
     * 指定の要素を含むかどうかを返します。
     *
     * @param o 含まれるかどうかを調べるオブジェクト
     * @return 含む場合は{@code true}, 含まなければ{@code false}
     */
    boolean contains(Object o);

    /**
     * 指定のcollectionの要素をすべて含むかどうかを返します。
     *
     * @param c 含まれるかどうかを調べるcollection
     * @return すべて含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean containsAll(Collection<?> c);

    /**
     * 指定の{@link IItemList IItemList}の要素をすべて含むかどうかを返します。
     *
     * @param elements 含まれるかどうかを調べる{@link IItemList IItemList}
     * @return すべて含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean containsAll(IItemList<?> elements);

    /**
     * 指定の{@link ICondition IConditon}に該当する要素があるかどうかを返します。
     *
     * @param condition 条件
     * @return {@link ICondition IConditon}に該当する要素があれば{@code true},
     * なければ{@code false}
     */
    boolean anyMatch(ICondition<? super E> condition);

    /**
     * 指定の{@link ICondition IConditon}にすべての要素が該当するかどうかを返します。
     *
     * @param condition 条件
     * @return {@link ICondition IConditon}にすべての要素が該当すれば{@code true},
     * 該当しないものがあれば{@code false}
     */
    boolean allMatch(ICondition<? super E> condition);

    /**
     * 指定の{@link ICondition IConditon}にすべての要素が該当しないかどうかを返します。
     *
     * @param condition 条件
     * @return {@link ICondition IConditon}にすべての要素が該当しなければ{@code true},
     * 該当するものがあれば{@code false}
     */
    boolean noneMatch(ICondition<? super E> condition);

    /**
     * 保持する要素が1件の時{@code true}を返します。
     *
     * @return 保持する要素が1件の時{@code true}, そうでなければ{@code false}
     */
    boolean isJustOne();

    /**
     * 保持する要素が1件の時、そのオブジェクトを保持する{@link IOptional IOptional}を返します。
     * 複数件の要素を保持する時や何も保持していない空の場合は、emptyな{@link IOptional IOptional}を返します。
     *
     * @return {@link IOptional IOptional}
     */
    IOptional<E> findJustOne();

    /**
     * 保持する要素の中で先頭の物を保持する{@link IOptional IOptional}を返します。
     *
     * @return {@link IOptional IOptional}
     */
    IOptional<E> findFirst();

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

    /**
     * 保持する要素を自然順序の逆順にソートした結果から構成される、新しい{@link IItemList IItemList}を返します。
     * ただし、保持する要素が{@link Comparable Comparable}でない、{@link ClassCastException}がスローされる可能性があります。
     *
     * @return ソート結果から構成される{@link IItemList IItemList}
     */
    IItemList<E> reversed();

    /**
     * 指定の要素を追加した、新しい{@link IItemList IItemList}を返します。
     *
     * @param item {@link IItemList IItemList}に追加する要素
     * @return 要素を追加した新しい{@link IItemList IItemList}
     */
    IItemList<E> added(E item);

    /**
     * 指定の要素をすべて追加した、新しい{@link IItemList IItemList}を返します。
     *
     * @param items {@link IItemList IItemList}に追加する要素
     * @return 要素をすべて追加した新しい{@link IItemList IItemList}
     */
    IItemList<E> added(E... items);
}
