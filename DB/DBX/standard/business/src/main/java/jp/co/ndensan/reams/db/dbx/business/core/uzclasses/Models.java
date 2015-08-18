/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.uzclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link DbTableEntityBase}を継承したEntityをラップして保持する参照オブジェクトを複数件扱うためのオブジェクトです。
 *
 * @param <I> 識別子の型
 * @param <T> 参照オブジェクトの型
 */
public final class Models<I, T extends IModel<I, ?, T>> implements Cloneable, Iterable<T>, Serializable {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。

    private IdMap<I, T> entities;

    private Models(IdMap<I, T> entities) {
        this.entities = entities;
    }

    /**
     * {@link Models}のインスタンスを生成します。
     *
     * @param <I> 識別子の型
     * @param <T> 業務概念Businessクラスの型
     * @param elements 参照オブジェクトの集合
     * @return {@link Models}のインスタンス
     */
    public static <I, T extends IModel<I, ?, T>> Models<I, T> create(Iterable<? extends T> elements) {
        Objects.requireNonNull(elements, "反復子がnullです。");
        return new Models<>(IdMap.create(elements));
    }

    /**
     * 指定の要素を追加する。既に同じ識別子の物が存在する場合は、置き換える。
     *
     * @param value 追加したい(もしくは置き換えたい)要素
     * @return 追加された(もしくは置き換えられた)要素
     */
    public T add(T value) {
        Objects.requireNonNull(value, "要素がnullです。");
        return entities.add(value);
    }

    /**
     * 識別子に該当する要素を返す。
     *
     * @param key 識別子
     * @return あれば指定の識別子を持った要素、なければ{@code null}
     */
    public T get(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        return entities.get(key);
    }

    /**
     * 識別子に該当する要素が、すでにDBへ永続化されている物であれば削除状態にします。<br/>
     * この場合、要素自体は保持し続けているため、再び{@link #get(java.lang.Object) get()}により取得できます。<br/>
     * DBに未だない新規の要素の場合は、取り除かれます。<br/>
     * Added → リストから取り除く <br/>
     * Added以外 → Deletedにする <br/>
     *
     * @param key 識別子
     * @return 影響のあったオブジェクト
     */
    public T deleteOrRemove(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        T value = entities.get(key);
        if (value == null) {
            return null;
        }
        if (value.toEntity().getState() == EntityDataState.Added) {
            return this.entities.remove(key);
        }
        return this.entities.add(value.deleted());
    }

    /**
     * {@link Models}で保持する要素を全て削除状態にします。<br/>
     * DBに存在する要素自体は保持し続けているため、再び{@link #get(java.lang.Object) get()}により取得できます。<br/>
     * DBに未だない新規の要素の場合は、取り除かれます。<br/>
     * Added → リストから取り除く <br/>
     * Added以外 → Deletedにする <br/>
     *
     * @return 削除処理実施後の{@link Models}インスタンス
     */
    public Models<I, T> deleted() {
        Models<I, T> copied = clone();
        copied.allDeleteOrRemove();
        return copied;
    }

    private void allDeleteOrRemove() {
        for (T value : values()) {
            deleteOrRemove(value.identifier());
        }
    }

    /**
     * 指定の識別子をもった要素が存在するかどうかを返す。
     *
     * @param key 識別子
     * @return true：該当する要素が存在する false：該当する要素が存在しない。
     */
    public boolean contains(I key) {
        Objects.requireNonNull(key, "識別子がnullです。");
        return this.entities.contains(key);
    }

    /**
     * 保持する要素を{@link Collection}で返します。
     *
     * @return 保持する要素の{@link Collection}
     */
    public Collection<T> values() {
        return entities.values();
    }

    @Override
    public Models<I, T> clone() {
        try {
            Models<I, T> copied = (Models<I, T>) super.clone();
            copied.entities = entities.clone();
            return copied;
        } catch (CloneNotSupportedException ex) {
            throw new SystemException(ex);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.entities.iterator();
    }

    /**
     * {@link Models}にて保持する要素の{@link IModel#hasChanged() }メソッドを呼び出し、<br/>
     * いずれかの戻り値がtrueであればtrue、全てfalseであればfalseを返します。<br/>
     * つまり、{@link Models}で保持する要素のいずれかが保存可能であればtrue、全て保存不可(全て変更なし)であればfalseを返します。
     *
     * @return true：保持する要素のいずれかが保存可能　false：全て保存不可(全て変更なし)
     */
    public boolean hasAnyChanged() {
        for (T model : entities.values()) {
            if (model.hasChanged()) {
                return true;
            }
        }
        return false;
    }
}
