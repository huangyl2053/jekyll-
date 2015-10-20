/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.jotaianteiseicode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link JotaiAnteiseiCode}の仕様クラスです。
 */
public enum JotaiAnteiseiCodeSpec implements IPredicate<JotaiAnteiseiCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                /**
                 *
                 * @param jotaiAnteiseiCode 要介護認定状態の安定性コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(JotaiAnteiseiCode jotaiAnteiseiCode) {
                    return true;
                }
            }
}
