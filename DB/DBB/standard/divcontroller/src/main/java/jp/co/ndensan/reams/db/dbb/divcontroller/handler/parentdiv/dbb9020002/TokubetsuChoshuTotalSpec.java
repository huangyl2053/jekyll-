/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb9020002;

import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.TokubetsuChoshuTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link TokubetsuChoshuTotalDiv}の仕様クラスです。 <br> {@link TokubetsuChoshuTotalDiv}における画面としての仕様を定義しています。
 */
public enum TokubetsuChoshuTotalSpec implements IPredicate<TokubetsuChoshuTotalDiv> {

    /**
     * 平準化６_８月分計算
     */
    平準化６_８月分計算 {
                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is平準化６_８月分計算(div);
                }
            },
    /**
     * 平準化８月分計算
     */
    平準化８月分計算 {
                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is平準化８月分計算(div);
                }
            };

    private static class SpecHelper {

        public static boolean is平準化６_８月分計算(TokubetsuChoshuTotalDiv div) {
            if (!TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                    .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho().getSelectedKey())) {
                if (HeijunkaUmu.しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                        .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().getSelectedKey())
                        || HeijunkaUmu.しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                                .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho()
                                .getRadZogakuHeijunKa().getSelectedKey())) {
                    return false;
                }
            } else if (TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                    .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho().getSelectedKey())) {
                if (HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                        .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().getSelectedKey())
                        || HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                                .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho()
                                .getRadZogakuHeijunKa().getSelectedKey())) {
                    return false;
                }
            }
            return true;
        }

        public static boolean is平準化８月分計算(TokubetsuChoshuTotalDiv div) {
            if (!TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                    .getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                    .getDdlHeijunka8GatsuKeisanHoho().getSelectedKey())) {
                if (HeijunkaUmu.しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                        .getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().getSelectedKey())
                        || HeijunkaUmu.しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                                .getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                                .getRad8GatsuZogakuHeijunKa().getSelectedKey())) {
                    return false;
                }
            } else if (TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                    .getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                    .getDdlHeijunka8GatsuKeisanHoho().getSelectedKey())) {
                if (HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                        .getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().getSelectedKey())
                        || HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                                .getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                                .getRad8GatsuZogakuHeijunKa().getSelectedKey())) {
                    return false;
                }
            }
            return true;
        }
    }
}
