/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DB出力(予防給付日数)updateのクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class UpdateYoboKeikakuNissuProcess extends BatchProcessBase<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010"
            + ".IKyufukanrihyoOutMapper.update予防給付日数");
    @BatchWriter
    private BatchPermanentTableWriter 出力予防給付日数;
    private KyufukanrihyoOutProcessParameter paramter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        出力予防給付日数
                = new BatchPermanentTableWriter(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.class);
    }

    @Override
    protected void process(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity) {
        entity.setSofuYM(paramter.get処理年月());
        出力予防給付日数.update(entity);
    }
}
