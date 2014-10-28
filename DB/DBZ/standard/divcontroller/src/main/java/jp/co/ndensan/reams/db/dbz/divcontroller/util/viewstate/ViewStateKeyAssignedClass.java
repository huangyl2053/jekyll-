/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@literal ViewState}において、あるclassと1対1で対応させるためのキーです。
 *
 * @author N3327 三浦 凌
 */
public final class ViewStateKeyAssignedClass implements IViewStateKey {

    private final Class<? extends Serializable> clazz;
    private final RString key;

    /**
     * インスタンスを生成します。
     *
     * @param clazz {@literal ViewState}で保持したい型のclass
     */
    public ViewStateKeyAssignedClass(Class<? extends Serializable> clazz) {
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
        this.key = new RString(clazz.getName());
    }

    @Override
    public String toString() {
        return key.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewStateKeyAssignedClass)) {
            return false;
        }
        ViewStateKeyAssignedClass other = (ViewStateKeyAssignedClass) obj;
        return Objects.equals(clazz, other.clazz);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.clazz);
        return hash;
    }
}
