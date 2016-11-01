/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShokujiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求食事費用取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsShokujiTempProcess extends BatchProcessBase<InsShokujiTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get償還払請求食事費用情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_08 = new RString("08");

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
    protected void process(InsShokujiTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsShokujiTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_08);
        tempEntity.setJigyoshaNo(entity.get食事費用Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get食事費用Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get食事費用Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get食事費用Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set食事費用(tempEntity, entity.get食事費用Entity());
        return tempEntity;
    }

    private void set食事費用(DbWT2112ShokanMeisaiTempEntity tempEntity, DbT3043ShokanShokujiHiyoEntity entity) {

        tempEntity.setKihonTeikyoNissu(entity.getKihonTeikyoNissu());
        tempEntity.setKihonTeikyoTanka(entity.getKihonTeikyoTanka());
        tempEntity.setKihonTeikyoKingaku(entity.getKihonTeikyoKingaku());
        tempEntity.setTokubetsuTeikyoNissu(entity.getTokubetsuTeikyoNissu());
        tempEntity.setTokubetsuTeikyoTanka(entity.getTokubetsuTeikyoTanka());
        tempEntity.setTokubetsuTeikyoKingaku(entity.getTokubetsuTeikyoKingaku());
        tempEntity.setShokujiTeikyoTotalNissu(entity.getShokujiTeikyoTotalNissu());
        tempEntity.setShokujiTeikyohiTotal(entity.getShokujiTeikyohiTotal());
        tempEntity.setGetsugakuHyojunFutangaku(entity.getGetsugakuHyojunFutangaku());
        tempEntity.setShokujiTeikyohiSeikyugaku(entity.getShokujiTeikyohiSeikyugaku());
        tempEntity.setNichigakuHyojunFutangaku(entity.getNichigakuHyojunFutangaku());
        tempEntity.setShikyuKubunCode(entity.getShikyuKubunCode());
        tempEntity.setTensuKingaku(entity.getTensuKingaku());
        tempEntity.setShikyuKingaku(entity.getShikyuKingaku());
        tempEntity.setZougenTen(entity.getZougenTen());
        tempEntity.setSagakuKingaku(entity.getSagakuKingaku());
    }
}
