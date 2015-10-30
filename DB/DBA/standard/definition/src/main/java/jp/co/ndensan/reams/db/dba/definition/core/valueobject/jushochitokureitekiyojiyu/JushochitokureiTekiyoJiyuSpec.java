/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.jushochitokureitekiyojiyu;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link JushochitokureiTekiyoJiyu}の仕様クラスです。
 */
public enum JushochitokureiTekiyoJiyuSpec implements IPredicate<JushochitokureiTekiyoJiyu> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * コードがNullでない場合にtrueを返す。
                 *
                 * @param JushochitokureiTekiyoJiyu 住所地特例適用事由
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(JushochitokureiTekiyoJiyu jushochitokureiTekiyoJiyu) {
                    return true;
                }
            },
    /**
     * 名称がNullでないこと。
     */
    名称がNullでないこと {
                /**
                 *
                 * 名称がNullでない場合にtrueを返す。
                 *
                 * @param JushochitokureiTekiyoJiyu 住所地特例適用事由
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(JushochitokureiTekiyoJiyu jushochitokureiTekiyoJiyu) {
                    return true;
                }
            };

}
