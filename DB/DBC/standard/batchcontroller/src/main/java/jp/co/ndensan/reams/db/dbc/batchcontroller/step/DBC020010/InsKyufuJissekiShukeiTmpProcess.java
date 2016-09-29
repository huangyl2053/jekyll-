/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCopiedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績集計のバックアップのProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsKyufuJissekiShukeiTmpProcess extends BatchProcessBase<DbT3033KyufujissekiShukeiEntity> {

    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter parameter;

    @BatchWriter
    BatchCopiedTempTableWriter 給付実績集計一時tableWriter;

    private static final RString 給付実績集計一時_TABLE_NAME = new RString("TempKyufujissekiShukei");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select給付実績集計");

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        給付実績集計一時tableWriter = new BatchCopiedTempTableWriter(DbT3033KyufujissekiShukeiEntity.class, 給付実績集計一時_TABLE_NAME);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toMybatisParameter());
    }

    @Override
    protected void process(DbT3033KyufujissekiShukeiEntity entity) {
        給付実績集計一時tableWriter.insert(entity);
    }
}
