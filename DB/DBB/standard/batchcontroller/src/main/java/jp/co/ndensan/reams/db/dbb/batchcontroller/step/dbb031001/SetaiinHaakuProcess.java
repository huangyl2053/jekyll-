/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
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
public class SetaiinHaakuProcess extends BatchProcessBase<SetaiHakuEntity> {

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
        writer = new BatchEntityCreatedTempTableWriter(世帯員把握入力テーブル, SetaiHakuEntity.class);
    }

    @Override
    protected void process(SetaiHakuEntity entity) {
        writer.insert(entity);
    }
}
