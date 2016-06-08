/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.inputshikibetsunocode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link InputShikibetsuNoCode}の仕様クラスです。
 */
public enum InputShikibetsuNoCodeSpec implements IPredicate<InputShikibetsuNoCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * @param inputShikibetsuNoCode 入力識別番号コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(InputShikibetsuNoCode inputShikibetsuNoCode) {
                    return true;
                }
            }
}
