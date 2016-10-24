/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DbT3170MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の<br/>
 * 計算結果を「高額合算自己負担額」、「高額合算自己負担額明細」に登録のプロセスです。
 *
 * @reamsid_L DBC-2060-050 lijunjun
 */
public class SetFutangakubackProcess extends BatchProcessBase<DbT3170MatchingEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.get自己負担額");

//    @BatchWriter
//    private IBatchTableWriter 高額合算自己負担額Writer;
//    @BatchWriter
//    private IBatchTableWriter 高額合算自己負担額明細Writer;
//    @BatchWriter
//    private IBatchTableWriter 高額合算申請書Writer;
//    private DBC020080DataUtil util;
//    private SetFutangakuProcessParameter processParameter;
//    private Decimal 抽出対象自己負担基準額;
    private DbT3170MatchingEntity beforeEntity;
//    private boolean isあり;
    private JissekiFutangakuDataTempEntity updEntity;

    @Override
    protected void initialize() {
//        RString configValue = DbBusinessConfig.get(
//                ConfigNameDBC.高額合算自己負担額計算_抽出対象自己負担基準額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
//        抽出対象自己負担基準額 = RString.isNullOrEmpty(configValue) ? Decimal.ZERO : new Decimal(configValue.toString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void createWriter() {
//        高額合算申請書Writer = new BatchPermanentTableWriter(DbT3068KogakuGassanShinseishoEntity.class);
//        if (!processParameter.is事業分フラグ()) {
//            高額合算自己負担額Writer = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
//            高額合算自己負担額明細Writer = new BatchPermanentTableWriter(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity.class);
//
//        } else {
//            高額合算自己負担額Writer = new BatchPermanentTableWriter(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
//            高額合算自己負担額明細Writer = new BatchPermanentTableWriter(DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity.class);
//        }
    }

    @Override
    protected void process(DbT3170MatchingEntity entity) {
//        isあり = true;
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        if (beforeEntity == null) {
            updEntity = 実績負担額;
            initHandle();
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        if (実績負担額.equalsPrimaryKeys(beforeEntity.get実績負担額データ())) {
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        beforeUpdate();
        updEntity.setState(EntityDataState.Modified);
        updEntity = 実績負担額;
        initHandle();
        loopHandle(entity);
        beforeEntity = entity;
    }

    private void initHandle() {
    }

    private void loopHandle(DbT3170MatchingEntity entity) {
        if (entity != null) {
            entity = null;
        }
//        JissekiFutangakuDataTempEntity 実績負担額データ = entity.get実績負担額データ();
//        DbT3170JigyoKogakuGassanJikoFutanGakuEntity 高額合算自己負担額 = entity.get高額合算自己負担額();
//        DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細 = entity.get高額合算自己負担額明細();
//        if (!util.hasSetFutangaku更新処理(実績負担額データ, 抽出対象自己負担基準額, processParameter)) {
//            return;
//        }
//        if (高額合算自己負担額 == null) {
////TODO INSERT
//
//            return;
//        }
//TODO UPDATE
    }

    private void beforeUpdate() {
    }
}
