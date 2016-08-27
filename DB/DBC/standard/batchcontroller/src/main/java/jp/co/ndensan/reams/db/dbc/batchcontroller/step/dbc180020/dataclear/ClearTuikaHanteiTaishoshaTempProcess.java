/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 追加判定対象者Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearTuikaHanteiTaishoshaTempProcess extends BatchProcessBase<SetainJohoTempEntity> {

    private static final RString TABLENAME = new RString("TuikaHanteiTaishoshaTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select追加判定対象者Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 追加判定対象者Temp;

    @Override
    protected void createWriter() {
        追加判定対象者Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, SetainJohoTempEntity.class);
    }

    @Override
    protected void process(SetainJohoTempEntity entity) {
        追加判定対象者Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
