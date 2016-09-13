/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.shokanbaraikyufu.ShikyuFushikyuKubun;
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
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.maskedkoza.MaskedKozaCreator;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト出力(高額合算支給額決定情報)Processクラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
public class HanyoListKogakuGassanShikyugakuKetteiProcess
        extends BatchProcessBase<HanyoListKogakuGassanShikyugakuKetteiEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
                    + "hanyolistkogakugassanshikyugakukettei.IHanyoListKogakuGassanShikyugakuKetteiMapper.getCSVData");
    private FlexibleDate システム日付;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private List<KoseiShichosonMaster> 構成市町村マスタ;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701017");
    private HanyoListKogakuGassanShikyugakuKetteiProcessParameter parameter;
    private RString hanyoListKogakuFilePath;
    @BatchWriter
    private CsvWriter<HanyoListKogakuGassanShikyugakuKetteiCSVEntity> hanyoListKogakuCSVWriter;
    private static final RString コンマ = new RString(",");
    private static final RString 出力ファイル名
            = new RString("HanyoList_KogakuGassanShikyugakuKettei.csv");
    private static final RString ダブル引用符 = new RString("\"");
    // TODO
    // private IOutputOrder 並び順;
    private Decimal 連番;
    private final int 定値INT_0 = 0;
    private final int 定値INT_10 = 10;
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
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額合算支給額決定情報CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KogakuGassanShikyugakuKettei.csv");
    private RString 出力有無;
    private static final RString あり = new RString("あり");
    private static final RString なし = new RString("なし");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 支給区分 = new RString("支給区分：");
    private static final RString 支払方法区分 = new RString("支払方法区分：");
    private static final RString 金融機関コード = new RString("金融機関コード ：");
    private static final RString 対象年度 = new RString("対象年度：");
    private static final RString 決定情報受取年月 = new RString("決定情報受取年月：");
    private static final RString すべて = new RString("すべて");
    private static final RString 波線 = new RString("～");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final RString 斜線 = new RString("/");
    private static final RString 年度作成 = new RString("年度");

    @Override
    protected void initialize() {
        super.initialize();
        出力有無 = なし;
        連番 = Decimal.ZERO;
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
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBD介護受給);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey searchKey = builder.build();
        parameter.setSearchkey(searchKey);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(parameter.getReamsLoginId());
        parameter.setList(list);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        hanyoListKogakuFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        hanyoListKogakuCSVWriter = BatchWriters.csvWriter(HanyoListKogakuGassanShikyugakuKetteiCSVEntity.class).
                filePath(hanyoListKogakuFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.is項目名付加()).
                build();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(HanyoListKogakuGassanShikyugakuKetteiEntity entity) {
        出力有無 = あり;
        連番 = 連番.add(Decimal.ONE);
        HanyoListKogakuGassanShikyugakuKetteiCSVEntity output;
        output = get帳票のCSVファイル作成(entity);
        hanyoListKogakuCSVWriter.writeLine(output);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        hanyoListKogakuCSVWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, hanyoListKogakuFilePath, accessLog);
        } else {
            manager.spool(hanyoListKogakuFilePath);
        }
        バッチ出力条件リストの出力();
    }

    private HanyoListKogakuGassanShikyugakuKetteiCSVEntity
            get帳票のCSVファイル作成(HanyoListKogakuGassanShikyugakuKetteiEntity entity) {
        HanyoListKogakuGassanShikyugakuKetteiCSVEntity output = new HanyoListKogakuGassanShikyugakuKetteiCSVEntity();
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
        set高額合算支給不支給決定(entity, output);
        set口座情報(entity, output);
        return output;
    }

    private void set宛名1(IKojin kojin,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
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
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
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

    private void set最新被保台帳(HanyoListKogakuGassanShikyugakuKetteiEntity entity,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
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
        output.set保険者名(getColumnValue(最新被保台帳.getHihokenshaNo()));
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

    private void set受給者台帳(HanyoListKogakuGassanShikyugakuKetteiEntity entity,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
        DbT4001JukyushaDaichoEntity 受給者台帳 = entity.get受給者台帳();
        if (受給者台帳 == null) {
            return;
        }
        output.set受給申請事由(get受給申請事由(受給者台帳));
        output.set受給申請日(get日付項目(受給者台帳.getJukyuShinseiYMD()));
        IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(
                システム日付, getColumnValue(受給者台帳.getYokaigoJotaiKubunCode()));
        output.set受給要介護度(要介護状態区分 != null ? 要介護状態区分.getName() : RString.EMPTY);
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

    private void set高額合算支給不支給決定(HanyoListKogakuGassanShikyugakuKetteiEntity entity,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
        DbT3074KogakuGassanShikyuFushikyuKetteiEntity 高額合算支給不支給決定 = entity.get高額合算支給不支給決定();
        if (高額合算支給不支給決定 == null) {
            return;
        }
        output.set対象年度(get対象年度(高額合算支給不支給決定.getTaishoNendo()));
        output.set保険者番号(getColumnValue(高額合算支給不支給決定.getHokenshaNo()));
        output.set連絡票整理番号(高額合算支給不支給決定.getShikyuSeiriNo());
        output.set履歴番号(new RString(高額合算支給不支給決定.getRirekiNo()));
        output.set自己負担額証明書整理番号(高額合算支給不支給決定.getJikoFutanSeiriNo());
        output.set対象計算期間_開始(get日付項目(高額合算支給不支給決定.getKeisanKaishiYMD()));
        output.set対象計算期間_終了(get日付項目(高額合算支給不支給決定.getKeisanShuryoYMD()));
        output.set申請年月日(get日付項目(高額合算支給不支給決定.getShinseiYMD()));
        output.set決定年月日(get日付項目(高額合算支給不支給決定.getKetteiYMD()));
        output.set自己負担総額(doカンマ編集(高額合算支給不支給決定.getJikoFutanSogaku()));
        if (!RString.isNullOrEmpty(高額合算支給不支給決定.getShikyuKubunCode())) {
            ShikyuFushikyuKubun 支給区分コード = ShikyuFushikyuKubun.toValue(高額合算支給不支給決定.getShikyuKubunCode());
            output.set支給区分コード(支給区分コード != null ? 支給区分コード.get名称() : RString.EMPTY);
        }
        output.set支給額(doカンマ編集(高額合算支給不支給決定.getShikyugaku()));
        output.set給付の種類(高額合算支給不支給決定.getKyufuShurui());
        output.set不支給理由(高額合算支給不支給決定.getFushikyuRiyu());
        output.set支払方法区分(高額合算支給不支給決定.getShiharaiHohoKubun());
        output.set支払場所(高額合算支給不支給決定.getShiharaiBasho());
        output.set支払期間開始年月日(get日付項目(高額合算支給不支給決定.getShiharaiKaishiYMD()));
        output.set支払期間終了年月日(get日付項目(高額合算支給不支給決定.getShiharaiShuryoYMD()));
        output.set支払期間開始年月日_時間(高額合算支給不支給決定.getShiharaiKaishiTime());
        output.set支払期間終了年月日_時間(高額合算支給不支給決定.getShiharaiShuryoTime());
        output.set決定通知書作成年月日(get日付項目(高額合算支給不支給決定.getKetteiTsuchiSakuseiYMD()));
        output.set振込通知書作成年月日(get日付項目(高額合算支給不支給決定.getFurikomiTsuchiSakuseiYMD()));
        output.set受取年月(get日付項目(高額合算支給不支給決定.getUketoriYM()));
        output.set給付の種類_短(get先頭10文字(高額合算支給不支給決定.getKyufuShurui()));
        output.set不支給理由_短(get先頭10文字(高額合算支給不支給決定.getFushikyuRiyu()));
        output.set支払場所_短(get先頭10文字(高額合算支給不支給決定.getShiharaiBasho()));
    }

    private void set宛先(IAtesaki atesaki,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
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

    private void set口座情報(HanyoListKogakuGassanShikyugakuKetteiEntity entity,
            HanyoListKogakuGassanShikyugakuKetteiCSVEntity output) {
        KozaRelateEntity 口座情報 = entity.get口座情報();
        if (口座情報 == null) {
            return;
        }
        IKoza iKoza = null;
        if (口座情報.getUaT0310KozaEntity().getKozaId() != 0L) {
            MaskedKozaCreator maskedKozaCreator = MaskedKozaCreator.createInstance(SubGyomuCode.DBC介護給付);
            iKoza = maskedKozaCreator.createマスク編集済口座(new Koza(口座情報));
        }
        if (iKoza == null) {
            return;
        }
        output.set金融機関コード(getColumnValue(iKoza.get金融機関コード()));
        if (iKoza.get金融機関() != null) {
            output.set金融機関名(iKoza.get金融機関().get金融機関名称());
        }
        output.set金融機関支店コード(get金融機関支店コード(iKoza));
        output.set金融機関支店名(get金融機関支店名(iKoza));
        if (iKoza.get預金種別() != null) {
            output.set口座種目名(iKoza.get預金種別().get預金種別名称());
        }
        output.set口座番号(iKoza.get口座番号());
        output.set口座名義人_カナ(getColumnValue(iKoza.get口座名義人()));

    }

    private RString get金融機関支店コード(IKoza iKoza) {
        RString 金融機関支店コード;
        if (iKoza.isゆうちょ銀行()) {
            金融機関支店コード = iKoza.get店番();
        } else {
            金融機関支店コード = iKoza.get支店コード().value();
        }
        return 金融機関支店コード;
    }

    private RString get金融機関支店名(IKoza iKoza) {
        RString 金融機関支店名;
        if (iKoza.isゆうちょ銀行()) {
            金融機関支店名 = RString.EMPTY;
        } else {
            金融機関支店名 = iKoza.get支店(FlexibleDate.getNowDate()).get支店名称();
        }
        return 金融機関支店名;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString get先頭10文字(RString 文字) {
        if (null == 文字) {
            return RString.EMPTY;
        }
        RString 文字_短;
        if (定値INT_10 < 文字.length()) {
            文字_短 = 文字.substringReturnAsPossible(定値INT_0, 定値INT_10);
        } else {
            文字_短 = 文字.substringReturnAsPossible(定値INT_0, 文字.length());
        }
        return 文字_短;
    }

    private RString get対象年度(FlexibleYear 対象年度) {
        if (null == 対象年度) {
            return RString.EMPTY;
        }
        return 対象年度.toDateString();
    }

//    TODO QA#
//    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {
//        if (RString.isNullOrEmpty(出力順ID)) {
//            return null;
//        }
//        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
//        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
//        return outputOrder;
//    }
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

    private PersonalData toPersonalData(HanyoListKogakuGassanShikyugakuKetteiEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 被保険者番号,
                entity.get高額合算支給不支給決定().getHihokenshaNo().value());
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
                出力条件
        );
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
        builder = get支給区分();
        get出力条件(出力条件, builder);
        builder = get支払方法区分();
        get出力条件(出力条件, builder);
        builder = get金融機関コード();
        get出力条件(出力条件, builder);
        builder = get対象年度();
        get出力条件(出力条件, builder);
        builder = get決定情報受取年月();
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

    private RStringBuilder get支給区分() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.get支給区分())) {
            return null;
        }
        builder.append(支給区分);
        ShikyuFushikyuKubun 支給区分名称 = ShikyuFushikyuKubun.toValue(parameter.get支給区分());
        builder.append(支給区分名称 != null ? 支給区分名称.get名称() : RString.EMPTY);
        return builder;
    }

    private RStringBuilder get支払方法区分() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.get支払方法区分())) {
            return null;
        }
        builder.append(支払方法区分);
        ShiharaiHohoKubun 支払方法区分名称 = ShiharaiHohoKubun.toValue(parameter.get支払方法区分());
        builder.append(支払方法区分名称 != null ? 支払方法区分名称.get名称() : RString.EMPTY);
        return builder;
    }

    private RStringBuilder get金融機関コード() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.get金融機関コード() == null || parameter.get金融機関コード().isEmpty()) {
            return null;
        }
        builder.append(金融機関コード);
        builder.append(左記号).append(getColumnValue(parameter.get金融機関コード())).append(右記号);
        return builder;
    }

    private RStringBuilder get対象年度() {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(parameter.get対象年度())) {
            return null;
        }
        builder.append(対象年度);
        builder.append(new FlexibleYear(parameter.get対象年度()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).toDateString().concat(年度作成));
        return builder;
    }

    private RStringBuilder get決定情報受取年月() {
        RStringBuilder builder = new RStringBuilder();
        boolean 決定情報受取年月FromFlag = false;
        boolean 決定情報受取年月ToFlag = false;
        if (parameter.get決定情報受取年月From() == null
                || parameter.get決定情報受取年月From().isEmpty()) {
            決定情報受取年月FromFlag = true;
        }
        if (parameter.get決定情報受取年月To() == null
                || parameter.get決定情報受取年月To().isEmpty()) {
            決定情報受取年月ToFlag = true;
        }
        if (決定情報受取年月FromFlag && 決定情報受取年月ToFlag) {
            return null;
        }
        builder.append(決定情報受取年月);
        if (決定情報受取年月ToFlag) {
            builder.append(dateFormat(parameter.get決定情報受取年月From()))
                    .append(RString.FULL_SPACE).append(波線);
        } else if (決定情報受取年月FromFlag) {
            builder.append(波線).append(RString.FULL_SPACE)
                    .append(parameter.get決定情報受取年月To().wareki().toDateString());
        } else {
            builder.append(dateFormat(parameter.get決定情報受取年月From()))
                    .append(RString.FULL_SPACE).append(波線).append(RString.FULL_SPACE)
                    .append(dateFormat(parameter.get決定情報受取年月To()));
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
}
