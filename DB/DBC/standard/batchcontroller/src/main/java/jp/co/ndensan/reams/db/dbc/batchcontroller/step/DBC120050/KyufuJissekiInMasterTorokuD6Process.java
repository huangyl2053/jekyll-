/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120050.KyufuJissekiInMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付更新結果情報取込・マスタ登録・D6を実行する。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInMasterTorokuD6Process extends BatchProcessBase<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekiin.IKyufuJissekiInMasterTorokuMapper.getマスタ登録データD6");
    @BatchWriter
    private BatchPermanentTableWriter 給付実績福祉用具販売費tableWriter;

    private KyufuJissekiInMasterTorokuProcessParameter parameter;
    private static final int 十桁 = 10;

    @Override
    protected void createWriter() {
        給付実績福祉用具販売費tableWriter
                = new BatchPermanentTableWriter(DbT3026KyufujissekiFukushiYoguHanbaihiEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity) {
        RString 通し番号 = new RString(Long.parseLong(entity.getToshiNo().toString())
                + parameter.get番号() - 1).padZeroToLeft(十桁);
        entity.setToshiNo(通し番号);
        entity.setState(EntityDataState.Added);
        給付実績福祉用具販売費tableWriter.insert(entity);
    }

}
