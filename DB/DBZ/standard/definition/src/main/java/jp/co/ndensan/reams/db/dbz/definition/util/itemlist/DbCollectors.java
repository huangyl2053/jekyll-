/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.function.DbFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link IDbCollector}の実装を集めたユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class DbCollectors {

    private DbCollectors() {
    }

    private static void _requireNonNull(Object target, String name) {
        Objects.requireNonNull(target, UrSystemErrorMessages.値がnull.getReplacedMessage(name));
    }

    /**
     * コレクタに仕上げの変換を付与します。
     *
     * @param <T> 入力要素の型
     * @param <A> 中間累積の型
     * @param <R> 中間結果の型
     * @param <RR> 最終結果の型
     * @param downstream コレクタ
     * @param finisher 最後にコレクタの結果を変換するためのfunction
     * @return コレクタに仕上げの変換を付与したもの
     */
    public static <T, A, R, RR> IDbCollector<T, A, RR> collectingAndThen(IDbCollector<T, A, R> downstream, IFunction<R, RR> finisher) {
        return DbCollector.of(
                downstream.container(),
                downstream.accumulator(),
                DbFunction.of(downstream.finisher()).andThen(finisher));
    }

    /**
     * {@link List}へ集積するためのコレクタを生成し、返します。
     *
     * @param <T> 集積元の型, {@link List}が保持する要素の型
     * @return {@link List}へ集積するためのコレクタ
     */
    public static <T> IDbCollector<T, ?, List<T>> toList() {
        return DbCollector.of(
                MySuppliers.<T>newArrayList(),
                MyBiConsumers.<List, T>collection_add());
    }

    /**
     * {@link IItemList}へ集積するためのコレクタを生成し、返します。
     *
     * @param <T> 集積元の型,{@link IItemList}が保持する要素の型
     * @return {@link IItemList}へ集積するためのコレクタ
     */
    public static <T> IDbCollector<T, ?, IItemList<T>> toIItemList() {
        return DbCollector.of(
                MySuppliers.<T>newArrayList(),
                MyBiConsumers.<List, T>collection_add(),
                new IFunction<List<T>, IItemList<T>>() {
                    @Override
                    public IItemList<T> apply(List<T> t) {
                        return ItemList.of(t);
                    }
                });
    }

    /**
     * 指定の{@link Comparator}でソートした{@link IItemList}へ集積するためのコレクタを生成し、返します。
     *
     * @param <T> 集積元の型,{@link IItemList}が保持する要素の型
     * @param comparator {@link Comparator}
     * @return 指定の{@link Comparator}でソートした{@link IItemList}へ集積するためのコレクタ
     */
    public static <T> IDbCollector<T, ?, IItemList<T>> sortBy(final Comparator<? super T> comparator) {
        return DbCollector.of(
                MySuppliers.<T>newArrayList(),
                MyBiConsumers.<List, T>collection_add(),
                new IFunction<List<T>, IItemList<T>>() {
                    @Override
                    public IItemList<T> apply(List<T> t) {
                        return ItemList.of(t).sorted(comparator);
                    }
                });
    }

    /**
     * 指定の{@link Comparator}でソートし先頭の要素を{@link Optional}で取得するコレクタを生成し、返します。
     *
     * @param <T> 集積元の型,{@link Optional}が保持する要素の型
     * @param comparator {@link Comparator}
     * @return 指定の{@link Comparator}でソートし先頭の要素を{@link Optional}で取得するコレクタ
     */
    public static <T> IDbCollector<T, ?, Optional<T>> minBy(final Comparator<? super T> comparator) {
        return DbCollector.of(
                MySuppliers.<T>newArrayList(),
                MyBiConsumers.<List, T>collection_add(),
                new IFunction<List<T>, Optional<T>>() {
                    @Override
                    public Optional<T> apply(List<T> t) {
                        return ItemList.of(t).sorted(comparator).findFirst();
                    }
                });
    }

    /**
     * 指定の{@link Comparator}でソートし最後の要素を{@link Optional}で取得するコレクタを生成し、返します。
     *
     * @param <T> 集積元の型,{@link Optional}が保持する要素の型
     * @param comparator {@link Comparator}
     * @return 指定の{@link Comparator}でソートし最後の要素を{@link Optional}で取得するコレクタ
     */
    public static <T> IDbCollector<T, ?, Optional<T>> maxBy(final Comparator<? super T> comparator) {
        return DbCollector.of(
                MySuppliers.<T>newArrayList(),
                MyBiConsumers.<List, T>collection_add(),
                new IFunction<List<T>, Optional<T>>() {
                    @Override
                    public Optional<T> apply(List<T> t) {
                        return ItemList.of(t).sorted(Collections.reverseOrder(comparator)).findFirst();
                    }
                });
    }

    /**
     * {@link IItemList}へ集積するためのコレクタを生成し、返します。
     *
     * @param <T> 集積元の型
     * @param <K> キーの型
     * @param <V> 値の型
     * @param keyMapper キーへマッピングするfunction
     * @param valueMapper 値へマッピングするfunction
     * @return {@link IItemList}へ集積するためのコレクタ
     */
    public static <T, K, V> IDbCollector<T, ?, Map<K, V>> toMap(
            final IFunction<? super T, ? extends K> keyMapper, final IFunction<? super T, ? extends V> valueMapper) {
        _requireNonNull(keyMapper, "keyMapper");
        _requireNonNull(valueMapper, "valueMapper");
        ISupplier<Map<K, V>> container = MySuppliers.newHashMap();
        IBiConsumer<Map<K, V>, T> accumulator = new IBiConsumer<Map<K, V>, T>() {
            @Override
            public void accept(Map<K, V> t, T u) {
                t.put(keyMapper.apply(u), valueMapper.apply(u));
            }
        };
        return DbCollector.of(container, accumulator);
    }

    /**
     * 指定のfunctionから生成したキーで{@link IItemList}をマッピングした{@link Map}へ集積する、グルーピング用のコレクタを生成し返します。
     *
     * @param <T> 集積元の型
     * @param <K> キーの型
     * @param keyMapper キーへマッピングするfunction
     * @return グルーピング用のコレクタ
     */
    public static <T, K> IDbCollector<T, ?, Map<K, IItemList<T>>> groupingBy(final IFunction<T, K> keyMapper) {
        return groupingBy(keyMapper, DbCollectors.<T>toIItemList());
    }

    /**
     * 指定のfunctionから生成したキーと指定のコレクタが生成したオブジェクトをマッピングする、グルーピング用のコレクタを生成し返します。
     *
     * @param <T> 集積元の型
     * @param <K> キーの型
     * @param <A> 中間累積の型
     * @param <D> 結果、キーとマッピングするオブジェクトの型
     * @param classifier キーを生成するfunction
     * @param downstream 結果を生成するコレクタ
     * @return グルーピング用のコレクタ
     */
    public static <T, K, A, D> IDbCollector<T, ?, Map<K, D>> groupingBy(final IFunction<T, K> classifier,
            final IDbCollector<? super T, A, D> downstream) {
        _requireNonNull(classifier, "classifier");
        ISupplier<Map<K, A>> container = MySuppliers.newHashMap();
        final ISupplier<A> downstreamContainer = downstream.container();
        IBiConsumer<Map<K, A>, T> accumulator = new IBiConsumer<Map<K, A>, T>() {
            @Override
            public void accept(Map<K, A> t, T u) {
                K key = Objects.requireNonNull(classifier.apply(u));
                A container = _computeIfAbsent(t, key, _toFanction(downstreamContainer));
                downstream.accumulator().accept(container, u);
            }
        };
        IFunction<Map<K, A>, Map<K, D>> finisher = new IFunction<Map<K, A>, Map<K, D>>() {
            @Override
            public Map<K, D> apply(Map<K, A> t) {
                Map<K, D> map = new HashMap<>();
                for (Map.Entry<K, A> entry : t.entrySet()) {
                    map.put(entry.getKey(), downstream.finisher().apply(entry.getValue()));
                }
                return map;
            }
        };
        return DbCollector.of(container, accumulator, finisher);
    }

    /**
     * 指定の{@link Map}が指定のキーに紐付く値を保持する場合は、その値を返します。
     * 保持しない場合は、mappingFunctionが生成する値をキーに紐付け、その値を返します。
     *
     * @param <K> キーの型
     * @param <V> キーに紐付く値の型
     * @param map マップ
     * @param key キー
     * @param mappingFunction マッピングする値を生成するfunction
     * @return キーに紐付く値(あれば)。もしくは、mappingFunctionにより新しく生成した値。
     */
    private static <K, V> V _computeIfAbsent(Map<K, V> map, K key, IFunction<? super K, ? extends V> mappingFunction) {
        V value = map.get(key);
        if (value != null) {
            return value;
        }

        V newValue = mappingFunction.apply(key);
        if (newValue != null) {
            map.put(key, newValue);
        }
        return newValue;
    }

    /**
     * 指定の{@link ISupplier}を実行して返す{@link IFunction}を生成します。{@link IFunction}の入力は無視されます。
     *
     * @param <T> 入力の型(実行時は何もされず、無視される)
     * @param <R> {@link ISupplier}が生成するオブジェクトの型
     * @param supplier {@link ISupplier}
     * @return 指定の{@link ISupplier}を実行して返す{@link IFunction}
     */
    private static <T, R> IFunction<T, R> _toFanction(final ISupplier<R> supplier) {
        return new IFunction<T, R>() {
            @Override
            public R apply(T t) {
                return supplier.get();
            }
        };
    }

    private static final class MySuppliers {

        private MySuppliers() {
        }

        /**
         * {@link HashMap}のインスタンスを生成する{@link ISupplier}です。
         *
         * @param <K> キーの型
         * @param <V> 値の型
         * @return {@link HashMap}のインスタンスを生成する{@link ISupplier}
         */
        private static <K, V> ISupplier<Map<K, V>> newHashMap() {
            return new ISupplier<Map<K, V>>() {
                @Override
                public Map<K, V> get() {
                    return new HashMap<>();
                }
            };
        }

        /**
         * {@link ArrayList}のインスタンスを生成する{@link ISupplier}です。
         *
         * @param <T> 保持する要素の型
         * @return {@link ArrayList}のインスタンスを生成する{@link ISupplier}
         */
        private static <T> ISupplier<List<T>> newArrayList() {
            return new ISupplier<List<T>>() {
                @Override
                public List<T> get() {
                    return new ArrayList<>();
                }
            };
        }
    }

    private static final class MyBiConsumers {

        private MyBiConsumers() {
        }

        /**
         * {@link Collection}を実装したオブジェクトの{@link Collection#add(java.lang.Object) add()}の振る舞いを定義した{@link IBiConsumer}です。
         *
         * @param <C> {@link Collection}を実装したオブジェクトの型
         * @param <E> {@link Collection}を実装したオブジェクトが保持する要素の型
         * @return
         * {@link Collection#add(java.lang.Object) add()}の振る舞いを定義した{@link IBiConsumer}
         */
        private static <C extends Collection<E>, E> IBiConsumer<? extends C, E> collection_add() {
            return new IBiConsumer<C, E>() {
                @Override
                public void accept(C t, E u) {
                    t.add(u);
                }
            };
        }
    }
}
