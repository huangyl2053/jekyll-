/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikenshoitemno;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShujiiIkenshoItemNo}の仕様クラスです。
 */
public enum ShujiiIkenshoItemNoSpec implements IPredicate<ShujiiIkenshoItemNo> {

    /**
     * 番号がNullでないこと。
     */
    番号がNullでないこと {
                /**
                 *
                 * @param shujiiIkenshoItemNo 主治医意見書の項目番号
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShujiiIkenshoItemNo shujiiIkenshoItemNo) {
                    return true;
                }
            }
}
