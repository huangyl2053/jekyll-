/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ作成のProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class UpdateNinteiShinseiJohoProcess extends BatchProcessBase<DbT5101NinteiShinseiJohoEntity> {

    private static final RString SELECT_NINTEISHINSEIJOHO = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getNinteiShinseiJoho");
    private CenterTransmissionUpdateProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5101NinteiShinseiJohoEntity> tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEISHINSEIJOHO, parameter.toCenterTransmissionUpdateMybitisParamter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT5101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(DbT5101NinteiShinseiJohoEntity entity) {
        entity.setIfSofuYMD(FlexibleDate.getNowDate());
        tableWriter.update(entity);

    }

}
