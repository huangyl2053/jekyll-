/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519001.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.NinteiShinseiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.NinteiShinseiJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報抽出_process処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class NinteiShinseiJohoProcess extends BatchProcessBase<DbT4101NinteiShinseiJohoEntity> {

    private static final RString MYBATIS_MAPPER_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.INinteiShinseiJohoMapper.select要介護認定申請情報");
    private NinteiShinseiJohoProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(NinteiShinseiJohoTempEntity.TABLE_NAME, NinteiShinseiJohoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_MAPPER_ID, parameter.toNinteiShinseiJohoMybatisParameter());
    }

    @Override
    protected void process(DbT4101NinteiShinseiJohoEntity entity) {
        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        tableWriter.insert(manager.creatTempEntity(entity));
    }

}
