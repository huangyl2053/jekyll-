/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 申請書管理番号を表すドメインです。
 *
 * @author n8178 城間篤人
 */
public final class ShinseishoKanriNo implements IValueObject<RString>, Comparable<ShinseishoKanriNo>, IDbColumnMappable, Serializable {

    /**
     * 空の ShinseishoKanriNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final ShinseishoKanriNo EMPTY;

    static {
        EMPTY = new ShinseishoKanriNo(RString.EMPTY);
    }

    private final RString 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinseishoKanriNo(String 申請書管理番号) {
        this.申請書管理番号 = (申請書管理番号 == null) ? null : new RString(申請書管理番号);
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinseishoKanriNo(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

    @Override
    public RString value() {
        return 申請書管理番号;
    }

    @Override
    public RString getColumnValue() {
        return 申請書管理番号;
    }

    @Override
    public int compareTo(ShinseishoKanriNo 比較対象) {
        return Objects.compare(this.申請書管理番号, 比較対象.申請書管理番号, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.申請書管理番号, this.申請書管理番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof ShinseishoKanriNo)) {
            return false;
        }
        ShinseishoKanriNo other = (ShinseishoKanriNo) 比較対象;
        return Objects.equals(this.申請書管理番号, other.申請書管理番号);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.申請書管理番号);
        return hash;
    }
}
