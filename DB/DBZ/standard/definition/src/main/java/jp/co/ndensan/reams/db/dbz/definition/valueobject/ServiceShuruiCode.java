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

    private final RString サービス種類コード;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public ServiceShuruiCode(RString サービス種類コード) {
        this.サービス種類コード = サービス種類コード;
    }

    @Override
    public RString value() {
        return サービス種類コード;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceShuruiCode)) {
            return false;
        }
        return ((ServiceShuruiCode) 比較対象).value().equals(サービス種類コード);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.サービス種類コード);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return サービス種類コード;
    }

    @Override
    public int compareTo(ServiceShuruiCode 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
