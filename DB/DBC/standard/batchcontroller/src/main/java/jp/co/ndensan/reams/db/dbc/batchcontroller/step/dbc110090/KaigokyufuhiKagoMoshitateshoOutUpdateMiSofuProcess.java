/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成のDB更新_未送付Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutUpdateMiSofuProcess extends BatchProcessBase<DbT3059KagoMoshitateEntity> {

    private static final RString TABLE_NAME = new RString("DbT3059KagoMoshitate");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
            + "IKaigokyufuhiKagoMoshitateshoOutMapper.updatetDB_未送付");
    @BatchWriter
    BatchPermanentTableWriter<DbT3059KagoMoshitateEntity> dbT3059TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbT3059TableWriter = new BatchPermanentTableWriter<>(DbT3059KagoMoshitateEntity.class);
    }

    @Override
    protected void process(DbT3059KagoMoshitateEntity entity) {
        entity.setKokuhorenSofuYM(FlexibleYearMonth.EMPTY);
        entity.setKokuhirenSaiSofuAriFlag(false);
        dbT3059TableWriter.update(entity);

    }

    @Override
    protected void afterExecute() {

    }

}
