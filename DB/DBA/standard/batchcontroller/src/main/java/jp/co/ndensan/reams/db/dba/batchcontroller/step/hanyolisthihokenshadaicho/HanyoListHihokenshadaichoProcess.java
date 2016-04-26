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
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisthihokenshadaicho.IHanyoListHihokenshadaichoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
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
    private HanyoListHihokenshadaichoProcessParameter processPrm;
    private HanyoListHihokenshadaichoMyBatisParameter mybatisPrm;
    private IHanyoListHihokenshadaichoMapper mapper;
    private List<PersonalData> personalDataList;
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private int int_連番;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toMyBatisParameter();
        mapper = getMapper(IHanyoListHihokenshadaichoMapper.class);
        personalDataList = new ArrayList<>();
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
        HanyoListHihokenshadaichoMyBatisParameter myBatisParameter = HanyoListHihokenshadaichoMyBatisParameter.create_MybatisParameter(
                mybatisPrm.isKomukuFukaMeyi(), mybatisPrm.isRembanfuka(), mybatisPrm.isHidukeHensyu(), mybatisPrm.getHidukeTyuushutuKubun(),
                mybatisPrm.getKijunniKubun(), mybatisPrm.getKijunni(), mybatisPrm.isKijunNichijiJukyusha(), mybatisPrm.getRangeChushutsuhiKubun(),
                mybatisPrm.getRangeChushutsuhiFrom(), mybatisPrm.getRangeChushutsuhiTo(), mybatisPrm.getHiHokenshaJyoho(),
                mybatisPrm.getShikakuChushutsuKubun(), mybatisPrm.getShutokujiyu(), mybatisPrm.getSoshitsujiyu(),
                mybatisPrm.getPsmChushutsu_Kubun(), mybatisPrm.getPsmChushutsuAge_Start(), mybatisPrm.getPsmChushutsuAge_End(),
                mybatisPrm.getPsmSeinengappiYMD_Start(), mybatisPrm.getPsmSeinengappiYMD_End(), mybatisPrm.getPsmAgeKijunni(),
                mybatisPrm.getShichoson_Code(), mybatisPrm.getPsmChiku_Kubun(), mybatisPrm.getPsmJusho_From(), mybatisPrm.getPsmJusho_To(),
                mybatisPrm.getPsmGyoseiku_From(), mybatisPrm.getPsmGyoseiku_To(), mybatisPrm.getPsmChiku1_From(), mybatisPrm.getPsmChiku1_To(),
                mybatisPrm.getPsmChiku2_From(), mybatisPrm.getPsmChiku2_To(), mybatisPrm.getPsmChiku3_From(), mybatisPrm.getPsmChiku3_To(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
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
//        manager.getEucOutputDirectry();
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
        List<RString> 被保険者情報 = mybatisPrm.getHiHokenshaJyoho();
        if (HizukeChushutsuKubun.基準日.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(new RString("日付抽出区分"), HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
            出力条件.add(get条件(new RString("基準日区分"), KijunbiKubun.toValue(kijunniKubun).get名称()));
            出力条件.add(get条件(new RString("基準日"), getパターン9(mybatisPrm.getKijunni())));
        } else if (HizukeChushutsuKubun.範囲.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(new RString("日付抽出区分"), HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
            出力条件.add(get条件(new RString("範囲抽出日区分"), HaniChushutsuKubun.toValue(rangeChushutsuhiKubun).get名称()));
            出力条件.add(get条件(new RString("範囲抽出日"), getFrom_To(getパターン9(mybatisPrm.getRangeChushutsuhiFrom()),
                    getパターン9(mybatisPrm.getRangeChushutsuhiTo()))));
        } else if (HizukeChushutsuKubun.直近.getコード().equals(hidukeTyuushutuKubun)) {
            出力条件.add(get条件(new RString("日付抽出区分"), HizukeChushutsuKubun.toValue(hidukeTyuushutuKubun).get名称()));
        }
        出力条件.add(RString.EMPTY);
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("被保険者情報"));
        条件.append(new RString("："));
        for (RString code : 被保険者情報) {
            if (HihokenshaJoho._１号.getコード().equals(code)) {
                条件.append(HihokenshaJoho._１号.get略称());
                条件.append("、");
            }
            if (HihokenshaJoho._２号.getコード().equals(code)) {
                条件.append(HihokenshaJoho._１号.get略称());
                条件.append("、");
            }
            if (HihokenshaJoho.日本人.getコード().equals(code)) {
                条件.append(HihokenshaJoho.日本人.get略称());
                条件.append("、");
            }
            if (HihokenshaJoho.外国人.getコード().equals(code)) {
                条件.append(HihokenshaJoho.外国人.get略称());
                条件.append("、");
            }
            if (HihokenshaJoho.自住所特例.getコード().equals(code)) {
                条件.append(HihokenshaJoho.自住所特例.get略称());
                条件.append("、");
            }
            if (HihokenshaJoho.広域住特者.getコード().equals(code)) {
                条件.append(HihokenshaJoho.広域住特者.get略称());
                条件.append("、");
            }
        }
        出力条件.add(条件.substring(条件.length() - 1));
        出力条件.add(RString.EMPTY);
        出力条件.add(get条件(new RString("資格抽出区分"), ShikakuChushutsuKubun.toValue(mybatisPrm.getShikakuChushutsuKubun()).get名称()));
        出力条件.add(get取得事由(mybatisPrm.getShutokujiyu()));
        出力条件.add(get喪失事由(mybatisPrm.getSoshitsujiyu()));
        出力条件.add(RString.EMPTY);
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(mybatisPrm.getPsmChushutsu_Kubun())) {
            RStringBuilder 年齢 = new RStringBuilder();
            年齢.append(new RString("年齢"));
            年齢.append(new RString("："));
            年齢.append(mybatisPrm.getPsmChushutsuAge_Start());
            年齢.append(new RString("歳～"));
            年齢.append(mybatisPrm.getPsmChushutsuAge_End());
            年齢.append(new RString("歳"));
            年齢.append(new RString("（年齢基準日："));
            年齢.append(getパターン9(mybatisPrm.getPsmAgeKijunni()));
            年齢.append(new RString("）"));
            出力条件.add(年齢.toRString());
        } else if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(mybatisPrm.getPsmChushutsu_Kubun())) {
            出力条件.add(get条件(new RString("生年月日"), getFrom_To(mybatisPrm.getPsmSeinengappiYMD_Start(),
                    mybatisPrm.getPsmSeinengappiYMD_End())));
        }
        if (!Chiku.全て.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
            if (Chiku.住所.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                get条件(new RString("住所"), getFrom_To(mybatisPrm.getPsmJusho_From(), mybatisPrm.getPsmJusho_To()));
            } else if (Chiku.行政区.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                get条件(new RString("行政区"), getFrom_To(mybatisPrm.getPsmGyoseiku_From(), mybatisPrm.getPsmGyoseiku_To()));
            } else if (Chiku.地区.getコード().equals(mybatisPrm.getPsmChiku_Kubun())) {
                get条件(new RString("地区"), getFrom_To(mybatisPrm.getPsmChiku1_From(), mybatisPrm.getPsmChiku1_To()));
            }
        }
        return 出力条件;
    }

    private RString get取得事由(List<RString> 取得事由) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("被保険者情報"));
        条件.append(new RString("："));
        for (RString code : 取得事由) {
            if (ShikakuShutokuJiyu.転入.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.転入.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.年齢到達.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.年齢到達.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu._２号申請.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu._２号申請.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.外国人.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.外国人.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.自特例転入.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.自特例転入.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.他特例居住.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.他特例居住.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.自特例適用.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.自特例適用.get名称());
                条件.append("、");
            }
            if (ShikakuShutokuJiyu.帰化.getコード().equals(code)) {
                条件.append(ShikakuShutokuJiyu.帰化.get名称());
                条件.append("、");
            }
            条件 = get取得事由(条件, code);
        }
        return 条件.substring(条件.length() - 1);
    }

    private RStringBuilder get取得事由(RStringBuilder 条件, RString 取得事由) {
        if (ShikakuShutokuJiyu.職権取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.職権取得.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.広域内転入.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広域内転入.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.除外者居住.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.除外者居住.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.その他.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.その他.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.国籍取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.国籍取得.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.施行時取得.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.施行時取得.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.広住特適用.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特適用.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.広住特転入.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特転入.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.広住特居住.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.広住特居住.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.一本化.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.一本化.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.合併.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.合併.get名称());
            条件.append("、");
        }
        if (ShikakuShutokuJiyu.自特例解除.getコード().equals(取得事由)) {
            条件.append(ShikakuShutokuJiyu.自特例解除.get名称());
            条件.append("、");
        }
        return 条件;
    }

    private RString get喪失事由(List<RString> 喪失事由) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("被保険者情報"));
        条件.append(new RString("："));
        for (RString code : 喪失事由) {
            if (ShikakuSoshitsuJiyu.転出.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.転出.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.年齢到達.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.年齢到達.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.死亡.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.死亡.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.国籍喪失.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.国籍喪失.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.自特例転入.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.自特例転入.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.他特例者.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.他特例者.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.自特例解除.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.自特例解除.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.帰化.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.帰化.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.職権喪失.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.職権喪失.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.広域内転出.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広域内転出.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.除外者.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.除外者.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.その他.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.その他.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.国籍取得.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.国籍取得.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.広住特転入.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広住特転入.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.広住特解除.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.広住特解除.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.一本化.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.一本化.get名称());
                条件.append("、");
            }
            if (ShikakuSoshitsuJiyu.合併.getコード().equals(code)) {
                条件.append(ShikakuSoshitsuJiyu.合併.get名称());
                条件.append("、");
            }
        }
        return 条件.substring(条件.length() - 1);
    }

    private RString getFrom_To(RString from, RString to) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(from);
        条件.append("～");
        条件.append(to);
        return 条件.toRString();
    }

    private RString getパターン9(FlexibleDate 基準日) {
        return 基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
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
                    get年齢(iKojin.get生年月日()), entity.getSeibetsuCode(),
                    entity.getTsuzukigaraCode(), entity.getSetaiCode(),
                    entity.getSetainushiMei(),
                    //住所コード
                    entity.getZenkokuJushoCode(), entity.getYubinNo(),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(),
                    entity.getKatagaki(), entity.getGyoseikuCode(),
                    entity.getGyoseikuName(), entity.getChikuCode1(),
                    entity.getChikuCode2(), entity.getChikuCode3(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki1(),
                    getパターン32(entity.getTorokuIdoYMD()), entity.getTorokuJiyuCode(),
                    getパターン32(entity.getTorokuTodokedeYMD()), getパターン32(entity.getJuteiIdoYMD()),
                    entity.getJuteiJiyuCode(), getパターン32(entity.getJuteiTodokedeYMD()),
                    getパターン32(entity.getShojoIdoYMD()), entity.getShojoJiyuCode(),
                    getパターン32(entity.getShojoTodokedeYMD()),
                    //転出入理由
                    iKojin.get転入前().get世帯主名(), entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(), t.getShichosonCode(), 市町村名,
                    //保険者コード  保険者名
                    AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                    AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                    RString.EMPTY,
                    //宛名・送付先・漢字氏名
                    entity.getKanjiShimei(),
                    entity.getKanaShimei(),
                    entity.getZenkokuJushoCode(),
                    entity.getYubinNo(),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(),
                    entity.getBanchi(),
                    entity.getKatagaki(),
                    entity.getGyoseikuCode(),
                    entity.getGyoseikuName(),
                    t.getHihokenshaNo(),
                    get略称(new CodeShubetsu("0007"), t.getShikakuShutokuJiyuCode()),
                    getパターン32(t.getShikakuShutokuYMD()),
                    getパターン32(t.getShikakuShutokuTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getパターン32(t.getShikakuSoshitsuYMD()),
                    getパターン32(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).toRString(),
                    t.isJushochiTokureiFlag() ? new RString("住特") : RString.EMPTY,
                    //get証記載保険者番号(t.isKoikinaiJushochiTokureiFlag(), t.getShichosonCode(), t.getKoikinaiTokureiSochimotoShichosonCode())
                    ShoKisaiHokenshaNo.EMPTY);
        } else {
            return new HanyoListHihokenshadaichoCSVEntity(
                    連番, entity.getShikibetsuCode(), entity.getJuminShubetsuCode(),
                    entity.getMeisho(), entity.getKanaMeisho(), getYYYYMMDD(entity.getSeinengappiYMD()),
                    get年齢(iKojin.get生年月日()), entity.getSeibetsuCode(), entity.getTsuzukigaraCode(),
                    entity.getSetaiCode(), entity.getSetainushiMei(),
                    //住所コード
                    entity.getZenkokuJushoCode(),
                    entity.getYubinNo(),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(), entity.getBanchi(), entity.getKatagaki(),
                    entity.getGyoseikuCode(), entity.getGyoseikuName(),
                    entity.getChikuCode1(), entity.getChikuCode2(), entity.getChikuCode3(),
                    entity.getRenrakusaki1(), entity.getRenrakusaki1(), getYYYYMMDD(entity.getTorokuIdoYMD()),
                    entity.getTorokuJiyuCode(),
                    getYYYYMMDD(entity.getTorokuTodokedeYMD()),
                    getYYYYMMDD(entity.getJuteiIdoYMD()),
                    entity.getJuteiJiyuCode(),
                    getYYYYMMDD(entity.getJuteiTodokedeYMD()),
                    getYYYYMMDD(entity.getShojoIdoYMD()),
                    entity.getShojoJiyuCode(),
                    getYYYYMMDD(entity.getShojoTodokedeYMD()),
                    //転出入理由
                    iKojin.get転入前().get世帯主名(),
                    entity.getTennyumaeYubinNo(),
                    get住所_番地_方書(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()),
                    entity.getTennyumaeJusho(),
                    entity.getTennyumaeBanchi(),
                    entity.getTennyumaeKatagaki(),
                    t.getShichosonCode(),
                    市町村名,
                    //保険者コード  保険者名
                    AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                    AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                    RString.EMPTY,
                    //宛名・送付先・漢字氏名
                    entity.getKanjiShimei(),
                    entity.getKanaShimei(),
                    entity.getZenkokuJushoCode(),
                    entity.getYubinNo(),
                    get住所_番地_方書(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()),
                    entity.getJusho(),
                    entity.getBanchi(),
                    entity.getKatagaki(),
                    entity.getGyoseikuCode(),
                    entity.getGyoseikuName(),
                    t.getHihokenshaNo(),
                    get略称(new CodeShubetsu("0007"), t.getShikakuShutokuJiyuCode()),
                    getYYYYMMDD(t.getShikakuShutokuYMD()),
                    getYYYYMMDD(t.getShikakuShutokuTodokedeYMD()),
                    get略称(new CodeShubetsu("0010"), t.getShikakuShutokuJiyuCode()),
                    getYYYYMMDD(t.getShikakuSoshitsuYMD()),
                    getYYYYMMDD(t.getShikakuSoshitsuTodokedeYMD()),
                    HihokenshaKubunCode.toValue(t.getHihokennshaKubunCode()).toRString(),
                    t.isJushochiTokureiFlag() ? new RString("住特") : RString.EMPTY,
                    //get証記載保険者番号(t.isKoikinaiJushochiTokureiFlag(), t.getShichosonCode(), t.getKoikinaiTokureiSochimotoShichosonCode())
                    ShoKisaiHokenshaNo.EMPTY);
        }

    }

    private ShoKisaiHokenshaNo get証記載保険者番号(boolean is広域, LasdecCode 広住特措置元市町村コード, LasdecCode 市町村コード) {
        List<HokenshaSummary> list = new ArrayList<>();
        if (is広域) {
            return HokenshaList.createFor広域(list).get(広住特措置元市町村コード).get証記載保険者番号();
        } else {
            return HokenshaList.createFor単一(list).get(市町村コード).get証記載保険者番号();
        }
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

    private RString get年齢(IDateOfBirth 生年月日) {
        AgeCalculator ageCalculator = new AgeCalculator(生年月日, JuminJotai.住民, FlexibleDate.MAX);
        return ageCalculator.get年齢();
    }

    private Encode getEncode(RString sakiEncodeKeitai) {
        Encode encode = Encode.SJIS;
        if (new RString("1").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("3").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else {
            encode = Encode.UTF_8withBOM;
        }
        return encode;
    }
}
