/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別判定対象者Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearTsukibetsuHanteiTaishoshaTempProcess extends BatchProcessBase<HanteiTaishoshaTempEntity> {

    private static final RString TABLENAME = new RString("TsukibetsuHanteiTaishoshaTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select月別判定対象者Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 月別判定対象者Temp;

    @Override
    protected void createWriter() {
        月別判定対象者Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(HanteiTaishoshaTempEntity entity) {
        月別判定対象者Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
