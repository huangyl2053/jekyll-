/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.uzclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link IIdentifiable}の集合を扱います。 識別子をキーとした{@link Map}のように動作します。
 *
 * @param <I> 識別子の型
 * @param <T> 参照オブジェクトの型
 */
public final class IdMap<I, T extends IIdentifiable<I>> implements Cloneable, Iterable<T>, Serializable {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。

    private final Map<I, T> map;

    private IdMap(Map<I, T> map) {
        this.map = map;
    }

    /**
     * 指定の参照オブジェクトの集合から{@link IdMap}を生成します。
     *
     * @param <I> 識別子の型
     * @param <T> 参照オブジェクトの型
     * @param elements 参照オブジェクトの集合
     * @return 指定の参照オブジェクトの集合から生成された{@link IdMap}
     */
    public static <I, T extends IIdentifiable<I>> IdMap<I, T> create(Iterable<? extends T> elements) {
        Objects.requireNonNull(elements, "反復子がnullです。");
        Map<I, T> map = Collections.<I, T>synchronizedMap(new LinkedHashMap<I, T>());
        for (T element : elements) {
            map.put(element.identifier(), element);
        }
        return new IdMap<>(map);
    }

    /**
     * 指定の識別子を持った参照オブジェクトを返します。 存在しない場合は、{@code null}を返します。
     *
     * @param key 識別子
     * @return 指定の識別子を持った参照オブジェクト、なければ{@code null}
     */
    public T get(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        return this.map.get(key);
    }

    /**
     * 指定の参照オブジェクトを追加します。 同じ識別子を持った物がすでに存在する場合は、上書きされます。
     * 以前に保持されていた参照オブジェクトを返します。
     *
     * @param value 追加したい参照オブジェクト
     * @return 以前に保持されていた参照オブジェクト
     */
    public T add(T value) {
        Objects.requireNonNull(value, "要素がnullです。");
        return this.map.put(value.identifier(), value);
    }

    /**
     * 指定の識別子を持った参照オブジェクトを取り除きます。 取り除かれた場合は、その参照オブジェクトを返します。
     * 指定の識別子に一致する物が無かった場合は、何の変更もせずに、{@code null}を返します。
     *
     * @param key 取り除きたい参照オブジェクトの識別子
     * @return 参照オブジェクト、もしくは{@code null}
     */
    public T remove(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        return this.map.remove(key);
    }

    /**
     * 保持する要素の数を返します。
     *
     * @return 保持する要素の数
     */
    public int size() {
        return this.map.size();
    }

    /**
     * 指定の識別子を持った参照オブジェクトがあれば{@code true}、なければ{@code false}を返します。
     *
     * @param key 識別子
     * @return 指定の識別子を持った参照オブジェクトがあれば{@code true}、なければ{@code false}
     */
    public boolean contains(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        return this.map.containsKey(key);
    }

    /**
     * 識別子のセットを返します。戻り値は変更不可です。
     *
     * @return 識別子のセット
     */
    public Set<I> keySet() {
        return Collections.unmodifiableSet(new HashSet<>(this.map.keySet()));
    }

    /**
     * 保持する参照オブジェクトの一覧を返します。 戻り値の一覧は、変更不可です。
     *
     * @return 保持する参照オブジェクトの一覧(変更不可)
     */
    public Collection<T> values() {
        return Collections.unmodifiableCollection(new ArrayList<>(this.map.values()));
    }

    /**
     * 保持する参照オブジェクトの一覧を{@link List} で返します。 戻り値の{@link List}は、変更不可です。
     *
     * @return 保持する参照オブジェクトの{@link List}(変更不可)
     */
    public List<T> valuesAsList() {
        return Collections.unmodifiableList(new ArrayList<>(this.map.values()));
    }

    /**
     * 変更不可なコピーを返します。
     *
     * @return 変更不可なコピー
     */
    public IdMap<I, T> frozen() {
        return new IdMap<>(Collections.unmodifiableMap(map));
    }

    @Override
    public IdMap<I, T> clone() {
        try {
            return (IdMap<I, T>) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new SystemException(ex);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.unmodifiableList(new ArrayList<>(this.map.values())).iterator();
    }
}
