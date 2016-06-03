/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.TokubetsuChoshuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.dgKibetsuJoho_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link TokubetsuChoshuTotalDiv}の仕様クラスです。 <br> {@link TokubetsuChoshuTotalDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBB-1770-040 cuilin
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
            },
    /**
     * 納期限_01月
     */
    納期限_04月 {
                private static final int 一行目 = 0;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 一行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_05月 {
                private static final int 二行目 = 1;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 二行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_06月 {
                private static final int 三行目 = 2;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 三行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_07月 {
                private static final int 四行目 = 3;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 四行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_08月 {
                private static final int 五行目 = 4;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 五行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_09月 {
                private static final int 六行目 = 5;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 六行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_10月 {
                private static final int 七行目 = 6;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 七行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_11月 {
                private static final int 八行目 = 7;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 八行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_12月 {
                private static final int 九行目 = 8;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 九行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_01月 {
                private static final int 十行目 = 9;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 十行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_02月 {
                private static final int 十一行目 = 10;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 十一行目);
                }
            },
    /**
     * 納期限_01月
     */
    納期限_03月 {
                private static final int 十二行目 = 11;

                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is納期限(div, 十二行目);
                }
            },
    /**
     * 選択数
     */
    選択数 {
                @Override
                public boolean apply(TokubetsuChoshuTotalDiv div) {
                    return SpecHelper.is選択数(div);
                }
            };

    private static class SpecHelper {

        private static final int 最大選択数 = 6;

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
            } else if (HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                    .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().getSelectedKey())
                    || HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                            .getTplKibetsuHasuJoho().getHeijunka6GatsuKeisanHoho()
                            .getRadZogakuHeijunKa().getSelectedKey())) {
                return false;
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
            } else if (HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                    .getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().getSelectedKey())
                    || HeijunkaUmu.する.getコード().equals(div.getTokubetsuChoshu().getTabTokucho()
                            .getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                            .getRad8GatsuZogakuHeijunKa().getSelectedKey())) {
                return false;
            }
            return true;
        }

        public static boolean is納期限(TokubetsuChoshuTotalDiv div, int 行目) {
            List<dgKibetsuJoho_Row> row = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                    .getKibetsuJohoHasu().getDgKibetsuJoho().getDataSource();
            if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible() && row.get(行目).getSelected()) {
                return row.get(行目).getTxtNokigen().getValue() != null && !row.get(行目).getTxtNokigen().getValue().isEmpty();
            }
            return true;
        }

        public static boolean is選択数(TokubetsuChoshuTotalDiv div) {
            return div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu()
                    .getDgKibetsuJoho().getSelectedItems().size() <= 最大選択数;
        }
    }
}
