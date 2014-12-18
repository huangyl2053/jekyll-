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
 * 交換情報識別番号を表すクラスです。
 *
 * @author n8223 朴 義一
 */
public final class KokanShikibetsuNo implements IValueObject<RString>, Comparable<KokanShikibetsuNo>, IDbColumnMappable, Serializable {

    /**
     * 空の KokanShikibetsuNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final KokanShikibetsuNo EMPTY;

    static {
        EMPTY = new KokanShikibetsuNo(RString.EMPTY);
    }

    private final RString 交換情報識別番号;

    /**
     * インスタンスを生成します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokanShikibetsuNo(String 交換情報識別番号) {
        this.交換情報識別番号 = (交換情報識別番号 == null) ? null : new RString(交換情報識別番号);
    }

    /**
     * インスタンスを生成します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokanShikibetsuNo(RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
    }

    @Override
    public RString value() {
        return 交換情報識別番号;
    }

    @Override
    public RString getColumnValue() {
        return 交換情報識別番号;
    }

    @Override
    public int compareTo(KokanShikibetsuNo 比較対象) {
        return Objects.compare(this.交換情報識別番号, 比較対象.交換情報識別番号, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.交換情報識別番号, this.交換情報識別番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KokanShikibetsuNo)) {
            return false;
        }
        KokanShikibetsuNo other = (KokanShikibetsuNo) 比較対象;
        return Objects.equals(this.交換情報識別番号, other.交換情報識別番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.交換情報識別番号);
        return hash;
    }
}
