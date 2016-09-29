/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果の明細データを取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class KogakuGassanShikyugakuKeisanKekkaMeisaiProcess extends BatchProcessBase<ShikyugakuCalcTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get高額合算支給額計算結果明細");
    private static final RString 区分2 = new RString(2);

    private static final RString TABLE_NAME = new RString("ShikyugakuCalcTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuCalcTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuCalcTempRelateEntity entity) {
        ShikyugakuCalcTempEntity tempEntity = new ShikyugakuCalcTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setTaishoNendo(entity.getTaishoNendo());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setKubun(区分2);
        tempEntity.setMeisaiNo(entity.get結果明細().getMeisanNo());
        tempEntity.setMeisaiHihokenshaNo(entity.get結果明細().getHihokenshaNo());

        tempEntity.setShikyugakuMeisai_hihokenshaNo(entity.get結果明細().getHihokenshaNo());
        tempEntity.setShikyugakuMeisai_taishoNendo(entity.get結果明細().getTaishoNendo());
        tempEntity.setShikyugakuMeisai_shoKisaiHokenshaNo(entity.get結果明細().getShoKisaiHokenshaNo());
        tempEntity.setShikyugakuMeisai_shikyuShinseishoSeiriNo(entity.get結果明細().getShikyuShinseishoSeiriNo());
        tempEntity.setShikyugakuMeisai_meisanNo(entity.get結果明細().getMeisanNo());
        tempEntity.setShikyugakuMeisai_rirekiNo(entity.get結果明細().getRirekiNo());
        tempEntity.setShikyugakuMeisai_hokenSeidoCode(entity.get結果明細().getHokenSeidoCode());
        tempEntity.setShikyugakuMeisai_uchiwakeHokenshaNo(entity.get結果明細().getUchiwakeHokenshaNo());
        tempEntity.setShikyugakuMeisai_kokuho_HihokenshaShoKigo(entity.get結果明細().getKokuho_HihokenshaShoKigo());
        tempEntity.setShikyugakuMeisai_hiHokenshaShoNo(entity.get結果明細().getHiHokenshaShoNo());
        tempEntity.setShikyugakuMeisai_uchiwakeHokenshaMei(entity.get結果明細().getUchiwakeHokenshaMei());
        tempEntity.setShikyugakuMeisai_jikoFutanSeiriNo(entity.get結果明細().getJikoFutanSeiriNo());
        tempEntity.setShikyugakuMeisai_taishoshaShimei(entity.get結果明細().getTaishoshaShimei());
        tempEntity.setShikyugakuMeisai_over70_Futangaku(entity.get結果明細().getOver70_Futangaku());
        tempEntity.setShikyugakuMeisai_over70_AmbunRitsu(entity.get結果明細().getOver70_AmbunRitsu());
        tempEntity.setShikyugakuMeisai_over70_Shikyugaku(entity.get結果明細().getOver70_Shikyugaku());
        tempEntity.setShikyugakuMeisai_under70_Futangaku(entity.get結果明細().getUnder70_Futangaku());
        tempEntity.setShikyugakuMeisai_futangaku(entity.get結果明細().getFutangaku());
        tempEntity.setShikyugakuMeisai_ambunRitsu(entity.get結果明細().getAmbunRitsu());
        tempEntity.setShikyugakuMeisai_under70_Shikyugaku(entity.get結果明細().getUnder70_Shikyugaku());
        tempEntity.setShikyugakuMeisai_shikyugaku(entity.get結果明細().getShikyugaku());
        tempEntity.setShikyugakuMeisai_over70_Biko(entity.get結果明細().getOver70_Biko());
        tempEntity.setShikyugakuMeisai_under70_Biko(entity.get結果明細().getUnder70_Biko());
        tempEntity.setShikyugakuMeisai_dataKubun(entity.get結果明細().getDataKubun());
        tempEntity.setShikyugakuMeisai_uketoriYM(entity.get結果明細().getUketoriYM());
        tempEntity.setShikyugakuMeisai_sofuYM(entity.get結果明細().getSofuYM());

        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }
}
