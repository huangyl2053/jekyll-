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
 * 事業高額合算自己負担額証明書明細データを取得するを取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiProcess extends BatchProcessBase<ShikyugakuCalcTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get事業高額合算自己負担額証明書明細");
    private static final RString 区分6 = new RString(6);

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
        tempEntity.setKubun(区分6);
        tempEntity.setMeisaiHihokenshaNo(entity.get証明書明細().getHihokenshaNo());

        tempEntity.setZenFutangakuMeisai_hihokenshaNo(entity.get証明書明細().getHihokenshaNo());
        tempEntity.setZenFutangakuMeisai_taishoNendo(entity.get証明書明細().getTaishoNendo());
        tempEntity.setZenFutangakuMeisai_hokenshaNo(entity.get証明書明細().getHokenshaNo());
        tempEntity.setZenFutangakuMeisai_shikyuShinseishoSeiriNo(entity.get証明書明細().getShikyuShinseishoSeiriNo());
        tempEntity.setZenFutangakuMeisai_tennyumaeHokenshaNo(entity.get証明書明細().getTennyumaeHokenshaNo());
        tempEntity.setZenFutangakuMeisai_rirekiNo(entity.get証明書明細().getRirekiNo());
        tempEntity.setZenFutangakuMeisai_taishoM(entity.get証明書明細().getTaishoM());
        tempEntity.setZenFutangakuMeisai_jikoFutanGaku(entity.get証明書明細().getJikoFutanGaku());
        tempEntity.setZenFutangakuMeisai_uchisu_70_74JikoFutanGaku(entity.get証明書明細().getUchisu_70_74JikoFutanGaku());
        tempEntity.setZenFutangakuMeisai_under_70KogakuShikyuGaku(entity.get証明書明細().getUnder_70KogakuShikyuGaku());
        tempEntity.setZenFutangakuMeisai_over_70_74KogakuShikyuGaku(entity.get証明書明細().getOver_70_74KogakuShikyuGaku());
        tempEntity.setZenFutangakuMeisai_tekiyo(entity.get証明書明細().getTekiyo());

        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }
}
