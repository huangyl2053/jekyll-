/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.InsShiharaihohoHenkoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DbT3030MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.5のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class UpdKyufuJIssekiShukeiTempProcess extends BatchKeyBreakBase<DbT3030MatchingEntity> {

    private static final RString TABLE_NAME2 = new RString("JissekiFutangakuDataTemp2");
    private static final RString PATH1 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getKyufuJIssekiShukeiTemp");
    private static final RString PATH2 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getKyufuJIssekiShukeiTempJigyobun");
    private InsShiharaihohoHenkoTempProcessParameter parameter;
    private DBC020080DataUtil util;
    private JissekiFutangakuDataTempEntity updEntity;
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
    protected void usualProcess(DbT3030MatchingEntity entity) {
        isあり = true;
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        if (getBefore() == null) {
            updEntity = 実績負担額;
            loopeHandle(entity);
            return;
        }
        if (実績負担額.equalsPrimaryKeys(getBefore().get実績負担額データ())) {
            loopeHandle(entity);
            return;
        }
        updEntity.setState(EntityDataState.Modified);
        実績負担額Writer.update(updEntity);
        updEntity = 実績負担額;
        loopeHandle(entity);
    }

    @Override
    protected void keyBreakProcess(DbT3030MatchingEntity t) {
    }

    @Override
    protected void afterExecute() {
        if (!isあり) {
            return;
        }
        実績負担額Writer.update(updEntity);
    }

    private void loopeHandle(DbT3030MatchingEntity entity) {
        DbT3033KyufujissekiShukeiEntity 給付実績集計 = entity.get給付実績集計();
        if (給付実績集計 != null) {
//            util.add自己負担額ワークエリア(updEntity, 給付実績集計);
        }
    }
}
