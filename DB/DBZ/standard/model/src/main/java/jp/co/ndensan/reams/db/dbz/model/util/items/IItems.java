/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.Collection;
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
public interface IItems<E> extends Iterable<E> {

    /**
     * 保持するすべての値をListとして返します。
     *
     * @return 保持するすべての値のlist
     */
    List<E> asList();

    /**
     * 保持する要素をすべて{@link IFunction mapper}により変換し、
     * その結果をもった新しい{@link IItems IItems}を返します。
     *
     * @param <R> 変換後の{@link IItems IItems}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return mapperにより変換された結果を保持した{@link IItems IItems}
     */
    <R> IItems<R> map(IFunction<? super E, ? extends R> mapper);

    /**
     * 指定の条件に該当する要素だけを保持する{@link IItems IItems}を返します。
     *
     * @param condition 条件
     * @return 指定の条件に該当する要素だけを保持する{@link IItems IItems}
     */
    IItems<E> filter(ICondition<? super E> condition);

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
     * 指定の{@link IItems items}の要素をすべて含むかどうかを返します。
     *
     * @param items 含まれるかどうかを調べる{@link IItems items}
     * @return すべて含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean containsAllItems(IItems<?> items);

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
}
