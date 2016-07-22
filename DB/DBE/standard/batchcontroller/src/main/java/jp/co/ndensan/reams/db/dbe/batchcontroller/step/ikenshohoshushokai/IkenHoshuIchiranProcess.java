/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshohoshushokai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai.IkenHoshuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshohoshushokai.IkenHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IIkenHoshuIchiranCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 主治医意見書作成報酬一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1930-020 chenxiangyu
 */
public class IkenHoshuIchiranProcess extends BatchProcessBase<IkenshoHoshuShokaiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshohoshushokai.IIkenshoHoshuShokaiRelateMapper.select合計額リスト");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE601004.getReportId();
    private static final RString REPORT_NAME = ReportIdDBE.DBE601004.getReportName();
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE601004"));
    private static final RString CSV_NAME_EN = new RString("DBE601004_NinteichosaHoshu.csv");
    private static final RString CSV_NAME_JP = new RString("主治医意見書作成報酬一覧表CSV.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString なし = new RString("なし");
    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(IkenHoshuIchiranReportSource.ReportSourceFields.iryokikanNo.name())));
    private int count = 0;
    private RString 医療機関番号 = RString.EMPTY;
    private IkenHoshuIchiranProcessParameter paramter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;

    @BatchWriter
    private BatchReportWriter<IkenHoshuIchiranReportSource> batchWrite;
    private ReportSourceWriter<IkenHoshuIchiranReportSource> reportSourceWriter;

    @BatchWriter
    private EucCsvWriter<IIkenHoshuIchiranCsvEucEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME_EN);
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<IkenHoshuIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(IkenshoHoshuShokaiRelateEntity relateEntity) {
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            eucCsvWriterJunitoJugo.writeLine(IkenHoshuIchiranChange.createIkenHoshuIchiranData(relateEntity, paramter));
        } else if (集計表を発行する.equals(paramter.get帳票出力区分())) {
            if (!医療機関番号.equals(relateEntity.get主治医医療機関コード())) {
                count = 1;
            } else {
                count = count + 1;
            }
            医療機関番号 = relateEntity.get主治医医療機関コード();
            IkenHoshuIchiranReport report = new IkenHoshuIchiranReport(
                    IkenHoshuIchiranChange.createIkenHoshuIchiranData(relateEntity, paramter),
                    IkenHoshuIchiranChange.createGokeiDate(relateEntity, count, reportSourceWriter.pageCount().value()));
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        manager.spool(eucFilePath);
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            バッチ出力条件リストの出力();
        } else if (集計表を発行する.equals(paramter.get帳票出力区分())) {
            帳票バッチ出力条件リストの出力();
        }
    }

    private void 帳票バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 意見書記入日FROM_SB = new RStringBuilder("【意見書記入日（From）】");
        意見書記入日FROM_SB.append(dateFormat(paramter.get作成依頼日期間開始()));
        RStringBuilder 意見書記入日To_SB = new RStringBuilder("【意見書記入日（To）】");
        意見書記入日To_SB.append(dateFormat(paramter.get作成依頼日期間終了()));
        出力条件.add(意見書記入日FROM_SB.toRString());
        出力条件.add(意見書記入日To_SB.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                REPORT_NAME,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力件数 = new RString(eucCsvWriterJunitoJugo.getCount());
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 意見書記入日FROM_SB = new RStringBuilder("【意見書記入日（From）】");
        意見書記入日FROM_SB.append(dateFormat(paramter.get作成依頼日期間開始()));
        RStringBuilder 意見書記入日To_SB = new RStringBuilder("【意見書記入日（To）】");
        意見書記入日To_SB.append(dateFormat(paramter.get作成依頼日期間終了()));
        出力条件.add(意見書記入日FROM_SB.toRString());
        出力条件.add(意見書記入日To_SB.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                CSV_NAME_JP,
                導入団体コード,
                市町村名,
                ジョブ番号,
                CSV_NAME_EN,
                EUC_ENTITY_ID.toRString(),
                出力件数,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private static RString dateFormat(FlexibleDate date) {
        if (date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
