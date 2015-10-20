/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

public enum GogitaiYukoKikanKaishiDateSpec implements IPredicate<GogitaiYukoKikanKaishiDate> {

    /**
     * 開始年月日がNullでないこと
     */
    開始年月日がNullでないこと {

                /**
                 *
                 * @param gogitaiYukoKikanKaishiDate 合議体有効期間開始年月日
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(GogitaiYukoKikanKaishiDate gogitaiYukoKikanKaishiDate) {
                    return true;
                }
            }
}
