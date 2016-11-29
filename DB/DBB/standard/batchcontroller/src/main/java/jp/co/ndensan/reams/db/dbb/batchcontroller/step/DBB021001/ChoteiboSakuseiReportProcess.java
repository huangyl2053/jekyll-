/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiFuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiGokeiFuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiGokeiItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiGokeiTokuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboDankaiTokuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboHeaderItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboKitsukiFuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboKitsukiItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboKitsukiTokuchoItem;
import jp.co.ndensan.reams.db.dbb.business.report.choteibo.ChoteiboReport;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo.ChoteiboShoriHizukeMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.NendoDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choteibo.IChoteiboSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 調定簿作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
public class ChoteiboSakuseiReportProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final int 当月フラグ = 1;
    private static final int 前月フラグ = 0;
    private static final RString SHORINENDO_NAME = new RString("【処理年度】");
    private static final RString STARTCHOTEINICHIJI_NAME = new RString("【開始調定日時】");
    private static final RString ENDCHOTEINICHIJI_NAME = new RString("【終了調定日時】");
    private static final RString BREAKKEY_NENDOTITLE = new RString("nendoTitle");
    private static final RString KEY_CHOTEINENDO = new RString("choteiNendo");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final RString HOSHI = new RString("※");
    private static final RString GOKEI = new RString("合計");
    private static final RString TONENDO = new RString("当年度");
    private static final RString ZENNENDO = new RString("前年度");
    private static final RString ZENZENNENDO = new RString("前々年度");
    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");
    private static final RString 文字列_期 = new RString("期");
    private static final RString 文字列_翌年度 = new RString("翌年度");
    private static final RString 文字列_随 = new RString("随");
    private static final int 第1期 = 1;
    private static final int 第2期 = 2;
    private static final int 第3期 = 3;
    private static final int 第4期 = 4;
    private static final int 第5期 = 5;
    private static final int 第6期 = 6;
    private static final int 第7期 = 7;
    private static final int 第8期 = 8;
    private static final int 第9期 = 9;
    private static final int 第10期 = 10;
    private static final int 第11期 = 11;
    private static final int 第12期 = 12;
    private static final int 第13期 = 13;
    private static final int 第14期 = 14;
    private static final int NENDO_SUBSTR_START = 2;
    private static final RString STRING_SAKUSEI = new RString("作成");
    private static final RString UNDERLINE = new RString("_");
    private static final RString MIDDLELINE = new RString("-");
    private static final RString なし = new RString("なし");
    private static final RString 本算定 = new RString("0");
    private static final RString FORMAT = new RString("%03d");
    private final RString 固定文字 = new RString("該当データがありません");
    private static final RString SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choteibo.IChoteiboSakuseiMapper.select処理日付");
    private IChoteiboSakuseiMapper choteiboSakuseiMapper;
    private HokenryoDankaiSettings 保険料段階取得Mgr;
    private List<NendoDataEntity> 当年度データリスト;
    private List<NendoDataEntity> 前年度データリスト;
    private List<NendoDataEntity> 前々年度データリスト;
    private List<GokeiDataEntity> 合計データリスト;
    private List<DbT7022ShoriDateKanriEntity> 処理日付リスト;
    private RString 導入団体コード;
    private RString 市町村名;
    private List<ChoteiboItem> targets;
    private KitsukiList 期月リスト_普徴;
    private Kitsuki 最終法定納期;
    private KitsukiList 期月リスト_過年度;
    @BatchWriter
    private BatchReportWriter<ChoteiboSource> batchReportWriter;
    private ReportSourceWriter<ChoteiboSource> reportSourceWriter;
    private ChoteiboProcessParameter parameter;

    @Override
    protected void initialize() {
        保険料段階取得Mgr = new HokenryoDankaiSettings();
        targets = new ArrayList<>();
        当年度データリスト = new ArrayList<>();
        前年度データリスト = new ArrayList<>();
        前々年度データリスト = new ArrayList<>();
        合計データリスト = new ArrayList<>();
        処理日付リスト = new ArrayList<>();
        choteiboSakuseiMapper = getMapper(IChoteiboSakuseiMapper.class);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
        帳票用Entityリストを作成する();
    }

    @Override
    protected IBatchReader createReader() {
        ChoteiboShoriHizukeMyBatisParameter myBatisparameter = new ChoteiboShoriHizukeMyBatisParameter(
                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), parameter.getShoriNendo());
        return new BatchDbReader(SELECT_ID, myBatisparameter);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        if (null != entity && null != entity.getKijunTimestamp() && !entity.getKijunTimestamp().isEmpty()
                && !parameter.getChushutsuEdYMD().isBefore(entity.getKijunTimestamp())) {
            処理日付リスト.add(entity);
        }
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB3001.getReportId().value())
                .addBreak(new BreakerCatalog<ChoteiboSource>().simplePageBreaker(BREAKKEY_NENDOTITLE))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void afterExecute() {
        make帳票出力リスト();
        作成したdataを帳票に引き渡す();
        バッチ出力条件リストの出力();
    }

    private void 帳票用Entityリストを作成する() {
        当年度データリスト.addAll(get年度データリスト(parameter.getShoriNendo(),
                parameter.getShoriNendo()));
        前年度データリスト.addAll(get年度データリスト(parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1)));
        前々年度データリスト.addAll(get年度データリスト(parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(2)));
        合計データリスト.addAll(get合計データリスト());
    }

    private void 作成したdataを帳票に引き渡す() {
        ChoteiboReport report = ChoteiboReport.createForm(targets);
        report.writeBy(reportSourceWriter);
    }

    private void make帳票出力リスト() {
        RString 年度 = parameter.getShoriNendo().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).toDateString();
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        ChoteiboHeaderItem headerItem = new ChoteiboHeaderItem(
                builder.append(RString.HALF_SPACE).append(STRING_SAKUSEI).toRString(),
                年度, 年度.substring(NENDO_SUBSTR_START),
                導入団体コード, 市町村名);
        makeChoteiboItemList(headerItem);
    }

    private void init期月リスト(FlexibleYear 年度) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(年度);
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        最終法定納期 = 期月リスト_普徴.get最終法定納期();
        期月リスト_過年度 = new KanendoKiUtil(年度).get期月リスト();
    }

    private void makeChoteiboItemList(ChoteiboHeaderItem headerItem) {
        init期月リスト(parameter.getShoriNendo());
        targets.add(makeChoteiboItem(TONENDO, 当年度データリスト, headerItem));
        init期月リスト(parameter.getShoriNendo().minusYear(1));
        targets.add(makeChoteiboItem(ZENNENDO, 前年度データリスト, headerItem));
        init期月リスト(parameter.getShoriNendo().minusYear(2));
        targets.add(makeChoteiboItem(ZENZENNENDO, 前々年度データリスト, headerItem));
        targets.add(makeChoteiboItemBy合計(合計データリスト, headerItem));
    }

    private ChoteiboItem makeChoteiboItemBy合計(
            List<GokeiDataEntity> 合計データリスト,
            ChoteiboHeaderItem headerItem) {
        ChoteiboKitsukiItem kitsukiItem = makeChoteiboKitsukiItemBy合計(合計データリスト);
        ChoteiboDankaiGokeiItem dankaiGokeiItem = makeChoteiboDankaiGokeiItemBy合計(合計データリスト);
        List<ChoteiboDankaiItem> dankaiItemList = makeChoteiboDankaiItemListBy合計(合計データリスト);
        return ChoteiboItem.createChoteiboItem(headerItem, kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }

    private ChoteiboItem makeChoteiboItem(
            RString 年度タイトル,
            List<NendoDataEntity> 年度データリスト,
            ChoteiboHeaderItem headerItem) {
        ChoteiboKitsukiItem kitsukiItem = makeChoteiboKitsukiItem(年度データリスト, 年度タイトル);
        ChoteiboDankaiGokeiItem dankaiGokeiItem = makeChoteiboDankaiGokeiItem(年度データリスト);
        List<ChoteiboDankaiItem> dankaiItemList = makeChoteiboDankaiItemList(年度データリスト);
        return ChoteiboItem.createChoteiboItem(headerItem, kitsukiItem, dankaiItemList, dankaiGokeiItem);
    }

    private ChoteiboKitsukiItem makeChoteiboKitsukiItemBy合計(List<GokeiDataEntity> 合計データリスト) {
        ChoteiboKitsukiTokuchoItem kitsukiTokuchoItem = null;
        ChoteiboKitsukiFuchoItem kitsukiFuchoItem = null;
        RString genmenGaku = RString.EMPTY;
        RString genmenSu = RString.EMPTY;
        RString nofuGakuSokei = RString.EMPTY;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(合計データ.get徴収方法())) {
                kitsukiFuchoItem = makeKitsukiFuchoItem(合計データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(合計データ.get徴収方法())) {
                kitsukiTokuchoItem = makeKitsukiTokuchoItem(合計データ);
            }
            genmenGaku = changeDecimalToRString(合計データ.get減免の調定額の総計());
            genmenSu = changeDecimalToRString(合計データ.get減免の件数の総計());
            if (null != 合計データ.get特徴と普徴の総計()) {
                nofuGakuSokei = changeDecimalToRString(合計データ.get特徴と普徴の総計());
            }
        }
        return new ChoteiboKitsukiItem(kitsukiTokuchoItem, kitsukiFuchoItem, genmenGaku, genmenSu, nofuGakuSokei, GOKEI);
    }

    private ChoteiboKitsukiFuchoItem makeKitsukiFuchoItem(GokeiDataEntity 合計データ) {
        if (null == 合計データ) {
            return new ChoteiboKitsukiFuchoItem(
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._5月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._7月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._9月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._11月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._1月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._3月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki.翌年度4月.get名称().replace(文字列_翌年度, RString.EMPTY),
                    Tsuki.翌年度5月.get名称().replace(文字列_翌年度, RString.EMPTY),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        return new ChoteiboKitsukiFuchoItem(
                changeDecimalToRString(合計データ.get普通徴収の調定額の総計()),
                changeDecimalToRString(合計データ.get普徴歳出還付の調定額の総計()),
                changeDecimalToRString(合計データ.get普徴歳出還付の件数の総計()),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                changeDecimalToRString(合計データ.get当_4月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_5月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_6月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_7月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_8月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_9月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_10月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_11月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_12月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_1月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_2月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_3月の調定額の小計()),
                changeDecimalToRString(合計データ.get翌_4月の調定額の小計()),
                changeDecimalToRString(合計データ.get翌_5月の調定額の小計()),
                Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._5月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._7月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._9月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._11月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._1月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._3月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki.翌年度4月.get名称().replace(文字列_翌年度, RString.EMPTY),
                Tsuki.翌年度5月.get名称().replace(文字列_翌年度, RString.EMPTY),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private ChoteiboKitsukiTokuchoItem makeKitsukiTokuchoItem(GokeiDataEntity 合計データ) {
        if (null == 合計データ) {
            return new ChoteiboKitsukiTokuchoItem(
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY));
        }
        return new ChoteiboKitsukiTokuchoItem(
                changeDecimalToRString(合計データ.get特別徴収の調定額の総計()),
                changeDecimalToRString(合計データ.get特徴歳出還付の調定額の総計()),
                changeDecimalToRString(合計データ.get特徴歳出還付の件数の総計()),
                RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY,
                changeDecimalToRString(合計データ.get当_4月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_6月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_8月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_10月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_12月の調定額の小計()),
                changeDecimalToRString(合計データ.get当_2月の調定額の小計()),
                Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY));
    }

    private ChoteiboDankaiGokeiItem makeChoteiboDankaiGokeiItemBy合計(List<GokeiDataEntity> 合計データリスト) {
        RString listDankaiBetsuGokei_2 = RString.EMPTY;
        RString listDankaiBetsuGokei_3 = RString.EMPTY;
        RString listDankaiBetsuGokei_4 = RString.EMPTY;
        RString mongon = RString.EMPTY;
        RString heichoShaSuKome = RString.EMPTY;
        RString fuchoShaSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem = null;
        ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem = null;
        Decimal 内併徴者数の件数合計 = Decimal.ZERO;
        Decimal 普徴者数の合計 = Decimal.ZERO;
        Decimal 特徴者数の合計 = Decimal.ZERO;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(合計データ.get徴収方法())) {
                dankaiGokeiFuchoItem = makeChoteiboDankaiGokeiFuchoItem(合計データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(合計データ.get徴収方法())) {
                dankaiGokeiTokuchoItem = makeChoteiboDankaiGokeiTokuchoItem(合計データ);
            }
            listDankaiBetsuGokei_2 = listDankaiBetsuGokei_2.isEmpty()
                    ? changeDecimalToRString(合計データ.get特徴者数の総計()) : listDankaiBetsuGokei_2;
            listDankaiBetsuGokei_3 = listDankaiBetsuGokei_3.isEmpty()
                    ? changeDecimalToRString(合計データ.get普徴者数の総計()) : listDankaiBetsuGokei_3;
            if (null != 合計データ.get内併徴者数の総計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(合計データ.get内併徴者数の総計());
            }
            for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
                内併徴者数の件数合計 = 内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
                普徴者数の合計 = 普徴者数の合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                特徴者数の合計 = 特徴者数の合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
            }
        }
        if (!changeDecimalToRString(内併徴者数の件数合計).equals(listDankaiBetsuGokei_4)) {
            heichoShaSuKome = 星を追加する(RString.EMPTY);
        }
        if (!changeDecimalToRString(普徴者数の合計).equals(listDankaiBetsuGokei_3)) {
            fuchoShaSuKome = 星を追加する(RString.EMPTY);
        }
        if (!changeDecimalToRString(特徴者数の合計).equals(listDankaiBetsuGokei_2)) {
            tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
        }
        return new ChoteiboDankaiGokeiItem(
                GOKEI, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                mongon, heichoShaSuKome, fuchoShaSuKome, tokuchoshaShaSuKome,
                dankaiGokeiFuchoItem, dankaiGokeiTokuchoItem);
    }

    private ChoteiboDankaiGokeiFuchoItem makeChoteiboDankaiGokeiFuchoItem(GokeiDataEntity 合計データ) {
        if (null == 合計データ) {
            return new ChoteiboDankaiGokeiFuchoItem(
                    GOKEI, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString fuchoTogetsuGakuKome = RString.EMPTY;
        RString fuchoTogetsuSuKome = RString.EMPTY;
        Decimal 当月末の件数合計 = Decimal.ZERO;
        Decimal 当月末の調定額合計 = Decimal.ZERO;
        for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
            当月末の件数合計 = 当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計 = 当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!当月末の件数合計.equals(合計データ.get当月末の全部件数の総計())) {
            fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!当月末の調定額合計.equals(合計データ.get当月末の全部調定額の総計())) {
            fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
        }
        return new ChoteiboDankaiGokeiFuchoItem(
                GOKEI,
                changeDecimalToRString(合計データ.get前月末の全部件数の総計()),
                changeDecimalToRString(合計データ.get前月末の全部調定額の総計()),
                changeDecimalToRString(合計データ.get増の全部件数の総計()),
                changeDecimalToRString(合計データ.get増の全部調定額の総計()),
                changeDecimalToRString(合計データ.get減の全部件数の総計()),
                changeDecimalToRString(合計データ.get減の全部調定額の総計()),
                changeDecimalToRString(合計データ.get当月末の全部件数の総計()),
                changeDecimalToRString(合計データ.get当月末の全部調定額の総計()),
                fuchoTogetsuGakuKome, fuchoTogetsuSuKome);
    }

    private ChoteiboDankaiGokeiTokuchoItem makeChoteiboDankaiGokeiTokuchoItem(GokeiDataEntity 合計データ) {
        if (null == 合計データ) {
            return new ChoteiboDankaiGokeiTokuchoItem(
                    GOKEI, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString tokuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoTogetsuGakuKome = RString.EMPTY;
        Decimal 当月末の件数合計 = Decimal.ZERO;
        Decimal 当月末の調定額合計 = Decimal.ZERO;
        for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
            当月末の件数合計 = 当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計 = 当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!当月末の件数合計.equals(合計データ.get当月末の全部件数の総計())) {
            tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!当月末の調定額合計.equals(合計データ.get当月末の全部調定額の総計())) {
            tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
        }
        return new ChoteiboDankaiGokeiTokuchoItem(
                GOKEI,
                changeDecimalToRString(合計データ.get前月末の全部件数の総計()),
                changeDecimalToRString(合計データ.get前月末の全部調定額の総計()),
                changeDecimalToRString(合計データ.get増の全部件数の総計()),
                changeDecimalToRString(合計データ.get増の全部調定額の総計()),
                changeDecimalToRString(合計データ.get減の全部件数の総計()),
                changeDecimalToRString(合計データ.get減の全部調定額の総計()),
                changeDecimalToRString(合計データ.get当月末の全部件数の総計()),
                changeDecimalToRString(合計データ.get当月末の全部調定額の総計()),
                tokuchoTogetsuSuKome, tokuchoTogetsuGakuKome);
    }

    private ChoteiboKitsukiItem makeChoteiboKitsukiItem(List<NendoDataEntity> 年度データリスト, RString 年度タイトル) {
        RString genmenGaku = RString.EMPTY;
        RString genmenSu = RString.EMPTY;
        RString nofuGakuSokei = RString.EMPTY;
        ChoteiboKitsukiTokuchoItem kitsukiTokuchoItem = null;
        ChoteiboKitsukiFuchoItem kitsukiFuchoItem = null;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(年度データ.get徴収方法())) {
                kitsukiFuchoItem = makeChoteiboKitsukiFuchoItem(年度データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(年度データ.get徴収方法())) {
                kitsukiTokuchoItem = makeKitsukiTokuchoItem(年度データ);
            }
            genmenGaku = changeDecimalToRString(年度データ.get減免の調定額());
            genmenSu = changeDecimalToRString(年度データ.get減免の件数());
            nofuGakuSokei = changeDecimalToRString(年度データ.get特徴と普徴の合計());
        }
        return new ChoteiboKitsukiItem(kitsukiTokuchoItem, kitsukiFuchoItem,
                genmenGaku, genmenSu, nofuGakuSokei, 年度タイトル);
    }

    private ChoteiboKitsukiTokuchoItem makeKitsukiTokuchoItem(NendoDataEntity 年度データ) {
        if (null == 年度データ) {
            return new ChoteiboKitsukiTokuchoItem(
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    文字列_第.concat(String.valueOf(第1期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第2期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第3期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第4期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第5期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第6期)).concat(文字列_期),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                    Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY));
        }
        return new ChoteiboKitsukiTokuchoItem(
                changeDecimalToRString(年度データ.get特別徴収の調定額の合計()),
                changeDecimalToRString(年度データ.get特徴歳出還付の調定額()),
                changeDecimalToRString(年度データ.get特徴歳出還付の件数()),
                文字列_第.concat(String.valueOf(第1期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第2期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第3期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第4期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第5期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第6期)).concat(文字列_期),
                changeDecimalToRString(年度データ.get第1期の調定額の小計()),
                changeDecimalToRString(年度データ.get第2期の調定額の小計()),
                changeDecimalToRString(年度データ.get第3期の調定額の小計()),
                changeDecimalToRString(年度データ.get第4期の調定額の小計()),
                changeDecimalToRString(年度データ.get第5期の調定額の小計()),
                changeDecimalToRString(年度データ.get第6期の調定額の小計()),
                Tsuki._4月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._6月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._8月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._10月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._12月.get名称().replace(UNDERLINE, RString.EMPTY),
                Tsuki._2月.get名称().replace(UNDERLINE, RString.EMPTY));
    }

    private ChoteiboKitsukiFuchoItem makeChoteiboKitsukiFuchoItem(NendoDataEntity 年度データ) {
        if (null == 年度データ) {
            return new ChoteiboKitsukiFuchoItem(
                    RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    get月As期By期月リスト(第1期, 期月リスト_普徴), get月As期By期月リスト(第2期, 期月リスト_普徴),
                    get月As期By期月リスト(第3期, 期月リスト_普徴), get月As期By期月リスト(第4期, 期月リスト_普徴),
                    get月As期By期月リスト(第5期, 期月リスト_普徴), get月As期By期月リスト(第6期, 期月リスト_普徴),
                    get月As期By期月リスト(第7期, 期月リスト_普徴), get月As期By期月リスト(第8期, 期月リスト_普徴),
                    get月As期By期月リスト(第9期, 期月リスト_普徴), get月As期By期月リスト(第10期, 期月リスト_普徴),
                    get月As期By期月リスト(第11期, 期月リスト_普徴), get月As期By期月リスト(第12期, 期月リスト_普徴),
                    get月As期By期月リスト(第13期, 期月リスト_普徴), get月As期By期月リスト(第14期, 期月リスト_普徴),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

        if (年度データ.get調定年度().equals(年度データ.get賦課年度())) {
            return new ChoteiboKitsukiFuchoItem(
                    changeDecimalToRString(年度データ.get普通徴収の調定額の合計()),
                    changeDecimalToRString(年度データ.get普徴歳出還付の調定額()),
                    changeDecimalToRString(年度データ.get普徴歳出還付の件数()),
                    文字列_第.concat(String.valueOf(第1期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第2期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第3期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第4期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第5期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第6期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第7期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第8期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第9期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第10期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第11期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第12期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第13期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第14期)).concat(文字列_期),
                    changeDecimalToRString(年度データ.get第1期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第2期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第3期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第4期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第5期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第6期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第7期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第8期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第9期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第10期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第11期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第12期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第13期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第14期の調定額の小計()),
                    get月As期By期月リスト(第1期, 期月リスト_普徴), get月As期By期月リスト(第2期, 期月リスト_普徴),
                    get月As期By期月リスト(第3期, 期月リスト_普徴), get月As期By期月リスト(第4期, 期月リスト_普徴),
                    get月As期By期月リスト(第5期, 期月リスト_普徴), get月As期By期月リスト(第6期, 期月リスト_普徴),
                    get月As期By期月リスト(第7期, 期月リスト_普徴), get月As期By期月リスト(第8期, 期月リスト_普徴),
                    get月As期By期月リスト(第9期, 期月リスト_普徴), get月As期By期月リスト(第10期, 期月リスト_普徴),
                    get月As期By期月リスト(第11期, 期月リスト_普徴), get月As期By期月リスト(第12期, 期月リスト_普徴),
                    get月As期By期月リスト(第13期, 期月リスト_普徴), get月As期By期月リスト(第14期, 期月リスト_普徴),
                    随時期月判断(第1期, 年度データ.get賦課年度()), 随時期月判断(第2期, 年度データ.get賦課年度()),
                    随時期月判断(第3期, 年度データ.get賦課年度()), 随時期月判断(第4期, 年度データ.get賦課年度()),
                    随時期月判断(第5期, 年度データ.get賦課年度()), 随時期月判断(第6期, 年度データ.get賦課年度()),
                    随時期月判断(第7期, 年度データ.get賦課年度()), 随時期月判断(第8期, 年度データ.get賦課年度()),
                    随時期月判断(第9期, 年度データ.get賦課年度()), 随時期月判断(第10期, 年度データ.get賦課年度()),
                    随時期月判断(第11期, 年度データ.get賦課年度()), 随時期月判断(第12期, 年度データ.get賦課年度()),
                    随時期月判断(第13期, 年度データ.get賦課年度()), 随時期月判断(第14期, 年度データ.get賦課年度()));
        } else {
            return new ChoteiboKitsukiFuchoItem(
                    changeDecimalToRString(年度データ.get普通徴収の調定額の合計()),
                    changeDecimalToRString(年度データ.get普徴歳出還付の調定額()),
                    changeDecimalToRString(年度データ.get普徴歳出還付の件数()),
                    文字列_第.concat(String.valueOf(第1期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第2期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第3期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第4期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第5期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第6期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第7期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第8期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第9期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第10期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第11期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第12期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第13期)).concat(文字列_期),
                    文字列_第.concat(String.valueOf(第14期)).concat(文字列_期),
                    changeDecimalToRString(年度データ.get第1期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第2期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第3期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第4期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第5期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第6期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第7期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第8期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第9期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第10期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第11期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第12期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第13期の調定額の小計()),
                    changeDecimalToRString(年度データ.get第14期の調定額の小計()),
                    get月As期By期月リスト(第1期, 期月リスト_過年度), get月As期By期月リスト(第2期, 期月リスト_過年度),
                    get月As期By期月リスト(第3期, 期月リスト_過年度), get月As期By期月リスト(第4期, 期月リスト_過年度),
                    get月As期By期月リスト(第5期, 期月リスト_過年度), get月As期By期月リスト(第6期, 期月リスト_過年度),
                    get月As期By期月リスト(第7期, 期月リスト_過年度), get月As期By期月リスト(第8期, 期月リスト_過年度),
                    get月As期By期月リスト(第9期, 期月リスト_過年度), get月As期By期月リスト(第10期, 期月リスト_過年度),
                    get月As期By期月リスト(第11期, 期月リスト_過年度), get月As期By期月リスト(第12期, 期月リスト_過年度),
                    get月As期By期月リスト(第13期, 期月リスト_過年度), get月As期By期月リスト(第14期, 期月リスト_過年度),
                    随時期月判断(第1期, 年度データ.get賦課年度()), 随時期月判断(第2期, 年度データ.get賦課年度()),
                    随時期月判断(第3期, 年度データ.get賦課年度()), 随時期月判断(第4期, 年度データ.get賦課年度()),
                    随時期月判断(第5期, 年度データ.get賦課年度()), 随時期月判断(第6期, 年度データ.get賦課年度()),
                    随時期月判断(第7期, 年度データ.get賦課年度()), 随時期月判断(第8期, 年度データ.get賦課年度()),
                    随時期月判断(第9期, 年度データ.get賦課年度()), 随時期月判断(第10期, 年度データ.get賦課年度()),
                    随時期月判断(第11期, 年度データ.get賦課年度()), 随時期月判断(第12期, 年度データ.get賦課年度()),
                    随時期月判断(第13期, 年度データ.get賦課年度()), 随時期月判断(第14期, 年度データ.get賦課年度()));
        }
    }

    private RString get月As期By期月リスト(int 期, KitsukiList 期月リスト) {
        if (null == 期月リスト.get期の月(期) || 期月リスト.get期の月(期).isEmpty()) {
            return RString.EMPTY;
        }
        return 期月リスト.get期の月(期).get(0).get月().get名称().
                replace(UNDERLINE, RString.EMPTY).
                replace(文字列_翌年度, RString.EMPTY);
    }

    private RString 随時期月判断(int 期, FlexibleYear 年度) {
        if (null == 年度 || !年度.equals(parameter.getShoriNendo())) {
            return RString.EMPTY;
        }
        for (Kitsuki kitsuki : 期月リスト_普徴.get期の月(期)) {
            if (!Tsuki.翌年度4月.equals(kitsuki.get月())
                    && !Tsuki.翌年度5月.equals(kitsuki.get月())) {
                continue;
            }
            if (kitsuki.get月().getコード().compareTo(最終法定納期.get月().getコード()) > 0) {
                return 文字列_随;
            }
        }
        return RString.EMPTY;
    }

    private ChoteiboDankaiGokeiItem makeChoteiboDankaiGokeiItem(List<NendoDataEntity> 年度データリスト) {
        RString listDankaiBetsuGokei_2 = RString.EMPTY;
        RString listDankaiBetsuGokei_3 = RString.EMPTY;
        RString listDankaiBetsuGokei_4 = RString.EMPTY;
        RString mongon = RString.EMPTY;
        RString heichoShaSuKome = RString.EMPTY;
        RString fuchoShaSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem = null;
        ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem = null;
        Decimal 内併徴者数の件数合計 = Decimal.ZERO;
        Decimal 普徴者数の合計 = Decimal.ZERO;
        Decimal 特徴者数の合計 = Decimal.ZERO;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(年度データ.get徴収方法())) {
                dankaiGokeiFuchoItem = makeChoteiboDankaiGokeiFuchoItem(年度データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(年度データ.get徴収方法())) {
                dankaiGokeiTokuchoItem = makeChoteiboDankaiGokeiTokuchoItem(年度データ);
            }
            listDankaiBetsuGokei_2 = listDankaiBetsuGokei_2.isEmpty()
                    ? changeDecimalToRString(年度データ.get特徴者数の合計()) : listDankaiBetsuGokei_2;
            listDankaiBetsuGokei_3 = listDankaiBetsuGokei_3.isEmpty()
                    ? changeDecimalToRString(年度データ.get普徴者数の合計()) : listDankaiBetsuGokei_3;
            if (null != 年度データ.get内併徴者数の合計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(年度データ.get内併徴者数の合計());
            }
            for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
                内併徴者数の件数合計 = 内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
                普徴者数の合計 = 普徴者数の合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                特徴者数の合計 = 特徴者数の合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
            }
        }
        if (!changeDecimalToRString(内併徴者数の件数合計).equals(listDankaiBetsuGokei_4)) {
            heichoShaSuKome = 星を追加する(RString.EMPTY);
        }
        if (!changeDecimalToRString(普徴者数の合計).equals(listDankaiBetsuGokei_3)) {
            fuchoShaSuKome = 星を追加する(RString.EMPTY);
        }
        if (!changeDecimalToRString(特徴者数の合計).equals(listDankaiBetsuGokei_2)) {
            tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                GOKEI, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                mongon, heichoShaSuKome, fuchoShaSuKome, tokuchoshaShaSuKome,
                dankaiGokeiFuchoItem, dankaiGokeiTokuchoItem);
        return dankaiGokeiItem;
    }

    private ChoteiboDankaiGokeiFuchoItem makeChoteiboDankaiGokeiFuchoItem(NendoDataEntity 年度データ) {
        if (null == 年度データ) {
            return new ChoteiboDankaiGokeiFuchoItem(
                    GOKEI, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString fuchoTogetsuGakuKome = RString.EMPTY;
        RString fuchoTogetsuSuKome = RString.EMPTY;
        Decimal 当月末の件数合計 = Decimal.ZERO;
        Decimal 当月末の調定額合計 = Decimal.ZERO;
        for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
            当月末の件数合計 = 当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計 = 当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!当月末の件数合計.equals(年度データ.get当月末の全部件数の合計())) {
            fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!当月末の調定額合計.equals(年度データ.get当月末の全部調定額の合計())) {
            fuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
        }
        return new ChoteiboDankaiGokeiFuchoItem(
                GOKEI,
                changeDecimalToRString(年度データ.get前月末の全部件数の合計()),
                changeDecimalToRString(年度データ.get前月末の全部調定額の合計()),
                changeDecimalToRString(年度データ.get増の全部件数の合計()),
                changeDecimalToRString(年度データ.get増の全部調定額の合計()),
                changeDecimalToRString(年度データ.get減の全部件数の合計()),
                changeDecimalToRString(年度データ.get減の全部調定額の合計()),
                changeDecimalToRString(年度データ.get当月末の全部件数の合計()),
                changeDecimalToRString(年度データ.get当月末の全部調定額の合計()),
                fuchoTogetsuGakuKome, fuchoTogetsuSuKome);
    }

    private ChoteiboDankaiGokeiTokuchoItem makeChoteiboDankaiGokeiTokuchoItem(NendoDataEntity 年度データ) {
        if (null == 年度データ) {
            return new ChoteiboDankaiGokeiTokuchoItem(
                    GOKEI, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString tokuchoTogetsuSuKome = RString.EMPTY;
        RString tokuchoTogetsuGakuKome = RString.EMPTY;
        Decimal 当月末の件数合計 = Decimal.ZERO;
        Decimal 当月末の調定額合計 = Decimal.ZERO;
        for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
            当月末の件数合計 = 当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計 = 当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!当月末の件数合計.equals(年度データ.get当月末の全部件数の合計())) {
            tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!当月末の調定額合計.equals(年度データ.get当月末の全部調定額の合計())) {
            tokuchoTogetsuGakuKome = 星を追加する(RString.EMPTY);
        }
        return new ChoteiboDankaiGokeiTokuchoItem(
                GOKEI,
                changeDecimalToRString(年度データ.get前月末の全部件数の合計()),
                changeDecimalToRString(年度データ.get前月末の全部調定額の合計()),
                changeDecimalToRString(年度データ.get増の全部件数の合計()),
                changeDecimalToRString(年度データ.get増の全部調定額の合計()),
                changeDecimalToRString(年度データ.get減の全部件数の合計()),
                changeDecimalToRString(年度データ.get減の全部調定額の合計()),
                changeDecimalToRString(年度データ.get当月末の全部件数の合計()),
                changeDecimalToRString(年度データ.get当月末の全部調定額の合計()),
                tokuchoTogetsuSuKome, tokuchoTogetsuGakuKome);
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemListBy合計(List<GokeiDataEntity> 合計データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        HokenryoDankaiList 保険料段階List = get保険料段階List(parameter.getShoriNendo());
        for (RString 段階表記 : sort表記List(保険料段階List.to表記List())) {
            dankaiItemList.add(makeChoteiboDankaiItemBy合計(段階表記, 合計データリスト));
        }
        return dankaiItemList;
    }

    private List<RString> sort表記List(List<RString> 表記List) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 表記List.size(); i++) {
            stringList.add(String.format(FORMAT.toString(), get段階(表記List.get(i))));
        }
        Collections.sort(stringList);
        List<RString> resultList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            for (int j = 0; j < 表記List.size(); j++) {
                if (get段階(表記List.get(j)) == Integer.parseInt(stringList.get(i))) {
                    resultList.add(表記List.get(j));
                }
            }
        }
        return resultList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItemBy合計(RString 段階表記, List<GokeiDataEntity> 合計データリスト) {
        RString listDankaiBetsu_2 = RString.EMPTY;
        RString listDankaiBetsu_3 = RString.EMPTY;
        RString listDankaiBetsu_4 = RString.EMPTY;
        ChoteiboDankaiFuchoItem dankaiFuchoItem = null;
        ChoteiboDankaiTokuchoItem dankaiTokuchoItem = null;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(合計データ.get徴収方法())) {
                dankaiFuchoItem = makeChoteiboDankaiFuchoItem(段階表記, 合計データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(合計データ.get徴収方法())) {
                dankaiTokuchoItem = makeChoteiboDankaiTokuchoItem(段階表記, 合計データ);
            }
            if (null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
                listDankaiBetsu_2 = RString.EMPTY;
                listDankaiBetsu_3 = RString.EMPTY;
                listDankaiBetsu_4 = RString.EMPTY;
            } else {
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                            || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                        continue;
                    }
                    listDankaiBetsu_2 = listDankaiBetsu_2.isEmpty()
                            ? changeDecimalToRString(段階小計.getTokuchosyaKensu()) : listDankaiBetsu_2;
                    listDankaiBetsu_3 = listDankaiBetsu_3.isEmpty()
                            ? changeDecimalToRString(段階小計.getFuchosyaKensu()) : listDankaiBetsu_3;
                    listDankaiBetsu_4 = listDankaiBetsu_4.isEmpty()
                            ? changeDecimalToRString(段階小計.getNaiheisyaKensu()) : listDankaiBetsu_4;
                }
            }
        }
        return new ChoteiboDankaiItem(
                段階表記, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                dankaiFuchoItem, dankaiTokuchoItem);
    }

    private ChoteiboDankaiFuchoItem makeChoteiboDankaiFuchoItem(RString 段階表記, GokeiDataEntity 合計データ) {
        if (null == 合計データ
                || null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
            return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString listFuchoDankaiBetsu_2 = RString.EMPTY;
        RString listFuchoDankaiBetsu_3 = RString.EMPTY;
        RString listFuchoDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_5 = RString.EMPTY;
        RString listFuchoDankaiBetsu_6 = RString.EMPTY;
        RString listFuchoDankaiBetsu_7 = RString.EMPTY;
        RString listFuchoDankaiBetsu_8 = RString.EMPTY;
        RString listFuchoDankaiBetsu_9 = RString.EMPTY;
        for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
            if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                    || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                continue;
            }
            listFuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
            listFuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
            listFuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
            listFuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
            listFuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
            listFuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
            listFuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
            listFuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
        }
        return new ChoteiboDankaiFuchoItem(段階表記, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9);
    }

    private ChoteiboDankaiTokuchoItem makeChoteiboDankaiTokuchoItem(RString 段階表記, GokeiDataEntity 合計データ) {
        if (null == 合計データ
                || null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
            return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString listTokuchoDankaiBetsu_2 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_3 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_4 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_5 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_6 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_7 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_8 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_9 = RString.EMPTY;
        for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
            if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                    || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                continue;
            }
            listTokuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
            listTokuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
            listTokuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
            listTokuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
            listTokuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
            listTokuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
            listTokuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
            listTokuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
        }
        return new ChoteiboDankaiTokuchoItem(段階表記, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
    }

    private int get段階(RString 段階表記) {
        if (null == 段階表記) {
            return -1;
        }
        段階表記 = 段階表記.substring(0, 段階表記.indexOf(文字列_段階));
        RString 段階 = 段階表記.replace(文字列_第, RString.EMPTY);
        段階 = 段階.replace(文字列_段階, RString.EMPTY).trim();
        return Integer.parseInt(段階.toString().concat("0"));
    }

    private List<ChoteiboDankaiItem> makeChoteiboDankaiItemList(List<NendoDataEntity> 年度データリスト) {
        List<ChoteiboDankaiItem> dankaiItemList = new ArrayList<>();
        HokenryoDankaiList 保険料段階List = get保険料段階List(年度データリスト.get(0).get賦課年度());
        if (保険料段階List.to表記List().isEmpty()) {
            ChoteiboDankaiFuchoItem fuchoItem = new ChoteiboDankaiFuchoItem(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            ChoteiboDankaiTokuchoItem tokuchoItem = new ChoteiboDankaiTokuchoItem(RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, 固定文字, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            ChoteiboDankaiItem item = new ChoteiboDankaiItem(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    fuchoItem, tokuchoItem);
            dankaiItemList.add(item);
            return dankaiItemList;
        }
        for (RString 段階表記 : sort表記List(保険料段階List.to表記List())) {
            dankaiItemList.add(makeChoteiboDankaiItem(段階表記, 年度データリスト));
        }
        return dankaiItemList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItem(RString 段階表記, List<NendoDataEntity> 年度データリスト) {
        RString listDankaiBetsu_2 = RString.EMPTY;
        RString listDankaiBetsu_3 = RString.EMPTY;
        RString listDankaiBetsu_4 = RString.EMPTY;
        ChoteiboDankaiFuchoItem dankaiFuchoItem = null;
        ChoteiboDankaiTokuchoItem sankaiTokuchoItem = null;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(年度データ.get徴収方法())) {
                dankaiFuchoItem = makeChoteiboDankaiFuchoItem(段階表記, 年度データ);
            } else if (ChoshuHohoKibetsu.特別徴収.getコード().equals(年度データ.get徴収方法())) {
                sankaiTokuchoItem = makeChoteiboDankaiTokuchoItem(段階表記, 年度データ);
            }
            if (null != 年度データ.get段階小計リスト() && !年度データ.get段階小計リスト().isEmpty()) {
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                            || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                        continue;
                    }
                    listDankaiBetsu_2 = listDankaiBetsu_2.isEmpty()
                            ? changeDecimalToRString(段階小計.getTokuchosyaKensu()) : listDankaiBetsu_2;
                    listDankaiBetsu_3 = listDankaiBetsu_3.isEmpty()
                            ? changeDecimalToRString(段階小計.getFuchosyaKensu()) : listDankaiBetsu_3;
                    listDankaiBetsu_4 = listDankaiBetsu_4.isEmpty()
                            ? changeDecimalToRString(段階小計.getNaiheisyaKensu()) : listDankaiBetsu_4;
                }
            }
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                段階表記, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                dankaiFuchoItem, sankaiTokuchoItem);
        return dankaiItem;
    }

    private ChoteiboDankaiFuchoItem makeChoteiboDankaiFuchoItem(RString 段階表記, NendoDataEntity 年度データ) {
        if (null == 年度データ
                || null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
            return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString listFuchoDankaiBetsu_2 = RString.EMPTY;
        RString listFuchoDankaiBetsu_3 = RString.EMPTY;
        RString listFuchoDankaiBetsu_4 = RString.EMPTY;
        RString listFuchoDankaiBetsu_5 = RString.EMPTY;
        RString listFuchoDankaiBetsu_6 = RString.EMPTY;
        RString listFuchoDankaiBetsu_7 = RString.EMPTY;
        RString listFuchoDankaiBetsu_8 = RString.EMPTY;
        RString listFuchoDankaiBetsu_9 = RString.EMPTY;
        for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
            if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                    || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                continue;
            }
            if (前月フラグ == 段階小計.getDogetsuFlag()) {
                listFuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                listFuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
            } else {
                listFuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                listFuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                listFuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                listFuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                listFuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                listFuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
            }
        }
        return new ChoteiboDankaiFuchoItem(段階表記, listFuchoDankaiBetsu_2, listFuchoDankaiBetsu_3,
                listFuchoDankaiBetsu_4, listFuchoDankaiBetsu_5, listFuchoDankaiBetsu_6,
                listFuchoDankaiBetsu_7, listFuchoDankaiBetsu_8, listFuchoDankaiBetsu_9);
    }

    private ChoteiboDankaiTokuchoItem makeChoteiboDankaiTokuchoItem(RString 段階表記, NendoDataEntity 年度データ) {
        if (null == 年度データ
                || null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
            return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString listTokuchoDankaiBetsu_2 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_3 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_4 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_5 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_6 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_7 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_8 = RString.EMPTY;
        RString listTokuchoDankaiBetsu_9 = RString.EMPTY;
        for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
            if (null == 段階小計.getDankai() || 段階小計.getDankai().isEmpty()
                    || get段階(段階表記) != Integer.parseInt(段階小計.getDankai().trim().toString())) {
                continue;
            }
            if (前月フラグ == 段階小計.getDogetsuFlag()) {
                listTokuchoDankaiBetsu_2 = changeDecimalToRString(段階小計.getZengetsusueKensu());
                listTokuchoDankaiBetsu_3 = changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount());
            } else {
                listTokuchoDankaiBetsu_4 = changeDecimalToRString(段階小計.getFueKensu());
                listTokuchoDankaiBetsu_5 = changeDecimalToRString(段階小計.getFueChoteigakuCount());
                listTokuchoDankaiBetsu_6 = changeDecimalToRString(段階小計.getGenKensu());
                listTokuchoDankaiBetsu_7 = changeDecimalToRString(段階小計.getGenChoteigakuCount());
                listTokuchoDankaiBetsu_8 = changeDecimalToRString(段階小計.getDogetsusueKensu());
                listTokuchoDankaiBetsu_9 = changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount());
            }
        }
        return new ChoteiboDankaiTokuchoItem(段階表記, listTokuchoDankaiBetsu_2, listTokuchoDankaiBetsu_3,
                listTokuchoDankaiBetsu_4, listTokuchoDankaiBetsu_5, listTokuchoDankaiBetsu_6,
                listTokuchoDankaiBetsu_7, listTokuchoDankaiBetsu_8, listTokuchoDankaiBetsu_9);
    }

    private HokenryoDankaiList get保険料段階List(FlexibleYear 年度) {
        return 保険料段階取得Mgr.get保険料段階ListIn(年度);
    }

    private RString 星を追加する(RString str) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(str == null ? RString.EMPTY : str);
        builder.append(HOSHI);
        return builder.toRString();
    }

    private RString changeDecimalToRString(Decimal val) {
        if (null == val || val.equals(Decimal.ZERO)) {
            return RString.EMPTY;
        } else {
            return new RString(String.valueOf(val.intValue()));
        }
    }

    private Decimal changeNULLToZero(Decimal val) {
        return null == val ? Decimal.ZERO : val;
    }

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RStringBuilder().append(JobContextHolder.getJobId()).toRString();
        RString 帳票名 = ReportIdDBB.DBB3001.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = なし;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(SHORINENDO_NAME);
        builder.append(parameter.getShoriNendo().wareki().toDateString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(STARTCHOTEINICHIJI_NAME);
        builder.append(parameter.getChushutsuStYMD().wareki().toDateString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(ENDCHOTEINICHIJI_NAME);
        builder.append(parameter.getChushutsuEdYMD().wareki().toDateString());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB3001.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private void set合計データリストBy合計部分総計情報(
            List<GokeiDataEntity> 合計データリスト,
            GokeiBubunSoukeiEntity 合計部分総計情報) {
        if (null == 合計部分総計情報 || null == 合計データリスト) {
            return;
        }
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (null == 合計データ.get徴収方法()) {
                setその他合計データ(合計データ, 合計部分総計情報);
            } else if (null != 合計部分総計情報.getChoshuHouhou()
                    && 合計データ.get徴収方法().equals(合計部分総計情報.getChoshuHouhou())) {
                set特徴と普徴合計データ(合計データ, 合計部分総計情報);
            }
        }
    }

    private void set特徴と普徴合計データ(GokeiDataEntity 合計データ, GokeiBubunSoukeiEntity 合計部分総計情報) {
        if (null == 合計データ.get前月末の全部件数の総計()) {
            合計データ.set前月末の全部件数の総計(合計部分総計情報.getZengetsusueKensuSoukei());
        }
        if (null == 合計データ.get前月末の全部調定額の総計()) {
            合計データ.set前月末の全部調定額の総計(合計部分総計情報.getZengetsusueChoteigakuSoukei());
        }
        if (null == 合計データ.get増の全部件数の総計()) {
            合計データ.set増の全部件数の総計(合計部分総計情報.getFueZennbuKennsuuSoukei());
        }
        if (null == 合計データ.get増の全部調定額の総計()) {
            合計データ.set増の全部調定額の総計(合計部分総計情報.getFueZennbuChoteigakuSoukei());
        }
        if (null == 合計データ.get減の全部件数の総計()) {
            合計データ.set減の全部件数の総計(合計部分総計情報.getGenZennbuKennsuuSoukei());
        }
        if (null == 合計データ.get減の全部調定額の総計()) {
            合計データ.set減の全部調定額の総計(合計部分総計情報.getGenZennbuChoteigakuSoukei());
        }
        if (null == 合計データ.get当月末の全部件数の総計()) {
            合計データ.set当月末の全部件数の総計(合計部分総計情報.getDogetsusueKensuSoukei());
        }
        if (null == 合計データ.get当月末の全部調定額の総計()) {
            合計データ.set当月末の全部調定額の総計(合計部分総計情報.getDogetsusueChoteigakuSoukei());
        }
    }

    private void setその他合計データ(GokeiDataEntity 合計データ, GokeiBubunSoukeiEntity 合計部分総計情報) {
        if (null == 合計データ.get特別徴収の調定額の総計()) {
            合計データ.set特別徴収の調定額の総計(合計部分総計情報.getTobetsuChoteigakuSoukei());
        }
        if (null == 合計データ.get普通徴収の調定額の総計()) {
            合計データ.set普通徴収の調定額の総計(合計部分総計情報.getFutsuChoteigakuSoukei());
        }
        if (null == 合計データ.get特徴と普徴の総計()) {
            合計データ.set特徴と普徴の総計(合計部分総計情報.getTobetsuTofutsuChoteigakuSoukei());
        }
        if (null == 合計データ.get特徴者数の総計()) {
            合計データ.set特徴者数の総計(合計部分総計情報.getTokuchosyaKensuSoukei());
        }
        if (null == 合計データ.get普徴者数の総計()) {
            合計データ.set普徴者数の総計(合計部分総計情報.getFuchosyaKensuSoukei());
        }
        if (null == 合計データ.get内併徴者数の総計()) {
            合計データ.set内併徴者数の総計(合計部分総計情報.getNaiheisyaKensuSoukei());
        }
        if (null == 合計データ.get減免の件数の総計()) {
            合計データ.set減免の件数の総計(合計部分総計情報.getGenmenSoukei());
        }
        if (null == 合計データ.get減免の調定額の総計()) {
            合計データ.set減免の調定額の総計(合計部分総計情報.getGenmenChoteigakuSoukei());
        }
        if (null == 合計データ.get特徴歳出還付の件数の総計()) {
            合計データ.set特徴歳出還付の件数の総計(合計部分総計情報.getTkSaishutsuKampuSoukei());
        }
        if (null == 合計データ.get特徴歳出還付の調定額の総計()) {
            合計データ.set特徴歳出還付の調定額の総計(合計部分総計情報.getTkSaishutsuKampuChoteigakuSoukei());
        }
        if (null == 合計データ.get普徴歳出還付の件数の総計()) {
            合計データ.set普徴歳出還付の件数の総計(合計部分総計情報.getFuSaishutsuKampuSoukei());
        }
        if (null == 合計データ.get普徴歳出還付の調定額の総計()) {
            合計データ.set普徴歳出還付の調定額の総計(合計部分総計情報.getFuSaishutsuKampuChoteigakuSoukei());
        }
    }

    private void set合計データリストBy合計部分情報(
            List<GokeiDataEntity> 合計データリスト,
            GokeiBubunEntity 合計部分情報) {
        if (null == 合計部分情報 || null == 合計データリスト) {
            return;
        }
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            set期別合計データ(合計データ, 合計部分情報);
            set段階合計データ(合計データ, 合計部分情報);
        }
    }

    private void set期別合計データ(GokeiDataEntity 合計データ, GokeiBubunEntity 合計部分情報) {
        if (null == 合計データ.get徴収方法() || null == 合計部分情報 || null == 合計部分情報.getChoshuHouhou()
                || !合計データ.get徴収方法().equals(合計部分情報.getChoshuHouhou())) {
            return;
        }
        if (null == 合計データ.get当_10月の調定額の小計()) {
            合計データ.set当_10月の調定額の小計(合計部分情報.getChoteigaku10GatsuCount());
        }
        if (null == 合計データ.get当_11月の調定額の小計()) {
            合計データ.set当_11月の調定額の小計(合計部分情報.getChoteigaku11GatsuCount());
        }
        if (null == 合計データ.get当_12月の調定額の小計()) {
            合計データ.set当_12月の調定額の小計(合計部分情報.getChoteigaku12GatsuCount());
        }
        if (null == 合計データ.get当_1月の調定額の小計()) {
            合計データ.set当_1月の調定額の小計(合計部分情報.getChoteigaku1GatsuCount());
        }
        if (null == 合計データ.get当_2月の調定額の小計()) {
            合計データ.set当_2月の調定額の小計(合計部分情報.getChoteigaku2GatsuCount());
        }
        if (null == 合計データ.get当_3月の調定額の小計()) {
            合計データ.set当_3月の調定額の小計(合計部分情報.getChoteigaku3GatsuCount());
        }
        if (null == 合計データ.get当_4月の調定額の小計()) {
            合計データ.set当_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCount());
        }
        if (null == 合計データ.get当_5月の調定額の小計()) {
            合計データ.set当_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCount());
        }
        if (null == 合計データ.get当_6月の調定額の小計()) {
            合計データ.set当_6月の調定額の小計(合計部分情報.getChoteigaku6GatsuCount());
        }
        if (null == 合計データ.get当_7月の調定額の小計()) {
            合計データ.set当_7月の調定額の小計(合計部分情報.getChoteigaku7GatsuCount());
        }
        if (null == 合計データ.get当_8月の調定額の小計()) {
            合計データ.set当_8月の調定額の小計(合計部分情報.getChoteigaku8GatsuCount());
        }
        if (null == 合計データ.get当_9月の調定額の小計()) {
            合計データ.set当_9月の調定額の小計(合計部分情報.getChoteigaku9GatsuCount());
        }
        if (null == 合計データ.get翌_4月の調定額の小計()) {
            合計データ.set翌_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCountYoku());
        }
        if (null == 合計データ.get翌_5月の調定額の小計()) {
            合計データ.set翌_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCountYoku());
        }
    }

    private void set段階合計データ(GokeiDataEntity 合計データ, GokeiBubunEntity 合計部分情報) {
        if (null == 合計部分情報.getDankai() || !本算定.equals(合計部分情報.getKarisanFlag())) {
            return;
        }
        if (null == 合計データ.get徴収方法()) {
            for (DankaiShokeiEntity 合計の段階 : 合計データ.get合計の段階リスト()) {
                if (合計の段階.getDankai().equals(合計部分情報.getDankai())) {
                    setその他合計の段階(合計の段階, 合計部分情報);
                    return;
                }
            }
            DankaiShokeiEntity 合計の段階 = new DankaiShokeiEntity();
            setその他合計の段階(合計の段階, 合計部分情報);
            合計データ.get合計の段階リスト().add(合計の段階);
        } else if (null != 合計部分情報.getChoshuHouhou()
                && 合計データ.get徴収方法().equals(合計部分情報.getChoshuHouhou())) {
            for (DankaiShokeiEntity 合計の段階 : 合計データ.get合計の段階リスト()) {
                if (合計の段階.getDankai().equals(合計部分情報.getDankai())) {
                    set合計の段階(合計の段階, 合計部分情報);
                    return;
                }
            }
            DankaiShokeiEntity 合計の段階 = new DankaiShokeiEntity();
            set合計の段階(合計の段階, 合計部分情報);
            合計データ.get合計の段階リスト().add(合計の段階);
        }
    }

    private void set合計の段階(DankaiShokeiEntity 合計の段階, GokeiBubunEntity 合計部分情報) {
        if (null == 合計の段階.getChoshuHouhou()) {
            合計の段階.setChoshuHouhou(合計部分情報.getChoshuHouhou());
        }
        if (null == 合計の段階.getDankai()) {
            合計の段階.setDankai(合計部分情報.getDankai());
        }
        if (null == 合計の段階.getZengetsusueKensu()) {
            合計の段階.setZengetsusueKensu(合計部分情報.getZengetsusueKensuCount());
        }
        if (null == 合計の段階.getZengetsusueChoteigakuCount()) {
            合計の段階.setZengetsusueChoteigakuCount(合計部分情報.getZengetsusueChoteigakuCount());
        }
        if (null == 合計の段階.getFueKensu()) {
            合計の段階.setFueKensu(合計部分情報.getFueKensuCount());
        }
        if (null == 合計の段階.getFueChoteigakuCount()) {
            合計の段階.setFueChoteigakuCount(合計部分情報.getFueChoteigakuCount());
        }
        if (null == 合計の段階.getGenKensu()) {
            合計の段階.setGenKensu(合計部分情報.getGenKensuCount());
        }
        if (null == 合計の段階.getGenChoteigakuCount()) {
            合計の段階.setGenChoteigakuCount(合計部分情報.getGenChoteigakuCount());
        }
        if (null == 合計の段階.getDogetsusueKensu()) {
            合計の段階.setDogetsusueKensu(合計部分情報.getDogetsusueKensuCount());
        }
        if (null == 合計の段階.getDogetsusueChoteigakuCount()) {
            合計の段階.setDogetsusueChoteigakuCount(合計部分情報.getDogetsusueChoteigakuCount());
        }
    }

    private void setその他合計の段階(DankaiShokeiEntity 合計の段階, GokeiBubunEntity 合計部分情報) {
        if (null == 合計の段階.getDankai()) {
            合計の段階.setDankai(合計部分情報.getDankai());
        }
        if (null == 合計の段階.getTokuchosyaKensu()) {
            合計の段階.setTokuchosyaKensu(合計部分情報.getTokuchosyaKensuCount());
        }
        if (null == 合計の段階.getFuchosyaKensu()) {
            合計の段階.setFuchosyaKensu(合計部分情報.getFuchosyaKensuCount());
        }
        if (null == 合計の段階.getNaiheisyaKensu()) {
            合計の段階.setNaiheisyaKensu(合計部分情報.getNaiheisyaKensuCount());
        }
    }

    private List<GokeiDataEntity> get合計データリスト() {
        List<GokeiDataEntity> 合計リスト = new ArrayList<>();
        List<GokeiBubunEntity> 合計部分情報リスト = choteiboSakuseiMapper.selectAll合計部分情報();
        List<GokeiBubunSoukeiEntity> 合計部分総計情報リスト = choteiboSakuseiMapper.selectAll合計部分総計情報();
        GokeiDataEntity 特別徴収合計データ = new GokeiDataEntity();
        List<DankaiShokeiEntity> 特別徴収合計の段階リスト = new ArrayList<>();
        特別徴収合計データ.set徴収方法(ChoshuHohoKibetsu.特別徴収.getコード());
        特別徴収合計データ.set合計の段階リスト(特別徴収合計の段階リスト);
        GokeiDataEntity 普通徴収合計データ = new GokeiDataEntity();
        List<DankaiShokeiEntity> 普通徴収合計の段階リスト = new ArrayList<>();
        普通徴収合計データ.set合計の段階リスト(普通徴収合計の段階リスト);
        普通徴収合計データ.set徴収方法(ChoshuHohoKibetsu.普通徴収.getコード());
        GokeiDataEntity その他合計データ = new GokeiDataEntity();
        List<DankaiShokeiEntity> その他合計の段階リスト = new ArrayList<>();
        その他合計データ.set合計の段階リスト(その他合計の段階リスト);
        合計リスト.add(特別徴収合計データ);
        合計リスト.add(普通徴収合計データ);
        合計リスト.add(その他合計データ);
        for (GokeiBubunSoukeiEntity 合計部分総計情報 : 合計部分総計情報リスト) {
            set合計データリストBy合計部分総計情報(合計リスト, 合計部分総計情報);
        }
        for (GokeiBubunEntity 合計部分情報 : 合計部分情報リスト) {
            set合計データリストBy合計部分情報(合計リスト, 合計部分情報);
        }
        特別徴収合計データ.set特別徴収の調定額の総計(その他合計データ.get特別徴収の調定額の総計());
        特別徴収合計データ.set特徴歳出還付の件数の総計(その他合計データ.get特徴歳出還付の件数の総計());
        特別徴収合計データ.set特徴歳出還付の調定額の総計(その他合計データ.get特徴歳出還付の調定額の総計());
        普通徴収合計データ.set普通徴収の調定額の総計(その他合計データ.get普通徴収の調定額の総計());
        普通徴収合計データ.set普徴歳出還付の件数の総計(その他合計データ.get普徴歳出還付の件数の総計());
        普通徴収合計データ.set普徴歳出還付の調定額の総計(その他合計データ.get普徴歳出還付の調定額の総計());
        return 合計リスト;
    }

    private List<NendoDataEntity> get年度データリスト(FlexibleYear choteiNendo, FlexibleYear fukaNendo) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), choteiNendo);
        param.put(KEY_FUKANENDO.toString(), fukaNendo);
        List<NendoDataEntity> 年度データリスト = new ArrayList<>();
        List<KibetsuShokeiEntity> 期別小計リスト = choteiboSakuseiMapper.select期別小計情報(param);
        List<DankaiShokeiEntity> 段階小計リスト = choteiboSakuseiMapper.select段階小計情報(param);
        List<KibetsuGokeiEntity> 期別合計リスト = choteiboSakuseiMapper.select期別合計情報(param);
        List<DankaiGokeiEntity> 段階合計リスト = choteiboSakuseiMapper.select段階合計情報(param);
        NendoDataEntity 年度特別徴収データ = new NendoDataEntity();
        年度特別徴収データ.set徴収方法(ChoshuHohoKibetsu.特別徴収.getコード());
        年度特別徴収データ.set調定年度(choteiNendo);
        年度特別徴収データ.set賦課年度(fukaNendo);
        NendoDataEntity 年度普通徴収データ = new NendoDataEntity();
        年度普通徴収データ.set徴収方法(ChoshuHohoKibetsu.普通徴収.getコード());
        年度普通徴収データ.set調定年度(choteiNendo);
        年度普通徴収データ.set賦課年度(fukaNendo);
        add期別小計To年度データ(年度特別徴収データ, 期別小計リスト, ChoshuHohoKibetsu.特別徴収.getコード());
        add期別小計To年度データ(年度普通徴収データ, 期別小計リスト, ChoshuHohoKibetsu.普通徴収.getコード());
        add段階小計リストTo年度データ(年度特別徴収データ, 段階小計リスト, ChoshuHohoKibetsu.特別徴収.getコード());
        add段階小計リストTo年度データ(年度普通徴収データ, 段階小計リスト, ChoshuHohoKibetsu.普通徴収.getコード());
        add期別合計To年度データ(年度特別徴収データ, 期別合計リスト, ChoshuHohoKibetsu.特別徴収.getコード());
        add期別合計To年度データ(年度普通徴収データ, 期別合計リスト, ChoshuHohoKibetsu.普通徴収.getコード());
        add段階合計To年度データ(年度特別徴収データ, 段階合計リスト, ChoshuHohoKibetsu.特別徴収.getコード());
        add段階合計To年度データ(年度普通徴収データ, 段階合計リスト, ChoshuHohoKibetsu.普通徴収.getコード());
        add特普徴者数の合計To年度データ(年度普通徴収データ, 段階合計リスト);
        年度データリスト.add(年度特別徴収データ);
        年度データリスト.add(年度普通徴収データ);
        return 年度データリスト;
    }

    private void add特普徴者数の合計To年度データ(
            NendoDataEntity 年度データ,
            List<DankaiGokeiEntity> 段階合計リスト) {
        if (null == 年度データ || null == 段階合計リスト) {
            return;
        }
        for (DankaiGokeiEntity 段階合計 : 段階合計リスト) {
            if (null != 段階合計.getNaiheisyaKensuCount()) {
                年度データ.set内併徴者数の合計(段階合計.getNaiheisyaKensuCount());
            }
            if (null != 段階合計.getTokuchosyaKensuCount()) {
                年度データ.set特徴者数の合計(段階合計.getTokuchosyaKensuCount());
            }
            if (null != 段階合計.getFuchosyaKensuCount()) {
                年度データ.set普徴者数の合計(段階合計.getFuchosyaKensuCount());
            }
        }
    }

    private void add段階合計To年度データ(
            NendoDataEntity 年度データ,
            List<DankaiGokeiEntity> 段階合計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 段階合計リスト) {
            return;
        }

        for (DankaiGokeiEntity 段階合計 : 段階合計リスト) {
            if (null == 段階合計.getChoshuHouhou() || !徴収方法.equals(段階合計.getChoshuHouhou())) {
                continue;
            }
            if (当月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set当月末の全部件数の合計(段階合計.getDogetsusueKensuCount());
                年度データ.set当月末の全部調定額の合計(段階合計.getDogetsusueChoteigakuCount());
            } else if (前月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set前月末の全部件数の合計(段階合計.getZengetsusueKensuCount());
                年度データ.set前月末の全部調定額の合計(段階合計.getZengetsusueChoteigakuCount());
            }
            年度データ.set増の全部件数の合計(段階合計.getFueZennbuKennsuuGokei());
            年度データ.set増の全部調定額の合計(段階合計.getFueZennbuChoteigakuGokei());
            年度データ.set減の全部件数の合計(段階合計.getGenZennbuKennsuuGokei());
            年度データ.set減の全部調定額の合計(段階合計.getGenZennbuChoteigakuGokei());
        }
    }

    private void add期別合計To年度データ(
            NendoDataEntity 年度データ,
            List<KibetsuGokeiEntity> 期別合計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 期別合計リスト) {
            return;
        }
        for (KibetsuGokeiEntity 期別合計 : 期別合計リスト) {
            if (null != 期別合計.getTobetsuTofutsuChoteigakuCount()) {
                年度データ.set特徴と普徴の合計(期別合計.getTobetsuTofutsuChoteigakuCount());
            }
            if (null != 期別合計.getGenmenCount()) {
                年度データ.set減免の件数(期別合計.getGenmenCount());
            }
            if (null != 期別合計.getGenmenChoteigaku()) {
                年度データ.set減免の調定額(期別合計.getGenmenChoteigaku());
            }
            if (null != 期別合計.getChoshuHouhou()
                    && ChoshuHohoKibetsu.特別徴収.getコード().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set特別徴収の調定額の合計(期別合計.getTobetsuChoteigakuCount());
                年度データ.set特徴歳出還付の件数(期別合計.getTkSaishutsuKampuCount());
                年度データ.set特徴歳出還付の調定額(期別合計.getTkSaishutsuKampuChoteigaku());
            } else if (null != 期別合計.getChoshuHouhou()
                    && ChoshuHohoKibetsu.普通徴収.getコード().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set普通徴収の調定額の合計(期別合計.getFutsuChoteigakuCount());
                年度データ.set普徴歳出還付の件数(期別合計.getFuSaishutsuKampuCount());
                年度データ.set普徴歳出還付の調定額(期別合計.getFuSaishutsuKampuChoteigaku());
            }
        }
    }

    private void add段階小計リストTo年度データ(
            NendoDataEntity 年度データ,
            List<DankaiShokeiEntity> 段階小計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 段階小計リスト) {
            return;
        }
        List<DankaiShokeiEntity> result段階小計リスト = new ArrayList<>();
        for (DankaiShokeiEntity 段階小計 : 段階小計リスト) {
            if (null != 段階小計.getChoshuHouhou() && 徴収方法.equals(段階小計.getChoshuHouhou())
                    && 本算定.equals(段階小計.getKarisanFlag())) {
                result段階小計リスト.add(段階小計);
            }
        }
        年度データ.set段階小計リスト(result段階小計リスト);
    }

    private void add期別小計To年度データ(
            NendoDataEntity 年度データ,
            List<KibetsuShokeiEntity> 期別小計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 期別小計リスト) {
            return;
        }
        for (KibetsuShokeiEntity 期別小計 : 期別小計リスト) {
            if (null != 期別小計.getChoshuHouhou() && 徴収方法.equals(期別小計.getChoshuHouhou())) {
                年度データ.set第1期の調定額の小計(期別小計.getDai1kiChoteigakuCount());
                年度データ.set第2期の調定額の小計(期別小計.getDai2kiChoteigakuCount());
                年度データ.set第3期の調定額の小計(期別小計.getDai3kiChoteigakuCount());
                年度データ.set第4期の調定額の小計(期別小計.getDai4kiChoteigakuCount());
                年度データ.set第5期の調定額の小計(期別小計.getDai5kiChoteigakuCount());
                年度データ.set第6期の調定額の小計(期別小計.getDai6kiChoteigakuCount());
                年度データ.set第7期の調定額の小計(期別小計.getDai7kiChoteigakuCount());
                年度データ.set第8期の調定額の小計(期別小計.getDai8kiChoteigakuCount());
                年度データ.set第9期の調定額の小計(期別小計.getDai9kiChoteigakuCount());
                年度データ.set第10期の調定額の小計(期別小計.getDai10kiChoteigakuCount());
                年度データ.set第11期の調定額の小計(期別小計.getDai11kiChoteigakuCount());
                年度データ.set第12期の調定額の小計(期別小計.getDai12kiChoteigakuCount());
                年度データ.set第13期の調定額の小計(期別小計.getDai13kiChoteigakuCount());
                年度データ.set第14期の調定額の小計(期別小計.getDai14kiChoteigakuCount());
            }
        }
    }

}
