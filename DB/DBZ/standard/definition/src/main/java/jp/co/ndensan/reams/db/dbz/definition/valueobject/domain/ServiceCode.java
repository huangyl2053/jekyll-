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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービスコードを表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class ServiceCode implements IValueObject<RString>, Comparable<ServiceCode>, IDbColumnMappable, Serializable {

    /**
     * 空の ServiceCode です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ServiceCode EMPTY;

    static {
        EMPTY = new ServiceCode(RString.EMPTY);
    }
    private final RString code;

    /**
     * 指定した値からサービスコードを生成します。
     *
     * @param code サービスコード サービスコード
     */
    public ServiceCode(String code) {
        this.code = (code == null) ? null : new RString(code);
    }

    /**
     * 指定した値からサービスコードを生成します。
     *
     * @param code サービスコード
     */
    public ServiceCode(RString code) {
        this.code = code;
    }

    @Override
    public RString value() {
        return code;
    }

    @Override
    public RString getColumnValue() {
        return code;
    }

    @Override
    public int compareTo(ServiceCode 比較対象) {
        return Objects.compare(this.code, 比較対象.code, NaturalOrderComparator.ASC.getInstance());
    }

    /**
     * {@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return {@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return EMPTY.equals(this);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ServiceCode)) {
            return false;
        }
        ServiceCode other = (ServiceCode) 比較対象;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.code);
        return hash;
    }
}
