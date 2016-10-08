/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 負担限度額認定申請承認（一括）のバリデーションクラスです。
 *
 * @reamsid_L DBD-3710-010 xuejm
 */
public enum FutangendogakuShoninMainDivSpec implements IPredicate<FutangendogakuShoninMainDiv> {

    作成年度の未入力チェック {
                /**
                 * 作成年度の未入力チェック .
                 *
                 * @param div FutangendogakuShoninMainDiv
                 * @return true:作成年度が非空です、false:作成年度が空白の場合。
                 */
                @Override
                public boolean apply(FutangendogakuShoninMainDiv div) {
                    return div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue() != null
                    && !div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue().isEmpty();
                }
            },
    決定日の未入力チェック {
                /**
                 * 決定日の未入力チェック .
                 *
                 * @param div FutangendogakuShoninMainDiv
                 * @return true:決定日が非空です、false:決定日が空白の場合。
                 */
                @Override
                public boolean apply(FutangendogakuShoninMainDiv div) {
                    return div.getFutangendogakuShonin().getTxtKetteibi().getValue() != null
                    && !div.getFutangendogakuShonin().getTxtKetteibi().getValue().isEmpty();
                }
            },
    申請日終了と申請日開始の比較チェック {
                /**
                 * 申請日終了と申請日開始の比較チェック .
                 *
                 * @param div FutangendogakuShoninMainDiv
                 * @return true:申請日終了>=申請日開始の場合、false:申請日終了≦申請日開始の場合。
                 */
                @Override
                public boolean apply(FutangendogakuShoninMainDiv div) {
                    RDate ShinseibiFrom = div.getFutangendogakuShonin().getTxtShinseibiJoken().getFromValue();
                    RDate ShinseibiTo = div.getFutangendogakuShonin().getTxtShinseibiJoken().getToValue();
                    return ShinseibiFrom.isBefore(ShinseibiTo);
                }
            },
    発行日の未入力チェック {
                /**
                 * 発行日の未入力チェック .
                 *
                 * @param div FutangendogakuShoninMainDiv
                 * @return true:発行日が非空です、false:発行日が空白の場合。
                 */
                @Override
                public boolean apply(FutangendogakuShoninMainDiv div) {
                    boolean TxtHakkoYMD = false;
                    if (div.getShinseiPrint().isIsPublish()) {
                        TxtHakkoYMD = div.getShinseiPrint().getTxtHakkoYMD().getValue() != null
                        && !div.getShinseiPrint().getTxtHakkoYMD().getValue().isEmpty();
                    }
                    return TxtHakkoYMD;
                }
            };

}
