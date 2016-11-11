/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.inskyufujissekichukankogakutmpprocess.InsKyufuJissekiChukanKogakuTmpProcess7Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41002_高額介護サービス費給付対象者登録Processのクラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsKyufuJissekiChukanKogakuTmpProcess7 extends BatchProcessBase<InsKyufuJissekiChukanKogakuTmpProcess7Entity> {

    private static final RString 定数_1 = new RString("1");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 給付実績中間高額一時7tableWriter;

    static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select給付実績中間高額一時の作成7");
    static final RString 給付実績中間高額一時7_TABLE_NAME = new RString("TempKyufujissekiTyukann7");

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        給付実績中間高額一時7tableWriter = new BatchEntityCreatedTempTableWriter(
                給付実績中間高額一時7_TABLE_NAME, TempKyufujissekiTyukannEntity.class);
    }

    @Override
    protected void process(InsKyufuJissekiChukanKogakuTmpProcess7Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity = set給付実績中間高額一時7Entity(entity);
        if (entity.get給付実績社会福祉法人軽減額一時Entity() != null) {
            給付実績中間高額一時7Entity.setKyufuJissekiShakaiFukushiHojinKeiUmu(定数_1);
            給付実績中間高額一時7Entity.setGoKeigengoRiyoshaFutangaku(entity.get給付実績社会福祉法人軽減額一時Entity().getAtoKeigengoRiyoshaFutangaku());
        }
        給付実績中間高額一時7tableWriter.insert(給付実績中間高額一時7Entity);
    }

    TempKyufujissekiTyukannEntity set給付実績中間高額一時7Entity(InsKyufuJissekiChukanKogakuTmpProcess7Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity = new TempKyufujissekiTyukannEntity();
        if (entity.get給付実績中間高額一時Entity() != null) {
            給付実績中間高額一時7Entity = set給付実績基本情報(給付実績中間高額一時7Entity, entity.get給付実績中間高額一時Entity());
            給付実績中間高額一時7Entity = set世帯員所得判定明細高額一時(給付実績中間高額一時7Entity, entity.get給付実績中間高額一時Entity());
        }
        if (entity.get給付実績集計一時Entity() != null) {
            給付実績中間高額一時7Entity = set世帯員所得判定明細高額一時(給付実績中間高額一時7Entity, entity.get給付実績集計一時Entity());
        }
        給付実績中間高額一時7Entity = set追加項目(給付実績中間高額一時7Entity);
        return 給付実績中間高額一時7Entity;
    }

    private TempKyufujissekiTyukannEntity set給付実績基本情報(TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity,
            TempKyufujissekiTyukannEntity entity) {
        給付実績中間高額一時7Entity.setKokanShikibetsuNo(entity.getKokanShikibetsuNo());
        給付実績中間高額一時7Entity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        給付実績中間高額一時7Entity.setRecodeShubetsuCode(entity.getRecodeShubetsuCode());
        給付実績中間高額一時7Entity.setShokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        給付実績中間高額一時7Entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        給付実績中間高額一時7Entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        給付実績中間高額一時7Entity.setJigyoshoNo(entity.getJigyoshoNo());
        給付実績中間高額一時7Entity.setKyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        給付実績中間高額一時7Entity.setKyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        給付実績中間高額一時7Entity.setToshiNo(entity.getToshiNo());
        給付実績中間高額一時7Entity.setKohi1FutanshaNo(entity.getKohi1FutanshaNo());
        給付実績中間高額一時7Entity.setKohi1JukyushaNo(entity.getKohi1JukyushaNo());
        給付実績中間高額一時7Entity.setKohi2FutanshaNo(entity.getKohi2FutanshaNo());
        給付実績中間高額一時7Entity.setKohi2JukyushaNo(entity.getKohi2JukyushaNo());
        給付実績中間高額一時7Entity.setKohi3FutanshaNo(entity.getKohi3FutanshaNo());
        給付実績中間高額一時7Entity.setKohi3JukyushaNo(entity.getKohi3JukyushaNo());
        給付実績中間高額一時7Entity.setUmareYMD(entity.getUmareYMD());
        給付実績中間高額一時7Entity.setSeibetsuCode(entity.getSeibetsuCode());
        給付実績中間高額一時7Entity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        給付実績中間高額一時7Entity.setKyuSochiNyushoshaTokureiCode(entity.getKyuSochiNyushoshaTokureiCode());
        給付実績中間高額一時7Entity.setNinteiYukoKaishiYMD(entity.getNinteiYukoKaishiYMD());
        給付実績中間高額一時7Entity.setNinteiYukoShuryoYMD(entity.getNinteiYukoShuryoYMD());
        給付実績中間高額一時7Entity.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        給付実績中間高額一時7Entity.setRojinhokenJukyushaNo(entity.getRojinhokenJukyushaNo());
        給付実績中間高額一時7Entity.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        給付実績中間高額一時7Entity.setKokiHiHokenshaNo(entity.getKokiHiHokenshaNo());
        給付実績中間高額一時7Entity.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        給付実績中間高額一時7Entity.setKokiHokenshaNo(entity.getKokiHokenshaNo());
        給付実績中間高額一時7Entity.setKokuhoHiHokenshashoNo(entity.getKokuhoHiHokenshashoNo());
        給付実績中間高額一時7Entity.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        給付実績中間高額一時7Entity.setKyotakuKaigoShienJigyoshoNo(entity.getKyotakuKaigoShienJigyoshoNo());
        給付実績中間高額一時7Entity.setKaishiYMD(entity.getKaishiYMD());
        給付実績中間高額一時7Entity.setChushiYMD(entity.getChushiYMD());
        給付実績中間高額一時7Entity.setChushiRiyuNyushomaeJyokyoCode(entity.getChushiRiyuNyushomaeJyokyoCode());
        給付実績中間高額一時7Entity.setNyushoYMD(entity.getNyushoYMD());
        給付実績中間高額一時7Entity.setTaishoYMD(entity.getTaishoYMD());
        給付実績中間高額一時7Entity.setNyushoJitsunissu(entity.getNyushoJitsunissu());
        給付実績中間高額一時7Entity.setGaihakuNissu(entity.getGaihakuNissu());
        給付実績中間高額一時7Entity.setTaishogoJotaiCode(entity.getTaishogoJotaiCode());
        給付実績中間高額一時7Entity.setHokenKyufuritsu(entity.getHokenKyufuritsu());
        給付実績中間高額一時7Entity.setKohi1Kyufuritsu(entity.getKohi1Kyufuritsu());
        給付実績中間高額一時7Entity.setKohi2Kyufuritsu(entity.getKohi2Kyufuritsu());
        給付実績中間高額一時7Entity.setKohi3Kyufuritsu(entity.getKohi3Kyufuritsu());
        給付実績中間高額一時7Entity.setMaeHokenServiceTanisu(entity.getMaeHokenServiceTanisu());
        給付実績中間高額一時7Entity.setMaeHokenSeikyugaku(entity.getMaeHokenSeikyugaku());
        給付実績中間高額一時7Entity.setMaeHokenRiyoshaFutangaku(entity.getMaeHokenRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setMaeHokenTokuteiShinryohiSeikyugaku(entity.getMaeHokenTokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi1ServiceTanisu(entity.getMaeKohi1ServiceTanisu());
        給付実績中間高額一時7Entity.setMaeKohi1Seikyugaku(entity.getMaeKohi1Seikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi1RiyoshaFutangaku(entity.getMaeKohi1RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi1TokuteiShinryohiSeikyugaku(entity.getMaeKohi1TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi2ServiceTanisu(entity.getMaeKohi2ServiceTanisu());
        給付実績中間高額一時7Entity.setMaeKohi2Seikyugaku(entity.getMaeKohi2Seikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi2RiyoshaFutangaku(entity.getMaeKohi2RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi2TokuteiShinryohiSeikyugaku(entity.getMaeKohi2TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi3ServiceTanisu(entity.getMaeKohi3ServiceTanisu());
        給付実績中間高額一時7Entity.setMaeKohi3Seikyugaku(entity.getMaeKohi3Seikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi3RiyoshaFutangaku(entity.getMaeKohi3RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi3TokuteiShinryohiSeikyugaku(entity.getMaeKohi3TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoHokenServiceTanisu(entity.getAtoHokenServiceTanisu());
        給付実績中間高額一時7Entity.setAtoHokenSeikyugaku(entity.getAtoHokenSeikyugaku());
        給付実績中間高額一時7Entity.setAtoHokenRiyoshaFutangaku(entity.getAtoHokenRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(entity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setAtoHokenTokuteiShinryohiSeikyugaku(entity.getAtoHokenTokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi1ServiceTanisu(entity.getAtoKohi1ServiceTanisu());
        給付実績中間高額一時7Entity.setAtoKohi1Seikyugaku(entity.getAtoKohi1Seikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi1RiyoshaFutangaku(entity.getAtoKohi1RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi1TokuteiShinryohiSeikyugaku(entity.getAtoKohi1TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi2ServiceTanisu(entity.getAtoKohi2ServiceTanisu());
        給付実績中間高額一時7Entity.setAtoKohi2Seikyugaku(entity.getAtoKohi2Seikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi2RiyoshaFutangaku(entity.getAtoKohi2RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi2TokuteiShinryohiSeikyugaku(entity.getAtoKohi2TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi3ServiceTanisu(entity.getAtoKohi3ServiceTanisu());
        給付実績中間高額一時7Entity.setAtoKohi3Seikyugaku(entity.getAtoKohi3Seikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi3RiyoshaFutangaku(entity.getAtoKohi3RiyoshaFutangaku());
        給付実績中間高額一時7Entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi3TokuteiShinryohiSeikyugaku(entity.getAtoKohi3TokuteiShinryohiSeikyugaku());
        給付実績中間高額一時7Entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(entity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        給付実績中間高額一時7Entity.setKeikaiKubunCode(entity.getKeikaiKubunCode());
        給付実績中間高額一時7Entity.setShinsaYM(entity.getShinsaYM());
        給付実績中間高額一時7Entity.setSeiriNo(entity.getSeiriNo());
        給付実績中間高額一時7Entity.setSofuYM(entity.getSofuYM());
        給付実績中間高額一時7Entity.setTorikomiYM(entity.getTorikomiYM());
        給付実績中間高額一時7Entity.setDokujiSakuseiKubun(entity.getDokujiSakuseiKubun());
        給付実績中間高額一時7Entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(entity.isHokenshaHoyuKyufujissekiJohoSakujoFlag());
        return 給付実績中間高額一時7Entity;
    }

    private TempKyufujissekiTyukannEntity set世帯員所得判定明細高額一時(TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity,
            TempKyufujissekiTyukannEntity entity) {
        給付実績中間高額一時7Entity.setShotokuHantei_hihokenshaNo(entity.getShotokuHantei_hihokenshaNo());
        給付実績中間高額一時7Entity.setShotokuHantei_shikibetsuCode(entity.getShotokuHantei_shikibetsuCode());
        給付実績中間高額一時7Entity.setShotokuHantei_kijunYMD(entity.getShotokuHantei_kijunYMD());
        給付実績中間高額一時7Entity.setShotokuHantei_shotokuNendo(entity.getShotokuHantei_shotokuNendo());
        給付実績中間高額一時7Entity.setShotokuHantei_jushochiTokureiFlag(entity.getShotokuHantei_jushochiTokureiFlag());
        給付実績中間高額一時7Entity.setShotokuHantei_setaiCode(entity.getShotokuHantei_setaiCode());
        給付実績中間高額一時7Entity.setShotokuHantei_honninKubun(entity.getShotokuHantei_honninKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_kazeiKubun(entity.getShotokuHantei_kazeiKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_kazeiKubunGemmenGo(entity.getShotokuHantei_kazeiKubunGemmenGo());
        給付実績中間高額一時7Entity.setShotokuHantei_gekihenKanwaKubun(entity.getShotokuHantei_gekihenKanwaKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_gokeiShotokuGaku(entity.getShotokuHantei_gokeiShotokuGaku());
        給付実績中間高額一時7Entity.setShotokuHantei_nenkiniShunyuGaku(entity.getShotokuHantei_nenkiniShunyuGaku());
        給付実績中間高額一時7Entity.setShotokuHantei_nenkiniShotokuGaku(entity.getShotokuHantei_nenkiniShotokuGaku());
        給付実績中間高額一時7Entity.setShotokuHantei_kazeiShotokuGaku(entity.getShotokuHantei_kazeiShotokuGaku());
        給付実績中間高額一時7Entity.setShotokuHantei_torokuGyomu(entity.getShotokuHantei_torokuGyomu());
        給付実績中間高額一時7Entity.setShotokuHantei_shichosonCode(entity.getShotokuHantei_shichosonCode());
        給付実績中間高額一時7Entity.setShotokuHantei_shoboKubun(entity.getShotokuHantei_shoboKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_roreiFukushi(entity.getShotokuHantei_roreiFukushi());
        給付実績中間高額一時7Entity.setShotokuHantei_setaiinHihokenshaNo(entity.getShotokuHantei_setaiinHihokenshaNo());
        給付実績中間高額一時7Entity.setShotokuHantei_honninKazeiKubun(entity.getShotokuHantei_honninKazeiKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_setaiKazeiKubun(entity.getShotokuHantei_setaiKazeiKubun());
        給付実績中間高額一時7Entity.setShotokuHantei_tsuzukigaraCodeNen(entity.getShotokuHantei_tsuzukigaraCodeNen());
        給付実績中間高額一時7Entity.setKogakuServicehiJogengakuGengakuGaitoFlag(entity.getKogakuServicehiJogengakuGengakuGaitoFlag());
        給付実績中間高額一時7Entity.setKogakuServicehiJogengakuGengakugoJogengaku(entity.getKogakuServicehiJogengakuGengakugoJogengaku());
        return 給付実績中間高額一時7Entity;
    }

    private TempKyufujissekiTyukannEntity set世帯員所得判定明細高額一時(TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity,
            DbT3033KyufujissekiShukeiEntity entity) {
        給付実績中間高額一時7Entity.setServiceSyuruiCode(entity.getServiceSyuruiCode());
        給付実績中間高額一時7Entity.setHokenSeikyugaku(entity.getAtoHokenSeikyugaku());
        給付実績中間高額一時7Entity.setHokenRiyoshaFutangaku(entity.getHokenRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setHokenDekidakaSeikyugaku(entity.getAtoHokenDekidakaSeikyugaku());
        給付実績中間高額一時7Entity.setHokenDekidakaIryohiRiyoshaFutangaku(entity.getHokenDekidakaIryohiRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setKohi1Seikyugaku(entity.getAtoKohi1Seikyugaku());
        給付実績中間高額一時7Entity.setKohi1HonninFutangaku(entity.getKohi1HonninFutangaku());
        給付実績中間高額一時7Entity.setKohi1DekidakaSeikyugaku(entity.getAtoKohi1DekidakaSeikyugaku());
        給付実績中間高額一時7Entity.setKohi1DekidakaIryohiRiyoshaFutangaku(entity.getKohi1DekidakaIryohiRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setKohi2Seikyugaku(entity.getAtoKohi2Seikyugaku());
        給付実績中間高額一時7Entity.setKohi2HonninFutangaku(entity.getKohi2HonninFutangaku());
        給付実績中間高額一時7Entity.setKohi2DekidakaSeikyugaku(entity.getAtoKohi2DekidakaSeikyugaku());
        給付実績中間高額一時7Entity.setKohi2DekidakaIryohiRiyoshaFutangaku(entity.getKohi2DekidakaIryohiRiyoshaFutangaku());
        給付実績中間高額一時7Entity.setKohi3Seikyugaku(entity.getAtoKohi3Seikyugaku());
        給付実績中間高額一時7Entity.setKohi3HonninFutangaku(entity.getKohi3HonninFutangaku());
        給付実績中間高額一時7Entity.setKohi3DekidakaSeikyugaku(entity.getAtoKohi3DekidakaSeikyugaku());
        給付実績中間高額一時7Entity.setKohi3DekidakaIryohiRiyoshaFutangaku(entity.getKohi3DekidakaIryohiRiyoshaFutangaku());
        return 給付実績中間高額一時7Entity;
    }

    private TempKyufujissekiTyukannEntity set追加項目(TempKyufujissekiTyukannEntity 給付実績中間高額一時7Entity) {
        給付実績中間高額一時7Entity.setDataKubun(RString.EMPTY);
        給付実績中間高額一時7Entity.setServiceHiyougakuGokei(null);
        給付実績中間高額一時7Entity.setSikyugaku(null);
        給付実績中間高額一時7Entity.setSanteiKijungaku(null);
        給付実績中間高額一時7Entity.setKogakuHanteiKekka(RString.EMPTY);
        給付実績中間高額一時7Entity.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時7Entity.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時7Entity.setBeikoSetaishotokuKubun(RString.EMPTY);
        給付実績中間高額一時7Entity.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間高額一時7Entity.setRiyoFitanDankai2(RString.EMPTY);
        return 給付実績中間高額一時7Entity;
    }
}
