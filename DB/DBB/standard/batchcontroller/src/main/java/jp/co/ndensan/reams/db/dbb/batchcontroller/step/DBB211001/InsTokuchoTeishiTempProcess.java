/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTeishiTempProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失等のデータ抽出します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTokuchoTeishiTempProcess extends BatchProcessBase<DbT2001ChoshuHohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get特徴停止のデータ");
    private static final RString TEMP_TABLE = new RString("特徴停止Temp");
    private InsTokuchoTeishiTempProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT2001ChoshuHohoEntity> 特徴停止TempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectTokuchoTeishiDataMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        特徴停止TempTableWriter = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected void process(DbT2001ChoshuHohoEntity t) {
        特徴停止TempTableWriter.insert(t);
    }

}
