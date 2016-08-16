/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.JikyoKogakuKaigoServiceHiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護申請管理マスタにデータを保存します。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoKogakuShinseikanriMasterUpdateProcess extends BatchProcessBase<JikyoKogakuKaigoServiceHiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get事業高額介護申請管理マスタのデータ");
    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity> dbt3109Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3110JigyoKogakuShikyuShinseiEntity> dbt3110Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> dbt3111Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3112KogakuShikyuShinsaKetteiEntity> dbt3112Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        dbt3109Writer = new BatchPermanentTableWriter<>(DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        dbt3110Writer = new BatchPermanentTableWriter<>(DbT3110JigyoKogakuShikyuShinseiEntity.class);
        dbt3111Writer = new BatchPermanentTableWriter<>(DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        dbt3112Writer = new BatchPermanentTableWriter<>(DbT3112KogakuShikyuShinsaKetteiEntity.class);
    }

    @Override
    protected void process(JikyoKogakuKaigoServiceHiRelateEntity entity) {
        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity dbt3109Entity = new DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
        dbt3109Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3109Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3109Entity.setRirekiNo(Decimal.ONE.add(entity.get給付対象者合計().getRirekiNo()));
        dbt3109Entity.setServiceHiyoGokeiGakuGokei(entity.get給付対象者合計().getServiceHiyoGokeiGakuGokei());
        dbt3109Entity.setRiyoshaFutanGakuGokei(entity.get給付対象者合計().getRiyoshaFutanGakuGokei());
        dbt3109Entity.setSanteiKijunGaku(entity.get給付対象者合計().getSanteiKijunGaku());
        dbt3109Entity.setShiharaiSumiKingakuGokei(entity.get申請情報().getShiharaiSumiKingakuGokeiJoho());
        dbt3109Entity.setJigyoKogakuShikyuGaku(entity.get給付対象者合計().getJigyoKogakuShikyuGaku());
        dbt3109Entity.setTashoshaUketoriYM(entity.get給付対象者合計().getTashoshaUketoriYM());
        dbt3109Entity.setTaishoshaHanteiShinsaYM(entity.get給付対象者合計().getTaishoshaHanteiShinsaYM());
        dbt3109Entity.setSetaiShuyakuNo(entity.get給付対象者合計().getSetaiShuyakuNo());
        dbt3109Entity.setKyokaisoTaishoshaFlag(entity.get給付対象者合計().getKyokaisoTaishoshaFlag());
        dbt3109Entity.setKogakuTaishoGaiFlag(entity.get給付対象者合計().getKogakuTaishoGaiFlag());
        dbt3109Entity.setJidoShokanTaishoFlag(entity.get給付対象者合計().getJidoShokanTaishoFlag());
        dbt3109Entity.setState(EntityDataState.Added);
        dbt3109Writer.insert(dbt3109Entity);

        DbT3110JigyoKogakuShikyuShinseiEntity dbt3110Entity = new DbT3110JigyoKogakuShikyuShinseiEntity();
        dbt3110Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3110Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3110Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3110Entity.setRirekiNo(Decimal.ONE.add(entity.get給付対象者合計().getRirekiNo()));
        dbt3110Entity.setUketsukeYMD(entity.get申請情報().getUketsukeYMDJoho());
        dbt3110Entity.setShinseiYMD(entity.get申請情報().getShinseiYMDJoho());
        dbt3110Entity.setShinseiRiyu(entity.get支給申請().getShinseiRiyu());
        dbt3110Entity.setShinseishaKubun(entity.get申請情報().getShinseishaKubunJoho());
        dbt3110Entity.setShinseishaShimei(entity.get申請情報().getShinseishaShimeiJoho());
        dbt3110Entity.setShinseishaShimeiKana(entity.get申請情報().getShinseishaShimeiKanaJoho());
        dbt3110Entity.setShinseishaJusho(entity.get支給申請().getShinseishaJusho());
        dbt3110Entity.setShinseishaTelNo(entity.get支給申請().getShinseishaTelNo());
        dbt3110Entity.setShinseiJigyoshaNo(entity.get支給申請().getShinseiJigyoshaNo());
        dbt3110Entity.setShiharaiHohoKubunCode(entity.get申請情報().getShiharaiHohoKubunCodeJoho());
        dbt3110Entity.setShiharaiBasho(entity.get支給申請().getShiharaiBasho());
        dbt3110Entity.setShiharaiKaishiYMD(entity.get支給申請().getShiharaiKaishiYMD());
        dbt3110Entity.setShiharaiShuryoYMD(entity.get支給申請().getShiharaiShuryoYMD());
        dbt3110Entity.setHeichoNaiyo(entity.get支給申請().getHeichoNaiyo());
        dbt3110Entity.setShiharaiKaishiTime(entity.get支給申請().getShiharaiKaishiTime());
        dbt3110Entity.setShiharaiShuryoTime(entity.get支給申請().getShiharaiShuryoTime());
        dbt3110Entity.setKozaID(entity.get申請情報().getKozaIDJoho());
        dbt3110Entity.setJuryoininKeiyakuNo(entity.get支給申請().getJuryoininKeiyakuNo());
        dbt3110Entity.setState(EntityDataState.Added);
        dbt3110Writer.insert(dbt3110Entity);

        DbT3111JigyoKogakuShikyuHanteiKekkaEntity dbt3111Entity = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        dbt3111Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3111Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3111Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3111Entity.setRirekiNo(Decimal.ONE.add(entity.get給付対象者合計().getRirekiNo()));
        dbt3111Entity.setKetteiYMD(entity.get申請情報().getKetteiYMDJoho());
        dbt3111Entity.setHonninShiharaiGaku(entity.get申請情報().getHonninShiharaiGakuJoho());
        dbt3111Entity.setShiharaiKubunCode(entity.get申請情報().getHanteiKekkaShikyuKubunCodeJoho());
        dbt3111Entity.setShiharaiKingaku(entity.get申請情報().getShikyuKingakuJoho());
        dbt3111Entity.setFushikyuRiyu(entity.get支給判定結果().getFushikyuRiyu());
        dbt3111Entity.setShinsaHohoKubun(entity.get申請情報().getShinsaHohoKubunJoho());
        dbt3111Entity.setHanteiKekkaSofuYM(entity.get申請情報().getHanteiKekkaSofuYMJoho());
        dbt3111Entity.setSaiSofuFlag(entity.get支給判定結果().getSaiSofuFlag());
        dbt3111Entity.setHanteiKekkaSofuFuyoFlag(entity.get支給判定結果().getHanteiKekkaSofuFuyoFlag());
        dbt3111Entity.setShinsaKekkaHaneiKubun(entity.get支給判定結果().getShinsaKekkaHaneiKubun());
        dbt3111Entity.setKetteiTsuchishoSakuseiYMD(entity.get支給判定結果().getKetteiTsuchishoSakuseiYMD());
        dbt3111Entity.setFurikomiMeisaishoSakuseiYMD(entity.get支給判定結果().getFurikomiMeisaishoSakuseiYMD());
        dbt3111Entity.setState(EntityDataState.Added);
        dbt3111Writer.insert(dbt3111Entity);

        DbT3112KogakuShikyuShinsaKetteiEntity dbt3112Entity = new DbT3112KogakuShikyuShinsaKetteiEntity();
        dbt3112Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3112Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3112Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3112Entity.setRirekiNo(1 + entity.get支給審査決定().getRirekiNo());
        dbt3112Entity.setKetteishaUketoriYM(entity.get申請情報().getKetteishaUketoriYMJoho());
        dbt3112Entity.setTsuchishoNo(entity.get支給審査決定().getTsuchishoNo());
        dbt3112Entity.setRiyoshaFutanGaku(entity.get申請情報().getKetteiRiyoshaFutanGakuJoho());
        dbt3112Entity.setShikyuKubunCode(entity.get支給審査決定().getShikyuKubunCode());
        dbt3112Entity.setKetteiYM(entity.get支給審査決定().getKetteiYM());
        dbt3112Entity.setJigyoKogakuShikyuGaku(entity.get支給審査決定().getJigyoKogakuShikyuGaku());
        dbt3112Entity.setState(EntityDataState.Added);
        dbt3112Writer.insert(dbt3112Entity);
    }
}
