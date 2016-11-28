/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.juryoininbarai.SanteiKijungaku;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.KijunShunyuShinseiTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.dgIchiran_Row;
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
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

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
     * 受給者または事業対象者チェックです。
     */
    受給者または事業対象者チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is受給者または事業対象者チェック(div);
                }
            },
    /**
     * 算定基準額チェックです。
     */
    算定基準額チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is算定基準額チェック(div);
                }
            },
    /**
     * 世帯再算出チェックです。
     */
    世帯再算出チェック {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is世帯再算出チェック(div);
                }
            },
    /**
     * 控除再算出ボタンの実行時チェック１です。
     */
    控除再算出チェック１ {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is控除再算出チェック１(div);
                }
            },
    /**
     * 控除再算出ボタンの実行時チェック２です。
     */
    控除再算出チェック２ {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is控除再算出チェック２(div);
                }
            },
    /**
     * 内容が変更されていないため、保存はできません。
     */
    内容変更なしで保存不可 {
                @Override
                public boolean apply(KijunShunyuShinseiTourokuDiv div) {
                    return SpecHelper.is変更(div);
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
        private static final int 歳以上_65 = 65;
        private static final Decimal 円_145万 = new Decimal("1450000");
        private static final Decimal 円_383万 = new Decimal("3830000");
        private static final Decimal 円_520万 = new Decimal("5200000");
        private static final RString 世帯再算出フラグ_0 = new RString("0");
        private static final RString 世帯再算出フラグ_1 = new RString("1");

        public static boolean is適用データチェック(KijunShunyuShinseiTourokuDiv div) {
            FlexibleDate 適用開始 = div.getMeisai().getTxtTekiyoStartYM().getValue();
            FlexibleDate 決定年月日 = div.getMeisai().getTxtKetteiYMD().getValue();
            RString 算定基準額 = div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue();
            return (isNullDate(適用開始) && isNullDate(決定年月日) && isNullRString(算定基準額))
                    || (!isNullDate(適用開始) && !isNullDate(決定年月日) && !isNullRString(算定基準額));
        }

        private static boolean isNullDate(FlexibleDate date) {
            return date == null || date.isEmpty();
        }

        private static boolean isNullRString(RString str) {
            return str.isNullOrEmpty();
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
            if (rowList == null || rowList.isEmpty()) {
                return false;
            }
            for (dgMeisai_Row row : rowList) {
                if (!RowState.Deleted.equals(row.getRowState())) {
                    return true;
                }
            }
            return false;
        }

        public static boolean is総収入額チェック(KijunShunyuShinseiTourokuDiv div) {
            Decimal 総収入額 = div.getMeisai().getTxtTotalShunyu().getValue();
            return 総収入額 != null;
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

        public static boolean is控除再算出チェック１(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            int 世帯主Count = NUM_0;
            for (dgMeisai_Row row : rowList) {
                if (row.getZennenSetainushi()) {
                    世帯主Count = 世帯主Count + NUM_1;
                }
            }
            return (世帯主Count <= NUM_1);
        }

        public static boolean is控除再算出チェック２(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            int 世帯主Count = NUM_0;
            for (dgMeisai_Row row : rowList) {
                if (row.getZennenSetainushi()) {
                    世帯主Count = 世帯主Count + NUM_1;
                }
            }
            return (世帯主Count != NUM_0);
        }

        public static boolean is変更(KijunShunyuShinseiTourokuDiv div) {
            for (dgIchiran_Row row : div.getDgIchiran().getDataSource()) {
                if (!RowState.Unchanged.equals(row.getRowState())) {
                    return true;
                }
            }
            return false;
        }

        public static boolean is世帯再算出チェック(KijunShunyuShinseiTourokuDiv div) {
            RString 世帯再算フラグ = DataPassingConverter.deserialize(
                    div.getMeisai().getHdnButtonSaiSanshutsuFlag(), RString.class);
            if (世帯再算出フラグ_0.equals(世帯再算フラグ) || 世帯再算出フラグ_1.equals(世帯再算フラグ)) {
                RString 変更前世帯コード = DataPassingConverter.deserialize(
                        div.getMeisai().getHdnHenkomaeStaiCode(), RString.class);
                FlexibleDate 変更前処理年度 = DataPassingConverter.deserialize(
                        div.getMeisai().getHdnHenkomaeShoriNendo(), FlexibleDate.class);
                FlexibleDate 変更前基準日 = DataPassingConverter.deserialize(
                        div.getMeisai().getHdnHenkomaeSetaiinHaakuKijunYMD(), FlexibleDate.class);
                RString 世帯コード = div.getMeisai().getTxtSetaiCode().getValue();
                FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
                FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
                return (変更前世帯コード.equals(世帯コード) && 変更前処理年度.equals(処理年度) && 変更前基準日.equals(基準日));
            }
            return true;
        }

        public static boolean is受給者または事業対象者チェック(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            for (dgMeisai_Row row : rowList) {
                if (row.getJyukyuJigyoTaisho() != null && !row.getJyukyuJigyoTaisho().isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        public static boolean is算定基準額チェック(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            return getチェック(div, rowList, get明細行総収入金額(div));
        }

        private static Decimal get明細行総収入金額(KijunShunyuShinseiTourokuDiv div) {
            List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
            Decimal 明細行総収入金額 = Decimal.ZERO;
            Decimal 公的年金;
            Decimal 給与;
            Decimal 以外の収入;
            for (dgMeisai_Row row : rowList) {
                if (get年齢(row.getAge()) < 歳以上_65 || RowState.Deleted.equals(row.getRowState())) {
                    continue;
                }
                公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
                給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
                以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
                明細行総収入金額 = 明細行総収入金額.add(公的年金).add(給与).add(以外の収入);
            }
            return 明細行総収入金額;
        }

        private static int get年齢(RString 年齢) {
            if (年齢.isNullOrEmpty()) {
                return 0;
            }
            return Integer.parseInt(年齢.toString());
        }

        private static boolean check算定基準額_44_400円(Decimal 課税所得, boolean 一人世帯flg, Decimal 一人で総収入金額,
                Decimal 二人以上で総収入金額, RString 算定基準額) {
            if (円_145万.compareTo(課税所得) < NUM_1
                    && ((一人世帯flg && 円_383万.compareTo(一人で総収入金額) == NUM_1) || (!一人世帯flg && 円_520万.compareTo(二人以上で総収入金額) == NUM_1))
                    && !SanteiKijungaku.算定基準額_44_400円.get略称().equals(算定基準額)) {
                return true;
            }
            return false;
        }

        private static boolean getチェック(KijunShunyuShinseiTourokuDiv div, List<dgMeisai_Row> rowList,
                Decimal 二人以上で総収入金額) {

            RString 算定基準額 = div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue();
            Decimal 一人で総収入金額;
            Decimal 公的年金;
            Decimal 給与;
            Decimal 以外の収入;
            Decimal 課税所得;
            boolean 一人世帯flg = rowList.size() == 1;
            for (dgMeisai_Row row : rowList) {
                課税所得 = row.getKazeiShotokuKojogo().getValue() == null ? Decimal.ZERO : row.getKazeiShotokuKojogo().getValue();
                公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
                給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
                以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
                一人で総収入金額 = 公的年金.add(給与).add(以外の収入);
                if (get年齢(row.getAge()) < 歳以上_65 || RowState.Deleted.equals(row.getRowState())) {
                    continue;
                }
                if (check算定基準額_44_400円(課税所得, 一人世帯flg, 一人で総収入金額, 二人以上で総収入金額, 算定基準額)) {
                    return false;
                }

                if (円_145万.compareTo(課税所得) < NUM_1
                        && ((一人世帯flg && 円_383万.compareTo(一人で総収入金額) < NUM_1) || (!一人世帯flg && 円_520万.compareTo(二人以上で総収入金額) < NUM_1))
                        && !SanteiKijungaku.算定基準額_37_200円.get略称().equals(算定基準額)) {
                    return false;
                }

                if (円_145万.compareTo(課税所得) == NUM_1
                        && SanteiKijungaku.算定基準額_44_400円.get略称().equals(算定基準額)) {
                    return false;
                }
            }

            return true;
        }
    }
}
