/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsMeisaiJutokuTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求明細・住所地特例情報取得Processクラスです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsMeisaiJutokuTempProcess extends BatchProcessBase<InsMeisaiJutokuTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get償還払請求住所地特例情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_03 = new RString("03");

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
    protected void process(InsMeisaiJutokuTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsMeisaiJutokuTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_03);
        tempEntity.setJigyoshaNo(entity.get明細_住所地特例Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get明細_住所地特例Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get明細_住所地特例Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get明細_住所地特例Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        tempEntity.setServiceShuruiCode(entity.get明細_住所地特例Entity().getServiceShuruiCode());
        tempEntity.setServiceKomokuCode(entity.get明細_住所地特例Entity().getServiceKomokuCode());
        tempEntity.setTanisu(entity.get明細_住所地特例Entity().getTanisu());
        tempEntity.setNissuKaisu(entity.get明細_住所地特例Entity().getNissuKaisu());
        tempEntity.setServiceTanisu(entity.get明細_住所地特例Entity().getServiceTanisu());
        tempEntity.setTekiyo(entity.get明細_住所地特例Entity().getTekiyo());
        return tempEntity;
    }
}
