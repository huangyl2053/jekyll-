/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD180020;

import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 利用者負担割合明細08Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearRiyoshaFutanWariaiMeisai02TempProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IRiyoshaFutanwariaiMapper mapper = getMapper(IRiyoshaFutanwariaiMapper.class);
        mapper.delete利用者負担割合明細02Temp();
    }

}
