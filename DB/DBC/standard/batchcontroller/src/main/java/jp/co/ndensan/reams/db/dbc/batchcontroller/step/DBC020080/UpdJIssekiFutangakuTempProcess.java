/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.InsShiharaihohoHenkoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.6のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class UpdJIssekiFutangakuTempProcess extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString TABLE_NAME2 = new RString("JissekiFutangakuDataTemp2");
    private static final RString PATH1 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getShafukuKeigenTemp");
    private static final RString PATH2 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getShafukuKeigenTempJigyobun");
    private InsShiharaihohoHenkoTempProcessParameter parameter;
    private DBC020080DataUtil util;
    private boolean isあり;

    @BatchWriter
    private IBatchTableWriter 実績負担額Writer;

    @Override
    protected void initialize() {
        isあり = false;
        util = new DBC020080DataUtil();
    }

    @Override
    protected void createWriter() {
        実績負担額Writer = new BatchEntityCreatedTempTableWriter(TABLE_NAME2, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        RString path = parameter.is事業分フラグ() ? PATH2 : PATH1;
        return new BatchDbReader(path);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity 実績負担額) {
        loopeHandle(実績負担額);
        実績負担額Writer.update(実績負担額);
    }

    private boolean loopeHandle(JissekiFutangakuDataTempEntity 実績負担額) {
        util.init自己負担額内数ワークエリア(実績負担額);
        if (!util.judgeAgeLessThan75(実績負担額)) {
            return false;
        }

//        TODO
        return true;

    }
}
