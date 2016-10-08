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
 * 世帯員把握入力一時の更新のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class UpdSetaiinHaakuNyuryokuKogakuTmpProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        mapper.世帯員把握入力一時の更新1();
        mapper.世帯員把握入力一時の更新2();
        mapper.世帯員把握入力一時の更新3();
        mapper.世帯員把握入力一時の更新4();
    }
}
