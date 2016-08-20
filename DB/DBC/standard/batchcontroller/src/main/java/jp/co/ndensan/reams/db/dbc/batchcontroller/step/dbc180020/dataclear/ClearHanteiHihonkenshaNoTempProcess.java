/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.HihokenshaNoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者番号Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearHanteiHihonkenshaNoTempProcess extends BatchProcessBase<HihokenshaNoEntity> {

    private static final RString TABLENAME = new RString("HanteiHihonkenshaNoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select被保険者番号Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 被保険者番号Temp;

    @Override
    protected void createWriter() {
        被保険者番号Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, HihokenshaNoEntity.class);
    }

    @Override
    protected void process(HihokenshaNoEntity entity) {
        被保険者番号Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
