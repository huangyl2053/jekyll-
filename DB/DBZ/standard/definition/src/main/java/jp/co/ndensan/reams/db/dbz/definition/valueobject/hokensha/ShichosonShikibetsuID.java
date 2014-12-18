/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.IllegalInitialValueException;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村を識別するための値です。
 *
 * @author N3327 三浦 凌
 */
public final class ShichosonShikibetsuID implements IValueObject<RString>, Comparable<ShichosonShikibetsuID>, Serializable {

    /**
     *
     */
    public static final ShichosonShikibetsuID EMPTY;
    /**
     *
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
     * @throws IllegalInitialValueException 引数がnullの時、引数が半角の数字以外を含む時、引数が2文字でない時
     */
    public ShichosonShikibetsuID(String value) throws IllegalInitialValueException {
        if (value == null) {
            this.theValue = null;
        } else {
            this.theValue = new RString(value);
        }
    }

    /**
     * 指定の値をもった ShichosonShikibetsuID を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時、引数が半角の数字以外を含む時、引数が2文字でない時
     */
    public ShichosonShikibetsuID(RString value) throws IllegalInitialValueException {
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
