/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細一覧表作成_申請データ有無確認_Process処理クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public class ShinseiDataKakuninProcess extends BatchProcessBase<FurikomiDetailTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IShinseiDataKakuninMapper.select申請データ有無確認情報");

    @BatchWriter
    BatchEntityCreatedTempTableWriter shinseiDataKakuninWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shinseiDataKakuninWriter = new BatchEntityCreatedTempTableWriter(FurikomiDetailTempTableEntity.TABLE_NAME,
                FurikomiDetailTempTableEntity.class);
    }

    @Override
    protected void process(FurikomiDetailTempTableEntity t) {
        t.setShinseiDataFlag(true);
        shinseiDataKakuninWriter.update(t);
    }
}
