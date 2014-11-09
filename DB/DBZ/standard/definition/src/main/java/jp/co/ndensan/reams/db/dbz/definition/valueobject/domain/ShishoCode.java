/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NaturalOrderComparator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 支所コードです。
 *
 * @author N3327 三浦 凌
 */
public final class ShishoCode implements IValueObject<RString>, Comparable<ShishoCode>, IDbColumnMappable, Serializable {

    /**
     * 空の ShishoCode です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ShishoCode EMPTY;

    static {
        EMPTY = new ShishoCode(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 指定の値をもった ShishoCode を生成します。
     *
     * @param value 値
     */
    public ShishoCode(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった ShishoCode を生成します。
     *
     * @param value 値
     */
    public ShishoCode(RString value) {
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
    public int compareTo(ShishoCode o) {
        return Objects.compare(this.theValue, o.theValue, NaturalOrderComparator.ASC.getInstance());
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
        if (!(obj instanceof ShishoCode)) {
            return false;
        }
        ShishoCode other = (ShishoCode) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
