/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120820;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranReport;
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
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TsugoJohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TsugoKekkaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakoshinkekka.JukyushaKoshinKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka.JukyushaKekkaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 受給者情報突合結果情報共通バッチ処理クラス．一覧表作成を実行する
 *
 * @reamsid_L DBC-2760-010 jianglaisheng
 */
public class JukyushaTotsugoKekkaDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<JukyushaHihokenshaEntity> {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private JukyushaKoshinKekkaMybatisParameter mybatisParameter;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private Set<ShikibetsuCode> 識別コードset;
    private RString 一覧ファイルパス;
    private IOutputOrder 出力順情報;
    private Map<RString, RString> 出力順Map;
    private List<RString> pageBreakKeys;
    private List<RString> 改頁リスト;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int 最大桁_12 = 12;
    private static final int 最大桁_30 = 30;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString パーセント = new RString("%");
    private static final RString 出力ファイル名
            = new RString("DBC200058_JukyushaTotsugokekkaIchiran.csv");
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakoshinkekka."
                    + "IJukyushaKoshinKekkaMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200058");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private static final RString 帳票分類ID = new RString("DBC200058_JukyushaTotsugokekkaIchiran");
    private static final RString SAKUSEI = new RString("作成");
    private final Code code = new Code("0003");
    private final RString 被保険者番号 = new RString("被保険者番号");

    private FileSpoolManager manager;
    @BatchWriter
    private BatchReportWriter<JukyushaKoshinKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKoshinKekkaIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter csvWriter;
    private ChohyoJushoEditor 住所Editor;

    @Override
    protected void initialize() {
        出力順Map = new HashMap<>();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        this.出力順情報 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == this.出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name()));
        RString orderByStr = MyBatisOrderByClauseCreator.create(JukyushaKoshinKekkaIchiranOutputOrder.class, 出力順情報);
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
        mybatisParameter = new JukyushaKoshinKekkaMybatisParameter();
        mybatisParameter.setOrderBy(orderByStr);
        住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        識別コードset = new HashSet();
    }

    @Override
    protected void keyBreakProcess(JukyushaHihokenshaEntity t) {
    }

    @Override
    protected void usualProcess(JukyushaHihokenshaEntity 帳票出力対象データ) {
        JukyushaHihokenshaEntity beforeEntity = getBefore();
        RString 管内管外区分 = 帳票出力対象データ.get被保険者一時().get管内管外区分();
        RString 住所 = 帳票出力対象データ.get被保険者一時().get住所();
        RString 番地 = 帳票出力対象データ.get被保険者一時().get番地();
        RString 方書 = 帳票出力対象データ.get被保険者一時().get方書();
        RString 行政区名 = 帳票出力対象データ.get被保険者一時().get行政区名();
        LasdecCode 市町村コード = 帳票出力対象データ.get被保険者一時().get市町村コード();
        RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);
        if (編集住所 == null) {
            編集住所 = RString.EMPTY;
        } else {
            if (最大桁_30 < 編集住所.length()) {
                編集住所 = 編集住所.substring(0, 最大桁_30);
            }
        }
        JukyushaKekkaIchiranCSVEntity output;
        if (beforeEntity != null) {
            output = this.createOutput(帳票出力対象データ.get受給者情報明細一時(),
                    帳票出力対象データ.get被保険者一時(), 編集住所, false);
        } else {
            output = this.createOutput(帳票出力対象データ.get受給者情報明細一時(),
                    帳票出力対象データ.get被保険者一時(), 編集住所, true);
        }
        JukyushaKoshinKekkaIchiranReport report = new JukyushaKoshinKekkaIchiranReport(帳票出力対象データ,
                編集住所, this.出力順Map, this.改頁リスト, parameter.getシステム日付(), 帳票分類ID);
        report.writeBy(reportSourceWriter);
        csvWriter.writeLine(output);
    }

    @Override
    protected void afterExecute() {
        this.csvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(一覧ファイルパス, accessLogUUID);
        } else {
            manager.spool(一覧ファイルパス);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, this.mybatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<JukyushaKoshinKekkaIchiranSource> breaker = new JukyushaKoshinKekkaIchiranPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200058.getReportId().value()).addBreak(breaker).create();
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

    private JukyushaKekkaIchiranCSVEntity createOutput(DbWT5331JukyushaJohoCsvEntity 受給者情報,
            DbWT0001HihokenshaTempEntity 被保険者, RString 住所, boolean ヘッダーフラグ) {
        JukyushaKekkaIchiranCSVEntity output = new JukyushaKekkaIchiranCSVEntity();

        if (ヘッダーフラグ) {
            headEditor(output, 受給者情報);
        } else {
            output.set保険者番号(RString.EMPTY);
            output.set保険者名(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        this.get突合結果(output, 受給者情報.get突合結果区分());
        this.get突合情報(output, 受給者情報.get突合情報区分());
        output.set異動年月日(date_to_string(受給者情報.get異動年月日()));
        this.get異動区分(output, 受給者情報.get異動区分コード());
        this.get異動事由(output, 受給者情報.get異動事由区分());
        output.set被保険者番号(被保険者.get登録被保険者番号().getColumnValue());
        output.set被保険者氏名カナ(被保険者.get宛名カナ名称());
        output.set被保険者氏名(被保険者.get宛名名称());
        output.set行政区コード(被保険者.get行政区コード());
        output.set行政区(被保険者.get行政区名());
        output.set町域コード(被保険者.get町域コード());
        output.set住所(住所);
        output.set生年月日(date_to_string(受給者情報.get生年月日()));
        this.get性別(output, 受給者情報.get性別コード());
        output.set資格取得日(date_to_string(受給者情報.get資格取得年月日()));
        output.set資格喪失日(date_to_string(受給者情報.get資格喪失年月日()));
        this.getみなし区分(output, 受給者情報.getみなし要介護区分コード());
        this.get要介護区分(output, 被保険者.getサービス提供年月末日(), 受給者情報.get要介護状態区分コード());
        output.set有効開始日(date_to_string(受給者情報.get認定有効期間開始年月日()));
        output.set有効終了日(date_to_string(受給者情報.get認定有効期間終了年月日()));
        this.get申請種別(output, 受給者情報.get申請種別コード());
        this.get変更申請区分(output, 受給者情報.get変更申請中区分コード());
        output.set申請日(date_to_string(受給者情報.get申請年月日()));
        this.get計画作成区分(output, 受給者情報.get居宅サービス計画作成区分コード());
        output.set計画作成適用開始日(date_to_string(受給者情報.get居宅サービス計画適用開始年月日()));
        output.set計画作成適用終了日(date_to_string(受給者情報.get居宅サービス計画適用終了年月日()));
        output.set支援事業者番号(受給者情報.get居宅介護支援事業所番号());
        output.set訪問通所支給限度基準額(decimal_to_string(受給者情報.get訪問通所_支給限度基準額()));
        output.set訪問通所管理開始日(date_to_string(受給者情報.get訪問通所_上限管理適用期間開始年月日()));
        output.set訪問通所管理終了日(date_to_string(受給者情報.get訪問通所_上限管理適用期間終了年月日()));
        output.set短期入所支給限度基準額(decimal_to_string(受給者情報.get短期入所_支給限度基準額()));
        output.set短期入所管理開始日(date_to_string(受給者情報.get短期入所_上限管理適用期間開始年月日()));
        output.set短期入所管理終了日(date_to_string(受給者情報.get短期入所_上限管理適用期間終了年月日()));
        this.get標準負担区分(output, 受給者情報.get標準負担区分コード());
        output.set標準負担額(decimal_to_string(受給者情報.get負担額()));
        output.set標準負担適用開始日(date_to_string(受給者情報.get負担額適用開始年月日()));
        output.set標準負担適用終了日(date_to_string(受給者情報.get負担額適用終了年月日()));
        this.get減免中区分(output, 受給者情報.get減免申請中区分コード());
        this.get利用者負担区分(output, 受給者情報.get利用者負担区分コード());
        output.set給付率(decimal_to_percentStr(受給者情報.get給付率()));
        output.set利用者負担適用開始日(date_to_string(受給者情報.get利用者負担適用開始年月日()));
        output.set利用者負担適用終了日(date_to_string(受給者情報.get利用者負担適用終了年月日()));
        this.get公費負担上限額減額(output, 受給者情報.get公費負担上限額減額の有無());
        output.set償還払化開始日(date_to_string(受給者情報.get償還払化開始年月日()));
        output.set償還払化終了日(date_to_string(受給者情報.get償還払化終了年月日()));
        output.set給付率引下げ開始日(date_to_string(受給者情報.get給付率引下げ開始年月日()));
        output.set給付率引下げ終了日(date_to_string(受給者情報.get給付率引下げ終了年月日()));
        this.get住所地特例区分(output, 受給者情報.get住所地特例対象者区分コード());
        output.set住所地特例施設所在保険者番号(受給者情報.get施設所在保険者番号());
        output.set住所地特例適用開始日(date_to_string(受給者情報.get住所地特例適用開始年月日()));
        output.set住所地特例適用終了日(date_to_string(受給者情報.get住所地特例適用終了年月日()));
        output.set老人保健市町村番号(受給者情報.get老人保健市町村番号());
        output.set老人保健受給者番号(受給者情報.get老人保健受給者番号());
        output.set広域_政令市_保険者番号(受給者情報.get広域連合_政令市_保険者番号());
        this.get小規模居宅サービス利用の有無(output, 受給者情報.get小規模居宅サービス利用有無());
        this.get二次予防事業区分(output, 受給者情報.get二次予防事業区分コード());
        output.set二次予防事業開始日(date_to_string(受給者情報.get二次予防事業有効期間開始年月日()));
        output.set二次予防事業終了日(date_to_string(受給者情報.get二次予防事業有効期間終了年月日()));
        this.get特定入所者認定申請中区分(output, 受給者情報.get特定入所者認定申請中区分コード());
        this.get特定入所者介護サービス区分(output, 受給者情報.get特定入所者介護サービス区分コード());
        this.get課税層の特例減額措置対象(output, 受給者情報.get課税層の特例減額措置対象区分());
        output.set課税層の特例減額適用開始日(date_to_string(受給者情報.get負担限度額適用開始年月日()));
        output.set課税層の特例減額適用終了日(date_to_string(受給者情報.get負担限度額適用終了年月日()));
        output.set特定入所者食費負担限度額(decimal_to_string(受給者情報.get特定入所者食費負担限度額()));
        output.set居住費_ユニット型個室_負担限度額(decimal_to_string(受給者情報.get居住費_ユニット型個室_負担限度額()));
        output.set居住費_従来型個室_特養等__負担限度額(decimal_to_string(受給者情報.get居住費_従来型個室_特養等_負担限度額()));
        output.set居住費_多床室_負担限度額(decimal_to_string(受給者情報.get居住費_多床室_負担限度額()));
        output.set居住費_新１_負担限度額(decimal_to_string(受給者情報.get居住費_新１_負担限度額()));
        output.set居住費_新２_負担限度額(decimal_to_string(受給者情報.get居住費_新２_負担限度額()));
        output.set居住費_新３_負担限度額(decimal_to_string(受給者情報.get居住費_新３_負担限度額()));
        output.set居住費_ユニット型準個室_負担限度額(decimal_to_string(受給者情報.get居住費_ユニット型準個室_負担限度額()));
        output.set居住費_従来型個室_老健_療養等__負担限度額(
                decimal_to_string(受給者情報.get居住費_従来型個室_老健_療養等_負担限度額()));
        output.set二割割合適用開始日(date_to_string(受給者情報.get二割負担適用開始年月日()));
        output.set二割割合適用終了日(date_to_string(受給者情報.get二割負担適用終了年月日()));
        output.set社会福祉法人軽減率(decimal_to_percentStr(受給者情報.get軽減率()));
        output.set社会福祉法人適用開始日(date_to_string(受給者情報.get軽減率適用開始年月日()));
        output.set社会福祉法人適用終了日(date_to_string(受給者情報.get軽減率適用終了年月日()));
        output.set後期被保険者番号(受給者情報.get被保険者番号_後期_());
        output.set後期保険者番号(受給者情報.get保険者番号_後期_());
        output.set国保保険者番号(受給者情報.get保険者番号_国保_());
        output.set国保被保険者証番号(受給者情報.get被保険者証番号_国保_());
        output.set個人番号(受給者情報.get宛名番号());
        if (null != 被保険者.get識別コード() && !被保険者.get識別コード().isEmpty()
                && null != 被保険者.get宛名カナ名称() && !被保険者.get宛名カナ名称().isEmpty()
                && null != 被保険者.get宛名名称() && !被保険者.get宛名名称().isEmpty()) {
            ShikibetsuCode 識別コード = new ShikibetsuCode(被保険者.get識別コード());
            if (!識別コード.isEmpty() && !this.識別コードset.contains(識別コード)) {
                this.識別コードset.add(識別コード);
                PersonalData personalData = this.getPersonalData(被保険者);
                this.personalDataList.add(personalData);
            }
        }
        return output;
    }

    private void headEditor(JukyushaKekkaIchiranCSVEntity output, DbWT5331JukyushaJohoCsvEntity 受給者情報) {
        RString 保険者名;
        if (受給者情報.get保険者名() == null) {
            保険者名 = RString.EMPTY;
        } else {
            if (最大桁_12 < 受給者情報.get保険者名().length()) {
                保険者名 = 受給者情報.get保険者名().substring(0, 最大桁_12);
            } else {
                保険者名 = 受給者情報.get保険者名();
            }
        }
        output.set保険者番号(受給者情報.get保険者番号());
        output.set保険者名(保険者名);
        RDateTime システム日時 = RDateTime.now();
        RString 作成日 = システム日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = システム日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
        output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(SAKUSEI));
    }

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 被保険者番号,
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private static RString date_to_string(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString date_to_string(RString 年月日) {
        if (null == 年月日 || RString.EMPTY.equals(年月日)  {
            return RString.EMPTY;
        }
        if (FlexibleDate.canConvert(年月日)) {
            if (new FlexibleDate(年月日).isWareki()) {
                return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
            }
        }
        return 年月日;
    }

    private static RString decimal_to_string(RString number) {
        if (null == number) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(number)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(number.toString()), 0);
        }
        return number;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private static RString decimal_to_percentStr(RString number) {
        if (null == number) {
            number = RString.EMPTY;
        }
        return number.concat(パーセント);
    }

    private void get突合結果(JukyushaKekkaIchiranCSVEntity output, RString 突合結果区分) {
        output.set突合結果(突合結果区分);
        if (!RString.isNullOrEmpty(突合結果区分)) {
            output.set突合結果名称(JukyushaIF_TsugoKekkaKubun.toValue(突合結果区分).get名称());
        }
    }

    private void get突合情報(JukyushaKekkaIchiranCSVEntity output, RString 突合情報区分) {
        output.set突合情報(突合情報区分);
        if (!RString.isNullOrEmpty(突合情報区分)) {
            output.set突合情報名称(JukyushaIF_TsugoJohoKubun.toValue(突合情報区分).get名称());
        }
    }

    private void get異動区分(JukyushaKekkaIchiranCSVEntity output, RString 異動区分) {
        output.set異動区分(異動区分);
        if (!RString.isNullOrEmpty(異動区分)) {
            output.set異動区分名称(JukyushaIF_IdoKubunCode.toValue(異動区分).get名称());
        }
    }

    private void get異動事由(JukyushaKekkaIchiranCSVEntity output, RString 異動事由) {
        output.set異動事由(異動事由);
        if (!RString.isNullOrEmpty(異動事由)) {
            output.set異動事由名称(JukyushaIF_JukyushaIdoJiyu.toValue(異動事由).get名称());
        }
    }

    private void getみなし区分(JukyushaKekkaIchiranCSVEntity output, RString みなし区分) {
        output.setみなし区分(みなし区分);
        if (!RString.isNullOrEmpty(みなし区分)) {
            output.setみなし区分名称(MinashiCode.toValue(みなし区分).get名称());
        }
    }

    private void get性別(JukyushaKekkaIchiranCSVEntity output, RString 性別) {
        output.set性別(性別);
        if (!RString.isNullOrEmpty(性別)) {
            output.set性別名称(Seibetsu.toValue(性別).get名称());
        }
    }

    private void get要介護区分(JukyushaKekkaIchiranCSVEntity output, FlexibleDate サービス提供年月末日, RString 要介護区分) {
        output.set要介護区分(要介護区分);
        if (!RString.isNullOrEmpty(要介護区分)) {
            output.set要介護区分名称(YokaigoJotaiKubunSupport.toValue(
                    サービス提供年月末日.getYearMonth(), 要介護区分).getName());
        }
    }

    private void get申請種別(JukyushaKekkaIchiranCSVEntity output, RString 申請種別) {
        output.set申請種別(申請種別);
        if (!RString.isNullOrEmpty(申請種別)) {
            output.set申請種別名称(JukyushaIF_ShinseiShubetsuCode.toValue(申請種別).get名称());
        }
    }

    private void get変更申請区分(JukyushaKekkaIchiranCSVEntity output, RString 変更申請区分) {
        output.set変更申請区分(変更申請区分);
        if (!RString.isNullOrEmpty(変更申請区分)) {
            output.set変更申請区分名称(JukyushaIF_HenkoShinseichuKubunCode.toValue(
                    変更申請区分).get名称());
        }
    }

    private void get計画作成区分(JukyushaKekkaIchiranCSVEntity output, RString 計画作成区分) {
        output.set計画作成区分(計画作成区分);
        if (!RString.isNullOrEmpty(計画作成区分)) {
            output.set計画作成区分名称(JukyushaIF_KeikakuSakuseiKubunCode.toValue(
                    計画作成区分).get名称());
        }
    }

    private void get標準負担区分(JukyushaKekkaIchiranCSVEntity output, RString 標準負担区分) {
        output.set標準負担区分(標準負担区分);
        if (!RString.isNullOrEmpty(標準負担区分)) {
            output.set標準負担区分名称(JukyushaIF_HyojunFutanKubunCode.toValue(標準負担区分).get名称());
        }
    }

    private void get減免中区分(JukyushaKekkaIchiranCSVEntity output, RString 減免中区分) {
        output.set減免中区分(減免中区分);
        if (!RString.isNullOrEmpty(減免中区分)) {
            output.set減免中区分名称(JukyushaIF_GemmenShinseichuKubunCode.toValue(減免中区分).get名称());
        }
    }

    private void get利用者負担区分(JukyushaKekkaIchiranCSVEntity output, RString 利用者負担区分) {
        output.set利用者負担区分(利用者負担区分);
        if (!RString.isNullOrEmpty(利用者負担区分)) {
            output.set利用者負担区分名称(JukyushaIF_RiyoshaFutanKubunCode.toValue(利用者負担区分).get名称());
        }
    }

    private void get公費負担上限額減額(JukyushaKekkaIchiranCSVEntity output, RString 公費負担上限額減額) {
        output.set公費負担上限額減額(公費負担上限額減額);
        if (!RString.isNullOrEmpty(公費負担上限額減額)) {
            output.set公費負担上限額減額名称(JukyushaIF_kohiFutanJogengakuGengakuUmu.toValue(
                    公費負担上限額減額).get名称());
        }
    }

    private void get住所地特例区分(JukyushaKekkaIchiranCSVEntity output, RString 住所地特例区分) {
        output.set住所地特例区分(住所地特例区分);
        if (!RString.isNullOrEmpty(住所地特例区分)) {
            output.set住所地特例区分名称(JukyushaIF_JutokuJigyoKubunCode.toValue(
                    住所地特例区分).get名称());
        }
    }

    private void get小規模居宅サービス利用の有無(JukyushaKekkaIchiranCSVEntity output, RString 小規模居宅サービス利用の有無) {
        output.set小規模居宅サービス利用の有無(小規模居宅サービス利用の有無);
        if (!RString.isNullOrEmpty(小規模居宅サービス利用の有無)) {
            output.set小規模居宅サービス利用の有無名称(JukyushaIF_ShokiboKyotakuServiceRIyoCode.toValue(
                    小規模居宅サービス利用の有無).get名称());
        }
    }

    private void get二次予防事業区分(JukyushaKekkaIchiranCSVEntity output, RString 二次予防事業区分) {
        output.set二次予防事業区分(二次予防事業区分);
        if (!RString.isNullOrEmpty(二次予防事業区分)) {
            output.set二次予防事業区分名称(JukyushaIF_NijiyoboJigyoKubunCode.toValue(
                    二次予防事業区分).get名称());
        }
    }

    private void get特定入所者認定申請中区分(JukyushaKekkaIchiranCSVEntity output, RString 特定入所者認定申請中区分) {
        output.set特定入所者認定申請中区分(特定入所者認定申請中区分);
        if (!RString.isNullOrEmpty(特定入所者認定申請中区分)) {
            output.set特定入所者認定申請中区分名称(JukyushaIF_NinteiShinseichuKubunCode.toValue(
                    特定入所者認定申請中区分).get名称());
        }
    }

    private void get特定入所者介護サービス区分(JukyushaKekkaIchiranCSVEntity output, RString 特定入所者介護サービス区分) {
        output.set特定入所者介護サービス区分(特定入所者介護サービス区分);
        if (!RString.isNullOrEmpty(特定入所者介護サービス区分)) {
            output.set特定入所者介護サービス区分名称(JukyushaIF_ServiceKubunCode.toValue(
                    特定入所者介護サービス区分).get名称());
        }
    }

    private void get課税層の特例減額措置対象(JukyushaKekkaIchiranCSVEntity output, RString 課税層の特例減額措置対象) {
        output.set課税層の特例減額措置対象(課税層の特例減額措置対象);
        if (!RString.isNullOrEmpty(課税層の特例減額措置対象)) {
            output.set課税層の特例減額措置対象名称(JukyushaIF_TokureiGengakuSochiTaisho.toValue(
                    課税層の特例減額措置対象).get名称());
        }
    }
}
