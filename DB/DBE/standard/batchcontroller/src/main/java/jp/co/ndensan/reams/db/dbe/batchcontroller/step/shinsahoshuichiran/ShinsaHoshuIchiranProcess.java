/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsahoshuichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran.ShinsaHoshuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsahoshuichiran.ShinsaHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.IShinsaHoshuIchiranEntityCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
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
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護認定審査会委員報酬一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public class ShinsaHoshuIchiranProcess extends BatchProcessBase<ShinsaHoshuIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID_GOKE = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper.get合計額");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE601005"));
    private static final RString CSV_NAME = new RString("Shinsahoshuichiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString なし = new RString("なし");
    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");
    private ShinsaHoshuIchiranChange change;
    private ShinsaHoshuIchiranProcessParameter paramter;
    private IShinsaHoshuIchiranMapper mapper;
    private List<ShinsaHoshuIchiranRelateEntity> list;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private int 出席回数;
    private static final RString 長 = new RString("長");
    private static final RString 出 = new RString("出");
    private static final RString 副 = new RString("副");
    private static final RString SHUSEKINITI = new RString("出席日（");
    private static final RString GATSU = new RString("月");
    private static final RString KAKO = new RString("）");
    private static final int ZERO = 0;
    private static final int YON = 4;
    private static final int NIJYU = 20;
    private int 初期化フラグ = 0;
    private int 総合計_審査回数;
    private Decimal 総合計_報酬総額;
    private Decimal 総合計_その他費用;
    private Decimal 総合計_税控除額;
    private Decimal 総合計_報酬合計;

    @BatchWriter
    private EucCsvWriter<IShinsaHoshuIchiranEntityCsvEucEntity> eucCsvWriterJunitoJugo;
    @BatchWriter
    private BatchReportWriter<ShinsaHoshuIchiranReportSource> batchWrite;
    private ReportSourceWriter<ShinsaHoshuIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        総合計_審査回数 = 0;
        総合計_報酬総額 = Decimal.ZERO;
        総合計_その他費用 = Decimal.ZERO;
        総合計_税控除額 = Decimal.ZERO;
        総合計_報酬合計 = Decimal.ZERO;
        change = new ShinsaHoshuIchiranChange();
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IShinsaHoshuIchiranMapper.class);
        list = new ArrayList<>();
        list = mapper.get出席状況(paramter.get審査会開催年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_GOKE, paramter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME);
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE601005.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShinsaHoshuIchiranRelateEntity relateEntity) {
        for (ShinsaHoshuIchiranRelateEntity entity : list) {
            if (relateEntity.get合議体番号() == (entity.get合議体番号())
                    && relateEntity.get介護認定審査会委員コード().equals(entity.get介護認定審査会委員コード())) {
                出席回数 = 0;
                relateEntity.set介護認定審査会委員氏名(entity.get介護認定審査会委員氏名());
                relateEntity.set出席状況_1日(entity.get出席状況_1日());
                this.get出席回数(entity.get出席状況_1日());
                relateEntity.set出席状況_2日(entity.get出席状況_2日());
                this.get出席回数(entity.get出席状況_2日());
                relateEntity.set出席状況_3日(entity.get出席状況_3日());
                this.get出席回数(entity.get出席状況_3日());
                relateEntity.set出席状況_4日(entity.get出席状況_4日());
                this.get出席回数(entity.get出席状況_4日());
                relateEntity.set出席状況_5日(entity.get出席状況_5日());
                this.get出席回数(entity.get出席状況_5日());
                relateEntity.set出席状況_6日(entity.get出席状況_6日());
                this.get出席回数(entity.get出席状況_6日());
                relateEntity.set出席状況_7日(entity.get出席状況_7日());
                this.get出席回数(entity.get出席状況_7日());
                relateEntity.set出席状況_8日(entity.get出席状況_8日());
                this.get出席回数(entity.get出席状況_8日());
                relateEntity.set出席状況_9日(entity.get出席状況_9日());
                this.get出席回数(entity.get出席状況_9日());
                relateEntity.set出席状況_10日(entity.get出席状況_10日());
                this.get出席回数(entity.get出席状況_10日());
                relateEntity.set出席状況_11日(entity.get出席状況_11日());
                this.get出席回数(entity.get出席状況_11日());
                relateEntity.set出席状況_12日(entity.get出席状況_12日());
                this.get出席回数(entity.get出席状況_12日());
                relateEntity.set出席状況_13日(entity.get出席状況_13日());
                this.get出席回数(entity.get出席状況_13日());
                relateEntity.set出席状況_14日(entity.get出席状況_14日());
                this.get出席回数(entity.get出席状況_14日());
                relateEntity.set出席状況_15日(entity.get出席状況_15日());
                this.get出席回数(entity.get出席状況_15日());
                relateEntity.set出席状況_16日(entity.get出席状況_16日());
                this.get出席回数(entity.get出席状況_16日());
                relateEntity.set出席状況_17日(entity.get出席状況_17日());
                this.get出席回数(entity.get出席状況_17日());
                relateEntity.set出席状況_18日(entity.get出席状況_18日());
                this.get出席回数(entity.get出席状況_18日());
                relateEntity.set出席状況_19日(entity.get出席状況_19日());
                this.get出席回数(entity.get出席状況_19日());
                relateEntity.set出席状況_20日(entity.get出席状況_20日());
                this.get出席回数(entity.get出席状況_20日());
                relateEntity.set出席状況_21日(entity.get出席状況_21日());
                this.get出席回数(entity.get出席状況_21日());
                relateEntity.set出席状況_22日(entity.get出席状況_22日());
                this.get出席回数(entity.get出席状況_22日());
                relateEntity.set出席状況_23日(entity.get出席状況_23日());
                this.get出席回数(entity.get出席状況_23日());
                relateEntity.set出席状況_24日(entity.get出席状況_24日());
                this.get出席回数(entity.get出席状況_24日());
                relateEntity.set出席状況_25日(entity.get出席状況_25日());
                this.get出席回数(entity.get出席状況_25日());
                relateEntity.set出席状況_26日(entity.get出席状況_26日());
                this.get出席回数(entity.get出席状況_26日());
                relateEntity.set出席状況_27日(entity.get出席状況_27日());
                this.get出席回数(entity.get出席状況_27日());
                relateEntity.set出席状況_28日(entity.get出席状況_28日());
                this.get出席回数(entity.get出席状況_28日());
                relateEntity.set出席状況_29日(entity.get出席状況_29日());
                this.get出席回数(entity.get出席状況_29日());
                relateEntity.set出席状況_30日(entity.get出席状況_30日());
                this.get出席回数(entity.get出席状況_30日());
                relateEntity.set出席状況_31日(entity.get出席状況_31日());
                this.get出席回数(entity.get出席状況_31日());
                relateEntity.set出席回数(出席回数);
                relateEntity.set審査会開催年月(set出席日(entity.get審査会開催年月(), paramter.get帳票出力区分()));
                総合計_審査回数 = 総合計_審査回数 + 出席回数;
                if (初期化フラグ == ZERO) {
                    総合計_報酬総額 = relateEntity.get総合計_報酬総額();
                    総合計_その他費用 = relateEntity.getその他費用();
                    総合計_税控除額 = relateEntity.get税額控除();
                    総合計_報酬合計 = relateEntity.get総合計_報酬合計();
                }
                if (CSVを出力する.equals(paramter.get帳票出力区分())) {
                    eucCsvWriterJunitoJugo.writeLine(change.createData(relateEntity, paramter.get帳票出力区分()));
                } else if (一覧表を発行する.equals(paramter.get帳票出力区分())) {
                    ShinsaHoshuIchiranReport report = new ShinsaHoshuIchiranReport(change.createData(relateEntity, paramter.get帳票出力区分()));
                    report.writeBy(reportSourceWriter);
                }
                if (初期化フラグ == NIJYU && CSVを出力する.equals(paramter.get帳票出力区分())) {
                    return;
                }
                初期化フラグ = 初期化フラグ + 1;
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            ShinsaHoshuIchiranEntity 総合計 = new ShinsaHoshuIchiranEntity(
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, new RString(総合計_審査回数),
                    DecimalFormatter.toコンマ区切りRString(総合計_報酬総額, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_その他費用, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_税控除額, ZERO),
                    DecimalFormatter.toコンマ区切りRString(総合計_報酬合計, ZERO));
            eucCsvWriterJunitoJugo.writeLine(総合計);
            eucCsvWriterJunitoJugo.close();
        }
        manager.spool(eucFilePath);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            バッチ出力条件リストの出力(導入団体クラス);
        } else if (一覧表を発行する.equals(paramter.get帳票出力区分())) {
            帳票バッチ出力条件リストの出力(導入団体クラス);
        }
    }

    private void バッチ出力条件リストの出力(Association 導入団体クラス) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("審査会開催年月");
        審査会開催年月.append(dateFormat(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("介護認定審査会委員報酬一覧表CSV"),
                導入団体クラス.getLasdecCode_().value(), 導入団体クラス.get市町村名(), new RString(JobContextHolder.getJobId()),
                CSV_NAME, EUC_ENTITY_ID.toRString(), new RString(eucCsvWriterJunitoJugo.getCount()), 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void 帳票バッチ出力条件リストの出力(Association 導入団体クラス) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("審査会開催年月");
        審査会開催年月.append(dateFormat(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE601005.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(), 導入団体クラス.get市町村名(), new RString(JobContextHolder.getJobId()),
                ReportIdDBE.DBE601005.getReportName(), new RString(reportSourceWriter.pageCount().value()), なし, なし, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private void get出席回数(RString 出席状況) {
        if (ShinsaHoshuIchiranProcess.長.equals(出席状況) || ShinsaHoshuIchiranProcess.副.equals(出席状況) || ShinsaHoshuIchiranProcess.出.equals(出席状況)) {
            出席回数++;
        }
    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().toDateString();
    }

    private static RString set出席日(RString date, RString 帳票出力区分) {

        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (CSVを出力する.equals(帳票出力区分)) {
            RStringBuilder 出席日 = new RStringBuilder();
            出席日.append(date.substring(YON));
            出席日.append(GATSU);
            return 出席日.toRString();
        }
        if (一覧表を発行する.equals(帳票出力区分)) {
            RStringBuilder 出席日 = new RStringBuilder();
            出席日.append(SHUSEKINITI);
            出席日.append(date.substring(YON));
            出席日.append(GATSU);
            出席日.append(KAKO);
            return 出席日.toRString();
        } else {
            return RString.EMPTY;
        }
    }
}
