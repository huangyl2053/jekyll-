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
 * 通知書番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public final class TsuchishoNo implements IValueObject<RString>, Comparable<TsuchishoNo>, IDbColumnMappable, Serializable {

    /**
     * 空の TsuchishoNo です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final TsuchishoNo EMPTY;

    static {
        EMPTY = new TsuchishoNo(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 引数から通知書番号を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param tsuchishoNo 通知書番号
     */
    public TsuchishoNo(String tsuchishoNo) {
        this.theValue = (tsuchishoNo == null) ? null : new RString(tsuchishoNo);
    }

    /**
     * 引数から通知書番号を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param tsuchishoNo 通知書番号
     */
    public TsuchishoNo(RString tsuchishoNo) {
        this.theValue = tsuchishoNo;
    }

    @Override
    public RString value() {
        return theValue;
    }

    @Override
    public RString getColumnValue() {
        return theValue;
    }

    @Override
    public int compareTo(TsuchishoNo target) {
        return Objects.compare(this.theValue, target.theValue, Comparators.naturalOrder());
    }

    /**
     * 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}を返します。
     *
     * @return 保持する値が{@link #EMPTY EMPTY}と等しい時、{@code true}
     */
    public boolean isEmpty() {
        return Objects.equals(EMPTY.theValue, this.theValue);
    }

    @Override
    public boolean equals(Object target) {
        if (target == null) {
            return false;
        }
        if (!(target instanceof TsuchishoNo)) {
            return false;
        }
        TsuchishoNo other = (TsuchishoNo) target;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public String toString() {
        return theValue.toString();
    }
}
