/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgTorokuKanyRirekiuList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額合算支給申請書登録のSpecです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public enum KogakuGassanShikyuShinseiTorokuSpec implements IPredicate<KogakuGassanShikyuShinseiTorokuAllPanelDiv> {

    /**
     * 老人所得区分必須入力チェックです。
     */
    老人所得区分必須入力チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is老人所得区分必須入力チェック(div);
                }
            },
    /**
     * 年度内範囲のチェックです。
     */
    年度内範囲チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is年度内範囲チェック(div);
                }
            },
    /**
     * 加入期間範囲チェックです。
     */
    加入期間範囲チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is加入期間範囲チェック(div);
                }
            },
    /**
     * 資格喪失チェック1です。
     */
    資格喪失チェック1 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is資格喪失チェック1(div);
                }
            },
    /**
     * 資格喪失チェック2です。
     */
    資格喪失チェック2 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is資格喪失チェック2(div);
                }
            },
    /**
     * 後期資格情報保険者番号のチェックです。
     */
    後期資格情報保険者番号チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is後期資格情報保険者番号(div);
                }
            },
    /**
     * 国保保険者番号桁数のチェックです。
     */
    国保保険者番号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is国保保険者番号桁数チェック(div);
                }
            },
    /**
     * 後期保険者番号桁数のチェックです。
     */
    後期保険者番号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is後期保険者番号桁数チェック(div);
                }
            },
    /**
     * 後期被保険者番号桁数のチェックです。
     */
    後期被保険者番号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is後期被保険者番号桁数チェック(div);
                }
            },
    /**
     * 被保険者証記号桁数のチェックです。
     */
    被保険者証記号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is被保険者証記号桁数チェック(div);
                }
            },
    /**
     * 被保険者証番号桁数のチェックです。
     */
    被保険者証番号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is被保険者証番号桁数チェック(div);
                }
            },
    /**
     * 介護日付のチェックです。
     */
    介護日付チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is介護日付チェック(div);
                }
            },
    /**
     * 被保日付のチェックです。
     */
    被保日付チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is被保日付チェック(div);
                }
            },
    /**
     * 国保日付のチェックです。
     */
    国保日付チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is国保日付チェック(div);
                }
            },
    /**
     * 後期日付のチェックです。
     */
    後期日付チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is後期日付チェック(div);
                }
            },
    /**
     * 開始計算期間1のチェックです。
     */
    開始計算期間チェック1 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック1(div);
                }
            },
    /**
     * 開始計算期間2のチェックです。
     */
    開始計算期間チェック2 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック2(div);
                }
            },
    /**
     * 開始計算期間3のチェックです。
     */
    開始計算期間チェック3 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック3(div);
                }
            },
    /**
     * 開始計算期間4のチェックです。
     */
    開始計算期間チェック4 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック4(div);
                }
            },
    /**
     * 開始計算期間5のチェックです。
     */
    開始計算期間チェック5 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック5(div);
                }
            },
    /**
     * 開始計算期間6のチェックです。
     */
    開始計算期間チェック6 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is開始計算期間チェック6(div);
                }
            },
    /**
     * 終了計算期間1のチェックです。
     */
    終了計算期間チェック1 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック1(div);
                }
            },
    /**
     * 終了計算期間2のチェックです。
     */
    終了計算期間チェック2 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック2(div);
                }
            },
    /**
     * 終了計算期間3のチェックです。
     */
    終了計算期間チェック3 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック3(div);
                }
            },
    /**
     * 終了計算期間4のチェックです。
     */
    終了計算期間チェック4 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック4(div);
                }
            },
    /**
     * 終了計算期間5のチェックです。
     */
    終了計算期間チェック5 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック5(div);
                }
            },
    /**
     * 終了計算期間6のチェックです。
     */
    終了計算期間チェック6 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is終了計算期間チェック6(div);
                }
            },
    /**
     * 保険加入期間が不正のチェックです。
     */
    保険加入期間が不正チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is保険加入期間が不正チェック(div);
                }
            },
    /**
     * 自己負担額証明書整理番号桁数のチェックです。
     */
    自己負担額証明書整理番号桁数チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is自己負担額証明書整理番号桁数チェック(div);
                }
            },
    /**
     * 自己負担額証明書整理番号既に存在のチェックです。
     */
    自己負担額証明書整理番号既に存在チェック {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
                    return SpecHelper.is自己負担額証明書整理番号既に存在チェック(div);
                }
            };

    /**
     * {@link JikoFutangakuHoseiSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final int INT_2008 = 2008;
        private static final int INT_0 = 0;
        private static final int INT_1 = 1;
        private static final int INT_2 = 2;
        private static final int INT_8 = 8;
        private static final int INT_20 = 20;
        private static final RString RSTRING_3 = new RString("3");
        private static final RString DATE_0401 = new RString("0401");
        private static final RString DATE_0731 = new RString("0731");
        private static final RString DATE_0801 = new RString("0801");
        private static final RString RSTRING_39 = new RString("39");

        public static boolean is老人所得区分必須入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            KogakuGassanShinseishoHoji 高額合算申請書保持
                    = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
            return !(div.getDdlHihokenshaJoho2().getSelectedIndex() == INT_0 && !RSTRING_3.equals(高額合算申請書保持.get申請状況()));
        }

        public static boolean is年度内範囲チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            FlexibleDate 開始計算期間 = div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue();
            FlexibleDate 終了計算期間 = div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue();
            if (開始計算期間 == null || 終了計算期間 == null || 開始計算期間.isEmpty() || 終了計算期間.isEmpty()) {
                return true;
            }
            int 申請対象年度 = Integer.parseInt(div.getDdlShinseiTaisyoNendo().getSelectedKey().toString());
            if (申請対象年度 == INT_2008) {
                FlexibleDate 計算期間FROM = new FlexibleDate(new RString(INT_2008).concat(DATE_0401));
                FlexibleDate 計算期間TO = new FlexibleDate(new RString(INT_2008 + INT_1).concat(DATE_0731));
                return 計算期間FROM.compareTo(開始計算期間) <= INT_0 && 計算期間TO.compareTo(終了計算期間) <= INT_0;
            } else if (INT_2008 < 申請対象年度) {
                FlexibleDate 計算期間FROM = new FlexibleDate(new RString(申請対象年度).concat(DATE_0801));
                FlexibleDate 計算期間TO = new FlexibleDate(new RString(申請対象年度 + INT_1).concat(DATE_0731));
                return 計算期間FROM.compareTo(開始計算期間) <= INT_0 && 計算期間TO.compareTo(終了計算期間) <= INT_0;
            }
            return true;
        }

        public static boolean is加入期間範囲チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            FlexibleDate 開始計算期間 = div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue();
            FlexibleDate 終了計算期間 = div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue();
            FlexibleDate 開始加入期間 = rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getFromValue());
            FlexibleDate 終了加入期間 = rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getToValue());
            if (開始計算期間 == null || 終了計算期間 == null || 開始加入期間 == null || 終了加入期間 == null
                    || 開始計算期間.isEmpty() || 終了計算期間.isEmpty() || 開始加入期間.isEmpty() || 終了加入期間.isEmpty()) {
                return true;
            }
            return 開始加入期間.compareTo(開始計算期間) <= INT_0 && 終了計算期間.compareTo(終了加入期間) <= INT_0;
        }

        public static boolean is資格喪失チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RDate 資格喪失日 = div.getTxtHihokenshaJohoShikakuSoshitsuYMD().getValue();
            boolean flg1 = 資格喪失日 == null || 資格喪失日.toDateString().isNullOrEmpty();
            boolean flg2 = div.getDdlHihokenshaJoho3().getSelectedIndex() != INT_0;
            return !(flg1 && flg2);
        }

        public static boolean is資格喪失チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RDate 資格喪失日 = div.getTxtHihokenshaJohoShikakuSoshitsuYMD().getValue();
            boolean flg1 = 資格喪失日 != null && !資格喪失日.toDateString().isNullOrEmpty();
            boolean flg2 = div.getDdlHihokenshaJoho3().getSelectedIndex() == 0;
            return !(flg1 && flg2);
        }

        public static boolean is後期資格情報保険者番号(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期保険者番号 = div.getTxtKokiShikaku().getText();
            return !(!RString.isNullOrEmpty(後期保険者番号) && !RSTRING_39.equals(後期保険者番号.substring(INT_0, INT_2)));
        }

        public static boolean is国保保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 国保保険者番号 = div.getTxtKokuhoShikakuHokensyaBango().getText();
            return !(!RString.isNullOrEmpty(国保保険者番号) && INT_8 != 国保保険者番号.length());
        }

        public static boolean is後期保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期保険者番号 = div.getTxtKokiShikaku().getText();
            return !(!RString.isNullOrEmpty(後期保険者番号) && INT_8 != 後期保険者番号.length());
        }

        public static boolean is後期被保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期被保険者番号 = div.getTxtKokiShikaku2().getText();
            return !(!RString.isNullOrEmpty(後期被保険者番号) && INT_8 != 後期被保険者番号.length());
        }

        public static boolean is被保険者証記号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 被保険者証記号 = div.getTxtKokuhoShikakuHikonensyaSyoKigo().getText();
            return !(!RString.isNullOrEmpty(被保険者証記号) && INT_20 != 被保険者証記号.length());
        }

        public static boolean is被保険者証番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 被保険者証番号 = div.getTxtKokuhoShikakuHikonensyaSyoBango().getText();
            return !(!RString.isNullOrEmpty(被保険者証番号) && INT_20 != 被保険者証番号.length());
        }

        public static boolean is介護日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getFromText())
                    || RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getToText())) {
                return true;
            }
            return div.getTxtKaigoShikakuJohoKanyuYMD().getFromValue().compareTo(
                    div.getTxtKaigoShikakuJohoKanyuYMD().getToValue()) <= INT_0;
        }

        public static boolean is被保日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is国保日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getFromText())
                    || RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getToText())) {
                return true;
            }
            return div.getTxtKokuhoShikakuKanyuYMD().getFromValue().compareTo(
                    div.getTxtKokuhoShikakuKanyuYMD().getFromValue()) <= INT_0;
        }

        public static boolean is後期日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getFromText())
                    || RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getToText())) {
                return true;
            }
            return div.getTxtKokiShikakuKanyuKikan().getFromValue().compareTo(
                    div.getTxtKokiShikakuKanyuKikan().getToValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getFromText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getFromValue())) <= INT_0;
        }

        public static boolean is開始計算期間チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getToText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getToValue())) <= INT_0;
        }

        public static boolean is開始計算期間チェック3(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getFromText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKokuhoShikakuKanyuYMD().getFromValue())) <= INT_0;
        }

        public static boolean is開始計算期間チェック4(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getToText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKokuhoShikakuKanyuYMD().getToValue())) <= INT_0;
        }

        public static boolean is開始計算期間チェック5(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getFromText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKokiShikakuKanyuKikan().getFromValue())) <= INT_0;
        }

        public static boolean is開始計算期間チェック6(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getToText())) {
                return true;
            }
            return div.getTxtHihokenshaJohoKeisanKikanSikiYMD().getValue().compareTo(
                    rDateToFixibleDate(div.getTxtKokiShikakuKanyuKikan().getToValue())) <= INT_0;
        }

        public static boolean is終了計算期間チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getFromText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getFromValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKaigoShikakuJohoKanyuYMD().getToText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKaigoShikakuJohoKanyuYMD().getToValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック3(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getFromText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKokuhoShikakuKanyuYMD().getFromValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック4(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokuhoShikakuKanyuYMD().getToText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKokuhoShikakuKanyuYMD().getToValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック5(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getFromText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKokiShikakuKanyuKikan().getFromValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック6(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getText())
                    || RString.isNullOrEmpty(div.getTxtKokiShikakuKanyuKikan().getToText())) {
                return true;
            }
            return rDateToFixibleDate(div.getTxtKokiShikakuKanyuKikan().getToValue()).compareTo(
                    div.getTxtHihokenshaJohoKeisanKikanSyukiYMD().getValue()) <= INT_0;
        }

        public static boolean is保険加入期間が不正チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return div.getTxtKanyuInfoKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtKanyuInfoKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is自己負担額証明書整理番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 証明書整理番号 = div.getTxtJikoFutangakuShomeishoSeiriBango().getText();
            return !(!RString.isNullOrEmpty(証明書整理番号) && INT_20 != 証明書整理番号.length());
        }

        public static boolean is自己負担額証明書整理番号既に存在チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 証明書整理番号 = div.getTxtJikoFutangakuShomeishoSeiriBango().getText();
            List<dgTorokuKanyRirekiuList_Row> rowList = div.getDgTorokuKanyRirekiuList().getDataSource();
            if (rowList == null || rowList.isEmpty()) {
                return true;
            }
            for (dgTorokuKanyRirekiuList_Row row : rowList) {
                if (証明書整理番号.equals(row.getTxtJikofutanSeiriNo())) {
                    return false;
                }
            }
            return true;
        }

        private static FlexibleDate rDateToFixibleDate(RDate date) {
            if (date == null || new RString(date.toString()).isEmpty()) {
                return null;
            }
            return new FlexibleDate(date.toString());
        }
    }
}
