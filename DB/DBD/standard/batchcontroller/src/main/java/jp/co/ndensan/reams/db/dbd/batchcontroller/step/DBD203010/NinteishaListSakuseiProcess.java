/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD203010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200004.ShakaiFukushiHojinKeigenReport;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuTaisho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.ninteishalistsakusei.NinteishaListSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.Setaiinshotokujoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenNoRennbannCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200004.ShakaiFukushiHojinReportSourse;
import jp.co.ndensan.reams.db.dbd.service.core.dbd203010.NinteishaListSakuseiManager;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 帳票・CSV作成の取得
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
public class NinteishaListSakuseiProcess extends BatchProcessBase<ShakaiFukushiHojinKeigenGaitoshaIchiranEntity> {

    private static final RString MAPPER_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishalistsakusei.INinteishaListSakuseiMapper.select社会福祉法人軽減情報");
    private NinteishaListSakuseiProcessParameter processParameter;
    private RString orderBy = null;
    private Association association = null;
    private List<PersonalData> ninteishapersonalDataList;
    private List<PersonalData> gaitoshapersonalDataList;
    private FileSpoolManager manager;
    private FileSpoolManager noRennbannmanager;
    private RString eucFilePath;
    private RString filePath;
    private IOutputOrder outputOrder;
    private IOutputOrder breakoutputOrder;
    private int 連番 = 0;
    private boolean 日付スラッシュ編集_flag = false;
    private boolean 連番_flag = false;
    private boolean タイトル_flag = false;
    private static final EucEntityId EUC_ENTITY_ID_1 = new EucEntityId("DBD203011");
    private static final EucEntityId EUC_ENTITY_ID_2 = new EucEntityId("DBD203010");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString NINTEISHAICHIRANCSV = new RString("ShakaiFukushiHojinKeigenNinteishaIchiran.csv");
    private static final RString GAITOSHAICHIRANCSV = new RString("ShakaiFukushiHojinKeigenGaitoshaIchiran.csv");
    private static final RString LISTSCV = new RString("ShakaiFukushiHojinKeigenList.csv");
    private static final RString 認定者 = new RString("1");
    private static final RString 該当者 = new RString("2");
    private static final RString 対象期間指定 = new RString("【対象期間指定】");
    private static final RString 対象年度 = new RString("【対象年度】");
    private static final RString 課税判定等基準日 = new RString("【課税判定等基準日】");
    private static final RString 基準日 = new RString("【基準日】");
    private static final RString 所得年度 = new RString("【所得年度】");
    private static final RString 世帯表示 = new RString("【世帯表示】");
    private static final RString 旧措置者区分 = new RString("【旧措置者区分】");
    private static final RString 抽出対象 = new RString("【抽出対象】");
    private static final RString 受給者区分 = new RString("【受給者区分】");
    private static final RString 世帯非課税等 = new RString("【世帯非課税等】");
    private static final RString CSV出力設定 = new RString("【CSV出力設定】");
    private static final RString 出力順 = new RString("【出力順】");
    private static final RString カラ = new RString("～");
    private static final RString POINT = new RString("、");
    private static final RString SPACE = new RString("　　　　　　　　 ");
    private static final RString より = new RString("＞");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private static final int NUM5 = 5;

    @BatchWriter
    private CsvWriter<ShakaiFukushiHojinKeigenCsvEntity> eucCsvWriter;
    @BatchWriter
    private CsvWriter<ShakaiFukushiHojinKeigenNoRennbannCsvEntity> noRennbanneucCsvWriter;
    @BatchWriter
    private BatchReportWriter<ShakaiFukushiHojinReportSourse> batchReportWriterIchiran;
    private ReportSourceWriter<ShakaiFukushiHojinReportSourse> reportSourceWriterIchiran;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninteishapersonalDataList = new ArrayList<>();
        gaitoshapersonalDataList = new ArrayList<>();
        for (int i = 0; i < processParameter.get出力設定().size(); i++) {
            if (processParameter.get出力設定().get(i).equals(new RString("3"))) {
                日付スラッシュ編集_flag = true;
            }
            if (processParameter.get出力設定().get(i).equals(new RString("2"))) {
                連番_flag = true;
            }
            if (processParameter.get出力設定().get(i).equals(new RString("1"))) {
                タイトル_flag = true;
            }
        }

        if (processParameter.get出力順ID() != 0) {
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票出力順ID = processParameter.get出力順ID();
            outputOrder = finder.get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200004.getReportId(), 帳票出力順ID);
            if (outputOrder != null) {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                        create(NinteishaListSakuseiOrderKey.class, outputOrder), NUM5);
            }
        }
        if (processParameter.get改頁出力順ID() != 0) {
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票改頁出力順ID = processParameter.get改頁出力順ID();
            breakoutputOrder = finder.get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200004.getReportId(), 帳票改頁出力順ID);
        }

    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        shikibetsuTaishoPSMKey.set基準日(processParameter.get課税判定等基準日());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();

        NinteishaListSakuseiParameter ninteishaListSakuseiParameter = new NinteishaListSakuseiParameter(
                Integer.parseInt(processParameter.get対象期間指定().toString()),
                Integer.parseInt(processParameter.get世帯表示().toString()),
                processParameter.get課税判定等基準日(),
                processParameter.get世帯非課税等(),
                Integer.parseInt(processParameter.get抽出対象().toString()),
                orderBy,
                Integer.parseInt(processParameter.get対象リスト().toString()),
                processParameter.get対象年度の開始年月日(),
                processParameter.get対象年度の終了年月日(),
                processParameter.get基準日(),
                shikibetsuTaishoPSMSearchKey
        );
        return new BatchDbReader(MAPPER_ID, ninteishaListSakuseiParameter);
    }

    @Override
    protected void createWriter() {
        if (連番_flag) {
            noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
            filePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
            noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(filePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
            if (processParameter.get対象リスト().equals(認定者) && タイトル_flag) {
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
                eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(認定者) && !タイトル_flag) {
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
                eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(false).
                        build();
            } else if (processParameter.get対象リスト().equals(該当者) && タイトル_flag) {
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
                eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(該当者) && !タイトル_flag) {
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
                eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(false).
                        build();
            }
        } else {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
            filePath = Path.combinePath(manager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
            eucCsvWriter = new CsvWriter.InstanceBuilder(filePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();

            if (processParameter.get対象リスト().equals(認定者) && タイトル_flag) {
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
                noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(認定者) && !タイトル_flag) {
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
                noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(false).
                        build();
            } else if (processParameter.get対象リスト().equals(該当者) && タイトル_flag) {
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
                noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(該当者) && !タイトル_flag) {
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
                noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(false).
                        build();
            }
        }

        List pageBreakKeys = new ArrayList<>();
        set改頁Key(breakoutputOrder, pageBreakKeys);

        if (!pageBreakKeys.isEmpty()) {
            batchReportWriterIchiran = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBD.DBD200004.getReportId().getColumnValue(), SubGyomuCode.DBD介護受給)
                    .addBreak(new BreakerCatalog<ShakaiFukushiHojinReportSourse>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriterIchiran = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBD.DBD200004.getReportId().getColumnValue(), SubGyomuCode.DBD介護受給).create();
        }
        reportSourceWriterIchiran = new ReportSourceWriter(batchReportWriterIchiran);
    }

    @Override
    protected void process(ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        RString 帳票タイトル;
        if (processParameter.get対象リスト().equals(認定者)) {
            帳票タイトル = new RString("社会福祉法人軽減認定者リスト");
        } else {
            帳票タイトル = new RString("社会福祉法人軽減該当者リスト");
        }
        ShakaiFukushiHojinKeigenReport report = new ShakaiFukushiHojinKeigenReport(entity, 帳票タイトル, processParameter.get帳票作成日時(),
                association, outputOrder);
        report.writeBy(reportSourceWriterIchiran);

        if (連番_flag) {
            ninteishapersonalDataList.add(toPersonalData(entity));
        } else {
            gaitoshapersonalDataList.add(toPersonalData(entity));
        }
        if (連番_flag && entity.get世帯員リスト().size() > 0) {
            ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenCsvEntity();
            for (int i = NO_0; i < entity.get世帯員リスト().size(); i++) {
                if (i == NO_0) {
                    連番++;
                    NinteishaListSakuseiManager.createInstance().連番ありCSV世帯員情報設定(eucCsvEntity, entity, 連番,
                            日付スラッシュ編集_flag, entity.get世帯員リスト().get(i));
                    eucCsvWriter.writeLine(eucCsvEntity);
                    ninteishapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                } else {
                    連番++;
                    NinteishaListSakuseiManager.createInstance().連番ありCSV情報設定(eucCsvEntity, entity.get世帯員リスト().get(i));
                    eucCsvWriter.writeLine(eucCsvEntity);
                    ninteishapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                }
            }
        }
        if (連番_flag && entity.get世帯員リスト().isEmpty()) {
            ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenCsvEntity();
            連番++;
            NinteishaListSakuseiManager.createInstance().連番ありCSV世帯員情報設定(eucCsvEntity, entity, 連番,
                    日付スラッシュ編集_flag, null);
            eucCsvWriter.writeLine(eucCsvEntity);
        }
        if (!連番_flag && entity.get世帯員リスト().size() > 0) {
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity noRennbannCsvEntit = new ShakaiFukushiHojinKeigenNoRennbannCsvEntity();
            for (int i = NO_0; i < entity.get世帯員リスト().size(); i++) {
                if (i == NO_0) {
                    NinteishaListSakuseiManager.createInstance().連番なしCSV世帯員情報設定(noRennbannCsvEntit, entity,
                            日付スラッシュ編集_flag, entity.get世帯員リスト().get(i));
                    noRennbanneucCsvWriter.writeLine(noRennbannCsvEntit);
                    gaitoshapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                } else {
                    NinteishaListSakuseiManager.createInstance().連番なしCSV情報設定(noRennbannCsvEntit, entity.get世帯員リスト().get(i));
                    noRennbanneucCsvWriter.writeLine(noRennbannCsvEntit);
                    gaitoshapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                }
            }
        }
        if (!連番_flag && entity.get世帯員リスト().isEmpty()) {
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity noRennbannCsvEntit = new ShakaiFukushiHojinKeigenNoRennbannCsvEntity();
            NinteishaListSakuseiManager.createInstance().連番なしCSV世帯員情報設定(noRennbannCsvEntit, entity,
                    日付スラッシュ編集_flag, null);
            noRennbanneucCsvWriter.writeLine(noRennbannCsvEntit);
        }
    }

    @Override
    protected void afterExecute() {
        if (連番_flag) {
            eucCsvWriter.close();
            AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, ninteishapersonalDataList);
            manager.spool(eucFilePath, log);
        } else {
            noRennbanneucCsvWriter.close();
            AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, gaitoshapersonalDataList);
            noRennbannmanager.spool(eucFilePath, log);
        }
        if (processParameter.get対象リスト().equals(認定者)) {
            認定者バッチ出力条件リストの出力();
        } else {
            該当者バッチ出力条件リストの出力();
        }
    }

    private PersonalData toPersonalData(ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者番号().value());
        return PersonalData.of(entity.get宛名() == null ? ShikibetsuCode.EMPTY : entity.get宛名().getShikibetsuCode(), expandedInfo);
    }

    private PersonalData toPersonalData2(Setaiinshotokujoho joho) {
        return PersonalData.of(joho.get世帯員宛名() == null ? ShikibetsuCode.EMPTY : joho.get世帯員宛名().getShikibetsuCode());
    }

    private void 認定者バッチ出力条件リストの出力() {
        RString 出力ページ数;
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        if (連番_flag) {
            出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        } else {
            出力ページ数 = new RString(String.valueOf(noRennbanneucCsvWriter.getCount()));
        }
        RString 帳票名 = new RString("社会福祉法人軽減認定者リスト");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("あり");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        set出力条件(出力条件);
        builder.append(抽出対象);
        builder.append(ChushutsuTaisho.toValue(processParameter.get抽出対象()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(CSV出力設定);
        for (int i = 0; i < processParameter.get出力設定().size(); i++) {
            if (i == processParameter.get出力設定().size() - NO_1) {
                builder.append(CSVSettings.toValue(processParameter.get出力設定().get(i)));
            } else {
                builder.append(CSVSettings.toValue(processParameter.get出力設定().get(i)));
                builder.append(POINT);
            }
        }
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                new RString("DBD200015_ShakaiFukushiHojinKeigenNinteishaIchiran"),
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                LISTSCV,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void 該当者バッチ出力条件リストの出力() {
        RString 出力ページ数;
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        if (連番_flag) {
            出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        } else {
            出力ページ数 = new RString(String.valueOf(noRennbanneucCsvWriter.getCount()));
        }
        RString 帳票名 = new RString("社会福祉法人軽減該当者リスト");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("あり");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        set出力条件(出力条件);
        builder.append(受給者区分);
        builder.append(JukyushaKubun2.toValue(processParameter.get受給者区分()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(世帯非課税等);
        for (int i = 0; i < processParameter.get世帯非課税等().size(); i++) {
            if (i == NO_0) {
                builder.append(HihokenshaKeizaiJokyo.toValue(processParameter.get世帯非課税等().get(i)));
            } else {
                builder.append(SPACE);
                builder.append(HihokenshaKeizaiJokyo.toValue(processParameter.get世帯非課税等().get(i)));
            }
        }
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(CSV出力設定);
        for (int i = 0; i < processParameter.get出力設定().size(); i++) {
            if (i == processParameter.get出力設定().size() - NO_1) {
                builder.append(CSVSettings.toValue(processParameter.get出力設定().get(i)));
            } else {
                builder.append(CSVSettings.toValue(processParameter.get出力設定().get(i)));
                builder.append(POINT);
            }

        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                new RString("DBD200004_ShakaiFukushiHojinKeigenGaitoshaIchiran"),
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                LISTSCV,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void set出力条件(List<RString> 出力条件) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象期間指定);
        builder.append(TaishoKikan.toValue(processParameter.get対象期間指定()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        if (processParameter.get対象期間指定().equals(new RString("1"))) {
            builder.append(対象年度);
            if (null != processParameter.get対象年度の開始年月日()) {
                builder.append(edit日期(processParameter.get対象年度の開始年月日()));
            }
            builder.append(カラ);
            if (null != processParameter.get対象年度の終了年月日()) {
                builder.append(edit日期(processParameter.get対象年度の終了年月日()));
            }
            出力条件.add(builder.toRString());
            builder.delete(NO_0, builder.length());
            builder.append(課税判定等基準日);
            builder.append(edit日期(processParameter.get課税判定等基準日()));
            出力条件.add(builder.toRString());
            builder.delete(NO_0, builder.length());
        }
        if (processParameter.get対象期間指定().equals(new RString("2"))) {
            builder.append(基準日);
            builder.append(edit日期(processParameter.get基準日()));
            出力条件.add(builder.toRString());
            builder.delete(NO_0, builder.length());
        }
        builder.append(所得年度);
        builder.append(edit年度(processParameter.get所得年度()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(旧措置者区分);
        builder.append(KyusochishaJukyushaKubun.toValue(processParameter.get旧措置者区分()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(世帯表示);
        builder.append(SetaiHyoji.toValue(processParameter.get世帯表示()));
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
        builder.append(出力順);
        if (outputOrder != null) {
            List<ISetSortItem> 改頁項目List = outputOrder.get設定項目リスト();
            for (ISetSortItem sortItem : 改頁項目List) {
                builder.append(sortItem.get項目名());
                builder.append(より);
            }
        }
        builder.delete(builder.length() - NO_1, builder.length());
        出力条件.add(builder.toRString());
        builder.delete(NO_0, builder.length());
    }

    private void set改頁Key(IOutputOrder outputOrder, List pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > NO_0 && list.get(NO_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(0).get項目ID());
            }
            if (list.size() > NO_1 && list.get(NO_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(NO_1).get項目ID());
            }
            if (list.size() > NO_2 && list.get(NO_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(NO_2).get項目ID());
            }
            if (list.size() > NO_3 && list.get(NO_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(NO_3).get項目ID());
            }
            if (list.size() > NO_4 && list.get(NO_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(NO_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (NinteishaListSakuseiOrderKey.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list1_2");
        } else if (NinteishaListSakuseiOrderKey.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list3_2");
        } else if (NinteishaListSakuseiOrderKey.証記載保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list2_1");
        } else if (NinteishaListSakuseiOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("hokenshaNo");
        }
        return 帳票物理名;
    }

    private RString edit日期(FlexibleDate 日期) {

        RString 変更後日期 = RString.EMPTY;
        if (日期 != null) {
            変更後日期 = 日期.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 変更後日期;
    }

    private RString edit年度(FlexibleYear 所得年度) {
        RString 変更後年度 = RString.EMPTY;
        if (所得年度 != null) {
            変更後年度 = 所得年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.NONE).toDateString();
        }
        return 変更後年度;
    }
}
