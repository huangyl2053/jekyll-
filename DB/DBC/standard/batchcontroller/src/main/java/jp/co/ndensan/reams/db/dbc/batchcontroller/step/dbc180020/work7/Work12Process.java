/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.DbT3115SakuseiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合根拠の登録<br/>
 * 処理詳細12
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class Work12Process extends BatchKeyBreakBase<DbT3115SakuseiEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合根拠");
    private DBC180020ProcessParameter parameter;
    private FlexibleYear nendo;
    private DbT3115SakuseiEntity last;
    private int rirekiNo;
    private int edaNo;
    private RString beforeNo;
    private RString nowNo;
    private boolean existingFlag;
    @BatchWriter
    private IBatchTableWriter 利用者負担割合根拠;

    @Override
    protected void initialize() {
        existingFlag = false;
        rirekiNo = 1;
        edaNo = 1;
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
    }

    @Override
    protected void createWriter() {
        利用者負担割合根拠 = new BatchPermanentTableWriter(DbT3115RiyoshaFutanWariaiKonkyoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(DbT3115SakuseiEntity entity) {
        existingFlag = true;
        if (getBefore() == null) {
            return;
        }
        last = entity;
        beforeNo = getBefore().get被保険者番号() == null ? RString.EMPTY : getBefore().get被保険者番号().value();
        nowNo = last.get被保険者番号() == null ? RString.EMPTY : last.get被保険者番号().value();
        loopHandle(getBefore());
        if (!beforeNo.equals(nowNo)) {
            rirekiNo = 1;
        } else {
            rirekiNo++;
        }
        edaNo++;
    }

    @Override
    protected void afterExecute() {
        if (!existingFlag) {
            return;
        }
        loopHandle(getBefore());
    }

    @Override
    protected void keyBreakProcess(DbT3115SakuseiEntity t) {
    }

    private void loopHandle(DbT3115SakuseiEntity before) {
        DbT3115RiyoshaFutanWariaiKonkyoEntity dbt3115Entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
        dbt3115Entity.setNendo(nendo);
        dbt3115Entity.setHihokenshaNo(before.get被保険者番号());
        dbt3115Entity.setRirekiNo(rirekiNo);
        dbt3115Entity.setEdaNo(edaNo);
        dbt3115Entity.setSetaiinHihokenshaNo(before.get世帯員被保険者番号());
        dbt3115Entity.setSetaiinShotokuRirekiNo(before.get元履歴番号());
        利用者負担割合根拠.insert(dbt3115Entity);
    }

}
