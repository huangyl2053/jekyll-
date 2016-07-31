/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 支払方法変更滞納者把握リストバリデーションクラスです。
 *
 * @reamsid_L DBD-3650-010 x_lilh
 */
public enum ShiharaiHohoHenkoHakuListMainDivSpec implements IPredicate<ShiharaiHohoHenkoHakuListMainDiv> {

    基準日の非空チェック {
                /**
                 * 基準日の非空チェックです。
                 *
                 * @param div 支払方法変更滞納者把握リスト画面Div
                 * @return true:基準日が非空です、false:基準日が空です。
                 */
                @Override
                public boolean apply(ShiharaiHohoHenkoHakuListMainDiv div) {
                    return div.getChushutsuJoken().getTxtKijunYMD().getValue() != null && !div.getChushutsuJoken().getTxtKijunYMD().getValue().isEmpty();
                }
            },
    受給認定日抽出期間が不正チェック {
                /**
                 * 受給認定日抽出期間が不正チェックです。
                 *
                 * @param div 支払方法変更滞納者把握リスト画面Div
                 * @return true:受給認定日開始＞受給認定日抽出終了、以外の場合falseを返却
                 */
                @Override
                public boolean apply(ShiharaiHohoHenkoHakuListMainDiv div) {
                    FlexibleDate 開始日 = div.getTxtNinteiDateFrom().getValue();
                    FlexibleDate 終了日 = div.getTxtNinteiYMDTo().getValue();
                    if (FlexibleDate.EMPTY.equals(開始日) || FlexibleDate.EMPTY.equals(終了日)) {
                        return true;
                    }
                    return !開始日.isBeforeOrEquals(終了日);
                }
            },
    償還支給決定日抽出期間が不正チェック {
                /**
                 * 償還支給決定日抽出期間が不正チェックです。
                 *
                 * @param div 支払方法変更滞納者把握リスト画面Div
                 * @return true:受給認定日開始＞受給認定日抽出終了、以外の場合falseを返却
                 */
                @Override
                public boolean apply(ShiharaiHohoHenkoHakuListMainDiv div) {
                    FlexibleDate 開始日 = div.getTxtShokanKetteiYMDFrom().getValue();
                    FlexibleDate 終了日 = div.getTxtShokanKetteiYMDTo().getValue();
                    if (FlexibleDate.EMPTY.equals(開始日) || FlexibleDate.EMPTY.equals(終了日)) {
                        return true;
                    }
                    return !開始日.isBeforeOrEquals(終了日);
                }
            };
}
