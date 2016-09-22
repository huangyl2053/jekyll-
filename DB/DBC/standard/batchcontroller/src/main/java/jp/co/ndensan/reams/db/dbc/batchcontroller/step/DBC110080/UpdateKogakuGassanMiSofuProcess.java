/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のDB更新_未送付Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class UpdateKogakuGassanMiSofuProcess extends BatchProcessBase<DbT3070KogakuGassanJikoFutanGakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get未送付高額合算自己負担額データ");
    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額3070tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額3070tableWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    @Override
    protected void process(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        entity.setHoseiZumi_SofuYM(FlexibleYearMonth.EMPTY);
        entity.setSaisoFlag(KokuhorenDataSaisoFlag.再送不要.getコード());
        高額合算自己負担額3070tableWriter.update(entity);
    }

}
