/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120120;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWTKogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込の履歴番号確認のクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanRirekiNoKakuninProcess extends BatchProcessBase<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassan.IKogakuGassanShikyugakuKeisanKekkaInMapper.select高額合算支給額計算結果");
    private static final RString 高額合算支給額計算結果_TABLE_NAME = new RString("DbWT3861KogakuGassanShikyugakuKeisanKekka");
    private static final RString データ区分 = new RString("1");
    private static final RString データ区分_保険者作成 = new RString("2");
    private static final RString データ区分_国保連作成 = new RString("3");
    private static final RString 再送フラグ_再送要 = new RString("1");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給額計算結果一時tableWriter;

    @Override
    protected void createWriter() {
        高額合算支給額計算結果一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給額計算結果_TABLE_NAME, DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbWTKogakuGassanShikyugakuKeisanKekkaEntity entity) {

        if (entity.getRirekiNoMax() != 0) {
            DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity dbWT3861entity = new DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity();
            dbWT3861entity.setRenban(entity.getRenban());
            dbWT3861entity.setHihokenshaNoIn(entity.getHihokenshaNoIn());
            dbWT3861entity.setTaishoNendo(entity.getTaishoNendo());
            dbWT3861entity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
            dbWT3861entity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
            dbWT3861entity.setRirekiNo(entity.getRirekiNoMax() + 1);
            dbWT3861entity.setHokenSeidoCode(entity.getHokenSeidoCode());
            dbWT3861entity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
            dbWT3861entity.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
            dbWT3861entity.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
            dbWT3861entity.setSetaiFutanSogaku(entity.getSetaiFutanSogaku());
            dbWT3861entity.setSetaiGassanGaku(entity.getSetaiGassanGaku());
            dbWT3861entity.setOver70_SetaiGassanGaku(entity.getOver70_SetaiGassanGaku());
            dbWT3861entity.setShotokuKubun(entity.getShotokuKubun());
            dbWT3861entity.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
            dbWT3861entity.setSanteiKijunGaku(entity.getSanteiKijunGaku());
            dbWT3861entity.setOver70_SanteiKijyunGaku(entity.getOver70_SanteiKijyunGaku());
            dbWT3861entity.setSetaiShikyuSogaku(entity.getSetaiShikyuSogaku());
            dbWT3861entity.setOver70_SetaiShikyuSogaku(entity.getOver70_SetaiShikyuSogaku());
            dbWT3861entity.setHonninShikyugaku(entity.getHonninShikyugaku());
            dbWT3861entity.setOver70_honninShikyugaku(entity.getOver70_honninShikyugaku());
            dbWT3861entity.setTeiShotoku_1_SaiKeisanUmu(entity.getTeiShotoku_1_SaiKeisanUmu());
            dbWT3861entity.setBiko(entity.getBiko());
            dbWT3861entity.setKekkaRenrakusakiYubinNo(entity.getKekkaRenrakusakiYubinNo());
            dbWT3861entity.setKekkaRenrakusakiJusho(entity.getKekkaRenrakusakiJusho());
            dbWT3861entity.setKetteRenrakusakiMeisho1(entity.getKetteRenrakusakiMeisho1());
            dbWT3861entity.setKekkaRenrakusakiMeisho2(entity.getKekkaRenrakusakiMeisho2());
            dbWT3861entity.setTsuchiYMD(entity.getTsuchiYMD());
            dbWT3861entity.setRenrakuhyoHakkoshaMei(entity.getRenrakuhyoHakkoshaMei());
            dbWT3861entity.setRenrakuhyoHakkoshaYubinNo(entity.getRenrakuhyoHakkoshaYubinNo());
            dbWT3861entity.setRenrakuhyoHakkoshaJusho(entity.getRenrakuhyoHakkoshaJusho());
            dbWT3861entity.setToiawasesakiYobinNo(entity.getToiawasesakiYobinNo());
            dbWT3861entity.setToiawasesakiJusho(entity.getToiawasesakiJusho());
            dbWT3861entity.setToiawasesakiMeisho1(entity.getToiawasesakiMeisho1());
            dbWT3861entity.setToiawasesakiMeisho2(entity.getToiawasesakiMeisho2());
            dbWT3861entity.setToiawasesakiTelNo(entity.getToiawasesakiTelNo());
            dbWT3861entity.setOver70_FutangakuGokei(entity.getOver70_FutangakuGokei());
            dbWT3861entity.setOver70_ShikyugakuGokei(entity.getOver70_ShikyugakuGokei());
            dbWT3861entity.setUnder70_FutangakuGokei(entity.getUnder70_FutangakuGokei());
            dbWT3861entity.setFutangakuGokei(entity.getFutangakuGokei());
            dbWT3861entity.setUnder70_ShikyugakuGokei(entity.getUnder70_ShikyugakuGokei());
            dbWT3861entity.setShikyugakuGokei(entity.getShikyugakuGokei());
            if (データ区分_保険者作成.equals(entity.getDbt3072DataKubun())) {
                dbWT3861entity.setDataKubun(データ区分_国保連作成);
            } else {
                dbWT3861entity.setDataKubun(データ区分);
            }
            if (データ区分_保険者作成.equals(entity.getDbt3072DataKubun())
                    && (再送フラグ_再送要.equals(entity.getDbt3072SaisoFG())
                    || entity.getDbt3072SofuYM() == null || entity.getDbt3072SofuYM().isEmpty())) {
                dbWT3861entity.setKakuninListFlag(true);
            }
            dbWT3861entity.setUketoriYM(entity.getUketoriYM());
            dbWT3861entity.setSofuYM(entity.getSofuYM());
            dbWT3861entity.setSaisoFG(entity.getSaisoFG());
            dbWT3861entity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());

            dbWT3861entity.setState(EntityDataState.Added);
            高額合算支給額計算結果一時tableWriter.insert(dbWT3861entity);
            dbWT3861entity.setRirekiNo(entity.getRirekiNo());
            dbWT3861entity.setState(EntityDataState.Deleted);
            高額合算支給額計算結果一時tableWriter.delete(dbWT3861entity);
        }
    }

}
