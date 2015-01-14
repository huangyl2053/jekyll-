/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link IPredicate}をラップしています。{@link #evaluate(java.lang.Object) evaluate()}では、ラップした
 * {@link IPredicate}と同じ結果を返します。
 * さらに、論理和、論理積、否定などの{@link IPredicate}を生成する機能を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <T> 検査対象の型
 */
public final class MyPredicate<T> implements IPredicate<T> {

    private final IPredicate<? super T> condition;

    private MyPredicate(IPredicate<? super T> condition) {
        this.condition = condition;
    }

    /**
     * 指定の{@link IPredicate}をラップした{@link MyPredicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}をラップした{@link MyPredicate}
     */
    public static <T> MyPredicate<T> of(IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new MyPredicate<>(predicate);
    }

    @Override
    public boolean evaluate(T t) {
        return this.condition.evaluate(t);
    }

    /**
     * 指定の{@link IPredicate}の否定の結果を返す{@link MyPredicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}の否定の結果を返す{@link MyPredicate}
     */
    public static <T> MyPredicate<T> not(final IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new MyPredicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return !predicate.evaluate(t);
            }
        });
    }

    /**
     * 否定の結果を返す{@link MyPredicate}を返します。
     *
     * @return 否定の結果を返す{@link MyPredicate}
     */
    public MyPredicate<T> negate() {
        return MyPredicate.not(this);
    }

    /**
     * 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link MyPredicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param target equalかどうかを調べる値
     * @return 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link MyPredicate}
     */
    public static <T> MyPredicate<T> isEqual(final Object target) {
        IPredicate<T> p = (null == target)
                ? new IPredicate<T>() {
                    @Override
                    public boolean evaluate(T t) {
                        return t == null;
                    }
                }
                : new IPredicate<T>() {
                    @Override
                    public boolean evaluate(T t) {
                        return target.equals(t);
                    }
                };
        return new MyPredicate<>(p);
    }

    /**
     *
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理和を返す{@link MyPredicate}
     */
    public MyPredicate<T> or(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new MyPredicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return MyPredicate.this.evaluate(t) || other.evaluate(t);
            }
        });
    }

    /**
     * 指定の{@link IPredicate}との論理積を返す{@link MyPredicate}を返します。
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理積を返す{@link MyPredicate}
     */
    public MyPredicate<T> and(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new MyPredicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return MyPredicate.this.evaluate(t) && other.evaluate(t);
            }
        });
    }
}
