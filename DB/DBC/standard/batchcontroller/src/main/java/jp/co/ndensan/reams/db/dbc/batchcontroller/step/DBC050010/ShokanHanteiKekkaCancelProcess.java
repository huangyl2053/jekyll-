/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 頼済の登録_償還払支給判定結果_依頼済取消更新_Process処理クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public class ShokanHanteiKekkaCancelProcess extends BatchProcessBase<DbT3036ShokanHanteiKekkaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiDataTourokuMapper.select依頼済取消_償還払支給判定結果情報");

    @BatchWriter
    private BatchPermanentTableWriter 償還払支給判定結果tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        償還払支給判定結果tableWriter = new BatchPermanentTableWriter(DbT3036ShokanHanteiKekkaEntity.class);
    }

    @Override
    protected void process(DbT3036ShokanHanteiKekkaEntity t) {
        t.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
        償還払支給判定結果tableWriter.update(t);
    }
}
