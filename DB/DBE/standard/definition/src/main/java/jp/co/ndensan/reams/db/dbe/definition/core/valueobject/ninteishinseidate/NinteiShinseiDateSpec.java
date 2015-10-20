/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteishinseidate;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinteiShinseiDate}の仕様クラスです。
 */
public enum NinteiShinseiDateSpec implements IPredicate<NinteiShinseiDate> {

    /**
     * 申請年月日がNullでないこと
     */
    申請年月日がNullでないこと {

                /**
                 *
                 * @param ninteiShinseiDate 認定申請年月日
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NinteiShinseiDate ninteishinseidate) {
                    return true;
                }
            }
}
