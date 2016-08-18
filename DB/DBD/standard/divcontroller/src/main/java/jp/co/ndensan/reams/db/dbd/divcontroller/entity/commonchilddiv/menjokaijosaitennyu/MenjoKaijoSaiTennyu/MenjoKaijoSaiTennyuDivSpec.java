/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 【共有子Div】 免除解除・再転入ダイアログのSpecです。
 *
 * @reamsid_L DBD-3620-044 panxiaobo
 */
public enum MenjoKaijoSaiTennyuDivSpec implements IPredicate<MenjoKaijoSaiTennyuDiv> {

    適用期間チェック {
                /**
                 * 適用期間のチェックです。
                 *
                 * @param div MenjoKaijoSaiTennyuDiv
                 * @return true:期間が正確、false:期間が不正
                 */
                @Override
                public boolean apply(MenjoKaijoSaiTennyuDiv div) {
                    if (!div.getTxtKonkaiKikanKaishiYMD().getValue().isEmpty() && !div.getTxtKonkaiKikanShuryoYMD().getValue().isEmpty()) {
                        return div.getTxtKonkaiKikanKaishiYMD().getValue().isBeforeOrEquals(div.getTxtKonkaiKikanShuryoYMD().getValue());
                    } else {
                        return !div.getTxtKonkaiKikanKaishiYMD().getValue().isEmpty() || !div.getTxtKonkaiKikanShuryoYMD().getValue().isEmpty();
                    }
                }
            }
}
