/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgKanyuRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
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
    },
    /**
     * 医療支給申請書整理番号入力チェックです。
     */
    医療支給申請書整理番号入力チェック {
        @Override
        public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return SpecHelper.is医療支給申請書整理番号入力チェック(div);
        }
    },
    /**
     * 所得区分入力チェック
     */
    所得区分入力チェック {
        @Override
        public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return SpecHelper.is所得区分入力チェック(div);
        }
    },
    /**
     * 加入期間FROM入力チェック
     */
    加入期間FROM入力チェック {
        @Override
        public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return SpecHelper.is加入期間FROM入力チェック(div);
        }
    },
    /**
     * 加入期間TO入力チェック
     */
    加入期間TO入力チェック {
        @Override
        public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return SpecHelper.is加入期間TO入力チェック(div);
        }
    },
    /**
     * 備考文字種チェック
     */
    備考文字種チェック {
        @Override
        public boolean apply(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return SpecHelper.is備考文字種チェック(div);
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
        private static final RString 追加 = new RString("追加");
        private static final RString DBCMN61009 = new RString("DBCMN61009");

        public static boolean is所得区分入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            if (DBCMN61009.equals(メニューID)) {
                return true;
            } else if (RString.isNullOrEmpty(div.getDdlShotokuKubun().getSelectedValue())) {
                return false;
            }
            return true;
        }

        public static boolean is加入期間FROM入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            return !(DBCMN61009.equals(メニューID) && div.getTxtKanyuKikanYMD().getFromValue() == null);
        }

        public static boolean is加入期間TO入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            return !(DBCMN61009.equals(メニューID) && div.getTxtKanyuKikanYMD().getToValue() == null);
        }

        public static boolean is備考文字種チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            return !(DBCMN61009.equals(メニューID) && !RStringUtil.is全角Only(div.getTxtBiko().getValue()));
        }

        public static boolean is老人所得区分必須入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            if (DBCMN61009.equals(メニューID)) {
                return true;
            }
            KogakuGassanShinseishoHoji 高額合算申請書保持
                    = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
            return !(div.getDdlOver70ShotokuKubun().getSelectedIndex() == INT_0 && !RSTRING_3.equals(高額合算申請書保持.get申請状況()));
        }

        public static boolean is年度内範囲チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RDate 開始計算期間 = div.getTxtTaishoKeisanKikanYMD().getFromValue();
            RDate 終了計算期間 = div.getTxtTaishoKeisanKikanYMD().getToValue();
            if (開始計算期間 == null || 終了計算期間 == null) {
                return true;
            }
            int 申請対象年度 = Integer.parseInt(div.getDdlShinseiTaishoNendo().getSelectedKey().toString());
            if (申請対象年度 == INT_2008) {
                RDate 計算期間FROM = new RDate(new RString(INT_2008).concat(DATE_0401).toString());
                RDate 計算期間TO = new RDate(new RString(INT_2008 + INT_1).concat(DATE_0731).toString());
                return 計算期間FROM.compareTo(開始計算期間) <= INT_0 && 終了計算期間.compareTo(計算期間TO) <= INT_0;
            } else if (INT_2008 < 申請対象年度) {
                RDate 計算期間FROM = new RDate(new RString(申請対象年度).concat(DATE_0801).toString());
                RDate 計算期間TO = new RDate(new RString(申請対象年度 + INT_1).concat(DATE_0731).toString());
                return 計算期間FROM.compareTo(開始計算期間) <= INT_0 && 終了計算期間.compareTo(計算期間TO) <= INT_0;
            }
            return true;
        }

        public static boolean is加入期間範囲チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RDate 開始計算期間 = div.getTxtTaishoKeisanKikanYMD().getFromValue();
            RDate 終了計算期間 = div.getTxtTaishoKeisanKikanYMD().getToValue();
            RDate 開始加入期間 = div.getTxtKanyuKikanYMD().getFromValue();
            RDate 終了加入期間 = div.getTxtKanyuKikanYMD().getToValue();
            if (開始計算期間 == null || 終了計算期間 == null || 開始加入期間 == null || 終了加入期間 == null) {
                return true;
            }
            return 開始加入期間.compareTo(開始計算期間) <= INT_0 && 終了計算期間.compareTo(終了加入期間) <= INT_0;
        }

        public static boolean is資格喪失チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            boolean flg1 = RString.isNullOrEmpty(div.getTxtShikakuSoshitsuYMD().getText());
            boolean flg2 = div.getDdlShikakuSoshitsuJiyu().getSelectedIndex() == INT_0;
            return !flg1 || flg2;
        }

        public static boolean is資格喪失チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            boolean flg1 = !RString.isNullOrEmpty(div.getTxtShikakuSoshitsuYMD().getText());
            boolean flg2 = div.getDdlShikakuSoshitsuJiyu().getSelectedIndex() == INT_0;
            return !flg1 || !flg2;
        }

        public static boolean is後期資格情報保険者番号(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期保険者番号 = div.getTxtKokiHokenshaNo().getText();
            return !(!RString.isNullOrEmpty(後期保険者番号) && !RSTRING_39.equals(後期保険者番号.substring(INT_0, INT_2)));
        }

        public static boolean is国保保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 国保保険者番号 = div.getTxtKokuhoHokenshaNo().getText();
            return !(!RString.isNullOrEmpty(国保保険者番号) && INT_8 != 国保保険者番号.length());
        }

        public static boolean is後期保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期保険者番号 = div.getTxtKokiHokenshaNo().getText();
            return !(!RString.isNullOrEmpty(後期保険者番号) && INT_8 != 後期保険者番号.length());
        }

        public static boolean is後期被保険者番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 後期被保険者番号 = div.getTxtKokiHihokenshaNo().getText();
            return !(!RString.isNullOrEmpty(後期被保険者番号) && INT_8 != 後期被保険者番号.length());
        }

        public static boolean is被保険者証記号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 被保険者証記号 = div.getTxtKokuhoHikonenshaShoKigo().getText();
            return !(!RString.isNullOrEmpty(被保険者証記号) && INT_20 != 被保険者証記号.length());
        }

        public static boolean is被保険者証番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 被保険者証番号 = div.getTxtKokuhoHikonenshaShoNo().getText();
            return !(!RString.isNullOrEmpty(被保険者証番号) && INT_20 != 被保険者証番号.length());
        }

        public static boolean is介護日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtKanyuKikanYMD().getFromValue() == null
                    || div.getTxtKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is被保日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtTaishoKeisanKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is国保日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtKokuhoKanyuKikanYMD().getFromValue() == null
                    || div.getTxtKokuhoKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKokuhoKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtKokuhoKanyuKikanYMD().getFromValue()) <= INT_0;
        }

        public static boolean is後期日付チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtKokiKanyuKikanYMD().getFromValue() == null
                    || div.getTxtKokiKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKokiKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtKokiKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKanyuKikanYMD().getFromValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック3(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKokuhoKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKokuhoKanyuKikanYMD().getFromValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック4(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKokuhoKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKokuhoKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック5(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKokiKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKokiKanyuKikanYMD().getFromValue()) <= INT_0;
        }

        public static boolean is開始計算期間チェック6(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKokiKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtTaishoKeisanKikanYMD().getFromValue().compareTo(
                    div.getTxtKokiKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック1(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getToValue() == null
                    || div.getTxtKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック2(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getToValue() == null
                    || div.getTxtKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKanyuKikanYMD().getToValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック3(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getToValue() == null
                    || div.getTxtKokuhoKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtKokuhoKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック4(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getToValue() == null
                    || div.getTxtKokuhoKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKokuhoKanyuKikanYMD().getToValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック5(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getToValue() == null
                    || div.getTxtKokiKanyuKikanYMD().getFromValue() == null) {
                return true;
            }
            return div.getTxtKokiKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is終了計算期間チェック6(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            if (div.getTxtTaishoKeisanKikanYMD().getFromValue() == null
                    || div.getTxtKokiKanyuKikanYMD().getToValue() == null) {
                return true;
            }
            return div.getTxtKokiKanyuKikanYMD().getToValue().compareTo(
                    div.getTxtTaishoKeisanKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is保険加入期間が不正チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            return div.getTxtKanyuRirekiKanyuKikanYMD().getFromValue().compareTo(
                    div.getTxtKanyuRirekiKanyuKikanYMD().getToValue()) <= INT_0;
        }

        public static boolean is自己負担額証明書整理番号桁数チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 証明書整理番号 = div.getTxtJikoFutangakuShomeishoSeiriBango().getText();
            return !(!RString.isNullOrEmpty(証明書整理番号) && INT_20 != 証明書整理番号.length());
        }

        public static boolean is自己負担額証明書整理番号既に存在チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 加入歴状態 = ViewStateHolder.get(ViewStateKeys.加入歴状態, RString.class);
            if (!追加.equals(加入歴状態)) {
                return true;
            }
            RString 証明書整理番号 = div.getTxtJikoFutangakuShomeishoSeiriBango().getText();
            List<dgKanyuRirekiIchiran_Row> rowList = div.getDgKanyuRirekiIchiran().getDataSource();
            if (rowList == null || rowList.isEmpty()) {
                return true;
            }
            for (dgKanyuRirekiIchiran_Row row : rowList) {
                if (証明書整理番号.equals(row.getTxtJikofutanSeiriNo())) {
                    return false;
                }
            }
            return true;
        }

        public static boolean is医療支給申請書整理番号入力チェック(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
            RString 整理番号2 = div.getTxtIryoShikyuShinseishoSeiriBango2().getText();
            RString 整理番号3 = div.getTxtIryoShikyuShinseishoSeiriBango3().getText();
            RString 整理番号4 = div.getTxtIryoShikyuShinseishoSeiriBango4().getText();
            return (RString.isNullOrEmpty(整理番号2) && RString.isNullOrEmpty(整理番号3) && RString.isNullOrEmpty(整理番号4))
                    || (!RString.isNullOrEmpty(整理番号2) && !RString.isNullOrEmpty(整理番号3) && !RString.isNullOrEmpty(整理番号4));
        }
    }
}
