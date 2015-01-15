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
 * nullかもしれない値を保持するオブジェクトです。保持する値があるか、または、emptyか、2つの状態のどちらかにあります。
 *
 * @param <T> Optional が保持する値
 * @author N3327 三浦 凌
 */
public final class Optional<T> {

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
     * 指定の非{@code null}値を保持した{@link Optional Optional}を生成します。<br/>
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

    /**
     * 保持する値を返します。emptyの場合は{@link NoSuchElementException}をスローします。 <br/>
     * 使用前に{@link #isPresent() isPresent()}でemptyでないことを確かめてください。
     *
     * @return 保持するオブジェクト
     */
    public T get() {
        if (this.value == null) {
            throw new java.util.NoSuchElementException("value is not present.");
        }
        return value;
    }

    /**
     * 保持する値があれば{@literal true}を返します。
     *
     * @return 保持する値があれば{@literal true}、emptyなら{@literal false}
     */
    public boolean isPresent() {
        return this.value != null;
    }

    /**
     * 保持する値があればその値、emptyなら引数の値を返します。
     *
     * @param other 保持する値がない時に返す値
     * @return 保持する値があればその値、emptyなら引数の値
     */
    public T orElse(T other) {
        return this.value != null ? this.value : other;
    }

    /**
     * 保持する値があればその値、emptyなら引数の{@link ISupplier ISupplier}が生成するexceptionをスローします。
     *
     * @param <X> スローされるexception
     * @param exceptionSupplier exceptionを生成するsupplier
     * @return 保持する値があればその値
     * @throws X emptyの時
     */
    public <X extends Throwable> T orElseThrow(ISupplier<X> exceptionSupplier) throws X {
        if (value != null) {
            return this.value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * デバッグ用の文字列を返します。
     *
     * @return デバッグ用の文字列
     */
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

    /**
     * 保持する値を指定の{@link IFunction mapper}により変換し、その結果を持った新しい{@link Optional Optional}として返します。
     * emptyの場合は、戻り値の{@link Optional Optional}もemptyになります。
     *
     * @param <R> 変換後の{@link Optional Optional}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return 保持する値を変換した結果を持った{@link Optional Optional},
     * emptyの場合はemptyな{@link Optional Optional}
     */
    public <R> Optional<R> map(IFunction<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Optional.ofNullable(mapper.apply(this.value));
        }
    }

    /**
     * 保持する値を指定の{@link IFunction mapper}により、別の{@link Optional Optional}として返します。
     * emptyの場合は、戻り値の{@link Optional Optional}もemptyになります。
     *
     * @param <R> 変換後の{@link Optional Optional}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return 保持する値を変換した結果を持った{@link Optional Optional},
     * emptyの場合はemptyな{@link Optional Optional}
     */
    public <R> Optional<R> flatMap(IFunction<? super T, Optional<R>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Objects.requireNonNull(mapper.apply(this.value));
        }
    }

    /**
     * 保持する値が指定の{@link IPredicate IConditon}に当てはまるときは自身を、
     * 当てはまらない時はemptyな{@link Optional Optional}を返します。
     *
     * @param predicate {@link IPredicate IPredicate}に定義される条件
     * @return 指定の条件にあてはまる時は自身をそのまま、あてはまらない時はemptyな{@link Optional Optional}
     */
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

    /**
     * 保持する値があれば、指定の{@code consumer}に定義された処理を実行します。
     *
     * @param consumer 保持する値があるときに実行する、指定の処理
     * @throws NullPointerException 保持する値が存在していて、かつ、引数の{@code consumer}がnullの時
     */
    public void ifPresent(IConsumer<? super T> consumer) throws NullPointerException {
        if (this.value != null) {
            consumer.accept(value);
        }
    }
}
