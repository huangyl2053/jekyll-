/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran.KogakuGassanKyufuJissekiInOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran.KogakuGassanKyufuJissekiInPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.DbWT38P1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 高額合算給付実績取込の一覧表作成クラスです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcess
        extends BatchKeyBreakBase<KogakuGassanKyufuJissekiInEntity> {

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の2件目 = new RString("KEY_並び順の2件目");
    private static final RString KEY_並び順の3件目 = new RString("KEY_並び順の3件目");
    private static final RString KEY_並び順の4件目 = new RString("KEY_並び順の4件目");
    private static final RString KEY_並び順の5件目 = new RString("KEY_並び順の5件目");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString エラーメッセージ = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200041");
    private static final RString 出力ファイル名 = new RString("DBC200041_GassanKyufujissekiTorikomiIchiran.csv");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final Code コード = new Code("0003");
//TODO mapper
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassankyufujissekiin.IKogakuGassanKyufuJissekiInMapper.get帳票出力対象データ");
    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 改頁項目名リスト;

    private FileSpoolManager manager;
    private Map<RString, RString> 出力順Map;
    private int 連番;
    private RString eucFilePath;
    private List<KogakuGassanKyufuJissekiInEntity> entityList;
    private KogakuGassanKyufuJissekiInEntity currentRecord;
    private KogakuGassanKyufuJissekiInCsvEntity csvEntity;
    private final Set<RString> 識別コードset = new HashSet<>();
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter processPrm;

    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;

    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<GassanKyufujissekiTorikomiIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<GassanKyufujissekiTorikomiIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processPrm.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200041.getReportId(),
                    Long.parseLong(processPrm.get出力順ID().toString()));
        }
        if (出力順情報 == null) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(エラーメッセージ.toString()).toString());
        }
        改頁項目名リスト = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        entityList = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        RString 出力順 = MyBatisOrderByClauseCreator.create(KogakuGassanKyufuJissekiInOutputOrder.class, 出力順情報);
        帳票データの取得Parameter.set出力順(出力順);

        int i = INT_0;
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁項目名リスト.add(item.get項目名());
                改頁リスト.add(item.get項目ID());
            }
            if (i == INT_0) {
                出力順Map.put(KEY_並び順の1件目, item.get項目名());
            } else if (i == INT_1) {
                出力順Map.put(KEY_並び順の2件目, item.get項目名());
            } else if (i == INT_2) {
                出力順Map.put(KEY_並び順の3件目, item.get項目名());
            } else if (i == INT_3) {
                出力順Map.put(KEY_並び順の4件目, item.get項目名());
            } else if (i == INT_4) {
                出力順Map.put(KEY_並び順の5件目, item.get項目名());
            }
            i = i + 1;
        }

    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(READ_DATA_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanKyufujissekiTorikomiIchiranSource> breaker = new KogakuGassanKyufuJissekiInPageBreak(改頁リスト);
        batchReportWriter_一覧表 = BatchReportFactory.
                createBatchReportWriter(ReportIdDBC.DBC200041.getReportId().getColumnValue()).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void usualProcess(KogakuGassanKyufuJissekiInEntity entity) {
        アクセスログ対象追加(entity);
        currentRecord = entity;
        entityList.add(entity);
        KogakuGassanKyufuJissekiInEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            if (null == csvEntity) {
                csvEntity = new KogakuGassanKyufuJissekiInCsvEntity();
                editヘッダー項目();
            }
            edit明細項目(beforeEntity);
            writeLine(beforeEntity);

        }
        連番 = 連番 + 1;
    }

    @Override
    protected void keyBreakProcess(KogakuGassanKyufuJissekiInEntity t) {

    }

    @Override
    protected void afterExecute() {
        if (!entityList.isEmpty()) {
            if (1 == entityList.size()) {
                csvEntity = new KogakuGassanKyufuJissekiInCsvEntity();
                editヘッダー項目();
            }
            edit明細項目(currentRecord);
            writeLine(currentRecord);
        }

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private void アクセスログ対象追加(KogakuGassanKyufuJissekiInEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者一時();
        RString 識別コード = 被保険者.get識別コード();
        if (null == 識別コード || 識別コード.isEmpty()) {
            return;
        }
        if (識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        PersonalData personalData = getPersonalData(被保険者);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号,
                entity.get登録被保険者番号().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private void writeLine(KogakuGassanKyufuJissekiInEntity entity) {
        GassanKyufujissekiTorikomiIchiranParameter パラメータ = new GassanKyufujissekiTorikomiIchiranParameter(
                entity, 出力順Map, 改頁項目名リスト, processPrm.get処理年月(), processPrm.getシステム日付(), 連番);
        GassanKyufujissekiTorikomiIchiranReport report = new GassanKyufujissekiTorikomiIchiranReport(パラメータ);
        report.writeBy(reportSourceWriter_一覧表);
    }

    private void editヘッダー項目() {
        csvEntity.set取込年月(processPrm.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 作成日 = processPrm.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = processPrm.getシステム日付().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        csvEntity.set保険者番号(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        csvEntity.set保険者名(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
    }

    private void edit明細項目(KogakuGassanKyufuJissekiInEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者一時();
        DbWT38P1KogakuGassanKyufuJissekiTempEntity 高額合算給付実績 = entity.get高額合算給付実績一時();

        csvEntity.set番号(new RString(連番));
        csvEntity.set被保険者番号(被保険者.get登録被保険者番号().getColumnValue());
        csvEntity.set被保険者氏名(被保険者.get宛名名称());
        csvEntity.set支給申請書整理番号(高額合算給付実績.getShikyuShinseiSeiriNo());
        csvEntity.set自己負担額証明書整理番号(高額合算給付実績.getJikoFutanSeiriNo());
        csvEntity.set作成区分コード(高額合算給付実績.getKyufuJissekiSakuseiKubunCode());
        csvEntity.set作成区分名称(KaigoGassan_KyufuJissekiSakuseiKubun
                .toValue(高額合算給付実績.getKyufuJissekiSakuseiKubunCode()).get名称());
        csvEntity.set証記載保険者番号(高額合算給付実績.getShoKisaiHokenshaNo().getColumnValue());
        csvEntity.set申請年月日(パターン4(高額合算給付実績.getShinseiYMD()));
        csvEntity.set決定年月日(パターン4(高額合算給付実績.getKetteiYMD()));
        csvEntity.set自己負担額(decimal_to_string(高額合算給付実績.getJikoFutanSogaku()));
        csvEntity.set支給額(decimal_to_string(高額合算給付実績.getShikyuGaku()));
        eucCsvWriter.writeLine(csvEntity);
        csvEntity = new KogakuGassanKyufuJissekiInCsvEntity();
    }

    private RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
