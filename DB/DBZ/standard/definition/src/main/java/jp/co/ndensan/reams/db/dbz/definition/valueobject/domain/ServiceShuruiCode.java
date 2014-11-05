/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービス種類コードを表すクラスです。
 *
 * @author n8223 朴 義一
 */
public final class ServiceShuruiCode implements IValueObject<RString>, Comparable<ServiceShuruiCode>, IDbColumnMappable, Serializable {

    /**
     * 空の ServiceShuruiCode です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ServiceShuruiCode EMPTY;

    static {
        EMPTY = new ServiceShuruiCode(RString.EMPTY);
    }

    private final RString code;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public ServiceShuruiCode(String サービス種類コード) {
        this.code = (サービス種類コード == null) ? null : new RString(サービス種類コード);
    }

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public ServiceShuruiCode(RString サービス種類コード) {
        this.code = サービス種類コード;
    }

    @Override
    public RString value() {
        return code;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceShuruiCode)) {
            return false;
        }
        ServiceShuruiCode other = (ServiceShuruiCode) 比較対象;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return code;
    }

    @Override
    public int compareTo(ServiceShuruiCode 比較対象) {
        return Objects.compare(this.code, 比較対象.code, Comparators.NaturalOrderComparator.ASC.getInstance());
    }
}
