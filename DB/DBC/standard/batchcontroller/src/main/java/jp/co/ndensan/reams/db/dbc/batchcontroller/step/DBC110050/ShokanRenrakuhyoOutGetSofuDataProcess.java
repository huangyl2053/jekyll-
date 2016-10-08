/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還連絡票情報作成の送付対象データ取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutGetSofuDataProcess extends BatchProcessBase<DbT3034ShokanShinseiEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get送付対象取得のデータ");
    private static final RString 償還払支給申請一時TABLE_NAME = new RString("DbWT2111ShokanShinsei");
    private static final RString 被保険者一時TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    private ShokanRenrakuhyoOutProcessParameter parameter;
    private int 連番;
    private OutputParameter<Integer> outCount;

    /**
     * 送付対象データ取得合計です。
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outCount");
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払支給申請一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時Writer;

    @Override
    protected void initialize() {
        連番 = INDEX_0;
        outCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toSofuDataMybatisParameter());
    }

    @Override
    protected void createWriter() {
        償還払支給申請一時Writer = new BatchEntityCreatedTempTableWriter(償還払支給申請一時TABLE_NAME,
                DbWT2111ShokanShinseiTempEntity.class);
        被保険者一時Writer = new BatchEntityCreatedTempTableWriter(被保険者一時TABLE_NAME,
                DbWT1001HihokenshaTempEntity.class);
        処理結果リスト一時Writer = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TABLE_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbT3034ShokanShinseiEntity entity) {
        連番 = 連番 + INDEX_1;
        償還払支給申請一時Writer.insert(get償還払支給申請一時(entity));
        被保険者一時Writer.insert(get被保険者一時(entity));
    }

    @Override
    protected void afterExecute() {
        if (連番 == INDEX_0) {
            処理結果リスト一時Writer.insert(get処理結果リスト一時());
        }
        outCount.setValue(連番);
    }

    private DbWT2111ShokanShinseiTempEntity get償還払支給申請一時(DbT3034ShokanShinseiEntity entity) {
        DbWT2111ShokanShinseiTempEntity tempEntity = new DbWT2111ShokanShinseiTempEntity();
        tempEntity.setRenban(連番);
        tempEntity.setHiHokenshaNo(entity.getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.getSeiriNo());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setUketsukeYMD(entity.getUketsukeYMD());
        tempEntity.setShinseiYMD(entity.getShinseiYMD());
        tempEntity.setShinseiRiyu(entity.getShinseiRiyu());
        tempEntity.setShinseishaKubun(entity.getShinseishaKubun());
        tempEntity.setShinseishaNameKanji(entity.getShinseishaNameKanji());
        tempEntity.setShinseishaNameKana(entity.getShinseishaNameKana());
        tempEntity.setShinseishaYubinNo(entity.getShinseishaYubinNo());
        tempEntity.setShinseishaAddress(entity.getShinseishaAddress());
        tempEntity.setShinseishaTelNo(entity.getShinseishaTelNo());
        tempEntity.setShinseiJigyoshaNo(entity.getShinseiJigyoshaNo());
        tempEntity.setRiyushoSakuseiYMD(entity.getRiyushoSakuseiYMD());
        tempEntity.setRiyushoSakuseishaName(entity.getRiyushoSakuseishaName());
        tempEntity.setRiyushoSakuseishaKanaName(entity.getRiyushoSakuseishaKanaName());
        tempEntity.setRiyushoSakuseiJigyoshaNo(entity.getRiyushoSakuseiJigyoshaNo());
        tempEntity.setRiyoshaFutangaku(new Decimal(entity.getRiyoshaFutangaku()));
        tempEntity.setShiharaiKingakuTotal(entity.getShiharaiKingakuTotal());
        tempEntity.setHokenTaishoHiyogaku(entity.getHokenTaishoHiyogaku());
        tempEntity.setHokenKyufugaku(new Decimal(entity.getHokenKyufugaku()));
        tempEntity.setShikyuShinseiShinsaKubun(entity.getShikyuShinseiShinsaKubun());
        tempEntity.setShinsaHohoKubun(entity.getShinsaHohoKubun());
        tempEntity.setSofuKubun(entity.getSofuKubun());
        tempEntity.setSofuYM(entity.getSofuYM());
        tempEntity.setKokuhorenSaisofuFlag(entity.getKokuhorenSaisofuFlag());
        tempEntity.setShiharaiHohoKubunCode(entity.getShiharaiHohoKubunCode());
        tempEntity.setShiharaiBasho(entity.getShiharaiBasho());
        tempEntity.setShiharaiKaishiYMD(entity.getShiharaiKaishiYMD());
        tempEntity.setShiharaiShuryoYMD(entity.getShiharaiShuryoYMD());
        tempEntity.setShiharaiKaishiTime(entity.getShiharaiKaishiTime());
        tempEntity.setShiharaiShuryoTime(entity.getShiharaiShuryoTime());
        tempEntity.setKozaID(entity.getKozaID());
        tempEntity.setJuryoininKeiyakuNo(entity.getJuryoininKeiyakuNo());
        tempEntity.setJutakuShoyusha(entity.getJutakuShoyusha());
        tempEntity.setHihokenshaKankei(entity.getHihokenshaKankei());
        tempEntity.setYokaigo3DankaiHenko(entity.getYokaigo3DankaiHenko());
        tempEntity.setJutakuJushoHenko(entity.getJutakuJushoHenko());
        tempEntity.setShinsaYMD(entity.getShinsaYMD());
        tempEntity.setShinsaKekka(entity.getShinsaKekka());
        tempEntity.setJizenServiceTeikyoYM(entity.getJizenServiceTeikyoYM());
        tempEntity.setJizenSeiriNo(entity.getJizenSeiriNo());
        tempEntity.setKaishuShinseiKubun(entity.getKaishuShinseiKubun());
        tempEntity.setKaishuShinseiTorikeshijiyuCode(entity.getKaishuShinseiTorikeshijiyuCode());
        tempEntity.setRyoshuYMD(entity.getRyoshuYMD());
        tempEntity.setSofuJogaiFlag(false);
        tempEntity.setHokenshaNo(null);
        tempEntity.setHokenshaName(RString.EMPTY);
        tempEntity.setJukyushaDaichoFlag(false);
        tempEntity.setKyuSochishaFlag(false);
        tempEntity.setYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setNinteiYukoKikanKaishiYMD(FlexibleDate.EMPTY);
        tempEntity.setNinteiYukoKikanShuryoYMD(FlexibleDate.EMPTY);
        return tempEntity;
    }

    private DbWT1001HihokenshaTempEntity get被保険者一時(DbT3034ShokanShinseiEntity entity) {
        DbWT1001HihokenshaTempEntity dbwt1001Entity = new DbWT1001HihokenshaTempEntity();
        dbwt1001Entity.setExRenban(連番);
        dbwt1001Entity.setExHokenshaNo(null);
        dbwt1001Entity.setExHokenshaName(RString.EMPTY);
        dbwt1001Entity.setExShoHokenshaNo(entity.getShoKisaiHokenshaNo());
        dbwt1001Entity.setExHihokenshaNo(entity.getHiHokenshaNo());
        dbwt1001Entity.setExServiceTeikyoYm(entity.getServiceTeikyoYM());
        dbwt1001Entity.setHenkanFlag(false);
        dbwt1001Entity.setOldShichosonCode(null);
        dbwt1001Entity.setSofuHihokenshaNo(entity.getHiHokenshaNo());
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

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時() {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbwt1002Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        dbwt1002Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        dbwt1002Enttiy.setShoHokanehshaNo(null);
        dbwt1002Enttiy.setHihokenshaNo(null);
        dbwt1002Enttiy.setKey1(RString.EMPTY);
        dbwt1002Enttiy.setKey2(RString.EMPTY);
        dbwt1002Enttiy.setKey3(RString.EMPTY);
        dbwt1002Enttiy.setKey4(RString.EMPTY);
        dbwt1002Enttiy.setKey5(RString.EMPTY);
        dbwt1002Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        dbwt1002Enttiy.setHihokenshaShimei(RString.EMPTY);
        dbwt1002Enttiy.setBiko(RString.EMPTY);
        return dbwt1002Enttiy;
    }

}
