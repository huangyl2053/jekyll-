/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額介護サービス費支給申請DB更新を処理します。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class UpdateDbT3056KogakuShikyuShinseiProcess extends BatchProcessBase<DbT3056KogakuShikyuShinseiEntity> {

    private static final RString 高額介護サービス費支給申請取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.get高額介護サービス費支給申請");
    private static final int NUM_4 = 4;

    @BatchWriter
    BatchPermanentTableWriter<DbT3056KogakuShikyuShinseiEntity> dbT3056Writer;

    KogakuKaigoServiceProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(高額介護サービス費支給申請取得SQL);
    }

    @Override
    protected void createWriter() {
        dbT3056Writer = new BatchPermanentTableWriter(DbT3056KogakuShikyuShinseiEntity.class);
    }

    @Override
    protected void process(DbT3056KogakuShikyuShinseiEntity entity) {
        entity.setShiharaiBasho(parameter.get支払場所());
        entity.setShiharaiKaishiYMD(parameter.get支払期間From() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(parameter.get支払期間From().toDateString()));
        entity.setShiharaiShuryoYMD(parameter.get支払期間To() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(parameter.get支払期間To().toDateString()));
        entity.setShiharaiKaishiTime(parameter.get開始時間() == null
                ? RString.EMPTY : parameter.get開始時間().toFormattedTimeString(DisplayTimeFormat.HH時mm分).remove(2).remove(NUM_4));
        entity.setShiharaiShuryoTime(parameter.get終了時間() == null
                ? RString.EMPTY : parameter.get終了時間().toFormattedTimeString(DisplayTimeFormat.HH時mm分).remove(2).remove(NUM_4));
        dbT3056Writer.update(entity);
    }

    @Override
    protected void afterExecute() {

    }

}
