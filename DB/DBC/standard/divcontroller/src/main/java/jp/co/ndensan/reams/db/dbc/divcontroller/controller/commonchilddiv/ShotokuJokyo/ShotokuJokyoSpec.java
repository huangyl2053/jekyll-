/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShotokuJokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo.dgSteaiinShotoku_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBC_ShotokuJokyo_所得状況のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public enum ShotokuJokyoSpec implements IPredicate<ShotokuJokyoDiv> {

    /**
     * 日付関係チェック
     */
    選択した行のチェック {
                @Override
                public boolean apply(ShotokuJokyoDiv div) {
                    return SpecHelper.check年齢(div);

                }
            };
    private static final Decimal 年齢_64 = new Decimal("64");

    private static class SpecHelper {

        /**
         * 世帯員所得情報Gridで選択した行の「年齢」が64歳以下の場合、エラー
         *
         * @param div ShotokuJokyoDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check年齢(ShotokuJokyoDiv div) {
            List<dgSteaiinShotoku_Row> rowList = div.getDgSteaiinShotoku().getSelectedItems();
            RString 年齢;
            for (dgSteaiinShotoku_Row row : rowList) {
                年齢 = row.getAge();
                if (年齢.isEmpty() || 年齢.isNull()) {
                    return true;
                } else if (new Decimal(年齢.toString()).compareTo(年齢_64) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
