/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.shikakuhenkojiyu;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShikakuHenkoJiyu}の仕様クラスです。
 */
public enum ShikakuHenkoJiyuSpec implements IPredicate<ShikakuHenkoJiyu> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                @Override
                public boolean apply(ShikakuHenkoJiyu t) {
                    return true;
                }
            },
    /**
     * 名称がNullでないこと
     */
    名称がNullでないこと {

                @Override
                public boolean apply(ShikakuHenkoJiyu t) {
                    return true;
                }
            };
}
