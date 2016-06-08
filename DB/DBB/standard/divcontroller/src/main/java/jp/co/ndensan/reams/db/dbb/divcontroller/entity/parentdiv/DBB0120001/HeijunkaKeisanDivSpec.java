/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 認定調査結果登録1バリデーションクラスです。
 */
public enum HeijunkaKeisanDivSpec implements IPredicate<HeijunkaKeisanDiv> {

    発行日の非空チェック {
                /**
                 * 発行日の非空チェックです。
                 *
                 * @param div HeijunkaKeisanDiv
                 * @return true:発行日が非空です、false:発行日が空です。
                 */
                @Override
                public boolean apply(HeijunkaKeisanDiv div) {
                    return div.getTokuchoHeijunkaChohyoHakko().getTxtHeijunkaHenkoTsuchiHakkoYMD().getValue() != null;
                }
            }

}
