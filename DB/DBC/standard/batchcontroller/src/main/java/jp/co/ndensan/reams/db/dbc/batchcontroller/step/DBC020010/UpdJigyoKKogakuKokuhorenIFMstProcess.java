/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * バッチ設計_DBCMN41002_高額介護サービス費給付対象者登録Processのクラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class UpdJigyoKKogakuKokuhorenIFMstProcess extends SimpleBatchProcessBase {

    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter parameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper = InstanceProvider.create(MapperProvider.class).
                create(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        mapper.update事業高額介護国保連IFマスタ(parameter.toCreateUpdKogakuKokuhorenIFMstMybatisParameter());
    }

}
