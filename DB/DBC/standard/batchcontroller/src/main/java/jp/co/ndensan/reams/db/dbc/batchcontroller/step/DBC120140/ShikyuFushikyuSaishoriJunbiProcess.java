/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120140.ShikyuFushikyuSaishoriJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再処理準備。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuSaishoriJunbiProcess extends BatchProcessBase<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> {

    private ShikyuFushikyuSaishoriJunbiProcessParameter parameter;
    private ShikyuFushikyuMyBatisParameter myBatisParameter;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get削除予定前回処理データ");

    @BatchWriter
    private BatchPermanentTableWriter 高額合算支給不支給決定tableWriter;

    @Override
    protected void initialize() {
        myBatisParameter = new ShikyuFushikyuMyBatisParameter();
        myBatisParameter.set処理区分(parameter.get処理区分());
        myBatisParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定tableWriter
                = new BatchPermanentTableWriter(
                        DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        高額合算支給不支給決定tableWriter.delete(entity);
    }

}
