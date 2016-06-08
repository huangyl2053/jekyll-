/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * {@link List List}を扱うユーティリティです。
 */
public final class Lists {

    private Lists() {
    }

    /**
     * 新しい{@link ArrayList ArrayList}を生成します。
     *
     * @param <E> {@link ArrayList ArrayList}が保持するオブジェクトの型
     * @return 新しい{@link ArrayList ArrayList}
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 保持する要素を指定して、{@link ArrayList ArrayList}を生成します。
     *
     * @param <E> {@link ArrayList ArrayList}が保持するオブジェクトの型
     * @param elements 保持する要素
     * @return 引数の要素を保持した{@link ArrayList ArrayList}
     */
    public static <E> ArrayList<E> newArrayList(E... elements) {
        ArrayList<E> list = newArrayList();
        list.addAll(Arrays.asList(elements));
        return list;
    }

    /**
     * {@link Iterable Iterable}なオブジェクトから、新しい{@link ArrayList ArrayList}を生成します。
     *
     * @param <E> {@link ArrayList ArrayList}が保持するオブジェクトの型
     * @param elements {@link Iterable Iterable}なオブジェクト
     * @return 引数のもつ要素をすべて保持した、新しい{@link ArrayList ArrayList}
     */
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
        Objects.requireNonNull(elements);
        ArrayList<E> list = newArrayList();
        for (E element : elements) {
            list.add(element);
        }
        return list;
    }

    /**
     * {@link Collection Collection}から、新しい{@link ArrayList ArrayList}を生成します。
     * このメソッドは、{@link ArrayList#ArrayList(java.util.Collection) }で代用できます。
     *
     * @param <E> {@link ArrayList ArrayList}が保持するオブジェクトの型
     * @param elements {@link Collection Collection}
     * @return
     * {@link Collection Collection}の要素をすべて保持した、新しい{@link ArrayList ArrayList}
     */
    public static <E> ArrayList<E> newArrayList(Collection<? extends E> elements) {
        return new ArrayList<>(Objects.requireNonNull(elements));
    }
}
