/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.IKaigoValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 連絡先区分番号のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class RenrakusakiKubunNo implements IKaigoValueObject<RString, RenrakusakiKubunNo> {

    private static RString name = new RString("連絡先区分番号");
    private static final int PERMISSIBLE_LENGTH = 8;
    private final RString 連絡先区分番号;

    /**
     * 指定の値を持った、RenrakusakiKubunNoを生成します。
     *
     * @param value 連絡先区分番号に相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき
     * @throws IllegalArgumentException 指定のRStringが8桁でないとき
     */
    public RenrakusakiKubunNo(RString value) throws NullPointerException, IllegalArgumentException {
        requireNonNull(value, Messages.E00003.replace(name.toString(), getClass().getName()).getMessage());
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
        if ((target == null) || (target.getClass() != getClass())) {
            return false;
        }
        return ((RenrakusakiKubunNo) target).value().equals(this.連絡先区分番号);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.連絡先区分番号);
        return hash;
    }

    private void validate(RString value) throws IllegalArgumentException {
        if (value.length() != PERMISSIBLE_LENGTH) {
            throw new IllegalArgumentException(Messages.E00013.replace(name.toString(), PERMISSIBLE_LENGTH + "桁").getMessage());
        }
    }
}
