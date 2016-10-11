/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握情報のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class CollectSetaiinProcess extends BatchProcessBase<FuchoKarisanteiTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get世帯員把握情報");
    private static final int NUM_1 = 1;
    private static final RString TABLE_NAME = new RString("TmpSetaiHaaku");
    @BatchWriter
    IBatchTableWriter tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                SetaiHakuEntity.class);
    }

    @Override
    protected void process(FuchoKarisanteiTempEntity entity) {
        SetaiHakuEntity item = new SetaiHakuEntity();
        item.setHihokenshaNo(entity.getHihokenshaNo());
        item.setShikibetsuCode(entity.getShikibetsuCode());
        item.setKijunYMD(entity.getFukaYMD());
        item.setShotokuNendo(entity.getChoteiNendo().minusYear(NUM_1));
        item.setJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        tableWriter.insert(item);
    }

}
