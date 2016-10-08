/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の被保険者判定Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutHihokenshaHanteiProcess extends BatchProcessBase<DbWT2111ShokanShinseiTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get被保険者がないのデータ");
    private static final RString 償還払支給申請一時TABLE_NAME = new RString("DbWT2111ShokanShinsei");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払支給申請一時Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH);
    }

    @Override
    protected void createWriter() {
        償還払支給申請一時Writer = new BatchEntityCreatedTempTableWriter(償還払支給申請一時TABLE_NAME,
                DbWT2111ShokanShinseiTempEntity.class);
    }

    @Override
    protected void process(DbWT2111ShokanShinseiTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        償還払支給申請一時Writer.update(entity);
    }

}
