/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.IllegalInitialValueException;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.equal;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健の市町村番号です。
 *
 * @author N3327 三浦 凌
 */
public final class RokenShichosonNo implements IValueObject<RString>, Comparable<RokenShichosonNo>, Serializable {

    public static final RokenShichosonNo EMPTY;

    static {
        EMPTY = new RokenShichosonNo(RString.EMPTY);
    }
    private static final int LENGTH = 8;
    private final RString theValue;

    /**
     * 指定の値をもった RokenShichosonNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数の長さが8文字でない時,
     * 引数が半角数字のみでない時
     */
    public RokenShichosonNo(String value) throws IllegalInitialValueException {
        this(new RString(ValueObjects.requireNonNull(value)));
    }

    /**
     * 指定の値をもった RokenShichosonNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数の長さが8文字でない時,
     * 引数が半角数字のみでない時
     */
    public RokenShichosonNo(RString value) throws IllegalInitialValueException {
        ValueObjects.requireNonNull(value);
        if (!value.isEmpty()) {
            ValueObjects.requireHalfSizeNumberOnly(value);
            ValueObjects.requireLength(value, equal(LENGTH));
        }
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
}
