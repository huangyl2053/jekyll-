/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HihoNoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データ比較処理を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class DataCompareShoriProcess extends BatchProcessBase<HihoNoTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select一致被保情報");
    private static final RString 被保番一時_TABLE_NAME = new RString("IdoTmp2");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動対象一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動対象一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保番一時_TABLE_NAME, HihoNoTempEntity.class);
    }

    @Override
    protected void process(HihoNoTempEntity entity) {
        if (entity.getHihokenshaNo().equals(new HihokenshaNo("2016092401"))) {
            異動対象一時tableWriter.insert(entity);
        }
    }

}
