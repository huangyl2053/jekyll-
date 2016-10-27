/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.InsHakouRirekiAndKanriMstParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiHaakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握入力Tempに出力のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsSetaiinHaakuTempProcess extends BatchProcessBase<SetaiHaakuEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select賦課基準日時点の世帯員");
    private static final RString 世帯員把握入力TEMP = new RString("TmpSetaiHaaku");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員把握入力writer;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private InsHakouRirekiAndKanriMstParameter myBatisParameter;

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new InsHakouRirekiAndKanriMstParameter();
        myBatisParameter.set処理年度(processParameter.get処理年度());
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        世帯員把握入力writer = new BatchEntityCreatedTempTableWriter(世帯員把握入力TEMP, SetaiHaakuEntity.class);
    }

    @Override
    protected void process(SetaiHaakuEntity t) {
        世帯員把握入力writer.insert(t);
    }

}
