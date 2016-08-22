/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200004.ShakaiFukushiHojinKeigenReport;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun;
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
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final RString 承認する = new RString("1");
    private static final RString 承認しない = new RString("0");
    private static final RString 認定者 = new RString("1");
    private static final RString 該当者 = new RString("2");
    private static final RString 承認 = new RString("承認");
    private static final RString 却下 = new RString("却下");
    private static final RString 自己作成 = new RString("自己作成");
    private static final RString 課 = new RString("課");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 居宅サービスのみ = new RString("居宅サービスのみ");
    private static final RString 居住費食費のみ = new RString("居住費・食費のみ");
    private static final RString 旧措ユ個のみ = new RString("旧措ユ個のみ");
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
    private static final RString カラ = new RString("～");
    private static final RString POINT = new RString("、");
    private static final RString ASTERISK = new RString("*");
    private static final RString SPACE = new RString("　　　　　　　　 ");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private static RStringBuilder orderByClause;
    private static RString space;
    private static RString comma;
    private static int commaCount;

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
        if (processParameter.get改頁出力順ID() != 0) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票出力順ID = processParameter.get改頁出力順ID();
            outputOrder = chohyoShutsuryokujunFinder.get出力順(
                    SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200004.getReportId(), 帳票出力順ID);
            if (null != outputOrder) {
                orderBy = createOrderSqlStr(NinteishaListSakuseiOrderKey.class, outputOrder);
            }
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
                processParameter.get対象年度の開始年月日(),
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
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
                eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(該当者) && !タイトル_flag) {
                noRennbannmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_2, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(noRennbannmanager.getEucOutputDirectry(), GAITOSHAICHIRANCSV);
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
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
                noRennbanneucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEnclosure(EUC_WRITER_ENCLOSURE).
                        setEncode(Encode.UTF_8withBOM).
                        setNewLine(NewLine.CRLF).
                        hasHeader(true).
                        build();
            } else if (processParameter.get対象リスト().equals(認定者) && !タイトル_flag) {
                manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_1, UzUDE0831EucAccesslogFileType.Csv);
                eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), NINTEISHAICHIRANCSV);
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
        set改頁Key(outputOrder, pageBreakKeys);

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
            帳票タイトル = new RString("介護保険　社会福祉法人軽減認定者リスト");
        } else {
            帳票タイトル = new RString("介護保険　社会福祉法人軽減該当者リスト");
        }
        ShakaiFukushiHojinKeigenReport report = ShakaiFukushiHojinKeigenReport.createReport(entity, 帳票タイトル, processParameter.get帳票作成日時(),
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
                    eucCsvEntity.set連番(new RString(連番));
                    setEucCsvEntity(eucCsvEntity, entity);
                    set世帯員CsvEntity(eucCsvEntity, entity.get世帯員リスト().get(i));
                    eucCsvWriter.writeLine(eucCsvEntity);
                    ninteishapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                } else {
                    連番++;
                    eucCsvEntity.set連番(new RString(連番));
                    setCsvEntityEmptyNo世帯員(eucCsvEntity);
                    set世帯員CsvEntity(eucCsvEntity, entity.get世帯員リスト().get(i));
                    eucCsvWriter.writeLine(eucCsvEntity);
                    ninteishapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                }
            }
        }
        if (連番_flag && entity.get世帯員リスト().isEmpty()) {
            ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenCsvEntity();
            setEucCsvEntity(eucCsvEntity, entity);
            連番++;
            eucCsvEntity.set連番(new RString(連番));
            eucCsvWriter.writeLine(eucCsvEntity);
        }
        if (!連番_flag && entity.get世帯員リスト().size() > 0) {
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity noRennbannCsvEntit = new ShakaiFukushiHojinKeigenNoRennbannCsvEntity();
            for (int i = NO_0; i < entity.get世帯員リスト().size(); i++) {
                if (i == NO_0) {
                    setNoRennbannEucCsvEntity(noRennbannCsvEntit, entity);
                    set世帯員NoRennbannCsvEntity(noRennbannCsvEntit, entity.get世帯員リスト().get(i));
                    noRennbanneucCsvWriter.writeLine(noRennbannCsvEntit);
                    gaitoshapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                } else {
                    setNoRennbannCsvEntityEmptyNo世帯員(noRennbannCsvEntit);
                    set世帯員NoRennbannCsvEntity(noRennbannCsvEntit, entity.get世帯員リスト().get(i));
                    noRennbanneucCsvWriter.writeLine(noRennbannCsvEntit);
                    gaitoshapersonalDataList.add(toPersonalData2(entity.get世帯員リスト().get(i)));
                }
            }
        }
        if (!連番_flag && entity.get世帯員リスト().isEmpty()) {
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity noRennbannCsvEntit = new ShakaiFukushiHojinKeigenNoRennbannCsvEntity();
            setNoRennbannEucCsvEntity(noRennbannCsvEntit, entity);
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

    private void setCsvEntityEmptyNo世帯員(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity) {
        eucCsvEntity.setカナ氏名(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set入所施設コード(RString.EMPTY);
        eucCsvEntity.set入所施設名称(RString.EMPTY);
        eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者番号(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set所得税課税区分(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set決定区分(RString.EMPTY);
        eucCsvEntity.set減免事由(RString.EMPTY);
        eucCsvEntity.set減免有効期限(RString.EMPTY);
        eucCsvEntity.set減免決定日(RString.EMPTY);
        eucCsvEntity.set減免申請日(RString.EMPTY);
        eucCsvEntity.set減免適用日(RString.EMPTY);
        eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        eucCsvEntity.set確認番号(RString.EMPTY);
        eucCsvEntity.set老齢福祉年金受給(RString.EMPTY);
        eucCsvEntity.set行政区(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set証保険者番号(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set課税区分(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set軽減率分子(RString.EMPTY);
        eucCsvEntity.set軽減率分母(RString.EMPTY);
        eucCsvEntity.set連番(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
    }

    private void set世帯員CsvEntity(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, Setaiinshotokujoho joho) {
        if (joho.get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(joho.get世帯員宛名());
            eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
            eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
        } else {
            eucCsvEntity.set世帯員氏名(RString.EMPTY);
            eucCsvEntity.set世帯員住民種別(RString.EMPTY);
        }
        if (!joho.get本人課税区分().isNullOrEmpty() && joho.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set世帯員課税区分(課);
        } else {
            eucCsvEntity.set世帯員課税区分(RString.EMPTY);
        }

        if (joho.get課税所得額() != null && joho.get課税所得額().intValue() > 0) {
            eucCsvEntity.set世帯員所得税課税区分(課);
        } else {
            eucCsvEntity.set世帯員所得税課税区分(RString.EMPTY);
        }

    }

    private void setEucCsvEntity(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {

        if (entity.get社会福祉法人等利用者負担軽減の情報() != null) {
            seteucCsvEntity軽減の情報_NotNull(eucCsvEntity, entity);
        } else {
            eucCsvEntity.set証保険者番号(RString.EMPTY);
            eucCsvEntity.set確認番号(RString.EMPTY);
            eucCsvEntity.set決定区分(RString.EMPTY);
            eucCsvEntity.set減免事由(RString.EMPTY);
            eucCsvEntity.set減免申請日(RString.EMPTY);
            eucCsvEntity.set減免決定日(RString.EMPTY);
            eucCsvEntity.set減免適用日(RString.EMPTY);
            eucCsvEntity.set減免有効期限(RString.EMPTY);
            eucCsvEntity.set軽減率分子(RString.EMPTY);
            eucCsvEntity.set軽減率分母(RString.EMPTY);
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        }
        eucCsvEntity.set被保険者番号(entity.get被保険者番号() != null ? entity.get被保険者番号().value() : RString.EMPTY);
        if (entity.get宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set郵便番号(kojin.get住所().get住所());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        } else {
            eucCsvEntity.set識別コード(RString.EMPTY);
            eucCsvEntity.set住所コード(RString.EMPTY);
            eucCsvEntity.set氏名(RString.EMPTY);
            eucCsvEntity.setカナ氏名(RString.EMPTY);
            eucCsvEntity.set年齢(RString.EMPTY);
            eucCsvEntity.set住民種別(RString.EMPTY);
            eucCsvEntity.set郵便番号(RString.EMPTY);
            eucCsvEntity.set住所(RString.EMPTY);
            eucCsvEntity.set行政区コード(RString.EMPTY);
            eucCsvEntity.set行政区(RString.EMPTY);
        }

        eucCsvEntity.set居宅支援事業者番号(entity.get計画事業者番号() != null ? entity.get計画事業者番号() : RString.EMPTY);
        if (entity.is自己作成()) {
            eucCsvEntity.set居宅支援事業者名称(entity.get計画事業者名() != null ? entity.get計画事業者名() : RString.EMPTY);
        } else {
            eucCsvEntity.set居宅支援事業者名称(自己作成);
        }
        if (entity.is老齢福祉年金受給者()) {
            eucCsvEntity.set老齢福祉年金受給(ASTERISK);
        } else {
            eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        }
        if (entity.is生活保護受給者()) {
            eucCsvEntity.set生活保護受給区分(ASTERISK);
        } else {
            eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        }
        if (entity.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set課税区分(課);
        } else {
            eucCsvEntity.set課税区分(RString.EMPTY);
        }
        if (entity.is所得税課税者()) {
            eucCsvEntity.set所得税課税区分(課);
        } else {
            eucCsvEntity.set所得税課税区分(RString.EMPTY);
        }
        eucCsvEntity.set入所施設コード(entity.get入所施設コード());
        eucCsvEntity.set入所施設名称(entity.get入所施設名称());
        if (entity.is旧措置者フラグ()) {
            eucCsvEntity.set旧措置(旧措置者);
        } else {
            eucCsvEntity.set旧措置(RString.EMPTY);
        }
        if (entity.get厚労省IF識別コード() != null && entity.get要介護状態区分コード() != null) {
            eucCsvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(
                    KoroshoInterfaceShikibetsuCode.toValue(entity.get厚労省IF識別コード()), entity.get要介護状態区分コード()).getName());
        } else {
            eucCsvEntity.set要介護度(RString.EMPTY);
        }
        eucCsvEntity.set認定日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定年月日()));
        eucCsvEntity.set認定開始日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間開始日()));
        eucCsvEntity.set認定終了日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間終了日()));
    }

    private void seteucCsvEntity軽減の情報_NotNull(
            ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        ShakaifukuRiyoshaFutanKeigen shakaifukuriyoshafutankeigen = new ShakaifukuRiyoshaFutanKeigen(entity.get社会福祉法人等利用者負担軽減の情報());
        eucCsvEntity.set証保険者番号(
                shakaifukuriyoshafutankeigen.get証記載保険者番号() != null ? shakaifukuriyoshafutankeigen.get証記載保険者番号().value() : RString.EMPTY);
        eucCsvEntity.set確認番号(shakaifukuriyoshafutankeigen.get確認番号());
        if (shakaifukuriyoshafutankeigen.get決定区分() != null) {
            if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認する)) {
                eucCsvEntity.set決定区分(承認);
            } else if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認しない)) {
                eucCsvEntity.set決定区分(却下);
            } else {
                eucCsvEntity.set決定区分(RString.EMPTY);
            }
        } else {
            eucCsvEntity.set決定区分(RString.EMPTY);
        }
        eucCsvEntity.set減免事由(RString.EMPTY);
        eucCsvEntity.set減免申請日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get申請年月日()));
        eucCsvEntity.set減免決定日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get決定年月日()));
        eucCsvEntity.set減免適用日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get適用開始年月日()));
        eucCsvEntity.set減免有効期限(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get適用終了年月日()));
        if (shakaifukuriyoshafutankeigen.get軽減率_分子() != null) {
            eucCsvEntity.set軽減率分子(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分子(RString.EMPTY);
        }
        if (shakaifukuriyoshafutankeigen.get軽減率_分母() != null) {
            eucCsvEntity.set軽減率分母(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分母(RString.EMPTY);
        }
        if (shakaifukuriyoshafutankeigen.is居宅サービス限定()) {
            eucCsvEntity.set対象サービスの制限(居宅サービスのみ.concat(POINT));
        }
        if (shakaifukuriyoshafutankeigen.is居住費_食費のみ()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(居住費食費のみ.concat(POINT)));
        }
        if (shakaifukuriyoshafutankeigen.is旧措置者ユニット型個室のみ()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(旧措ユ個のみ.concat(POINT)));
        }
        if (eucCsvEntity.get対象サービスの制限() != null) {
            int length = eucCsvEntity.get対象サービスの制限().length();
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().substring(NO_0, length - NO_1));
        } else {
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        }
    }

    private void setNoRennbannCsvEntityEmptyNo世帯員(ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity) {
        eucCsvEntity.setカナ氏名(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set入所施設コード(RString.EMPTY);
        eucCsvEntity.set入所施設名称(RString.EMPTY);
        eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者番号(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set所得税課税区分(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set決定区分(RString.EMPTY);
        eucCsvEntity.set減免事由(RString.EMPTY);
        eucCsvEntity.set減免有効期限(RString.EMPTY);
        eucCsvEntity.set減免決定日(RString.EMPTY);
        eucCsvEntity.set減免申請日(RString.EMPTY);
        eucCsvEntity.set減免適用日(RString.EMPTY);
        eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        eucCsvEntity.set確認番号(RString.EMPTY);
        eucCsvEntity.set老齢福祉年金受給(RString.EMPTY);
        eucCsvEntity.set行政区(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set証保険者番号(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set課税区分(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set軽減率分子(RString.EMPTY);
        eucCsvEntity.set軽減率分母(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
    }

    private void set世帯員NoRennbannCsvEntity(ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity, Setaiinshotokujoho joho) {
        if (joho.get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(joho.get世帯員宛名());
            eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
            eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
        } else {
            eucCsvEntity.set世帯員氏名(RString.EMPTY);
            eucCsvEntity.set世帯員住民種別(RString.EMPTY);
        }
        if (!joho.get本人課税区分().isNullOrEmpty() && joho.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set世帯員課税区分(課);
        } else {
            eucCsvEntity.set世帯員課税区分(RString.EMPTY);
        }

        if (joho.get課税所得額().intValue() > 0) {
            eucCsvEntity.set世帯員所得税課税区分(課);
        } else {
            eucCsvEntity.set世帯員所得税課税区分(RString.EMPTY);
        }
    }

    private void setNoRennbannEucCsvEntity(
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        if (entity.get社会福祉法人等利用者負担軽減の情報() != null) {
            setNoRennbanneucCsvEntity軽減の情報_NotNull(eucCsvEntity, entity);
        } else {
            eucCsvEntity.set証保険者番号(RString.EMPTY);
            eucCsvEntity.set確認番号(RString.EMPTY);
            eucCsvEntity.set決定区分(RString.EMPTY);
            eucCsvEntity.set減免事由(RString.EMPTY);
            eucCsvEntity.set減免申請日(RString.EMPTY);
            eucCsvEntity.set減免決定日(RString.EMPTY);
            eucCsvEntity.set減免適用日(RString.EMPTY);
            eucCsvEntity.set減免有効期限(RString.EMPTY);
            eucCsvEntity.set軽減率分子(RString.EMPTY);
            eucCsvEntity.set軽減率分母(RString.EMPTY);
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        }
        eucCsvEntity.set被保険者番号(entity.get被保険者番号() != null ? entity.get被保険者番号().value() : RString.EMPTY);
        if (entity.get宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set郵便番号(kojin.get住所().get住所());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        } else {
            eucCsvEntity.set識別コード(RString.EMPTY);
            eucCsvEntity.set住所コード(RString.EMPTY);
            eucCsvEntity.set氏名(RString.EMPTY);
            eucCsvEntity.setカナ氏名(RString.EMPTY);
            eucCsvEntity.set年齢(RString.EMPTY);
            eucCsvEntity.set住民種別(RString.EMPTY);
            eucCsvEntity.set郵便番号(RString.EMPTY);
            eucCsvEntity.set住所(RString.EMPTY);
            eucCsvEntity.set行政区コード(RString.EMPTY);
            eucCsvEntity.set行政区(RString.EMPTY);
        }

        eucCsvEntity.set居宅支援事業者番号(entity.get計画事業者番号() != null ? entity.get計画事業者番号() : RString.EMPTY);
        if (entity.is自己作成()) {
            eucCsvEntity.set居宅支援事業者名称(entity.get計画事業者名() != null ? entity.get計画事業者名() : RString.EMPTY);
        } else {
            eucCsvEntity.set居宅支援事業者名称(自己作成);
        }
        if (entity.is老齢福祉年金受給者()) {
            eucCsvEntity.set老齢福祉年金受給(ASTERISK);
        } else {
            eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        }
        if (entity.is生活保護受給者()) {
            eucCsvEntity.set生活保護受給区分(ASTERISK);
        } else {
            eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        }
        if (entity.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set課税区分(課);
        } else {
            eucCsvEntity.set課税区分(RString.EMPTY);
        }
        if (entity.is所得税課税者()) {
            eucCsvEntity.set所得税課税区分(課);
        } else {
            eucCsvEntity.set所得税課税区分(RString.EMPTY);
        }
        eucCsvEntity.set入所施設コード(entity.get入所施設コード());
        eucCsvEntity.set入所施設名称(entity.get入所施設名称());
        if (entity.is旧措置者フラグ()) {
            eucCsvEntity.set旧措置(旧措置者);
        } else {
            eucCsvEntity.set旧措置(RString.EMPTY);
        }
        if (entity.get厚労省IF識別コード() != null && entity.get要介護状態区分コード() != null) {
            eucCsvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(
                    KoroshoInterfaceShikibetsuCode.toValue(entity.get厚労省IF識別コード()), entity.get要介護状態区分コード()).getName());
        } else {
            eucCsvEntity.set要介護度(RString.EMPTY);
        }
        eucCsvEntity.set認定日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定年月日()));
        eucCsvEntity.set認定開始日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間開始日()));
        eucCsvEntity.set認定終了日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間終了日()));
    }

    private void setNoRennbanneucCsvEntity軽減の情報_NotNull(
            ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        ShakaifukuRiyoshaFutanKeigen shakaifukuriyoshafutankeigen = new ShakaifukuRiyoshaFutanKeigen(entity.get社会福祉法人等利用者負担軽減の情報());
        eucCsvEntity.set証保険者番号(
                shakaifukuriyoshafutankeigen.get証記載保険者番号() != null ? shakaifukuriyoshafutankeigen.get証記載保険者番号().value() : RString.EMPTY);
        eucCsvEntity.set確認番号(shakaifukuriyoshafutankeigen.get確認番号());
        if (shakaifukuriyoshafutankeigen.get決定区分() != null) {
            if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認する)) {
                eucCsvEntity.set決定区分(承認);
            } else if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認しない)) {
                eucCsvEntity.set決定区分(却下);
            } else {
                eucCsvEntity.set決定区分(RString.EMPTY);
            }
        } else {
            eucCsvEntity.set決定区分(RString.EMPTY);
        }
        eucCsvEntity.set減免事由(RString.EMPTY);
        eucCsvEntity.set減免申請日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get申請年月日()));
        eucCsvEntity.set減免決定日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get決定年月日()));
        eucCsvEntity.set減免適用日(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get適用開始年月日()));
        eucCsvEntity.set減免有効期限(toパターン32or34(日付スラッシュ編集_flag, shakaifukuriyoshafutankeigen.get適用終了年月日()));
        if (shakaifukuriyoshafutankeigen.get軽減率_分子() != null) {
            eucCsvEntity.set軽減率分子(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分子(RString.EMPTY);
        }
        if (shakaifukuriyoshafutankeigen.get軽減率_分母() != null) {
            eucCsvEntity.set軽減率分母(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分母(RString.EMPTY);
        }
        if (shakaifukuriyoshafutankeigen.is居宅サービス限定()) {
            eucCsvEntity.set対象サービスの制限(居宅サービスのみ.concat(POINT));
        }
        if (shakaifukuriyoshafutankeigen.is居住費_食費のみ()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(居住費食費のみ.concat(POINT)));
        }
        if (shakaifukuriyoshafutankeigen.is旧措置者ユニット型個室のみ()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(旧措ユ個のみ.concat(POINT)));
        }
        if (eucCsvEntity.get対象サービスの制限() != null) {
            int length = eucCsvEntity.get対象サービスの制限().length();
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().substring(NO_0, length - NO_1));
        } else {
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
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

    private RString toパターン32or34(boolean flag, FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        if (flag) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return date.seireki().
                    separator(Separator.NONE).
                    fillType(FillType.ZERO).
                    toDateString();
        }
    }

    private void 認定者バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString 帳票名 = new RString("社会福祉法人軽減認定者リスト");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("あり");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        set出力条件(出力条件);
        builder.append(抽出対象);
        builder.append(ChushutsuTaisho.toValue(processParameter.get抽出対象()));
        出力条件.add(builder.toRString());
        出力条件.add(CSV出力設定);
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
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(noRennbanneucCsvWriter.getCount()));
        RString 帳票名 = new RString("社会福祉法人軽減該当者リスト");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("あり");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        set出力条件(出力条件);
        builder.append(受給者区分);
        builder.append(JukyushaKubun.toValue(processParameter.get受給者区分()));
        出力条件.add(builder.toRString());
        builder.append(世帯非課税等);
        for (int i = 0; i < processParameter.get世帯非課税等().size(); i++) {
            if (i == NO_0) {
                builder.append(HihokenshaKeizaiJokyo.toValue(processParameter.get世帯非課税等().get(i)));
                出力条件.add(builder.toRString());
            } else {
                builder.append(SPACE);
                builder.append(HihokenshaKeizaiJokyo.toValue(processParameter.get世帯非課税等().get(i)));
                出力条件.add(builder.toRString());
            }
        }
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
        if (processParameter.get対象期間指定().equals(new RString("1"))) {
            builder.append(対象年度);
            if (null != processParameter.get対象年度の開始年月日()) {
                builder.append(new RString(processParameter.get対象年度の開始年月日().toString()));
            }
            builder.append(カラ);
            if (null != processParameter.get対象年度の終了年月日()) {
                builder.append(new RString(processParameter.get対象年度の終了年月日().toString()));
            }
            出力条件.add(builder.toRString());
            builder.append(課税判定等基準日);
            builder.append(new RString(processParameter.get課税判定等基準日().toString()));
            出力条件.add(builder.toRString());
        }
        if (processParameter.get対象期間指定().equals(new RString("2"))) {
            builder.append(基準日);
            builder.append(new RString(processParameter.get基準日().toString()));
            出力条件.add(builder.toRString());
        }
        builder.append(所得年度);
        builder.append(new RString(processParameter.get所得年度().toString()));
        出力条件.add(builder.toRString());
        builder.append(旧措置者区分);
        builder.append(processParameter.get旧措置者区分());
        出力条件.add(builder.toRString());
        builder.append(世帯表示);
        builder.append(SetaiHyoji.toValue(processParameter.get世帯表示()));
        出力条件.add(builder.toRString());
    }

    private static <T extends Enum<T> & IReportItems> RString createOrderSqlStr(Class<T> clazz, IOutputOrder outputOrder) {
        ReportItemsMap reportItems = new ReportItemsMap(Arrays.<IReportItems>asList(clazz.getEnumConstants()));
        orderByClause = new RStringBuilder("order by");
        space = new RString(" ");
        comma = new RString(",");
        commaCount = 0;
        if (outputOrder.get設定項目リスト().isEmpty()) {
            return RString.EMPTY;
        }
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {

            if (commaCount != 0) {
                orderByClause = orderByClause.append(space).append(comma).append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());

            } else {
                setSortItem.get項目名();
                setSortItem.getDB項目名();
                setSortItem.get帳票フィールド名();
                orderByClause = orderByClause.append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());
            }
            commaCount++;
        }

        return orderByClause.toRString();
    }

    private static class ReportItemsMap {

        private Map<RString, IReportItems> map;

        public ReportItemsMap(List<IReportItems> items) {
            this.map = new HashMap<>();
            for (IReportItems item : items) {
                this.map.put(item.get項目ID(), item);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        RString getMyBatis項目名(RString 項目ID) throws IllegalArgumentException {
            if (this.map.containsKey(項目ID)) {
                return this.map.get(項目ID).getMyBatis項目名();
            } else {
                throw new IllegalArgumentException(UrErrorMessages.データが存在しない.toString());
            }
        }
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
}
