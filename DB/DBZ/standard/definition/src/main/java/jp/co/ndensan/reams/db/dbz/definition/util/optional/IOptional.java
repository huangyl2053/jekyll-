/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.optional;

import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;

/**
 * nullかもしれない値を保持するオブジェクトです。保持する値があるか、または、emptyか、2つの状態のどちらかにあります。<br/>
 * javaSE8 Optionalの簡易版です。
 *
 * @author N3327 三浦 凌
 * @param <T> nullかもしれないオブジェクトの型
 */
public interface IOptional<T> {

    /**
     * 保持する値を返します。<br/>
     * ただし、emptyの可能性があるので、使用前に{@link #isPresent() isPresent()}でemptyでないことを確かめてください。
     *
     * @return 保持するオブジェクト
     */
    T get();

    /**
     * 保持する値があれば{@literal true}を返します。
     *
     * @return 保持する値があれば{@literal true}、emptyなら{@literal false}
     */
    boolean isPresent();

    /**
     * 保持する値があれば、指定の{@code consumer}に定義された処理を実行します。
     *
     * @param consumer 保持する値があるときに実行する、指定の処理
     * @throws NullPointerException 保持する値が存在していて、かつ、引数の{@code consumer}がnullの時
     */
    void ifPresent(IConsumer<? super T> consumer) throws NullPointerException;

    /**
     * 保持する値があればその値、emptyなら引数の値を返します。
     *
     * @param other 保持する値がない時に返す値
     * @return 保持する値があればその値、emptyなら引数の値
     */
    T orElse(T other);

    /**
     * 保持する値があればその値、emptyなら引数の{@link ISupplier ISupplier}が生成するexceptionをスローします。
     *
     * @param <X> スローされるexception
     * @param exceptionSupplier exceptionを生成するsupplier
     * @return 保持する値があればその値
     * @throws X emptyの時
     */
    <X extends Throwable> T orElseThrow(ISupplier<X> exceptionSupplier) throws X;

    /**
     * 保持する値を指定の{@link IFunction mapper}により変換し、その結果を持った新しい{@link IOptional IOptional}として返します。
     * emptyの場合は、戻り値の{@link IOptional IOptional}もemptyになります。
     *
     * @param <R> 変換後の{@link IOptional IOptional}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return 保持する値を変換した結果を持った{@link IOptional IOptional},
     * emptyの場合はemptyな{@link IOptional IOptional}
     */
    <R> IOptional<R> map(IFunction<? super T, ? extends R> mapper);

    /**
     * 保持する値を指定の{@link IFunction mapper}により、別の{@link IOptional IOptional}として返します。
     * emptyの場合は、戻り値の{@link IOptional IOptional}もemptyになります。
     *
     * @param <R> 変換後の{@link IOptional IOptional}が保持する型
     * @param mapper 変換に用いる{@link IFunction mapper}
     * @return 保持する値を変換した結果を持った{@link IOptional IOptional},
     * emptyの場合はemptyな{@link IOptional IOptional}
     */
    <R> IOptional<R> flatMap(IFunction<? super T, IOptional<R>> mapper);

    /**
     * 保持する値が指定の{@link IPredicate IConditon}に当てはまるときは自身を、
     * 当てはまらない時はemptyな{@link IOptional IOptional}を返します。
     *
     * @param predicate {@link IPredicate IPredicate}に定義される条件
     * @return 指定の条件にあてはまる時は自身をそのまま、あてはまらない時はemptyな{@link IOptional IOptional}
     */
    IOptional<T> filter(IPredicate<? super T> predicate);

    /**
     * デバッグ用の文字列を返します。
     *
     * @return デバッグ用の文字列
     */
    @Override
    String toString();
}
