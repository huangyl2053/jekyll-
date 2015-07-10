/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link IPredicate}をラップして拡張します。
 * {@link #evaluate(java.lang.Object) evaluate()}では、ラップした{@link IPredicate}と同じ結果を返します。
 * さらに、論理和、論理積、否定などの{@link IPredicate}を生成する機能を持ちます。
 *
 * @author N3327 三浦 凌
 * @param <T> 検査対象の型
 */
public final class Pred<T> implements IPredicate<T> {

    private final IPredicate<? super T> predicate;

    private Pred(IPredicate<? super T> predicate) {
        this.predicate = predicate;
    }

    /**
     * 指定の{@link IPredicate}をラップした{@link Pred}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}をラップした{@link Pred}
     */
    public static <T> Pred<T> of(IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new Pred<>(predicate);
    }

    @Override
    public boolean evaluate(T t) {
        return this.predicate.evaluate(t);
    }

    /**
     * 指定の{@link IPredicate}の否定の結果を返す{@link Pred}を生成します。
     *
     * @param <T> 検査対象の型
     * @param predicate {@link IPredicate}
     * @return 指定の{@link IPredicate}の否定の結果を返す{@link Pred}
     */
    public static <T> Pred<T> not(final IPredicate<? super T> predicate) {
        Objects.requireNonNull(predicate, UrSystemErrorMessages.値がnull.getReplacedMessage("Predicate"));
        return new Pred<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return !predicate.evaluate(t);
            }
        });
    }

    /**
     * 否定の結果を返す{@link Pred}を返します。
     *
     * @return 否定の結果を返す{@link Pred}
     */
    public Pred<T> negate() {
        return Pred.not(this);
    }

    /**
     * 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link Pred}を生成します。
     *
     * @param <T> 検査対象の型
     * @param target equalかどうかを調べる値
     * @return 指定の値と{@link Objects#equals(java.lang.Object, java.lang.Object)
     * }で一致するかどうかを調べることができる{@link Pred}
     */
    public static <T> Pred<T> isEqual(final Object target) {
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
        return new Pred<>(p);
    }

    /**
     * 指定の{@link IPredicate}との論理和を返す{@link Pred}を返します。
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理和を返す{@link Pred}
     */
    public Pred<T> or(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new Pred<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return Pred.this.evaluate(t) || other.evaluate(t);
            }
        });
    }

    /**
     * 指定の{@link IPredicate}との論理積を返す{@link Pred}を返します。
     *
     * @param other {@link IPredicate}
     * @return 指定の{@link IPredicate}との論理積を返す{@link Pred}
     */
    public Pred<T> and(final IPredicate<? super T> other) {
        Objects.requireNonNull(other, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new Pred<>(new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return Pred.this.evaluate(t) && other.evaluate(t);
            }
        });
    }
}
