/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKariHenkoTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮徴収額変更の賦課情報を取得します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsKariHenkoTempProcess extends BatchProcessBase<DbT2002FukaJohoTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get仮徴収額変更の賦課情報");
    private static final RString TEMP_TABLE = new RString("仮徴収額変更Temp");

    private InsKariHenkoTempProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT2002FukaJohoTempTableEntity> 仮徴収額変更Temp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectKariHenkoTempMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        仮徴収額変更Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, DbT2002FukaJohoTempTableEntity.class);
    }

    @Override
    protected void process(DbT2002FukaJohoTempTableEntity t) {
        仮徴収額変更Temp.insert(t);
    }
}
