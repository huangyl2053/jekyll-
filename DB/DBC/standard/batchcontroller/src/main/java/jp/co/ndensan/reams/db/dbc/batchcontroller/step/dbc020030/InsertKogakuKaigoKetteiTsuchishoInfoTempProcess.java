/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額サービス等支給（不支給）決定通知書情報一時TBLの登録処理のクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class InsertKogakuKaigoKetteiTsuchishoInfoTempProcess extends BatchProcessBase<KetteiTsuchishoInfoTempResultEntity> {

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額サービス決定通知書情報一時tableWriter;

    private static final RString 高額サービス決定通知書情報一時_TABLE_NAME = new RString("KetteiTsuchishoInfoTempEntity");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.select高額サービス情報");

    private KogakuKaigoServiceProcessParameter parameter;
    ServicehiShikyuKetteiTsuchisho manager;

    @Override
    protected void initialize() {
        manager = ServicehiShikyuKetteiTsuchisho.createInstance();
    }

    @Override
    protected void createWriter() {
        高額サービス決定通知書情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額サービス決定通知書情報一時_TABLE_NAME, KetteiTsuchishoInfoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toパラメータ());
    }

    @Override
    protected void process(KetteiTsuchishoInfoTempResultEntity entity) {
        高額サービス決定通知書情報一時tableWriter.insert(manager.to決定通知書情報(entity));
    }

    @Override
    protected void afterExecute() {

    }

}
