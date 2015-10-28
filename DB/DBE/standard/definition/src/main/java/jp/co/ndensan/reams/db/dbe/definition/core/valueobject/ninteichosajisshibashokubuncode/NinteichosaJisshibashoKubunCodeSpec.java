/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosajisshibashokubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinteichosaJisshibashoKubunCode}の仕様クラスです。
 */
public enum NinteichosaJisshibashoKubunCodeSpec implements IPredicate<NinteichosaJisshibashoKubunCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {

                /**
                 *
                 * @param ninteichosaJisshibashoKubunCode 要介護認定調査の実施場所区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NinteichosaJisshibashoKubunCode ninteichosaJisshibashoKubunCode) {
                    return true;
                }
            }
}
