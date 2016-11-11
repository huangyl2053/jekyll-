/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 実績基本データTempの削除プロセスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class ClearJissekiFutangakuDataTempProcess extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper"
            + ".get実績基本データ");
    private static final RString TABLENAME = new RString("JissekiFutangakuDataTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 実績基本データTemp;

    @Override
    protected void createWriter() {
        実績基本データTemp = new BatchEntityCreatedTempTableWriter(TABLENAME, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity entity) {
        実績基本データTemp.delete(entity);
    }

}
