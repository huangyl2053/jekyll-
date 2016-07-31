/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額介護サービス費給付対象者-スケジュール設定の入力チェックSpecです。
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public enum KyufuTaishoshaScheduleSetteiPanelSpec implements IPredicate<KyufuTaishoshaScheduleSetteiPanelDiv> {

    /**
     * 審査年月期間(開始年月)と審査年月期間(終了年月)の前後順チェックです。
     */
    開始年月と終了年月の前後順チェック {
                @Override
                public boolean apply(KyufuTaishoshaScheduleSetteiPanelDiv div) {
                    return SpecHelper.is開始年月と終了年月の前後順チェック(div);
                }
            };

    private static class SpecHelper {

        public static boolean is開始年月と終了年月の前後順チェック(KyufuTaishoshaScheduleSetteiPanelDiv div) {
            FlexibleYearMonth 開始年月 = div.getTxtShinsaNengetsuFrom().getDomain();
            FlexibleYearMonth 終了年月 = div.getTxtShinsaNengetsuTo().getDomain();
            return 開始年月.isBeforeOrEquals(終了年月);
        }
    }
}
