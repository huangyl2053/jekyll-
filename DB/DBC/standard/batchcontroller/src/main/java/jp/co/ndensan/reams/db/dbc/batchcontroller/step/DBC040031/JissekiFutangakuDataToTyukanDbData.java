/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 実績基本データTO中間DBデータプロセスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class JissekiFutangakuDataToTyukanDbData extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper"
            + ".get実績基本データ");
    private static final RString TABLENAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 中間DBデータTemp;

    @Override
    protected void createWriter() {
        中間DBデータTemp = new BatchEntityCreatedTempTableWriter(TABLENAME, KogakugassanJikofutangakuInfoHoseiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity entity) {
        KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangakuInfoHoseiTempEntity
                = new KogakugassanJikofutangakuInfoHoseiTempEntity();
        setデータ(entity, kogakugassanJikofutangakuInfoHoseiTempEntity);
        setデータSub(kogakugassanJikofutangakuInfoHoseiTempEntity, entity);
        中間DBデータTemp.insert(kogakugassanJikofutangakuInfoHoseiTempEntity);

    }

    private void setデータ(JissekiFutangakuDataTempEntity entity,
            KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangakuInfoHoseiTempEntity) {
        kogakugassanJikofutangakuInfoHoseiTempEntity.setAtesakiJusho(entity.getAtesakiJusho());
        if (!RString.isNullOrEmpty(entity.getAtesakiShimei())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setAtesakiShimei(new AtenaMeisho(entity.getAtesakiShimei()));
        }
        if (!RString.isNullOrEmpty(entity.getAtesakiYubinNo())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setAtesakiYubinNo(new YubinNo(entity.getAtesakiYubinNo()));
        }
        if (!RString.isNullOrEmpty(entity.getBatchHoseiJissiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setBatchHoseiJissiYMD(new FlexibleDate(entity.getBatchHoseiJissiYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTyushutuTaishouKubun(entity.getChushuTaishoKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        if (!RString.isNullOrEmpty(entity.getHihokenshaKaishiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHihokenshaKaishiYMD(new FlexibleDate(entity.getHihokenshaKaishiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaNo())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHihokenshaNo(new HihokenshaNo(entity.getHihokenshaNo()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaShimei())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHihokenshaShimei(new AtenaMeisho(entity.getHihokenshaShimei()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaShimeiKana())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHihokenshaShimeiKana(new AtenaKanaMeisho(entity.getHihokenshaShimeiKana()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaKaishiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHihokenshaShuryoYMD(new FlexibleDate(entity.getHihokenshaShuryoYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setHokenshaMei(entity.getHokenshaMei());
        if (!RString.isNullOrEmpty(entity.getHokenshaNo())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHokenshaNo(new HokenshaNo(entity.getHokenshaNo()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setHoseiZumiSofuKubun(entity.getHoseiZumiSofuKubun());
        if (!RString.isNullOrEmpty(entity.getHoseiZumi_SofuYM())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setHoseiZumi_SofuYM(new FlexibleYearMonth(entity.getHoseiZumi_SofuYM()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setIchiranBiko(entity.getIchiranBiko());
        if (!RString.isNullOrEmpty(entity.getIchiranChoikiCode())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setChoikiCode(new ChoikiCode(entity.getIchiranChoikiCode()));
        }
        if (!RString.isNullOrEmpty(entity.getIchiranGyoseikuCode())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setGyoseikuCode(new GyoseikuCode(entity.getIchiranGyoseikuCode()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setJuminShubetsuCode(entity.getIchiranJuminShubetsuCode());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setIchiranKakuninKubun(entity.getIchiranKakuninKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setIchiranKakuninKubun2(entity.getIchiranKakuninKubun2());
        if (!RString.isNullOrEmpty(entity.getIchiranShichosonCode())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShichosonCode(new LasdecCode(entity.getIchiranShichosonCode()));
        }
        if (!RString.isNullOrEmpty(entity.getIchiranYubinNo())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setYubinNo(new YubinNo(entity.getIchiranYubinNo()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setIdoKubun(entity.getIdoKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_JikoFutanGaku(entity.getJikoFutanGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_JikoFutanGaku(entity.getJikoFutanGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_JikoFutanGaku(entity.getJikoFutanGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_JikoFutanGaku(entity.getJikoFutanGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_JikoFutanGaku(entity.getJikoFutanGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_JikoFutanGaku(entity.getJikoFutanGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_JikoFutanGaku(entity.getJikoFutanGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_JikoFutanGaku(entity.getJikoFutanGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_JikoFutanGaku(entity.getJikoFutanGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_JikoFutanGaku(entity.getJikoFutanGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_JikoFutanGaku(entity.getJikoFutanGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_JikoFutanGaku(entity.getJikoFutanGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_JikoFutanGaku(entity.getJikoFutanGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_JikoFutanGaku(entity.getJikoFutanGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_JikoFutanGaku(entity.getJikoFutanGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_JikoFutanGaku(entity.getJikoFutanGaku107());
        if (!RString.isNullOrEmpty(entity.getJikoFutanKeisanYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setJikoFutan_KeisanYM(new FlexibleYearMonth(entity.getJikoFutanKeisanYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getJikoFutanKeisanYMD2())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setJikoFutanKeisanYMD(new FlexibleDate(entity.getJikoFutanKeisanYMD2()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setJikoFutanGakuHoseiJissi(entity.getJikoFutangakuHosei());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKaipejiArea(entity.getKaipageArea());
        if (!RString.isNullOrEmpty(entity.getKakunin_UketoriYM())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setKakunin_UketoriYM(new FlexibleYearMonth(entity.getKakunin_UketoriYM()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKogakuShikyuGakuGakuHoseiJissi(entity.getKogakuShikyuGakuHosei());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKoki_HihokenshaNo(entity.getKoki_HihokenshaNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKoki_HokenshaNo(entity.getKoki_HokenshaNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKoki_KokuhoShoriKubun(entity.getKoki_KokuhoShoriKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKokuho_HihokenshaShoNo(entity.getKokuho_HihokenshaShoNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKokuho_HokenshaNo(entity.getKokuho_HokenshaNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setKokuho_KojinNo(entity.getKokuho_KojinNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setMadoguchi_TaishoshaHanteiCode(entity.getMadoguchi_TaishoshaHanteiCode());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShotokuKubun(entity.getShotokuKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSourceArea(entity.getSortArea());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_Tekiyo(entity.getTekiyo004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_Tekiyo(entity.getTekiyo005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_Tekiyo(entity.getTekiyo006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_Tekiyo(entity.getTekiyo007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_Tekiyo(entity.getTekiyo008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_Tekiyo(entity.getTekiyo009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_Tekiyo(entity.getTekiyo010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_Tekiyo(entity.getTekiyo011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_Tekiyo(entity.getTekiyo012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_Tekiyo(entity.getTekiyo101());
    }

    private void setデータSub(KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangakuInfoHoseiTempEntity,
            JissekiFutangakuDataTempEntity entity) {
        if (!RString.isNullOrEmpty(entity.getRealHoseiJissiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setRealHoseiJissiYMD(new FlexibleDate(entity.getRealHoseiJissiYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setRirekiNo1(entity.getRirekiNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setRirekiNo2(Integer.parseInt(entity.getRirekiNo2().toString()));
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSaisoFlag(entity.getSaisoFlag());
        if (!RString.isNullOrEmpty(entity.getSeibetsuCode())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setSeibetsuCode(new Code(entity.getSeibetsuCode()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setSeiriNo(entity.getSeiriNo());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShiharaiBasho(entity.getShiharaiBasho());
        if (!RString.isNullOrEmpty(entity.getShiharaiShuryoYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShiharaiShuryoYMD(new FlexibleDate(entity.getShiharaiShuryoYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShiharaiShuryoTime(entity.getShiharaiShuryoYMDJikan());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShiharaiShuryoYMD_Yoobi(entity.getShiharaiShuryoYMDYobi());
        if (!RString.isNullOrEmpty(entity.getShikaraiKaishiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShikaraiKaishiYMD(new FlexibleDate(entity.getShikaraiKaishiYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShiharaiKaishiTime(entity.getShikaraiKaishiYMDJikan());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShikaraiKaishiYMD_Yoobi(entity.getShikaraiKaishiYMDYobi());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        if (!RString.isNullOrEmpty(entity.getShinseiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShinseiYMD(new FlexibleDate(entity.getShinseiYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setShinseiYMDShiteiMikeisanKubun(entity.getShinseibiMikeisanKubun());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.getShomeiShoHakoflag());
        if (!RString.isNullOrEmpty(entity.getShomeiShoSakuseiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShomeiShoSakuseiYMD(new FlexibleDate(entity.getShomeiShoSakuseiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getShomeisho_UketoriYM())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setShomeisho_UketoriYM(new FlexibleYearMonth(entity.getShomeisho_UketoriYM()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_sumi_Tekiyo(entity.getSumi_Tekiyo004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_sumi_Tekiyo(entity.getSumi_Tekiyo005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_sumi_Tekiyo(entity.getSumi_Tekiyo006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_sumi_Tekiyo(entity.getSumi_Tekiyo007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_sumi_Tekiyo(entity.getSumi_Tekiyo008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_sumi_Tekiyo(entity.getSumi_Tekiyo009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_sumi_Tekiyo(entity.getSumi_Tekiyo010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_sumi_Tekiyo(entity.getSumi_Tekiyo011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_sumi_Tekiyo(entity.getSumi_Tekiyo012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_sumi_Tekiyo(entity.getSumi_Tekiyo101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_sumi_Tekiyo(entity.getSumi_Tekiyo102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_sumi_Tekiyo(entity.getSumi_Tekiyo103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_sumi_Tekiyo(entity.getSumi_Tekiyo104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_sumi_Tekiyo(entity.getSumi_Tekiyo105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_sumi_Tekiyo(entity.getSumi_Tekiyo106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_sumi_Tekiyo(entity.getSumi_Tekiyo107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku107());
        if (!RString.isNullOrEmpty(entity.getTaishoKeisanKaishiYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setTaishoKeisanKaishiYMD(new FlexibleDate(entity.getTaishoKeisanKaishiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getTaishoKeisanShuryoYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setTaishoKeisanShuryoYMD(new FlexibleDate(entity.getTaishoKeisanShuryoYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getTaishoNendo())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setTaishoNendo(new FlexibleYear(entity.getTaishoNendo()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_Tekiyo(entity.getTekiyo102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_Tekiyo(entity.getTekiyo103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_Tekiyo(entity.getTekiyo104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_Tekiyo(entity.getTekiyo105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_Tekiyo(entity.getTekiyo106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_Tekiyo(entity.getTekiyo107());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku107());
        if (!RString.isNullOrEmpty(entity.getUmareYMD())) {
            kogakugassanJikofutangakuInfoHoseiTempEntity.setUmareYMD(new FlexibleDate(entity.getUmareYMD()));
        }
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_04_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku004());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_05_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku005());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_06_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku006());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_07_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku007());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_08_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku008());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_09_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku009());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_10_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku010());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_11_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku011());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setTounen_12_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku012());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_01_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku101());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_02_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku102());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_03_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku103());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_04_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku104());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_05_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku105());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_06_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku106());
        kogakugassanJikofutangakuInfoHoseiTempEntity.setYokunen_07_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku107());
    }
}
