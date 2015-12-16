/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.hihokenshadaichosakusei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshadaichosakusei.HihokenshaDaichoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
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
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者台帳のクラスです。
 */
public class HihokenshaDaichoSakusei {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac;
    private final DbT7037ShoKofuKaishuDac 証交付回収Dac;
    private final DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac;
    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;

    /**
     * コンストラクタです。
     */
    HihokenshaDaichoSakusei() {
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
    HihokenshaDaichoSakusei(DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
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
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakusei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoSakusei}のインスタンス
     */
    public static HihokenshaDaichoSakusei createInstance() {
	return InstanceProvider.create(HihokenshaDaichoSakusei.class);
    }

    /**
     * 被保険者台帳を返します。
     *
     * @param parameter 被保険者台帳の入力パラメータ
     * @return hihokenshaList 被保険者情報
     */
    @Transaction
    public List<HihokenshaEntity> getHihokenshaDaichoSakusei(HihokenshaDaichoSakuseiParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));

	List<HihokenshaEntity> hihokenshaList = this.get被保険者情報(parameter);
	if (hihokenshaList.isEmpty()) {
	    return new ArrayList<>();
	}
	return hihokenshaList;
    }

    private List<HihokenshaEntity> get被保険者情報(HihokenshaDaichoSakuseiParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenList = this.get被保険者台帳管理情報(parameter);
	List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiList = this.get老齢福祉年金受給者情報(parameter);
	List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKoList = this.get証交付回収情報(parameter);
	DbT1008IryohokenKanyuJokyoEntity dbT1008IryohoEntity = this.get介護保険医療保険情報(parameter);

	List<HihokenshaEntity> hihokenshaList = new ArrayList<>();
	HihokenshaEntity hihokenshaEntity = new HihokenshaEntity();
	hihokenshaEntity.setPrintDate(FlexibleDate.getNowDate());
	hihokenshaEntity.setPage(RString.EMPTY);
	hihokenshaEntity.setTitle(new RString("介護保険　被保険者台帳"));

	//市町村コード,市町村名称,被保険者番号,状態,
	for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenList) {
	    //市町村コード,市町村名称
	    if (new LasdecCode("120").equals(entity.getShichosonCode())
		    || new LasdecCode("220").equals(entity.getShichosonCode())) {

		hihokenshaEntity.setShichosonCode(entity.getShichosonCode());
		Association association = AssociationFinderFactory.createInstance().getAssociation();
		hihokenshaEntity.setShichosonMeisho(association.get市町村名());
		hihokenshaList.add(hihokenshaEntity);
	    }
	    if (new LasdecCode("111").equals(entity.getShichosonCode())
		    || new LasdecCode("112").equals(entity.getShichosonCode())
		    || new LasdecCode("211").equals(entity.getShichosonCode())) {
		List<DbT7051KoseiShichosonMasterEntity> DbT7051KoseiEntityList
			= 構成市町村マスタDac.selectByshichosonCode(entity.getShichosonCode());

		hihokenshaEntity.setShichosonMeisho(DbT7051KoseiEntityList.get(0).getShichosonMeisho());
		hihokenshaList.add(hihokenshaEntity);
	    }
	    //被保険者番号,状態
	    hihokenshaEntity.setHihokenshaNoTitle(new RString("被保険者番号"));
	    hihokenshaEntity.setHihokenshaNo(entity.getHihokenshaNo());
	    hihokenshaList.add(hihokenshaEntity);
	    if (new RString("03").equals(entity.getShikakuSoshitsuJiyuCode())) {
		hihokenshaEntity.setState(new RString("適用除外者"));
	    } else if (new RString("05").equals(entity.getShikakuSoshitsuJiyuCode())) {
		hihokenshaEntity.setState(new RString("他市町村住所地特例者"));
	    } else if (RString.isNullOrEmpty(RString.EMPTY)) {
		hihokenshaEntity.setState(new RString("資格取得者"));
	    } else {
		hihokenshaEntity.setState(new RString("資格喪失者"));
	    }
	}

	//TODO 宛名識別対象取得ガイドラインを呼び出す。
//	UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class);
//	ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.UR業務共通, KensakuYusenKubun.住登外優先));
//	IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
//	List<IShikibetsuTaisho> list = new ArrayList<>();
//	List<UaFt200FindShikibetsuTaishoEntity> entitylist = dac.select(psm);
//	for (UaFt200FindShikibetsuTaishoEntity entity : entitylist) {
//	    //IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity);
//	    IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entity);
//	    IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity);
//
//	    list.add(shikibetsuTaisho);
//	}
	// 事業者番号,事業者名称
	ShisetsuNyutaishoEntity shisetsuNyutaishoEntity = this.get入所施設(parameter);
	hihokenshaEntity.setJigyoshaNo(shisetsuNyutaishoEntity.getJigyoshaNo());
	hihokenshaEntity.setJigyoshaMeisho(shisetsuNyutaishoEntity.getJigyoshaMeisho());
	//医療保険種別
	hihokenshaEntity.setIryoHokenShubetsu(CodeMaster.getCodeMeisho(new CodeShubetsu("0001"),
		new Code(dbT1008IryohoEntity.getIryoHokenShubetsuCode())));
	hihokenshaEntity.setIryoHokenshaMeisho(dbT1008IryohoEntity.getIryoHokenshaMeisho());
	//記号番号
	hihokenshaEntity.setIryoHokenKigoNo(dbT1008IryohoEntity.getIryoHokenKigoNo());
	hihokenshaEntity.setOrderNo(RString.EMPTY);
	hihokenshaEntity.setDbT1001HihokenshaDaichoEntityList(dbT1001HihokenList);
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
	List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = this.get被保険者台帳(hihokenshaList);
	if (hihokenshaDaichoSakuseiEntityList.isEmpty()) {
	    return new ArrayList<>();
	}
	return hihokenshaDaichoSakuseiEntityList;
    }

    private List<HihokenshaDaichoSakuseiEntity> get被保険者台帳(List<HihokenshaEntity> hihokenshaList) {

	List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = new ArrayList<>();
	for (int i = 0; i < hihokenshaList.size(); i++) {
	    List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = this.get分割した被保険者台帳管理リスト(
		    hihokenshaList.get(i).getDbT1001HihokenshaDaichoEntityList());
	    List 分割した老齢福祉年金受給者List = this.get分割した老齢福祉年金受給者リスト(
		    hihokenshaList.get(i).getDbT7006RoreiFukushiNenkinJukyushaEntityList());
	    List 分割した証交付回収List = this.get分割した証交付回収リスト(
		    hihokenshaList.get(i).getDbT7037ShoKofuKaishuEntityList());
	    int maxCount = this.getMaxList件数(分割した被保険者台帳管理List, 分割した老齢福祉年金受給者List, 分割した証交付回収List);

	    for (int j = 0; j < maxCount; j++) {

		HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity = new HihokenshaDaichoSakuseiEntity();
		hihokenshaDaichoSakuseiEntity.setPrintDate(hihokenshaList.get(j).getPrintDate());
		hihokenshaDaichoSakuseiEntity.setPage(String.valueOf(j));
		hihokenshaDaichoSakuseiEntity.setTitle(new RString("介護保険被保険者台帳"));
		hihokenshaDaichoSakuseiEntity.setJigyoshaNo(hihokenshaList.get(j).getJigyoshaNo());
		hihokenshaDaichoSakuseiEntity.setJigyoshaMeisho(hihokenshaList.get(j).getJigyoshaMeisho());
		//医療保険種別
		hihokenshaDaichoSakuseiEntity.setIryoHokenShubetsu(hihokenshaList.get(j).getIryoHokenShubetsu());
		//医療保険者
		hihokenshaDaichoSakuseiEntity.setIryoHokenshaMeisho(hihokenshaList.get(j).getIryoHokenshaMeisho());
		//記号番号
		hihokenshaDaichoSakuseiEntity.setIryoHokenKigoNo(hihokenshaList.get(j).getIryoHokenKigoNo());
		hihokenshaDaichoSakuseiEntity.setOrderNo(hihokenshaList.get(j).getOrderNo());

		List<HihokenshaDaichoDivisionEntity> 資格異動情報List = this.get資格異動情報(分割した被保険者台帳管理List, maxCount);
		List<RoreiFukushiNenkinJukyushaDivisionEntity> 老齢福祉情報List = this.get老齢福祉情報(分割した老齢福祉年金受給者List, maxCount);
		List<ShoKofuKaishuDivisionSumEntity> 証交付回収List = this.get証交付回収(分割した証交付回収List, maxCount);
		hihokenshaDaichoSakuseiEntity.set資格異動情報List(資格異動情報List);
		//生活保護情報 TODO
		hihokenshaDaichoSakuseiEntity.set老齢福祉情報List(老齢福祉情報List);
		// 世帯情報 TODO
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

    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者情報(HihokenshaDaichoSakuseiParameter parameter) {

	List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = 老齢福祉年金受給者Dac.selectByShikibetsuCode(parameter.getShikibetsuCode());

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

	if (entityList.isEmpty()) {
	    return new ArrayList<>();
	}
	return entityList;
    }

    private DbT1008IryohokenKanyuJokyoEntity get介護保険医療保険情報(HihokenshaDaichoSakuseiParameter parameter) {

	DbT1008IryohokenKanyuJokyoEntity entity = 介護保険医療保険加入状況Dac.selectByShikibetsuCode(parameter.getShikibetsuCode());
	if (entity == null) {
	    return new DbT1008IryohokenKanyuJokyoEntity();
	}
	return entity;
    }

    private ShisetsuNyutaishoEntity get入所施設(HihokenshaDaichoSakuseiParameter parameter) {

	ShisetsuNyutaishoEntity entity = new ShisetsuNyutaishoEntity();
	HihokenshaDaichoSakuseiMapper mapper = mapperProvider.create(HihokenshaDaichoSakuseiMapper.class);
	ShisetsuNyutaishoEntity shisetsuNyutaishoEntity = mapper.getShisetsuNyutaisho(parameter);
	if (shisetsuNyutaishoEntity.getNyushoShisetsuShurui() != new RString("11")) {
	    entity.setJigyoshaNo(shisetsuNyutaishoEntity.getJigyoshaNo());
	    entity.setJigyoshaMeisho(shisetsuNyutaishoEntity.getJigyoshaMeisho());
	} else {
	    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = mapper.getKaigoJigyosha(parameter);
	    entity.setJigyoshaNo(new RString(dbT7060KaigoJigyoshaEntity.getJigyoshaNo().toString()));
	    entity.setJigyoshaMeisho(dbT7060KaigoJigyoshaEntity.getJigyoshaName());
	}
	return entity;
    }

    private List<HihokenshaDaichoDivisionEntity> get分割した被保険者台帳管理リスト(List<DbT1001HihokenshaDaichoEntity> entityList) {

	List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = new ArrayList<>();
	HihokenshaDaichoDivisionEntity hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
	int i = 1;
	int nocount = 0;
	for (DbT1001HihokenshaDaichoEntity entity : entityList) {
	    if ((nocount + 1) % 5 == 0) {
		hihokenshaDaichoDivisionEntity.get資格異動No().add(new RString(String.valueOf(i)));
		hihokenshaDaichoDivisionEntity.get取得日().add(entity.getShikakuShutokuYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get取得事由コード().add(entity.getShikakuShutokuJiyuCode());
		CodeMaster.getCodeMeisho(new CodeShubetsu("0117"), new Code(entity.getShikakuShutokuJiyuCode()));
		hihokenshaDaichoDivisionEntity.get号取得日().add(entity.getIchigoShikakuShutokuYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get喪失日().add(entity.getShikakuSoshitsuYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get喪失事由コード().add(entity.getShikakuSoshitsuJiyuCode());
		CodeMaster.getCodeMeisho(new CodeShubetsu("0121"), new Code(entity.getShikakuSoshitsuJiyuCode()));
		hihokenshaDaichoDivisionEntity.get資格区分().add(entity.getHihokennshaKubunCode());
		hihokenshaDaichoDivisionEntity.get変更日().add(entity.getShikakuHenkoYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get変更事由コード().add(entity.getShikakuHenkoJiyuCode());
		CodeMaster.getCodeMeisho(new CodeShubetsu("0126"), new Code(entity.getShikakuHenkoJiyuCode()));
		hihokenshaDaichoDivisionEntity.get住特適用日().add(entity.getJushochitokureiTekiyoYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get住特解除日().add(entity.getJushochitokureiKaijoYMD()
			.wareki().fillType(FillType.BLANK).toDateString());
		hihokenshaDaichoDivisionEntity.get措置保険者().add(entity.getKoikinaiTokureiSochimotoShichosonCode());
		hihokenshaDaichoDivisionEntity.get旧保険者().add(entity.getKyuShichosonCode());
		分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
		hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
	    }
	    nocount++;
	    i++;
	}
	if ((nocount + 1) % 5 != 0) {
	    分割した被保険者台帳管理List.add(hihokenshaDaichoDivisionEntity);
	}
	return 分割した被保険者台帳管理List;
    }

    private List get分割した老齢福祉年金受給者リスト(List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList) {
	List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List = new ArrayList<>();
	RoreiFukushiNenkinJukyushaDivisionEntity roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
	int i = 1;
	int nocount = 0;
	for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
	    if ((nocount + 1) % 3 == 0) {
		roreiDivisionEntity.get老齢福祉No().add(new RString(String.valueOf(i)));
		roreiDivisionEntity.get老齢福祉受給開始日().add(entity.getJukyuKaishiYMD());
		roreiDivisionEntity.get老齢福祉受給終了日().add(entity.getJukyuShuryoYMD());
		分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
		roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
	    }
	    nocount++;
	    i++;
	}
	if ((nocount + 1) % 3 != 0) {
	    分割した老齢福祉年金受給者List.add(roreiDivisionEntity);
	}
	return 分割した老齢福祉年金受給者List;
    }

    private List get分割した証交付回収リスト(List<DbT7037ShoKofuKaishuEntity> entityList) {
	List<ShoKofuKaishuDivisionEntity> 分割した証交付回収List = new ArrayList<>();
	ShoKofuKaishuDivisionEntity kaishuDivisionEntity = new ShoKofuKaishuDivisionEntity();
	int i = 1;
	int nocount = 0;
	for (DbT7037ShoKofuKaishuEntity entity : entityList) {
	    if ((nocount + 1) % 3 == 0) {
		kaishuDivisionEntity.get証履歴No().add(new RString(String.valueOf(i)));
		kaishuDivisionEntity.get証履歴発行日().add(entity.getKofuYMD());
		kaishuDivisionEntity.get証履歴事由名称().add(CodeMaster.getCodeMeisho(new CodeShubetsu("0002"), new Code(entity.getKofuJiyu())));
		kaishuDivisionEntity.get証履歴回収日().add(entity.getKaishuYMD());
		分割した証交付回収List.add(kaishuDivisionEntity);
		kaishuDivisionEntity = new ShoKofuKaishuDivisionEntity();
	    }
	    nocount++;
	    i++;
	}
	if ((nocount + 1) % 3 != 0) {
	    分割した証交付回収List.add(kaishuDivisionEntity);
	}
	return 分割した証交付回収List;
    }

    private List<HihokenshaDaichoDivisionEntity> get資格異動情報(List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List, int maxCount) {

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
		for (int j = 0; j < 5; j++) {
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

    private List<RoreiFukushiNenkinJukyushaDivisionEntity> get老齢福祉情報(List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List, int maxCount) {
	List<RoreiFukushiNenkinJukyushaDivisionEntity> 老齢福祉情報List = new ArrayList<>();
	if (分割した老齢福祉年金受給者List.size() < maxCount) {
	    for (int i = 0; i < maxCount; i++) {
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
		List<RString> 老齢福祉No = new ArrayList<>();
		List<FlexibleDate> 老齢福祉受給開始日 = new ArrayList<>();
		List<FlexibleDate> 老齢福祉受給終了日 = new ArrayList<>();
		for (int j = 0; j < 3; j++) {
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
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
		juukyushaDivisionEntity.set老齢福祉No(分割した老齢福祉年金受給者List.get(i).get老齢福祉No());
		juukyushaDivisionEntity.set老齢福祉受給開始日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給開始日());
		juukyushaDivisionEntity.set老齢福祉受給終了日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給終了日());
		老齢福祉情報List.add(juukyushaDivisionEntity);
	    }
	} else {
	    for (int i = 0; i < maxCount; i++) {
		RoreiFukushiNenkinJukyushaDivisionEntity juukyushaDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
		juukyushaDivisionEntity.set老齢福祉No(分割した老齢福祉年金受給者List.get(i).get老齢福祉No());
		juukyushaDivisionEntity.set老齢福祉受給開始日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給開始日());
		juukyushaDivisionEntity.set老齢福祉受給終了日(分割した老齢福祉年金受給者List.get(i).get老齢福祉受給終了日());
		老齢福祉情報List.add(juukyushaDivisionEntity);
	    }
	}
	return 老齢福祉情報List;
    }

    private List<ShoKofuKaishuDivisionSumEntity> get証交付回収(List<ShoKofuKaishuDivisionEntity> 分割した証交付回収リスト, int maxCount) {

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
	    for (int j = 0; j < 5; j++) {
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

	    if (5 < 分割した証交付回収リスト.get(i).get証履歴No().size()) {

		for (int j = 0; j < 分割した証交付回収リスト.get(i).get証履歴No().size(); j++) {
		    // 被保険者証発行履歴情報１
		    if (j < 5) {
			shoKofuKaishuDivisionSumEntity.get証履歴No1().set(j, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴事由名称1().set(j, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴回収日1().set(j, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴発行日1().set(j, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));

			// 被保険者証発行履歴情報2
		    } else {
			shoKofuKaishuDivisionSumEntity.get証履歴No2().set(j - 5, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴事由名称2().set(j - 5, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴回収日2().set(j - 5, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
			shoKofuKaishuDivisionSumEntity.get証履歴発行日2().set(j - 5, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));
		    }
		}

	    } else {
		for (int j = 0; j < 分割した証交付回収リスト.get(i).get証履歴No().size(); j++) {
		    // 被保険者証発行履歴情報１
		    shoKofuKaishuDivisionSumEntity.get証履歴No1().set(j, 分割した証交付回収リスト.get(i).get証履歴No().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴事由名称1().set(j, 分割した証交付回収リスト.get(i).get証履歴事由名称().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴回収日1().set(j, 分割した証交付回収リスト.get(i).get証履歴回収日().get(j));
		    shoKofuKaishuDivisionSumEntity.get証履歴発行日1().set(j, 分割した証交付回収リスト.get(i).get証履歴発行日().get(j));
		}
	    }
	    証交付回収List.set(i, shoKofuKaishuDivisionSumEntity);
	}
	return 証交付回収List;
    }

    private int getMaxList件数(List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List,
	    List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List,
	    List<ShoKofuKaishuDivisionSumEntity> 証交付回収List) {
	int[] array = {分割した被保険者台帳管理List.size(), 分割した老齢福祉年金受給者List.size(), 証交付回収List.size()};
	int maxCount = array[0];
	for (int i = 0; i < 2; i++) {
	    if (array[i + 1] > maxCount) {
		maxCount = array[i + 1];
	    }
	}
	return maxCount;
    }
}
