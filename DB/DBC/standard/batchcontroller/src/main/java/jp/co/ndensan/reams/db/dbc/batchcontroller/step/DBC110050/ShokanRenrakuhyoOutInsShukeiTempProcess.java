/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求集計情報取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsShukeiTempProcess extends BatchProcessBase<InsShukeiTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get償還払請求集計情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_12 = new RString("12");

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
    protected void process(InsShukeiTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsShukeiTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_12);
        tempEntity.setJigyoshaNo(entity.get集計Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get集計Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get集計Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get集計Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set集計情報(tempEntity, entity.get集計Entity());
        return tempEntity;
    }

    private void set集計情報(DbWT2112ShokanMeisaiTempEntity tempEntity, DbT3053ShokanShukeiEntity entity) {

        tempEntity.setServiceShuruiCode(entity.getServiceShuruiCode());
        tempEntity.setServiceJitsunissu(entity.getServiceJitsunissu());
        tempEntity.setPlanTanisu(entity.getPlanTanisu());
        tempEntity.setGendogakuKanriTaishoTanisu(entity.getGendogakuKanriTaishoTanisu());
        tempEntity.setGendogakuKanriTaishogaiTanisu(entity.getGendogakuKanriTaishogaiTanisu());
        tempEntity.setTankiNyushoPlanNissu(entity.getTankiNyushoPlanNissu());
        tempEntity.setTankiNyushoJitsunissu(entity.getTankiNyushoJitsunissu());
        tempEntity.setTanisuTotal(entity.getTanisuTotal());
        tempEntity.setTanisuTanka(entity.getTanisuTanka());
        tempEntity.setSeikyugaku(entity.getSeikyugaku());
        tempEntity.setRiyoshaFutangaku(entity.getRiyoshaFutangaku());
        tempEntity.setDekidakaIryohiTanisuTotal(entity.getDekidakaIryohiTanisuTotal());
        tempEntity.setDekidakaIryohiSeikyugaku(entity.getDekidakaIryohiSeikyugaku());
        tempEntity.setDekidakaIryohiRiyoshaFutangaku(entity.getDekidakaIryohiRiyoshaFutangaku());
        tempEntity.setShinsaHohoKubunCode(entity.getShinsaHohoKubunCode());
        tempEntity.setShinsaYM(entity.getShinsaYM());
        tempEntity.setShikyuKubunCode(entity.getShikyuKubunCode());
        tempEntity.setTensuKingaku(entity.getTensuKingaku());
        tempEntity.setShikyuKingaku(entity.getShikyuKingaku());
        tempEntity.setZougenTen(entity.getZougenten());
        tempEntity.setSeikyugakuSagakuKingaku(entity.getSeikyugakuSagakuKingaku());
        tempEntity.setDekidakaSeikyugakuSagaku(entity.getDekidakaSeikyugakuSagaku());
        tempEntity.setZougenRiyu(entity.getZougenRiyu());
        tempEntity.setHushikyuRiyu(entity.getHushikyuRiyu());
        tempEntity.setKounyuKaishuRireki(entity.getKounyuKaishuRireki());
    }
}
