/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.io.Serializable;
import java.util.Objects;

/**
 * {@link IViewStateAccessors}の実装です。
 *
 * @author N3327 三浦 凌
 */
final class _ViewStateAccessors implements IViewStateAccessors {

    _ViewStateAccessors() {
    }

    @Override
    public <T extends Serializable> IViewStateValue<T> valueAssignedToA(Class<T> type) {
        Objects.requireNonNull(type);
        return new _ViewStateValue<>(type);
    }

    @Override
    public <T extends Serializable> IViewStateValue<T> valueAssignedTo(IViewStateKey key, Class<T> type) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(type);
        return new _ViewStateValue<>(key, type);
    }

    @Deprecated
    @Override
    public <T extends Serializable> IViewStateValue<T> valueAssignedTo(ViewStateKeyAssignedClass key, Class<T> type) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(type);
        return new _ViewStateValue<>(key, type);
    }
}
