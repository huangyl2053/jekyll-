/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShoteiShikkanTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求所定疾患施設療養費等取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsShoteiShikkanTempProcess extends BatchProcessBase<InsShoteiShikkanTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get所定疾患施設療養費情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_05 = new RString("05");

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
    protected void process(InsShoteiShikkanTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsShoteiShikkanTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_05);
        tempEntity.setJigyoshaNo(entity.get所定疾患施設療養費Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get所定疾患施設療養費Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get所定疾患施設療養費Entity().getMeisaiNo());
        tempEntity.setRenban(entity.get所定疾患施設療養費Entity().getRenban());
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        set所定疾患施設療養費(tempEntity, entity.get所定疾患施設療養費Entity());
        return tempEntity;
    }

    private void set所定疾患施設療養費(DbWT2112ShokanMeisaiTempEntity tempEntity, DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity) {
        tempEntity.setKinkyuShobyoName1(entity.getKinkyuShobyoName1());
        tempEntity.setKinkyuShobyoName2(entity.getKinkyuShobyoName2());
        tempEntity.setKinkyuShobyoName3(entity.getKinkyuShobyoName3());
        tempEntity.setKinkyuChiryoKaishiYMD1(entity.getKinkyuChiryoKaishiYMD1());
        tempEntity.setKinkyuChiryoKaishiYMD2(entity.getKinkyuChiryoKaishiYMD2());
        tempEntity.setKinkyuChiryoKaishiYMD3(entity.getKinkyuChiryoKaishiYMD3());
        tempEntity.setOshinNissu(entity.getOshinNissu());
        tempEntity.setOshinIryoKikanName(entity.getOshinIryoKikanName());
        tempEntity.setTsuinNissu(entity.getTsuinNissu());
        tempEntity.setTsuinKikanName(entity.getTsuinKikanName());
        tempEntity.setKinkyuChiryoKanriTanisu(entity.getKinkyuChiryoKanriTanisu());
        tempEntity.setKinkyuChiryoKanriNissu(entity.getKinkyuChiryoKanriNissu());
        tempEntity.setKinkyuChiryoKanriSubTotal(entity.getKinkyuChiryoKanriSubTotal());
        tempEntity.setRehabilitationTanisu(entity.getRehabilitationTanisu());
        tempEntity.setShochiTanisu(entity.getShochiTanisu());
        tempEntity.setShujutsuTanisu(entity.getShujutsuTanisu());
        tempEntity.setMasuiTanisu(entity.getMasuiTanisu());
        tempEntity.setHoshasenChiryoTanisu(entity.getHoshasenChiryoTanisu());
        tempEntity.setTekiyo1(entity.getTekiyo1());
        tempEntity.setTekiyo2(entity.getTekiyo2());
        tempEntity.setTekiyo3(entity.getTekiyo3());
        tempEntity.setTekiyo4(entity.getTekiyo4());
        tempEntity.setTekiyo5(entity.getTekiyo5());
        tempEntity.setTekiyo6(entity.getTekiyo6());
        tempEntity.setTekiyo7(entity.getTekiyo7());
        tempEntity.setTekiyo8(entity.getTekiyo8());
        tempEntity.setTekiyo9(entity.getTekiyo9());
        tempEntity.setTekiyo10(entity.getTekiyo10());
        tempEntity.setTekiyo11(entity.getTekiyo11());
        tempEntity.setTekiyo12(entity.getTekiyo12());
        tempEntity.setTekiyo13(entity.getTekiyo13());
        tempEntity.setTekiyo14(entity.getTekiyo14());
        tempEntity.setTekiyo15(entity.getTekiyo15());
        tempEntity.setTekiyo16(entity.getTekiyo16());
        tempEntity.setTekiyo17(entity.getTekiyo17());
        tempEntity.setTekiyo18(entity.getTekiyo18());
        tempEntity.setTekiyo19(entity.getTekiyo19());
        tempEntity.setTekiyo20(entity.getTekiyo20());
        tempEntity.setKinkyuShisetsuRyoyohiTotalTanisu(entity.getKinkyuShisetsuRyoyohiTotalTanisu());
        tempEntity.setShoteiShikkanShobyoName1(entity.getShoteiShikkanShobyoName1());
        tempEntity.setShoteiShikkanShobyoName2(entity.getShoteiShikkanShobyoName2());
        tempEntity.setShoteiShikkanShobyoName3(entity.getShoteiShikkanShobyoName3());
        tempEntity.setShoteiShikkanShobyoKaishiYMD1(entity.getShoteiShikkanShobyoKaishiYMD1());
        tempEntity.setShoteiShikkanShobyoKaishiYMD2(entity.getShoteiShikkanShobyoKaishiYMD2());
        tempEntity.setShoteiShikkanShobyoKaishiYMD3(entity.getShoteiShikkanShobyoKaishiYMD3());
        tempEntity.setShoteiShikkanTanisu(entity.getShoteiShikkanTanisu());
        tempEntity.setShoteiShikkanNissu(entity.getShoteiShikkanNissu());
        tempEntity.setShoteiShikkanSubTotal(entity.getShoteiShikkanSubTotal());
    }
}
