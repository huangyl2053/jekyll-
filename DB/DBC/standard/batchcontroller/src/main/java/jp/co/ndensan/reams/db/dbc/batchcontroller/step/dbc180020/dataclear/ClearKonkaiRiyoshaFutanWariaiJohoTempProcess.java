/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 今回利用者負担割合情報Tempの削除プロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class ClearKonkaiRiyoshaFutanWariaiJohoTempProcess extends BatchProcessBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> {

    private static final RString TABLENAME = new RString("KonkaiRiyoshaFutanWariaiJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select今回利用者負担割合情報Temp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 月別負担割合新Temp;

    @Override
    protected void createWriter() {
        月別負担割合新Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, KonkaiRiyoshaFutanWariaiJohoTempEntity.class);
    }

    @Override
    protected void process(KonkaiRiyoshaFutanWariaiJohoTempEntity entity) {
        月別負担割合新Temp.delete(entity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
