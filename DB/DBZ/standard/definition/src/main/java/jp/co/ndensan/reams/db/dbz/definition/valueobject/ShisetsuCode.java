/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.message.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設コードを表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class ShisetsuCode implements IValueObject<RString>, Comparable<ShisetsuCode>, Serializable {

    private final RString 施設コード;

    /**
     * 指定の値を持った、ShisetsuCodeを生成します。
     *
     * @param value 施設コードの値
     */
    public ShisetsuCode(RString value) {
        requireNonNull(value, Messages.E00003.replace("施設Code", getClass().getName()).getMessage());
        this.施設コード = value;
    }

    @Override
    public RString value() {
        return this.施設コード;
    }

    @Override
    public int compareTo(ShisetsuCode target) {
        return this.施設コード.compareTo(target.value());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ShisetsuCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.施設コード);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShisetsuCode target) {
        return target.value().equals(this.施設コード);
    }
}
