/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービス提供年月を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceTeikyoYM implements IDbColumnMappable, IValueObject, Comparable<ServiceTeikyoYM> {

    private final FlexibleDate serviceTeikyoYM;

    /**
     * インスタンスを生成します。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public ServiceTeikyoYM(FlexibleDate serviceTeikyoYM) throws NullPointerException {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    @Override
    public FlexibleDate value() {
        return serviceTeikyoYM;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KokanShikibetsuNo)) {
            return false;
        }
        return ((ServiceTeikyoYM) 比較対象).value().equals(serviceTeikyoYM);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.serviceTeikyoYM);
        return hash;
    }

    @Override
    public FlexibleDate getColumnValue() {
        return serviceTeikyoYM;
    }

    @Override
    public int compareTo(ServiceTeikyoYM 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
