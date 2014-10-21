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
 * 国保連広域内市町村番号です。
 *
 * @author N3327 三浦 凌
 */
public final class KokuhorenKoikiShichosonNo implements IValueObject<RString>, Comparable<KokuhorenKoikiShichosonNo>, Serializable {

    private static final int LENGTH = 3;
    private final RString theValue;

    /**
     * 指定の値をもった KokuhorenKoikiShichosonNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数が3桁でない時, 引数に半角数字以外を含む時
     */
    public KokuhorenKoikiShichosonNo(String value) throws IllegalInitialValueException {
        this(new RString(ValueObjects.requireNonNull(value)));
    }

    /**
     * 指定の値をもった KokuhorenKoikiShichosonNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数が3桁でない時, 引数に半角数字以外を含む時
     */
    public KokuhorenKoikiShichosonNo(RString value) throws IllegalInitialValueException {
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
    public int compareTo(KokuhorenKoikiShichosonNo o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KokuhorenKoikiShichosonNo)) {
            return false;
        }
        KokuhorenKoikiShichosonNo other = (KokuhorenKoikiShichosonNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
