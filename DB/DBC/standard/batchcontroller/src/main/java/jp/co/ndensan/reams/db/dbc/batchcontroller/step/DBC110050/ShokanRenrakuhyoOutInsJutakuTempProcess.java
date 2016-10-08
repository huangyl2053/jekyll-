/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsJutakuTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求住宅改修情報取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsJutakuTempProcess extends BatchProcessBase<InsJutakuTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get住宅改修情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_11 = new RString("11");

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
    protected void process(InsJutakuTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsJutakuTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_11);
        tempEntity.setJigyoshaNo(entity.get住宅改修Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get住宅改修Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get住宅改修Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get住宅改修Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set住宅改修(tempEntity, entity.get住宅改修Entity());
        return tempEntity;
    }

    private void set住宅改修(DbWT2112ShokanMeisaiTempEntity tempEntity, DbT3049ShokanJutakuKaishuEntity entity) {

        tempEntity.setServiceCode(entity.getServiceCode());
        tempEntity.setJutakuKaishuChakkoYMD(entity.getJutakuKaishuChakkoYMD());
        tempEntity.setJutakuKaishuNaiyo(entity.getJutakuKaishuNaiyo());
        tempEntity.setJutakuKaishuJigyoshaName(entity.getJutakuKaishuJigyoshaName());
        tempEntity.setJutakuKaishuJutakuAddress(entity.getJutakuKaishuJutakuAddress());
        tempEntity.setKaishuKingaku(entity.getKaishuKingaku());
        tempEntity.setShinsaHohoKubunCode(entity.getShinsaHohoKubunCode());
        tempEntity.setJutakuKaishuKanseiYMD(entity.getJutakuKaishuKanseiYMD());
        tempEntity.setSagakuKingaku(entity.getSagakuKingaku());
        tempEntity.setJizenServiceTeikyoYM(entity.getJizenServiceTeikyoYM());
        tempEntity.setJizenSeiriNo(entity.getJizenSeiriNo());
    }

}
