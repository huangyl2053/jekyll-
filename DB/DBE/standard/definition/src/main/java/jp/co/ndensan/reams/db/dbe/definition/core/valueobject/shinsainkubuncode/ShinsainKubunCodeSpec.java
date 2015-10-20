/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsainkubuncode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShinsainKubunCode}の仕様クラスです。
 */
public enum ShinsainKubunCodeSpec implements IPredicate<ShinsainKubunCode> {

    コードがNullでないこと {

                /**
                 *
                 * @param shinsainKubunCode 介護認定審査会での、委員としての役割コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShinsainKubunCode shinsainKubunCode) {
                    return true;
                }
            }
}
