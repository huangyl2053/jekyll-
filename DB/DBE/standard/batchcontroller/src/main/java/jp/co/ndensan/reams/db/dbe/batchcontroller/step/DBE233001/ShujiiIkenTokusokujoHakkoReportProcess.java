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
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShuturyokuJyoukenProcessParamter;
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
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
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

    /**
     * OUT_DATA_LISTです。
     */
    public static final RString OUT_DATA_LIST;
    /**
     * SHUJI_DATA_LISTです。
     */
    public static final RString SHUJI_DATA_LIST;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001."
            + "IDbe233001RelateMapper.select主治医意見書督促対象者一覧表ByKey");

    private static final ReportId REPORT_DBE223002 = ReportIdDBE.DBE223002.getReportId();
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<ShujiiIkenTokusokujoCsvEntity> csvWriter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList;
    NinteiChosaTokusokuTaishoshaIchiranhyoItem item;
    private boolean outputCsv;
    private ShuturyokuJyoukenProcessParamter processPrm;
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("ShujiiIkenEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString タイトル = new RString("督促状発行対象者一覧");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 市町村名称 = new RString("市町村名称");
    private static final RString 番号 = new RString("No");
    private static final RString 保険者名 = new RString("保険者名");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 被保険者氏名カナ = new RString("被保険者氏名カナ");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString 申請日 = new RString("申請日");
    private static final RString 督促状発行日 = new RString("督促状発行日");
    private static final RString 氏名 = new RString("氏名");
    private static final RString 事業者名称 = new RString("事業者名称");
    private static final RString 事業者住所 = new RString("事業者住所");
    private static final RString 事業者電話番号 = new RString("事業者電話番号");
    private static int index = 1;

    static {
        OUT_DATA_LIST = new RString("outDataList");
        SHUJI_DATA_LIST = new RString("shujiDataList");
    }
    private OutputParameter<List<RString>> outDataList;
    private OutputParameter<List<NinteiChosaTokusokuTaishoshaIchiranhyoItem>> shujiDataList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        itemList = new ArrayList();
        shinseishoKanriNoList = new ArrayList<>();
        outDataList = new OutputParameter<>();
        shujiDataList = new OutputParameter<>();
        outputCsv = processPrm.getTemp_CSV出力().equals(new RString("1"));
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toShujiiIkenTokusokujoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223002.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        if (outputCsv) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                    UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            eucFilePath = Path.combinePath(spoolWorkPath, new RString("ShujiiIkenEucCsv.csv"));
            csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8).setNewLine(NewLine.CRLF).hasHeader(false).build();
        }
    }

    @Override
    protected void beforeExecute() {
        if (outputCsv) {
            csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                    タイトル, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null));
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
                    null, null, null, null));
            csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                    市町村コード, 市町村名称, 番号, 保険者名, 被保険者番号, 被保険者氏名カナ, 被保険者氏名, 申請日, 督促状発行日,
                    氏名, 事業者名称, 事業者住所, 事業者電話番号));
        }
    }

    @Override
    protected void process(ShujiiIkenTokusokujoHakkoRelateEntity entity) {
        shinseishoKanriNoList.add(entity.getTemp_申請書管理番号().getColumnValue());
        item = new NinteiChosaTokusokuTaishoshaIchiranhyoItem(entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード()
                .getColumnValue(),
                entity.getTemp_市町村名称(),
                processPrm.getTemp_保険者名称(),
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
        index = index + 1;
        report.writeBy(reportSourceWriter);
        if (outputCsv) {
            csvWriter.writeLine(createCsvEntity(item, index));
        }
    }

    private ShujiiIkenTokusokujoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoItem item, int idenx) {
        return new ShujiiIkenTokusokujoCsvEntity(
                item.getCityCode(), item.getCityName(), new RString(String.valueOf(idenx)), item.getListUpper1_1(),
                item.getListLower1_1(), item.getListUpper1_2(),
                item.getListLower1_2(), item.getListShinseiYMD_1().toDateString(),
                item.getListTokusokujoHakkoYMD_1().toDateString(),
                item.getListLower2_1(), item.getListUpper2_1(),
                item.getListUpper2_2(), item.getListLower2_2());
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
        outDataList.setValue(shinseishoKanriNoList);
        shujiDataList.setValue(itemList);
        if (outputCsv) {
            csvWriter.close();
            manager.spool(eucFilePath);
        }
    }

    private void set出力条件表() {
        List 出力条件 = new ArrayList();
        出力条件.add(processPrm.getTemp_保険者コード());
        出力条件.add(processPrm.getTemp_保険者名称());
        出力条件.add(processPrm.getTemp_主治医医療機関コード());
        出力条件.add(processPrm.getTemp_主治医コード());
        出力条件.add(processPrm.getTemp_基準日() == null ? RString.EMPTY : new RString(processPrm.getTemp_基準日().toString()));
        出力条件.add(processPrm.getTemp_主治医意見書督促期限日数() == null ? RString.EMPTY
                : new RString(processPrm.getTemp_主治医意見書督促期限日数().toString()));
        出力条件.add(processPrm.getTemp_主治医意見書督促状());
        出力条件.add(processPrm.getTemp_主治医意見書督促対象者一覧表());
        出力条件.add(processPrm.getTemp_CSV出力());
        出力条件.add(processPrm.getTemp_印刷済対象者());
        出力条件.add(processPrm.getTemp_発行履歴());
        出力条件.add(new RString(String.valueOf(processPrm.getTemp_督促方法())));
        出力条件.add(processPrm.getTemp_督促メモ());
        出力条件.add(processPrm.getTemp_督促日() == null ? RString.EMPTY : new RString(processPrm.getTemp_督促日().toString()));
        出力条件.add(processPrm.getTemp_印刷期間開始日() == null ? RString.EMPTY : new RString(processPrm.getTemp_印刷期間開始日().toString()));
        出力条件.add(processPrm.getTemp_印刷期間終了日() == null ? RString.EMPTY : new RString(processPrm.getTemp_印刷期間終了日().toString()));
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        REPORT_DBE223002.value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE223002.value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
