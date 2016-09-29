/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsChoshuHoho2ProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * （特徴異動）徴収方法の追加します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsChoshuHoho2Process extends BatchProcessBase<DbT2001ChoshuHohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get特徴異動_徴収方法の追加情報");

    private InsChoshuHoho2ProcessParameter parameter;
    @BatchWriter
    BatchPermanentTableWriter 徴収方法TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectChoshuHohoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        徴収方法TableWriter = new BatchPermanentTableWriter(DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected void process(DbT2001ChoshuHohoEntity t) {
        t.setIraiSohuzumiFlag(true);
        int 履歴番号 = t.getRirekiNo() + 1;
        t.setRirekiNo(履歴番号);
        徴収方法TableWriter.insert(t);
    }

}
