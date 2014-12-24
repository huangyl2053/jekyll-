/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import java.util.Objects;

/**
 *
 * @author n3327 三浦 凌
 * @param <T> 入力の型
 * @param <R> 出力の型
 */
public final class Function<T, R> implements IFunction<T, R> {

    private final IFunction<? super T, ? extends R> instance;

    private Function(IFunction<? super T, ? extends R> instance) {
        this.instance = instance;
    }

    public static <T, R> Function<T, R> of(IFunction<? super T, ? extends R> function) {
        return new Function<>(function);
    }

    @Override
    public R apply(T t) {
        return instance.apply(t);
    }

    /**
     *
     * @param <V>
     * @param after
     * @return
     */
    public <V> Function<T, V> andThen(final IFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new Function<>(new IFunction<T, V>() {
            @Override
            public V apply(T t) {
                return after.apply(Function.this.apply(t));
            }
        });
    }

    /**
     *
     * @param <V>
     * @param before
     * @return
     */
    public <V> Function<V, R> compose(final IFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new Function<>(new IFunction<V, R>() {
            @Override
            public R apply(V t) {
                return Function.this.apply(before.apply(t));
            }
        });
    }
}
