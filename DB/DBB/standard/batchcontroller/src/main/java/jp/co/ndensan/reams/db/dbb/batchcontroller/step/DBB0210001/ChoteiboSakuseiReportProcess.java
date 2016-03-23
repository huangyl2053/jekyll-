/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB0210001;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo.ChoteiboShoriHizukeMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportId.ReportIdDBB;
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
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 調定簿作成帳票用Processクラスです。
 */
public class ChoteiboSakuseiReportProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final int 当月フラグ = 1;
    private static final int 前月フラグ = 0;
    private static final RString SHORINENDO_NAME = new RString("【処理年度】");
    private static final RString STARTCHOTEINICHIJI_NAME = new RString("【開始調定日時】");
    private static final RString ENDCHOTEINICHIJI_NAME = new RString("【終了調定日時】");
    private static final RString JOBNO_NAME = new RString("【ジョブ番号】");
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
    private static final RString UNDERLINE = new RString("_");
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
        if (null != entity && null != entity.getKijunTimestamp()
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

    private boolean is仮算定データ() {
        return 処理日付リスト.isEmpty();
    }

    private void make帳票出力リスト() {
        ChoteiboHeaderItem headerItem = new ChoteiboHeaderItem(
                RDateTime.now().getDate().wareki().toDateString(),
                ReportIdDBB.DBB3001.getReportName(),
                parameter.getShoriNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString(),
                parameter.getShoriNendo().wareki().getYear(),
                導入団体コード, 市町村名);
        makeChoteiboItemList(headerItem);
    }

    private void makeChoteiboItemList(ChoteiboHeaderItem headerItem) {
        targets.add(makeChoteiboItem(TONENDO, 当年度データリスト, headerItem));
        targets.add(makeChoteiboItem(ZENNENDO, 前年度データリスト, headerItem));
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
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                kitsukiFuchoItem = makeKitsukiFuchoItem(合計データ);
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                kitsukiTokuchoItem = makeKitsukiTokuchoItem(合計データ);
            }
            genmenGaku = changeDecimalToRString(合計データ.get減免の調定額の総計());
            genmenSu = changeDecimalToRString(合計データ.get減免の件数の総計());
            nofuGakuSokei = changeDecimalToRString(合計データ.get特徴と普徴の総計());
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
                changeDecimalToRString(合計データ.get_4月の調定額の小計()),
                changeDecimalToRString(合計データ.get_5月の調定額の小計()),
                changeDecimalToRString(合計データ.get_6月の調定額の小計()),
                changeDecimalToRString(合計データ.get_7月の調定額の小計()),
                changeDecimalToRString(合計データ.get_8月の調定額の小計()),
                changeDecimalToRString(合計データ.get_9月の調定額の小計()),
                changeDecimalToRString(合計データ.get_10月の調定額の小計()),
                changeDecimalToRString(合計データ.get_11月の調定額の小計()),
                changeDecimalToRString(合計データ.get_12月の調定額の小計()),
                changeDecimalToRString(合計データ.get_1月の調定額の小計()),
                changeDecimalToRString(合計データ.get_2月の調定額の小計()),
                changeDecimalToRString(合計データ.get_3月の調定額の小計()),
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
                changeDecimalToRString(合計データ.get特別徴収の調定額の総計()),
                changeDecimalToRString(合計データ.get特徴歳出還付の調定額の総計()),
                changeDecimalToRString(合計データ.get特徴歳出還付の件数の総計()),
                文字列_第.concat(String.valueOf(第1期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第2期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第3期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第4期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第5期)).concat(文字列_期),
                文字列_第.concat(String.valueOf(第6期)).concat(文字列_期),
                changeDecimalToRString(合計データ.get_4月の調定額の小計()),
                changeDecimalToRString(合計データ.get_6月の調定額の小計()),
                changeDecimalToRString(合計データ.get_8月の調定額の小計()),
                changeDecimalToRString(合計データ.get_10月の調定額の小計()),
                changeDecimalToRString(合計データ.get_12月の調定額の小計()),
                changeDecimalToRString(合計データ.get_2月の調定額の小計()),
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
        RString ｈeichoShaSuKome = RString.EMPTY;
        RString fuchoShaSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem = null;
        ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem = null;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                dankaiGokeiFuchoItem = makeChoteiboDankaiGokeiFuchoItem(合計データ);
                listDankaiBetsuGokei_3 = changeDecimalToRString(合計データ.get普徴者数の総計());
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                dankaiGokeiTokuchoItem = makeChoteiboDankaiGokeiTokuchoItem(合計データ);
                listDankaiBetsuGokei_2 = changeDecimalToRString(合計データ.get特徴者数の総計());
            }
            if (null != 合計データ.get内併徴者数の総計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(合計データ.get内併徴者数の総計());
            }
            Decimal 内併徴者数の件数合計 = Decimal.ZERO;
            Decimal 普徴者数の合計 = Decimal.ZERO;
            Decimal 特徴者数の合計 = Decimal.ZERO;
            for (DankaiShokeiEntity 段階 : 合計データ.get合計の段階リスト()) {
                内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
                普徴者数の合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                特徴者数の合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
            }
            if (!is仮算定データ() && !内併徴者数の件数合計.equals(合計データ.get内併徴者数の総計())) {
                ｈeichoShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (!is仮算定データ() && !普徴者数の合計.equals(合計データ.get普徴者数の総計())) {
                fuchoShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (!is仮算定データ() && !特徴者数の合計.equals(合計データ.get特徴者数の総計())) {
                tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
            }
        }
        return new ChoteiboDankaiGokeiItem(
                GOKEI, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                mongon, ｈeichoShaSuKome, fuchoShaSuKome, tokuchoshaShaSuKome,
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
            当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!is仮算定データ() && !当月末の件数合計.equals(合計データ.get当月末の全部件数の総計())) {
            fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!is仮算定データ() && !当月末の調定額合計.equals(合計データ.get当月末の全部件数の総計())) {
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
            当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!is仮算定データ() && !当月末の件数合計.equals(合計データ.get当月末の全部件数の総計())) {
            tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!is仮算定データ() && !当月末の調定額合計.equals(合計データ.get当月末の全部件数の総計())) {
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
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                kitsukiFuchoItem = makeChoteiboKitsukiFuchoItem(年度データ);
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
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
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
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
                    期月リスト_特徴.get期の月(第1期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                    期月リスト_特徴.get期の月(第2期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                    期月リスト_特徴.get期の月(第3期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                    期月リスト_特徴.get期の月(第4期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                    期月リスト_特徴.get期の月(第5期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                    期月リスト_特徴.get期の月(第6期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY));
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
                期月リスト_特徴.get期の月(第1期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                期月リスト_特徴.get期の月(第2期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                期月リスト_特徴.get期の月(第3期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                期月リスト_特徴.get期の月(第4期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                期月リスト_特徴.get期の月(第5期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY),
                期月リスト_特徴.get期の月(第6期).get(0).get月().get名称().replace(UNDERLINE, RString.EMPTY));
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
                    get普徴月As期(第1期), get普徴月As期(第2期), get普徴月As期(第3期), get普徴月As期(第4期),
                    get普徴月As期(第5期), get普徴月As期(第6期), get普徴月As期(第7期), get普徴月As期(第8期),
                    get普徴月As期(第9期), get普徴月As期(第10期), get普徴月As期(第11期), get普徴月As期(第12期),
                    get普徴月As期(第13期), get普徴月As期(第14期),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
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
                get普徴月As期(第1期), get普徴月As期(第2期), get普徴月As期(第3期), get普徴月As期(第4期),
                get普徴月As期(第5期), get普徴月As期(第6期), get普徴月As期(第7期), get普徴月As期(第8期),
                get普徴月As期(第9期), get普徴月As期(第10期), get普徴月As期(第11期), get普徴月As期(第12期),
                get普徴月As期(第13期), get普徴月As期(第14期),
                随時期月判断(第1期, 年度データ.get賦課年度()), 随時期月判断(第2期, 年度データ.get賦課年度()),
                随時期月判断(第3期, 年度データ.get賦課年度()), 随時期月判断(第4期, 年度データ.get賦課年度()),
                随時期月判断(第5期, 年度データ.get賦課年度()), 随時期月判断(第6期, 年度データ.get賦課年度()),
                随時期月判断(第7期, 年度データ.get賦課年度()), 随時期月判断(第8期, 年度データ.get賦課年度()),
                随時期月判断(第9期, 年度データ.get賦課年度()), 随時期月判断(第10期, 年度データ.get賦課年度()),
                随時期月判断(第11期, 年度データ.get賦課年度()), 随時期月判断(第12期, 年度データ.get賦課年度()),
                随時期月判断(第13期, 年度データ.get賦課年度()), 随時期月判断(第14期, 年度データ.get賦課年度()));
    }

    private RString get普徴月As期(int 期) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        return 期月リスト_普徴.get期の月(期).get(0).get月().get名称().
                replace(UNDERLINE, RString.EMPTY).
                replace(文字列_翌年度, RString.EMPTY);
    }

    private RString 随時期月判断(int 期, FlexibleYear 年度) {
        if (null == 年度 || !年度.equals(parameter.getShoriNendo())) {
            return RString.EMPTY;
        }
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        Kitsuki 期月 = 期月リスト_普徴.get最終法定納期();
        for (Kitsuki kitsuki : 期月リスト_普徴.get期の月(期)) {
            if (期 != kitsuki.get期AsInt()
                    || Tsuki.翌年度4月.equals(kitsuki.get月())
                    || Tsuki.翌年度5月.equals(kitsuki.get月())) {
                continue;
            }
            if (kitsuki.get月().getコード().compareTo(期月.get月().getコード()) > 0) {
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
        RString ｈeichoShaSuKome = RString.EMPTY;
        RString fuchoShaSuKome = RString.EMPTY;
        RString tokuchoshaShaSuKome = RString.EMPTY;
        ChoteiboDankaiGokeiFuchoItem dankaiGokeiFuchoItem = null;
        ChoteiboDankaiGokeiTokuchoItem dankaiGokeiTokuchoItem = null;
        for (NendoDataEntity 年度データ : 年度データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                dankaiGokeiFuchoItem = makeChoteiboDankaiGokeiFuchoItem(年度データ);
                listDankaiBetsuGokei_3 = changeDecimalToRString(年度データ.get普徴者数の合計());
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                dankaiGokeiTokuchoItem = makeChoteiboDankaiGokeiTokuchoItem(年度データ);
                listDankaiBetsuGokei_2 = changeDecimalToRString(年度データ.get特徴者数の合計());
            }
            if (null != 年度データ.get内併徴者数の合計()) {
                listDankaiBetsuGokei_4 = changeDecimalToRString(年度データ.get内併徴者数の合計());
            }
            Decimal 内併徴者数の件数合計 = Decimal.ZERO;
            Decimal 普徴者数の合計 = Decimal.ZERO;
            Decimal 特徴者数の合計 = Decimal.ZERO;
            for (DankaiShokeiEntity 段階 : 年度データ.get段階小計リスト()) {
                内併徴者数の件数合計.add(changeNULLToZero(段階.getNaiheisyaKensu()));
                普徴者数の合計.add(changeNULLToZero(段階.getFuchosyaKensu()));
                特徴者数の合計.add(changeNULLToZero(段階.getTokuchosyaKensu()));
            }
            if (!is仮算定データ() && !内併徴者数の件数合計.equals(年度データ.get内併徴者数の合計())) {
                ｈeichoShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (!is仮算定データ() && !普徴者数の合計.equals(年度データ.get普徴者数の合計())) {
                fuchoShaSuKome = 星を追加する(RString.EMPTY);
            }
            if (!is仮算定データ() && !特徴者数の合計.equals(年度データ.get特徴者数の合計())) {
                tokuchoshaShaSuKome = 星を追加する(RString.EMPTY);
            }
        }
        ChoteiboDankaiGokeiItem dankaiGokeiItem = new ChoteiboDankaiGokeiItem(
                GOKEI, listDankaiBetsuGokei_2, listDankaiBetsuGokei_3, listDankaiBetsuGokei_4,
                mongon, ｈeichoShaSuKome, fuchoShaSuKome, tokuchoshaShaSuKome,
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
            当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!is仮算定データ() && !当月末の件数合計.equals(年度データ.get当月末の全部件数の合計())) {
            fuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!is仮算定データ() && !当月末の調定額合計.equals(年度データ.get当月末の全部件数の合計())) {
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
            当月末の件数合計.add(changeNULLToZero(段階.getDogetsusueKensu()));
            当月末の調定額合計.add(changeNULLToZero(段階.getDogetsusueChoteigakuCount()));
        }
        if (!is仮算定データ() && !当月末の件数合計.equals(年度データ.get前月末の全部件数の合計())) {
            tokuchoTogetsuSuKome = 星を追加する(RString.EMPTY);
        }
        if (!is仮算定データ() && !当月末の調定額合計.equals(年度データ.get前月末の全部件数の合計())) {
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
        for (RString 段階表記 : 保険料段階List.to表記List()) {
            dankaiItemList.add(makeChoteiboDankaiItemBy合計(段階表記, 合計データリスト));
        }
        return dankaiItemList;
    }

    private ChoteiboDankaiItem makeChoteiboDankaiItemBy合計(RString 段階表記, List<GokeiDataEntity> 合計データリスト) {
        RString listDankaiBetsu_2 = RString.EMPTY;
        RString listDankaiBetsu_3 = RString.EMPTY;
        RString listDankaiBetsu_4 = RString.EMPTY;
        ChoteiboDankaiFuchoItem dankaiFuchoItem = null;
        ChoteiboDankaiTokuchoItem dankaiTokuchoItem = null;
        for (GokeiDataEntity 合計データ : 合計データリスト) {
            if (ChoshuHohoKibetsu.普通徴収.code().equals(合計データ.get徴収方法())) {
                dankaiFuchoItem = makeChoteiboDankaiFuchoItem(段階表記, 合計データ);
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(合計データ.get徴収方法())) {
                dankaiTokuchoItem = makeChoteiboDankaiTokuchoItem(段階表記, 合計データ);
            }
            if (is仮算定データ() || null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
                listDankaiBetsu_2 = RString.EMPTY;
                listDankaiBetsu_3 = RString.EMPTY;
                listDankaiBetsu_4 = RString.EMPTY;
            } else {
                for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
                    if (get段階(段階表記).equals(段階小計.getDankai())) {
                        listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                        listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                        listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                        break;
                    }
                }
            }
        }
        return new ChoteiboDankaiItem(
                段階表記, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                dankaiFuchoItem, dankaiTokuchoItem);
    }

    private ChoteiboDankaiFuchoItem makeChoteiboDankaiFuchoItem(RString 段階表記, GokeiDataEntity 合計データ) {
        if (is仮算定データ() || null == 合計データ
                || null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
            return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
            if (get段階(段階表記).equals(段階小計.getDankai())) {
                return new ChoteiboDankaiFuchoItem(段階表記,
                        changeDecimalToRString(段階小計.getZengetsusueKensu()),
                        changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getFueKensu()),
                        changeDecimalToRString(段階小計.getFueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getGenKensu()),
                        changeDecimalToRString(段階小計.getGenChoteigakuCount()),
                        changeDecimalToRString(段階小計.getDogetsusueKensu()),
                        changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount()));
            }
        }
        return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private ChoteiboDankaiTokuchoItem makeChoteiboDankaiTokuchoItem(RString 段階表記, GokeiDataEntity 合計データ) {
        if (is仮算定データ() || null == 合計データ
                || null == 合計データ.get合計の段階リスト() || 合計データ.get合計の段階リスト().isEmpty()) {
            return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        for (DankaiShokeiEntity 段階小計 : 合計データ.get合計の段階リスト()) {
            if (get段階(段階表記).equals(段階小計.getDankai())) {
                return new ChoteiboDankaiTokuchoItem(段階表記,
                        changeDecimalToRString(段階小計.getZengetsusueKensu()),
                        changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getFueKensu()),
                        changeDecimalToRString(段階小計.getFueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getGenKensu()),
                        changeDecimalToRString(段階小計.getGenChoteigakuCount()),
                        changeDecimalToRString(段階小計.getDogetsusueKensu()),
                        changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount()));
            }
        }
        return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
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
            if (ChoshuHohoKibetsu.普通徴収.code().equals(年度データ.get徴収方法())) {
                dankaiFuchoItem = makeChoteiboDankaiFuchoItem(段階表記, 年度データ);
            } else if (ChoshuHohoKibetsu.特別徴収.code().equals(年度データ.get徴収方法())) {
                sankaiTokuchoItem = makeChoteiboDankaiTokuchoItem(段階表記, 年度データ);
            }
            if (is仮算定データ() || null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
                listDankaiBetsu_2 = RString.EMPTY;
                listDankaiBetsu_3 = RString.EMPTY;
                listDankaiBetsu_4 = RString.EMPTY;
            } else {
                for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
                    if (get段階(段階表記).equals(段階小計.getDankai())) {
                        listDankaiBetsu_2 = changeDecimalToRString(段階小計.getTokuchosyaKensu());
                        listDankaiBetsu_3 = changeDecimalToRString(段階小計.getFuchosyaKensu());
                        listDankaiBetsu_4 = changeDecimalToRString(段階小計.getNaiheisyaKensu());
                        break;
                    }
                }
            }
        }
        ChoteiboDankaiItem dankaiItem = new ChoteiboDankaiItem(
                段階表記, listDankaiBetsu_2, listDankaiBetsu_3, listDankaiBetsu_4,
                dankaiFuchoItem, sankaiTokuchoItem);
        return dankaiItem;
    }

    private ChoteiboDankaiFuchoItem makeChoteiboDankaiFuchoItem(RString 段階表記, NendoDataEntity 年度データ) {
        if (is仮算定データ() || null == 年度データ
                || null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
            return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
            if (get段階(段階表記).equals(段階小計.getDankai())) {
                return new ChoteiboDankaiFuchoItem(段階表記,
                        changeDecimalToRString(段階小計.getZengetsusueKensu()),
                        changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getFueKensu()),
                        changeDecimalToRString(段階小計.getFueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getGenKensu()),
                        changeDecimalToRString(段階小計.getGenChoteigakuCount()),
                        changeDecimalToRString(段階小計.getDogetsusueKensu()),
                        changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount()));
            }
        }
        return new ChoteiboDankaiFuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private ChoteiboDankaiTokuchoItem makeChoteiboDankaiTokuchoItem(RString 段階表記, NendoDataEntity 年度データ) {
        if (is仮算定データ() || null == 年度データ
                || null == 年度データ.get段階小計リスト() || 年度データ.get段階小計リスト().isEmpty()) {
            return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        for (DankaiShokeiEntity 段階小計 : 年度データ.get段階小計リスト()) {
            if (get段階(段階表記).equals(段階小計.getDankai())) {
                return new ChoteiboDankaiTokuchoItem(段階表記,
                        changeDecimalToRString(段階小計.getZengetsusueKensu()),
                        changeDecimalToRString(段階小計.getZengetsusueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getFueKensu()),
                        changeDecimalToRString(段階小計.getFueChoteigakuCount()),
                        changeDecimalToRString(段階小計.getGenKensu()),
                        changeDecimalToRString(段階小計.getGenChoteigakuCount()),
                        changeDecimalToRString(段階小計.getDogetsusueKensu()),
                        changeDecimalToRString(段階小計.getDogetsusueChoteigakuCount()));
            }
        }
        return new ChoteiboDankaiTokuchoItem(段階表記, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
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
        return null == val ? RString.EMPTY : new RString(String.valueOf(val.intValue()));
    }

    private Decimal changeNULLToZero(Decimal val) {
        return null == val ? Decimal.ZERO : val;
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(JOBNO_NAME);
        builder.append(" ");
        builder.append(JobContextHolder.getJobId());
        RString ジョブ番号 = builder.toRString();
        RString 帳票名 = ReportIdDBB.DBB3001.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = new RString("-");
        List<RString> 出力条件 = new ArrayList<>();
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

    private List<GokeiDataEntity> get合計データリスト() {
        List<GokeiDataEntity> 合計データリスト = new ArrayList<>();
        List<GokeiBubunEntity> 合計部分情報リスト = choteiboSakuseiMapper.selectAll合計部分情報();
        List<GokeiBubunSoukeiEntity> 合計部分総計情報リスト = choteiboSakuseiMapper.selectAll合計部分総計情報();
        for (GokeiBubunSoukeiEntity 合計部分総計情報 : 合計部分総計情報リスト) {
            GokeiDataEntity 合計データ = new GokeiDataEntity();
            合計データ.set徴収方法(合計部分総計情報.getChoshuHouhou());
            合計データ.set当月フラグ(合計部分総計情報.getDogetsuFlag());
            合計データ.set特別徴収の調定額の総計(合計部分総計情報.getTobetsuChoteigakuSoukei());
            合計データ.set普通徴収の調定額の総計(合計部分総計情報.getFutsuChoteigakuSoukei());
            合計データ.set特徴と普徴の総計(合計部分総計情報.getTobetsuTofutsuChoteigakuSoukei());
            合計データ.set前月末の全部件数の総計(合計部分総計情報.getZengetsusueKensuSoukei());
            合計データ.set前月末の全部調定額の総計(合計部分総計情報.getZengetsusueChoteigakuSoukei());
            合計データ.set増の全部件数の総計(合計部分総計情報.getFueZennbuKennsuuSoukei());
            合計データ.set増の全部調定額の総計(合計部分総計情報.getFueZennbuChoteigakuSoukei());
            合計データ.set減の全部件数の総計(合計部分総計情報.getGenZennbuKennsuuSoukei());
            合計データ.set減の全部調定額の総計(合計部分総計情報.getGenZennbuChoteigakuSoukei());
            合計データ.set当月末の全部件数の総計(合計部分総計情報.getDogetsusueKensuSoukei());
            合計データ.set当月末の全部調定額の総計(合計部分総計情報.getDogetsusueChoteigakuSoukei());
            合計データ.set特徴者数の総計(合計部分総計情報.getTokuchosyaKensuSoukei());
            合計データ.set普徴者数の総計(合計部分総計情報.getFuchosyaKensuSoukei());
            合計データ.set内併徴者数の総計(合計部分総計情報.getNaiheisyaKensuSoukei());
            合計データ.set減免の件数の総計(合計部分総計情報.getGenmenSoukei());
            合計データ.set減免の調定額の総計(合計部分総計情報.getGenmenChoteigakuSoukei());
            合計データ.set特徴歳出還付の件数の総計(合計部分総計情報.getTkSaishutsuKampuSoukei());
            合計データ.set特徴歳出還付の調定額の総計(合計部分総計情報.getTkSaishutsuKampuChoteigakuSoukei());
            合計データ.set普徴歳出還付の件数の総計(合計部分総計情報.getFuSaishutsuKampuSoukei());
            合計データ.set普徴歳出還付の調定額の総計(合計部分総計情報.getFuSaishutsuKampuChoteigakuSoukei());
            List<DankaiShokeiEntity> 合計の段階リスト = new ArrayList<>();
            for (GokeiBubunEntity 合計部分情報 : 合計部分情報リスト) {
                if (null == 合計データ.get徴収方法() || null == 合計部分情報.getChoshuHouhou()) {
                    continue;
                }
                if (合計データ.get徴収方法().equals(合計部分情報.getChoshuHouhou())
                        && 合計データ.get当月フラグ() == 合計部分情報.getDogetsuFlag()) {
                    合計データ.set_10月の調定額の小計(合計部分情報.getChoteigaku10GatsuCount());
                    合計データ.set_11月の調定額の小計(合計部分情報.getChoteigaku11GatsuCount());
                    合計データ.set_12月の調定額の小計(合計部分情報.getChoteigaku12GatsuCount());
                    合計データ.set_1月の調定額の小計(合計部分情報.getChoteigaku1GatsuCount());
                    合計データ.set_2月の調定額の小計(合計部分情報.getChoteigaku2GatsuCount());
                    合計データ.set_3月の調定額の小計(合計部分情報.getChoteigaku3GatsuCount());
                    合計データ.set_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCount());
                    合計データ.set_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCount());
                    合計データ.set_6月の調定額の小計(合計部分情報.getChoteigaku6GatsuCount());
                    合計データ.set_7月の調定額の小計(合計部分情報.getChoteigaku7GatsuCount());
                    合計データ.set_8月の調定額の小計(合計部分情報.getChoteigaku8GatsuCount());
                    合計データ.set_9月の調定額の小計(合計部分情報.getChoteigaku9GatsuCount());
                    合計データ.set翌_4月の調定額の小計(合計部分情報.getChoteigaku4GatsuCountYoku());
                    合計データ.set翌_5月の調定額の小計(合計部分情報.getChoteigaku5GatsuCountYoku());
                    DankaiShokeiEntity 合計の段階 = new DankaiShokeiEntity();
                    合計の段階.setChoshuHouhou(合計部分情報.getChoshuHouhou());
                    合計の段階.setDogetsuFlag(合計部分情報.getDogetsuFlag());
                    合計の段階.setDankai(合計部分情報.getDankai());
                    合計の段階.setZengetsusueKensu(合計部分情報.getZengetsusueKensuCount());
                    合計の段階.setZengetsusueChoteigakuCount(合計部分情報.getZengetsusueChoteigakuCount());
                    合計の段階.setFueKensu(合計部分情報.getFueKensuCount());
                    合計の段階.setFueChoteigakuCount(合計部分情報.getFueChoteigakuCount());
                    合計の段階.setGenKensu(合計部分情報.getGenKensuCount());
                    合計の段階.setGenChoteigakuCount(合計部分情報.getGenChoteigakuCount());
                    合計の段階.setDogetsusueKensu(合計部分情報.getDogetsusueKensuCount());
                    合計の段階.setDogetsusueChoteigakuCount(合計部分情報.getDogetsusueChoteigakuCount());
                    合計の段階.setTokuchosyaKensu(合計部分情報.getTokuchosyaKensuCount());
                    合計の段階.setFuchosyaKensu(合計部分情報.getFuchosyaKensuCount());
                    合計の段階.setNaiheisyaKensu(合計部分情報.getNaiheisyaKensuCount());
                    合計の段階リスト.add(合計の段階);
                }
            }
            合計データ.set合計の段階リスト(合計の段階リスト);
            合計データリスト.add(合計データ);
        }
        return 合計データリスト;
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
        年度特別徴収データ.set徴収方法(ChoshuHohoKibetsu.特別徴収.code());
        年度特別徴収データ.set調定年度(choteiNendo);
        年度特別徴収データ.set賦課年度(fukaNendo);
        NendoDataEntity 年度普通徴収データ = new NendoDataEntity();
        年度普通徴収データ.set徴収方法(ChoshuHohoKibetsu.普通徴収.code());
        年度普通徴収データ.set調定年度(choteiNendo);
        年度普通徴収データ.set賦課年度(fukaNendo);
        add期別小計To年度データ(年度特別徴収データ, 期別小計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add期別小計To年度データ(年度普通徴収データ, 期別小計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add段階小計リストTo年度データ(年度特別徴収データ, 段階小計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add段階小計リストTo年度データ(年度普通徴収データ, 段階小計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add期別合計To年度データ(年度特別徴収データ, 期別合計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add期別合計To年度データ(年度普通徴収データ, 期別合計リスト, ChoshuHohoKibetsu.普通徴収.code());
        add段階合計To年度データ(年度特別徴収データ, 段階合計リスト, ChoshuHohoKibetsu.特別徴収.code());
        add段階合計To年度データ(年度普通徴収データ, 段階合計リスト, ChoshuHohoKibetsu.普通徴収.code());
        年度データリスト.add(年度特別徴収データ);
        年度データリスト.add(年度普通徴収データ);
        return 年度データリスト;
    }

    private void add段階合計To年度データ(
            NendoDataEntity 年度データ,
            List<DankaiGokeiEntity> 段階合計リスト,
            RString 徴収方法) {
        if (null == 徴収方法 || null == 年度データ || null == 段階合計リスト) {
            return;
        }

        for (DankaiGokeiEntity 段階合計 : 段階合計リスト) {
            if (null == 段階合計.getChoshuHouhou() || 徴収方法.equals(段階合計.getChoshuHouhou())) {
                continue;
            }
            if (当月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set当月末の全部件数の合計(段階合計.getDogetsusueKensuCount());
                年度データ.set当月末の全部調定額の合計(段階合計.getDogetsusueChoteigakuCount());
                年度データ.set当月末の全部件数の合計(段階合計.getDogetsusueKensuCount());
                年度データ.set当月末の全部調定額の合計(段階合計.getDogetsusueChoteigakuCount());
            } else if (前月フラグ == 段階合計.getDogetsuFlag()) {
                年度データ.set前月末の全部件数の合計(段階合計.getZengetsusueKensuCount());
                年度データ.set前月末の全部調定額の合計(段階合計.getZengetsusueChoteigakuCount());
                年度データ.set前月末の全部件数の合計(段階合計.getZengetsusueKensuCount());
                年度データ.set前月末の全部調定額の合計(段階合計.getZengetsusueChoteigakuCount());
            }
            年度データ.set増の全部件数の合計(段階合計.getFueZennbuKennsuuGokei());
            年度データ.set増の全部調定額の合計(段階合計.getFueZennbuChoteigakuGokei());
            年度データ.set減の全部件数の合計(段階合計.getGenZennbuKennsuuGokei());
            年度データ.set減の全部調定額の合計(段階合計.getGenZennbuChoteigakuGokei());
            年度データ.set内併徴者数の合計(段階合計.getNaiheisyaKensuCount());
            if (ChoshuHohoKibetsu.特別徴収.code().equals(段階合計.getChoshuHouhou())) {
                年度データ.set特徴者数の合計(段階合計.getTokuchosyaKensuCount());
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(段階合計.getChoshuHouhou())) {
                年度データ.set普徴者数の合計(段階合計.getFuchosyaKensuCount());
            }
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
                    && ChoshuHohoKibetsu.特別徴収.code().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set特別徴収の調定額の合計(期別合計.getTobetsuChoteigakuCount());
                年度データ.set特徴歳出還付の件数(期別合計.getTkSaishutsuKampuCount());
                年度データ.set特徴歳出還付の調定額(期別合計.getTkSaishutsuKampuChoteigaku());
            } else if (null != 期別合計.getChoshuHouhou()
                    && ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法)
                    && 徴収方法.equals(期別合計.getChoshuHouhou())) {
                年度データ.set普通徴収の調定額の合計(期別合計.getFutsuChoteigakuCount());
                年度データ.set普徴歳出還付の件数(期別合計.getFutsuChoteigakuCount());
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
            if (null != 段階小計.getChoshuHouhou() && 徴収方法.equals(段階小計.getChoshuHouhou())) {
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
