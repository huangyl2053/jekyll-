/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002;

import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.entity.UzT0001StandardConfigEntity;

/**
 * 業務コンフィグ年度切替processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class UpdateUzT0001StandardConfigProcess extends BatchProcessBase<UzT0001StandardConfigEntity> {

    private NendoKirikaeProcessParameter processParameter;
    private static final int INT_1 = 1;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae."
            + "INendoKirikaeMapper.select業務コンフィグ");

    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(UzT0001StandardConfigEntity.class);
    }

    @Override
    protected void process(UzT0001StandardConfigEntity entity) {
        entity.setConfigValue(processParameter.get調定年度().plusYear(INT_1).toDateString());
        writer.update(entity);
    }
}
