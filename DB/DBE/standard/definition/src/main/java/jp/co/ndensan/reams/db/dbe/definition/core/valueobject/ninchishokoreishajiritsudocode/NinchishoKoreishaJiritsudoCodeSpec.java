/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudocode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinchishoKoreishaJiritsudoCode}の仕様クラスです。
 */
public enum NinchishoKoreishaJiritsudoCodeSpec implements IPredicate<NinchishoKoreishaJiritsudoCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {

                /**
                 *
                 * @param ninchishoKoreishaJiritsudoCode 認知症高齢者自立度コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NinchishoKoreishaJiritsudoCode ninchishoKoreishaJiritsudoCode) {
                    return true;
                }
            }
}
