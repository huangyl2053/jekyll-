/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichosakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiLeftEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiRightEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiinJohoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShoKofuKaishuDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaichosakusei.IHihokenshaDaichoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.SeikatsuHogoFujoShuruiCodeType;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
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
    private static final RString CODESHUBETSU_0007 = new RString("0007");
    private static final RString CODESHUBETSU_0010 = new RString("0010");
    private static final RString CODESHUBETSU_0013 = new RString("0013");
    private static final RString CODESHUBETSU_0002 = new RString("0002");
    private static final RString CODESHUBETSU_0001 = new RString("0001");
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_6 = 6;
    private static final int NOCOUNT_8 = 8;
    private static final int NOCOUNT_10 = 10;
    private static final int NOCOUNT_11 = 11;
    private static final int NOCOUNT_12 = 12;
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");
    private static final RString TELEPHONENO_TITLE = new RString("連絡先");
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
     * @return SearchResult<HihokenshaDaichoSakusei> 被保険者台帳
     */
    @Transaction
    public SearchResult<HihokenshaDaichoSakusei> getHihokenshaDaichoSakusei(
            HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        HihokenshaEntity hihokenshaEntity = get被保険者情報(parameter);
        List<HihokenshaDaichoSakusei> businessList = getHihokenshaDaichoHenshu(hihokenshaEntity).records();
        return SearchResult.of(businessList, 0, false);
    }

    private HihokenshaEntity get被保険者情報(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenList = get被保険者台帳管理情報(parameter);
        List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList = get生活保護受給者情報(parameter);
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiList = get老齢福祉年金受給者情報(parameter);
        List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKoList = get証交付回収情報(parameter);
        SetaiinFinder setaiinFinder = SetaiinFinder.createInstance();
        List<SetaiinJoho> setaiinJohoList = setaiinFinder.get世帯員情報By識別コード(parameter.getShikibetsuCode(), FlexibleDate.getNowDate());
        DbT1008IryohokenKanyuJokyoEntity dbT1008IryohoEntity = get介護保険医療保険加入状況情報(parameter);
        HihokenshaEntity hihokenshaEntity = new HihokenshaEntity();
        hihokenshaEntity.setPrintDate(dateFormat(RDateTime.now()));
        hihokenshaEntity.setPage(RString.EMPTY);
        hihokenshaEntity.setTitle(TITLE);
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務);
        for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenList) {
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
                        = 構成市町村マスタDac.shichosonCodeYoriShichosonJoho(entity.getShichosonCode());
                RString shichosonMeisho = !dbT7051KoseiEntityList.isEmpty() ? dbT7051KoseiEntityList.get(0).getShichosonMeisho() : RString.EMPTY;
                hihokenshaEntity.setShichosonMeisho(shichosonMeisho);
            }
        }
        UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険,
                        KensakuYusenKubun.住登外優先));
        if (!dbT1001HihokenList.isEmpty()) {
            hihokenshaEntity.setHihokenshaNoTitle(HIHOKENSHANO_TITLE);
            hihokenshaEntity.setHihokenshaNo(dbT1001HihokenList.get(0).getHihokenshaNo());
            if (SHIKAKUSOSHITSUJIYUCODE_03.equals(dbT1001HihokenList.get(0).getShikakuSoshitsuJiyuCode())) {
                hihokenshaEntity.setState(STATE_適用除外者);
            } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(dbT1001HihokenList.get(0).getShikakuSoshitsuJiyuCode())) {
                hihokenshaEntity.setState(STATE_他市町村住所地特例者);
            } else if (RString.isNullOrEmpty(RString.EMPTY)) {
                hihokenshaEntity.setState(STATE_資格取得者);
            } else {
                hihokenshaEntity.setState(STATE_資格喪失者);
            }
            key.set識別コード(dbT1001HihokenList.get(0).getShikibetsuCode());
        }
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
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        List<UaFt200FindShikibetsuTaishoEntity> entitylist = dac.select(psm);
        if (!entitylist.isEmpty()) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entitylist.get(0));
            hihokenshaEntity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
            hihokenshaEntity.setMeisho(shikibetsuTaisho.get名称().getName());
            hihokenshaEntity.setSeinengappiYMD(shikibetsuTaisho.to個人().get生年月日().toFlexibleDate());
            hihokenshaEntity.setSeibetsuCode(shikibetsuTaisho.to個人().get性別() == null ? RString.EMPTY
                    : shikibetsuTaisho.to個人().get性別().getName().getShortJapanese());
            hihokenshaEntity.setSetaiCode(shikibetsuTaisho.to個人().get世帯コード());
            hihokenshaEntity.setShikibetsuCode(shikibetsuTaisho.to個人().get識別コード());
            hihokenshaEntity.setChikucodeTitle1(shikibetsuTaisho.to個人().get行政区画().getChiku1().get名称());
            hihokenshaEntity.setChikuCode1(shikibetsuTaisho.to個人().get行政区画().getChiku1().getコード());
            hihokenshaEntity.setChikucodeTitle2(shikibetsuTaisho.to個人().get行政区画().getChiku2().get名称());
            hihokenshaEntity.setChikuCode2(shikibetsuTaisho.to個人().get行政区画().getChiku2().getコード());
            hihokenshaEntity.setChikucodeTitle3(shikibetsuTaisho.to個人().get行政区画().getChiku3().get名称());
            hihokenshaEntity.setChikuCode3(shikibetsuTaisho.to個人().get行政区画().getChiku3().getコード());
            hihokenshaEntity.setJushoTitle(JUSHO_TITLE);
            hihokenshaEntity.setJusho(shikibetsuTaisho.get住所().get住所());
            hihokenshaEntity.setZenkokuJushoCode(shikibetsuTaisho.to個人().get住所().get全国住所コード());
            hihokenshaEntity.setGyoseikuTitle(GYOSEIKU_TITLE);
            hihokenshaEntity.setGyoseikuCode(shikibetsuTaisho.to個人().get行政区画().getGyoseiku().getコード());
            hihokenshaEntity.setTelephoneNoTitle(TELEPHONENO_TITLE);
            hihokenshaEntity.setTelephoneNo1(shikibetsuTaisho.get連絡先１() == null ? RString.EMPTY : shikibetsuTaisho.get連絡先１().getColumnValue());
            hihokenshaEntity.setTelephoneNo1(shikibetsuTaisho.get連絡先２() == null ? RString.EMPTY : shikibetsuTaisho.get連絡先２().getColumnValue());
        }
        ShisetsuNyutaishoEntity nyutaishoEntity = get入所施設(parameter);
        hihokenshaEntity.setJigyoshaNo(nyutaishoEntity.getJigyoshaNo());
        hihokenshaEntity.setJigyoshaMeisho(nyutaishoEntity.getJigyoshaMeisho() == null ? AtenaMeisho.EMPTY
                : new AtenaMeisho(nyutaishoEntity.getJigyoshaMeisho()));
        if (dbT1008IryohoEntity != null && dbT1008IryohoEntity.getIryoHokenShubetsuCode() != null) {
            hihokenshaEntity.setIryoHokenShubetsu(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(CODESHUBETSU_0001),
                    new Code(dbT1008IryohoEntity.getIryoHokenShubetsuCode())));
            hihokenshaEntity.setIryoHokenshaMeisho(dbT1008IryohoEntity.getIryoHokenshaMeisho());
            hihokenshaEntity.setIryoHokenKigoNo(dbT1008IryohoEntity.getIryoHokenKigoNo());
        }
        hihokenshaEntity.setOrderNo(RString.EMPTY);
        hihokenshaEntity.setDbT1001HihokenshaDaichoEntityList(dbT1001HihokenList);
        hihokenshaEntity.setShisetsuNyutaishoEntityList(shisetsuNyutaishoEntityList);
        hihokenshaEntity.setDbT7006RoreiFukushiNenkinJukyushaEntityList(dbT7006RoreiList);
        hihokenshaEntity.setDbT7037ShoKofuKaishuEntityList(dbT7037ShoKoList);
        hihokenshaEntity.setSetaiinJohoEntityList(get世帯員取得(setaiinJohoList));
        return hihokenshaEntity;
    }

    private List<SetaiinJohoEntity> get世帯員取得(List<SetaiinJoho> setaiinJohoList) {
        List<SetaiinJohoEntity> setaiinJohoEntityList = new ArrayList<>();
        if (!setaiinJohoList.isEmpty()) {
            SetaiinJohoEntity setaiinJohoEntity = new SetaiinJohoEntity();
            for (SetaiinJoho setaiinJoho : setaiinJohoList) {
                setaiinJohoEntity.setUaFt200Entity(setaiinJoho.get識別対象().toEntity());
                setaiinJohoEntity.set本人区分(setaiinJoho.get本人区分());
                setaiinJohoEntityList.add(setaiinJohoEntity);
            }
        }
        return setaiinJohoEntityList;
    }

    /**
     * 被保険者台帳を編集します。
     *
     * @param hihokenshaEntity 被保険者情報
     * @return SearchResult<HihokenshaDaichoSakusei> 被保険者台帳
     */
    @Transaction
    public SearchResult<HihokenshaDaichoSakusei> getHihokenshaDaichoHenshu(HihokenshaEntity hihokenshaEntity
    ) {
        requireNonNull(hihokenshaEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaEntity"));
        List<HihokenshaDaichoSakusei> businessList = new ArrayList<>();
        List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiList = get被保険者台帳(hihokenshaEntity);
        if (!hihokenshaDaichoSakuseiList.isEmpty()) {
            for (HihokenshaDaichoSakuseiEntity daichoSakuseiEntity : hihokenshaDaichoSakuseiList) {
                businessList.add(new HihokenshaDaichoSakusei(daichoSakuseiEntity));
            }
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 被保険者台帳を編集します。
     *
     * @param hihokenshaEntity 被保険者情報
     * @return hihokenshaDaichoSakuseiEntityList 被保険者台帳
     */
    public List<HihokenshaDaichoSakuseiEntity> get被保険者台帳(HihokenshaEntity hihokenshaEntity) {
        requireNonNull(hihokenshaEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaEntity"));
        List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiList = new ArrayList<>();
        List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = get分割した被保険者台帳管理リスト(
                hihokenshaEntity.getDbT1001HihokenshaDaichoEntityList());
        List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List
                = get分割した老齢福祉年金受給者リスト(hihokenshaEntity.getDbT7006RoreiFukushiNenkinJukyushaEntityList());
        List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List = get分割した証交付回収リスト(
                hihokenshaEntity.getDbT7037ShoKofuKaishuEntityList());
        List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List = get分割した生活保護受給者リスト(
                hihokenshaEntity.getShisetsuNyutaishoEntityList());
        List<SetaiDivisionEntity> 分割した世帯一覧情報List = get分割した世帯情報リスト(hihokenshaEntity.getSetaiinJohoEntityList());
        int maxCount = getMaxList件数(分割した被保険者台帳管理List, 分割した老齢福祉年金受給者List,
                分割した証交付回収List, 分割した生活保護受給者List, 分割した世帯一覧情報List);
        for (int i = 0; i < maxCount; i++) {
            HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity = new HihokenshaDaichoSakuseiEntity();
            hihokenshaDaichoSakuseiEntity.setPrintDate(dateFormat日時(hihokenshaEntity.getPrintDate()));
            hihokenshaDaichoSakuseiEntity.setPage(new RString(String.valueOf(i)));
            hihokenshaDaichoSakuseiEntity.setTitle(TITLE_介護保険被保険者台帳);
            hihokenshaDaichoSakuseiEntity.setShichosonCode(hihokenshaEntity.getShichosonCode());
            hihokenshaDaichoSakuseiEntity.setShichosonMeisho(hihokenshaEntity.getShichosonMeisho());
            hihokenshaDaichoSakuseiEntity.setHihokenshaNoTitle(hihokenshaEntity.getHihokenshaNoTitle());
            hihokenshaDaichoSakuseiEntity.setHihokenshaNo(hihokenshaEntity.getHihokenshaNo());
            hihokenshaDaichoSakuseiEntity.setKanaMeisho(hihokenshaEntity.getKanaMeisho());
            hihokenshaDaichoSakuseiEntity.setMeisho(hihokenshaEntity.getMeisho());
            hihokenshaDaichoSakuseiEntity.setSeinengappiYMD(flexRString(hihokenshaEntity.getSeinengappiYMD()));
            hihokenshaDaichoSakuseiEntity.setSeibetsuCode(hihokenshaEntity.getSeibetsuCode());
            hihokenshaDaichoSakuseiEntity.setSetaiCode(hihokenshaEntity.getSetaiCode());
            hihokenshaDaichoSakuseiEntity.setShikibetsuCode(hihokenshaEntity.getShikibetsuCode());
            hihokenshaDaichoSakuseiEntity.setChikucodeTitle1(hihokenshaEntity.getChikucodeTitle1());
            hihokenshaDaichoSakuseiEntity.setChikuCode1(hihokenshaEntity.getChikuCode1());
            hihokenshaDaichoSakuseiEntity.setChikucodeTitle2(hihokenshaEntity.getChikucodeTitle2());
            hihokenshaDaichoSakuseiEntity.setChikuCode2(hihokenshaEntity.getChikuCode2());
            hihokenshaDaichoSakuseiEntity.setChikucodeTitle3(hihokenshaEntity.getChikucodeTitle3());
            hihokenshaDaichoSakuseiEntity.setChikuCode3(hihokenshaEntity.getChikuCode3());
            hihokenshaDaichoSakuseiEntity.setJushoTitle(hihokenshaEntity.getJushoTitle());
            hihokenshaDaichoSakuseiEntity.setJusho(hihokenshaEntity.getJusho());
            hihokenshaDaichoSakuseiEntity.setZenkokuJushoCode(hihokenshaEntity.getZenkokuJushoCode());
            hihokenshaDaichoSakuseiEntity.setGyoseikuTitle(hihokenshaEntity.getGyoseikuTitle());
            hihokenshaDaichoSakuseiEntity.setGyoseikuCode(hihokenshaEntity.getGyoseikuCode());
            hihokenshaDaichoSakuseiEntity.setTelephoneNoTitle(hihokenshaEntity.getTelephoneNoTitle());
            hihokenshaDaichoSakuseiEntity.setTelephoneNo1(hihokenshaEntity.getTelephoneNo1());
            hihokenshaDaichoSakuseiEntity.setTelephoneNo2(hihokenshaEntity.getTelephoneNo2());
            hihokenshaDaichoSakuseiEntity.setState(hihokenshaEntity.getState());
            hihokenshaDaichoSakuseiEntity.setJigyoshaNo(hihokenshaEntity.getJigyoshaNo());
            hihokenshaDaichoSakuseiEntity.setJigyoshaMeisho(hihokenshaEntity.getJigyoshaMeisho());
            hihokenshaDaichoSakuseiEntity.setIryoHokenShubetsu(hihokenshaEntity.getIryoHokenShubetsu());
            hihokenshaDaichoSakuseiEntity.setIryoHokenshaMeisho(hihokenshaEntity.getIryoHokenshaMeisho());
            hihokenshaDaichoSakuseiEntity.setIryoHokenKigoNo(hihokenshaEntity.getIryoHokenKigoNo());
            hihokenshaDaichoSakuseiEntity.setOrderNo(hihokenshaEntity.getOrderNo());
            if (!分割した被保険者台帳管理List.isEmpty() && i < 分割した被保険者台帳管理List.size()) {
                set資格異動情報(hihokenshaDaichoSakuseiEntity, 分割した被保険者台帳管理List.get(i));
            } else {
                setEmptiy資格異動情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_5);
            }
            if (!分割した生活保護受給者List.isEmpty() && i < 分割した生活保護受給者List.size()) {
                set生活保護受給者情報(hihokenshaDaichoSakuseiEntity, 分割した生活保護受給者List.get(i));
            } else {
                setEmptiy生活保護受給者情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_3);
            }
            if (!分割した老齢福祉年金受給者List.isEmpty() && i < 分割した老齢福祉年金受給者List.size()) {
                set老齢福祉年金受給者情報(hihokenshaDaichoSakuseiEntity, 分割した老齢福祉年金受給者List.get(i));
            } else {
                setEmptiy老齢福祉年金受給者情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_3);
            }
            if (!分割した証交付回収List.isEmpty() && i < 分割した証交付回収List.size()) {
                set被保険者証発行履歴情報(hihokenshaDaichoSakuseiEntity, 分割した証交付回収List.get(i));
            } else {
                setEmptiy被保険者証発行履歴情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_10);
            }
            if (!分割した世帯一覧情報List.isEmpty() && i < 分割した世帯一覧情報List.size()) {
                set世帯情報(hihokenshaDaichoSakuseiEntity, 分割した世帯一覧情報List.get(i));
            } else {
                this.setEmptiy世帯情報(hihokenshaDaichoSakuseiEntity, NOCOUNT_5);
            }
            hihokenshaDaichoSakuseiList.add(hihokenshaDaichoSakuseiEntity);
        }
        return hihokenshaDaichoSakuseiList;
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
        資格異動情報Entity.set住特解除日(hihokenshaDaichoDivisionEntity.get住特解除日());
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
            SeikatsuHogoJukyushaDivisionEntity seikatsuHogoJukyushaDivision) {
        requireNonNull(seikatsuHogoJukyushaDivision, UrSystemErrorMessages.値がnull
                .getReplacedMessage("seikatsuHogoJukyushaDivisionEntity"));
        SeikatsuHogoJukyushaDivisionEntity 生活保護情報Entity = new SeikatsuHogoJukyushaDivisionEntity();
        生活保護情報Entity.set全額停止終了日(seikatsuHogoJukyushaDivision.get全額停止終了日());
        生活保護情報Entity.set全額停止開始日(seikatsuHogoJukyushaDivision.get全額停止開始日());
        生活保護情報Entity.set受給廃止日(seikatsuHogoJukyushaDivision.get受給廃止日());
        生活保護情報Entity.set受給開始日(seikatsuHogoJukyushaDivision.get受給開始日());
        生活保護情報Entity.set扶助種類(seikatsuHogoJukyushaDivision.get扶助種類());
        生活保護情報Entity.set生活保護No(seikatsuHogoJukyushaDivision.get生活保護No());
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
            RoreiFukushiNenkinJukyushaDivisionEntity roreiFukushiNenkinJukyusha) {
        requireNonNull(roreiFukushiNenkinJukyusha, UrSystemErrorMessages.値がnull
                .getReplacedMessage("roreiFukushiNenkinJukyushaDivisionEntity"));
        RoreiFukushiNenkinJukyushaDivisionEntity 老齢福祉年金受給者Entity
                = new RoreiFukushiNenkinJukyushaDivisionEntity();
        老齢福祉年金受給者Entity.set老齢福祉No(roreiFukushiNenkinJukyusha.get老齢福祉No());
        老齢福祉年金受給者Entity.set老齢福祉受給終了日(roreiFukushiNenkinJukyusha.get老齢福祉受給終了日());
        老齢福祉年金受給者Entity.set老齢福祉受給開始日(roreiFukushiNenkinJukyusha.get老齢福祉受給開始日());
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
        if (shoKofuKaishuDivisionEntity.get証履歴No() != null) {
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

    private void set世帯情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity,
            SetaiDivisionEntity setaiDivisionEntity) {
        requireNonNull(setaiDivisionEntity, UrSystemErrorMessages.値がnull.
                getReplacedMessage("setaiDivisionEntity"));
        SetaiLeftEntity leftEntity = new SetaiLeftEntity();
        SetaiRightEntity rightEntity = new SetaiRightEntity();
        if (setaiDivisionEntity.get世帯左No() != null) {
            for (int i = 0; i < setaiDivisionEntity.get世帯左No().size(); i++) {
                if (i == 0) {
                    hihokenshaDaichoSakuseiEntity.setSetaiName1(setaiDivisionEntity.get氏名().get(i));
                }
                if (i == 1) {
                    hihokenshaDaichoSakuseiEntity.setSetaiName2(setaiDivisionEntity.get氏名().get(i));
                }
                if (i == 2) {
                    hihokenshaDaichoSakuseiEntity.setSetaiName3(setaiDivisionEntity.get氏名().get(i));
                }
                if (i == NOCOUNT_3) {
                    hihokenshaDaichoSakuseiEntity.setSetaiName4(setaiDivisionEntity.get氏名().get(i));
                }
                if (i == NOCOUNT_4) {
                    hihokenshaDaichoSakuseiEntity.setSetaiName5(setaiDivisionEntity.get氏名().get(i));
                }
            }
            leftEntity.set世帯左No(setaiDivisionEntity.get世帯左No());
            leftEntity.set世帯左識別コード(setaiDivisionEntity.get世帯左識別コード());
            rightEntity.set世帯右性別(setaiDivisionEntity.get世帯性別());
            rightEntity.set世帯右生年月日(setaiDivisionEntity.get世帯生年月日());
            rightEntity.set世帯右続柄(setaiDivisionEntity.get世帯続柄());
            rightEntity.set世帯右被保険者番号(setaiDivisionEntity.get世帯被保険者番号());
            hihokenshaDaichoSakuseiEntity.set世帯左情報(leftEntity);
            hihokenshaDaichoSakuseiEntity.set世帯右情報(rightEntity);
        }
    }

    private void setEmptiy世帯情報(HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity, int 一ページのレコード) {
        hihokenshaDaichoSakuseiEntity.setSetaiName1(RString.EMPTY);
        hihokenshaDaichoSakuseiEntity.setSetaiName2(RString.EMPTY);
        hihokenshaDaichoSakuseiEntity.setSetaiName3(RString.EMPTY);
        hihokenshaDaichoSakuseiEntity.setSetaiName4(RString.EMPTY);
        hihokenshaDaichoSakuseiEntity.setSetaiName5(RString.EMPTY);
        SetaiLeftEntity leftEntity = new SetaiLeftEntity();
        SetaiRightEntity rightEntity = new SetaiRightEntity();
        List<RString> 世帯左No = new ArrayList<>();
        List<ShikibetsuCode> 世帯左識別コード = new ArrayList<>();
        List<RString> 世帯右性別 = new ArrayList<>();
        List<FlexibleDate> 世帯右生年月日 = new ArrayList<>();
        List<RString> 世帯右続柄 = new ArrayList<>();
        List<HihokenshaNo> 世帯右被保険者番号 = new ArrayList<>();
        for (int i = 0; i < 一ページのレコード; i++) {
            世帯左No.add(RString.EMPTY);
            世帯左識別コード.add(ShikibetsuCode.EMPTY);
            世帯右性別.add(RString.EMPTY);
            世帯右生年月日.add(FlexibleDate.EMPTY);
            世帯右続柄.add(RString.EMPTY);
            世帯右被保険者番号.add(HihokenshaNo.EMPTY);
        }
        leftEntity.set世帯左No(世帯左No);
        leftEntity.set世帯左識別コード(世帯左識別コード);
        rightEntity.set世帯右性別(世帯右性別);
        rightEntity.set世帯右生年月日(世帯右生年月日);
        rightEntity.set世帯右続柄(世帯右続柄);
        rightEntity.set世帯右被保険者番号(世帯右被保険者番号);
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
        return entity;
    }

    private ShisetsuNyutaishoEntity get入所施設(HihokenshaDaichoSakuseiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        ShisetsuNyutaishoEntity entity = new ShisetsuNyutaishoEntity();
        IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
        DbT1004ShisetsuNyutaishoEntity nyutaishoEntity = mapper.getShisetsuNyutaisho(parameter);
        if (nyutaishoEntity != null && !NYUSHOSHISETSUSHURUI_11.equals(nyutaishoEntity.getNyushoShisetsuShurui())) {
            HihokenshaDaichoSakuseiParameter sakuseiParameter = HihokenshaDaichoSakuseiParameter.createSelectByKeyParam(
                    parameter.getShikibetsuCode(), parameter.getHihokenshaNo(), nyutaishoEntity.getNyushoShisetsuCode());
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity tokureiTaishoShisetsuEntity = mapper.getKaigoJogaiTokureiTaisho(sakuseiParameter);
            if (tokureiTaishoShisetsuEntity != null) {
                entity.setJigyoshaNo(tokureiTaishoShisetsuEntity.getJigyoshaNo());
                entity.setJigyoshaMeisho(tokureiTaishoShisetsuEntity.getJigyoshaMeisho() == null
                        ? RString.EMPTY : tokureiTaishoShisetsuEntity.getJigyoshaMeisho().getColumnValue());
            }
        } else if (nyutaishoEntity != null && NYUSHOSHISETSUSHURUI_11.equals(nyutaishoEntity.getNyushoShisetsuShurui())) {
            HihokenshaDaichoSakuseiParameter sakuseiParameter = HihokenshaDaichoSakuseiParameter.createSelectByKeyParam(
                    parameter.getShikibetsuCode(), parameter.getHihokenshaNo(), nyutaishoEntity.getNyushoShisetsuCode());
            DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = mapper.getKaigoJigyosha(sakuseiParameter);
            if (dbT7060KaigoJigyoshaEntity != null) {
                entity.setJigyoshaNo(dbT7060KaigoJigyoshaEntity.getJigyoshaNo() == null
                        ? RString.EMPTY : dbT7060KaigoJigyoshaEntity.getJigyoshaNo().getColumnValue());
                entity.setJigyoshaMeisho(dbT7060KaigoJigyoshaEntity.getJigyoshaName() == null
                        ? RString.EMPTY : dbT7060KaigoJigyoshaEntity.getJigyoshaName().getColumnValue());
            }
        }
        return entity;
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
        if (entityList.isEmpty()) {
            hihokenshaDaichoDivisionEntity.set資格異動No(資格異動No);
            分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
        }
        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            資格異動No.add(new RString(String.valueOf(nocount + 1)));
            取得日.add(flexRString(entity.getShikakuShutokuYMD()));
            取得事由コード.add(entity.getShikakuShutokuJiyuCode());
            if (entity.getShikakuShutokuJiyuCode() != null) {
                取得事由名称.add(CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(CODESHUBETSU_0007), new Code(entity.getShikakuShutokuJiyuCode())));
            } else {
                取得事由名称.add(RString.EMPTY);
            }
            一号取得日.add(flexRString(entity.getIchigoShikakuShutokuYMD()));
            喪失日.add(flexRString(entity.getShikakuSoshitsuYMD()));
            喪失事由コード.add(entity.getShikakuSoshitsuJiyuCode());
            if (entity.getShikakuSoshitsuJiyuCode() != null) {
                喪失事由名称.add(CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(CODESHUBETSU_0010), new Code(entity.getShikakuSoshitsuJiyuCode())));
            } else {
                喪失事由名称.add(RString.EMPTY);
            }
            資格区分.add(entity.getHihokennshaKubunCode());
            変更日.add(flexRString(entity.getShikakuHenkoYMD()));
            変更事由コード.add(entity.getShikakuHenkoJiyuCode());
            if (entity.getShikakuHenkoJiyuCode() != null) {
                変更事由名称.add(CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(CODESHUBETSU_0013), new Code(entity.getShikakuHenkoJiyuCode())));
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
                資格異動No = new ArrayList<>();
                取得日 = new ArrayList<>();
                取得事由コード = new ArrayList<>();
                取得事由名称 = new ArrayList<>();
                一号取得日 = new ArrayList<>();
                喪失日 = new ArrayList<>();
                喪失事由コード = new ArrayList<>();
                喪失事由名称 = new ArrayList<>();
                資格区分 = new ArrayList<>();
                変更日 = new ArrayList<>();
                変更事由コード = new ArrayList<>();
                変更事由名称 = new ArrayList<>();
                住特適用日 = new ArrayList<>();
                住特解除日 = new ArrayList<>();
                措置保険者 = new ArrayList<>();
                旧保険者 = new ArrayList<>();
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
            }
            nocount++;
        }
        if (nocount % NOCOUNT_5 != 0) {
            分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
        }
        return 分割した被保険者台帳管理List;
    }

    private RString flexRString(FlexibleDate fromDate) {
        RString flexDate = RString.EMPTY;
        if (fromDate != null) {
            flexDate = fromDate.wareki().fillType(FillType.BLANK).toDateString();
        }
        return flexDate;
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
        List<RString> 扶助種類 = new ArrayList<>();
        if (entityList.isEmpty()) {
            seikatsuHogoJukyushaDivisionEntity.set生活保護No(生活保護No);
            分割した生活保護受給者List.add(seikatsuHogoJukyushaDivisionEntity);
        }
        for (ShisetsuNyutaishoEntity entity : entityList) {
            生活保護No.add(new RString(String.valueOf(nocount + 1)));
            受給開始日.add(entity.getJukyuKaishiYMD());
            受給廃止日.add(entity.getJukyuHaishiYMD());
            全額停止開始日.add(entity.getJukyuTeishiKaishiYMD());
            全額停止終了日.add(entity.getJukyuTeishiShuryoYMD());
            扶助種類.add(get扶助種類名称(entity.getFujoShuruiCode()));
            if ((nocount + 1) % NOCOUNT_3 == 0) {
                seikatsuHogoJukyushaDivisionEntity.set生活保護No(生活保護No);
                seikatsuHogoJukyushaDivisionEntity.set受給開始日(受給開始日);
                seikatsuHogoJukyushaDivisionEntity.set受給廃止日(受給廃止日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止開始日(全額停止開始日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止終了日(全額停止終了日);
                seikatsuHogoJukyushaDivisionEntity.set扶助種類(扶助種類);
                分割した生活保護受給者List.add(seikatsuHogoJukyushaDivisionEntity);
                生活保護No = new ArrayList<>();
                受給開始日 = new ArrayList<>();
                受給廃止日 = new ArrayList<>();
                全額停止開始日 = new ArrayList<>();
                全額停止終了日 = new ArrayList<>();
                扶助種類 = new ArrayList<>();
                seikatsuHogoJukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_3 < (nocount + 1)) {
                seikatsuHogoJukyushaDivisionEntity.set生活保護No(生活保護No);
                seikatsuHogoJukyushaDivisionEntity.set受給開始日(受給開始日);
                seikatsuHogoJukyushaDivisionEntity.set受給廃止日(受給廃止日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止開始日(全額停止開始日);
                seikatsuHogoJukyushaDivisionEntity.set全額停止終了日(全額停止終了日);
                seikatsuHogoJukyushaDivisionEntity.set扶助種類(扶助種類);
            }
            nocount++;
        }
        if (nocount % NOCOUNT_3 != 0) {
            分割した生活保護受給者List.add(seikatsuHogoJukyushaDivisionEntity);
        }
        return 分割した生活保護受給者List;
    }

    private static RString get扶助種類名称(RString sourceStr) {
        RStringBuilder 扶助種類 = new RStringBuilder();
        List<RString> sourceStrArray = sourceStr.split("/");
        for (int i = 0; i < sourceStrArray.size() - 1; i++) {
            RString str = SeikatsuHogoFujoShuruiCodeType.toValue(sourceStrArray.get(i)).toRString();
            扶助種類.append(str + "/");
        }
        RString rStr = SeikatsuHogoFujoShuruiCodeType.toValue(sourceStrArray.get(sourceStrArray.size() - 1)).toRString();
        扶助種類.append(rStr);
        return 扶助種類.toRString();
    }

    private List<RoreiFukushiNenkinJukyushaDivisionEntity> get分割した老齢福祉年金受給者リスト(
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList) {
        List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List = new ArrayList<>();
        RoreiFukushiNenkinJukyushaDivisionEntity roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
        int nocount = 0;
        List<RString> 老齢福祉No = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給開始日 = new ArrayList<>();
        List<FlexibleDate> 老齢福祉受給終了日 = new ArrayList<>();
        if (entityList.isEmpty()) {
            roreiDivisionEntity.set老齢福祉No(老齢福祉No);
            分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
        }
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
            老齢福祉No.add(new RString(String.valueOf(nocount + 1)));
            老齢福祉受給開始日.add(entity.getJukyuKaishiYMD());
            老齢福祉受給終了日.add(entity.getJukyuHaishiYMD());
            if ((nocount + 1) % NOCOUNT_3 == 0) {
                roreiDivisionEntity.set老齢福祉No(老齢福祉No);
                roreiDivisionEntity.set老齢福祉受給開始日(老齢福祉受給開始日);
                roreiDivisionEntity.set老齢福祉受給終了日(老齢福祉受給終了日);
                分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
                老齢福祉No = new ArrayList<>();
                老齢福祉受給開始日 = new ArrayList<>();
                老齢福祉受給終了日 = new ArrayList<>();
                roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
            } else if ((entityList.size() - entityList.size() % NOCOUNT_3) < (nocount + 1)) {
                roreiDivisionEntity.set老齢福祉No(老齢福祉No);
                roreiDivisionEntity.set老齢福祉受給開始日(老齢福祉受給開始日);
                roreiDivisionEntity.set老齢福祉受給終了日(老齢福祉受給終了日);
            }
            nocount++;
        }
        if (nocount % NOCOUNT_3 != 0) {
            分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
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
                証履歴事由名称.add(CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
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
                証履歴No = new ArrayList<>();
                証履歴発行日 = new ArrayList<>();
                証履歴事由名称 = new ArrayList<>();
                証履歴回収日 = new ArrayList<>();
                kaishuDivisionEntity = new ShoKofuKaishuDivisionEntity();
            } else if (entityList.size() - entityList.size() % NOCOUNT_10 < (nocount + 1)) {
                kaishuDivisionEntity.set証履歴No(証履歴No);
                kaishuDivisionEntity.set証履歴発行日(証履歴発行日);
                kaishuDivisionEntity.set証履歴事由名称(証履歴事由名称);
                kaishuDivisionEntity.set証履歴回収日(証履歴回収日);
            }
            nocount++;
        }
        if (nocount % NOCOUNT_10 != 0) {
            分割した証交付回収List.add(kaishuDivisionEntity);
        }
        return 分割した証交付回収List;
    }

    private List get分割した世帯情報リスト(List<SetaiinJohoEntity> setaiinJohoEntityList) {
        List<SetaiDivisionEntity> 分割した世帯情報List = new ArrayList<>();
        SetaiDivisionEntity setaiDivisionEntity = new SetaiDivisionEntity();
        int nocount = 0;
        List<RString> 世帯左No = new ArrayList<>();
        List<ShikibetsuCode> 世帯左識別コード = new ArrayList<>();
        List<RString> 氏名 = new ArrayList<>();
        List<RString> 世帯性別 = new ArrayList<>();
        List<FlexibleDate> 世帯生年月日 = new ArrayList<>();
        List<RString> 世帯続柄 = new ArrayList<>();
        List<HihokenshaNo> 世帯被保険者番号 = new ArrayList<>();
        if (setaiinJohoEntityList.isEmpty()) {
            setaiDivisionEntity.set世帯左No(世帯左No);
            setaiDivisionEntity.set世帯被保険者番号(世帯被保険者番号);
            分割した世帯情報List.add(setaiDivisionEntity);
        }
        for (SetaiinJohoEntity entity : setaiinJohoEntityList) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entity.getUaFt200Entity());
            世帯左No.add(new RString(String.valueOf(nocount + 1)));
            世帯左識別コード.add(shikibetsuTaisho.get識別コード());
            氏名.add(shikibetsuTaisho.get名称().getKana() == null ? RString.EMPTY : shikibetsuTaisho.get名称().getKana().getColumnValue());
            世帯性別.add(shikibetsuTaisho.to個人().get性別() == null ? RString.EMPTY
                    : new RString(shikibetsuTaisho.to個人().get性別().getName().toString()));
            世帯生年月日.add(shikibetsuTaisho.to個人().get生年月日() == null ? FlexibleDate.EMPTY
                    : shikibetsuTaisho.to個人().get生年月日().toFlexibleDate());
            世帯続柄.add(shikibetsuTaisho.to個人().get続柄());
            // TODO  内部QA：1107 Redmine：#83700(被保番号の取得方式が知らない、一時固定値を使用します)
            世帯被保険者番号.add(new HihokenshaNo("123456"));
            if ((nocount + 1) % NOCOUNT_5 == 0) {
                setaiDivisionEntity.set世帯左No(世帯左No);
                setaiDivisionEntity.set世帯左識別コード(世帯左識別コード);
                setaiDivisionEntity.set氏名(氏名);
                setaiDivisionEntity.set世帯性別(世帯性別);
                setaiDivisionEntity.set世帯生年月日(世帯生年月日);
                setaiDivisionEntity.set世帯続柄(世帯続柄);
                setaiDivisionEntity.set世帯被保険者番号(世帯被保険者番号);
                分割した世帯情報List.add(setaiDivisionEntity);
                世帯左No = new ArrayList<>();
                世帯左識別コード = new ArrayList<>();
                氏名 = new ArrayList<>();
                世帯性別 = new ArrayList<>();
                世帯生年月日 = new ArrayList<>();
                世帯続柄 = new ArrayList<>();
                世帯被保険者番号 = new ArrayList<>();
                setaiDivisionEntity = new SetaiDivisionEntity();
            } else if (setaiinJohoEntityList.size() - setaiinJohoEntityList.size() % NOCOUNT_10 < (nocount + 1)) {
                setaiDivisionEntity.set世帯左No(世帯左No);
                setaiDivisionEntity.set世帯左識別コード(世帯左識別コード);
                setaiDivisionEntity.set氏名(氏名);
                setaiDivisionEntity.set世帯性別(世帯性別);
                setaiDivisionEntity.set世帯生年月日(世帯生年月日);
                setaiDivisionEntity.set世帯続柄(世帯続柄);
                setaiDivisionEntity.set世帯被保険者番号(世帯被保険者番号);
            }
            nocount++;
        }
        if (nocount % NOCOUNT_5 != 0) {
            分割した世帯情報List.add(setaiDivisionEntity);
        }
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
        RStringBuilder nianYueRiShiFenMiao = new RStringBuilder(new RDate(formatDate.substring(0, NOCOUNT_11).toString())
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
