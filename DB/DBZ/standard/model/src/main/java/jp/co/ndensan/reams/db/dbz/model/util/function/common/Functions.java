/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function.common;

import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * {@link IFunction IFunction}をより便利に扱うためのユーティリティです。
 * 汎用的な{@link IFunction IFunction}を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class Functions {

    private static final _ChildToParent<?, ?> CHILD_TO_PARENT;
    private static final _WithOutChange<?> WITHOUT_CHANGE;

    static {
        WITHOUT_CHANGE = new _WithOutChange<>();
        CHILD_TO_PARENT = new _ChildToParent<>();
    }

    private Functions() {
    }

    /**
     * あるオブジェクトをそのオブジェクトへ変換する{@link IFunction IFunction}を返します。<br/>
     * このFunctionは、例えば、{@link IOptional#map(jp.co.ndensan.reams.db.dbz.model.util.function.IFunction) IOptional#map()}などで、
     * 変換元のオブジェクトを親オブジェクトへ変換する際に用いることができます。
     *
     * @param <T> オブジェクトの型
     * @param clazz オブジェクトのclass
     * @return あるオブジェクトをあるオブジェクトへ変換する{@link IFunction IFunction}
     */
    public static <T> IFunction<T, T> to(Class<T> clazz) {
        return (IFunction<T, T>) WITHOUT_CHANGE;
    }

    private static class _WithOutChange<A> implements IFunction<A, A> {

        @Override
        public A apply(A t) {
            return t;
        }
    }

    /**
     * あるオブジェクトを親のオブジェクトへ変換する{@link IFunction IFunction}を返します。
     * {@link #childToParent() toParent()}との違いは、変換後の型だけを明確にすれば問題ない時に、
     * 変換元の型の指定を省略することができる点です。
     *
     * @param <C> 子オブジェクトの型
     * @param <P> 親オブジェクトの型
     * @param parentType 親オブジェクトのclass
     * @return あるオブジェクトを親のオブジェクトへ変換する{@link IFunction IFunction}
     */
    public static <C extends P, P> IFunction<C, P> toParent(Class<P> parentType) {
        return (IFunction<C, P>) CHILD_TO_PARENT;
    }

    /**
     * あるオブジェクトを親のオブジェクトへ変換する{@link IFunction IFunction}を返します。<br/>
     * 以下の様に、変換前後の型を明確にする必要があります。
     * <pre>
     * {@code Functions.<String, CharSequence>toParent();}
     * </pre>
     *
     * @param <C> 子オブジェクトの型
     * @param <P> 親オブジェクトの型
     * @return あるオブジェクトを親のオブジェクトへ変換する{@link IFunction IFunction}
     */
    public static <C extends P, P> IFunction<C, P> childToParent() {
        return (IFunction<C, P>) CHILD_TO_PARENT;
    }

    private static class _ChildToParent<C extends P, P> implements IFunction<C, P> {

        @Override
        public P apply(C t) {
            return t;
        }
    }
}
