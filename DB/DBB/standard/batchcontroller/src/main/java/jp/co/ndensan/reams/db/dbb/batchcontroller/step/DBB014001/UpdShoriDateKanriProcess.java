/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class UpdShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.select処理日付管理");
    private FuchoKarisanteiFukaProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
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
        entity.setKijunTimestamp(new YMDHMS(parameter.getバッチ起動日時()));
        return entity;
    }

}
