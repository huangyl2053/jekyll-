/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators;
import jp.co.ndensan.reams.db.dbz.model.util.Lists;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * {@link IItemList IItemList}の実装です。{@link IItemList IItemList}を取得するためのstaticなメソッドを持ちます。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持する要素の型
 */
public final class ItemList<E> implements IItemList<E> {

    private final List<E> elements;
    private final _Items<E> defaultImpl;

    /**
     * 何も要素を保持しない空の{@link ItemList ItemList}を生成します。
     *
     * @param <T> {@link ItemList ItemList}が保持する要素の型
     * @return 空の{@link ItemList ItemList}
     */
    public static <T> ItemList<T> empty() {
        return new ItemList<>(Collections.<T>emptyList());
    }

    /**
     * 指定のlistを保持する{@link ItemList ItemList}を生成します。
     *
     * @param <T> {@link ItemList ItemList}が保持する要素の型
     * @param list {@link ItemList ItemList}が保持する要素のlist
     * @return 引数のlistを保持する{@link ItemList ItemList}
     * @throws NullPointerException 引数がnullの時, listがnullの要素を含むとき
     */
    public static <T> ItemList<T> of(List<T> list) throws NullPointerException {
        return new ItemList<>(list);
    }

    /**
     * 指定の単一要素を保持する{@link ItemList ItemList}を生成します。
     *
     * @param <T> {@link ItemList ItemList}が保持する要素の型
     * @param t {@link ItemList ItemList}が保持するひとつの要素
     * @return 引数の要素を保持する{@link ItemList ItemList}
     * @throws NullPointerException 引数がnullの時
     */
    public static <T> ItemList<T> of(T t) throws NullPointerException {
        Objects.requireNonNull(t);
        return new ItemList<>(Arrays.asList(t));
    }

    /**
     * 指定の要素を保持する{@link ItemList ItemList}を生成します。
     *
     * @param <T> {@link ItemList ItemList}が保持する要素の型
     * @param t {@link ItemList ItemList}が保持する要素
     * @return 引数の要素を保持する{@link ItemList ItemList}
     * @throws NullPointerException 引数がnullの要素を含むとき
     */
    public static <T> ItemList<T> of(T... t) throws NullPointerException {
        return new ItemList<>(Arrays.asList(t));
    }

    private ItemList(List<E> list) {
        Objects.requireNonNull(list);
        if (list.contains(null)) {
            throw new NullPointerException("nullの要素を含むため、生成できません。");
        }
        this.elements = list;
        this.defaultImpl = new _Items<>(list);
    }

    @Override
    public boolean isEmpty() {
        return this.defaultImpl.isEmpty();
    }

    @Override
    public boolean isJustOne() {
        return this.defaultImpl.isJustOne();
    }

    @Override
    public IOptional<E> findJustOne() {
        return this.defaultImpl.findJustOne();
    }

    @Override
    public IOptional<E> findFirst() {
        return this.defaultImpl.findFirst();
    }

    @Override
    public IItemList<E> sorted() {
        List<E> copied = Lists.newArrayList(this.elements);
        Collections.sort(copied, (Comparator<E>) Comparators.NaturalOrderComparator.ASC.getInstance());
        return new ItemList<>(copied);
    }

    @Override
    public IItemList<E> sorted(Comparator<? super E> comparator) {
        List<E> copied = Lists.newArrayList(this.elements);
        Collections.sort(copied, comparator);
        return new ItemList<>(copied);
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
            list.add(mapper.apply(item));
        }
        return new ItemList<>(list);
    }

    @Override
    public List<E> asList() {
        return Collections.unmodifiableList(this.elements);
    }

    @Override
    public Iterator<E> iterator() {
        return this.defaultImpl.iterator();
    }

    @Override
    public int size() {
        return this.defaultImpl.size();
    }

    @Override
    public boolean contains(Object o) {
        return this.defaultImpl.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.defaultImpl.containsAll(c);
    }

    @Override
    public boolean containsAllItems(IItems<?> items) {
        return this.defaultImpl.containsAllItems(items);
    }

    @Override
    public boolean anyMatch(ICondition<? super E> condition) {
        return this.defaultImpl.anyMatch(condition);
    }

    @Override
    public boolean allMatch(ICondition<? super E> condition) {
        return this.defaultImpl.allMatch(condition);
    }

    @Override
    public boolean noneMatch(ICondition<? super E> condition) {
        return this.defaultImpl.noneMatch(condition);
    }
}
