/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 更新用一時の情報をマスタにINSERTする処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class UpdateMasterTableProcess extends BatchProcessBase<ShikyugakuUpdateTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get更新用一時の情報");
    private static final RString 区分１ = new RString("1");

    @BatchWriter
    private BatchPermanentTableWriter<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> 結果Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 結果明細Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> 支給不支給Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        結果Writer = new BatchPermanentTableWriter<>(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
        結果明細Writer = new BatchPermanentTableWriter<>(DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class);
        支給不支給Writer = new BatchPermanentTableWriter<>(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempEntity entity) {
        if (区分１.equals(entity.getKubun())) {
            DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity 結果 = new DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity();
            結果.setHihokenshaNo(entity.getShikyugaku_hihokenshaNo());
            結果.setTaishoNendo(entity.getShikyugaku_taishoNendo());
            結果.setShoKisaiHokenshaNo(entity.getShikyugaku_shoKisaiHokenshaNo());
            結果.setShikyuShinseishoSeiriNo(entity.getShikyugaku_shikyuShinseishoSeiriNo());
            結果.setRirekiNo(entity.getShikyugaku_rirekiNo());
            結果.setHokenSeidoCode(entity.getShikyugaku_hokenSeidoCode());
            結果.setJikoFutanSeiriNo(entity.getShikyugaku_jikoFutanSeiriNo());
            結果.setTaishoKeisanKaishiYMD(entity.getShikyugaku_taishoKeisanKaishiYMD());
            結果.setTaishoKeisanShuryoYMD(entity.getShikyugaku_taishoKeisanShuryoYMD());
            結果.setSetaiFutanSogaku(entity.getShikyugaku_setaiFutanSogaku());
            結果.setSetaiGassanGaku(entity.getShikyugaku_setaiGassanGaku());
            結果.setOver70_SetaiGassanGaku(entity.getShikyugaku_over70_SetaiGassanGaku());
            結果.setShotokuKubun(entity.getShikyugaku_shotokuKubun());
            結果.setOver70_ShotokuKubun(entity.getShikyugaku_over70_ShotokuKubun());
            結果.setSanteiKijunGaku(entity.getShikyugaku_santeiKijunGaku());
            結果.setOver70_SanteiKijyunGaku(entity.getShikyugaku_over70_SanteiKijyunGaku());
            結果.setSetaiShikyuSogaku(entity.getShikyugaku_setaiShikyuSogaku());
            結果.setOver70_SetaiShikyuSogaku(entity.getShikyugaku_over70_SetaiShikyuSogaku());
            結果.setHonninShikyugaku(entity.getShikyugaku_honninShikyugaku());
            結果.setOver70_honninShikyugaku(entity.getShikyugaku_over70_honninShikyugaku());
            結果.setTeiShotoku_1_SaiKeisanUmu(entity.getShikyugaku_teiShotoku_1_SaiKeisanUmu());
            結果.setBiko(entity.getShikyugaku_biko());
            結果.setKekkaRenrakusakiJusho(entity.getShikyugaku_kekkaRenrakusakiJusho());
            結果.setKekkaRenrakusakiYubinNo(entity.getShikyugaku_kekkaRenrakusakiYubinNo());
            結果.setKetteRenrakusakiMeisho1(entity.getShikyugaku_kettaRenrakusakiMeisho1());
            結果.setKekkaRenrakusakiMeisho2(entity.getShikyugaku_kekkaRenrakusakiMeisho2());
            結果.setTsuchiYMD(entity.getShikyugaku_tsuchiYMD());
            結果.setRenrakuhyoHakkoshaMei(entity.getShikyugaku_renrakuhyoHakkoshaMei());
            結果.setRenrakuhyoHakkoshaYubinNo(entity.getShikyugaku_renrakuhyoHakkoshaYubinNo());
            結果.setRenrakuhyoHakkoshaJusho(entity.getShikyugaku_renrakuhyoHakkoshaJusho());
            結果.setToiawasesakiJusho(entity.getShikyugaku_toiawasesakiJusho());
            結果.setToiawasesakiTelNo(entity.getShikyugaku_toiawasesakiTelNo());
            結果.setToiawasesakiYobinNo(entity.getShikyugaku_toiawasesakiYobinNo());
            結果.setToiawasesakiMeisho1(entity.getShikyugaku_toiawasesakiMeisho1());
            結果.setToiawasesakiMeisho2(entity.getShikyugaku_toiawasesakiMeisho2());
            結果.setOver70_FutangakuGokei(entity.getShikyugaku_over70_FutangakuGokei());
            結果.setOver70_ShikyugakuGokei(entity.getShikyugaku_over70_ShikyugakuGokei());
            結果.setUnder70_FutangakuGokei(entity.getShikyugaku_under70_FutangakuGokei());
            結果.setFutangakuGokei(entity.getShikyugaku_futangakuGokei());
            結果.setUnder70_ShikyugakuGokei(entity.getShikyugaku_under70_ShikyugakuGokei());
            結果.setShikyugakuGokei(entity.getShikyugaku_shikyugakuGokei());
            結果.setDataKubun(entity.getShikyugaku_dataKubun());
            結果.setUketoriYM(entity.getShikyugaku_uketoriYM());
            結果.setSofuYM(entity.getShikyugaku_sofuYM());
            結果.setSaisoFG(entity.getShikyugaku_saisoFG());
            結果.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getShikyugaku_sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
            結果.setState(EntityDataState.Added);
            結果Writer.insert(結果);
            // TODO QA1632
            if (entity.getKettei_hihokenshaNo() == null || entity.getKettei_hihokenshaNo().isEmpty()) {
                return;
            }
            DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 支給不支給 = new DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity();
            支給不支給.setHihokenshaNo(entity.getKettei_hihokenshaNo());
            支給不支給.setTaishoNendo(entity.getKettei_taishoNendo());
            支給不支給.setHokenshaNo(entity.getKettei_hokenshaNo());
            支給不支給.setShikyuSeiriNo(entity.getKettei_shikyuShinseishoSeiriNo());
            支給不支給.setRirekiNo(entity.getKettei_rirekiNo());
            支給不支給.setJikoFutanSeiriNo(entity.getKettei_jikoFutanSeiriNo());
            支給不支給.setHokenSeidoCode(entity.getKettei_hokenSeidoCode());
            支給不支給.setKokuho_HihokenshaShoKigo(entity.getKettei_kokuho_HihokenshaShoKigo());
            支給不支給.setKeisanKaishiYMD(entity.getKettei_taishoKeisanKaishiYMD());
            支給不支給.setKeisanShuryoYMD(entity.getKettei_taishoKeisanShuryoYMD());
            支給不支給.setShinseiYMD(entity.getKettei_shinseiYMD());
            支給不支給.setKetteiYMD(entity.getKettei_ketteiYMD());
            支給不支給.setJikoFutanSogaku(entity.getKettei_jikoFutanSogaku());
            支給不支給.setShikyuKubunCode(entity.getKettei_shikyuKubun());
            支給不支給.setShikyugaku(entity.getKettei_shikyugaku());
            支給不支給.setKyufuShurui(entity.getKettei_kyufuShurui());
            支給不支給.setFushikyuRiyu(entity.getKettei_fushikyuRiyu());
            支給不支給.setBiko(entity.getKettei_biko());
            支給不支給.setShiharaiHohoKubun(entity.getKettei_shiharaiHohoKubun());
            支給不支給.setShiharaiBasho(entity.getKettei_shiharaiBasho());
            支給不支給.setShiharaiKaishiYMD(entity.getKettei_shiharaikikanKaishiYMD());
            支給不支給.setShiharaiShuryoTime(entity.getKettei_shiharaikikanShuryoTime());
            支給不支給.setShiharaiKaishiTime(entity.getKettei_shiharaikikanKaishiTime());
            支給不支給.setShiharaiShuryoYMD(entity.getKettei_shiharaikikanShuryoYMD());
            支給不支給.setHeichoNaiyo(entity.getKettei_heichoNaiyo());
            支給不支給.setKetteiTsuchiSakuseiYMD(entity.getKettei_ketteiTsuchishoSakuseiYMD());
            支給不支給.setFurikomiTsuchiSakuseiYMD(entity.getKettei_hurikomiTsuchishoSakuseiYMD());
            支給不支給.setUketoriYM(entity.getKettei_uketoriYM());
            支給不支給.setKozaid(entity.getKettei_kozaID());
            支給不支給.setDataSakuseiKubun(entity.getKettei_dataSakuseiKubun());
            支給不支給.setState(EntityDataState.Added);
            支給不支給Writer.insert(支給不支給);
        } else {
            DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity 結果明細 = new DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            結果明細.setHihokenshaNo(entity.getShikyugakuMeisai_hihokenshaNo());
            結果明細.setTaishoNendo(entity.getShikyugakuMeisai_taishoNendo());
            結果明細.setShoKisaiHokenshaNo(entity.getShikyugakuMeisai_shoKisaiHokenshaNo());
            結果明細.setShikyuShinseishoSeiriNo(entity.getShikyugakuMeisai_shikyuShinseishoSeiriNo());
            結果明細.setMeisanNo(entity.getShikyugakuMeisai_meisanNo());
            結果明細.setRirekiNo(entity.getShikyugakuMeisai_rirekiNo());
            結果明細.setHokenSeidoCode(entity.getShikyugakuMeisai_hokenSeidoCode());
            結果明細.setUchiwakeHokenshaNo(entity.getShikyugakuMeisai_uchiwakeHokenshaNo());
            結果明細.setKokuho_HihokenshaShoKigo(entity.getShikyugakuMeisai_kokuho_HihokenshaShoKigo());
            結果明細.setHiHokenshaShoNo(entity.getShikyugakuMeisai_hiHokenshaShoNo());
            結果明細.setUchiwakeHokenshaMei(entity.getShikyugakuMeisai_uchiwakeHokenshaMei());
            結果明細.setJikoFutanSeiriNo(entity.getShikyugakuMeisai_jikoFutanSeiriNo());
            結果明細.setTaishoshaShimei(entity.getShikyugakuMeisai_taishoshaShimei());
            結果明細.setOver70_Futangaku(entity.getShikyugakuMeisai_over70_Futangaku());
            結果明細.setOver70_AmbunRitsu(entity.getShikyugakuMeisai_over70_AmbunRitsu());
            結果明細.setOver70_Shikyugaku(entity.getShikyugakuMeisai_over70_Shikyugaku());
            結果明細.setUnder70_Futangaku(entity.getShikyugakuMeisai_under70_Futangaku());
            結果明細.setFutangaku(entity.getShikyugakuMeisai_futangaku());
            結果明細.setAmbunRitsu(entity.getShikyugakuMeisai_ambunRitsu());
            結果明細.setUnder70_Shikyugaku(entity.getShikyugakuMeisai_under70_Shikyugaku());
            結果明細.setShikyugaku(entity.getShikyugakuMeisai_shikyugaku());
            結果明細.setOver70_Biko(entity.getShikyugakuMeisai_over70_Biko());
            結果明細.setUnder70_Biko(entity.getShikyugakuMeisai_under70_Biko());
            結果明細.setDataKubun(entity.getShikyugakuMeisai_dataKubun());
            結果明細.setUketoriYM(entity.getShikyugakuMeisai_uketoriYM());
            結果明細.setSofuYM(entity.getShikyugakuMeisai_sofuYM());
            結果明細.setState(EntityDataState.Added);
            結果明細Writer.insert(結果明細);
        }
    }
}
