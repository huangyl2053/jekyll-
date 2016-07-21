/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohokanrilist.SelectHenkouJohoMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.PublishReportProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.HenkouJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更管理リスト作成_バッチ処理クラスです。
 *
 * @reamsid_L DBD-3630-040 liangbc
 */
public class PublishReportProcess extends BatchProcessBase<HenkouJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohokanrilist."
                    + "IShiharaiHohoKanriListMapper.selectTaishoshaJoho");
    private PublishReportProcessParameter processParameter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, SelectHenkouJohoMapperParameter.createParameter(processParameter));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShiharaiHohoHenkoTempTableEntity.class)
                .tempTableName(ShiharaiHohoHenkoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(HenkouJohoEntity entity) {
//        ShiharaiHohoHenkoTempTableEntity tempTableEntity = PublishReportProcessSerivice.createIntance().createShiharaiHohoHenkoTempTableEntity(entity);
//        tmpTableWriter.insert(tempTableEntity);
    }
}
