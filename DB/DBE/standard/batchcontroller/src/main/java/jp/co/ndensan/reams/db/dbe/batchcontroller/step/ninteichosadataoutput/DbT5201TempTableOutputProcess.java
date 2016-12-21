/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbT5201NinteichosaIraiJohoデータを一時テーブルに格納するクラスです。
 */
public class DbT5201TempTableOutputProcess extends BatchProcessBase<DbT5201NinteichosaIraiJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "getDbT5201NinteichosaIraiJohoForTempTable");
    private NinteiChosaDataOutputProcessParamter processParamter;
    
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT5201NinteichosaIraiJohoEntity> tempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaDataOutputBatchMybitisParameter());
    }

    @Override
    public void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(
                processParamter.getCsvTempTableName(), DbT5201NinteichosaIraiJohoEntity.class, true);
    }
    
    @Override
    protected void process(DbT5201NinteichosaIraiJohoEntity entity) {
        tempTableWriter.insert(entity);
    }

}
