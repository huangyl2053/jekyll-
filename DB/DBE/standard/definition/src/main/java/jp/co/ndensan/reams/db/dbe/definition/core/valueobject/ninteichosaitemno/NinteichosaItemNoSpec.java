/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosaitemno;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinteichosaItemNo}の仕様クラスです。
 */
public enum NinteichosaItemNoSpec implements IPredicate<NinteichosaItemNo> {

    /**
     * 番号がNullでないこと。
     */
    番号がNullでないこと {
                /**
                 *
                 * @param ninteichosaItemNo 要介護認定調査の調査項目番号
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override

                public boolean apply(NinteichosaItemNo ninteichosaItemNo) {
                    return true;
                }
            }
}
