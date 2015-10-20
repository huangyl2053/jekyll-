/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.tokuteishippeicode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link TokuteiShippeiCode}の仕様クラスです。
 */
public enum TokuteiShippeiCodeSpec implements IPredicate<TokuteiShippeiCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                /**
                 *
                 * @param tokuteiShippeiCode 要介護状態区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(TokuteiShippeiCode tokuteiShippeiCode) {
                    return true;
                }
            }
}
