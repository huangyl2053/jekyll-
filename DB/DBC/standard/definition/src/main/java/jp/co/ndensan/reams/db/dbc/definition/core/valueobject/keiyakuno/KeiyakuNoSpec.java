/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link KeiyakuNo}の仕様クラスです。
 */
public enum KeiyakuNoSpec implements IPredicate<KeiyakuNo> {

    /**
     * 番号がNullでないこと。
     */
    番号がNullでないこと {
                /**
                 *
                 * コードがNullでない場合にtrueを返す。
                 *
                 * @param keiyakuNo 賦課のエラーコード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KeiyakuNo keiyakuNo) {
                    return true;
                }
            };
}
