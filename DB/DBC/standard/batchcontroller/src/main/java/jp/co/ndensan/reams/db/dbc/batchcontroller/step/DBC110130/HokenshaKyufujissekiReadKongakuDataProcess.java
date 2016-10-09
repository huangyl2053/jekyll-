/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi.DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity;
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
 * 保険者保有給付実績情報作成のバッチ送付対象データ_高額取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiReadKongakuDataProcess extends BatchProcessBase<DbT3028KyufujissekiKogakuKaigoServicehiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get給付実績高額介護サービス費データ");

    private static final RString 給付実績高額一時NAME = new RString("DbWT1132KyufujissekiKogakuKaigoServicehi");
    private static final RString 被保険者一時NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString データがある = new RString("1");
    private static final RString データがない = new RString("0");
    private static final int INT_0 = 0;
    /**
     * 送付対象データ取得です。
     */
    public static final RString PARAMETER_OUT_FLOWFLAG;

    static {
        PARAMETER_OUT_FLOWFLAG = new RString("dataFlag");
    }

    private int renban;
    private HokenshaKyufujissekiProcessParameter processParameter;

    private OutputParameter<RString> dataFlag;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績高額一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected void initialize() {
        dataFlag = new OutputParameter<>();
        renban = processParameter.get基本件数();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toHokenshaKyufujissekiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績高額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績高額一時NAME, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時NAME, DbWT1001HihokenshaTempEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        renban = renban + 1;
        DbWT1001HihokenshaTempEntity dbWT1001Entity = get被保険者一時Entity(entity);
        DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity dbWT1132Entity = get給付実績高額一時Enttiy(entity);
        被保険者一時tableWriter.insert(dbWT1001Entity);
        給付実績高額一時tableWriter.insert(dbWT1132Entity);
    }

    @Override
    protected void afterExecute() {
        if (INT_0 == renban) {
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

    private DbWT1001HihokenshaTempEntity get被保険者一時Entity(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        DbWT1001HihokenshaTempEntity 一時entity = new DbWT1001HihokenshaTempEntity();
        一時entity.setExRenban(renban);
        一時entity.setExHokenshaNo(HokenshaNo.EMPTY);
        一時entity.setExHokenshaName(RString.EMPTY);
        一時entity.setExShoHokenshaNo(new ShoKisaiHokenshaNo(entity.getShokisaiHokenshaNo().getColumnValue()));
        一時entity.setExHihokenshaNo(entity.getHiHokenshaNo());
        一時entity.setExServiceTeikyoYm(entity.getServiceTeikyoYM());
        一時entity.setHenkanFlag(false);
        一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        一時entity.setSofuHihokenshaNo(entity.getHiHokenshaNo());
        一時entity.setShichosonCode(LasdecCode.EMPTY);
        一時entity.setKannaiKangaiKubun(RString.EMPTY);
        一時entity.setYubinNo(RString.EMPTY);
        一時entity.setChoikiCode(RString.EMPTY);
        一時entity.setGyoseikuCode(RString.EMPTY);
        一時entity.setGyoseikuMei(RString.EMPTY);
        一時entity.setJusho(RString.EMPTY);
        一時entity.setBanchi(RString.EMPTY);
        一時entity.setKatagaki(RString.EMPTY);
        一時entity.setKanaMeisho(RString.EMPTY);
        一時entity.setMeisho(RString.EMPTY);
        一時entity.setShimei50onKana(RString.EMPTY);
        一時entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        一時entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        一時entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        一時entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        一時entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        一時entity.setSetaiShuyakuNo(RString.EMPTY);
        一時entity.setSeinenYmd(FlexibleDate.EMPTY);
        一時entity.setSeibetsuCode(RString.EMPTY);
        一時entity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        一時entity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        return 一時entity;
    }

    private DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity get給付実績高額一時Enttiy(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity 一時entity = new DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity();
        一時entity.setKokanJohoShikibetsuNo(entity.getKokanJohoShikibetsuNo());
        一時entity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        一時entity.setRecodeShubetsuCode(entity.getRecodeShubetsuCode());
        一時entity.setShokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        一時entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        一時entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        一時entity.setKyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        一時entity.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        一時entity.setToshiNo(entity.getToshiNo());
        一時entity.setUketsukeYMD(entity.getUketsukeYMD());
        一時entity.setKetteiYMD(entity.getKetteiYMD());
        一時entity.setKohi1FutanNo(entity.getKohi1FutanNo());
        一時entity.setKohi2FutanNo(entity.getKohi2FutanNo());
        一時entity.setKohi3FutanNo(entity.getKohi3FutanNo());
        一時entity.setRiyoshaFutangaku(entity.getRiyoshaFutangaku());
        一時entity.setKohi1Futangaku(entity.getKohi1Futangaku());
        一時entity.setKohi2Futangaku(entity.getKohi2Futangaku());
        一時entity.setKohi3Futangaku(entity.getKohi3Futangaku());
        一時entity.setShikyugaku(entity.getShikyugaku());
        一時entity.setKohi1Shikyugaku(entity.getKohi1Shikyugaku());
        一時entity.setKohi2Shikyugaku(entity.getKohi2Shikyugaku());
        一時entity.setKohi3Shikyugaku(entity.getKohi3Shikyugaku());
        一時entity.setShinsaYM(entity.getShinsaYM());
        一時entity.setSeiriNo(entity.getSeiriNo());
        一時entity.setSofuYM(entity.getSofuYM());
        一時entity.setTorikomiYM(entity.getTorikomiYM());
        一時entity.setSakuseiKubun(entity.getSakuseiKubun());
        一時entity.setKanriNo(entity.getKanriNo());
        一時entity.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(entity.getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag());
        一時entity.setRenban(renban);
        一時entity.setSofuJogaiFlag(false);
        一時entity.setHokenshaNo(HokenshaNo.EMPTY);
        一時entity.setHokenshaName(RString.EMPTY);
        一時entity.setSofuHihokenshaNo(HihokenshaNo.EMPTY);
        return 一時entity;
    }

}
