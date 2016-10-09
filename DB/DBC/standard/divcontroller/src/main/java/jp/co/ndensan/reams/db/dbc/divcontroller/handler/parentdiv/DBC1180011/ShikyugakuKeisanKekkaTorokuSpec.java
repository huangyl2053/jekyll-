/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaRelate;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyuGakuKeisanKekka_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanShikyuFushikyuKetteiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanShikyuGakuKeisanKekkaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額合算支給額計算結果登録のSpecです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public enum ShikyugakuKeisanKekkaTorokuSpec implements IPredicate<ShikyugakuKeisanKekkaTorokuDiv> {

    /**
     * 重複チェックです。
     */
    重複チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is重複チェック(div);
                }
            },
    /**
     * 年度チェックです。
     */
    年度チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is年度チェック(div);
                }
            },
    /**
     * 明細グリッドのチェックです。
     */
    明細グリッドチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is明細グリッドチェック(div);
                }
            },
    /**
     * 按分後支給額のチェックです。
     */
    按分後支給額チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is按分後支給額チェック(div);
                }
            },
    /**
     * うち70歳以上分チェック。
     */
    うち70歳以上分チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.isうち70歳以上分チェック(div);
                }
            },
    /**
     * 介護等合算算定基準額チェック。
     */
    介護等合算算定基準額チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is介護等合算算定基準額チェック(div);
                }
            },
    /**
     * 対象計算期間終了年月日チェック。
     */
    対象計算期間終了年月日チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is対象計算期間終了年月日チェック(div);
                }
            },
    /**
     * 年度内範囲チェック。
     */
    年度内範囲チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is年度内範囲チェック(div);
                }
            },
    /**
     * 金額チェック。
     */
    金額チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is金額チェック(div);
                }
            },
    /**
     * 高額合算支給不支給決定データの存在チェック。
     */
    高額合算支給不支給決定データの存在チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is高額合算支給不支給決定データの存在チェック(div);
                }
            },
    /**
     * 自己負担額証明書整理番号桁数不正のチェック。
     */
    自己負担額証明書整理番号桁数不正のチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is自己負担額証明書整理番号桁数不正のチェック(div);
                }
            },
    /**
     * 保険者番号桁数不正のチェック。
     */
    保険者番号桁数不正のチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is保険者番号桁数不正のチェック(div);
                }
            },
    /**
     * 被保険者記号桁数不正のチェック。
     */
    被保険者記号桁数不正のチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is被保険者記号桁数不正のチェック(div);
                }
            },
    /**
     * 被保険者(証)番号桁数不正のチェック。
     */
    被保険者証番号桁数不正のチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is被保険者証番号桁数不正のチェック(div);
                }
            },
    /**
     * 自己負担額証明書整理番号入力値が不正チェック。
     */
    自己負担額証明書整理番号入力値が不正チェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is自己負担額証明書整理番号入力値が不正チェック(div);
                }
            },
    /**
     * 既に存在のチェック。
     */
    既に存在のチェック {
                @Override
                public boolean apply(ShikyugakuKeisanKekkaTorokuDiv div) {
                    return SpecHelper.is既に存在のチェック(div);
                }
            };

    /**
     * {@link ShikyugakuKeisanKekkaTorokuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final int INT_2008 = 2008;
        private static final int INT_0 = 0;
        private static final int INT_1 = 1;
        private static final int INT_2 = 2;
        private static final int INT_3 = 3;
        private static final int INT_5 = 5;
        private static final int INT_8 = 8;
        private static final int INT_11 = 11;
        private static final int INT_20 = 20;
        private static final RString RSTRING_3 = new RString("3");
        private static final RString RSTRING_99 = new RString("99");
        private static final RString DATE_0401 = new RString("0401");
        private static final RString DATE_0731 = new RString("0731");
        private static final RString DATE_0801 = new RString("0801");
        private static final RString 追加 = new RString("追加");

        public static boolean is重複チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
            RString 支給申請書整理番号 = div.getTxtShikyuShinseishoSeiriNoInput().getValue();
            KogakuGassanShikyuGakuKeisanKekkaManager manager = new KogakuGassanShikyuGakuKeisanKekkaManager();
            List<KogakuGassanShikyuGakuKeisanKekka> resultList
                    = manager.get高額合算支給額計算結果(被保険者番号, 支給申請書整理番号);
            boolean flg1 = resultList.isEmpty();
            List<dgKogakuGassanShikyuGakuKeisanKekka_Row> rowList
                    = div.getDgKogakuGassanShikyuGakuKeisanKekka().getDataSource();
            boolean flg2 = true;
            for (dgKogakuGassanShikyuGakuKeisanKekka_Row row : rowList) {
                if (支給申請書整理番号.equals(row.getTxtShikyuShinseishoSeiriNo())) {
                    flg2 = false;
                    break;
                }
            }
            return flg1 && flg2;
        }

        public static boolean is年度チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 支給申請書整理番号 = div.getTxtShikyuShinseishoSeiriNoInput().getValue();
            return RYear.canConvert(支給申請書整理番号.substringEmptyOnError(INT_0, INT_3));
        }

        public static boolean is明細グリッドチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            return !div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getDataSource().isEmpty();
        }

        public static boolean is按分後支給額チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            return !Decimal.ZERO.equals(div.getTxtHonninShikyugaku().getValue());
        }

        public static boolean isうち70歳以上分チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            boolean flg1 = INT_0 == div.getDdlOver70ShotokuKubun().getSelectedIndex();
            boolean flg2 = div.getTxtOver70HonninShikyugaku().getValue().compareTo(Decimal.ZERO) < 0;
            return !flg1 || !flg2;
        }

        public static boolean is介護等合算算定基準額チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            return div.getTxtSanteiKijunGaku().getValue() != null && !Decimal.ZERO.equals(div.getTxtSanteiKijunGaku().getValue());
        }

        private static boolean is対象計算期間終了年月日チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RDate 対象計算期間終了年月日 = div.getTxtTaishoKeisanKikan().getToValue();
            return 対象計算期間終了年月日.compareTo(RDate.getNowDate()) <= 0;
        }

        public static boolean is年度内範囲チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RDate 開始計算期間 = div.getTxtTaishoKeisanKikan().getFromValue();
            RDate 終了計算期間 = div.getTxtTaishoKeisanKikan().getToValue();
            if (開始計算期間 == null || 終了計算期間 == null) {
                return true;
            }
            int 申請対象年度 = div.getTxtTaishoNendo().getValue().getNendo().getYearValue();
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

        private static boolean is金額チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            Decimal 按分後支給額 = div.getTxtHonninShikyugaku().getValue();
            Decimal うち70歳以上分按分後支給額 = div.getTxtOver70HonninShikyugaku().getValue();
            return うち70歳以上分按分後支給額 == null || うち70歳以上分按分後支給額.compareTo(按分後支給額) <= 0;
        }

        private static boolean is高額合算支給不支給決定データの存在チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                    = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
            HihokenshaNo 被保険者番号 = 支給額計算結果.get被保険者番号();
            FlexibleYear 対象年度 = 支給額計算結果.get対象年度();
            HokenshaNo 証記載保険者番号 = 支給額計算結果.get証記載保険者番号();
            RString 支給申請書整理番号 = 支給額計算結果.get支給申請書整理番号();
            KogakuGassanShikyuFushikyuKetteiManager manager = new KogakuGassanShikyuFushikyuKetteiManager();
            List<KogakuGassanShikyuFushikyuKettei> resultList
                    = manager.get高額合算支給不支給決定情報(被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
            return resultList.isEmpty();
        }

        private static boolean is自己負担額証明書整理番号桁数不正のチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 自己負担額証明書整理番号 = div.getTxtJikoFutanSeiriNom().getValue();
            return !RString.isNullOrEmpty(自己負担額証明書整理番号) && 自己負担額証明書整理番号.length() == INT_20;
        }

        private static boolean is保険者番号桁数不正のチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 保険者番号 = div.getTxtShoKisaiHokenshaNo().getValue();
            return !RString.isNullOrEmpty(保険者番号) && 保険者番号.length() == INT_8;
        }

        private static boolean is被保険者記号桁数不正のチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 被保険者記号 = div.getTxtKokuhoHihokenshaShoKigo().getValue();
            return !RString.isNullOrEmpty(被保険者記号) && 被保険者記号.length() == INT_20;
        }

        private static boolean is被保険者証番号桁数不正のチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 被保険者証番号 = div.getTxtHiHokenshaShoNo().getValue();
            return !RString.isNullOrEmpty(被保険者証番号) && 被保険者証番号.length() == INT_20;
        }

        private static boolean is自己負担額証明書整理番号入力値が不正チェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 自己負担額証明書整理番号 = div.getTxtJikoFutanSeiriNom().getValue();
            RString 保険者番号 = 自己負担額証明書整理番号.substring(INT_5, INT_11);
            RString 先頭2桁 = 保険者番号.substring(INT_0, INT_2);
            boolean flg1 = RSTRING_3.equals(div.getDdlHokenSeido().getSelectedKey());
            boolean flg2 = RSTRING_99.equals(先頭2桁);
            return !flg1 || !flg2;
        }

        private static boolean is既に存在のチェック(ShikyugakuKeisanKekkaTorokuDiv div) {
            RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果明細状態, RString.class);
            if (!追加.equals(状態)) {
                return true;
            }
            RString 証明書整理番号 = div.getTxtJikoFutanSeiriNom().getText();
            List<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> rowList
                    = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getDataSource();
            if (rowList == null || rowList.isEmpty()) {
                return true;
            }
            for (dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row : rowList) {
                if (証明書整理番号.equals(row.getTxtJikoFutanSeiriNo())) {
                    return false;
                }
            }
            return true;
        }
    }
}
