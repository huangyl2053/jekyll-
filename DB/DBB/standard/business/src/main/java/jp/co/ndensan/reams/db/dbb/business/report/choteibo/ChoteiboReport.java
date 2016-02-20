/*
 * To change this license headerItem, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NendoDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiHyoki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.ChoshuHohoKibetsu;
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

    private List<ChoteiboItem> targets;
    private final FlexibleYear 調定年度;
    private final YMDHMS 開始調定日時;
    private final YMDHMS 終了調定日時;
    private final List<NendoDataEntity> 年度データリスト;
    private final List<GokeiDataEntity> 合計データリスト;
    private final RString hokenshaNo;
    private final RString hokenshaName;

    private static final RString HOSHI = new RString("※");
    private static final RString GOKEI = new RString("合計");
    private static final RString TONENDO = new RString("当年度");
    private static final RString ZENNENDO = new RString("前年度");
    private static final RString ZENZENNENDO = new RString("前々年度");

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

    private boolean is星を追加するか() {
        // TODO 3.2、合計行※印設定判定
        return true;
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
        RString nendoTitle = get年度Title(false, 年度データリスト.get(0).get調定年度(),
                年度データリスト.get(0).get賦課年度());
        RString fuchichoNofuGokei = RString.EMPTY;
        RString fuchoSaishutsuKanpuGaku = RString.EMPTY;
        RString fuchoSaishutsuKanpuSu = RString.EMPTY;
        RString tokuchoNofuGokei = RString.EMPTY;
        RString tokuchoSaishutsuKanfuGaku = RString.EMPTY;
        RString tokuchoSaishutsuKanpuSu = RString.EMPTY;
        KitsukiList list = get期月リスト();
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
                listFuchoKi_1 = get期の月(list, 1).get表記().as第X期();
                listFuchoKi_2 = get期の月(list, 2).get表記().as第X期();
                listFuchoKi_3 = get期の月(list, 3).get表記().as第X期();
                listFuchoKi_4 = get期の月(list, 4).get表記().as第X期();
                listFuchoKi_5 = get期の月(list, 5).get表記().as第X期();
                listFuchoKi_6 = get期の月(list, 6).get表記().as第X期();
                listFuchoKi_7 = get期の月(list, 7).get表記().as第X期();
                listFuchoKi_8 = get期の月(list, 8).get表記().as第X期();
                listFuchoKi_9 = get期の月(list, 9).get表記().as第X期();
                listFuchoKi_10 = get期の月(list, 10).get表記().as第X期();
                listFuchoKi_11 = get期の月(list, 11).get表記().as第X期();
                listFuchoKi_12 = get期の月(list, 12).get表記().as第X期();
                listFuchoKi_13 = get期の月(list, 13).get表記().as第X期();
                listFuchoKi_14 = get期の月(list, 14).get表記().as第X期();
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
                listFuchoTsuki_1 = get期の月(list, 1).get月().get名称();
                listFuchoTsuki_2 = get期の月(list, 2).get月().get名称();
                listFuchoTsuki_3 = get期の月(list, 3).get月().get名称();
                listFuchoTsuki_4 = get期の月(list, 4).get月().get名称();
                listFuchoTsuki_5 = get期の月(list, 5).get月().get名称();
                listFuchoTsuki_6 = get期の月(list, 6).get月().get名称();
                listFuchoTsuki_7 = get期の月(list, 7).get月().get名称();
                listFuchoTsuki_8 = get期の月(list, 8).get月().get名称();
                listFuchoTsuki_9 = get期の月(list, 9).get月().get名称();
                listFuchoTsuki_10 = get期の月(list, 10).get月().get名称();
                listFuchoTsuki_11 = get期の月(list, 11).get月().get名称();
                listFuchoTsuki_12 = get期の月(list, 12).get月().get名称();
                listFuchoTsuki_13 = get期の月(list, 13).get月().get名称();
                listFuchoTsuki_14 = get期の月(list, 14).get月().get名称();
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                tokuchoNofuGokei = changeDecimalToRString(年度データ.get特別徴収の調定額の合計());
                tokuchoSaishutsuKanfuGaku = changeDecimalToRString(年度データ.get特徴歳出還付の調定額());
                tokuchoSaishutsuKanpuSu = changeDecimalToRString(年度データ.get特徴歳出還付の件数());
                listTokuchoKi_1 = get期の月(list, 1).get表記().as第X期();
                listTokuchoKi_2 = get期の月(list, 2).get表記().as第X期();
                listTokuchoKi_3 = get期の月(list, 3).get表記().as第X期();
                listTokuchoKi_4 = get期の月(list, 4).get表記().as第X期();
                listTokuchoKi_5 = get期の月(list, 5).get表記().as第X期();
                listTokuchoKi_6 = get期の月(list, 6).get表記().as第X期();
                listTokuchoNofugaku_1 = changeDecimalToRString(年度データ.get第1期の調定額の小計());
                listTokuchoNofugaku_2 = changeDecimalToRString(年度データ.get第2期の調定額の小計());
                listTokuchoNofugaku_3 = changeDecimalToRString(年度データ.get第3期の調定額の小計());
                listTokuchoNofugaku_4 = changeDecimalToRString(年度データ.get第4期の調定額の小計());
                listTokuchoNofugaku_5 = changeDecimalToRString(年度データ.get第5期の調定額の小計());
                listTokuchoNofugaku_6 = changeDecimalToRString(年度データ.get第6期の調定額の小計());
                listTokuchoTsuki_1 = get期の月(list, 1).get月().get名称();
                listTokuchoTsuki_2 = get期の月(list, 2).get月().get名称();
                listTokuchoTsuki_3 = get期の月(list, 3).get月().get名称();
                listTokuchoTsuki_4 = get期の月(list, 4).get月().get名称();
                listTokuchoTsuki_5 = get期の月(list, 5).get月().get名称();
                listTokuchoTsuki_6 = get期の月(list, 6).get月().get名称();
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

    private Kitsuki get期の月(KitsukiList 期月リスト, int 期) {
        Kitsuki object = 期月リスト.get月の期(Tsuki._1月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._2月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._3月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._4月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._5月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._6月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._7月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._8月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._9月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._10月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._11月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki._12月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki.翌年度4月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        object = 期月リスト.get月の期(Tsuki.翌年度5月);
        if (object.get期AsInt() == 期) {
            return object;
        }
        return new Kitsuki(null, RString.EMPTY, null, false, KitsukiHyoki.EMPTY);
    }

    // TODO
    private KitsukiList get期月リスト() {
        List<Kitsuki> list = new ArrayList<>();
        Kitsuki object = new Kitsuki(Tsuki._1月, new RString("1"),
                null, false, new KitsukiHyoki(Tsuki._1月, new RString("1")));
        list.add(object);
        object = new Kitsuki(Tsuki._2月, new RString("2"),
                null, false, new KitsukiHyoki(Tsuki._2月, new RString("2")));
        list.add(object);
        object = new Kitsuki(Tsuki._3月, new RString("3"),
                null, false, new KitsukiHyoki(Tsuki._3月, new RString("3")));
        list.add(object);
        object = new Kitsuki(Tsuki._4月, new RString("4"),
                null, false, new KitsukiHyoki(Tsuki._4月, new RString("4")));
        list.add(object);
        object = new Kitsuki(Tsuki._5月, new RString("5"),
                null, false, new KitsukiHyoki(Tsuki._5月, new RString("5")));
        list.add(object);
        object = new Kitsuki(Tsuki._6月, new RString("6"),
                null, false, new KitsukiHyoki(Tsuki._6月, new RString("6")));
        list.add(object);
        object = new Kitsuki(Tsuki._7月, new RString("7"),
                null, false, new KitsukiHyoki(Tsuki._7月, new RString("7")));
        list.add(object);
        object = new Kitsuki(Tsuki._8月, new RString("8"),
                null, false, new KitsukiHyoki(Tsuki._8月, new RString("8")));
        list.add(object);
        object = new Kitsuki(Tsuki._9月, new RString("9"),
                null, false, new KitsukiHyoki(Tsuki._9月, new RString("9")));
        list.add(object);
        object = new Kitsuki(Tsuki._10月, new RString("10"),
                null, false, new KitsukiHyoki(Tsuki._10月, new RString("10")));
        list.add(object);
        object = new Kitsuki(Tsuki._11月, new RString("11"),
                null, false, new KitsukiHyoki(Tsuki._11月, new RString("11")));
        list.add(object);
        object = new Kitsuki(Tsuki._12月, new RString("12"),
                null, false, new KitsukiHyoki(Tsuki._12月, new RString("12")));
        list.add(object);
        object = new Kitsuki(Tsuki.翌年度4月, new RString("13"),
                null, false, new KitsukiHyoki(Tsuki.翌年度4月, new RString("13")));
        list.add(object);
        object = new Kitsuki(Tsuki.翌年度5月, new RString("14"),
                null, false, new KitsukiHyoki(Tsuki.翌年度5月, new RString("14")));
        list.add(object);
        return new KitsukiList(list);
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
                fuchoShaSuKome = 星を追加する(RString.EMPTY);
                fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
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
                tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (null != 合計データ.get内併徴者数の総計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(合計データ.get内併徴者数の総計());
            }
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                listDankaiBetsuGokei_1,
                listDankaiBetsuGokei_2,
                listDankaiBetsuGokei_3,
                listDankaiBetsuGokei_4,
                listFuchoGokei_1,
                listFuchoGokei_2,
                listFuchoGokei_3,
                listFuchoGokei_4,
                listFuchoGokei_5,
                listFuchoGokei_6,
                listFuchoGokei_7,
                listFuchoGokei_8,
                listFuchoGokei_9,
                listTokuchoGokei_1,
                listTokuchoGokei_2,
                listTokuchoGokei_3,
                listTokuchoGokei_4,
                listTokuchoGokei_5,
                listTokuchoGokei_6,
                listTokuchoGokei_7,
                listTokuchoGokei_8,
                listTokuchoGokei_9,
                mongon,
                HeichoShaSuKome,
                fuchoShaSuKome,
                fuchoTogetsuGakuKome,
                fuchoTogetsuSuKome,
                tokuchoTogetsuGakuKome,
                tokuchoTogetsuSuKome,
                tokuchoshaShaSuKome);
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
        RString HeichoShaSuKome = 星を追加する(RString.EMPTY);
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
                fuchoShaSuKome = 星を追加する(RString.EMPTY);
                fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
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
                tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
                tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
                tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (null != 年度データ.get内併徴者数の合計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(年度データ.get内併徴者数の合計());
            }
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                listDankaiBetsuGokei_1,
                listDankaiBetsuGokei_2,
                listDankaiBetsuGokei_3,
                listDankaiBetsuGokei_4,
                listFuchoGokei_1,
                listFuchoGokei_2,
                listFuchoGokei_3,
                listFuchoGokei_4,
                listFuchoGokei_5,
                listFuchoGokei_6,
                listFuchoGokei_7,
                listFuchoGokei_8,
                listFuchoGokei_9,
                listTokuchoGokei_1,
                listTokuchoGokei_2,
                listTokuchoGokei_3,
                listTokuchoGokei_4,
                listTokuchoGokei_5,
                listTokuchoGokei_6,
                listTokuchoGokei_7,
                listTokuchoGokei_8,
                listTokuchoGokei_9,
                mongon,
                HeichoShaSuKome,
                fuchoShaSuKome,
                fuchoTogetsuGakuKome,
                fuchoTogetsuSuKome,
                tokuchoTogetsuGakuKome,
                tokuchoTogetsuSuKome,
                tokuchoshaShaSuKome);
        return dankaiGokeiItem;
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemListBy合計(List<GokeiDataEntity> 合計データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        List<Integer> 段階List = get段階List();
        for (Integer i : 段階List) {
            dankaiItemList.add(makeChoteiboDankaiItemBy合計(i, 合計データリスト));
        }
        return dankaiItemList;
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemList(List<NendoDataEntity> 年度データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        List<Integer> 段階List = get段階List();
        for (Integer i : 段階List) {
            dankaiItemList.add(makeChoteiboDankaiItem(i, 年度データリスト));
        }
        return dankaiItemList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItemBy合計(int 段階, List<GokeiDataEntity> 合計データリスト) {
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

        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (段階 == 段階小計.getDogetsuFlag()) {
                        listFuchoDankaiBetsu_1 = to表記(段階);
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
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (段階 == 段階小計.getDogetsuFlag()) {
                        listDankaiBetsu_1 = to表記(段階);
                        listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                        listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                        listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                        listTokuchoDankaiBetsu_1 = to表記(段階);
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
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                listDankaiBetsu_1,
                listDankaiBetsu_2,
                listDankaiBetsu_3,
                listDankaiBetsu_4,
                listFuchoDankaiBetsu_1,
                listFuchoDankaiBetsu_2,
                listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4,
                listFuchoDankaiBetsu_5,
                listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7,
                listFuchoDankaiBetsu_8,
                listFuchoDankaiBetsu_9,
                listTokuchoDankaiBetsu_1,
                listTokuchoDankaiBetsu_2,
                listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4,
                listTokuchoDankaiBetsu_5,
                listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7,
                listTokuchoDankaiBetsu_8,
                listTokuchoDankaiBetsu_9);
        return dankaiItem;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItem(int 段階, List<NendoDataEntity> 年度データリスト) {
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

        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (段階 == 段階小計.getDogetsuFlag()) {
                        listFuchoDankaiBetsu_1 = to表記(段階);
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
                }
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (段階 == 段階小計.getDogetsuFlag()) {
                        listDankaiBetsu_1 = to表記(段階);
                        listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                        listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                        listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                        listTokuchoDankaiBetsu_1 = to表記(段階);
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
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                listDankaiBetsu_1,
                listDankaiBetsu_2,
                listDankaiBetsu_3,
                listDankaiBetsu_4,
                listFuchoDankaiBetsu_1,
                listFuchoDankaiBetsu_2,
                listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4,
                listFuchoDankaiBetsu_5,
                listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7,
                listFuchoDankaiBetsu_8,
                listFuchoDankaiBetsu_9,
                listTokuchoDankaiBetsu_1,
                listTokuchoDankaiBetsu_2,
                listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4,
                listTokuchoDankaiBetsu_5,
                listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7,
                listTokuchoDankaiBetsu_8,
                listTokuchoDankaiBetsu_9);
        return dankaiItem;
    }

    private List<Integer> get段階List() {
        List<Integer> 段階List = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            段階List.add(i + 1);
        }
        return 段階List;
    }

    private RString to表記(int 段階) {
        RStringBuilder builder = new RStringBuilder();
        builder.append("段階");
        builder.append(段階);
        return builder.toRString();
    }

    private RString 星を追加する(RString str) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(str == null ? RString.EMPTY : str);
        if (is星を追加するか()) {
            builder.append(HOSHI);
        }
        return builder.toRString();
    }

    private RString make期(int 期) {
        RStringBuilder builder = new RStringBuilder();
        builder.append("第");
        builder.append(期);
        builder.append("期");
        return builder.toRString();
    }

    private RString make月(Tsuki 月) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(月.getコード());
        builder.append("月");
        return builder.toRString();
    }

    // TODO 「処理詳細」の2.3で取得した徴収方法が「1（特別徴収）」の段階を設定する
    private List<RString> get表記List() {
        List<RString> 表記List = new ArrayList<>(20);
        for (int i = 1; i < 21; i++) {
            表記List.add(new RString(String.valueOf(i)));
        }
        return 表記List;
    }

    // TODO
    private Tsuki get期の月(int 期) {
        switch (期) {
            case 1:
                return Tsuki._1月;
            case 2:
                return Tsuki._2月;
            case 3:
                return Tsuki._3月;
            case 4:
                return Tsuki._4月;
            case 5:
                return Tsuki._5月;
            case 6:
                return Tsuki._6月;
            case 7:
                return Tsuki._7月;
            case 8:
                return Tsuki._8月;
            case 9:
                return Tsuki._9月;
            case 10:
                return Tsuki._10月;
            case 11:
                return Tsuki._11月;
            case 12:
                return Tsuki._12月;
            case 13:
                return Tsuki.翌年度4月;
            case 14:
                return Tsuki.翌年度5月;
            default:
                throw new IllegalArgumentException();
        }
    }

    private RString changeDecimalToRString(Decimal val) {
        return null == val ? RString.EMPTY : new RString(String.valueOf(val.intValue()));
    }
}
