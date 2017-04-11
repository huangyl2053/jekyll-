/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE223001;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
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
    private final List<PersonalData> personalDataList = new ArrayList<>();

    private static final ReportId REPORT_DBE223001 = ReportIdDBE.DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo.getReportId();
    private int 帳票データの行番号 = 1;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE223002");
    private static final RString CSVファイル名 = new RString("認定調査督促対象者一覧表.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
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
            csvWriter = new CsvWriter.InstanceBuilder(csvFilePath).canAppend(false).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
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
            personalDataList.add(toPersonalData(entity.getTemp_保険者番号(), entity.getTemp_被保険者番号(), entity.getTemp_申請書管理番号()));
        }
    }

    private PersonalData toPersonalData(RString 証記載保険者番号, RString 被保険者番号, RString 申請書管理番号) {
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(証記載保険者番号.substring(0, 5).concat(被保険者番号));
        ExpandedInformation expandedInformation = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(shikibetsuCode, expandedInformation);
    }

    @Override
    protected void afterExecute() {
        if (parameter.isCsv出力_選択された()) {
            csvWriter.close();
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            fileSpoolManager.spool(csvFilePath, accessLogUUID);
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
