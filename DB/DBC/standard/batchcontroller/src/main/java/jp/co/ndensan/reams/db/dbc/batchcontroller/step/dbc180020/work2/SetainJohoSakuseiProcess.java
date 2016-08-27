/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work2;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員情報Tempの作成のクラスです。<br/>
 * 処理詳細2.part3/処理詳細4.part3
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class SetainJohoSakuseiProcess extends BatchProcessBase<SetainJohoTempEntity> {

    private static final RString ONE = new RString("1");
    private static final RString TABLENAME = new RString("SetainJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select世帯員情報");
    private DBC180020ProcessParameter parameter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員情報Temp;

    @Override
    protected void createWriter() {
        世帯員情報Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, SetainJohoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void process(SetainJohoTempEntity entity) {
        if (ONE.equals(entity.getSetaiShotokuHonninKubun())) {
            entity.setHoninShikibetsuCode(entity.getShikibetsuCode());
        }
        世帯員情報Temp.insert(entity);
    }
}
