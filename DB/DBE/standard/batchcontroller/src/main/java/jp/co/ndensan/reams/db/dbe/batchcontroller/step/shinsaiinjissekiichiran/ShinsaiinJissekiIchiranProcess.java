/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsaiinjissekiichiran;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.IShinsaiinJissekiIchiranCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護認定審査会委員報酬実績集計表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
public class ShinsaiinJissekiIchiranProcess extends BatchProcessBase<ShinsaiinJissekiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate."
            + "shinsaiinjissekiichiran.IShinsaiinJissekiIchiranMapper.get介護認定審査会委員報酬集計表");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE601003.getReportId();
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE601003"));
    private static final RString CSV_NAME = new RString("ShinsaiinJissekiIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString なし = new RString("なし");
    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");
    private ShinsaiinJissekiIchiranProcessParamter paramter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;

    @BatchWriter
    private BatchReportWriter<ShinsaiinJissekiIchiranReportSource> batchWrite;
    private ReportSourceWriter<ShinsaiinJissekiIchiranReportSource> reportSourceWriter;

    @BatchWriter
    private EucCsvWriter<IShinsaiinJissekiIchiranCsvEucEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, (IMyBatisParameter) paramter.toMybitisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME);
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(new RString(File.separator))
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        if (CSVを出力する.equals(paramter.get帳票出力区分())) {
            IShinsaiinJissekiIchiranCsvEucEntity entity = new ShinsaiinJissekiIchiranEntity(relateEntity);
            eucCsvWriterJunitoJugo.writeLine(entity);
        } else if (集計表を発行する.equals(paramter.get帳票出力区分())) {
            ShinsaiinJissekiIchiranReport report = new ShinsaiinJissekiIchiranReport(relateEntity);
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

    private void バッチ出力条件リストの出力() {
        RString 出力件数 = new RString(eucCsvWriterJunitoJugo.getCount());
        List<RString> 出力件数_list = new ArrayList<>();
        RString 出力件数_substr = RString.EMPTY;
        for (int i = 0; i < 出力件数.length(); i++) {
            if (i + 3 > 出力件数.length()) {
                出力件数_substr = 出力件数.substring(i, 出力件数.length());
            }
            出力件数_list.add(出力件数_substr);
        }
        RStringBuilder 出力件数_SB = new RStringBuilder();
        for (int i = 0; i < 出力件数_list.size(); i++) {
            出力件数_SB.append(出力件数_list.get(i)).append(",");
        }
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催日FROM_SB = new RStringBuilder("【審査会開催日（From）】");
        審査会開催日FROM_SB.append(paramter.get審査会開催日FROM());
        RStringBuilder 審査会開催日To_SB = new RStringBuilder("【審査会開催日（To）】");
        審査会開催日To_SB.append(paramter.get審査会開催日TO());
        出力条件.add(審査会開催日FROM_SB.toRString());
        出力条件.add(審査会開催日To_SB.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("介護認定審査会委員実績集計CSV"), 導入団体コード, 市町村名, new RString(JobContextHolder.getJobId()),
                CSV_NAME, EUC_ENTITY_ID.toRString(), 出力件数_SB.toRString(), 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void 帳票バッチ出力条件リストの出力() {
        RString 帳票名 = ReportIdDBE.DBE601003.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催日FROM_SB = new RStringBuilder("【審査会開催日（From）】");
        審査会開催日FROM_SB.append(dateFormat(paramter.get審査会開催日FROM()));
        RStringBuilder 審査会開催日To_SB = new RStringBuilder("【審査会開催日（To）】");
        審査会開催日To_SB.append(paramter.get審査会開催日TO());
        出力条件.add(審査会開催日FROM_SB.toRString());
        出力条件.add(審査会開催日To_SB.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE601003.getReportId().value(), 導入団体コード, 市町村名, new RString(JobContextHolder.getJobId()),
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private static RString dateFormat(FlexibleDate date) {
        if (date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
