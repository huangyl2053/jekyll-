/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanHoseisumiJikofutangakuOutPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanHoseisumiJikofutangakuOutputOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassan.KogakugassanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan.KogakugassanProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
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
 * 高額合算補正済自己負担額情報作成のバッチ帳票出力_送付Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanGassanSofuReprotProcess extends BatchKeyBreakBase<SyuturyokuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get送付一覧表出力対象データ");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200032.getReportId();
    private static final RString メッセージ引数 = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名 = new RString("DBC200032_GassanHoseizumiJikofutangakuJohoSofuchiran.csv");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString 作成R = new RString("作成");
    private static final RString 再送要 = new RString("※");
    private static final RString 年度R = new RString("年度");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200032");
    private static final Code コード = new Code("0003");
    private static final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");

    private KogakugassanProcessParameter processParameter;
    private KogakugassanMybatisParameter mybatisParam;
    private IOutputOrder 出力順情報;
    private List<RString> pageBreakKeys;
    private FileSpoolManager eucManager;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private int index;
    private RString 設定値;
    private List<PersonalData> personalDataList;
    private Set<ShikibetsuCode> 識別コードset;

    private BatchReportWriter<GassanHoseizumiJikofutangakuSofuchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanHoseizumiJikofutangakuSofuchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KogakugassanSoufuFairuSakuseiCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        識別コードset = new HashSet<>();
        personalDataList = new ArrayList<>();
        index = INT_1;
        get設定値();
        super.initialize();
        get出力順();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisParam = processParameter.toKogakugassanMybatisParameter();
        RString 出力順 = MyBatisOrderByClauseCreator.create(KogakugassanHoseisumiJikofutangakuOutputOrder.class, 出力順情報);
        mybatisParam.set出力順(出力順);
        return new BatchDbReader(READ_DATA_ID, mybatisParam);
    }

    @Override
    protected void createWriter() {
        eucManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = eucManager.getEucOutputDirectry();
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
    protected void usualProcess(SyuturyokuEntity entity) {
        if (index == INT_1) {
            PageBreaker<GassanHoseizumiJikofutangakuSofuchiranSource> breakPage
                    = new KogakugassanHoseisumiJikofutangakuOutPageBreak(pageBreakKeys);
            batchReportWriter
                    = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付).addBreak(breakPage).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        }
        GassanHoseizumiJikofutangakuSofuchiranReport report
                = new GassanHoseizumiJikofutangakuSofuchiranReport(
                        entity, 出力順情報, processParameter.getShoriYM(), processParameter.getNow().getRDateTime(), index, 設定値);
        report.writeBy(reportSourceWriter);
        KogakugassanSoufuFairuSakuseiCsvEntity csvEntity = getCsvEntity(index, entity);

        eucCsvWriter.writeLine(csvEntity);
        アクセスログ対象追加(entity);
        index = index + INT_1;
    }

    @Override
    protected void keyBreakProcess(SyuturyokuEntity t) {
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (index != INT_1) {
            batchReportWriter.close();
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
                eucManager.spool(eucFilePath, accessLogUUID);
            } else {
                eucManager.spool(eucFilePath);
            }
        }
    }

    private void アクセスログ対象追加(SyuturyokuEntity entity) {
        ShikibetsuCode 識別コード = entity.get被保険者一時Entity().getShikibetsuCode();
        HihokenshaNo 被保険者番号 = entity.get被保険者一時Entity().getExHihokenshaNo();
        if (null == 識別コード || 識別コード.isEmpty() || 識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        ExpandedInformation expandedInformations = new ExpandedInformation(コード, 漢字_被保険者番号, 被保険者番号.getColumnValue());
        personalDataList.add(PersonalData.of(識別コード, expandedInformations));
    }

    private KogakugassanSoufuFairuSakuseiCsvEntity getCsvEntity(int flag, SyuturyokuEntity entity) {
        KogakugassanSoufuFairuSakuseiCsvEntity csvEntity = new KogakugassanSoufuFairuSakuseiCsvEntity();
        if (flag == INT_1) {
            RString 処理年月 = processParameter.getShoriYM().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            csvEntity.set送付年月(処理年月);
            csvEntity.set作成日時(getSakuseiYmhm(processParameter.getNow().getRDateTime()));
            csvEntity.set保険者番号(processParameter.get保険者情報_保険者番号());
            csvEntity.set保険者名(processParameter.get保険者情報_保険者名称());
        }
        DbWT37K1KogakuGassanJikoFutanGakuTempEntity 一時Entity = entity.get高額合算自己負担額一時Entity();
        csvEntity.setNo(new RString(flag));
        FlexibleYear 対象年度 = 一時Entity.getTaishoNendo();
        RString 対象年度R = 対象年度 == null || 対象年度.isEmpty() ? RString.EMPTY
                : 対象年度.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(年度R);
        csvEntity.set対象年度(対象年度R);
        HihokenshaNo 被保険者番号 = 一時Entity.getHihokenshaNo();
        RString 被保険者番号R = 被保険者番号 == null || 被保険者番号.isEmpty() ? RString.EMPTY : 被保険者番号.getColumnValue();
        csvEntity.set被保険者番号(被保険者番号R);
        csvEntity.set申請書整理番号(一時Entity.getShikyuShinseishoSeiriNo());
        csvEntity.set被保険者氏名(entity.get被保険者一時Entity().getMeisho());
        FlexibleYearMonth 受取年月 = 一時Entity.getShomeisho_UketoriYM();
        RString 受取年月R = 受取年月 == null || 受取年月.isEmpty() ? RString.EMPTY : 受取年月.wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        csvEntity.set受取年月(受取年月R);
        csvEntity.setバッチ補正実施年月日(getFromatDate(一時Entity.getBatchHoseiJissiYMD()));
        csvEntity.setリアル補正実施年月日(getFromatDate(一時Entity.getRealHoseiJissiYMD()));
        csvEntity.set申請年月日(getFromatDate(一時Entity.getShinseiYMD()));
        csvEntity.set介護加入期間_開始年月日(getFromatDate(一時Entity.getHihokenshaKaishiYMD()));
        csvEntity.set介護加入期間_終了年月日(getFromatDate(一時Entity.getHihokenshaShuryoYMD()));
        csvEntity.set計算対象期間_開始年月日(getFromatDate(一時Entity.getTaishoKeisanKaishiYMD()));
        csvEntity.set計算対象期間_終了年月日(getFromatDate(一時Entity.getTaishoKeisanShuryoYMD()));
        csvEntity.set自己負担額合計(getFormatDecimal(一時Entity.getSumi_Gokei_JikoFutanGaku()));
        csvEntity.set自己負担額合計_うち70_74歳(getFormatDecimal(一時Entity.getSumi_Gokei_70_74JikoFutanGaku()));
        csvEntity.set高額介護サービス費(getFormatDecimal(一時Entity.getSumi_Gokei_Under70KogakuShikyuGaku()));
        RString 再送 = KokuhorenDataSaisoFlag.再送要.getコード().equals(一時Entity.getSaisoFlag()) ? 再送要 : RString.EMPTY;
        csvEntity.set再送(再送);
        return csvEntity;
    }

    private RString getFormatDecimal(Decimal dec) {
        return dec == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(dec, INT_0);
    }

    private RString getFromatDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY : date.wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getSakuseiYmhm(RDateTime datetime) {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成R);
        return sakuseiYMD.toRString();
    }

    private void get設定値() {
        ChohyoSeigyoHanyo hanyoResult = ChohyoSeigyoHanyoManager.createInstance()
                .get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID, 管理年度, ChohyoSeigyoHanyoKomokuMei.帳票タイトル.get名称());
        if (hanyoResult != null) {
            設定値 = hanyoResult.get設定値();
        } else {
            設定値 = RString.EMPTY;
        }
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processParameter.getShutsuryokujunId())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票ID, Long.parseLong(processParameter.getShutsuryokujunId().toString()));
        }
        if (出力順情報 == null) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(メッセージ引数.toString()).evaluate());
        }
        pageBreakKeys = new ArrayList<>();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }
}
