/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110070.KogakugassanKeisankekkaRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算計算結果連絡票情報作成のProcessクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuTaishoDataShutokuProcess extends BatchProcessBase<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get高額合算計算結果連絡票情報");

    private static final RString 高額合算支給額計算結果一時 = new RString("DbWT3811KogakuGassanShikyuGakuKeisanKekka");
    private static final RString 被保険者一時 = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時 = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString データがある = new RString("1");
    private static final RString データがない = new RString("0");
    /**
     * 送付対象データ取得フラグです。
     */
    public static final RString PARAMETER_OUT_FLOWFLAG;

    static {
        PARAMETER_OUT_FLOWFLAG = new RString("dataFlag");
    }

    private int renban;
    private boolean 取得データフラグ = true;
    private KogakugassanKeisankekkaRenrakuhyoOutProcessParameter processParameter;
    private OutputParameter<RString> dataFlag;

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT3811TableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT1001TableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT1002TableWriter;

    @Override
    protected void initialize() {
        dataFlag = new OutputParameter<>();
        renban = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbWT3811TableWriter = new BatchEntityCreatedTempTableWriter(高額合算支給額計算結果一時,
                DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity.class);
        dbWT1001TableWriter = new BatchEntityCreatedTempTableWriter(被保険者一時,
                DbWT1001HihokenshaTempEntity.class);
        dbWT1002TableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        取得データフラグ = false;
        dbWT3811TableWriter.insert(get高額合算支給額計算結果一時Enttiy(entity));
        dbWT1001TableWriter.insert(get被保険者一時Entity(entity));
        renban = renban + 1;
    }

    @Override
    protected void afterExecute() {
        if (取得データフラグ) {
            dbWT1002TableWriter.insert(get処理結果リスト一時Entity());
            dataFlag.setValue(データがない);
        } else {
            dataFlag.setValue(データがある);
        }
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity() {
        DbWT1002KokuhorenSakuseiErrorTempEntity 一時Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        一時Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        一時Enttiy.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        一時Enttiy.setHihokenshaNo(HihokenshaNo.EMPTY);
        一時Enttiy.setKey1(RString.EMPTY);
        一時Enttiy.setKey2(RString.EMPTY);
        一時Enttiy.setKey3(RString.EMPTY);
        一時Enttiy.setKey4(RString.EMPTY);
        一時Enttiy.setKey5(RString.EMPTY);
        一時Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        一時Enttiy.setHihokenshaShimei(RString.EMPTY);
        一時Enttiy.setBiko(RString.EMPTY);
        return 一時Enttiy;
    }

    private DbWT1001HihokenshaTempEntity get被保険者一時Entity(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbWT1001HihokenshaTempEntity 一時Enttiy = new DbWT1001HihokenshaTempEntity();
        一時Enttiy.setExRenban(renban);
        一時Enttiy.setExHokenshaNo(HokenshaNo.EMPTY);
        一時Enttiy.setExHokenshaName(RString.EMPTY);
        一時Enttiy.setExShoHokenshaNo(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo().getColumnValue()));
        一時Enttiy.setExHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setExServiceTeikyoYm(FlexibleDate.getNowDate().getYearMonth());
        一時Enttiy.setHenkanFlag(false);
        一時Enttiy.setOldShichosonCode(LasdecCode.EMPTY);
        一時Enttiy.setSofuHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setShichosonCode(LasdecCode.EMPTY);
        一時Enttiy.setKannaiKangaiKubun(RString.EMPTY);
        一時Enttiy.setYubinNo(RString.EMPTY);
        一時Enttiy.setChoikiCode(RString.EMPTY);
        一時Enttiy.setGyoseikuCode(RString.EMPTY);
        一時Enttiy.setGyoseikuMei(RString.EMPTY);
        一時Enttiy.setJusho(RString.EMPTY);
        一時Enttiy.setBanchi(RString.EMPTY);
        一時Enttiy.setKatagaki(RString.EMPTY);
        一時Enttiy.setKanaMeisho(RString.EMPTY);
        一時Enttiy.setMeisho(RString.EMPTY);
        一時Enttiy.setShimei50onKana(RString.EMPTY);
        一時Enttiy.setShikibetsuCode(ShikibetsuCode.EMPTY);
        一時Enttiy.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        一時Enttiy.setShikakuShutokuJiyuCode(RString.EMPTY);
        一時Enttiy.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        一時Enttiy.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        一時Enttiy.setSetaiShuyakuNo(RString.EMPTY);
        一時Enttiy.setSeinenYmd(FlexibleDate.EMPTY);
        一時Enttiy.setSeibetsuCode(RString.EMPTY);
        一時Enttiy.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        一時Enttiy.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        return 一時Enttiy;
    }

    private DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity get高額合算支給額計算結果一時Enttiy(
            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity 一時Enttiy = new DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity();
        一時Enttiy.setRenban(renban);
        一時Enttiy.setHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setTaishoNendo(entity.getTaishoNendo());
        一時Enttiy.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        一時Enttiy.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        一時Enttiy.setRirekiNo(entity.getRirekiNo());
        一時Enttiy.setHokenSeidoCode(entity.getHokenSeidoCode());
        一時Enttiy.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        一時Enttiy.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        一時Enttiy.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        一時Enttiy.setSetaiFutanSogaku(entity.getSetaiFutanSogaku());
        一時Enttiy.setSetaiGassanGaku(entity.getSetaiGassanGaku());
        一時Enttiy.setOver70_SetaiGassanGaku(entity.getOver70_SetaiGassanGaku());
        一時Enttiy.setShotokuKubun(entity.getShotokuKubun());
        一時Enttiy.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        一時Enttiy.setSanteiKijunGaku(entity.getSanteiKijunGaku());
        一時Enttiy.setOver70_SanteiKijyunGaku(entity.getOver70_SanteiKijyunGaku());
        一時Enttiy.setSetaiShikyuSogaku(entity.getSetaiShikyuSogaku());
        一時Enttiy.setOver70_SetaiShikyuSogaku(entity.getOver70_SetaiShikyuSogaku());
        一時Enttiy.setHonninShikyugaku(entity.getHonninShikyugaku());
        一時Enttiy.setOver70_honninShikyugaku(entity.getOver70_honninShikyugaku());
        一時Enttiy.setTeiShotoku_1_SaiKeisanUmu(entity.getTeiShotoku_1_SaiKeisanUmu());
        一時Enttiy.setBiko(entity.getBiko());
        一時Enttiy.setKekkaRenrakusakiYubinNo(entity.getKekkaRenrakusakiYubinNo());
        一時Enttiy.setKekkaRenrakusakiJusho(entity.getKekkaRenrakusakiJusho());
        一時Enttiy.setKetteRenrakusakiMeisho1(entity.getKetteRenrakusakiMeisho1());
        一時Enttiy.setKekkaRenrakusakiMeisho2(entity.getKekkaRenrakusakiMeisho2());
        一時Enttiy.setTsuchiYMD(entity.getTsuchiYMD());
        一時Enttiy.setRenrakuhyoHakkoshaMei(entity.getRenrakuhyoHakkoshaMei());
        一時Enttiy.setRenrakuhyoHakkoshaYubinNo(entity.getRenrakuhyoHakkoshaYubinNo());
        一時Enttiy.setRenrakuhyoHakkoshaJusho(entity.getRenrakuhyoHakkoshaJusho());
        一時Enttiy.setToiawasesakiYobinNo(entity.getToiawasesakiYobinNo());
        一時Enttiy.setToiawasesakiJusho(entity.getToiawasesakiJusho());
        一時Enttiy.setToiawasesakiMeisho1(entity.getToiawasesakiMeisho1());
        一時Enttiy.setToiawasesakiMeisho2(entity.getToiawasesakiMeisho2());
        一時Enttiy.setToiawasesakiTelNo(entity.getToiawasesakiTelNo());
        一時Enttiy.setOver70_FutangakuGokei(entity.getOver70_FutangakuGokei());
        一時Enttiy.setOver70_ShikyugakuGokei(entity.getOver70_ShikyugakuGokei());
        一時Enttiy.setUnder70_FutangakuGokei(entity.getUnder70_FutangakuGokei());
        一時Enttiy.setFutangakuGokei(entity.getFutangakuGokei());
        一時Enttiy.setUnder70_ShikyugakuGokei(entity.getUnder70_ShikyugakuGokei());
        一時Enttiy.setShikyugakuGokei(entity.getShikyugakuGokei());
        一時Enttiy.setDataKubun(entity.getDataKubun());
        一時Enttiy.setUketoriYM(entity.getUketoriYM());
        一時Enttiy.setSofuYM(entity.getSofuYM());
        一時Enttiy.setSaisoFG(entity.getSaisoFG());
        一時Enttiy.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
        一時Enttiy.setSofuJogaiFlag(false);
        return 一時Enttiy;
    }
}
