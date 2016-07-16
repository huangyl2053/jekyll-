/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.nushijuminjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.ShikibetsuTaishoEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nushijuminjoho.NushiJuminJohoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nushijuminjoho.INushiJuminJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2008ShotokuKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class NushiJuminJohoService {

    private final DbT2008ShotokuKanriDac dbt2008dac;
    private final DbT2020ShotokuShokaihyoHakkoRirekiDac dbt2020dac;
    private final MapperProvider mapperProvider;

    private static final int 整数_ONE = 1;
    private static final RString 文字列_ZERO = new RString("0");

    NushiJuminJohoService() {
        this.dbt2008dac = InstanceProvider.create(DbT2008ShotokuKanriDac.class);
        this.dbt2020dac = InstanceProvider.create(DbT2020ShotokuShokaihyoHakkoRirekiDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    NushiJuminJohoService(DbT2008ShotokuKanriDac dbt2008dac,
            DbT2020ShotokuShokaihyoHakkoRirekiDac dbt2020dac,
            MapperProvider mapperProvider) {
        this.dbt2008dac = dbt2008dac;
        this.dbt2020dac = dbt2020dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link}のインスタンス
     */
    public static NushiJuminJohoService createInstance() {
        return InstanceProvider.create(NushiJuminJohoService.class);
    }

    /**
     * get宛名識別対象
     *
     * @param shikibetsuTaishoPSMSearchKey IShikibetsuTaishoPSMSearchKey
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    public ShikibetsuTaishoEntity get宛名識別対象(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        NushiJuminJohoParameter nushiJuminJohoParameter
                = new NushiJuminJohoParameter(shikibetsuTaishoPSMSearchKey);
        INushiJuminJohoMapper nushiJuminJohoMapper = mapperProvider.create(INushiJuminJohoMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = nushiJuminJohoMapper.get宛名識別対象(nushiJuminJohoParameter);
        return new ShikibetsuTaishoEntity(宛名情報);
    }

    /**
     * get識別コード
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コードList List
     * @return List
     */
    public List<DbT2008ShotokuKanriEntity> get識別コード(FlexibleYear 所得年度, List<ShikibetsuCode> 識別コードList) {
        return dbt2008dac.selectShikibetsuCode(所得年度, 識別コードList);
    }

    /**
     * db出力
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コード ShikibetsuCode
     * @param 送付先地方公共団体コード LasdecCode
     * @param 世帯コード SetaiCode
     * @param 発行日 FlexibleDate
     */
    public void db出力(FlexibleYear 所得年度,
            ShikibetsuCode 識別コード,
            LasdecCode 送付先地方公共団体コード,
            SetaiCode 世帯コード,
            FlexibleDate 発行日) {
        DbT2008ShotokuKanriEntity entity = dbt2008dac.selectBySomeKey(所得年度, 識別コード);
        DbT2008ShotokuKanriEntity newEntity = new DbT2008ShotokuKanriEntity();
        newEntity.setShotokuNendo(所得年度);
        newEntity.setShikibetsuCode(識別コード);
        if (entity != null) {
            newEntity.setRirekiNo(entity.getRirekiNo() + 整数_ONE);
        } else {
            newEntity.setRirekiNo(整数_ONE);
        }
        newEntity.setKazeiKubun(KazeiKubun.所得調査中.getコード());
        newEntity.setKazeiKubunGemmenGo(KazeiKubun.所得調査中.getコード());
        newEntity.setGokeiShotokuGaku(Decimal.ZERO);
        newEntity.setNenkiniShunyuGaku(Decimal.ZERO);
        newEntity.setNenkiniShotokuGaku(Decimal.ZERO);
        newEntity.setKazeiShotokuGaku(Decimal.ZERO);
        newEntity.setGekihenKanwaKubun(文字列_ZERO);
        newEntity.setYusenKubun(文字列_ZERO);
        newEntity.setShoriTimeStamp(YMDHMS.now());
        newEntity.setState(EntityDataState.Added);
        dbt2008dac.save(newEntity);
        DbT2020ShotokuShokaihyoHakkoRirekiEntity dbt2020Entity = dbt2020dac.selectBySomeKey(所得年度, 識別コード);
        DbT2020ShotokuShokaihyoHakkoRirekiEntity dbt2020NewEntity = new DbT2020ShotokuShokaihyoHakkoRirekiEntity();
        dbt2020NewEntity.setShoriNendo(所得年度);
        dbt2020NewEntity.setShikibetsuCode(識別コード);
        if (dbt2020Entity != null) {
            dbt2020NewEntity.setRirekiNo(dbt2020Entity.getRirekiNo() + 整数_ONE);
        } else {
            dbt2020NewEntity.setRirekiNo(整数_ONE);
        }
        dbt2020NewEntity.setShokaisakiLasdecCode(送付先地方公共団体コード);
        dbt2020NewEntity.setSetaiCode(世帯コード);
        RString 発行ユーザＩＤ = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        dbt2020NewEntity.setHakkoReamsLoginId(発行ユーザＩＤ);
        dbt2020NewEntity.setHakkoYMD(発行日);
        dbt2020NewEntity.setSakuseiTimestamp(YMDHMS.now());
        dbt2020NewEntity.setState(EntityDataState.Added);
        dbt2020dac.save(dbt2020NewEntity);
    }
}
