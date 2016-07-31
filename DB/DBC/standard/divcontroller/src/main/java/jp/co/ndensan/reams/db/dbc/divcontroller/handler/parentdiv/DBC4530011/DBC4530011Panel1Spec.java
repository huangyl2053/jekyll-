/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011Panel1Div;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DBC4530011Panel1Div}の仕様クラスです。 <br> {@link DBC4530011Panel1Div}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public enum DBC4530011Panel1Spec implements IPredicate<DBC4530011Panel1Div> {

    /**
     * 全角桁数超過64位の場合です。
     */
    全角桁数超過64位の場合 {
                @Override
                public boolean apply(DBC4530011Panel1Div div) {
                    return SpecHelper.is全角桁数超過64位(div);
                }
            };

    /**
     * {@link DBC4530011Panel1Spec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final int 桁数MAX = 64;

        /**
         * 全角64位を超える場合、入力できないです。
         *
         * @param div DBC4530011Panel1Div
         */
        public static boolean is全角桁数超過64位(DBC4530011Panel1Div div) {

            if (!RString.isNullOrEmpty(div.getTxtShiharaiBasho().getValue())) {
                return !(div.getTxtShiharaiBasho().getValue().length() > 桁数MAX);
            }
            return Boolean.TRUE;
        }

    }

}
