/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranOutput;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuServicehiTaishoshaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 対象者一覧表発行処理_高額総合事業サービス費対象者一覧
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class PrtTaishoshaIchiranJigyoProcess extends BatchProcessBase<KogakuKaigoServicehiReportEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku."
            + "IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select高額総合事業サービス費対象者一覧");
    private static final ReportId 帳票分類ID = new ReportId("DBC200077_KogakuSogoJigyoServiceHiTaishoshaIchiran");
    private static final RString 出力ファイル名 = new RString("KogakuSogoJigyoServiceHiTaishoshaIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200077"));
    private static final Code EUC_CODE = new Code("0003");
    private static final RString EUC_CODE_NAME = new RString("被保険者番号");
    private static final RString 作成 = new RString("作成");
    private static final RString TEXT_単 = new RString("単");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private CsvWriter<KogakuServicehiTaishoshaIchiranCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> reportSourceWriter;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private List<PersonalData> personalDataList;
    private RString 出力順;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> breakKeyList;
    private int 連番;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        出力項目リスト = new ArrayList<>();
        breakKeyList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        連番 = 1;
        if (!RString.isNullOrEmpty(parameter.get出力順ID())) {
            get出力順(parameter.get出力順ID());
        }
    }

    @Override
    protected IBatchReader createReader() {
        KyufuJissekiKihonKogakuMybatisParameter param = new KyufuJissekiKihonKogakuMybatisParameter();
        param.set出力順(出力順);
        return new BatchDbReader(MYBATISPATH, param);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> breaker = new KogakuSogoJigyoServiceHiTaishoshaIchiranPageBreak(breakKeyList);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200077.getReportId().value())
                .addBreak(breaker).create();
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
    protected void process(KogakuKaigoServicehiReportEntity entity) {
        KogakuSogoJigyoServiceHiTaishoshaIchiranEntity 対象者一覧表Entity = createReportData(entity);
        KogakuSogoJigyoServiceHiTaishoshaIchiranReport report = new KogakuSogoJigyoServiceHiTaishoshaIchiranReport(対象者一覧表Entity,
                YMDHMS.now(), 地方公共団体, 出力項目リスト, 改頁項目リスト, 連番);
        report.writeBy(reportSourceWriter);
        eucCsvWriter.writeLine(createCsvData(entity));
        personalDataList.add(toPersonalData(entity));
        連番 = 連番 + 1;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.log(AccessLogType.更新, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private KogakuSogoJigyoServiceHiTaishoshaIchiranEntity createReportData(KogakuKaigoServicehiReportEntity entity) {
        KogakuSogoJigyoServiceHiTaishoshaIchiranEntity 対象者一覧表Entity = new KogakuSogoJigyoServiceHiTaishoshaIchiranEntity();
        対象者一覧表Entity.set審査年月(parameter.get処理年月());
        対象者一覧表Entity.set市町村コード(entity.get市町村コード());
        対象者一覧表Entity.set被保険者番号(entity.get被保険者番号());
        対象者一覧表Entity.set被保険者名(entity.get名称().value());
        対象者一覧表Entity.set識別コード(entity.get識別コード());
        対象者一覧表Entity.setサービス提供年月(entity.getサービス提供年月());
        対象者一覧表Entity.set要介護認定状態区分コード(entity.get要介護認定状態区分コード());
        対象者一覧表Entity.set世帯コード(entity.get世帯コード());
        対象者一覧表Entity.set利用者負担額(entity.get利用者負担額());
        対象者一覧表Entity.set支給予定金額(entity.get支給予定金額());
        対象者一覧表Entity.set備考(entity.get備考欄個人所得区分());
        対象者一覧表Entity.set証記載保険者番号(entity.get証記載保険者番号());
        対象者一覧表Entity.set郵便番号(entity.get郵便番号());
        対象者一覧表Entity.set町域コード(entity.get町域コード());
        対象者一覧表Entity.set行政区コード(entity.get行政区コード());
        対象者一覧表Entity.set氏名５０音カナ(entity.get氏名５０音カナ());
        return 対象者一覧表Entity;
    }

    private KogakuServicehiTaishoshaIchiranCSVEntity createCsvData(KogakuKaigoServicehiReportEntity entity) {
        KogakuServicehiTaishoshaIchiranCSVEntity csvEntity = new KogakuServicehiTaishoshaIchiranCSVEntity();
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
        csvEntity.set被保険者名(getColumnValue(entity.get名称()));
        csvEntity.set旧措置(entity.is旧措置者フラグ() ? KyusochishaKubun.旧措置者.get名称()
                : KyusochishaKubun.旧措置者以外.get名称());
        csvEntity.set要介護度(YokaigoJotaiKubun.toValue(getColumnValue(entity.get要介護認定状態区分コード())).get名称());
        FlexibleDate 認定有効開始年月日 = entity.get認定有効期間開始年月日();
        if (認定有効開始年月日 != null) {
            csvEntity.set認定有効開始年月日(new RString(認定有効開始年月日.toString()));
        }
        FlexibleDate 認定有効終了年月日 = entity.get認定有効期間終了年月日();
        if (認定有効終了年月日 != null) {
            csvEntity.set認定有効開始年月日(new RString(認定有効終了年月日.toString()));
        }
        csvEntity.set世帯番号(getColumnValue(entity.get世帯コード()));
        csvEntity.set単独合算(TEXT_単);
        Decimal 支給予定金額 = entity.get支給予定金額();
        csvEntity.set支給予定金額(支給予定金額 != null ? new RString(支給予定金額.toString()) : RString.EMPTY);
        Decimal 自己負担額 = entity.get利用者負担額();
        csvEntity.set自己負担額(自己負担額 != null ? new RString(自己負担額.toString()) : RString.EMPTY);
        csvEntity.set備考(entity.get備考欄個人所得区分());
        return csvEntity;

    }

    private PersonalData toPersonalData(KogakuKaigoServicehiReportEntity entity) {

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

    private void get出力順(RString 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        出力順 = MyBatisOrderByClauseCreator.create(KogakuSogoJigyoServiceHiTaishoshaIchiranOutput.BreakerFieldsEnum.class,
                outputOrder);
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                    breakKeyList.add(setSortItem.get項目ID());
                }
            }
            i = i + INT_1;
        }
    }

}
