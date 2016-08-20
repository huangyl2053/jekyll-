/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.TsukibetsuFutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別負担割合（新）Temp<br/>
 * 処理詳細9
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class Work9Process extends BatchProcessBase<TsukibetsuFutanWariaiTempEntity> {

    private static final RString TABLENAME = new RString("TsukibetsuFutanWariaiNewTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select月別負担割合作成新");
    private DBC180020ProcessParameter parameter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 月別負担割合新Temp;

    @Override
    protected void createWriter() {
        月別負担割合新Temp
                = new BatchEntityCreatedTempTableWriter(TABLENAME, TsukibetsuFutanWariaiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void process(TsukibetsuFutanWariaiTempEntity entity) {
        月別負担割合新Temp.insert(entity);
    }
}
