/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisthihokenshadaicho;

import jp.co.ndensan.reams.db.dba.business.core.hanyolisthihokenshadaicho.ShikakShutokuHanteiComparator;
import jp.co.ndensan.reams.db.dba.business.core.hanyolisthihokenshadaicho.ShikakShutokuHantei;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HaniChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HihokenshaJoho;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoMyBatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoCSVEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 汎用リスト_被保険者台帳_バッチ処理クラスです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
public class HanyoListHihokenshadaichoProcess extends BatchProcessBase<HanyoListHihokenshadaichoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisthihokenshadaicho"
            + ".IHanyoListHihokenshadaichoMapper.get汎用リスト被保険者台帳データの取得");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBA701001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_95 = 95;
    private static final RString 読点 = new RString("、");
    private static final RString コロン = new RString("：");
    private static final RString 日付抽出区分 = new RString("日付抽出区分");
    private static final RString 基準日区分 = new RString("基準日区分");
    private static final RString 基準日 = new RString("基準日");
    private static final RString 範囲抽出日区分 = new RString("範囲抽出日区分");
    private static final RString 範囲抽出日 = new RString("範囲抽出日");
    private static final RString 被保険者情報 = new RString("被保険者情報");
    private static final RString 資格抽出区分 = new RString("資格抽出区分");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区1 = new RString("地区1");
    private static final RString 地区2 = new RString("地区2");
    private static final RString 地区3 = new RString("地区3");
    private static final RString 保険者 = new RString("保険者");
    private HanyoListHihokenshadaichoProcessParameter processPrm;
    private HanyoListHihokenshadaichoMyBatisParameter mybatisPrm;
    private List<PersonalData> personalDataList;
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private int int_連番;
    private boolean hasCSVデータ;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村s;
    private IAssociation 地方公共団体;

    @Override
    protected void initialize() {
        構成市町村s = find構成市町村sAsMap();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        mybatisPrm = processPrm.toMyBatisParameter();
        personalDataList = new ArrayList<>();
        hasCSVデータ = false;
        //TODO システム日時は使用なし
        //RDateTime システム日時 = RDate.getNowDateTime();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("HanyoList_Hihokenshadaicho.csv"));
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilename, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(mybatisPrm.isKomukuFukaMeyi()).
                build();

    }

    private static Map<LasdecCode, KoseiShichosonMaster> find構成市町村sAsMap() {
        Map<LasdecCode, KoseiShichosonMaster> map = new HashMap<>();
        for (KoseiShichosonMaster ks : KoseiShichosonJohoFinder.createInstance().get現市町村情報()) {
            map.put(ks.get市町村コード(), ks);
        }
        return Collections.unmodifiableMap(map);
    }

    @BatchWriter
    private EucCsvWriter<HanyoListHihokenshadaichoCSVEntity> eucCsvWriterJunitoJugo;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> list = new ArrayList<>();
        List<RString> hiHokenshaJyoho = mybatisPrm.getHiHokenshaJyoho();
        boolean is日本人 = false;
        boolean is外国人 = false;
        for (RString code : hiHokenshaJyoho) {
            if (HihokenshaJoho.日本人.getコード().equals(code)) {
                is日本人 = true;
            }
            if (HihokenshaJoho.外国人.getコード().equals(code)) {
                is外国人 = true;
            }
        }
        if (is日本人) {
            list.add(JuminShubetsu.住登外個人_日本人);
            list.add(JuminShubetsu.日本人);
        }
        if (is外国人) {
            list.add(JuminShubetsu.住登外個人_外国人);
            list.add(JuminShubetsu.外国人);
        }
        if (is日本人 || is外国人) {
            key.set住民種別(list);
        }
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        HanyoListHihokenshadaichoMyBatisParameter myBatisParameter = HanyoListHihokenshadaichoMyBatisParameter.create_MybatisParameter(
                mybatisPrm.isKomukuFukaMeyi(), mybatisPrm.isRembanfuka(), mybatisPrm.isHidukeHensyu(), mybatisPrm.getHidukeTyuushutuKubun(),
                mybatisPrm.getKijunniKubun(), mybatisPrm.getKijunni(), mybatisPrm.isKijunNichijiJukyusha(), mybatisPrm.getRangeChushutsuhiKubun(),
                mybatisPrm.getRangeChushutsuhiFrom(), mybatisPrm.getRangeChushutsuhiTo(), mybatisPrm.getHiHokenshaJyoho(),
                mybatisPrm.getShikakuChushutsuKubun(), mybatisPrm.getShutokujiyu(), mybatisPrm.getSoshitsujiyu(),
                mybatisPrm.getPsmChushutsu_Kubun(), mybatisPrm.getPsmChushutsuAge_Start(), mybatisPrm.getPsmChushutsuAge_End(),
                mybatisPrm.getPsmSeinengappiYMD_Start(), mybatisPrm.getPsmSeinengappiYMD_End(), mybatisPrm.getPsmAgeKijunni(),
                mybatisPrm.getShichoson_Code(),
                mybatisPrm.getShichoson_Name(), mybatisPrm.getPsmChiku_Kubun(), mybatisPrm.getPsmJusho_From(), mybatisPrm.getPsmJusho_To(),
                mybatisPrm.getPsmGyoseiku_From(), mybatisPrm.getPsmGyoseiku_To(), mybatisPrm.getPsmChiku1_From(), mybatisPrm.getPsmChiku1_To(),
                mybatisPrm.getPsmChiku2_From(), mybatisPrm.getPsmChiku2_To(), mybatisPrm.getPsmChiku3_From(), mybatisPrm.getPsmChiku3_To(),
                mybatisPrm.getPsmJusho_From_Name(), mybatisPrm.getPsmJusho_To_Name(), mybatisPrm.getPsmGyoseiku_From_Name(),
                mybatisPrm.getPsmGyoseiku_To_Name(), mybatisPrm.getPsmChiku1_From_Name(), mybatisPrm.getPsmChiku1_To_Name(),
                mybatisPrm.getPsmChiku2_From_Name(), mybatisPrm.getPsmChiku2_To_Name(), mybatisPrm.getPsmChiku3_From_Name(),
                mybatisPrm.getPsmChiku3_To_Name(),
                new RString(uaFt200Psm.toString()),
                new RString(uaFt250Psm.toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, myBatisParameter);
    }

    @Override
    protected void process(HanyoListHihokenshadaichoRelateEntity t) {
        int_連番 = int_連番 + 1;
        HanyoListHihokenshadaichoCSVEntity entity = getCSVEntity(t, int_連番);
        eucCsvWriterJunitoJugo.writeLine(entity);
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.getHihokenshaNo());
        PersonalData personalData = PersonalData.of(t.getPsmEntity().getShikibetsuCode(), expandedInformations);
        personalDataList.add(personalData);
        hasCSVデータ = true;
    }

    @Override
    protected void afterExecute() {
        if (mybatisPrm.isKomukuFukaMeyi() && !hasCSVデータ) {
            eucCsvWriterJunitoJugo.writeLine(new HanyoListHihokenshadaichoCSVEntity(
                    RString.EMPTY, ShikibetsuCode.EMPTY, RString.EMPTY, AtenaMeisho.EMPTY, AtenaKanaMeisho.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, TsuzukigaraCode.EMPTY, SetaiCode.EMPTY, AtenaMeisho.EMPTY, ZenkokuJushoCode.EMPTY,
                    RString.EMPTY, RString.EMPTY, AtenaJusho.EMPTY, AtenaBanchi.EMPTY, Katagaki.EMPTY, GyoseikuCode.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, TelNo.EMPTY, TelNo.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, YubinNo.EMPTY, RString.EMPTY, AtenaJusho.EMPTY, AtenaBanchi.EMPTY, Katagaki.EMPTY,
                    LasdecCode.EMPTY, RString.EMPTY, LasdecCode.EMPTY, RString.EMPTY, RString.EMPTY, AtenaMeisho.EMPTY, AtenaKanaMeisho.EMPTY,
                    ZenkokuJushoCode.EMPTY, RString.EMPTY, RString.EMPTY, AtenaJusho.EMPTY, AtenaBanchi.EMPTY, Katagaki.EMPTY, GyoseikuCode.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY));
        }
        outputJokenhyoFactory();
        eucCsvWriterJunitoJugo.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilename, id);
    }

    private void outputJokenhyoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                地方公共団体.get地方公共団体コード().value(),
                地方公共団体.get市町村名(),
                new RString(String.valueOf(processPrm.getJobId())),
                new RString("汎用リスト 被保険者台帳CSV"),
                new RString("HanyoList_Hihokenshadaicho.csv"),
                new RString(String.valueOf(eucCsvWriterJunitoJugo.getCount())),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RString hidukeTyuushutuKubun = mybatisPrm.getHidukeTyuushutuKubun();
        RString kijunniKubun = mybatisPrm.getKijunniKubun();
        RString rangeChushutsuhiKubun = mybatisPrm.getRangeChushutsuhiKubun();
        List<RString> 被保険者情報List = mybatisPrm.getHiHokenshaJyoho();
        if (HizukeChushutsuKubun.基準日.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(日付抽出区分, HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
            出力条件.add(get条件(基準日区分, KijunbiKubun.toValue(kijunniKubun).get名称()));
            出力条件.add(get条件(基準日, getパターン9(mybatisPrm.getKijunni())));
        } else if (HizukeChushutsuKubun.範囲.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(日付抽出区分, HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
            出力条件.add(get条件(範囲抽出日区分, HaniChushutsuKubun.toValue(rangeChushutsuhiKubun).get名称()));
            出力条件.add(get条件(範囲抽出日, getFrom_To(getパターン9(mybatisPrm.getRangeChushutsuhiFrom()),
                    getパターン9(mybatisPrm.getRangeChushutsuhiTo()))));
        } else if (HizukeChushutsuKubun.直近.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(日付抽出区分, HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
        }
        出力条件.add(RString.EMPTY);
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(被保険者情報);
        条件.append(コロン);
        for (RString code : 被保険者情報List) {
            if (HihokenshaJoho._１号.getコード().equals(code)) {
                条件.append(HihokenshaJoho._１号.get名称());
                条件.append(読点);
            }
            if (HihokenshaJoho._２号.getコード().equals(code)) {
                条件.append(HihokenshaJoho._２号.get名称());
                条件.append(読点);
            }
            if (HihokenshaJoho.日本人.getコード().equals(code)) {
                条件.append(HihokenshaJoho.日本人.get名称());
                条件.append(読点);
            }
            if (HihokenshaJoho.外国人.getコード().equals(code)) {
                条件.append(HihokenshaJoho.外国人.get名称());
                条件.append(読点);
            }
            if (HihokenshaJoho.自住所特例.getコード().equals(code)) {
                条件.append(HihokenshaJoho.自住所特例.get名称());
                条件.append(読点);
            }
            if (HihokenshaJoho.広域住特者.getコード().equals(code)) {
                条件.append(HihokenshaJoho.広域住特者.get名称());
                条件.append(読点);
            }
        }
        出力条件.add(条件.substring(0, 条件.length() - 1));
        出力条件.add(RString.EMPTY);
        出力条件.add(get条件(資格抽出区分, ShikakuChushutsuKubun.toValue(mybatisPrm.getShikakuChushutsuKubun()).get名称()));
        RString 取得事由 = get取得事由(mybatisPrm.getShutokujiyu());
        if (取得事由.length() > INT_95) {
            出力条件.add(取得事由.substring(0, INT_95));
            出力条件.add(set改行(取得事由.substring(INT_95)));
        } else {
            出力条件.add(get取得事由(mybatisPrm.getShutokujiyu()));
        }
        出力条件.add(get喪失事由(mybatisPrm.getSoshitsujiyu()));
        出力条件.add(RString.EMPTY);
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(mybatisPrm.getPsmChushutsu_Kubun())) {
            RStringBuilder 年齢 = new RStringBuilder();
            年齢.append(new RString("年齢"));
            年齢.append(コロン);
            年齢.append(mybatisPrm.getPsmChushutsuAge_Start());
            年齢.append(new RString("歳～"));
            年齢.append(mybatisPrm.getPsmChushutsuAge_End());
            年齢.append(new RString("歳"));
            年齢.append(new RString("（年齢基準日："));
            年齢.append(getパターン9(mybatisPrm.getPsmAgeKijunni()));
            年齢.append(new RString("）"));
            出力条件.add(年齢.toRString());
        } else if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(mybatisPrm.getPsmChushutsu_Kubun())) {
            出力条件.add(get条件(生年月日, getFrom_To(
                    getパターン9(new FlexibleDate(mybatisPrm.getPsmSeinengappiYMD_Start())),
                    getパターン9(new FlexibleDate(mybatisPrm.getPsmSeinengappiYMD_End())))));
        }
        if (!Chiku.全て.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
            if (Chiku.住所.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                出力条件.add(get条件(住所, getFrom_To(getCode_Name(mybatisPrm.getPsmJusho_From(), mybatisPrm.getPsmJusho_From_Name()),
                        getCode_Name(mybatisPrm.getPsmJusho_To(), mybatisPrm.getPsmJusho_To_Name()))));
            } else if (Chiku.行政区.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                出力条件.add(get条件(行政区, getFrom_To(getCode_Name(mybatisPrm.getPsmGyoseiku_From(), mybatisPrm.getPsmGyoseiku_From_Name()),
                        getCode_Name(mybatisPrm.getPsmGyoseiku_To(), mybatisPrm.getPsmGyoseiku_To_Name()))));
            } else if (Chiku.地区.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                出力条件.add(get条件(地区1, getFrom_To(getCode_Name(mybatisPrm.getPsmChiku1_From(), mybatisPrm.getPsmChiku1_From_Name()),
                        getCode_Name(mybatisPrm.getPsmChiku1_To(), mybatisPrm.getPsmChiku1_To_Name()))));
                出力条件.add(get条件(地区2, getFrom_To(getCode_Name(mybatisPrm.getPsmChiku2_From(), mybatisPrm.getPsmChiku2_From_Name()),
                        getCode_Name(mybatisPrm.getPsmChiku2_To(), mybatisPrm.getPsmChiku2_To_Name()))));
                出力条件.add(get条件(地区3, getFrom_To(getCode_Name(mybatisPrm.getPsmChiku3_From(), mybatisPrm.getPsmChiku3_From_Name()),
                        getCode_Name(mybatisPrm.getPsmChiku3_To(), mybatisPrm.getPsmChiku3_To_Name()))));
            }
        }
        出力条件.add(get条件(保険者, getCode_Name(mybatisPrm.getShichoson_Code(), mybatisPrm.getShichoson_Name())));
        return 出力条件;
    }

    private RString set改行(RString 取得事由) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("　　　　　"));
        条件.append(取得事由);
        return 条件.toRString();
    }

    private RString get取得事由(List<RString> 取得事由) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("取得事由"));
        条件.append(コロン);
        for (RString code : 取得事由) {
            if (ShikakuShutokuJiyu.転入.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.転入.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.年齢到達.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.年齢到達.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu._２号申請.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu._２号申請.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.外国人.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.外国人.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.自特例転入.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.自特例転入.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.他特例居住.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.他特例居住.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.自特例適用.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.自特例適用.get名称());
                条件.append(読点);
            }
            if (ShikakuShutokuJiyu.帰化.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.帰化.get名称());
                条件.append(読点);
            }
            条件 = get取得事由(条件, code);
        }
        return 条件.substring(0, 条件.length() - 1);
    }

    private RStringBuilder get取得事由(RStringBuilder 条件, RString 取得事由) {
        if (ShikakuShutokuJiyu.職権取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.職権取得.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.広域内転入.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広域内転入.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.除外者居住.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.除外者居住.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.その他.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.その他.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.国籍取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.国籍取得.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.施行時取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.施行時取得.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.広住特適用.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特適用.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.広住特転入.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特転入.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.広住特居住.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特居住.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.一本化.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.一本化.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.合併.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.合併.get名称());
            条件.append(読点);
        }
        if (ShikakuShutokuJiyu.自特例解除.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.自特例解除.get名称());
            条件.append(読点);
        }
        return 条件;
    }

    private RString get喪失事由(List<RString> 喪失事由) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("喪失事由"));
        条件.append(コロン);
        for (RString code : 喪失事由) {
            if (ShikakuSoshitsuJiyu.転出.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.転出.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.死亡.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.死亡.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.国籍喪失.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.国籍喪失.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.他特例者.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.他特例者.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.自特例解除.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.自特例解除.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.職権喪失.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.職権喪失.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.除外者.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.除外者.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.その他.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.その他.get名称());
                条件.append(読点);
            }
        }
        return 条件.substring(0, 条件.length() - 1);
    }

    private RString getCode_Name(RString code, RString name) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(code);
        条件.append(" ");
        条件.append(name);
        return 条件.toRString();
    }

    private RString getFrom_To(RString from, RString to) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(from);
        条件.append("～");
        条件.append(to);
        return 条件.toRString();
    }

    private RString getパターン9(FlexibleDate 基準日) {
        if (基準日 != null && !基準日.isEmpty()) {
            return 基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(バッチパラメータ名);
        条件.append("：");
        条件.append(値);
        return 条件.toRString();
    }

    /**
     * 資格取得の事由・適用日・届出日について、資格取得年月日・資格変更年月日・住所地特例適用年月日・住所地特例解除年月日で<br />
     * 最大の適用日付を判定し、それに対応する事由・適用日・適用届出日を、資格取得事由・適用日・届出日として出力する。
     *
     * @param t HanyoListHihokenshadaichoRelateEntity
     * @return ShikakShutokuHantei
     */
    private ShikakShutokuHantei decide資格取得(HanyoListHihokenshadaichoRelateEntity t) {
        ShikakShutokuHantei 資格取得 = new ShikakShutokuHantei();
        ShikakShutokuHantei 資格変更 = new ShikakShutokuHantei();
        ShikakShutokuHantei 住特適用 = new ShikakShutokuHantei();
        ShikakShutokuHantei 住特解除 = new ShikakShutokuHantei();

        資格取得.setCodeShubetsu(new RString("0007"));
        資格取得.setJiyuCode(t.getShikakuShutokuJiyuCode());
        資格取得.setTekiyoYMD(t.getShikakuShutokuYMD());
        資格取得.setTodokedeYMD(t.getShikakuShutokuTodokedeYMD());

        資格変更.setCodeShubetsu(new RString("0013"));
        資格変更.setJiyuCode(t.getShikakuHenkoJiyuCode());
        資格変更.setTekiyoYMD(t.getShikakuHenkoYMD());
        資格変更.setTodokedeYMD(t.getShikakuHenkoTodokedeYMD());

        住特適用.setCodeShubetsu(new RString("0014"));
        住特適用.setJiyuCode(t.getJushochitokureiTekiyoJiyuCode());
        住特適用.setTekiyoYMD(t.getJushochitokureiTekiyoYMD());
        住特適用.setTodokedeYMD(t.getJushochitokureiTekiyoTodokedeYMD());

        住特解除.setCodeShubetsu(new RString("0015"));
        住特解除.setJiyuCode(t.getJushochitokureiKaijoJiyuCode());
        住特解除.setTekiyoYMD(t.getJushochitokureiKaijoYMD());
        住特解除.setTodokedeYMD(t.getJushochitokureiKaijoTodokedeYMD());

        List<ShikakShutokuHantei> list = new ArrayList<>();
        list.add(住特解除);
        list.add(住特適用);
        list.add(資格変更);
        list.add(資格取得);
        Collections.sort(list, new ShikakShutokuHanteiComparator());

        return list.get(0);
    }

    private HanyoListHihokenshadaichoCSVEntity getCSVEntity(HanyoListHihokenshadaichoRelateEntity t, int i) {
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
        UaFt200FindShikibetsuTaishoEntity entity = t.getPsmEntity();
        UaFt250FindAtesakiEntity atesakiEntity = t.getAtesakiEntity();
        RString 連番 = RString.EMPTY;
        if (mybatisPrm.isRembanfuka()) {
            連番 = new RString(i);
        }
        RString 市町村名 = RString.EMPTY;
        if (t.getShichosonCode() != null && !t.getShichosonCode().isEmpty()) {
            市町村名 = AssociationFinderFactory.createInstance().getAssociation(t.getShichosonCode()).get市町村名();
        }

        ShikakShutokuHantei shikakShutokuHantei = decide資格取得(t);
        if (mybatisPrm.isHidukeHensyu()) {
            return new HanyoListHihokenshadaichoCSVEntity(
                    連番, entity.getShikibetsuCode(),
                    iKojin.get住民状態().住民状態略称(),
                    entity.getMeisho(), entity.getKanaMeisho(), getパターン32(entity.getSeinengappiYMD()),
                    iKojin.get年齢算出().get年齢(),
                    iKojin.get性別().getName().getShortJapanese(),
                    entity.getTsuzukigaraCode(), entity.getSetaiCode(),
                    entity.getSetainushiMei(),
                    entity.getZenkokuJushoCode(),
                    get郵便番号(entity.getYubinNo()),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(),
                    entity.getKatagaki(), entity.getGyoseikuCode(),
                    entity.getGyoseikuName(),
                    iKojin.get行政区画().getChiku1().get名称(),
                    iKojin.get行政区画().getChiku2().get名称(),
                    iKojin.get行政区画().getChiku3().get名称(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki2(),
                    getパターン32(entity.getTorokuIdoYMD()),
                    iKojin.get登録事由().get異動事由略称(),
                    getパターン32(entity.getTorokuTodokedeYMD()),
                    getパターン32(entity.getJuteiIdoYMD()),
                    iKojin.get住定事由().get異動事由略称(),
                    getパターン32(entity.getJuteiTodokedeYMD()),
                    getパターン32(entity.getShojoIdoYMD()),
                    iKojin.get消除事由().get異動事由略称(),
                    getパターン32(entity.getShojoTodokedeYMD()),
                    RString.EMPTY,
                    entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(), t.getShichosonCode(), 市町村名,
                    地方公共団体.get地方公共団体コード(),
                    地方公共団体.get市町村名(),
                    RString.EMPTY,
                    atesakiEntity.getKanjiShimei(),
                    atesakiEntity.getKanaShimei(),
                    atesakiEntity.getZenkokuJushoCode(),
                    get郵便番号(atesakiEntity.getYubinNo()),
                    get住所_番地_方書(atesakiEntity.getJusho(), atesakiEntity.getBanchi(), atesakiEntity.getKatagaki()),
                    atesakiEntity.getJusho(),
                    atesakiEntity.getBanchi(),
                    atesakiEntity.getKatagaki(),
                    atesakiEntity.getGyoseikuCode(),
                    atesakiEntity.getGyoseiku(),
                    t.getHihokenshaNo(),
                    get略称(new CodeShubetsu(shikakShutokuHantei.getCodeShubetsu()), shikakShutokuHantei.getJiyuCode()),
                    getパターン32(shikakShutokuHantei.getTekiyoYMD()),
                    getパターン32(shikakShutokuHantei.getTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getパターン32(t.getShikakuSoshitsuYMD()),
                    getパターン32(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).get名称(),
                    new RString("1").equals(t.getJushochiTokureiFlag()) ? new RString("住特") : RString.EMPTY,
                    get証記載保険者番号(new RString("1").equals(t.getKoikinaiJushochiTokureiFlag()),
                            t.getKoikinaiTokureiSochimotoShichosonCode(), t.getShichosonCode()));
        } else {
            return new HanyoListHihokenshadaichoCSVEntity(
                    連番, entity.getShikibetsuCode(), iKojin.get住民状態().住民状態略称(),
                    entity.getMeisho(), entity.getKanaMeisho(), getYYYYMMDD(entity.getSeinengappiYMD()),
                    iKojin.get年齢算出().get年齢(),
                    iKojin.get性別().getName().getShortJapanese(),
                    entity.getTsuzukigaraCode(),
                    entity.getSetaiCode(), entity.getSetainushiMei(),
                    entity.getZenkokuJushoCode(),
                    get郵便番号(entity.getYubinNo()),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(), entity.getKatagaki(),
                    entity.getGyoseikuCode(), entity.getGyoseikuName(),
                    iKojin.get行政区画().getChiku1().get名称(),
                    iKojin.get行政区画().getChiku2().get名称(),
                    iKojin.get行政区画().getChiku3().get名称(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki2(), getYYYYMMDD(entity.getTorokuIdoYMD()),
                    iKojin.get登録事由().get異動事由略称(),
                    getYYYYMMDD(entity.getTorokuTodokedeYMD()),
                    getYYYYMMDD(entity.getJuteiIdoYMD()),
                    iKojin.get住定事由().get異動事由略称(),
                    getYYYYMMDD(entity.getJuteiTodokedeYMD()),
                    getYYYYMMDD(entity.getShojoIdoYMD()),
                    iKojin.get消除事由().get異動事由略称(),
                    getYYYYMMDD(entity.getShojoTodokedeYMD()),
                    RString.EMPTY, entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(),
                    entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(),
                    t.getShichosonCode(),
                    市町村名,
                    地方公共団体.get地方公共団体コード(),
                    地方公共団体.get市町村名(),
                    RString.EMPTY,
                    atesakiEntity.getKanjiShimei(),
                    atesakiEntity.getKanaShimei(),
                    atesakiEntity.getZenkokuJushoCode(),
                    get郵便番号(atesakiEntity.getYubinNo()),
                    get住所_番地_方書(atesakiEntity.getJusho(), atesakiEntity.getBanchi(), atesakiEntity.getKatagaki()),
                    atesakiEntity.getJusho(),
                    atesakiEntity.getBanchi(),
                    atesakiEntity.getKatagaki(),
                    atesakiEntity.getGyoseikuCode(),
                    atesakiEntity.getGyoseiku(),
                    t.getHihokenshaNo(),
                    get略称(new CodeShubetsu(shikakShutokuHantei.getCodeShubetsu()), shikakShutokuHantei.getJiyuCode()),
                    getYYYYMMDD(shikakShutokuHantei.getTekiyoYMD()),
                    getYYYYMMDD(shikakShutokuHantei.getTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getYYYYMMDD(t.getShikakuSoshitsuYMD()),
                    getYYYYMMDD(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).get名称(),
                    new RString("1").equals(t.getJushochiTokureiFlag()) ? new RString("住特") : RString.EMPTY,
                    get証記載保険者番号(new RString("1").equals(t.getKoikinaiJushochiTokureiFlag()),
                            t.getKoikinaiTokureiSochimotoShichosonCode(), t.getShichosonCode()));
        }
    }

    private RString get証記載保険者番号(boolean is広域内住所地特例, LasdecCode 広住特措置元市町村コード, LasdecCode 市町村コード) {
        LasdecCode shichosonCode = is広域内住所地特例 ? 広住特措置元市町村コード : 市町村コード;
        KoseiShichosonMaster koseiShichoson = this.構成市町村s.get(shichosonCode);
        return koseiShichoson == null ? RString.EMPTY : koseiShichoson.get証記載保険者番号().value();
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            return 郵便番号.getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private RString get略称(CodeShubetsu コード種別, Code コード) {
        UzT0007CodeEntity entity = CodeMaster.getCode(コード種別, コード);
        if (entity == null) {
            return RString.EMPTY;
        }
        return entity.getコード略称();
    }

    private RString getYYYYMMDD(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
    }

    private RString getパターン32(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString get住所_番地_方書(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RStringBuilder 住所_番地_方書 = new RStringBuilder();
        住所_番地_方書.append(住所);
        住所_番地_方書.append(番地);
        住所_番地_方書.append("　");
        住所_番地_方書.append(方書);
        return 住所_番地_方書.toRString();
    }
}
