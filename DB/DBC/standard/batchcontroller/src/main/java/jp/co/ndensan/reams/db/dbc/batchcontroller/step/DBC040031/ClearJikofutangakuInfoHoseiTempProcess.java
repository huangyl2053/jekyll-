/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 中間DBデータTempの削除プロセスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class ClearJikofutangakuInfoHoseiTempProcess extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper"
            + ".get中間DBデータ");
    private static final RString TABLENAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 中間DBデータTemp;

    @Override
    protected void createWriter() {
        中間DBデータTemp = new BatchEntityCreatedTempTableWriter(TABLENAME, KogakugassanJikofutangakuInfoHoseiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(KogakugassanJikofutangakuInfoHoseiTempEntity entity) {
        中間DBデータTemp.delete(entity);
    }
}
