/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NaturalOrderComparator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 給付率を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public final class HokenKyufuRitsu implements IValueObject<Decimal>, Comparable<HokenKyufuRitsu>, IDbColumnMappable, Serializable {

    /**
     * {@link #value() value()}で{@link Decimal#ZERO Decimal.ZERO}を返す
     * HokenKyufuRitsu です。
     */
    public static final HokenKyufuRitsu ZERO;

    static {
        ZERO = new HokenKyufuRitsu(Decimal.ZERO);
    }

    private final Decimal 給付率;

    /**
     * インスタンスを生成します。
     *
     * @param 給付率 給付率
     */
    public HokenKyufuRitsu(Decimal 給付率) {
        this.給付率 = 給付率;
    }

    @Override
    public Decimal value() {
        return 給付率;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof HokenKyufuRitsu)) {
            return false;
        }
        HokenKyufuRitsu other = (HokenKyufuRitsu) 比較対象;
        return Objects.equals(this.給付率, other.給付率);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.給付率);
        return hash;
    }

    @Override
    public Decimal getColumnValue() {
        return 給付率;
    }

    @Override
    public int compareTo(HokenKyufuRitsu 比較対象) {
        return Objects.compare(this.給付率, 比較対象.給付率, NaturalOrderComparator.ASC.getInstance());
    }
}
