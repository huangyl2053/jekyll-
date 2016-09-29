/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績基本抽出01のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
public class InsKyufuJissekiKihonJigyoKogakuTmpProcess3 extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString 給付実績基本情報事業高額一時 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db."
            + "mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "get給付実績基本情報事業高額一時3");
    private static final RString 給付実績基本情報事業高額一時3 = new RString("TempKyufujissekiKihonJigyo3");
    private static final int INDEX_2 = 2;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 一時給付実績基本情報事業高額一時3;
    private RString breakKey;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(給付実績基本情報事業高額一時);

    }

    @Override
    protected void createWriter() {
        一時給付実績基本情報事業高額一時3 = new BatchEntityCreatedTempTableWriter(給付実績基本情報事業高額一時3,
                DbT3017KyufujissekiKihonEntity.class);
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        if (breakKey != null && breakKey.equals(getBreakKey(entity))) {
            return;
        }
        entity.setShokisaiHokenshaNo(new HokenshaNo(entity.getShokisaiHokenshaNo().getColumnValue().substring(INDEX_2)));
        一時給付実績基本情報事業高額一時3.insert(entity);

    }

    private RString getBreakKey(DbT3017KyufujissekiKihonEntity entity) {
        return entity.getInputShikibetsuNo().getColumnValue()
                .concat(entity.getHiHokenshaNo().getColumnValue())
                .concat(entity.getServiceTeikyoYM().toDateString())
                .concat(entity.getKyufuJissekiKubunCode())
                .concat(entity.getJigyoshoNo().getColumnValue());
    }

}
