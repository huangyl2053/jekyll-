/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120180;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin.SogojigyohiKagoKetteInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin.SogojigyohiKagoKetteInPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * 一覧表作成。
 *
 * @reamsid_L DBC-2550-010 jianglaisheng
 */
public class SogojigyohiKagoKetteiInDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<SogojigyohiKagoKetteiInEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteiin."
                    + "ISogojigyohiKagoKetteiInMapper.get帳票出力対象データ");
    private int 連番;
    private IOutputOrder 並び順;
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private List<RString> pageBreakKeys;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200075");
    private RString eucFilePath;
    private static final RString 出力ファイル名
            = new RString("DBC200075_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private static final RString デフォルト出力順 = new RString(" ORDER BY DbWT3060.\"hdrShoHokenshaNo\" ASC ");
    private static final RString SAKUSEI = new RString("作成");
    private final Code code = new Code("0003");
    private final RString 被保険者番号 = new RString("被保険者番号");

    @BatchWriter
    private BatchReportWriter<SogojigyohiKagoKetteiInSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiKagoKetteiInSource> reportSourceWriter;
    private CsvWriter<SogojigyohiKagoKetteiInCsvEntity> sogojigyohiKagoKetteiInCsvWriter;

    private SogojigyohiKagoKetteiInEntity lastEntity;
    private Map<RString, RString> 出力順Map;
    private Set<ShikibetsuCode> 識別コードset;

    @Override
    protected void initialize() {
        連番 = 1;
        pageBreakKeys = new ArrayList<>();
        証記載保険者番号 = null;
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        識別コードset = new HashSet<>();
        出力順Map = new HashMap<>();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        lastEntity = new SogojigyohiKagoKetteiInEntity();
        並び順 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(SogojigyohiKagoKetteInOutPutOrder.class, 並び順);
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = 出力順.split(コンマ.toString());
            出力順 = デフォルト出力順;
            if (出力順BODY.size() > 1) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    出力順 = 出力順.concat(コンマ).concat(出力順BODY.get(i));
                }
            }
        }
        int index = 0;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (index == INDEX_1) {
                    出力順Map.put(KEY_並び順の２件目, item.get項目名());
                } else if (index == INDEX_2) {
                    出力順Map.put(KEY_並び順の３件目, item.get項目名());
                } else if (index == INDEX_3) {
                    出力順Map.put(KEY_並び順の４件目, item.get項目名());
                } else if (index == INDEX_4) {
                    出力順Map.put(KEY_並び順の５件目, item.get項目名());
                } else if (index == INDEX_5) {
                    出力順Map.put(KEY_並び順の６件目, item.get項目名());
                }
                index = index + 1;
            }
        }
        帳票データの取得Parameter.set出力順(出力順);
        pageBreakKeys.add(new RString(SogojigyohiKagoKetteiInSource.ReportSourceFields.shoKisaiHokenshaNo.name()));
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiKagoKetteiInSource> breaker = new SogojigyohiKagoKetteInPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200075.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        sogojigyohiKagoKetteiInCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void keyBreakProcess(SogojigyohiKagoKetteiInEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiKagoKetteiInEntity entity) {
        boolean 集計Flag = false;
        ShoKisaiHokenshaNo this証記載保険者番号 = entity.get証記載保険者番号();
        if (証記載保険者番号 != null && !証記載保険者番号.equals(this証記載保険者番号)) {
            集計Flag = true;
        }
        証記載保険者番号 = this証記載保険者番号;
        if (集計Flag) {
            SogojigyohiKagoKetteiInReport report = new SogojigyohiKagoKetteiInReport(lastEntity,
                    出力順Map,
                    parameter.get処理年月(),
                    parameter.getシステム日付(),
                    連番,
                    true);
            report.writeBy(reportSourceWriter);
        }
        SogojigyohiKagoKetteiInReport report = new SogojigyohiKagoKetteiInReport(entity,
                出力順Map,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                連番,
                false);
        report.writeBy(reportSourceWriter);
        SogojigyohiKagoKetteiInCsvEntity output = do帳票のCSVファイル作成(entity,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                集計Flag);
        sogojigyohiKagoKetteiInCsvWriter.writeLine(output);
        連番++;
        lastEntity = entity;
    }

    @Override
    protected void afterExecute() {
        SogojigyohiKagoKetteiInReport report = new SogojigyohiKagoKetteiInReport(lastEntity,
                出力順Map,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                連番,
                true);
        report.writeBy(reportSourceWriter);
        SogojigyohiKagoKetteiInCsvEntity output = do帳票のCSVファイル作成(lastEntity,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                true);
        sogojigyohiKagoKetteiInCsvWriter.writeLine(output);
        sogojigyohiKagoKetteiInCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private SogojigyohiKagoKetteiInCsvEntity do帳票のCSVファイル作成(SogojigyohiKagoKetteiInEntity entity,
            FlexibleYearMonth 処理年月, RDateTime 作成日時, boolean 集計Flag) {
        SogojigyohiKagoKetteiInCsvEntity output = new SogojigyohiKagoKetteiInCsvEntity();
        if (連番 == 1) {
            output.set処理年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(SAKUSEI));
        } else {
            output.set処理年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }

        output.set証記載保険者番号(getColumnValue(entity.get証記載保険者番号()));
        output.set証記載保険者名(entity.get証記載保険者名());

        if (集計Flag) {
            output.set総合事業費_件数(new RString(entity.get介護給付費件数()));
            output.set総合事業費_単位数(doカンマ編集(entity.get介護給付費単位数()));
            output.set総合事業費_負担額(doカンマ編集(entity.get介護給付費保険者負担額()));
        } else {
            output.set取扱年月(doパターン54(entity.get取扱年月()));
            output.set事業者番号(getColumnValue(entity.get事業者番号()));
            output.set事業者名(entity.get事業者名());
            output.set被保険者番号(getColumnValue(entity.get被保険者番号()));
            output.set被保険者名(entity.get被保険者名());
            output.setサービス提供年月(doパターン54(entity.getサービ提供年月()));
            output.setサービス種類コード(getColumnValue(entity.getサービス種類コード()));
            output.setサービス種類名(entity.getサービス種類名());
            output.set過誤申立事由コード(getColumnValue(entity.get過誤申立事由コード()));
            output.set過誤申立事由(entity.get過誤申立事由());
            output.set単位数(doカンマ編集(entity.get単位数()));
            output.set負担額(doカンマ編集(entity.get保険者負担額()));

        }

        if (null != entity.get識別コード() && !entity.get識別コード().isEmpty()
                && !識別コードset.contains(entity.get識別コード())) {
            PersonalData personalData = getPersonalData(entity);
            personalDataList.add(personalData);
            識別コードset.add(entity.get識別コード());
        }
        return output;
    }

    private PersonalData getPersonalData(SogojigyohiKagoKetteiInEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 被保険者番号,
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
