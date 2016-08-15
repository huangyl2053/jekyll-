/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.JikoFutangakuHosei2Div;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分自己負担額情報補正（単）_補正入力のクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public enum JikoFutangakuHosei2Spec implements IPredicate<JikoFutangakuHosei2Div> {

    /**
     * 補正後のデータ入力済
     */
    補正後のデータ入力済 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後のデータ入力済(div);
                }
            },
    /**
     * 補正後チェック１
     */
    補正後チェック１ {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック１(div);
                }
            },
    /**
     * 補正後チェック２
     */
    補正後チェック２ {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック２(div);
                }
            },
    /**
     * 補正後チェック３
     */
    補正後チェック３ {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック３(div);
                }
            },
    /**
     * 補正後チェック４
     */
    補正後チェック４ {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック４(div);
                }
            },
    /**
     * 補正後チェック５_008
     */
    補正後チェック５_008 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_008(div);
                }
            },
    /**
     * 補正後チェック５_009
     */
    補正後チェック５_009 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_009(div);
                }
            },
    /**
     * 補正後チェック５_010
     */
    補正後チェック５_010 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_010(div);
                }
            },
    /**
     * 補正後チェック５_011
     */
    補正後チェック５_011 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_011(div);
                }
            },
    /**
     * 補正後チェック５_012
     */
    補正後チェック５_012 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_012(div);
                }
            },
    /**
     * 補正後チェック５_101
     */
    補正後チェック５_101 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_101(div);
                }
            },
    /**
     * 補正後チェック５_102
     */
    補正後チェック５_102 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_102(div);
                }
            },
    /**
     * 補正後チェック５_103
     */
    補正後チェック５_103 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_103(div);
                }
            },
    /**
     * 補正後チェック５_104
     */
    補正後チェック５_104 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_104(div);
                }
            },
    /**
     * 補正後チェック５_105
     */
    補正後チェック５_105 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_105(div);
                }
            },
    /**
     * 補正後チェック５_106
     */
    補正後チェック５_106 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_106(div);
                }
            },
    /**
     * 補正後チェック５_107
     */
    補正後チェック５_107 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック５_107(div);
                }
            },
    /**
     * 補正後チェック６_008
     */
    補正後チェック６_008 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_008(div);
                }
            },
    /**
     * 補正後チェック６_009
     */
    補正後チェック６_009 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_009(div);
                }
            },
    /**
     * 補正後チェック６_010
     */
    補正後チェック６_010 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_010(div);
                }
            },
    /**
     * 補正後チェック６_011
     */
    補正後チェック６_011 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_011(div);
                }
            },
    /**
     * 補正後チェック６_012
     */
    補正後チェック６_012 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_012(div);
                }
            },
    /**
     * 補正後チェック６_101
     */
    補正後チェック６_101 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_101(div);
                }
            },
    /**
     * 補正後チェック６_102
     */
    補正後チェック６_102 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_102(div);
                }
            },
    /**
     * 補正後チェック６_103
     */
    補正後チェック６_103 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_103(div);
                }
            },
    /**
     * 補正後チェック６_104
     */
    補正後チェック６_104 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_104(div);
                }
            },
    /**
     * 補正後チェック６_105
     */
    補正後チェック６_105 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_105(div);
                }
            },
    /**
     * 補正後チェック６_106
     */
    補正後チェック６_106 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_106(div);
                }
            },
    /**
     * 補正後チェック６_107
     */
    補正後チェック６_107 {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is補正後チェック６_107(div);
                }
            },
    /**
     * 高額総合事業サービス費チェック
     */
    高額総合事業サービス費チェック {
                @Override
                public boolean apply(JikoFutangakuHosei2Div div) {
                    return SpecHelper.is高額総合事業サービス費チェック(div);
                }
            };

    private static class SpecHelper {

        private static final int 整数_ONE = 1;

        public static boolean is補正後のデータ入力済(JikoFutangakuHosei2Div div) {
            if (div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue() == null
                    || div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue() == null) {
                return false;
            }
            return is補正後のデータ入力済_翌年(div);
        }

        private static boolean is補正後のデータ入力済_翌年(JikoFutangakuHosei2Div div) {
            return div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue() != null
                    && div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue() != null;
        }

        public static boolean is補正後チェック１(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_8月分 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue();
            if ((!うち70_74歳に係る負担額_8月分.equals(Decimal.ZERO) && !自己負担額_8月分.equals(うち70_74歳に係る負担額_8月分))
                    || (!うち70_74歳に係る負担額_9月分.equals(Decimal.ZERO) && !自己負担額_9月分.equals(うち70_74歳に係る負担額_9月分))
                    || (!うち70_74歳に係る負担額_10月分.equals(Decimal.ZERO) && !自己負担額_10月分.equals(うち70_74歳に係る負担額_10月分))
                    || (!うち70_74歳に係る負担額_11月分.equals(Decimal.ZERO) && !自己負担額_11月分.equals(うち70_74歳に係る負担額_11月分))
                    || (!うち70_74歳に係る負担額_12月分.equals(Decimal.ZERO) && !自己負担額_12月分.equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return is補正後チェック１_翌年(div);
        }

        private static boolean is補正後チェック１_翌年(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue();
            return (うち70_74歳に係る負担額_1月分.equals(Decimal.ZERO) || 自己負担額_1月分.equals(うち70_74歳に係る負担額_1月分))
                    && (うち70_74歳に係る負担額_2月分.equals(Decimal.ZERO) || 自己負担額_2月分.equals(うち70_74歳に係る負担額_2月分))
                    && (うち70_74歳に係る負担額_3月分.equals(Decimal.ZERO) || 自己負担額_3月分.equals(うち70_74歳に係る負担額_3月分))
                    && (うち70_74歳に係る負担額_4月分.equals(Decimal.ZERO) || 自己負担額_4月分.equals(うち70_74歳に係る負担額_4月分))
                    && (うち70_74歳に係る負担額_5月分.equals(Decimal.ZERO) || 自己負担額_5月分.equals(うち70_74歳に係る負担額_5月分))
                    && (うち70_74歳に係る負担額_6月分.equals(Decimal.ZERO) || 自己負担額_6月分.equals(うち70_74歳に係る負担額_6月分))
                    && (うち70_74歳に係る負担額_7月分.equals(Decimal.ZERO) || 自己負担額_7月分.equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック２(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_8月分 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_8月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_9月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_10月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_11月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_12月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分))) {
                return false;
            }
            return is補正後チェック２_翌年(div);
        }

        private static boolean is補正後チェック２_翌年(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_1月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_2月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_3月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_4月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_5月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_6月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
            Decimal うち70_74歳に係る負担額_7月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(自己負担額_1月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分))
                    && (!Decimal.ZERO.equals(自己負担額_2月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分))
                    && (!Decimal.ZERO.equals(自己負担額_3月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分))
                    && (!Decimal.ZERO.equals(自己負担額_4月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                    && (!Decimal.ZERO.equals(自己負担額_5月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                    && (!Decimal.ZERO.equals(自己負担額_6月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                    && (!Decimal.ZERO.equals(自己負担額_7月分) || Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分));
        }

        public static boolean is補正後チェック３(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_8月分 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
            Decimal 高額総合事業サービス費_8月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
            Decimal 高額総合事業サービス費_9月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
            Decimal 高額総合事業サービス費_10月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
            Decimal 高額総合事業サービス費_11月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
            Decimal 高額総合事業サービス費_12月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue();
            if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(高額総合事業サービス費_8月分))
                    || (Decimal.ZERO.equals(自己負担額_9月分)  && !Decimal.ZERO.equals(高額総合事業サービス費_9月分))
                    || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(高額総合事業サービス費_10月分))
                    || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(高額総合事業サービス費_11月分))
                    || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(高額総合事業サービス費_12月分))) {
                return false;
            }
            return is補正後チェック３_翌年(div);
        }

        private static boolean is補正後チェック３_翌年(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額総合事業サービス費_1月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額総合事業サービス費_2月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額総合事業サービス費_3月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額総合事業サービス費_4月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額総合事業サービス費_5月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額総合事業サービス費_6月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額総合事業サービス費_7月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue();
            return (!Decimal.ZERO.equals(自己負担額_1月分) || Decimal.ZERO.equals(高額総合事業サービス費_1月分))
                    && (!Decimal.ZERO.equals(自己負担額_2月分) || Decimal.ZERO.equals(高額総合事業サービス費_2月分))
                    && (!Decimal.ZERO.equals(自己負担額_3月分) || Decimal.ZERO.equals(高額総合事業サービス費_3月分))
                    && (!Decimal.ZERO.equals(自己負担額_4月分) || Decimal.ZERO.equals(高額総合事業サービス費_4月分))
                    && (!Decimal.ZERO.equals(自己負担額_5月分) || Decimal.ZERO.equals(高額総合事業サービス費_5月分))
                    && (!Decimal.ZERO.equals(自己負担額_6月分) || Decimal.ZERO.equals(高額総合事業サービス費_6月分))
                    && (!Decimal.ZERO.equals(自己負担額_7月分) || Decimal.ZERO.equals(高額総合事業サービス費_7月分));
        }

        public static boolean is補正後チェック４(JikoFutangakuHosei2Div div) {
            if (!Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuMae().getValue())
                    || !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuMae().getValue())) {
                return false;
            }
            return is補正後チェック４_補正後(div);
        }

        private static boolean is補正後チェック４_補正後(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue())
                    && Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue());
        }

        public static boolean is高額総合事業サービス費チェック(JikoFutangakuHosei2Div div) {
            Decimal 自己負担額_8月分 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
            Decimal 高額総合事業サービス費_8月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue();
            Decimal 自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
            Decimal 高額総合事業サービス費_9月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue();
            Decimal 自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
            Decimal 高額総合事業サービス費_10月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue();
            Decimal 自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
            Decimal 高額総合事業サービス費_11月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue();
            Decimal 自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
            Decimal 高額総合事業サービス費_12月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue();
            Decimal 自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
            Decimal 高額総合事業サービス費_1月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue();
            Decimal 自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
            Decimal 高額総合事業サービス費_2月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue();
            Decimal 自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
            Decimal 高額総合事業サービス費_3月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue();
            Decimal 自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
            Decimal 高額総合事業サービス費_4月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue();
            Decimal 自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
            Decimal 高額総合事業サービス費_5月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue();
            Decimal 自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
            Decimal 高額総合事業サービス費_6月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue();
            Decimal 自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
            Decimal 高額総合事業サービス費_7月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue();
            return 高額総合事業サービス費_8月分.compareTo(自己負担額_8月分) != 整数_ONE
                    && 高額総合事業サービス費_9月分.compareTo(自己負担額_9月分) != 整数_ONE
                    && 高額総合事業サービス費_10月分.compareTo(自己負担額_10月分) != 整数_ONE
                    && 高額総合事業サービス費_11月分.compareTo(自己負担額_11月分) != 整数_ONE
                    && 高額総合事業サービス費_12月分.compareTo(自己負担額_12月分) != 整数_ONE
                    && 高額総合事業サービス費_1月分.compareTo(自己負担額_1月分) != 整数_ONE
                    && 高額総合事業サービス費_2月分.compareTo(自己負担額_2月分) != 整数_ONE
                    && 高額総合事業サービス費_3月分.compareTo(自己負担額_3月分) != 整数_ONE
                    && 高額総合事業サービス費_4月分.compareTo(自己負担額_4月分) != 整数_ONE
                    && 高額総合事業サービス費_5月分.compareTo(自己負担額_5月分) != 整数_ONE
                    && 高額総合事業サービス費_6月分.compareTo(自己負担額_6月分) != 整数_ONE
                    && 高額総合事業サービス費_7月分.compareTo(自己負担額_7月分) != 整数_ONE;
        }

        public static boolean is補正後チェック５_008(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_009(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_010(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_011(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_012(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_101(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_102(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_103(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_104(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_105(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_106(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue());
        }

        public static boolean is補正後チェック５_107(JikoFutangakuHosei2Div div) {
            return Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_008(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_009(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_010(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_011(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_012(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_101(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_102(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_103(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_104(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_105(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_106(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue());
        }

        public static boolean is補正後チェック６_107(JikoFutangakuHosei2Div div) {
            return !Decimal.ZERO.equals(div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue());
        }
    }

}
