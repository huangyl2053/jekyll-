/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWTKogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込の高額合算支給額計算結果マスタ登録するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanInsertMasterProcess extends BatchProcessBase<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassan.IKogakuGassanShikyugakuKeisanKekkaInMapper.select高額合算支給額計算結果_マスタ");

    @BatchWriter
    BatchPermanentTableWriter dbT3072Writer;

    @Override
    protected void createWriter() {
        dbT3072Writer = new BatchPermanentTableWriter(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbWTKogakuGassanShikyugakuKeisanKekkaEntity entity) {

        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity dbT3072entity = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
        dbT3072entity.setHihokenshaNo(entity.getHihokenshaNoIn());
        dbT3072entity.setTaishoNendo(entity.getTaishoNendo());
        dbT3072entity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        dbT3072entity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        dbT3072entity.setRirekiNo(entity.getRirekiNo());
        dbT3072entity.setHokenSeidoCode(entity.getHokenSeidoCode());
        dbT3072entity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        dbT3072entity.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        dbT3072entity.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        dbT3072entity.setSetaiFutanSogaku(entity.getSetaiFutanSogaku());
        dbT3072entity.setSetaiGassanGaku(entity.getSetaiGassanGaku());
        dbT3072entity.setOver70_SetaiGassanGaku(entity.getOver70_SetaiGassanGaku());
        dbT3072entity.setShotokuKubun(entity.getShotokuKubun());
        dbT3072entity.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        dbT3072entity.setSanteiKijunGaku(entity.getSanteiKijunGaku());
        dbT3072entity.setOver70_SanteiKijyunGaku(entity.getOver70_SanteiKijyunGaku());
        dbT3072entity.setSetaiShikyuSogaku(entity.getSetaiShikyuSogaku());
        dbT3072entity.setOver70_SetaiShikyuSogaku(entity.getOver70_SetaiShikyuSogaku());
        dbT3072entity.setHonninShikyugaku(entity.getHonninShikyugaku());
        dbT3072entity.setOver70_honninShikyugaku(entity.getOver70_honninShikyugaku());
        dbT3072entity.setTeiShotoku_1_SaiKeisanUmu(entity.getTeiShotoku_1_SaiKeisanUmu());
        dbT3072entity.setBiko(entity.getBiko());
        dbT3072entity.setKekkaRenrakusakiYubinNo(entity.getKekkaRenrakusakiYubinNo());
        dbT3072entity.setKekkaRenrakusakiJusho(entity.getKekkaRenrakusakiJusho());
        dbT3072entity.setKetteRenrakusakiMeisho1(entity.getKetteRenrakusakiMeisho1());
        dbT3072entity.setKekkaRenrakusakiMeisho2(entity.getKekkaRenrakusakiMeisho2());
        dbT3072entity.setTsuchiYMD(entity.getTsuchiYMD());
        dbT3072entity.setRenrakuhyoHakkoshaMei(entity.getRenrakuhyoHakkoshaMei());
        dbT3072entity.setRenrakuhyoHakkoshaYubinNo(entity.getRenrakuhyoHakkoshaYubinNo());
        dbT3072entity.setRenrakuhyoHakkoshaJusho(entity.getRenrakuhyoHakkoshaJusho());
        dbT3072entity.setToiawasesakiYobinNo(entity.getToiawasesakiYobinNo());
        dbT3072entity.setToiawasesakiJusho(entity.getToiawasesakiJusho());
        dbT3072entity.setToiawasesakiMeisho1(entity.getToiawasesakiMeisho1());
        dbT3072entity.setToiawasesakiMeisho2(entity.getToiawasesakiMeisho2());
        dbT3072entity.setToiawasesakiTelNo(entity.getToiawasesakiTelNo());
        dbT3072entity.setOver70_FutangakuGokei(entity.getOver70_FutangakuGokei());
        dbT3072entity.setOver70_ShikyugakuGokei(entity.getOver70_ShikyugakuGokei());
        dbT3072entity.setUnder70_FutangakuGokei(entity.getUnder70_FutangakuGokei());
        dbT3072entity.setFutangakuGokei(entity.getFutangakuGokei());
        dbT3072entity.setUnder70_ShikyugakuGokei(entity.getUnder70_ShikyugakuGokei());
        dbT3072entity.setShikyugakuGokei(entity.getShikyugakuGokei());
        dbT3072entity.setDataKubun(entity.getDataKubun());
        dbT3072entity.setUketoriYM(entity.getUketoriYM());
        dbT3072entity.setSofuYM(entity.getSofuYM());
        dbT3072entity.setSaisoFG(entity.getSaisoFG());
        dbT3072entity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
        dbT3072entity.setState(EntityDataState.Added);
        dbT3072Writer.insert(dbT3072entity);
    }
}
