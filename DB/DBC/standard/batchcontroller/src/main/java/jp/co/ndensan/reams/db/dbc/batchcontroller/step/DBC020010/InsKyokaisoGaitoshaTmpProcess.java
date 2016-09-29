/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 境界層該当者のバックアップのProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyokaisoGaitoshaTmpProcess extends BatchProcessBase<DbT1006KyokaisoGaitoshaEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select境界層管理一時");
    private static final RString TABLE_境界層管理一時 = new RString("TempyokaisoGaitosha");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter yokaisoGaitoshaWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        yokaisoGaitoshaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_境界層管理一時, DbT1006KyokaisoGaitoshaEntity.class);
    }

    @Override
    protected void process(DbT1006KyokaisoGaitoshaEntity entity) {
        yokaisoGaitoshaWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
