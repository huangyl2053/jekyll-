/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import com.google.common.base.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.IllegalInitialValueException;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.equal;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * ドメインのShichosonCodeです。
 *
 * @author N3327 三浦 凌
 */
public final class ShichosonCode implements IValueObject<RString>, Comparable<ShichosonCode>, IDbColumnMappable {

    private final static int LENGTH = 5;
    private final RString theValue;

    /**
     * 指定の値をもった ShichosonCode を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時、引数が半角の数字以外を含む時、引数が5文字でない時
     */
    public ShichosonCode(String value) throws IllegalInitialValueException {
        this(new RString(ValueObjects.requireNonNull(value)));
    }

    /**
     * 指定の値をもった ShichosonCode を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時、引数が半角の数字以外を含む時、引数が5文字でない時
     */
    public ShichosonCode(RString value) throws IllegalInitialValueException {
        ValueObjects.requireNonNull(value);
        ValueObjects.requireHalfSizeNumberOnly(value);
        ValueObjects.requireLength(value, equal(LENGTH));
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(ShichosonCode o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public RString getColumnValue() {
        return this.theValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShichosonCode)) {
            return false;
        }
        ShichosonCode other = (ShichosonCode) obj;
        return Objects.equal(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + java.util.Objects.hashCode(this.theValue);
        return hash;
    }
}
