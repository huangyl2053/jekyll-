/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaichokubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link GogitaichoKubunCode}の仕様クラスです。
 */
public enum GogitaichoKubunCodeSpec implements IPredicate<GogitaichoKubunCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {

                /**
                 *
                 * @param gogitaichoKubunCode 合議体（介護認定審査会）の長や長代理、委員などの区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(GogitaichoKubunCode gogitaichoKubunCode) {
                    return true;
                }
            };
}
