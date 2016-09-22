/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuRirikoNoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 最大履歴番号取得する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuRirekiNoTorokuProcess extends BatchProcessBase<ShikyuFushikyuRirikoNoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get最大履歴番号");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給不支給決定一時tableWriter;
    private static final RString 高額合算支給不支給決定一時_TABLE_NAME
            = new RString("DbWT38B1KogakuGassanShikyuFushikyuKettei");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給不支給決定一時_TABLE_NAME,
                        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(ShikyuFushikyuRirikoNoEntity entity) {
        entity.get通知書データ().set履歴番号(entity.get最大履歴番号() + 1);
        高額合算支給不支給決定一時tableWriter.update(entity.get通知書データ().toEntity());
    }

}
