/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120860;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikagoketteikohifutanshain.SogojigyohiKagoKetteiKohifutanshaInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha.SogoKohifutanshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
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
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表作成。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteiKohifutanshaDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<SogoKohifutanshaEntity> {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private Set<ShikibetsuCode> 識別コードset;
    private RString 一覧ファイルパス;
    private IOutputOrder 出力順情報;
    private Map<RString, RString> 出力順Map;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private List<RString> pageBreakKeys;
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
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200086_SogojigyohiKagoKetteitsuchishoTorikomiIchiranKohi.csv");
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteikohifutansha."
                    + "ISogoKohifutanshaChohyoMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200086");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString 固定改頁項目ID = new RString("0134");
    private static final RString 作成 = new RString("作成");
    private static final RString CODE = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private List<RString> 改頁項目リスト;
    private int 連番;
    private SogoKohifutanshaEntity lastEntity;

    private FileSpoolManager manager;
    @BatchWriter
    private BatchReportWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter csvWriter;

    @Override
    protected void initialize() {
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        this.出力順情報 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == this.出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        this.pageBreakKeys = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        RString orderByStr = MyBatisOrderByClauseCreator.create(SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder.class, this.出力順情報);
        if (null != this.出力順情報) {
            int i = 0;
            for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
                if (i == INDEX_1) {
                    出力順Map.put(KEY_並び順の２件目, item.get項目名());
                } else if (i == INDEX_2) {
                    出力順Map.put(KEY_並び順の３件目, item.get項目名());
                } else if (i == INDEX_3) {
                    出力順Map.put(KEY_並び順の４件目, item.get項目名());
                } else if (i == INDEX_4) {
                    出力順Map.put(KEY_並び順の５件目, item.get項目名());
                } else if (i == INDEX_5) {
                    出力順Map.put(KEY_並び順の６件目, item.get項目名());
                }
                i = i + 1;
            }
        }
        帳票データの取得Parameter.set出力順(orderByStr);
        this.識別コードset = new HashSet();
        連番 = 0;
        pageBreakKeys.add(固定改頁項目ID);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> breaker = new SogojigyohiKagoKetteitsuchishoTorikomiPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200086.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        一覧ファイルパス = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(一覧ファイルパス)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected void keyBreakProcess(SogoKohifutanshaEntity t) {
    }

    @Override
    protected void usualProcess(SogoKohifutanshaEntity 帳票出力対象データ) {

        SogoKohifutanshaEntity beforeEntity = getBefore();
        SogojigyohiKagoKetteiKohifutanshaInCsvEntity output;
        if (beforeEntity != null) {
            if (!beforeEntity.get証記載保険者番号().equals(帳票出力対象データ.get証記載保険者番号())) {
                output = 集計項目作成(beforeEntity);
                csvWriter.writeLine(output);
                連番 = 連番 + 1;
                SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport report = new SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport(
                        beforeEntity, 出力順Map, parameter.get処理年月(), parameter.getシステム日付(), true, 連番);
                report.writeBy(reportSourceWriter);
                output = 書き込むデータ作成(帳票出力対象データ, false);
                csvWriter.writeLine(output);
            } else {
                output = 書き込むデータ作成(帳票出力対象データ, false);
                csvWriter.writeLine(output);
                連番 = 連番 + 1;
                SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport report = new SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport(
                        beforeEntity, 出力順Map, parameter.get処理年月(), parameter.getシステム日付(), false, 連番);
                report.writeBy(reportSourceWriter);
            }

        } else {
            output = 書き込むデータ作成(帳票出力対象データ, true);
            csvWriter.writeLine(output);
        }
        lastEntity = 帳票出力対象データ;

    }

    @Override
    protected void afterExecute() {
        if (null != lastEntity) {
            連番 = 連番 + 1;
            SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport report = new SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport(
                    lastEntity, 出力順Map, parameter.get処理年月(), parameter.getシステム日付(), true, 連番);
            report.writeBy(reportSourceWriter);

            SogojigyohiKagoKetteiKohifutanshaInCsvEntity output = 集計項目作成(lastEntity);
            csvWriter.writeLine(output);
        }
        this.csvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(一覧ファイルパス, accessLogUUID);
        } else {
            manager.spool(一覧ファイルパス);
        }
    }

    private SogojigyohiKagoKetteiKohifutanshaInCsvEntity 書き込むデータ作成(SogoKohifutanshaEntity 出力データ, boolean ヘッダーフラグ) {
        SogojigyohiKagoKetteiKohifutanshaInCsvEntity output = new SogojigyohiKagoKetteiKohifutanshaInCsvEntity();
        if (ヘッダーフラグ) {
            output.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = parameter.getシステム日付().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(作成);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        } else {
            output.set取込年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        output.set公費負担者番号(getColumnValue(出力データ.get証記載保険者番号()));
        output.set公費負担者名(出力データ.get証記載保険者名());
        output.set取扱年月(出力データ.get取扱年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        output.set事業者番号(getColumnValue(出力データ.get事業所番号()));
        output.set事業者名(出力データ.get事業所名());
        output.set公費受給者番号(出力データ.get公費受給者番号());
        output.set公費受給者氏名(出力データ.get宛名名称());
        output.set証記載保険者番号(getColumnValue(出力データ.get公費証記載保険者番号()));
        output.set被保険者番号(getColumnValue(出力データ.get登録被保険者番号()));
        output.setサービス提供年月(出力データ.getサービ提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        output.setサービス種類コード(getColumnValue(出力データ.getサービス種類コード()));
        output.setサービス種類名(出力データ.getサービス種類名());
        output.set過誤申立事由コード(getColumnValue(出力データ.get過誤申立事由コード()));
        output.set過誤申立事由(出力データ.get過誤申立事由());
        output.set単位数(doカンマ編集(出力データ.get単位数()));
        output.set負担額(doカンマ編集(出力データ.get保険者負担額()));

        if (null != 出力データ.get識別コード() && !出力データ.get識別コード().isEmpty()) {
            ShikibetsuCode 識別コード = new ShikibetsuCode(出力データ.get識別コード());
            if (!識別コード.isEmpty() && !識別コードset.contains(識別コード)) {
                識別コードset.add(識別コード);
                PersonalData personalData = getPersonalData(出力データ);
                personalDataList.add(personalData);
            }
        }
        return output;
    }

    private SogojigyohiKagoKetteiKohifutanshaInCsvEntity 集計項目作成(SogoKohifutanshaEntity 集計項目) {
        SogojigyohiKagoKetteiKohifutanshaInCsvEntity output = new SogojigyohiKagoKetteiKohifutanshaInCsvEntity();
        output.set公費負担者番号(getColumnValue(集計項目.get証記載保険者番号()));
        output.set公費負担者名(集計項目.get証記載保険者名());
        output.set総合事業費_件数(doカンマ編集(集計項目.get介護給付費件数()));
        output.set総合事業費_単位数(doカンマ編集(集計項目.get介護給付費単位数()));
        output.set総合事業費_負担額(doカンマ編集(集計項目.get介護給付費保険者負担額()));
        return output;
    }

    private PersonalData getPersonalData(SogoKohifutanshaEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code(CODE), 被保険者番号,
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private static RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
