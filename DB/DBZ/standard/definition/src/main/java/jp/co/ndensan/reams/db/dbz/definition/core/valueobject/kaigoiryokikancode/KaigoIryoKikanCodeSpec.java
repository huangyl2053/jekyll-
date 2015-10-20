/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link KaigoIryoKikanCode}の仕様クラスです。
 */
public enum KaigoIryoKikanCodeSpec implements IPredicate<KaigoIryoKikanCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {
                /**
                 *
                 * @param kaigoIryoKikanCode 介護医療機関コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KaigoIryoKikanCode kaigoIryoKikanCode) {
                    return true;
                }
            }
}
