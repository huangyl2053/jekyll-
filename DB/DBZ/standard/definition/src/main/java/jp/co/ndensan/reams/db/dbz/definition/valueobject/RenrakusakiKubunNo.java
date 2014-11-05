/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NaturalOrderComparator;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連絡先区分番号です。<br/>
 * ひとりの被保険者に対して複数件の連絡の情報がある場合に、その中のひとつを特定するための番号です。
 *
 * @author N3327 三浦 凌
 */
public final class RenrakusakiKubunNo implements IValueObject<RString>, Comparable<RenrakusakiKubunNo> {

    /**
     * 空の RenrakusakiKubunNo です。
     * {@link #value() value()}で{@link RString#EMPTY}を返します。
     */
    public static final RenrakusakiKubunNo EMPTY;

    static {
        EMPTY = new RenrakusakiKubunNo(RString.EMPTY);
    }

    private final RString theValue;

    /**
     * 指定の値をもった RenrakusakiKubunNo を生成します。
     *
     * @param value 値
     */
    public RenrakusakiKubunNo(String value) {
        this.theValue = (value == null) ? null : new RString(value);
    }

    /**
     * 指定の値をもった RenrakusakiKubunNo を生成します。
     *
     * @param value 値
     */
    public RenrakusakiKubunNo(RString value) {
        this.theValue = value;
    }

    @Override
    public RString value() {
        return this.theValue;
    }

    @Override
    public int compareTo(RenrakusakiKubunNo o) {
        return Objects.compare(this.theValue, o.theValue, NaturalOrderComparator.ASC.getInstance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenrakusakiKubunNo)) {
            return false;
        }
        RenrakusakiKubunNo other = (RenrakusakiKubunNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.theValue);
        return hash;
    }
}
