/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.noryokumiteikaninchishokoreishashihyocode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NoryokuMiteikaNinchishoKoreishaShihyoCode}の仕様クラスです。
 */
public enum NoryokuMiteikaNinchishoKoreishaShihyoCodeSpec implements IPredicate<NoryokuMiteikaNinchishoKoreishaShihyoCode> {

    コードがNullでないこと {

                /**
                 *
                 * @param noryokuKoreishaShihyoCode 運動能力未低下認知症高齢者の指標コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NoryokuMiteikaNinchishoKoreishaShihyoCode noryokuKoreishaShihyoCode) {
                    return true;
                }
            }
}
