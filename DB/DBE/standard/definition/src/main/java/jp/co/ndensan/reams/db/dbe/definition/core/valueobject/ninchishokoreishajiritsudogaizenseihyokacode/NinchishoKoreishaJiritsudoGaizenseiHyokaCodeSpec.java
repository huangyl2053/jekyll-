/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudogaizenseihyokacode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinchishoKoreishaJiritsudoGaizenseiHyokaCode}の仕様クラスです。
 */
public enum NinchishoKoreishaJiritsudoGaizenseiHyokaCodeSpec implements IPredicate<NinchishoKoreishaJiritsudoGaizenseiHyokaCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * @param ninchishoKoreishaJiritsudoGaizenseiHyokaCode
                 * 認知症高齢者自立度の蓋然性評価コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NinchishoKoreishaJiritsudoGaizenseiHyokaCode ninchishoKoreishaJiritsudoGaizenseiHyokaCode) {
                    return true;
                }
            }
}
