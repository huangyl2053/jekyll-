/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額総合事業サービス費支給（不支給）決定通知書作成のDB更新処理Processです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class UpdateKogakuKaigoServicehiHanteiKekkaProcess extends
        BatchProcessBase<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get更新の判定結果データ");

    private KogakuKaigoServiceProcessParameter parameter;
    ServicehiShikyuKetteiTsuchisho manager;

    @BatchWriter
    BatchPermanentTableWriter<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> 支給判定結果Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toパラメータ());
    }

    @Override
    protected void createWriter() {

        支給判定結果Writer = new BatchPermanentTableWriter<>(DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
    }

    @Override
    protected void process(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {

        entity.setKetteiYMD(new FlexibleDate(parameter.get決定日().toDateString()));
        支給判定結果Writer.update(entity);
    }
}
