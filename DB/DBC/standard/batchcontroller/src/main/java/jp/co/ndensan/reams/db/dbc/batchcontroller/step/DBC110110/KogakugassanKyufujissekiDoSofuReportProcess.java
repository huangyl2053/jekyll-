/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassankyufujissekiout.KogakugassanKyufujissekiOutPageBreak;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassankyufujissekiout.KogakugassanKyufujissekiOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanKyufujissekiDoSofuReportEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiDoSofuReportMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiDoSofuReportProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiTyohyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 高額合算給付実績情報作成の帳票出力Process
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiDoSofuReportProcess extends BatchKeyBreakBase<KogakuGassanKyufuJissekiSofuEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout."
            + "IKogakugassanKyufujissekiOutMapper.get帳票出力データ");
    private static final RString 出力ファイル名 = new RString("DBC200042_GassanKyufujissekiSofuIchiran.csv");
    private static final RString EUC_ENTITY_ID = new RString("DBC200042");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final Code コード = new Code("0003");
    private static final RString 名称 = new RString("被保険者番号");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString カンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final int INT_1 = 1;
    private static final int INT_0 = 0;

    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> 並び順リスト;
    private RString csvFilePath;
    private Set<ShikibetsuCode> 識別コードset;
    private List<PersonalData> personalDataList;
    private RDateTime システム日時;
    private int 連番;
    private FileSpoolManager manager;
    private RString 保険者情報_保険者番号;
    private RString 保険者情報_保険者名;

    private KogakugassanKyufujissekiDoSofuReportProcessParameter parameter;
    private KogakugassanKyufujissekiDoSofuReportMybatisParameter mybatisParameter;

    private CsvWriter<KogakuGassanKyufuJissekiTyohyoCsvEntity> csvWriter;
    private BatchReportWriter<GassanKyufujissekiSofuIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanKyufujissekiSofuIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        識別コードset = new HashSet<>();
        personalDataList = new ArrayList<>();
        システム日時 = RDateTime.now();
        連番 = INT_0;
        get出力順();
        保険者情報_保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        保険者情報_保険者名 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {

        mybatisParameter = parameter.toMybatisParameter();
        RString 出力順 = MyBatisOrderByClauseCreator.create(KogakugassanKyufujissekiOutputOrder.class, 出力順情報);
        mybatisParameter.set出力順(出力順);
        return new BatchDbReader(MAPPER_PATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        csvFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);

    }

    @Override
    protected void keyBreakProcess(KogakuGassanKyufuJissekiSofuEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuGassanKyufuJissekiSofuEntity entity) {

        if (連番 == INT_0) {
            PageBreaker<GassanKyufujissekiSofuIchiranSource> breaker = new KogakugassanKyufujissekiOutPageBreak(改頁項目リスト);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200042.getReportId().value()).addBreak(breaker).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            csvWriter = new CsvWriter.InstanceBuilder(csvFilePath).
                    setDelimiter(カンマ).
                    setEnclosure(ダブル引用符).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
        }
        連番 = 連番 + INT_1;
        GassanKyufujissekiSofuIchiranReport report = new GassanKyufujissekiSofuIchiranReport(getReportEntity(entity));
        report.writeBy(reportSourceWriter);
        csvWriter.writeLine(getCsvEntity(entity, 連番));
        if (null != entity.get識別コード() && !entity.get識別コード().isEmpty()
                && !識別コードset.contains(entity.get識別コード())) {
            識別コードset.add(entity.get識別コード());
            personalDataList.add(getPersonalData(entity));
        }
    }

    @Override
    protected void afterExecute() {
        if (連番 != INT_0) {
            csvWriter.close();
            batchReportWriter.close();
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                manager.spool(csvFilePath, accessLogUUID);
            } else {
                manager.spool(csvFilePath);
            }
        }
    }

    private KogakuGassanKyufuJissekiTyohyoCsvEntity getCsvEntity(KogakuGassanKyufuJissekiSofuEntity entity, int index) {
        KogakuGassanKyufuJissekiTyohyoCsvEntity csvEntity = new KogakuGassanKyufuJissekiTyohyoCsvEntity();
        if (index == INT_1) {
            csvEntity.set送付年月(parameter.get処理年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = システム日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            csvEntity.set保険者番号(保険者情報_保険者番号);
            csvEntity.set保険者名(保険者情報_保険者番号);
        } else {
            csvEntity.set送付年月(RString.EMPTY);
            csvEntity.set作成日時(RString.EMPTY);
            csvEntity.set保険者番号(RString.EMPTY);
            csvEntity.set保険者名(RString.EMPTY);
        }
        csvEntity.set連番(new RString(index));
        csvEntity.set被保険者番号(entity.get給付実績_被保険者番号().getColumnValue());
        csvEntity.set被保険者氏名(entity.get宛名名称());
        csvEntity.set支給申請書整理番号(entity.get支給申請書整理番号());
        csvEntity.set自己負担額証明書整理番号(entity.get自己負担額証明書整理番号());
        csvEntity.set作成区分コード(entity.get給付実績作成区分コード());
        if (null != entity.get給付実績作成区分コード() && !entity.get給付実績作成区分コード().isEmpty()) {
            KaigoGassan_KyufuJissekiSakuseiKubun 作成区分
                    = KaigoGassan_KyufuJissekiSakuseiKubun.toValue(entity.get給付実績作成区分コード());
            csvEntity.set作成区分(作成区分.get名称());
        }
        csvEntity.set証記載保険者番号(entity.get給付実績_証記載保険者番号().getColumnValue());
        csvEntity.set申請年月日(entity.get申請年月日().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        csvEntity.set決定年月日(entity.get決定年月日().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        csvEntity.set自己負担総額(doFormatDecimal(entity.get自己負担総額()));
        csvEntity.set支給額(doFormatDecimal(entity.get支給額()));
        return csvEntity;
    }

    private RString doFormatDecimal(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private PersonalData getPersonalData(KogakuGassanKyufuJissekiSofuEntity entity) {
        ExpandedInformation expandedInformations
                = new ExpandedInformation(コード, 名称, entity.get被保険者_被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200042.getReportId(),
                Long.parseLong(parameter.get出力順ID().toString()));
        if (null == 出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        並び順リスト = new ArrayList<>();
        改頁リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            並び順リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                改頁項目リスト.add(item.get項目ID());
            }
        }
    }

    private KogakugassanKyufujissekiDoSofuReportEntity getReportEntity(KogakuGassanKyufuJissekiSofuEntity entity) {
        KogakugassanKyufujissekiDoSofuReportEntity reportEntity = new KogakugassanKyufujissekiDoSofuReportEntity();
        reportEntity.set並び順リスト(並び順リスト);
        reportEntity.set作成日時(システム日時);
        reportEntity.set保険者名(保険者情報_保険者名);
        reportEntity.set保険者番号(保険者情報_保険者番号);
        reportEntity.set処理年月(parameter.get処理年月());
        reportEntity.set改頁リスト(改頁リスト);
        reportEntity.set連番(連番);
        reportEntity.set帳票用データ(entity);
        return reportEntity;
    }

}
