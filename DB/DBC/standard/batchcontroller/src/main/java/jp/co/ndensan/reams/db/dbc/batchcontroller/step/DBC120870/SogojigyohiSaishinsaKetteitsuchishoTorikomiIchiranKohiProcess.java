/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120870;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohisaishinsa.SogojigyohiSaishinsaCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費再審査決定通知書情報共通バッチ処理クラス．一覧表作成を実行する
 *
 * @reamsid_L DBC-4730-030 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiProcess
        extends BatchKeyBreakBase<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisaishinsa."
                    + "ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper.get帳票出力対象データ");
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private int 連番;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目;
    private Map<RString, RString> 出力順Map;
    private static final RString コンマ = new RString(",");
    private SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity lastEntity;
    private Set<ShikibetsuCode> 識別コードset = new HashSet();
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
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
    private ShoKisaiHokenshaNo 公費負担者番号;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200081");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;

    private static final RString 出力ファイル名
            = new RString("DBC200081_SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohi.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 漢字_分 = new RString("分");

    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> reportSourceWriter;

    @Override
    protected void initialize() {
        連番 = 1;
        公費負担者番号 = null;
        改頁項目 = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        識別コードset = new HashSet<>();
        出力順Map = new HashMap<>();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        lastEntity = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity();
        並び順 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(SogojigyohiSaishinsaOutPutOrder.class, 並び順);
        帳票データの取得Parameter.set出力順(出力順);

        int index = 0;
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁項目.add(item.get項目名());
            }
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

        改頁項目.add(new RString(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource.ReportSourceFields.kohiFutanshaNo.name()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> breaker
                = new SogojigyohiSaishinsaKetteitsuchishoPageBreak(改頁項目);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected void usualProcess(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity entity) {
        boolean 集計Flag = false;
        ShoKisaiHokenshaNo this公費負担者番号 = entity.get公費負担者番号();
        if (公費負担者番号 != null && !公費負担者番号.equals(this公費負担者番号)) {
            集計Flag = true;
        }
        公費負担者番号 = this公費負担者番号;
        if (連番 != 1) {
            int 連番_1 = 連番 - 1;
            if (集計Flag) {
                SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport report
                        = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport(
                                lastEntity,
                                出力順Map,
                                parameter.get処理年月(),
                                parameter.getシステム日付(),
                                false,
                                連番_1,
                                true
                        );
                連番 = 1;
                report.writeBy(reportSourceWriter);
            } else {
                SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport report
                        = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport(
                                lastEntity,
                                出力順Map,
                                parameter.get処理年月(),
                                parameter.getシステム日付(),
                                false,
                                連番_1,
                                false);
                report.writeBy(reportSourceWriter);
            }
            do帳票のCSVファイル作成(
                    lastEntity,
                    parameter.get処理年月(),
                    parameter.getシステム日付(),
                    集計Flag
            );
        }
        連番++;
        lastEntity = entity;
    }

    @Override
    protected void keyBreakProcess(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity entity) {

    }

    @Override
    protected void afterExecute() {
        int 連番_2 = 連番 - 1;
        SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport report;
        report = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport(
                lastEntity,
                出力順Map,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                false,
                連番_2,
                true
        );
        report.writeBy(reportSourceWriter);

        do帳票のCSVファイル作成(
                lastEntity,
                parameter.get処理年月(),
                parameter.getシステム日付(),
                true
        );
        eucCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void do帳票のCSVファイル作成(
            SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity sogolistentity,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            boolean 集計Flag) {
        SogojigyohiSaishinsaCSVEntity output = new SogojigyohiSaishinsaCSVEntity();
        if (連番 == 1) {
            if (null != 処理年月 && !処理年月.isEmpty()) {
                output.set処理年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(漢字_分));
            }
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            output.set国保連合会名(sogolistentity.get国保連合会名());
            output.set審査委員会名(sogolistentity.get審査委員会名());
        } else {
            output.set処理年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set国保連合会名(RString.EMPTY);
            output.set審査委員会名(RString.EMPTY);
        }
        if (null != sogolistentity.get公費負担者番号()) {
            output.set公費負担者番号(sogolistentity.get公費負担者番号().getColumnValue());
        }
        output.set公費負担者名(sogolistentity.get公費負担者名());
        if (null != sogolistentity.get取扱年月()) {
            output.set取扱年月(sogolistentity.get取扱年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != sogolistentity.get事業者番号()) {
            output.set事業者番号(sogolistentity.get事業者番号().value());
        }
        output.set事業者名(sogolistentity.get事業者名());
        if (null != sogolistentity.getサービス提供年月()) {
            output.setサービス提供年月(sogolistentity.getサービス提供年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != sogolistentity.getサービス種類コード()) {
            output.setサービス種類コード(sogolistentity.getサービス種類コード().getColumnValue());
        }
        output.setサービス種類名(sogolistentity.getサービス種類名());
        output.set当初請求単位数(doカンマ編集(sogolistentity.get当初請求単位数()));
        output.set決定単位数(doカンマ編集(sogolistentity.get決定単位数()));
        output.set負担額(doカンマ編集(sogolistentity.get公費負担額()));
        if (null != sogolistentity.get被保険者番号()) {
            output.set被保険者番号(sogolistentity.get被保険者番号().value());
        }
        output.set被保険者氏名(sogolistentity.get被保険者氏名());
        output.set申立事由コード(sogolistentity.get申立事由コード().value());
        output.set申立事由(sogolistentity.get申立事由());
        output.set原審単位数(doカンマ編集(sogolistentity.get原審単位数()));
        output.set調整単位数(doカンマ編集(sogolistentity.get調整単位数()));
        if (集計Flag) {
            SogojigyohiSaishinsaCSVEntity totalRecord = new SogojigyohiSaishinsaCSVEntity();
            totalRecord.set公費負担者番号(sogolistentity.get公費負担者番号().value());
            totalRecord.set公費負担者名(sogolistentity.get公費負担者名());
            totalRecord.set総合事業費_決定_件数(doカンマ編集(sogolistentity.get総合事業費_決定_件数()));
            totalRecord.set総合事業費_決定_単位数(doカンマ編集(sogolistentity.get総合事業費_決定_単位数()));
            totalRecord.set総合事業費_決定_負担額(doカンマ編集(sogolistentity.get総合事業費_決定_負担額()));
            totalRecord.set総合事業費_調整_件数(doカンマ編集(sogolistentity.get総合事業費_調整_件数()));
            totalRecord.set総合事業費_調整_単位数(doカンマ編集(sogolistentity.get総合事業費_調整_単位数()));
            totalRecord.set総合事業費_調整_負担額(doカンマ編集(sogolistentity.get総合事業費_調整_負担額()));
            clear集計(output);
            eucCsvWriter.writeLine(output);
            eucCsvWriter.writeLine(totalRecord);
        } else {
            clear集計(output);
            eucCsvWriter.writeLine(output);
        }

        if (null != sogolistentity.get識別コード() && !sogolistentity.get識別コード().isEmpty()
                && !識別コードset.contains(sogolistentity.get識別コード())) {
            PersonalData personalData = getPersonalData(sogolistentity);
            personalDataList.add(personalData);
            識別コードset.add(sogolistentity.get識別コード());

        }

    }

    private void clear集計(SogojigyohiSaishinsaCSVEntity output) {
        output.set総合事業費_決定_件数(RString.EMPTY);
        output.set総合事業費_決定_単位数(RString.EMPTY);
        output.set総合事業費_決定_負担額(RString.EMPTY);
        output.set総合事業費_調整_件数(RString.EMPTY);
        output.set総合事業費_調整_単位数(RString.EMPTY);
        output.set総合事業費_調整_負担額(RString.EMPTY);
    }

    private PersonalData getPersonalData(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity chohyoEntity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                chohyoEntity.get被保険者番号().getColumnValue());
        return PersonalData.of(chohyoEntity.get識別コード(), expandedInformations);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
