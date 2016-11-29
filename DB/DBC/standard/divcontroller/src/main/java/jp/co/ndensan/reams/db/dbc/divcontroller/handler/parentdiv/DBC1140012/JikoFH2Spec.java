/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額情報補正(単)_補正入力20年度のSpecクラスです。
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public enum JikoFH2Spec implements IPredicate<JikoFutangakuHosei2PanelDiv> {

    /**
     * 補正後チェック１
     */
    補正後チェック１ {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック１(div);
                }
            },
    /**
     * 補正後チェック２
     */
    補正後チェック２ {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック２(div);
                }
            },
    /**
     * 補正後チェック３
     */
    補正後チェック３ {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック３(div);
                }
            },
    /**
     * 高額介護_予防_サービス費チェック
     */
    高額介護_予防_サービス費チェック {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is高額介護_予防_サービス費チェック(div);
                }
            },
    /**
     * 補正後チェック4
     */
    補正後チェック4 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック4_補正後(div);
                }
            },
    /**
     * 補正後チェック１
     */
    補正後チェック１_20年度以外 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック１_20年度以外(div);
                }
            },
    /**
     * 補正後チェック２
     */
    補正後チェック２_20年度以外 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック２_20年度以外(div);
                }
            },
    /**
     * 補正後チェック３
     */
    補正後チェック３_20年度以外 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック３_20年度以外(div);
                }
            },
    /**
     * 高額介護_予防_サービス費チェック
     */
    高額介護_予防_サービス費チェック_20年度以外 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is高額介護_予防_サービス費チェック_20年度以外(div);
                }
            },
    /**
     * 補正後チェック4
     */
    補正後チェック4_20年度以外 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return SpecHelper.is補正後チェック4_補正後_20年度以外(div);
                }
            },
    /**
     * 補正後チェック5
     */
    補正後チェック5 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return false;
                }
            },
    /**
     * 補正後チェック6
     */
    補正後チェック6 {
                @Override
                public boolean apply(JikoFutangakuHosei2PanelDiv div) {
                    return false;
                }
            };

    private static class SpecHelper {

        private static final int INT_1 = 1;

        private static Decimal isNull(Decimal 金額) {
            if (金額 == null) {
                return Decimal.ZERO;
            } else {
                return 金額;
            }
        }

        public static boolean is補正後チェック１(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
            Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
            if ((!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !isNull(自己負担額_4月分).equals(うち70_74歳に係る負担額_4月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !isNull(自己負担額_5月分).equals(うち70_74歳に係る負担額_5月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !isNull(自己負担額_6月分).equals(うち70_74歳に係る負担額_6月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !isNull(自己負担額_7月分).equals(うち70_74歳に係る負担額_7月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分) && !isNull(自己負担額_8月分).equals(うち70_74歳に係る負担額_8月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分) && !isNull(自己負担額_9月分).equals(うち70_74歳に係る負担額_9月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分) && !isNull(自己負担額_10月分).equals(うち70_74歳に係る負担額_10月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分) && !isNull(自己負担額_11月分).equals(うち70_74歳に係る負担額_11月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分) && !isNull(自己負担額_12月分).equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return !is補正後チェック１_翌年(div);
        }

        private static boolean is補正後チェック１_翌年(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分) && !isNull(自己負担額_1月分).equals(うち70_74歳に係る負担額_1月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分) && !isNull(自己負担額_2月分).equals(うち70_74歳に係る負担額_2月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分) && !isNull(自己負担額_3月分).equals(うち70_74歳に係る負担額_3月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !isNull(自己負担額_4月分).equals(うち70_74歳に係る負担額_4月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !isNull(自己負担額_5月分).equals(うち70_74歳に係る負担額_5月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !isNull(自己負担額_6月分).equals(うち70_74歳に係る負担額_6月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !isNull(自己負担額_7月分).equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック２(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
            Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分))
                    || (Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return !is補正後チェック２_翌年(div);
        }

        private static boolean is補正後チェック２_翌年(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
            return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分))
                    || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分))
                    || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分))
                    || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック３(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
            Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分))
                    || (Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_12月分))) {
                return false;
            }
            return !is補正後チェック３_翌年(div);
        }

        private static boolean is補正後チェック３_翌年(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
            return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_1月分))
                    || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_2月分))
                    || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_3月分))
                    || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分));
        }

        public static boolean is高額介護_予防_サービス費チェック(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
            Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
            if (高額介護_予防_サービス費_4月分.compareTo(自己負担額_4月分) == INT_1
                    || 高額介護_予防_サービス費_5月分.compareTo(自己負担額_5月分) == INT_1
                    || 高額介護_予防_サービス費_6月分.compareTo(自己負担額_6月分) == INT_1
                    || 高額介護_予防_サービス費_7月分.compareTo(自己負担額_7月分) == INT_1
                    || 高額介護_予防_サービス費_8月分.compareTo(自己負担額_8月分) == INT_1
                    || 高額介護_予防_サービス費_9月分.compareTo(自己負担額_9月分) == INT_1
                    || 高額介護_予防_サービス費_10月分.compareTo(自己負担額_10月分) == INT_1
                    || 高額介護_予防_サービス費_11月分.compareTo(自己負担額_11月分) == INT_1
                    || 高額介護_予防_サービス費_12月分.compareTo(自己負担額_12月分) == INT_1) {
                return false;
            }
            return !is高額介護_予防_サービス費チェック_翌年(div);
        }

        private static boolean is高額介護_予防_サービス費チェック_翌年(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
            return (高額介護_予防_サービス費_1月分.compareTo(自己負担額_1月分) == INT_1
                    || 高額介護_予防_サービス費_2月分.compareTo(自己負担額_2月分) == INT_1
                    || 高額介護_予防_サービス費_3月分.compareTo(自己負担額_3月分) == INT_1
                    || 高額介護_予防_サービス費_4月分.compareTo(自己負担額_4月分) == INT_1
                    || 高額介護_予防_サービス費_5月分.compareTo(自己負担額_5月分) == INT_1
                    || 高額介護_予防_サービス費_6月分.compareTo(自己負担額_6月分) == INT_1
                    || 高額介護_予防_サービス費_7月分.compareTo(自己負担額_7月分) == INT_1);
        }

        public static boolean is補正後チェック4_補正後(JikoFutangakuHosei2PanelDiv div) {
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)) {
                return false;
            }
            return !is補正後チェック4_補正後翌年(div);
        }

        private static boolean is補正後チェック4_補正後翌年(JikoFutangakuHosei2PanelDiv div) {
            Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分));
        }

        public static boolean is補正後チェック１_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
            if ((!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分) && !isNull(自己負担額_8月分).equals(うち70_74歳に係る負担額_8月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分) && !isNull(自己負担額_9月分).equals(うち70_74歳に係る負担額_9月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分) && !isNull(自己負担額_10月分).equals(うち70_74歳に係る負担額_10月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分) && !isNull(自己負担額_11月分).equals(うち70_74歳に係る負担額_11月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分) && !isNull(自己負担額_12月分).equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return !is補正後チェック１_翌年_20年度以外(div);
        }

        private static boolean is補正後チェック１_翌年_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分) && !isNull(自己負担額_1月分).equals(うち70_74歳に係る負担額_1月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分) && !isNull(自己負担額_2月分).equals(うち70_74歳に係る負担額_2月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分) && !isNull(自己負担額_3月分).equals(うち70_74歳に係る負担額_3月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !isNull(自己負担額_4月分).equals(うち70_74歳に係る負担額_4月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !isNull(自己負担額_5月分).equals(うち70_74歳に係る負担額_5月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !isNull(自己負担額_6月分).equals(うち70_74歳に係る負担額_6月分))
                    || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !isNull(自己負担額_7月分).equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック２_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return !is補正後チェック２_翌年_20年度以外(div);
        }

        private static boolean is補正後チェック２_翌年_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
            return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分))
                    || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分))
                    || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分))
                    || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック３_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_12月分))) {
                return false;
            }
            return !is補正後チェック３_翌年_20年度以外(div);
        }

        private static boolean is補正後チェック３_翌年_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
            return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_1月分))
                    || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_2月分))
                    || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_3月分))
                    || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                    || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                    || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                    || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分));
        }

        public static boolean is補正後チェック4_補正後_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)) {
                return false;
            }
            return !is補正後チェック4_補正後翌年_20年度以外(div);
        }

        private static boolean is補正後チェック4_補正後翌年_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分));
        }

        public static boolean is高額介護_予防_サービス費チェック_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
            if (isNull(高額介護_予防_サービス費_8月分).compareTo(isNull(自己負担額_8月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_9月分).compareTo(isNull(自己負担額_9月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_10月分).compareTo(isNull(自己負担額_10月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_11月分).compareTo(isNull(自己負担額_11月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_12月分).compareTo(isNull(自己負担額_12月分)) == INT_1) {
                return false;
            }
            return !is高額介護_予防_サービス費チェック_翌年_20年度以外(div);
        }

        private static boolean is高額介護_予防_サービス費チェック_翌年_20年度以外(JikoFutangakuHosei2PanelDiv div) {
            Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
            return (isNull(高額介護_予防_サービス費_1月分).compareTo(isNull(自己負担額_1月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_2月分).compareTo(isNull(自己負担額_2月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_3月分).compareTo(isNull(自己負担額_3月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_4月分).compareTo(isNull(自己負担額_4月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_5月分).compareTo(isNull(自己負担額_5月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_6月分).compareTo(isNull(自己負担額_6月分)) == INT_1
                    || isNull(高額介護_予防_サービス費_7月分).compareTo(isNull(自己負担額_7月分)) == INT_1);
        }
    }

}
