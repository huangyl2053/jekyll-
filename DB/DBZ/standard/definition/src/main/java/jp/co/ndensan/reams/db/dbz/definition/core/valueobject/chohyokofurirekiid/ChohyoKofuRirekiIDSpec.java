/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.chohyokofurirekiid;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ChohyoKofuRirekiID}の仕様クラスです。
 */
public enum ChohyoKofuRirekiIDSpec implements IPredicate<ChohyoKofuRirekiID> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * @param chohyoKofuRirekiID 帳票交付履歴ID
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ChohyoKofuRirekiID chohyoKofuRirekiID) {
                    return true;
                }
            }
}
