/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.testyou;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * Test用のプロセスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class CreateTestProcess extends BatchProcessBase<SetainJohoTempEntity> {

    private static final Decimal 金額1 = new Decimal(100000);
    private static final Decimal 金額2 = new Decimal(200000);
    private static final RString TABLENAME = new RString("HanteiTaishoshaTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select追加判定対象者Temp");
    private DBC180020ProcessParameter parameter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 判定対象者Temp;

    @Override
    protected void createWriter() {
        判定対象者Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void process(SetainJohoTempEntity entity) {
    }

    @Override
    protected void afterProcess() {
        HanteiTaishoshaTempEntity 判定対象者 = new HanteiTaishoshaTempEntity();
        判定対象者.setTaishoNendo(new FlexibleYear("2016"));
        判定対象者.setTaishoTsuki(new FlexibleYearMonth("201608"));
        判定対象者.setHihokenshaNo(new HihokenshaNo("6777777771"));
        判定対象者.setShikibetsuCode(new ShikibetsuCode("000000001007004"));
        判定対象者.setNinteiYukoKaishiDate(new FlexibleDate("20160802"));
        判定対象者.setHihokenshaKubunCode(new RString("1"));
        判定対象者.setSetaiCode(new SetaiCode("000000002007003"));
        判定対象者.setGokeiShotokuGaku(金額1);
        判定対象者Temp.insert(判定対象者);
        判定対象者.setTaishoNendo(new FlexibleYear("2016"));
        判定対象者.setTaishoTsuki(new FlexibleYearMonth("201609"));
        判定対象者.setHihokenshaNo(new HihokenshaNo("6777777772"));
        判定対象者.setShikibetsuCode(new ShikibetsuCode("000000001007004"));
        判定対象者.setNinteiYukoKaishiDate(new FlexibleDate("20160802"));
        判定対象者.setHihokenshaKubunCode(new RString("2"));
        判定対象者.setSetaiCode(new SetaiCode("000000002007003"));
        判定対象者.setGokeiShotokuGaku(金額2);
        判定対象者Temp.insert(判定対象者);
    }
}
