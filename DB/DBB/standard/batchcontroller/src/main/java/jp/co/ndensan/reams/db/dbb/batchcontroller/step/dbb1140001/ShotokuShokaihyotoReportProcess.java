/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.SetaiInn;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.KoikiZenShichosonJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.shotokushokaihyo.Shotokushokaihyo;
import jp.co.ndensan.reams.db.dbb.service.report.shotokushokaihyo.ShotokuShokaihyoPrintSercive;
import jp.co.ndensan.reams.db.dbb.service.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 所得照会票の出力を出力します。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class ShotokuShokaihyotoReportProcess extends SimpleBatchProcessBase {

    private static final RString 設定値_001 = new RString("001");
    private static final RString 設定値_002 = new RString("002");
    private static final RString 区 = new RString("区");
    private static final RString 市 = new RString("市");
    private static final RString 町 = new RString("町");
    private static final RString 村 = new RString("村");
    private static final RString 役所 = new RString("役所");
    private static final RString 役場 = new RString("役場");
    private static final RString 転出者 = new RString("3");
    private static final RString CSV_世帯コード = new RString("世帯コード");
    private static final RString CSV_カナ氏名 = new RString("カナ氏名");
    private static final RString CSV_前住所 = new RString("前住所");
    private static final RString CSV_生年月日 = new RString("生年月日");
    private static final RString CSV_照会日 = new RString("照会日");
    private static final RString CSV_転入日 = new RString("転入日");
    private static final RString CSV_種別 = new RString("種別");
    private static final RString CSV_識別コード = new RString("識別コード");
    private static final RString CSV_氏名 = new RString("氏名");
    private static final RString CSV_現住所 = new RString("現住所");
    private static final RString CSV_性別 = new RString("性別");
    private static final RString CSV_転出日 = new RString("転出日");
    private static final RString CSV_被保険者番号 = new RString("被保険者番号");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200024"));
    private static final RString 候補者区分_転入者 = new RString("1");
    private static final RString 候補者区分_住特者 = new RString("2");
    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 印字_１号 = new RString("１号");
    private static final RString 印字_１号予 = new RString("１号（予）");
    private static final RString 印字_２号 = new RString("２号");
    private static final RString 印字_世帯員 = new RString("世帯員");
    private static final RString 印字_世帯員予 = new RString("世帯員（予）");
    private static final RString 印字_１号住特 = new RString("１号住特");
    private static final RString 印字_２号住特 = new RString("２号住特");
    private static final RString 印字_広域 = new RString("広域");
    private static final RString 被保険者区分コード_EMPTY = new RString("");
    private static final RString 被保険者区分コード_NUM1 = new RString("1");
    private static final RString 被保険者区分コード_NUM2 = new RString("2");
    private static final RString 本人 = new RString("1");
    private static final RString 世帯員 = new RString("2");
    private static final RString 出力対象_0 = new RString("0");
    private static final ReportId 帳票ID = new ReportId("DBB100001_ShotokuShokaihyoDaihyo");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_5 = 5;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_15 = 15;

    private List<ShotokuShoukaiDataTempEntity> 所得照会票リスト;
    private ShotokuShokaihyoHakkoProcessParameter parameter;
    private IShotokushokaihyoMapper mapper;
    private Shotokushokaihyo kaihyo;

    @Override
    protected void beforeExecute() {
        kaihyo = Shotokushokaihyo.createInstance();
        所得照会票リスト = new ArrayList<>();
        mapper = getMapper(IShotokushokaihyoMapper.class);
    }

    @Override
    protected void process() {
        所得照会票リスト = mapper.selectAll所得照会票();
        if (所得照会票リスト == null && 所得照会票リスト.isEmpty()) {
            return;
        }
        ChohyoSeigyoHanyo hanyo = new ChohyoSeigyoHanyo(null);
        RString 文書タイトル = hanyo.get項目名();
        RString 送付先担当課名称 = hanyo.get設定値();
        ShotokuShokaihyoPrintSercive service = new ShotokuShokaihyoPrintSercive();
        NushiJuminJohoResult result = set所得照会票パラメタ(所得照会票リスト);
        SourceDataCollection sourceDataCollection = null;
        if (hanyo.get設定値().equals(設定値_001)) {
            sourceDataCollection = service.printＡ４横(result, 文書タイトル, 送付先担当課名称);
        } else if (hanyo.get設定値().equals(設定値_002)) {
            sourceDataCollection = service.printＡ４縦(result, 文書タイトル, 送付先担当課名称);
        }
        if (sourceDataCollection != null && !parameter.isテストプリント()) {
            kaihyo.updateShotokushokaihyo(parameter.get処理年度(), parameter.get照会年月日(), 所得照会票リスト);
        }
    }

    @Override
    protected void afterExecute() {
        RString 出力順 = parameter.get出力順();
        List<KoikiZenShichosonJohoParameter> 構成市町村情報 = parameter.get構成市町村情報リスト();
        List<KoikiZenShichosonJoho> 構成市町村情報リスト = editor構成市町村情報リスト(構成市町村情報);
        所得照会票リスト = mapper.selectAll所得照会票OrderBy出力順(出力順);
        if (所得照会票リスト == null || 所得照会票リスト.isEmpty()) {
            return;
        }
        ShotokushokaihyoHakkoIchiranPrintService service = new ShotokushokaihyoHakkoIchiranPrintService();
        service.print所得照会票(所得照会票リスト, 構成市町村情報リスト, parameter.get照会年月日(), parameter.get処理年度(),
                parameter.isテストプリント(), parameter.get出力順ID());

        // TODO
        RString eucFileName = new RString("");
        List<RString> headerList = new ArrayList<>();
        headerList.add(CSV_世帯コード);
        headerList.add(CSV_カナ氏名);
        headerList.add(CSV_前住所);
        headerList.add(CSV_生年月日);
        headerList.add(CSV_照会日);
        headerList.add(CSV_転入日);
        headerList.add(CSV_種別);
        headerList.add(CSV_識別コード);
        headerList.add(CSV_氏名);
        headerList.add(CSV_現住所);
        headerList.add(CSV_性別);
        headerList.add(CSV_転出日);
        headerList.add(CSV_被保険者番号);
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, eucFileName);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build()) {
            for (ShotokuShoukaiDataTempEntity tempEntity : 所得照会票リスト) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(new RString(tempEntity.getSetaiCode().toString()));
                bodyList.add(new RString(tempEntity.getAtenaKanaShimei().toString()));
                RString 候補者区分 = tempEntity.getKouhoshakubun();
                if (候補者区分 != null && 候補者区分.equals(候補者区分_転入者) && tempEntity.getZenjusho() != null) {
                    bodyList.add(tempEntity.getZenjusho());
                } else if (候補者区分 != null && 候補者区分.equals(候補者区分_住特者)) {
                    bodyList.add(RString.EMPTY);
                }
                RString 住民種別コード = tempEntity.getJuminShubetsuCode();
                if (住民種別コード.equals(外国人)
                        || 住民種別コード.equals(住登外外国人)) {
                    bodyList.add(tempEntity.getSeinengappiYMD().seireki().toDateString());
                }
                if (住民種別コード.equals(日本人)
                        || 住民種別コード.equals(住登外日本人)) {
                    bodyList.add(tempEntity.getSeinengappiYMD().wareki().toDateString());
                }
                bodyList.add(CSV_照会日);
                bodyList.add(CSV_転入日);
                RString 種別 = set種別(tempEntity, 構成市町村情報リスト);
                bodyList.add(種別);
                bodyList.add(tempEntity.getShikibetsuCode().getColumnValue());
                bodyList.add(tempEntity.getAtenaShimei().getColumnValue());
                bodyList.add(tempEntity.getGenjusho());
                RString 性別;
                if (Seibetsu.男.getコード().equals(tempEntity.getSeibetsuCode())) {
                    性別 = Seibetsu.男.get名称();
                } else if (Seibetsu.女.getコード().equals(tempEntity.getSeibetsuCode())) {
                    性別 = Seibetsu.女.get名称();
                } else {
                    性別 = RString.EMPTY;
                }
                bodyList.add(性別);
                bodyList.add(CSV_転出日);
                bodyList.add(tempEntity.getHihokenshaNo().getColumnValue());
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
            csvListWriter.close();
        }

        RString 出力対象 = parameter.get出力対象();
        if (出力対象.equals(出力対象_0)) {
            List<SaiHakkoParameter> 再発行対象リスト = new ArrayList<>();
            List<SaiHakkoEntity> 再発行対象List = new ArrayList<>();
            for (SaiHakkoParameter param : 再発行対象リスト) {
                SaiHakkoEntity entity = new SaiHakkoEntity();
                entity.setユーザ(param.getユーザ());
                entity.set処理年度(param.get処理年度());
                entity.set処理日時(param.get処理日時());
                entity.set発行件数(param.get発行件数());
                再発行対象List.add(entity);
            }
            kaihyo.getSaiHakkoShotokushokaihyo(parameter.get処理年度(), 出力対象, 再発行対象List);
            List<ShotokuShoukaiDataTempEntity> 所得照会票List = mapper.selectAll所得照会票();

            ChohyoSeigyoHanyo hanyo = new ChohyoSeigyoHanyo(null);
            RString 文書タイトル = hanyo.get項目名();
            RString 送付先担当課名称 = hanyo.get設定値();
            ShotokuShokaihyoPrintSercive printservice = new ShotokuShokaihyoPrintSercive();
            NushiJuminJohoResult result = set所得照会票パラメタ(所得照会票List);
            if (hanyo.get設定値().equals(設定値_001)) {
                printservice.printＡ４横(result, 文書タイトル, 送付先担当課名称);
            } else if (hanyo.get設定値().equals(設定値_002)) {
                printservice.printＡ４縦(result, 文書タイトル, 送付先担当課名称);
            }
        }
    }

    private RString set種別(ShotokuShoukaiDataTempEntity tempEntity,
            List<KoikiZenShichosonJoho> 構成市町村情報リスト) {
        RString 候補者区分 = tempEntity.getKouhoshakubun();
        RString 被保険者区分コード = tempEntity.getHihokennshaKubunCode();
        RString 本人区分 = tempEntity.getHonninKubun();
        if (is１号(候補者区分, 本人区分, 被保険者区分コード)) {
            return 印字_１号;
        } else if (is１号予(候補者区分, 本人区分, 被保険者区分コード)) {
            return 印字_１号予;
        } else if (is２号(候補者区分, 本人区分, 被保険者区分コード)) {
            return 印字_２号;
        } else if (is世帯員(候補者区分, 本人区分, 被保険者区分コード)) {
            return 印字_世帯員;
        } else if (is世帯員予(候補者区分, 本人区分, 被保険者区分コード)) {
            return 印字_世帯員予;
        } else if (is１号住特(候補者区分, 被保険者区分コード)) {
            return 印字_１号住特;
        } else if (is２号住特(候補者区分, 被保険者区分コード)) {
            return 印字_２号住特;
        } else if (is広域(tempEntity, 構成市町村情報リスト)) {
            return 印字_広域;
        } else {
            return RString.EMPTY;
        }
    }

    private boolean is広域(ShotokuShoukaiDataTempEntity tempEntity,
            List<KoikiZenShichosonJoho> 構成市町村情報リスト) {
        RString 市町村コード = RString.EMPTY;
        RString 構成市町村情報_市町村コード = RString.EMPTY;
        if (tempEntity.getShokaisakiLasdecCode() != null) {
            市町村コード = new RString(tempEntity.getShokaisakiLasdecCode().toString().substring(INT_0, INT_5));
        }
        List<RString> 市町村コードリスト = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村情報 : 構成市町村情報リスト) {
            if (構成市町村情報.get市町村コード() != null) {
                構成市町村情報_市町村コード = new RString(構成市町村情報.get市町村コード()
                        .toString().substring(INT_0, INT_5));
            }
            市町村コードリスト.add(構成市町村情報_市町村コード);
        }
        return 市町村コードリスト.contains(市町村コード);
    }

    private boolean is２号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_住特者) && 被保険者区分コード.equals(被保険者区分コード_NUM2);
    }

    private boolean is１号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_住特者) && 被保険者区分コード.equals(被保険者区分コード_NUM1);
    }

    private boolean is世帯員予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_転入者) && 本人区分.equals(世帯員)
                && 被保険者区分コード.equals(被保険者区分コード_EMPTY);
    }

    private boolean is世帯員(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_転入者) && 本人区分.equals(世帯員)
                && 被保険者区分コード.equals(被保険者区分コード_NUM1);
    }

    private boolean is２号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_転入者) && 本人区分.equals(本人)
                && 被保険者区分コード.equals(被保険者区分コード_NUM2);
    }

    private boolean is１号予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_転入者) && 本人区分.equals(本人)
                && 被保険者区分コード.equals(被保険者区分コード_EMPTY);
    }

    private boolean is１号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分.equals(候補者区分_転入者) && 本人区分.equals(本人)
                && 被保険者区分コード.equals(被保険者区分コード_NUM1);
    }

    private List<KoikiZenShichosonJoho> editor構成市町村情報リスト(List<KoikiZenShichosonJohoParameter> 構成市町村情報) {
        List<KoikiZenShichosonJoho> 構成市町村情報リスト = new ArrayList<>();
        for (KoikiZenShichosonJohoParameter param : 構成市町村情報) {
            DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(param.getShichosonShokibetsuID());
            entity.setShichosonCode(param.getShichosonCode());
            entity.setShoKisaiHokenshaNo(param.getShoKisaiHokenshaNo());
            entity.setKokuhorenKoikiShichosonNo(param.getKokuhorenKoikiShichosonNo());
            entity.setShichosonMeisho(param.getShichosonMeisho());
            entity.setTodofukenMeisho(param.getTodofukenMeisho());
            entity.setGunMeisho(param.getGunMeisho());
            entity.setYubinNo(param.getYubinNo());
            entity.setJusho(param.getJusho());
            entity.setTelNo(param.getTelNo());
            entity.setYusenChikuCode(param.getYusenChikuCode());
            entity.setTyohyoTodoufukenHyojiUmu(param.getTyohyoTodoufukenHyojiUmu());
            entity.setTyohyoGunHyojiUmu(param.getTyohyoGunHyojiUmu());
            entity.setTyohyoShichosonHyojiUmu(param.getTyohyoShichosonHyojiUmu());
            entity.setTyohyoJushoHenshuHouhou(param.getTyohyoJushoHenshuHouhou());
            entity.setTyohyoKatagakiHyojiUmu(param.getTyohyoKatagakiHyojiUmu());
            entity.setGaikokujinHyojiHouhou(param.getGaikokujinHyojiHouhou());
            entity.setRojinhokenShichosonNo(param.getRojinhokenShichosonNo());
            entity.setRokenJukyushaNoTaikei(param.getRokenJukyushaNoTaikei());
            entity.setShotokuHikidashiHoho(param.getShotokuHikidashiHoho());
            entity.setNofugakuDataRenkeiHoho(param.getNofugakuDataRenkeiHoho());
            entity.setTokuchoBunpaishuyaku(param.getTokuchoBunpaishuyaku());
            entity.setIkoYMD(param.getIkoYMD());
            entity.setKanyuYMD(param.getKanyuYMD());
            entity.setRidatsuYMD(param.getRidatsuYMD());
            entity.setGappeiKyuShichosonKubun(param.getGappeiKyuShichosonKubun());
            entity.setGappeiKyuShichosonHyojiUmu(param.getGappeiKyuShichosonHyojiUmu());
            entity.setGappeiChiikiNo(param.getGappeiChiikiNo());
            entity.setUnyoHokenshaNo(param.getUnyoHokenshaNo());
            entity.setUnyoKaishiYMD(param.getUnyoKaishiYMD());
            entity.setUnyoShuryoYMD(param.getUnyoShuryoYMD());
            entity.setUnyoKeitaiKubun(param.getUnyoKeitaiKubun());
            KoikiZenShichosonJoho joikiZenShichosonJoho = new KoikiZenShichosonJoho(entity);
            構成市町村情報リスト.add(joikiZenShichosonJoho);
        }
        return 構成市町村情報リスト;
    }

    private NushiJuminJohoResult set所得照会票パラメタ(List<ShotokuShoukaiDataTempEntity> 所得照会票リスト) {
        NushiJuminJohoResult result = new NushiJuminJohoResult();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 市町村名 = association.get市町村名();
        set所得照会先(result);
        result.set住民税課税年度(parameter.get処理年度());
        result.set発行日(new RDate(parameter.get照会年月日().toString()));
        result.set市町村名(市町村名);
        List<SetaiInn> 世帯員リスト = new ArrayList<>();
        for (ShotokuShoukaiDataTempEntity entity : 所得照会票リスト) {
            result.set生年月日(entity.getSeinengappiYMD());
            if (entity.getJuminJotaiCode().equals(転出者)) {
                result.set転出先住所(entity.getGenjusho());
            } else {
                result.set転入前住所(entity.getZenjusho());
            }
            result.set氏名(entity.getHihokenshaName().getColumnValue());
            result.set世帯コード(entity.getSetaiCode());
            result.set前住所(entity.getZenjusho());
            result.set現住所(entity.getGenjusho());
            result.set住民状態コード(entity.getJuminJotaiCode());
            SetaiInn setaiInn = new SetaiInn();
            setaiInn.set住民状態コード(entity.getJuminJotaiCode());
            // TODO
            setaiInn.set転出日(null);
            setaiInn.set転入異動日(entity.getIdoYMD());
            setaiInn.set識別コード(entity.getShikibetsuCode());
            setaiInn.setカナ氏名(entity.getAtenaKanaShimei().getColumnValue());
            setaiInn.set氏名(entity.getAtenaShimei().getColumnValue());
            setaiInn.set生年月日(entity.getSeinengappiYMD());
            世帯員リスト.add(setaiInn);
            result.set世帯員リスト(世帯員リスト);
        }
        KaigoToiawasesakiManager manager = new KaigoToiawasesakiManager();
        KaigoToiawasesaki 差出人情報 = manager.get介護問合せ先(SubGyomuCode.DBB介護賦課, 帳票ID);
        result.set担当部署名(差出人情報.get部署名());
        result.set担当者名(差出人情報.get担当者名());
        result.set庁舎名(差出人情報.get庁舎名());
        result.set所在地(差出人情報.get所在地());
        result.set内線番号(差出人情報.get内線番号());
        result.set差出人_郵便番号(差出人情報.get郵便番号());
        result.set電話番号(差出人情報.get電話番号());
        return result;
    }

    private void set所得照会先(NushiJuminJohoResult result) {
        ICityAtesakiFinder atesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        LasdecCode 全国住所コード = LasdecCode.EMPTY;
        ShichosonAtesaki atesaki = atesakiFinder.get市町村宛先(全国住所コード, SofusakiGroup.所得照会関連.getCode());
        YubinNo 郵便番号 = YubinNo.EMPTY;
        RString 住所 = RString.EMPTY;
        AtenaBanchi 番地 = AtenaBanchi.EMPTY;
        RString 役所_役場名 = RString.EMPTY;
        RString 役所_役場名の上段 = RString.EMPTY;
        RString 役所_役場名の下段 = RString.EMPTY;
        RString 住所の上段 = RString.EMPTY;
        RString 住所の下段 = RString.EMPTY;
        if (atesaki != null) {
            郵便番号 = atesaki.get郵便番号();
            番地 = atesaki.get番地();
            住所 = atesaki.get住所();
            RString 名称 = atesaki.get名称();
            if (!名称.isNullOrEmpty()) {
                役所_役場名 = editor役所_役場名(名称, 役所_役場名, atesaki);
            }
            if (役所_役場名.length() >= INT_10) {
                役所_役場名の上段 = 役所_役場名.substring(INT_0, INT_9);
                役所_役場名の下段 = 役所_役場名.substring(INT_9, 役所_役場名.length());
            }
            if (役所_役場名.length() <= INT_9) {
                役所_役場名の下段 = 役所_役場名;
            }
        }
        住所 = 住所.concat(RString.FULL_SPACE).concat(番地.value());
        if (住所.length() >= INT_15) {
            住所の上段 = 住所.substring(INT_0, INT_15);
            住所の下段 = 住所.substring(INT_15, 住所.length());
        }
        if (住所.length() <= INT_15) {
            住所の下段 = 住所;
        }
        result.set郵便番号(郵便番号);
        result.set役所_役場名_上段(役所_役場名の上段);
        result.set役所_役場名_下段(役所_役場名の下段);
        result.set住所_上段(住所の上段);
        result.set住所_下段(住所の下段);
    }

    private RString editor役所_役場名(RString 名称, RString 役所_役場名, ShichosonAtesaki atesaki) {
        if (区.equals(名称.substring(名称.length() - INT_1, 名称.length()))
                || 市.equals(名称.substring(名称.length() - INT_1, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役所);
        }
        if (町.equals(名称.substring(名称.length() - INT_1, 名称.length()))
                || 村.equals(名称.substring(名称.length() - INT_1, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役場);
        }
        return 役所_役場名;
    }
}
