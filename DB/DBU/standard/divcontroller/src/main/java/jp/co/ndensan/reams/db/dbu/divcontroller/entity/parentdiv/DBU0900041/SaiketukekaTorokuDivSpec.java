/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 裁決結果登録バリデーションクラスです。
 */
public enum SaiketukekaTorokuDivSpec implements IPredicate<SaiketukekaTorokuPanelDiv> {

    弁明書作成日の空チェック {
                /**
                 * 弁明書作成日の空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:弁明書作成日が非空です、false:弁明書作成日が空です。
                 */
                @Override
                public boolean apply(SaiketukekaTorokuPanelDiv div) {
                    return div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().getValue() != null;
                }
            }

}
