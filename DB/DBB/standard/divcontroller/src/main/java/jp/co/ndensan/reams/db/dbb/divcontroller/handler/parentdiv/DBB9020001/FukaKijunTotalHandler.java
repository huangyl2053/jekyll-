/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HokenryoDankaiPattern;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.DBB9020001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.dgHokenryoDankai_Row;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbb.service.core.hokenryodankaipatternhantei.HokenryoDankaiPatternHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RankJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.RankJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * システム管理（賦課基準）のハンドラクラスです。
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class FukaKijunTotalHandler {

    private final FukaKijunTotalDiv div;
    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final FlexibleYear 平成27年 = new FlexibleYear("2015");
    private static final FlexibleYear 平成26年 = new FlexibleYear("2014");
    private static final FlexibleYear 平成25年 = new FlexibleYear("2013");
    private static final FlexibleYear 平成24年 = new FlexibleYear("2012");
    private static final FlexibleYear 平成23年 = new FlexibleYear("2011");
    private static final FlexibleYear 平成21年 = new FlexibleYear("2009");
    private static final FlexibleYear 平成20年 = new FlexibleYear("2008");
    private static final FlexibleYear 平成18年 = new FlexibleYear("2006");
    private static final FlexibleYear 平成17年 = new FlexibleYear("2005");
    private static final RString ランク_無 = new RString("0");
    private static final RString ランク_有 = new RString("1");
    private static final RString ランク区分_00 = new RString("00");
    private static final RString 段階インデックス_01 = new RString("01");
    private static final RString 段階インデックス_02 = new RString("02");
    private static final RString 段階インデックス_03 = new RString("03");
    private static final RString 段階インデックス_04 = new RString("04");
    private static final RString 段階インデックス_05 = new RString("05");
    private static final RString 段階インデックス_06 = new RString("06");
    private static final RString 段階インデックス_07 = new RString("07");
    private static final RString 順番_COLUMN = new RString("txtHokenryoDankaiIndex");
    private static final RString 段階区分_COLUMN = new RString("ddlHokenryoDankai");
    private static final RString 特例表示_COLUMN = new RString("txtTokureiHyoji");
    private static final RString 保険料率_COLUMN = new RString("txtHokenryoRitsu");
    private static final RString 基準所得金額_COLUMN = new RString("txtKijunShotokuKingaku");
    private static final RString タイトル_保険料段階および保険料率等を設定する = new RString("保険料段階および保険料率等を設定する");
    private static final RString タイトル_課税層段階 = new RString("課税層段階");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;
    private static final int NUM_15 = 15;
    private static final int NUM_16 = 16;
    private static final RString STR_ZERO = new RString("0");
    private static final RString STR_ONE = new RString("1");
    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");
    private static final RString 軽減対象 = new RString("（軽減対象）");
    private static final RString インデックス_00 = new RString("00");
    private static final RString 段階_031 = new RString("031");
    private static final RString 段階_041 = new RString("041");
    private static final RString 段階_042 = new RString("042");
    private static final RString 段階_043 = new RString("043");
    private static final RString 段階_051 = new RString("051");
    private static final RString 段階_052 = new RString("052");
    private static final RString 段階_053 = new RString("053");
    private static final RString 段階_054 = new RString("054");
    private static final RString 第４段階 = new RString("第４段階");
    private static final RString 第３段階 = new RString("第３段階");
    private static final RString 第５段階 = new RString("第５段階");
    private static final RString 第３段階_軽減対象 = new RString("第３段階（軽減対象）");
    private static final RString 第３段階_軽減対象外 = new RString("第３段階（軽減対象外）");
    private static final RString 第４段階_軽減対象 = new RString("第４段階（軽減対象）");
    private static final RString 第４段階_軽減対象外 = new RString("第４段階（軽減対象外）");
    private static final RString 第５段階_軽減対象 = new RString("第５段階（軽減対象）");
    private static final RString 第５段階_軽減対象外 = new RString("第５段階（軽減対象外）");
    private static final RString 第６段階_軽減対象外 = new RString("第６段階（軽減対象外）");
    private static final RString 第４_５段階 = new RString("第４／５段階");
    private static final RString 第５_６段階 = new RString("第５／６段階");
    private static final RString インデックス_05 = new RString("05");
    private static final RString インデックス_11 = new RString("11");
    private static final RString インデックス_17 = new RString("17");

    /**
     * コンストラクタです。
     *
     * @param div システム管理（賦課基準）の画面Div
     */
    public FukaKijunTotalHandler(FukaKijunTotalDiv div) {
        this.div = div;
    }

    /**
     * 賦課年度の設定のメソッドです。
     *
     * @param now システム日時
     */
    public void 賦課年度の設定(RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, now, SubGyomuCode.DBB介護賦課));
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri 新年度管理情報作成 = manager.get抽出調定日時(
                SubGyomuCode.DBB介護賦課, ShoriName.新年度管理情報作成.get名称(), 賦課年度.plusYear(NUM_1));
        boolean is新年度管理情報未作成 = null == 新年度管理情報作成
                || null == 新年度管理情報作成.get基準年月日()
                || 新年度管理情報作成.get基準年月日().isEmpty();
        FlexibleYear 年度 = is新年度管理情報未作成 ? 賦課年度 : 賦課年度.plusYear(NUM_1);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int index = 年度.getYearValue(); 平成12年.getYearValue() <= index; index--) {
            FlexibleYear 開始年度 = new FlexibleYear(new RString(index));
            KeyValueDataSource dataSource = new KeyValueDataSource(開始年度.seireki().toDateString(),
                    開始年度.wareki().toDateString());
            dataSourceList.add(dataSource);
        }
        div.getKonkaiShoriNaiyo().getDdlFukaNendo().setDataSource(dataSourceList);
        div.getKonkaiShoriNaiyo().getDdlFukaNendo().setSelectedKey(賦課年度.seireki().toDateString());
    }

    /**
     * ランクを取得のメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param now システム日時
     */
    public void ランクの取得(FlexibleYear 賦課年度, RDate now) {
        boolean isランク非表示 = false;
        RString ランク有無 = DbBusinessConfig.get(ConfigNameDBB.ランク管理情報_ランク有無, now, SubGyomuCode.DBB介護賦課);
        if (ランク_無.equals(ランク有無)) {
            isランク非表示 = true;
        } else if (ランク_有.equals(ランク有無)) {
            FlexibleYear ランク開始年度 = new FlexibleYear(DbBusinessConfig.get(
                    ConfigNameDBB.ランク管理情報_ランク開始年度, now, SubGyomuCode.DBB介護賦課));
            FlexibleYear ランク終了年度 = new FlexibleYear(DbBusinessConfig.get(
                    ConfigNameDBB.ランク管理情報_ランク終了年度, now, SubGyomuCode.DBB介護賦課));
            isランク非表示 = 賦課年度.isBefore(ランク開始年度) || ランク終了年度.isBefore(賦課年度);
        }
        div.getKonkaiShoriNaiyo().getDdlRank().setDisplayNone(isランク非表示);
        if (!isランク非表示) {
            ランクDDLのデータ設定(賦課年度);
        }
    }

    private void ランクDDLのデータ設定(FlexibleYear 賦課年度) {
        RankJohoManager manager = new RankJohoManager();
        List<RankJoho> ランク情報一覧 = manager.getランク情報一覧By賦課年度(賦課年度);
        if (!ランク情報一覧.isEmpty()) {
            List<KeyValueDataSource> dataSourceList = new ArrayList<>();
            for (RankJoho ランク情報 : ランク情報一覧) {
                KeyValueDataSource dataSource = new KeyValueDataSource(ランク情報.getランク区分(),
                        ランク情報.getランク名称());
                dataSourceList.add(dataSource);
            }
            div.getKonkaiShoriNaiyo().getDdlRank().setDataSource(dataSourceList);
            div.getKonkaiShoriNaiyo().getDdlRank().setSelectedIndex(NUM_0);
        }
    }

    /**
     * 賦課年度より、遷移先を設定のメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @return DBB9020001StateName
     */
    public DBB9020001StateName 遷移先の設定(FlexibleYear 賦課年度) {
        if (平成27年.isBeforeOrEquals(賦課年度)) {
            return DBB9020001StateName.平成27年以降;
        } else if (平成26年.equals(賦課年度)) {
            return DBB9020001StateName.平成26年;
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成25年)) {
            return DBB9020001StateName.平成24年から平25年まで;
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            return DBB9020001StateName.平成21年から平成23年まで;
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            return DBB9020001StateName.平成18年から平成20年;
        } else if (賦課年度.isBeforeOrEquals(平成17年)) {
            return DBB9020001StateName.平成17年以前;
        }
        return DBB9020001StateName.初期状態;
    }

    /**
     * 保険料率の取得と画面表示の設定のメソッドです。
     *
     * @param now システム日時
     * @return 保険料段階一覧 List
     */
    public List<HokenryoDankai> 保険料率の取得と画面表示の設定(RDate now) {
        HokenryoDankaiManager manager = new HokenryoDankaiManager();
        RString ランク区分 = div.getKonkaiShoriNaiyo().getDdlRank().isDisplayNone()
                ? ランク区分_00 : div.getKonkaiShoriNaiyo().getDdlRank().getSelectedKey();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        List<HokenryoDankai> 保険料段階一覧 = manager.get保険料段階一覧Byランク区分(賦課年度, ランク区分);
        if (!保険料段階一覧.isEmpty()) {
            Collections.sort(保険料段階一覧, new Comparator<HokenryoDankai>() {
                @Override
                public int compare(HokenryoDankai o1, HokenryoDankai o2) {
                    return o1.get段階インデックス().compareTo(o2.get段階インデックス());
                }
            });
        }
        return 保険料段階一覧;
    }

    /**
     * 画面項目の保険料率の値の設定のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 画面項目の保険料率の値の設定(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        Decimal 基準額 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                now, SubGyomuCode.DBB介護賦課).toString());
        if (平成27年.isBeforeOrEquals(賦課年度)) {
            set画面項目_平成27年以降(保険料段階一覧, now);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            set画面項目_平成24年から平成26年まで(保険料段階一覧, 賦課年度, now, 基準額);
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            set画面項目_平成21年から平成23年まで(保険料段階一覧, 賦課年度, now, 基準額);
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            set画面項目_平成18年から平成20年まで(保険料段階一覧, 賦課年度, now, 基準額);
        } else if (賦課年度.isBeforeOrEquals(平成17年)) {
            set画面項目_平成17年以前(保険料段階一覧, 賦課年度, now);
        }
    }

    private void set画面項目_平成17年以前(List<HokenryoDankai> 保険料段階一覧, FlexibleYear 賦課年度, RDate now) {
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_01));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_02));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
        保険料段階Gridの保険料等の設定(保険料段階一覧, 賦課年度, now, true);
    }

    private void set画面項目_平成18年から平成20年まで(List<HokenryoDankai> 保険料段階一覧,
            FlexibleYear 賦課年度,
            RDate now,
            Decimal 基準額) {
        FlexibleYear 激変緩和_開始年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_開始年度,
                now, SubGyomuCode.DBB介護賦課));
        FlexibleYear 激変緩和_終了年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_終了年度,
                now, SubGyomuCode.DBB介護賦課));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_01));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_02));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_07));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().setValue(基準額);
        if (激変緩和_開始年度.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(激変緩和_終了年度)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getBtnGekihenKanwa().setDisplayNone(false);
            set激変緩和保険料率ダイアログ用の保険料率(保険料段階一覧);
        } else {
            div.getShotokuDankai().getShotokuDankaiTo2014().getBtnGekihenKanwa().setDisplayNone(true);
        }
        保険料段階Gridの保険料等の設定(保険料段階一覧, 賦課年度, now, true);
    }

    private void set画面項目_平成21年から平成23年まで(List<HokenryoDankai> 保険料段階一覧,
            FlexibleYear 賦課年度,
            RDate now,
            Decimal 基準額) {
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_01));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_02));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().setValue(基準額);
        HokenryoDankaiPatternHantei 保険料段階パターン = new HokenryoDankaiPatternHantei();
        HokenryoDankaiPattern パターン = 保険料段階パターン.decideHokenryoDankaiPattern(賦課年度, 保険料段階一覧);
        div.setHdnPatan(パターン.getコード());
        Decimal 基準年金収入2 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                now, SubGyomuCode.DBB介護賦課).toString());
        set本人非課税世帯課税段階_平成21年から平成23年まで(保険料段階一覧, パターン.getコード(), 基準年金収入2);
        保険料段階Gridの保険料等の設定(保険料段階一覧, 賦課年度, now, true);
    }

    private void set画面項目_平成24年から平成26年まで(List<HokenryoDankai> 保険料段階一覧,
            FlexibleYear 賦課年度,
            RDate now,
            Decimal 基準額) {
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_01));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().setValue(
                get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_02));
        div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().setValue(基準額);
        HokenryoDankaiPatternHantei 保険料段階パターン = new HokenryoDankaiPatternHantei();
        HokenryoDankaiPattern パターン = 保険料段階パターン.decideHokenryoDankaiPattern(賦課年度, 保険料段階一覧);
        div.setHdnPatan(パターン.getコード());
        Decimal 基準年金収入2 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                now, SubGyomuCode.DBB介護賦課).toString());
        set世帯非課税段階_２段階以外(保険料段階一覧, パターン.getコード(), 基準年金収入2);

        Decimal 基準年金収入3 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                now, SubGyomuCode.DBB介護賦課).toString());
        set本人非課税世帯課税段階_平成24年から平成26年まで(保険料段階一覧, パターン.getコード(), 基準年金収入3);

        保険料段階Gridの保険料等の設定(保険料段階一覧, 賦課年度, now, true);
    }

    private void set画面項目_平成27年以降(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        for (HokenryoDankai 段階 : 保険料段階一覧) {
            if (段階_031.equals(段階.get段階区分()) || 段階_041.equals(段階.get段階区分())) {
                div.getShotokuDankai().getHokenryoDankaiFrom2015().getRadDankaihyokiNinisettei().setSelectedKey(STR_ONE);
                break;
            }
        }
        段階表記の任意設定の変更(保険料段階一覧, now);
    }

    private boolean toCheckパターン3(RString パターン, boolean flag) {
        if (flag) {
            return HokenryoDankaiPattern._2012_パターン1.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン2.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン3.getコード().equals(パターン);
        }
        return HokenryoDankaiPattern._2012_パターン1.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン7.getコード().equals(パターン);
    }

    private boolean toCheckパターン6(RString パターン, boolean flag) {
        if (flag) {
            return HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン7.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン8.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン9.getコード().equals(パターン);
        }
        return HokenryoDankaiPattern._2012_パターン2.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン3.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン8.getコード().equals(パターン)
                || HokenryoDankaiPattern._2012_パターン9.getコード().equals(パターン);
    }

    private void set激変緩和保険料率ダイアログ用の保険料率(List<HokenryoDankai> 保険料段階一覧) {
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            if (保険料段階.get保険料率() == null) {
                continue;
            }
            if (段階_041.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex04(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_042.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex05(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_043.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex06(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_051.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex08(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_052.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex09(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_053.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex10(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            } else if (段階_054.equals(保険料段階.get段階区分())) {
                div.getShotokuDankai().getShotokuDankaiTo2014().setHdnGekihenIndex11(
                        DataPassingConverter.serialize(保険料段階.get保険料率()));
            }
        }
    }

    private void 保険料段階Gridの保険料等の設定(List<HokenryoDankai> 保険料段階一覧,
            FlexibleYear 賦課年度,
            RDate now,
            boolean 業務コンフィグの取得Flag) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        RString 先頭インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                now, SubGyomuCode.DBB介護賦課);
        RString 最終インデックス = インデックス_00;
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            if (先頭インデックス.compareTo(保険料段階.get段階インデックス()) < NUM_1
                    && 保険料段階.get段階区分().substring(NUM_2, NUM_3).equals(STR_ZERO)) {
                保険料段階List.add(保険料段階);
            }
        }

        if (賦課年度.isBeforeOrEquals(平成27年)) {
            最終インデックス = インデックス_05;
        }
        if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            最終インデックス = インデックス_17;
        }
        if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            最終インデックス = インデックス_11;
        }
        if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)
                && !保険料段階List.isEmpty()) {
            最終インデックス = 保険料段階List.get(保険料段階List.size() - NUM_1).get段階インデックス();
        }

        List<dgHokenryoDankai_Row> rowList = new ArrayList<>();
        dgHokenryoDankai_Row row;
        List<KeyValueDataSource> dateSource;
        int 行目Flag = 1;
        for (HokenryoDankai 段階 : 保険料段階List) {
            if (最終インデックス.compareTo(段階.get段階インデックス()) < NUM_0) {
                break;
            }
            row = new dgHokenryoDankai_Row();
            row.getTxtHokenryoDankaiIndex().setValue(段階.get段階インデックス());
            dateSource = new ArrayList<>();
            dateSource.add(new KeyValueDataSource(段階.get段階インデックス(), get段階区分(段階.get段階区分())));
            row.getDdlHokenryoDankai().setDataSource(dateSource);
            row.getDdlHokenryoDankai().setSelectedKey(段階.get段階インデックス());
            row.getTxtHokenryoRitsu().setValue(段階.get保険料率());
            if (NUM_1 == 行目Flag) {
                row.getTxtKijunShotokuKingaku().setValue(null);
                row.getTxtKijunShotokuKingaku().setDisabled(true);
                row.setCellBgColor(基準所得金額_COLUMN.toString(), DataGridCellBgColor.bgColorLightGray);
            } else {
                if (業務コンフィグの取得Flag) {
                    Decimal 基準所得金額 = get基準所得金額(行目Flag, now);
                    row.getTxtKijunShotokuKingaku().setValue(基準所得金額);
                } else {
                    row.getTxtKijunShotokuKingaku().setValue(Decimal.ZERO);
                }
            }
            行目Flag = 行目Flag + NUM_1;
            rowList.add(row);
        }
        div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai().setDataSource(rowList);
    }

    private Decimal get基準所得金額(int 行目Flag, RDate now) {
        switch (行目Flag) {
            case NUM_2:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_3:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_4:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_5:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_6:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_7:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_8:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_9:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_10:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_11:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_12:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_13:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_14:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_15:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                        now, SubGyomuCode.DBB介護賦課).toString());
            case NUM_16:
                return new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                        now, SubGyomuCode.DBB介護賦課).toString());
            default:
                return null;
        }
    }

    /**
     * 本人保険料段階強制設定の設定段階の設定のメソッドです。
     *
     * @param now システム日時
     * @return 段階DateSource Map
     */
    public Map<RString, RString> 本人保険料段階強制設定の設定段階の設定(RDate now) {
        HokenryoDankaiManager manager = new HokenryoDankaiManager();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        FlexibleYear 激変緩和_開始年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_開始年度,
                now, SubGyomuCode.DBB介護賦課));
        FlexibleYear 激変緩和_終了年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_終了年度,
                now, SubGyomuCode.DBB介護賦課));
        RString ランク区分 = div.getKonkaiShoriNaiyo().getDdlRank().isDisplayNone()
                ? ランク区分_00 : div.getKonkaiShoriNaiyo().getDdlRank().getSelectedKey();
        List<HokenryoDankai> 保険料段階一覧 = manager.get保険料段階一覧Byランク区分(賦課年度, ランク区分);
        if (!保険料段階一覧.isEmpty()) {
            Collections.sort(保険料段階一覧, new Comparator<HokenryoDankai>() {
                @Override
                public int compare(HokenryoDankai o1, HokenryoDankai o2) {
                    return o1.get段階インデックス().compareTo(o2.get段階インデックス());
                }
            });
        }
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        boolean 除くFlag = false;
        if (激変緩和_開始年度.isBeforeOrEquals(賦課年度)
                && 賦課年度.isBeforeOrEquals(激変緩和_終了年度)) {
            除くFlag = true;
        }
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            if (保険料段階.get保険料率() != null && 保険料段階.get保険料率().compareTo(Decimal.ZERO) < NUM_1) {
                continue;
            }
            if (除くFlag) {
                if (保険料段階.get段階区分() != null && 保険料段階.get段階区分().substring(NUM_2, NUM_3).equals(STR_ZERO)) {
                    保険料段階List.add(保険料段階);
                }
            } else {
                保険料段階List.add(保険料段階);
            }
        }
        List<KeyValueDataSource> dateSource = new ArrayList<>();
        Map<RString, RString> 段階DateSource = new HashMap<>();
        for (HokenryoDankai 段階 : 保険料段階List) {
            RString 段階区分 = get段階区分(段階.get段階区分());
            dateSource.add(new KeyValueDataSource(段階.get段階インデックス(), 段階区分));
            段階DateSource.put(段階.get段階インデックス(), 段階区分);
        }
        div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDataSource(dateSource);
        div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDataSource(dateSource);
        div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDataSource(dateSource);
        return 段階DateSource;
    }

    private RString get段階区分_平成27年以降(RString 段階区分) {
        RString 区分;
        RStringBuilder 表記 = new RStringBuilder();
        表記.append(文字列_第);
        表記.append(Integer.valueOf(段階区分.substring(NUM_0, NUM_2).toString()));
        表記.append(文字列_段階);
        区分 = 表記.toRString();
        return 区分;
    }

    private RString get段階区分(RString 段階区分) {
        RString 区分;
        RStringBuilder 表記 = new RStringBuilder();
        表記.append(文字列_第);
        表記.append(Integer.valueOf(段階区分.substring(NUM_0, NUM_2).toString()));
        表記.append(文字列_段階);
        if (!段階区分.substring(NUM_2, NUM_3).equals(STR_ZERO)) {
            表記.append(軽減対象);
        }
        区分 = 表記.toRString();
        return 区分;
    }

    /**
     * 画面項目「5 保険料段階2015年以降」の表示を制御のメソッドです。
     *
     * @param now システム日時
     */
    public void 保険料段階2015年以降の表示設定(RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        DataGridSetting grid = div.getShotokuDankai().getHokenryoDankaiFrom2015()
                .getDgHokenryoDankai().getGridSetting();
        if (平成27年.isBeforeOrEquals(賦課年度)) {
            div.getShotokuDankai().getHokenryoDankaiFrom2015().setTitle(タイトル_保険料段階および保険料率等を設定する);
            div.getShotokuDankai().getHokenryoDankaiFrom2015().getRadDankaihyokiNinisettei().setDisplayNone(false);
            grid.getColumn(順番_COLUMN).setVisible(true);
            grid.getColumn(段階区分_COLUMN).setVisible(true);
            grid.getColumn(段階区分_COLUMN).getCellDetails().setDisabled(false);
            grid.getColumn(特例表示_COLUMN).setVisible(true);
            grid.getColumn(保険料率_COLUMN).setVisible(true);
            grid.getColumn(基準所得金額_COLUMN).setVisible(true);
        } else {
            div.getShotokuDankai().getHokenryoDankaiFrom2015().setTitle(タイトル_課税層段階);
            div.getShotokuDankai().getHokenryoDankaiFrom2015().getRadDankaihyokiNinisettei().setDisplayNone(true);
            grid.getColumn(順番_COLUMN).setVisible(false);
            grid.getColumn(段階区分_COLUMN).setVisible(true);
            grid.getColumn(段階区分_COLUMN).getCellDetails().setDisabled(true);
            grid.getColumn(特例表示_COLUMN).setVisible(false);
            grid.getColumn(保険料率_COLUMN).setVisible(true);
            grid.getColumn(基準所得金額_COLUMN).setVisible(true);
        }
    }

    private Decimal get保険料率From保険料段階一覧(List<HokenryoDankai> 保険料段階一覧, RString 段階インデックス) {
        if (保険料段階一覧.isEmpty()) {
            return null;
        }
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            if (段階インデックス.equals(保険料段階.get段階インデックス())) {
                return 保険料段階.get保険料率();
            }
        }
        return null;
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他を解除のメソッドです。
     */
    public void 前排他を解除する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        RealInitialLocker.release(key);
    }

    /**
     * 世帯非課税の軽減措置の変更のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 世帯非課税の軽減措置の変更(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai2Gai().getSelectedKey();
        RString 本人非課税の軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadKeigenSochiDankai4().getSelectedKey();
        RString 本人非課税の段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadDankaiHyokiDankai4().getSelectedKey();
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        if (STR_ONE.equals(軽減措置)) {
            if (STR_ZERO.equals(本人非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン4.getコード();
            } else if (STR_ZERO.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン5.getコード();
            } else if (STR_ONE.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン6.getコード();
            }
        } else {
            if (STR_ZERO.equals(本人非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン1.getコード();
            } else if (STR_ZERO.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン2.getコード();
            } else if (STR_ONE.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン3.getコード();
            }
        }
        div.setHdnPatan(パターン);
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            保険料段階 = 保険料段階.createBuilderForEdit().set保険料率(Decimal.ZERO).build();
            保険料段階List.add(保険料段階);
        }
        set世帯非課税段階_２段階以外(保険料段階List, パターン, Decimal.ZERO);
        set本人非課税世帯課税段階_平成24年から平成26年まで(保険料段階List, パターン, Decimal.ZERO);
        保険料段階Gridの保険料等の設定(保険料段階List, 賦課年度, now, false);
    }

    /**
     * 世帯非課税の段階表記の変更のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 世帯非課税の段階表記の変更(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai2Gai().getSelectedKey();
        RString 本人非課税の軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadKeigenSochiDankai4().getSelectedKey();
        RString 本人非課税の段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadDankaiHyokiDankai4().getSelectedKey();
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        if (STR_ZERO.equals(段階表記)) {
            if (STR_ZERO.equals(本人非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン4.getコード();
            } else if (STR_ZERO.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン5.getコード();
            } else if (STR_ONE.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン6.getコード();
            }
        } else {
            if (STR_ZERO.equals(本人非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン7.getコード();
            } else if (STR_ZERO.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン8.getコード();
            } else if (STR_ONE.equals(本人非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン9.getコード();
            }
        }
        div.setHdnPatan(パターン);
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            保険料段階 = 保険料段階.createBuilderForEdit().set保険料率(Decimal.ZERO).build();
            保険料段階List.add(保険料段階);
        }
        set世帯非課税段階_２段階以外(保険料段階List, パターン, Decimal.ZERO);
        set本人非課税世帯課税段階_平成24年から平成26年まで(保険料段階List, パターン, Decimal.ZERO);
        保険料段階Gridの保険料等の設定(保険料段階List, 賦課年度, now, false);
    }

    private void set世帯非課税段階_２段階以外(List<HokenryoDankai> 保険料段階一覧,
            RString パターン,
            Decimal 軽減判定基準額) {
        if (toCheckパターン3(パターン, true)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai2Gai().setSelectedKey(STR_ZERO);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai2Gai().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                    .setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai3().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .setLabelLText(第３段階);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
        } else if (toCheckパターン6(パターン, true)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai2Gai().setSelectedKey(STR_ONE);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai2Gai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                    .setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai3().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai3().setValue(軽減判定基準額);
            if (HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)) {
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai2Gai().setSelectedKey(STR_ZERO);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                        .setLabelLText(第３段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                        .setLabelLText(第３段階_軽減対象外);
            } else {
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai2Gai().setSelectedKey(STR_ONE);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                        .setLabelLText(第３段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                        .setLabelLText(第４段階_軽減対象外);
            }
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_04));
        }
    }

    private void set本人非課税世帯課税段階_平成24年から平成26年まで(
            List<HokenryoDankai> 保険料段階一覧,
            RString パターン,
            Decimal 軽減判定基準額) {
        if (toCheckパターン3(パターン, false)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai4().setSelectedKey(STR_ZERO);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setDisplayNone(true);
            if (HokenryoDankaiPattern._2012_パターン1.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)) {
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第４段階);
            } else {
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第５段階);
            }
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_05));
        } else if (toCheckパターン6(パターン, false)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai4().setSelectedKey(STR_ONE);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setValue(軽減判定基準額);
            List<KeyValueDataSource> dateSource = new ArrayList<>();
            if (HokenryoDankaiPattern._2012_パターン2.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)) {
                dateSource.add(new KeyValueDataSource(STR_ZERO, 第４段階));
                dateSource.add(new KeyValueDataSource(STR_ONE, 第４_５段階));
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDataSource(dateSource);
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ZERO);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                        .setLabelLText(第４段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第４段階_軽減対象外);
            } else if (HokenryoDankaiPattern._2012_パターン8.getコード().equals(パターン)) {
                dateSource.add(new KeyValueDataSource(STR_ZERO, 第５段階));
                dateSource.add(new KeyValueDataSource(STR_ONE, 第５_６段階));
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDataSource(dateSource);
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ZERO);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                        .setLabelLText(第５段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第５段階_軽減対象外);
            } else if (HokenryoDankaiPattern._2012_パターン3.getコード().equals(パターン)
                    || HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)) {
                dateSource.add(new KeyValueDataSource(STR_ZERO, 第４段階));
                dateSource.add(new KeyValueDataSource(STR_ONE, 第４_５段階));
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDataSource(dateSource);
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ONE);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                        .setLabelLText(第４段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第５段階_軽減対象外);
            } else {
                dateSource.add(new KeyValueDataSource(STR_ZERO, 第５段階));
                dateSource.add(new KeyValueDataSource(STR_ONE, 第５_６段階));
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDataSource(dateSource);
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ONE);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                        .setLabelLText(第５段階_軽減対象);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第６段階_軽減対象外);
            }
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_05));
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_06));
        }
    }

    /**
     * 本人非課税の軽減措置の変更のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 本人非課税の軽減措置の変更(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai4().getSelectedKey();
        RString 世帯非課税の軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadKeigenSochiDankai2Gai().getSelectedKey();
        RString 世帯非課税の段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadDankaiHyokiDankai2Gai().getSelectedKey();
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            保険料段階 = 保険料段階.createBuilderForEdit().set保険料率(Decimal.ZERO).build();
            保険料段階List.add(保険料段階);
        }
        if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            if (STR_ZERO.equals(軽減措置)) {
                パターン = HokenryoDankaiPattern._2009_パターン1.getコード();
            } else {
                パターン = HokenryoDankaiPattern._2009_パターン2.getコード();
            }
            set本人非課税世帯課税段階_平成21年から平成23年まで(保険料段階List, パターン, Decimal.ZERO);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            パターン = getパターン_軽減措置(軽減措置, 世帯非課税の軽減措置, 世帯非課税の段階表記);
            set本人非課税世帯課税段階_平成24年から平成26年まで(保険料段階List, パターン, Decimal.ZERO);
        }
        div.setHdnPatan(パターン);
        保険料段階Gridの保険料等の設定(保険料段階List, 賦課年度, now, false);
    }

    /**
     * 本人非課税の段階表記の変更のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 本人非課税の段階表記の変更(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().getSelectedKey();
        RString 世帯非課税の軽減措置 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadKeigenSochiDankai2Gai().getSelectedKey();
        RString 世帯非課税の段階表記 = div.getShotokuDankai().getShotokuDankaiTo2014()
                .getRadDankaiHyokiDankai2Gai().getSelectedKey();
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            保険料段階 = 保険料段階.createBuilderForEdit().set保険料率(Decimal.ZERO).build();
            保険料段階List.add(保険料段階);
        }
        if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            if (STR_ZERO.equals(段階表記)) {
                パターン = HokenryoDankaiPattern._2009_パターン2.getコード();
            } else {
                パターン = HokenryoDankaiPattern._2009_パターン3.getコード();
            }
            set本人非課税世帯課税段階_平成21年から平成23年まで(保険料段階List, パターン, Decimal.ZERO);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            パターン = getパターン_段階表記(段階表記, 世帯非課税の軽減措置, 世帯非課税の段階表記);
            set本人非課税世帯課税段階_平成24年から平成26年まで(保険料段階List, パターン, Decimal.ZERO);
        }
        div.setHdnPatan(パターン);
        保険料段階Gridの保険料等の設定(保険料段階List, 賦課年度, now, false);
    }

    private RString getパターン_軽減措置(RString 軽減措置, RString 世帯非課税の軽減措置, RString 世帯非課税の段階表記) {
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        if (STR_ONE.equals(軽減措置)) {
            if (STR_ZERO.equals(世帯非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン2.getコード();
            } else if (STR_ZERO.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン5.getコード();
            } else if (STR_ONE.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン8.getコード();
            }
        } else {
            if (STR_ZERO.equals(世帯非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン1.getコード();
            } else if (STR_ZERO.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン4.getコード();
            } else if (STR_ONE.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン7.getコード();
            }
        }
        return パターン;
    }

    private RString getパターン_段階表記(RString 段階表記, RString 世帯非課税の軽減措置, RString 世帯非課税の段階表記) {
        RString パターン = HokenryoDankaiPattern.パターン無し.getコード();
        if (STR_ONE.equals(段階表記)) {
            if (STR_ZERO.equals(世帯非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン3.getコード();
            } else if (STR_ZERO.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン6.getコード();
            } else if (STR_ONE.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン9.getコード();
            }
        } else {
            if (STR_ZERO.equals(世帯非課税の軽減措置)) {
                パターン = HokenryoDankaiPattern._2012_パターン2.getコード();
            } else if (STR_ZERO.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン5.getコード();
            } else if (STR_ONE.equals(世帯非課税の段階表記)) {
                パターン = HokenryoDankaiPattern._2012_パターン8.getコード();
            }
        }
        return パターン;
    }

    private void set本人非課税世帯課税段階_平成21年から平成23年まで(
            List<HokenryoDankai> 保険料段階一覧,
            RString パターン,
            Decimal 軽減判定基準額) {
        if (HokenryoDankaiPattern._2009_パターン1.getコード().equals(パターン)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai4().setSelectedKey(STR_ZERO);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .setLabelLText(第４段階);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_04));
        } else if (HokenryoDankaiPattern._2009_パターン2.getコード().equals(パターン)
                || HokenryoDankaiPattern._2009_パターン3.getコード().equals(パターン)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadKeigenSochiDankai4().setSelectedKey(STR_ONE);
            div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().setValue(軽減判定基準額);
            if (HokenryoDankaiPattern._2009_パターン2.getコード().equals(パターン)) {
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ZERO);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第４段階_軽減対象外);
            } else {
                div.getShotokuDankai().getShotokuDankaiTo2014().getRadDankaiHyokiDankai4().setSelectedKey(STR_ONE);
                div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                        .setLabelLText(第５段階_軽減対象外);
            }
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                    .setLabelLText(第４段階_軽減対象);
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_04));
            div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .setValue(get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_05));
        }
    }

    /**
     * 段階表記の任意設定の変更のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 段階表記の任意設定の変更(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        RString 選択Key = div.getShotokuDankai().getHokenryoDankaiFrom2015().getRadDankaihyokiNinisettei()
                .getSelectedKey();
        DataGridSetting grid = div.getShotokuDankai().getHokenryoDankaiFrom2015()
                .getDgHokenryoDankai().getGridSetting();
        if (STR_ZERO.equals(選択Key)) {
            grid.getColumn(段階区分_COLUMN).getCellDetails().setDisabled(true);
            grid.getColumn(特例表示_COLUMN).setVisible(false);
        } else {
            grid.getColumn(段階区分_COLUMN).getCellDetails().setDisabled(false);
            grid.getColumn(特例表示_COLUMN).setVisible(true);
        }
        set保険料段階Grid(保険料段階一覧, now, 選択Key);
    }

    private void set保険料段階Grid(List<HokenryoDankai> 保険料段階一覧, RDate now, RString 選択Key) {
        List<dgHokenryoDankai_Row> rowList = new ArrayList<>();
        dgHokenryoDankai_Row row;
        List<KeyValueDataSource> dateSource = new ArrayList<>();
        KeyValueDataSource source;
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            source = new KeyValueDataSource(保険料段階.get段階インデックス().concat(保険料段階.get段階区分()),
                    get段階区分_平成27年以降(保険料段階.get段階区分()));
            dateSource.add(source);
        }
        int 順番 = 1;
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            row = new dgHokenryoDankai_Row();
            row.getTxtHokenryoDankaiIndex().setValue(保険料段階.get段階インデックス());
            row.getDdlHokenryoDankai().setDataSource(dateSource);
            row.getDdlHokenryoDankai().setSelectedKey(保険料段階.get段階インデックス().concat(保険料段階.get段階区分()));
            row.getTxtHokenryoRitsu().setValue(保険料段階.get保険料率());
            if (STR_ONE.equals(選択Key) && 保険料段階.get特例表記() != null) {
                row.getTxtTokureiHyoji().setValue(保険料段階.get特例表記());
            }
            if (順番 <= NUM_4) {
                row.setCellBgColor(順番_COLUMN.toString(), DataGridCellBgColor.bgColorLightRed);
                row.setCellBgColor(段階区分_COLUMN.toString(), DataGridCellBgColor.bgColorLightRed);
            } else if (順番 == NUM_5 || 順番 == NUM_6) {
                row.setCellBgColor(順番_COLUMN.toString(), DataGridCellBgColor.bgColorLightYellow);
                row.setCellBgColor(段階区分_COLUMN.toString(), DataGridCellBgColor.bgColorLightYellow);
            } else if (NUM_7 <= 順番 && 順番 <= NUM_9) {
                row.setCellBgColor(順番_COLUMN.toString(), DataGridCellBgColor.bgColorLightGreen);
                row.setCellBgColor(段階区分_COLUMN.toString(), DataGridCellBgColor.bgColorLightGreen);
            } else {
                row.setCellBgColor(順番_COLUMN.toString(), DataGridCellBgColor.bgColorLightBlue);
                row.setCellBgColor(段階区分_COLUMN.toString(), DataGridCellBgColor.bgColorLightBlue);
            }
            if (順番 == NUM_1 || 順番 == NUM_4 || 順番 == NUM_6) {
                row.getTxtKijunShotokuKingaku().setValue(null);
                row.getTxtKijunShotokuKingaku().setDisabled(true);
                row.setCellBgColor(基準所得金額_COLUMN.toString(), DataGridCellBgColor.bgColorLightGray);
            }
            if (順番 == NUM_2) {
                row.getTxtKijunShotokuKingaku().setValue(new Decimal(DbBusinessConfig.get(
                        ConfigNameDBB.賦課基準_基準年金収入1, now, SubGyomuCode.DBB介護賦課).toString()));
            } else if (順番 == NUM_3) {
                row.getTxtKijunShotokuKingaku().setValue(new Decimal(DbBusinessConfig.get(
                        ConfigNameDBB.賦課基準_基準年金収入3, now, SubGyomuCode.DBB介護賦課).toString()));
            } else if (順番 == NUM_5) {
                row.getTxtKijunShotokuKingaku().setValue(new Decimal(DbBusinessConfig.get(
                        ConfigNameDBB.賦課基準_基準年金収入2, now, SubGyomuCode.DBB介護賦課).toString()));
            } else if (NUM_7 <= 順番) {
                Decimal 基準所得金額 = get基準所得金額(順番 - NUM_5, now);
                row.getTxtKijunShotokuKingaku().setValue(基準所得金額);
            }
            順番 = 順番 + NUM_1;
            rowList.add(row);
        }
        div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai().setDataSource(rowList);
    }

    /**
     * 項目表示を制御のメソッドです。
     *
     * @param now システム日時
     * @param source Map
     */
    public void set項目表示を制御(RDate now, Map<RString, RString> source) {

        List<RString> dataSourceKeyList = getKeyList(source);
        List<KeyValueDataSource> dateSource = new ArrayList<>();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 強制設定_未申告 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                now, SubGyomuCode.DBB介護賦課);
        RString 設定段階_未申告 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                now, SubGyomuCode.DBB介護賦課);
        RString 課税区分の見直し方_未申告 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                now, SubGyomuCode.DBB介護賦課);
        div.getHokenryoRitsuIgaiInfo().getMishinkoku().getRadMishinkokuKyoseiSettei().setSelectedKey(強制設定_未申告);
        if (STR_ZERO.equals(強制設定_未申告)) {
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDataSource(dateSource);
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(true);
        } else if (!dataSourceKeyList.isEmpty()) {
            if (dataSourceKeyList.contains(設定段階_未申告)) {
                div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setSelectedKey(設定段階_未申告);
            } else {
                div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setSelectedIndex(NUM_0);
            }
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(false);
        } else {
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(false);
        }
        div.getHokenryoRitsuIgaiInfo().getMishinkoku().getRadtMishinkokuKazeiKbn()
                .setSelectedKey(課税区分の見直し方_未申告);

        RString 強制設定_所得調査中 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                now, SubGyomuCode.DBB介護賦課);
        RString 設定段階_所得調査中 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                now, SubGyomuCode.DBB介護賦課);
        RString 課税区分の見直し方_所得調査中 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                now, SubGyomuCode.DBB介護賦課);
        div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getRadShotokuChosaChuKyoseiSettei()
                .setSelectedKey(強制設定_所得調査中);
        div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getRadShotokuChosaChuKazeiKbn()
                .setSelectedKey(課税区分の見直し方_所得調査中);
        if (STR_ZERO.equals(強制設定_所得調査中)) {
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDataSource(dateSource);
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(true);
        } else if (!dataSourceKeyList.isEmpty()) {
            if (dataSourceKeyList.contains(設定段階_所得調査中)) {
                div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei()
                        .setSelectedKey(設定段階_所得調査中);
            } else {
                div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setSelectedIndex(NUM_0);
            }
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(false);
        } else {
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(false);
        }

        if (平成26年.equals(賦課年度) || 平成27年.equals(賦課年度)) {
            RString 強制設定_課税取消 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                    now, SubGyomuCode.DBB介護賦課);
            RString 設定段階_課税取消 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                    now, SubGyomuCode.DBB介護賦課);
            RString 課税区分の見直し方_課税取消 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                    now, SubGyomuCode.DBB介護賦課);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getRadKazeiTorikeshiKyoseiSettei()
                    .setSelectedKey(強制設定_課税取消);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getRadKazeiTorikeshiKazeiKbn()
                    .setSelectedKey(課税区分の見直し方_課税取消);
            set課税取消項目表示を制御(強制設定_課税取消, dataSourceKeyList, dateSource, 設定段階_課税取消);
        }

        RString 端数 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常, now, SubGyomuCode.DBB介護賦課);
        RString 丸め方 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常, now, SubGyomuCode.DBB介護賦課);
        div.getHokenryoRitsuIgaiInfo().getNengakuHokenryo().getDdlHasu().setSelectedKey(端数);
        div.getHokenryoRitsuIgaiInfo().getNengakuHokenryo().getDdlMarumeKata().setSelectedKey(丸め方);
    }

    private void set課税取消項目表示を制御(RString 強制設定_課税取消,
            List<RString> dataSourceKeyList,
            List<KeyValueDataSource> dateSource,
            RString 設定段階_課税取消) {
        if (STR_ZERO.equals(強制設定_課税取消)) {
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDataSource(dateSource);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(true);
        } else if (!dataSourceKeyList.isEmpty()) {
            if (dataSourceKeyList.contains(設定段階_課税取消)) {
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei()
                        .setSelectedKey(設定段階_課税取消);
            } else {
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setSelectedIndex(NUM_0);
            }
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(false);
        } else {
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(false);
        }
    }

    /**
     * 未申告の本人保険料段階の強制設定のメソッドです。
     *
     * @param dateSource 保険料段階DATESOURCE
     */
    public void 未申告設定段階の表示制御(Map<RString, RString> dateSource) {
        RString 強制設定_未申告 = div.getHokenryoRitsuIgaiInfo().getMishinkoku().getRadMishinkokuKyoseiSettei()
                .getSelectedKey();
        if (STR_ZERO.equals(強制設定_未申告)) {
            List<KeyValueDataSource> source = new ArrayList<>();
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(true);
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei()
                    .setDataSource(source);
        } else {
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(false);
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei()
                    .setDataSource(getDateSource(dateSource));
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setSelectedIndex(NUM_0);
        }
    }

    /**
     * 所得調査中の本人保険料段階の強制設定のメソッドです。
     *
     * @param dateSource 保険料段階DATESOURCE
     */
    public void 所得調査中設定段階の表示制御(Map<RString, RString> dateSource) {
        RString 強制設定_所得調査中 = div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu()
                .getRadShotokuChosaChuKyoseiSettei().getSelectedKey();
        if (STR_ZERO.equals(強制設定_所得調査中)) {
            List<KeyValueDataSource> source = new ArrayList<>();
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(true);
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei()
                    .setDataSource(source);
        } else {
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(false);
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei()
                    .setDataSource(getDateSource(dateSource));
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setSelectedIndex(NUM_0);
        }
    }

    /**
     * 課税取消の場合本人保険料段階の強制設定のメソッドです。
     *
     * @param dateSource 保険料段階DATESOURCE
     */
    public void 課税取消設定段階の表示制御(Map<RString, RString> dateSource) {
        RString 強制設定_課税取消 = div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getRadKazeiTorikeshiKyoseiSettei()
                .getSelectedKey();
        if (STR_ZERO.equals(強制設定_課税取消)) {
            List<KeyValueDataSource> source = new ArrayList<>();
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(true);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei()
                    .setDataSource(source);
        } else {
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(false);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei()
                    .setDataSource(getDateSource(dateSource));
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setSelectedIndex(NUM_0);
        }
    }

    private List<KeyValueDataSource> getDateSource(Map<RString, RString> map) {
        List<KeyValueDataSource> dateSource = new ArrayList<>();
        Set<Map.Entry<RString, RString>> set = map.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            dateSource.add(new KeyValueDataSource(entry.getKey(), entry.getValue()));
        }
        Collections.sort(dateSource, new Comparator<KeyValueDataSource>() {
            @Override
            public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return dateSource;
    }

    /**
     * 保険料段階マスタチェックのメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param 賦課年度 FlexibleYear
     * @return boolean
     */
    public boolean check保険料段階マスタ(List<HokenryoDankai> 保険料段階一覧, FlexibleYear 賦課年度) {
        if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            HokenryoDankaiPatternHantei 保険料段階パターン = new HokenryoDankaiPatternHantei();
            HokenryoDankaiPattern パターン = 保険料段階パターン.decideHokenryoDankaiPattern(賦課年度, 保険料段階一覧);
            return HokenryoDankaiPattern.パターン無し.getコード().equals(パターン.getコード());
        }
        return false;
    }

    /**
     * 状態定義のメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     */
    public void set状態定義(FlexibleYear 賦課年度) {
        if (賦課年度.isBeforeOrEquals(平成17年)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaiHikazeiDankai().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setDisplayNone(false);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(false);
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaiHikazeiDankai().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setDisplayNone(false);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(false);
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaiHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setDisplayNone(false);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(false);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成25年)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaiHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setDisplayNone(true);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(false);
        } else if (平成26年.equals(賦課年度)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaiHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setDisplayNone(true);
            div.getShotokuDankai().getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setDisplayNone(true);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(false);
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(false);
        } else if (平成27年.isBeforeOrEquals(賦課年度)) {
            div.getShotokuDankai().getShotokuDankaiTo2014().setDisplayNone(true);
            div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().setDisplayNone(false);
        }
    }

    /**
     * 保険料率チェックのメソッドです。
     *
     * @param 保険料段階一覧 List
     * @return boolean
     */
    public boolean check保険料率(List<HokenryoDankai> 保険料段階一覧) {
        int count = 保険料段階一覧.size();
        Decimal 保険料率;
        Decimal 次の保険料率;
        for (int index = NUM_1; index < count; index++) {
            保険料率 = 保険料段階一覧.get(index - NUM_1).get保険料率();
            次の保険料率 = 保険料段階一覧.get(index).get保険料率();
            if ((保険料率 == null || 保険料率.compareTo(Decimal.ZERO) == NUM_0)
                    || (次の保険料率 == null || 次の保険料率.compareTo(Decimal.ZERO) == NUM_0)) {
                return true;
            } else if (保険料率.compareTo(次の保険料率) == NUM_1) {
                return true;
            }
        }
        return false;
    }

    private List<RString> getKeyList(Map<RString, RString> source) {
        List<RString> keyList = new ArrayList<>();
        Set<Map.Entry<RString, RString>> set = source.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            keyList.add(entry.getKey());
        }
        return keyList;
    }

    /**
     * ランクの変更_項目表示を制御のメソッドです。
     *
     * @param dateSource Map
     */
    public void setランクの変更_項目表示を制御(Map<RString, RString> dateSource) {
        List<KeyValueDataSource> keyValueDateSource = new ArrayList<>();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        RString 強制設定_未申告 = div.getHokenryoRitsuIgaiInfo().getMishinkoku()
                .getRadMishinkokuKyoseiSettei().getSelectedKey();
        if (STR_ZERO.equals(強制設定_未申告)) {
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDataSource(keyValueDateSource);
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(true);
        } else if (dateSource != null && !dateSource.isEmpty()) {
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setSelectedIndex(NUM_0);
            div.getHokenryoRitsuIgaiInfo().getMishinkoku().getDdlMishinkokuKyoseiSettei().setDisabled(false);
        }

        RString 強制設定_所得調査中 = div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu()
                .getRadShotokuChosaChuKyoseiSettei().getSelectedKey();
        if (STR_ZERO.equals(強制設定_所得調査中)) {
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei()
                    .setDataSource(keyValueDateSource);
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(true);
        } else if (dateSource != null && !dateSource.isEmpty()) {
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setSelectedIndex(NUM_0);
            div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei().setDisabled(false);
        }

        if (平成26年.equals(賦課年度) || 平成27年.equals(賦課年度)) {
            RString 強制設定_課税取消 = div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getRadKazeiTorikeshiKyoseiSettei()
                    .getSelectedKey();
            if (STR_ZERO.equals(強制設定_課税取消)) {
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei()
                        .setDataSource(keyValueDateSource);
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(true);
            } else if (dateSource != null && !dateSource.isEmpty()) {
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setSelectedIndex(NUM_0);
                div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei().setDisabled(false);
            }
        }
    }
}
