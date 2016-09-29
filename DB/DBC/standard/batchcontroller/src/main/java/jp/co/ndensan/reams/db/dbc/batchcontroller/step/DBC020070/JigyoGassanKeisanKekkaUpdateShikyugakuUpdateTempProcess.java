/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算支給額計算結果データに既に履歴が存在する場合に、最新の履歴番号を設定する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class JigyoGassanKeisanKekkaUpdateShikyugakuUpdateTempProcess extends BatchProcessBase<ShikyugakuUpdateTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get更新用一時最新の履歴番号");

    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempEntity entity) {
        entity.setShikyugaku_rirekiNo(entity.getShikyugaku_rirekiNo() + 1);
        entity.setShikyugakuMeisai_rirekiNo(entity.getShikyugakuMeisai_rirekiNo() + 1);

        entity.setState(EntityDataState.Modified);
        tempDbWriter.update(entity);
    }
}
