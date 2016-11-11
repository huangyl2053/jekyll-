/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DbT3170MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の<br/>
 * 計算結果を「高額合算自己負担額」、「高額合算自己負担額明細」に登録のプロセスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class SetFutangakuProcess extends BatchProcessBase<DbT3170MatchingEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.get自己負担額");

    @BatchWriter
    private IBatchTableWriter 高額合算自己負担額Writer;
    @BatchWriter
    private IBatchTableWriter 高額合算自己負担額明細Writer;

    private DBC040010DataUtil util;
    private SetFutangakuProcessParameter processParameter;
    private Decimal 抽出対象自己負担基準額;
    private DbT3170MatchingEntity beforeEntity;
    private RString beforKeyOf高額合算自己負担額;

    @Override
    protected void initialize() {
        util = new DBC040010DataUtil();
        RString configValue;
        if (!processParameter.is事業分フラグ()) {
            configValue = DbBusinessConfig.get(
                    ConfigNameDBC.高額合算自己負担額計算_抽出対象自己負担基準額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        } else {
            configValue = DbBusinessConfig.get(
                    ConfigNameDBC.事業高額合算自己負担額計算_抽出対象自己負担基準額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        }
        抽出対象自己負担基準額 = RString.isNullOrEmpty(configValue) ? Decimal.ZERO : new Decimal(configValue.toString());
        beforKeyOf高額合算自己負担額 = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, processParameter.toSetFutangakuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        if (!processParameter.is事業分フラグ()) {
            高額合算自己負担額Writer = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
            高額合算自己負担額明細Writer = new BatchPermanentTableWriter(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity.class);
        } else {
            高額合算自己負担額Writer = new BatchPermanentTableWriter(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
            高額合算自己負担額明細Writer = new BatchPermanentTableWriter(DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity.class);
        }
    }

    @Override
    protected void process(DbT3170MatchingEntity entity) {
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        if (beforeEntity == null) {
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        if (実績負担額.equalsPrimaryKeys(beforeEntity.get実績負担額データ())) {
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        loopHandle(entity);
        beforeEntity = entity;
    }

    private void loopHandle(DbT3170MatchingEntity entity) {
        JissekiFutangakuDataTempEntity 実績負担額データ = entity.get実績負担額データ();
        DbT3170JigyoKogakuGassanJikoFutanGakuEntity 高額合算自己負担額 = entity.get高額合算自己負担額();
        DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細 = entity.get高額合算自己負担額明細();
        if (!util.hasSetFutangaku更新処理(実績負担額データ, 抽出対象自己負担基準額, processParameter)) {
            return;
        }
        if (高額合算自己負担額 == null) {
            insertHandle(実績負担額データ);
            return;
        }
        updateHandle(実績負担額データ, 高額合算自己負担額, 高額合算自己負担額明細);
    }

    private void insertHandle(JissekiFutangakuDataTempEntity 実績負担額データ) {
        if (!processParameter.is事業分フラグ()) {
            高額合算自己負担額Writer.insert(util.getInsOrUpd高額合算自己負担額(実績負担額データ, null, false));
            List<DbT3071KogakuGassanJikoFutanGakuMeisaiEntity> ins高額合算自己負担額明細
                    = util.getIns高額合算自己負担額明細(実績負担額データ);
            for (DbT3071KogakuGassanJikoFutanGakuMeisaiEntity ins明細 : ins高額合算自己負担額明細) {
                高額合算自己負担額明細Writer.insert(ins明細);
            }
        } else {
            高額合算自己負担額Writer.insert(util.getInsOrUpd高額合算自己負担額事業分(実績負担額データ, null, false));
            List<DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity> ins高額合算自己負担額明細
                    = util.getIns高額合算自己負担額明細事業分(実績負担額データ);
            for (DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity ins明細 : ins高額合算自己負担額明細) {
                高額合算自己負担額明細Writer.insert(ins明細);
            }
        }
    }

    private void updateHandle(JissekiFutangakuDataTempEntity 実績負担額データ,
            DbT3170JigyoKogakuGassanJikoFutanGakuEntity 高額合算自己負担額,
            DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細) {
        RString nowKey = util.getKeyOf高額合算自己負担額(高額合算自己負担額);
        if (!processParameter.is事業分フラグ()) {
            if (!nowKey.equals(beforKeyOf高額合算自己負担額)) {
                高額合算自己負担額Writer.update(util.getInsOrUpd高額合算自己負担額(実績負担額データ,
                        util.toDbT3070KogakuGassanJikoFutanGakuEntity(高額合算自己負担額), true));
                beforKeyOf高額合算自己負担額 = nowKey;
            }
            if (高額合算自己負担額明細 == null) {
                return;
            }
            DbT3071KogakuGassanJikoFutanGakuMeisaiEntity updEntity = util.update高額合算自己負担額明細(実績負担額データ,
                    util.toDbT3071KogakuGassanJikoFutanGakuMeisaiEntity(高額合算自己負担額明細));
            if (updEntity != null) {
                高額合算自己負担額明細Writer.update(updEntity);
            }
        } else {
            if (!nowKey.equals(beforKeyOf高額合算自己負担額)) {
                高額合算自己負担額Writer.update(util.getInsOrUpd高額合算自己負担額事業分(実績負担額データ, 高額合算自己負担額, true));
                beforKeyOf高額合算自己負担額 = nowKey;
            }
            if (高額合算自己負担額明細 == null) {
                return;
            }
            DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity updEntity = util.update高額合算自己負担額明細(実績負担額データ,
                    高額合算自己負担額明細);
            if (updEntity != null) {
                高額合算自己負担額明細Writer.update(updEntity);
            }
        }
    }
}
