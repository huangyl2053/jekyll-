/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼済の登録_高額合算クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class UpdKogakuGassanKetteiProcess extends BatchProcessBase<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get依頼済の登録_高額合算");

    @BatchWriter
    private BatchPermanentTableWriter 高額合算支給不支給決定tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定tableWriter = new BatchPermanentTableWriter(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        entity.setFurikomiTsuchiSakuseiYMD(FlexibleDate.getNowDate());
        高額合算支給不支給決定tableWriter.update(entity);
    }
}
