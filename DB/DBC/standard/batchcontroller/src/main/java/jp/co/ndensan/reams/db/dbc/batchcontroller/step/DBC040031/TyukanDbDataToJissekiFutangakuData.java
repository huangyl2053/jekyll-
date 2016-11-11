/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 中間DBデータTO実績基本データプロセスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class TyukanDbDataToJissekiFutangakuData extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper"
            + ".get中間DBデータ");
    private static final RString TABLENAME = new RString("JissekiFutangakuDataTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 実績基本データTemp;

    @Override
    protected void createWriter() {
        実績基本データTemp = new BatchEntityCreatedTempTableWriter(TABLENAME, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(KogakugassanJikofutangakuInfoHoseiTempEntity entity) {
        JissekiFutangakuDataTempEntity jissekiFutangakuDataTempEntity = new JissekiFutangakuDataTempEntity();
        setデータ(jissekiFutangakuDataTempEntity, entity);
        setデータSub(jissekiFutangakuDataTempEntity, entity);
        実績基本データTemp.insert(jissekiFutangakuDataTempEntity);
    }

    private void setデータ(JissekiFutangakuDataTempEntity jissekiFutangakuDataTempEntity, KogakugassanJikofutangakuInfoHoseiTempEntity entity) {
        jissekiFutangakuDataTempEntity.setAtesakiJusho(entity.getAtesakiJusho());
        if (entity.getAtesakiShimei() != null) {
            jissekiFutangakuDataTempEntity.setAtesakiShimei(entity.getAtesakiShimei().value());
        }
        if (entity.getAtesakiYubinNo() != null) {
            jissekiFutangakuDataTempEntity.setAtesakiYubinNo(entity.getAtesakiYubinNo().value());
        }
        if (entity.getBatchHoseiJissiYMD() != null) {
            jissekiFutangakuDataTempEntity.setBatchHoseiJissiYMD(new RString(entity.getBatchHoseiJissiYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setChushuTaishoKubun(entity.getTyushutuTaishouKubun());
        jissekiFutangakuDataTempEntity.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        jissekiFutangakuDataTempEntity.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        if (entity.getHihokenshaKaishiYMD() != null) {
            jissekiFutangakuDataTempEntity.setHihokenshaKaishiYMD(new RString(entity.getHihokenshaKaishiYMD().toString()));
        }
        if (entity.getHihokenshaNo() != null) {
            jissekiFutangakuDataTempEntity.setHihokenshaNo(entity.getHihokenshaNo().value());
        }
        if (entity.getHihokenshaShimei() != null) {
            jissekiFutangakuDataTempEntity.setHihokenshaShimei(entity.getHihokenshaShimei().value());
        }
        if (entity.getHihokenshaShimeiKana() != null) {
            jissekiFutangakuDataTempEntity.setHihokenshaShimeiKana(entity.getHihokenshaShimeiKana().value());
        }
        if (entity.getHihokenshaKaishiYMD() != null) {
            jissekiFutangakuDataTempEntity.setHihokenshaShuryoYMD(new RString(entity.getHihokenshaShuryoYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
        jissekiFutangakuDataTempEntity.setHokenshaMei(entity.getHokenshaMei());
        if (entity.getHokenshaNo() != null) {
            jissekiFutangakuDataTempEntity.setHokenshaNo(entity.getHokenshaNo().value());
        }
        jissekiFutangakuDataTempEntity.setHoseiZumiSofuKubun(entity.getHoseiZumiSofuKubun());
        if (entity.getHoseiZumi_SofuYM() != null) {
            jissekiFutangakuDataTempEntity.setHoseiZumi_SofuYM(entity.getHoseiZumi_SofuYM().toDateString());
        }
        jissekiFutangakuDataTempEntity.setIchiranBiko(entity.getIchiranBiko());
        if (entity.getChoikiCode() != null) {
            jissekiFutangakuDataTempEntity.setIchiranChoikiCode(entity.getChoikiCode().value());
        }
        if (entity.getGyoseikuCode() != null) {
            jissekiFutangakuDataTempEntity.setIchiranGyoseikuCode(entity.getGyoseikuCode().value());
        }
        jissekiFutangakuDataTempEntity.setIchiranJuminShubetsuCode(entity.getJuminShubetsuCode());
        jissekiFutangakuDataTempEntity.setIchiranKakuninKubun(entity.getIchiranKakuninKubun());
        jissekiFutangakuDataTempEntity.setIchiranKakuninKubun2(entity.getIchiranKakuninKubun2());
        if (entity.getShichosonCode() != null) {
            jissekiFutangakuDataTempEntity.setIchiranShichosonCode(entity.getShichosonCode().value());
        }
        if (entity.getYubinNo() != null) {
            jissekiFutangakuDataTempEntity.setIchiranYubinNo(entity.getYubinNo().value());
        }
        jissekiFutangakuDataTempEntity.setIdoKubun(entity.getIdoKubun());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku004(entity.getTounen_04_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku005(entity.getTounen_05_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku006(entity.getTounen_06_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku007(entity.getTounen_07_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku008(entity.getTounen_08_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku009(entity.getTounen_09_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku010(entity.getTounen_10_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku011(entity.getTounen_11_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku012(entity.getTounen_12_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku101(entity.getYokunen_01_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku102(entity.getYokunen_02_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku103(entity.getYokunen_03_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku104(entity.getYokunen_04_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku105(entity.getYokunen_05_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku106(entity.getYokunen_06_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setJikoFutanGaku107(entity.getYokunen_07_JikoFutanGaku());
        if (entity.getJikoFutan_KeisanYM() != null) {
            jissekiFutangakuDataTempEntity.setJikoFutanKeisanYMD(new RString(entity.getJikoFutan_KeisanYM().toString()));
        }
        if (entity.getJikoFutanKeisanYMD() != null) {
            jissekiFutangakuDataTempEntity.setJikoFutanKeisanYMD2(new RString(entity.getJikoFutanKeisanYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        jissekiFutangakuDataTempEntity.setJikoFutangakuHosei(entity.getJikoFutanGakuHoseiJissi());
        jissekiFutangakuDataTempEntity.setKaipageArea(entity.getKaipejiArea());
        if (entity.getKakunin_UketoriYM() != null) {
            jissekiFutangakuDataTempEntity.setKakunin_UketoriYM(entity.getKakunin_UketoriYM().toDateString());
        }
        jissekiFutangakuDataTempEntity.setKogakuShikyuGakuHosei(entity.getKogakuShikyuGakuGakuHoseiJissi());
        jissekiFutangakuDataTempEntity.setKoki_HihokenshaNo(entity.getKoki_HihokenshaNo());
        jissekiFutangakuDataTempEntity.setKoki_HokenshaNo(entity.getKoki_HokenshaNo());
        jissekiFutangakuDataTempEntity.setKoki_KokuhoShoriKubun(entity.getKoki_KokuhoShoriKubun());
        jissekiFutangakuDataTempEntity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        jissekiFutangakuDataTempEntity.setKokuho_HihokenshaShoNo(entity.getKokuho_HihokenshaShoNo());
        jissekiFutangakuDataTempEntity.setKokuho_HokenshaNo(entity.getKokuho_HokenshaNo());
        jissekiFutangakuDataTempEntity.setKokuho_KojinNo(entity.getKokuho_KojinNo());
        jissekiFutangakuDataTempEntity.setMadoguchi_TaishoshaHanteiCode(entity.getMadoguchi_TaishoshaHanteiCode());
        jissekiFutangakuDataTempEntity.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku004(entity.getTounen_04_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku005(entity.getTounen_05_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku006(entity.getTounen_06_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku007(entity.getTounen_07_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku008(entity.getTounen_08_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku009(entity.getTounen_09_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku010(entity.getTounen_10_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku011(entity.getTounen_11_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku012(entity.getTounen_12_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku101(entity.getYokunen_01_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku102(entity.getYokunen_02_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku103(entity.getYokunen_03_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku104(entity.getYokunen_04_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku105(entity.getYokunen_05_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku106(entity.getYokunen_06_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setOver_70_74KogakuShikyuGaku107(entity.getYokunen_07_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setShotokuKubun(entity.getShotokuKubun());
        jissekiFutangakuDataTempEntity.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        jissekiFutangakuDataTempEntity.setSortArea(entity.getSourceArea());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku004(entity.getTounen_04_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku005(entity.getTounen_05_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku006(entity.getTounen_06_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku007(entity.getTounen_07_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku008(entity.getTounen_08_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku009(entity.getTounen_09_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku010(entity.getTounen_10_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku011(entity.getTounen_11_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku012(entity.getTounen_12_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku101(entity.getYokunen_01_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku102(entity.getYokunen_02_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku103(entity.getYokunen_03_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku104(entity.getYokunen_04_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku105(entity.getYokunen_05_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku106(entity.getYokunen_06_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74JikoFutanGaku107(entity.getYokunen_07_sumi_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku004(entity.getTounen_04_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku005(entity.getTounen_05_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku006(entity.getTounen_06_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku007(entity.getTounen_07_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku008(entity.getTounen_08_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku009(entity.getTounen_09_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku010(entity.getTounen_10_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku011(entity.getTounen_11_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku012(entity.getTounen_12_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku101(entity.getYokunen_01_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku102(entity.getYokunen_02_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku103(entity.getYokunen_03_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku104(entity.getYokunen_04_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku105(entity.getYokunen_05_Over_70_74KogakuShikyuGaku());
    }

    private void setデータSub(JissekiFutangakuDataTempEntity jissekiFutangakuDataTempEntity, KogakugassanJikofutangakuInfoHoseiTempEntity entity) {
        if (entity.getRealHoseiJissiYMD() != null) {
            jissekiFutangakuDataTempEntity.setRealHoseiJissiYMD(new RString(entity.getRealHoseiJissiYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setRirekiNo(entity.getRirekiNo1());
        jissekiFutangakuDataTempEntity.setRirekiNo2(new RString(entity.getRirekiNo2()));
        jissekiFutangakuDataTempEntity.setSaisoFlag(entity.getSaisoFlag());
        if (entity.getSeibetsuCode() != null) {
            jissekiFutangakuDataTempEntity.setSeibetsuCode(entity.getSeibetsuCode().value());
        }
        jissekiFutangakuDataTempEntity.setSeiriNo(entity.getSeiriNo());
        jissekiFutangakuDataTempEntity.setShiharaiBasho(entity.getShiharaiBasho());
        if (entity.getShiharaiShuryoYMD() != null) {
            jissekiFutangakuDataTempEntity.setShiharaiShuryoYMD(new RString(entity.getShiharaiShuryoYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setShiharaiShuryoYMDJikan(entity.getShiharaiShuryoTime());
        jissekiFutangakuDataTempEntity.setShiharaiShuryoYMDYobi(entity.getShiharaiShuryoYMD_Yoobi());
        if (entity.getShikaraiKaishiYMD() != null) {
            jissekiFutangakuDataTempEntity.setShikaraiKaishiYMD(new RString(entity.getShikaraiKaishiYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setShikaraiKaishiYMDJikan(entity.getShiharaiKaishiTime());
        jissekiFutangakuDataTempEntity.setShikaraiKaishiYMDYobi(entity.getShikaraiKaishiYMD_Yoobi());
        jissekiFutangakuDataTempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        if (entity.getShinseiYMD() != null) {
            jissekiFutangakuDataTempEntity.setShinseiYMD(new RString(entity.getShinseiYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setShinseibiMikeisanKubun(entity.getShinseiYMDShiteiMikeisanKubun());
        jissekiFutangakuDataTempEntity.setShomeiShoHakoflag(entity.getJikoFutangakuShomeishoRealHakkoFlag());
        if (entity.getShomeiShoSakuseiYMD() != null) {
            jissekiFutangakuDataTempEntity.setShomeiShoSakuseiYMD(new RString(entity.getShomeiShoSakuseiYMD().toString()));
        }
        if (entity.getShomeisho_UketoriYM() != null) {
            jissekiFutangakuDataTempEntity.setShomeisho_UketoriYM(new RString(entity.getShomeisho_UketoriYM().toString()));
        }
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku106(entity.getYokunen_06_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_70_74KogakuShikyuGaku107(entity.getYokunen_07_Over_70_74KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku004(entity.getTounen_04_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku005(entity.getTounen_05_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku006(entity.getTounen_06_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku007(entity.getTounen_07_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku008(entity.getTounen_08_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku009(entity.getTounen_09_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku010(entity.getTounen_10_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku011(entity.getTounen_11_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku012(entity.getTounen_12_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku101(entity.getYokunen_01_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku102(entity.getYokunen_02_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku103(entity.getYokunen_03_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku104(entity.getYokunen_04_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku105(entity.getYokunen_05_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku106(entity.getYokunen_06_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_JikoFutanGaku107(entity.getYokunen_07_sumi_JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo004(entity.getTounen_04_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo005(entity.getTounen_05_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo006(entity.getTounen_06_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo007(entity.getTounen_07_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo008(entity.getTounen_08_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo009(entity.getTounen_09_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo010(entity.getTounen_10_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo011(entity.getTounen_11_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo012(entity.getTounen_12_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo101(entity.getYokunen_01_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo102(entity.getYokunen_02_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo103(entity.getYokunen_03_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo104(entity.getYokunen_04_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo105(entity.getYokunen_05_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo106(entity.getYokunen_06_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_Tekiyo107(entity.getYokunen_07_sumi_Tekiyo());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku004(entity.getTounen_04_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku005(entity.getTounen_05_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku006(entity.getTounen_06_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku007(entity.getTounen_07_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku008(entity.getTounen_08_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku009(entity.getTounen_09_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku010(entity.getTounen_10_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku011(entity.getTounen_11_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku012(entity.getTounen_12_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku101(entity.getYokunen_01_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku102(entity.getYokunen_02_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku103(entity.getYokunen_03_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku104(entity.getYokunen_04_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku105(entity.getYokunen_05_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku106(entity.getYokunen_06_sumi_under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setSumi_under_70KogakuShikyuGaku107(entity.getYokunen_07_sumi_under_70KogakuShikyuGaku());
        if (entity.getTaishoKeisanKaishiYMD() != null) {
            jissekiFutangakuDataTempEntity.setTaishoKeisanKaishiYMD(new RString(entity.getTaishoKeisanKaishiYMD().toString()));
        }
        if (entity.getTaishoKeisanShuryoYMD() != null) {
            jissekiFutangakuDataTempEntity.setTaishoKeisanShuryoYMD(new RString(entity.getTaishoKeisanShuryoYMD().toString()));
        }
        if (entity.getTaishoNendo() != null) {
            jissekiFutangakuDataTempEntity.setTaishoNendo(new RString(entity.getTaishoNendo().toString()));
        }
        jissekiFutangakuDataTempEntity.setTekiyo004(entity.getTounen_04_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo005(entity.getTounen_05_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo006(entity.getTounen_06_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo007(entity.getTounen_07_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo008(entity.getTounen_08_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo009(entity.getTounen_09_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo010(entity.getTounen_10_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo011(entity.getTounen_11_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo012(entity.getTounen_12_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo101(entity.getYokunen_01_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo102(entity.getYokunen_02_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo103(entity.getYokunen_03_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo104(entity.getYokunen_04_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo105(entity.getYokunen_05_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo106(entity.getYokunen_06_Tekiyo());
        jissekiFutangakuDataTempEntity.setTekiyo107(entity.getYokunen_07_Tekiyo());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku004(entity.getTounen_04_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku005(entity.getTounen_05_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku006(entity.getTounen_06_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku007(entity.getTounen_07_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku008(entity.getTounen_08_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku009(entity.getTounen_09_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku010(entity.getTounen_10_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku011(entity.getTounen_11_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku012(entity.getTounen_12_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku101(entity.getYokunen_01_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku102(entity.getYokunen_02_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku103(entity.getYokunen_03_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku104(entity.getYokunen_04_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku105(entity.getYokunen_05_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku106(entity.getYokunen_06_Uchisu_70_74JikoFutanGaku());
        jissekiFutangakuDataTempEntity.setUchisu_70_74JikoFutanGaku107(entity.getYokunen_07_Uchisu_70_74JikoFutanGaku());
        if (entity.getUmareYMD() != null) {
            jissekiFutangakuDataTempEntity.setUmareYMD(new RString(entity.getUmareYMD().toString()));
        }
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku004(entity.getTounen_04_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku005(entity.getTounen_05_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku006(entity.getTounen_06_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku007(entity.getTounen_07_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku008(entity.getTounen_08_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku009(entity.getTounen_09_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku010(entity.getTounen_10_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku011(entity.getTounen_11_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku012(entity.getTounen_12_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku101(entity.getYokunen_01_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku102(entity.getYokunen_02_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku103(entity.getYokunen_03_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku104(entity.getYokunen_04_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku105(entity.getYokunen_05_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku106(entity.getYokunen_06_Under_70KogakuShikyuGaku());
        jissekiFutangakuDataTempEntity.setUnder_70KogakuShikyuGaku107(entity.getYokunen_07_Under_70KogakuShikyuGaku());
    }

}
