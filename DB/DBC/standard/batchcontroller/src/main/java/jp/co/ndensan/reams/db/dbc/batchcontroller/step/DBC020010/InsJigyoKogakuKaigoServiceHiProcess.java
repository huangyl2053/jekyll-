/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業高額介護サービス費追加のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsJigyoKogakuKaigoServiceHiProcess extends SimpleBatchProcessBase {

    @Override
    protected void beforeExecute() {
        IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper = InstanceProvider.create(MapperProvider.class).
                create(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        mapper.insert事業高額介護サービス費支給申請();
        mapper.insert事業高額介護サービス費支給判定結果();
        mapper.insert事業高額介護サービス費支給審査決定();
        mapper.insert事業高額介護サービス費給付対象者合計();
        mapper.update事業高額介護サービス費給付対象者合計();
        mapper.insert事業高額介護サービス給付対象者明細();
    }

    @Override
    protected void process() {
    }
}
