/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.DbWT38Q1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.SofuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成の送付対象データ取得Process
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiGetSofuTaishoDataProcess extends BatchProcessBase<KogakuGassanKyufuJissekiDataEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout."
            + "IKogakugassanKyufujissekiOutMapper.get送付対象データ");
    private static final RString 高額合算給付実績一時_NAME = new RString("DbWT38Q1KogakuGassanKyufuJisseki");
    private static final RString 被保険者一時_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    private KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter parameter;
    private int 合計;
    private OutputParameter<SofuTaishoEntity> flowEntity;
    private SofuTaishoEntity returnEntity;
    /**
     * 送付対象データ取得後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 高額合算給付実績一時Writer;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 被保険者一時Writer;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 処理結果リスト一時Writer;

    @Override
    protected void initialize() {
        returnEntity = new SofuTaishoEntity();
        flowEntity = new OutputParameter<>();
        合計 = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        高額合算給付実績一時Writer = new BatchEntityCreatedTempTableWriter(高額合算給付実績一時_NAME,
                DbWT38Q1KogakuGassanKyufuJissekiTempEntity.class);
        被保険者一時Writer = new BatchEntityCreatedTempTableWriter(被保険者一時_NAME,
                DbWT1001HihokenshaTempEntity.class);
        処理結果リスト一時Writer = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanKyufuJissekiDataEntity entity) {
        合計 = 合計 + INT_1;
        高額合算給付実績一時Writer.insert(set高額合算給付実績(entity, 合計));
        被保険者一時Writer.insert(set被保険者一時(entity, 合計));
    }

    @Override
    protected void afterExecute() {

        if (合計 == INT_0) {
            処理結果リスト一時Writer.insert(set処理結果リスト());
        }
        returnEntity.set合計(合計);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private DbWT38Q1KogakuGassanKyufuJissekiTempEntity set高額合算給付実績(KogakuGassanKyufuJissekiDataEntity entity, int 連番) {

        DbWT38Q1KogakuGassanKyufuJissekiTempEntity dbwt38Q1Entity = new DbWT38Q1KogakuGassanKyufuJissekiTempEntity();
        dbwt38Q1Entity.setRenban(連番);
        dbwt38Q1Entity.setKokanJohoShikibetsuNo(entity.get交換情報識別番号());
        dbwt38Q1Entity.setHihokenshaNo(entity.get被保険者番号());
        dbwt38Q1Entity.setShikyuShinseiSeiriNo(entity.get支給申請書整理番号());
        dbwt38Q1Entity.setSeiriNo(entity.get整理番号());
        dbwt38Q1Entity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        dbwt38Q1Entity.setHokenSeidoCode(entity.get保険制度コード());
        dbwt38Q1Entity.setKyufuJissekiSakuseiKubunCode(entity.get給付実績作成区分コード());
        dbwt38Q1Entity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        dbwt38Q1Entity.setKokuho_HihokenshaShoKigo(entity.get国保_被保険者証記号());
        dbwt38Q1Entity.setShinseiYMD(entity.get申請年月日());
        dbwt38Q1Entity.setKetteiYMD(entity.get決定年月日());
        dbwt38Q1Entity.setJikoFutanSogaku(entity.get自己負担総額());
        dbwt38Q1Entity.setShikyuGaku(entity.get支給額());
        dbwt38Q1Entity.setShoriYM(entity.get処理年月());
        dbwt38Q1Entity.setUketoriYM(entity.get受取年月());
        dbwt38Q1Entity.setSofuYM(entity.get送付年月());
        dbwt38Q1Entity.setDataKubun(entity.getデータ区分());
        dbwt38Q1Entity.setSofuJogaiFlag(false);
        return dbwt38Q1Entity;
    }

    private DbWT1001HihokenshaTempEntity set被保険者一時(KogakuGassanKyufuJissekiDataEntity entity, int 連番) {

        DbWT1001HihokenshaTempEntity dbwt1001Entity = new DbWT1001HihokenshaTempEntity();
        dbwt1001Entity.setExRenban(連番);
        dbwt1001Entity.setExHokenshaNo(null);
        dbwt1001Entity.setExHokenshaName(RString.EMPTY);
        dbwt1001Entity.setExShoHokenshaNo(entity.get証記載保険者番号());
        dbwt1001Entity.setExHihokenshaNo(entity.get被保険者番号());
        RDate now = RDate.getNowDate();
        dbwt1001Entity.setExServiceTeikyoYm(new FlexibleYearMonth(now.getYearMonth().toDateString()));
        dbwt1001Entity.setHenkanFlag(false);
        dbwt1001Entity.setOldShichosonCode(null);
        dbwt1001Entity.setSofuHihokenshaNo(entity.get被保険者番号());
        dbwt1001Entity.setShichosonCode(null);
        dbwt1001Entity.setKannaiKangaiKubun(RString.EMPTY);
        dbwt1001Entity.setYubinNo(RString.EMPTY);
        dbwt1001Entity.setChoikiCode(RString.EMPTY);
        dbwt1001Entity.setGyoseikuCode(RString.EMPTY);
        dbwt1001Entity.setGyoseikuMei(RString.EMPTY);
        dbwt1001Entity.setJusho(RString.EMPTY);
        dbwt1001Entity.setBanchi(RString.EMPTY);
        dbwt1001Entity.setKatagaki(RString.EMPTY);
        dbwt1001Entity.setKanaMeisho(RString.EMPTY);
        dbwt1001Entity.setMeisho(RString.EMPTY);
        dbwt1001Entity.setShimei50onKana(RString.EMPTY);
        dbwt1001Entity.setShikibetsuCode(null);
        dbwt1001Entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        dbwt1001Entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        dbwt1001Entity.setSetaiShuyakuNo(RString.EMPTY);
        dbwt1001Entity.setSeinenYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setSeibetsuCode(RString.EMPTY);
        dbwt1001Entity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        return dbwt1001Entity;
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity set処理結果リスト() {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbwt1002Entity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        dbwt1002Entity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        dbwt1002Entity.setShoHokanehshaNo(null);
        dbwt1002Entity.setHihokenshaNo(null);
        dbwt1002Entity.setKey1(RString.EMPTY);
        dbwt1002Entity.setKey2(RString.EMPTY);
        dbwt1002Entity.setKey3(RString.EMPTY);
        dbwt1002Entity.setKey4(RString.EMPTY);
        dbwt1002Entity.setKey5(RString.EMPTY);
        dbwt1002Entity.setHihokenshaKanaShimei(RString.EMPTY);
        dbwt1002Entity.setHihokenshaShimei(RString.EMPTY);
        dbwt1002Entity.setBiko(RString.EMPTY);
        return dbwt1002Entity;
    }

}
