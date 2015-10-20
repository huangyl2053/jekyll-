/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.yokaigojotaikubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link YokaigoJotaiKubunCode}の仕様クラスです。
 */
public enum YokaigoJotaiKubunCodeSpec implements IPredicate<YokaigoJotaiKubunCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                /**
                 *
                 * @param yokaigoJotaiKubunCode 要介護状態区分コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(YokaigoJotaiKubunCode yokaigoJotaiKubunCode) {
                    return true;
                }
            }
}
