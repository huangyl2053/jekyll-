/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710160;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassankeisan.HanyoListKogakuGassanOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_KarisanteiData;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassan.HanyoListKogakuGassanKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassan.HanyoListKogakuGassanKeisanCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassan.HanyoListKogakuGassanKeisanEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)Processクラスです。
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
public class HanyoListKogakuGassanKeisanKekkaRenrakuHyoProcess
        extends BatchProcessBase<HanyoListKogakuGassanKeisanEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
                    + "hanyolistkogakugassan.IHanyoListKogakuGassanMapper.getCSVData");
    private FlexibleDate システム日付;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private List<KoseiShichosonMaster> 構成市町村マスタ;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701016");
    private HanyoListKogakuGassanKeisanProcessParameter parameter;
    private RString hanyoListKogakuFilePath;
    @BatchWriter
    private CsvWriter<HanyoListKogakuGassanKeisanCSVEntity> hanyoListKogakuCSVWriter;
    private static final RString コンマ = new RString(",");
    private static final RString 出力ファイル名
            = new RString("HanyoListKogakuGassanKeisanKekkaRenrakuHyo.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private Decimal 連番;
    private final int 定値INT_0 = 0;
    private final RString 定値RSTRING_0 = new RString("0");
    private final RString 定値RSTRING_1 = new RString("1");
    Map<LasdecCode, KoseiShichosonMaster> 構成市町村Map;
    private static final RString 文字_住特 = new RString("住特");
    private static final RString 文字_旧措置者 = new RString("旧措置者");
    private static final RString 文字_みなし = new RString("みなし");
    private static final RString 受給申請事由_初回申請 = new RString("初回申請　　");
    private static final RString 受給申請事由_再申請_有効期限内 = new RString("再申請内　　");
    private static final RString 受給申請事由_再申請_有効期限外 = new RString("再申請外　　");
    private static final RString 受給申請事由_要支援申請 = new RString("支援から申請");
    private static final RString 受給申請事由_区分変更申請 = new RString("区分変更申請");
    private static final RString 受給申請事由_指定サービス種類変更申請 = new RString("サ変更申請　");
    private static final RString 受給申請事由_申請_法施行前 = new RString("施行前申請　");
    private static final RString 受給申請事由_追加_申請なしの追加 = new RString("追加　　　　");
    private static final RString 追加_認定 = new RString("認定　　　　　");
    private static final RString 要介護度変更申請認定 = new RString("変更申請認定　");
    private static final RString 要介護度変更申請却下 = new RString("変更申請却下　");
    private static final RString サービス種類変更申請認定 = new RString("サ変更申請認定");
    private static final RString サービス種類変更申請却下 = new RString("サ変更申請却下");
    private static final RString 削除 = new RString("削除　　　　　");
    private static final RString 修正 = new RString("修正　　　　　");
    private static final RString 受給申請却下 = new RString("受給申請却下　");
    private static final RString 削除回復 = new RString("削除回復　　　");
    private static final RString 職権記載 = new RString("職権記載　　　");
    private static final RString 職権修正 = new RString("職権修正　　　");
    private static final RString 職権取消 = new RString("職権取消　　　");
    private static final RString 履歴修正 = new RString("履歴修正　　　");
    private List<PersonalData> personalDataList;
    private static final Code CODE = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額合算計算結果連絡票情報CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoListKogakuGassanKeisanKekkaRenrakuHyo.csv");
    private RString 出力有無;
    private static final RString あり = new RString("あり");
    private static final RString なし = new RString("なし");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 抽出区分 = new RString("抽出区分：");
    private static final RString データ区分 = new RString("データ区分：");
    private static final RString データ種類 = new RString("データ種類 ：");
    private static final RString 対象年度 = new RString("対象年度：");
    private static final RString 受取年月 = new RString("受取年月：");
    private static final RString 送付年月 = new RString("送付年月：");
    private static final RString すべて = new RString("すべて");
    private static final RString 波線 = new RString("～");
    private static final RString 斜線 = new RString("/");
    private static final RString 年度作成 = new RString("年度");
    private static final RString HEAD_連番 = new RString("連番");
    private static final RString HEAD_識別コード = new RString("識別コード");
    private static final RString HEAD_住民種別 = new RString("住民種別");
    private static final RString HEAD_氏名 = new RString("氏名");
    private static final RString HEAD_氏名カナ = new RString("氏名カナ");
    private static final RString HEAD_生年月日 = new RString("生年月日");
    private static final RString HEAD_年齢 = new RString("年齢");
    private static final RString HEAD_性別 = new RString("性別");
    private static final RString HEAD_続柄コード = new RString("続柄コード");
    private static final RString HEAD_世帯コード = new RString("世帯コード");
    private static final RString HEAD_世帯主名 = new RString("世帯主名");
    private static final RString HEAD_住所コード = new RString("住所コード");
    private static final RString HEAD_郵便番号 = new RString("郵便番号");
    private static final RString HEAD_住所番地方書 = new RString("住所番地方書");
    private static final RString HEAD_住所 = new RString("住所");
    private static final RString HEAD_番地 = new RString("番地");
    private static final RString HEAD_方書 = new RString("方書");
    private static final RString HEAD_行政区コード = new RString("行政区コード");
    private static final RString HEAD_行政区名 = new RString("行政区名");
    private static final RString HEAD_地区１ = new RString("地区１");
    private static final RString HEAD_地区２ = new RString("地区２");
    private static final RString HEAD_地区３ = new RString("地区３");
    private static final RString HEAD_連絡先１ = new RString("連絡先１");
    private static final RString HEAD_連絡先２ = new RString("連絡先２");
    private static final RString HEAD_登録異動日 = new RString("登録異動日");
    private static final RString HEAD_登録事由 = new RString("登録事由");
    private static final RString HEAD_登録届出日 = new RString("登録届出日");
    private static final RString HEAD_住定異動日 = new RString("住定異動日");
    private static final RString HEAD_住定事由 = new RString("住定事由");
    private static final RString HEAD_住定届出日 = new RString("住定届出日");
    private static final RString HEAD_消除異動日 = new RString("消除異動日");
    private static final RString HEAD_消除事由 = new RString("消除事由");
    private static final RString HEAD_消除届出日 = new RString("消除届出日");
    private static final RString HEAD_転出入理由 = new RString("転出入理由");
    private static final RString HEAD_前住所郵便番号 = new RString("前住所郵便番号");
    private static final RString HEAD_前住所番地方書 = new RString("前住所番地方書");
    private static final RString HEAD_前住所 = new RString("前住所");
    private static final RString HEAD_前住所番地 = new RString("前住所番地");
    private static final RString HEAD_前住所方書 = new RString("前住所方書");
    private static final RString HEAD_市町村コード = new RString("市町村コード");
    private static final RString HEAD_市町村名 = new RString("市町村名");
    private static final RString HEAD_保険者コード = new RString("保険者コード");
    private static final RString HEAD_保険者名 = new RString("保険者名");
    private static final RString HEAD_空白 = new RString("空白");
    private static final RString HEAD_送付先氏名 = new RString("送付先氏名");
    private static final RString HEAD_送付先氏名カナ = new RString("送付先氏名カナ");
    private static final RString HEAD_送付先住所コード = new RString("送付先住所コード");
    private static final RString HEAD_送付先郵便番号 = new RString("送付先郵便番号");
    private static final RString HEAD_送付先住所番地方書 = new RString("送付先住所番地方書");
    private static final RString HEAD_送付先住所 = new RString("送付先住所");
    private static final RString HEAD_送付先番地 = new RString("送付先番地");
    private static final RString HEAD_送付先方書 = new RString("送付先方書");
    private static final RString HEAD_送付先行政区コード = new RString("送付先行政区コード");
    private static final RString HEAD_送付先行政区名 = new RString("送付先行政区名");
    private static final RString HEAD_被保険者番号 = new RString("被保険者番号");
    private static final RString HEAD_資格取得事由 = new RString("資格取得事由");
    private static final RString HEAD_資格取得日 = new RString("資格取得日");
    private static final RString HEAD_資格取得届出日 = new RString("資格取得届出日");
    private static final RString HEAD_喪失事由 = new RString("喪失事由");
    private static final RString HEAD_資格喪失日 = new RString("資格喪失日");
    private static final RString HEAD_資格喪失届出日 = new RString("資格喪失届出日");
    private static final RString HEAD_資格区分 = new RString("資格区分");
    private static final RString HEAD_住所地特例状態 = new RString("住所地特例状態");
    private static final RString HEAD_受給申請事由 = new RString("受給申請事由");
    private static final RString HEAD_受給申請日 = new RString("受給申請日");
    private static final RString HEAD_受給要介護度 = new RString("受給要介護度");
    private static final RString HEAD_受給認定開始日 = new RString("受給認定開始日");
    private static final RString HEAD_受給認定終了日 = new RString("受給認定終了日");
    private static final RString HEAD_受給認定日 = new RString("受給認定日");
    private static final RString HEAD_受給旧措置 = new RString("受給旧措置");
    private static final RString HEAD_受給みなし更新認定 = new RString("受給みなし更新認定");
    private static final RString HEAD_受給直近事由 = new RString("受給直近事由");
    private static final RString HEAD_対象年度 = new RString("対象年度");
    private static final RString HEAD_保険者番号 = new RString("保険者番号");
    private static final RString HEAD_連絡票整理番号 = new RString("連絡票整理番号");
    private static final RString HEAD_履歴番号 = new RString("履歴番号");
    private static final RString HEAD_自己負担額証明書整理番号 = new RString("自己負担額証明書整理番号");
    private static final RString HEAD_対象計算期間_開始 = new RString("対象計算期間（開始）");
    private static final RString HEAD_対象計算期間_終了 = new RString("対象計算期間（終了）");
    private static final RString HEAD_世帯負担総額 = new RString("世帯負担総額");
    private static final RString HEAD_介護一部世帯負担 = new RString("介護一部世帯負担");
    private static final RString HEAD_介護一部世帯負担_７０ = new RString("７０介護一部世帯負担");
    private static final RString HEAD_所得区分 = new RString("所得区分");
    private static final RString HEAD_係る所得区分_70歳以上の者に = new RString("70歳以上の者に係る所得区分");
    private static final RString HEAD_介護等合算算定基準額 = new RString("介護等合算算定基準額");
    private static final RString HEAD_合算算定基準額_70歳以上介護等 = new RString("70歳以上介護等合算算定基準額");
    private static final RString HEAD_世帯支給総額 = new RString("世帯支給総額");
    private static final RString HEAD_うち70歳以上分世帯支給総額 = new RString("うち70歳以上分世帯支給総額");
    private static final RString HEAD_按分後支給額 = new RString("按分後支給額");
    private static final RString HEAD_うち70歳以上分按分後支給額 = new RString("うち70歳以上分按分後支給額");
    private static final RString HEAD_介護低所得者Ⅰ再計算実施の有無 = new RString("介護低所得者Ⅰ再計算実施の有無");
    private static final RString HEAD_負担額合計_70歳以上 = new RString("70歳以上負担額合計");
    private static final RString HEAD_かかる支給額合計 = new RString("70歳以上負担額合計にかかる支給額合計");
    private static final RString HEAD_負担額合計_70歳未満 = new RString("70歳未満負担額合計");
    private static final RString HEAD_負担額の合計額 = new RString("負担額の合計額");
    private static final RString HEAD_未満支給額合計_70歳 = new RString("70歳未満支給額合計");
    private static final RString HEAD_支給額合計額 = new RString("支給額合計額");
    private static final RString HEAD_データ区分 = new RString("データ区分");
    private static final RString HEAD_受取年月 = new RString("受取年月");
    private static final RString HEAD_送付年月 = new RString("送付年月");
    private static final RString HEAD_支給額計算結果連絡票作成年月日 = new RString("支給額計算結果連絡票作成年月日");
    private static final RString HEAD_データ種類 = new RString("データ種類");
    private static final RString ORDER_BY = new RString("ORDER BY ");
    private static final RString 出力順_被保険者番号 = new RString("\"dbT3072_hihokenshaNo\" ASC, ");
    private static final RString 出力順_対象年度 = new RString("\"dbT3072_taishoNendo\" ASC, ");
    private static final RString 出力順_保険者番号 = new RString("\"dbT3072_shoKisaiHokenshaNo\" ASC, ");
    private static final RString 出力順_支給申請書整理番号 = new RString("\"dbT3072_shikyuShinseishoSeiriNo\" ASC, ");
    private static final RString 出力順_履歴番号 = new RString("\"dbT3072_rirekiNo\" ASC");

    @Override
    protected void initialize() {
        super.initialize();
        出力有無 = なし;
        連番 = Decimal.ZERO;
        personalDataList = new ArrayList<>();
        システム日付 = FlexibleDate.getNowDate();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        構成市町村マスタ = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        構成市町村Map = new HashMap<>();
        if (構成市町村マスタ != null) {
            for (KoseiShichosonMaster data : 構成市町村マスタ) {
                if (data.get市町村コード() != null) {
                    構成市町村Map.put(data.get市町村コード(), data);
                }
            }
        }
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        parameter.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
    }

    @Override
    protected IBatchReader createReader() {
        parameter.set介護合算_仮算定データ(Kaigogassan_KarisanteiData.仮算定データ.getコード());
        parameter.set出力項目(get出力順());
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        hanyoListKogakuFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        hanyoListKogakuCSVWriter = BatchWriters.csvWriter(HanyoListKogakuGassanKeisanCSVEntity.class).
                filePath(hanyoListKogakuFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        if (parameter.is項目名付加()) {
            hanyoListKogakuCSVWriter.writeLine(getHeader());
        }
    }

    @Override
    protected void process(HanyoListKogakuGassanKeisanEntity entity) {
        出力有無 = あり;
        連番 = 連番.add(Decimal.ONE);
        HanyoListKogakuGassanKeisanCSVEntity output = get帳票のCSVファイル作成(entity);
        hanyoListKogakuCSVWriter.writeLine(output);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        hanyoListKogakuCSVWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, hanyoListKogakuFilePath, accessLog);
        } else {
            manager.spool(hanyoListKogakuFilePath);
        }
        バッチ出力条件リストの出力();
    }

    private HanyoListKogakuGassanKeisanCSVEntity
            get帳票のCSVファイル作成(HanyoListKogakuGassanKeisanEntity entity) {
        HanyoListKogakuGassanKeisanCSVEntity output = new HanyoListKogakuGassanKeisanCSVEntity();
        output.set連番(DecimalFormatter.toRString(連番, 定値INT_0));
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        if (kojin != null) {
            set宛名1(kojin, output);
            set宛名2(kojin, output);
        }
        set最新被保台帳(entity, output);
        IAtesaki atesaki = AtesakiFactory.createInstance(entity.get宛先());
        if (atesaki != null) {
            set宛先(atesaki, output);
        }
        set受給者台帳(entity, output);
        set高額合算支給額計算結果(entity, output);
        return output;
    }

    private void set宛名1(IKojin kojin,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        output.set識別コード(getColumnValue(kojin.get識別コード()));
        if (kojin.get住民状態() != null) {
            output.set住民種別(kojin.get住民状態().住民状態略称());
        }
        if (kojin.get名称() != null) {
            output.set氏名(getColumnValue(kojin.get名称().getName()));
            output.set氏名カナ(getColumnValue(kojin.get名称().getKana()));
        }
        if (kojin.get生年月日() != null) {
            RString temp = get日付項目(kojin.get生年月日().toFlexibleDate());
            output.set生年月日(temp);
        }
        if (kojin.get年齢算出() != null) {
            output.set年齢(kojin.get年齢算出().get年齢());
        }
        if (kojin.get性別() != null) {
            output.set性別(kojin.get性別().getName().getShortJapanese());
        }
        if (kojin.get続柄コードリスト() != null) {
            output.set続柄コード(getColumnValue(
                    kojin.get続柄コードリスト().toTsuzukigaraCode()));
        }
        output.set世帯コード(getColumnValue(kojin.get世帯コード()));
        output.set世帯主名(getColumnValue(kojin.get世帯主名()));
        if (kojin.get住所() != null) {
            output.set住所コード(getColumnValue(kojin.get住所().get全国住所コード()));
            output.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            if (kojin.get住所().get住所() != null
                    && kojin.get住所().get番地() != null
                    && kojin.get住所().get方書() != null) {
                output.set住所番地方書(kojin.get住所().get住所()
                        .concat(getColumnValue(kojin.get住所().get番地().getBanchi()))
                        .concat(RString.FULL_SPACE)
                        .concat(getColumnValue(kojin.get住所().get方書())));
            }
            output.set住所(kojin.get住所().get住所());
            if (kojin.get住所().get番地() != null) {
                output.set番地(getColumnValue(kojin.get住所().get番地().getBanchi()));
            }
            output.set方書(getColumnValue(kojin.get住所().get方書()));
        }
        if (kojin.get行政区画() != null) {
            if (kojin.get行政区画().getGyoseiku() != null) {
                output.set行政区コード(getColumnValue(kojin.get行政区画().getGyoseiku().getコード()));
                output.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            }
            if (kojin.get行政区画().getChiku1() != null) {
                output.set地区１(getColumnValue(kojin.get行政区画().getChiku1().getコード()));
            }
            if (kojin.get行政区画().getChiku2() != null) {
                output.set地区２(getColumnValue(kojin.get行政区画().getChiku2().getコード()));
            }
            if (kojin.get行政区画().getChiku3() != null) {
                output.set地区３(getColumnValue(kojin.get行政区画().getChiku3().getコード()));
            }
        }
        output.set連絡先１(getColumnValue(kojin.get連絡先１()));
        output.set連絡先２(getColumnValue(kojin.get連絡先２()));
    }

    private void set宛名2(IKojin kojin,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        output.set登録異動日(get日付項目(kojin.get登録異動年月日()));
        if (kojin.get登録事由() != null) {
            output.set登録事由((kojin.get登録事由().get異動事由略称()));
        }
        output.set登録届出日(get日付項目(kojin.get登録届出年月日()));
        output.set住定異動日(get日付項目(kojin.get住定異動年月日()));
        if (kojin.get住定事由() != null) {
            output.set住定事由(kojin.get住定事由().get異動事由略称());
        }
        output.set住定届出日(get日付項目(kojin.get住定届出年月日()));
        output.set消除異動日(get日付項目(kojin.get消除異動年月日()));
        if (kojin.get消除事由() != null) {
            output.set消除事由(kojin.get消除事由().get異動事由略称());
        }
        output.set消除届出日(get日付項目(kojin.get消除届出年月日()));
        output.set転出入理由(RString.EMPTY);
        if (kojin.get転入前() != null) {
            output.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            if (kojin.get転入前().get住所() != null
                    && kojin.get転入前().get番地() != null
                    && kojin.get転入前().get方書() != null) {
                output.set前住所番地方書(kojin.get転入前().get住所()
                        .concat(getColumnValue(kojin.get転入前().get番地().getBanchi()))
                        .concat(RString.FULL_SPACE)
                        .concat(getColumnValue(kojin.get転入前().get方書())));
            }
            output.set前住所(kojin.get転入前().get住所());
            if (kojin.get転入前().get番地() != null) {
                output.set前住所番地(getColumnValue(kojin.get転入前().get番地().getBanchi()));
            }
            output.set前住所方書(getColumnValue(kojin.get転入前().get方書()));
        }
    }

    private void set最新被保台帳(HanyoListKogakuGassanKeisanEntity entity,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        DbT1001HihokenshaDaichoEntity 最新被保台帳 = entity.get最新被保台帳();
        if (最新被保台帳 == null) {
            return;
        }
        LasdecCode 市町村コード = 最新被保台帳.getShichosonCode();
        RString 市町村コードValue = getColumnValue(市町村コード);
        output.set市町村コード(市町村コードValue);
        KoseiShichosonMaster 構成市町村;
        if (市町村コード != null) {
            構成市町村 = 構成市町村Map.get(市町村コード);
            if (構成市町村 != null) {
                output.set市町村名(構成市町村.get市町村名称());
            }
        }
        output.set保険者コード(getColumnValue(地方公共団体.get地方公共団体コード()));
        output.set保険者名(地方公共団体.get市町村名());
        output.set空白(RString.EMPTY);
        output.set被保険者番号(getColumnValue(最新被保台帳.getHihokenshaNo()));
        if (!RString.isNullOrEmpty(最新被保台帳.getShikakuShutokuJiyuCode())) {
            output.set資格取得事由(CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(),
                    new Code(最新被保台帳.getShikakuShutokuJiyuCode()), FlexibleDate.getNowDate()));
        }
        output.set資格取得日(get日付項目(最新被保台帳.getShikakuShutokuYMD()));
        output.set資格取得届出日(get日付項目(最新被保台帳.getShikakuShutokuTodokedeYMD()));
        if (!RString.isNullOrEmpty(最新被保台帳.getShikakuSoshitsuJiyuCode())) {
            output.set喪失事由(CodeMaster.getCodeRyakusho(
                    SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(最新被保台帳.getShikakuSoshitsuJiyuCode()), FlexibleDate.getNowDate()));
        }
        output.set資格喪失日(get日付項目(最新被保台帳.getShikakuSoshitsuYMD()));
        output.set資格喪失届出日(get日付項目(最新被保台帳.getShikakuSoshitsuTodokedeYMD()));
        if (!RString.isNullOrEmpty(最新被保台帳.getHihokennshaKubunCode())) {
            HihokenshaKubunCode 被保険者区分コード
                    = HihokenshaKubunCode.toValue(最新被保台帳.getHihokennshaKubunCode());
            output.set資格区分(被保険者区分コード != null ? 被保険者区分コード.get名称() : RString.EMPTY);
        }
        if (定値RSTRING_1.equals(最新被保台帳.getJushochiTokureiFlag())) {
            output.set住所地特例状態(文字_住特);
        }
    }

    private void set受給者台帳(HanyoListKogakuGassanKeisanEntity entity,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        DbT4001JukyushaDaichoEntity 受給者台帳 = entity.get受給者台帳();
        if (受給者台帳 == null) {
            return;
        }
        output.set受給申請事由(get受給申請事由(受給者台帳));
        output.set受給申請日(get日付項目(受給者台帳.getJukyuShinseiYMD()));
        if (受給者台帳.getYokaigoJotaiKubunCode() != null && !受給者台帳.getYokaigoJotaiKubunCode().isEmpty()) {
            IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(
                    システム日付, getColumnValue(受給者台帳.getYokaigoJotaiKubunCode()));
            output.set受給要介護度(要介護状態区分 != null ? 要介護状態区分.getName() : RString.EMPTY);
        }
        output.set受給認定開始日(get日付項目(受給者台帳.getNinteiYukoKikanKaishiYMD()));
        output.set受給認定終了日(get日付項目(受給者台帳.getNinteiYukoKikanShuryoYMD()));
        output.set受給認定日(get日付項目(受給者台帳.getNinteiYMD()));
        if (受給者台帳.getKyuSochishaFlag()) {
            output.set受給旧措置(文字_旧措置者);
        }
        RString みなし要介護区分コード = getColumnValue(受給者台帳.getShiteiServiceShurui01());
        if (!RString.isNullOrEmpty(みなし要介護区分コード)) {
            if (MinashiCode.通常の認定.getコード().equals(みなし要介護区分コード)) {
                output.set受給みなし更新認定(MinashiCode.toValue(みなし要介護区分コード).get名称());
            } else {
                output.set受給みなし更新認定(文字_みなし);
            }
        }
        output.set受給直近事由(set異動事由文言(getColumnValue(受給者台帳.getChokkinIdoJiyuCode())));
    }

    private void set高額合算支給額計算結果(HanyoListKogakuGassanKeisanEntity entity,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity 高額合算支給額計算結果
                = entity.get高額合算支給額計算結果();
        if (高額合算支給額計算結果 == null) {
            return;
        }
        output.set対象年度(get対象年度(高額合算支給額計算結果.getTaishoNendo()));
        output.set保険者番号(getColumnValue(高額合算支給額計算結果.getShoKisaiHokenshaNo()));
        output.set連絡票整理番号(高額合算支給額計算結果.getShikyuShinseishoSeiriNo());
        output.set履歴番号(new RString(高額合算支給額計算結果.getRirekiNo()));
        output.set自己負担額証明書整理番号(高額合算支給額計算結果.getJikoFutanSeiriNo());
        output.set対象計算期間_開始(get日付項目(高額合算支給額計算結果.getTaishoKeisanKaishiYMD()));
        output.set対象計算期間_終了(get日付項目(高額合算支給額計算結果.getTaishoKeisanShuryoYMD()));
        output.set世帯負担総額(doカンマ編集(高額合算支給額計算結果.getSetaiFutanSogaku()));
        output.set介護一部世帯負担(doカンマ編集(高額合算支給額計算結果.getSetaiGassanGaku()));
        output.set介護一部世帯負担_７０(doカンマ編集(高額合算支給額計算結果.getOver70_SetaiGassanGaku()));
        if (高額合算支給額計算結果.getShotokuKubun() != null) {
            KaigoGassan_ShotokuKbn 所得区分 = KaigoGassan_ShotokuKbn.toValue(高額合算支給額計算結果.getShotokuKubun());
            if (所得区分 != null) {
                output.set所得区分(所得区分.get名称());
            }
        }
        if (高額合算支給額計算結果.getOver70_ShotokuKubun() != null && !RString.EMPTY.equals(高額合算支給額計算結果.getOver70_ShotokuKubun())) {
            KaigoGassan_Over70_ShotokuKbn 区分_70歳以上 = KaigoGassan_Over70_ShotokuKbn.toValue(高額合算支給額計算結果.getOver70_ShotokuKubun());
            output.set係る所得区分_70歳以上の者に(区分_70歳以上 != null ? 区分_70歳以上.get名称() : RString.EMPTY);
        }
        output.set介護等合算算定基準額(doカンマ編集(高額合算支給額計算結果.getSanteiKijunGaku()));
        output.set合算算定基準額_70歳以上介護等(doカンマ編集(高額合算支給額計算結果.getOver70_SanteiKijyunGaku()));
        output.set世帯支給総額(doカンマ編集(高額合算支給額計算結果.getSetaiShikyuSogaku()));
        output.setうち70歳以上分世帯支給総額(doカンマ編集(高額合算支給額計算結果.getOver70_SetaiShikyuSogaku()));
        output.set按分後支給額(doカンマ編集(高額合算支給額計算結果.getHonninShikyugaku()));
        output.setうち70歳以上分按分後支給額(doカンマ編集(高額合算支給額計算結果.getOver70_honninShikyugaku()));
        output.set介護低所得者Ⅰ再計算実施の有無(高額合算支給額計算結果.getTeiShotoku_1_SaiKeisanUmu());
        output.set負担額合計_70歳以上(doカンマ編集(高額合算支給額計算結果.getOver70_FutangakuGokei()));
        output.setかかる支給額合計(doカンマ編集(高額合算支給額計算結果.getOver70_ShikyugakuGokei()));
        output.set負担額合計_70歳未満(doカンマ編集(高額合算支給額計算結果.getUnder70_FutangakuGokei()));
        output.set未満支給額合計_70歳(doカンマ編集(高額合算支給額計算結果.getUnder70_ShikyugakuGokei()));
        output.set負担額の合計額(doカンマ編集(高額合算支給額計算結果.getFutangakuGokei()));
        output.set支給額合計額(doカンマ編集(高額合算支給額計算結果.getShikyugakuGokei()));
        if (高額合算支給額計算結果.getDataKubun() != null) {
            Kaigogassan_DataKubun データ区分名称 = Kaigogassan_DataKubun.toValue(高額合算支給額計算結果.getDataKubun());
            output.setデータ区分(データ区分名称 != null ? データ区分名称.get名称() : RString.EMPTY);
        }
        output.set受取年月(get日付項目(高額合算支給額計算結果.getUketoriYM()));
        output.set送付年月(get日付項目(高額合算支給額計算結果.getSofuYM()));
        output.set支給額計算結果連絡票作成年月日(get日付項目(高額合算支給額計算結果.getTsuchiYMD()));
        output.setデータ種類(getColumnValue(高額合算支給額計算結果.getKekkaRenrakusakiYubinNo()));

    }

    private void set宛先(IAtesaki atesaki,
            HanyoListKogakuGassanKeisanCSVEntity output) {
        if (atesaki.get宛先名称() != null) {
            output.set送付先氏名(getColumnValue(atesaki.get宛先名称().getName()));
            output.set送付先氏名カナ(getColumnValue(atesaki.get宛先名称().getKana()));
        }
        if (atesaki.get宛先住所() != null) {
            output.set送付先住所コード(getColumnValue(atesaki.get宛先住所().get全国住所コード()));
            output.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            if (atesaki.get宛先住所().get住所() != null
                    && atesaki.get宛先住所().get番地() != null
                    && atesaki.get宛先住所().get方書() != null) {
                output.set送付先住所番地方書(atesaki.get宛先住所().get住所()
                        .concat(getColumnValue(atesaki.get宛先住所().get番地().getBanchi()))
                        .concat(RString.FULL_SPACE)
                        .concat(getColumnValue(atesaki.get宛先住所().get方書())));
            }
            output.set送付先住所(atesaki.get宛先住所().get住所());
            if (atesaki.get宛先住所().get番地() != null) {
                output.set送付先番地(getColumnValue(atesaki.get宛先住所().get番地().getBanchi()));
            }
            output.set送付先方書(getColumnValue(atesaki.get宛先住所().get方書()));
            if (atesaki.get宛先行政区() != null) {
                output.set送付先行政区コード(getColumnValue(atesaki.get宛先行政区().getコード()));
                output.set送付先行政区名(atesaki.get宛先行政区().get名称());
            }
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString get対象年度(FlexibleYear 対象年度) {
        if (null == 対象年度) {
            return RString.EMPTY;
        }
        return 対象年度.toDateString();
    }

    private RString getパターン32(FlexibleDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン32(FlexibleYearMonth date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get日付項目(FlexibleDate date) {
        RString temp = getパターン32(date);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
    }

    private RString get日付項目(FlexibleYearMonth date) {
        RString temp = getパターン32(date);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString get受給申請事由(DbT4001JukyushaDaichoEntity 受給者台帳) {
        RString 受給申請事由 = RString.EMPTY;
        RString 受給申請事由コード = getColumnValue(受給者台帳.getJukyuShinseiJiyu());
        受給申請事由 = getJukyuShinseiJiyu(受給申請事由コード, 受給申請事由, 受給者台帳.getYoshienshaNinteiShinseiFlag() ? 定値RSTRING_1 : 定値RSTRING_0);
        return 受給申請事由;
    }

    private RString getJukyuShinseiJiyu(RString 受給申請事由コード, RString 受給申請事由, RString 要支援者認定申請区分) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_再申請_有効期限内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_再申請_有効期限外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由コード)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(要支援者認定申請区分)) {
                受給申請事由 = 受給申請事由_要支援申請;
            } else {
                受給申請事由 = 受給申請事由_区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_指定サービス種類変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_申請_法施行前;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(受給申請事由コード)) {
            受給申請事由 = 受給申請事由_追加_申請なしの追加;
        }
        return 受給申請事由;
    }

    private RString set異動事由文言(RString 異動事由コード) {
        if (RString.isNullOrEmpty(異動事由コード)) {
            return RString.EMPTY;
        }
        RString 直近異動事由 = ChokkinIdoJiyuCode.toValue(異動事由コード).get名称();
        if (ChokkinIdoJiyuCode.未登録.get名称().equals(直近異動事由)) {
            return RString.EMPTY;
        } else if (ChokkinIdoJiyuCode.追加_認定.get名称().equals(直近異動事由)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.get名称().equals(直近異動事由)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.get名称().equals(直近異動事由)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.get名称().equals(直近異動事由)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.get名称().equals(直近異動事由)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.get名称().equals(直近異動事由)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.get名称().equals(直近異動事由)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.get名称().equals(直近異動事由)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.get名称().equals(直近異動事由)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.get名称().equals(直近異動事由)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.get名称().equals(直近異動事由)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.get名称().equals(直近異動事由)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.get名称().equals(直近異動事由)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }

    private PersonalData toPersonalData(HanyoListKogakuGassanKeisanEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 被保険者番号,
                entity.get高額合算支給額計算結果().getHihokenshaNo().value());
        return PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(hanyoListKogakuCSVWriter.getCount()));
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                導入団体コード,
                市町村名,
                RString.EMPTY,
                日本語ファイル名,
                出力件数,
                出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        get出力条件(出力条件, builder);
        builder = get保険者名();
        get出力条件(出力条件, builder);
        builder = get抽出区分();
        get出力条件(出力条件, builder);
        builder = getデータ区分();
        get出力条件(出力条件, builder);
        builder = getデータ種類();
        get出力条件(出力条件, builder);
        builder = get対象年度();
        get出力条件(出力条件, builder);
        builder = get年月期間(parameter.get受取年月From(), parameter.get受取年月To(), 受取年月);
        get出力条件(出力条件, builder);
        builder = get年月期間(parameter.get送付年月From(), parameter.get送付年月To(), 送付年月);
        get出力条件(出力条件, builder);
        return 出力条件;
    }

    private RStringBuilder get保険者名() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.get保険者コード() == null || parameter.get保険者コード().isEmpty()
                || すべて.equals(getColumnValue(parameter.get保険者コード()))) {
            return null;
        }
        builder.append(保険者);
        Association 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation(parameter.get保険者コード());
        builder.append(地方公共団体コード.get市町村名());
        return builder;
    }

    private RStringBuilder get抽出区分() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.get抽出区分())) {
            return null;
        }
        builder.append(抽出区分);
        Kaigogassan_ChushutsuKubun 抽出区分名称 = Kaigogassan_ChushutsuKubun.toValue(parameter.get抽出区分());
        builder.append(抽出区分名称 != null ? 抽出区分名称.get名称() : RString.EMPTY);
        return builder;
    }

    private RStringBuilder getデータ区分() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.getデータ区分())) {
            return null;
        }
        builder.append(データ区分);
        Kaigogassan_DataKubun データ区分名称 = Kaigogassan_DataKubun.toValue(parameter.getデータ区分());
        builder.append(データ区分名称 != null ? データ区分名称.get名称() : RString.EMPTY);
        return builder;
    }

    private RStringBuilder getデータ種類() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.getデータ種類())) {
            return null;
        }
        builder.append(データ種類);
        Kaigogassan_DataShubetsu データ種類名称 = Kaigogassan_DataShubetsu.toValue(parameter.getデータ種類());
        builder.append(データ種類名称 != null ? データ種類名称.get名称() : RString.EMPTY);
        return builder;
    }

    private RStringBuilder get対象年度() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.get対象年度() == null || parameter.get対象年度().isEmpty()) {
            return null;
        }
        builder.append(対象年度);
        builder.append(parameter.get対象年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).toDateString().concat(年度作成));
        return builder;
    }

    private RStringBuilder get年月期間(FlexibleYearMonth 年月From, FlexibleYearMonth 年月To, RString 抽出条件) {
        RStringBuilder builder = new RStringBuilder();
        boolean 年月FromFlag = false;
        boolean 年月ToFlag = false;
        if (年月From == null
                || 年月From.isEmpty()) {
            年月FromFlag = true;
        }
        if (年月To == null
                || 年月To.isEmpty()) {
            年月ToFlag = true;
        }
        if (年月FromFlag && 年月ToFlag) {
            return null;
        }
        builder.append(抽出条件);
        if (年月ToFlag) {
            builder.append(dateFormat(年月From))
                    .append(RString.FULL_SPACE).append(波線);
        } else if (年月FromFlag) {
            builder.append(波線).append(RString.FULL_SPACE)
                    .append(dateFormat(年月To));
        } else {
            builder.append(dateFormat(年月From))
                    .append(RString.FULL_SPACE).append(波線).append(RString.FULL_SPACE)
                    .append(dateFormat(年月To));
        }
        return builder;
    }

    private void get出力条件(List<RString> 出力条件, RStringBuilder builder) {
        if (builder == null) {
            return;
        }
        出力条件.add(builder.toRString());
    }

    private RString dateFormat(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }

    private HanyoListKogakuGassanKeisanCSVEntity getHeader() {
        HanyoListKogakuGassanKeisanCSVEntity csvEntity = new HanyoListKogakuGassanKeisanCSVEntity();
        csvEntity.set連番(HEAD_連番);
        csvEntity.set識別コード(HEAD_識別コード);
        csvEntity.set住民種別(HEAD_住民種別);
        csvEntity.set氏名(HEAD_氏名);
        csvEntity.set氏名カナ(HEAD_氏名カナ);
        csvEntity.set生年月日(HEAD_生年月日);
        csvEntity.set年齢(HEAD_年齢);
        csvEntity.set性別(HEAD_性別);
        csvEntity.set続柄コード(HEAD_続柄コード);
        csvEntity.set世帯コード(HEAD_世帯コード);
        csvEntity.set世帯主名(HEAD_世帯主名);
        csvEntity.set住所コード(HEAD_住所コード);
        csvEntity.set郵便番号(HEAD_郵便番号);
        csvEntity.set住所番地方書(HEAD_住所番地方書);
        csvEntity.set住所(HEAD_住所);
        csvEntity.set番地(HEAD_番地);
        csvEntity.set方書(HEAD_方書);
        csvEntity.set行政区コード(HEAD_行政区コード);
        csvEntity.set行政区名(HEAD_行政区名);
        csvEntity.set地区１(HEAD_地区１);
        csvEntity.set地区２(HEAD_地区２);
        csvEntity.set地区３(HEAD_地区３);
        csvEntity.set連絡先１(HEAD_連絡先１);
        csvEntity.set連絡先２(HEAD_連絡先２);
        csvEntity.set登録異動日(HEAD_登録異動日);
        csvEntity.set登録事由(HEAD_登録事由);
        csvEntity.set登録届出日(HEAD_登録届出日);
        csvEntity.set住定異動日(HEAD_住定異動日);
        csvEntity.set住定事由(HEAD_住定事由);
        csvEntity.set住定届出日(HEAD_住定届出日);
        csvEntity.set消除異動日(HEAD_消除異動日);
        csvEntity.set消除事由(HEAD_消除事由);
        csvEntity.set消除届出日(HEAD_消除届出日);
        csvEntity.set転出入理由(HEAD_転出入理由);
        csvEntity.set前住所郵便番号(HEAD_前住所郵便番号);
        csvEntity.set前住所番地方書(HEAD_前住所番地方書);
        csvEntity.set前住所(HEAD_前住所);
        csvEntity.set前住所番地(HEAD_前住所番地);
        csvEntity.set前住所方書(HEAD_前住所方書);
        csvEntity.set市町村コード(HEAD_市町村コード);
        csvEntity.set市町村名(HEAD_市町村名);
        csvEntity.set保険者コード(HEAD_保険者コード);
        csvEntity.set保険者名(HEAD_保険者名);
        csvEntity.set空白(HEAD_空白);
        csvEntity.set送付先氏名(HEAD_送付先氏名);
        csvEntity.set送付先氏名カナ(HEAD_送付先氏名カナ);
        csvEntity.set送付先住所コード(HEAD_送付先住所コード);
        csvEntity.set送付先郵便番号(HEAD_送付先郵便番号);
        csvEntity.set送付先住所番地方書(HEAD_送付先住所番地方書);
        csvEntity.set送付先住所(HEAD_送付先住所);
        csvEntity.set送付先番地(HEAD_送付先番地);
        csvEntity.set送付先方書(HEAD_送付先方書);
        csvEntity.set送付先行政区コード(HEAD_送付先行政区コード);
        csvEntity.set送付先行政区名(HEAD_送付先行政区名);
        csvEntity.set被保険者番号(HEAD_被保険者番号);
        csvEntity.set資格取得事由(HEAD_資格取得事由);
        csvEntity.set資格取得日(HEAD_資格取得日);
        csvEntity.set資格取得届出日(HEAD_資格取得届出日);
        csvEntity.set喪失事由(HEAD_喪失事由);
        csvEntity.set資格喪失日(HEAD_資格喪失日);
        csvEntity.set資格喪失届出日(HEAD_資格喪失届出日);
        csvEntity.set資格区分(HEAD_資格区分);
        csvEntity.set住所地特例状態(HEAD_住所地特例状態);
        csvEntity.set受給申請事由(HEAD_受給申請事由);
        csvEntity.set受給申請日(HEAD_受給申請日);
        csvEntity.set受給要介護度(HEAD_受給要介護度);
        csvEntity.set受給認定開始日(HEAD_受給認定開始日);
        csvEntity.set受給認定終了日(HEAD_受給認定終了日);
        csvEntity.set受給認定日(HEAD_受給認定日);
        csvEntity.set受給旧措置(HEAD_受給旧措置);
        csvEntity.set受給みなし更新認定(HEAD_受給みなし更新認定);
        csvEntity.set受給直近事由(HEAD_受給直近事由);
        csvEntity.set対象年度(HEAD_対象年度);
        csvEntity.set保険者番号(HEAD_保険者番号);
        csvEntity.set連絡票整理番号(HEAD_連絡票整理番号);
        csvEntity.set履歴番号(HEAD_履歴番号);
        csvEntity.set自己負担額証明書整理番号(HEAD_自己負担額証明書整理番号);
        csvEntity.set対象計算期間_開始(HEAD_対象計算期間_開始);
        csvEntity.set対象計算期間_終了(HEAD_対象計算期間_終了);
        csvEntity.set世帯負担総額(HEAD_世帯負担総額);
        csvEntity.set介護一部世帯負担(HEAD_介護一部世帯負担);
        csvEntity.set介護一部世帯負担_７０(HEAD_介護一部世帯負担_７０);
        csvEntity.set所得区分(HEAD_所得区分);
        csvEntity.set係る所得区分_70歳以上の者に(HEAD_係る所得区分_70歳以上の者に);
        csvEntity.set介護等合算算定基準額(HEAD_介護等合算算定基準額);
        csvEntity.set合算算定基準額_70歳以上介護等(HEAD_合算算定基準額_70歳以上介護等);
        csvEntity.set世帯支給総額(HEAD_世帯支給総額);
        csvEntity.setうち70歳以上分世帯支給総額(HEAD_うち70歳以上分世帯支給総額);
        csvEntity.set按分後支給額(HEAD_按分後支給額);
        csvEntity.setうち70歳以上分按分後支給額(HEAD_うち70歳以上分按分後支給額);
        csvEntity.set介護低所得者Ⅰ再計算実施の有無(HEAD_介護低所得者Ⅰ再計算実施の有無);
        csvEntity.set負担額合計_70歳以上(HEAD_負担額合計_70歳以上);
        csvEntity.setかかる支給額合計(HEAD_かかる支給額合計);
        csvEntity.set負担額合計_70歳未満(HEAD_負担額合計_70歳未満);
        csvEntity.set負担額の合計額(HEAD_負担額の合計額);
        csvEntity.set未満支給額合計_70歳(HEAD_未満支給額合計_70歳);
        csvEntity.set支給額合計額(HEAD_支給額合計額);
        csvEntity.setデータ区分(HEAD_データ区分);
        csvEntity.set受取年月(HEAD_受取年月);
        csvEntity.set送付年月(HEAD_送付年月);
        csvEntity.set支給額計算結果連絡票作成年月日(HEAD_支給額計算結果連絡票作成年月日);
        csvEntity.setデータ種類(HEAD_データ種類);
        return csvEntity;
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(HanyoListKogakuGassanOutPutOrder.class, order);
            出力順 = 出力順.concat(コンマ);
        }
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.concat(ORDER_BY);
        }
        出力順 = 出力順.concat(出力順_被保険者番号);
        出力順 = 出力順.concat(出力順_対象年度);
        出力順 = 出力順.concat(出力順_保険者番号);
        出力順 = 出力順.concat(出力順_支給申請書整理番号);
        出力順 = 出力順.concat(出力順_履歴番号);
        return 出力順;
    }
}
