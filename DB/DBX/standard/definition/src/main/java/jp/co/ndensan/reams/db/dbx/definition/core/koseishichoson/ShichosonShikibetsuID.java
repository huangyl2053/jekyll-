/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 広域構成市町村を識別するための値です。
 */
public final class ShichosonShikibetsuID implements IValueObject<RString>, Comparable<ShichosonShikibetsuID>, IDbColumnMappable, Serializable {

    /**
     * 空の ShichosonShikibetsuID です。
     */
    public static final ShichosonShikibetsuID EMPTY;
    /**
     * 最大長です。
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new ShichosonShikibetsuID(RString.EMPTY);
        MAX_LENGTH = 2;
    }

    private final RString theValue;

    /**
     * 指定の値をもった ShichosonShikibetsuID を生成します。
     *
     * @param value 値
     */
    public ShichosonShikibetsuID(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった ShichosonShikibetsuID を生成します。
     *
     * @param value 値
     */
    public ShichosonShikibetsuID(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(ShichosonShikibetsuID o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShichosonShikibetsuID)) {
            return false;
        }
        ShichosonShikibetsuID other = (ShichosonShikibetsuID) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + java.util.Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return this.theValue;
    }

    /**
     * 最大長以下の値を持つかどうかを返します。
     *
     * @return 最大長以下の値を持つ場合、{@code true}。
     */
    public boolean hasValidLength() {
        if (this.theValue == null) {
            return true;
        }
        return this.theValue.length() <= MAX_LENGTH;
    }
}
