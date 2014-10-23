/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保番号です。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaNo implements IValueObject<RString>, Comparable<HihokenshaNo>, IDbColumnMappable, Serializable {

    /**
     * 空の HihokenshaNo です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final HihokenshaNo EMPTY;

    static {
        EMPTY = new HihokenshaNo(RString.EMPTY);
    }
    private final RString theValue;

    /**
     * 指定の値をもった HihokenshaNo を生成します。引数がnullのとき、空文字を設定します。
     *
     * @param value 値
     */
    public HihokenshaNo(String value) {
        if (value == null) {
            this.theValue = RString.EMPTY;
        } else {
            this.theValue = new RString(value);
        }
    }

    /**
     * 指定の値をもった HihokenshaNo を生成します。
     *
     * @param value 値
     */
    public HihokenshaNo(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(HihokenshaNo o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HihokenshaNo)) {
            return false;
        }
        HihokenshaNo other = (HihokenshaNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public RString getColumnValue() {
        return this.theValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
