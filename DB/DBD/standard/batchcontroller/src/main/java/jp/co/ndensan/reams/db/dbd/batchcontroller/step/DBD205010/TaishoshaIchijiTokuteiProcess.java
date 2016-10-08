/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD205010;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbz00001.TaishoshaIchijiTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.TaishoshaIchijiTokuteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.TaishoshaIchijiTokuteiTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者一次特定_process処理クラスです。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
public class TaishoshaIchijiTokuteiProcess extends BatchProcessBase<TaishoshaIchijiTokuteiEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".futangenogakuninteisha.IRiyoshafutangakuGengakuNinteiMapper.get被保険者番号");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    private TaishoshaIchijiTokuteiProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, processParameter.toTaishoshaIchijiTokuteiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TaishoshaIchijiTokuteiTableEntity.class)
                .tempTableName(TaishoshaIchijiTokuteiTableEntity.TABLE_NAME)
                .build();
    }

    @Override
    protected void process(TaishoshaIchijiTokuteiEntity t) {
        TaishoshaIchijiTokuteiTableEntity insertEntity = create対象者一次特定Entity(t);
        tmpTableWriter.insert(insertEntity);
    }

    private TaishoshaIchijiTokuteiTableEntity create対象者一次特定Entity(TaishoshaIchijiTokuteiEntity t) {
        TaishoshaIchijiTokuteiTableEntity data = new TaishoshaIchijiTokuteiTableEntity();
        data.setHihokenshaNo(new HihokenshaNo(t.getHihokenshaNo().getColumnValue()));
        data.setKijunYMD(processParameter.get基準日());
        return data;
    }
}
