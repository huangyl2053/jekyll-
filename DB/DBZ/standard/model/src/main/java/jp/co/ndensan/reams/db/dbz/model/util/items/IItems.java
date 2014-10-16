/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.Collection;
import java.util.List;
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
     * 保持する要素が空のとき{@code true}を返します。
     *
     * @return 保持する要素が空のとき{@code true}, そうでなければ{@code false}
     */
    boolean isEmpty();

    /**
     * 保持する要素の数を返します。
     *
     * @return 保持する要素の数
     */
    int size();

    /**
     * 引数の要素を含むかどうかを返します。
     *
     * @param o 探索対象
     * @return 含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean contains(Object o);

    /**
     * 引数のcollectionの要素をすべて含むかどうかを返します。
     *
     * @param c 探索対象のcollection
     * @return 含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean containsAll(Collection<?> c);

    /**
     * 引数のitemsの要素をすべて含むかどうかを返します。
     *
     * @param items 探索するIItems
     * @return 含む場合は{@code true}, そうでなければ{@code false}
     */
    boolean containsAllItems(IItems<?> items);

    /**
     * 保持する要素が1件の時{@code true}を返します。
     *
     * @return 保持する要素が1件の時{@code true}, そうでなければ{@code false}
     */
    boolean isOnly();

    /**
     * 保持する要素が1件の時、そのオブジェクトを保持する{@link IOptional IOptional}を返します。
     * 複数件の要素を保持する時やemptyの場合は、空の{@link IOptional IOptional}を返します。
     *
     * @return {@link IOptional IOptional}
     */
    IOptional<E> getOnlyOne();
}
