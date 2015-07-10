/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.message.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票交付履歴IDです。
 *
 * @author N3327 三浦 凌
 */
public class ChohyoKofuRirekiID implements IValueObject<RString>, Comparable<ChohyoKofuRirekiID> {

    private final RString 帳票交付履歴ID;

    /**
     * 指定の値をもった、ChohyoKofuRirekiIDを生成します。
     *
     * @param value 帳票交付履歴IDに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public ChohyoKofuRirekiID(RString value) throws NullPointerException {
        requireNonNull(value, Messages.E00003.replace("value", getClass().getName()).getMessage());
        this.帳票交付履歴ID = value;
    }

    @Override
    public RString value() {
        return this.帳票交付履歴ID;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ChohyoKofuRirekiID) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.帳票交付履歴ID);
        return hash;
    }

    @Override
    public int compareTo(ChohyoKofuRirekiID target) {
        return this.帳票交付履歴ID.compareTo(target.value());
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ChohyoKofuRirekiID target) {
        return target.value().equals(this.帳票交付履歴ID);
    }
}
