/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算自己負担額証明書（転入前市町村での自己負担額）のデータを取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class JigyoKogakuGassanJikoFutanGakuShomeishoProcess extends BatchProcessBase<ShikyugakuCalcTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get事業高額合算自己負担額証明書");
    private static final RString 区分4 = new RString(4);

    private static final RString TABLE_NAME = new RString("ShikyugakuCalcTemp");

    private HihokenshaNo 被保険者番号;
    private int 連番 = 0;

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
        連番 = 連番 + 1;
        ShikyugakuCalcTempEntity tempEntity = new ShikyugakuCalcTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setTaishoNendo(entity.getTaishoNendo());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setKubun(区分4);
        if (entity.get証明書().getHihokenshaNo().equals(被保険者番号)) {
            tempEntity.setMeisaiNo(new RString(連番));
        } else {
            連番 = 1;
            tempEntity.setMeisaiNo(new RString(連番));
        }
        tempEntity.setMeisaiHihokenshaNo(entity.get証明書().getHihokenshaNo());
        tempEntity.setZenFutangaku_hihokenshaNo(entity.get証明書().getHihokenshaNo());
        tempEntity.setZenFutangaku_taishoNendo(entity.get証明書().getTaishoNendo());
        tempEntity.setZenFutangaku_shokisaiHokenshaNo(entity.get証明書().getShokisaiHokenshaNo());
        tempEntity.setZenFutangaku_shikyuShinseishoSeiriNo(entity.get証明書().getShikyuShinseishoSeiriNo());
        tempEntity.setZenFutangaku_tennyumaeHokenshaNo(entity.get証明書().getTennyumaeHokenshaNo());
        tempEntity.setZenFutangaku_rirekiNo(entity.get証明書().getRirekiNo());
        tempEntity.setZenFutangaku_jikoFutanSeiriNo(entity.get証明書().getJikoFutanSeiriNo());
        tempEntity.setZenFutangaku_tennyumaeHokenshaMei(entity.get証明書().getTennyumaeHokenshaMei());
        tempEntity.setZenFutangaku_taishoKeisanKaishiYMD(entity.get証明書().getTaishoKeisanKaishiYMD());
        tempEntity.setZenFutangaku_taishoKeisanShuryoYMD(entity.get証明書().getTaishoKeisanShuryoYMD());
        tempEntity.setZenFutangaku_hihokenshaKaishiYMD(entity.get証明書().getHihokenshaKaishiYMD());
        tempEntity.setZenFutangaku_hihokenshaShuryoYMD(entity.get証明書().getHihokenshaShuryoYMD());
        tempEntity.setZenFutangaku_hakkoDate(entity.get証明書().getHakkoDate());
        tempEntity.setZenFutangaku_gokei_JikoFutanGaku(entity.get証明書().getGokei_JikoFutanGaku());
        tempEntity.setZenFutangaku_gokei_70_74JikoFutanGaku(entity.get証明書().getGokei_70_74JikoFutanGaku());
        tempEntity.setZenFutangaku_gokei_Under70KogakuShikyuGaku(entity.get証明書().getGokei_Under70KogakuShikyuGaku());
        tempEntity.setZenFutangaku_gokei_70_74KogakuShikyuGaku(entity.get証明書().getGokei_70_74KogakuShikyuGaku());
        tempEntity.setZenFutangaku_atesakiYubinNo(entity.get証明書().getAtesakiYubinNo());
        tempEntity.setZenFutangaku_atesakiJusho(entity.get証明書().getAtesakiJusho());
        tempEntity.setZenFutangaku_biko(entity.get証明書().getBiko());
        tempEntity.setZenFutangaku_uketsukeDate(entity.get証明書().getUketsukeDate());
        tempEntity.setZenFutangaku_shikyugakuKeisanDate(entity.get証明書().getShikyugakuKeisanDate());
        tempEntity.setZenFutangaku_atesakiShimei(entity.get証明書().getAtesakiShimei());
        tempEntity.setZenFutangaku_madoguchi_TaishoshaHanteiCode(entity.get証明書().getMadoguchi_TaishoshaHanteiCode());
        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }
}
