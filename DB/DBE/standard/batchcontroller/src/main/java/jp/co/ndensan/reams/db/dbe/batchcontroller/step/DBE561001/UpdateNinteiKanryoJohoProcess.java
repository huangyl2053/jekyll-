/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 死亡、転入データの要介護認定完了情報の更新を行うためのProcessクラスです。
 */
public class UpdateNinteiKanryoJohoProcess extends BatchProcessBase<DbT5105NinteiKanryoJohoEntity> {

    private static final RString SELECT_NINTEIKANRYOJOHO = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getNinteiKanryoJoho");
    private CenterTransmissionUpdateProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5105NinteiKanryoJohoEntity> tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEIKANRYOJOHO, parameter.toCenterTransmissionUpdateMybitisParamter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT5105NinteiKanryoJohoEntity.class);
    }

    @Override
    protected void process(DbT5105NinteiKanryoJohoEntity entity) {
        entity.setCenterSoshinYMD(FlexibleDate.getNowDate());
        tableWriter.update(entity);
    }
}
