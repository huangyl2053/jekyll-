/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120110.GassanJikofutangakuKakunOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120110.GassanJikofutangakuKakunPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.dbc120110.GassanJikofutangakuKakunReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.GassanJikofutangakuKakunCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuKakunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 37J_高額合算自己負担額確認情報取込の一覧表作成を実行する。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class KogakuGassanJikofutangakuKakunDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<KogakuGassanJikofutangakuKakunEntity> {

    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString SAKUSEI = new RString("作成");
    private final Code code = new Code("0003");
    private final RString 漢字_被保険者番号 = new RString("被保険者番号");
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
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120110."
                    + "IKogakuGassanJikofutangakuMapper.get帳票出力対象データ");
    private final RString 固定改頁項目ID = new RString("0103");
    private static final RString 出力ファイル名
            = new RString("DBC200028_GassanJikofutangakuKakuninTorikomiIchiran.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200028");
    private int 連番 = 1;
    private final List<PersonalData> personalDataList = new ArrayList<>();

    private FileSpoolManager manager;
    private IOutputOrder 出力順情報;
    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private List<RString> pageBreakKeys;
    private List<RString> 改頁リスト;
    private Map<RString, RString> 出力順Map;
    private Set<ShikibetsuCode> 識別コードset;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private RString eucFilePath;
    @BatchWriter
    private BatchReportWriter<GassanJikofutangakuKakuninSource> batchReportWriter;
    private ReportSourceWriter<GassanJikofutangakuKakuninSource> reportSourceWriter;
    private CsvWriter<GassanJikofutangakuKakunCsvEntity> gassanJikofutangakuKakuninCsvWriter;

    @Override
    protected void initialize() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        this.出力順情報 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == this.出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        出力順Map = new HashMap<>();
        pageBreakKeys = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        pageBreakKeys.add(固定改頁項目ID);
        RString orderByStr = MyBatisOrderByClauseCreator.create(GassanJikofutangakuKakunOutPutOrder.class, 出力順情報);
        int i = 0;
        this.改頁リスト = new ArrayList();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
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
        識別コードset = new HashSet();
        帳票データの取得Parameter.set出力順(orderByStr);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanJikofutangakuKakuninSource> breaker = new GassanJikofutangakuKakunPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200028.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        gassanJikofutangakuKakuninCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void keyBreakProcess(KogakuGassanJikofutangakuKakunEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuGassanJikofutangakuKakunEntity entity) {
        アクセスログ対象追加(entity);
        GassanJikofutangakuKakunReport report = new GassanJikofutangakuKakunReport(entity,
                連番, parameter.get処理年月(), parameter.getシステム日付(), 出力順Map, 改頁リスト);
        report.writeBy(reportSourceWriter);
        this.csv作成(entity);
        連番++;
    }

    @Override
    protected void afterExecute() {
        gassanJikofutangakuKakuninCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private void csv作成(KogakuGassanJikofutangakuKakunEntity entity) {
        GassanJikofutangakuKakunCsvEntity output = new GassanJikofutangakuKakunCsvEntity();
        if (連番 == 1) {
            output.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RDateTime 作成日時 = parameter.getシステム日付();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            output.set保険者番号(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
            output.set保険者名(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        } else {
            output.set取込年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
            output.set保険者番号(RString.EMPTY);
            output.set保険者名(RString.EMPTY);
        }
        output.set連番(new RString(連番));
        output.set証記載保険者番号(entity.get証記載保険者番号());
        output.set証記載保険者名(entity.get証記載保険者名());
        output.set被保険者番号(entity.get被保険者番号());
        output.set被保険者氏名(entity.get被保険者氏名());
        output.set支給申請書整理番号(entity.get支給申請書整理番号());
        output.set対象年度(doパターン304(entity.get対象年度()));
        output.set履歴番号(new RString(entity.get履歴番号()));
        output.set申請年月日(doパターン4(entity.get申請年月日()));
        output.set異動区分コード(entity.get異動区分コード());
        output.set異動区分(this.get異動区分(entity.get異動区分コード()));
        output.set介護加入期間_開始(doパターン4(entity.get介護加入期間_開始()));
        output.set介護加入期間_終了(doパターン4(entity.get介護加入期間_終了()));
        output.set対象計算期間_開始(doパターン4(entity.get対象計算期間_開始()));
        output.set対象計算期間_終了(doパターン4(entity.get対象計算期間_終了()));
        output.set自己負担額合計(doカンマ編集(entity.get自己負担額合計()));
        output.set自己負担額合計_うち70_74歳(doカンマ編集(entity.get自己負担額合計_うち70_74歳()));
        output.set高額介護サービス費(doカンマ編集(entity.get高額介護サービス費()));
        gassanJikofutangakuKakuninCsvWriter.writeLine(output);
    }

    private RString doパターン304(FlexibleYear 年度) {
        if (null == 年度) {
            return RString.EMPTY;
        }
        return 年度.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString get異動区分(RString 異動区分コード) {
        if (!RString.isNullOrEmpty(異動区分コード)) {
            return KaigoGassan_Idokubun.toValue(異動区分コード).get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private void アクセスログ対象追加(KogakuGassanJikofutangakuKakunEntity entity) {
        if (null == entity.get識別コード() || entity.get識別コード().isEmpty()) {
            return;
        }
        if (識別コードset.contains(entity.get識別コード())) {
            return;
        }
        識別コードset.add(entity.get識別コード());
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(KogakuGassanJikofutangakuKakunEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 漢字_被保険者番号,
                entity.get被保険者番号());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }
}
