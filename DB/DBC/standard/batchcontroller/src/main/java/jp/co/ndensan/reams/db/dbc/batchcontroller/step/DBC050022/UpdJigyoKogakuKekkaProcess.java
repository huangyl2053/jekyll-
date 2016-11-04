/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼済の登録_事業高額クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class UpdJigyoKogakuKekkaProcess extends BatchProcessBase<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get依頼済の登録_事業高額");

    @BatchWriter
    private BatchPermanentTableWriter 事業高額介護サービス費支給判定結果tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        事業高額介護サービス費支給判定結果tableWriter = new BatchPermanentTableWriter(DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
    }

    @Override
    protected void process(DbT3111JigyoKogakuShikyuHanteiKekkaEntity t) {
        t.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.getNowDate());
        事業高額介護サービス費支給判定結果tableWriter.update(t);
    }
}
