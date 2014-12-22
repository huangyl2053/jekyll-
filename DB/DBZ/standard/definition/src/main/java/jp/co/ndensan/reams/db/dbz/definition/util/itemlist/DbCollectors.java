/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 *
 * @author N3327 三浦 凌
 */
public final class DbCollectors {

    private DbCollectors() {
    }

    /**
     *
     * @param <T>
     * @param <K>
     * @param <V>
     * @param keyMapper
     * @param valueMapper
     * @return
     */
    public static <T, K, V> IDbCollector<T, ?, Map<K, V>> toMap(
            final IFunction<? super T, ? extends K> keyMapper, final IFunction<? super T, ? extends V> valueMapper) {
        Objects.requireNonNull(keyMapper, UrSystemErrorMessages.値がnull.getReplacedMessage("keyMapper"));
        Objects.requireNonNull(valueMapper, UrSystemErrorMessages.値がnull.getReplacedMessage("valueMapper"));
        ISupplier<Map<K, V>> container = new ISupplier<Map<K, V>>() {
            @Override
            public Map<K, V> get() {
                return new HashMap<>();
            }
        };
        IBiConsumer<Map<K, V>, T> accumulator = new IBiConsumer<Map<K, V>, T>() {
            @Override
            public void accept(Map<K, V> t, T u) {
                t.put(keyMapper.apply(u), valueMapper.apply(u));
            }
        };
        return DbCollector.of(container, accumulator);
    }

    /**
     *
     * @param <T>
     * @param <K>
     * @param keyMapper
     * @return
     */
    public static <T, K> IDbCollector<T, ?, Map<K, IItemList<T>>> groupingBy(final IFunction<T, K> keyMapper) {
        return groupingBy(keyMapper, null);
    }

    /**
     *
     * @param <T>
     * @param <K>
     * @param keyMapper
     * @param comparator
     * @return
     */
    public static <T, K> IDbCollector<T, ?, Map<K, IItemList<T>>> groupingBy(final IFunction<T, K> keyMapper, final Comparator<? super T> comparator) {
        Objects.requireNonNull(keyMapper, UrSystemErrorMessages.値がnull.getReplacedMessage("keyMapper"));
        ISupplier<Map<K, IItemList<T>>> container = new ISupplier<Map<K, IItemList<T>>>() {
            @Override
            public Map<K, IItemList<T>> get() {
                return new HashMap<>();
            }
        };
        IBiConsumer<Map<K, IItemList<T>>, T> accumulator = new IBiConsumer<Map<K, IItemList<T>>, T>() {
            @Override
            public void accept(Map<K, IItemList<T>> t, T u) {
                K key = keyMapper.apply(u);
                if (!t.containsKey(key)) {
                    t.put(key, ItemList.<T>empty());
                }
                t.put(key, t.get(key).added(u));
            }
        };
        if (comparator == null) {
            return DbCollector.of(container, accumulator);
        }
        IFunction<Map<K, IItemList<T>>, Map<K, IItemList<T>>> finisher = new IFunction<Map<K, IItemList<T>>, Map<K, IItemList<T>>>() {
            @Override
            public Map<K, IItemList<T>> apply(Map<K, IItemList<T>> t) {
                Map<K, IItemList<T>> map = new HashMap<>();
                for (Map.Entry<K, IItemList<T>> entry : t.entrySet()) {
                    map.put(entry.getKey(), entry.getValue().sorted(comparator));
                }
                return map;
            }
        };
        return DbCollector.of(container, accumulator, finisher);
    }
}
