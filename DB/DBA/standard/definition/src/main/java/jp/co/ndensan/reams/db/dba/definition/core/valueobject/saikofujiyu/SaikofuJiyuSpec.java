/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.saikofujiyu;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link SaikofuJiyu}の仕様クラスです。
 */
public enum SaikofuJiyuSpec implements IPredicate<SaikofuJiyu> {

    /**
     * コードがNullでないこと。
     */
    コードがNullでないこと {
                /**
                 *
                 * コードがNullでない場合にtrueを返す。
                 *
                 * @param saikofuJiyu 空の住所地特例解除事由を生成します
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(SaikofuJiyu saikofuJiyu) {
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
                 * @param saikofuJiyu 空の住所地特例解除事由を生成します
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(SaikofuJiyu saikofuJiyu) {
                    return true;
                }
            };

}
