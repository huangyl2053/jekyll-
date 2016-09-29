/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020010.KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護サービス費支給申請一時の作成のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsSaishoriKogakuShikyuSinseiTmpProcess extends BatchProcessBase<DbT3056KogakuShikyuShinseiEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select高額介護サービス費支給申請一時");
    private static final RString TABLE_高額介護サービス費支給申請一時 = new RString("TempKogakuShikyuShinsei");
    private KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kogakuShikyuShinseiWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        kogakuShikyuShinseiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請一時, DbT3056KogakuShikyuShinseiEntity.class);
    }

    @Override
    protected void process(DbT3056KogakuShikyuShinseiEntity entity) {
        kogakuShikyuShinseiWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
