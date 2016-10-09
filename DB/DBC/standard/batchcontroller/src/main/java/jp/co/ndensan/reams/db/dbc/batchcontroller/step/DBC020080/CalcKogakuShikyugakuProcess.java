/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.CalcKogakuShikyugakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.KogakuShikyugakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の高額支給額集計のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class CalcKogakuShikyugakuProcess extends BatchProcessBase<CalcKogakuShikyugakuEntity> {

    private static final RString TABLE_NAME = new RString("JissekiFutangakuDataTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getCalcKogakuShikyugaku");
    private DBC020080DataUtil util;
    private JissekiFutangakuDataTempEntity updEntity;
    private boolean isあり;
    private CalcKogakuShikyugakuEntity beforeEntity;
    @BatchWriter
    private IBatchTableWriter 実績負担額Writer;

    @Override
    protected void initialize() {
        isあり = false;

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
    protected void process(CalcKogakuShikyugakuEntity entity) {
        isあり = true;
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        KogakuShikyugakuEntity 関連データ = entity.get関連データ();
        if (関連データ == null) {
            return;
        }
        if (beforeEntity == null) {
            updEntity = 実績負担額;
            initHandle(updEntity);
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        if (実績負担額.equalsPrimaryKeys(beforeEntity.get実績負担額データ())) {
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        updEntity.setState(EntityDataState.Modified);
        実績負担額Writer.update(updEntity);
        updEntity = 実績負担額;
        initHandle(updEntity);
        loopHandle(entity);
        beforeEntity = entity;
    }

    @Override
    protected void afterExecute() {
        if (!isあり) {
            return;
        }
        実績負担額Writer.update(updEntity);
    }

    private void initHandle(JissekiFutangakuDataTempEntity updEntity) {
        util.init高額支給額ワークエリア(updEntity);
        util.get補正済自己負担額項目に0でない月(updEntity);
    }

    private void loopHandle(CalcKogakuShikyugakuEntity entity) {

    }
}
