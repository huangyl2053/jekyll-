/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.function.Functions;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;

/**
 * {@link IDbCollector}の実装です。ICollectorを生成するための static なメソッドを公開します。
 *
 * @author N3327 三浦 凌
 * @param <T> 集積する元要素の型
 * @param <A> 集積先のオブジェクトの型
 * @param <R> 結果の型
 */
public final class DbCollector<T, A, R> implements IDbCollector<T, A, R> {

    private final ISupplier<A> supplier;
    private final IBiConsumer<A, T> accumulator;
    private final IFunction<A, R> finisher;

    private DbCollector(ISupplier<A> supplier, IBiConsumer<A, T> accumulator, IFunction<A, R> finisher) {
        this.supplier = Objects.requireNonNull(supplier);
        this.accumulator = Objects.requireNonNull(accumulator);
        this.finisher = Objects.requireNonNull(finisher);
    }

    /**
     *
     * @param <T>
     * @param <A>
     * @param <R>
     * @param supplier
     * @param accumulator
     * @param finisher
     * @return
     */
    public static <T, A, R> DbCollector<T, A, R> of(ISupplier<A> supplier, IBiConsumer<A, T> accumulator, IFunction<A, R> finisher) {
        return new DbCollector<>(supplier, accumulator, finisher);
    }

    private DbCollector(ISupplier<A> supplier, IBiConsumer<A, T> accumulator) {
        this(supplier, accumulator, DbCollector.<A, R>casting());
    }

    /**
     *
     * @param <T>
     * @param <R>
     * @param supplier
     * @param accumulator
     * @return
     */
    public static <T, R> DbCollector<T, ?, R> of(ISupplier<R> supplier, IBiConsumer<R, T> accumulator) {
        return new DbCollector<>(supplier, accumulator);
    }

    @Override
    public IBiConsumer<A, T> accumulator() {
        return accumulator;
    }

    @Override
    public ISupplier<A> container() {
        return supplier;
    }

    @Override
    public IFunction<A, R> finisher() {
        return finisher;
    }

    private static <A, R> IFunction<A, R> casting() {
        return Functions.cast();
    }
}
