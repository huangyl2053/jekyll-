/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護該当情報Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearSeikatsuHogoGaitoJohoTempProcess extends BatchProcessBase<SeikatsuHogoGaitoJohoTempEntity> {

    private static final RString TABLENAME = new RString("SeikatsuHogoGaitoJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select生活保護該当情報Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 生活保護該当情報Temp;

    @Override
    protected void createWriter() {
        生活保護該当情報Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, SeikatsuHogoGaitoJohoTempEntity.class);
    }

    @Override
    protected void process(SeikatsuHogoGaitoJohoTempEntity entity) {
        生活保護該当情報Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
