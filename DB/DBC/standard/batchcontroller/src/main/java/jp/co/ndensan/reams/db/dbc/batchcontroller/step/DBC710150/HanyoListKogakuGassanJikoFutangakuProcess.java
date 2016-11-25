/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_HoseiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_HoseizumiJikofutangakuSofuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_SofuTaishogaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyoListKogakuGassanJikoFutangakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト出力(高額合算自己負担額情報)CSV出力の処理クラスです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
public class HanyoListKogakuGassanJikoFutangakuProcess extends BatchProcessBase<HanyoListKogakuGassanJikoFutangakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkogakugassanjikofutangaku.IHanyoListKogakuGassanJikoFutangakuMapper.selectAllデータ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC701015"));
    private static final ReportId EUC_ID = new ReportId("DBC701015");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 直近異動事由コード00 = new RString("00");
    private static final RString 直近異動事由コード01 = new RString("01");
    private static final RString 直近異動事由コード02 = new RString("02");
    private static final RString 直近異動事由コード03 = new RString("03");
    private static final RString 直近異動事由コード04 = new RString("04");
    private static final RString 直近異動事由コード05 = new RString("05");
    private static final RString 直近異動事由コード06 = new RString("06");
    private static final RString 直近異動事由コード07 = new RString("07");
    private static final RString 直近異動事由コード08 = new RString("08");
    private static final RString 直近異動事由コード09 = new RString("09");
    private static final RString 直近異動事由コード10 = new RString("10");
    private static final RString 直近異動事由コード11 = new RString("11");
    private static final RString 直近異動事由コード12 = new RString("12");
    private static final RString 直近異動事由コード20 = new RString("20");
    private static final RString 直近異動事由コード名称00 = new RString("");
    private static final RString 直近異動事由コード名称01 = new RString("認定　　　　　");
    private static final RString 直近異動事由コード名称02 = new RString("変更申請認定　");
    private static final RString 直近異動事由コード名称03 = new RString("変更申請却下　");
    private static final RString 直近異動事由コード名称04 = new RString("サ変更申請認定");
    private static final RString 直近異動事由コード名称05 = new RString("サ変更申請却下");
    private static final RString 直近異動事由コード名称06 = new RString("削除　　　　　");
    private static final RString 直近異動事由コード名称07 = new RString("修正　　　　　");
    private static final RString 直近異動事由コード名称08 = new RString("受給申請却下　");
    private static final RString 直近異動事由コード名称09 = new RString("削除回復　　　");
    private static final RString 直近異動事由コード名称10 = new RString("職権記載　　　");
    private static final RString 直近異動事由コード名称11 = new RString("職権修正　　　");
    private static final RString 直近異動事由コード名称12 = new RString("職権取消　　　");
    private static final RString 直近異動事由コード名称20 = new RString("履歴修正　　　");
    private static final RString 受給申請事由_初回申請 = new RString("初回申請　　");
    private static final RString 受給申請事由_再申請内 = new RString("再申請内　　");
    private static final RString 受給申請事由_再申請外 = new RString("再申請外　　");
    private static final RString 受給申請事由_支援から申請 = new RString("支援から申請");
    private static final RString 受給申請事由_区分変更申請 = new RString("区分変更申請");
    private static final RString 受給申請事由_サ変更申請 = new RString("サ変更申請　");
    private static final RString 受給申請事由_施行前申請 = new RString("施行前申請　");
    private static final RString 受給申請事由_追加 = new RString("追加　　　　");
    private static final int NUMZERO = 0;
    private static final Code CODE = new Code("0003");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 住特_表示 = new RString("住特");
    private static final RString 旧措置者_表示 = new RString("旧措置者");
    private static final RString みなし_表示 = new RString("みなし");
    private static final RString すべて = new RString("すべて");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 抽出区分 = new RString("抽出区分：");
    private static final RString データ作成区分 = new RString("データ作成区分：");
    private static final RString データ種類 = new RString("データ種類：");
    private static final RString 補正状況 = new RString("補正状況：");
    private static final RString 対象年度 = new RString("対象年度：");
    private static final RString 申請年月日 = new RString("申請年月日：");
    private static final RString 支給申請書整理番号 = new RString("支給申請書整理番号：");
    private static final RString 自己負担額確認情報受取年月 = new RString("自己負担額確認情報受取年月：");
    private static final RString 補正済自己負担額情報送付年月 = new RString("補正済自己負担額情報送付年月：");
    private static final RString 自己負担額証明書情報受取年月 = new RString("自己負担額証明書情報受取年月：");
    private static final RString 波線 = new RString("　～　");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final RString 送付対象外データを含める = new RString("送付対象外データを含める");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額合算自己負担額情報CSV");
    private static final RString 出力ファイル名 = new RString("HanyoListKogakuGassanJikoFutangaku.csv");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString 斜線 = new RString("/");
    private static final RString ORDER_BY = new RString("ORDER BY ");
    private static final RString 出力順_被保険者番号 = new RString("\"高額合算自己負担額_被保険者番号\" ASC, ");
    private static final RString 出力順_対象年度 = new RString("\"高額合算自己負担額_対象年度\" ASC, ");
    private static final RString 出力順_保険者番号 = new RString("\"高額合算自己負担額_保険者番号\" ASC, ");
    private static final RString 出力順_支給申請書整理番号 = new RString("\"高額合算自己負担額_整理番号\" ASC, ");
    private static final RString 出力順_履歴番号 = new RString("\"高額合算自己負担額_履歴番号\" ASC");
    private RString 出力有無;
    private HanyoListKogakuGassanJikoFutangakuProcessParameter parameter;
    private List<KoseiShichosonMaster> 構成市町村マスタlist;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村Map;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private FlexibleDate システム日付;
    private Decimal 連番;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;

    @BatchWriter
    private CsvWriter<HanyoListKogakuGassanJikoFutangakuCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        連番 = Decimal.ONE;
        出力有無 = CSV出力有無_なし;
        システム日付 = FlexibleDate.getNowDate();
        parameter.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
        parameter.set出力項目(get出力順());
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = BatchWriters.csvWriter(HanyoListKogakuGassanJikoFutangakuCsvEntity.class).
                filePath(eucFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.is項目名付加()).
                build();
    }

    @Override
    protected void beforeExecute() {

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        構成市町村マスタlist = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        構成市町村Map = new HashMap<>();
        personalDataList = new ArrayList<>();
        if (構成市町村マスタlist != null) {
            for (KoseiShichosonMaster data : 構成市町村マスタlist) {
                if (data.get市町村コード() != null) {
                    構成市町村Map.put(data.get市町村コード(), data);
                }
            }
        }
    }

    @Override
    protected void process(HanyoListKogakuGassanJikoFutangakuEntity entity) {
        出力有無 = CSV出力有無_あり;
        HanyoListKogakuGassanJikoFutangakuCsvEntity eucCsvEntity = new HanyoListKogakuGassanJikoFutangakuCsvEntity();
        eucCsvEntity.set連番(DecimalFormatter.toRString(連番, NUMZERO));
        連番 = 連番.add(Decimal.ONE);
        edit高額合算自己負担額情報ファイル作成(entity, eucCsvEntity);
        eucCsvWriter.writeLine(eucCsvEntity);
        personalDataList.add(toPersonalData(entity));
    }

    private PersonalData toPersonalData(HanyoListKogakuGassanJikoFutangakuEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 定数_被保険者番号,
                entity.get高額合算自己負担額_被保険者番号().getColumnValue());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    private void edit高額合算自己負担額情報ファイル作成(HanyoListKogakuGassanJikoFutangakuEntity entity,
            HanyoListKogakuGassanJikoFutangakuCsvEntity eucCsvEntity) {
        set宛名(entity, eucCsvEntity);
        set宛先(entity, eucCsvEntity);
        set被保険者台帳管理(entity, eucCsvEntity);
    }

    private void set宛名(HanyoListKogakuGassanJikoFutangakuEntity entity,
            HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {
        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            ShikibetsuCode 識別コード = 宛名.get識別コード();
            csvEntity.set識別コード(識別コード != null
                    ? 識別コード.getColumnValue() : RString.EMPTY);
            csvEntity.set住民種別(宛名.get住民状態().住民状態略称());
            AtenaMeisho 氏名 = 宛名.get名称().getName();
            csvEntity.set氏名(氏名 != null
                    ? 氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 氏名カナ = 宛名.get名称().getKana();
            csvEntity.set氏名カナ(氏名カナ != null
                    ? 氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set生年月日(dataToRString(宛名.get生年月日().toFlexibleDate()));
            csvEntity.set年齢(宛名.get年齢算出().get年齢());
            if (宛名.get性別() != null) {
                csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
            }
            TsuzukigaraCode 続柄コード = 宛名.get続柄コードリスト().toTsuzukigaraCode();
            csvEntity.set続柄コード(続柄コード != null
                    ? 続柄コード.getColumnValue() : RString.EMPTY);
            SetaiCode 世帯コード = 宛名.get世帯コード();
            csvEntity.set世帯コード(世帯コード != null
                    ? 世帯コード.getColumnValue() : RString.EMPTY);
            AtenaMeisho 世帯主名 = 宛名.get世帯主名();
            csvEntity.set世帯主名(世帯主名 != null
                    ? 世帯主名.getColumnValue() : RString.EMPTY);
            ZenkokuJushoCode 住所コード = 宛名.get住所().get全国住所コード();
            csvEntity.set住所コード(住所コード != null
                    ? 住所コード.getColumnValue() : RString.EMPTY);
            YubinNo 郵便番号 = 宛名.get住所().get郵便番号();
            csvEntity.set郵便番号(郵便番号 != null
                    ? 郵便番号.getEditedYubinNo() : RString.EMPTY);
            set宛名本人(宛名, csvEntity);
        }
    }

    private void set宛名本人(IKojin 宛名, HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {
        if (宛名.get住所() != null) {
            Banchi 番地 = 宛名.get住所().get番地();
            Katagaki 方書 = 宛名.get住所().get方書();
            RString 住所 = 宛名.get住所().get住所();
            if (番地 != null && 方書 != null && 住所 != null) {
                csvEntity.set住所と番地と方書(住所.concat(番地.getBanchi().getColumnValue())
                        .concat(RString.FULL_SPACE).concat(方書.getColumnValue()));
            }
            csvEntity.set住所(住所 != null
                    ? 住所 : RString.EMPTY);
            csvEntity.set番地(番地 != null
                    ? 番地.getBanchi().getColumnValue() : RString.EMPTY);
            csvEntity.set方書(方書 != null
                    ? 方書.getColumnValue() : RString.EMPTY);
        }
        if (宛名.get行政区画() != null) {
            GyoseikuCode 行政区コード = 宛名.get行政区画().getGyoseiku().getコード();
            RString 地区1;
            RString 地区2;
            RString 地区3;
            if (宛名.get行政区画().getChiku1() != null) {
                地区1 = 宛名.get行政区画().getChiku1().getコード().getColumnValue();
            } else {
                地区1 = RString.EMPTY;
            }
            if (宛名.get行政区画().getChiku2() != null) {
                地区2 = 宛名.get行政区画().getChiku2().getコード().getColumnValue();
            } else {
                地区2 = RString.EMPTY;
            }
            if (宛名.get行政区画().getChiku3() != null) {
                地区3 = 宛名.get行政区画().getChiku3().getコード().getColumnValue();
            } else {
                地区3 = RString.EMPTY;
            }

            TelNo 連絡先1 = 宛名.get連絡先１();
            TelNo 連絡先2 = 宛名.get連絡先２();
            YubinNo 前住所郵便番号 = 宛名.get転入前().get郵便番号();
            csvEntity.set行政区コード(行政区コード != null ? 行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set行政区名(宛名.get行政区画().getGyoseiku().get名称());
            csvEntity.set地区１(地区1);
            csvEntity.set地区２(地区2);
            csvEntity.set地区３(地区3);
            csvEntity.set連絡先１(連絡先1 != null ? 連絡先1.getColumnValue() : RString.EMPTY);
            csvEntity.set連絡先２(連絡先2 != null ? 連絡先2.getColumnValue() : RString.EMPTY);
            csvEntity.set登録異動日(dataToRString(宛名.get登録異動年月日()));
            IIdoJiyu 登録事由 = 宛名.get登録事由();
            IIdoJiyu 住定事由 = 宛名.get住定事由();
            IIdoJiyu 消除事由 = 宛名.get消除事由();
            csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set登録届出日(dataToRString(宛名.get登録届出年月日()));
            csvEntity.set住定異動日(dataToRString(宛名.get住定異動年月日()));
            csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set住定届出日(dataToRString(宛名.get住定届出年月日()));
            csvEntity.set消除異動日(dataToRString(宛名.get消除異動年月日()));
            csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set消除届出日(dataToRString(宛名.get消除届出年月日()));
            csvEntity.set転出入理由(RString.EMPTY);
            csvEntity.set前住所郵便番号(前住所郵便番号 != null ? 前住所郵便番号.getEditedYubinNo() : RString.EMPTY);
        }
    }

    private void set宛先(HanyoListKogakuGassanJikoFutangakuEntity entity,
            HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先Entity());
            AtenaMeisho 送付先氏名 = 宛先.get宛先名称().getName();
            AtenaKanaMeisho 送付先氏名カナ = 宛先.get宛先名称().getKana();
            ZenkokuJushoCode 送付先住所コード = 宛先.get宛先住所().get全国住所コード();
            YubinNo 送付先郵便番号 = 宛先.get宛先住所().get郵便番号();
            GyoseikuCode 送付先行政区コード = 宛先.get宛先行政区().getコード();
            csvEntity.set送付先氏名(送付先氏名 != null
                    ? 送付先氏名.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先氏名カナ(送付先氏名カナ != null
                    ? 送付先氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先住所コード(送付先住所コード != null
                    ? 送付先住所コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先郵便番号(送付先郵便番号 != null
                    ? 送付先郵便番号.getEditedYubinNo() : RString.EMPTY);

            csvEntity.set送付先行政区コード(送付先行政区コード != null
                    ? 送付先行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先行政区名(宛先.get宛先行政区().get名称());
            set前住所番地方書(宛先, csvEntity);

        }
    }

    private void set前住所番地方書(IAtesaki 宛先, HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {
        if (宛先.get宛先住所() != null) {
            RString 送付先住所 = 宛先.get宛先住所().get住所();
            AtenaBanchi 送付先番地 = 宛先.get宛先住所().get番地().getBanchi();
            Katagaki 送付先方書 = 宛先.get宛先住所().get方書();
            if (送付先住所 != null && 送付先番地 != null && 送付先方書 != null) {
                csvEntity.set送付先住所と番地と方書(送付先住所
                        .concat(送付先番地.getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(送付先方書.getColumnValue()));
            }
            csvEntity.set送付先住所(送付先住所 != null
                    ? 送付先住所 : RString.EMPTY);
            csvEntity.set送付先番地(送付先番地 != null
                    ? 送付先番地.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先方書(送付先方書 != null
                    ? 送付先方書.getColumnValue() : RString.EMPTY);
        }
    }

    private void set被保険者台帳管理(HanyoListKogakuGassanJikoFutangakuEntity entity,
            HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {

        csvEntity.set市町村コード(entity.get市町村コード() != null
                ? entity.get市町村コード().getColumnValue() : RString.EMPTY);
        if (構成市町村Map.get(entity.get市町村コード()) != null) {
            csvEntity.set市町村名(構成市町村Map.get(entity.get市町村コード()).get市町村名称());
        }
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().getColumnValue());
        csvEntity.set保険者名(地方公共団体.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get被保険者番号() != null
                ? entity.get被保険者番号().getColumnValue() : RString.EMPTY);
        RString 資格取得事由 = RString.EMPTY;
        if (entity.get資格取得事由コード() != null && !entity.get資格取得事由コード().isEmpty()) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格取得事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.get資格取得年月日()));
        csvEntity.set資格取得届出日(dataToRString(entity.get資格取得届出年月日()));
        RString 資格喪失事由 = RString.EMPTY;
        if (entity.get資格喪失事由コード() != null && !entity.get資格喪失事由コード().isEmpty()) {
            資格喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格喪失事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(資格喪失事由);
        csvEntity.set資格喪失日(dataToRString(entity.get資格喪失年月日()));
        csvEntity.set資格喪失届日(dataToRString(entity.get資格喪失届出年月日()));
        if (entity.get被保険者区分コード() != null && !entity.get被保険者区分コード().isEmpty()) {
            HihokenshaKubunCode 被保険者区分コード = HihokenshaKubunCode.toValue(entity.get被保険者区分コード());
            csvEntity.set資格区分(被保険者区分コード != null ? 被保険者区分コード.get名称() : RString.EMPTY);
        }
        csvEntity.set住所地特例状態(entity.is住所地特例フラグ() ? 住特_表示 : RString.EMPTY);
        csvEntity.set受給申請事由(get受給申請事由(entity));
        csvEntity.set受給申請日(dataToRString(entity.get受給申請年月日()));
        if (!RString.isNullOrEmpty(entity.get要介護認定状態区分コード())) {
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(システム日付, entity.get要介護認定状態区分コード()).getName());
        }
        csvEntity.set受給認定開始日(dataToRString(entity.get認定有効期間開始年月日()));
        csvEntity.set受給認定終了日(dataToRString(entity.get認定有効期間終了年月日()));
        csvEntity.set受給認定日(dataToRString(entity.get認定年月日()));
        if (entity.is旧措置者フラグ()) {
            csvEntity.set受給旧措置(旧措置者_表示);
        } else {
            csvEntity.set受給旧措置(RString.EMPTY);
        }
        csvEntity.set受給みなし更新認定(get受給みなし更新認定(entity.getみなし要介護区分コード()));
        if (entity.get直近異動事由コード() != null) {
            csvEntity.set受給直近事由(get受給直近事由(entity.get直近異動事由コード()));
        }
        csvEntity.set対象年度(entity.get対象年度());
        csvEntity.set保険者番号(entity.get保険者番号());
        csvEntity.set支給申請書整理番号(entity.get支給申請書整理番号());
        csvEntity.set履歴番号(entity.get履歴番号());
        if (entity.get所得区分() != null) {
            csvEntity.set所得区分(KaigoGassan_ShotokuKbn.toValue(entity.get所得区分()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.get所得区分_70歳以上())) {
            csvEntity.set所得区分_70歳以上(
                    KaigoGassan_Over70_ShotokuKbn.toValue(entity.get所得区分_70歳以上()).get名称());
        }

        csvEntity.set自己負担額証明書整理番号(entity.get自己負担額証明書整理番号());
        if (!RString.isNullOrEmpty(entity.get異動区分())) {
            csvEntity.set異動区分(KaigoGassan_Idokubun.toValue(entity.get異動区分()).get名称());
        }
        if (!RString.isNullOrEmpty(entity.get補正済自己負担額送付区分())) {
            csvEntity.set補正済自己負担額送付区分(
                    Kaigogassan_HoseizumiJikofutangakuSofuKubun.toValue(entity.get補正済自己負担額送付区分()).get名称());
        }

        csvEntity.set対象計算期間_開始(dataToRString(entity.get対象計算期間開始年月日()));
        csvEntity.set対象計算期間_終了(dataToRString(entity.get対象計算期間終了年月日()));
        csvEntity.set被保険者期間_開始(dataToRString(entity.get被保険者期間開始年月日()));
        csvEntity.set被保険者期間_終了(dataToRString(entity.get被保険者期間終了年月日()));
        csvEntity.set申請年月日(dataToRString(entity.get申請年月日()));
        set高額合算自己負担額明細(entity, csvEntity);
    }

    private void set高額合算自己負担額明細(HanyoListKogakuGassanJikoFutangakuEntity entity,
            HanyoListKogakuGassanJikoFutangakuCsvEntity csvEntity) {
        csvEntity.set当０４_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細004_自己負担額()));
        csvEntity.set当０４_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細004_70_74自己負担額_内数()));
        csvEntity.set当０４_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細004_70_74高額支給額()));
        csvEntity.set当０５_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細005_自己負担額()));
        csvEntity.set当０５_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細005_70_74自己負担額_内数()));
        csvEntity.set当０５_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細005_70_74高額支給額()));
        csvEntity.set当０６_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細006_自己負担額()));
        csvEntity.set当０６_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細006_70_74自己負担額_内数()));
        csvEntity.set当０６_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細006_70_74高額支給額()));
        csvEntity.set当０７_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細007_自己負担額()));
        csvEntity.set当０７_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細007_70_74自己負担額_内数()));
        csvEntity.set当０７_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細007_70_74高額支給額()));
        csvEntity.set当０８_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細008_自己負担額()));
        csvEntity.set当０８_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細008_70_74自己負担額_内数()));
        csvEntity.set当０８_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細008_70_74高額支給額()));
        csvEntity.set当０９_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細009_自己負担額()));
        csvEntity.set当０９_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細009_70_74自己負担額_内数()));
        csvEntity.set当０９_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細009_70_74高額支給額()));
        csvEntity.set当１０_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細010_自己負担額()));
        csvEntity.set当１０_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細010_70_74自己負担額_内数()));
        csvEntity.set当１０_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細010_70_74高額支給額()));
        csvEntity.set当１１_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細011_自己負担額()));
        csvEntity.set当１１_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細011_70_74自己負担額_内数()));
        csvEntity.set当１１_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細011_70_74高額支給額()));
        csvEntity.set当１２_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細012_自己負担額()));
        csvEntity.set当１２_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細012_70_74自己負担額_内数()));
        csvEntity.set当１２_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細012_70_74高額支給額()));
        csvEntity.set翌０１_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細101_自己負担額()));
        csvEntity.set翌０１_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細101_70_74自己負担額_内数()));
        csvEntity.set翌０１_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細101_70_74高額支給額()));
        csvEntity.set翌０２_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細102_自己負担額()));
        csvEntity.set翌０２_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細102_70_74自己負担額_内数()));
        csvEntity.set翌０２_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細102_70_74高額支給額()));
        csvEntity.set翌０３_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細103_自己負担額()));
        csvEntity.set翌０３_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細103_70_74自己負担額_内数()));
        csvEntity.set翌０３_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細103_70_74高額支給額()));
        csvEntity.set翌０４_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細104_自己負担額()));
        csvEntity.set翌０４_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細104_70_74自己負担額_内数()));
        csvEntity.set翌０４_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細104_70_74高額支給額()));
        csvEntity.set翌０５_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細105_自己負担額()));
        csvEntity.set翌０５_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細105_70_74自己負担額_内数()));
        csvEntity.set翌０５_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細105_70_74高額支給額()));
        csvEntity.set翌０６_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細106_自己負担額()));
        csvEntity.set翌０６_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細106_70_74自己負担額_内数()));
        csvEntity.set翌０６_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細106_70_74高額支給額()));
        csvEntity.set翌０７_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細107_自己負担額()));
        csvEntity.set翌０７_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細107_70_74自己負担額_内数()));
        csvEntity.set翌０７_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細107_70_74高額支給額()));
        if (entity.get高額合算自己負担額_合計_自己負担額() != null) {
            csvEntity.set合計_自己負担額(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_合計_自己負担額(), 0));
        }
        if (entity.get高額合算自己負担額_合計_70_74自己負担額_内訳() != null) {
            csvEntity.set合計_７０_７４(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_合計_70_74自己負担額_内訳(), 0));
        }
        if (entity.get高額合算自己負担額_合計_70_74高額支給額() != null) {
            csvEntity.set合計_高額支給額(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_合計_70_74高額支給額(), 0));
        }
        csvEntity.set補当０４_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細004_補正済_自己負担額()));
        csvEntity.set補当０４_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細004_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０４_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細004_補正済_70_74高額支給額()));
        csvEntity.set補当０５_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細005_補正済_自己負担額()));
        csvEntity.set補当０５_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細005_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０５_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細005_補正済_70_74高額支給額()));
        csvEntity.set補当０６_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細006_補正済_自己負担額()));
        csvEntity.set補当０６_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細006_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０６_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細006_補正済_70_74高額支給額()));
        csvEntity.set補当０７_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細007_補正済_自己負担額()));
        csvEntity.set補当０７_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細007_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０７_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細007_補正済_70_74高額支給額()));
        csvEntity.set補当０８_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細008_補正済_自己負担額()));
        csvEntity.set補当０８_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細008_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０８_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細008_補正済_70_74高額支給額()));
        csvEntity.set補当０９_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細009_補正済_自己負担額()));
        csvEntity.set補当０９_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細009_補正済_70_74自己負担額_内数()));
        csvEntity.set補当０９_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細009_補正済_70_74高額支給額()));
        csvEntity.set補当１０_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細010_補正済_自己負担額()));
        csvEntity.set補当１０_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細010_補正済_70_74自己負担額_内数()));
        csvEntity.set補当１０_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細010_補正済_70_74高額支給額()));
        csvEntity.set補当１１_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細011_補正済_自己負担額()));
        csvEntity.set補当１１_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細011_補正済_70_74自己負担額_内数()));
        csvEntity.set補当１１_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細011_補正済_70_74高額支給額()));
        csvEntity.set補当１２_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細012_補正済_自己負担額()));
        csvEntity.set補当１２_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細012_補正済_70_74自己負担額_内数()));
        csvEntity.set補当１２_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細012_補正済_70_74高額支給額()));
        csvEntity.set補翌０１_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細101_補正済_自己負担額()));
        csvEntity.set補翌０１_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細101_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０１_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細101_補正済_70_74高額支給額()));
        csvEntity.set補翌０２_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細102_補正済_自己負担額()));
        csvEntity.set補翌０２_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細102_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０２_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細102_補正済_70_74高額支給額()));
        csvEntity.set補翌０３_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細103_補正済_自己負担額()));
        csvEntity.set補翌０３_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細103_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０３_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細103_補正済_70_74高額支給額()));
        csvEntity.set補翌０４_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細104_補正済_自己負担額()));
        csvEntity.set補翌０４_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細104_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０４_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細104_補正済_70_74高額支給額()));
        csvEntity.set補翌０５_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細105_補正済_自己負担額()));
        csvEntity.set補翌０５_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細105_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０５_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細105_補正済_70_74高額支給額()));
        csvEntity.set補翌０６_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細106_補正済_自己負担額()));
        csvEntity.set補翌０６_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細106_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０６_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細106_補正済_70_74高額支給額()));
        csvEntity.set補翌０７_自己負担額(doカンマ編集(entity.get高額合算自己負担額明細107_補正済_自己負担額()));
        csvEntity.set補翌０７_７０_７４(doカンマ編集(entity.get高額合算自己負担額明細107_補正済_70_74自己負担額_内数()));
        csvEntity.set補翌０７_高額支給額(doカンマ編集(entity.get高額合算自己負担額明細107_補正済_70_74高額支給額()));
        if (entity.get高額合算自己負担額_補正済_合計_自己負担額() != null) {
            csvEntity.set補合計_自己負担額(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_補正済_合計_自己負担額(), 0));
        }
        if (entity.get高額合算自己負担額_補正済_合計_70_74自己負担額_内訳() != null) {
            csvEntity.set補合計_７０_７４(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_補正済_合計_70_74自己負担額_内訳(), 0));
        }
        if (entity.get高額合算自己負担額_補正済_合計_70_74高額支給額() != null) {
            csvEntity.set補合計_高額支給額(DecimalFormatter.toコンマ区切りRString(entity.get高額合算自己負担額_補正済_合計_70_74高額支給額(), 0));
        }
        if (!RString.isNullOrEmpty(entity.get高額合算自己負担額_データ作成区分())) {
            csvEntity.setデータ作成区分(Kaigogassan_DataSakuseiKubun.toValue(entity.get高額合算自己負担額_データ作成区分()).get名称());
        }
        csvEntity.set自己負担額確認情報受取年月(monthToRString(entity.get高額合算自己負担額_自己負担額確認情報受取年月()));
        csvEntity.set補正済自己負担額情報送付年月(monthToRString(entity.get高額合算自己負担額_補正済自己負担額情報送付年月()));
        csvEntity.set自己負担額証明書情報受取年月(monthToRString(entity.get高額合算自己負担額_自己負担額証明書情報受取年月()));
        if (!RString.isNullOrEmpty(entity.get高額合算自己負担額_送付対象外フラグ())) {
            csvEntity.set送付対象外フラグ(Kaigogassan_SofuTaishogaiKubun.toValue(entity.get高額合算自己負担額_送付対象外フラグ()).get名称());
        }
        csvEntity.set自己負担額計算年月日(dataToRString(entity.get高額合算自己負担額_自己負担額計算年月日()));
        csvEntity.set自己負担額証明書作成年月日(dataToRString(entity.get高額合算自己負担額_自己負担額証明書作成年月日()));
        csvEntity.setバッチ補正実施年月日(dataToRString(entity.get高額合算自己負担額_バッチ補正実施年月日()));
        csvEntity.setリアル補正実施年月日(dataToRString(entity.get高額合算自己負担額_リアル補正実施年月日()));
    }

    private static RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString get受給みなし更新認定(RString みなし要介護区分コード) {
        RString 受給みなし更新認定 = RString.EMPTY;
        if (!MinashiCode.通常の認定.getコード().equals(みなし要介護区分コード)) {
            受給みなし更新認定 = みなし_表示;
        }
        return 受給みなし更新認定;
    }

    private RString get受給直近事由(RString 直近異動事由コード) {
        if (直近異動事由コード00.equals(直近異動事由コード)) {
            return 直近異動事由コード名称00;
        } else if (直近異動事由コード01.equals(直近異動事由コード)) {
            return 直近異動事由コード名称01;
        } else if (直近異動事由コード02.equals(直近異動事由コード)) {
            return 直近異動事由コード名称02;
        } else if (直近異動事由コード03.equals(直近異動事由コード)) {
            return 直近異動事由コード名称03;
        } else if (直近異動事由コード04.equals(直近異動事由コード)) {
            return 直近異動事由コード名称04;
        } else if (直近異動事由コード05.equals(直近異動事由コード)) {
            return 直近異動事由コード名称05;
        } else if (直近異動事由コード06.equals(直近異動事由コード)) {
            return 直近異動事由コード名称06;
        } else if (直近異動事由コード07.equals(直近異動事由コード)) {
            return 直近異動事由コード名称07;
        } else if (直近異動事由コード08.equals(直近異動事由コード)) {
            return 直近異動事由コード名称08;
        } else if (直近異動事由コード09.equals(直近異動事由コード)) {
            return 直近異動事由コード名称09;
        } else if (直近異動事由コード10.equals(直近異動事由コード)) {
            return 直近異動事由コード名称10;
        } else if (直近異動事由コード11.equals(直近異動事由コード)) {
            return 直近異動事由コード名称11;
        } else if (直近異動事由コード12.equals(直近異動事由コード)) {
            return 直近異動事由コード名称12;
        } else if (直近異動事由コード20.equals(直近異動事由コード)) {
            return 直近異動事由コード名称20;
        }
        return RString.EMPTY;
    }

    private RString get受給申請事由(HanyoListKogakuGassanJikoFutangakuEntity entity) {
        RString 受給申請事由コード = RString.EMPTY;
        if (entity.get受給申請事由() != null) {
            受給申請事由コード = entity.get受給申請事由();
        }
        return getJukyuShinseiJiyu(受給申請事由コード, entity.get要支援者認定申請区分());
    }

    private RString getJukyuShinseiJiyu(RString 受給申請事由コード, RString 要支援者認定申請区分) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由コード)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(要支援者認定申請区分)) {
                return 受給申請事由_支援から申請;
            } else {
                return 受給申請事由_区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_追加;
        }
        return RString.EMPTY;
    }

    private RString dataToRString(FlexibleDate 日付) {
        RString temp = getパターン32(日付);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
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

    private RString monthToRString(FlexibleYearMonth 日付) {
        RString temp = getパターン32(日付);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));

        List<RString> 出力条件 = get出力条件();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                RString.EMPTY,
                日本語ファイル名,
                出力件数,
                出力有無,
                出力ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        出力条件.add(builder.toRString());
        builder = get保険者コード();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get抽出区分();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = getデータ作成区分();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = getデータ種類();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get補正状況();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get対象年度();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get申請年月日();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get支給申請書整理番号();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get自己負担額確認情報受取年月();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get補正済自己負担額情報送付年月();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get自己負担額証明書情報受取年月();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }

        return 出力条件;
    }

    private RStringBuilder get保険者コード() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(保険者);
        if (!RString.isNullOrEmpty(parameter.get保険者コード()) && !すべて.equals(parameter.get保険者コード())) {
            Association 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation(
                    new LasdecCode(parameter.get保険者コード()));
            return builder.append(地方公共団体コード.get市町村名());
        }
        return null;
    }

    private RStringBuilder get抽出区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出区分);
        boolean flag = false;
        if (!RString.isNullOrEmpty(parameter.get抽出区分())) {
            flag = true;
            builder.append(Kaigogassan_ChushutsuKubun.toValue(parameter.get抽出区分()).get名称());
            if (parameter.is送付対象外()) {
                builder.append(左記号).append(送付対象外データを含める).append(右記号);
            }
        } else {
            if (parameter.is送付対象外()) {
                flag = true;
                builder.append(すべて).append(左記号).append(送付対象外データを含める).append(右記号);
            }
        }
        if (flag) {
            return builder;
        } else {
            return null;
        }
    }

    private RStringBuilder getデータ作成区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(データ作成区分);
        if (!RString.isNullOrEmpty(parameter.getデータ作成区分())) {
            return builder.append(Kaigogassan_DataSakuseiKubun.toValue(parameter.getデータ作成区分()).get名称());
        }
        return null;
    }

    private RStringBuilder getデータ種類() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(データ種類);
        if (!RString.isNullOrEmpty(parameter.getデータ種類())) {
            return builder.append(Kaigogassan_DataShubetsu.toValue(parameter.getデータ種類()).get名称());
        }
        return null;
    }

    private RStringBuilder get補正状況() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(補正状況);
        if (!RString.isNullOrEmpty(parameter.get補正状況())) {
            return builder.append(Kaigogassan_HoseiJokyo.toValue(parameter.get補正状況()).get名称());
        }
        return null;
    }

    private RStringBuilder get対象年度() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年度);
        if (!RString.isNullOrEmpty(parameter.get対象年度())) {
            return builder.append(DateConverter.getWarekiYear(new RYear(parameter.get対象年度().toString())));
        }
        return null;
    }

    private RStringBuilder get申請年月日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(申請年月日);
        RString serviceYmFrom = get年月日(parameter.get申請年月日From());
        RString serviceYmTo = get年月日(parameter.get申請年月日To());
        if (RString.isNullOrEmpty(serviceYmFrom) && RString.isNullOrEmpty(serviceYmTo)) {
            return null;
        }
        if (!RString.isNullOrEmpty(serviceYmFrom) && !RString.isNullOrEmpty(serviceYmTo)) {
            return builder.append(serviceYmFrom).append(波線).append(serviceYmTo);
        } else if (!RString.isNullOrEmpty(serviceYmFrom)) {
            return builder.append(serviceYmFrom).append(波線);
        } else if (!RString.isNullOrEmpty(serviceYmTo)) {
            return builder.append(波線).append(serviceYmTo);
        }
        return null;
    }

    private RStringBuilder get支給申請書整理番号() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(支給申請書整理番号);
        RString 支給申請書整理番号From = parameter.get支給申請書整理番号From();
        RString 支給申請書整理番号To = parameter.get支給申請書整理番号To();
        if (RString.isNullOrEmpty(支給申請書整理番号From) && RString.isNullOrEmpty(支給申請書整理番号To)) {
            return null;
        }
        if (!RString.isNullOrEmpty(支給申請書整理番号From) && !RString.isNullOrEmpty(支給申請書整理番号To)) {
            return builder.append(支給申請書整理番号From).append(波線).append(支給申請書整理番号To);
        } else if (!RString.isNullOrEmpty(支給申請書整理番号From)) {
            return builder.append(支給申請書整理番号From).append(波線);
        } else if (!RString.isNullOrEmpty(支給申請書整理番号To)) {
            return builder.append(波線).append(支給申請書整理番号To);
        }
        return null;
    }

    private RStringBuilder get自己負担額確認情報受取年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(自己負担額確認情報受取年月);
        RString 自己負担額確認情報受取年月From = get提供年月(parameter.get自己負担額確認情報受取年月From());
        RString 自己負担額確認情報受取年月To = get提供年月(parameter.get自己負担額確認情報受取年月To());
        if (RString.isNullOrEmpty(自己負担額確認情報受取年月From) && RString.isNullOrEmpty(自己負担額確認情報受取年月To)) {
            return null;
        }
        if (!RString.isNullOrEmpty(自己負担額確認情報受取年月From) && !RString.isNullOrEmpty(自己負担額確認情報受取年月To)) {
            return builder.append(自己負担額確認情報受取年月From).append(波線).append(自己負担額確認情報受取年月To);
        } else if (!RString.isNullOrEmpty(自己負担額確認情報受取年月From)) {
            return builder.append(自己負担額確認情報受取年月From).append(波線);
        } else if (!RString.isNullOrEmpty(自己負担額確認情報受取年月To)) {
            return builder.append(波線).append(自己負担額確認情報受取年月To);
        }
        return null;
    }

    private RStringBuilder get補正済自己負担額情報送付年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(補正済自己負担額情報送付年月);
        RString 補正済自己負担額情報送付年月From = get提供年月(parameter.get補正済自己負担額情報送付年月From());
        RString 補正済自己負担額情報送付年月To = get提供年月(parameter.get補正済自己負担額情報送付年月To());
        if (RString.isNullOrEmpty(補正済自己負担額情報送付年月From) && RString.isNullOrEmpty(補正済自己負担額情報送付年月To)) {
            return null;
        }
        if (!RString.isNullOrEmpty(補正済自己負担額情報送付年月From) && !RString.isNullOrEmpty(補正済自己負担額情報送付年月To)) {
            return builder.append(補正済自己負担額情報送付年月From).append(波線).append(補正済自己負担額情報送付年月To);
        } else if (!RString.isNullOrEmpty(補正済自己負担額情報送付年月From)) {
            return builder.append(補正済自己負担額情報送付年月From).append(波線);
        } else if (!RString.isNullOrEmpty(補正済自己負担額情報送付年月To)) {
            return builder.append(波線).append(補正済自己負担額情報送付年月To);
        }
        return null;
    }

    private RStringBuilder get自己負担額証明書情報受取年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(自己負担額証明書情報受取年月);
        RString 自己負担額証明書情報受取年月From = get提供年月(parameter.get自己負担額証明書情報受取年月From());
        RString 自己負担額証明書情報受取年月To = get提供年月(parameter.get自己負担額証明書情報受取年月To());
        if (RString.isNullOrEmpty(自己負担額証明書情報受取年月From) && RString.isNullOrEmpty(自己負担額証明書情報受取年月To)) {
            return null;
        }
        if (!RString.isNullOrEmpty(自己負担額証明書情報受取年月From) && !RString.isNullOrEmpty(自己負担額証明書情報受取年月To)) {
            return builder.append(自己負担額証明書情報受取年月From).append(波線).append(自己負担額証明書情報受取年月To);
        } else if (!RString.isNullOrEmpty(自己負担額証明書情報受取年月From)) {
            return builder.append(自己負担額証明書情報受取年月From).append(波線);
        } else if (!RString.isNullOrEmpty(自己負担額証明書情報受取年月To)) {
            return builder.append(波線).append(自己負担額証明書情報受取年月To);
        }
        return null;
    }

    private RString get提供年月(FlexibleYearMonth サービス提供年月) {

        if (サービス提供年月 == null || サービス提供年月.isEmpty()) {
            return RString.EMPTY;
        }
        return サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString get年月日(FlexibleDate 年月日) {

        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(HanyoListKogakuGassanJikoFutangakuOutPutOrder.class, order);
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
