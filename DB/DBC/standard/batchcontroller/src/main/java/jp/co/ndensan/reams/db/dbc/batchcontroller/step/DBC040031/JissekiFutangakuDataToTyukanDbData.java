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
        KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangaku
                = new KogakugassanJikofutangakuInfoHoseiTempEntity();
        setデータ(entity, kogakugassanJikofutangaku);
        setデータSub(kogakugassanJikofutangaku, entity);
        中間DBデータTemp.insert(kogakugassanJikofutangaku);

    }

    private void setデータ(JissekiFutangakuDataTempEntity entity,
            KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangaku) {
        kogakugassanJikofutangaku.setAtesakiJusho(entity.getAtesakiJusho());
        if (!RString.isNullOrEmpty(entity.getAtesakiShimei())) {
            kogakugassanJikofutangaku.setAtesakiShimei(new AtenaMeisho(entity.getAtesakiShimei()));
        }
        if (!RString.isNullOrEmpty(entity.getAtesakiYubinNo())) {
            kogakugassanJikofutangaku.setAtesakiYubinNo(new YubinNo(entity.getAtesakiYubinNo()));
        }
        if (!RString.isNullOrEmpty(entity.getBatchHoseiJissiYMD())) {
            kogakugassanJikofutangaku.setBatchHoseiJissiYMD(new FlexibleDate(entity.getBatchHoseiJissiYMD()));
        }
        kogakugassanJikofutangaku.setTyushutuTaishouKubun(entity.getChushuTaishoKubun());
        kogakugassanJikofutangaku.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        kogakugassanJikofutangaku.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        kogakugassanJikofutangaku.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        kogakugassanJikofutangaku.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        kogakugassanJikofutangaku.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        if (!RString.isNullOrEmpty(entity.getHihokenshaKaishiYMD())) {
            kogakugassanJikofutangaku.setHihokenshaKaishiYMD(new FlexibleDate(entity.getHihokenshaKaishiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaNo())) {
            kogakugassanJikofutangaku.setHihokenshaNo(new HihokenshaNo(entity.getHihokenshaNo()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaShimei())) {
            kogakugassanJikofutangaku.setHihokenshaShimei(new AtenaMeisho(entity.getHihokenshaShimei()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaShimeiKana())) {
            kogakugassanJikofutangaku.setHihokenshaShimeiKana(new AtenaKanaMeisho(entity.getHihokenshaShimeiKana()));
        }
        if (!RString.isNullOrEmpty(entity.getHihokenshaKaishiYMD())) {
            kogakugassanJikofutangaku.setHihokenshaShuryoYMD(new FlexibleDate(entity.getHihokenshaShuryoYMD()));
        }
        kogakugassanJikofutangaku.setHokenSeidoCode(entity.getHokenSeidoCode());
        kogakugassanJikofutangaku.setHokenshaMei(entity.getHokenshaMei());
        if (!RString.isNullOrEmpty(entity.getHokenshaNo())) {
            kogakugassanJikofutangaku.setHokenshaNo(new HokenshaNo(entity.getHokenshaNo()));
        }
        kogakugassanJikofutangaku.setHoseiZumiSofuKubun(entity.getHoseiZumiSofuKubun());
        if (!RString.isNullOrEmpty(entity.getHoseiZumi_SofuYM())) {
            kogakugassanJikofutangaku.setHoseiZumi_SofuYM(new FlexibleYearMonth(entity.getHoseiZumi_SofuYM()));
        }
        kogakugassanJikofutangaku.setIchiranBiko(entity.getIchiranBiko());
        if (!RString.isNullOrEmpty(entity.getIchiranChoikiCode())) {
            kogakugassanJikofutangaku.setChoikiCode(new ChoikiCode(entity.getIchiranChoikiCode()));
        }
        if (!RString.isNullOrEmpty(entity.getIchiranGyoseikuCode())) {
            kogakugassanJikofutangaku.setGyoseikuCode(new GyoseikuCode(entity.getIchiranGyoseikuCode()));
        }
        kogakugassanJikofutangaku.setJuminShubetsuCode(entity.getIchiranJuminShubetsuCode());
        kogakugassanJikofutangaku.setIchiranKakuninKubun(entity.getIchiranKakuninKubun());
        kogakugassanJikofutangaku.setIchiranKakuninKubun2(entity.getIchiranKakuninKubun2());
        if (!RString.isNullOrEmpty(entity.getIchiranShichosonCode())) {
            kogakugassanJikofutangaku.setShichosonCode(new LasdecCode(entity.getIchiranShichosonCode()));
        }
        if (!RString.isNullOrEmpty(entity.getIchiranYubinNo())) {
            kogakugassanJikofutangaku.setYubinNo(new YubinNo(entity.getIchiranYubinNo()));
        }
        kogakugassanJikofutangaku.setIdoKubun(entity.getIdoKubun());
        kogakugassanJikofutangaku.setTounen_04_JikoFutanGaku(entity.getJikoFutanGaku004());
        kogakugassanJikofutangaku.setTounen_05_JikoFutanGaku(entity.getJikoFutanGaku005());
        kogakugassanJikofutangaku.setTounen_06_JikoFutanGaku(entity.getJikoFutanGaku006());
        kogakugassanJikofutangaku.setTounen_07_JikoFutanGaku(entity.getJikoFutanGaku007());
        kogakugassanJikofutangaku.setTounen_08_JikoFutanGaku(entity.getJikoFutanGaku008());
        kogakugassanJikofutangaku.setTounen_09_JikoFutanGaku(entity.getJikoFutanGaku009());
        kogakugassanJikofutangaku.setTounen_10_JikoFutanGaku(entity.getJikoFutanGaku010());
        kogakugassanJikofutangaku.setTounen_11_JikoFutanGaku(entity.getJikoFutanGaku011());
        kogakugassanJikofutangaku.setTounen_12_JikoFutanGaku(entity.getJikoFutanGaku012());
        kogakugassanJikofutangaku.setYokunen_01_JikoFutanGaku(entity.getJikoFutanGaku101());
        kogakugassanJikofutangaku.setYokunen_02_JikoFutanGaku(entity.getJikoFutanGaku102());
        kogakugassanJikofutangaku.setYokunen_03_JikoFutanGaku(entity.getJikoFutanGaku103());
        kogakugassanJikofutangaku.setYokunen_04_JikoFutanGaku(entity.getJikoFutanGaku104());
        kogakugassanJikofutangaku.setYokunen_05_JikoFutanGaku(entity.getJikoFutanGaku105());
        kogakugassanJikofutangaku.setYokunen_06_JikoFutanGaku(entity.getJikoFutanGaku106());
        kogakugassanJikofutangaku.setYokunen_07_JikoFutanGaku(entity.getJikoFutanGaku107());
        if (!RString.isNullOrEmpty(entity.getJikoFutanKeisanYMD())) {
            kogakugassanJikofutangaku.setJikoFutan_KeisanYM(new FlexibleYearMonth(entity.getJikoFutanKeisanYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getJikoFutanKeisanYMD2())) {
            kogakugassanJikofutangaku.setJikoFutanKeisanYMD(new FlexibleDate(entity.getJikoFutanKeisanYMD2()));
        }
        kogakugassanJikofutangaku.setJikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        kogakugassanJikofutangaku.setJikoFutanGakuHoseiJissi(entity.getJikoFutangakuHosei());
        kogakugassanJikofutangaku.setKaipejiArea(entity.getKaipageArea());
        if (!RString.isNullOrEmpty(entity.getKakunin_UketoriYM())) {
            kogakugassanJikofutangaku.setKakunin_UketoriYM(new FlexibleYearMonth(entity.getKakunin_UketoriYM()));
        }
        kogakugassanJikofutangaku.setKogakuShikyuGakuGakuHoseiJissi(entity.getKogakuShikyuGakuHosei());
        kogakugassanJikofutangaku.setKoki_HihokenshaNo(entity.getKoki_HihokenshaNo());
        kogakugassanJikofutangaku.setKoki_HokenshaNo(entity.getKoki_HokenshaNo());
        kogakugassanJikofutangaku.setKoki_KokuhoShoriKubun(entity.getKoki_KokuhoShoriKubun());
        kogakugassanJikofutangaku.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        kogakugassanJikofutangaku.setKokuho_HihokenshaShoNo(entity.getKokuho_HihokenshaShoNo());
        kogakugassanJikofutangaku.setKokuho_HokenshaNo(entity.getKokuho_HokenshaNo());
        kogakugassanJikofutangaku.setKokuho_KojinNo(entity.getKokuho_KojinNo());
        kogakugassanJikofutangaku.setMadoguchi_TaishoshaHanteiCode(entity.getMadoguchi_TaishoshaHanteiCode());
        kogakugassanJikofutangaku.setOver70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        kogakugassanJikofutangaku.setTounen_04_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku004());
        kogakugassanJikofutangaku.setTounen_05_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku005());
        kogakugassanJikofutangaku.setTounen_06_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku006());
        kogakugassanJikofutangaku.setTounen_07_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku007());
        kogakugassanJikofutangaku.setTounen_08_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku008());
        kogakugassanJikofutangaku.setTounen_09_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku009());
        kogakugassanJikofutangaku.setTounen_10_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku010());
        kogakugassanJikofutangaku.setTounen_11_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku011());
        kogakugassanJikofutangaku.setTounen_12_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku012());
        kogakugassanJikofutangaku.setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku101());
        kogakugassanJikofutangaku.setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku102());
        kogakugassanJikofutangaku.setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku103());
        kogakugassanJikofutangaku.setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku104());
        kogakugassanJikofutangaku.setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku105());
        kogakugassanJikofutangaku.setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku106());
        kogakugassanJikofutangaku.setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getOver_70_74KogakuShikyuGaku107());
        kogakugassanJikofutangaku.setShotokuKubun(entity.getShotokuKubun());
        kogakugassanJikofutangaku.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        kogakugassanJikofutangaku.setSourceArea(entity.getSortArea());
        kogakugassanJikofutangaku.setTounen_04_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku004());
        kogakugassanJikofutangaku.setTounen_05_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku005());
        kogakugassanJikofutangaku.setTounen_06_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku006());
        kogakugassanJikofutangaku.setTounen_07_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku007());
        kogakugassanJikofutangaku.setTounen_08_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku008());
        kogakugassanJikofutangaku.setTounen_09_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku009());
        kogakugassanJikofutangaku.setTounen_10_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku010());
        kogakugassanJikofutangaku.setTounen_11_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku011());
        kogakugassanJikofutangaku.setTounen_12_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku012());
        kogakugassanJikofutangaku.setYokunen_01_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku101());
        kogakugassanJikofutangaku.setYokunen_02_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku102());
        kogakugassanJikofutangaku.setYokunen_03_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku103());
        kogakugassanJikofutangaku.setYokunen_04_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku104());
        kogakugassanJikofutangaku.setYokunen_05_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku105());
        kogakugassanJikofutangaku.setYokunen_06_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku106());
        kogakugassanJikofutangaku.setYokunen_07_sumi_70_74JikoFutanGaku(entity.getSumi_70_74JikoFutanGaku107());
        kogakugassanJikofutangaku.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        kogakugassanJikofutangaku.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        kogakugassanJikofutangaku.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        kogakugassanJikofutangaku.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        kogakugassanJikofutangaku.setTounen_04_Tekiyo(entity.getTekiyo004());
        kogakugassanJikofutangaku.setTounen_05_Tekiyo(entity.getTekiyo005());
        kogakugassanJikofutangaku.setTounen_06_Tekiyo(entity.getTekiyo006());
        kogakugassanJikofutangaku.setTounen_07_Tekiyo(entity.getTekiyo007());
        kogakugassanJikofutangaku.setTounen_08_Tekiyo(entity.getTekiyo008());
        kogakugassanJikofutangaku.setTounen_09_Tekiyo(entity.getTekiyo009());
        kogakugassanJikofutangaku.setTounen_10_Tekiyo(entity.getTekiyo010());
        kogakugassanJikofutangaku.setTounen_11_Tekiyo(entity.getTekiyo011());
        kogakugassanJikofutangaku.setTounen_12_Tekiyo(entity.getTekiyo012());
        kogakugassanJikofutangaku.setYokunen_01_Tekiyo(entity.getTekiyo101());
    }

    private void setデータSub(KogakugassanJikofutangakuInfoHoseiTempEntity kogakugassanJikofutangaku,
            JissekiFutangakuDataTempEntity entity) {
        if (!RString.isNullOrEmpty(entity.getRealHoseiJissiYMD())) {
            kogakugassanJikofutangaku.setRealHoseiJissiYMD(new FlexibleDate(entity.getRealHoseiJissiYMD()));
        }
        kogakugassanJikofutangaku.setRirekiNo1(entity.getRirekiNo());
        kogakugassanJikofutangaku.setRirekiNo2(Integer.parseInt(entity.getRirekiNo2().toString()));
        kogakugassanJikofutangaku.setSaisoFlag(entity.getSaisoFlag());
        if (!RString.isNullOrEmpty(entity.getSeibetsuCode())) {
            kogakugassanJikofutangaku.setSeibetsuCode(new Code(entity.getSeibetsuCode()));
        }
        kogakugassanJikofutangaku.setSeiriNo(entity.getSeiriNo());
        kogakugassanJikofutangaku.setShiharaiBasho(entity.getShiharaiBasho());
        if (!RString.isNullOrEmpty(entity.getShiharaiShuryoYMD())) {
            kogakugassanJikofutangaku.setShiharaiShuryoYMD(new FlexibleDate(entity.getShiharaiShuryoYMD()));
        }
        kogakugassanJikofutangaku.setShiharaiShuryoTime(entity.getShiharaiShuryoYMDJikan());
        kogakugassanJikofutangaku.setShiharaiShuryoYMD_Yoobi(entity.getShiharaiShuryoYMDYobi());
        if (!RString.isNullOrEmpty(entity.getShikaraiKaishiYMD())) {
            kogakugassanJikofutangaku.setShikaraiKaishiYMD(new FlexibleDate(entity.getShikaraiKaishiYMD()));
        }
        kogakugassanJikofutangaku.setShiharaiKaishiTime(entity.getShikaraiKaishiYMDJikan());
        kogakugassanJikofutangaku.setShikaraiKaishiYMD_Yoobi(entity.getShikaraiKaishiYMDYobi());
        kogakugassanJikofutangaku.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        if (!RString.isNullOrEmpty(entity.getShinseiYMD())) {
            kogakugassanJikofutangaku.setShinseiYMD(new FlexibleDate(entity.getShinseiYMD()));
        }
        kogakugassanJikofutangaku.setShinseiYMDShiteiMikeisanKubun(entity.getShinseibiMikeisanKubun());
        kogakugassanJikofutangaku.setJikoFutangakuShomeishoRealHakkoFlag(entity.getShomeiShoHakoflag());
        if (!RString.isNullOrEmpty(entity.getShomeiShoSakuseiYMD())) {
            kogakugassanJikofutangaku.setShomeiShoSakuseiYMD(new FlexibleDate(entity.getShomeiShoSakuseiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getShomeisho_UketoriYM())) {
            kogakugassanJikofutangaku.setShomeisho_UketoriYM(new FlexibleYearMonth(entity.getShomeisho_UketoriYM()));
        }
        kogakugassanJikofutangaku.setTounen_04_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku004());
        kogakugassanJikofutangaku.setTounen_05_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku005());
        kogakugassanJikofutangaku.setTounen_06_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku006());
        kogakugassanJikofutangaku.setTounen_07_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku007());
        kogakugassanJikofutangaku.setTounen_08_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku008());
        kogakugassanJikofutangaku.setTounen_09_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku009());
        kogakugassanJikofutangaku.setTounen_10_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku010());
        kogakugassanJikofutangaku.setTounen_11_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku011());
        kogakugassanJikofutangaku.setTounen_12_sumi_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku012());
        kogakugassanJikofutangaku.setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku101());
        kogakugassanJikofutangaku.setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku102());
        kogakugassanJikofutangaku.setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku103());
        kogakugassanJikofutangaku.setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku104());
        kogakugassanJikofutangaku.setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku105());
        kogakugassanJikofutangaku.setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku106());
        kogakugassanJikofutangaku.setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getSumi_70_74KogakuShikyuGaku107());
        kogakugassanJikofutangaku.setTounen_04_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku004());
        kogakugassanJikofutangaku.setTounen_05_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku005());
        kogakugassanJikofutangaku.setTounen_06_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku006());
        kogakugassanJikofutangaku.setTounen_07_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku007());
        kogakugassanJikofutangaku.setTounen_08_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku008());
        kogakugassanJikofutangaku.setTounen_09_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku009());
        kogakugassanJikofutangaku.setTounen_10_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku010());
        kogakugassanJikofutangaku.setTounen_11_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku011());
        kogakugassanJikofutangaku.setTounen_12_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku012());
        kogakugassanJikofutangaku.setYokunen_01_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku101());
        kogakugassanJikofutangaku.setYokunen_02_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku102());
        kogakugassanJikofutangaku.setYokunen_03_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku103());
        kogakugassanJikofutangaku.setYokunen_04_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku104());
        kogakugassanJikofutangaku.setYokunen_05_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku105());
        kogakugassanJikofutangaku.setYokunen_06_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku106());
        kogakugassanJikofutangaku.setYokunen_07_sumi_JikoFutanGaku(entity.getSumi_JikoFutanGaku107());
        kogakugassanJikofutangaku.setTounen_04_sumi_Tekiyo(entity.getSumi_Tekiyo004());
        kogakugassanJikofutangaku.setTounen_05_sumi_Tekiyo(entity.getSumi_Tekiyo005());
        kogakugassanJikofutangaku.setTounen_06_sumi_Tekiyo(entity.getSumi_Tekiyo006());
        kogakugassanJikofutangaku.setTounen_07_sumi_Tekiyo(entity.getSumi_Tekiyo007());
        kogakugassanJikofutangaku.setTounen_08_sumi_Tekiyo(entity.getSumi_Tekiyo008());
        kogakugassanJikofutangaku.setTounen_09_sumi_Tekiyo(entity.getSumi_Tekiyo009());
        kogakugassanJikofutangaku.setTounen_10_sumi_Tekiyo(entity.getSumi_Tekiyo010());
        kogakugassanJikofutangaku.setTounen_11_sumi_Tekiyo(entity.getSumi_Tekiyo011());
        kogakugassanJikofutangaku.setTounen_12_sumi_Tekiyo(entity.getSumi_Tekiyo012());
        kogakugassanJikofutangaku.setYokunen_01_sumi_Tekiyo(entity.getSumi_Tekiyo101());
        kogakugassanJikofutangaku.setYokunen_02_sumi_Tekiyo(entity.getSumi_Tekiyo102());
        kogakugassanJikofutangaku.setYokunen_03_sumi_Tekiyo(entity.getSumi_Tekiyo103());
        kogakugassanJikofutangaku.setYokunen_04_sumi_Tekiyo(entity.getSumi_Tekiyo104());
        kogakugassanJikofutangaku.setYokunen_05_sumi_Tekiyo(entity.getSumi_Tekiyo105());
        kogakugassanJikofutangaku.setYokunen_06_sumi_Tekiyo(entity.getSumi_Tekiyo106());
        kogakugassanJikofutangaku.setYokunen_07_sumi_Tekiyo(entity.getSumi_Tekiyo107());
        kogakugassanJikofutangaku.setTounen_04_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku004());
        kogakugassanJikofutangaku.setTounen_05_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku005());
        kogakugassanJikofutangaku.setTounen_06_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku006());
        kogakugassanJikofutangaku.setTounen_07_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku007());
        kogakugassanJikofutangaku.setTounen_08_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku008());
        kogakugassanJikofutangaku.setTounen_09_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku009());
        kogakugassanJikofutangaku.setTounen_10_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku010());
        kogakugassanJikofutangaku.setTounen_11_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku011());
        kogakugassanJikofutangaku.setTounen_12_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku012());
        kogakugassanJikofutangaku.setYokunen_01_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku101());
        kogakugassanJikofutangaku.setYokunen_02_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku102());
        kogakugassanJikofutangaku.setYokunen_03_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku103());
        kogakugassanJikofutangaku.setYokunen_04_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku104());
        kogakugassanJikofutangaku.setYokunen_05_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku105());
        kogakugassanJikofutangaku.setYokunen_06_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku106());
        kogakugassanJikofutangaku.setYokunen_07_sumi_under_70KogakuShikyuGaku(entity.getSumi_under_70KogakuShikyuGaku107());
        if (!RString.isNullOrEmpty(entity.getTaishoKeisanKaishiYMD())) {
            kogakugassanJikofutangaku.setTaishoKeisanKaishiYMD(new FlexibleDate(entity.getTaishoKeisanKaishiYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getTaishoKeisanShuryoYMD())) {
            kogakugassanJikofutangaku.setTaishoKeisanShuryoYMD(new FlexibleDate(entity.getTaishoKeisanShuryoYMD()));
        }
        if (!RString.isNullOrEmpty(entity.getTaishoNendo())) {
            kogakugassanJikofutangaku.setTaishoNendo(new FlexibleYear(entity.getTaishoNendo()));
        }
        kogakugassanJikofutangaku.setYokunen_02_Tekiyo(entity.getTekiyo102());
        kogakugassanJikofutangaku.setYokunen_03_Tekiyo(entity.getTekiyo103());
        kogakugassanJikofutangaku.setYokunen_04_Tekiyo(entity.getTekiyo104());
        kogakugassanJikofutangaku.setYokunen_05_Tekiyo(entity.getTekiyo105());
        kogakugassanJikofutangaku.setYokunen_06_Tekiyo(entity.getTekiyo106());
        kogakugassanJikofutangaku.setYokunen_07_Tekiyo(entity.getTekiyo107());
        kogakugassanJikofutangaku.setTounen_04_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku004());
        kogakugassanJikofutangaku.setTounen_05_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku005());
        kogakugassanJikofutangaku.setTounen_06_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku006());
        kogakugassanJikofutangaku.setTounen_07_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku007());
        kogakugassanJikofutangaku.setTounen_08_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku008());
        kogakugassanJikofutangaku.setTounen_09_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku009());
        kogakugassanJikofutangaku.setTounen_10_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku010());
        kogakugassanJikofutangaku.setTounen_11_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku011());
        kogakugassanJikofutangaku.setTounen_12_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku012());
        kogakugassanJikofutangaku.setYokunen_01_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku101());
        kogakugassanJikofutangaku.setYokunen_02_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku102());
        kogakugassanJikofutangaku.setYokunen_03_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku103());
        kogakugassanJikofutangaku.setYokunen_04_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku104());
        kogakugassanJikofutangaku.setYokunen_05_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku105());
        kogakugassanJikofutangaku.setYokunen_06_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku106());
        kogakugassanJikofutangaku.setYokunen_07_Uchisu_70_74JikoFutanGaku(entity.getUchisu_70_74JikoFutanGaku107());
        if (!RString.isNullOrEmpty(entity.getUmareYMD())) {
            kogakugassanJikofutangaku.setUmareYMD(new FlexibleDate(entity.getUmareYMD()));
        }
        kogakugassanJikofutangaku.setTounen_04_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku004());
        kogakugassanJikofutangaku.setTounen_05_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku005());
        kogakugassanJikofutangaku.setTounen_06_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku006());
        kogakugassanJikofutangaku.setTounen_07_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku007());
        kogakugassanJikofutangaku.setTounen_08_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku008());
        kogakugassanJikofutangaku.setTounen_09_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku009());
        kogakugassanJikofutangaku.setTounen_10_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku010());
        kogakugassanJikofutangaku.setTounen_11_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku011());
        kogakugassanJikofutangaku.setTounen_12_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku012());
        kogakugassanJikofutangaku.setYokunen_01_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku101());
        kogakugassanJikofutangaku.setYokunen_02_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku102());
        kogakugassanJikofutangaku.setYokunen_03_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku103());
        kogakugassanJikofutangaku.setYokunen_04_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku104());
        kogakugassanJikofutangaku.setYokunen_05_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku105());
        kogakugassanJikofutangaku.setYokunen_06_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku106());
        kogakugassanJikofutangaku.setYokunen_07_Under_70KogakuShikyuGaku(entity.getUnder_70KogakuShikyuGaku107());
    }
}
