/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.InsShiharaihohoHenkoTempBeforeProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.3のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class InsShiharaihohoHenkoTempBeforeProcess extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString TABLE_NAME = new RString("KyufujissekiKihonTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.get給付実績基本一時");
    private InsShiharaihohoHenkoTempBeforeProcessParameter parameter;
    @BatchWriter
    private IBatchTableWriter 給付実績基本TempWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected void createWriter() {
        給付実績基本TempWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbT3017KyufujissekiKihonEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toInsShiharaihohoHenkoTempBeforeMyBatisParameter());
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        給付実績基本TempWriter.insert(entity);
    }

}
