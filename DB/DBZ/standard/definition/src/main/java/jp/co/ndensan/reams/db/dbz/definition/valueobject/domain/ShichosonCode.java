/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 市町村コードを表すクラスです。
 *
 * @author n8223　朴義一
 */
public class ShichosonCode implements IValueObject<RString>, Comparable<ShichosonCode>, IDbColumnMappable, Serializable {

    /**
     * 空の ShichosonCode です。 {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ShichosonCode EMPTY;

    static {
        EMPTY = new ShichosonCode(RString.EMPTY);
    }

    private final RString code;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード 市町村コード
     */
    public ShichosonCode(String 市町村コード) {
        this.code = (市町村コード == null) ? null : new RString(市町村コード);
    }

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード 市町村コード
     */
    public ShichosonCode(RString 市町村コード) {
        this.code = 市町村コード;
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
    public int compareTo(ShichosonCode 比較対象) {
        return Objects.compare(this.code, 比較対象.code, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.code, this.code);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShichosonCode other = (ShichosonCode) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.code);
        return hash;
    }

}
