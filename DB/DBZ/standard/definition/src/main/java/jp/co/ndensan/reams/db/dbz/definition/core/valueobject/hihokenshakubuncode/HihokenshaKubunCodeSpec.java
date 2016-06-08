/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hihokenshakubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link HihokenshaKubunCode}の仕様クラスです。
 */
public enum HihokenshaKubunCodeSpec implements IPredicate<HihokenshaKubunCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * @param hihokenshakubuncode 保険者区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(HihokenshaKubunCode hihokenshakubuncode) {
                    return true;
                }
            }
}
