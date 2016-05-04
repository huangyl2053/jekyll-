/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisthihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HaniChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HihokenshaJoho;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoMyBatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoCSVEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.HihokenshaKubunCode;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

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

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toMyBatisParameter();
        personalDataList = new ArrayList<>();
        //TODO システム日時は使用なし
//        RDateTime システム日時 = RDate.getNowDateTime();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("HanyoList_Hihokenshadaicho.csv"));
        RString 文字コード = BusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, SubGyomuCode.DBU介護統計報告);
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilename, EUC_ENTITY_ID).
                setEncode(getEncode(文字コード))
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(mybatisPrm.isKomukuFukaMeyi()).
                build();

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
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()));
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
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
        eucCsvWriterJunitoJugo.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilename, id);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                RString.EMPTY,
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
            if (ShikakuSoshitsuJiyu.年齢到達.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.年齢到達.get名称());
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
            if (ShikakuSoshitsuJiyu.自特例転入.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.自特例転入.get名称());
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
            if (ShikakuSoshitsuJiyu.帰化.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.帰化.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.職権喪失.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.職権喪失.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.広域内転出.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広域内転出.get名称());
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
            if (ShikakuSoshitsuJiyu.国籍取得.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.国籍取得.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.広住特転入.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広住特転入.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.広住特解除.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広住特解除.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.一本化.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.一本化.get名称());
                条件.append(読点);
            }
            if (ShikakuSoshitsuJiyu.合併.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.合併.get名称());
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
        if (mybatisPrm.isHidukeHensyu()) {
            return new HanyoListHihokenshadaichoCSVEntity(
                    連番, entity.getShikibetsuCode(), entity.getJuminShubetsuCode(),
                    entity.getMeisho(), entity.getKanaMeisho(), getパターン32(entity.getSeinengappiYMD()),
                    iKojin.get年齢算出().get年齢(), entity.getSeibetsuCode(),
                    entity.getTsuzukigaraCode(), entity.getSetaiCode(),
                    entity.getSetainushiMei(),
                    entity.getZenkokuJushoCode(),
                    get郵便番号(entity.getYubinNo()),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(),
                    entity.getKatagaki(), entity.getGyoseikuCode(),
                    entity.getGyoseikuName(), entity.getChikuCode1(),
                    entity.getChikuCode2(), entity.getChikuCode3(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki2(),
                    getパターン32(entity.getTorokuIdoYMD()), entity.getTorokuJiyuCode(),
                    getパターン32(entity.getTorokuTodokedeYMD()), getパターン32(entity.getJuteiIdoYMD()),
                    entity.getJuteiJiyuCode(), getパターン32(entity.getJuteiTodokedeYMD()),
                    getパターン32(entity.getShojoIdoYMD()), entity.getShojoJiyuCode(),
                    getパターン32(entity.getShojoTodokedeYMD()),
                    RString.EMPTY,
                    entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(), t.getShichosonCode(), 市町村名,
                    AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                    AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
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
                    get略称(new CodeShubetsu("0007"), t.getShikakuShutokuJiyuCode()),
                    getパターン32(t.getShikakuShutokuYMD()),
                    getパターン32(t.getShikakuShutokuTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getパターン32(t.getShikakuSoshitsuYMD()),
                    getパターン32(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).toRString(),
                    t.isJushochiTokureiFlag() ? new RString("住特") : RString.EMPTY,
                    get証記載保険者番号(t.isKoikinaiJushochiTokureiFlag(), t.getKoikinaiTokureiSochimotoShichosonCode(), t.getShichosonCode()));
        } else {
            return new HanyoListHihokenshadaichoCSVEntity(
                    連番, entity.getShikibetsuCode(), entity.getJuminShubetsuCode(),
                    entity.getMeisho(), entity.getKanaMeisho(), getYYYYMMDD(entity.getSeinengappiYMD()),
                    iKojin.get年齢算出().get年齢(), entity.getSeibetsuCode(), entity.getTsuzukigaraCode(),
                    entity.getSetaiCode(), entity.getSetainushiMei(),
                    entity.getZenkokuJushoCode(),
                    get郵便番号(entity.getYubinNo()),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(), entity.getKatagaki(),
                    entity.getGyoseikuCode(), entity.getGyoseikuName(),
                    entity.getChikuCode1(), entity.getChikuCode2(), entity.getChikuCode3(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki2(), getYYYYMMDD(entity.getTorokuIdoYMD()),
                    entity.getTorokuJiyuCode(),
                    getYYYYMMDD(entity.getTorokuTodokedeYMD()),
                    getYYYYMMDD(entity.getJuteiIdoYMD()),
                    entity.getJuteiJiyuCode(),
                    getYYYYMMDD(entity.getJuteiTodokedeYMD()),
                    getYYYYMMDD(entity.getShojoIdoYMD()),
                    entity.getShojoJiyuCode(),
                    getYYYYMMDD(entity.getShojoTodokedeYMD()),
                    RString.EMPTY, entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(),
                    entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(),
                    t.getShichosonCode(),
                    市町村名,
                    AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                    AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
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
                    get略称(new CodeShubetsu("0007"), t.getShikakuShutokuJiyuCode()),
                    getYYYYMMDD(t.getShikakuShutokuYMD()),
                    getYYYYMMDD(t.getShikakuShutokuTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getYYYYMMDD(t.getShikakuSoshitsuYMD()),
                    getYYYYMMDD(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).toRString(),
                    t.isJushochiTokureiFlag() ? new RString("住特") : RString.EMPTY,
                    get証記載保険者番号(t.isKoikinaiJushochiTokureiFlag(), t.getKoikinaiTokureiSochimotoShichosonCode(), t.getShichosonCode()));
        }

    }

    private RString get証記載保険者番号(boolean is広域, LasdecCode 広住特措置元市町村コード, LasdecCode 市町村コード) {
        HokenshaListLoader loader = HokenshaListLoader.createInstance();
        HokenshaList hokenshaList = loader.getShichosonCodeNameList(GyomuBunrui.介護事務);
        if (is広域) {
            if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
                return hokenshaList.get(広住特措置元市町村コード).get証記載保険者番号().getColumnValue();
            } else {
                return RString.EMPTY;
            }
        } else {
            if (市町村コード != null && !市町村コード.isEmpty()) {
                return hokenshaList.get(市町村コード).get証記載保険者番号().getColumnValue();
            } else {
                return RString.EMPTY;
            }
        }
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

    private Encode getEncode(RString sakiEncodeKeitai) {
        Encode encode = Encode.UTF_8withBOM;
        if (new RString("1").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("3").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        }
        return encode;
    }
}
