/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービス提供年月を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceTeikyoYM implements IDbColumnMappable, IValueObject, Comparable<ServiceTeikyoYM> {

    private final FlexibleYearMonth サービス提供年月;

    /**
     * インスタンスを生成します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public ServiceTeikyoYM(FlexibleYearMonth サービス提供年月) {
        this.サービス提供年月 = サービス提供年月;
    }

    @Override
    public FlexibleYearMonth value() {
        return サービス提供年月;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceTeikyoYM)) {
            return false;
        }
        return ((ServiceTeikyoYM) 比較対象).value().equals(サービス提供年月);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.サービス提供年月);
        return hash;
    }

    @Override
    public FlexibleYearMonth getColumnValue() {
        return サービス提供年月;
    }

    @Override
    public int compareTo(ServiceTeikyoYM 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
