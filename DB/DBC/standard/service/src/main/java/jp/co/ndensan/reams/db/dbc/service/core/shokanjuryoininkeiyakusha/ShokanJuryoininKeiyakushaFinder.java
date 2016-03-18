/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ChkKeiyakuNoParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ChkTorokuzumiParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3078ShokanJuryoininKeiyakushaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanjuryoininkeiyakusha.IShokanJuryoininKeiyakushaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会
 */
public class ShokanJuryoininKeiyakushaFinder {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT3078ShokanJuryoininKeiyakushaDac 償還受領委任契約者Dac;

    /**
     * コンストラクタです。
     */
    public ShokanJuryoininKeiyakushaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.償還受領委任契約者Dac = InstanceProvider.create(DbT3078ShokanJuryoininKeiyakushaDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 被保険者台帳管理Dac 被保険者台帳管理Dac
     * @param 償還受領委任契約者Dac 償還受領委任契約者Dac
     */
    ShokanJuryoininKeiyakushaFinder(MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
            DbT3078ShokanJuryoininKeiyakushaDac 償還受領委任契約者Dac) {
        this.mapperProvider = mapperProvider;
        this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
        this.償還受領委任契約者Dac = 償還受領委任契約者Dac;
    }

    /**
     * 契約者一覧取得
     *
     * @param parameter parameter
     * @return List<ShokanJuryoininKeiyakusha>
     */
    public List<ShokanJuryoininKeiyakusha> getShokanJuryoininKeiyakushaList(ShokanJuryoininKeiyakushaParameter parameter) {

        List<ShokanJuryoininKeiyakusha> kushaList = new ArrayList<>();
        ShokanJuryoininKeiyakushaListParameter param
                = ShokanJuryoininKeiyakushaListParameter.createSelectByKeyParam(parameter.get被保険者番号(),
                        parameter.get契約決定日FROM(), parameter.get契約申請日TO(), parameter.get契約決定日FROM(),
                        parameter.get契約決定日TO(), parameter.get契約事業者番号(), parameter.get契約サービス種類(),
                        parameter.get契約年度(), parameter.get契約番号());
        IShokanJuryoininKeiyakushaMapper mapper = mapperProvider.create(IShokanJuryoininKeiyakushaMapper.class);
        List<DbT3078ShokanJuryoininKeiyakushaEntity> entityList = mapper.get契約事業者一覧(param);
        if (entityList == null || entityList.isEmpty()) {
            return kushaList;
        }
        for (DbT3078ShokanJuryoininKeiyakushaEntity entity : entityList) {
            DbT1001HihokenshaDaichoEntity dbt1001entity = 被保険者台帳管理Dac.get被保険者証資格証発行情報(entity.getHihokenshaNo());
            if (dbt1001entity != null) {
                IAtesakiGyomuHanteiKey 宛先業務判定キー
                        = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
                IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー)
                        .set識別コード(dbt1001entity.getShikibetsuCode())
                        .build();
                List<IAtesaki> 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(searchKey);
                //QA.334(Redmine#:78267)
                entity.setBiko(宛先s.get(0).get備考());
            }
            kushaList.add(new ShokanJuryoininKeiyakusha(entity));
        }
        return kushaList;
    }

    /**
     * 登録処理
     *
     * @param kusha kusha
     * @return 登録件数
     */
    public int insShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakusha kusha) {

        DbT3078ShokanJuryoininKeiyakushaEntity entity = kusha.toEntity();
        entity.setState(EntityDataState.Added);
        return 償還受領委任契約者Dac.save(entity);
    }

    /**
     * 修正処理
     *
     * @param kusha kusha
     * @return 更新件数
     */
    public int updShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakusha kusha) {

        DbT3078ShokanJuryoininKeiyakushaEntity entity = kusha.toEntity();
        entity.setState(EntityDataState.Modified);
        return 償還受領委任契約者Dac.save(entity);
    }

    /**
     * 削除処理
     *
     * @param kusha kusha
     */
    public void delShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakusha kusha) {

        DbT3078ShokanJuryoininKeiyakushaEntity entity = kusha.toEntity();
        entity.setState(EntityDataState.Deleted);
        償還受領委任契約者Dac.delete(entity);
    }

    /**
     * 償還受領委任契約者取得
     *
     * @param 被保険者番号 被保険者番号
     * @param 申請年月日 申請年月日
     * @param 契約事業者番号 契約事業者番号
     * @param 契約サービス種類 契約サービス種類
     * @return ShokanJuryoininKeiyakusha 契約事業者一覧取得データがない場合、NULLで返却し
     */
    public ShokanJuryoininKeiyakusha getShokanJuryoininKeiyakusha(HihokenshaNo 被保険者番号,
            FlexibleDate 申請年月日,
            RString 契約事業者番号,
            RString 契約サービス種類) {

        DbT3078ShokanJuryoininKeiyakushaEntity entity
                = 償還受領委任契約者Dac.selectByKey(被保険者番号, 申請年月日, 契約事業者番号, 契約サービス種類);
        if (entity == null) {
            return null;
        }
        return new ShokanJuryoininKeiyakusha(entity);
    }

    /**
     * 受領委任契約番号存在チェック
     *
     * @param parameter parameter
     * @return チェックフラグ
     */
    public boolean chkKeiyakuNo(ChkKeiyakuNoParameter parameter) {
        RStringBuilder builder = new RStringBuilder();
        RString 新受領委任契約番号 = builder.append(parameter.get年度().toDateString()).
                append(parameter.get番号1() == null ? RString.EMPTY : parameter.get番号1()).
                append(parameter.get番号2() == null ? RString.EMPTY : parameter.get番号2()).toRString();
        List<DbT3078ShokanJuryoininKeiyakushaEntity> entityList
                = 償還受領委任契約者Dac.select償還受領委任契約者(新受領委任契約番号);
        if (entityList == null || entityList.isEmpty()) {
            return true;
        }
        if (new RString("登録").equals(parameter.get画面モード())) {
            return false;
        }
        if (!new RString("修正").equals(parameter.get画面モード())) {
            return true;
        }
        for (DbT3078ShokanJuryoininKeiyakushaEntity entity : entityList) {
            if (entity.getHihokenshaNo().equals(parameter.get被保険者番号())
                    && entity.getShinseiYMD().equals(parameter.get修正前_申請年月日())
                    && entity.getKeiyakuJigyoshaNo().equals(parameter.get修正前_契約事業者番号())
                    && entity.getKeiyakuServiceShurui().equals(parameter.get修正前_契約サービス種類())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 登録済みチェック
     *
     * @param parameter parameter
     * @return チェックフラグ
     */
    public boolean chkTorokuzumi(ChkTorokuzumiParameter parameter) {
        DbT3078ShokanJuryoininKeiyakushaEntity entity
                = 償還受領委任契約者Dac.selectByKey(parameter.get被保険者番号(), parameter.get申請年月日(),
                        parameter.get契約事業者番号(), parameter.get契約サービス種類());

        if (entity == null) {
            return true;
        }
        if (new RString("登録").equals(parameter.get画面モード())) {
            return false;
        }
        if (!new RString("修正").equals(parameter.get画面モード())) {
            return true;
        }
        return (entity.getHihokenshaNo().equals(parameter.get被保険者番号())
                && entity.getShinseiYMD().equals(parameter.get修正前_申請年月日())
                && entity.getKeiyakuJigyoshaNo().equals(parameter.get修正前_契約事業者番号())
                && entity.getKeiyakuServiceShurui().equals(parameter.get修正前_契約サービス種類()));
    }
}
