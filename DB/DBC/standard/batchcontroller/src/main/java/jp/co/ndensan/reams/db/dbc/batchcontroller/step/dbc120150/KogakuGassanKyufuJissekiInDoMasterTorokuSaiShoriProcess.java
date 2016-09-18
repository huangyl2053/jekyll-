/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120150;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInLoginMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績取込のマスタ登録(再処理準備)。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInDoMasterTorokuSaiShoriProcess extends BatchProcessBase<DbT3075KogakuGassanKyufuJissekiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassankyufujissekiin.IKogakuGassanKyufuJissekiInMapper.get高額合算給付実績一時再処理準備のデータ");
    private KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter;
    private KogakuGassanKyufuJissekiInLoginMybatisParameter dbParameter;
    @BatchWriter
    BatchPermanentTableWriter dbT3075Writer;

    @Override
    protected void initialize() {
        dbParameter = new KogakuGassanKyufuJissekiInLoginMybatisParameter();
        if (parameter.get処理区分() != null) {
            dbParameter.set処理区分(parameter.get処理区分().trim());
        }
        dbParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, dbParameter);
    }

    @Override
    protected void createWriter() {
        dbT3075Writer = new BatchPermanentTableWriter(DbT3075KogakuGassanKyufuJissekiEntity.class);

    }

    @Override
    protected void process(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        doデータ削除(entity);
    }

    private void doデータ削除(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        DbT3075KogakuGassanKyufuJissekiEntity dbt3075entity = new DbT3075KogakuGassanKyufuJissekiEntity();
        dbt3075entity.setKokanJohoShikibetsuNo(entity.getKokanJohoShikibetsuNo());
        dbt3075entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbt3075entity.setShikyuShinseiSeiriNo(entity.getShikyuShinseiSeiriNo());
        dbt3075entity.setSeiriNo(entity.getSeiriNo());
        dbt3075entity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        dbt3075entity.setHokenSeidoCode(entity.getHokenSeidoCode());
        dbt3075entity.setKyufuJissekiSakuseiKubunCode(entity.getKyufuJissekiSakuseiKubunCode());
        dbt3075entity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        dbt3075entity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        dbt3075entity.setShinseiYMD(entity.getShinseiYMD());
        dbt3075entity.setKetteiYMD(entity.getKetteiYMD());
        dbt3075entity.setJikoFutanSogaku(entity.getJikoFutanSogaku());
        dbt3075entity.setShikyuGaku(entity.getShikyuGaku());
        dbt3075entity.setShoriYM(entity.getShoriYM());
        dbt3075entity.setUketoriYM(entity.getUketoriYM());
        dbt3075entity.setSofuYM(entity.getSofuYM());
        dbt3075entity.setDataKubun(entity.getDataKubun());
        dbT3075Writer.delete(dbt3075entity);
    }

}
