/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 給付額減額管理リストのバリデーションクラスです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
public enum KyufugakuGengakuKanriListDivSpec implements IPredicate<KyufugakuGengakuKanriListDiv> {

    基準日の非空チェック {
        /**
         * 基準日の非空チェックです。
         *
         * @param div 給付額減額管理リストDiv
         * @return true:基準日が非空です、false:基準日が空です。
         */
        @Override
        public boolean apply(KyufugakuGengakuKanriListDiv div) {
            return div.getChushutuJoken().getTxtKijunDate().getValue().toDateString() != null && !div.getChushutuJoken().getTxtKijunDate().getValue().toDateString().isEmpty();
        }
    },
    減額終了日抽出_終了日が開始日以前のチェック {
        /**
         * 減額終了日抽出_終了日が開始日以前のチェック。
         *
         * @param div 給付額減額管理リストDiv
         * @return true:減額終了日抽出_終了日が開始日以前ではないです、false:減額終了日抽出_終了日が開始日以前です。
         */
        @Override
        public boolean apply(KyufugakuGengakuKanriListDiv div) {

            RDate 開始日 = div.getTxtGengakuShuryoRange().getFromValue();
            RDate 終了日 = div.getTxtGengakuShuryoRange().getToValue();

            return !終了日.isBeforeOrEquals(開始日);
        }
    };

}
