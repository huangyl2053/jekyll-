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
 * 入力識別番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public final class NyuryokuShikibetsuNo implements IValueObject<RString>, Comparable<NyuryokuShikibetsuNo>, IDbColumnMappable, Serializable {

    /**
     * 空の NyuryokuShikibetsuNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final NyuryokuShikibetsuNo EMPTY;

    static {
        EMPTY = new NyuryokuShikibetsuNo(RString.EMPTY);
    }

    private final RString 入力識別番号;

    /**
     * 文字列を受け取り、インスタンスを生成します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public NyuryokuShikibetsuNo(String 入力識別番号) {
        this.入力識別番号 = (入力識別番号 == null) ? null : new RString(入力識別番号);
    }

    /**
     * 文字列を受け取り、インスタンスを生成します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public NyuryokuShikibetsuNo(RString 入力識別番号) {
        this.入力識別番号 = 入力識別番号;
    }

    @Override
    public RString value() {
        return 入力識別番号;
    }

    @Override
    public RString getColumnValue() {
        return 入力識別番号;
    }

    @Override
    public int compareTo(NyuryokuShikibetsuNo 比較対象) {
        return Objects.compare(this.入力識別番号, 比較対象.入力識別番号, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.入力識別番号, this.入力識別番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof NyuryokuShikibetsuNo)) {
            return false;
        }
        NyuryokuShikibetsuNo other = (NyuryokuShikibetsuNo) 比較対象;
        return Objects.equals(this.入力識別番号, other.入力識別番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.value());
        return hash;
    }
}
