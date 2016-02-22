/*
 * To change this license headerItem, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NendoDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 */
public class ChoteiboReport extends Report<ChoteiboSource> {

    private final List<ChoteiboItem> targets;
    private final FlexibleYear 調定年度;
    private final YMDHMS 開始調定日時;
    private final YMDHMS 終了調定日時;
    private final List<NendoDataEntity> 年度データリスト;
    private final List<GokeiDataEntity> 合計データリスト;
    private final RString hokenshaNo;
    private final RString hokenshaName;

    private HokenryoDankaiList 当年度保険料段階リスト;
    private HokenryoDankaiList 前年度保険料段階リスト;
    private HokenryoDankaiList 前々年度保険料段階リスト;
    private DbT7022ShoriDateKanriEntity 当年度処理日付;
    private DbT7022ShoriDateKanriEntity 前年度処理日付;
    private DbT7022ShoriDateKanriEntity 前々年度処理日付;

    private static final RString HOSHI = new RString("※");
    private static final RString GOKEI = new RString("合計");
    private static final RString TONENDO = new RString("当年度");
    private static final RString ZENNENDO = new RString("前年度");
    private static final RString ZENZENNENDO = new RString("前々年度");
    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");

    protected ChoteiboReport(
            FlexibleYear 調定年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時,
            List<NendoDataEntity> 年度データリスト,
            List<GokeiDataEntity> 合計データリスト) {
        this.調定年度 = 調定年度;
        this.開始調定日時 = 開始調定日時;
        this.終了調定日時 = 終了調定日時;
        this.年度データリスト = 年度データリスト;
        this.合計データリスト = 合計データリスト;
        targets = new ArrayList<>();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        hokenshaNo = 導入団体クラス.getLasdecCode_().value();
        hokenshaName = 導入団体クラス.get市町村名();
    }

    public static ChoteiboReport createForm(
            @NonNull FlexibleYear 調定年度,
            @NonNull YMDHMS 開始調定日時,
            @NonNull YMDHMS 終了調定日時,
            @NonNull List<NendoDataEntity> 年度データリスト,
            @NonNull List<GokeiDataEntity> 合計データリスト) {
        return new ChoteiboReport(調定年度, 開始調定日時, 終了調定日時, 年度データリスト, 合計データリスト);
    }

    /**
     * 当年度保険料段階リストを設定する。
     *
     * @param 当年度保険料段階リスト
     */
    public void set当年度保険料段階リスト(HokenryoDankaiList 当年度保険料段階リスト) {
        this.当年度保険料段階リスト = 当年度保険料段階リスト;
    }

    /**
     * 前年度保険料段階リストを設定する。
     *
     * @param 前年度保険料段階リスト
     */
    public void set前年度保険料段階リスト(HokenryoDankaiList 前年度保険料段階リスト) {
        this.前年度保険料段階リスト = 前年度保険料段階リスト;
    }

    /**
     * 前々年度保険料段階リストを設定する。
     *
     * @param 前々年度保険料段階リスト
     */
    public void set前々年度保険料段階リスト(HokenryoDankaiList 前々年度保険料段階リスト) {
        this.前々年度保険料段階リスト = 前々年度保険料段階リスト;
    }

    /**
     * 当年度処理日付を設定する。
     *
     * @param 当年度処理日付
     */
    public void set当年度処理日付(DbT7022ShoriDateKanriEntity 当年度処理日付) {
        this.当年度処理日付 = 当年度処理日付;
    }

    /**
     * 前年度処理日付を設定する。
     *
     * @param 前年度処理日付
     */
    public void set前年度処理日付(DbT7022ShoriDateKanriEntity 前年度処理日付) {
        this.前年度処理日付 = 前年度処理日付;
    }

    /**
     * 前々年度処理日付を設定する。
     *
     * @param 前々年度処理日付
     */
    public void set前々年度処理日付(DbT7022ShoriDateKanriEntity 前々年度処理日付) {
        this.前々年度処理日付 = 前々年度処理日付;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChoteiboSource> writer) {
        ChoteiboHeaderItem headerItem = new ChoteiboHeaderItem(
                FlexibleDate.getNowDate().wareki().toDateString(),
                RString.EMPTY,
                調定年度.wareki().getYear().substring(0, 1),
                調定年度.wareki().getYear().substring(1),
                hokenshaNo,
                hokenshaName);
        makeChoteiboItemList();
        for (ChoteiboItem target : targets) {
            IChoteiboEditor headerEditor = new ChoteiboHeaderEditor(headerItem);
            ChoteiboKitsukiEditor kitsukiEditor = new ChoteiboKitsukiEditor(target.getKitsukiItem());
            ChoteiboDankaiGokeiEditor dankaiGokeiEditor = new ChoteiboDankaiGokeiEditor(target.getDankaiGokeiItem());
            for (ChoteiboDankaiItem dankaiItem : target.getDankaiItemList()) {
                ChoteiboDankaiEditor dankaiEditor = new ChoteiboDankaiEditor(dankaiItem);
                IChoteiboBuilder builder = new ChoteiboBuilder(headerEditor,
                        kitsukiEditor, dankaiEditor, dankaiGokeiEditor);
                writer.writeLine(builder);
            }
        }
    }

    private boolean is仮算定データ(FlexibleYear 年度) {
        if (this.調定年度.equals(年度)) {
            return is仮算定データ(当年度処理日付);
        } else if (this.調定年度.minusYear(1).equals(年度)) {
            return is仮算定データ(前年度処理日付);
        } else if (this.調定年度.minusYear(2).equals(年度)) {
            return is仮算定データ(前々年度処理日付);
        }
        return false;
    }

    private boolean is仮算定データ(DbT7022ShoriDateKanriEntity 処理日付) {
        return null == 処理日付
                || null == 処理日付.getKijunTimestamp()
                || 終了調定日時.isBefore(処理日付.getKijunTimestamp());
    }

    private void makeChoteiboItemList() {
        List<NendoDataEntity> 当年度データ = new ArrayList<>();
        List<NendoDataEntity> 前当年度データ = new ArrayList<>();
        List<NendoDataEntity> 前々当年度データ = new ArrayList<>();
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (this.調定年度.equals(年度データ.get調定年度())
                    && this.調定年度.equals(年度データ.get賦課年度())) {
                当年度データ.add(年度データ);
            } else if (this.調定年度.equals(年度データ.get調定年度())
                    && this.調定年度.minusYear(1).equals(年度データ.get賦課年度())) {
                前当年度データ.add(年度データ);
            } else if (this.調定年度.equals(年度データ.get調定年度())
                    && this.調定年度.minusYear(2).equals(年度データ.get賦課年度())) {
                前々当年度データ.add(年度データ);
            }
        }
        targets.add(makeChoteiboItem(当年度データ));
        targets.add(makeChoteiboItem(前当年度データ));
        targets.add(makeChoteiboItem(前々当年度データ));
        targets.add(makeChoteiboItemBy合計(合計データリスト));
    }

    private ChoteiboItem makeChoteiboItemBy合計(List<GokeiDataEntity> 合計データリスト) {
        ChoteiboKitsukiItem kitsukiItem = makeChoteiboKitsukiItemBy合計(合計データリスト);
        ChoteiboDankaiGokeiItem dankaiGokeiItem = makeChoteiboDankaiGokeiItemBy合計(合計データリスト);
        List<ChoteiboDankaiItem> dankaiItemList = makeChoteiboDankaiItemListBy合計(合計データリスト);
        return ChoteiboItem.createChoteiboItem(kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }

    private ChoteiboItem makeChoteiboItem(List<NendoDataEntity> 年度データリスト) {
        ChoteiboKitsukiItem kitsukiItem = makeChoteiboKitsukiItem(年度データリスト);
        ChoteiboDankaiGokeiItem dankaiGokeiItem = makeChoteiboDankaiGokeiItem(年度データリスト);
        List<ChoteiboDankaiItem> dankaiItemList = makeChoteiboDankaiItemList(年度データリスト);
        return ChoteiboItem.createChoteiboItem(kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }

    private ChoteiboKitsukiItem makeChoteiboKitsukiItemBy合計(List<GokeiDataEntity> 合計データリスト) {
        RString nendoTitle = get年度Title(true, null, null);
        RString fuchichoNofuGokei = RString.EMPTY;
        RString fuchoSaishutsuKanpuGaku = RString.EMPTY;
        RString fuchoSaishutsuKanpuSu = RString.EMPTY;
        RString tokuchoNofuGokei = RString.EMPTY;
        RString tokuchoSaishutsuKanfuGaku = RString.EMPTY;
        RString tokuchoSaishutsuKanpuSu = RString.EMPTY;
        RString listFuchoKi_1 = RString.EMPTY;
        RString listFuchoKi_2 = RString.EMPTY;
        RString listFuchoKi_3 = RString.EMPTY;
        RString listFuchoKi_4 = RString.EMPTY;
        RString listFuchoKi_5 = RString.EMPTY;
        RString listFuchoKi_6 = RString.EMPTY;
        RString listFuchoKi_7 = RString.EMPTY;
        RString listFuchoKi_8 = RString.EMPTY;
        RString listFuchoKi_9 = RString.EMPTY;
        RString listFuchoKi_10 = RString.EMPTY;
        RString listFuchoKi_11 = RString.EMPTY;
        RString listFuchoKi_12 = RString.EMPTY;
        RString listFuchoKi_13 = RString.EMPTY;
        RString listFuchoKi_14 = RString.EMPTY;
        RString listFuchoNofugaku_1 = RString.EMPTY;
        RString listFuchoNofugaku_2 = RString.EMPTY;
        RString listFuchoNofugaku_3 = RString.EMPTY;
        RString listFuchoNofugaku_4 = RString.EMPTY;
        RString listFuchoNofugaku_5 = RString.EMPTY;
        RString listFuchoNofugaku_6 = RString.EMPTY;
        RString listFuchoNofugaku_7 = RString.EMPTY;
        RString listFuchoNofugaku_8 = RString.EMPTY;
        RString listFuchoNofugaku_9 = RString.EMPTY;
        RString listFuchoNofugaku_10 = RString.EMPTY;
        RString listFuchoNofugaku_11 = RString.EMPTY;
        RString listFuchoNofugaku_12 = RString.EMPTY;
        RString listFuchoNofugaku_13 = RString.EMPTY;
        RString listFuchoNofugaku_14 = RString.EMPTY;
        RString listFuchoTsuki_1 = RString.EMPTY;
        RString listFuchoTsuki_2 = RString.EMPTY;
        RString listFuchoTsuki_3 = RString.EMPTY;
        RString listFuchoTsuki_4 = RString.EMPTY;
        RString listFuchoTsuki_5 = RString.EMPTY;
        RString listFuchoTsuki_6 = RString.EMPTY;
        RString listFuchoTsuki_7 = RString.EMPTY;
        RString listFuchoTsuki_8 = RString.EMPTY;
        RString listFuchoTsuki_9 = RString.EMPTY;
        RString listFuchoTsuki_10 = RString.EMPTY;
        RString listFuchoTsuki_11 = RString.EMPTY;
        RString listFuchoTsuki_12 = RString.EMPTY;
        RString listFuchoTsuki_13 = RString.EMPTY;
        RString listFuchoTsuki_14 = RString.EMPTY;
        RString listTokuchoKi_1 = RString.EMPTY;
        RString listTokuchoKi_2 = RString.EMPTY;
        RString listTokuchoKi_3 = RString.EMPTY;
        RString listTokuchoKi_4 = RString.EMPTY;
        RString listTokuchoKi_5 = RString.EMPTY;
        RString listTokuchoKi_6 = RString.EMPTY;
        RString listTokuchoNofugaku_1 = RString.EMPTY;
        RString listTokuchoNofugaku_2 = RString.EMPTY;
        RString listTokuchoNofugaku_3 = RString.EMPTY;
        RString listTokuchoNofugaku_4 = RString.EMPTY;
        RString listTokuchoNofugaku_5 = RString.EMPTY;
        RString listTokuchoNofugaku_6 = RString.EMPTY;
        RString listTokuchoTsuki_1 = RString.EMPTY;
        RString listTokuchoTsuki_2 = RString.EMPTY;
        RString listTokuchoTsuki_3 = RString.EMPTY;
        RString listTokuchoTsuki_4 = RString.EMPTY;
        RString listTokuchoTsuki_5 = RString.EMPTY;
        RString listTokuchoTsuki_6 = RString.EMPTY;
        RString listZuiji_1 = RString.EMPTY;
        RString listZuiji_2 = RString.EMPTY;
        RString listZuiji_3 = RString.EMPTY;
        RString listZuiji_4 = RString.EMPTY;
        RString listZuiji_5 = RString.EMPTY;
        RString listZuiji_6 = RString.EMPTY;
        RString listZuiji_7 = RString.EMPTY;
        RString listZuiji_8 = RString.EMPTY;
        RString listZuiji_9 = RString.EMPTY;
        RString listZuiji_10 = RString.EMPTY;
        RString listZuiji_11 = RString.EMPTY;
        RString listZuiji_12 = RString.EMPTY;
        RString listZuiji_13 = RString.EMPTY;
        RString listZuiji_14 = RString.EMPTY;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                fuchichoNofuGokei = changeDecimalToRString(合計データ.get普通徴収の調定額の総計());
                fuchoSaishutsuKanpuGaku = changeDecimalToRString(合計データ.get普徴歳出還付の調定額の総計());
                fuchoSaishutsuKanpuSu = changeDecimalToRString(合計データ.get普徴歳出還付の件数の総計());
                listFuchoNofugaku_1 = changeDecimalToRString(合計データ.get_4月の調定額の小計());
                listFuchoNofugaku_2 = changeDecimalToRString(合計データ.get_5月の調定額の小計());
                listFuchoNofugaku_3 = changeDecimalToRString(合計データ.get_6月の調定額の小計());
                listFuchoNofugaku_4 = changeDecimalToRString(合計データ.get_7月の調定額の小計());
                listFuchoNofugaku_5 = changeDecimalToRString(合計データ.get_8月の調定額の小計());
                listFuchoNofugaku_6 = changeDecimalToRString(合計データ.get_9月の調定額の小計());
                listFuchoNofugaku_7 = changeDecimalToRString(合計データ.get_10月の調定額の小計());
                listFuchoNofugaku_8 = changeDecimalToRString(合計データ.get_11月の調定額の小計());
                listFuchoNofugaku_9 = changeDecimalToRString(合計データ.get_12月の調定額の小計());
                listFuchoNofugaku_10 = changeDecimalToRString(合計データ.get_1月の調定額の小計());
                listFuchoNofugaku_11 = changeDecimalToRString(合計データ.get_2月の調定額の小計());
                listFuchoNofugaku_12 = changeDecimalToRString(合計データ.get_3月の調定額の小計());
                listFuchoNofugaku_13 = changeDecimalToRString(合計データ.get翌_4月の調定額の小計());
                listFuchoNofugaku_14 = changeDecimalToRString(合計データ.get翌_5月の調定額の小計());
                listFuchoTsuki_1 = Tsuki._4月.get名称();
                listFuchoTsuki_2 = Tsuki._5月.get名称();
                listFuchoTsuki_3 = Tsuki._6月.get名称();
                listFuchoTsuki_4 = Tsuki._7月.get名称();
                listFuchoTsuki_5 = Tsuki._8月.get名称();
                listFuchoTsuki_6 = Tsuki._9月.get名称();
                listFuchoTsuki_7 = Tsuki._10月.get名称();
                listFuchoTsuki_8 = Tsuki._11月.get名称();
                listFuchoTsuki_9 = Tsuki._12月.get名称();
                listFuchoTsuki_10 = Tsuki._1月.get名称();
                listFuchoTsuki_11 = Tsuki._2月.get名称();
                listFuchoTsuki_12 = Tsuki._3月.get名称();
                listFuchoTsuki_13 = Tsuki.翌年度4月.get名称();
                listFuchoTsuki_14 = Tsuki.翌年度5月.get名称();
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                tokuchoNofuGokei = changeDecimalToRString(合計データ.get特別徴収の調定額の総計());
                tokuchoSaishutsuKanfuGaku = changeDecimalToRString(合計データ.get特徴歳出還付の調定額の総計());
                tokuchoSaishutsuKanpuSu = changeDecimalToRString(合計データ.get特徴歳出還付の件数の総計());
                listTokuchoNofugaku_1 = changeDecimalToRString(合計データ.get_4月の調定額の小計());
                listTokuchoNofugaku_2 = changeDecimalToRString(合計データ.get_6月の調定額の小計());
                listTokuchoNofugaku_3 = changeDecimalToRString(合計データ.get_8月の調定額の小計());
                listTokuchoNofugaku_4 = changeDecimalToRString(合計データ.get_10月の調定額の小計());
                listTokuchoNofugaku_5 = changeDecimalToRString(合計データ.get_12月の調定額の小計());
                listTokuchoNofugaku_6 = changeDecimalToRString(合計データ.get_2月の調定額の小計());
                listTokuchoTsuki_1 = Tsuki._4月.get名称();
                listTokuchoTsuki_2 = Tsuki._6月.get名称();
                listTokuchoTsuki_3 = Tsuki._8月.get名称();
                listTokuchoTsuki_4 = Tsuki._10月.get名称();
                listTokuchoTsuki_5 = Tsuki._12月.get名称();
                listTokuchoTsuki_6 = Tsuki._2月.get名称();
            }
        }
        ChoteiboKitsukiItem kitsukiItem = new ChoteiboKitsukiItem(
                nendoTitle, fuchichoNofuGokei, fuchoSaishutsuKanpuGaku,
                fuchoSaishutsuKanpuSu, tokuchoNofuGokei,
                tokuchoSaishutsuKanfuGaku, tokuchoSaishutsuKanpuSu,
                listFuchoKi_1, listFuchoKi_2, listFuchoKi_3, listFuchoKi_4,
                listFuchoKi_5, listFuchoKi_6, listFuchoKi_7, listFuchoKi_8,
                listFuchoKi_9, listFuchoKi_10, listFuchoKi_11, listFuchoKi_12,
                listFuchoKi_13, listFuchoKi_14,
                listFuchoNofugaku_1, listFuchoNofugaku_2, listFuchoNofugaku_3,
                listFuchoNofugaku_4, listFuchoNofugaku_5, listFuchoNofugaku_6,
                listFuchoNofugaku_7, listFuchoNofugaku_8, listFuchoNofugaku_9,
                listFuchoNofugaku_10, listFuchoNofugaku_11, listFuchoNofugaku_12,
                listFuchoNofugaku_13, listFuchoNofugaku_14,
                listFuchoTsuki_1, listFuchoTsuki_2, listFuchoTsuki_3, listFuchoTsuki_4,
                listFuchoTsuki_5, listFuchoTsuki_6, listFuchoTsuki_7, listFuchoTsuki_8,
                listFuchoTsuki_9, listFuchoTsuki_10, listFuchoTsuki_11, listFuchoTsuki_12,
                listFuchoTsuki_13, listFuchoTsuki_14,
                listTokuchoKi_1, listTokuchoKi_2, listTokuchoKi_3,
                listTokuchoKi_4, listTokuchoKi_5, listTokuchoKi_6,
                listTokuchoNofugaku_1, listTokuchoNofugaku_2, listTokuchoNofugaku_3,
                listTokuchoNofugaku_4, listTokuchoNofugaku_5, listTokuchoNofugaku_6,
                listTokuchoTsuki_1, listTokuchoTsuki_2, listTokuchoTsuki_3,
                listTokuchoTsuki_4, listTokuchoTsuki_5, listTokuchoTsuki_6,
                listZuiji_1, listZuiji_2, listZuiji_3, listZuiji_4,
                listZuiji_5, listZuiji_6, listZuiji_7, listZuiji_8,
                listZuiji_9, listZuiji_10, listZuiji_11, listZuiji_12,
                listZuiji_13, listZuiji_14);
        return kitsukiItem;
    }

    private ChoteiboKitsukiItem makeChoteiboKitsukiItem(List<NendoDataEntity> 年度データリスト) {
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        RString nendoTitle = get年度Title(false, 年度データリスト.get(0).get調定年度(),
                年度データリスト.get(0).get賦課年度());
        RString fuchichoNofuGokei = RString.EMPTY;
        RString fuchoSaishutsuKanpuGaku = RString.EMPTY;
        RString fuchoSaishutsuKanpuSu = RString.EMPTY;
        RString tokuchoNofuGokei = RString.EMPTY;
        RString tokuchoSaishutsuKanfuGaku = RString.EMPTY;
        RString tokuchoSaishutsuKanpuSu = RString.EMPTY;
        RString listFuchoKi_1 = RString.EMPTY;
        RString listFuchoKi_2 = RString.EMPTY;
        RString listFuchoKi_3 = RString.EMPTY;
        RString listFuchoKi_4 = RString.EMPTY;
        RString listFuchoKi_5 = RString.EMPTY;
        RString listFuchoKi_6 = RString.EMPTY;
        RString listFuchoKi_7 = RString.EMPTY;
        RString listFuchoKi_8 = RString.EMPTY;
        RString listFuchoKi_9 = RString.EMPTY;
        RString listFuchoKi_10 = RString.EMPTY;
        RString listFuchoKi_11 = RString.EMPTY;
        RString listFuchoKi_12 = RString.EMPTY;
        RString listFuchoKi_13 = RString.EMPTY;
        RString listFuchoKi_14 = RString.EMPTY;
        RString listFuchoNofugaku_1 = RString.EMPTY;
        RString listFuchoNofugaku_2 = RString.EMPTY;
        RString listFuchoNofugaku_3 = RString.EMPTY;
        RString listFuchoNofugaku_4 = RString.EMPTY;
        RString listFuchoNofugaku_5 = RString.EMPTY;
        RString listFuchoNofugaku_6 = RString.EMPTY;
        RString listFuchoNofugaku_7 = RString.EMPTY;
        RString listFuchoNofugaku_8 = RString.EMPTY;
        RString listFuchoNofugaku_9 = RString.EMPTY;
        RString listFuchoNofugaku_10 = RString.EMPTY;
        RString listFuchoNofugaku_11 = RString.EMPTY;
        RString listFuchoNofugaku_12 = RString.EMPTY;
        RString listFuchoNofugaku_13 = RString.EMPTY;
        RString listFuchoNofugaku_14 = RString.EMPTY;
        RString listFuchoTsuki_1 = RString.EMPTY;
        RString listFuchoTsuki_2 = RString.EMPTY;
        RString listFuchoTsuki_3 = RString.EMPTY;
        RString listFuchoTsuki_4 = RString.EMPTY;
        RString listFuchoTsuki_5 = RString.EMPTY;
        RString listFuchoTsuki_6 = RString.EMPTY;
        RString listFuchoTsuki_7 = RString.EMPTY;
        RString listFuchoTsuki_8 = RString.EMPTY;
        RString listFuchoTsuki_9 = RString.EMPTY;
        RString listFuchoTsuki_10 = RString.EMPTY;
        RString listFuchoTsuki_11 = RString.EMPTY;
        RString listFuchoTsuki_12 = RString.EMPTY;
        RString listFuchoTsuki_13 = RString.EMPTY;
        RString listFuchoTsuki_14 = RString.EMPTY;
        RString listTokuchoKi_1 = RString.EMPTY;
        RString listTokuchoKi_2 = RString.EMPTY;
        RString listTokuchoKi_3 = RString.EMPTY;
        RString listTokuchoKi_4 = RString.EMPTY;
        RString listTokuchoKi_5 = RString.EMPTY;
        RString listTokuchoKi_6 = RString.EMPTY;
        RString listTokuchoNofugaku_1 = RString.EMPTY;
        RString listTokuchoNofugaku_2 = RString.EMPTY;
        RString listTokuchoNofugaku_3 = RString.EMPTY;
        RString listTokuchoNofugaku_4 = RString.EMPTY;
        RString listTokuchoNofugaku_5 = RString.EMPTY;
        RString listTokuchoNofugaku_6 = RString.EMPTY;
        RString listTokuchoTsuki_1 = RString.EMPTY;
        RString listTokuchoTsuki_2 = RString.EMPTY;
        RString listTokuchoTsuki_3 = RString.EMPTY;
        RString listTokuchoTsuki_4 = RString.EMPTY;
        RString listTokuchoTsuki_5 = RString.EMPTY;
        RString listTokuchoTsuki_6 = RString.EMPTY;
        RString listZuiji_1 = RString.EMPTY;
        RString listZuiji_2 = RString.EMPTY;
        RString listZuiji_3 = RString.EMPTY;
        RString listZuiji_4 = RString.EMPTY;
        RString listZuiji_5 = RString.EMPTY;
        RString listZuiji_6 = RString.EMPTY;
        RString listZuiji_7 = RString.EMPTY;
        RString listZuiji_8 = RString.EMPTY;
        RString listZuiji_9 = RString.EMPTY;
        RString listZuiji_10 = RString.EMPTY;
        RString listZuiji_11 = RString.EMPTY;
        RString listZuiji_12 = RString.EMPTY;
        RString listZuiji_13 = RString.EMPTY;
        RString listZuiji_14 = RString.EMPTY;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                fuchichoNofuGokei = changeDecimalToRString(年度データ.get普通徴収の調定額の合計());
                fuchoSaishutsuKanpuGaku = changeDecimalToRString(年度データ.get普徴歳出還付の調定額());
                fuchoSaishutsuKanpuSu = changeDecimalToRString(年度データ.get普徴歳出還付の件数());
                listFuchoKi_1 = 期月リスト_普徴.get期の月(1).get(0).get表記().as第X期();
                listFuchoKi_2 = 期月リスト_普徴.get期の月(2).get(0).get表記().as第X期();
                listFuchoKi_3 = 期月リスト_普徴.get期の月(3).get(0).get表記().as第X期();
                listFuchoKi_4 = 期月リスト_普徴.get期の月(4).get(0).get表記().as第X期();
                listFuchoKi_5 = 期月リスト_普徴.get期の月(5).get(0).get表記().as第X期();
                listFuchoKi_6 = 期月リスト_普徴.get期の月(6).get(0).get表記().as第X期();
                listFuchoKi_7 = 期月リスト_普徴.get期の月(7).get(0).get表記().as第X期();
                listFuchoKi_8 = 期月リスト_普徴.get期の月(8).get(0).get表記().as第X期();
                listFuchoKi_9 = 期月リスト_普徴.get期の月(9).get(0).get表記().as第X期();
                listFuchoKi_10 = 期月リスト_普徴.get期の月(10).get(0).get表記().as第X期();
                listFuchoKi_11 = 期月リスト_普徴.get期の月(11).get(0).get表記().as第X期();
                listFuchoKi_12 = 期月リスト_普徴.get期の月(12).get(0).get表記().as第X期();
                listFuchoKi_13 = 期月リスト_普徴.get期の月(13).get(0).get表記().as第X期();
                listFuchoKi_14 = 期月リスト_普徴.get期の月(14).get(0).get表記().as第X期();
                listFuchoNofugaku_1 = changeDecimalToRString(年度データ.get第1期の調定額の小計());
                listFuchoNofugaku_2 = changeDecimalToRString(年度データ.get第2期の調定額の小計());
                listFuchoNofugaku_3 = changeDecimalToRString(年度データ.get第3期の調定額の小計());
                listFuchoNofugaku_4 = changeDecimalToRString(年度データ.get第4期の調定額の小計());
                listFuchoNofugaku_5 = changeDecimalToRString(年度データ.get第5期の調定額の小計());
                listFuchoNofugaku_6 = changeDecimalToRString(年度データ.get第6期の調定額の小計());
                listFuchoNofugaku_7 = changeDecimalToRString(年度データ.get第7期の調定額の小計());
                listFuchoNofugaku_8 = changeDecimalToRString(年度データ.get第8期の調定額の小計());
                listFuchoNofugaku_9 = changeDecimalToRString(年度データ.get第9期の調定額の小計());
                listFuchoNofugaku_10 = changeDecimalToRString(年度データ.get第10期の調定額の小計());
                listFuchoNofugaku_11 = changeDecimalToRString(年度データ.get第11期の調定額の小計());
                listFuchoNofugaku_12 = changeDecimalToRString(年度データ.get第12期の調定額の小計());
                listFuchoNofugaku_13 = changeDecimalToRString(年度データ.get第13期の調定額の小計());
                listFuchoNofugaku_14 = changeDecimalToRString(年度データ.get第14期の調定額の小計());
                listFuchoTsuki_1 = 期月リスト_普徴.get期の月(1).get(0).get月().get名称();
                listFuchoTsuki_2 = 期月リスト_普徴.get期の月(2).get(0).get月().get名称();
                listFuchoTsuki_3 = 期月リスト_普徴.get期の月(3).get(0).get月().get名称();
                listFuchoTsuki_4 = 期月リスト_普徴.get期の月(4).get(0).get月().get名称();
                listFuchoTsuki_5 = 期月リスト_普徴.get期の月(5).get(0).get月().get名称();
                listFuchoTsuki_6 = 期月リスト_普徴.get期の月(6).get(0).get月().get名称();
                listFuchoTsuki_7 = 期月リスト_普徴.get期の月(7).get(0).get月().get名称();
                listFuchoTsuki_8 = 期月リスト_普徴.get期の月(8).get(0).get月().get名称();
                listFuchoTsuki_9 = 期月リスト_普徴.get期の月(9).get(0).get月().get名称();
                listFuchoTsuki_10 = 期月リスト_普徴.get期の月(10).get(0).get月().get名称();
                listFuchoTsuki_11 = 期月リスト_普徴.get期の月(11).get(0).get月().get名称();
                listFuchoTsuki_12 = 期月リスト_普徴.get期の月(12).get(0).get月().get名称();
                listFuchoTsuki_13 = 期月リスト_普徴.get期の月(13).get(0).get月().get名称();
                listFuchoTsuki_14 = 期月リスト_普徴.get期の月(14).get(0).get月().get名称();
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                tokuchoNofuGokei = changeDecimalToRString(年度データ.get特別徴収の調定額の合計());
                tokuchoSaishutsuKanfuGaku = changeDecimalToRString(年度データ.get特徴歳出還付の調定額());
                tokuchoSaishutsuKanpuSu = changeDecimalToRString(年度データ.get特徴歳出還付の件数());
                listTokuchoKi_1 = 期月リスト_特徴.get期の月(1).get(0).get表記().as第X期();
                listTokuchoKi_2 = 期月リスト_特徴.get期の月(2).get(0).get表記().as第X期();
                listTokuchoKi_3 = 期月リスト_特徴.get期の月(3).get(0).get表記().as第X期();
                listTokuchoKi_4 = 期月リスト_特徴.get期の月(4).get(0).get表記().as第X期();
                listTokuchoKi_5 = 期月リスト_特徴.get期の月(5).get(0).get表記().as第X期();
                listTokuchoKi_6 = 期月リスト_特徴.get期の月(6).get(0).get表記().as第X期();
                listTokuchoNofugaku_1 = changeDecimalToRString(年度データ.get第1期の調定額の小計());
                listTokuchoNofugaku_2 = changeDecimalToRString(年度データ.get第2期の調定額の小計());
                listTokuchoNofugaku_3 = changeDecimalToRString(年度データ.get第3期の調定額の小計());
                listTokuchoNofugaku_4 = changeDecimalToRString(年度データ.get第4期の調定額の小計());
                listTokuchoNofugaku_5 = changeDecimalToRString(年度データ.get第5期の調定額の小計());
                listTokuchoNofugaku_6 = changeDecimalToRString(年度データ.get第6期の調定額の小計());
                listTokuchoTsuki_1 = 期月リスト_特徴.get期の月(1).get(0).get月().get名称();
                listTokuchoTsuki_2 = 期月リスト_特徴.get期の月(2).get(0).get月().get名称();
                listTokuchoTsuki_3 = 期月リスト_特徴.get期の月(3).get(0).get月().get名称();
                listTokuchoTsuki_4 = 期月リスト_特徴.get期の月(4).get(0).get月().get名称();
                listTokuchoTsuki_5 = 期月リスト_特徴.get期の月(5).get(0).get月().get名称();
                listTokuchoTsuki_6 = 期月リスト_特徴.get期の月(6).get(0).get月().get名称();
            }
        }
        ChoteiboKitsukiItem kitsukiItem = new ChoteiboKitsukiItem(
                nendoTitle, fuchichoNofuGokei, fuchoSaishutsuKanpuGaku,
                fuchoSaishutsuKanpuSu, tokuchoNofuGokei,
                tokuchoSaishutsuKanfuGaku, tokuchoSaishutsuKanpuSu,
                listFuchoKi_1, listFuchoKi_2, listFuchoKi_3, listFuchoKi_4,
                listFuchoKi_5, listFuchoKi_6, listFuchoKi_7, listFuchoKi_8,
                listFuchoKi_9, listFuchoKi_10, listFuchoKi_11, listFuchoKi_12,
                listFuchoKi_13, listFuchoKi_14,
                listFuchoNofugaku_1, listFuchoNofugaku_2, listFuchoNofugaku_3,
                listFuchoNofugaku_4, listFuchoNofugaku_5, listFuchoNofugaku_6,
                listFuchoNofugaku_7, listFuchoNofugaku_8, listFuchoNofugaku_9,
                listFuchoNofugaku_10, listFuchoNofugaku_11, listFuchoNofugaku_12,
                listFuchoNofugaku_13, listFuchoNofugaku_14,
                listFuchoTsuki_1, listFuchoTsuki_2, listFuchoTsuki_3, listFuchoTsuki_4,
                listFuchoTsuki_5, listFuchoTsuki_6, listFuchoTsuki_7, listFuchoTsuki_8,
                listFuchoTsuki_9, listFuchoTsuki_10, listFuchoTsuki_11, listFuchoTsuki_12,
                listFuchoTsuki_13, listFuchoTsuki_14,
                listTokuchoKi_1, listTokuchoKi_2, listTokuchoKi_3,
                listTokuchoKi_4, listTokuchoKi_5, listTokuchoKi_6,
                listTokuchoNofugaku_1, listTokuchoNofugaku_2, listTokuchoNofugaku_3,
                listTokuchoNofugaku_4, listTokuchoNofugaku_5, listTokuchoNofugaku_6,
                listTokuchoTsuki_1, listTokuchoTsuki_2, listTokuchoTsuki_3,
                listTokuchoTsuki_4, listTokuchoTsuki_5, listTokuchoTsuki_6,
                listZuiji_1, listZuiji_2, listZuiji_3, listZuiji_4,
                listZuiji_5, listZuiji_6, listZuiji_7, listZuiji_8,
                listZuiji_9, listZuiji_10, listZuiji_11, listZuiji_12,
                listZuiji_13, listZuiji_14);
        return kitsukiItem;
    }

    private RString get年度Title(boolean is合計, FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        if (is合計) {
            return GOKEI;
        }
        if (this.調定年度.equals(調定年度) && this.調定年度.equals(賦課年度)) {
            return TONENDO;
        }
        if (this.調定年度.equals(調定年度) && this.調定年度.minusYear(1).equals(賦課年度)) {
            return ZENNENDO;
        }
        if (this.調定年度.equals(調定年度) && this.調定年度.minusYear(2).equals(賦課年度)) {
            return ZENZENNENDO;
        }
        return RString.EMPTY;
    }

    private ChoteiboDankaiGokeiItem makeChoteiboDankaiGokeiItemBy合計(List<GokeiDataEntity> 合計データリスト) {
        RString listDankaiBetsuGokei_1 = GOKEI;
        RString listDankaiBetsuGokei_2 = RString.EMPTY;
        RString listDankaiBetsuGokei_3 = RString.EMPTY;
        RString listDankaiBetsuGokei_4 = RString.EMPTY;
        RString listFuchoGokei_1 = RString.EMPTY;
        RString listFuchoGokei_2 = RString.EMPTY;
        RString listFuchoGokei_3 = RString.EMPTY;
        RString listFuchoGokei_4 = RString.EMPTY;
        RString listFuchoGokei_5 = RString.EMPTY;
        RString listFuchoGokei_6 = RString.EMPTY;
        RString listFuchoGokei_7 = RString.EMPTY;
        RString listFuchoGokei_8 = RString.EMPTY;
        RString listFuchoGokei_9 = RString.EMPTY;
        RString listTokuchoGokei_1 = RString.EMPTY;
        RString listTokuchoGokei_2 = RString.EMPTY;
        RString listTokuchoGokei_3 = RString.EMPTY;
        RString listTokuchoGokei_4 = RString.EMPTY;
        RString listTokuchoGokei_5 = RString.EMPTY;
        RString listTokuchoGokei_6 = RString.EMPTY;
        RString listTokuchoGokei_7 = RString.EMPTY;
        RString listTokuchoGokei_8 = RString.EMPTY;
        RString listTokuchoGokei_9 = RString.EMPTY;
        RString mongon = RString.EMPTY;
        RString HeichoShaSuKome = 星を追加する(RString.EMPTY);
        RString fuchoShaSuKome = RString.EMPTY;
        RString fuchoTogetsuGakuKome = RString.EMPTY;
        RString fuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoTogetsuGakuKome = RString.EMPTY;
        RString tokuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                listDankaiBetsuGokei_3 = changeDecimalToRString(合計データ.get普徴者数の総計());
                listFuchoGokei_1 = GOKEI;
                listFuchoGokei_2 = changeDecimalToRString(合計データ.get前月末の全部件数の総計());
                listFuchoGokei_3 = changeDecimalToRString(合計データ.get前月末の全部調定額の総計());
                listFuchoGokei_4 = changeDecimalToRString(合計データ.get増の全部件数の総計());
                listFuchoGokei_5 = changeDecimalToRString(合計データ.get増の全部調定額の総計());
                listFuchoGokei_6 = changeDecimalToRString(合計データ.get減の全部件数の総計());
                listFuchoGokei_7 = changeDecimalToRString(合計データ.get減の全部調定額の総計());
                listFuchoGokei_8 = changeDecimalToRString(合計データ.get当月末の全部件数の総計());
                listFuchoGokei_9 = changeDecimalToRString(合計データ.get当月末の全部調定額の総計());

                Decimal 当月末の件数合計 = Decimal.ZERO;
                Decimal 当月末の調定額合計 = Decimal.ZERO;
                Decimal 普徴者数の件数合計 = Decimal.ZERO;
                for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
                    当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
                    当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
                    普徴者数の件数合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                }
                if (当月末の件数合計.equals(合計データ.get前月末の全部件数の総計())) {
                    fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                }
                if (当月末の調定額合計.equals(合計データ.get前月末の全部件数の総計())) {
                    fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                }
                if (普徴者数の件数合計.equals(合計データ.get前月末の全部件数の総計())) {
                    fuchoShaSuKome = 星を追加する(RString.EMPTY);
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                listDankaiBetsuGokei_2 = changeDecimalToRString(合計データ.get特徴者数の総計());
                listTokuchoGokei_1 = GOKEI;
                listTokuchoGokei_2 = changeDecimalToRString(合計データ.get前月末の全部件数の総計());
                listTokuchoGokei_3 = changeDecimalToRString(合計データ.get前月末の全部調定額の総計());
                listTokuchoGokei_4 = changeDecimalToRString(合計データ.get増の全部件数の総計());
                listTokuchoGokei_5 = changeDecimalToRString(合計データ.get増の全部調定額の総計());
                listTokuchoGokei_6 = changeDecimalToRString(合計データ.get減の全部件数の総計());
                listTokuchoGokei_7 = changeDecimalToRString(合計データ.get減の全部調定額の総計());
                listTokuchoGokei_8 = changeDecimalToRString(合計データ.get当月末の全部件数の総計());
                listTokuchoGokei_9 = changeDecimalToRString(合計データ.get当月末の全部調定額の総計());
                Decimal 当月末の件数合計 = Decimal.ZERO;
                Decimal 当月末の調定額合計 = Decimal.ZERO;
                Decimal 特徴者数の件数合計 = Decimal.ZERO;
                for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
                    当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
                    当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
                    特徴者数の件数合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
                }
                if (!当月末の件数合計.equals(合計データ.get前月末の全部件数の総計())) {
                    tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                }
                if (!当月末の調定額合計.equals(合計データ.get前月末の全部件数の総計())) {
                    tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                }
                if (!特徴者数の件数合計.equals(合計データ.get前月末の全部件数の総計())) {
                    tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
                }
            }
            if (null != 合計データ.get内併徴者数の総計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(合計データ.get内併徴者数の総計());
            }
            Decimal 内併徴者数の件数合計 = Decimal.ZERO;
            for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
                内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
            }
            if (!内併徴者数の件数合計.equals(合計データ.get前月末の全部件数の総計())) {
                HeichoShaSuKome = 星を追加する(RString.EMPTY);
            }
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                listDankaiBetsuGokei_1, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                listFuchoGokei_1, listFuchoGokei_2, listFuchoGokei_3, listFuchoGokei_4, listFuchoGokei_5,
                listFuchoGokei_6, listFuchoGokei_7, listFuchoGokei_8, listFuchoGokei_9, listTokuchoGokei_1,
                listTokuchoGokei_2, listTokuchoGokei_3, listTokuchoGokei_4, listTokuchoGokei_5, listTokuchoGokei_6,
                listTokuchoGokei_7, listTokuchoGokei_8, listTokuchoGokei_9,
                mongon, HeichoShaSuKome, fuchoShaSuKome, fuchoTogetsuGakuKome, fuchoTogetsuSuKome,
                tokuchoTogetsuGakuKome, tokuchoTogetsuSuKome, tokuchoshaShaSuKome);
        return dankaiGokeiItem;
    }

    private ChoteiboDankaiGokeiItem makeChoteiboDankaiGokeiItem(List<NendoDataEntity> 年度データリスト) {
        RString listDankaiBetsuGokei_1 = GOKEI;
        RString listDankaiBetsuGokei_2 = RString.EMPTY;
        RString listDankaiBetsuGokei_3 = RString.EMPTY;
        RString listDankaiBetsuGokei_4 = RString.EMPTY;
        RString listFuchoGokei_1 = RString.EMPTY;
        RString listFuchoGokei_2 = RString.EMPTY;
        RString listFuchoGokei_3 = RString.EMPTY;
        RString listFuchoGokei_4 = RString.EMPTY;
        RString listFuchoGokei_5 = RString.EMPTY;
        RString listFuchoGokei_6 = RString.EMPTY;
        RString listFuchoGokei_7 = RString.EMPTY;
        RString listFuchoGokei_8 = RString.EMPTY;
        RString listFuchoGokei_9 = RString.EMPTY;
        RString listTokuchoGokei_1 = RString.EMPTY;
        RString listTokuchoGokei_2 = RString.EMPTY;
        RString listTokuchoGokei_3 = RString.EMPTY;
        RString listTokuchoGokei_4 = RString.EMPTY;
        RString listTokuchoGokei_5 = RString.EMPTY;
        RString listTokuchoGokei_6 = RString.EMPTY;
        RString listTokuchoGokei_7 = RString.EMPTY;
        RString listTokuchoGokei_8 = RString.EMPTY;
        RString listTokuchoGokei_9 = RString.EMPTY;
        RString mongon = RString.EMPTY;
        RString HeichoShaSuKome = RString.EMPTY;
        RString fuchoShaSuKome = RString.EMPTY;
        RString fuchoTogetsuGakuKome = RString.EMPTY;
        RString fuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoTogetsuGakuKome = RString.EMPTY;
        RString tokuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                listDankaiBetsuGokei_3 = changeDecimalToRString(年度データ.get普徴者数の合計());
                listFuchoGokei_1 = GOKEI;
                listFuchoGokei_2 = changeDecimalToRString(年度データ.get前月末の全部件数の合計());
                listFuchoGokei_3 = changeDecimalToRString(年度データ.get前月末の全部調定額の合計());
                listFuchoGokei_4 = changeDecimalToRString(年度データ.get増の全部件数の合計());
                listFuchoGokei_5 = changeDecimalToRString(年度データ.get増の全部調定額の合計());
                listFuchoGokei_6 = changeDecimalToRString(年度データ.get減の全部件数の合計());
                listFuchoGokei_7 = changeDecimalToRString(年度データ.get減の全部調定額の合計());
                listFuchoGokei_8 = changeDecimalToRString(年度データ.get当月末の全部件数の合計());
                listFuchoGokei_9 = changeDecimalToRString(年度データ.get当月末の全部調定額の合計());
                Decimal 当月末の件数合計 = Decimal.ZERO;
                Decimal 当月末の調定額合計 = Decimal.ZERO;
                Decimal 普徴者数の件数合計 = Decimal.ZERO;
                for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
                    当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
                    当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
                    普徴者数の件数合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                }
                if (!当月末の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
                    fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                }
                if (!当月末の調定額合計.equals(年度データ.get前月末の全部件数の合計())) {
                    fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                }
                if (!普徴者数の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
                    fuchoShaSuKome = 星を追加する(RString.EMPTY);
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                listDankaiBetsuGokei_2 = changeDecimalToRString(年度データ.get特徴者数の合計());
                listTokuchoGokei_1 = GOKEI;
                listTokuchoGokei_2 = changeDecimalToRString(年度データ.get前月末の全部件数の合計());
                listTokuchoGokei_3 = changeDecimalToRString(年度データ.get前月末の全部調定額の合計());
                listTokuchoGokei_4 = changeDecimalToRString(年度データ.get増の全部件数の合計());
                listTokuchoGokei_5 = changeDecimalToRString(年度データ.get増の全部調定額の合計());
                listTokuchoGokei_6 = changeDecimalToRString(年度データ.get減の全部件数の合計());
                listTokuchoGokei_7 = changeDecimalToRString(年度データ.get減の全部調定額の合計());
                listTokuchoGokei_8 = changeDecimalToRString(年度データ.get当月末の全部件数の合計());
                listTokuchoGokei_9 = changeDecimalToRString(年度データ.get当月末の全部調定額の合計());
                Decimal 当月末の件数合計 = Decimal.ZERO;
                Decimal 当月末の調定額合計 = Decimal.ZERO;
                Decimal 特徴者数の件数合計 = Decimal.ZERO;
                for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
                    当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
                    当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
                    特徴者数の件数合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
                }
                if (!当月末の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
                    tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                }
                if (!当月末の調定額合計.equals(年度データ.get前月末の全部件数の合計())) {
                    tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                }
                if (!特徴者数の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
                    tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
                }
            }
            Decimal 内併徴者数の件数合計 = Decimal.ZERO;
            for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
                内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
            }
            if (!内併徴者数の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
                HeichoShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (null != 年度データ.get内併徴者数の合計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(年度データ.get内併徴者数の合計());
            }
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                listDankaiBetsuGokei_1, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                listFuchoGokei_1, listFuchoGokei_2, listFuchoGokei_3, listFuchoGokei_4, listFuchoGokei_5,
                listFuchoGokei_6, listFuchoGokei_7, listFuchoGokei_8, listFuchoGokei_9, listTokuchoGokei_1,
                listTokuchoGokei_2, listTokuchoGokei_3, listTokuchoGokei_4, listTokuchoGokei_5, listTokuchoGokei_6,
                listTokuchoGokei_7, listTokuchoGokei_8, listTokuchoGokei_9,
                mongon, HeichoShaSuKome, fuchoShaSuKome, fuchoTogetsuGakuKome, fuchoTogetsuSuKome,
                tokuchoTogetsuGakuKome, tokuchoTogetsuSuKome, tokuchoshaShaSuKome);
        return dankaiGokeiItem;
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemListBy合計(List<GokeiDataEntity> 合計データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        HokenryoDankaiList 保険料段階List = get保険料段階List(null);
        for (RString 段階表記 : 保険料段階List.to表記List()) {
            makeChoteiboDankaiItemBy合計(段階表記, 合計データリスト);
        }
        return dankaiItemList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItemBy合計(RString 段階表記, List<GokeiDataEntity> 合計データリスト) {
        RString listDankaiBetsu_1 = RString.EMPTY;
        RString listDankaiBetsu_2 = RString.EMPTY;
        RString listDankaiBetsu_3 = RString.EMPTY;
        RString listDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_1 = RString.EMPTY;
        RString listFuchoDankaiBetsu_2 = RString.EMPTY;
        RString listFuchoDankaiBetsu_3 = RString.EMPTY;
        RString listFuchoDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_5 = RString.EMPTY;
        RString listFuchoDankaiBetsu_6 = RString.EMPTY;
        RString listFuchoDankaiBetsu_7 = RString.EMPTY;
        RString listFuchoDankaiBetsu_8 = RString.EMPTY;
        RString listFuchoDankaiBetsu_9 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_1 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_2 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_3 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_4 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_5 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_6 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_7 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_8 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_9 = RString.EMPTY;

        RString 段階 = get段階(段階表記);

        if (null == 合計データリスト || 合計データリスト.isEmpty()) {
            listFuchoDankaiBetsu_2 = new RString("該当");
            listFuchoDankaiBetsu_3 = new RString("データ");
            listFuchoDankaiBetsu_4 = new RString("があり");
            listFuchoDankaiBetsu_5 = new RString("ません");
            ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                    listDankaiBetsu_1, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                    listFuchoDankaiBetsu_1, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                    listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                    listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9,
                    listTokuchoDankaiBetsu_1, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                    listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                    listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
            return dankaiItem;
        }
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                if (null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
                    listFuchoDankaiBetsu_2 = new RString("該当");
                    listFuchoDankaiBetsu_3 = new RString("データ");
                    listFuchoDankaiBetsu_4 = new RString("があり");
                    listFuchoDankaiBetsu_5 = new RString("ません");
                }
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (!段階.equals(段階小計.getDankai())) {
                        continue;
                    }
                    listFuchoDankaiBetsu_1 = 段階表記;
                    listFuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                    listFuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
                    listFuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                    listFuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                    listFuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                    listFuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                    listFuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                    listFuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
                    break;
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                if (null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
                    listTokuchoDankaiBetsu_2 = new RString("該当");
                    listTokuchoDankaiBetsu_3 = new RString("データ");
                    listTokuchoDankaiBetsu_4 = new RString("があり");
                    listTokuchoDankaiBetsu_5 = new RString("ません");
                }
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (!段階.equals(段階小計.getDankai())) {
                        continue;
                    }
                    listDankaiBetsu_1 = 段階表記;
                    listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                    listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                    listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                    listTokuchoDankaiBetsu_1 = 段階表記;
                    listTokuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                    listTokuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
                    listTokuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                    listTokuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                    listTokuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                    listTokuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                    listTokuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                    listTokuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
                    break;
                }
            }
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                listDankaiBetsu_1, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                listFuchoDankaiBetsu_1, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9,
                listTokuchoDankaiBetsu_1, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
        return dankaiItem;
    }

    private RString get段階(RString 段階表記) {
        if (null == 段階表記) {
            return RString.EMPTY;
        }
        RString 段階 = 段階表記.replace(文字列_第, RString.EMPTY);
        return 段階.replace(文字列_段階, RString.EMPTY);
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemList(List<NendoDataEntity> 年度データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        HokenryoDankaiList 保険料段階List = get保険料段階List(年度データリスト.get(0).get賦課年度());
        for (RString 段階表記 : 保険料段階List.to表記List()) {
            makeChoteiboDankaiItem(段階表記, 年度データリスト);
        }
        return dankaiItemList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItem(RString 段階表記, List<NendoDataEntity> 年度データリスト) {
        RString listDankaiBetsu_1 = RString.EMPTY;
        RString listDankaiBetsu_2 = RString.EMPTY;
        RString listDankaiBetsu_3 = RString.EMPTY;
        RString listDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_1 = RString.EMPTY;
        RString listFuchoDankaiBetsu_2 = RString.EMPTY;
        RString listFuchoDankaiBetsu_3 = RString.EMPTY;
        RString listFuchoDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_5 = RString.EMPTY;
        RString listFuchoDankaiBetsu_6 = RString.EMPTY;
        RString listFuchoDankaiBetsu_7 = RString.EMPTY;
        RString listFuchoDankaiBetsu_8 = RString.EMPTY;
        RString listFuchoDankaiBetsu_9 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_1 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_2 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_3 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_4 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_5 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_6 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_7 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_8 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_9 = RString.EMPTY;

        RString 段階 = get段階(段階表記);

        if (null == 年度データリスト || 年度データリスト.isEmpty()) {
            listFuchoDankaiBetsu_2 = new RString("該当");
            listFuchoDankaiBetsu_3 = new RString("データ");
            listFuchoDankaiBetsu_4 = new RString("があり");
            listFuchoDankaiBetsu_5 = new RString("ません");
            ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                    listDankaiBetsu_1, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                    listFuchoDankaiBetsu_1, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                    listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                    listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9,
                    listTokuchoDankaiBetsu_1, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                    listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                    listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
            return dankaiItem;
        }
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                if (null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
                    listFuchoDankaiBetsu_2 = new RString("該当");
                    listFuchoDankaiBetsu_3 = new RString("データ");
                    listFuchoDankaiBetsu_4 = new RString("があり");
                    listFuchoDankaiBetsu_5 = new RString("ません");
                }
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (!段階.equals(段階小計.getDankai())) {
                        continue;
                    }
                    listFuchoDankaiBetsu_1 = 段階表記;
                    listFuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                    listFuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
                    listFuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                    listFuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                    listFuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                    listFuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                    listFuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                    listFuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
                    break;
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                if (null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
                    listTokuchoDankaiBetsu_2 = new RString("該当");
                    listTokuchoDankaiBetsu_3 = new RString("データ");
                    listTokuchoDankaiBetsu_4 = new RString("があり");
                    listTokuchoDankaiBetsu_5 = new RString("ません");
                }
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (!段階.equals(段階小計.getDankai())) {
                        continue;
                    }
                    listDankaiBetsu_1 = 段階表記;
                    listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                    listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                    listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                    listTokuchoDankaiBetsu_1 = 段階表記;
                    listTokuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                    listTokuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
                    listTokuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                    listTokuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                    listTokuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                    listTokuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                    listTokuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                    listTokuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
                    break;
                }
            }
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                listDankaiBetsu_1, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                listFuchoDankaiBetsu_1, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9,
                listTokuchoDankaiBetsu_1, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
        return dankaiItem;
    }

    private HokenryoDankaiList get保険料段階List(FlexibleYear 年度) {
        if (this.調定年度.equals(年度)) {
            return 当年度保険料段階リスト;
        } else if (this.調定年度.minusYear(1).equals(年度)) {
            return 当年度保険料段階リスト;
        } else if (this.調定年度.minusYear(2).equals(年度)) {
            return 当年度保険料段階リスト;
        }
        return 当年度保険料段階リスト;
    }

    private RString 星を追加する(RString str) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(str == null ? RString.EMPTY : str);
        builder.append(HOSHI);
        return builder.toRString();
    }

    private RString changeDecimalToRString(Decimal val) {
        return null == val ? RString.EMPTY : new RString(String.valueOf(val.intValue()));
    }

    private Decimal changeNULLToZero(Decimal val) {
        return null == val ? Decimal.ZERO : val;
    }
}
