/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import java.util.Objects;

/**
 * {@link IFunction}をラップして拡張します。
 *
 * @author n3327 三浦 凌
 * @param <T> 入力の型
 * @param <R> 出力の型
 */
public final class MyFunction<T, R> implements IFunction<T, R> {

    private final IFunction<? super T, ? extends R> instance;

    private MyFunction(IFunction<? super T, ? extends R> instance) {
        this.instance = instance;
    }

    /**
     * 指定の{@link IFunction}を保持するインスタンスを生成します。
     *
     * @param <T> 入力の型
     * @param <R> 出力の型
     * @param function ラップする{@link IFunction}
     * @return 指定の{@link IFunction}を保持する{@link MyFunction}
     */
    public static <T, R> MyFunction<T, R> of(IFunction<? super T, ? extends R> function) {
        return new MyFunction<>(function);
    }

    @Override
    public R apply(T t) {
        return instance.apply(t);
    }

    /**
     * 保持する{@link IFunction}の後、指定の事後処理を適用する合成関数を持った、新しい{@link MyFunction}を返します。
     *
     * @param <V> 結果の型
     * @param after 事後処理
     * @return 保持する{@link IFunction}の後、指定の事後処理を適用する合成関数を持った{@link MyFunction}
     */
    public <V> MyFunction<T, V> andThen(final IFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new MyFunction<>(new IFunction<T, V>() {
            @Override
            public V apply(T t) {
                return after.apply(MyFunction.this.apply(t));
            }
        });
    }

    /**
     * 指定の事前処理の後、保持する{@link IFunction}を適用する合成関数を持った、新しい{@link MyFunction}を返します。
     *
     * @param <V> 結果の型
     * @param before 事前処理
     * @return 指定の事前処理の後、保持する{@link IFunction}を適用する合成関数を持った{@link MyFunction}
     */
    public <V> MyFunction<V, R> compose(final IFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new MyFunction<>(new IFunction<V, R>() {
            @Override
            public R apply(V t) {
                return MyFunction.this.apply(before.apply(t));
            }
        });
    }
}
