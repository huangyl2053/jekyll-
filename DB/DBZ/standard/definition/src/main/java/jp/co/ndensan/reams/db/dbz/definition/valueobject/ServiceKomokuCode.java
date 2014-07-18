/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービス項目コードを表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceKomokuCode implements IDbColumnMappable, IValueObject, Comparable<ServiceKomokuCode> {

    private final RString serviceKomokuCode;

    /**
     * インスタンスを生成します。
     *
     * @param serviceKomokuCode サービス項目コード
     */
    public ServiceKomokuCode(RString serviceKomokuCode) throws NullPointerException {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    @Override
    public RString value() {
        return serviceKomokuCode;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceKomokuCode)) {
            return false;
        }
        return ((ServiceKomokuCode) 比較対象).value().equals(serviceKomokuCode);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.serviceKomokuCode);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return serviceKomokuCode;
    }

    @Override
    public int compareTo(ServiceKomokuCode 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
