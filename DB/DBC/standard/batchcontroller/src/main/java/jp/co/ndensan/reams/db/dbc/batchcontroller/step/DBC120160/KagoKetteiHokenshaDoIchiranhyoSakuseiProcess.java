/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteiHokenshaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120160.KagoKetteiHokenshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120160.KagoKetteiHokenshaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160.KagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付管理票情報取込の一覧表を作成する。
 *
 * @reamsid_L DBC-0980-300 zhangrui
 */
public class KagoKetteiHokenshaDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<KagoKetteiHokenshaChohyoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc120160.IKagoKetteiHokenshaChohyoMapper.get帳票出力対象データ");

    private static final RString エラーメッセージ = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 定数_作成 = new RString("作成");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200050");
    private static final RString 出力ファイル名 = new RString("DBC200050_KagoKetteitsuchishoTorikomiIchiranHokenshaBun.csv");
    private final Code code = new Code("0003");
    private final RString 被保険者番号 = new RString("被保険者番号");
    private KagoKetteiHokenshaDoIchiranhyoSakuseiProcessParameter parameter;
    private FileSpoolManager manager;
    private KagoKetteiHokenshaChohyoEntity entityTemp;
    private Set<ShikibetsuCode> 識別コードset;
    private List<PersonalData> personalDataList;
    private RString path;

    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private List<RString> pageBreakKeys;
    private int 連番;

    private BatchReportWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportWriter;
    private ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportSourceWriter;
    private CsvWriter csvWriter;

    @Override
    protected void initialize() {

        get出力順();
        識別コードset = new HashSet();
        personalDataList = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        PageBreaker<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> breaker
                = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunPageBreak(pageBreakKeys);
        reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200050.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(reportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        path = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(path)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected IBatchReader createReader() {
        KokuhorenIchiranhyoMybatisParameter mybatisParameter = new KokuhorenIchiranhyoMybatisParameter();
        mybatisParameter.set出力順(MyBatisOrderByClauseCreator.create(
                KagoKetteitsuchishoTorikomiIchiranHokenshaBunOutputOrder.class, 出力順情報));
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);
    }

    @Override
    protected void keyBreakProcess(KagoKetteiHokenshaChohyoEntity entity) {
        publish一覧表(getBefore(), is集計(getBefore(), entity));
    }

    @Override
    protected void usualProcess(KagoKetteiHokenshaChohyoEntity entity) {
        entityTemp = entity;
    }

    @Override
    protected void afterExecute() {

        publish一覧表(entityTemp, true);

        csvWriter.close();
        reportWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(path, accessLogUUID);
        } else {
            manager.spool(path);
        }

    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(parameter.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200050.getReportId(),
                    Long.parseLong(parameter.get出力順ID().toString()));
        }
        if (出力順情報 == null) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(エラーメッセージ.toString()).toString());
        }

        並び順リスト = new ArrayList<>();
        改頁リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            並び順リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }

    private boolean is集計(KagoKetteiHokenshaChohyoEntity before, KagoKetteiHokenshaChohyoEntity current) {
        return !before.get証記載保険者番号().equals(current.get証記載保険者番号());
    }

    private void publish一覧表(KagoKetteiHokenshaChohyoEntity entity, boolean 集計flg) {
        連番 = 連番 + 1;
        KagoKetteiHokenshaIchiranParameter パラメター = new KagoKetteiHokenshaIchiranParameter(改頁リスト,
                並び順リスト, entity, parameter.getシステム日付(), parameter.get処理年月(), 集計flg, 連番);
        KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport report
                = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport(パラメター);
        report.writeBy(reportSourceWriter);
        do一覧表CSV出力(entity, 集計flg);

    }

    private void do一覧表CSV出力(KagoKetteiHokenshaChohyoEntity entity, boolean 集計flg) {
        KagoKetteiHokenshaIchiranCSVEntity csvEntity = get一覧表CSV項目(entity);
        csvWriter.writeLine(csvEntity);
        if (集計flg) {
            KagoKetteiHokenshaIchiranCSVEntity 集計CsvEntity = get一覧表集計CSV項目(entity);
            csvWriter.writeLine(集計CsvEntity);
        }
    }

    private KagoKetteiHokenshaIchiranCSVEntity get一覧表CSV項目(KagoKetteiHokenshaChohyoEntity entity) {
        KagoKetteiHokenshaIchiranCSVEntity csvEntity = new KagoKetteiHokenshaIchiranCSVEntity();
        if (1 == 連番) {
            FlexibleYearMonth 処理年月 = parameter.get処理年月();
            csvEntity.set取込年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RDateTime 作成日時 = parameter.getシステム日付();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(定数_作成));
        }
        csvEntity.set証記載保険者番号(getColumnValue(entity.get証記載保険者番号()));
        csvEntity.set証記載保険者名(entity.get証記載保険者名());
        csvEntity.set取扱年月(doパターン54(entity.get取扱年月()));
        csvEntity.set事業者番号(getColumnValue(entity.get事業者番号()));
        csvEntity.set事業者名(entity.get事業者名());
        csvEntity.set被保険者番号(getColumnValue(entity.get被保険者番号()));
        csvEntity.set被保険者氏名(entity.get被保険者氏名());
        csvEntity.setサービス提供年月(doパターン54(entity.getサービ提供年月()));
        csvEntity.setサービス種類コード(getColumnValue(entity.getサービス種類コード()));
        csvEntity.setサービス種類名(entity.getサービス種類名());
        csvEntity.set過誤申立事由コード(getColumnValue(entity.get過誤申立事由コード()));
        csvEntity.set過誤申立事由(entity.get過誤申立事由());
        csvEntity.set単位数(doカンマ編集(entity.get単位数()));
        csvEntity.set負担額(doカンマ編集(entity.get保険者負担額()));

        if (entity.get識別コード() != null && !entity.get識別コード().isEmpty()
                && !this.識別コードset.contains(entity.get識別コード())) {
            this.識別コードset.add(entity.get識別コード());
            PersonalData personalData = getPersonalData(entity);
            this.personalDataList.add(personalData);
        }
        return csvEntity;
    }

    private KagoKetteiHokenshaIchiranCSVEntity get一覧表集計CSV項目(KagoKetteiHokenshaChohyoEntity entity) {
        KagoKetteiHokenshaIchiranCSVEntity csvEntity = new KagoKetteiHokenshaIchiranCSVEntity();
        csvEntity.set証記載保険者番号(getColumnValue(entity.get証記載保険者番号()));
        csvEntity.set証記載保険者名(entity.get証記載保険者名());
        csvEntity.set介護給付費_件数(doカンマ編集(entity.get介護給付費の件数()));
        csvEntity.set介護給付費_単位数(doカンマ編集(entity.get介護給付費の単位数()));
        csvEntity.set介護給付費_負担額(doカンマ編集(entity.get介護給付費の負担額()));
        csvEntity.set高額介護サービス費_件数(doカンマ編集(entity.get高額介護サービス費の件数()));
        csvEntity.set高額介護サービス費_単位数(doカンマ編集(entity.get高額介護サービス費の単位数()));
        csvEntity.set高額介護サービス費_負担額(doカンマ編集(entity.get高額介護サービス費の負担額()));
        csvEntity.set特定入所者介護サービス費等_件数(doカンマ編集(entity.get特定入所者介護費等の件数()));
        csvEntity.set特定入所者介護サービス費等_単位数(doカンマ編集(entity.get特定入所者介護費等の単位数()));
        csvEntity.set特定入所者介護サービス費等_負担額(doカンマ編集(entity.get特定入所者介護費等の負担額()));
        return csvEntity;
    }

    private PersonalData getPersonalData(KagoKetteiHokenshaChohyoEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 被保険者番号,
                getColumnValue(entity.get被保険者番号()));
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString doカンマ編集(int number) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(number), 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

}
