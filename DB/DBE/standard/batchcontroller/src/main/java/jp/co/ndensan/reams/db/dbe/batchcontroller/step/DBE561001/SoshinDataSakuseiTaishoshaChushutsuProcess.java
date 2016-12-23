/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.SoshinDataSakuseiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送信データを作成する対象者を抽出するためのProcessクラスです。
 */
public class SoshinDataSakuseiTaishoshaChushutsuProcess extends BatchProcessBase<SoshinDataSakuseiTaishoshaTempEntity> {

    private static final RString SoshinDataSakuseiSql = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getSoshinDataSakuseiTaishosha");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SoshinDataSakuseiSql, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(
                SoshinDataSakuseiTaishoshaTempEntity.TABLE_NAME, SoshinDataSakuseiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(SoshinDataSakuseiTaishoshaTempEntity entity) {
        tableWriter.insert(entity);
    }
}
