/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.toushoshotokujohochushutsurenkei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.toushoshotokujohochushutsurenkei.IToushoShotokuJohoChushutsuRenkeiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 所得情報抽出・連携バッチのFinderです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class ToushoShotokuJohoChushutsuRenkeiFinder {

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    ToushoShotokuJohoChushutsuRenkeiFinder() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ToushoShotokuJohoChushutsuRenkeiFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ToushoShotokuJohoChushutsuRenkeiFinder}のインスタンス
     */
    public static ToushoShotokuJohoChushutsuRenkeiFinder createInstance() {
        return InstanceProvider.create(ToushoShotokuJohoChushutsuRenkeiFinder.class);
    }

    /**
     * 介護所得Tempを返します。
     *
     * @return List<KaigoShotoTempTableEntity>
     */
    public List<KaigoShotoTempTableEntity> get介護所得Temp() {
        IToushoShotokuJohoChushutsuRenkeiMapper mapper = mapperProvider.create(IToushoShotokuJohoChushutsuRenkeiMapper.class);
        List<KaigoShotoTempTableEntity> list = mapper.get介護所得Temp();
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /**
     * 処理日付管理マスタの更新
     *
     * @param dbt7022Entity DbT7022ShoriDateKanriEntity
     */
    public void update(DbT7022ShoriDateKanriEntity dbt7022Entity) {
        dbt7022Entity.setState(EntityDataState.Modified);
        dac.save(dbt7022Entity);
    }

    /**
     * 処理日付管理マスタの更新
     *
     * @param dbt7022Entity DbT7022ShoriDateKanriEntity
     */
    public void insert(DbT7022ShoriDateKanriEntity dbt7022Entity) {
        dbt7022Entity.setState(EntityDataState.Added);
        dac.save(dbt7022Entity);
    }
}
