/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 認定調査員コードクラスです。
 *
 * @author n8223　朴義一
 */
public class ChosainCode implements IValueObject<RString>, Comparable<ChosainCode>, IDbColumnMappable, Serializable {

    private static final int EIGHT = 8;
    /**
     * 空の{@link ChosainCode}です。
     */
    public static final ChosainCode EMPTY;
    /**
     * 最大長です。
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new ChosainCode(RString.EMPTY);
        MAX_LENGTH = EIGHT;
    }

    private final RString theValue;

    /**
     * 指定の値をもった ShujiCode を生成します。
     *
     * @param value 値
     */
    public ChosainCode(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった ShujiCode を生成します。
     *
     * @param value 値
     */
    public ChosainCode(RString value) {
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
    public int compareTo(ChosainCode o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChosainCode other = (ChosainCode) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
