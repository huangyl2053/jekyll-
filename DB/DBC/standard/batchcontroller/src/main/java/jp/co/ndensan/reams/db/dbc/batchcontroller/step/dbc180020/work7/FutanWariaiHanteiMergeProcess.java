/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定マージのクラスです。<br/>
 * 処理詳細8
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiHanteiMergeProcess extends BatchKeyBreakBase<RiyoshaFutanWariaiMeisaiTempEntity> {

    private static final RString TABLENAME = new RString("RiyoshaFutanWariaiMeisaiTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合判定マージ");
    private DBC180020ProcessParameter parameter;
    private RiyoshaFutanWariaiHantei service;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private FlexibleYear nendo;
    private List<RiyoshaFutanWariaiMeisaiTempEntity> entities;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細Temp;

    @Override
    protected void initialize() {
        service = RiyoshaFutanWariaiHantei.createInstance();
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
        entities = new ArrayList<>();

    }

    @Override
    protected void createWriter() {
        利用者負担割合明細Temp
                = new BatchEntityCreatedTempTableWriter(TABLENAME, RiyoshaFutanWariaiMeisaiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(RiyoshaFutanWariaiMeisaiTempEntity entity) {
        if (getBefore() == null) {
            entities.add(entity);
            return;
        }
        beforeNo = getBefore().getHihokenshaNo();
        nowNo = entity.getHihokenshaNo();
        if (beforeNo.equals(nowNo)) {
            entities.add(entity);
            return;
        }
        insertHandle();
        entities = new ArrayList<>();
        entities.add(entity);
    }

    private void insertHandle() {
        List<RiyoshaFutanWariaiMeisaiTempEntity> results = service.futanWariaiHanteiMerge(entities, nendo);
        for (RiyoshaFutanWariaiMeisaiTempEntity result : results) {
            利用者負担割合明細Temp.insert(result);
        }
    }

    @Override
    protected void afterExecute() {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        insertHandle();
    }

    @Override
    protected void keyBreakProcess(RiyoshaFutanWariaiMeisaiTempEntity t) {
    }

}
