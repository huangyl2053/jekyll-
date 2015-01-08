/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * ランク区分です。
 *
 * @author N8156 宮本 康
 */
public final class RankKubun implements IValueObject<RString>, Comparable<RankKubun>, IDbColumnMappable {

    /**
     * 空の RankKubun です。{@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final RankKubun EMPTY;

    static {
        EMPTY = new RankKubun(RString.EMPTY);
    }
    private final RString theValue;

    /**
     * 指定の値をもった RankKubun を生成します。
     *
     * @param value 値
     */
    public RankKubun(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった RankKubun を生成します。
     *
     * @param value 値
     */
    public RankKubun(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(RankKubun o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RankKubun)) {
            return false;
        }
        RankKubun other = (RankKubun) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return theValue;
    }
}
