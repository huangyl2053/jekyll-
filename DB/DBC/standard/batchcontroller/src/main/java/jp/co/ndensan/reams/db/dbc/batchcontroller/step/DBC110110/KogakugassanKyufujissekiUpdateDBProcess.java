/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiUpdateDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成のDB更新Process
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiUpdateDBProcess extends BatchProcessBase<DbT3075KogakuGassanKyufuJissekiEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout."
            + "IKogakugassanKyufujissekiOutMapper.get高額合算給付実績更新対象");

    private KogakugassanKyufujissekiUpdateDBProcessParameter parameter;

    @BatchWriter
    BatchPermanentTableWriter 高額合算給付実績Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        高額合算給付実績Writer = new BatchPermanentTableWriter(DbT3075KogakuGassanKyufuJissekiEntity.class);
    }

    @Override
    protected void process(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        if (parameter.is送付除外フラグ()) {
            entity.setShoriYM(FlexibleYearMonth.EMPTY);
            entity.setSofuYM(FlexibleYearMonth.EMPTY);
        } else {
            entity.setShoriYM(parameter.get処理年月());
            entity.setSofuYM(parameter.get処理年月());
        }
        高額合算給付実績Writer.update(entity);
    }

}
