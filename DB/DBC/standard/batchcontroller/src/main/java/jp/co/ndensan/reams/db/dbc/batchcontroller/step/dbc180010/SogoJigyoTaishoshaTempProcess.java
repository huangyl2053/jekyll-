/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.SogoJigyoTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業対象者台帳一時テーブルにデータの編集を行う
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class SogoJigyoTaishoshaTempProcess extends BatchProcessBase<SogoJigyoTaishoshaTempEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.getSogoJigyoTaishoshaTemp");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID, processParameter.toNenjiRiyoshaFutanwariaiHanteiMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(new RString("SogoJigyoTaishoshaTempTable"), SogoJigyoTaishoshaTempEntity.class);
    }

    @Override
    protected void process(SogoJigyoTaishoshaTempEntity entity) {
        tempDbWriter.insert(entity);
    }

}
