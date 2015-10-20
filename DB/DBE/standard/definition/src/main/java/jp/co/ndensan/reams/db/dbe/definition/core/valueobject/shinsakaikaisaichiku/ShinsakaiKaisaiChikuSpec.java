/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaichiku;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShinsakaiKaisaiChiku}の仕様クラスです。
 */
public enum ShinsakaiKaisaiChikuSpec implements IPredicate<ShinsakaiKaisaiChiku> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {
                /**
                 *
                 * @param shinsakaiKaisaiChiku 介護認定審査会の開催地区
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShinsakaiKaisaiChiku shinsakaiKaisaiChiku) {
                    return true;
                }
            }
}
