/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehi.KogakuServicehiKyufugakuCalc_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuServicehiHanteiErrorCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.HanteiEraaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorlist.KogakuSogoJigyoServicehiHanteiErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * エラーリスト発行処理_高額総合事業サービス費判定エラーリスト
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class PrtErrorListJigyoProcess extends BatchProcessBase<HanteiEraaResultEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku."
            + "IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select高額総合事業サービス費判定エラーリスト");
    private static final ReportId 帳票分類ID = new ReportId("DBC200076_KogakuSogoJigyoServicehiHanteiErrorIchiran");
    private static final RString 出力ファイル名 = new RString("KogakuSogoJigyoServicehiHanteiErrorIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200076"));
    private static final Code EUC_CODE = new Code("0003");
    private static final RString EUC_CODE_NAME = new RString("被保険者番号");
    private static final RString 作成 = new RString("作成");
    private static final RString 審査分 = new RString("審査分");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private CsvWriter<KogakuServicehiHanteiErrorCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> reportSourceWriter;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private List<PersonalData> personalDataList;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private List<KogakuSogoJigyoServicehiHanteiErrorListEntity> errorList;
    private int 連番;
    private RString 並び順の１件目;
    private RString 並び順の２件目;
    private RString 並び順の３件目;
    private RString 並び順の４件目;
    private RString 並び順の５件目;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        出力項目リスト = new ArrayList<>();
        errorList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        連番 = 1;
        if (!RString.isNullOrEmpty(parameter.get出力順ID())) {
            get出力順(parameter.get出力順ID());
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200077.getReportId().value()).create();
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
            new KogakuSogoJigyoServicehiHanteiErrorIchiranReport(errorList, 地方公共団体, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目リスト, YMDHMS.now()).writeBy(reportSourceWriter);
        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.log(AccessLogType.更新, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private KogakuSogoJigyoServicehiHanteiErrorListEntity createReportData(HanteiEraaResultEntity entity) {
        KogakuSogoJigyoServicehiHanteiErrorListEntity 高額介護サービス費判定エラーEntity = new KogakuSogoJigyoServicehiHanteiErrorListEntity();
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
        if (INT_0 < 出力項目リスト.size()) {
            csvEntity.set出力順1(出力項目リスト.get(INT_0));
            if (INT_0 < 改頁項目リスト.size()) {
                csvEntity.set改ページ1(改頁項目リスト.get(INT_0));
            }
        }
        if (INT_1 < 出力項目リスト.size()) {
            csvEntity.set出力順2(出力項目リスト.get(INT_1));
            if (INT_1 < 改頁項目リスト.size()) {
                csvEntity.set改ページ2(改頁項目リスト.get(INT_1));
            }
        }
        if (INT_2 < 出力項目リスト.size()) {
            csvEntity.set出力順3(出力項目リスト.get(INT_2));
            if (INT_2 < 改頁項目リスト.size()) {
                csvEntity.set改ページ3(改頁項目リスト.get(INT_2));
            }
        }
        if (INT_3 < 出力項目リスト.size()) {
            csvEntity.set出力順4(出力項目リスト.get(INT_3));
            if (INT_3 < 改頁項目リスト.size()) {
                csvEntity.set改ページ4(改頁項目リスト.get(INT_3));
            }
        }
        if (INT_4 < 出力項目リスト.size()) {
            csvEntity.set出力順5(出力項目リスト.get(INT_4));
            if (INT_4 < 改頁項目リスト.size()) {
                csvEntity.set改ページ5(改頁項目リスト.get(INT_4));
            }
        }
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

        if (審査年月 != null) {
            RString format審査年月From = 審査年月.wareki().firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString format審査年月To = RDate.getNowDate().getYearMonth().wareki().firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            return format審査年月From.concat(RString.FULL_SPACE)
                    .concat(format審査年月To).concat(RString.FULL_SPACE)
                    .concat(審査分);
        }
        return RString.EMPTY;
    }

    private void get出力順(RString 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                }
                if (i == INT_1) {
                    並び順の１件目 = setSortItem.get項目名();
                } else if (i == INT_2) {
                    並び順の２件目 = setSortItem.get項目名();
                } else if (i == INT_3) {
                    並び順の３件目 = setSortItem.get項目名();
                } else if (i == INT_4) {
                    並び順の４件目 = setSortItem.get項目名();
                } else if (i == INT_5) {
                    並び順の５件目 = setSortItem.get項目名();
                }
            }
            i = i + INT_1;
        }
    }

}
