/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 支払方法変更管理のバックアップのProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsShiharaiHohoHenkoKanriTmpProcess extends BatchProcessBase<DbT4021ShiharaiHohoHenkoEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select支払方法変更管理");
    private static final RString TABLE_支払方法変更管理一時 = new RString("TempShiharaiHohoHenko");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter shiharaiHohoHenkoWriter;

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
        shiharaiHohoHenkoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_支払方法変更管理一時, DbT4021ShiharaiHohoHenkoEntity.class);
    }

    @Override
    protected void process(DbT4021ShiharaiHohoHenkoEntity entity) {
        shiharaiHohoHenkoWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
