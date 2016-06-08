/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.kaigoninteichosainno;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link KaigoNinteichosainNo}の仕様クラスです。
 */
public enum KaigoNinteichosainNoSpec implements IPredicate<KaigoNinteichosainNo> {

    /**
     * 番号がNullでないこと。
     */
    番号がNullでないこと {
                /**
                 *
                 * @param kaigoNinteichosainNo 介護独自の認定調査員番号
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override

                public boolean apply(KaigoNinteichosainNo kaigoNinteichosainNo) {
                    return true;
                }
            }
}
