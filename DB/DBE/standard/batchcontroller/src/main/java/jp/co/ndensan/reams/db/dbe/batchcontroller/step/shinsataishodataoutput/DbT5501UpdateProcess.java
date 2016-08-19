/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会割当委員情報出力（モバイル）「DB介護認定審査会開催予定情報」の更新処理クラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class DbT5501UpdateProcess extends BatchProcessBase<DbT5501ShinsakaiKaisaiYoteiJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper."
            + "getDbT5501ShinsakaiKaisaiYoteiJoho");
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> dbT5501SEntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShinsaTaishoDataOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT5501SEntityWriter = new BatchPermanentTableWriter(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    @Override
    protected void process(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        dbT5501SEntityWriter.update(entity);
    }
}
