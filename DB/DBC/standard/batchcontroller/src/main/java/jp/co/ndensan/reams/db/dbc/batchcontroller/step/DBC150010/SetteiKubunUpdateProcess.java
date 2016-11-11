/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1510KyufuJissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 設定区分更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class SetteiKubunUpdateProcess extends BatchProcessBase<DbWT1510KyufuJissekiKihonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select設定区分");

    private static final RString TABLE_給付実績基本一時 = new RString("DbWT1510KyufuJissekiKihon");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        給付実績基本一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本一時,
                DbWT1510KyufuJissekiKihonEntity.class);
    }

    @Override
    protected void process(DbWT1510KyufuJissekiKihonEntity entity) {
        給付実績基本一時TBL.update(entity);
    }
}
