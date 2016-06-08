/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.suiteikyuhukubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link SuiteiKyuhuKubunCode}の仕様クラスです。
 */
public enum SuiteiKyuhuKubunCodeSpec implements IPredicate<SuiteiKyuhuKubunCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * @param suiteiKyuhuKubunCode 推定給付区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(SuiteiKyuhuKubunCode suiteiKyuhuKubunCode) {
                    return true;
                }
            }
}
