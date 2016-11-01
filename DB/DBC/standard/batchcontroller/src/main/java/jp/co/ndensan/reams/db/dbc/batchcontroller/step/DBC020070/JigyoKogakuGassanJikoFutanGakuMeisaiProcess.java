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
 * 事業高額合算自己負担額明細データを取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class JigyoKogakuGassanJikoFutanGakuMeisaiProcess extends BatchProcessBase<ShikyugakuCalcTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get事業高額合算自己負担額明細");
    private static final RString 区分5 = new RString(5);

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
        tempEntity.setKubun(区分5);
        tempEntity.setMeisaiHihokenshaNo(entity.get負担額明細().getHihokenshaNo());

        tempEntity.setFutangakuMeisai_hihokenshaNo(entity.get負担額明細().getHihokenshaNo());
        tempEntity.setFutangakuMeisai_taishoNendo(entity.get負担額明細().getTaishoNendo());
        tempEntity.setFutangakuMeisai_hokenshaNo(entity.get負担額明細().getHokenshaNo());
        tempEntity.setFutangakuMeisai_shikyuShinseishoSeiriNo(entity.get負担額明細().getShikyuShinseishoSeiriNo());
        tempEntity.setFutangakuMeisai_rirekiNo(entity.get負担額明細().getRirekiNo());
        tempEntity.setFutangakuMeisai_taishoM(entity.get負担額明細().getTaishoM());
        tempEntity.setFutangakuMeisai_jikoFutanGaku(entity.get負担額明細().getJikoFutanGaku());
        tempEntity.setFutangakuMeisai_uchisu_70_74JikoFutanGaku(entity.get負担額明細().getUchisu_70_74JikoFutanGaku());
        tempEntity.setFutangakuMeisai_under_70KogakuShikyuGaku(entity.get負担額明細().getUnder_70KogakuShikyuGaku());
        tempEntity.setFutangakuMeisai_over_70_74KogakuShikyuGaku(entity.get負担額明細().getOver_70_74KogakuShikyuGaku());
        tempEntity.setFutangakuMeisai_tekiyo(entity.get負担額明細().getTekiyo());
        tempEntity.setFutangakuMeisai_sumi_JikoFutanGaku(entity.get負担額明細().getSumi_JikoFutanGaku());
        tempEntity.setFutangakuMeisai_sumi_70_74JikoFutanGaku(entity.get負担額明細().getSumi_70_74JikoFutanGaku());
        tempEntity.setFutangakuMeisai_sumi_under_70KogakuShikyuGaku(entity.get負担額明細().getSumi_under_70KogakuShikyuGaku());
        tempEntity.setFutangakuMeisai_sumi_70_74KogakuShikyuGaku(entity.get負担額明細().getSumi_70_74KogakuShikyuGaku());
        tempEntity.setFutangakuMeisai_sumi_Tekiyo(entity.get負担額明細().getSumi_Tekiyo());

        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }
}
