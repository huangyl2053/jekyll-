/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranProperty;
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
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaKoshinKekkaIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushakoshinkekka.JukyushaKoshinKekkaInManager;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushakoshinkekka.JukyushaKoshinKekkaInPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 受給者情報更新結果情報取込の一覧表作成プロセス
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
public class JukyushaKoshinKekkaInDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200055");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString 一覧ファイルパス;
    @BatchWriter
    private CsvWriter csvWriter;

    private static final RString 出力ファイル名
            = new RString("DBC200055_JukyushaKoshinKekkaInIchiran.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY JUKYUSHAJOHOTEMP.\"hokenshaNo\" ASC");
    private static final RString コンマ = new RString(",");
    private static final RString 帳票分類ID = new RString("DBC200055_JukyushaKoshinkekkaIchiran");

    @Override
    protected void process() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        Map<String, Object> mybatisParameter = new HashMap<>();
        RString 出力順 = MyBatisOrderByClauseCreator.create(JukyushaKoshinKekkaIchiranProperty//
                .DBC120030ShutsuryokujunEnum.class, order);
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
        mybatisParameter.put(キー_出力順.toString(), 出力順);
        JukyushaKoshinKekkaInManager chohyoManager = JukyushaKoshinKekkaInManager.createInstance();
        List<JukyushaHihokenshaEntity> list = chohyoManager.get帳票出力対象データ(mybatisParameter);
        if (null == list || list.isEmpty()) {
            return;
        }
        List<RString> 住所List = new ArrayList<>();
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        for (JukyushaHihokenshaEntity 帳票出力対象データ : list) {
            RString 管内管外区分 = 帳票出力対象データ.get被保険者一時().get管内管外区分();
            RString 住所 = 帳票出力対象データ.get被保険者一時().get住所();
            RString 番地 = 帳票出力対象データ.get被保険者一時().get番地();
            RString 方書 = 帳票出力対象データ.get被保険者一時().get方書();
            RString 行政区名 = 帳票出力対象データ.get被保険者一時().get行政区名();
            LasdecCode 市町村コード = 帳票出力対象データ.get被保険者一時().get市町村コード();
            RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);
            住所List.add(編集住所);
        }
        JukyushaKoshinKekkaInPrintService printService
                = new JukyushaKoshinKekkaInPrintService();
        printService.printTaitsu(list, 住所List, order, parameter.get処理年月(), parameter.getシステム日付());
        do帳票のCSVファイル作成(list, 住所List, parameter.getシステム日付());

    }
    
    /**
     * 帳票のCSVファイル作成する。
     * 
     * @param list List<JukyushaHihokenshaEntity>
     * @param 住所List List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    private void do帳票のCSVファイル作成(List<JukyushaHihokenshaEntity> list, List<RString> 住所List, RDateTime 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        一覧ファイルパス = Path.combinePath(manager.getEucOutputDirectry(), 出力ファイル名);
        Path.combinePath(manager.getEucOutputDirectry(), 出力ファイル名);
        csvWriter = BatchWriters.csvWriter(JukyushaKoshinKekkaIchiranCsvEntity.class).filePath(一覧ファイルパス).build();

        Set<ShikibetsuCode> 識別コードset = new HashSet<>();
        for (int index = 0; index < list.size(); index++) {
            JukyushaHihokenshaEntity 出力対象 = list.get(index);
            DbWT5331JukyushaJohoTempEntity 受給者情報 = 出力対象.get受給者情報明細一時();
            DbWT0001HihokenshaTempEntity 被保険者 = 出力対象.get被保険者一時();
            JukyushaKoshinKekkaIchiranCsvEntity output = this.書き込むデータ作成(index, 受給者情報, 被保険者, 作成日時, 住所List);
            csvWriter.writeLine(output);
            if (null == 被保険者.get識別コード() || 被保険者.get識別コード().isEmpty()) {
                continue;
            }
            if (null == 被保険者.get宛名カナ名称() || 被保険者.get宛名カナ名称().isEmpty()) {
                continue;
            }
            if (null == 被保険者.get宛名名称() || 被保険者.get宛名名称().isEmpty()) {
                continue;
            }
            ShikibetsuCode 識別コード = new ShikibetsuCode(被保険者.get識別コード());
            if (識別コードset.contains(識別コード)) {
                continue;
            }
            識別コードset.add(識別コード);
            PersonalData personalData = getPersonalData(被保険者);
            personalDataList.add(personalData);
        }
        csvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(一覧ファイルパス, accessLogUUID);
        }
    }
    /**
     * CSV書き込むデータを作成する。
     * @param index int
     * @param 受給者情報 DbWT5331JukyushaJohoTempEntity
     * @param 被保険者 DbWT0001HihokenshaTempEntity
     * @param 作成日時 RDateTime
     * @param 住所List List<RString>
     * @return　CSV書き込むデータ
     */
    private JukyushaKoshinKekkaIchiranCsvEntity 書き込むデータ作成(int index, DbWT5331JukyushaJohoTempEntity 受給者情報, DbWT0001HihokenshaTempEntity 被保険者, RDateTime 作成日時, List<RString> 住所List) {
        JukyushaKoshinKekkaIchiranCsvEntity output = new JukyushaKoshinKekkaIchiranCsvEntity();
        RString 保険者名;
        if (受給者情報.get保険者名() == null) {
            保険者名 = RString.EMPTY;
        } else {
            if (受給者情報.get保険者名().length() > 80) {
                保険者名 = 受給者情報.get保険者名().substring(0, 80);
            } else {
                保険者名 = 受給者情報.get保険者名();
            }
        }
        if (index == 0) {
            output.set保険者番号(受給者情報.get保険者番号());
            output.set保険者名(保険者名);
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        } else {
            output.set保険者番号(RString.EMPTY);
            output.set保険者名(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        output.set訂正年月日(date_to_string(受給者情報.get訂正年月日()));
        output.set訂正区分(受給者情報.get訂正区分コード());
        JukyushaIF_TeiseiKubunCode 訂正区分コード = JukyushaIF_TeiseiKubunCode.toValue(受給者情報.get訂正区分コード());
        output.set訂正区分名称(訂正区分コード.get名称());
        output.set異動年月日(date_to_string(受給者情報.get異動年月日()));
        RString 異動区分コード = 受給者情報.get異動区分コード();
        output.set異動区分(異動区分コード);
        output.set異動区分名称(JukyushaIF_IdoKubunCode.toValue(異動区分コード).get名称());
        output.set異動事由(受給者情報.get異動事由区分());
        output.set異動事由名称(JukyushaIF_JukyushaIdoJiyu.toValue(受給者情報.get異動事由区分()).get名称());
        output.set被保険者番号(被保険者.get登録被保険者番号().getColumnValue());
        output.set被保険者氏名カナ(被保険者.get宛名カナ名称());
        output.set被保険者氏名(被保険者.get宛名名称());
        output.set行政区コード(被保険者.get行政区コード());
        output.set行政区(被保険者.get行政区名());
        output.set町域コード(被保険者.get町域コード());
        output.set住所(住所List.get(index));
        output.set生年月日(date_to_string(受給者情報.get生年月日()));
        output.set性別(受給者情報.get性別コード());
        output.set性別名称(Seibetsu.toValue(受給者情報.get性別コード()).get名称());
        output.set資格取得日(date_to_string(受給者情報.get資格取得年月日()));
        output.set資格喪失日(date_to_string(受給者情報.get資格喪失年月日()));
        output.setみなし区分(受給者情報.getみなし要介護区分コード());
        output.setみなし区分名称(MinashiCode.toValue(受給者情報.getみなし要介護区分コード()).get名称());
        output.set要介護区分(受給者情報.get要介護状態区分コード());
        output.set要介護区分名称(YokaigoJotaiKubunSupport.toValue(被保険者.getサービス提供年月末日(), 受給者情報.get要介護状態区分コード()).getName());
        output.set有効開始日(date_to_string(受給者情報.get認定有効期間開始年月日()));
        output.set有効終了日(date_to_string(受給者情報.get認定有効期間終了年月日()));
        output.set申請種別(受給者情報.get申請種別コード());
        output.set申請種別名称(JukyushaIF_ShinseiShubetsuCode.toValue(受給者情報.get申請種別コード()).get名称());
        output.set変更申請区分(受給者情報.get変更申請中区分コード());
        output.set変更申請区分名称(JukyushaIF_HenkoShinseichuKubunCode.toValue(受給者情報.get変更申請中区分コード()).get名称());
        output.set申請日(date_to_string(受給者情報.get申請年月日()));
        output.set計画作成区分(受給者情報.get居宅サービス計画作成区分コード());
        output.set計画作成区分名称(JukyushaIF_KeikakuSakuseiKubunCode.toValue(受給者情報.get居宅サービス計画作成区分コード()).get名称());
        output.set計画作成適用開始日(date_to_string(受給者情報.get居宅サービス計画適用開始年月日()));
        output.set計画作成適用終了日(date_to_string(受給者情報.get居宅サービス計画適用終了年月日()));
        output.set支援事業者番号(受給者情報.get居宅介護支援事業所番号());
        output.set訪問通所支給限度基準額(decimal_to_string(受給者情報.get訪問通所_支給限度基準額()));
        output.set訪問通所管理開始日(date_to_string(受給者情報.get訪問通所_上限管理適用期間開始年月日()));
        output.set訪問通所管理終了日(date_to_string(受給者情報.get訪問通所_上限管理適用期間終了年月日()));
        output.set短期入所支給限度基準額(decimal_to_string(受給者情報.get短期入所_支給限度基準額()));
        output.set短期入所管理開始日(date_to_string(受給者情報.get短期入所_上限管理適用期間開始年月日()));
        output.set短期入所管理終了日(date_to_string(受給者情報.get短期入所_上限管理適用期間終了年月日()));
        output.set標準負担区分(受給者情報.get標準負担区分コード());
        output.set標準負担区分名称(JukyushaIF_HyojunFutanKubunCode.toValue(受給者情報.get標準負担区分コード()).get名称());
        output.set標準負担額(decimal_to_string(受給者情報.get負担額()));
        output.set標準負担適用開始日(date_to_string(受給者情報.get負担額適用開始年月日()));
        output.set標準負担適用終了日(date_to_string(受給者情報.get負担額適用終了年月日()));
        output.set減免中区分(受給者情報.get減免申請中区分コード());
        output.set減免中区分名称(JukyushaIF_GemmenShinseichuKubunCode.toValue(受給者情報.get減免申請中区分コード()).get名称());
        output.set利用者負担区分(受給者情報.get利用者負担区分コード());
        output.set利用者負担区分名称(JukyushaIF_RiyoshaFutanKubunCode.toValue(受給者情報.get利用者負担区分コード()).get名称());
        output.set給付率(decimal_to_string(受給者情報.get給付率()));
        output.set利用者負担適用開始日(date_to_string(受給者情報.get利用者負担適用開始年月日()));
        output.set利用者負担適用終了日(date_to_string(受給者情報.get利用者負担適用終了年月日()));
        output.set公費負担上限額減額(受給者情報.get公費負担上限額減額の有無());
        output.set公費負担上限額減額名称(JukyushaIF_kohiFutanJogengakuGengakuUmu.toValue(受給者情報.get公費負担上限額減額の有無()).get名称());
        output.set償還払化開始日(date_to_string(受給者情報.get償還払化開始年月日()));
        output.set償還払化終了日(date_to_string(受給者情報.get償還払化終了年月日()));
        output.set給付率引下げ開始日(date_to_string(受給者情報.get給付率引下げ開始年月日()));
        output.set給付率引下げ終了日(date_to_string(受給者情報.get給付率引下げ終了年月日()));
        output.set住所地特例区分(受給者情報.get住所地特例対象者区分コード());
        output.set住所地特例区分名称(JukyushaIF_JutokuJigyoKubunCode.toValue(受給者情報.get住所地特例対象者区分コード()).get名称());
        output.set住所地特例施設所在保険者番号(受給者情報.get施設所在保険者番号());
        output.set住所地特例適用開始日(date_to_string(受給者情報.get住所地特例適用開始年月日()));
        output.set住所地特例適用終了日(date_to_string(受給者情報.get住所地特例適用終了年月日()));
        output.set老人保健市町村番号(受給者情報.get老人保健市町村番号());
        output.set老人保健受給者番号(受給者情報.get老人保健受給者番号());
        output.set広域_政令市_保険者番号(受給者情報.get広域連合_政令市_保険者番号());
        output.set小規模居宅サービス利用の有無(受給者情報.get小規模居宅サービス利用有無());
        output.set小規模居宅サービス利用の有無名称(JukyushaIF_ShokiboKyotakuServiceRIyoCode.toValue(受給者情報.get小規模居宅サービス利用有無()).get名称());
        output.set二次予防事業区分(受給者情報.get二次予防事業区分コード());
        output.set二次予防事業区分名称(JukyushaIF_NijiyoboJigyoKubunCode.toValue(受給者情報.get二次予防事業区分コード()).get名称());
        output.set二次予防事業開始日(date_to_string(受給者情報.get二次予防事業有効期間開始年月日()));
        output.set二次予防事業終了日(date_to_string(受給者情報.get二次予防事業有効期間終了年月日()));
        output.set特定入所者認定申請中区分(受給者情報.get特定入所者認定申請中区分コード());
        output.set特定入所者認定申請中区分名称(JukyushaIF_NinteiShinseichuKubunCode.toValue(受給者情報.get特定入所者認定申請中区分コード()).get名称());
        output.set特定入所者介護サービス区分(受給者情報.get特定入所者介護サービス区分コード());
        output.set特定入所者介護サービス区分名称(JukyushaIF_ServiceKubunCode.toValue(受給者情報.get特定入所者介護サービス区分コード()).get名称());
        output.set課税層の特例減額措置対象(受給者情報.get課税層の特例減額措置対象区分());
        output.set課税層の特例減額措置対象名称(JukyushaIF_TokureiGengakuSochiTaisho.toValue(受給者情報.get課税層の特例減額措置対象区分()).get名称());
        output.set課税層の特例減額適用開始日(date_to_string(受給者情報.get負担限度額適用開始年月日()));
        output.set課税層の特例減額適用終了日(date_to_string(受給者情報.get負担限度額適用終了年月日()));
        output.set特定入所者食費負担限度額(decimal_to_string(受給者情報.get特定入所者食費負担限度額()));
        output.set居住費_ユニット型個室_負担限度額(decimal_to_string(受給者情報.get居住費_ユニット型個室_負担限度額()));
        output.set居住費_従来型個室_特養等_負担限度額(decimal_to_string(受給者情報.get居住費_従来型個室_特養等_負担限度額()));
        output.set居住費_多床室_負担限度額(decimal_to_string(受給者情報.get居住費_多床室_負担限度額()));
        output.set居住費_新１_負担限度額(decimal_to_string(受給者情報.get居住費_新１_負担限度額()));
        output.set居住費_新２_負担限度額(decimal_to_string(受給者情報.get居住費_新２_負担限度額()));
        output.set居住費_新３_負担限度額(decimal_to_string(受給者情報.get居住費_新３_負担限度額()));
        output.set居住費_ユニット型準個室_負担限度額(decimal_to_string(受給者情報.get居住費_ユニット型準個室_負担限度額()));
        output.set居住費_従来型個室_老健_療養等_負担限度額(decimal_to_string(受給者情報.get居住費_従来型個室_老健_療養等_負担限度額()));
        output.set二割割合適用開始日(date_to_string(受給者情報.get二割負担適用開始年月日()));
        output.set二割割合適用終了日(date_to_string(受給者情報.get二割負担適用終了年月日()));
        output.set社会福祉法人軽減率(decimal_to_string(受給者情報.get軽減率()));
        output.set社会福祉法人適用開始日(date_to_string(受給者情報.get軽減率適用開始年月日()));
        output.set社会福祉法人適用終了日(date_to_string(受給者情報.get軽減率適用終了年月日()));
        output.set後期被保険者番号(受給者情報.get被保険者番号_後期_());
        output.set後期保険者番号(受給者情報.get保険者番号_後期_());
        output.set国保保険者番号(受給者情報.get保険者番号_国保_());
        output.set国保被保険者証番号(受給者情報.get被保険者証番号_国保_());
        output.set個人番号(受給者情報.get宛名番号());
        return output;
    }
    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }
    /**
     * 日付からstringに転換する。
     * 
     * @param  年月日
     *          日付
     * @return stringで表示する日付
     */
    private static RString date_to_string(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
    
    /**
     * 数値からstringに転換する。
     * 
     * @param  number
     *          数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
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
