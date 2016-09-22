/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込の高額合算支給額計算結果明細マスタ登録するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanInsertMasterMeisaiProcess extends BatchProcessBase<DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassan.IKogakuGassanShikyugakuKeisanKekkaInMapper.select高額合算支給額計算結果明細_マスタ");
    private static final Decimal 定数_1 = new Decimal(1);
    private RString breakKey;
    private Decimal 履歴番号;

    @BatchWriter
    BatchPermanentTableWriter dbT3073Writer;

    @Override
    protected void initialize() {
        履歴番号 = Decimal.ZERO;
        breakKey = RString.EMPTY;
    }

    @Override
    protected void createWriter() {
        dbT3073Writer = new BatchPermanentTableWriter(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {

        DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity dbt3073Entity = new DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();

        RString breakTempKey = entity.getHihokenshaNo().getColumnValue().concat(entity.getTaishoNendo().toDateString())
                .concat(entity.getShoKisaiHokenshaNo().getColumnValue()).concat(entity.getShikyuShinseishoSeiriNo());
        if (RString.EMPTY.equals(breakKey) || breakKey.equals(breakTempKey)) {
            履歴番号 = 履歴番号.add(定数_1);
        } else {
            履歴番号 = 定数_1;
        }
        breakKey = breakTempKey;

        dbt3073Entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbt3073Entity.setTaishoNendo(entity.getTaishoNendo());
        dbt3073Entity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        dbt3073Entity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        dbt3073Entity.setMeisanNo(entity.getMeisanNo());
        dbt3073Entity.setRirekiNo(履歴番号);
        dbt3073Entity.setHokenSeidoCode(entity.getHokenSeidoCode());
        dbt3073Entity.setUchiwakeHokenshaNo(entity.getShoHokenshaNo().getColumnValue());
        dbt3073Entity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        dbt3073Entity.setHiHokenshaShoNo(entity.getDbwt0001_hihokenshaNo().getColumnValue());
        dbt3073Entity.setUchiwakeHokenshaMei(entity.getMeisho());
        dbt3073Entity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        dbt3073Entity.setTaishoshaShimei(entity.getTaishoshaShimei());
        dbt3073Entity.setOver70_Futangaku(entity.getOver70_Futangaku());
        dbt3073Entity.setOver70_AmbunRitsu(entity.getOver70_AmbunRitsu());
        dbt3073Entity.setOver70_Shikyugaku(entity.getOver70_Shikyugaku());
        dbt3073Entity.setUnder70_Futangaku(entity.getUnder70_Futangaku());
        dbt3073Entity.setFutangaku(entity.getFutangaku());
        dbt3073Entity.setAmbunRitsu(entity.getAmbunRitsu());
        dbt3073Entity.setUnder70_Shikyugaku(entity.getUnder70_Shikyugaku());
        dbt3073Entity.setShikyugaku(entity.getShikyugaku());
        dbt3073Entity.setOver70_Biko(entity.getOver70_Biko());
        dbt3073Entity.setUnder70_Biko(entity.getUnder70_Biko());
        dbt3073Entity.setDataKubun(entity.getDataKubun());
        dbt3073Entity.setUketoriYM(entity.getUketoriYM());
        dbt3073Entity.setSofuYM(entity.getSofuYM());
        dbt3073Entity.setState(EntityDataState.Added);
        dbT3073Writer.insert(dbt3073Entity);
    }
}
