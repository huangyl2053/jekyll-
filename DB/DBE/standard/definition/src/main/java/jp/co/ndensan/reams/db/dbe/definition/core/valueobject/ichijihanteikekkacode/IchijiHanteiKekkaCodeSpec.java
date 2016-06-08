/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ichijihanteikekkacode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link IchijiHanteiKekkaCode}の仕様クラスです。
 */
public enum IchijiHanteiKekkaCodeSpec implements IPredicate<IchijiHanteiKekkaCode> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {

                /**
                 *
                 * @param ichijiHanteiKekkaCode 一次判定結果コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(IchijiHanteiKekkaCode ichijiHanteiKekkaCode) {
                    return true;
                }
            }
}
