/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.UpdJikofutangakuChukanTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.2のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class UpdJikofutangakuChukanTempProcess extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString TABLE_NAME = new RString("JissekiFutangakuDataTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.get実績負担額データ");
    private DBC020080DataUtil util;
    private UpdJikofutangakuChukanTempProcessParameter parameter;

    @BatchWriter
    private IBatchTableWriter 実績負担額Writer;

    @Override
    protected void initialize() {
        util = new DBC020080DataUtil();
    }

    @Override
    protected void createWriter() {
        実績負担額Writer = new BatchEntityCreatedTempTableWriter(TABLE_NAME, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity entity) {
        entity.setState(EntityDataState.Modified);
        util.update受託なし処理時(entity, parameter.get処理日時());
        実績負担額Writer.update(entity);
    }
}
