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
 * サービス種類コードを表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceShuruiCode implements IDbColumnMappable, IValueObject, Comparable<ServiceShuruiCode> {

    private final RString serviceShuruiCode;

    /**
     * インスタンスを生成します。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public ServiceShuruiCode(RString serviceShuruiCode) throws NullPointerException {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    @Override
    public RString value() {
        return serviceShuruiCode;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceShuruiCode)) {
            return false;
        }
        return ((ServiceShuruiCode) 比較対象).value().equals(serviceShuruiCode);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.serviceShuruiCode);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return serviceShuruiCode;
    }

    @Override
    public int compareTo(ServiceShuruiCode 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
