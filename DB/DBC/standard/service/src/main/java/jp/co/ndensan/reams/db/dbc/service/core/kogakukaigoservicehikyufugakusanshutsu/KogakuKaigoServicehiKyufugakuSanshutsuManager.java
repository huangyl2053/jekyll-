/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufugakusanshutsu;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3056KogakuShikyuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3058KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3110JigyoKogakuShikyuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3112KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護サービス費内容登録Mangerです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
public class KogakuKaigoServicehiKyufugakuSanshutsuManager {

    private final DbT3054KogakuKyufuTaishoshaMeisaiDac dbt3054Dac;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac dbt3055Dac;
    private final DbT3056KogakuShikyuShinseiDac dbt3056Dac;
    private final DbT3057KogakuShikyuHanteiKekkaDac dbt3057Dac;
    private final DbT3058KogakuShikyuShinsaKetteiDac dbt3058Dac;
    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac dbt3108Dac;
    private final DbT3109JigyoKogakuKyufuTaishoshaGokeiDac dbt3109Dac;
    private final DbT3110JigyoKogakuShikyuShinseiDac dbt3110Dac;
    private final DbT3111JigyoKogakuShikyuHanteiKekkaDac dbt3111Dac;
    private final DbT3112KogakuShikyuShinsaKetteiDac dbt3112Dac;

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServicehiKyufugakuSanshutsuManager() {
        this.dbt3054Dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        this.dbt3055Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        this.dbt3056Dac = InstanceProvider.create(DbT3056KogakuShikyuShinseiDac.class);
        this.dbt3057Dac = InstanceProvider.create(DbT3057KogakuShikyuHanteiKekkaDac.class);
        this.dbt3058Dac = InstanceProvider.create(DbT3058KogakuShikyuShinsaKetteiDac.class);
        this.dbt3108Dac = InstanceProvider.create(DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac.class);
        this.dbt3109Dac = InstanceProvider.create(DbT3109JigyoKogakuKyufuTaishoshaGokeiDac.class);
        this.dbt3110Dac = InstanceProvider.create(DbT3110JigyoKogakuShikyuShinseiDac.class);
        this.dbt3111Dac = InstanceProvider.create(DbT3111JigyoKogakuShikyuHanteiKekkaDac.class);
        this.dbt3112Dac = InstanceProvider.create(DbT3112KogakuShikyuShinsaKetteiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKaigoServicehiKyufugakuSanshutsuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKaigoServicehiKyufugakuSanshutsuManager}のインスタンス
     */
    public static KogakuKaigoServicehiKyufugakuSanshutsuManager createInstance() {
        return InstanceProvider.create(KogakuKaigoServicehiKyufugakuSanshutsuManager.class);
    }

    /**
     * 高額介護サービス費給付対象者明細を登録します。
     *
     * @param entity DbT3054KogakuKyufuTaishoshaMeisaiEntity
     */
    public void save高額介護サービス費給付対象者明細(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3054Dac.save(entity);
    }

    /**
     * 高額介護サービス費支給申請を登録します。
     *
     * @param entity DbT3056KogakuShikyuShinseiEntity
     */
    public void save高額介護サービス費支給申請(DbT3056KogakuShikyuShinseiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3056Dac.save(entity);
    }

    /**
     * 高額介護サービス費支給判定結果を登録します。
     *
     * @param entity DbT3057KogakuShikyuHanteiKekkaEntity
     */
    public void save高額介護サービス費支給判定結果(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3057Dac.save(entity);
    }

    /**
     * 高額介護サービス費支給審査決定を登録します。
     *
     * @param entity DbT3058KogakuShikyuShinsaKetteiEntity
     */
    public void save高額介護サービス費支給審査決定(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3058Dac.insert(entity);
    }

    /**
     * 高額介護サービス費給付対象者合計を登録します。
     *
     * @param entity DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    public void save高額介護サービス費給付対象者合計(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3055Dac.save(entity);
    }

    /**
     * 事業高額介護サービス費給付対象者明細を登録します。
     *
     * @param entity DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity
     */
    public void save事業高額介護サービス費給付対象者明細(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3108Dac.save(entity);
    }

    /**
     * 事業高額介護サービス費支給申請を登録します。
     *
     * @param entity DbT3110JigyoKogakuShikyuShinseiEntity
     */
    public void save事業高額介護サービス費支給申請(DbT3110JigyoKogakuShikyuShinseiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3110Dac.save(entity);
    }

    /**
     * 事業高額介護サービス費支給判定結果を登録します。
     *
     * @param entity DbT3111JigyoKogakuShikyuHanteiKekkaEntity
     */
    public void save事業高額介護サービス費支給判定結果(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3111Dac.save(entity);
    }

    /**
     * 事業高額介護サービス費支給審査決定を登録します。
     *
     * @param entity DbT3112KogakuShikyuShinsaKetteiEntity
     */
    public void save事業高額介護サービス費支給審査決定(DbT3112KogakuShikyuShinsaKetteiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3112Dac.save(entity);
    }

    /**
     * 事業高額介護サービス費給付対象者合計を登録します。
     *
     * @param entity DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity
     */
    public void save事業高額介護サービス費給付対象者合計(DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt3109Dac.save(entity);
    }
}
