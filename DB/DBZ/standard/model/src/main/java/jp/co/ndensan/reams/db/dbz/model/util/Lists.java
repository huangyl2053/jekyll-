/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link List List}を扱うユーティリティです。
 *
 * @author N3327 三浦 凌
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
     * {@link Iterable Iterable}なオブジェクトから新しい{@link ArrayList ArrayList}を生成します。
     *
     * @param <E> {@link ArrayList ArrayList}が保持するオブジェクトの型
     * @param elements {@link Iterable Iterable}なオブジェクト
     * @return 引数のオブジェクトを保持した新しい{@link ArrayList ArrayList}
     */
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
        ArrayList<E> list = newArrayList();
        for (E element : elements) {
            list.add(element);
        }
        return list;
    }
}
