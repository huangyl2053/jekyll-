/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link KaigoJigyoshaNo}の仕様クラスです。
 */
public enum KaigoJigyoshaNoSpec implements IPredicate<KaigoJigyoshaNo> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {
                /**
                 *
                 * @param kaigoJigyoshaNo 認定調査委託先コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KaigoJigyoshaNo kaigoJigyoshaNo) {
                    return true;
                }
            }
}
