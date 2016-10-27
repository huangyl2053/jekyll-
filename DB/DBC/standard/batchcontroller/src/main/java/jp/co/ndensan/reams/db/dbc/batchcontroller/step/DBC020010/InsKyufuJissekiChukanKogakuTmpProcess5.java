/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 給付実績中間高額一時の作成5のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyufuJissekiChukanKogakuTmpProcess5 extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        mapper.insert給付実績中間高額一時の作成5();
        mapper.insert高額判定エラー一時();
    }
}
