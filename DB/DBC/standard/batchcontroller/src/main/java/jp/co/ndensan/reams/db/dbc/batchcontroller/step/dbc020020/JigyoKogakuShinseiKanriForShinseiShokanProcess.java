/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.JikyoKogakuKaigoServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoShokanTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額申請（総合事業）管理のマスタテーブルから、申請情報の取得処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoKogakuShinseiKanriForShinseiShokanProcess extends BatchProcessBase<JikyoKogakuKaigoServiceHiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get自動償還対象For事業高額介護サービス費");

    private static final RString TABLE_NAME = new RString("ShinseiJohoShokanTemp");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoShokanTempEntity.class);
    }

    @Override
    protected void process(JikyoKogakuKaigoServiceHiRelateEntity entity) {
        ShinseiJohoShokanTempEntity tmpEntity = new ShinseiJohoShokanTempEntity();
        tmpEntity.setHihokenshaNoShokan(entity.get支給申請().getHihokenshaNo());
        tmpEntity.setServiceTeikyoYMShokan(entity.get支給申請().getServiceTeikyoYM());
        tmpEntity.setShoKisaiHokenshaNoShokan(entity.get支給申請().getShoKisaiHokenshaNo());
        tmpEntity.setRirekiNoShokan(entity.get支給申請().getRirekiNo());
        tmpEntity.setUketsukeYMDShokan(entity.get支給申請().getUketsukeYMD());
        tmpEntity.setShinseiYMDShokan(entity.get支給申請().getShinseiYMD());
        tmpEntity.setShinseiRiyuShokan(entity.get支給申請().getShinseiRiyu());
        tmpEntity.setShinseishaKubunShokan(entity.get支給申請().getShinseishaKubun());
        tmpEntity.setShinseishaShimeiShokan(entity.get支給申請().getShinseishaShimei());
        tmpEntity.setShinseishaShimeiKanaShokan(entity.get支給申請().getShinseishaShimeiKana());
        tmpEntity.setShinseishaJushoShokan(entity.get支給申請().getShinseishaJusho());
        tmpEntity.setShinseishaTelNoShokan(entity.get支給申請().getShinseishaTelNo());
        tmpEntity.setShinseiJigyoshaNoShokan(entity.get支給申請().getShinseiJigyoshaNo());
        tmpEntity.setShiharaiHohoKubunCodeShokan(entity.get支給申請().getShiharaiHohoKubunCode());
        tmpEntity.setShiharaiBashoShokan(entity.get支給申請().getShiharaiBasho());
        tmpEntity.setShiharaiKaishiYMDShokan(entity.get支給申請().getShiharaiKaishiYMD());
        tmpEntity.setShiharaiShuryoYMDShokan(entity.get支給申請().getShiharaiShuryoYMD());
        tmpEntity.setHeichoNaiyoShokan(entity.get支給申請().getHeichoNaiyo());
        tmpEntity.setShiharaiKaishiTimeShokan(entity.get支給申請().getShiharaiKaishiTime());
        tmpEntity.setShiharaiShuryoTimeShokan(entity.get支給申請().getShiharaiShuryoTime());
        tmpEntity.setKozaIDShokan(entity.get支給申請().getKozaID());
        tmpEntity.setJuryoininKeiyakuNoShokan(entity.get支給申請().getJuryoininKeiyakuNo());
        tmpEntity.setKetteiYMDShokan(entity.get支給判定結果().getKetteiYMD());
        tmpEntity.setHonninShiharaiGakuShokan(entity.get支給判定結果().getHonninShiharaiGaku());
        tmpEntity.setHanteiKekkaShikyuKubunCodeShokan(entity.get支給判定結果().getShiharaiKubunCode());
        tmpEntity.setShikyuKingakuShokan(entity.get支給判定結果().getShiharaiKingaku());
        tmpEntity.setFushikyuRiyuShokan(entity.get支給判定結果().getFushikyuRiyu());
        tmpEntity.setShinsaHohoKubunShokan(entity.get支給判定結果().getShinsaHohoKubun());
        tmpEntity.setHanteiKekkaSofuYMShokan(entity.get支給判定結果().getHanteiKekkaSofuYM());
        tmpEntity.setSaiSofuFlagShokan(entity.get支給判定結果().getSaiSofuFlag());
        tmpEntity.setHanteiKekkaSofuFuyoFlagShokan(entity.get支給判定結果().getHanteiKekkaSofuFuyoFlag());
        tmpEntity.setShinsaKekkaHaneiKubunShokan(entity.get支給判定結果().getShinsaKekkaHaneiKubun());
        tmpEntity.setKetteiTsuchishoSakuseiYMDShokan(entity.get支給判定結果().getKetteiTsuchishoSakuseiYMD());
        tmpEntity.setFurikomiMeisaishoSakuseiYMDShokan(entity.get支給判定結果().getFurikomiMeisaishoSakuseiYMD());
        tmpEntity.setServiceHiyoGokeiGakuGokeiShokan(entity.get給付対象者合計().getServiceHiyoGokeiGakuGokei());
        tmpEntity.setRiyoshaFutanGakuGokeiShokan(entity.get給付対象者合計().getRiyoshaFutanGakuGokei());
        tmpEntity.setSanteiKijunGakuShokan(entity.get給付対象者合計().getSanteiKijunGaku());
        tmpEntity.setShiharaiSumiKingakuGokeiShokan(entity.get給付対象者合計().getShiharaiSumiKingakuGokei());
        tmpEntity.setGokeiKogakuShikyuGakuShokan(entity.get給付対象者合計().getJigyoKogakuShikyuGaku());
        tmpEntity.setGokeiTashoshaUketoriYMShokan(entity.get給付対象者合計().getTashoshaUketoriYM());
        tmpEntity.setTaishoshaHanteiShinsaYMShokan(entity.get給付対象者合計().getTaishoshaHanteiShinsaYM());
        tmpEntity.setSetaiShuyakuNoShokan(entity.get給付対象者合計().getSetaiShuyakuNo());
        tmpEntity.setKyokaisoTaishoshaFlagShokan(entity.get給付対象者合計().getKyokaisoTaishoshaFlag());
        tmpEntity.setHojinKeigenTaishoFlagShokan(entity.get給付対象者合計().getHojinKeigenTaishoFlag());
        tmpEntity.setKogakuTaishoGaiFlagShokan(entity.get給付対象者合計().getKogakuTaishoGaiFlag());
        tmpEntity.setJidoShokanTaishoFlagShokan(entity.get給付対象者合計().getJidoShokanTaishoFlag());
        tmpEntity.setServiceHiyoGokeiGakuShokan(entity.get給付対象者明細().getServiceHiyoGokeiGaku());
        tmpEntity.setMeisaiRiyoshaFutanGakuShokan(entity.get給付対象者明細().getRiyoshaFutanGaku());
        tmpEntity.setKogakuKyufuKonkyoShokan(entity.get給付対象者明細().getJigyoKogakuKyufuKonkyo());
        tmpEntity.setMeisaiTaishoshaUketoriYMShokan(entity.get給付対象者明細().getTaishoshaUketoriYM());
        tmpEntity.setJigyoshaNoShokan(entity.get給付対象者明細().getJigyoshaNo());
        tmpEntity.setServiceShuruiCodeShokan(entity.get給付対象者明細().getServiceShuruiCode());
        tmpEntity.setKetteishaUketoriYMShokan(entity.get支給審査決定().getKetteishaUketoriYM());
        tmpEntity.setTsuchishoNoShokan(entity.get支給審査決定().getTsuchishoNo());
        tmpEntity.setKetteiRiyoshaFutanGakuShokan(entity.get支給審査決定().getRiyoshaFutanGaku());
        tmpEntity.setKetteiShikyuKubunCodeShokan(entity.get支給審査決定().getShikyuKubunCode());
        tmpEntity.setKetteiYMShokan(entity.get支給審査決定().getKetteiYM());
        tmpEntity.setKetteiKogakuShikyuGakuShokan(entity.get支給審査決定().getJigyoKogakuShikyuGaku());
        tmpEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tmpEntity);
    }
}
