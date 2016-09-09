/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の保険者番号取込Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoProcess extends BatchProcessBase<KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
                    + "IKaigokyufuhiKagoMoshitateshoOutMapper.select保険者番号");
    private static final RString 過誤申立一時TBL_NAME = new RString("DbWT1731KagoMoshitate");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT1731TableWriter;

    @Override
    protected void createWriter() {
        this.dbWT1731TableWriter = new BatchEntityCreatedTempTableWriter(過誤申立一時TBL_NAME, DbWT1731KagoMoshitateTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity entity) {
        DbWT1731KagoMoshitateTempEntity dbw1731Entity = entity.getDbWT1731Entity();
        dbw1731Entity.setHokenshaNo(entity.getDbWT1001Entity().getExHokenshaNo());
        dbw1731Entity.setHokenshaName(entity.getDbWT1001Entity().getExHokenshaName());
        dbWT1731TableWriter.update(dbw1731Entity);

    }

    @Override
    protected void afterExecute() {

    }

}
