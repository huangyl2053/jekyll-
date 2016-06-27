/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.roreifukushinenkinjoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.roreifukushinenkinjoho.IRoreiFukushiNenkinJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 【共有子Div】老齢福祉年金Finderです。
 *
 * @reamsid_L DBD-3560-090 wangjie2
 */
public class RoreiFukushiNenkinJohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    RoreiFukushiNenkinJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 【共有子Div】老齢福祉年金FinderのIntanceを作成します。
     *
     * @return RoreiFukushiNenkinJohoFinder
     */
    public static RoreiFukushiNenkinJohoFinder createIntance() {
        return InstanceProvider.create(RoreiFukushiNenkinJohoFinder.class);
    }

    /**
     * 老齢福祉年金情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<老齢福祉年金情報の情報>
     */
    @Transaction
    public List<RoreiFukushiNenkinJukyusha> get老齢福祉年金情報(HihokenshaNo 被保険者番号) {
        List<RoreiFukushiNenkinJukyusha> 老齢福祉年金情報List = new ArrayList<>();
        IRoreiFukushiNenkinJohoMapper mapper = mapperProvider.create(IRoreiFukushiNenkinJohoMapper.class);
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = mapper.get老齢福祉年金情報(被保険者番号);
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : entityList) {
            老齢福祉年金情報List.add(new RoreiFukushiNenkinJukyusha(entity));
        }
        return 老齢福祉年金情報List;
    }

}
