/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050023;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼済の取消_事業高額合算クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class DelJigyoKogakuGassanKetteiProcess extends BatchProcessBase<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get依頼済の取消_事業高額合算");

    @BatchWriter
    private BatchPermanentTableWriter 事業高額合算支給不支給決定tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        事業高額合算支給不支給決定tableWriter = new BatchPermanentTableWriter(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity t) {
        t.setFurikomiTsuchiSakuseiYMD(FlexibleDate.EMPTY);
        事業高額合算支給不支給決定tableWriter.update(t);
    }

}
