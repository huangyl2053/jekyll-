/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.util.Lists;
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
final class _ItemCollection<E> implements IItems<E> {

    private final Collection<E> elements;

    /**
     * Collectionからインスタンスを生成します。
     *
     * @param elements Collection
     */
    _ItemCollection(Collection<E> elements) {
        this.elements = elements;
    }

    @Override
    public List<E> asList() {
        return Collections.unmodifiableList(Lists.newArrayList(elements));
    }

    @Override
    public <R> IItems<R> map(IFunction<? super E, ? extends R> mapper) {
        List<R> list = new ArrayList<>();
        for (E item : this.elements) {
            list.add(mapper.apply(item));
        }
        return new _ItemCollection<>(list);
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean isOnly() {
        return this.elements.size() == 1;
    }

    @Override
    public IOptional<E> getOnlyOne() {
        return isOnly()
                ? DbOptional.of((E) this.elements.toArray()[0])
                : DbOptional.<E>empty();
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
    public boolean containsLike(ICondition<? super E> condition) {
        for (E element : elements) {
            if (condition.check(element)) {
                return true;
            }
        }
        return false;
    }
}
