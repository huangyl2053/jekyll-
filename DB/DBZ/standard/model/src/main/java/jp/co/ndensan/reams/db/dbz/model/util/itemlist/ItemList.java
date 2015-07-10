/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.itemlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * {@link IItemList}の実装です。<br/>
 *
 * @author N3327 三浦 凌
 * @param <E> 保持するオブジェクトの型
 */
public final class ItemList<E> implements IItemList<E>, Serializable {

    private final ArrayList<E> elements;

    private ItemList() {
        this.elements = new ArrayList<>();
    }

    private ItemList(List<? extends E> c) {
        Objects.requireNonNull(c);
        if (c.contains(null)) {
            throw new NullPointerException("nullの要素を含むため、生成できません。");
        }
        this.elements = new ArrayList<>(c);
    }

    /**
     * 指定の{@link IItemList IItemList}から、同じ要素を保持する新しい{@link IItemList IItemList}を生成します。
     *
     * @param <T> {@link IItemList IItemList}が保持する要素の型
     * @param items {@link IItemList IItemList}
     * @return
     * 指定の{@link IItemList IItemList}から生成した、新しい{@link IItemList IItemList}
     */
    public static <T> ItemList<T> newItemList(IItemList<? extends T> items) {
        return new ItemList<>(items.asList());
    }

    /**
     * 何も要素を保持しない空の{@link IItemList IItemList}を生成します。
     *
     * @param <T> {@link IItemList IItemList}が保持する要素の型
     * @return 空の{@link IItemList IItemList}
     */
    public static <T> ItemList<T> empty() {
        return new ItemList<>();
    }

    /**
     * 指定のlistを保持する{@link IItemList IItemList}を生成します。
     *
     * @param <T> {@link IItemList IItemList}が保持する要素の型
     * @param list {@link IItemList IItemList}が保持する要素のlist
     * @return 引数のlistを保持する{@link IItemList IItemList}
     * @throws NullPointerException 引数がnullの時, listがnullの要素を含むとき
     */
    public static <T> ItemList<T> of(List<? extends T> list) throws NullPointerException {
        return new ItemList<>(list);
    }

    /**
     * 指定の単一要素を保持する{@link IItemList IItemList}を生成します。
     *
     * @param <T> {@link IItemList IItemList}が保持する要素の型
     * @param t {@link IItemList IItemList}が保持するひとつの要素
     * @return 引数の要素を保持する{@link IItemList IItemList}
     * @throws NullPointerException 引数がnullの時
     */
    public static <T> ItemList<T> of(T t) throws NullPointerException {
        Objects.requireNonNull(t);
        return new ItemList<>(Arrays.asList(t));
    }

    /**
     * 指定の要素を保持する{@link IItemList IItemList}を生成します。
     *
     * @param <T> {@link IItemList IItemList}が保持する要素の型
     * @param t {@link IItemList IItemList}が保持する要素
     * @return 引数の要素を保持する{@link IItemList IItemList}
     * @throws NullPointerException 引数がnullの要素を含むとき
     */
    public static <T> ItemList<T> of(T... t) throws NullPointerException {
        return new ItemList<>(Arrays.asList(t));
    }

    @Override
    public List<E> asList() {
        return new ArrayList<>(elements);
    }

    @Override
    public IItemList<E> filter(ICondition<? super E> condition) {
        List<E> list = new ArrayList<>();
        for (E item : this.elements) {
            if (condition.check(item)) {
                list.add(item);
            }
        }
        return new ItemList<>(list);
    }

    @Override
    public <R> IItemList<R> map(IFunction<? super E, ? extends R> mapper) {
        List<R> list = new ArrayList<>();
        for (E item : this.elements) {
            list.add(Objects.requireNonNull(mapper.apply(item)));
        }
        return new ItemList<>(list);
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean isJustOne() {
        return this.elements.size() == 1;
    }

    private E _firstItem() {
        assert !elements.isEmpty();
        return (E) this.elements.toArray()[0];
    }

    @Override
    public IOptional<E> findJustOne() {
        return this.isJustOne()
                ? DbOptional.of(_firstItem())
                : DbOptional.<E>empty();
    }

    @Override
    public IOptional<E> findFirst() {
        return this.elements.isEmpty()
                ? DbOptional.<E>empty()
                : DbOptional.of(_firstItem());
    }

    @Override
    public Iterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean contains(Object o) {
        return this.elements.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.elements.containsAll(c);
    }

    @Override
    public boolean containsAll(IItemList<?> items) {
        return this.elements.containsAll(items.asList());
    }

    @Override
    public boolean anyMatch(ICondition<? super E> condition) {
        for (E element : elements) {
            if (condition.check(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean allMatch(ICondition<? super E> condition) {
        for (E element : elements) {
            if (!(condition.check(element))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noneMatch(ICondition<? super E> condition) {
        for (E element : elements) {
            if (condition.check(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public IItemList<E> sorted() {
        List<E> copied = new ArrayList<>(this.elements);
        Collections.sort(copied, (Comparator<E>) Comparators.naturalOrder());
        return new ItemList<>(copied);
    }

    @Override
    public IItemList<E> sorted(Comparator<? super E> comparator) {
        List<E> copied = new ArrayList<>(this.elements);
        Collections.sort(copied, comparator);
        return new ItemList<>(copied);
    }

    @Override
    public IItemList<E> reversed() {
        List<E> copied = new ArrayList<>(this.elements);
        Collections.sort(copied, (Comparator<E>) Comparators.reverseOrder());
        return new ItemList<>(copied);
    }

    @Override
    public IItemList<E> added(E itemToAdd) {
        Objects.requireNonNull(itemToAdd);
        ArrayList<E> list = new ArrayList<>(this.elements);
        list.add(itemToAdd);
        return new ItemList<>(list);
    }

    @Override
    public IItemList<E> added(E... items) {
        Objects.requireNonNull(items);
        ArrayList<E> list = new ArrayList<>(this.elements);
        for (E item : items) {
            if (item == null) {
                throw new IllegalArgumentException("引数にnullが含まれています。");
            }
            list.add(item);
        }
        return new ItemList<>(list);
    }
}
