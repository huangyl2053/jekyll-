/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsTokuteiNyushoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求特定入所者介護サービス費用取得のProcess
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsTokuteiNyushoTempProcess extends BatchProcessBase<InsTokuteiNyushoTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get特定入所者介護サービス費用データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_13 = new RString("13");

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
    protected void process(InsTokuteiNyushoTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsTokuteiNyushoTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_13);
        tempEntity.setJigyoshaNo(entity.get特定入所者介護サービス費用Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get特定入所者介護サービス費用Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get特定入所者介護サービス費用Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get特定入所者介護サービス費用Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set特定入所者介護サービス費用(tempEntity, entity.get特定入所者介護サービス費用Entity());
        return tempEntity;
    }

    private void set特定入所者介護サービス費用(DbWT2112ShokanMeisaiTempEntity tempEntity,
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {

        tempEntity.setServiceShuruiCode(entity.getServiceShuruiCode());
        tempEntity.setServiceKomokuCode(entity.getServiceKomokuCode());
        tempEntity.setHiyoTanka(entity.getHiyoTanka());
        tempEntity.setFutanGendogaku(entity.getFutanGendogaku());
        tempEntity.setNissu(entity.getNissu());
        tempEntity.setHiyogaku(entity.getHiyogaku());
        tempEntity.setHokenbunSeikyugaku(entity.getHokenbunSeikyugaku());
        tempEntity.setRiyoshaFutangaku(entity.getRiyoshaFutangaku());
        tempEntity.setHiyogakuTotal(entity.getHiyogakuTotal());
        tempEntity.setHokenbunSeikyugakuTotal(entity.getHokenbunSeikyugakuTotal());
        tempEntity.setRiyoshaFutangakuTotal(entity.getRiyoshaFutangakuTotal());
        tempEntity.setShikyuKubunCode(entity.getShikyuKubunCode());
        tempEntity.setTensuKingaku(entity.getTensuKingaku());
        tempEntity.setShikyuKingaku(entity.getShikyuKingaku());
        tempEntity.setZougenTen(entity.getZougenten());
        tempEntity.setSagakuKingaku(entity.getSagakuKingaku());
    }
}
