/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動送付の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsJukyushaIdoRenrakuhyoTempProcess extends BatchProcessBase<DbT3001JukyushaIdoRenrakuhyoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select受給者異動送付");
    private static final RString 受給者異動送付一時_TABLE_NAME = new RString("JukyushaIdoRenrakuhyoTemp");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者異動送付一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        受給者異動送付一時tableWriter
                = new BatchEntityCreatedTempTableWriter(受給者異動送付一時_TABLE_NAME, DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    @Override
    protected void process(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
//        if (!entity.getHiHokenshaNo().equals(new HihokenshaNo("2016111601"))) {
//            return;
//        }
        受給者異動送付一時tableWriter.insert(entity);
    }

}
