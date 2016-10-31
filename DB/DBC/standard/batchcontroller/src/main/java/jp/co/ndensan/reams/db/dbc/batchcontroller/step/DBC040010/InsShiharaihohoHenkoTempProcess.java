/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DbT3017MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のBatchStep2.3のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class InsShiharaihohoHenkoTempProcess extends BatchKeyBreakBase<DbT3017MatchingEntity> {

    private static final RString JIKOFUTANGAKUWORK = new RString("JikoFutangakuWork");
    private static final RString UCHISUJIKOFUTANGAKU = new RString("UchisuJikoFutanGaku");
    private static final RString TABLE_NAME2 = new RString("JissekiFutangakuDataTemp2");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.getShiharaihohoHenkoHosoku");
    private DBC040010DataUtil util;
    private JissekiFutangakuDataTempEntity insertEntity;
    private boolean isあり;
    @BatchWriter
    private IBatchTableWriter 実績負担額2Writer;

    @Override
    protected void initialize() {
        util = new DBC040010DataUtil();
        isあり = false;
    }

    @Override
    protected void createWriter() {
        実績負担額2Writer = new BatchEntityCreatedTempTableWriter(TABLE_NAME2, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void usualProcess(DbT3017MatchingEntity entity) {
        isあり = true;
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        if (entity.get給付実績基本() == null) {
            insertEntity = null;
            return;
        }
        if (getBefore() == null) {
            insertEntity = 実績負担額;
            initHandle();
            loopHandle(entity);
            return;
        }
        if (実績負担額.equalsPrimaryKeys(getBefore().get実績負担額データ())) {
            loopHandle(entity);
            return;
        }
        実績負担額2Writer.insert(insertEntity);
        insertEntity = 実績負担額;
        initHandle();
        loopHandle(entity);
    }

    private void loopHandle(DbT3017MatchingEntity entity) {
        DbT3017KyufujissekiKihonEntity 給付実績基本 = entity.get給付実績基本();
        DbT4021ShiharaiHohoHenkoEntity 支払方法変更 = entity.get支払方法変更();
        if (支払方法変更 != null) {
            util.insShiharaihohoHenkoTemp(insertEntity, 給付実績基本.getServiceTeikyoYM().toDateString());
        }
    }

    @Override
    protected void keyBreakProcess(DbT3017MatchingEntity t) {

    }

    @Override
    protected void afterExecute() {
        if (!isあり || insertEntity == null) {
            return;
        }
        実績負担額2Writer.insert(insertEntity);
    }

    private void initHandle() {
        util.loopInitDecimal(insertEntity, JIKOFUTANGAKUWORK);
        util.loopInitDecimal(insertEntity, UCHISUJIKOFUTANGAKU);
    }
}
