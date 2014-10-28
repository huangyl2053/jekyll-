/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.io.Serializable;

/**
 * {@literal  ViewState}に保持されている値へアクセスする機能を持ちます。<br/>
 * このオブジェクトが返すインスタンスは、{@link ViewStateHolder ViewStateHolder}を用いて、
 * {@literal ViewState}に保持している値を制御することができます。
 *
 * @author N3327 三浦 凌
 */
public interface IViewStateAccessors {

    /**
     * {@link IViewStateKey key}に紐付けられた値へアクセスします。
     *
     * @param <T> {@literal  ViewState}に保持される値の型
     * @param key key
     * @param type {@literal  ViewState}に保持される値のclass
     * @return {@link IViewStateKey key}に紐付けられた値を操作できるインスタンス
     */
    <T extends Serializable> IViewStateValue<T> valueAssignedTo(IViewStateKey key, Class<T> type);

    /**
     * このメソッドは非推奨です。{@link #valueAssignedToA(java.lang.Class)}を使用するべきです。
     *
     * @param <T> {@literal  ViewState}に保持される値の型
     * @param key key
     * @param type {@literal  ViewState}に保持される値のclass
     * @return {@link IViewStateKey key}に紐付けられた値を操作できるインスタンス
     * @deprecated {@link #valueAssignedToA(java.lang.Class) }を使用してください
     */
    @Deprecated
    <T extends Serializable> IViewStateValue<T> valueAssignedTo(ViewStateKeyAssignedClass key, Class<T> type);

    /**
     * あるクラスに紐付けられた値へアクセスします。
     *
     * @param <T> {@literal  ViewState}に保持される値の型
     * @param type {@literal  ViewState}に保持される値のclass
     * @return {@link IViewStateKey key}に紐付けられた値を操作できるインスタンス
     */
    <T extends Serializable> IViewStateValue<T> valueAssignedToA(Class<T> type);
}
