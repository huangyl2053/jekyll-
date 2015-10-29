/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaino;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShinsakaiKaisaiNo}の仕様クラスです。
 */
public enum ShinsakaiKaisaiNoSpec implements IPredicate<ShinsakaiKaisaiNo> {

    /**
     * 番号がNullでないこと。
     */
    番号がNullでないこと {
                /**
                 *
                 * @param shinsakaiKaisaiNo 審査会開催番号
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShinsakaiKaisaiNo shinsakaiKaisaiNo) {
                    return true;
                }
            }
}
