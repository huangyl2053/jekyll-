/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001;

import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.ShoriDateKanriParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class SystemTimeUpdateHonsanteiProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".honnsanteifuka.IHonnSanteiFukaMapper.select処理日付管理");
    private HonsanteiFukaProcessParameter processParameter;
    private ShoriDateKanriParameter myBatisParameter;
    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new ShoriDateKanriParameter();
        myBatisParameter.set年度(processParameter.get調定年度());
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        writer.update(creatEntity(entity));
    }

    private DbT7022ShoriDateKanriEntity creatEntity(DbT7022ShoriDateKanriEntity entity) {
        entity.setKijunTimestamp(processParameter.getバッチ起動時処理日時());
        return entity;
    }
}
