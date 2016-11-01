/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsFukushiYoguTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求福祉用具販売費取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsFukushiYoguTempProcess extends BatchProcessBase<InsFukushiYoguTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get福祉用具販売費情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_10 = new RString("10");

    private ShokanRenrakuhyoOutProcessParameter parameter;
    private ShokanRenrakuhyoOutManager manager;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時tableWriter;

    @Override
    protected void initialize() {
        manager = ShokanRenrakuhyoOutManager.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toSofuMeisaiParameter());
    }

    @Override
    protected void createWriter() {
        一時tableWriter = new BatchEntityCreatedTempTableWriter(一時TABLE_NAME, DbWT2112ShokanMeisaiTempEntity.class);
    }

    @Override
    protected void process(InsFukushiYoguTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsFukushiYoguTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_10);
        tempEntity.setJigyoshaNo(entity.get福祉用具販売費Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get福祉用具販売費Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get福祉用具販売費Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get福祉用具販売費Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set福祉用具販売費(tempEntity, entity.get福祉用具販売費Entity());
        return tempEntity;
    }

    private void set福祉用具販売費(DbWT2112ShokanMeisaiTempEntity tempEntity, DbT3048ShokanFukushiYoguHanbaihiEntity entity) {

        tempEntity.setServiceCode(entity.getServiceCode());
        tempEntity.setFukushiYoguHanbaiYMD(entity.getFukushiYoguHanbaiYMD());
        tempEntity.setFukushiYoguShohinName(entity.getFukushiYoguShohinName());
        tempEntity.setFukushiYoguShumokuCode(entity.getFukushiYoguShumokuCode());
        tempEntity.setFukushiYoguSeizoJigyoshaName(entity.getFukushiYoguSeizoJigyoshaName());
        tempEntity.setFukushiYoguHanbaiJigyoshaName(entity.getFukushiYoguHanbaiJigyoshaName());
        tempEntity.setKounyuKingaku(entity.getKounyuKingaku());
        tempEntity.setHinmokuCode(entity.getHinmokuCode());
        tempEntity.setShinsaHohoKubunCode(entity.getShinsaHohoKubunCode());
        tempEntity.setSagakuKingaku(entity.getSagakuKingaku());
    }

}
