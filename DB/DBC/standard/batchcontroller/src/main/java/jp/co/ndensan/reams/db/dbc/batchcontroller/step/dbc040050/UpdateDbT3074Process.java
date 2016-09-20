/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給不支給決定の決定通知書作成年月日を更新processクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public class UpdateDbT3074Process extends BatchProcessBase<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanshikyuketteitsuchisho.IKogakugassanShikyuKetteitsuchishoMapper.get中間DB_高額合算支給決定通知書データ");
    private KogakugassanShikyuKetteitsuchishoProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchPermanentTableWriter(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        entity.setKetteiTsuchiSakuseiYMD(processParameter.get決定日());
        tempDbWriter.update(entity);
    }

}
