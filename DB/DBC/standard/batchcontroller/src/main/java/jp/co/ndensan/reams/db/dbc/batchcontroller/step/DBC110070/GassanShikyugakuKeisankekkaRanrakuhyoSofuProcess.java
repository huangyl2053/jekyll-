/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Teishotokusha1SaikeisanJisshiUmu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110070.KogakugassanKeisankekkaRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.GassanShikyugakuKeisankekkaIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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

/**
 * 高額合算支給額計算結果連絡票情報送付一覧表作成のバッチProcessです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class GassanShikyugakuKeisankekkaRanrakuhyoSofuProcess extends BatchProcessBase<GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get送付一覧表情報");

    private static final int INT_1 = 1;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString FORMATTER = new RString("###,###,###,##0");
    private static final RString 作成 = new RString("作成");
    private static final RString 年度 = new RString("年度");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 帳票出力順の取得 = new RString("帳票出力順の取得");
    private static final RString 出力ファイル名
            = new RString("DBC200036_GassanShikyugakuKeisankekkaRanrakuhyoSofuIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200036");
    private final Code コード = new Code("0003");
    private KogakugassanKeisankekkaRenrakuhyoOutProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private IOutputOrder outputOrder;
    private YMDHMS システム日付;
    private int 連番;

    private Set<ShikibetsuCode> 識別コードset;
    private List<PersonalData> personalDataList;
    private List<RString> pageBreakKeys;

    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<GassanShikyugakuKeisankekkaSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanShikyugakuKeisankekkaSofuIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        システム日付 = YMDHMS.now();
        識別コードset = new HashSet<>();
        personalDataList = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        連番 = 0;
        get出力順();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        PageBreaker<GassanShikyugakuKeisankekkaSofuIchiranSource> breaker
                = new GassanShikyugakuKeisankekkaSofuIchiranPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200036.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity entity) {
        GassanShikyugakuKeisankekkaSofuIchiranReport report = new GassanShikyugakuKeisankekkaSofuIchiranReport(
                entity, outputOrder, processParameter.get処理年月(), システム日付, 連番 + 1);
        report.writeBy(reportSourceWriter);
        if (連番 == 0) {
            ヘッダー項目出力(entity);
        } else {
            明細項目出力(entity);
        }
        アクセスログ対象追加(entity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void 明細項目出力(GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity entity) {
        連番 = 連番 + INT_1;
        GassanShikyugakuKeisankekkaIchiranCsvEntity meisaiEntity
                = new GassanShikyugakuKeisankekkaIchiranCsvEntity();
        meisaiEntity.set送付年月(RString.EMPTY);
        meisaiEntity.set作成日時(RString.EMPTY);
        meisaiEntity.set保険者番号(RString.EMPTY);
        meisaiEntity.set保険者名(RString.EMPTY);
        meisaiEntity.set連番(new RString(連番));
        meisaiEntity.set支給申請書整理番号(entity.get高額合算支給額計算結果一時().getShikyuShinseishoSeiriNo());
        meisaiEntity.set被保険者番号(entity.get高額合算支給額計算結果一時().getHihokenshaNo().getColumnValue());
        meisaiEntity.set被保険者氏名(entity.get被保険者一時().getMeisho());
        if (entity.get高額合算支給額計算結果一時().getTaishoNendo() != null) {
            meisaiEntity.set対象年度(
                    entity.get高額合算支給額計算結果一時().getTaishoNendo()
                    .wareki().fillType(FillType.BLANK).toDateString().concat(年度));
        }
        if (entity.get高額合算支給額計算結果一時().getTaishoKeisanKaishiYMD() != null) {
            meisaiEntity.set計算対象期間開始年月日(entity.get高額合算支給額計算結果一時().getTaishoKeisanKaishiYMD()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (entity.get高額合算支給額計算結果一時().getTaishoKeisanShuryoYMD() != null) {
            meisaiEntity.set計算対象期間終了年月日(entity.get高額合算支給額計算結果一時().getTaishoKeisanShuryoYMD()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        meisaiEntity.set世帯負担総額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiFutanSogaku()));
        meisaiEntity.set世帯合算額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiGassanGaku()));
        meisaiEntity.set世帯合算額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SetaiGassanGaku()));
        meisaiEntity.set所得区分(entity.get高額合算支給額計算結果一時().getShotokuKubun());
        meisaiEntity.set所得区分名(
                KaigoGassan_ShotokuKbn.toValue(entity.get高額合算支給額計算結果一時().getShotokuKubun()).get名称());
        meisaiEntity.set所得区分_70歳以上(entity.get高額合算支給額計算結果一時().getOver70_ShotokuKubun());
        meisaiEntity.set所得区分名_70歳以上(
                KaigoGassan_Over70_ShotokuKbn.toValue(entity.get高額合算支給額計算結果一時().getOver70_ShotokuKubun())
                .get名称());
        meisaiEntity.set算定基準額(decimalFormat(entity.get高額合算支給額計算結果一時().getSanteiKijunGaku()));
        meisaiEntity.set算定基準額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SanteiKijyunGaku()));
        meisaiEntity.set世帯総支給額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiShikyuSogaku()));
        meisaiEntity.set世帯総支給額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SetaiShikyuSogaku()));
        meisaiEntity.set按分後の支給額(decimalFormat(entity.get高額合算支給額計算結果一時().getHonninShikyugaku()));
        meisaiEntity.set按分後の支給額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_honninShikyugaku()));
        meisaiEntity.set再計算の有無(
                KaigoGassan_Teishotokusha1SaikeisanJisshiUmu.toValue(
                        entity.get高額合算支給額計算結果一時().getTeiShotoku_1_SaiKeisanUmu()).get名称());
        eucCsvWriter.writeLine(meisaiEntity);
    }

    private void ヘッダー項目出力(GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity entity) {
        GassanShikyugakuKeisankekkaIchiranCsvEntity headEntity = new GassanShikyugakuKeisankekkaIchiranCsvEntity();
        headEntity.set送付年月(processParameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RStringBuilder builder = new RStringBuilder();
        builder.append(システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        builder.append(RString.FULL_SPACE);
        builder.append(システム日付.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        builder.append(RString.FULL_SPACE).append(作成);
        headEntity.set作成日時(builder.toRString());
        headEntity.set保険者番号(
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        headEntity.set保険者名(
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        連番 = 連番 + INT_1;
        headEntity.set連番(new RString(連番));
        headEntity.set支給申請書整理番号(entity.get高額合算支給額計算結果一時().getShikyuShinseishoSeiriNo());
        headEntity.set被保険者番号(entity.get高額合算支給額計算結果一時().getHihokenshaNo().getColumnValue());
        headEntity.set被保険者氏名(entity.get被保険者一時().getMeisho());
        if (entity.get高額合算支給額計算結果一時().getTaishoNendo() != null) {
            headEntity.set対象年度(
                    entity.get高額合算支給額計算結果一時().getTaishoNendo()
                    .wareki().fillType(FillType.BLANK).toDateString().concat(年度));
        }
        if (entity.get高額合算支給額計算結果一時().getTaishoKeisanKaishiYMD() != null) {
            headEntity.set計算対象期間開始年月日(entity.get高額合算支給額計算結果一時().getTaishoKeisanKaishiYMD()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (entity.get高額合算支給額計算結果一時().getTaishoKeisanShuryoYMD() != null) {
            headEntity.set計算対象期間終了年月日(entity.get高額合算支給額計算結果一時().getTaishoKeisanShuryoYMD()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        headEntity.set世帯負担総額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiFutanSogaku()));
        headEntity.set世帯合算額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiGassanGaku()));
        headEntity.set世帯合算額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SetaiGassanGaku()));
        headEntity.set所得区分(entity.get高額合算支給額計算結果一時().getShotokuKubun());
        headEntity.set所得区分名(
                KaigoGassan_ShotokuKbn.toValue(entity.get高額合算支給額計算結果一時().getShotokuKubun()).get名称());
        headEntity.set所得区分_70歳以上(entity.get高額合算支給額計算結果一時().getOver70_ShotokuKubun());
        headEntity.set所得区分名_70歳以上(
                KaigoGassan_Over70_ShotokuKbn.toValue(entity.get高額合算支給額計算結果一時().getOver70_ShotokuKubun())
                .get名称());
        headEntity.set算定基準額(decimalFormat(entity.get高額合算支給額計算結果一時().getSanteiKijunGaku()));
        headEntity.set算定基準額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SanteiKijyunGaku()));
        headEntity.set世帯総支給額(decimalFormat(entity.get高額合算支給額計算結果一時().getSetaiShikyuSogaku()));
        headEntity.set世帯総支給額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_SetaiShikyuSogaku()));
        headEntity.set按分後の支給額(decimalFormat(entity.get高額合算支給額計算結果一時().getHonninShikyugaku()));
        headEntity.set按分後の支給額_70歳以上(
                decimalFormat(entity.get高額合算支給額計算結果一時().getOver70_honninShikyugaku()));
        headEntity.set再計算の有無(
                KaigoGassan_Teishotokusha1SaikeisanJisshiUmu.toValue(
                        entity.get高額合算支給額計算結果一時().getTeiShotoku_1_SaiKeisanUmu()).get名称());
        eucCsvWriter.writeLine(headEntity);
    }

    private void get出力順() {
        RString 出力順 = RString.EMPTY;
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200036.getReportId(), Long.parseLong(processParameter.get出力順ID().toString()));
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.class, outputOrder);
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    pageBreakKeys.add(item.get項目ID());
                }
            }
        } else {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(
                    帳票出力順の取得.toString()).toString());
        }
        processParameter.set出力順(出力順.replace(ORDER_BY, RString.EMPTY));
    }

    private void アクセスログ対象追加(GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity entity) {
        ShikibetsuCode 識別コード = entity.get被保険者一時().getShikibetsuCode();
        if (識別コード == null || 識別コード.isEmpty() || 識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 被保険者番号,
                entity.get被保険者一時().getExHihokenshaNo().getColumnValue());
        return PersonalData.of(entity.get被保険者一時().getShikibetsuCode(), expandedInformations);
    }

    private RString decimalFormat(Decimal decimal) {
        if (decimal == null) {
            return RString.EMPTY;
        }
        NumberFormat format = new DecimalFormat(FORMATTER.toString());
        return new RString(format.format(decimal));
    }
}
