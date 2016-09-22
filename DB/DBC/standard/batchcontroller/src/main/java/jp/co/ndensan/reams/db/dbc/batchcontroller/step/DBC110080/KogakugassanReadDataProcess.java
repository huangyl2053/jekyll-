/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan.KogakugassanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のバッチ送付対象データ取得Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanReadDataProcess extends BatchProcessBase<DbT3070KogakuGassanJikoFutanGakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get高額合算自己負担額データ");

    private static final RString 高額合算自己負担額一時NAME = new RString("DbWT37K1KogakuGassanJikoFutanGaku");
    private static final RString 被保険者一時NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString データがある = new RString("1");
    private static final RString データがない = new RString("0");
    /**
     * 送付対象データ取得です。
     */
    public static final RString PARAMETER_OUT_FLOWFLAG;

    static {
        PARAMETER_OUT_FLOWFLAG = new RString("dataFlag");
    }
    private int renban;
    private boolean 取得データフラグ = true;
    private KogakugassanProcessParameter processParameter;
    private OutputParameter<RString> dataFlag;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected void initialize() {
        dataFlag = new OutputParameter<>();
        renban = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toKogakugassanMybatisParameter());
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時NAME, DbWT37K1KogakuGassanJikoFutanGakuTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時NAME, DbWT1001HihokenshaTempEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        取得データフラグ = false;
        DbWT1001HihokenshaTempEntity dbWT1001Entity = get被保険者一時Entity(entity);
        DbWT37K1KogakuGassanJikoFutanGakuTempEntity dbWT37K1Entity = get高額合算自己負担額一時Enttiy(entity);
        被保険者一時tableWriter.insert(dbWT1001Entity);
        高額合算自己負担額一時tableWriter.insert(dbWT37K1Entity);
        renban = renban + 1;
    }

    @Override
    protected void afterExecute() {
        if (取得データフラグ) {
            DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002Entity = get処理結果リスト一時Entity();
            処理結果リスト一時tableWriter.insert(dbWT1002Entity);
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

    private DbWT1001HihokenshaTempEntity get被保険者一時Entity(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        DbWT1001HihokenshaTempEntity 一時Enttiy = new DbWT1001HihokenshaTempEntity();
        一時Enttiy.setExRenban(renban);
        一時Enttiy.setExHokenshaNo(HokenshaNo.EMPTY);
        一時Enttiy.setExHokenshaName(RString.EMPTY);
        一時Enttiy.setExShoHokenshaNo(new ShoKisaiHokenshaNo(entity.getHokenshaNo().getColumnValue()));
        一時Enttiy.setExHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setExServiceTeikyoYm(new FlexibleYearMonth(processParameter.getNow().toDateString()));
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

    private DbWT37K1KogakuGassanJikoFutanGakuTempEntity get高額合算自己負担額一時Enttiy(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        DbWT37K1KogakuGassanJikoFutanGakuTempEntity 一時Enttiy = new DbWT37K1KogakuGassanJikoFutanGakuTempEntity();
        一時Enttiy.setRenban(renban);
        一時Enttiy.setHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setTaishoNendo(entity.getTaishoNendo());
        一時Enttiy.setHokenshaNo(entity.getHokenshaNo());
        一時Enttiy.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        一時Enttiy.setRirekiNo(entity.getRirekiNo());
        一時Enttiy.setHokenSeidoCode(entity.getHokenSeidoCode());
        一時Enttiy.setHokenshaMei(entity.getHokenshaMei());
        一時Enttiy.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        一時Enttiy.setHihokenshaShimeiKana(entity.getHihokenshaShimeiKana());
        一時Enttiy.setHihokenshaShimei(entity.getHihokenshaShimei());
        一時Enttiy.setUmareYMD(entity.getUmareYMD());
        一時Enttiy.setSeibetsuCode(entity.getSeibetsuCode());
        一時Enttiy.setShotokuKubun(entity.getShotokuKubun());
        一時Enttiy.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        一時Enttiy.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        一時Enttiy.setKoki_HokenshaNo(entity.getKoki_HokenshaNo());
        一時Enttiy.setKoki_HihokenshaNo(entity.getKoki_HihokenshaNo());
        一時Enttiy.setKokuho_HokenshaNo(entity.getKokuho_HokenshaNo());
        一時Enttiy.setKokuho_HihokenshaShoNo(entity.getKokuho_HihokenshaShoNo());
        一時Enttiy.setKokuho_KojinNo(entity.getKokuho_KojinNo());
        一時Enttiy.setIdoKubun(entity.getIdoKubun());
        一時Enttiy.setHoseiZumiSofuKubun(entity.getHoseiZumiSofuKubun());
        一時Enttiy.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        一時Enttiy.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        一時Enttiy.setHihokenshaKaishiYMD(entity.getHihokenshaKaishiYMD());
        一時Enttiy.setHihokenshaShuryoYMD(entity.getHihokenshaShuryoYMD());
        一時Enttiy.setShinseiYMD(entity.getShinseiYMD());
        一時Enttiy.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        一時Enttiy.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        一時Enttiy.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        一時Enttiy.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        一時Enttiy.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        一時Enttiy.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        一時Enttiy.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        一時Enttiy.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        一時Enttiy.setAtesakiShimei(entity.getAtesakiShimei());
        一時Enttiy.setAtesakiYubinNo(entity.getAtesakiYubinNo());
        一時Enttiy.setAtesakiJusho(entity.getAtesakiJusho());
        一時Enttiy.setMadoguchi_TaishoshaHanteiCode(entity.getMadoguchi_TaishoshaHanteiCode());
        一時Enttiy.setShiharaiBasho(entity.getShiharaiBasho());
        一時Enttiy.setShikaraiKaishiYMD(entity.getShikaraiKaishiYMD());
        一時Enttiy.setShiharaiShuryoYMD(entity.getShiharaiShuryoYMD());
        一時Enttiy.setHeichoNaiyo(entity.getHeichoNaiyo());
        一時Enttiy.setShiharaiKaishiTime(entity.getShiharaiKaishiTime());
        一時Enttiy.setShiharaiShuryoTime(entity.getShiharaiShuryoTime());
        一時Enttiy.setBiko(entity.getBiko());
        一時Enttiy.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        一時Enttiy.setKakunin_UketoriYM(entity.getKakunin_UketoriYM());
        一時Enttiy.setHoseiZumi_SofuYM(entity.getHoseiZumi_SofuYM());
        一時Enttiy.setShomeisho_UketoriYM(entity.getShomeisho_UketoriYM());
        一時Enttiy.setSaisoFlag(entity.getSaisoFlag());
        一時Enttiy.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        一時Enttiy.setJikoFutanKeisanYMD(entity.getJikoFutanKeisanYMD());
        一時Enttiy.setShomeiShoSakuseiYMD(entity.getShomeiShoSakuseiYMD());
        一時Enttiy.setKoki_KokuhoShoriKubun(entity.getKoki_KokuhoShoriKubun());
        一時Enttiy.setJikoFutangakuShomeishoRealHakkoFlag(entity.getJikoFutangakuShomeishoRealHakkoFlag());
        一時Enttiy.setBatchHoseiJissiYMD(entity.getBatchHoseiJissiYMD());
        一時Enttiy.setRealHoseiJissiYMD(entity.getRealHoseiJissiYMD());
        一時Enttiy.setShoKisaiHokenshaNo(entity.getHokenshaNo());
        一時Enttiy.setSofuJogaiFlag(false);
        return 一時Enttiy;
    }

}
