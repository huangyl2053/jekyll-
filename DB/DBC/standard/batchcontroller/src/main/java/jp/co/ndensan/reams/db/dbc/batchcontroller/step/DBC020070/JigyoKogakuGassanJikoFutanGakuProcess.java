/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算自己負担額のデータを取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class JigyoKogakuGassanJikoFutanGakuProcess extends BatchProcessBase<ShikyugakuCalcTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get事業高額合算自己負担額");
    private static final RString 区分3 = new RString(3);

    private static final RString TABLE_NAME = new RString("ShikyugakuCalcTemp");

    private HihokenshaNo 被保険者番号;
    private int 連番 = 0;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuCalcTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuCalcTempRelateEntity entity) {
        連番 = 連番 + 1;
        ShikyugakuCalcTempEntity tempEntity = new ShikyugakuCalcTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setTaishoNendo(entity.getTaishoNendo());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setKubun(区分3);
        if (entity.get負担額().getHihokenshaNo().equals(被保険者番号)) {
            tempEntity.setMeisaiNo(new RString(連番));
        } else {
            連番 = 1;
            tempEntity.setMeisaiNo(new RString(連番));
        }
        tempEntity.setMeisaiHihokenshaNo(entity.get負担額().getHihokenshaNo());
        tempEntity.setFutangaku_hihokenshaNo(entity.get負担額().getHihokenshaNo());
        tempEntity.setFutangaku_taishoNendo(entity.get負担額().getTaishoNendo());
        tempEntity.setFutangaku_hokenshaNo(entity.get負担額().getHokenshaNo());
        tempEntity.setFutangaku_shikyuShinseishoSeiriNo(entity.get負担額().getShikyuShinseishoSeiriNo());
        tempEntity.setFutangaku_rirekiNo(entity.get負担額().getRirekiNo());
        tempEntity.setFutangaku_hokenSeidoCode(entity.get負担額().getHokenSeidoCode());
        tempEntity.setFutangaku_hokenshaMei(entity.get負担額().getHokenshaMei());
        tempEntity.setFutangaku_kokuho_HihokenshaShoKigo(entity.get負担額().getKokuho_HihokenshaShoKigo());
        tempEntity.setFutangaku_hihokenshaShimeiKana(entity.get負担額().getHihokenshaShimeiKana());
        tempEntity.setFutangaku_hihokenshaShimei(entity.get負担額().getHihokenshaShimei());
        tempEntity.setFutangaku_umareYMD(entity.get負担額().getUmareYMD());
        tempEntity.setFutangaku_seibetsuCode(entity.get負担額().getSeibetsuCode());
        tempEntity.setFutangaku_shotokuKubun(entity.get負担額().getShotokuKubun());
        tempEntity.setFutangaku_over70_ShotokuKubun(entity.get負担額().getOver70_ShotokuKubun());
        tempEntity.setFutangaku_jikoFutanSeiriNo(entity.get負担額().getJikoFutanSeiriNo());
        tempEntity.setFutangaku_koki_HokenshaNo(entity.get負担額().getKoki_HokenshaNo());
        tempEntity.setFutangaku_koki_HihokenshaNo(entity.get負担額().getKoki_HihokenshaNo());
        tempEntity.setFutangaku_kokuho_HokenshaNo(entity.get負担額().getKokuho_HokenshaNo());
        tempEntity.setFutangaku_kokuho_HihokenshaShoNo(entity.get負担額().getKokuho_HihokenshaShoNo());
        tempEntity.setFutangaku_kokuho_KojinNo(entity.get負担額().getKokuho_KojinNo());
        tempEntity.setFutangaku_idoKubun(entity.get負担額().getIdoKubun());
        tempEntity.setFutangaku_hoseiZumiSofuKubun(entity.get負担額().getHoseiZumiSofuKubun());
        tempEntity.setFutangaku_taishoKeisanKaishiYMD(entity.get負担額().getTaishoKeisanKaishiYMD());
        tempEntity.setFutangaku_taishoKeisanShuryoYMD(entity.get負担額().getTaishoKeisanShuryoYMD());
        tempEntity.setFutangaku_hihokenshaKaishiYMD(entity.get負担額().getHihokenshaKaishiYMD());
        tempEntity.setFutangaku_hihokenshaShuryoYMD(entity.get負担額().getHihokenshaShuryoYMD());
        tempEntity.setFutangaku_shinseiYMD(entity.get負担額().getShinseiYMD());
        tempEntity.setFutangaku_gokei_JikoFutanGaku(entity.get負担額().getGokei_JikoFutanGaku());
        tempEntity.setFutangaku_gokei_70_74JikoFutanGaku(entity.get負担額().getGokei_70_74JikoFutanGaku());
        tempEntity.setFutangaku_gokei_Under70KogakuShikyuGaku(entity.get負担額().getGokei_Under70KogakuShikyuGaku());
        tempEntity.setFutangaku_gokei_70_74KogakuShikyuGaku(entity.get負担額().getGokei_70_74KogakuShikyuGaku());
        tempEntity.setFutangaku_sumi_Gokei_JikoFutanGaku(entity.get負担額().getSumi_Gokei_JikoFutanGaku());
        tempEntity.setFutangaku_sumi_Gokei_70_74JikoFutanGaku(entity.get負担額().getSumi_Gokei_70_74JikoFutanGaku());
        tempEntity.setFutangaku_sumi_Gokei_Under70KogakuShikyuGaku(entity.get負担額().getSumi_Gokei_Under70KogakuShikyuGaku());
        tempEntity.setFutangaku_sumi_Gokei_70_74KogakuShikyuGaku(entity.get負担額().getSumi_Gokei_70_74KogakuShikyuGaku());
        tempEntity.setFutangaku_atesakiShimei(entity.get負担額().getAtesakiShimei());
        tempEntity.setFutangaku_atesakiYubinNo(entity.get負担額().getAtesakiYubinNo());
        tempEntity.setFutangaku_atesakiJusho(entity.get負担額().getAtesakiJusho());
        tempEntity.setFutangaku_madoguchi_TaishoshaHanteiCode(entity.get負担額().getMadoguchi_TaishoshaHanteiCode());
        tempEntity.setFutangaku_shiharaiBasho(entity.get負担額().getShiharaiBasho());
        tempEntity.setFutangaku_shikaraiKaishiYMD(entity.get負担額().getShikaraiKaishiYMD());
        tempEntity.setFutangaku_shiharaiShuryoYMD(entity.get負担額().getShiharaiShuryoYMD());
        tempEntity.setFutangaku_heichoNaiyo(entity.get負担額().getHeichoNaiyo());
        tempEntity.setFutangaku_shiharaiKaishiTime(entity.get負担額().getShiharaiKaishiTime());
        tempEntity.setFutangaku_shiharaiShuryoTime(entity.get負担額().getShiharaiShuryoTime());
        tempEntity.setFutangaku_biko(entity.get負担額().getBiko());
        tempEntity.setFutangaku_dataSakuseiKubun(entity.get負担額().getDataSakuseiKubun());
        tempEntity.setFutangaku_kakunin_UketoriYM(entity.get負担額().getKakunin_UketoriYM());
        tempEntity.setFutangaku_hoseiZumi_SofuYM(entity.get負担額().getHoseiZumi_SofuYM());
        tempEntity.setFutangaku_shomeisho_UketoriYM(entity.get負担額().getShomeisho_UketoriYM());
        tempEntity.setFutangaku_saisoFlag(entity.get負担額().getSaisoFlag());
        tempEntity.setFutangaku_sofuTaishoGaiFlag(entity.get負担額().getSofuTaishoGaiFlag());
        tempEntity.setFutangaku_jikoFutanKeisanYMD(entity.get負担額().getJikoFutanKeisanYMD());
        tempEntity.setFutangaku_shomeiShoSakuseiYMD(entity.get負担額().getShomeiShoSakuseiYMD());
        tempEntity.setFutangaku_koki_KokuhoShoriKubun(entity.get負担額().getKoki_KokuhoShoriKubun());
        tempEntity.setFutangaku_jikoFutangakuShomeishoRealHakkoFlag(entity.get負担額().getJikoFutangakuShomeishoRealHakkoFlag());
        tempEntity.setFutangaku_batchHoseiJissiYMD(entity.get負担額().getBatchHoseiJissiYMD());
        tempEntity.setFutangaku_realHoseiJissiYMD(entity.get負担額().getRealHoseiJissiYMD());
        tempEntity.setFutangaku_shoumeishoyouDataKubun(entity.get負担額().getShoumeishoyouDataKubun());
        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }
}
