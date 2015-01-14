/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.optional;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;

/**
 * {@link Optional Optional}を生成します。
 *
 * @param <T> Optional が保持する値
 * @author N3327 三浦 凌
 */
public final class Optional<T> implements IOptional<T> {

    private static final Optional<?> THE_EMPTY;

    static {
        THE_EMPTY = new Optional<>();
    }

    private final T value;

    private Optional() {
        this.value = null;
    }

    /**
     * emptyな{@link Optional Optional}を返します。<br/>
     * 確実にnullの値を{@link #ofNullable(java.lang.Object) ofNullable()}に渡す様ならば、こちらを使ってください。
     *
     * @param <T> 保持するオブジェクトの型
     * @return 空の{@link Optional Optional}
     */
    public static <T> Optional<T> empty() {
        return (Optional<T>) THE_EMPTY;
    }

    private Optional(T value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    /**
     * 引数の値を保持した{@link Optional Optional}を生成します。<br/>
     * 引数がnullかもしれない場合は、{@link #ofNullable(java.lang.Object) ofNullable()}を使用してください。
     *
     * @param <T> 保持するオブジェクトの型
     * @param value 保持する値
     * @return 引数の値を保持する{@link Optional Optional}
     * @throws NullPointerException 引数がnullの時
     */
    public static <T> Optional<T> of(T value) throws NullPointerException {
        return new Optional<>(value);
    }

    /**
     * 引数がnullの時は{@link #empty() empty()}、nullでない時は{@link #of(java.lang.Object) of()}と同じ値を返します。
     *
     * @param <T> 保持するオブジェクトの型
     * @param value 保持する値
     * @return
     * 引数の値を保持する{@link Optional Optional}もしくは{@link #empty() empty}な{@link Optional Optional}
     */
    public static <T> Optional<T> ofNullable(T value) {
        return null == value ? Optional.<T>empty() : of(value);
    }

    @Override
    public T get() {
        if (this.value == null) {
            throw new java.util.NoSuchElementException("value is not present.");
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
                ? String.format("Optional[%s]", this.value)
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
        if (!(obj instanceof Optional)) {
            return false;
        }
        Optional<?> other = (Optional<?>) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public <R> Optional<R> map(IFunction<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Optional.ofNullable(mapper.apply(this.value));
        }
    }

    @Override
    public <R> Optional<R> flatMap(IFunction<? super T, Optional<R>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Objects.requireNonNull(mapper.apply(this.value));
        }
    }

    @Override
    public Optional<T> filter(IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        }
        if (predicate.evaluate(this.value)) {
            return this;
        }
        return empty();
    }

    @Override
    public void ifPresent(IConsumer<? super T> consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }
}
