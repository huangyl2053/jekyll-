/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.HihokenshaDaichoSakusei.HihokenshaDaichoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author soft863
 */
public class HihokenshaDaichoSakusei {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac;
    private final DbT7037ShoKofuKaishuDac 証交付回収Dac;
    private final DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac;

    /**
     * コンストラクタです。
     */
    HihokenshaDaichoSakusei() {
	this.mapperProvider = InstanceProvider.create(MapperProvider.class);
	this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
	this.老齢福祉年金受給者Dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
	this.証交付回収Dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
	this.介護保険医療保険加入状況Dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5912ShujiiJohoDac}
     */
    HihokenshaDaichoSakusei(DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
	    DbT7006RoreiFukushiNenkinJukyushaDac 老齢福祉年金受給者Dac,
	    DbT7037ShoKofuKaishuDac 証交付回収Dac,
	    DbT1008IryohokenKanyuJokyoDac 介護保険医療保険加入状況Dac,
	    MapperProvider mapperProvider) {
	this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
	this.老齢福祉年金受給者Dac = 老齢福祉年金受給者Dac;
	this.証交付回収Dac = 証交付回収Dac;
	this.介護保険医療保険加入状況Dac = 介護保険医療保険加入状況Dac;
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
     *
     * @param parameter
     * @return ShujiiJohoList
     */
    @Transaction
    public List<HihokenshaEntity> getHihokenshaDaichoSakusei(HihokenshaDaichoSakuseiParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenList = this.get被保険者台帳管理情報(parameter);
	List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiList = this.get老齢福祉年金受給者情報(parameter);
	List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKoList = this.get証交付回収情報(parameter);
	DbT1008IryohokenKanyuJokyoEntity dbT1008IryohoEntity = this.get介護保険医療保険情報(parameter);

	List<HihokenshaEntity> hihokenshaList = new ArrayList();
	HihokenshaEntity hihokenshaEntity = new HihokenshaEntity();
	hihokenshaEntity.setPrintDate(FlexibleDate.getNowDate());
	hihokenshaEntity.setPage(RString.EMPTY);
	hihokenshaEntity.setTitle(new RString("介護保険　被保険者台帳"));
	//市町村情報 TODO
	hihokenshaEntity.setHihokenshaNoTitle(new RString("被保険者番号"));

	for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenList) {
	    hihokenshaEntity.setHihokenshaNo(entity.getHihokenshaNo());
	    hihokenshaList.add(hihokenshaEntity);
	}
	// 事業者番号,事業者名称
	ShisetsuNyutaishoEntity shisetsuNyutaishoEntity = this.get入所施設(parameter);
	hihokenshaEntity.setJigyoshaNo(shisetsuNyutaishoEntity.getJigyoshaNo());
	hihokenshaEntity.setJigyoshaMeisho(shisetsuNyutaishoEntity.getJigyoshaMeisho());
	//医療保険種別
	//TODO
	//医療保険者
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
     *
     * @param hihokenshaList
     * @return ShujiiJohoList
     */
    @Transaction
    public List<HihokenshaEntity> getHihokenshaDaichoHenshu(List<HihokenshaEntity> hihokenshaList) {
	requireNonNull(hihokenshaList, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaList"));
	int i = 0;
	List<HihokenshaDaichoSakuseiEntity> hihokenshaDaichoSakuseiEntityList = new ArrayList();
	for (HihokenshaEntity entity : hihokenshaList) {
	    List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = this.get分割した被保険者台帳管理リスト(
		    hihokenshaList.get(i).getDbT1001HihokenshaDaichoEntityList());
	    List 分割した老齢福祉年金受給者List = this.get分割した老齢福祉年金受給者リスト(
		    hihokenshaList.get(i).getDbT7006RoreiFukushiNenkinJukyushaEntityList());
	    List 分割した証交付回収List = this.get分割した証交付回収リスト(
		    hihokenshaList.get(i).getDbT7037ShoKofuKaishuEntityList());
	    i++;

	    List maxList = new ArrayList();//TODO
	    //TODO 件数が最大のリストの件数で繰り返して、データ読み込みを行う
	    for (int j = 0; j < maxList.size(); j++) {

		HihokenshaDaichoSakuseiEntity hihokenshaDaichoSakuseiEntity = new HihokenshaDaichoSakuseiEntity();
		hihokenshaDaichoSakuseiEntity.setPrintDate(hihokenshaList.get(i).getPrintDate());
		hihokenshaDaichoSakuseiEntity.setPage(String.valueOf(i));
		hihokenshaDaichoSakuseiEntity.setTitle(new RString("介護保険被保険者台帳"));
		hihokenshaDaichoSakuseiEntity.setJigyoshaNo(hihokenshaList.get(i).getJigyoshaNo());
		hihokenshaDaichoSakuseiEntity.setJigyoshaMeisho(hihokenshaList.get(i).getJigyoshaMeisho());
		//医療保険種別
		//TODO
		//医療保険者
		hihokenshaDaichoSakuseiEntity.setIryoHokenshaMeisho(hihokenshaList.get(i).getIryoHokenshaMeisho());
		//記号番号
		hihokenshaDaichoSakuseiEntity.setIryoHokenKigoNo(hihokenshaList.get(i).getIryoHokenKigoNo());
		hihokenshaDaichoSakuseiEntity.setOrderNo(hihokenshaList.get(i).getOrderNo());

		List<HihokenshaDaichoDivisionEntity> 資格異動情報List = new ArrayList();
		HihokenshaDaichoDivisionEntity daichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
		if (分割した被保険者台帳管理List.size() < maxList.size()) {
		    for (int l = 0; l < maxList.size(); i++) {
			daichoDivisionEntity.set資格異動No(null);
			daichoDivisionEntity.set取得日(null);
			daichoDivisionEntity.set取得事由コード(null);
			daichoDivisionEntity.set取得事由名称(null);
			daichoDivisionEntity.set号取得日(null);
			daichoDivisionEntity.set喪失日(null);
			daichoDivisionEntity.set喪失事由コード(null);
			daichoDivisionEntity.set喪失事由名称(null);
			daichoDivisionEntity.set資格区分(null);
			daichoDivisionEntity.set号取得日(null);
			daichoDivisionEntity.set変更日(null);
			daichoDivisionEntity.set変更事由コード(null);
			daichoDivisionEntity.set変更事由名称(null);
			daichoDivisionEntity.set住特適用日(null);
			daichoDivisionEntity.set住特適用日(null);
			daichoDivisionEntity.set措置保険者(null);
			daichoDivisionEntity.set旧保険者(null);
			資格異動情報List.add(daichoDivisionEntity);
		    }
		    for (int k = 0; k < 分割した被保険者台帳管理List.size(); k++) {

			daichoDivisionEntity.set資格異動No(分割した被保険者台帳管理List.get(k).get資格異動No());
			daichoDivisionEntity.set取得日(分割した被保険者台帳管理List.get(k).get取得日());
			daichoDivisionEntity.set取得事由コード(分割した被保険者台帳管理List.get(k).get取得事由コード());
			daichoDivisionEntity.set取得事由名称(分割した被保険者台帳管理List.get(k).get取得事由名称());
			daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(k).get号取得日());
			daichoDivisionEntity.set喪失日(分割した被保険者台帳管理List.get(k).get喪失日());
			daichoDivisionEntity.set喪失事由コード(分割した被保険者台帳管理List.get(k).get喪失事由コード());
			daichoDivisionEntity.set喪失事由名称(分割した被保険者台帳管理List.get(k).get喪失事由名称());
			daichoDivisionEntity.set資格区分(分割した被保険者台帳管理List.get(k).get資格区分());
			daichoDivisionEntity.set号取得日(分割した被保険者台帳管理List.get(k).get号取得日());
			daichoDivisionEntity.set変更日(分割した被保険者台帳管理List.get(k).get変更日());
			daichoDivisionEntity.set変更事由コード(分割した被保険者台帳管理List.get(k).get変更事由コード());
			daichoDivisionEntity.set変更事由名称(分割した被保険者台帳管理List.get(k).get変更事由名称());
			daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(k).get住特適用日());
			daichoDivisionEntity.set住特適用日(分割した被保険者台帳管理List.get(k).get住特解除日());
			daichoDivisionEntity.set措置保険者(分割した被保険者台帳管理List.get(k).get措置保険者());
			daichoDivisionEntity.set旧保険者(分割した被保険者台帳管理List.get(k).get旧保険者());
			資格異動情報List.add(daichoDivisionEntity);
		    }

		}
	    }

	}

	return null;

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
	    return new ArrayList();
	}
	return entityList;

    }

    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者情報(HihokenshaDaichoSakuseiParameter parameter) {

	List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = 老齢福祉年金受給者Dac.select(parameter.getShikibetsuCode());

	if (entityList.isEmpty()) {
	    return new ArrayList();
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
	    return new ArrayList();
	}
	return entityList;

    }

    private DbT1008IryohokenKanyuJokyoEntity get介護保険医療保険情報(HihokenshaDaichoSakuseiParameter parameter) {

	DbT1008IryohokenKanyuJokyoEntity entity = 介護保険医療保険加入状況Dac.select(parameter.getShikibetsuCode());
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
	    entity.setJigyoshaNo(dbT7060KaigoJigyoshaEntity.getJigyoshaNo());
	    entity.setJigyoshaMeisho(dbT7060KaigoJigyoshaEntity.getJigyoshaName());
	}
	return entity;
    }

    private List get分割した老齢福祉年金受給者リスト(List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList) {
	List<RoreiFukushiNenkinJukyushaDivisionEntity> 分割した老齢福祉年金受給者List = new ArrayList();
	RoreiFukushiNenkinJukyushaDivisionEntity roreiDivisionEntity = new RoreiFukushiNenkinJukyushaDivisionEntity();
	int i = 1;
	int nocount = 0;
	for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
	    if ((nocount + 1) % 3 == 0) {
		roreiDivisionEntity.get老齢福祉No().add(String.valueOf(i));
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
	List 分割した証交付回収リスト = new ArrayList();
	List<String> ページのレコードを格納するリスト = new ArrayList<>();
	int i = 1;
	int nocount = 0;
	for (DbT7037ShoKofuKaishuEntity entity : entityList) {
	    if ((nocount + 1) % 3 == 0) {
		ページのレコードを格納するリスト.add(String.valueOf(i));
		ページのレコードを格納するリスト.add(entity.getKofuYMD().toString());
		//
		ページのレコードを格納するリスト.add(entity.getKaishuYMD().toString());
		ページのレコードを格納するリスト = new ArrayList<>();
	    }
	    nocount++;
	    i++;
	}
	if ((nocount + 1) % 3 != 0 && !ページのレコードを格納するリスト.isEmpty()) {
	    分割した証交付回収リスト.add(ページのレコードを格納するリスト);
	}

	return 分割した証交付回収リスト;

    }

    private List<HihokenshaDaichoDivisionEntity> get分割した被保険者台帳管理リスト(List<DbT1001HihokenshaDaichoEntity> entityList) {

	List<HihokenshaDaichoDivisionEntity> 分割した被保険者台帳管理List = new ArrayList();
	HihokenshaDaichoDivisionEntity hihokenshaDaichoDivisionEntity = new HihokenshaDaichoDivisionEntity();
	int i = 1;
	int nocount = 0;
	for (DbT1001HihokenshaDaichoEntity entity : entityList) {
	    if ((nocount + 1) % 5 == 0) {
		hihokenshaDaichoDivisionEntity.get資格異動No().add(String.valueOf(i));//TODO
		hihokenshaDaichoDivisionEntity.get取得日().add(entity.getShikakuShutokuYMD());
		hihokenshaDaichoDivisionEntity.get取得事由コード().add(entity.getShikakuShutokuJiyuCode());
		//ページのレコードを格納するリスト.add(null);
		hihokenshaDaichoDivisionEntity.get号取得日().add(entity.getIchigoShikakuShutokuYMD());
		hihokenshaDaichoDivisionEntity.get喪失日().add(entity.getShikakuSoshitsuYMD());
		hihokenshaDaichoDivisionEntity.get喪失事由コード().add(entity.getShikakuSoshitsuJiyuCode());
		//ページのレコードを格納するリスト.add(entity.getShikakuSoshitsuYMD());
		hihokenshaDaichoDivisionEntity.get資格区分().add(entity.getHihokennshaKubunCode());
		hihokenshaDaichoDivisionEntity.get変更日().add(entity.getShikakuHenkoYMD());
		hihokenshaDaichoDivisionEntity.get変更事由コード().add(entity.getShikakuHenkoJiyuCode());
		//ページのレコードを格納するリスト.add(entity.getHihokennshaKubunCode());
		hihokenshaDaichoDivisionEntity.get住特適用日().add(entity.getJushochitokureiTekiyoYMD());
		hihokenshaDaichoDivisionEntity.get住特解除日().add(entity.getJushochitokureiKaijoYMD());
		hihokenshaDaichoDivisionEntity.get措置保険者().add(entity.getKoikinaiTokureiSochimotoShichosonCode());
		hihokenshaDaichoDivisionEntity.get旧保険者().add(entity.getKyuShichosonCode());

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

}
