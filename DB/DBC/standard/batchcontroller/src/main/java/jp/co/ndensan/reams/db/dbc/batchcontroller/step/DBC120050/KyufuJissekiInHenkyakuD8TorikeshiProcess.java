/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111JKyufuJissekiD8Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuD8DataEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 返却データ削除・給付実績D8の取消データの場合。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInHenkyakuD8TorikeshiProcess extends BatchProcessBase<KyufuJissekiInHenkyakuD8DataEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekiin.IKyufuJissekiInMasterTorokuMapper.select給付実績D8の取消データ");
    @BatchWriter
    private BatchPermanentTableWriter 給付実績高額tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績D8tableWriter;
    private static final RString 給付実績D8一時_TABLE_NAME = new RString("DbWT111JKyufuJissekiD8");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績高額tableWriter
                = new BatchPermanentTableWriter(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class);
        給付実績D8tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D8一時_TABLE_NAME, DbWT111JKyufuJissekiD8Entity.class);
    }

    @Override
    protected void process(KyufuJissekiInHenkyakuD8DataEntity entity) {
        DbWT111JKyufuJissekiD8Entity 給付実績D8 = entity.get給付実績D8();
        DbT3028KyufujissekiKogakuKaigoServicehiEntity 給付実績高額 = entity.get給付実績高額介護サービス費();
        給付実績高額.setState(EntityDataState.Deleted);
        給付実績高額tableWriter.delete(給付実績高額);

        給付実績D8.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(true);
        給付実績D8.setState(EntityDataState.Modified);
        給付実績D8tableWriter.update(給付実績D8);
    }

}
