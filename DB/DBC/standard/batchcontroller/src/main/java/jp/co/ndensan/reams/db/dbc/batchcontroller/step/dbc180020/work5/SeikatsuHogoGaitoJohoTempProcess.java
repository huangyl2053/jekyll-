/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work5;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護該当情報Tempの作成のクラスです。<br/>
 * 処理詳細5
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class SeikatsuHogoGaitoJohoTempProcess extends BatchProcessBase<SeikatsuHogoGaitoJohoTempEntity> {

    private static final RString TABLENAME = new RString("SeikatsuHogoGaitoJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select生活保護該当情報作成");
    private DBC180020ProcessParameter parameter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 生活保護該当情報Temp;

    @Override
    protected void createWriter() {
        生活保護該当情報Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, SeikatsuHogoGaitoJohoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(parameter.is異動()));
    }

    @Override
    protected void process(SeikatsuHogoGaitoJohoTempEntity entity) {
        生活保護該当情報Temp.insert(entity);
    }
}
