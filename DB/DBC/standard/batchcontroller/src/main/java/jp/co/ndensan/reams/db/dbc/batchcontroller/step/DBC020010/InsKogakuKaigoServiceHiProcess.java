/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufugakusanshutsu.KogakuKaigoServicehiKyufugakuSanshutsuManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 高額介護サービス費追加のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsKogakuKaigoServiceHiProcess extends SimpleBatchProcessBase {

    private KogakuKaigoServicehiKyufugakuSanshutsuManager manager;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;

    @Override
    protected void beforeExecute() {
        manager = KogakuKaigoServicehiKyufugakuSanshutsuManager.createInstance();
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
    }

    @Override
    protected void process() {
        List<DbT3056KogakuShikyuShinseiEntity> 高額介護サービス費支給申請リスト = mapper.get高額介護サービス費支給申請();
        for (DbT3056KogakuShikyuShinseiEntity entity : 高額介護サービス費支給申請リスト) {
            manager.save高額介護サービス費支給申請(entity);
        }
        List<DbT3057KogakuShikyuHanteiKekkaEntity> 高額介護サービス費支給判定結果リスト = mapper.get高額介護サービス費支給判定結果();
        for (DbT3057KogakuShikyuHanteiKekkaEntity entity : 高額介護サービス費支給判定結果リスト) {
            manager.save高額介護サービス費支給判定結果(entity);
        }
        List<DbT3058KogakuShikyuShinsaKetteiEntity> 高額介護サービス費支給審査決定リスト = mapper.get高額介護サービス費支給審査決定();
        for (DbT3058KogakuShikyuShinsaKetteiEntity entity : 高額介護サービス費支給審査決定リスト) {
            manager.save高額介護サービス費支給審査決定(entity);
        }
        List<DbT3055KogakuKyufuTaishoshaGokeiEntity> 高額介護サービス費給付対象者合計リスト = mapper.get高額介護サービス費給付対象者合計();
        for (DbT3055KogakuKyufuTaishoshaGokeiEntity entity : 高額介護サービス費給付対象者合計リスト) {
            manager.save高額介護サービス費給付対象者合計(entity);
        }
        mapper.update高額介護サービス費給付対象者合計();
        // QA確認中
//        mapper.insert高額介護サービス給付対象者明細();
    }
}
