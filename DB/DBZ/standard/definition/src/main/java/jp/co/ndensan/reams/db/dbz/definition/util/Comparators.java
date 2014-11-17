/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * 汎用的なComparatorを生成する機能を持ったユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class Comparators {

    private Comparators() {
    }

    /**
     * Comparableなオブジェクト同士を比較するComparatorを生成します。
     */
    private enum NaturalOrderComparator implements Comparator<Comparable<Object>> {

        INSTANCE {

                    @Override
                    public int compare(Comparable<Object> o1, Comparable<Object> o2) {
                        return o1.compareTo(o2);
                    }

                };

        public Comparator<Comparable<Object>> reversed() {
            return Collections.reverseOrder(this);
        }
    }

    /**
     * 自然順序に並び替える{@link Comparator Comparator}を返します。
     *
     * @param <T> {@link Comparable Comparable}なオブジェクト
     * @return 自然順序に並び替えるComparator
     */
    public static <T extends Comparable> Comparator<T> naturalOrder() {
        return (Comparator<T>) NaturalOrderComparator.INSTANCE;
    }

    /**
     * 自然順序の逆順に並び替える{@link Comparator Comparator}を返します。
     *
     * @param <T> {@link Comparable Comparable}なオブジェクト
     * @return 自然順序の逆順に並び替えるComparator
     */
    public static <T extends Comparable> Comparator<T> reverseOrder() {
        return (Comparator<T>) NaturalOrderComparator.INSTANCE.reversed();
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

    private static final class _NullComparator<T> implements Comparator<T>, Serializable {

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
