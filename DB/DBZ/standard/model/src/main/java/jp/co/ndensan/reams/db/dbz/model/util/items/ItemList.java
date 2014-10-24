/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.Lists;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * {@link IItemList IItemList}の実装です。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持する要素の型
 */
public final class ItemList<E> implements IItemList<E> {

    private final List<E> elements;
    private final _ItemCollection<E> defaultImpl;

    /**
     * 何も要素を保持しない空の{@link IItems I_ItemCollection}を生成します。
     *
     * @param <T> {@link IItems I_ItemCollection}が保持する要素の型
     * @return 空の{@link IItems I_ItemCollection}
     */
    public static <T> ItemList<T> empty() {
        return new ItemList<>(Collections.<T>emptyList());
    }

    /**
     * 引数のlistを保持する{@link IItems I_ItemCollection}を生成します。
     *
     * @param <T> {@link IItems I_ItemCollection}が保持する要素の型
     * @param list {@link IItems I_ItemCollection}が保持する要素のlist
     * @throws NullPointerException 引数がnullの時, listがnullの要素を含むとき
     * @return 引数のlistを保持する{@link IItems I_ItemCollection}
     */
    public static <T> ItemList<T> of(List<T> list) throws NullPointerException {
        return new ItemList<>(list);
    }

    private ItemList(List<E> list) {
        Objects.requireNonNull(list);
        if (list.contains(null)) {
            throw new NullPointerException("nullの要素を含むため、生成できません。");
        }
        this.elements = list;
        this.defaultImpl = new _ItemCollection<>(list);
    }

    @Override
    public boolean isEmpty() {
        return this.defaultImpl.isEmpty();
    }

    @Override
    public boolean isOnly() {
        return this.defaultImpl.isOnly();
    }

    @Override
    public IOptional<E> getOnlyOne() {
        return this.defaultImpl.getOnlyOne();
    }

    @Override
    public IItemList<E> sortBy(Comparator<? super E> comparator) {
        List<E> copied = Lists.newArrayList(this.elements);
        Collections.sort(copied, comparator);
        return new ItemList<>(copied);
    }

    @Override
    public <R> IItemList<R> map(IFunction<? super E, ? extends R> mapper) {
        List<R> list = Lists.newArrayList();
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
    public boolean containsAny(ICondition<? super E> condition) {
        return this.defaultImpl.containsAny(condition);
    }
}
