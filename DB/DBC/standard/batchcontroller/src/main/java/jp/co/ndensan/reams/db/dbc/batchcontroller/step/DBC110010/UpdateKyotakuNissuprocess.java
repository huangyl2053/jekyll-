/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅給付日数updateのクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class UpdateKyotakuNissuprocess extends BatchProcessBase<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010"
            + ".IKyufukanrihyoOutMapper.update居宅給付日数");
    @BatchWriter
    private BatchPermanentTableWriter 出力居宅給付日数;
    private KyufukanrihyoOutProcessParameter paramter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        出力居宅給付日数
                = new BatchPermanentTableWriter(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.class);
    }

    @Override
    protected void process(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity) {
        entity.setSofuYM(paramter.get処理年月());
        出力居宅給付日数.update(entity);
    }
}
