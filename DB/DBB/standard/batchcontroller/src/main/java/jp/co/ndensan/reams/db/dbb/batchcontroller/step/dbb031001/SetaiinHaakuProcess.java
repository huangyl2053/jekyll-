/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiHaakuShuturyokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握のクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class SetaiinHaakuProcess extends BatchProcessBase<SetaiHaakuShuturyokuEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".honnsanteifuka.IHonnSanteiFukaMapper.select世帯員把握");
    private static final RString 世帯員把握入力テーブル = new RString("TmpSetaiHaaku");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH);
    }

    @Override
    protected void createWriter() {
        writer = new BatchEntityCreatedTempTableWriter(世帯員把握入力テーブル, SetaiHaakuShuturyokuEntity.class);
    }

    @Override
    protected void process(SetaiHaakuShuturyokuEntity entity) {
        writer.insert(entity);
    }
}
