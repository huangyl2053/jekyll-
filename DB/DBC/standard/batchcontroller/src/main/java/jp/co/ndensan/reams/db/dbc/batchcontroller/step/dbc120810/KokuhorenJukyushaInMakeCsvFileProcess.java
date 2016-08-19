/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120810;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran.KokuhoernJukyushaDaichoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran.KokuhorenJukyushaDaichoIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran.KokuhorenJukyushaDaichoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_GemmenShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HenkoShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HyojunFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JutokuJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NijiyoboJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NinteiShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_RiyoshaFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ServiceKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShinseiShubetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShokiboKyotakuServiceRIyoCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_YuryoRojinHomeDoishoUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.KokuhorenJukyushaOutCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
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
 * 国保連保有受給者情報取込一覧表作成。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaInMakeCsvFileProcess extends BatchKeyBreakBase<DbWT0001DbWT5331Entity> {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private IOutputOrder 並び順;
    private Map<RString, RString> 出力順Map;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private List<DbWT0001DbWT5331Entity> entityList;
    private DbWT0001DbWT5331Entity currentRecord;
    private KokuhorenJukyushaOutCsvEntity csvEntity;
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
    private static final RString 帳票分類ID = new RString("DBC200055_JukyushaKoshinkekkaIchiran");
    private static final RString SAKUSEI = new RString("作成");
    private List<RString> 改頁項目名リスト;
    private List<RString> 改頁リスト;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenjukyushain."
            + "IKokuhorenJukyushaMapper.get帳票出力対象データ");
    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<JukyushaKoshinkekkaIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<JukyushaKoshinkekkaIchiranSource> reportSourceWriter_一覧表;
    private final Set<RString> 識別コードset = new HashSet<>();

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200006");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;

    private static final RString 出力ファイル名
            = new RString("DBC200006_KokuhorenJukyushaDaichoIchiran.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString デフォルト出力順 = new RString("order by DbWT5331.\"hokenshaNo\"");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 百分率 = new RString("%");

    @Override
    protected void initialize() {
        super.initialize();
        改頁項目名リスト = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        entityList = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        並び順 = order;
        RString 出力順 = MyBatisOrderByClauseCreator.create(KokuhorenJukyushaDaichoIchiranProperty//
                .DBC200006ShutsuryokujunEnum.class, order);
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

        帳票データの取得Parameter.set出力順(出力順);
        int i = 0;

        for (ISetSortItem item : 並び順.get設定項目リスト()) {

            if (item.is改頁項目()) {
                改頁項目名リスト.add(item.get項目名());
                改頁リスト.add(item.get項目ID());
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

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<JukyushaKoshinkekkaIchiranSource> breaker
                = new KokuhoernJukyushaDaichoIchiranPageBreak(改頁リスト);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
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
    protected void keyBreakProcess(DbWT0001DbWT5331Entity t) {
    }

    @Override
    protected void usualProcess(DbWT0001DbWT5331Entity entity) {
        アクセスログ対象追加(entity);

        currentRecord = entity;
        entityList.add(entity);
        DbWT0001DbWT5331Entity beforeEntity = getBefore();
        if (null != beforeEntity) {
            if (null == csvEntity) {
                csvEntity = new KokuhorenJukyushaOutCsvEntity();
                editヘッダー項目(beforeEntity);
            }
            setSource(beforeEntity);
            writeLine(beforeEntity);

        }
    }

    @Override
    protected void afterExecute() {
        if (!entityList.isEmpty()) {
            writeLine(currentRecord);
            if (1 == entityList.size()) {
                csvEntity = new KokuhorenJukyushaOutCsvEntity();
                editヘッダー項目(currentRecord);
            }
            setSource(currentRecord);
        }
        eucCsvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private void writeLine(DbWT0001DbWT5331Entity entity) {

        KokuhorenJukyushaDaichoIchiranReport report = new KokuhorenJukyushaDaichoIchiranReport(entity,
                出力順Map, parameter.getシステム日付(), csvEntity.get住所(), 改頁項目名リスト);
        report.writeBy(reportSourceWriter_一覧表);
    }

    private void editヘッダー項目(DbWT0001DbWT5331Entity entity) {

        csvEntity.set保険者番号(entity.get保険者番号());
        csvEntity.set保険者名(entity.get保険者名());
        RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日付().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));

    }

    private void アクセスログ対象追加(DbWT0001DbWT5331Entity entity) {
        RString 識別コード = entity.get識別コード();
        if (null == 識別コード || 識別コード.isEmpty()) {
            return;
        }
        if (識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private void setSource(DbWT0001DbWT5331Entity 出力対象) {
        csvEntity.set訂正年月日(doパターン4(出力対象.get訂正年月日()));
        csvEntity.set異動年月日(doパターン4(出力対象.get異動年月日()));
        csvEntity.set異動区分(出力対象.get異動区分コード());
        csvEntity.set異動区分名称(JukyushaIF_IdoKubunCode.toValue(出力対象.get異動区分コード()).get名称());
        csvEntity.set異動事由(出力対象.get異動事由区分());
        csvEntity.set異動事由名称(JukyushaIF_JukyushaIdoJiyu.toValue(出力対象.get異動事由区分()).get名称());
        csvEntity.set被保険者番号(出力対象.get登録被保険者番号().getColumnValue());
        csvEntity.set被保険者氏名カナ(出力対象.get宛名カナ名称());
        csvEntity.set被保険者氏名(出力対象.get宛名名称());
        csvEntity.set行政区コード(出力対象.get行政区コード());
        csvEntity.set行政区(出力対象.get行政区名());
        csvEntity.set町域コード(出力対象.get町域コード());
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        RString 住所 = 住所Editor
                .editJusho(出力対象.get管内管外区分(), 出力対象.get住所(), 出力対象.get番地(), 出力対象.get方書(), 出力対象.get行政区名(), 出力対象.get市町村コード());
        csvEntity.set住所(住所);
        csvEntity.set生年月日(doパターン4(出力対象.get生年月日()));
        csvEntity.set性別(出力対象.get性別コード());
        csvEntity.set性別名称(new RString(Seibetsu.toValue(出力対象.get性別コード()).name()));
        csvEntity.set資格取得日(doパターン4(出力対象.get資格取得年月日()));
        csvEntity.set資格喪失日(doパターン4(出力対象.get資格喪失年月日()));
        csvEntity.setみなし区分(出力対象.getみなし要介護区分コード());
        csvEntity.setみなし区分名称(new RString(MinashiCode
                .toValue(出力対象.getみなし要介護区分コード()).name()));
        csvEntity.set要介護区分(出力対象.get要介護状態区分コード());
        if (null != 出力対象.getサービス提供年月末日() && null != 出力対象.get要介護状態区分コード()) {
            IYokaigoJotaiKubun support = YokaigoJotaiKubunSupport
                    .toValue(出力対象.getサービス提供年月末日().getYearMonth(), 出力対象.get要介護状態区分コード());
            csvEntity.set要介護区分名称(support.getName());
        }
        csvEntity.set有効開始日(doパターン4(出力対象.get認定有効期間開始年月日()));
        csvEntity.set有効終了日(doパターン4(出力対象.get認定有効期間終了年月日()));
        csvEntity.set申請種別(出力対象.get申請種別コード());
        csvEntity.set申請種別名称(JukyushaIF_ShinseiShubetsuCode
                .toValue(出力対象.get申請種別コード()).get名称());
        csvEntity.set変更申請区分(出力対象.get変更申請中区分コード());
        csvEntity.set変更申請区分名称(JukyushaIF_HenkoShinseichuKubunCode
                .toValue(出力対象.get変更申請中区分コード()).get名称());
        csvEntity.set申請日(doパターン4(出力対象.get申請年月日()));
        csvEntity.set計画作成区分(出力対象.get居宅サービス計画作成区分コード());
        csvEntity.set計画作成区分名称(JukyushaIF_KeikakuSakuseiKubunCode
                .toValue(出力対象.get居宅サービス計画作成区分コード()).get名称());
        csvEntity.set計画作成適用開始日(doパターン4(出力対象.get居宅サービス計画適用開始年月日()));
        csvEntity.set計画作成適用終了日(doパターン4(出力対象.get居宅サービス計画適用終了年月日()));
        csvEntity.set支援事業者番号(出力対象.get居宅介護支援事業所番号());
        csvEntity.set訪問通所支給限度基準額(doカンマ編集(出力対象.get訪問通所支給限度基準額()));
        csvEntity.set訪問通所管理開始日(doパターン4(出力対象.get訪問通所上限管理適用期間開始年月日()));
        csvEntity.set訪問通所管理終了日(doパターン4(出力対象.get訪問通所上限管理適用期間終了年月日()));
        csvEntity.set短期入所支給限度基準額(doカンマ編集(出力対象.get短期入所支給限度基準額()));
        csvEntity.set短期入所管理開始日(doパターン4(出力対象.get短期入所上限管理適用期間開始年月日()));
        csvEntity.set短期入所管理終了日(doパターン4(出力対象.get短期入所上限管理適用期間終了年月日()));
        csvEntity.set標準負担区分(出力対象.get標準負担区分コード());
        csvEntity.set標準負担区分名称(JukyushaIF_HyojunFutanKubunCode
                .toValue(出力対象.get標準負担区分コード()).get名称());
        csvEntity.set標準負担額(doカンマ編集(出力対象.get負担額()));
        csvEntity.set標準負担適用開始日(doパターン4(出力対象.get負担額適用開始年月日()));
        csvEntity.set標準負担適用終了日(doパターン4(出力対象.get負担額適用終了年月日()));
        csvEntity.set減免中区分(出力対象.get減免申請中区分コード());
        csvEntity.set減免中区分名称(JukyushaIF_GemmenShinseichuKubunCode
                .toValue(出力対象.get減免申請中区分コード()).get名称());
        csvEntity.set利用者負担区分(出力対象.get利用者負担区分コード());
        csvEntity.set利用者負担区分名称(JukyushaIF_RiyoshaFutanKubunCode
                .toValue(出力対象.get利用者負担区分コード()).get名称());
        if (null != 出力対象.get給付率()) {
            csvEntity.set給付率(new RString(出力対象.get給付率().toString()).concat(百分率));
        }
        csvEntity.set利用者負担適用開始日(doパターン4(出力対象.get利用者負担適用開始年月日()));
        csvEntity.set利用者負担適用終了日(doパターン4(出力対象.get利用者負担適用終了年月日()));
        csvEntity.set公費負担上限額減額(出力対象.get公費負担上限額減額の有無());
        csvEntity.set公費負担上限額減額名称(JukyushaIF_kohiFutanJogengakuGengakuUmu
                .toValue(出力対象.get公費負担上限額減額の有無()).get名称());
        csvEntity.set償還払化開始日(doパターン4(出力対象.get償還払化開始年月日()));
        csvEntity.set償還払化終了日(doパターン4(出力対象.get償還払化終了年月日()));
        csvEntity.set給付率引下げ開始日(doパターン4(出力対象.get給付率引下げ開始年月日()));
        csvEntity.set給付率引下げ終了日(doパターン4(出力対象.get給付率引下げ終了年月日()));
        csvEntity.set住所地特例区分(出力対象.get住所地特例対象者区分コード());
        csvEntity.set住所地特例区分名称(JukyushaIF_JutokuJigyoKubunCode
                .toValue(出力対象.get住所地特例対象者区分コード()).get名称());
        csvEntity.set住所地特例施設所在保険者番号(出力対象.get施設所在保険者番号());
        csvEntity.set住所地特例適用開始日(doパターン4(出力対象.get住所地特例適用開始年月日()));
        csvEntity.set住所地特例適用終了日(doパターン4(出力対象.get住所地特例適用終了年月日()));
        csvEntity.set老人保健市町村番号(出力対象.get老人保健市町村番号());
        csvEntity.set老人保健受給者番号(出力対象.get老人保健受給者番号());
        csvEntity.set広域政令市保険者番号(出力対象.get広域連合政令市保険者番号());
        csvEntity.set小規模居宅サービス利用の有無(出力対象.get小規模居宅サービス利用有無());
        csvEntity.set小規模居宅サービス利用の有無名称(JukyushaIF_ShokiboKyotakuServiceRIyoCode
                .toValue(出力対象.get小規模居宅サービス利用有無()).get名称());
        csvEntity.set有料老人ホーム等同意書(出力対象.get有料老人ホーム等同意書の有無());
        csvEntity.set有料老人ホーム等同意書名称(JukyushaIF_YuryoRojinHomeDoishoUmu
                .toValue(出力対象.get有料老人ホーム等同意書の有無()).get名称());
        csvEntity.set二次予防事業区分(出力対象.get二次予防事業区分コード());
        csvEntity.set二次予防事業区分名称(JukyushaIF_NijiyoboJigyoKubunCode
                .toValue(出力対象.get二次予防事業区分コード()).get名称());
        csvEntity.set二次予防事業開始日(doパターン4(出力対象.get二次予防事業有効期間開始年月日()));
        csvEntity.set二次予防事業終了日(doパターン4(出力対象.get二次予防事業有効期間終了年月日()));
        csvEntity.set特定入所者認定申請中区分(出力対象.get特定入所者認定申請中区分コード());
        csvEntity.set特定入所者認定申請中区分名称(JukyushaIF_NinteiShinseichuKubunCode
                .toValue(出力対象.get特定入所者認定申請中区分コード()).get名称());
        csvEntity.set特定入所者介護サービス区分(出力対象.get特定入所者介護サービス区分コード());
        csvEntity.set特定入所者介護サービス区分名称(JukyushaIF_ServiceKubunCode
                .toValue(出力対象.get特定入所者介護サービス区分コード()).get名称());
        csvEntity.set課税層の特例減額措置対象(出力対象.get課税層の特例減額措置対象区分());
        csvEntity.set課税層の特例減額措置対象名称(JukyushaIF_TokureiGengakuSochiTaisho
                .toValue(出力対象.get課税層の特例減額措置対象区分()).get名称());
        csvEntity.set課税層の特例減額適用開始日(doパターン4(出力対象.get負担限度額適用開始年月日()));
        csvEntity.set課税層の特例減額適用終了日(doパターン4(出力対象.get負担限度額適用終了年月日()));
        csvEntity.set特定入所者食費負担限度額(doカンマ編集(出力対象.get特定入所者食費負担限度額()));
        csvEntity.set居住費ユニット型個室負担限度額(doカンマ編集(出力対象.get居住費ユニット型個室負担限度額()));
        csvEntity.set居住費従来型個室特養等負担限度額(doカンマ編集(出力対象.get居住費従来型個室特養等負担限度額()));
        csvEntity.set居住費多床室負担限度額(doカンマ編集(出力対象.get居住費多床室負担限度額()));
        csvEntity.set居住費新１負担限度額(doカンマ編集(出力対象.get居住費新１負担限度額()));
        csvEntity.set居住費新２負担限度額(doカンマ編集(出力対象.get居住費新２負担限度額()));
        csvEntity.set居住費新３負担限度額(doカンマ編集(出力対象.get居住費新３負担限度額()));
        csvEntity.set居住費ユニット型準個室負担限度額(doカンマ編集(出力対象.get居住費ユニット型準個室負担限度額()));
        csvEntity.set居住費従来型個室老健療養等負担限度額(doカンマ編集(出力対象.get居住費従来型個室老健療養等負担限度額()));
        csvEntity.set二割割合適用開始日(doパターン4(出力対象.get二割負担適用開始年月日()));
        csvEntity.set二割割合適用終了日(doパターン4(出力対象.get二割負担終了開始年月日()));
        if (null != 出力対象.get軽減率()) {
            csvEntity.set社会福祉法人軽減率(new RString(出力対象.get軽減率().toString()).concat(百分率));
        }
        csvEntity.set社会福祉法人適用開始日(doパターン4(出力対象.get軽減率適用開始年月日()));
        csvEntity.set社会福祉法人適用終了日(doパターン4(出力対象.get軽減率適用終了年月日()));
        csvEntity.set後期被保険者番号(出力対象.get被保険者番号後期());
        csvEntity.set後期保険者番号(出力対象.get保険者番号後期());
        csvEntity.set国保保険者番号(出力対象.get保険者番号国保());
        csvEntity.set国保被保険者証番号(出力対象.get被保険者証番号国保());
        csvEntity.set個人番号(出力対象.get宛名番号());
        eucCsvWriter.writeLine(csvEntity);
        csvEntity = new KokuhorenJukyushaOutCsvEntity();
    }

    private PersonalData getPersonalData(DbWT0001DbWT5331Entity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
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
