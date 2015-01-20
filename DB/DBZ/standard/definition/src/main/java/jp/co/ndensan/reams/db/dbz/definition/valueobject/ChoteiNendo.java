/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * 調定年度です。
 *
 * @author N3317 塚田 萌
 */
public final class ChoteiNendo implements IValueObject<FlexibleYear>, Comparable<ChoteiNendo>, Serializable {

    /**
     * 空の ChoteiNendo
     * です。{@link #value() value()}で{@link FlexibleYear#EMPTY}を返します。
     */
    public static final ChoteiNendo EMPTY;

    static {
        EMPTY = new ChoteiNendo(FlexibleYear.EMPTY);
    }
    private final FlexibleYear theValue;

    /**
     * 指定の値をもった ChoteiNendo を生成します。
     *
     * @param value 値
     */
    public ChoteiNendo(String value) {
        this.theValue = (value == null) ? null : new FlexibleYear(value);
    }

    /**
     * 指定の値をもった ChoteiNendo を生成します。
     *
     * @param value 値
     */
    public ChoteiNendo(FlexibleYear value) {
        this.theValue = value;
    }

    @Override
    public FlexibleYear value() {
        return this.theValue;
    }

    @Override
    public int compareTo(ChoteiNendo o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChoteiNendo)) {
            return false;
        }
        ChoteiNendo other = (ChoteiNendo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
