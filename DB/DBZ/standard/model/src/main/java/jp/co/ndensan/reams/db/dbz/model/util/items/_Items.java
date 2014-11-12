/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;

/**
 * {@link IItems IItems}の標準の実装です。<br/>
 * {@link IItems IItems}を実装したクラスを新しく作る場合には、可能なメソッドはこのクラスに処理を委譲します。
 * そうすることで実装の手間を省略できます。{@link ItemList ItemList}の実装を参考にしてください。
 *
 * @author N3327 三浦 凌
 * @param <E> 保持するオブジェクトの型
 */
class _Items<E> implements IItems<E>, Serializable {

    private final Collection<E> elements;

    /**
     * Collectionからインスタンスを生成します。
     *
     * @param elements Collection
     */
    protected _Items(Collection<E> elements) {
        Objects.requireNonNull(elements);
        this.elements = elements;
    }

    @Override
    public List<E> asList() {
        return new ArrayList<>(elements);
    }

    @Override
    public IItems<E> filter(ICondition<? super E> condition) {
        List<E> list = new ArrayList<>();
        for (E item : this.elements) {
            if (condition.check(item)) {
                list.add(item);
            }
        }
        return new _Items<>(list);
    }

    @Override
    public <R> IItems<R> map(IFunction<? super E, ? extends R> mapper) {
        List<R> list = new ArrayList<>();
        for (E item : this.elements) {
            list.add(mapper.apply(item));
        }
        return new _Items<>(list);
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
    public boolean containsAllItems(IItems<?> items) {
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
}
