/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

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
        _requireNonNull(keyMapper, "keyMapper");
        _requireNonNull(valueMapper, "valueMapper");
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

    private static void _requireNonNull(Object target, String name) {
        Objects.requireNonNull(target, UrSystemErrorMessages.値がnull.getReplacedMessage(name));
    }
}
