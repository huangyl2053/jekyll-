/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健の市町村番号です。
 *
 * @author N3327 三浦 凌
 */
public final class RokenShichosonNo implements IValueObject<RString>, Comparable<RokenShichosonNo>, Serializable {

    /**
     *
     */
    public static final RokenShichosonNo EMPTY;
    /**
     *
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new RokenShichosonNo(RString.EMPTY);
        MAX_LENGTH = 8;
    }
    private final RString theValue;

    /**
     * 指定の値をもった RokenShichosonNo を生成します。
     *
     * @param value 値
     */
    public RokenShichosonNo(String value) {
        if (value == null) {
            this.theValue = null;
        } else {
            this.theValue = new RString(value);
        }
    }

    /**
     * 指定の値をもった RokenShichosonNo を生成します。
     *
     * @param value 値
     */
    public RokenShichosonNo(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(RokenShichosonNo o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RokenShichosonNo)) {
            return false;
        }
        RokenShichosonNo other = (RokenShichosonNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.theValue);
        return hash;
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
