/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.ninteiinput;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author LDNS chenty
 */
public enum NinteiInputSpec implements IPredicate<FlexibleDate> {

    /**
     * 入力がEmptyでないこと
     */
    入力がEmptyでないこと {
                @Override
                public boolean apply(FlexibleDate 有効開始年月日) {
                    boolean res = true;
                    if (!有効開始年月日.isEmpty()) {
                        res = false;
                    }
                    return res;
                }
            },
}
