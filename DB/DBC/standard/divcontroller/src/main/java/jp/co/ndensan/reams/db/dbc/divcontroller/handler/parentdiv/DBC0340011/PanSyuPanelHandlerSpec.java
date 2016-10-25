/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0340011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0340011.PanSyuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のクラスです。
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
public enum PanSyuPanelHandlerSpec implements IPredicate<PanSyuPanelDiv> {

    /**
     * 契約申請日の範囲チェック
     */
    契約申請日の範囲チェック {
                @Override
                public boolean apply(PanSyuPanelDiv div) {
                    return SpecHelper.is契約申請日の範囲チェック(div);
                }
            },
    /**
     * 契約決定日の範囲チェック
     */
    契約決定日の範囲チェック {
                @Override
                public boolean apply(PanSyuPanelDiv div) {
                    return SpecHelper.is契約決定日の範囲チェック(div);
                }
            };

    private static class SpecHelper {

        /**
         * 契約申請日の範囲チェック場合です。
         *
         * @param div PanSyuPanelDiv
         */
        public static boolean is契約申請日の範囲チェック(PanSyuPanelDiv div) {
            RDate 契約開始申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getFromValue();
            RDate 契約終了申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getToValue();
            if (契約開始申請日 != null && 契約終了申請日 != null) {
                return !契約終了申請日.isBefore(契約開始申請日);
            }
            return true;
        }

        /**
         * 契約決定日の範囲チェック場合です。
         *
         * @param div PanSyuPanelDiv
         */
        public static boolean is契約決定日の範囲チェック(PanSyuPanelDiv div) {
            RDate 契約開始決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getFromValue();
            RDate 契約終了決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getToValue();
            if (契約開始決定日 != null && 契約終了決定日 != null) {
                return !契約終了決定日.isBefore(契約開始決定日);
            }
            return true;
        }
    }
}
