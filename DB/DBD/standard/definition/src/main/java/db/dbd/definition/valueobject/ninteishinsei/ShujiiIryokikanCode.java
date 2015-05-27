/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dbd.definition.valueobject.ninteishinsei;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 主治医医療機関コードです。
 *
 * @author N8235 船山 洋介
 */
public class ShujiiIryokikanCode implements IValueObject<RString>, Comparable<ShujiiIryokikanCode>, IDbColumnMappable, Serializable {

    /**
     * 空の{@link ShujiiIryokikanCode}です。
     */
    public static final ShujiiIryokikanCode EMPTY;
    /**
     * 最大長です。
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new ShujiiIryokikanCode(RString.EMPTY);
        MAX_LENGTH = 8;
    }

    private final RString theValue;

    /**
     * 指定の値をもった ShujiiIryokikanCode を生成します。
     *
     * @param value 値
     */
    public ShujiiIryokikanCode(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった ShujiiIryokikanCode を生成します。
     *
     * @param value 値
     */
    public ShujiiIryokikanCode(RString value) {
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
    public int compareTo(ShujiiIryokikanCode o) {
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
        final ShujiiIryokikanCode other = (ShujiiIryokikanCode) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.theValue);
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
