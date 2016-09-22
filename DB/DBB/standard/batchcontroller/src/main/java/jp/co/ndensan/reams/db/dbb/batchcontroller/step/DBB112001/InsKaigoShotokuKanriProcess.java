/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携バッチの介護所得管理登録Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class InsKaigoShotokuKanriProcess extends BatchProcessBase<KaigoShotoTempTableEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "toushoshotokujohochushutsurenkei.IToushoShotokuJohoChushutsuRenkeiMapper.get介護所得Temp");

    @BatchWriter
    BatchPermanentTableWriter 介護所得管理2008tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        介護所得管理2008tableWriter = new BatchPermanentTableWriter(DbT2008ShotokuKanriEntity.class);
    }

    @Override
    protected void process(KaigoShotoTempTableEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理entity = get介護所得管理entity(entity);
        介護所得管理2008tableWriter.insert(介護所得管理entity);
    }

    private DbT2008ShotokuKanriEntity get介護所得管理entity(KaigoShotoTempTableEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理entity = new DbT2008ShotokuKanriEntity();
        介護所得管理entity.setShotokuNendo(entity.getShotoNendo());
        介護所得管理entity.setShikibetsuCode(entity.getShikibetsuCode());
        介護所得管理entity.setRirekiNo(entity.getRirekiNo());
        介護所得管理entity.setKazeiKubun(entity.getKazeiKubun());
        介護所得管理entity.setKazeiKubunGemmenGo(entity.getKazeiKubunGemmenGo());
        介護所得管理entity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        介護所得管理entity.setNenkiniShunyuGaku(entity.getNenkiniShunyuGaku());
        介護所得管理entity.setNenkiniShotokuGaku(entity.getNenkiniShotokuGaku());
        介護所得管理entity.setKazeiShotokuGaku(entity.getKazeiShotoGaku());
        介護所得管理entity.setGekihenKanwaKubun(entity.getGekihenkanwaKubun());
        介護所得管理entity.setYusenKubun(entity.getYuusenKunbun());
        介護所得管理entity.setShoriTimeStamp(entity.getShoriTimeStamp());
        return 介護所得管理entity;
    }
}
