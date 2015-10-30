/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteiyukokikantsukisu;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link NinteiYukoKikanTsukisu}の仕様クラスです。
 */
public enum NinteiYukoKikanTsukisuSpec implements IPredicate<NinteiYukoKikanTsukisu> {

    /**
     * 有効期間月数がNullでないこと。
     */
    有効期間月数がNullでないこと {
                /**
                 *
                 * @param ninteiYukoKikanTsukisu 認定有効期間月数
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(NinteiYukoKikanTsukisu ninteiyukokikantsukisu) {
                    return true;
                }
            }
}
