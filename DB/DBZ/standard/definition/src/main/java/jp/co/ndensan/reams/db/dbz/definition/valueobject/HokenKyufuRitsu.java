/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 給付率
 * 
 * @author n8223
 */
public class HokenKyufuRitsu implements IValueObject, IDbColumnMappable, Comparable<HokenKyufuRitsu> {

    private final  Decimal hokenKyufuRitsu;
         

    /**
     * コンストラクタです
     *
     * @param 給付率 給付率
     */
    public HokenKyufuRitsu(Decimal hokenKyufuRitsu) {
        this.hokenKyufuRitsu = hokenKyufuRitsu;
    }

    @Override
    public Decimal value() {
        return hokenKyufuRitsu;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof JigyoshaNo)) {
            return false;
        }
        return ((HokenKyufuRitsu) 比較対象).value().equals(hokenKyufuRitsu);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.hokenKyufuRitsu);
        return hash;
    }

    /**
     * 給付率を取得します
     *
     * @return 給付率
     */
    @Override
    public Decimal getColumnValue() {
        return hokenKyufuRitsu;
    }

    @Override
    public int compareTo(HokenKyufuRitsu 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
