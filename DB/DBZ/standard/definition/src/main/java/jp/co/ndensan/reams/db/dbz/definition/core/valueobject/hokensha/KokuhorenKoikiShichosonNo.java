/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連広域内市町村番号クラスです。
 *
 * @author N3327 三浦 凌
 */
public final class KokuhorenKoikiShichosonNo implements IValueObject<RString>, Comparable<KokuhorenKoikiShichosonNo>, Serializable {

    private static final int three = 3;
    /**
     * 空の{@link KokuhorenKoikiShichosonNo}です。
     */
    public static final KokuhorenKoikiShichosonNo EMPTY;
    /**
     * 最大長です。
     */
    public static final int MAX_LENGTH;

    static {
        EMPTY = new KokuhorenKoikiShichosonNo(RString.EMPTY);
        MAX_LENGTH = 3;
    }

    private final RString theValue;

    /**
     * 指定の値をもった KokuhorenKoikiShichosonNo を生成します。
     *
     * @param value 値
     */
    public KokuhorenKoikiShichosonNo(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった KokuhorenKoikiShichosonNo を生成します。
     *
     * @param value 値
     */
    public KokuhorenKoikiShichosonNo(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(KokuhorenKoikiShichosonNo o) {
        return this.theValue.compareTo(o.theValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KokuhorenKoikiShichosonNo)) {
            return false;
        }
        KokuhorenKoikiShichosonNo other = (KokuhorenKoikiShichosonNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.theValue);
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
