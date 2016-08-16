/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011.PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021PanelAllDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * {@link PanelAllDiv}の仕様クラスです。 <br> {@link PanelAllDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public enum PanelAllSpec implements IPredicate<DBC2000021PanelAllDiv> {

//    /**
//     * 基準日が未入力の場合です。
//     */
//    基準日が未入力の場合 {
//                @Override
//                public boolean apply(DBC2000021PanelAllDiv div) {
//                    return SpecHelper.is基準日が未入力(div);
//                }
//            },
    /**
     * 基準日が年度範囲外の場合です。
     */
    基準日は指定年度内の日付を指定してくださいの場合 {
                @Override
                public boolean apply(DBC2000021PanelAllDiv div) {
                    return SpecHelper.is基準日は指定年度内の日付を指定してください(div);
                }
            };

    /**
     * {@link PanelAllSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

//        /**
//         * 基準日が未入力、入力できないです。
//         *
//         * @param div DBC2000021PanelAllDiv
//         */
//        public static boolean is基準日が未入力(DBC2000021PanelAllDiv div) {
//
//            if (div.getTxtKijunbi().getValue() == null) {
//                return Boolean.FALSE;
//            }
//            return Boolean.TRUE;
//        }
        /**
         * 基準日が年度範囲外できないです。
         *
         * @param div DBC2000021PanelAllDiv
         */
        public static boolean is基準日は指定年度内の日付を指定してください(DBC2000021PanelAllDiv div) {

            RDate 年度 = new RDate((div.getDdlNendo().getSelectedValue().concat(DbBusinessConfig
                    .get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(), SubGyomuCode.DBC介護給付)).toString()));
            if (div.getTxtKijunbi().getValue().isBefore((年度.plusDay(1)))
                    && 年度.isBefore(div.getTxtKijunbi().getValue())) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

    }
}
