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
 * サービス項目コードを表すクラスです。
 *
 * @author n8223 朴 義一
 */
public class ServiceKomokuCode implements IValueObject, Comparable<ServiceKomokuCode>, IDbColumnMappable, Serializable {

    /**
     * 空の ServiceKomokuCode
     * です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ServiceKomokuCode EMPTY;

    static {
        EMPTY = new ServiceKomokuCode(RString.EMPTY);
    }

    private final RString code;

    /**
     * インスタンスを生成します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public ServiceKomokuCode(String サービス項目コード) {
        this.code = (サービス項目コード == null) ? null : new RString(サービス項目コード);
    }

    /**
     * インスタンスを生成します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public ServiceKomokuCode(RString サービス項目コード) {
        this.code = サービス項目コード;
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
        if (!(比較対象 instanceof ServiceKomokuCode)) {
            return false;
        }
        ServiceKomokuCode other = (ServiceKomokuCode) 比較対象;
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
    public int compareTo(ServiceKomokuCode 比較対象) {
        return Objects.compare(this.code, 比較対象.code, Comparators.NaturalOrderComparator.ASC.getInstance());
    }
}
