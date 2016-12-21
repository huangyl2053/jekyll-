/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 「認定調査督促対象者一覧表の作成」と「認定調査督促対象者一覧表csvの作成」の処理クラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess extends BatchProcessBase<NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity> {

    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter;
    private CsvWriter<NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity> csvWriter;

    private NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter parameter;

    private static final ReportId REPORT_DBE223001 = ReportIdDBE.DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo.getReportId();
    private int 帳票データの行番号 = 1;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE223002");
    private static final RString CSVファイル名 = new RString("認定調査督促対象者一覧表.csv");
    private static final RString CSVタイトル = new RString("督促状発行対象者一覧");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString 改頁キー = new RString("cityCode");

    private RString csvFilePath;
    private FileSpoolManager fileSpoolManager;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo."
                    + "INinteichosaTokusokujyoRelateMapper.select認定調査督促対象者一覧表ByKey");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value())
                .addBreak(new BreakerCatalog<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource>().simplePageBreaker(改頁キー))
                .create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);

        if (parameter.isCsv出力_選択された()) {
            fileSpoolManager = new FileSpoolManager(
                    UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
            csvFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);
            csvWriter = new CsvWriter.InstanceBuilder(csvFilePath).canAppend(false)
                    .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).setNewLine(NewLine.CRLF).build();
        }
    }

    @Override
    protected void beforeExecute() {
        RString 印刷年月日 = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().toString());

        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString 時分秒 = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");

        if (parameter.isCsv出力_選択された()) {
            csvWriter.writeLine(new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(
                    CSVタイトル, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null));
            csvWriter.writeLine(new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(
                    印刷年月日.concat(RString.HALF_SPACE).concat(時分秒),
                    null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null));
        }
    }

    @Override
    protected void process(NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity) {
        entity.set行番号(帳票データの行番号++);

        NinteiChosaTokusokuTaishoshaIchiranhyoReport report
                = new NinteiChosaTokusokuTaishoshaIchiranhyoReport(entity);
        report.writeBy(reportSourceWriter);

        if (parameter.isCsv出力_選択された()) {
            csvWriter.writeLine(new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity().createCsvEntity(entity));
        }
    }

    @Override
    protected void afterExecute() {
        if (parameter.isCsv出力_選択された()) {
            csvWriter.close();
            fileSpoolManager.spool(csvFilePath);
        }
        NinteiChosaTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor outputJokenhyoEditor
                = new NinteiChosaTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor(parameter);
        List<RString> 条件リスト = outputJokenhyoEditor.edit();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ = new ReportOutputJokenhyoItem(
                REPORT_DBE223001.value(),
                association.get地方公共団体コード().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE223001.value()),
                new RString(batchWrite.getPageCount()),
                parameter.isCsv出力_選択された() ? new RString("あり") : new RString("なし"),
                parameter.isCsv出力_選択された() ? CSVファイル名 : RString.EMPTY,
                条件リスト);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
