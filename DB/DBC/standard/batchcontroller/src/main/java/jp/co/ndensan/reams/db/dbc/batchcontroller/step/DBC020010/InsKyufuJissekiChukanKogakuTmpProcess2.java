/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufujissekiTyukannInsertEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績中間高額一時の作成2のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyufuJissekiChukanKogakuTmpProcess2 extends BatchProcessBase<KyufujissekiTyukannInsertEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select給付実績中間高額一時の作成2");
    private static final RString TABLE_給付実績中間高額一時2 = new RString("TempKyufujissekiTyukann2");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukannWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        kyufujissekiTyukannWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時2, TempKyufujissekiTyukannEntity.class);
    }

    @Override
    protected void process(KyufujissekiTyukannInsertEntity entity) {
        TempKyufujissekiTyukannEntity data = new TempKyufujissekiTyukannEntity();
        set給付実績基本情報(data, entity.get給付実績基本情報高額一時());
        set世帯員所得判定明細高額一時(data, entity.get世帯員所得判定明細高額一時());
        kyufujissekiTyukannWriter.insert(data);
    }

    @Override
    protected void afterExecute() {
    }

    private void set給付実績基本情報(TempKyufujissekiTyukannEntity entity, DbT3017KyufujissekiKihonEntity 実績基本) {
        entity.setInputShikibetsuNo(実績基本.getInputShikibetsuNo());
        entity.setRecodeShubetsuCode(実績基本.getRecodeShubetsuCode());
        entity.setShokisaiHokenshaNo(実績基本.getShokisaiHokenshaNo());
        entity.setHiHokenshaNo(実績基本.getHiHokenshaNo());
        entity.setServiceTeikyoYM(実績基本.getServiceTeikyoYM());
        entity.setJigyoshoNo(実績基本.getJigyoshoNo());
        entity.setKyufuSakuseiKubunCode(実績基本.getKyufuSakuseiKubunCode());
        entity.setKyufuJissekiKubunCode(実績基本.getKyufuJissekiKubunCode());
        entity.setToshiNo(実績基本.getToshiNo());
        entity.setKohi1FutanshaNo(実績基本.getKohi1FutanshaNo());
        entity.setKohi1JukyushaNo(実績基本.getKohi1JukyushaNo());
        entity.setKokanShikibetsuNo(実績基本.getKokanShikibetsuNo());
        entity.setKohi2FutanshaNo(実績基本.getKohi2FutanshaNo());
        entity.setKohi2JukyushaNo(実績基本.getKohi2JukyushaNo());
        entity.setKohi3FutanshaNo(実績基本.getKohi3FutanshaNo());
        entity.setKohi3JukyushaNo(実績基本.getKohi3JukyushaNo());
        entity.setUmareYMD(実績基本.getUmareYMD());
        entity.setSeibetsuCode(実績基本.getSeibetsuCode());
        entity.setYoKaigoJotaiKubunCode(実績基本.getYoKaigoJotaiKubunCode());
        entity.setKyuSochiNyushoshaTokureiCode(実績基本.getKyuSochiNyushoshaTokureiCode());
        entity.setNinteiYukoKaishiYMD(実績基本.getNinteiYukoKaishiYMD());
        entity.setNinteiYukoShuryoYMD(実績基本.getNinteiYukoShuryoYMD());
        entity.setRojinHokenShichosonNo(実績基本.getRojinHokenShichosonNo());
        entity.setRojinhokenJukyushaNo(実績基本.getRojinhokenJukyushaNo());
        entity.setKokiHokenshaNo(実績基本.getKokiHokenshaNo());
        entity.setKokiHiHokenshaNo(実績基本.getKokiHiHokenshaNo());
        entity.setKokuhoHokenshaNo(実績基本.getKokuhoHokenshaNo());
        entity.setKokuhoHiHokenshashoNo(実績基本.getKokuhoHiHokenshashoNo());
        entity.setKokuhoKojinNo(実績基本.getKokuhoKojinNo());
        entity.setKyotakuServiceSakuseiKubunCode(実績基本.getKokuhoKojinNo());
        entity.setKyotakuKaigoShienJigyoshoNo(実績基本.getKyotakuKaigoShienJigyoshoNo());
        entity.setKaishiYMD(実績基本.getKaishiYMD());
        entity.setChushiYMD(実績基本.getChushiYMD());
        entity.setChushiRiyuNyushomaeJyokyoCode(実績基本.getChushiRiyuNyushomaeJyokyoCode());
        entity.setNyushoYMD(実績基本.getNyushoYMD());
        entity.setTaishoYMD(実績基本.getTaishoYMD());
        entity.setNyushoJitsunissu(実績基本.getNyushoJitsunissu());
        entity.setGaihakuNissu(実績基本.getGaihakuNissu());
        entity.setTaishogoJotaiCode(実績基本.getTaishogoJotaiCode());
        entity.setHokenKyufuritsu(実績基本.getHokenKyufuritsu());
        entity.setKohi1Kyufuritsu(実績基本.getKohi1Kyufuritsu());
        entity.setKohi2Kyufuritsu(実績基本.getKohi2Kyufuritsu());
        entity.setKohi3Kyufuritsu(実績基本.getKohi3Kyufuritsu());
        entity.setMaeHokenServiceTanisu(実績基本.getMaeHokenServiceTanisu());
        entity.setMaeHokenSeikyugaku(実績基本.getMaeHokenSeikyugaku());
        entity.setMaeHokenRiyoshaFutangaku(実績基本.getMaeHokenRiyoshaFutangaku());
        entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(実績基本.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku());
        entity.setMaeHokenTokuteiShinryohiSeikyugaku(実績基本.getMaeHokenTokuteiShinryohiSeikyugaku());
        entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setMaeKohi1ServiceTanisu(実績基本.getMaeKohi1ServiceTanisu());
        entity.setMaeKohi1Seikyugaku(実績基本.getMaeKohi1Seikyugaku());
        entity.setMaeKohi1RiyoshaFutangaku(実績基本.getMaeKohi1RiyoshaFutangaku());
        entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(実績基本.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku());
        entity.setMaeKohi1TokuteiShinryohiSeikyugaku(実績基本.getMaeKohi1TokuteiShinryohiSeikyugaku());
        entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setMaeKohi2ServiceTanisu(実績基本.getMaeKohi2ServiceTanisu());
        entity.setMaeKohi2Seikyugaku(実績基本.getMaeKohi2Seikyugaku());
        entity.setMaeKohi2RiyoshaFutangaku(実績基本.getMaeKohi2RiyoshaFutangaku());
        entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(実績基本.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku());
        entity.setMaeKohi2TokuteiShinryohiSeikyugaku(実績基本.getMaeKohi2TokuteiShinryohiSeikyugaku());
        entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setMaeKohi3ServiceTanisu(実績基本.getMaeKohi3ServiceTanisu());
        entity.setMaeKohi3Seikyugaku(実績基本.getMaeKohi3Seikyugaku());
        entity.setMaeKohi3RiyoshaFutangaku(実績基本.getMaeKohi3RiyoshaFutangaku());
        entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(実績基本.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku());
        entity.setMaeKohi3TokuteiShinryohiSeikyugaku(実績基本.getMaeKohi3TokuteiShinryohiSeikyugaku());
        entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setAtoHokenServiceTanisu(実績基本.getAtoHokenServiceTanisu());
        entity.setAtoHokenSeikyugaku(実績基本.getAtoHokenSeikyugaku());
        entity.setAtoHokenRiyoshaFutangaku(実績基本.getAtoHokenRiyoshaFutangaku());
        entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(実績基本.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku());
        entity.setAtoHokenTokuteiShinryohiSeikyugaku(実績基本.getAtoHokenTokuteiShinryohiSeikyugaku());
        entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setAtoKohi1ServiceTanisu(実績基本.getAtoKohi1ServiceTanisu());
        entity.setAtoKohi1Seikyugaku(実績基本.getAtoKohi1Seikyugaku());
        entity.setAtoKohi1RiyoshaFutangaku(実績基本.getAtoKohi1RiyoshaFutangaku());
        entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(実績基本.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku());
        entity.setAtoKohi1TokuteiShinryohiSeikyugaku(実績基本.getAtoKohi1TokuteiShinryohiSeikyugaku());
        entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setAtoKohi2ServiceTanisu(実績基本.getAtoKohi2ServiceTanisu());
        entity.setAtoKohi2Seikyugaku(実績基本.getAtoKohi2Seikyugaku());
        entity.setAtoKohi2RiyoshaFutangaku(実績基本.getAtoKohi2RiyoshaFutangaku());
        entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(実績基本.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku());
        entity.setAtoKohi2TokuteiShinryohiSeikyugaku(実績基本.getAtoKohi2TokuteiShinryohiSeikyugaku());
        entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setAtoKohi3ServiceTanisu(実績基本.getAtoKohi3ServiceTanisu());
        entity.setAtoKohi3Seikyugaku(実績基本.getAtoKohi3Seikyugaku());
        entity.setAtoKohi3RiyoshaFutangaku(実績基本.getAtoKohi3RiyoshaFutangaku());
        entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(実績基本.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku());
        entity.setAtoKohi3TokuteiShinryohiSeikyugaku(実績基本.getAtoKohi3TokuteiShinryohiSeikyugaku());
        entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(実績基本.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku());
        entity.setKeikaiKubunCode(実績基本.getKeikaiKubunCode());
        entity.setShinsaYM(実績基本.getShinsaYM());
        entity.setSeiriNo(実績基本.getSeiriNo());
        entity.setSofuYM(実績基本.getSofuYM());
        entity.setTorikomiYM(実績基本.getTorikomiYM());
        entity.setDokujiSakuseiKubun(実績基本.getDokujiSakuseiKubun());
        entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(実績基本.getHokenshaHoyuKyufujissekiJohoSakujoFlag());
    }

    private void set世帯員所得判定明細高額一時(TempKyufujissekiTyukannEntity entity,
            TempSetaiinShotokuHanteiEntity 明細高額) {
        entity.setShotokuHantei_hihokenshaNo(明細高額.getHihokenshaNo());
        entity.setShotokuHantei_shikibetsuCode(明細高額.getShikibetsuCode());
        entity.setShotokuHantei_setaiinShikibetsuCode(null);
        entity.setShotokuHantei_kijunYMD(明細高額.getKijunYMD());
        entity.setShotokuHantei_shotokuNendo(明細高額.getShotokuNendo());
        entity.setShotokuHantei_jushochiTokureiFlag(明細高額.getJushochiTokureiFlag());
        entity.setShotokuHantei_setaiCode(明細高額.getSetaiCode());
        entity.setShotokuHantei_honninKubun(明細高額.getHonninKubun());
        entity.setShotokuHantei_kazeiKubun(明細高額.getKazeiKubun());
        entity.setShotokuHantei_kazeiKubunGemmenGo(明細高額.getKazeiKubunGemmenGo());
        entity.setShotokuHantei_gekihenKanwaKubun(明細高額.getGekihenKanwaKubun());
        entity.setShotokuHantei_gokeiShotokuGaku(明細高額.getGokeiShotokuGaku());
        entity.setShotokuHantei_nenkiniShunyuGaku(明細高額.getNenkiniShunyuGaku());
        entity.setShotokuHantei_nenkiniShotokuGaku(明細高額.getNenkiniShotokuGaku());
        entity.setShotokuHantei_kazeiShotokuGaku(明細高額.getKazeiShotokuGaku());
        entity.setShotokuHantei_torokuGyomu(明細高額.getTorokuGyomu());
        entity.setShotokuHantei_shichosonCode(明細高額.getShichosonCode());
        entity.setShotokuHantei_shoboKubun(明細高額.getShoboKubun());
        entity.setShotokuHantei_roreiFukushi(明細高額.getRoreiFukushi());
        entity.setShotokuHantei_setaiinHihokenshaNo(明細高額.getSetaiinHihokenshaNo());
        entity.setShotokuHantei_honninKazeiKubun(明細高額.getHonninKazeiKubun());
        entity.setShotokuHantei_setaiKazeiKubun(明細高額.getSetaiKazeiKubun());
        entity.setShotokuHantei_tsuzukigaraCodeNen(明細高額.getTsuzukigaraCodeNen());
    }
}
