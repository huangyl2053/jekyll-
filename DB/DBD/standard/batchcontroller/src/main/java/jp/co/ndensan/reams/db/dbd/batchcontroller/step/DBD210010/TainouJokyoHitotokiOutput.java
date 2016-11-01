/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd210010.ShiharaiHouhouKanriHitotokiDataManager;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.TainouJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.TainouJokyoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付制限対象者一覧CSVのprocessクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public class TainouJokyoHitotokiOutput extends BatchProcessBase<TainouJokyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".kyufuseigentaishoichiran.IShiharaiHohoHenkoMapper.get滞納状況情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tainouJokyoTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tainouJokyoTemp = new BatchEntityCreatedTempTableWriter(TainouJokyoTempEntity.TABLE_NAME,
                TainouJokyoTempEntity.class);
    }

    @Override
    protected void process(TainouJokyoEntity t) {
        ShiharaiHouhouKanriHitotokiDataManager manager = new ShiharaiHouhouKanriHitotokiDataManager();
        TainouJokyoTempEntity tempTable = manager.set滞納状況一時テーブル(t);
        tainouJokyoTemp.insert(tempTable);
    }
}
