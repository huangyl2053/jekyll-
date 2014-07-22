/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の取下げ理由です。
 *
 * @author N3327 三浦 凌
 */
public class TorisageRiyu {

    /**
     * RString.EMPTYをもった、TorisageRiyuです。
     */
    public static final TorisageRiyu EMPTY;

    static {
        EMPTY = new TorisageRiyu(RString.EMPTY);
    }
    private final RString torisageRiyu;

    /**
     * 指定のRStringをもったTorisageRiyuを生成します。
     *
     * @param 取下げ理由 取下げ理由
     */
    public TorisageRiyu(RString 取下げ理由) {
        this.torisageRiyu = isNull(取下げ理由) ? RString.EMPTY : 取下げ理由;
    }

    private static boolean isNull(Object target) {
        return target == null;
    }

    /**
     * 取下げ理由をRString型で返します。
     *
     * @return 取下げ理由
     */
    public RString asRString() {
        return this.torisageRiyu;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((TorisageRiyu) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.torisageRiyu);
        return hash;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(TorisageRiyu target) {
        return target.asRString().equals(this.torisageRiyu);
    }
}
