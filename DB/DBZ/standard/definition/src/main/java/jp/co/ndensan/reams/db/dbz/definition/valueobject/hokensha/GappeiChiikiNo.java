/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村同士を結びつけるための番号です。
 *
 * @author N3327 三浦 凌
 */
public final class GappeiChiikiNo implements IValueObject<RString>, Comparable<GappeiChiikiNo>, Serializable {

    /**
     * 空の GappeiLinkNo です。
     * {@link #value() value()}で{@link RString#EMPTY RString.EMPTY}を返します。
     */
    public static final GappeiChiikiNo EMPTY;
    /**
     *
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new GappeiChiikiNo();
        MAX_LENGTH = 2;
    }

    /**
     * {@link #EMPTY}を生成するためのプライベートコンストラクタです。
     */
    private GappeiChiikiNo() {
        this.theValue = RString.EMPTY;
    }

    private final RString theValue;

    /**
     * GappeiLinkNo を生成します。
     *
     * @param value 値
     */
    public GappeiChiikiNo(String value) {
        if (value == null) {
            this.theValue = null;
        } else {
            this.theValue = new RString(value);
        }
    }

    /**
     * GappeiLinkNo を生成します。
     *
     * @param value 値
     */
    public GappeiChiikiNo(RString value) throws NullPointerException {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(GappeiChiikiNo o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GappeiChiikiNo)) {
            return false;
        }
        GappeiChiikiNo other = (GappeiChiikiNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    /**
     * 最大長以下の値を持つかどうかを返します。
     *
     * @return 最大長以下の値を持つ場合、{@code true}。
     */
    public boolean hasValidLength() {
        if (this.theValue == null) {
            return true;
        }
        return this.theValue.length() <= MAX_LENGTH;
    }
}
