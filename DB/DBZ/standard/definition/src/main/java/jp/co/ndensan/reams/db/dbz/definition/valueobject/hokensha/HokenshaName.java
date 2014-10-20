/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.IllegalInitialValueException;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.lessOrEqual;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者の名称です。
 *
 * @author N3327 三浦 凌
 */
public final class HokenshaName implements IValueObject<RString>, Comparable<HokenshaName> {

    private static final int LENGTH = 20;
    private final RString theValue;

    /**
     * 指定の値をもった HokenshaName を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時、引数が20文字より大きい時
     */
    public HokenshaName(String value) throws IllegalInitialValueException {
        this(new RString(ValueObjects.requireNonNull(value)));
    }

    /**
     * 指定の値をもった HokenshaName を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時、引数が20文字より大きい時
     */
    public HokenshaName(RString value) throws IllegalInitialValueException {
        ValueObjects.requireNonNull(value);
        ValueObjects.requireLength(value, lessOrEqual(LENGTH));
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
}
