/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NaturalOrderComparator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保険者番号です。
 *
 * @author N3327 三浦 凌
 * @deprecated {@link HihokenshaNo}を使用してください。
 */
public final class KaigoHihokenshaNo implements IValueObject<RString>, Comparable<KaigoHihokenshaNo>, IDbColumnMappable, Serializable {

    /**
     * 空の KaigoHihokenshaNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final KaigoHihokenshaNo EMPTY;

    static {
        EMPTY = new KaigoHihokenshaNo(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 指定の値をもった KaigoHihokenshaNo を生成します。
     *
     * @param value 値
     */
    public KaigoHihokenshaNo(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった KaigoHihokenshaNo を生成します。
     *
     * @param value 値
     */
    public KaigoHihokenshaNo(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(KaigoHihokenshaNo o) {
        return Objects.compare(this.theValue, o.theValue, NaturalOrderComparator.ASC.getInstance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KaigoHihokenshaNo)) {
            return false;
        }
        KaigoHihokenshaNo other = (KaigoHihokenshaNo) obj;
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
        return this.theValue;
    }

    /**
     * HihokenshaNo へ変換します。
     *
     * @return HihokenshaNo
     */
    public HihokenshaNo toHihokenshaNo() {
        return new HihokenshaNo(this.theValue);
    }
}
