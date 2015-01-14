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
 * predicate と同じ結果を返します。 さらに、論理和、論理積、否定などの{@link IPredicate}を生成する機能を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <T> 検査対象の型
 */
public final class Predicate<T> implements IPredicate<T> {

    private final IPredicate<? super T> condition;

    private Predicate(IPredicate<? super T> condition) {
        this.condition = condition;
    }

    /**
     * 指定の{@link IPredicate}をラップした{@link Predicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}をラップした{@link Predicate}
     */
    public static <T> Predicate<T> of(IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new Predicate<>(predicate);
    }

    @Override
    public boolean evaluate(T t) {
        return this.condition.evaluate(t);
    }

    /**
     * 指定の{@link IPredicate}の否定の結果を返す{@link Predicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}の否定の結果を返す{@link Predicate}
     */
    public static <T> Predicate<T> not(final IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new Predicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return !predicate.evaluate(t);
            }
        });
    }

    /**
     * 否定の結果を返す{@link Predicate}を返します。
     *
     * @return 否定の結果を返す{@link Predicate}
     */
    public Predicate<T> negate() {
        return Predicate.not(this);
    }

    /**
     * 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link Predicate}を生成します。
     *
     * @param <T> 検査対象の型
     * @param target equalかどうかを調べる値
     * @return 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link Predicate}
     */
    public static <T> Predicate<T> isEqual(final Object target) {
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
        return new Predicate<>(p);
    }

    /**
     *
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理和を返す{@link Predicate}
     */
    public Predicate<T> or(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new Predicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return Predicate.this.evaluate(t) || other.evaluate(t);
            }
        });
    }

    /**
     * 指定の{@link IPredicate}との論理積を返す{@link Predicate}を返します。
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理積を返す{@link Predicate}
     */
    public Predicate<T> and(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new Predicate<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return Predicate.this.evaluate(t) && other.evaluate(t);
            }
        });
    }
}
