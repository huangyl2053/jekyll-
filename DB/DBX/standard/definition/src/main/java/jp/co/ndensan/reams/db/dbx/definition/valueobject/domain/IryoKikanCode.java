/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 保険者番号です。
 *
 * @author N3327 三浦 凌
 */
public final class IryoKikanCode implements IValueObject<RString>, Comparable<IryoKikanCode>, IDbColumnMappable, Serializable {

    /**
     * 空の IryoKikanCode です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final IryoKikanCode EMPTY;

    static {
        EMPTY = new IryoKikanCode(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 指定の値をもった IryoKikanCode を生成します。
     *
     * @param value 値
     */
    public IryoKikanCode(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった IryoKikanCode を生成します。
     *
     * @param value 値
     */
    public IryoKikanCode(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public RString getColumnValue() {
        return this.theValue;
    }

    @Override
    public int compareTo(IryoKikanCode o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.theValue, this.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IryoKikanCode)) {
            return false;
        }
        IryoKikanCode other = (IryoKikanCode) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
