/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021021;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.shunyu.ShunoDataKubun;
import jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran.ShotokuDankaiBetsuShunoritsuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran.ShotokuDankaiBetsuShunoritsuIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dankaibetsushunoritsu.PrtDankaibetsuShunoritsuIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu.ShotokuDankaiBetsuShunoritsuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料段階別収納率一覧表の発行
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
public class PrtDankaibetsuShunoritsuIchiranhyoProcess
        extends BatchKeyBreakBase<DankaibetsuShunoritsuTempEntity> {

    private static final RString MYBATIS_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dankaibetsushunoritsu."
                    + "IDankaibetsuShunoritsuMapper.select保険料段階別収納率一覧表");
    private static final RString EUCファイル名 = new RString("DankaibetsuShunoritsuIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB300003");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_0 = 0;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString RSTRING_0 = new RString("0.00");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString 抽出条件_１号被保険者すべて = new RString("1");
    private static final RString 抽出条件_認定者のみ = new RString("2");
    private static final RString 抽出条件_受給者のみ = new RString("3");
    private static final RString 抽出条件_認定者を除く１号被保険者 = new RString("4");
    private static final RString 調定年度 = new RString("調定年度");
    private static final RString 賦課年度 = new RString("賦課年度");
    private static final RString 科目コード = new RString("科目コード");
    private static final RString 構成市町村コード = new RString("構成市町村コード");
    private static final RString 収納区分 = new RString("収納データ区分");
    private static final RString FORMAT_TYPE = new RString("0.00");
    private static final RString TEXT_中括弧_左 = new RString("【");
    private static final RString TEXT_中括弧_右 = new RString("】");
    private static final RString TEXT_抽出年度 = new RString("抽出年度");
    private static final RString TEXT_調定年度 = new RString("　・調定年度　");
    private static final RString TEXT_カラ = new RString("　～　");
    private static final RString TEXT_調定基準年月 = new RString("調定基準年月");
    private static final RString TEXT_１号被保険者すべて = new RString("１号被保険者すべて");
    private static final RString TEXT_認定者のみ = new RString("認定者のみ");
    private static final RString TEXT_受給者のみ = new RString("受給者のみ（サービス受給者）");
    private static final RString TEXT_認定者を除く１号被保険者 = new RString("認定者を除く１号被保険者");
    private static final RString TEXT_年齢 = new RString("年齢");
    private static final RString TEXT_年齢基準日 = new RString("年齢基準日");
    private static final RString TEXT_生年月日 = new RString("生年月日");
    private static final RString TEXT_市町村 = new RString("市町村");
    private static final RString TEXT_旧市町村 = new RString("旧市町村");
    private static final RString TEXT_選択対象 = new RString("選択対象");
    private static final RString TEXT_選択対象_空白 = new RString("　　　　　　　　　");
    private static final RString TEXT_全角空白 = new RString("　");
    private static final RString TEXT_収納区分 = new RString("収納区分");
    private static final RString TEXT_完納分を出力する = new RString("完納分を出力する");
    private static final RString TEXT_未納分を出力する = new RString("未納分を出力する");
    private static final RString 未納分 = new RString("0");
    private static final RString 完納分 = new RString("1");
    private static final RString 保険料段階の小計 = new RString("**");
    private static final Decimal 負数_1 = new Decimal(-1);
    private static final Decimal NUM_100 = new Decimal(100);
    private static final RString 斜線 = new RString("/");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 特別徴収 = new RString("（特別徴収）");
    private static final RString TEXT_過年度 = new RString("*過年度*");
    private static final RString TEXT_現年度 = new RString("*現年度*");
    private static final RString TEXT_次年度 = new RString("*次年度*");
    private static final RString TEXT_合計 = new RString("*合 計*");
    private static final RString TEXT_総過年度 = new RString("*総過年度*");
    private static final RString TEXT_総現年度 = new RString("*総現年度*");
    private static final RString TEXT_総次年度 = new RString("*総次年度*");
    private static final RString TEXT_総合計 = new RString("*総 合 計*");
    private static final RString TEXT_完納分 = new RString("（完納分）");
    private static final RString TEXT_普通徴収 = new RString("（普通徴収）");
    private static final RString TEXT_特別徴収 = new RString("（特別徴収）");
    private static final RString TEXT_普通徴収_完納分 = new RString("（普通徴収　完納分）");
    private static final RString TEXT_特別徴収_完納分 = new RString("（特別徴収　完納分）");
    private static final RString 該当データ無し = new RString("「該当データ無し」");

    private PrtDankaibetsuShunoritsuIchiranhyoParameter parameter;

    private Decimal 小計_調定額;
    private int 小計_調定件数;
    private Decimal 小計_不納欠損額;
    private int 小計_不納欠損件数;
    private Decimal 小計_収入額;
    private int 小計_収入件数;
    private Decimal 小計_還付額;
    private int 小計_還付件数;
    private Decimal 小計_充当額負;
    private int 小計_充当額負件数;
    private Decimal 小計_充当額;
    private int 小計_充当額件数;
    private Decimal 合計_過年度_調定額;
    private int 合計_過年度_調定件数;
    private Decimal 合計_過年度_不納欠損額;
    private int 合計_過年度_不納欠損件数;
    private Decimal 合計_過年度_収入額;
    private int 合計_過年度_収入件数;
    private Decimal 合計_過年度_還付額;
    private int 合計_過年度_還付件数;
    private Decimal 合計_過年度_充当額負;
    private int 合計_過年度_充当額負件数;
    private Decimal 合計_過年度_充当額;
    private int 合計_過年度_充当額件数;
    private Decimal 合計_現年度_調定額;
    private int 合計_現年度_調定件数;
    private Decimal 合計_現年度_不納欠損額;
    private int 合計_現年度_不納欠損件数;
    private Decimal 合計_現年度_収入額;
    private int 合計_現年度_収入件数;
    private Decimal 合計_現年度_還付額;
    private int 合計_現年度_還付件数;
    private Decimal 合計_現年度_充当額負;
    private int 合計_現年度_充当額負件数;
    private Decimal 合計_現年度_充当額;
    private int 合計_現年度_充当額件数;
    private Decimal 合計_次年度_調定額;
    private int 合計_次年度_調定件数;
    private Decimal 合計_次年度_不納欠損額;
    private int 合計_次年度_不納欠損件数;
    private Decimal 合計_次年度_収入額;
    private int 合計_次年度_収入件数;
    private Decimal 合計_次年度_還付額;
    private int 合計_次年度_還付件数;
    private Decimal 合計_次年度_充当額負;
    private int 合計_次年度_充当額負件数;
    private Decimal 合計_次年度_充当額;
    private int 合計_次年度_充当額件数;
    private Decimal 総合計_過年度_調定額;
    private int 総合計_過年度_調定件数;
    private Decimal 総合計_過年度_不納欠損額;
    private int 総合計_過年度_不納欠損件数;
    private Decimal 総合計_過年度_収入額;
    private int 総合計_過年度_収入件数;
    private Decimal 総合計_過年度_還付額;
    private int 総合計_過年度_還付件数;
    private Decimal 総合計_過年度_充当額負;
    private int 総合計_過年度_充当額負件数;
    private Decimal 総合計_過年度_充当額;
    private int 総合計_過年度_充当額件数;
    private Decimal 総合計_現年度_調定額;
    private int 総合計_現年度_調定件数;
    private Decimal 総合計_現年度_不納欠損額;
    private int 総合計_現年度_不納欠損件数;
    private Decimal 総合計_現年度_収入額;
    private int 総合計_現年度_収入件数;
    private Decimal 総合計_現年度_還付額;
    private int 総合計_現年度_還付件数;
    private Decimal 総合計_現年度_充当額負;
    private int 総合計_現年度_充当額負件数;
    private Decimal 総合計_現年度_充当額;
    private int 総合計_現年度_充当額件数;
    private Decimal 総合計_次年度_調定額;
    private int 総合計_次年度_調定件数;
    private Decimal 総合計_次年度_不納欠損額;
    private int 総合計_次年度_不納欠損件数;
    private Decimal 総合計_次年度_収入額;
    private int 総合計_次年度_収入件数;
    private Decimal 総合計_次年度_還付額;
    private int 総合計_次年度_還付件数;
    private Decimal 総合計_次年度_充当額負;
    private int 総合計_次年度_充当額負件数;
    private Decimal 総合計_次年度_充当額;
    private int 総合計_次年度_充当額件数;
    private List<RString> 改頁List;
    private FileSpoolManager manager;
    private ShunoKamokuFinder shunoKamokuManager;
    private IAssociationFinder finder;
    private RString spoolWorkPath;
    private RString eucFilePath;
    private RString 帳票タイトル;
    private RString before帳票タイトル;
    private RString 最終頁帳票タイトル;
    private RString 市町村コード;
    private RString 市町村名称;
    private DankaibetsuShunoritsuTempEntity lastEntity;
    private BatchReportWriter<ShotokuDankaiBetsuShunoritsuIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<ShotokuDankaiBetsuShunoritsuIchiranSource> reportSourceWriter_一覧表;
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        改頁List = new ArrayList<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        shunoKamokuManager = ShunoKamokuFinder.createInstance();
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        clear小計();
        clear合計();
        clear総合計();
        帳票タイトル = RString.EMPTY;
        before帳票タイトル = RString.EMPTY;
        最終頁帳票タイトル = RString.EMPTY;
        市町村コード = RString.EMPTY;
        市町村名称 = RString.EMPTY;
        lastEntity = null;
    }

    @Override
    protected void beforeExecute() {
        get改頁List();
        finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        市町村名称 = association.get市町村名();
        if (association.get地方公共団体コード() != null) {
            市町村コード = association.get地方公共団体コード().value();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        PageBreaker<ShotokuDankaiBetsuShunoritsuIchiranSource> breaker
                = new ShotokuDankaiBetsuShunoritsuIchiranPageBreak(改頁List);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB300003.getReportId().value(), SubGyomuCode.DBB介護賦課).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void keyBreakProcess(DankaibetsuShunoritsuTempEntity entity) {
    }

    @Override
    protected void usualProcess(DankaibetsuShunoritsuTempEntity entity) {
        DankaibetsuShunoritsuTempEntity beforeEntity = getBefore();
        if (beforeEntity == null) {
            beforeEntity = entity;
        }
        if (!entity.getKannnouKunbun().equals(beforeEntity.getKannnouKunbun())) {
            prt小計合計();
            prt総合計();
            clear小計();
            clear合計();
            clear総合計();
            beforeEntity = entity;
        }
        boolean is科目コード改頁 = new ShotokuDankaiBetsuShunoritsuIchiranPageBreak(改頁List).
                is科目コード改頁(entity, beforeEntity);
        boolean is市町村コード改頁 = new ShotokuDankaiBetsuShunoritsuIchiranPageBreak(改頁List).
                is市町村コード改頁(entity, beforeEntity);
        if (is市町村コード改頁) {
            if (未納分.equals(entity.getKannnouKunbun())) {
                帳票タイトル = RString.EMPTY;
                最終頁帳票タイトル = RString.EMPTY;
            } else if (完納分.equals(entity.getKannnouKunbun())) {
                帳票タイトル = TEXT_完納分;
                最終頁帳票タイトル = TEXT_完納分;
            }
        } else {
            if (未納分.equals(entity.getKannnouKunbun())) {
                帳票タイトル = get徴収方法(entity.getKamokuCode());
                最終頁帳票タイトル = RString.EMPTY;
            } else if (完納分.equals(entity.getKannnouKunbun())) {
                帳票タイトル = get完納分徴収方法(entity.getKamokuCode());
                最終頁帳票タイトル = TEXT_完納分;
            }
        }
        if (beforeEntity.getChoteiNendo().equals(entity.getChoteiNendo())
                && beforeEntity.getFukaNendo().equals(entity.getFukaNendo())
                && beforeEntity.getKibetsu() == entity.getKibetsu()
                && beforeEntity.getHokenryoDankai().equals(entity.getHokenryoDankai())
                && beforeEntity.getKamokuCode().equals(entity.getKamokuCode())
                && !is市町村コード改頁) {
            get小計集計(entity);
        } else {
            DankaibetsuShunoritsuIchiran 険料段階別収納率通知書集計Data
                    = get険料段階別収納率通知書小計集計パラメータ(beforeEntity);
            険料段階別収納率通知書集計Data.set保険料段階(保険料段階の小計);
            険料段階別収納率通知書集計Data.set年度(RString.EMPTY);
            ShotokuDankaiBetsuShunoritsuIchiranReport 通知書集計report
                    = new ShotokuDankaiBetsuShunoritsuIchiranReport(険料段階別収納率通知書集計Data);
            通知書集計report.writeBy(reportSourceWriter_一覧表);
            csvListWriter.writeLine(getCSVData(険料段階別収納率通知書集計Data, beforeEntity));
            clear小計();
            get小計集計(entity);
        }
        if (is科目コード改頁 || is市町村コード改頁) {
            List<DankaibetsuShunoritsuIchiran> 年度分険料段階別収納率通知書リスト
                    = get年度分険料段階別収納率通知書パラメータ(beforeEntity);
            for (DankaibetsuShunoritsuIchiran data : 年度分険料段階別収納率通知書リスト) {
                ShotokuDankaiBetsuShunoritsuIchiranReport 通知書report
                        = new ShotokuDankaiBetsuShunoritsuIchiranReport(data);
                通知書report.writeBy(reportSourceWriter_一覧表);
            }
            clear合計();
        }
        if (is市町村コード改頁) {
            prt総合計();
            clear総合計();
        }
        get合計集計(entity);
        DankaibetsuShunoritsuIchiran 険料段階別収納率通知書Data = get険料段階別収納率通知書パラメータ(entity);
        ShotokuDankaiBetsuShunoritsuIchiranReport 通知書report
                = new ShotokuDankaiBetsuShunoritsuIchiranReport(険料段階別収納率通知書Data);
        get総合計集計(entity);
        通知書report.writeBy(reportSourceWriter_一覧表);
        before帳票タイトル = 帳票タイトル;
        lastEntity = entity;
    }

    @Override
    protected void afterExecute() {
        if (lastEntity == null) {
            DankaibetsuShunoritsuIchiran 険料段階別収納率通知書集計Data = new DankaibetsuShunoritsuIchiran();
            険料段階別収納率通知書集計Data.set年度(該当データ無し);
            ShotokuDankaiBetsuShunoritsuIchiranReport 通知書report
                    = new ShotokuDankaiBetsuShunoritsuIchiranReport(険料段階別収納率通知書集計Data);
            通知書report.writeBy(reportSourceWriter_一覧表);
            csvListWriter.close();
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
            batchReportWriter_一覧表.close();
            return;
        }
        prt小計合計();
        prt総合計();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB300003.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB300003.getReportName(),
                new RString(reportSourceWriter_一覧表.pageCount().value()),
                CSV出力有無,
                RString.EMPTY,
                get出力条件表の作成());
        OutputJokenhyoFactory.createInstance(item).print();
        csvListWriter.close();
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        batchReportWriter_一覧表.close();
    }

    private void prt小計合計() {
        DankaibetsuShunoritsuIchiran 険料段階別収納率通知書集計Data
                = get険料段階別収納率通知書小計集計パラメータ(lastEntity);
        険料段階別収納率通知書集計Data.set保険料段階(保険料段階の小計);
        険料段階別収納率通知書集計Data.set年度(RString.EMPTY);
        ShotokuDankaiBetsuShunoritsuIchiranReport 通知書集計report
                = new ShotokuDankaiBetsuShunoritsuIchiranReport(険料段階別収納率通知書集計Data);
        通知書集計report.writeBy(reportSourceWriter_一覧表);
        csvListWriter.writeLine(getCSVData(険料段階別収納率通知書集計Data, lastEntity));

        List<DankaibetsuShunoritsuIchiran> 年度分険料段階別収納率通知書リスト
                = get年度分険料段階別収納率通知書パラメータ(lastEntity);
        for (DankaibetsuShunoritsuIchiran data : 年度分険料段階別収納率通知書リスト) {
            ShotokuDankaiBetsuShunoritsuIchiranReport 通知書report
                    = new ShotokuDankaiBetsuShunoritsuIchiranReport(data);
            通知書report.writeBy(reportSourceWriter_一覧表);
        }
    }

    private void prt総合計() {
        List<DankaibetsuShunoritsuIchiran> 総年度分険料段階別収納率通知書リスト
                = get総年度分険料段階別収納率通知書パラメータ(lastEntity);
        for (DankaibetsuShunoritsuIchiran data : 総年度分険料段階別収納率通知書リスト) {
            ShotokuDankaiBetsuShunoritsuIchiranReport 通知書report
                    = new ShotokuDankaiBetsuShunoritsuIchiranReport(data);
            通知書report.writeBy(reportSourceWriter_一覧表);
        }
    }

    private void get改頁List() {
        改頁List.add(調定年度);
        改頁List.add(賦課年度);
        改頁List.add(科目コード);
        改頁List.add(構成市町村コード);
        改頁List.add(収納区分);
    }

    private RString get百分率で表示(double num) {
        DecimalFormat df = new DecimalFormat(FORMAT_TYPE.toString());
        return new RString(df.format(num));
    }

    private List<RString> get出力条件表の作成() {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder 抽出年度Builder = new RStringBuilder();
        抽出年度Builder.append(TEXT_調定年度);
        抽出年度Builder.append(parameter.get開始調定年度().wareki().toDateString());
        抽出年度Builder.append(TEXT_カラ);
        抽出年度Builder.append(parameter.get終了調定年度().wareki().toDateString());
        抽出年度Builder.append(TEXT_調定年度);
        抽出年度Builder.append(parameter.get開始賦課年度().wareki().toDateString());
        抽出年度Builder.append(TEXT_カラ);
        抽出年度Builder.append(parameter.get終了賦課年度().wareki().toDateString());
        出力条件リスト.add(get条件(TEXT_抽出年度, 抽出年度Builder.toRString()));
        出力条件リスト.add(get条件(TEXT_調定基準年月, parameter.get調定基準年月().wareki().toDateString()));
        RString 抽出条件 = RString.EMPTY;
        if (抽出条件_１号被保険者すべて.equals(parameter.get抽出条件())) {
            抽出条件 = TEXT_１号被保険者すべて;
        } else if (抽出条件_認定者のみ.equals(parameter.get抽出条件())) {
            抽出条件 = TEXT_認定者のみ;
        } else if (抽出条件_受給者のみ.equals(parameter.get抽出条件())) {
            抽出条件 = TEXT_受給者のみ;
        } else if (抽出条件_認定者を除く１号被保険者.equals(parameter.get抽出条件())) {
            抽出条件 = TEXT_認定者を除く１号被保険者;
        }
        出力条件リスト.add(get条件(TEXT_抽出年度, 抽出条件));
        RStringBuilder 年齢Builder = new RStringBuilder();
        if (parameter.get開始年齢() != INT_0
                || parameter.get終了年齢() != INT_0) {
            if (parameter.get開始年齢() != INT_0) {
                年齢Builder.append(parameter.get開始年齢());
            }
            年齢Builder.append(TEXT_カラ);
            if (parameter.get終了年齢() != INT_0) {
                年齢Builder.append(parameter.get終了年齢());
            }
        }
        出力条件リスト.add(get条件(TEXT_年齢, 年齢Builder.toRString()));
        if (parameter.get年齢基準日() != null && !parameter.get年齢基準日().isEmpty()) {
            出力条件リスト.add(get条件(TEXT_年齢基準日, parameter.get年齢基準日().wareki().toDateString()));
        }
        RStringBuilder 生年月日Builder = new RStringBuilder();
        if (parameter.get開始生年月日() != null
                || parameter.get終了生年月日() != null) {
            if (parameter.get開始生年月日() != null) {
                生年月日Builder.append(parameter.get開始生年月日().wareki().toDateString());
            }
            生年月日Builder.append(TEXT_カラ);
            if (parameter.get終了生年月日() != null) {
                生年月日Builder.append(parameter.get終了生年月日().wareki().toDateString());
            }
        }
        出力条件リスト.add(get条件(TEXT_生年月日, 生年月日Builder.toRString()));
        get出力条件表市町村の作成(出力条件リスト);
        if (ZERO.equals(parameter.get完納出力区分().get(INT_0))) {
            出力条件リスト.add(get条件(TEXT_収納区分, TEXT_完納分を出力する));
        } else if (ONE.equals(parameter.get完納出力区分().get(INT_0))) {
            出力条件リスト.add(get条件(TEXT_収納区分, TEXT_未納分を出力する));
        }
        return 出力条件リスト;
    }

    private void get出力条件表市町村の作成(List<RString> 出力条件リスト) {
        if (DonyuKeitaiCode.toValue(parameter.get広域判定区分()).is広域()) {
            RStringBuilder 市町村情報Builder = new RStringBuilder();
            市町村情報Builder.append(parameter.get市町村情報());
            市町村情報Builder.append(TEXT_全角空白);
            市町村情報Builder.append(parameter.get市町村情報名称());
            出力条件リスト.add(get条件(TEXT_市町村, 市町村情報Builder.toRString()));
            if (parameter.get旧市町村情報() != null && !parameter.get旧市町村情報().isEmpty()) {
                RStringBuilder 旧市町村情報Builder = new RStringBuilder();
                旧市町村情報Builder.append(parameter.get旧市町村情報());
                旧市町村情報Builder.append(TEXT_全角空白);
                旧市町村情報Builder.append(parameter.get旧市町村情報名称());
                出力条件リスト.add(get条件(TEXT_旧市町村, 市町村情報Builder.toRString()));
            }
        }
        if (DonyuKeitaiCode.toValue(parameter.get広域判定区分()).is単一()
                && !RString.isNullOrEmpty(parameter.get選択対象区分())
                && !parameter.get選択対象リスト().entrySet().isEmpty()) {
            boolean is１件目 = Boolean.TRUE;
            for (Map.Entry<RString, RString> 選択対象 : parameter.get選択対象リスト().entrySet()) {
                if (is１件目) {
                    RStringBuilder 選択対象Builder = new RStringBuilder();
                    選択対象Builder.append(選択対象.getKey());
                    選択対象Builder.append(TEXT_全角空白);
                    選択対象Builder.append(選択対象.getValue());
                    出力条件リスト.add(get条件(TEXT_選択対象, 選択対象Builder.toRString()));
                    is１件目 = Boolean.FALSE;
                } else {
                    RStringBuilder 選択対象Builder = new RStringBuilder();
                    選択対象Builder.append(TEXT_選択対象_空白);
                    選択対象Builder.append(選択対象.getKey());
                    選択対象Builder.append(TEXT_全角空白);
                    選択対象Builder.append(選択対象.getValue());
                    出力条件リスト.add(選択対象Builder.toRString());
                }
            }
        }
    }

    private RString get条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(TEXT_中括弧_左);
        条件.append(バッチパラメータ名);
        条件.append(TEXT_中括弧_右);
        条件.append(値);
        return 条件.toRString();
    }

    private DankaibetsuShunoritsuIchiran get険料段階別収納率通知書パラメータ(
            DankaibetsuShunoritsuTempEntity entity) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 調定額 = Decimal.ZERO;
        int 調定件数 = INT_0;
        Decimal 不納欠損額 = Decimal.ZERO;
        int 不納欠損件数 = INT_0;
        Decimal 収入額 = Decimal.ZERO;
        int 収入件数 = INT_0;
        Decimal 還付額 = Decimal.ZERO;
        int 還付件数 = INT_0;
        Decimal 充当額負 = Decimal.ZERO;
        int 充当額負件数 = INT_0;
        Decimal 充当額 = Decimal.ZERO;
        int 充当額件数 = INT_0;
        int 収納データ区分 = Integer.parseInt(entity.getShunoDataKubun().toString());
        if (収納データ区分 < Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            調定額 = 調定額.add(entity.getChoteigaku());
            調定件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            収入額 = 収入額.add(entity.getShunyugaku());
            収入件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当元.value().toString())) {
            充当額負 = 充当額負.add(entity.getShunyugaku().multiply(負数_1));
            充当額負件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当先.value().toString())) {
            充当額 = 充当額.add(entity.getShunyugaku());
            充当額件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.還付.value().toString())) {
            還付額 = 還付額.add(entity.getShunyugaku().multiply(負数_1));
            還付件数++;
        }
        if (Decimal.ZERO.compareTo(entity.getFunougaku()) < 0) {
            不納欠損額 = 不納欠損額.add(entity.getFunougaku());
            不納欠損件数++;
        }
        Decimal 未納額 = 調定額.subtract(収入額.subtract(還付額).add(充当額).subtract(充当額負)).subtract(不納欠損額);
        RString 収納率 = Decimal.ZERO.equals(調定額.subtract(不納欠損額)) ? get百分率で表示(0L)
                : get百分率で表示((収入額.subtract(還付額).add(充当額).subtract(充当額負)).
                        divide(調定額.subtract(不納欠損額)).
                        multiply(NUM_100).doubleValue());
        data.set年度(entity.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(entity.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(entity.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(entity.getFukaNendo().wareki().toDateString()));
        data.set期(entity.getKibetsu());
        data.set保険料段階(entity.getHokenryoDankai());
        data.set調定額_件数(調定件数);
        data.set調定額(調定額);
        data.set収入額_件数(収入件数);
        data.set収入額(収入額);
        data.set未納額(未納額);
        data.set還付額_件数(還付件数);
        data.set還付額(還付額);
        data.set充当額負_件数(充当額負件数);
        data.set充当額負(充当額負);
        data.set充当額_件数(充当額件数);
        data.set充当額(充当額);
        data.set不納欠損額_件数(不納欠損件数);
        data.set不納欠損額(不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(entity.getLasdecCode());
        data.set市町村名(finder.getAssociation(entity.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(帳票タイトル);
        data.set科目コード(entity.getKamokuCode());
        data.setHdn年度(entity.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(entity.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get険料段階別収納率通知書小計集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 小計_調定額.subtract(小計_収入額.subtract(小計_還付額).add(小計_充当額).
                subtract(小計_充当額負)).subtract(小計_不納欠損額);
        RString 収納率 = Decimal.ZERO.equals(小計_調定額.subtract(小計_不納欠損額)) ? get百分率で表示(0L)
                : get百分率で表示((小計_収入額.subtract(小計_還付額).add(小計_充当額).subtract(小計_充当額負)).
                        divide(小計_調定額.subtract(小計_不納欠損額)).
                        multiply(NUM_100).doubleValue());
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(小計_調定件数);
        data.set調定額(小計_調定額);
        data.set収入額_件数(小計_収入件数);
        data.set収入額(小計_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(小計_還付件数);
        data.set還付額(小計_還付額);
        data.set充当額負_件数(小計_充当額負件数);
        data.set充当額負(小計_充当額負);
        data.set充当額_件数(小計_充当額件数);
        data.set充当額(小計_充当額);
        data.set不納欠損額_件数(小計_不納欠損件数);
        data.set不納欠損額(小計_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(before帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private List<DankaibetsuShunoritsuIchiran> get年度分険料段階別収納率通知書パラメータ(
            DankaibetsuShunoritsuTempEntity entity) {
        List<DankaibetsuShunoritsuIchiran> list = new ArrayList<>();
        DankaibetsuShunoritsuIchiran 過年度集計 = get過年度集計パラメータ(entity);
        過年度集計.set年度(TEXT_過年度);
        list.add(過年度集計);
        DankaibetsuShunoritsuIchiran 現年度集計 = get現年度集計パラメータ(entity);
        現年度集計.set年度(TEXT_現年度);
        list.add(現年度集計);
        DankaibetsuShunoritsuIchiran 次年度集計 = get次年度集計パラメータ(entity);
        次年度集計.set年度(TEXT_次年度);
        list.add(次年度集計);
        DankaibetsuShunoritsuIchiran 合計 = get合計集計パラメータ(entity);
        合計.set年度(TEXT_合計);
        list.add(合計);
        return list;
    }

    private DankaibetsuShunoritsuIchiran get過年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 合計_過年度_調定額.subtract(合計_過年度_収入額.subtract(合計_過年度_還付額).
                add(合計_過年度_充当額).subtract(合計_過年度_充当額負)).subtract(合計_過年度_不納欠損額);
        RString 収納率;
        if (合計_過年度_調定額.subtract(合計_過年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(合計_過年度_調定額.subtract(合計_過年度_不納欠損額)) ? get百分率で表示(0L)
                    : get百分率で表示((合計_過年度_収入額.subtract(合計_過年度_還付額).add(合計_過年度_充当額).
                            subtract(合計_過年度_充当額負)).divide(合計_過年度_調定額.subtract(合計_過年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(合計_過年度_調定件数);
        data.set調定額(合計_過年度_調定額);
        data.set収入額_件数(合計_過年度_収入件数);
        data.set収入額(合計_過年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(合計_過年度_還付件数);
        data.set還付額(合計_過年度_還付額);
        data.set充当額負_件数(合計_過年度_充当額負件数);
        data.set充当額負(合計_過年度_充当額負);
        data.set充当額_件数(合計_過年度_充当額件数);
        data.set充当額(合計_過年度_充当額);
        data.set不納欠損額_件数(合計_過年度_不納欠損件数);
        data.set不納欠損額(合計_過年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(before帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get現年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 合計_現年度_調定額.subtract(合計_現年度_収入額.subtract(合計_現年度_還付額).
                add(合計_現年度_充当額).subtract(合計_現年度_充当額負)).subtract(合計_現年度_不納欠損額);
        RString 収納率;
        if (合計_現年度_調定額.subtract(合計_現年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(合計_現年度_調定額.subtract(合計_現年度_不納欠損額)) ? get百分率で表示(0L)
                    : get百分率で表示((合計_現年度_収入額.subtract(合計_現年度_還付額).add(合計_現年度_充当額).
                            subtract(合計_現年度_充当額負)).divide(合計_現年度_調定額.subtract(合計_現年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(合計_現年度_調定件数);
        data.set調定額(合計_現年度_調定額);
        data.set収入額_件数(合計_現年度_収入件数);
        data.set収入額(合計_現年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(合計_現年度_還付件数);
        data.set還付額(合計_現年度_還付額);
        data.set充当額負_件数(合計_現年度_充当額負件数);
        data.set充当額負(合計_現年度_充当額負);
        data.set充当額_件数(合計_現年度_充当額件数);
        data.set充当額(合計_現年度_充当額);
        data.set不納欠損額_件数(合計_現年度_不納欠損件数);
        data.set不納欠損額(合計_現年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(before帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get次年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 合計_次年度_調定額.subtract(合計_次年度_収入額.subtract(合計_次年度_還付額).
                add(合計_次年度_充当額).subtract(合計_次年度_充当額負)).subtract(合計_次年度_不納欠損額);
        RString 収納率;
        if (合計_次年度_調定額.subtract(合計_次年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(合計_次年度_調定額.subtract(合計_次年度_不納欠損額)) ? get百分率で表示(0L)
                    : get百分率で表示((合計_次年度_収入額.subtract(合計_次年度_還付額).add(合計_次年度_充当額).
                            subtract(合計_次年度_充当額負)).divide(合計_次年度_調定額.subtract(合計_次年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(合計_次年度_調定件数);
        data.set調定額(合計_次年度_調定額);
        data.set収入額_件数(合計_次年度_収入件数);
        data.set収入額(合計_次年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(合計_次年度_還付件数);
        data.set還付額(合計_次年度_還付額);
        data.set充当額負_件数(合計_次年度_充当額負件数);
        data.set充当額負(合計_次年度_充当額負);
        data.set充当額_件数(合計_次年度_充当額件数);
        data.set充当額(合計_次年度_充当額);
        data.set不納欠損額_件数(合計_次年度_不納欠損件数);
        data.set不納欠損額(合計_次年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(before帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get合計集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 合計_調定額 = 合計_過年度_調定額.add(合計_現年度_調定額).add(合計_次年度_調定額);
        int 合計_調定件数 = 合計_過年度_調定件数 + 合計_現年度_調定件数 + 合計_次年度_調定件数;
        Decimal 合計_不納欠損額 = 合計_過年度_不納欠損額.add(合計_現年度_不納欠損額).add(合計_次年度_不納欠損額);
        int 合計_不納欠損件数 = 合計_過年度_不納欠損件数 + 合計_現年度_不納欠損件数 + 合計_次年度_不納欠損件数;
        Decimal 合計_収入額 = 合計_過年度_収入額.add(合計_現年度_収入額).add(合計_次年度_収入額);
        int 合計_収入件数 = 合計_過年度_収入件数 + 合計_現年度_収入件数 + 合計_次年度_収入件数;
        Decimal 合計_還付額 = 合計_過年度_還付額.add(合計_現年度_還付額).add(合計_次年度_還付額);
        int 合計_還付件数 = 合計_過年度_還付件数 + 合計_現年度_還付件数 + 合計_次年度_還付件数;
        Decimal 合計_充当額負 = 合計_過年度_充当額負.add(合計_現年度_充当額負).add(合計_次年度_充当額負);
        int 合計_充当額負件数 = 合計_過年度_充当額負件数 + 合計_現年度_充当額負件数 + 合計_次年度_充当額負件数;
        Decimal 合計_充当額 = 合計_過年度_充当額.add(合計_現年度_充当額).add(合計_次年度_充当額);
        int 合計_充当額件数 = 合計_過年度_充当額件数 + 合計_現年度_充当額件数 + 合計_次年度_充当額件数;
        Decimal 未納額 = 合計_調定額.subtract(合計_収入額.subtract(合計_還付額).add(合計_充当額).
                subtract(合計_充当額負)).subtract(合計_不納欠損額);
        RString 収納率;
        if (合計_調定額.subtract(合計_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(合計_調定額.subtract(合計_不納欠損額)) ? get百分率で表示(0L)
                    : get百分率で表示((合計_収入額.subtract(合計_還付額).add(合計_充当額).
                            subtract(合計_充当額負)).divide(合計_調定額.subtract(合計_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(合計_調定件数);
        data.set調定額(合計_調定額);
        data.set収入額_件数(合計_収入件数);
        data.set収入額(合計_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(合計_還付件数);
        data.set還付額(合計_還付額);
        data.set充当額負_件数(合計_充当額負件数);
        data.set充当額負(合計_充当額負);
        data.set充当額_件数(合計_充当額件数);
        data.set充当額(合計_充当額);
        data.set不納欠損額_件数(合計_不納欠損件数);
        data.set不納欠損額(合計_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(before帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private List<DankaibetsuShunoritsuIchiran> get総年度分険料段階別収納率通知書パラメータ(
            DankaibetsuShunoritsuTempEntity entity) {
        List<DankaibetsuShunoritsuIchiran> list = new ArrayList<>();
        DankaibetsuShunoritsuIchiran 過年度集計 = get総過年度集計パラメータ(entity);
        過年度集計.set年度(TEXT_総過年度);
        list.add(過年度集計);
        DankaibetsuShunoritsuIchiran 現年度集計 = get総現年度集計パラメータ(entity);
        現年度集計.set年度(TEXT_総現年度);
        list.add(現年度集計);
        DankaibetsuShunoritsuIchiran 次年度集計 = get総次年度集計パラメータ(entity);
        次年度集計.set年度(TEXT_総次年度);
        list.add(次年度集計);
        DankaibetsuShunoritsuIchiran 合計 = get総合計集計パラメータ(entity);
        合計.set年度(TEXT_総合計);
        list.add(合計);
        return list;
    }

    private DankaibetsuShunoritsuIchiran get総過年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 総合計_過年度_調定額.subtract(総合計_過年度_収入額.subtract(総合計_過年度_還付額).
                add(総合計_過年度_充当額).subtract(総合計_過年度_充当額負)).subtract(総合計_過年度_不納欠損額);
        RString 収納率;
        if (総合計_過年度_調定額.subtract(総合計_過年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(総合計_過年度_調定額.subtract(総合計_過年度_不納欠損額))
                    ? get百分率で表示(0L) : get百分率で表示((総合計_過年度_収入額.subtract(総合計_過年度_還付額).add(総合計_過年度_充当額).
                            subtract(総合計_過年度_充当額負)).divide(総合計_過年度_調定額.subtract(総合計_過年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(総合計_過年度_調定件数);
        data.set調定額(総合計_過年度_調定額);
        data.set収入額_件数(総合計_過年度_収入件数);
        data.set収入額(総合計_過年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(総合計_過年度_還付件数);
        data.set還付額(総合計_過年度_還付額);
        data.set充当額負_件数(総合計_過年度_充当額負件数);
        data.set充当額負(総合計_過年度_充当額負);
        data.set充当額_件数(総合計_過年度_充当額件数);
        data.set充当額(総合計_過年度_充当額);
        data.set不納欠損額_件数(総合計_過年度_不納欠損件数);
        data.set不納欠損額(総合計_過年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(最終頁帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get総現年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 総合計_現年度_調定額.subtract(総合計_現年度_収入額.subtract(総合計_現年度_還付額).
                add(総合計_現年度_充当額).subtract(総合計_現年度_充当額負)).subtract(総合計_現年度_不納欠損額);
        RString 収納率;
        if (総合計_現年度_調定額.subtract(総合計_現年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(総合計_現年度_調定額.subtract(総合計_現年度_不納欠損額))
                    ? get百分率で表示(0L) : get百分率で表示((総合計_現年度_収入額.subtract(総合計_現年度_還付額).add(総合計_現年度_充当額).
                            subtract(総合計_現年度_充当額負)).divide(総合計_現年度_調定額.subtract(総合計_現年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(総合計_現年度_調定件数);
        data.set調定額(総合計_現年度_調定額);
        data.set収入額_件数(総合計_現年度_収入件数);
        data.set収入額(総合計_現年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(総合計_現年度_還付件数);
        data.set還付額(総合計_現年度_還付額);
        data.set充当額負_件数(総合計_現年度_充当額負件数);
        data.set充当額負(総合計_現年度_充当額負);
        data.set充当額_件数(総合計_現年度_充当額件数);
        data.set充当額(総合計_現年度_充当額);
        data.set不納欠損額_件数(総合計_現年度_不納欠損件数);
        data.set不納欠損額(総合計_現年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(最終頁帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get総次年度集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 未納額 = 総合計_次年度_調定額.subtract(総合計_次年度_収入額.subtract(総合計_次年度_還付額).
                add(総合計_次年度_充当額).subtract(総合計_次年度_充当額負)).subtract(総合計_次年度_不納欠損額);
        RString 収納率;
        if (総合計_次年度_調定額.subtract(総合計_次年度_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(総合計_次年度_調定額.subtract(総合計_次年度_不納欠損額))
                    ? get百分率で表示(0L) : get百分率で表示((総合計_次年度_収入額.subtract(総合計_次年度_還付額).add(総合計_次年度_充当額).
                            subtract(総合計_次年度_充当額負)).divide(総合計_次年度_調定額.subtract(総合計_次年度_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(総合計_次年度_調定件数);
        data.set調定額(総合計_次年度_調定額);
        data.set収入額_件数(総合計_次年度_収入件数);
        data.set収入額(総合計_次年度_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(総合計_次年度_還付件数);
        data.set還付額(総合計_次年度_還付額);
        data.set充当額負_件数(総合計_次年度_充当額負件数);
        data.set充当額負(総合計_次年度_充当額負);
        data.set充当額_件数(総合計_次年度_充当額件数);
        data.set充当額(総合計_次年度_充当額);
        data.set不納欠損額_件数(総合計_次年度_不納欠損件数);
        data.set不納欠損額(総合計_次年度_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(最終頁帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private DankaibetsuShunoritsuIchiran get総合計集計パラメータ(
            DankaibetsuShunoritsuTempEntity 保険料段階別収納率) {
        DankaibetsuShunoritsuIchiran data = new DankaibetsuShunoritsuIchiran();
        Decimal 総合計_調定額 = 総合計_過年度_調定額.add(総合計_現年度_調定額).add(総合計_次年度_調定額);
        int 総合計_調定件数 = 総合計_過年度_調定件数 + 総合計_現年度_調定件数 + 総合計_次年度_調定件数;
        Decimal 総合計_不納欠損額 = 総合計_過年度_不納欠損額.add(総合計_現年度_不納欠損額).add(総合計_次年度_不納欠損額);
        int 総合計_不納欠損件数 = 総合計_過年度_不納欠損件数 + 総合計_現年度_不納欠損件数 + 総合計_次年度_不納欠損件数;
        Decimal 総合計_収入額 = 総合計_過年度_収入額.add(総合計_現年度_収入額).add(総合計_次年度_収入額);
        int 総合計_収入件数 = 総合計_過年度_収入件数 + 総合計_現年度_収入件数 + 総合計_次年度_収入件数;
        Decimal 総合計_還付額 = 総合計_過年度_還付額.add(総合計_現年度_還付額).add(総合計_次年度_還付額);
        int 総合計_還付件数 = 総合計_過年度_還付件数 + 総合計_現年度_還付件数 + 総合計_次年度_還付件数;
        Decimal 総合計_充当額負 = 総合計_過年度_充当額負.add(総合計_現年度_充当額負).add(総合計_次年度_充当額負);
        int 総合計_充当額負件数 = 総合計_過年度_充当額負件数 + 総合計_現年度_充当額負件数 + 総合計_次年度_充当額負件数;
        Decimal 総合計_充当額 = 総合計_過年度_充当額.add(総合計_現年度_充当額).add(総合計_次年度_充当額);
        int 総合計_充当額件数 = 総合計_過年度_充当額件数 + 総合計_現年度_充当額件数 + 総合計_次年度_充当額件数;
        Decimal 未納額 = 総合計_調定額.subtract(総合計_収入額.subtract(総合計_還付額).add(総合計_充当額).
                subtract(総合計_充当額負)).subtract(総合計_不納欠損額);
        RString 収納率;
        if (総合計_調定額.subtract(総合計_不納欠損額).equals(Decimal.ZERO)) {
            収納率 = RSTRING_0;
        } else {
            収納率 = Decimal.ZERO.equals(総合計_調定額.subtract(総合計_不納欠損額))
                    ? get百分率で表示(0L) : get百分率で表示((総合計_収入額.subtract(総合計_還付額).add(総合計_充当額).
                            subtract(総合計_充当額負)).divide(総合計_調定額.subtract(総合計_不納欠損額)).
                            multiply(NUM_100).doubleValue());
        }
        data.set年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        data.set期(保険料段階別収納率.getKibetsu());
        data.set保険料段階(保険料段階別収納率.getHokenryoDankai());
        data.set調定額_件数(総合計_調定件数);
        data.set調定額(総合計_調定額);
        data.set収入額_件数(総合計_収入件数);
        data.set収入額(総合計_収入額);
        data.set未納額(未納額);
        data.set還付額_件数(総合計_還付件数);
        data.set還付額(総合計_還付額);
        data.set充当額負_件数(総合計_充当額負件数);
        data.set充当額負(総合計_充当額負);
        data.set充当額_件数(総合計_充当額件数);
        data.set充当額(総合計_充当額);
        data.set不納欠損額_件数(総合計_不納欠損件数);
        data.set不納欠損額(総合計_不納欠損額);
        data.set収納率(収納率);
        data.set市町村コード(保険料段階別収納率.getLasdecCode());
        data.set市町村名(finder.getAssociation(保険料段階別収納率.getLasdecCode()).get市町村名());
        data.set被保険者番号(市町村コード);
        data.set被保険者名(市町村名称);
        data.set帳票タイトル(最終頁帳票タイトル);
        data.set科目コード(保険料段階別収納率.getKamokuCode());
        data.setHdn年度(保険料段階別収納率.getChoteiNendo().wareki().toDateString().concat(斜線).
                concat(保険料段階別収納率.getFukaNendo().wareki().toDateString()));
        return data;
    }

    private RString get徴収方法(KamokuCode kamokuCode) {
        IShunoKamoku 普通徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 特別徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (普通徴収科目 != null && kamokuCode.equals(普通徴収科目.getコード())) {
            return TEXT_普通徴収;
        } else if (特別徴収科目 != null && kamokuCode.equals(特別徴収科目.getコード())) {
            return TEXT_特別徴収;
        }
        return RString.EMPTY;
    }

    private RString getCSV徴収方法(KamokuCode kamokuCode) {
        IShunoKamoku 普通徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 特別徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (普通徴収科目 != null && kamokuCode.equals(普通徴収科目.getコード())) {
            return 普通徴収;
        } else if (特別徴収科目 != null && kamokuCode.equals(特別徴収科目.getコード())) {
            return 特別徴収;
        }
        return RString.EMPTY;
    }

    private RString get完納分徴収方法(KamokuCode kamokuCode) {
        IShunoKamoku 普通徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 特別徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (普通徴収科目 != null && kamokuCode.equals(普通徴収科目.getコード())) {
            return TEXT_普通徴収_完納分;
        } else if (特別徴収科目 != null && kamokuCode.equals(特別徴収科目.getコード())) {
            return TEXT_特別徴収_完納分;
        }
        return RString.EMPTY;
    }

    private List<RString> getCSVData(DankaibetsuShunoritsuIchiran data,
            DankaibetsuShunoritsuTempEntity entity) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(entity.getChoteiNendo().toDateString());
        bodyList.add(entity.getFukaNendo().toDateString());
        bodyList.add(new RString(entity.getKibetsu()));
        bodyList.add(entity.getHokenryoDankai());
        bodyList.add(new RString(data.get調定額_件数()));
        bodyList.add(get金額Formatter(data.get調定額()));
        bodyList.add(new RString(data.get収入額_件数()));
        bodyList.add(get金額Formatter(data.get収入額()));
        bodyList.add(get金額Formatter(data.get未納額()));
        bodyList.add(new RString(data.get還付額_件数()));
        bodyList.add(get金額Formatter(data.get還付額()));
        bodyList.add(new RString(data.get充当額負_件数()));
        bodyList.add(get金額Formatter(data.get充当額負()));
        bodyList.add(new RString(data.get充当額_件数()));
        bodyList.add(get金額Formatter(data.get充当額()));
        bodyList.add(new RString(data.get不納欠損額_件数()));
        bodyList.add(get金額Formatter(data.get不納欠損額()));
        bodyList.add(data.get収納率());
        bodyList.add(getCSV徴収方法(data.get科目コード()));
        bodyList.add(data.get市町村コード().getColumnValue());
        return bodyList;
    }

    private RString get金額Formatter(Decimal 金額) {
        return DecimalFormatter.toコンマ区切りRString(金額, INT_0);
    }

    private void clear小計() {
        小計_調定額 = Decimal.ZERO;
        小計_調定件数 = INT_0;
        小計_不納欠損額 = Decimal.ZERO;
        小計_不納欠損件数 = INT_0;
        小計_収入額 = Decimal.ZERO;
        小計_収入件数 = INT_0;
        小計_還付額 = Decimal.ZERO;
        小計_還付件数 = INT_0;
        小計_充当額負 = Decimal.ZERO;
        小計_充当額負件数 = INT_0;
        小計_充当額 = Decimal.ZERO;
        小計_充当額件数 = INT_0;
    }

    private void clear合計() {
        合計_過年度_調定額 = Decimal.ZERO;
        合計_過年度_調定件数 = INT_0;
        合計_過年度_不納欠損額 = Decimal.ZERO;
        合計_過年度_不納欠損件数 = INT_0;
        合計_過年度_収入額 = Decimal.ZERO;
        合計_過年度_収入件数 = INT_0;
        合計_過年度_還付額 = Decimal.ZERO;
        合計_過年度_還付件数 = INT_0;
        合計_過年度_充当額負 = Decimal.ZERO;
        合計_過年度_充当額負件数 = INT_0;
        合計_過年度_充当額 = Decimal.ZERO;
        合計_過年度_充当額件数 = INT_0;
        合計_現年度_調定額 = Decimal.ZERO;
        合計_現年度_調定件数 = INT_0;
        合計_現年度_不納欠損額 = Decimal.ZERO;
        合計_現年度_不納欠損件数 = INT_0;
        合計_現年度_収入額 = Decimal.ZERO;
        合計_現年度_収入件数 = INT_0;
        合計_現年度_還付額 = Decimal.ZERO;
        合計_現年度_還付件数 = INT_0;
        合計_現年度_充当額負 = Decimal.ZERO;
        合計_現年度_充当額負件数 = INT_0;
        合計_現年度_充当額 = Decimal.ZERO;
        合計_現年度_充当額件数 = INT_0;
        合計_次年度_調定額 = Decimal.ZERO;
        合計_次年度_調定件数 = INT_0;
        合計_次年度_不納欠損額 = Decimal.ZERO;
        合計_次年度_不納欠損件数 = INT_0;
        合計_次年度_収入額 = Decimal.ZERO;
        合計_次年度_収入件数 = INT_0;
        合計_次年度_還付額 = Decimal.ZERO;
        合計_次年度_還付件数 = INT_0;
        合計_次年度_充当額負 = Decimal.ZERO;
        合計_次年度_充当額負件数 = INT_0;
        合計_次年度_充当額 = Decimal.ZERO;
        合計_次年度_充当額件数 = INT_0;
    }

    private void clear総合計() {
        総合計_過年度_調定額 = Decimal.ZERO;
        総合計_過年度_調定件数 = INT_0;
        総合計_過年度_不納欠損額 = Decimal.ZERO;
        総合計_過年度_不納欠損件数 = INT_0;
        総合計_過年度_収入額 = Decimal.ZERO;
        総合計_過年度_収入件数 = INT_0;
        総合計_過年度_還付額 = Decimal.ZERO;
        総合計_過年度_還付件数 = INT_0;
        総合計_過年度_充当額負 = Decimal.ZERO;
        総合計_過年度_充当額負件数 = INT_0;
        総合計_過年度_充当額 = Decimal.ZERO;
        総合計_過年度_充当額件数 = INT_0;
        総合計_現年度_調定額 = Decimal.ZERO;
        総合計_現年度_調定件数 = INT_0;
        総合計_現年度_不納欠損額 = Decimal.ZERO;
        総合計_現年度_不納欠損件数 = INT_0;
        総合計_現年度_収入額 = Decimal.ZERO;
        総合計_現年度_収入件数 = INT_0;
        総合計_現年度_還付額 = Decimal.ZERO;
        総合計_現年度_還付件数 = INT_0;
        総合計_現年度_充当額負 = Decimal.ZERO;
        総合計_現年度_充当額負件数 = INT_0;
        総合計_現年度_充当額 = Decimal.ZERO;
        総合計_現年度_充当額件数 = INT_0;
        総合計_次年度_調定額 = Decimal.ZERO;
        総合計_次年度_調定件数 = INT_0;
        総合計_次年度_不納欠損額 = Decimal.ZERO;
        総合計_次年度_不納欠損件数 = INT_0;
        総合計_次年度_収入額 = Decimal.ZERO;
        総合計_次年度_収入件数 = INT_0;
        総合計_次年度_還付額 = Decimal.ZERO;
        総合計_次年度_還付件数 = INT_0;
        総合計_次年度_充当額負 = Decimal.ZERO;
        総合計_次年度_充当額負件数 = INT_0;
        総合計_次年度_充当額 = Decimal.ZERO;
        総合計_次年度_充当額件数 = INT_0;
    }

    private void get小計集計(DankaibetsuShunoritsuTempEntity entity) {
        int 収納データ区分 = Integer.parseInt(entity.getShunoDataKubun().toString());
        if (収納データ区分 < Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            小計_調定額 = 小計_調定額.add(entity.getChoteigaku());
            小計_調定件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            小計_収入額 = 小計_収入額.add(entity.getShunyugaku());
            小計_収入件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当元.value().toString())) {
            小計_充当額負 = 小計_充当額負.add(entity.getShunyugaku().multiply(負数_1));
            小計_充当額負件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当先.value().toString())) {
            小計_充当額 = 小計_充当額.add(entity.getShunyugaku());
            小計_充当額件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.還付.value().toString())) {
            小計_還付額 = 小計_還付額.add(entity.getShunyugaku().multiply(負数_1));
            小計_還付件数++;
        }
        if (Decimal.ZERO.compareTo(entity.getFunougaku()) < 0) {
            小計_不納欠損額 = 小計_不納欠損額.add(entity.getFunougaku());
            小計_不納欠損件数++;
        }
    }

    private void get合計集計(DankaibetsuShunoritsuTempEntity entity) {
        Decimal 調定額 = Decimal.ZERO;
        int 調定件数 = INT_0;
        Decimal 不納欠損額 = Decimal.ZERO;
        int 不納欠損件数 = INT_0;
        Decimal 収入額 = Decimal.ZERO;
        int 収入件数 = INT_0;
        Decimal 還付額 = Decimal.ZERO;
        int 還付件数 = INT_0;
        Decimal 充当額負 = Decimal.ZERO;
        int 充当額負件数 = INT_0;
        Decimal 充当額 = Decimal.ZERO;
        int 充当額件数 = INT_0;
        int 収納データ区分 = Integer.parseInt(entity.getShunoDataKubun().toString());
        if (収納データ区分 < Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            調定額 = 調定額.add(entity.getChoteigaku());
            調定件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            収入額 = 収入額.add(entity.getShunyugaku());
            収入件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当元.value().toString())) {
            充当額負 = 充当額負.add(entity.getShunyugaku().multiply(負数_1));
            充当額負件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当先.value().toString())) {
            充当額 = 充当額.add(entity.getShunyugaku());
            充当額件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.還付.value().toString())) {
            還付額 = 還付額.add(entity.getShunyugaku().multiply(負数_1));
            還付件数++;
        }
        if (Decimal.ZERO.compareTo(entity.getFunougaku()) < 0) {
            不納欠損額 = 不納欠損額.add(entity.getFunougaku());
            不納欠損件数++;
        }
        if (entity.getChoteiNendo().isBefore(entity.getFukaNendo())) {
            合計_過年度_調定額 = 合計_過年度_調定額.add(調定額);
            合計_過年度_調定件数 += 調定件数;
            合計_過年度_不納欠損額 = 合計_過年度_不納欠損額.add(不納欠損額);
            合計_過年度_不納欠損件数 += 不納欠損件数;
            合計_過年度_収入額 = 合計_過年度_収入額.add(収入額);
            合計_過年度_収入件数 += 収入件数;
            合計_過年度_還付額 = 合計_過年度_還付額.add(還付額);
            合計_過年度_還付件数 += 還付件数;
            合計_過年度_充当額負 = 合計_過年度_充当額負.add(充当額負);
            合計_過年度_充当額負件数 += 充当額負件数;
            合計_過年度_充当額 = 合計_過年度_充当額.add(充当額);
            合計_過年度_充当額件数 += 充当額件数;
        } else if (entity.getChoteiNendo().equals(entity.getFukaNendo())) {
            合計_現年度_調定額 = 合計_現年度_調定額.add(調定額);
            合計_現年度_調定件数 += 調定件数;
            合計_現年度_不納欠損額 = 合計_現年度_不納欠損額.add(不納欠損額);
            合計_現年度_不納欠損件数 += 不納欠損件数;
            合計_現年度_収入額 = 合計_現年度_収入額.add(収入額);
            合計_現年度_収入件数 += 収入件数;
            合計_現年度_還付額 = 合計_現年度_還付額.add(還付額);
            合計_現年度_還付件数 += 還付件数;
            合計_現年度_充当額負 = 合計_現年度_充当額負.add(充当額負);
            合計_現年度_充当額負件数 += 充当額負件数;
            合計_現年度_充当額 = 合計_現年度_充当額.add(充当額);
            合計_現年度_充当額件数 += 充当額件数;
        } else {
            合計_次年度_調定額 = 合計_次年度_調定額.add(調定額);
            合計_次年度_調定件数 += 調定件数;
            合計_次年度_不納欠損額 = 合計_次年度_不納欠損額.add(不納欠損額);
            合計_次年度_不納欠損件数 += 不納欠損件数;
            合計_次年度_収入額 = 合計_次年度_収入額.add(収入額);
            合計_次年度_収入件数 += 収入件数;
            合計_次年度_還付額 = 合計_次年度_還付額.add(還付額);
            合計_次年度_還付件数 += 還付件数;
            合計_次年度_充当額負 = 合計_次年度_充当額負.add(充当額負);
            合計_次年度_充当額負件数 += 充当額負件数;
            合計_次年度_充当額 = 合計_次年度_充当額.add(充当額);
            合計_次年度_充当額件数 += 充当額件数;
        }
    }

    private void get総合計集計(DankaibetsuShunoritsuTempEntity entity) {
        Decimal 調定額 = Decimal.ZERO;
        int 調定件数 = INT_0;
        Decimal 不納欠損額 = Decimal.ZERO;
        int 不納欠損件数 = INT_0;
        Decimal 収入額 = Decimal.ZERO;
        int 収入件数 = INT_0;
        Decimal 還付額 = Decimal.ZERO;
        int 還付件数 = INT_0;
        Decimal 充当額負 = Decimal.ZERO;
        int 充当額負件数 = INT_0;
        Decimal 充当額 = Decimal.ZERO;
        int 充当額件数 = INT_0;
        int 収納データ区分 = Integer.parseInt(entity.getShunoDataKubun().toString());
        if (収納データ区分 < Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            調定額 = 調定額.add(entity.getChoteigaku());
            調定件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.納付.value().toString())) {
            収入額 = 収入額.add(entity.getShunyugaku());
            収入件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当元.value().toString())) {
            充当額負 = 充当額負.add(entity.getShunyugaku().multiply(負数_1));
            充当額負件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.充当先.value().toString())) {
            充当額 = 充当額.add(entity.getShunyugaku());
            充当額件数++;
        } else if (収納データ区分 == Integer.parseInt(ShunoDataKubun.還付.value().toString())) {
            還付額 = 還付額.add(entity.getShunyugaku().multiply(負数_1));
            還付件数++;
        }
        if (Decimal.ZERO.compareTo(entity.getFunougaku()) < 0) {
            不納欠損額 = 不納欠損額.add(entity.getFunougaku());
            不納欠損件数++;
        }
        if (entity.getChoteiNendo().isBefore(entity.getFukaNendo())) {
            総合計_過年度_調定額 = 総合計_過年度_調定額.add(調定額);
            総合計_過年度_調定件数 += 調定件数;
            総合計_過年度_不納欠損額 = 総合計_過年度_不納欠損額.add(不納欠損額);
            総合計_過年度_不納欠損件数 += 不納欠損件数;
            総合計_過年度_収入額 = 総合計_過年度_収入額.add(収入額);
            総合計_過年度_収入件数 += 収入件数;
            総合計_過年度_還付額 = 総合計_過年度_還付額.add(還付額);
            総合計_過年度_還付件数 += 還付件数;
            総合計_過年度_充当額負 = 総合計_過年度_充当額負.add(充当額負);
            総合計_過年度_充当額負件数 += 充当額負件数;
            総合計_過年度_充当額 = 総合計_過年度_充当額.add(充当額);
            総合計_過年度_充当額件数 += 充当額件数;
        } else if (entity.getChoteiNendo().equals(entity.getFukaNendo())) {
            総合計_現年度_調定額 = 総合計_現年度_調定額.add(調定額);
            総合計_現年度_調定件数 += 調定件数;
            総合計_現年度_不納欠損額 = 総合計_現年度_不納欠損額.add(不納欠損額);
            総合計_現年度_不納欠損件数 += 不納欠損件数;
            総合計_現年度_収入額 = 総合計_現年度_収入額.add(収入額);
            総合計_現年度_収入件数 += 収入件数;
            総合計_現年度_還付額 = 総合計_現年度_還付額.add(還付額);
            総合計_現年度_還付件数 += 還付件数;
            総合計_現年度_充当額負 = 総合計_現年度_充当額負.add(充当額負);
            総合計_現年度_充当額負件数 += 充当額負件数;
            総合計_現年度_充当額 = 総合計_現年度_充当額.add(充当額);
            総合計_現年度_充当額件数 += 充当額件数;
        } else {
            総合計_次年度_調定額 = 総合計_次年度_調定額.add(調定額);
            総合計_次年度_調定件数 += 調定件数;
            総合計_次年度_不納欠損額 = 総合計_次年度_不納欠損額.add(不納欠損額);
            総合計_次年度_不納欠損件数 += 不納欠損件数;
            総合計_次年度_収入額 = 総合計_次年度_収入額.add(収入額);
            総合計_次年度_収入件数 += 収入件数;
            総合計_次年度_還付額 = 総合計_次年度_還付額.add(還付額);
            総合計_次年度_還付件数 += 還付件数;
            総合計_次年度_充当額負 = 総合計_次年度_充当額負.add(充当額負);
            総合計_次年度_充当額負件数 += 充当額負件数;
            総合計_次年度_充当額 = 総合計_次年度_充当額.add(充当額);
            総合計_次年度_充当額件数 += 充当額件数;
        }
    }
}
