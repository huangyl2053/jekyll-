/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsKeikakuTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求サービス計画取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsKeikakuTempProcess extends BatchProcessBase<InsKeikakuTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.getサービス計画情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_09 = new RString("09");

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
    protected void process(InsKeikakuTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsKeikakuTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_09);
        tempEntity.setJigyoshaNo(entity.getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.getYoshikiNo());
        tempEntity.setMeisaiNo(entity.getMeisaiNo());
        tempEntity.setRenban(entity.getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        setサービス計画(tempEntity, entity);
        return tempEntity;
    }

    private void setサービス計画(DbWT2112ShokanMeisaiTempEntity tempEntity, InsKeikakuTempEntity entity) {

        tempEntity.setShiteiKijunGaitoJigyoshaKubunCode(entity.getShiteiKijunGaitoJigyoshaKubunCode());
        tempEntity.setKyotakuServiceSakuseiIraiYMD(entity.getKyotakuServiceSakuseiIraiYMD());
        tempEntity.setServiceCode(entity.getServiceCode());
        tempEntity.setTanisu(entity.getTanisu());
        tempEntity.setTanisuTanka(entity.getTanisuTanka());
        tempEntity.setSeikyuKingaku(entity.getSeikyuKingaku());
        tempEntity.setShinsaHohoKubunCode(entity.getShinsaHohoKubunCode());
        tempEntity.setShinsaYM(entity.getShinsaYM());
        tempEntity.setShikyuKubunCode(entity.getShikyuKubunCode());
        tempEntity.setTensuKingaku(entity.getTensuKingaku());
        tempEntity.setShikyuKingaku(entity.getShikyuKingaku());
        tempEntity.setZougenTen(entity.getZougenTen());
        tempEntity.setSagakuKingaku(entity.getSagakuKingaku());
        tempEntity.setZougenRiyu(entity.getZougenRiyu());
        tempEntity.setFushikyuRiyu(entity.getFushikyuRiyu());
        tempEntity.setKounyuKaishuRireki(entity.getKounyuKaishuRireki());

        tempEntity.setTantokangoshienSemmoninNo(entity.getTantokangoshienSemmoninNo());
        tempEntity.setTekiyo(entity.getTekiyo());

        tempEntity.setKaisu(entity.getKaisu());
        tempEntity.setServiceTanisu(entity.getServiceTanisu());
        tempEntity.setServiceTanisuTotal(entity.getServiceTanisuTotal());
    }
}
