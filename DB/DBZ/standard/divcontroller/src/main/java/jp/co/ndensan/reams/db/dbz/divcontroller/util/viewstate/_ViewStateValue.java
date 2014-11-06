/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateChangeState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * {@link IViewStateValue IViewStateValue}の実装です。
 *
 * @author N3327 三浦 凌
 * @param <T> 保持するオブジェクトの型
 */
final class _ViewStateValue<T extends Serializable> implements IViewStateValue<T> {

    private final Class<T> type;
    private final IViewStateKey key;

    /**
     * 指定のclassと1対1で紐付く(紐付かせる)値を操作するためのインスタンスを生成します。
     *
     * @param type 保持するオブジェクトの型
     */
    _ViewStateValue(Class<T> type) {
        this.type = Objects.requireNonNull(type);
        this.key = new ViewStateKeyAssignedClass(type);
    }

    /**
     * 指定のkeyと紐付く(紐付かせる)値を操作するためのインスタンスを生成します。
     *
     * @param key key
     * @param type 保持するオブジェクトの型
     */
    _ViewStateValue(IViewStateKey key, Class<T> type) {
        this.key = Objects.requireNonNull(key);
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public IOptional<T> tryToGet() {
        return DbOptional.ofNullable(ViewStateHolder.get(key.toString(), type));
    }

    @Override
    public void put(T value) {
        ViewStateHolder.put(key.toString(), value);
    }

    @Override
    public void remove() {
        ViewStateHolder.remove(key.toString());
    }

    @Override
    public ViewStateChangeState state() {
        return ViewStateHolder.state(key.toString());
    }

    @Override
    public boolean isEmpty() {
        return ViewStateHolder.state(key.toString()) == ViewStateChangeState.Empty;
    }

    @Override
    public boolean isDeleted() {
        return ViewStateHolder.state(key.toString()) == ViewStateChangeState.Deleted;
    }

    @Override
    public boolean isModified() {
        return ViewStateHolder.state(key.toString()) == ViewStateChangeState.Modified;
    }

    @Override
    public boolean isNoChange() {
        return ViewStateHolder.state(key.toString()) == ViewStateChangeState.Nochanged;
    }
}
