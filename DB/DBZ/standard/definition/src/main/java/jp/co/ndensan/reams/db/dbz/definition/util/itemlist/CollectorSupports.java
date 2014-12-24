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
 *
 * @author N3327 三浦 凌
 */
public final class CollectorSupports {

    private CollectorSupports() {
    }

    /**
     *
     * @param <T>
     * @param elementType
     * @return
     */
    public static <T> IFunction<List<T>, List<T>> collections$unmodifiableList(Class<T> elementType) {
        return collections$unmodifiableList();
    }

    /**
     *
     * @param <T>
     * @return
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
     *
     * @param <K>
     * @param <V>
     * @param keyType
     * @param valueType
     * @return
     */
    public static <K, V> IFunction<Map<K, V>, Map<K, V>> collections$unmodifiableMap(Class<K> keyType, Class<V> valueType) {
        return collections$unmodifiableMap();
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @return
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
     *
     * @param <K>
     * @param <T>
     * @param mapKeyType
     * @param itemsType
     * @return
     */
    public static <K, T> IFunction<Map<K, IOptional<T>>, IItemList<T>> gatheringPresentItems(Class<K> mapKeyType, Class<T> itemsType) {
        return gatheringPresentItems();
    }

    /**
     *
     * @param <K>
     * @param <T>
     * @return
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
