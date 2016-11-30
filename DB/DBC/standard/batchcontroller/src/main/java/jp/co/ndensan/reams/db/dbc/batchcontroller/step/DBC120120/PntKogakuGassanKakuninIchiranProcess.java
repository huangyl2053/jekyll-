/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanKakuninIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanShikyugakuKeisanKekkaIn;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanShikyugakuKeisanKekkaInOutputOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120120.KogakuGassanShikyugakuKeisanKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.TempDbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算支給額計算結果連絡票情報確認リストを出力するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class PntKogakuGassanKakuninIchiranProcess extends BatchKeyBreakBase<KogakuGassanShikyugakuKeisanKekkaInfoEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassan.IKogakuGassanShikyugakuKeisanKekkaInMapper.select計算結果連絡票確認リスト情報");

    private static final RString エラーメッセージ = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 定数_作成 = new RString("作成");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200038");
    private static final RString 出力ファイル名 = new RString("DBC200038_GassanShikyugakuKeisankekkaRanrakuhyoKakuninIchiran.csv");
    private final Code code = new Code("0003");
    private final RString 被保険者番号 = new RString("被保険者番号");
    private KogakuGassanShikyugakuKeisanKekkaInParameter processPrm;
    private FileSpoolManager manager;
    private Set<ShikibetsuCode> 識別コードset;
    private List<PersonalData> personalDataList;
    private RString path;

    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private List<RString> pageBreakKeys;
    private int 連番;
    private RString 保険者番号;
    private RString 保険者名;

    private BatchReportWriter<GassanShikyugakuKakuninIchiranSource> reportWriter;
    private ReportSourceWriter<GassanShikyugakuKakuninIchiranSource> reportSourceWriter;

    private CsvWriter csvWriter;

    @Override
    protected void initialize() {

        get出力順();
        識別コードset = new HashSet();
        personalDataList = new ArrayList<>();
        保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        保険者名 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanShikyugakuKakuninIchiranSource> breaker = new KogakuGassanKakuninIchiranPageBreak(pageBreakKeys);
        reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200038.getReportId().value()).addBreak(breaker).create();
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
        KokuhorenIchiranhyoMybatisParameter parameter = new KokuhorenIchiranhyoMybatisParameter();
        parameter.set出力順(MyBatisOrderByClauseCreator.create(KogakuGassanShikyugakuKeisanKekkaInOutputOrder.class, 出力順情報));
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void keyBreakProcess(KogakuGassanShikyugakuKeisanKekkaInfoEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuGassanShikyugakuKeisanKekkaInfoEntity entity) {

        連番 = 連番 + 1;
        KogakuGassanShikyugakuKeisanKekkaIn 確認リスト帳票用データ = new KogakuGassanShikyugakuKeisanKekkaIn();
        確認リスト帳票用データ.set帳票用データ(entity);
        確認リスト帳票用データ.set並び順リスト(並び順リスト);
        確認リスト帳票用データ.set改頁リスト(改頁リスト);
        確認リスト帳票用データ.set作成日時(processPrm.get作成日時());
        確認リスト帳票用データ.set処理年月(processPrm.get処理年月());
        確認リスト帳票用データ.set連番(連番);
        確認リスト帳票用データ.set保険者番号(保険者番号);
        確認リスト帳票用データ.set保険者名(保険者名);
        GassanShikyugakuKakuninIchiranReport report = new GassanShikyugakuKakuninIchiranReport(確認リスト帳票用データ);
        report.writeBy(reportSourceWriter);

        KogakuGassanShikyugakuKeisanKekkaInCsvEntity csvEntity = get一覧表CSV項目(entity);
        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        reportWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(path, accessLogUUID);
        } else {
            manager.spool(SubGyomuCode.DBC介護給付, path);
        }

    }

    private void get出力順() {

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processPrm.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200037.getReportId(),
                    Long.parseLong(processPrm.get出力順ID().toString()));
        }
        if (出力順情報 == null) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(エラーメッセージ.toString()).toString());
        }

        改頁リスト = new ArrayList();
        並び順リスト = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            並び順リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }

    private KogakuGassanShikyugakuKeisanKekkaInCsvEntity get一覧表CSV項目(KogakuGassanShikyugakuKeisanKekkaInfoEntity entity) {

        DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity 計算結果entity = entity.get計算結果entity();
        TempDbWT0001HihokenshaEntity 被保険者entity = entity.get被保険者entity();
        KogakuGassanShikyugakuKeisanKekkaInCsvEntity csvEntity = new KogakuGassanShikyugakuKeisanKekkaInCsvEntity();
        if (連番 == 1) {
            csvEntity.set取込年月(processPrm.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = processPrm.get作成日時().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = processPrm.get作成日時().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)
                    .concat(RString.HALF_SPACE).concat(定数_作成);
            csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            csvEntity.set保険者番号(保険者番号);
            csvEntity.set保険者名(保険者名);
        } else {
            csvEntity.set取込年月(RString.EMPTY);
            csvEntity.set作成日時(RString.EMPTY);
            csvEntity.set保険者番号(RString.EMPTY);
            csvEntity.set保険者名(RString.EMPTY);
        }
        csvEntity.set番号(new RString(連番));
        csvEntity.set年度(計算結果entity.getTaishoNendo().wareki().firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        csvEntity.set被保険者番号(getColumnValue(被保険者entity.getHihokenshaNo()));
        csvEntity.set被保険者氏名(getRString(被保険者entity.getMeisho()));
        csvEntity.set支給申請書整理番号(getRString(計算結果entity.getShikyuShinseishoSeiriNo()));
        csvEntity.set自己負担額証明書整理番号(getRString(計算結果entity.getJikoFutanSeiriNo()));
        csvEntity.set計算対象期間_開始(get年月日(計算結果entity.getTaishoKeisanKaishiYMD()));
        csvEntity.set計算対象期間_終了(get年月日(計算結果entity.getTaishoKeisanShuryoYMD()));
        if (RString.isNullOrEmpty(計算結果entity.getShotokuKubun())) {
            csvEntity.set所得区分(RString.EMPTY);
        } else {
            csvEntity.set所得区分(KaigoGassan_ShotokuKbn.toValue(計算結果entity.getShotokuKubun()).get名称());
        }
        if (RString.isNullOrEmpty(計算結果entity.getOver70_ShotokuKubun())) {
            csvEntity.set七十歳以上分(RString.EMPTY);
        } else {
            csvEntity.set七十歳以上分(KaigoGassan_Over70_ShotokuKbn.toValue(計算結果entity.getOver70_ShotokuKubun()).get名称());
        }
        csvEntity.set世帯負担総額(get金額(計算結果entity.getSetaiFutanSogaku()));
        csvEntity.set介護分(get金額(計算結果entity.getSetaiGassanGaku()));
        csvEntity.set七十歳以上介護分(get金額(計算結果entity.getOver70_SetaiGassanGaku()));
        csvEntity.set介護等合算算定基準額(get金額(計算結果entity.getSanteiKijunGaku()));
        csvEntity.set介護等合算算定基準額_70歳以上介護分(get金額(計算結果entity.getOver70_SanteiKijyunGaku()));
        csvEntity.set世帯支給総額(get金額(計算結果entity.getSetaiShikyuSogaku()));
        csvEntity.set世帯支給総額_うち70歳以上分(get金額(計算結果entity.getOver70_SetaiShikyuSogaku()));
        csvEntity.set按分後支給額(get金額(計算結果entity.getHonninShikyugaku()));
        csvEntity.set按分後支給額_うち70歳以上分(get金額(計算結果entity.getOver70_honninShikyugaku()));
        csvEntity.set備考(getRString(計算結果entity.getBiko()));

        if (被保険者entity.getShikibetsuCode() != null && !被保険者entity.getShikibetsuCode().isEmpty()
                && !this.識別コードset.contains(被保険者entity.getShikibetsuCode())) {
            this.識別コードset.add(被保険者entity.getShikibetsuCode());
            PersonalData personalData = getPersonalData(被保険者entity);
            this.personalDataList.add(personalData);
        }

        return csvEntity;
    }

    private PersonalData getPersonalData(TempDbWT0001HihokenshaEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 被保険者番号,
                getColumnValue(entity.getHihokenshaNo()));
        return PersonalData.of(entity.getShikibetsuCode(), expandedInformations);
    }

    private static RString get金額(Decimal 金額) {
        if (金額 == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString get年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString getRString(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
