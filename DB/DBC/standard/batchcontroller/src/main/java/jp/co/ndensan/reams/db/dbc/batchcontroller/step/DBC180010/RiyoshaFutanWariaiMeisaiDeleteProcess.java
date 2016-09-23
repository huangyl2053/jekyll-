/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合明細の編集を行う
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class RiyoshaFutanWariaiMeisaiDeleteProcess extends BatchProcessBase<DbT3114RiyoshaFutanWariaiMeisaiEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.delete利用者負担割合明細");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;
    @BatchWriter
    BatchPermanentTableWriter<DbT3114RiyoshaFutanWariaiMeisaiEntity> tableWrite;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID, processParameter.toNenjiRiyoshaFutanwariaiHanteiMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tableWrite = new BatchPermanentTableWriter<>(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
    }

    @Override
    protected void process(DbT3114RiyoshaFutanWariaiMeisaiEntity entity) {
        tableWrite.delete(entity);

    }

}
