/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000074;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000074.TsuuchishoHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 基準収入額決定通知書発行画面
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public enum TsuuchishoHakkoSpec implements IPredicate<TsuuchishoHakkoDiv> {

    /**
     * 申請年月日
     */
    申請年月日 {
                @Override
                public boolean apply(TsuuchishoHakkoDiv div) {
                    return SpecHelper.申請年月日判定(div);
                }
            },
    /**
     * 決定年月日
     */
    決定年月日 {
                @Override
                public boolean apply(TsuuchishoHakkoDiv div) {
                    return SpecHelper.決定年月日判定(div);
                }
            };

    private static class SpecHelper {

        public static boolean 申請年月日判定(TsuuchishoHakkoDiv div) {
            RDate 申請年月日_終了日 = div.getTxtShinseiYMD().getToValue();
            RDate 申請年月日_開始日 = div.getTxtShinseiYMD().getFromValue();
            return 申請年月日_開始日.isBefore(申請年月日_終了日);
        }

        public static boolean 決定年月日判定(TsuuchishoHakkoDiv div) {
            RDate 決定年月日_終了日 = div.getTxtKetteiYMD().getToValue();
            RDate 決定年月日_開始日 = div.getTxtKetteiYMD().getFromValue();
            return 決定年月日_開始日.isBefore(決定年月日_終了日);
        }

    }
}
