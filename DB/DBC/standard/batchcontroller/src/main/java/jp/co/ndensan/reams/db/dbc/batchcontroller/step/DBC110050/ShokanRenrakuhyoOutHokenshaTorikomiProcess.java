/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.HokenshaTorikomiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の保険者番号取込Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutHokenshaTorikomiProcess extends BatchProcessBase<HokenshaTorikomiEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get保険者番号取込データ");
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
    protected void process(HokenshaTorikomiEntity entity) {
        DbWT2111ShokanShinseiTempEntity tempEntity = entity.get償還一時Entity();
        tempEntity.setHokenshaNo(entity.get保険者番号());
        tempEntity.setHokenshaName(entity.get保険者名());
        償還払支給申請一時Writer.update(tempEntity);
    }

}
