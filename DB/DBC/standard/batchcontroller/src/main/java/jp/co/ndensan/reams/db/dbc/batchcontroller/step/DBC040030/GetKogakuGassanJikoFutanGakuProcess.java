/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030.IKogakugassanJikofutangakuInfoHoseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のprocessクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public class GetKogakuGassanJikoFutanGakuProcess extends BatchProcessBase<DbT3070KogakuGassanJikoFutanGakuEntity> {

    /**
     * 取得件数です。
     */
    public static final RString PARAMETER_OUT_OUTPUTSAKUSEIYMD;

    static {
        PARAMETER_OUT_OUTPUTSAKUSEIYMD = new RString("取得件数");

    }
    private OutputParameter<Integer> 取得件数;
    private int 高額合算自己負担額件数;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get高額合算自己負担額データ");

    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private static final RString TABLE_NAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString データ作成区分_2 = new RString("2");
    private static final RString データ作成区分_3 = new RString("3");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        取得件数 = new OutputParameter<>();
        取得件数.setValue(INT_0);
        高額合算自己負担額件数 = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        KogakugassanJikofutangakuMybatisParameter param = new KogakugassanJikofutangakuMybatisParameter();
        param.set確認情報受取年月(processParameter.getKakunin_UketoriYM());
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
    protected void process(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity = new KogakugassanJikofutangakuInfoHoseiTempEntity();
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

        tempDbWriter.insert(tmpEntity);
        高額合算自己負担額件数 = 高額合算自己負担額件数 + INT_1;
    }

    @Override
    protected void afterExecute() {
        取得件数.setValue(高額合算自己負担額件数);
    }
}
