/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519001.InsNinteiGaibuDataOutputHistoryManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.InsNinteiGaibuDataOutputHistoryProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定外部データ出力履歴登録_process処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class InsNinteiGaibuDataOutputHistoryProcess extends BatchProcessBase<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.IInsNinteiGaibuDataOutputHistoryMapper.select出力履歴");
    private InsNinteiGaibuDataOutputHistoryProcessParameter parameter;
    private boolean isUpdate = false;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> tableWriter;

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybitsParameter());
    }

    @Override
    protected void process(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        InsNinteiGaibuDataOutputHistoryManager manager = new InsNinteiGaibuDataOutputHistoryManager();
        manager.set要介護認定外部データ出力履歴(entity, parameter);
        tableWriter.update(entity);
        isUpdate = true;
    }

    @Override
    protected void afterExecute() {
        if (!isUpdate) {
            InsNinteiGaibuDataOutputHistoryManager manager = new InsNinteiGaibuDataOutputHistoryManager();
            tableWriter.insert(manager.get出力履歴(parameter));
        }
    }
}
