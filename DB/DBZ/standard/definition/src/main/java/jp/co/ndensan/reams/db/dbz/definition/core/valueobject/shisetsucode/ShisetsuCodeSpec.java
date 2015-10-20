/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.shisetsucode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShisetsuCode}の仕様クラスです。
 */
public enum ShisetsuCodeSpec implements IPredicate<ShisetsuCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                /**
                 *
                 * @param shisetsuCode 施設コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShisetsuCode shisetsuCode) {
                    return true;
                }

            }
}
