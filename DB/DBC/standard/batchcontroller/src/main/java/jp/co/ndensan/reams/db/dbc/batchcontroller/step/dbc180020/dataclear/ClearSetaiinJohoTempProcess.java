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
 * 世帯員情報Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearSetaiinJohoTempProcess extends BatchProcessBase<SetainJohoTempEntity> {

    private static final RString TABLENAME = new RString("SetaiinJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select世帯員情報Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員情報Temp;

    @Override
    protected void createWriter() {
        世帯員情報Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, SetainJohoTempEntity.class);
    }

    @Override
    protected void process(SetainJohoTempEntity entity) {
        世帯員情報Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
