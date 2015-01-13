/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;

/**
 * {@link DbCollectors}と合わせて用いることを想定したユーティリティです。
 * 例えば、{@link IFunction}を返すクラスメソッドは
 * {@link DbCollectors#collectingAndThen(jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IDbCollector, jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction) DbCollectors#collectingAndThen}
 * の{@code finisher}に渡すことで、任意の事後処理を付加できます。
 *
 * @author N3327 三浦 凌
 */
public final class DbCollectorsSupport {

    private DbCollectorsSupport() {
    }

    /**
     * {@link List}を{@link Collections#unmodifiableList(java.util.List)}に渡した結果を返す{@link IFunction}を返します。
     *
     * @param <T> {@link List}が保持する要素の型
     * @param elementType {@link List}が保持する要素の{@code class}
     * @return
     * {@link List}を{@link Collections#unmodifiableList(java.util.List)}に渡した結果を返す{@link IFunction}
     */
    public static <T> IFunction<List<T>, List<T>> collections$unmodifiableList(Class<T> elementType) {
        return collections$unmodifiableList();
    }

    /**
     * {@link List}を{@link Collections#unmodifiableList(java.util.List)}に渡した結果を返す{@link IFunction}を返します。
     *
     * @param <T> {@link List}が保持する要素の型
     * @return
     * {@link List}を{@link Collections#unmodifiableList(java.util.List)}に渡した結果を返す{@link IFunction}
     */
    public static <T> IFunction<List<T>, List<T>> collections$unmodifiableList() {
        return new IFunction<List<T>, List<T>>() {
            @Override
            public List<T> apply(List<T> t) {
                return Collections.unmodifiableList(t);
            }
        };
    }

    /**
     * {@link Map}を{@link Collections#unmodifiableMap(java.util.Map)}に渡した結果を返す{@link IFunction}を返します。
     *
     * @param <K> キーの型
     * @param <V> 値の型
     * @param keyType キーの{@code class}
     * @param valueType 値の{@code class}
     * @return
     * {@link Map}を{@link Collections#unmodifiableMap(java.util.Map)}に渡した結果を返す{@link IFunction}
     */
    public static <K, V> IFunction<Map<K, V>, Map<K, V>> collections$unmodifiableMap(Class<K> keyType, Class<V> valueType) {
        return collections$unmodifiableMap();
    }

    /**
     * {@link Map}を{@link Collections#unmodifiableMap(java.util.Map)}に渡した結果を返す{@link IFunction}を返します。
     *
     * @param <K> キーの型
     * @param <V> 値の型
     * @return
     * {@link Map}を{@link Collections#unmodifiableMap(java.util.Map)}に渡した結果を返す{@link IFunction}
     */
    public static <K, V> IFunction<Map<K, V>, Map<K, V>> collections$unmodifiableMap() {
        return new IFunction<Map<K, V>, Map<K, V>>() {
            @Override
            public Map<K, V> apply(Map<K, V> t) {
                return Collections.unmodifiableMap(t);
            }
        };
    }

    /**
     * {@link IOptional}を保持するMapから{@link IOptional#isPresent() isPresent()}が{@code true}を返す値だけをまとめて、
     * {@link IItemList}として返す処理を定義した{@link IFunction}を返します。
     * {@link #gatheringPresentItems() gatheringPresentItems()}の型指定を引数によって行います。
     *
     * @param <K> キーの型
     * @param <T> Mapの保持する{@link IOptional}がラップしたオブジェクトの型,
     * 生成される{@link IItemList}が保持する要素の型
     * @param mapKeyType Mapのキーの型を表す{@link class}
     * @param itemsType 生成される{@link IItemList}が保持する要素の型を表す{@link class}
     * @return
     * {@link IOptional#isPresent() isPresent()}が{@code true}を返す値だけをまとめた{@link IItemList}を生成する{@link IFunction}
     */
    public static <K, T> IFunction<Map<K, IOptional<T>>, IItemList<T>> gatheringPresentItems(Class<K> mapKeyType, Class<T> itemsType) {
        return gatheringPresentItems();
    }

    /**
     * {@link IOptional}を保持するMapから{@link IOptional#isPresent() isPresent()}が{@code true}を返す値だけをまとめて、
     * {@link IItemList}として返す処理を定義した{@link IFunction}を返します。
     *
     * @param <K> Mapのキーの型
     * @param <T> Mapの保持する{@link IOptional}がラップしたオブジェクトの型,
     * 生成される{@link IItemList}が保持する要素の型
     * @return
     * {@link IOptional#isPresent() isPresent()}が{@code true}を返す値だけをまとめた{@link IItemList}を生成する{@link IFunction}
     */
    public static <K, T> IFunction<Map<K, IOptional<T>>, IItemList<T>> gatheringPresentItems() {
        return new IFunction<Map<K, IOptional<T>>, IItemList<T>>() {
            @Override
            public IItemList<T> apply(Map<K, IOptional<T>> t) {
                final List<T> list = new ArrayList<>();
                for (Map.Entry<? extends K, IOptional<T>> entry : t.entrySet()) {
                    entry.getValue().ifPresent(new IConsumer<T>() {
                        @Override
                        public void accept(T t) {
                            list.add(t);
                        }
                    });
                }
                return ItemList.of(list);
            }
        };
    }
}
