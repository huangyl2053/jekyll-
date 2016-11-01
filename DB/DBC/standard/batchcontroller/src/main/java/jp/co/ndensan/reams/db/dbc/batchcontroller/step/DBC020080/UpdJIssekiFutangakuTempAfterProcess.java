/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.UpdJIssekiFutangakuTempAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.7のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class UpdJIssekiFutangakuTempAfterProcess extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString 償還受託あり = new RString("2");
    private static final RString 呼び出し元自己負担額計算 = new RString("3");
    private static final RString TABLE_NAME1 = new RString("JissekiFutangakuDataTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.get実績負担額データ2");
    private DBC020080DataUtil util;
    private UpdJIssekiFutangakuTempAfterProcessParameter parameter;
    private RString 処理区分;
    @BatchWriter
    private IBatchTableWriter 実績負担額Writer;

    @Override
    protected void initialize() {
        util = new DBC020080DataUtil();
        処理区分 = parameter.get処理区分();
    }

    @Override
    protected void createWriter() {
        実績負担額Writer = new BatchEntityCreatedTempTableWriter(TABLE_NAME1, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity 実績負担額get) {
        JissekiFutangakuDataTempEntity 実績負担額set = 実績負担額get.clone();
        if (償還受託あり.equals(処理区分)) {
            util.updJIssekiFutangakuTemp償還受託あり(実績負担額set, 実績負担額get, parameter.get処理日時());
            実績負担額Writer.update(実績負担額set);
        }
        if (呼び出し元自己負担額計算.equals(処理区分)) {
            util.updJIssekiFutangakuTemp呼び出し元自己負担額計算(実績負担額set, 実績負担額get, parameter.get処理日時());
            実績負担額Writer.update(実績負担額set);
        }
    }
}
