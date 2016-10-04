/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiUpdateDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassankyufujissekiout.KogakugassanKyufujissekiOutService;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 高額合算給付実績情報作成のDB更新Process
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiUpdateDBProcess extends SimpleBatchProcessBase {

    private KogakugassanKyufujissekiUpdateDBProcessParameter parameter;

    @Override
    protected void process() {
        KogakugassanKyufujissekiOutService manager = KogakugassanKyufujissekiOutService.createInstance();
        manager.updateDB更新(parameter);
    }

}
