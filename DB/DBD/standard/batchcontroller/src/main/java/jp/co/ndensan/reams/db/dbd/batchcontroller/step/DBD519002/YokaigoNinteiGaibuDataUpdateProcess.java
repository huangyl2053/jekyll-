/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519002.RenekeiDataSakuseiFourMasterCsvManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519002.RenekeiDataSakuseiFourMasterProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定外部データ出力履歴に更新。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
public class YokaigoNinteiGaibuDataUpdateProcess extends BatchProcessBase<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.")
            .concat("renekeidatasakuseifourmaster.IRenekeiDataSakuseiFourMasterMapper.get要介護認定外部データ出力履歴");
    private RenekeiDataSakuseiFourMasterProcessParameter para;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, para.toYokaigoNinteiGaibuDataMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity.class);
    }

    @Override
    protected void process(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        RenekeiDataSakuseiFourMasterCsvManager manager = new RenekeiDataSakuseiFourMasterCsvManager();
        if (entity == null) {
            tableWriter.insert(manager.dbT7204YokaigoNinteiGaibuDataOutputHistoryInsert(para));
        } else {
            tableWriter.update(manager.dbT7204YokaigoNinteiGaibuDataOutputHistoryUpdate(para, entity));
        }
    }
}
