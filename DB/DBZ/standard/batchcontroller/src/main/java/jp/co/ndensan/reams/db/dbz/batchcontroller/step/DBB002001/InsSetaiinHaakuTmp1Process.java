/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員（住民）の把握_住所地特例該当が１クラスです。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class InsSetaiinHaakuTmp1Process extends BatchProcessBase<SetaiHakuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka."
            + "ISetaiShotokuKazeiHanteiMapper.select世帯員把握入力_1");

    private static final RString 本人区分 = new RString("1");

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    private static final RString TABLE_NAME = new RString("TmpSetaiShotoku");

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                SetaiShotokuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(SetaiHakuEntity entity) {
        tableWriter.insert(to世帯員所得情報(entity));
    }

    /**
     * create世帯員所得情報
     *
     * @param entity SetaiHaakuEntity
     * @return 世帯員所得情報
     */
    private SetaiShotokuEntity to世帯員所得情報(SetaiHakuEntity entity) {
        SetaiShotokuEntity 世帯員所得情報 = new SetaiShotokuEntity();
        世帯員所得情報.setHihokenshaNo(entity.getHihokenshaNo());
        世帯員所得情報.setShikibetsuCode(entity.getShikibetsuCode());
        世帯員所得情報.setShotokuNendo(entity.getShotokuNendo());
        世帯員所得情報.setKijunYMD(entity.getKijunYMD());
        世帯員所得情報.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        世帯員所得情報.setSetaiCode(entity.getSetaiCode());
        世帯員所得情報.setHonninKubun(本人区分);
        return 世帯員所得情報;
    }
}
