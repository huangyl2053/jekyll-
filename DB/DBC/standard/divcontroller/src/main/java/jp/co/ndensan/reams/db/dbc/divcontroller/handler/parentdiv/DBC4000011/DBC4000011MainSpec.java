/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4000011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.dgService_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC4000011_サービス内容登録のSpecクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public enum DBC4000011MainSpec implements IPredicate<DBC4000011MainDiv> {

    /**
     * 提供期間の重複チェック。
     */
    提供期間の重複チェック {
                @Override
                public boolean apply(DBC4000011MainDiv div) {
                    return !SpecHelper.提供期間の重複チェック(div);
                }
            };

    private static class SpecHelper {

        /**
         * 提供期間の重複チェックです。
         *
         * @param div DBC4000011MainDiv
         */
        public static boolean 提供期間の重複チェック(DBC4000011MainDiv div) {
            List<dgService_Row> allRows = div.getDgService().getDataSource();
            if (allRows == null || allRows.isEmpty()) {
                return false;
            }
            dgService_Row 直近データ = null;
            FlexibleDate 提供開始年月 = new FlexibleDate(div.getServiceShosai().getTxtTeikyoKikanYM().getFromValue().toDateString());
            for (dgService_Row row : allRows) {
                if (RString.isNullOrEmpty(row.getTeikyoShuryoYM())) {
                    直近データ = row;
                }
            }
            if (直近データ == null) {
                return false;
            }
            if (提供開始年月.isBeforeOrEquals(直近データ.getTeikyoKaishiKey().getValue())) {
                return true;
            }
            return false;
        }

    }
}
