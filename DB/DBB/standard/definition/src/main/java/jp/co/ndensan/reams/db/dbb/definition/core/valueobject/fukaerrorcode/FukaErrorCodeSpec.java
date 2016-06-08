/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.valueobject.fukaerrorcode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link FukaErrorCode}の仕様クラスです。
 */
public enum FukaErrorCodeSpec implements IPredicate<FukaErrorCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * コードがNullでない場合にtrueを返す。
                 *
                 * @param fukaErrorCode 賦課のエラーコード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(FukaErrorCode fukaErrorCode) {
                    return true;
                }
            };
}
