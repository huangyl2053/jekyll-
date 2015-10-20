/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ichijihanteikeikokucode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link IchijiHanteiKeikokuCode}の仕様クラスです。
 */
public enum IchijiHanteiKeikokuCodeSpec implements IPredicate<IchijiHanteiKeikokuCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {

                /**
                 *
                 * @param ichijiHanteiKeikokuCode 一次判定警告コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(IchijiHanteiKeikokuCode ichijiHanteiKeikokuCode) {
                    return true;
                }
            }
}
