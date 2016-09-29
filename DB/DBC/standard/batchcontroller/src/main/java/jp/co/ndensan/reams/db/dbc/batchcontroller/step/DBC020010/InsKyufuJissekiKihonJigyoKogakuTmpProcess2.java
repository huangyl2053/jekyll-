/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020010.KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績基本データのバックアップ1のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyufuJissekiKihonJigyoKogakuTmpProcess2 extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString 事業高額_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select給付実績基本情報事業高額一時2");
    private KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter parameter;
    private static final RString TABLE_給付実績基本情報事業高額一時2 = new RString("TempKyufujissekiKihonJigyo2");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiKihonWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(事業高額_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        kyufujissekiKihonWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時2, DbT3017KyufujissekiKihonEntity.class);
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        kyufujissekiKihonWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
