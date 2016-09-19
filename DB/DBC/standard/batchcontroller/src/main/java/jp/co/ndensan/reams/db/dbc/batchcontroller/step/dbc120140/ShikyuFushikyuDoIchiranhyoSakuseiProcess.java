/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoin.KyufukanrihyoDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140.GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuChohyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
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
 * 一覧表作成する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuDoIchiranhyoSakuseiProcess extends BatchProcessBase<ShikyuFushikyuChohyoEntity> {

    private KyufukanrihyoDoIchiranhyoSakuseiProcessParameter parameter;
    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private List<RString> pageBreakKeys;
    private GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiranCSVEntity csvEntity;
    private int 連番;
    private RDateTime 作成日時;
    private Set<RString> 識別コードset;
    private List<PersonalData> personalDataList;
    private RString 保険者番号 = RString.EMPTY;
    private RString 保険者名 = RString.EMPTY;
    private static final int INT_0 = 0;
    private static final RString 支給 = new RString("1");
    private static final RString 不支給 = new RString("0");
    private static final RString 窓口払 = new RString("1");
    private static final RString 口座払 = new RString("2");
    private static final RString 名称_支給 = new RString("支給");
    private static final RString 名称_不支給 = new RString("不支給");
    private static final RString 接続文字 = new RString("～");
    private static final RString 左カッコ = new RString("（");
    private static final RString 右カッコ = new RString("）");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString エラーメッセージ = new RString("帳票出力順の取得");
    private static final Code コード = new Code("0003");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200039");
    private FileSpoolManager manager;
    private RString path;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get帳票出力対象データ");
    private static final RString 出力ファイル名
            = new RString("DBC200039_GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiran.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private CsvWriter csvWriter;
    private BatchReportWriter<GassanShikyuTsuchishoTorikomiIchiranSource> reportWriter;
    private ReportSourceWriter<GassanShikyuTsuchishoTorikomiIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        super.initialize();
        get出力順();
        作成日時 = parameter.getシステム日付();
        識別コードset = new HashSet();
        personalDataList = new ArrayList<>();
        保険者番号 = DbBusinessConfig
                .get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        保険者名 = DbBusinessConfig
                .get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {
        KokuhorenIchiranhyoMybatisParameter mybatisParameter = new KokuhorenIchiranhyoMybatisParameter();
        mybatisParameter.set出力順(MyBatisOrderByClauseCreator.create(
                GassanShikyuTsuchishoTorikomiIchiranOutputOrder.class, 出力順情報));
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanShikyuTsuchishoTorikomiIchiranSource> breaker
                = new GassanShikyuTsuchishoTorikomiIchiranPageBreak(pageBreakKeys);
        reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200039.getReportId().value())
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
    protected void process(ShikyuFushikyuChohyoEntity entity) {
        連番 = 連番 + 1;
        アクセスログ対象追加(entity);
        edit明細項目(entity);
        writeLine(entity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        reportWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
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
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200039.getReportId(),
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

    private void アクセスログ対象追加(ShikyuFushikyuChohyoEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
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
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private void edit明細項目(ShikyuFushikyuChohyoEntity entity) {
        csvEntity = new GassanShikyuFushikyuKetteiTsuchishoTorikomiIchiranCSVEntity();
        DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 決定 = entity.get決定データ();
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
        if (連番 == 1) {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)
                    .concat(RString.HALF_SPACE).concat(SAKUSEI);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            csvEntity.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString());
        }
        csvEntity.setNo(new RString(連番));
        csvEntity.set保険者番号(保険者番号);
        csvEntity.set保険者名(保険者名);
        csvEntity.set履歴番号(new RString(決定.get履歴番号()));
        csvEntity.set被保険者番号(getColumnValue(被保険者.get登録被保険者番号()));
        csvEntity.set被保険者氏名(被保険者.get宛名名称());
        csvEntity.set住所(get住所(被保険者.get住所(), 被保険者.get番地(), 被保険者.get方書()));
        csvEntity.set支給申請書整理番号(決定.get支給申請書整理番号());
        csvEntity.set計算対象期間_開始(doパターン4(決定.get対象計算期間開始年月日()));
        csvEntity.set計算対象期間_終了(doパターン4(決定.get対象計算期間終了年月日()));
        csvEntity.set申請年月日(doパターン4(決定.get申請年月日()));
        csvEntity.set決定年月日(doパターン4(決定.get決定年月日()));
        csvEntity.set支給区分(決定.get支給区分コード());
        if (支給.equals(決定.get支給区分コード())) {
            csvEntity.set支給区分名称(名称_支給);
            csvEntity.set支払方法(決定.get支払方法区分());
            if (!RString.isNullOrEmpty(決定.get支払方法区分())) {
                csvEntity.set支払方法名称(ShiharaiHohoKubun.toValue(決定.get支払方法区分()).get名称());
            }
            if (窓口払.equals(決定.get支払方法区分())) {
                csvEntity.set窓口払い_支払場所(決定.get支払場所());
                csvEntity.set窓口払_支払期間(get支払期間(決定.get支払期間開始年月日(),
                        決定.get支払期間開始時間(), 決定.get支払期間終了年月日(), 決定.get支払期間終了時間()));
            } else if (口座払.equals(決定.get支払方法区分())) {
                csvEntity.set口座払_金融機関_支店名(get金融機関支店名(決定.get金融機関名(), 決定.get金融機関支店名()));
                csvEntity.set口座払_種目(決定.get口座種目名());
                csvEntity.set口座払_口座番号(決定.get口座番号());
                csvEntity.set口座払_口座名義人(決定.get口座名義人_カナ());
            }
        } else if (不支給.equals(決定.get支給区分コード())) {
            csvEntity.set支給区分名称(名称_不支給);
        }
        csvEntity.set自己負担総額(doカンマ編集(決定.get自己負担総額()));
        csvEntity.set支給額(doカンマ編集(決定.get支給額()));
        csvWriter.writeLine(csvEntity);
    }

    private void writeLine(ShikyuFushikyuChohyoEntity entity) {

        ShikyuFushikyuChohyoParameter パラメター = new ShikyuFushikyuChohyoParameter(entity, 並び順リスト,
                改頁リスト, parameter.get処理年月(), parameter.getシステム日付(), 保険者番号, 保険者名, 連番);
        GassanShikyuTsuchishoTorikomiIchiranReport report
                = new GassanShikyuTsuchishoTorikomiIchiranReport(パラメター);
        report.writeBy(reportSourceWriter);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, INT_0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString get住所(RString jusho, RString banchi, RString katagaki) {
        if (RString.isNullOrEmpty(jusho) && RString.isNullOrEmpty(banchi) && RString.isNullOrEmpty(katagaki)) {
            return RString.EMPTY;
        }
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(jusho);
        sakuseiYMD.append(banchi);
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(katagaki);
        return sakuseiYMD.toRString();
    }

    private RString doパターン4(RString 年月日) {
        if (RString.isNullOrEmpty(年月日)) {
            return RString.EMPTY;
        }
        return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString get支払期間(RString kaishiYMD, RString kaishiTime, RString shuryoYMD, RString shuryoTime) {
        if (RString.isNullOrEmpty(kaishiYMD) && RString.isNullOrEmpty(shuryoYMD)) {
            return RString.EMPTY;
        }
        RStringBuilder sakuseiYMD = new RStringBuilder();
        if (!RString.isNullOrEmpty(kaishiYMD)) {
            FlexibleDate 開始年月日 = new FlexibleDate(kaishiYMD);
            sakuseiYMD.append(開始年月日.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
            sakuseiYMD.append(左カッコ);
            sakuseiYMD.append(開始年月日.getDayOfWeek().getShortTerm());
            sakuseiYMD.append(右カッコ);
        }
        if (!RString.isNullOrEmpty(kaishiTime)) {
            RTime 開始時間 = new RTime(kaishiTime);
            sakuseiYMD.append(RString.HALF_SPACE);
            sakuseiYMD.append(開始時間.toFormattedTimeString(DisplayTimeFormat.HH_mm));
            sakuseiYMD.append(接続文字);
        }
        if (!RString.isNullOrEmpty(shuryoYMD)) {
            FlexibleDate 終了年月日 = new FlexibleDate(shuryoYMD);
            sakuseiYMD.append(終了年月日.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
            sakuseiYMD.append(左カッコ);
            sakuseiYMD.append(終了年月日.getDayOfWeek().getShortTerm());
            sakuseiYMD.append(右カッコ);
        }
        if (!RString.isNullOrEmpty(shuryoTime)) {
            RTime 終了時間 = new RTime(shuryoTime);
            sakuseiYMD.append(RString.HALF_SPACE);
            sakuseiYMD.append(終了時間.toFormattedTimeString(DisplayTimeFormat.HH_mm));
        }

        return sakuseiYMD.toRString();
    }

    private RString get金融機関支店名(RString 金融機関, RString 支店名) {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(金融機関);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(支店名);
        return sakuseiYMD.toRString();
    }

}
