/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.optional;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.function.ISupplier;

/**
 * {@link IOptional IOptional}を生成します。
 *
 * @param <T> {@link IOptional I_DbOptional}が保持する値
 * @author N3327 三浦 凌
 */
public final class DbOptional<T> implements IOptional<T> {

    private static final IOptional<?> THE_EMPTY;

    static {
        THE_EMPTY = new DbOptional<>();
    }

    private final T value;

    private DbOptional() {
        this.value = null;
    }

    /**
     * emptyな{@link IOptional IOptional}を返します。<br/>
     * 確実にnullの値を{@link #ofNullable(java.lang.Object) ofNullable()}に渡す様ならば、こちらを使ってください。
     *
     * @param <T> 保持するオブジェクトの型
     * @return 空の{@link IOptional IOptional}
     */
    public static <T> IOptional<T> empty() {
        return (IOptional<T>) THE_EMPTY;
    }

    private DbOptional(T value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    /**
     * 引数の値を保持した{@link IOptional IOptional}を生成します。<br/>
     * 引数がnullかもしれない場合は、{@link #ofNullable(java.lang.Object) ofNullable()}を使用してください。
     *
     * @param <T> 保持するオブジェクトの型
     * @param value 保持する値
     * @return 引数の値を保持する{@link IOptional IOptional}
     * @throws NullPointerException 引数がnullの時
     */
    public static <T> IOptional<T> of(T value) throws NullPointerException {
        return new DbOptional<>(value);
    }

    /**
     * 引数がnullの時は{@link #empty() empty()}、nullでない時は{@link #of(java.lang.Object) of()}と同じ値を返します。
     *
     * @param <T> 保持するオブジェクトの型
     * @param value 保持する値
     * @return
     * 引数の値を保持する{@link IOptional IOptional}もしくは{@link #empty() empty}な{@link IOptional IOptional}
     */
    public static <T> IOptional<T> ofNullable(T value) {
        return null == value ? DbOptional.<T>empty() : of(value);
    }

    @Override
    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("value is not present.");
        }
        return value;
    }

    @Override
    public boolean isPresent() {
        return this.value != null;
    }

    @Override
    public T orElse(T other) {
        return this.value != null ? this.value : other;
    }

    @Override
    public <X extends Throwable> T orElseThrow(ISupplier<X> exceptionSupplier) throws X {
        if (value != null) {
            return this.value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    @Override
    public String toString() {
        return this.value != null
                ? String.format("IOptional[%s]", this.value)
                : "empty";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DbOptional)) {
            return false;
        }
        DbOptional<?> other = (DbOptional<?>) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public <R> IOptional<R> map(IFunction<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return DbOptional.ofNullable(mapper.apply(this.value));
        }
    }

    @Override
    public <R> IOptional<R> flatMap(IFunction<? super T, IOptional<R>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Objects.requireNonNull(mapper.apply(this.value));
        }
    }

    @Override
    public IOptional<T> filter(ICondition<? super T> condtion) {
        Objects.requireNonNull(condtion);
        if (!isPresent()) {
            return this;
        }
        if (condtion.check(this.value)) {
            return this;
        }
        return empty();
    }
}
