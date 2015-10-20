/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiinshikakucode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShinsakaiIinShikakuCode}の仕様クラスです。
 */
public enum ShinsakaiIinShikakuCodeSpec implements IPredicate<ShinsakaiIinShikakuCode> {

    コードがNullでないこと {

                /**
                 *
                 * @param shinsakaiIinShikakuCode 介護認定審査会委員資格コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShinsakaiIinShikakuCode shinsakaiiinshikakucode) {
                    return true;
                }
            }
}
