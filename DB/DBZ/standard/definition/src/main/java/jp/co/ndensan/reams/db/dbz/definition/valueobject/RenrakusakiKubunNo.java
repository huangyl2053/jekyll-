/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * 連絡先区分番号です。<br />
 * ひとりの被保険者に対して複数件連絡の情報がある場合に、その中からひとつを特定するための番号です。
 *
 * @author N3327 三浦 凌
 */
public class RenrakusakiKubunNo implements IValueObject<RString>, Comparable<RenrakusakiKubunNo> {

    private static final int PERMISSIBLE_LENGTH = 8;
    /**
     * 連絡先区分番号がないことを表す値です。
     */
    public static final RenrakusakiKubunNo NULL_VALUE;

    static {
        NULL_VALUE = new RenrakusakiKubunNo(new RString("        "));
    }
    private final RString 連絡先区分番号;

    /**
     * 指定の値を持った、RenrakusakiKubunNoを生成します。
     *
     * @param value 連絡先区分番号に相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき
     * @throws IllegalArgumentException 指定のRStringが8桁でないとき
     */
    public RenrakusakiKubunNo(RString value) throws NullPointerException, IllegalArgumentException {
        requireNonNull(value, Messages.E00003.replace("value", getClass().getName()).getMessage());
        validate(value);
        this.連絡先区分番号 = value;
    }

    @Override
    public RString value() {
        return this.連絡先区分番号;
    }

    @Override
    public int compareTo(RenrakusakiKubunNo target) {
        return this.連絡先区分番号.compareTo(target.value());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((RenrakusakiKubunNo) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.連絡先区分番号);
        return hash;
    }

    private void validate(RString value) throws IllegalArgumentException {
        if (value.length() != PERMISSIBLE_LENGTH) {
            throw new IllegalArgumentException(Messages.E00013.replace("連絡先区分番号", PERMISSIBLE_LENGTH + "桁").getMessage());
        }
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(RenrakusakiKubunNo target) {
        return target.value().equals(this.連絡先区分番号);
    }
}
