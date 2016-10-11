/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030.IKogakugassanJikofutangakuInfoHoseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のprocessクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public class GetKogakugassanJikofutangakuInfoHoseiTempProcess extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get高額合算自己負担額情報");

    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private static final RString TABLE_NAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    private static final RString データ作成区分_2 = new RString("2");
    private static final RString データ作成区分_3 = new RString("3");
    private static final RString 当年04月 = new RString("004");
    private static final RString 当年05月 = new RString("005");
    private static final RString 当年06月 = new RString("006");
    private static final RString 当年07月 = new RString("007");
    private static final RString 当年08月 = new RString("008");
    private static final RString 当年09月 = new RString("009");
    private static final RString 当年10月 = new RString("010");
    private static final RString 当年11月 = new RString("011");
    private static final RString 当年12月 = new RString("012");
    private static final RString 翌年01月 = new RString("101");
    private static final RString 翌年02月 = new RString("102");
    private static final RString 翌年03月 = new RString("103");
    private static final RString 翌年04月 = new RString("104");
    private static final RString 翌年05月 = new RString("105");
    private static final RString 翌年06月 = new RString("106");
    private static final RString 翌年07月 = new RString("107");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        KogakugassanJikofutangakuMybatisParameter param = new KogakugassanJikofutangakuMybatisParameter();
        param.set確認情報受取年月(processParameter.getKakunin_UketoriYM());
        param.set基準年月日(new FlexibleDate(processParameter.getHandleTimestamp().getDate().toDateString()));
        return new BatchDbReader(READ_DATA_ID, param);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, KogakugassanJikofutangakuInfoHoseiTempEntity.class);
    }

    @Override
    protected void beforeExecute() {
        getMapper(IKogakugassanJikofutangakuInfoHoseiMapper.class).delete中間DB();
    }

    @Override
    protected void process(KogakugassanJikofutangakuInfoHoseiEntity entity) {
        KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity = new KogakugassanJikofutangakuInfoHoseiTempEntity();
        set高額合算自己負担額情報(tmpEntity, entity.getDbt3070Entity());
        set被保険者情報と宛名情報(tmpEntity, entity);
        if (entity.getDbt3071Entity() != null) {
            set高額合算自己負担額明細情報(tmpEntity, entity);
        }
        tempDbWriter.insert(tmpEntity);
    }

    private void set高額合算自己負担額情報(KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity,
            DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        tmpEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tmpEntity.setTaishoNendo(entity.getTaishoNendo());
        tmpEntity.setHokenshaNo(entity.getHokenshaNo());
        tmpEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tmpEntity.setRirekiNo2(entity.getRirekiNo());
        tmpEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
        tmpEntity.setHokenshaMei(entity.getHokenshaMei());
        tmpEntity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        tmpEntity.setHihokenshaShimeiKana(entity.getHihokenshaShimeiKana());
        tmpEntity.setHihokenshaShimei(entity.getHihokenshaShimei());
        tmpEntity.setUmareYMD(entity.getUmareYMD());
        tmpEntity.setSeibetsuCode(entity.getSeibetsuCode());
        tmpEntity.setShotokuKubun(entity.getShotokuKubun());
        tmpEntity.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        tmpEntity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        tmpEntity.setKoki_HokenshaNo(entity.getKoki_HokenshaNo());
        tmpEntity.setKoki_HihokenshaNo(entity.getKoki_HihokenshaNo());
        tmpEntity.setKokuho_HokenshaNo(entity.getKokuho_HokenshaNo());
        tmpEntity.setKokuho_HihokenshaShoNo(entity.getKokuho_HihokenshaShoNo());
        tmpEntity.setKokuho_KojinNo(entity.getKokuho_KojinNo());
        tmpEntity.setIdoKubun(entity.getIdoKubun());
        tmpEntity.setHoseiZumiSofuKubun(entity.getHoseiZumiSofuKubun());
        tmpEntity.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        tmpEntity.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        tmpEntity.setHihokenshaKaishiYMD(entity.getHihokenshaKaishiYMD());
        tmpEntity.setHihokenshaShuryoYMD(entity.getHihokenshaShuryoYMD());
        tmpEntity.setShinseiYMD(entity.getShinseiYMD());
        tmpEntity.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        tmpEntity.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        tmpEntity.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        tmpEntity.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        tmpEntity.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        tmpEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        tmpEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        tmpEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        tmpEntity.setAtesakiShimei(entity.getAtesakiShimei());
        tmpEntity.setAtesakiYubinNo(entity.getAtesakiYubinNo());
        tmpEntity.setAtesakiJusho(entity.getAtesakiJusho());
        tmpEntity.setMadoguchi_TaishoshaHanteiCode(entity.getMadoguchi_TaishoshaHanteiCode());
        tmpEntity.setShiharaiBasho(entity.getShiharaiBasho());
        tmpEntity.setShikaraiKaishiYMD(entity.getShikaraiKaishiYMD());
        tmpEntity.setShiharaiShuryoYMD(entity.getShiharaiShuryoYMD());
        tmpEntity.setShiharaiKaishiTime(entity.getShiharaiKaishiTime());
        tmpEntity.setShiharaiShuryoTime(entity.getShiharaiShuryoTime());
        tmpEntity.setBiko(entity.getBiko());
        tmpEntity.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        tmpEntity.setKakunin_UketoriYM(entity.getKakunin_UketoriYM());
        tmpEntity.setHoseiZumi_SofuYM(entity.getHoseiZumi_SofuYM());
        tmpEntity.setShomeisho_UketoriYM(entity.getShomeisho_UketoriYM());
        tmpEntity.setSaisoFlag(entity.getSaisoFlag());
        tmpEntity.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        if (データ作成区分_2.equals(entity.getDataSakuseiKubun()) || データ作成区分_3.equals(entity.getDataSakuseiKubun())) {
            tmpEntity.setJikoFutanKeisanYMD(entity.getJikoFutanKeisanYMD());
        }
        if (データ作成区分_2.equals(entity.getDataSakuseiKubun())) {
            tmpEntity.setShomeiShoSakuseiYMD(entity.getShomeiShoSakuseiYMD());
        }
        tmpEntity.setKoki_KokuhoShoriKubun(entity.getKoki_KokuhoShoriKubun());
        tmpEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.getJikoFutangakuShomeishoRealHakkoFlag());
        tmpEntity.setBatchHoseiJissiYMD(entity.getBatchHoseiJissiYMD());
        tmpEntity.setRealHoseiJissiYMD(entity.getRealHoseiJissiYMD());
    }

    private void set被保険者情報と宛名情報(KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity,
            KogakugassanJikofutangakuInfoHoseiEntity entity) {
        tmpEntity.setJuminShubetsuCode(entity.getJuminShubetsuCode());
        tmpEntity.setShichosonCode(entity.getShichosonCode());
        tmpEntity.setYubinNo(entity.getYubinNo());
        tmpEntity.setZenkokuJushoCode(entity.getZenkokuJushoCode());
        tmpEntity.setGyoseikuCode(entity.getGyoseikuCode());
    }

    private void set高額合算自己負担額明細情報(KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity,
            KogakugassanJikofutangakuInfoHoseiEntity entity) {
        if (当年04月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_04_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_04_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_04_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_04_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_04_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_04_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_04_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_04_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_04_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_04_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年05月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_05_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_05_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_05_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_05_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_05_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_05_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_05_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_05_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_05_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_05_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年06月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_06_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_06_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_06_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_06_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_06_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_06_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_06_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_06_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_06_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_06_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年07月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_07_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_07_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_07_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_07_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_07_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_07_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_07_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_07_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_07_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_07_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年08月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_08_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_08_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_08_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_08_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_08_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_08_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_08_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_08_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_08_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_08_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年09月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_09_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_09_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_09_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_09_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_09_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_09_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_09_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_09_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_09_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_09_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年10月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_10_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_10_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_10_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_10_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_10_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_10_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_10_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_10_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_10_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_10_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年11月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_11_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_11_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_11_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_11_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_11_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_11_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_11_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_11_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_11_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_11_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年12月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setTounen_12_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setTounen_12_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setTounen_12_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setTounen_12_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_12_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setTounen_12_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setTounen_12_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setTounen_12_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setTounen_12_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setTounen_12_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else {
            set高額合算自己負担額明細情報Part2(tmpEntity, entity);
        }
    }

    private void set高額合算自己負担額明細情報Part2(KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity,
            KogakugassanJikofutangakuInfoHoseiEntity entity) {
        if (翌年01月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_01_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_01_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_01_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_01_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_01_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_01_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_01_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_01_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_01_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年02月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_02_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_02_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_02_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_02_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_02_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_02_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_02_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_02_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_02_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年03月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_03_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_03_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_03_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_03_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_03_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_03_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_03_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_03_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_03_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年04月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_04_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_04_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_04_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_04_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_04_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_04_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_04_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_04_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_04_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年05月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_05_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_05_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_05_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_05_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_05_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_05_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_05_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_05_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_05_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年06月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_06_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_06_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_06_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_06_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_06_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_06_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_06_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_06_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_06_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年07月.equals(entity.getDbt3071Entity().getTaishoM())) {
            tmpEntity.setYokunen_07_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            tmpEntity.setYokunen_07_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            tmpEntity.setYokunen_07_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            tmpEntity.setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_07_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            tmpEntity.setYokunen_07_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            tmpEntity.setYokunen_07_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            tmpEntity.setYokunen_07_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            tmpEntity.setYokunen_07_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            tmpEntity.setYokunen_07_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        }
    }

}
