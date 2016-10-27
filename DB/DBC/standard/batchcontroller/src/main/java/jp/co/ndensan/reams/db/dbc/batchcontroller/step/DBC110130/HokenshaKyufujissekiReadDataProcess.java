/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
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
 * 保険者保有給付実績情報作成のバッチ送付対象データ_基本取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiReadDataProcess extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get給付実績基本データ");

    private static final RString 給付実績基本一時NAME = new RString("DbWT1131KyufujissekiKihon");
    private static final RString 被保険者一時NAME = new RString("DbWT1001Hihokensha");
    /**
     * 送付対象データ取得です。
     */
    public static final RString PARAMETER_OUT_件数;

    static {
        PARAMETER_OUT_件数 = new RString("件数");
    }
    private int renban;
    private HokenshaKyufujissekiProcessParameter processParameter;
    private OutputParameter<Integer> 件数;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;

    @Override
    protected void initialize() {
        件数 = new OutputParameter<>();
        renban = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toHokenshaKyufujissekiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績基本一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績基本一時NAME, DbWT1131KyufujissekiKihonTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時NAME, DbWT1001HihokenshaTempEntity.class);
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        renban = renban + 1;
        DbWT1001HihokenshaTempEntity dbWT1001Entity = get被保険者一時Entity(entity);
        DbWT1131KyufujissekiKihonTempEntity dbWT1131Entity = get給付実績基本一時Enttiy(entity);
        被保険者一時tableWriter.insert(dbWT1001Entity);
        給付実績基本一時tableWriter.insert(dbWT1131Entity);
    }

    @Override
    protected void afterExecute() {
        件数.setValue(renban);
    }

    private DbWT1001HihokenshaTempEntity get被保険者一時Entity(DbT3017KyufujissekiKihonEntity entity) {
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

    private DbWT1131KyufujissekiKihonTempEntity get給付実績基本一時Enttiy(DbT3017KyufujissekiKihonEntity entity) {
        DbWT1131KyufujissekiKihonTempEntity 一時entity = new DbWT1131KyufujissekiKihonTempEntity();
        一時entity.setKokanShikibetsuNo(entity.getKokanShikibetsuNo());
        一時entity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        一時entity.setRecodeShubetsuCode(entity.getRecodeShubetsuCode());
        一時entity.setShokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        一時entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        一時entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        一時entity.setJigyoshoNo(entity.getJigyoshoNo());
        一時entity.setKyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        一時entity.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        一時entity.setToshiNo(entity.getToshiNo());
        一時entity.setKohi1FutanshaNo(entity.getKohi1FutanshaNo());
        一時entity.setKohi1JukyushaNo(entity.getKohi1JukyushaNo());
        一時entity.setKohi2FutanshaNo(entity.getKohi2FutanshaNo());
        一時entity.setKohi2JukyushaNo(entity.getKohi2JukyushaNo());
        一時entity.setKohi3FutanshaNo(entity.getKohi3FutanshaNo());
        一時entity.setKohi3JukyushaNo(entity.getKohi3JukyushaNo());
        一時entity.setUmareYMD(entity.getUmareYMD());
        一時entity.setSeibetsuCode(entity.getSeibetsuCode());
        一時entity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        一時entity.setKyuSochiNyushoshaTokureiCode(entity.getKyuSochiNyushoshaTokureiCode());
        一時entity.setNinteiYukoKaishiYMD(entity.getNinteiYukoKaishiYMD());
        一時entity.setNinteiYukoShuryoYMD(entity.getNinteiYukoShuryoYMD());
        一時entity.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        一時entity.setRojinhokenJukyushaNo(entity.getRojinhokenJukyushaNo());
        一時entity.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        一時entity.setKokiHiHokenshaNo(entity.getKokiHiHokenshaNo());
        一時entity.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        一時entity.setKokuhoHiHokenshashoNo(entity.getKokuhoHiHokenshashoNo());
        一時entity.setKokuhoKojinNo(entity.getKokuhoKojinNo());
        一時entity.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        一時entity.setKyotakuKaigoShienJigyoshoNo(entity.getKyotakuKaigoShienJigyoshoNo());
        一時entity.setKaishiYMD(entity.getKaishiYMD());
        一時entity.setChushiYMD(entity.getChushiYMD());
        一時entity.setChushiRiyuNyushomaeJyokyoCode(entity.getChushiRiyuNyushomaeJyokyoCode());
        一時entity.setNyushoYMD(entity.getNyushoYMD());
        一時entity.setTaishoYMD(entity.getTaishoYMD());
        一時entity.setNyushoJitsunissu(entity.getNyushoJitsunissu());
        一時entity.setGaihakuNissu(entity.getGaihakuNissu());
        一時entity.setTaishogoJotaiCode(entity.getTaishogoJotaiCode());
        一時entity.setHokenKyufuritsu(entity.getHokenKyufuritsu());
        一時entity.setKohi1Kyufuritsu(entity.getKohi1Kyufuritsu());
        一時entity.setKohi2Kyufuritsu(entity.getKohi2Kyufuritsu());
        一時entity.setKohi3Kyufuritsu(entity.getKohi3Kyufuritsu());
        一時entity.setMaeHokenServiceTanisu(entity.getMaeHokenServiceTanisu());
        一時entity.setMaeHokenSeikyugaku(entity.getMaeHokenSeikyugaku());
        一時entity.setMaeHokenRiyoshaFutangaku(entity.getMaeHokenRiyoshaFutangaku());
        一時entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setMaeHokenTokuteiShinryohiSeikyugaku(entity.getMaeHokenTokuteiShinryohiSeikyugaku());
        一時entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setMaeKohi1ServiceTanisu(entity.getMaeKohi1ServiceTanisu());
        一時entity.setMaeKohi1Seikyugaku(entity.getMaeKohi1Seikyugaku());
        一時entity.setMaeKohi1RiyoshaFutangaku(entity.getMaeKohi1RiyoshaFutangaku());
        一時entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setMaeKohi1TokuteiShinryohiSeikyugaku(entity.getMaeKohi1TokuteiShinryohiSeikyugaku());
        一時entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setMaeKohi2ServiceTanisu(entity.getMaeKohi2ServiceTanisu());
        一時entity.setMaeKohi2Seikyugaku(entity.getMaeKohi2Seikyugaku());
        一時entity.setMaeKohi2RiyoshaFutangaku(entity.getMaeKohi2RiyoshaFutangaku());
        一時entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setMaeKohi2TokuteiShinryohiSeikyugaku(entity.getMaeKohi2TokuteiShinryohiSeikyugaku());
        一時entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setMaeKohi3ServiceTanisu(entity.getMaeKohi3ServiceTanisu());
        一時entity.setMaeKohi3Seikyugaku(entity.getMaeKohi3Seikyugaku());
        一時entity.setMaeKohi3RiyoshaFutangaku(entity.getMaeKohi3RiyoshaFutangaku());
        一時entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setMaeKohi3TokuteiShinryohiSeikyugaku(entity.getMaeKohi3TokuteiShinryohiSeikyugaku());
        一時entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setAtoHokenServiceTanisu(entity.getAtoHokenServiceTanisu());
        一時entity.setAtoHokenSeikyugaku(entity.getAtoHokenSeikyugaku());
        一時entity.setAtoHokenRiyoshaFutangaku(entity.getAtoHokenRiyoshaFutangaku());
        一時entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setAtoHokenTokuteiShinryohiSeikyugaku(entity.getAtoHokenTokuteiShinryohiSeikyugaku());
        一時entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setAtoKohi1ServiceTanisu(entity.getAtoKohi1ServiceTanisu());
        一時entity.setAtoKohi1Seikyugaku(entity.getAtoKohi1Seikyugaku());
        一時entity.setAtoKohi1RiyoshaFutangaku(entity.getAtoKohi1RiyoshaFutangaku());
        一時entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setAtoKohi1TokuteiShinryohiSeikyugaku(entity.getAtoKohi1TokuteiShinryohiSeikyugaku());
        一時entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setAtoKohi2ServiceTanisu(entity.getAtoKohi2ServiceTanisu());
        一時entity.setAtoKohi2Seikyugaku(entity.getAtoKohi2Seikyugaku());
        一時entity.setAtoKohi2RiyoshaFutangaku(entity.getAtoKohi2RiyoshaFutangaku());
        一時entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setAtoKohi2TokuteiShinryohiSeikyugaku(entity.getAtoKohi2TokuteiShinryohiSeikyugaku());
        一時entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setAtoKohi3ServiceTanisu(entity.getAtoKohi3ServiceTanisu());
        一時entity.setAtoKohi3Seikyugaku(entity.getAtoKohi3Seikyugaku());
        一時entity.setAtoKohi3RiyoshaFutangaku(entity.getAtoKohi3RiyoshaFutangaku());
        一時entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku());
        一時entity.setAtoKohi3TokuteiShinryohiSeikyugaku(entity.getAtoKohi3TokuteiShinryohiSeikyugaku());
        一時entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        一時entity.setKeikaiKubunCode(entity.getKeikaiKubunCode());
        一時entity.setShinsaYM(entity.getShinsaYM());
        一時entity.setSeiriNo(entity.getSeiriNo());
        一時entity.setSofuYM(entity.getSofuYM());
        一時entity.setTorikomiYM(entity.getTorikomiYM());
        一時entity.setDokujiSakuseiKubun(entity.getDokujiSakuseiKubun());
        一時entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(entity.getHokenshaHoyuKyufujissekiJohoSakujoFlag());
        一時entity.setRenban(renban);
        一時entity.setSofuJogaiFlag(false);
        一時entity.setHokenshaNo(HokenshaNo.EMPTY);
        一時entity.setHokenshaName(RString.EMPTY);
        一時entity.setSofuHihokenshaNo(HihokenshaNo.EMPTY);
        一時entity.setMeisaiSetteiKubun(RString.EMPTY);
        一時entity.setKinkyuShisetsuRyoyoSetteiKubun(RString.EMPTY);
        一時entity.setTokuteiShinryoSetteiKubun(RString.EMPTY);
        一時entity.setShokujiHiyosetteiKubun(RString.EMPTY);
        一時entity.setKyotakuKeikakuSetteiKubun(RString.EMPTY);
        一時entity.setFukushoyouguKonyuSetteiKubun(RString.EMPTY);
        一時entity.setJutakukaishuSetteiKubun(RString.EMPTY);
        一時entity.setTokuteishinryoTokubetsuryoyoSetteiKubun(RString.EMPTY);
        一時entity.setTokuteinyushoshaSetteiKubun(RString.EMPTY);
        一時entity.setShakaifukushiKeigenSetteiKubun(RString.EMPTY);
        一時entity.setShoteiShikkanSetteiKubun(RString.EMPTY);
        一時entity.setMeisaiJushochitokureiSetteiKubun(RString.EMPTY);
        一時entity.setShukeiSetteiKubun(RString.EMPTY);
        return 一時entity;
    }
}
