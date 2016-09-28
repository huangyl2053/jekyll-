/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.KijunShunyuShinseiTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.dgMeisai_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku.KijunShunyuShinseiTourokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 基準収入額適用申請登録の入力チェックSpecです。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public enum KijunShunyuShinseiTourokuSpec implements IPredicate<KijunShunyuShinseiTourokuDiv> {

    /**
     * 適用データチェックです。
     */
    適用データチェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is適用データチェック(div);
                }
            },
    /**
     * 処理年度チェックです。
     */
    処理年度チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is処理年度チェック(div);
                }
            },
    /**
     * 世帯員把握基準日チェックです。
     */
    世帯員把握基準日チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is世帯員把握基準日チェック(div);
                }
            },
    /**
     * 適用開始チェック１です。
     */
    適用開始チェック１ {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is適用開始チェック１(div);
                }
            },
    /**
     * 適用開始チェック２です。
     */
    適用開始チェック２ {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is適用開始チェック２(div);
                }
            },
    /**
     * 世帯員が0人です。
     */
    世帯員が0人 {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is世帯員が0人(div);
                }
            },
    /**
     * 総収入額チェック２です。
     */
    総収入額チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is総収入額チェック(div);
                }
            },
    /**
     * 世帯課税チェックです。
     */
    世帯課税チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is世帯課税チェック(div);
                }
            },
    /**
     * 宛先印字者チェックです。
     */
    宛先印字者チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is宛先印字者チェック(div);
                }
            },
    /**
     * 控除再算出ボタンの実行時チェックです。
     */
    控除再算出チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is控除再算出チェック(div);
                }
            };

    private static class SpecHelper {

        private static final int NUM_0 = 0;
        private static final int NUM_1 = 1;
        private static final int NUM_4 = 4;
        private static final int NUM_6 = 6;
        private static final FlexibleYear 年度_2015 = new FlexibleYear("2015");
        private static final RString 月日_0801 = new RString("0801");
        private static final RString 月日_0731 = new RString("0731");
        private static final RString 月_08 = new RString("08");
        private static final RString 月_07 = new RString("07");

        public static boolean is適用データチェック(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 適用開始 = div.getMeisai().getTxtTekiyoStartYM().getValue();
            FlexibleDate 決定年月日 = div.getMeisai().getTxtKetteiYMD().getValue();
            RString 算定基準額 = div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue();
            return ((適用開始 != null && !適用開始.isEmpty()) && (決定年月日 != null && !決定年月日.isEmpty())
                    && (算定基準額 != null && !算定基準額.isEmpty()));
        }

        public static boolean is処理年度チェック(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
            RString 所得年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課);
            FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
            return !(年度.isBefore(年度_2015) || new FlexibleYear(所得年度).isBefore(年度));
        }

        public static boolean is世帯員把握基準日チェック(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 世帯員把握基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
            if (世帯員把握基準日 != null && !世帯員把握基準日.isEmpty()) {
                FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
                FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
                FlexibleDate 処理年度_0801 = new FlexibleDate(年度.toDateString().concat(月日_0801));
                FlexibleDate 処理年度_0731 = new FlexibleDate(年度.plusYear(NUM_1).toDateString().concat(月日_0731));
                return !(世帯員把握基準日.isBefore(処理年度_0801) || 処理年度_0731.isBefore(世帯員把握基準日));
            }
            return true;
        }

        public static boolean is適用開始チェック１(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 適用開始 = div.getMeisai().getTxtTekiyoStartYM().getValue();
            if (適用開始 == null || 適用開始.isEmpty()) {
                return true;
            }
            FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
            FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
            FlexibleYearMonth 処理年度_08 = new FlexibleYearMonth(年度.toDateString().concat(月_08));
            FlexibleYearMonth 処理年度_07 = new FlexibleYearMonth(年度.plusYear(NUM_1).toDateString().concat(月_07));
            FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(適用開始.toString().substring(NUM_0, NUM_6));
            return !(適用開始年月.isBefore(処理年度_08) || 処理年度_07.isBefore(適用開始年月));
        }

        public static boolean is適用開始チェック２(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 開始年月 = div.getMeisai().getTxtTekiyoStartYM().getValue();
            for (dgMeisai_Row row : div.getMeisai().getDgMeisai().getDataSource()) {
                HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getHihokenshaNo());
                if (!RowState.Deleted.equals(row.getRowState()) && 開始年月 != null && !開始年月.isEmpty()) {
                    FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(開始年月.toString().substring(NUM_0, NUM_6));
                    return KijunShunyuShinseiTourokuManager.createInstance().is適用開始チェック(被保険者番号, 適用開始年月);
                }
            }
            return true;
        }

        public static boolean is世帯員が0人(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            return (rowList != null && !rowList.isEmpty());
        }

        public static boolean is総収入額チェック(KijunShunyuShinseiTourokuDiv div) {
            Decimal 総収入額 = div.getMeisai().getTxtTotalShunyu().getValue();
            return (総収入額 != null);
        }

        public static boolean is世帯課税チェック(KijunShunyuShinseiTourokuDiv div) {
            RString 世帯課税 = div.getMeisai().getTxtSetaiKazei().getValue();
            return SetaiKazeiKubun.課税.get名称().equals(世帯課税);
        }

        public static boolean is宛先印字者チェック(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            int count = NUM_0;
            for (dgMeisai_Row row : rowList) {
                if (row.getAtesakiPrint()) {
                    count = count + NUM_1;
                }
            }
            return !(count == NUM_0 || NUM_1 < count);
        }

        public static boolean is控除再算出チェック(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            int 世帯主Count = NUM_0;
            for (dgMeisai_Row row : rowList) {
                if (row.getZennenSetainushi()) {
                    世帯主Count = 世帯主Count + NUM_1;
                }
            }
            return (世帯主Count <= NUM_1);
        }
    }
}
