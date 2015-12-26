/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hiho;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.PresenceValidator;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author LDNS chenty
 */
public enum HihokenshaShikakuHakkoSpec implements IPredicate<RString> {

    /**
     * 交付事由が選択されていること
     */
    交付事由が選択されていること {
                @Override
                public boolean apply(RString 交付事由) {
                    boolean res = false;
                    if (!PresenceValidator.isValid(交付事由)) {
                        res = true;
                    }
                    return res;
                }
            },
}
