/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoHakkoReportProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 主治医意見書督促対象者一覧表の作成クラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public class ShujiiIkenTokusokujoHakkoReportProcess extends BatchProcessBase<ShujiiIkenTokusokujoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001."
            + "IDbe233001RelateMapper.select主治医意見書督促対象者一覧表ByKey");

    private static final ReportId REPORT_DBE233002 = ReportIdDBE.DBE233002.getReportId();
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter;
    private CsvWriter<ShujiiIkenTokusokujoCsvEntity> csvWriter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList;
    NinteiChosaTokusokuTaishoshaIchiranhyoItem item;
    private boolean outputCsv;
    private ShujiiIkenTokusokujoHakkoReportProcessParameter processPrm;
    private static final RString CSVファイル名 = new RString("主治医意見書督促対象者一覧表.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE233002"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVタイトル = new RString("主治医意見書督促対象者一覧");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 市町村名称 = new RString("市町村名称");
    private static final RString 番号 = new RString("No");
    private static final RString 保険者名 = new RString("保険者名");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 被保険者氏名カナ = new RString("被保険者氏名カナ");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString 申請日 = new RString("申請日");
    private static final RString 督促状発行日 = new RString("督促状発行日");
    private static final RString 氏名 = new RString("主治医氏名");
    private static final RString 医療機関コード = new RString("主治医医療機関コード");
    private static final RString 事業者名称 = new RString("主治医医療機関名称");
    private static final RString 事業者住所 = new RString("主治医医療機関住所");
    private static final RString 事業者電話番号 = new RString("主治医医療機関電話番号");
    private static final RString 改頁キー = new RString("cityCode");
    private static int index = 1;

    @Override
    protected void initialize() {
        itemList = new ArrayList();
        outputCsv = processPrm.getTemp_CSV出力().equals(new RString("1"));
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toShujiiIkenTokusokujoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE233002.value())
                .addBreak(new BreakerCatalog<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource>().simplePageBreaker(改頁キー))
                .create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        if (outputCsv) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                    UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            eucFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);
            csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).setNewLine(NewLine.CRLF).hasHeader(false).build();
        }
    }

    @Override
    protected void beforeExecute() {
        if (outputCsv) {
            csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                    CSVタイトル, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null));
            RStringBuilder systemDateTime = new RStringBuilder();
            RDateTime datetime = RDate.getNowDateTime();
            systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.ZERO).toDateString());
            systemDateTime.append(RString.HALF_SPACE);
            systemDateTime.append(String.format("%02d", datetime.getHour()));
            systemDateTime.append(new RString("時"));
            systemDateTime.append(String.format("%02d", datetime.getMinute()));
            systemDateTime.append(new RString("分"));
            systemDateTime.append(String.format("%02d", datetime.getSecond()));
            systemDateTime.append(new RString("秒"));
            csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                    systemDateTime.toRString(),
                    null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null));
            csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                    番号, 市町村コード, 市町村名称, 保険者名, 被保険者番号, 被保険者氏名カナ, 被保険者氏名, 申請日, 督促状発行日,
                    医療機関コード, 事業者名称, 事業者住所, 事業者電話番号, 氏名));
        }
    }

    @Override
    protected void process(ShujiiIkenTokusokujoHakkoRelateEntity entity) {
        item = new NinteiChosaTokusokuTaishoshaIchiranhyoItem(entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード()
                .getColumnValue(),
                entity.getTemp_市町村名称(),
                entity.getTemp_市町村名称(),
                entity.getTemp_被保険者番号(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                entity.getTemp_申請日() == null ? RDate.MIN : new RDate(entity.getTemp_申請日().toString()),
                entity.getTemp_督促状発行日() == null ? RDate.MIN : new RDate(entity.getTemp_督促状発行日().toString()),
                entity.getTemp_主治医氏名() == null ? RString.EMPTY : entity.getTemp_主治医氏名(),
                entity.getTemp_事業者名称(),
                entity.getTemp_事業者住所(),
                entity.getTemp_事業者電話番号() == null ? RString.EMPTY : entity.getTemp_事業者電話番号().getColumnValue());
        itemList.add(item);
        NinteiChosaTokusokuTaishoshaIchiranhyoReport report = new NinteiChosaTokusokuTaishoshaIchiranhyoReport(item, index);
        report.writeBy(reportSourceWriter);
        if (outputCsv) {
            csvWriter.writeLine(createCsvEntity(
                    item,
                    entity.getTemp_医療機関コード() == null ? RString.EMPTY : entity.getTemp_医療機関コード(),
                    index));
        }
        index = index + 1;
    }

    private ShujiiIkenTokusokujoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoItem item,
            RString 医療機関コード, int idenx) {
        return new ShujiiIkenTokusokujoCsvEntity(
                item.getCityCode(), item.getCityName(), new RString(String.valueOf(idenx)), item.getListUpper1_1(),
                item.getListLower1_1(), item.getListUpper1_2(),
                item.getListLower1_2(), item.getListShinseiYMD_1().toDateString(),
                item.getListTokusokujoHakkoYMD_1().toDateString(),
                医療機関コード, item.getListUpper2_1(),
                item.getListUpper2_2(), item.getListLower2_2(), item.getListLower2_1());
    }

    @Override
    protected void afterExecute() {
        ShujiiIkenshoTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor outputJokenhyoEditor
                = new ShujiiIkenshoTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor(processPrm);
        List<RString> 条件リスト = outputJokenhyoEditor.edit();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ = new ReportOutputJokenhyoItem(
                REPORT_DBE233002.value(),
                association.get地方公共団体コード().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE233002.value()),
                new RString(batchWrite.getPageCount()),
                outputCsv ? new RString("あり") : new RString("なし"),
                outputCsv ? CSVファイル名 : RString.EMPTY,
                条件リスト);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
        if (outputCsv) {
            csvWriter.close();
            manager.spool(eucFilePath);
        }
    }
}
