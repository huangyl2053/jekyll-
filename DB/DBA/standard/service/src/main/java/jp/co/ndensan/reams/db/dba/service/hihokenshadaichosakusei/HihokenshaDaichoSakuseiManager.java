/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.hihokenshadaichosakusei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshadaichosakusei.IHihokenshaDaichoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
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
    private static final int NOCOUNT_10 = 10;
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac;
    private final DbT7037ShoKofuKaishuDac 証交付回収Dac;
    private final DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac;
    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;

    /**
     * コンストラクタです。
     */
    HihokenshaDaichoSakuseiManager() {
	this.mapperProvider = InstanceProvider.create(MapperProvider.class);
	this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
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
	this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
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
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	List<HihokenshaEntity> hihokenshaList = get被保険者情報(parameter);
	if (hihokenshaList.isEmpty()) {
	    return new ArrayList<>();
	}

	return getHihokenshaDaichoHenshu(hihokenshaList);
    }

    private List<HihokenshaEntity> get被保険者情報(HihokenshaDaichoSakuseiParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenList = get被保険者台帳管理情報(parameter);
	List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList = get生活保護受給者情報(parameter);
	List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiList = get老齢福祉年金受給者情報(parameter);
	List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKoList = get証交付回収情報(parameter);
	DbT1008IryohokenKanyuJokyoEntity dbT1008IryohoEntity = get介護保険医療保険加入状況情報(parameter);
	List<HihokenshaEntity> hihokenshaList = new ArrayList<>();
	HihokenshaEntity hihokenshaEntity = new HihokenshaEntity();
	hihokenshaEntity.setPrintDate(FlexibleDate.getNowDate());
	hihokenshaEntity.setPage(RString.EMPTY);
	hihokenshaEntity.setTitle(TITLE);
	for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenList) {
	    ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(
		    GyomuBunrui.介護事務);
	    if (new Code(SHICHOSONCODE_120).equals(shichosonSecurityJoho.get導入形態コード())
		    || new Code(SHICHOSONCODE_220).equals(shichosonSecurityJoho.get導入形態コード())) {

		hihokenshaEntity.setShichosonCode(entity.getShichosonCode());
		Association association = AssociationFinderFactory.createInstance().getAssociation();
		hihokenshaEntity.setShichosonMeisho(association.get市町村名());
		hihokenshaList.add(hihokenshaEntity);
	    }
	    if (new Code(SHICHOSONCODE_111).equals(shichosonSecurityJoho.get導入形態コード())
		    || new Code(SHICHOSONCODE_112).equals(shichosonSecurityJoho.get導入形態コード())
		    || new Code(SHICHOSONCODE_211).equals(shichosonSecurityJoho.get導入形態コード())) {
		List<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiEntityList
			= 構成市町村マスタDac.selectByshichosonCode(entity.getShichosonCode());

		hihokenshaEntity.setShichosonMeisho(dbT7051KoseiEntityList.get(0).getShichosonMeisho());
		hihokenshaList.add(hihokenshaEntity);
	    }
	    hihokenshaEntity.setHihokenshaNoTitle(HIHOKENSHANO_TITLE);
	    hihokenshaEntity.setHihokenshaNo(entity.getHihokenshaNo());
	    hihokenshaList.add(hihokenshaEntity);
	    if (SHIKAKUSOSHITSUJIYUCODE_03.equals(entity.getShikakuSoshitsuJiyuCode())) {
		hihokenshaEntity.setState(STATE_適用除外者);
	    } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(entity.getShikakuSoshitsuJiyuCode())) {
		hihokenshaEntity.setState(STATE_他市町村住所地特例者);
	    } else if (RString.isNullOrEmpty(RString.EMPTY)) {
		hihokenshaEntity.setState(STATE_資格取得者);
	    } else {
		hihokenshaEntity.setState(STATE_資格喪失者);
	    }
	}
	UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
		UaFt200FindShikibetsuTaishoFunctionDac.class);
	ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
		ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.UR業務共通, KensakuYusenKubun.住登外優先));
	key.set識別コード(parameter.getShikibetsuCode());
	IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
	List<UaFt200FindShikibetsuTaishoEntity> entitylist = dac.select(psm);
	for (UaFt200FindShikibetsuTaishoEntity entity : entitylist) {
	    IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entity);
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
	    if (shikibetsuTaisho.get住所() != null) {
		hihokenshaEntity.setJusho(new AtenaJusho(shikibetsuTaisho.get住所().toString()));
	    }
	    hihokenshaEntity.setZenkokuJushoCode(shikibetsuTaisho.to個人().get住所().get全国住所コード());
	    hihokenshaEntity.setGyoseikuTitle(GYOSEIKU_TITLE);
	    hihokenshaEntity.setGyoseikuCode(shikibetsuTaisho.to個人().get行政区画().getGyoseiku().getコード());
	    // TODO 蘇広俊 電話番号１取得方針不明、QA207提出中
	    hihokenshaEntity.setTelephoneNo2(RString.EMPTY);
	    hihokenshaList.add(hihokenshaEntity);
	}
	ShisetsuNyutaishoEntity shisetsuNyutaishoEntity = get入所施設(parameter);
	hihokenshaEntity.setJigyoshaNo(shisetsuNyutaishoEntity.getJigyoshaNo());
	hihokenshaEntity.setJigyoshaMeisho(shisetsuNyutaishoEntity.getJigyoshaMeisho());
	if (dbT1008IryohoEntity.getIryoHokenShubetsuCode() != null) {
	    hihokenshaEntity.setIryoHokenShubetsu(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0001),
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

	return hihokenshaList;
    }

    /**
     * 被保険者台帳を編集します。
     *
     * @param hihokenshaList 被保険者情報
     * @return hihokenshaDaichoSakuseiEntityList 被保険者台帳
     */
    @Transaction
    public List<HihokenshaDaichoSakuseiEntity> getHihokenshaDaichoHenshu(List<HihokenshaEntity> hihokenshaList) {
	requireNonNull(hihokenshaList, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaList"));
	List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = get被保険者台帳(hihokenshaList);
	if (hihokenshaDaichoSakuseiEntityList.isEmpty()) {
	    return new ArrayList<>();
	}

	return hihokenshaDaichoSakuseiEntityList;
    }

    private List<HihokenshaDaichoSakuseiEntity> get被保険者台帳(List<HihokenshaEntity> hihokenshaList) {
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
		hihokenshaDaichoSakuseiEntity.setPrintDate(hihokenshaList.get(j).getPrintDate());
		hihokenshaDaichoSakuseiEntity.setPage(new RString(String.valueOf(i)));
		hihokenshaDaichoSakuseiEntity.setTitle(TITLE_介護保険被保険者台帳);
		hihokenshaDaichoSakuseiEntity.setShichosonCode(hihokenshaList.get(j).getShichosonCode());
		hihokenshaDaichoSakuseiEntity.setShichosonMeisho(hihokenshaList.get(j).getShichosonMeisho());
		hihokenshaDaichoSakuseiEntity.setHihokenshaNoTitle(hihokenshaList.get(j).getHihokenshaNoTitle());
		hihokenshaDaichoSakuseiEntity.setHihokenshaNo(hihokenshaList.get(j).getHihokenshaNo());
		hihokenshaDaichoSakuseiEntity.setKanaMeisho(hihokenshaList.get(j).getKanaMeisho());
		hihokenshaDaichoSakuseiEntity.setMeisho(hihokenshaList.get(j).getMeisho());
		hihokenshaDaichoSakuseiEntity.setSeinengappiYMD(hihokenshaList.get(j).getSeinengappiYMD());
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
		List<HihokenshaDaichoDivisionEntity> 資格異動情報List
			= get資格異動情報(分割した被保険者台帳管理List, maxCount);
		List<SeikatsuHogoJukyushaDivisionEntity> 生活保護情報List
			= get生活保護情報(分割した生活保護受給者List, maxCount);
		List<RoreiFukushiNenkinJukyushaDivisionEntity> 老齢福祉情報List
			= get老齢福祉情報(分割した老齢福祉年金受給者List, maxCount);
		List<ShoKofuKaishuDivisionSumEntity> 証交付回収List = get証交付回収(分割した証交付回収List, maxCount);
		hihokenshaDaichoSakuseiEntity.set資格異動情報List(資格異動情報List);
		hihokenshaDaichoSakuseiEntity.set生活保護情報List(生活保護情報List);
		hihokenshaDaichoSakuseiEntity.set老齢福祉情報List(老齢福祉情報List);
		// TODO 蘇広俊 世帯情報取得方針不明、QA170提出中
		hihokenshaDaichoSakuseiEntity.set証交付回収List(証交付回収List);
		hihokenshaDaichoSakuseiEntityList.add(hihokenshaDaichoSakuseiEntity);
	    }
	}

	return hihokenshaDaichoSakuseiEntityList;
    }

    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳管理情報(HihokenshaDaichoSakuseiParameter parameter) {
	ITrueFalseCriteria makeShuruiConditions;
	if (parameter.getHihokenshaNo() == null || parameter.getHihokenshaNo().isEmpty()) {
	    makeShuruiConditions = and(
		    leq(DbT1001HihokenshaDaicho.logicalDeletedFlag, false),
		    leq(parameter.getShikibetsuCode(), DbT1001HihokenshaDaicho.shikibetsuCode));
	} else {
	    makeShuruiConditions = and(
		    eq(DbT1001HihokenshaDaicho.logicalDeletedFlag, false),
		    leq(DbT1001HihokenshaDaicho.hihokenshaNo, parameter.getHihokenshaNo()));
	}
	List<DbT1001HihokenshaDaichoEntity> entityList = 被保険者台帳管理Dac.select(makeShuruiConditions);
	if (entityList.isEmpty()) {
	    return new ArrayList<>();
	}

	return entityList;
    }

    private List<ShisetsuNyutaishoEntity> get生活保護受給者情報(HihokenshaDaichoSakuseiParameter parameter) {
	IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
	List<ShisetsuNyutaishoEntity> entityList = mapper.getSeikatsuHogoJukyusha(parameter);
	if (entityList.isEmpty()) {
	    return new ArrayList<>();
	}

	return entityList;
    }

    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者情報(
	    HihokenshaDaichoSakuseiParameter parameter) {
	List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = 老齢福祉年金受給者Dac.selectByShikibetsuCode(
		parameter.getShikibetsuCode());
	if (entityList.isEmpty()) {
	    return new ArrayList<>();
	}

	return entityList;
    }

    private List<DbT7037ShoKofuKaishuEntity> get証交付回収情報(HihokenshaDaichoSakuseiParameter parameter) {
	ITrueFalseCriteria makeShuruiConditions;
	if (parameter.getHihokenshaNo() == null || parameter.getHihokenshaNo().isEmpty()) {
	    makeShuruiConditions = and(
		    leq(DbT7037ShoKofuKaishu.logicalDeletedFlag, false),
		    leq(parameter.getShikibetsuCode(), DbT7037ShoKofuKaishu.shikibetsuCode));
	} else {
	    makeShuruiConditions = and(
		    eq(DbT7037ShoKofuKaishu.logicalDeletedFlag, false),
		    leq(DbT7037ShoKofuKaishu.hihokenshaNo, parameter.getHihokenshaNo()));
	}
	List<DbT7037ShoKofuKaishuEntity> entityList = 証交付回収Dac.select(makeShuruiConditions);
	if (entityList != null) {
	    return new ArrayList<>();
	}

	return entityList;
    }

    private DbT1008IryohokenKanyuJokyoEntity get介護保険医療保険加入状況情報(
	    HihokenshaDaichoSakuseiParameter parameter) {
	DbT1008IryohokenKanyuJokyoEntity entity = 介護保険医療保険加入状況Dac.selectByShikibetsuCode(
		parameter.getShikibetsuCode());
	if (entity == null) {
	    return new DbT1008IryohokenKanyuJokyoEntity();
	}

	return entity;
    }

    private ShisetsuNyutaishoEntity get入所施設(HihokenshaDaichoSakuseiParameter parameter) {
	ShisetsuNyutaishoEntity entity = new ShisetsuNyutaishoEntity();
	IHihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(IHihokenshaDaichoSakuseiMapper.class);
	ShisetsuNyutaishoEntity shisetsuNyutaishoEntity = mapper.getShisetsuNyutaisho(parameter);
	if (shisetsuNyutaishoEntity == null) {
	    return new ShisetsuNyutaishoEntity();
	} else {
	    if (shisetsuNyutaishoEntity.getNyushoShisetsuShurui() != NYUSHOSHISETSUSHURUI_11) {
		entity.setJigyoshaNo(shisetsuNyutaishoEntity.getJigyoshaNo());
		entity.setJigyoshaMeisho(shisetsuNyutaishoEntity.getJigyoshaMeisho());
	    } else {
		DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = mapper.getKaigoJigyosha(parameter);
		entity.setJigyoshaNo(new RString(dbT7060KaigoJigyoshaEntity.getJigyoshaNo().toString()));
		entity.setJigyoshaMeisho(dbT7060KaigoJigyoshaEntity.getJigyoshaName());
	    }
	}
	return entity;
    }

    private List<HihokenshaDaichoDivisionEntity> get分割した被保険者台帳管理リスト(
	    List<DbT1001HihokenshaDaichoEntity> entityList) {
	List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = new ArrayList<>();
	HihokenshaDaichoDivisionEntity hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
	int nocount = 0;
	List<RString> 資格異動No = new ArrayList<>();
	List<RString> 取得日 = new ArrayList<>();
	List<RString> 取得事由コード = new ArrayList<>();
	List<RString> 取得事由名称 = new ArrayList<>();
	List<RString> 号取得日 = new ArrayList<>();
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
	    取得日.add(entity.getShikakuShutokuYMD().wareki().fillType(FillType.BLANK).toDateString());
	    取得事由コード.add(entity.getShikakuShutokuJiyuCode());
	    取得事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
		    new CodeShubetsu(CODESHUBETSU_0117), new Code(entity.getShikakuShutokuJiyuCode())));
	    号取得日.add(entity.getIchigoShikakuShutokuYMD().wareki().fillType(FillType.BLANK).toDateString());
	    喪失日.add(entity.getShikakuSoshitsuYMD().wareki().fillType(FillType.BLANK).toDateString());
	    喪失事由コード.add(entity.getShikakuSoshitsuJiyuCode());
	    喪失事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
		    new CodeShubetsu(CODESHUBETSU_0121), new Code(entity.getShikakuSoshitsuJiyuCode())));
	    資格区分.add(entity.getHihokennshaKubunCode());
	    変更日.add(entity.getShikakuHenkoYMD().wareki().fillType(FillType.BLANK).toDateString());
	    変更事由コード.add(entity.getShikakuHenkoJiyuCode());
	    変更事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
		    new CodeShubetsu(CODESHUBETSU_0126), new Code(entity.getShikakuHenkoJiyuCode())));
	    住特適用日.add(entity.getJushochitokureiTekiyoYMD().wareki().fillType(FillType.BLANK).toDateString());
	    住特解除日.add(entity.getJushochitokureiKaijoYMD().wareki().fillType(FillType.BLANK).toDateString());
	    措置保険者.add(entity.getKoikinaiTokureiSochimotoShichosonCode());
	    旧保険者.add(entity.getKyuShichosonCode());
	    if ((nocount + 1) % NOCOUNT_5 == 0) {
		hihokenshaDaichoDivisionEntity.set資格異動No(資格異動No);
		hihokenshaDaichoDivisionEntity.set取得日(取得日);
		hihokenshaDaichoDivisionEntity.set取得事由コード(取得事由コード);
		hihokenshaDaichoDivisionEntity.set取得事由名称(取得事由名称);
		hihokenshaDaichoDivisionEntity.set号取得日(号取得日);
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
		号取得日.clear();
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
	    } else if (entityList.size() - entityList.size() % NOCOUNT_3 < (nocount + 1)) {
		hihokenshaDaichoDivisionEntity.set資格異動No(資格異動No);
		hihokenshaDaichoDivisionEntity.set取得日(取得日);
		hihokenshaDaichoDivisionEntity.set取得事由コード(取得事由コード);
		hihokenshaDaichoDivisionEntity.set取得事由名称(取得事由名称);
		hihokenshaDaichoDivisionEntity.set号取得日(号取得日);
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
	//TODO QA
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
	    証履歴事由名称.add(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
		    new CodeShubetsu(CODESHUBETSU_0002), new Code(entity.getKofuJiyu())));
	    証履歴回収日.add(entity.getKaishuYMD());
	    // TODO 蘇広俊 証交付回収取得方針不明、QA210提出中
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

    private List<HihokenshaDaichoDivisionEntity> get資格異動情報(
	    List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List, int maxCount) {
	List<HihokenshaDaichoDivisionEntity> 資格異動情報List = new ArrayList<>();
	HihokenshaDaichoDivisionEntity daichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
	if (分割した被保険者台帳管理List.size() < maxCount) {
	    for (int i = 0; i < maxCount; i++) {
		List<RString> 資格異動No = new ArrayList<>();
		List<RString> 取得日 = new ArrayList<>();
		List<RString> 取得事由コード = new ArrayList<>();
		List<RString> 取得事由名称 = new ArrayList<>();
		List<RString> 号取得日 = new ArrayList<>();
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
		for (int j = 0; j < NOCOUNT_5; j++) {
		    資格異動No.add(RString.EMPTY);
		    取得日.add(RString.EMPTY);
		    取得事由コード.add(RString.EMPTY);
		    取得事由名称.add(RString.EMPTY);
		    号取得日.add(RString.EMPTY);
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
		daichoDivisionEntity.set資格異動No(資格異動No);
		daichoDivisionEntity.set取得日(取得日);
		daichoDivisionEntity.set取得事由コード(取得事由コード);
		daichoDivisionEntity.set取得事由名称(取得事由名称);
		daichoDivisionEntity.set号取得日(号取得日);
		daichoDivisionEntity.set喪失日(喪失日);
		daichoDivisionEntity.set喪失事由コード(喪失事由コード);
		daichoDivisionEntity.set喪失事由名称(喪失事由名称);
		daichoDivisionEntity.set資格区分(資格区分);
		daichoDivisionEntity.set変更日(変更日);
		daichoDivisionEntity.set変更事由コード(変更事由コード);
		daichoDivisionEntity.set変更事由名称(変更事由名称);
		daichoDivisionEntity.set住特適用日(住特適用日);
		daichoDivisionEntity.set住特解除日(住特解除日);
		daichoDivisionEntity.set措置保険者(措置保険者);
		daichoDivisionEntity.set旧保険者(旧保険者);
		資格異動情報List.add(daichoDivisionEntity);
	    }
	    for (int i = 0; i < 分割した被保険者台帳管理List.size(); i++) {
		daichoDivisionEntity.set資格異動No(分割した被保険者台帳管理List.get(i).get資格異動No());
		daichoDivisionEntity.set取得日(分割した被保険者台帳管理List.get(i).get取得日());
		daichoDivisionEntity.set取得事由コード(分割した被保険者台帳管理List.get(i).get取得事由コード());
		daichoDivisionEntity.set取得事由名称(分割した被保険者台帳管理List.get(i).get取得事由名称());
		daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(i).get号取得日());
		daichoDivisionEntity.set喪失日(分割した被保険者台帳管理List.get(i).get喪失日());
		daichoDivisionEntity.set喪失事由コード(分割した被保険者台帳管理List.get(i).get喪失事由コード());
		daichoDivisionEntity.set喪失事由名称(分割した被保険者台帳管理List.get(i).get喪失事由名称());
		daichoDivisionEntity.set資格区分(分割した被保険者台帳管理List.get(i).get資格区分());
		daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(i).get号取得日());
		daichoDivisionEntity.set変更日(分割した被保険者台帳管理List.get(i).get変更日());
		daichoDivisionEntity.set変更事由コード(分割した被保険者台帳管理List.get(i).get変更事由コード());
		daichoDivisionEntity.set変更事由名称(分割した被保険者台帳管理List.get(i).get変更事由名称());
		daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(i).get住特適用日());
		daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(i).get住特解除日());
		daichoDivisionEntity.set措置保険者(分割した被保険者台帳管理List.get(i).get措置保険者());
		daichoDivisionEntity.set旧保険者(分割した被保険者台帳管理List.get(i).get旧保険者());
		資格異動情報List.add(daichoDivisionEntity);
	    }
	} else {
	    for (int i = 0; i < maxCount; i++) {
		daichoDivisionEntity.set資格異動No(分割した被保険者台帳管理List.get(i).get資格異動No());
		daichoDivisionEntity.set取得日(分割した被保険者台帳管理List.get(i).get取得日());
		daichoDivisionEntity.set取得事由コード(分割した被保険者台帳管理List.get(i).get取得事由コード());
		daichoDivisionEntity.set取得事由名称(分割した被保険者台帳管理List.get(i).get取得事由名称());
		daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(i).get号取得日());
		daichoDivisionEntity.set喪失日(分割した被保険者台帳管理List.get(i).get喪失日());
		daichoDivisionEntity.set喪失事由コード(分割した被保険者台帳管理List.get(i).get喪失事由コード());
		daichoDivisionEntity.set喪失事由名称(分割した被保険者台帳管理List.get(i).get喪失事由名称());
		daichoDivisionEntity.set資格区分(分割した被保険者台帳管理List.get(i).get資格区分());
		daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(i).get号取得日());
		daichoDivisionEntity.set変更日(分割した被保険者台帳管理List.get(i).get変更日());
		daichoDivisionEntity.set変更事由コード(分割した被保険者台帳管理List.get(i).get変更事由コード());
		daichoDivisionEntity.set変更事由名称(分割した被保険者台帳管理List.get(i).get変更事由名称());
		daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(i).get住特適用日());
		daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(i).get住特解除日());
		daichoDivisionEntity.set措置保険者(分割した被保険者台帳管理List.get(i).get措置保険者());
		daichoDivisionEntity.set旧保険者(分割した被保険者台帳管理List.get(i).get旧保険者());
		資格異動情報List.add(daichoDivisionEntity);
	    }
	}

	return 資格異動情報List;
    }

    private List<SeikatsuHogoJukyushaDivisionEntity> get生活保護情報(
	    List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List, int maxCount) {
	List<SeikatsuHogoJukyushaDivisionEntity> 生活保護情報List = new ArrayList<>();
	if (分割した生活保護受給者List.size() < maxCount) {
	    for (int i = 0; i < maxCount; i++) {
		SeikatsuHogoJukyushaDivisionEntity jukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
		List<RString> 生活保護No = new ArrayList<>();
		List<FlexibleDate> 受給開始日 = new ArrayList<>();
		List<FlexibleDate> 受給廃止日 = new ArrayList<>();
		List<FlexibleDate> 全額停止開始日 = new ArrayList<>();
		List<FlexibleDate> 全額停止終了日 = new ArrayList<>();
		List<RString> 扶助種類 = new ArrayList<>();
		for (int j = 0; j < NOCOUNT_3; j++) {
		    生活保護No.add(RString.EMPTY);
		    受給開始日.add(FlexibleDate.EMPTY);
		    受給廃止日.add(FlexibleDate.EMPTY);
		    全額停止開始日.add(FlexibleDate.EMPTY);
		    全額停止終了日.add(FlexibleDate.EMPTY);
		}
		jukyushaDivisionEntity.set生活保護No(生活保護No);
		jukyushaDivisionEntity.set受給開始日(受給開始日);
		jukyushaDivisionEntity.set受給廃止日(受給廃止日);
		jukyushaDivisionEntity.set全額停止開始日(全額停止開始日);
		jukyushaDivisionEntity.set全額停止終了日(全額停止終了日);
	    }
	    for (int i = 0; i < 生活保護情報List.size(); i++) {
		SeikatsuHogoJukyushaDivisionEntity jukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
		jukyushaDivisionEntity.set生活保護No(生活保護情報List.get(i).get生活保護No());
		jukyushaDivisionEntity.set受給開始日(生活保護情報List.get(i).get受給開始日());
		jukyushaDivisionEntity.set受給廃止日(生活保護情報List.get(i).get受給廃止日());
		生活保護情報List.add(jukyushaDivisionEntity);
	    }
	} else {
	    for (int i = 0; i < maxCount; i++) {
		SeikatsuHogoJukyushaDivisionEntity jukyushaDivisionEntity = new SeikatsuHogoJukyushaDivisionEntity();
		jukyushaDivisionEntity.set生活保護No(生活保護情報List.get(i).get生活保護No());
		jukyushaDivisionEntity.set受給開始日(生活保護情報List.get(i).get受給開始日());
		jukyushaDivisionEntity.set受給廃止日(生活保護情報List.get(i).get受給廃止日());
		生活保護情報List.add(jukyushaDivisionEntity);
	    }
	}

	return 生活保護情報List;
    }

    private List<RoreiFukushiNenkinJukyushaDivisionEntity> get老齢福祉情報(
	    List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List, int maxCount) {
	List<RoreiFukushiNenkinJukyushaDivisionEntity> 老齢福祉情報List = new ArrayList<>();
	if (分割した老齢福祉年金受給者List.size() < maxCount) {
	    for (int i = 0; i < maxCount; i++) {
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity
			= new RoreiFukushiNenkinJukyushaDivisionEntity();
		List<RString> 老齢福祉No = new ArrayList<>();
		List<FlexibleDate> 老齢福祉受給開始日 = new ArrayList<>();
		List<FlexibleDate> 老齢福祉受給終了日 = new ArrayList<>();
		for (int j = 0; j < NOCOUNT_3; j++) {
		    老齢福祉No.add(RString.EMPTY);
		    老齢福祉受給開始日.add(FlexibleDate.MAX);
		    老齢福祉受給終了日.add(FlexibleDate.MAX);
		}
		juukyushaDivisionEntity.set老齢福祉No(老齢福祉No);
		juukyushaDivisionEntity.set老齢福祉受給開始日(老齢福祉受給開始日);
		juukyushaDivisionEntity.set老齢福祉受給終了日(老齢福祉受給終了日);
		老齢福祉情報List.add(juukyushaDivisionEntity);
	    }

	    for (int i = 0; i < 分割した老齢福祉年金受給者List.size(); i++) {
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity
			= new RoreiFukushiNenkinJukyushaDivisionEntity();
		juukyushaDivisionEntity.set老齢福祉No(分割した老齢福祉年金受給者List.get(i).get老齢福祉No());
		juukyushaDivisionEntity.set老齢福祉受給開始日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給開始日());
		juukyushaDivisionEntity.set老齢福祉受給終了日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給終了日());
		老齢福祉情報List.add(juukyushaDivisionEntity);
	    }
	} else {
	    for (int i = 0; i < maxCount; i++) {
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity
			= new RoreiFukushiNenkinJukyushaDivisionEntity();
		juukyushaDivisionEntity.set老齢福祉No(分割した老齢福祉年金受給者List.get(i).get老齢福祉No());
		juukyushaDivisionEntity.set老齢福祉受給開始日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給開始日());
		juukyushaDivisionEntity.set老齢福祉受給終了日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給終了日());
		老齢福祉情報List.add(juukyushaDivisionEntity);
	    }
	}

	return 老齢福祉情報List;
    }

    private List<ShoKofuKaishuDivisionSumEntity> get証交付回収(
	    List<ShoKofuKaishuDivisionEntity> 分割した証交付回収リスト, int maxCount) {
	List<ShoKofuKaishuDivisionSumEntity> 証交付回収List = new ArrayList<>();
	for (int i = 0; i < maxCount; i++) {
	    ShoKofuKaishuDivisionSumEntity shoKofuKaishuDivisionSumEntity = new ShoKofuKaishuDivisionSumEntity();
	    List<RString> 証履歴No1 = new ArrayList<>();
	    List<FlexibleDate> 証履歴発行日1 = new ArrayList<>();
	    List<RString> 証履歴事由名称1 = new ArrayList<>();
	    List<FlexibleDate> 証履歴回収日1 = new ArrayList<>();
	    List<RString> 証履歴No2 = new ArrayList<>();
	    List<FlexibleDate> 証履歴発行日2 = new ArrayList<>();
	    List<RString> 証履歴事由名称2 = new ArrayList<>();
	    List<FlexibleDate> 証履歴回収日2 = new ArrayList<>();
	    for (int j = 0; j < NOCOUNT_5; j++) {
		証履歴No1.add(RString.EMPTY);
		証履歴発行日1.add(FlexibleDate.EMPTY);
		証履歴事由名称1.add(RString.EMPTY);
		証履歴回収日1.add(FlexibleDate.EMPTY);
		証履歴No2.add(RString.EMPTY);
		証履歴発行日2.add(FlexibleDate.EMPTY);
		証履歴事由名称2.add(RString.EMPTY);
		証履歴回収日2.add(FlexibleDate.EMPTY);
	    }
	    shoKofuKaishuDivisionSumEntity.set証履歴No1(証履歴No1);
	    shoKofuKaishuDivisionSumEntity.set証履歴事由名称1(証履歴事由名称1);
	    shoKofuKaishuDivisionSumEntity.set証履歴回収日1(証履歴回収日1);
	    shoKofuKaishuDivisionSumEntity.set証履歴発行日1(証履歴発行日1);
	    shoKofuKaishuDivisionSumEntity.set証履歴No2(証履歴No2);
	    shoKofuKaishuDivisionSumEntity.set証履歴事由名称2(証履歴事由名称2);
	    shoKofuKaishuDivisionSumEntity.set証履歴回収日2(証履歴回収日2);
	    shoKofuKaishuDivisionSumEntity.set証履歴発行日2(証履歴発行日2);

	    証交付回収List.add(shoKofuKaishuDivisionSumEntity);
	}

	for (int i = 0; i < 分割した証交付回収リスト.size(); i++) {
	    ShoKofuKaishuDivisionSumEntity shoKofuKaishuDivisionSumEntity = 証交付回収List.get(i);
	    if (分割した証交付回収リスト.get(i).get証履歴No() != null
		    && NOCOUNT_5 < 分割した証交付回収リスト.get(i).get証履歴No().size()) {
		for (int j = 0; j < 分割した証交付回収リスト.get(i).get証履歴No().size(); j++) {
		    if (j < NOCOUNT_5) {
			shoKofuKaishuDivisionSumEntity.get証履歴No1().set(
				j, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴事由名称1().set(
				j, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴回収日1().set(
				j, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴発行日1().set(
				j, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));
		    } else {
			shoKofuKaishuDivisionSumEntity.get証履歴No2().set(
				j - NOCOUNT_5, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴事由名称2().set(
				j - NOCOUNT_5, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴回収日2().set(
				j - NOCOUNT_5, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴発行日2().set(
				j - NOCOUNT_5, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));
		    }
		}
	    } else if (分割した証交付回収リスト.get(i).get証履歴No() != null) {
		for (int j = 0; j < 分割した証交付回収リスト.get(i).get証履歴No().size(); j++) {
		    shoKofuKaishuDivisionSumEntity.get証履歴No1().set(
			    j, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴事由名称1().set(
			    j, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴回収日1().set(
			    j, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴発行日1().set(
			    j, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));
		}
	    }
	    証交付回収List.set(i, shoKofuKaishuDivisionSumEntity);
	}

	return 証交付回収List;
    }

    private int getMaxList件数(List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List,
	    List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List,
	    List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List,
	    List<SeikatsuHogoJukyushaDivisionEntity> 分割した生活保護受給者List,
	    List 分割した世帯情報List) {
	int[] array = {分割した被保険者台帳管理List.size(),
	    分割した老齢福祉年金受給者List.size(),
	    分割した証交付回収List.size(),
	    分割した生活保護受給者List.size(),
	    分割した世帯情報List.size()};
	Arrays.sort(array);
	return array[array.length - 1];
    }
}
