/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額合算情報Insertのprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class KogakuGassanTempInsertProcess extends BatchProcessBase<KogakuGassanJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select高額合算情報");
    private static final RString TABLE_NAME = new RString("KogakuGassanTemp");
    private JikofutanShomeishoProcessParameter parameter;

    @BatchWriter
    IBatchTableWriter tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, KogakuGassanTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanJohoEntity entity) {
        KogakuGassanTempEntity tempEntity = new KogakuGassanTempEntity();
        setTempEntity(entity, tempEntity);
        tableWriter.insert(tempEntity);
    }

    private void setTempEntity(KogakuGassanJohoEntity entity, KogakuGassanTempEntity tempEntity) {
        tempEntity.setHihokenshaNo(entity.get高額合算申請書().getHihokenshaNo());
        tempEntity.setTaishoNendo(entity.get高額合算申請書().getTaishoNendo());
        tempEntity.setHokenshaNo(entity.get高額合算自己負担額().getHokenshaNo());
        tempEntity.setSeiriNo(entity.get高額合算申請書().getSeiriNo());
        tempEntity.setRirekiNo(entity.get高額合算申請書().getRirekiNo());
        tempEntity.setShinseiJokyoKubun(entity.get高額合算申請書().getShinseiJokyoKubun());
        tempEntity.setShinseiYMD(entity.get高額合算申請書().getShinseiYMD());
        tempEntity.setShikyuShinseishoSeiriNo(entity.get高額合算申請書().getShikyuShinseishoSeiriNo());
        tempEntity.setKokuhoShikyuShinseishoSeiriNo(entity.get高額合算申請書().getKokuhoShikyuShinseishoSeiriNo());
        tempEntity.setShikyuShinseiKubun(entity.get高額合算申請書().getShikyuShinseiKubun());
        tempEntity.setTaishoKeisanKaishiYMD(entity.get高額合算申請書().getTaishoKeisanKaishiYMD());
        tempEntity.setTaishoKeisanShuryoYMD(entity.get高額合算申請書().getTaishoKeisanShuryoYMD());
        tempEntity.setShikyuShinseiKeitai(entity.get高額合算申請書().getShikyuShinseiKeitai());
        tempEntity.setJikoFutanKofuUmu(entity.get高額合算申請書().getJikoFutanKofuUmu());
        tempEntity.setShinseiDaihyoshaShimei(entity.get高額合算申請書().getShinseiDaihyoshaShimei());
        tempEntity.setShinseiDaihyoshaYubinNo(entity.get高額合算申請書().getShinseiDaihyoshaYubinNo());
        tempEntity.setShinseiDaihyoshaJusho(entity.get高額合算申請書().getShinseiDaihyoshaJusho());
        tempEntity.setShinseiDaihyoshaTelNo(entity.get高額合算申請書().getShinseiDaihyoshaTelNo());
        tempEntity.setShotokuKubun(entity.get高額合算申請書().getShotokuKubun());
        tempEntity.setOver70_ShotokuKubun(entity.get高額合算申請書().getOver70_ShotokuKubun());
        tempEntity.setShikakuSoshitsuYMD(entity.get高額合算申請書().getShikakuSoshitsuYMD());
        tempEntity.setShikakuSoshitsuJiyu(entity.get高額合算申請書().getShikakuSoshitsuJiyu());
        tempEntity.setKanyuKaishiYMD(entity.get高額合算申請書().getKanyuKaishiYMD());
        tempEntity.setKanyuShuryoYMD(entity.get高額合算申請書().getKanyuShuryoYMD());
        tempEntity.setKokuho_HokenshaNo(entity.get高額合算申請書().getKokuho_HokenshaNo());
        tempEntity.setKokuho_HokenshaMeisho(entity.get高額合算申請書().getKokuho_HokenshaMeisho());
        tempEntity.setKokuho_HihokenshaShoKigo(entity.get高額合算申請書().getKokuho_HihokenshaShoKigo());
        tempEntity.setKokuho_HihokenshaShoNo(entity.get高額合算申請書().getKokuho_HihokenshaShoNo());
        tempEntity.setKokuho_SetaiNo(entity.get高額合算申請書().getKokuho_SetaiNo());
        tempEntity.setKokuho_Zokugara(entity.get高額合算申請書().getKokuho_Zokugara());
        tempEntity.setKokuho_KanyuKaishiYMD(entity.get高額合算申請書().getKokuho_KanyuKaishiYMD());
        tempEntity.setKokuho_KanyuShuryoYMD(entity.get高額合算申請書().getKokuho_KanyuShuryoYMD());
        tempEntity.setKoki_HokenshaNo(entity.get高額合算申請書().getKoki_HokenshaNo());
        tempEntity.setKoki_KoikiRengoMeisho(entity.get高額合算申請書().getKoki_KoikiRengoMeisho());
        tempEntity.setKoki_HihokenshaNo(entity.get高額合算申請書().getKoki_HihokenshaNo());
        tempEntity.setKoki_KanyuKaishiYMD(entity.get高額合算申請書().getKoki_KanyuKaishiYMD());
        tempEntity.setKoki_KanyuShuryoYMD(entity.get高額合算申請書().getKoki_KanyuShuryoYMD());
        tempEntity.setShiharaiHohoKubun(entity.get高額合算申請書().getShiharaiHohoKubun());
        tempEntity.setShiharaiBasho(entity.get高額合算申請書().getShiharaiBasho());
        tempEntity.setShiharaiKaishiYMD(entity.get高額合算申請書().getShiharaiKaishiYMD());
        tempEntity.setShiharaiShuryoYMD(entity.get高額合算申請書().getShiharaiShuryoYMD());
        tempEntity.setHeichoNaiyo(entity.get高額合算申請書().getHeichoNaiyo());
        tempEntity.setShiharaiKaishiTime(entity.get高額合算申請書().getShiharaiKaishiTime());
        tempEntity.setShiharaiShuryoTime(entity.get高額合算申請書().getShiharaiShuryoTime());
        tempEntity.setKozaID(entity.get高額合算申請書().getKozaID());
        tempEntity.setBiko(entity.get高額合算申請書().getBiko());
        tempEntity.setShikyuShinseisho_SofuYM(entity.get高額合算申請書().getShikyuShinseisho_SofuYM());
        tempEntity.setSaiSofuFlag(entity.get高額合算申請書().getSaiSofuFlag());
        tempEntity.setJikoFutan_KeisanYM(entity.get高額合算申請書().getJikoFutan_KeisanYM());
        tempEntity.setSaiKeisanKubun(entity.get高額合算申請書().getSaiKeisanKubun());

        tempEntity.setJikoFutanGaku_RirekiNo(entity.get高額合算自己負担額().getRirekiNo());
        tempEntity.setJikoFutanGaku_HokenSeidoCode(entity.get高額合算自己負担額().getHokenSeidoCode());
        tempEntity.setJikoFutanGaku_HokenshaMei(entity.get高額合算自己負担額().getHokenshaMei());
        tempEntity.setJikoFutanGaku_Kokuho_HihokenshaShoKigo(entity.get高額合算自己負担額().getKokuho_HihokenshaShoKigo());
        tempEntity.setJikoFutanGaku_HihokenshaShimeiKana(entity.get高額合算自己負担額().getHihokenshaShimeiKana());
        tempEntity.setJikoFutanGaku_HihokenshaShimei(entity.get高額合算自己負担額().getHihokenshaShimei());
        tempEntity.setJikoFutanGaku_UmareYMD(entity.get高額合算自己負担額().getUmareYMD());
        tempEntity.setJikoFutanGaku_SeibetsuCode(entity.get高額合算自己負担額().getSeibetsuCode());
        tempEntity.setJikoFutanGaku_ShotokuKubun(entity.get高額合算自己負担額().getShotokuKubun());
        tempEntity.setJikoFutanGaku_Over70_ShotokuKubun(entity.get高額合算自己負担額().getOver70_ShotokuKubun());
        tempEntity.setJikoFutanGaku_JikoFutanSeiriNo(entity.get高額合算自己負担額().getJikoFutanSeiriNo());
        tempEntity.setJikoFutanGaku_Koki_HokenshaNo(entity.get高額合算自己負担額().getKoki_HokenshaNo());
        tempEntity.setJikoFutanGaku_Koki_HihokenshaNo(entity.get高額合算自己負担額().getKoki_HihokenshaNo());
        tempEntity.setJikoFutanGaku_Kokuho_HokenshaNo(entity.get高額合算自己負担額().getKokuho_HokenshaNo());
        tempEntity.setJikoFutanGaku_Kokuho_HihokenshaShoNo(entity.get高額合算自己負担額().getKokuho_HihokenshaShoNo());
        tempEntity.setJikoFutanGaku_Kokuho_KojinNo(entity.get高額合算自己負担額().getKokuho_KojinNo());
        tempEntity.setJikoFutanGaku_IdoKubun(entity.get高額合算自己負担額().getIdoKubun());
        tempEntity.setJikoFutanGaku_HoseiZumiSofuKubun(entity.get高額合算自己負担額().getHoseiZumiSofuKubun());
        tempEntity.setJikoFutanGaku_TaishoKeisanKaishiYMD(entity.get高額合算自己負担額().getTaishoKeisanKaishiYMD());
        tempEntity.setJikoFutanGaku_TaishoKeisanShuryoYMD(entity.get高額合算自己負担額().getTaishoKeisanShuryoYMD());
        tempEntity.setJikoFutanGaku_HihokenshaKaishiYMD(entity.get高額合算自己負担額().getHihokenshaKaishiYMD());
        tempEntity.setJikoFutanGaku_HihokenshaShuryoYMD(entity.get高額合算自己負担額().getHihokenshaShuryoYMD());
        tempEntity.setJikoFutanGaku_ShinseiYMD(entity.get高額合算自己負担額().getShinseiYMD());
        tempEntity.setJikoFutanGaku_Gokei_JikoFutanGaku(entity.get高額合算自己負担額().getGokei_JikoFutanGaku());
        tempEntity.setJikoFutanGaku_Gokei_70_74JikoFutanGaku(entity.get高額合算自己負担額().getGokei_70_74JikoFutanGaku());
        tempEntity.setJikoFutanGaku_Gokei_Under70KogakuShikyuGaku(entity.get高額合算自己負担額().getGokei_Under70KogakuShikyuGaku());
        tempEntity.setJikoFutanGaku_Gokei_70_74KogakuShikyuGaku(entity.get高額合算自己負担額().getGokei_70_74KogakuShikyuGaku());
        tempEntity.setJikoFutanGaku_Sumi_Gokei_JikoFutanGaku(entity.get高額合算自己負担額().getSumi_Gokei_JikoFutanGaku());
        tempEntity.setJikoFutanGaku_Sumi_Gokei_70_74JikoFutanGaku(entity.get高額合算自己負担額().getSumi_Gokei_70_74JikoFutanGaku());
        tempEntity.setJikoFutanGaku_Sumi_Gokei_Under70KogakuShikyuGaku(entity.get高額合算自己負担額().getSumi_Gokei_Under70KogakuShikyuGaku());
        tempEntity.setJikoFutanGaku_Sumi_Gokei_70_74KogakuShikyuGaku(entity.get高額合算自己負担額().getSumi_Gokei_70_74KogakuShikyuGaku());
        tempEntity.setJikoFutanGaku_AtesakiShimei(entity.get高額合算自己負担額().getAtesakiShimei());
        tempEntity.setJikoFutanGaku_AtesakiYubinNo(entity.get高額合算自己負担額().getAtesakiYubinNo());
        tempEntity.setJikoFutanGaku_AtesakiJusho(entity.get高額合算自己負担額().getAtesakiJusho());
        tempEntity.setJikoFutanGaku_Madoguchi_TaishoshaHanteiCode(entity.get高額合算自己負担額().getMadoguchi_TaishoshaHanteiCode());
        tempEntity.setJikoFutanGaku_ShiharaiBasho(entity.get高額合算自己負担額().getShiharaiBasho());
        tempEntity.setJikoFutanGaku_ShikaraiKaishiYMD(entity.get高額合算自己負担額().getShikaraiKaishiYMD());
        tempEntity.setJikoFutanGaku_ShiharaiShuryoYMD(entity.get高額合算自己負担額().getShiharaiShuryoYMD());
        tempEntity.setJikoFutanGaku_HeichoNaiyo(entity.get高額合算自己負担額().getHeichoNaiyo());
        tempEntity.setJikoFutanGaku_ShiharaiKaishiTime(entity.get高額合算自己負担額().getShiharaiKaishiTime());
        tempEntity.setJikoFutanGaku_ShiharaiShuryoTime(entity.get高額合算自己負担額().getShiharaiShuryoTime());
        tempEntity.setJikoFutanGaku_Biko(entity.get高額合算自己負担額().getBiko());
        tempEntity.setJikoFutanGaku_DataSakuseiKubun(entity.get高額合算自己負担額().getDataSakuseiKubun());
        tempEntity.setJikoFutanGaku_Kakunin_UketoriYM(entity.get高額合算自己負担額().getKakunin_UketoriYM());
        tempEntity.setJikoFutanGaku_HoseiZumi_SofuYM(entity.get高額合算自己負担額().getHoseiZumi_SofuYM());
        tempEntity.setJikoFutanGaku_Shomeisho_UketoriYM(entity.get高額合算自己負担額().getShomeisho_UketoriYM());
        tempEntity.setJikoFutanGaku_SaisoFlag(entity.get高額合算自己負担額().getSaisoFlag());
        tempEntity.setJikoFutanGaku_SofuTaishoGaiFlag(entity.get高額合算自己負担額().getSofuTaishoGaiFlag());
        tempEntity.setJikoFutanGaku_JikoFutanKeisanYMD(entity.get高額合算自己負担額().getJikoFutanKeisanYMD());
        tempEntity.setJikoFutanGaku_ShomeiShoSakuseiYMD(entity.get高額合算自己負担額().getShomeiShoSakuseiYMD());
        tempEntity.setJikoFutanGaku_Koki_KokuhoShoriKubun(entity.get高額合算自己負担額().getKoki_KokuhoShoriKubun());
    }
}
