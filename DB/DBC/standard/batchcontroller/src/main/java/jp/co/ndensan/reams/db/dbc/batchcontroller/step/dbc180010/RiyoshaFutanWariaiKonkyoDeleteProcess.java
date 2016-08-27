/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合世帯員データの編集を行う
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class RiyoshaFutanWariaiKonkyoDeleteProcess extends BatchProcessBase<DbT3115RiyoshaFutanWariaiKonkyoEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.delete利用者負担割合世帯員");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;
    @BatchWriter
    BatchPermanentTableWriter<DbT3115RiyoshaFutanWariaiKonkyoEntity> tableWrite;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID, processParameter.toNenjiRiyoshaFutanwariaiHanteiMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tableWrite = new BatchPermanentTableWriter<>(DbT3115RiyoshaFutanWariaiKonkyoEntity.class);
    }

    @Override
    protected void process(DbT3115RiyoshaFutanWariaiKonkyoEntity entity) {
        tableWrite.delete(entity);

    }

}
