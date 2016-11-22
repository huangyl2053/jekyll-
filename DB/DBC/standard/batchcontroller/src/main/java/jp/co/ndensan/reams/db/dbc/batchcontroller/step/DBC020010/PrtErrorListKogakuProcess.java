/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehi.KogakuServicehiKyufugakuCalc_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuServicehiHanteiErrorCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.HanteiEraaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorlist.KogakuServicehiHanteiErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * エラーリスト発行処理_高額介護サービス費判定エラーリスト
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class PrtErrorListKogakuProcess extends BatchProcessBase<HanteiEraaResultEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku."
            + "IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select高額介護サービス費判定エラーリスト");
    private static final ReportId 帳票分類ID = new ReportId("DBC200018_KogakuServicehiHanteiErrorIchiran");
    private static final RString 出力ファイル名 = new RString("KogakuServicehiHanteiErrorIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200018"));
    private static final Code EUC_CODE = new Code("0003");
    private static final RString EUC_CODE_NAME = new RString("被保険者番号");
    private static final RString 作成 = new RString("作成");
    private static final RString TEXT_被保険者番号 = new RString("被保険者番号");
    private static final RString TEXT_識別コード = new RString("識別コード");
    private static final RString TEXT_基準年月日 = new RString("基準年月日");
    private static final RString TEXT_エラーコード = new RString("エラーコード");
    private static final RString TEXT_世帯コード = new RString("世帯コード");

    private CsvWriter<KogakuServicehiHanteiErrorCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<KogakuServicehiHanteiErrorIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuServicehiHanteiErrorIchiranSource> reportSourceWriter;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private List<PersonalData> personalDataList;
    private List<RString> 改頁項目リスト;
    private List<KogakuServicehiHanteiErrorListEntity> errorList;
    private int 連番;
    private RString 並び順の１件目;
    private RString 並び順の２件目;
    private RString 並び順の３件目;
    private RString 並び順の４件目;
    private RString 並び順の５件目;

    @Override
    protected void initialize() {
        並び順の１件目 = TEXT_被保険者番号;
        並び順の２件目 = TEXT_識別コード;
        並び順の３件目 = TEXT_基準年月日;
        並び順の４件目 = TEXT_エラーコード;
        並び順の５件目 = TEXT_世帯コード;
        personalDataList = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        errorList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        連番 = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200018.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(HanteiEraaResultEntity entity) {
        errorList.add(createReportData(entity));
        eucCsvWriter.writeLine(createCsvData(entity));
        personalDataList.add(toPersonalData(entity));
        連番 = 連番 + 1;
    }

    @Override
    protected void afterExecute() {
        if (errorList != null && !errorList.isEmpty()) {
            new KogakuServicehiHanteiErrorIchiranReport(errorList, 地方公共団体, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目リスト, YMDHMS.now()).writeBy(reportSourceWriter);
        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.log(AccessLogType.更新, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private KogakuServicehiHanteiErrorListEntity createReportData(HanteiEraaResultEntity entity) {
        KogakuServicehiHanteiErrorListEntity 高額介護サービス費判定エラーEntity = new KogakuServicehiHanteiErrorListEntity();
        高額介護サービス費判定エラーEntity.set審査年月(parameter.get処理年月());
        高額介護サービス費判定エラーEntity.set市町村コード(getColumnValue(entity.get市町村コード()));
        高額介護サービス費判定エラーEntity.set被保険者番号(getColumnValue(entity.get被保険者番号()));
        高額介護サービス費判定エラーEntity.set被保険者名(getColumnValue(entity.get被保険者名()));
        高額介護サービス費判定エラーEntity.set識別コード(entity.get識別コード());
        高額介護サービス費判定エラーEntity.setサービス提供年月(entity.getサービス提供年月());
        高額介護サービス費判定エラーEntity.set世帯コード(getColumnValue(entity.get世帯コード()));
        if (!RString.isNullOrEmpty(entity.getエラーコード())) {
            高額介護サービス費判定エラーEntity.setエラーコード(KogakuServicehiKyufugakuCalc_ErrorKubun.toValue(entity.getエラーコード()).get名称());
        }
        高額介護サービス費判定エラーEntity.set世帯員識別コード(getColumnValue(entity.get世帯員識別コード()));
        return 高額介護サービス費判定エラーEntity;
    }

    private KogakuServicehiHanteiErrorCSVEntity createCsvData(HanteiEraaResultEntity entity) {
        KogakuServicehiHanteiErrorCSVEntity csvEntity = new KogakuServicehiHanteiErrorCSVEntity();
        RString 作成年月日 = YMDHMS.now().getDate().seireki().separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString();
        RString 帳票作成日時 = YMDHMS.now().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        csvEntity.set作成日時(作成年月日.concat(帳票作成日時).concat(RString.FULL_SPACE).concat(作成));
        csvEntity.set審査年月(format審査年月(parameter.get処理年月()));
        csvEntity.set市町村コード(getColumnValue(entity.get市町村コード()));
        csvEntity.set市町村名称(地方公共団体.get市町村名());
        csvEntity.set出力順1(並び順の１件目);
        csvEntity.set出力順2(並び順の２件目);
        csvEntity.set出力順3(並び順の３件目);
        csvEntity.set出力順4(並び順の４件目);
        csvEntity.set出力順5(並び順の５件目);
        csvEntity.setNo(new RString(連番));
        csvEntity.set被保険者番号(getColumnValue(entity.get被保険者番号()));
        FlexibleYearMonth サービス提供年月 = entity.getサービス提供年月();
        if (サービス提供年月 != null) {
            csvEntity.setサービス提供年月(サービス提供年月.toDateString());
        }
        csvEntity.set被保険者名(getColumnValue(entity.get被保険者名()));
        if (!RString.isNullOrEmpty(entity.getエラーコード())) {
            csvEntity.setエラーコード(KogakuServicehiKyufugakuCalc_ErrorKubun.toValue(entity.getエラーコード()).get名称());
        }
        csvEntity.set世帯コード(getColumnValue(entity.get世帯コード()));
        csvEntity.set世帯員識別コード(getColumnValue(entity.get世帯員識別コード()));

        return csvEntity;

    }

    private PersonalData toPersonalData(HanteiEraaResultEntity entity) {

        ExpandedInformation expandedInformations = new ExpandedInformation(EUC_CODE, EUC_CODE_NAME,
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString format審査年月(FlexibleYearMonth 審査年月) {
        return 審査年月.wareki().firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
