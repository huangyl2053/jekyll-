/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * 汎用的なComparatorを生成する機能を持ったユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class Comparators {

    private static final Comparator<? extends Comparable> NATURAL_ORDER;

    static {
        NATURAL_ORDER = new _NaturalOrderComparator<>();
    }

    private Comparators() {
    }

    /**
     * Comparableなオブジェクト同士を比較するComparatorを生成します。
     */
    public enum NaturalOrderComparator {

        /**
         * 昇順です。
         */
        ASC(true),
        /**
         * 降順です。
         */
        DESC(false);
        private final boolean naturalOrder;

        private NaturalOrderComparator(boolean naturalOrder) {
            this.naturalOrder = naturalOrder;
        }

        /**
         * インスタンスを返します。
         *
         * @param <T> 比較するオブジェクトの型
         * @return Comparatorのインスタンス
         */
        public <T extends Comparable> Comparator<T> getInstance() {
            return naturalOrder
                    ? (Comparator<T>) NATURAL_ORDER
                    : Collections.reverseOrder((Comparator<T>) NATURAL_ORDER);
        }
    }

    private static final class _NaturalOrderComparator<T extends Comparable> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            Objects.requireNonNull(o1);
            Objects.requireNonNull(o2);
            return o1.compareTo(o2);
        }
    }

    /**
     * nullを比較可能なComparatorを生成します。
     */
    public enum NullComparator {

        /**
         * nullの方が前と判断します。
         */
        NullsFirst(true),
        /**
         * nullの方が後と判断します。
         */
        NullsLast(false);
        private final boolean nullsFirst;

        private NullComparator(boolean nullsFirst) {
            this.nullsFirst = nullsFirst;
        }

        /**
         * nullと比較可能なcomparatorを生成します。
         * 引数のcomparatorは、{@link Comparator#compare(java.lang.Object, java.lang.Object) compare()}の引数がどちらもnullでないときに用います。
         *
         * @param <T> 比較する型
         * @param comparator comparator
         * @return nullが比較可能なcomparator
         * @throws NullPointerException 引数がnullの時
         */
        public <T> Comparator<T> of(Comparator<? super T> comparator) throws NullPointerException {
            Objects.requireNonNull(comparator);
            return new _NullComparator<>(nullsFirst, comparator);
        }
    }

    private static final class _NullComparator<T> implements Comparator<T> {

        private final boolean nullsFirst;
        private final Comparator<? super T> comparator;

        public _NullComparator(boolean nullsFirst, Comparator<? super T> comparator) {
            this.nullsFirst = nullsFirst;
            this.comparator = comparator;
        }

        @Override
        public int compare(T o1, T o2) {
            if (o1 == null) {
                return (o2 == null) ? 0 : (nullsFirst ? -1 : 1);
            }
            if (o2 == null) {
                return nullsFirst ? 1 : -1;
            }
            return (comparator == null) ? 0 : comparator.compare(o1, o2);
        }
    }
}
