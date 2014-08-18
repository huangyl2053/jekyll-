/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の申請理由です。
 *
 * @author N3327 三浦 凌
 */
public class NinteiShinseiRiyu {

    /**
     * 申請理由がないことを表します。
     */
    public static final NinteiShinseiRiyu EMPTY;

    static {
        EMPTY = new NinteiShinseiRiyu(RString.EMPTY);
    }
    private final RString shinseiRiyu;

    /**
     * NinteiShinseiRiyuを生成します。
     *
     * @param 申請理由 申請理由
     */
    public NinteiShinseiRiyu(RString 申請理由) {
        this.shinseiRiyu = isNull(申請理由) ? RString.EMPTY : 申請理由;
    }

    private static boolean isNull(Object target) {
        return target == null;
    }

    /**
     * 申請理由をRStringで返します。
     *
     * @return 申請理由
     */
    public RString asRString() {
        return this.shinseiRiyu;
    }
}
