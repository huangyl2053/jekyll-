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
 * 合併市町村同士を結びつけるための番号です。
 *
 * @author N3327 三浦 凌
 */
public final class GappeiLinkNo implements IValueObject<RString>, Comparable<GappeiLinkNo>, Serializable {

    /**
     * 空の GappeiLinkNo です。
     * {@link #value() value()}で{@link RString#EMPTY RString.EMPTY}を返します。
     */
    public static final GappeiLinkNo EMPTY;

    static {
        EMPTY = new GappeiLinkNo();
    }

    /**
     * {@link #EMPTY}を生成するためのプライベートコンストラクタです。
     */
    private GappeiLinkNo() {
        this.theValue = RString.EMPTY;
    }

    private static final int LENGTH = 2;
    private final RString theValue;

    /**
     * 引数に指定した2桁の半角数字をもった GappeiLinkNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数が半角数字のみでない時, 引数が2桁でない時
     */
    public GappeiLinkNo(String value) throws IllegalInitialValueException {
        this(new RString(ValueObjects.requireNonNull(value)));
    }

    /**
     * 引数に指定した2桁の半角数字をもった GappeiLinkNo を生成します。
     *
     * @param value 値
     * @throws IllegalInitialValueException 引数がnullの時, 引数が半角数字のみでない時, 引数が2桁でない時
     */
    public GappeiLinkNo(RString value) throws IllegalInitialValueException {
        ValueObjects.requireNonNull(value);
        if (!value.equals(RString.EMPTY)) {
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
    public int compareTo(GappeiLinkNo o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GappeiLinkNo)) {
            return false;
        }
        GappeiLinkNo other = (GappeiLinkNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
