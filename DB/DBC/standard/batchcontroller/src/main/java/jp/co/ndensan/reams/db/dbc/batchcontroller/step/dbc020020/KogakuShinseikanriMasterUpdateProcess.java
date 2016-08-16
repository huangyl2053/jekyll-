/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServiceHiRelateEntity;
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
public class KogakuShinseikanriMasterUpdateProcess extends BatchProcessBase<KogakuKaigoServiceHiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get高額介護申請管理マスタのデータ");
    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT3055KogakuKyufuTaishoshaGokeiEntity> dbt3055Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3056KogakuShikyuShinseiEntity> dbt3056Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3057KogakuShikyuHanteiKekkaEntity> dbt3057Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3058KogakuShikyuShinsaKetteiEntity> dbt3058Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        dbt3055Writer = new BatchPermanentTableWriter<>(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        dbt3056Writer = new BatchPermanentTableWriter<>(DbT3056KogakuShikyuShinseiEntity.class);
        dbt3057Writer = new BatchPermanentTableWriter<>(DbT3057KogakuShikyuHanteiKekkaEntity.class);
        dbt3058Writer = new BatchPermanentTableWriter<>(DbT3058KogakuShikyuShinsaKetteiEntity.class);
    }

    @Override
    protected void process(KogakuKaigoServiceHiRelateEntity entity) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity dbt3055Entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        dbt3055Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3055Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3055Entity.setRirekiNo(Decimal.ONE.add(entity.get給付対象者合計().getRirekiNo()));
        dbt3055Entity.setServiceHiyoGokeiGakuGokei(entity.get給付対象者合計().getServiceHiyoGokeiGakuGokei());
        dbt3055Entity.setRiyoshaFutanGakuGokei(entity.get給付対象者合計().getRiyoshaFutanGakuGokei());
        dbt3055Entity.setSanteiKijunGaku(entity.get給付対象者合計().getSanteiKijunGaku());
        dbt3055Entity.setShiharaiSumiKingakuGokei(entity.get申請情報().getShiharaiSumiKingakuGokeiJoho());
        dbt3055Entity.setKogakuShikyuGaku(entity.get給付対象者合計().getKogakuShikyuGaku());
        dbt3055Entity.setTashoshaUketoriYM(entity.get給付対象者合計().getTashoshaUketoriYM());
        dbt3055Entity.setTaishoshaHanteiShinsaYM(entity.get給付対象者合計().getTaishoshaHanteiShinsaYM());
        dbt3055Entity.setSetaiShuyakuNo(entity.get給付対象者合計().getSetaiShuyakuNo());
        dbt3055Entity.setKyokaisoTaishoshaFlag(entity.get給付対象者合計().getKyokaisoTaishoshaFlag());
        dbt3055Entity.setKogakuTaishoGaiFlag(entity.get給付対象者合計().getKogakuTaishoGaiFlag());
        dbt3055Entity.setJidoShokanTaishoFlag(entity.get給付対象者合計().getJidoShokanTaishoFlag());
        dbt3055Entity.setState(EntityDataState.Added);
        dbt3055Writer.insert(dbt3055Entity);

        DbT3056KogakuShikyuShinseiEntity dbt3056Entity = new DbT3056KogakuShikyuShinseiEntity();
        dbt3056Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3056Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3056Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3056Entity.setRirekiNo(Decimal.ONE.add(entity.get給付対象者合計().getRirekiNo()));
        dbt3056Entity.setUketsukeYMD(entity.get申請情報().getUketsukeYMDJoho());
        dbt3056Entity.setShinseiYMD(entity.get申請情報().getShinseiYMDJoho());
        dbt3056Entity.setShinseiRiyu(entity.get支給申請().getShinseiRiyu());
        dbt3056Entity.setShinseishaKubun(entity.get申請情報().getShinseishaKubunJoho());
        dbt3056Entity.setShinseishaShimei(entity.get申請情報().getShinseishaShimeiJoho());
        dbt3056Entity.setShinseishaShimeiKana(entity.get申請情報().getShinseishaShimeiKanaJoho());
        dbt3056Entity.setShinseishaJusho(entity.get支給申請().getShinseishaJusho());
        dbt3056Entity.setShinseishaTelNo(entity.get支給申請().getShinseishaTelNo());
        dbt3056Entity.setShinseiJigyoshaNo(entity.get支給申請().getShinseiJigyoshaNo());
        dbt3056Entity.setShiharaiHohoKubunCode(entity.get申請情報().getShiharaiHohoKubunCodeJoho());
        dbt3056Entity.setShiharaiBasho(entity.get支給申請().getShiharaiBasho());
        dbt3056Entity.setShiharaiKaishiYMD(entity.get支給申請().getShiharaiKaishiYMD());
        dbt3056Entity.setShiharaiShuryoYMD(entity.get支給申請().getShiharaiShuryoYMD());
        dbt3056Entity.setHeichoNaiyo(entity.get支給申請().getHeichoNaiyo());
        dbt3056Entity.setShiharaiKaishiTime(entity.get支給申請().getShiharaiKaishiTime());
        dbt3056Entity.setShiharaiShuryoTime(entity.get支給申請().getShiharaiShuryoTime());
        dbt3056Entity.setKozaID(entity.get申請情報().getKozaIDJoho());
        dbt3056Entity.setJuryoininKeiyakuNo(entity.get支給申請().getJuryoininKeiyakuNo());
        dbt3056Entity.setState(EntityDataState.Added);
        dbt3056Writer.insert(dbt3056Entity);

        DbT3057KogakuShikyuHanteiKekkaEntity dbt3057Entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
        dbt3057Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3057Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3057Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3057Entity.setRirekiNo(1 + entity.get給付対象者合計().getRirekiNo().intValue());
        dbt3057Entity.setKetteiYMD(entity.get申請情報().getKetteiYMDJoho());
        dbt3057Entity.setHonninShiharaiGaku(entity.get申請情報().getHonninShiharaiGakuJoho());
        dbt3057Entity.setShikyuKubunCode(entity.get申請情報().getHanteiKekkaShikyuKubunCodeJoho());
        dbt3057Entity.setShikyuKingaku(entity.get申請情報().getShikyuKingakuJoho());
        dbt3057Entity.setFushikyuRiyu(entity.get支給判定結果().getFushikyuRiyu());
        dbt3057Entity.setShinsaHohoKubun(entity.get申請情報().getShinsaHohoKubunJoho());
        dbt3057Entity.setHanteiKekkaSofuYM(entity.get申請情報().getHanteiKekkaSofuYMJoho());
        dbt3057Entity.setSaiSofuFlag(entity.get支給判定結果().getSaiSofuFlag());
        dbt3057Entity.setHanteiKekkaSofuFuyoFlag(entity.get支給判定結果().getHanteiKekkaSofuFuyoFlag());
        dbt3057Entity.setShinsaKekkaHaneiKubun(entity.get支給判定結果().getShinsaKekkaHaneiKubun());
        dbt3057Entity.setKetteiTsuchishoSakuseiYMD(entity.get支給判定結果().getKetteiTsuchishoSakuseiYMD());
        dbt3057Entity.setFurikomiMeisaishoSakuseiYMD(entity.get支給判定結果().getFurikomiMeisaishoSakuseiYMD());
        dbt3057Entity.setState(EntityDataState.Added);
        dbt3057Writer.insert(dbt3057Entity);

        DbT3058KogakuShikyuShinsaKetteiEntity dbt3058Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        dbt3058Entity.setHihokenshaNo(entity.get支給申請().getHihokenshaNo());
        dbt3058Entity.setServiceTeikyoYM(entity.get支給申請().getServiceTeikyoYM());
        dbt3058Entity.setShoKisaiHokenshaNo(entity.get支給申請().getShoKisaiHokenshaNo());
        dbt3058Entity.setRirekiNo(1 + entity.get給付対象者合計().getRirekiNo().intValue());
        dbt3058Entity.setKetteishaUketoriYM(entity.get申請情報().getKetteishaUketoriYMJoho());
        dbt3058Entity.setTsuchishoNo(entity.get支給審査決定().getTsuchishoNo());
        dbt3058Entity.setRiyoshaFutanGaku(entity.get申請情報().getKetteiRiyoshaFutanGakuJoho());
        dbt3058Entity.setShikyuKubunCode(entity.get支給審査決定().getShikyuKubunCode());
        dbt3058Entity.setKetteiYM(entity.get支給審査決定().getKetteiYM());
        dbt3058Entity.setKogakuShikyuGaku(entity.get支給審査決定().getKogakuShikyuGaku());
        dbt3058Entity.setState(EntityDataState.Added);
        dbt3058Writer.insert(dbt3058Entity);
    }
}
