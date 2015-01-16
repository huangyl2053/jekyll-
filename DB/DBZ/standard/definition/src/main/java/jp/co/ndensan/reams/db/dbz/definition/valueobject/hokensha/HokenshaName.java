/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者の名称です。
 *
 * @author N3327 三浦 凌
 */
public final class HokenshaName implements IValueObject<RString>, Comparable<HokenshaName> {

    /**
     * 最大長です。
     */
    public static final int MAX_LENGTH;

    static {
        MAX_LENGTH = 20;
    }

    private final RString theValue;

    /**
     * 指定の値をもった HokenshaName を生成します。
     *
     * @param value 値
     */
    public HokenshaName(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった HokenshaName を生成します。
     *
     * @param value 値
     */
    public HokenshaName(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(HokenshaName o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HokenshaName)) {
            return false;
        }
        HokenshaName other = (HokenshaName) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.theValue);
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
