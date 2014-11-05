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
 * 証記載保険者番号です。
 *
 * @author N3327 三浦 凌
 */
public final class ShoKisaiHokenshaNo implements IValueObject<RString>, Comparable<ShoKisaiHokenshaNo>, IDbColumnMappable, Serializable {

    /**
     * 空の ShoKisaiHokenshaNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ShoKisaiHokenshaNo EMPTY;

    static {
        EMPTY = new ShoKisaiHokenshaNo(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 指定の値をもった ShoKisaiHokenshaNo を生成します。
     *
     * @param value 値
     */
    public ShoKisaiHokenshaNo(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった ShoKisaiHokenshaNo を生成します。
     *
     * @param value 値
     */
    public ShoKisaiHokenshaNo(RString value) {
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
    public int compareTo(ShoKisaiHokenshaNo o) {
        return Objects.compare(this.theValue, o.theValue, NaturalOrderComparator.ASC.getInstance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShoKisaiHokenshaNo)) {
            return false;
        }
        ShoKisaiHokenshaNo other = (ShoKisaiHokenshaNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
