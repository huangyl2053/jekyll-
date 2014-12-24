/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 段階インデックスです。
 *
 * @author N8156 宮本 康
 */
public final class DankaiIndex implements IValueObject<RString>, Comparable<DankaiIndex>, IDbColumnMappable {

    /**
     * 空の DankaiIndex です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final DankaiIndex EMPTY;

    static {
        EMPTY = new DankaiIndex(RString.EMPTY);
    }
    private final RString theValue;

    /**
     * 指定の値をもった DankaiIndex を生成します。
     *
     * @param value 値
     */
    public DankaiIndex(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった DankaiIndex を生成します。
     *
     * @param value 値
     */
    public DankaiIndex(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(DankaiIndex o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DankaiIndex)) {
            return false;
        }
        DankaiIndex other = (DankaiIndex) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return theValue;
    }
}
