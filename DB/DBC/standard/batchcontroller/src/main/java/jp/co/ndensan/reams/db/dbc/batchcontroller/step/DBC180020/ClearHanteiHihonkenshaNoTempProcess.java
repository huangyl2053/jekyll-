/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 被保険者番号Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearHanteiHihonkenshaNoTempProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IRiyoshaFutanwariaiMapper mapper = getMapper(IRiyoshaFutanwariaiMapper.class);
        mapper.delete被保険者番号Temp();
    }

}
