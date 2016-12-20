/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 調査委託先＆調査員入力共有子Divの仕様クラスです。
 */
public enum ChosaItakusakiAndChosainInputSpec implements IPredicate<ChosaItakusakiAndChosainInputDiv> {

    /**
     * 調査委託先コードに該当するデータが存在すること
     */
    調査委託先コードに該当するデータが存在すること {
                @Override
                public boolean apply(ChosaItakusakiAndChosainInputDiv div) {
                    return div.getTxtChosaItakusakiCode().getValue().isEmpty()
                    || !div.getTxtChosaItakusakiName().getValue().isEmpty();
                }
            },
    /**
     * 調査員コードに該当するデータが存在すること
     */
    調査員コードに該当するデータが存在すること {
                @Override
                public boolean apply(ChosaItakusakiAndChosainInputDiv div) {
                    return div.getTxtChosainCode().getValue().isEmpty()
                    || !div.getTxtChosainName().getValue().isEmpty();
                }
            }

}
