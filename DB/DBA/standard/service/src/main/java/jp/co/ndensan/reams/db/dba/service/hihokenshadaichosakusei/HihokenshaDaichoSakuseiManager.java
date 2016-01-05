/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.hihokenshadaichosakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshadaichosakusei.IHihokenshaDaichoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳のクラスです。
 *
 */
public class HihokenshaDaichoSakuseiManager {

    private static final RString TITLE = new RString("介護保険　被保険者台帳");
    private static final RString HIHOKENSHANO_TITLE = new RString("被保険者番号");
    private static final RString SHICHOSONCODE_120 = new RString("120");
    private static final RString SHICHOSONCODE_220 = new RString("220");
    private static final RString SHICHOSONCODE_111 = new RString("111");
    private static final RString SHICHOSONCODE_112 = new RString("112");
    private static final RString SHICHOSONCODE_211 = new RString("211");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_03 = new RString("03");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_05 = new RString("05");
    private static final RString STATE_適用除外者 = new RString("適用除外者");
    private static final RString STATE_他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString STATE_資格取得者 = new RString("資格取得者");
    private static final RString STATE_資格喪失者 = new RString("資格喪失者");
    private static final RString TITLE_介護保険被保険者台帳 = new RString("介護保険被保険者台帳");
    private static final RString NYUSHOSHISETSUSHURUI_11 = new RString("11");
    private static final RString CODESHUBETSU_0117 = new RString("0117");
    private static final RString CODESHUBETSU_0121 = new RString("0121");
    private static final RString CODESHUBETSU_0126 = new RString("0126");
    private static final RString CODESHUBETSU_0002 = new RString("0002");
    private static final RString CODESHUBETSU_0001 = new RString("0001");
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_6 = 6;
    private static final int NOCOUNT_8 = 8;
    private static final int NOCOUNT_10 = 10;
    private static final int NOCOUNT_11 = 11;
    private static final int NOCOUNT_12 = 12;
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");
    private static final RString HOUR = new RString("時");
    private static final RString MINUTE = new RString("分");
    private static final RString SECOND = new RString("秒");
    private static final RString REPLACED_MESSAGE = new RString("parameter");

    private final MapperProvider mapperProvider;
    private final DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac;
    private final DbT7037ShoKofuKaishuDac 証交付回収Dac;
    private final DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac;
    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;

    /**
     * コンストラクタです。
     */
    HihokenshaDaichoSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.老齢福祉年金受給者Dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        this.証交付回収Dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
        this.介護保険医療保険加入状況Dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
        this.構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 被保険者台帳管理Dac 被保険者台帳管理Dac
     * @param 老齢福祉年金受給者Dac 老齢福祉年金受給者Dac
     * @param 証交付回収Dac 証交付回収Dac
     * @param 介護保険医療保険加入状況Dac 介護保険医療保険加入状況Dac
     * @param 構成市町村マスタDac 構成市町村マスタDac
     * @param MapperProvider mapperProvider
     */
    HihokenshaDaichoSakuseiManager(DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
            DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac,
            DbT7037ShoKofuKaishuDac 証交付回収Dac,
            DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac,
            DbT7051KoseiShichosonMasterDac 構成市町村マスタDac,
            MapperProvider mapperProvider) {
        this.老齢福祉年金受給者Dac = 老齢福祉年金受給者Dac;
        this.証交付回収Dac = 証交付回収Dac;
        this.介護保険医療保険加入状況Dac = 介護保険医療保険加入状況Dac;
        this.構成市町村マスタDac = 構成市町村マスタDac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakuseiManager}のインスタンス
     */
    public static HihokenshaDaichoSakuseiManager createInstance() {
        return InstanceProvider.create(HihokenshaDaichoSakuseiManager.class);
    }

    /**
     * 被保険者台帳を返します。
     *
     * @param parameter 被保険者台帳の入力パラメータ
     * @return hihokenshaDaichoSakuseiEntityList 被保険者台帳
     */
    @Transaction
    public List<HihokenshaDaichoSakuseiEntity> getHihokenshaDaichoSakusei(
            HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        List<HihokenshaEntity> hihokenshaList = get被保険者情報(parameter);
        if (hihokenshaList.isEmpty()) {
            return new ArrayList<>();
        }

        return getHihokenshaDaichoHenshu(hihokenshaList);
    }

    private List<HihokenshaEntity> get被保険者情報(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenList = get被保険者台帳管理情報(parameter);
        List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList = get生活保護受給者情報(parameter);
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiList = get老齢福祉年金受給者情報(parameter);
        List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKoList = get証交付回収情報(parameter);
        // TODO 蘇広俊 世帯情報の取得方針不明、QA170提出中
        DbT1008IryohokenKanyuJokyoEntity dbT1008IryohoEntity = get介護保険医療保険加入状況情報(parameter);
        List<HihokenshaEntity> hihokenshaList = new ArrayList<>();
        HihokenshaEntity hihokenshaEntity = new HihokenshaEntity();
        for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenList) {
            hihokenshaEntity.setPrintDate(dateFormat(RDateTime.now()));
            hihokenshaEntity.setPage(RString.EMPTY);
            hihokenshaEntity.setTitle(TITLE);
            ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(
                    GyomuBunrui.介護事務);
            if (new Code(SHICHOSONCODE_120).equals(shichosonSecurityJoho.get導入形態コード())
                    || new Code(SHICHOSONCODE_220).equals(shichosonSecurityJoho.get導入形態コード())) {
                hihokenshaEntity.setShichosonCode(entity.getShichosonCode());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                hihokenshaEntity.setShichosonMeisho(association.get市町村名());
            }
            if (new Code(SHICHOSONCODE_111).equals(shichosonSecurityJoho.get導入形態コード())
                    || new Code(SHICHOSONCODE_112).equals(shichosonSecurityJoho.get導入形態コード())
                    || new Code(SHICHOSONCODE_211).equals(shichosonSecurityJoho.get導入形態コード())) {
                List<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiEntityList
                        = 構成市町村マスタDac.selectByshichosonCode(entity.getShichosonCode());
                hihokenshaEntity.setShichosonMeisho(dbT7051KoseiEntityList.get(0).getShichosonMeisho());
            }
            hihokenshaEntity.setHihokenshaNoTitle(HIHOKENSHANO_TITLE);
            hihokenshaEntity.setHihokenshaNo(entity.getHihokenshaNo());
            if (SHIKAKUSOSHITSUJIYUCODE_03.equals(entity.getShikakuSoshitsuJiyuCode())) {
                hihokenshaEntity.setState(STATE_適用除外者);
            } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(entity.getShikakuSoshitsuJiyuCode())) {
                hihokenshaEntity.setState(STATE_他市町村住所地特例者);
            } else if (RString.isNullOrEmpty(RString.EMPTY)) {
                hihokenshaEntity.setState(STATE_資格取得者);
            } else {
                hihokenshaEntity.setState(STATE_資格喪失者);
            }
            UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
                    UaFt200FindShikibetsuTaishoFunctionDac.class);
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                    ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(SubGyomuCode.DBA介護資格.getGyomuCode(),
                            KensakuYusenKubun.住登外優先));
            IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
            List<JuminShubetsu> 住民種別 = new ArrayList<>();
            List<JuminJotai> 住民状態 = new ArrayList<>();
            住民種別.add(JuminShubetsu.住登外個人_外国人);
            住民種別.add(JuminShubetsu.住登外個人_日本人);
            住民種別.add(JuminShubetsu.日本人);
            住民種別.add(JuminShubetsu.外国人);
            住民状態.add(JuminJotai.住民);
            住民状態.add(JuminJotai.住登外);
            住民状態.add(JuminJotai.消除者);
            住民状態.add(JuminJotai.転出者);
            住民状態.add(JuminJotai.死亡者);
            key.set住民種別(住民種別);
            key.set住民状態(住民状態);
            List<UaFt200FindShikibetsuTaishoEntity> entitylist = dac.select(psm);
            for (UaFt200FindShikibetsuTaishoEntity uaFt200entity : entitylist) {
                IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(uaFt200entity);
                hihokenshaEntity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
                hihokenshaEntity.setMeisho(shikibetsuTaisho.get名称().getName());
                hihokenshaEntity.setSeinengappiYMD(shikibetsuTaisho.to個人().get生年月日().toFlexibleDate());
                hihokenshaEntity.setSeibetsuCode(shikibetsuTaisho.to個人().get性別().getCode());
                hihokenshaEntity.setSetaiCode(shikibetsuTaisho.to個人().get世帯コード());
                hihokenshaEntity.setShikibetsuCode(shikibetsuTaisho.to個人().get識別コード());
                hihokenshaEntity.setChikucodeTitle1(shikibetsuTaisho.to個人().get行政区画().getChiku1().get名称());
                hihokenshaEntity.setChikuCode1(shikibetsuTaisho.to個人().get行政区画().getChiku1().getコード());
                hihokenshaEntity.setChikucodeTitle2(shikibetsuTaisho.to個人().get行政区画().getChiku2().get名称());
                hihokenshaEntity.setChikuCode2(shikibetsuTaisho.to個人().get行政区画().getChiku2().getコード());
                hihokenshaEntity.setChikucodeTitle3(shikibetsuTaisho.to個人().get行政区画().getChiku3().get名称());
                hihokenshaEntity.setChikuCode3(shikibetsuTaisho.to個人().get行政区画().getChiku3().getコード());
                hihokenshaEntity.setJushoTitle(JUSHO_TITLE);
                hihokenshaEntity.setJusho(new RString(shikibetsuTaisho.get住所().toString()));
                hihokenshaEntity.setZenkokuJushoCode(shikibetsuTaisho.to個人().get住所().get全国住所コード());
                hihokenshaEntity.setGyoseikuTitle(GYOSEIKU_TITLE);
                hihokenshaEntity.setGyoseikuCode(shikibetsuTaisho.to個人().get行政区画().getGyoseiku().getコード());
                // TODO 蘇広俊 電話番号１取得方針不明、QA207提出中
            }
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = get入所施設(parameter);
            for (ShisetsuNyutaishoEntity shisetsuNyutaishoentity : shisetsuNyutaishoList) {
                hihokenshaEntity.setJigyoshaNo(shisetsuNyutaishoentity.getJigyoshaNo());
                hihokenshaEntity.setJigyoshaMeisho(new AtenaMeisho(shisetsuNyutaishoentity
                        .getJigyoshaMeisho().toString()));
            }
            if (dbT1008IryohoEntity.getIryoHokenShubetsuCode() != null) {
                hihokenshaEntity.setIryoHokenShubetsu(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(CODESHUBETSU_0001),
                        new Code(dbT1008IryohoEntity.getIryoHokenShubetsuCode())));
            }
            hihokenshaEntity.setIryoHokenshaMeisho(dbT1008IryohoEntity.getIryoHokenshaMeisho());
            hihokenshaEntity.setIryoHokenKigoNo(dbT1008IryohoEntity.getIryoHokenKigoNo());
            hihokenshaEntity.setOrderNo(RString.EMPTY);
            hihokenshaEntity.setDbT1001HihokenshaDaichoEntityList(dbT1001HihokenList);
            hihokenshaEntity.setShisetsuNyutaishoEntityList(shisetsuNyutaishoEntityList);
            hihokenshaEntity.setDbT7006RoreiFukushiNenkinJukyushaEntityList(dbT7006RoreiList);
            hihokenshaEntity.setDbT7037ShoKofuKaishuEntityList(dbT7037ShoKoList);
            hihokenshaList.add(hihokenshaEntity);
        }

        return hihokenshaList;
    }

    /**
     * 被保険者台帳を編集します。
     *
     * @param hihokenshaList 被保険者情報
     * @return hihokenshaDaichoSakuseiEntityList 被保険者台帳
     */
    @Transaction
    public List<HihokenshaDaichoSakuseiEntity> getHihokenshaDaichoHenshu(List<HihokenshaEntity> hihokenshaList
    ) {
        requireNonNull(hihokenshaList, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaList"));
        List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = get被保険者台帳(hihokenshaList);
        if (hihokenshaDaichoSakuseiEntityList.isEmpty()) {
            return new ArrayList<>();
        }

        return hihokenshaDaichoSakuseiEntityList;
    }

    private List<HihokenshaDaichoSakuseiEntity> get被保険者台帳(List<HihokenshaEntity> hihokenshaList) {
        requireNonNull(hihokenshaList, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaList"));
        List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = new ArrayList<>();
        for (int i = 0; i < hihokenshaList.size(); i++) {
            List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = get分割した被保険者台帳管理リスト(
                    hihokenshaList.get(i).getDbT1001HihokenshaDaichoEntityList());
            List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List
                    = get分割した老齢福祉年金受給者リスト(
                            hihokenshaList.get(i).getDbT7006RoreiFukushiNenkinJukyushaEntityList());
            List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List = get分割した証交付回収リスト(
                    hihokenshaList.get(i).getDbT7037ShoKofuKaishuEntityList());
            List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List = get分割した生活保護受給者リスト(
                    hihokenshaList.get(i).getShisetsuNyutaishoEntityList());
            // TODO 蘇広俊 世帯情報取得方針不明、QA170提出中
            List 分割した世帯情報List = get分割した世帯情報リスト(分割した証交付回収List);

            int maxCount = getMaxList件数(分割した被保険者台帳管理List, 分割した老齢福祉年金受給者List,
                    分割した証交付回収List, 分割した生活保護受給者List, 分割した世帯情報List);
            for (int j = 0; j < maxCount; j++) {
                HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity = new HihokenshaDaichoSakuseiEntity();
                hihokenshaDaichoSakuseiEntity.setPrintDate(dateFormat日時(hihokenshaList.get(j).getPrintDate()));
                hihokenshaDaichoSakuseiEntity.setPage(new RString(String.valueOf(i)));
                hihokenshaDaichoSakuseiEntity.setTitle(TITLE_介護保険被保険者台帳);
                hihokenshaDaichoSakuseiEntity.setShichosonCode(hihokenshaList.get(j).getShichosonCode());
                hihokenshaDaichoSakuseiEntity.setShichosonMeisho(hihokenshaList.get(j).getShichosonMeisho());
                hihokenshaDaichoSakuseiEntity.setHihokenshaNoTitle(hihokenshaList.get(j).getHihokenshaNoTitle());
                hihokenshaDaichoSakuseiEntity.setHihokenshaNo(hihokenshaList.get(j).getHihokenshaNo());
                hihokenshaDaichoSakuseiEntity.setKanaMeisho(hihokenshaList.get(j).getKanaMeisho());
                hihokenshaDaichoSakuseiEntity.setMeisho(hihokenshaList.get(j).getMeisho());
                hihokenshaDaichoSakuseiEntity.setSeinengappiYMD(
                        flexRString(hihokenshaList.get(j).getSeinengappiYMD()));
                hihokenshaDaichoSakuseiEntity.setSeibetsuCode(hihokenshaList.get(j).getSeibetsuCode());
                hihokenshaDaichoSakuseiEntity.setSetaiCode(hihokenshaList.get(j).getSetaiCode());
                hihokenshaDaichoSakuseiEntity.setShikibetsuCode(hihokenshaList.get(j).getShikibetsuCode());
                hihokenshaDaichoSakuseiEntity.setChikucodeTitle1(hihokenshaList.get(j).getChikucodeTitle1());
                hihokenshaDaichoSakuseiEntity.setChikuCode1(hihokenshaList.get(j).getChikuCode1());
                hihokenshaDaichoSakuseiEntity.setChikucodeTitle2(hihokenshaList.get(j).getChikucodeTitle2());
                hihokenshaDaichoSakuseiEntity.setChikuCode2(hihokenshaList.get(j).getChikuCode2());
                hihokenshaDaichoSakuseiEntity.setChikucodeTitle3(hihokenshaList.get(j).getChikucodeTitle3());
                hihokenshaDaichoSakuseiEntity.setChikuCode3(hihokenshaList.get(j).getChikuCode3());
                hihokenshaDaichoSakuseiEntity.setJushoTitle(hihokenshaList.get(j).getJushoTitle());
                hihokenshaDaichoSakuseiEntity.setJusho(hihokenshaList.get(j).getJusho());
                hihokenshaDaichoSakuseiEntity.setZenkokuJushoCode(hihokenshaList.get(j).getZenkokuJushoCode());
                hihokenshaDaichoSakuseiEntity.setGyoseikuTitle(hihokenshaList.get(j).getGyoseikuTitle());
                hihokenshaDaichoSakuseiEntity.setGyoseikuCode(hihokenshaList.get(j).getGyoseikuCode());
                // TODO 蘇広俊 電話番号１取得方針不明、QA207提出中
                hihokenshaDaichoSakuseiEntity.setTelephoneNo2(RString.EMPTY);
                hihokenshaDaichoSakuseiEntity.setState(hihokenshaList.get(j).getState());
                hihokenshaDaichoSakuseiEntity.setJigyoshaNo(hihokenshaList.get(j).getJigyoshaNo());
                hihokenshaDaichoSakuseiEntity.setJigyoshaMeisho(hihokenshaList.get(j).getJigyoshaMeisho());
                hihokenshaDaichoSakuseiEntity.setIryoHokenShubetsu(hihokenshaList.get(j).getIryoHokenShubetsu());
                hihokenshaDaichoSakuseiEntity.setIryoHokenshaMeisho(hihokenshaList.get(j).getIryoHokenshaMeisho());
                hihokenshaDaichoSakuseiEntity.setIryoHokenKigoNo(hihokenshaList.get(j).getIryoHokenKigoNo());
                hihokenshaDaichoSakuseiEntity.setOrderNo(hihokenshaList.get(j).getOrderNo());
                if (!分割した被保険者台帳管理List.isEmpty() && 分割した被保険者台帳管理List.get(j) != null) {
                    set資格異動情報(hihokenshaDaichoSakuseiEntity, 分割した被保険者台帳管理List.get(j));
                } else {
                    setEmptiy資格異動情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_5);
                }
                if (!分割した生活保護受給者List.isEmpty() && 分割した生活保護受給者List.get(j) != null) {
                    set生活保護受給者情報(hihokenshaDaichoSakuseiEntity, 分割した生活保護受給者List.get(j));
                } else {
                    setEmptiy生活保護受給者情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_3);
                }
                if (!分割した老齢福祉年金受給者List.isEmpty() && 分割した老齢福祉年金受給者List.get(j) != null) {
                    set老齢福祉年金受給者情報(hihokenshaDaichoSakuseiEntity, 分割した老齢福祉年金受給者List.get(j));
                } else {
                    setEmptiy老齢福祉年金受給者情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_3);
                }
                if (!分割した証交付回収List.isEmpty() && 分割した証交付回収List.get(j) != null) {
                    set被保険者証発行履歴情報(hihokenshaDaichoSakuseiEntity, 分割した証交付回収List.get(j));
                } else {
                    setEmptiy被保険者証発行履歴情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_10);
                }

                hihokenshaDaichoSakuseiEntityList.add(hihokenshaDaichoSakuseiEntity);
            }
        }
        return hihokenshaDaichoSakuseiEntityList;
    }

    private void set資格異動情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            HihokenshaDaichoDivisionEntity hihokenshaDaichoDivisionEntity) {
        requireNonNull(hihokenshaDaichoDivisionEntity, UrSystemErrorMessages.値がnull
                .getReplacedMessage("hihokenshaDaichoDivisionEntity"));
        HihokenshaDaichoDivisionEntity 資格異動情報Entity = new HihokenshaDaichoDivisionEntity();
        資格異動情報Entity.set資格異動No(hihokenshaDaichoDivisionEntity.get資格異動No());
        資格異動情報Entity.set取得日(hihokenshaDaichoDivisionEntity.get取得日());
        資格異動情報Entity.set取得事由コード(hihokenshaDaichoDivisionEntity.get取得事由コード());
        資格異動情報Entity.set取得事由名称(hihokenshaDaichoDivisionEntity.get取得事由名称());
        資格異動情報Entity.set一号取得日(hihokenshaDaichoDivisionEntity.get一号取得日());
        資格異動情報Entity.set喪失日(hihokenshaDaichoDivisionEntity.get喪失日());
        資格異動情報Entity.set喪失事由コード(hihokenshaDaichoDivisionEntity.get喪失事由コード());
        資格異動情報Entity.set喪失事由名称(hihokenshaDaichoDivisionEntity.get喪失事由名称());
        資格異動情報Entity.set資格区分(hihokenshaDaichoDivisionEntity.get資格区分());
        資格異動情報Entity.set一号取得日(hihokenshaDaichoDivisionEntity.get一号取得日());
        資格異動情報Entity.set変更日(hihokenshaDaichoDivisionEntity.get変更日());
        資格異動情報Entity.set変更事由コード(hihokenshaDaichoDivisionEntity.get変更事由コード());
        資格異動情報Entity.set変更事由名称(hihokenshaDaichoDivisionEntity.get変更事由名称());
        資格異動情報Entity.set住特適用日(hihokenshaDaichoDivisionEntity.get住特適用日());
        資格異動情報Entity.set住特適用日(hihokenshaDaichoDivisionEntity.get住特解除日());
        資格異動情報Entity.set措置保険者(hihokenshaDaichoDivisionEntity.get措置保険者());
        資格異動情報Entity.set旧保険者(hihokenshaDaichoDivisionEntity.get旧保険者());
        hihokenshaDaichoSakuseiEntity.set資格異動情報Entity(資格異動情報Entity);
    }

    private void setEmptiy資格異動情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            int 一ページのレコード) {
        HihokenshaDaichoDivisionEntity 資格異動情報Entity = new HihokenshaDaichoDivisionEntity();
        List<RString> 資格異動No = new ArrayList<>();
        List<RString> 取得日 = new ArrayList<>();
        List<RString> 取得事由コード = new ArrayList<>();
        List<RString> 取得事由名称 = new ArrayList<>();
        List<RString> 一号取得日 = new ArrayList<>();
        List<RString> 喪失日 = new ArrayList<>();
        List<RString> 喪失事由コード = new ArrayList<>();
        List<RString> 喪失事由名称 = new ArrayList<>();
        List<RString> 資格区分 = new ArrayList<>();
        List<RString> 変更日 = new ArrayList<>();
        List<RString> 変更事由コード = new ArrayList<>();
        List<RString> 変更事由名称 = new ArrayList<>();
        List<RString> 住特適用日 = new ArrayList<>();
        List<RString> 住特解除日 = new ArrayList<>();
        List<LasdecCode> 措置保険者 = new ArrayList<>();
        List<LasdecCode> 旧保険者 = new ArrayList<>();
        for (int i = 0; i < 一ページのレコード; i++) {
            資格異動No.add(RString.EMPTY);
            取得日.add(RString.EMPTY);
            取得事由コード.add(RString.EMPTY);
            取得事由名称.add(RString.EMPTY);
            一号取得日.add(RString.EMPTY);
            喪失日.add(RString.EMPTY);
            喪失事由コード.add(RString.EMPTY);
            喪失事由名称.add(RString.EMPTY);
            資格区分.add(RString.EMPTY);
            変更日.add(RString.EMPTY);
            変更事由コード.add(RString.EMPTY);
            変更事由名称.add(RString.EMPTY);
            住特適用日.add(RString.EMPTY);
            住特解除日.add(RString.EMPTY);
            措置保険者.add(LasdecCode.EMPTY);
            旧保険者.add(LasdecCode.EMPTY);
        }
        資格異動情報Entity.set資格異動No(資格異動No);
        資格異動情報Entity.set取得日(取得日);
        資格異動情報Entity.set取得事由コード(取得事由コード);
        資格異動情報Entity.set取得事由名称(取得事由名称);
        資格異動情報Entity.set一号取得日(一号取得日);
        資格異動情報Entity.set喪失日(喪失日);
        資格異動情報Entity.set喪失事由コード(喪失事由コード);
        資格異動情報Entity.set喪失事由名称(喪失事由名称);
        資格異動情報Entity.set資格区分(資格区分);
        資格異動情報Entity.set変更日(変更日);
        資格異動情報Entity.set変更事由コード(変更事由コード);
        資格異動情報Entity.set変更事由名称(変更事由名称);
        資格異動情報Entity.set住特適用日(住特適用日);
        資格異動情報Entity.set住特解除日(住特解除日);
        資格異動情報Entity.set措置保険者(措置保険者);
        資格異動情報Entity.set旧保険者(旧保険者);
        hihokenshaDaichoSakuseiEntity.set資格異動情報Entity(資格異動情報Entity);
    }

    private void set生活保護受給者情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            SeikatsuHogoJukyushaDivisionEntity seikatsuHogoJukyushaDivisionEntity) {
        requireNonNull(seikatsuHogoJukyushaDivisionEntity, UrSystemErrorMessages.値がnull
                .getReplacedMessage("seikatsuHogoJukyushaDivisionEntity"));
        SeikatsuHogoJukyushaDivisionEntity 生活保護情報Entity = new SeikatsuHogoJukyushaDivisionEntity();
        生活保護情報Entity.set全額停止終了日(seikatsuHogoJukyushaDivisionEntity.get全額停止終了日());
        生活保護情報Entity.set全額停止開始日(seikatsuHogoJukyushaDivisionEntity.get全額停止開始日());
        生活保護情報Entity.set受給廃止日(seikatsuHogoJukyushaDivisionEntity.get受給廃止日());
        生活保護情報Entity.set受給開始日(seikatsuHogoJukyushaDivisionEntity.get受給開始日());
        生活保護情報Entity.set扶助種類(seikatsuHogoJukyushaDivisionEntity.get扶助種類());
        生活保護情報Entity.set生活保護No(seikatsuHogoJukyushaDivisionEntity.get生活保護No());
        hihokenshaDaichoSakuseiEntity.set生活保護情報Entity(生活保護情報Entity);
    }

    private void setEmptiy生活保護受給者情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            int 一ページのレコード) {
        SeikatsuHogoJukyushaDivisionEntity 生活保護情報Entity = new SeikatsuHogoJukyushaDivisionEntity();
        List<RString> 生活保護No = new ArrayList<>();
        List<FlexibleDate> 受給開始日 = new ArrayList<>();
        List<FlexibleDate> 受給廃止日 = new ArrayList<>();
        List<FlexibleDate> 全額停止開始日 = new ArrayList<>();
        List<FlexibleDate> 全額停止終了日 = new ArrayList<>();
        List<RString> 扶助種類 = new ArrayList<>();
        for (int i = 0; i < 一ページのレコード; i++) {
            生活保護No.add(RString.EMPTY);
            受給開始日.add(FlexibleDate.EMPTY);
            受給廃止日.add(FlexibleDate.EMPTY);
            全額停止開始日.add(FlexibleDate.EMPTY);
            全額停止終了日.add(FlexibleDate.EMPTY);
            扶助種類.add(RString.EMPTY);
        }
        生活保護情報Entity.set生活保護No(生活保護No);
        生活保護情報Entity.set受給開始日(受給開始日);
        生活保護情報Entity.set受給廃止日(受給廃止日);
        生活保護情報Entity.set全額停止開始日(全額停止開始日);
        生活保護情報Entity.set全額停止終了日(全額停止終了日);
        生活保護情報Entity.set扶助種類(扶助種類);
        hihokenshaDaichoSakuseiEntity.set生活保護情報Entity(生活保護情報Entity);
    }

    private void set老齢福祉年金受給者情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            RoreiFukushiNenkinJukyushaDivisionEntity roreiFukushiNenkinJukyushaDivisionEntity) {
        requireNonNull(roreiFukushiNenkinJukyushaDivisionEntity, UrSystemErrorMessages.値がnull
                .getReplacedMessage("roreiFukushiNenkinJukyushaDivisionEntity"));
        RoreiFukushiNenkinJukyushaDivisionEntity 老齢福祉年金受給者Entity
                = new RoreiFukushiNenkinJukyushaDivisionEntity();
        老齢福祉年金受給者Entity.set老齢福祉No(roreiFukushiNenkinJukyushaDivisionEntity.get老齢福祉No());
        老齢福祉年金受給者Entity.set老齢福祉受給終了日(roreiFukushiNenkinJukyushaDivisionEntity.get老齢福祉受給終了日());
        老齢福祉年金受給者Entity.set老齢福祉受給開始日(roreiFukushiNenkinJukyushaDivisionEntity.get老齢福祉受給開始日());
        hihokenshaDaichoSakuseiEntity.set老齢福祉情報Entity(老齢福祉年金受給者Entity);
    }

    private void setEmptiy老齢福祉年金受給者情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            int 一ページのレコード) {
        RoreiFukushiNenkinJukyushaDivisionEntity 老齢福祉年金受給者Entity
                = new RoreiFukushiNenkinJukyushaDivisionEntity();
        List<RString> 老齢福祉No = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給開始日 = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給終了日 = new ArrayList<>();
        for (int i = 0; i < 一ページのレコード; i++) {
            老齢福祉No.add(RString.EMPTY);
            老齢福祉受給開始日.add(FlexibleDate.EMPTY);
            老齢福祉受給終了日.add(FlexibleDate.EMPTY);
        }
        老齢福祉年金受給者Entity.set老齢福祉No(老齢福祉No);
        老齢福祉年金受給者Entity.set老齢福祉受給開始日(老齢福祉受給開始日);
        老齢福祉年金受給者Entity.set老齢福祉受給終了日(老齢福祉受給終了日);
        hihokenshaDaichoSakuseiEntity.set老齢福祉情報Entity(老齢福祉年金受給者Entity);
    }

    private void set被保険者証発行履歴情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            ShoKofuKaishuDivisionEntity shoKofuKaishuDivisionEntity) {
        requireNonNull(shoKofuKaishuDivisionEntity, UrSystemErrorMessages.値がnull.
                getReplacedMessage("shoKofuKaishuDivisionEntity"));
        ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報１ = new ShoKofuKaishuDivisionSumEntity();
        ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報２ = new ShoKofuKaishuDivisionSumEntity();
        List<RString> 証履歴No1 = new ArrayList<>();
        List<FlexibleDate> 証履歴発行日1 = new ArrayList<>();
        List<RString> 証履歴事由名称1 = new ArrayList<>();
        List<FlexibleDate> 証履歴回収日1 = new ArrayList<>();
        List<RString> 証履歴No2 = new ArrayList<>();
        List<FlexibleDate> 証履歴発行日2 = new ArrayList<>();
        List<RString> 証履歴事由名称2 = new ArrayList<>();
        List<FlexibleDate> 証履歴回収日2 = new ArrayList<>();
        for (int i = 0; i < shoKofuKaishuDivisionEntity.get証履歴No().size(); i++) {
            if (i < NOCOUNT_5) {
                証履歴No1.add(shoKofuKaishuDivisionEntity.get証履歴No().get(i));
                証履歴発行日1.add(shoKofuKaishuDivisionEntity.get証履歴発行日().get(i));
                証履歴事由名称1.add(shoKofuKaishuDivisionEntity.get証履歴事由名称().get(i));
                証履歴回収日1.add(shoKofuKaishuDivisionEntity.get証履歴回収日().get(i));
                continue;
            }
            if (i >= NOCOUNT_5 && i < NOCOUNT_10) {
                証履歴No2.add(shoKofuKaishuDivisionEntity.get証履歴No().get(i));
                証履歴発行日2.add(shoKofuKaishuDivisionEntity.get証履歴発行日().get(i));
                証履歴事由名称2.add(shoKofuKaishuDivisionEntity.get証履歴事由名称().get(i));
                証履歴回収日2.add(shoKofuKaishuDivisionEntity.get証履歴回収日().get(i));
            }
        }
        被保険者証発行履歴情報１.set証履歴No1(証履歴No1);
        被保険者証発行履歴情報１.set証履歴事由名称1(証履歴事由名称1);
        被保険者証発行履歴情報１.set証履歴回収日1(証履歴回収日1);
        被保険者証発行履歴情報１.set証履歴発行日1(証履歴発行日1);
        被保険者証発行履歴情報２.set証履歴No2(証履歴No2);
        被保険者証発行履歴情報２.set証履歴事由名称2(証履歴事由名称2);
        被保険者証発行履歴情報２.set証履歴回収日2(証履歴回収日2);
        被保険者証発行履歴情報２.set証履歴発行日2(証履歴発行日2);
        hihokenshaDaichoSakuseiEntity.set被保険者証発行履歴情報１(被保険者証発行履歴情報１);
        hihokenshaDaichoSakuseiEntity.set被保険者証発行履歴情報２(被保険者証発行履歴情報２);
    }

    private void setEmptiy被保険者証発行履歴情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            int 一ページのレコード) {
        ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報１ = new ShoKofuKaishuDivisionSumEntity();
        ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報２ = new ShoKofuKaishuDivisionSumEntity();
        List<RString> 証履歴No1 = new ArrayList<>();
        List<FlexibleDate> 証履歴発行日1 = new ArrayList<>();
        List<RString> 証履歴事由名称1 = new ArrayList<>();
        List<FlexibleDate> 証履歴回収日1 = new ArrayList<>();
        List<RString> 証履歴No2 = new ArrayList<>();
        List<FlexibleDate> 証履歴発行日2 = new ArrayList<>();
        List<RString> 証履歴事由名称2 = new ArrayList<>();
        List<FlexibleDate> 証履歴回収日2 = new ArrayList<>();
        for (int i = 0; i < 一ページのレコード; i++) {
            if (i < NOCOUNT_5) {
                証履歴No1.add(RString.EMPTY);
                証履歴発行日1.add(FlexibleDate.EMPTY);
                証履歴事由名称1.add(RString.EMPTY);
                証履歴回収日1.add(FlexibleDate.EMPTY);
                continue;
            }
            if (i >= NOCOUNT_5 && i < 一ページのレコード) {
                証履歴No2.add(RString.EMPTY);
                証履歴発行日2.add(FlexibleDate.EMPTY);
                証履歴事由名称2.add(RString.EMPTY);
                証履歴回収日2.add(FlexibleDate.EMPTY);
            }
        }
        被保険者証発行履歴情報１.set証履歴No1(証履歴No1);
        被保険者証発行履歴情報１.set証履歴事由名称1(証履歴事由名称1);
        被保険者証発行履歴情報１.set証履歴回収日1(証履歴回収日1);
        被保険者証発行履歴情報１.set証履歴発行日1(証履歴発行日1);
        被保険者証発行履歴情報２.set証履歴No2(証履歴No2);
        被保険者証発行履歴情報２.set証履歴事由名称2(証履歴事由名称2);
        被保険者証発行履歴情報２.set証履歴回収日2(証履歴回収日2);
        被保険者証発行履歴情報２.set証履歴発行日2(証履歴発行日2);
        hihokenshaDaichoSakuseiEntity.set被保険者証発行履歴情報１(被保険者証発行履歴情報１);
        hihokenshaDaichoSakuseiEntity.set被保険者証発行履歴情報２(被保険者証発行履歴情報２);
    }

    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳管理情報(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
        List<DbT1001HihokenshaDaichoEntity> entityList = mapper.getHihokenshaDaicho(parameter);
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }

        return entityList;
    }

    private List<ShisetsuNyutaishoEntity> get生活保護受給者情報(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
        List<ShisetsuNyutaishoEntity> entityList = mapper.getSeikatsuHogoJukyusha(parameter);
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }

        return entityList;
    }

    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者情報(
            HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = 老齢福祉年金受給者Dac.selectByShikibetsuCode(
                parameter.getShikibetsuCode());
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }

        return entityList;
    }

    private List<DbT7037ShoKofuKaishuEntity> get証交付回収情報(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        ITrueFalseCriteria makeShuruiConditions;
        if (parameter.getHihokenshaNo() == null || parameter.getHihokenshaNo().isEmpty()) {
            makeShuruiConditions = and(
                    eq(DbT7037ShoKofuKaishu.logicalDeletedFlag, false),
                    eq(parameter.getShikibetsuCode(), DbT7037ShoKofuKaishu.shikibetsuCode));
        } else {
            makeShuruiConditions = and(
                    eq(DbT7037ShoKofuKaishu.logicalDeletedFlag, false),
                    eq(DbT7037ShoKofuKaishu.hihokenshaNo, parameter.getHihokenshaNo()));
        }
        List<DbT7037ShoKofuKaishuEntity> entityList = 証交付回収Dac.select(makeShuruiConditions);
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }

        return entityList;
    }

    private DbT1008IryohokenKanyuJokyoEntity get介護保険医療保険加入状況情報(
            HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        DbT1008IryohokenKanyuJokyoEntity entity = 介護保険医療保険加入状況Dac.selectByShikibetsuCode(
                parameter.getShikibetsuCode());
        if (entity == null) {
            return new DbT1008IryohokenKanyuJokyoEntity();
        }

        return entity;
    }

    private List<ShisetsuNyutaishoEntity> get入所施設(HihokenshaDaichoSakuseiParameter parameter) {
        List<ShisetsuNyutaishoEntity> 入所施設List = new ArrayList<>();
        ShisetsuNyutaishoEntity entity = new ShisetsuNyutaishoEntity();
        IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
        List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList = mapper.getShisetsuNyutaisho(parameter);
        for (int i = 0; i < shisetsuNyutaishoEntityList.size(); i++) {
            if (shisetsuNyutaishoEntityList.get(i).getNyushoShisetsuShurui() != NYUSHOSHISETSUSHURUI_11) {
                entity.setJigyoshaNo(shisetsuNyutaishoEntityList.get(i).getJigyoshaNo());
                entity.setJigyoshaMeisho(shisetsuNyutaishoEntityList.get(i).getJigyoshaMeisho());
                入所施設List.add(entity);
                entity = new ShisetsuNyutaishoEntity();
            } else {
                DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = mapper.getKaigoJigyosha(parameter);
                entity.setJigyoshaNo(new RString(dbT7060KaigoJigyoshaEntity.getJigyoshaNo().toString()));
                entity.setJigyoshaMeisho(new RString(dbT7060KaigoJigyoshaEntity.getJigyoshaName().toString()));
                入所施設List.add(entity);
                entity = new ShisetsuNyutaishoEntity();
            }
        }

        return 入所施設List;
    }

    private List<HihokenshaDaichoDivisionEntity> get分割した被保険者台帳管理リスト(
            List<DbT1001HihokenshaDaichoEntity> entityList) {
        requireNonNull(entityList, UrSystemErrorMessages.値がnull.getReplacedMessage("entityList"));
        List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = new ArrayList<>();
        HihokenshaDaichoDivisionEntity hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
        int nocount = 0;
        List<RString> 資格異動No = new ArrayList<>();
        List<RString> 取得日 = new ArrayList<>();
        List<RString> 取得事由コード = new ArrayList<>();
        List<RString> 取得事由名称 = new ArrayList<>();
        List<RString> 一号取得日 = new ArrayList<>();
        List<RString> 喪失日 = new ArrayList<>();
        List<RString> 喪失事由コード = new ArrayList<>();
        List<RString> 喪失事由名称 = new ArrayList<>();
        List<RString> 資格区分 = new ArrayList<>();
        List<RString> 変更日 = new ArrayList<>();
        List<RString> 変更事由コード = new ArrayList<>();
        List<RString> 変更事由名称 = new ArrayList<>();
        List<RString> 住特適用日 = new ArrayList<>();
        List<RString> 住特解除日 = new ArrayList<>();
        List<LasdecCode> 措置保険者 = new ArrayList<>();
        List<LasdecCode> 旧保険者 = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            資格異動No.add(new RString(String.valueOf(nocount + 1)));
            取得日.add(flexRString(entity.getShikakuShutokuYMD()));
            取得事由コード.add(entity.getShikakuShutokuJiyuCode());
            if (entity.getShikakuShutokuJiyuCode() != null) {
                取得事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                        new CodeShubetsu(CODESHUBETSU_0117), new Code(entity.getShikakuShutokuJiyuCode())));
            } else {
                取得事由名称.add(RString.EMPTY);
            }
            一号取得日.add(flexRString(entity.getIchigoShikakuShutokuYMD()));
            喪失日.add(flexRString(entity.getShikakuSoshitsuYMD()));
            喪失事由コード.add(entity.getShikakuSoshitsuJiyuCode());
            if (entity.getShikakuSoshitsuJiyuCode() != null) {
                喪失事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                        new CodeShubetsu(CODESHUBETSU_0121), new Code(entity.getShikakuSoshitsuJiyuCode())));
            } else {
                喪失事由名称.add(RString.EMPTY);
            }
            資格区分.add(entity.getHihokennshaKubunCode());
            変更日.add(flexRString(entity.getShikakuHenkoYMD()));
            変更事由コード.add(entity.getShikakuHenkoJiyuCode());
            if (entity.getShikakuHenkoJiyuCode() != null) {
                変更事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                        new CodeShubetsu(CODESHUBETSU_0126), new Code(entity.getShikakuHenkoJiyuCode())));
            } else {
                変更事由名称.add(RString.EMPTY);
            }
            住特適用日.add(flexRString(entity.getJushochitokureiTekiyoYMD()));
            住特解除日.add(flexRString(entity.getJushochitokureiKaijoYMD()));
            措置保険者.add(entity.getKoikinaiTokureiSochimotoShichosonCode());
            旧保険者.add(entity.getKyuShichosonCode());
            if ((nocount + 1) % NOCOUNT_5 == 0) {
                hihokenshaDaichoDivisionEntity.set資格異動No(資格異動No);
                hihokenshaDaichoDivisionEntity.set取得日(取得日);
                hihokenshaDaichoDivisionEntity.set取得事由コード(取得事由コード);
                hihokenshaDaichoDivisionEntity.set取得事由名称(取得事由名称);
                hihokenshaDaichoDivisionEntity.set一号取得日(一号取得日);
                hihokenshaDaichoDivisionEntity.set喪失日(喪失日);
                hihokenshaDaichoDivisionEntity.set喪失事由コード(喪失事由コード);
                hihokenshaDaichoDivisionEntity.set喪失事由名称(喪失事由名称);
                hihokenshaDaichoDivisionEntity.set資格区分(資格区分);
                hihokenshaDaichoDivisionEntity.set変更日(変更日);
                hihokenshaDaichoDivisionEntity.set変更事由コード(変更事由コード);
                hihokenshaDaichoDivisionEntity.set変更事由名称(変更事由名称);
                hihokenshaDaichoDivisionEntity.set住特適用日(住特適用日);
                hihokenshaDaichoDivisionEntity.set住特解除日(住特解除日);
                hihokenshaDaichoDivisionEntity.set措置保険者(措置保険者);
                hihokenshaDaichoDivisionEntity.set旧保険者(旧保険者);
                分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
                資格異動No.clear();
                取得日.clear();
                取得事由コード.clear();
                取得事由名称.clear();
                一号取得日.clear();
                喪失日.clear();
                喪失事由コード.clear();
                喪失事由名称.clear();
                資格区分.clear();
                変更日.clear();
                変更事由コード.clear();
                変更事由名称.clear();
                住特適用日.clear();
                住特解除日.clear();
                措置保険者.clear();
                旧保険者.clear();
                hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_5 < (nocount + 1)) {
                hihokenshaDaichoDivisionEntity.set資格異動No(資格異動No);
                hihokenshaDaichoDivisionEntity.set取得日(取得日);
                hihokenshaDaichoDivisionEntity.set取得事由コード(取得事由コード);
                hihokenshaDaichoDivisionEntity.set取得事由名称(取得事由名称);
                hihokenshaDaichoDivisionEntity.set一号取得日(一号取得日);
                hihokenshaDaichoDivisionEntity.set喪失日(喪失日);
                hihokenshaDaichoDivisionEntity.set喪失事由コード(喪失事由コード);
                hihokenshaDaichoDivisionEntity.set喪失事由名称(喪失事由名称);
                hihokenshaDaichoDivisionEntity.set資格区分(資格区分);
                hihokenshaDaichoDivisionEntity.set変更日(変更日);
                hihokenshaDaichoDivisionEntity.set変更事由コード(変更事由コード);
                hihokenshaDaichoDivisionEntity.set変更事由名称(変更事由名称);
                hihokenshaDaichoDivisionEntity.set住特適用日(住特適用日);
                hihokenshaDaichoDivisionEntity.set住特解除日(住特解除日);
                hihokenshaDaichoDivisionEntity.set措置保険者(措置保険者);
                hihokenshaDaichoDivisionEntity.set旧保険者(旧保険者);
                分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
            }
            nocount++;
        }

        return 分割した被保険者台帳管理List;
    }

    private RString flexRString(FlexibleDate fromDate) {
        return fromDate.wareki().fillType(FillType.BLANK).toDateString();
    }

    private List<SeikatsuHogoJukyushaDivisionEntity> get分割した生活保護受給者リスト(
            List<ShisetsuNyutaishoEntity> entityList) {
        List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List = new ArrayList<>();
        SeikatsuHogoJukyushaDivisionEntity seikatsuHogoJukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
        int nocount = 0;
        List<RString> 生活保護No = new ArrayList<>();
        List<FlexibleDate> 受給開始日 = new ArrayList<>();
        List<FlexibleDate> 受給廃止日 = new ArrayList<>();
        List<FlexibleDate> 全額停止開始日 = new ArrayList<>();
        List<FlexibleDate> 全額停止終了日 = new ArrayList<>();
        // TODO 蘇広俊 扶助種類方針不明、QA279提出中
        List<RString> 扶助種類 = new ArrayList<>();
        for (ShisetsuNyutaishoEntity entity : entityList) {
            生活保護No.add(new RString(String.valueOf(nocount + 1)));
            受給開始日.add(entity.getJukyuKaishiYMD());
            受給廃止日.add(entity.getJukyuHaishiYMD());
            全額停止開始日.add(entity.getJukyuTeishiKaishiYMD());
            全額停止終了日.add(entity.getJukyuTeishiShuryoYMD());
            if ((nocount + 1) % NOCOUNT_3 == 0) {
                seikatsuHogoJukyushaDivisionEntity.set生活保護No(生活保護No);
                seikatsuHogoJukyushaDivisionEntity.set受給開始日(受給開始日);
                seikatsuHogoJukyushaDivisionEntity.set受給廃止日(受給廃止日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止開始日(全額停止開始日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止終了日(全額停止終了日);
                分割した生活保護受給者List.add(seikatsuHogoJukyushaDivisionEntity);
                生活保護No.clear();
                受給開始日.clear();
                受給廃止日.clear();
                全額停止開始日.clear();
                全額停止終了日.clear();
                seikatsuHogoJukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_3 < (nocount + 1)) {
                seikatsuHogoJukyushaDivisionEntity.set生活保護No(生活保護No);
                seikatsuHogoJukyushaDivisionEntity.set受給開始日(受給開始日);
                seikatsuHogoJukyushaDivisionEntity.set受給廃止日(受給廃止日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止開始日(全額停止開始日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止終了日(全額停止終了日);
                分割した生活保護受給者List.add(seikatsuHogoJukyushaDivisionEntity);
            }
            nocount++;
        }

        return 分割した生活保護受給者List;
    }

    private List<RoreiFukushiNenkinJukyushaDivisionEntity> get分割した老齢福祉年金受給者リスト(
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList) {
        List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List = new ArrayList<>();
        RoreiFukushiNenkinJukyushaDivisionEntity roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
        int nocount = 0;
        List<RString> 老齢福祉No = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給開始日 = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給終了日 = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
            老齢福祉No.add(new RString(String.valueOf(nocount + 1)));
            老齢福祉受給開始日.add(entity.getJukyuKaishiYMD());
            老齢福祉受給終了日.add(entity.getJukyuShuryoYMD());
            if ((nocount + 1) % NOCOUNT_3 == 0) {
                roreiDivisionEntity.set老齢福祉No(老齢福祉No);
                roreiDivisionEntity.set老齢福祉受給開始日(老齢福祉受給開始日);
                roreiDivisionEntity.set老齢福祉受給終了日(老齢福祉受給終了日);
                分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
                老齢福祉No.clear();
                老齢福祉受給開始日.clear();
                老齢福祉受給終了日.clear();
                roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_3 < (nocount + 1)) {
                roreiDivisionEntity.set老齢福祉No(老齢福祉No);
                roreiDivisionEntity.set老齢福祉受給開始日(老齢福祉受給開始日);
                roreiDivisionEntity.set老齢福祉受給終了日(老齢福祉受給終了日);
                分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
            }
            nocount++;
        }

        return 分割した老齢福祉年金受給者List;
    }

    private List get分割した証交付回収リスト(List<DbT7037ShoKofuKaishuEntity> entityList) {
        List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List = new ArrayList<>();
        ShoKofuKaishuDivisionEntity kaishuDivisionEntity = new ShoKofuKaishuDivisionEntity();
        int nocount = 0;
        List<RString> 証履歴No = new ArrayList<>();
        List<FlexibleDate> 証履歴発行日 = new ArrayList<>();
        List<RString> 証履歴事由名称 = new ArrayList<>();
        List<FlexibleDate> 証履歴回収日 = new ArrayList<>();
        for (DbT7037ShoKofuKaishuEntity entity : entityList) {
            証履歴No.add(new RString(String.valueOf(nocount + 1)));
            証履歴発行日.add(entity.getKofuYMD());
            if (entity.getKofuJiyu() != null) {
                証履歴事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                        new CodeShubetsu(CODESHUBETSU_0002), new Code(entity.getKofuJiyu())));
            } else {
                証履歴事由名称.add(RString.EMPTY);
            }
            証履歴回収日.add(entity.getKaishuYMD());
            if ((nocount + 1) % NOCOUNT_10 == 0) {
                kaishuDivisionEntity.set証履歴No(証履歴No);
                kaishuDivisionEntity.set証履歴発行日(証履歴発行日);
                kaishuDivisionEntity.set証履歴事由名称(証履歴事由名称);
                kaishuDivisionEntity.set証履歴回収日(証履歴回収日);
                分割した証交付回収List.add(kaishuDivisionEntity);
                証履歴No.clear();
                証履歴発行日.clear();
                証履歴事由名称.clear();
                証履歴回収日.clear();
                kaishuDivisionEntity = new ShoKofuKaishuDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_10 < (nocount + 1)) {
                kaishuDivisionEntity.set証履歴No(証履歴No);
                kaishuDivisionEntity.set証履歴発行日(証履歴発行日);
                kaishuDivisionEntity.set証履歴事由名称(証履歴事由名称);
                kaishuDivisionEntity.set証履歴回収日(証履歴回収日);
                分割した証交付回収List.add(kaishuDivisionEntity);
            }
            nocount++;
        }

        return 分割した証交付回収List;
    }

    // TODO 蘇広俊 世帯情報取得方針不明、QA170提出中
    private List get分割した世帯情報リスト(List entityList) {
        List 分割した世帯情報List = new ArrayList<>();

        return 分割した世帯情報List;
    }

    private int getMaxList件数(List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List,
            List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List,
            List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List,
            List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List,
            List 分割した世帯情報List) {
        List<Integer> array = new ArrayList<>();
        array.add(分割した被保険者台帳管理List.size());
        array.add(分割した老齢福祉年金受給者List.size());
        array.add(分割した証交付回収List.size());
        array.add(分割した生活保護受給者List.size());
        array.add(分割した世帯情報List.size());
        Collections.sort(array);
        return array.get(array.size() - 1);
    }

    private RString dateFormat(RDateTime formatDate) {
        return formatDate.getDate().seireki().separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString().concat(" ").concat(
                        formatDate.getTime().toString().substring(0, NOCOUNT_12));
    }

    private RString dateFormat日時(RString formatDate) {
        RStringBuilder nianYueRiShiFenMiao
                = new RStringBuilder(new RDate(formatDate.substring(0, NOCOUNT_11).toString())
                        .wareki().separator(Separator.JAPANESE).toDateString());
        RString temp = formatDate.substring(NOCOUNT_12);
        RStringBuilder tempTime = new RStringBuilder(temp.substring(0, 2));
        tempTime.append(HOUR);
        tempTime.append(temp.substring(NOCOUNT_3, NOCOUNT_5));
        tempTime.append(MINUTE);
        tempTime.append(temp.substring(NOCOUNT_6, NOCOUNT_8));
        tempTime.append(SECOND);

        return nianYueRiShiFenMiao.append(tempTime.toRString()).toRString();
    }
}
