/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.JikyoKogakuKaigoServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額申請（総合事業）管理のマスタテーブルから、申請情報の取得処理クラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoKogakuShinseiKanriForShinseiJyohoProcess extends BatchProcessBase<JikyoKogakuKaigoServiceHiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get事業高額介護サービス費情報");
    private static final RString TABLE_NAME = new RString("ShinseiJohoTemp");
    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoTempEntity.class);
    }

    @Override
    protected void process(JikyoKogakuKaigoServiceHiRelateEntity entity) {
        ShinseiJohoTempEntity tmpEntity = new ShinseiJohoTempEntity();
        tmpEntity.setHihokenshaNoJoho(entity.get支給申請().getHihokenshaNo());
        tmpEntity.setServiceTeikyoYMJoho(entity.get支給申請().getServiceTeikyoYM());
        tmpEntity.setShoKisaiHokenshaNoJoho(entity.get支給申請().getShoKisaiHokenshaNo());
        tmpEntity.setRirekiNoJoho(entity.get支給申請().getRirekiNo());
        tmpEntity.setUketsukeYMDJoho(entity.get支給申請().getUketsukeYMD());
        tmpEntity.setShinseiYMDJoho(entity.get支給申請().getShinseiYMD());
        tmpEntity.setShinseiRiyuJoho(entity.get支給申請().getShinseiRiyu());
        tmpEntity.setShinseishaKubunJoho(entity.get支給申請().getShinseishaKubun());
        tmpEntity.setShinseishaShimeiJoho(entity.get支給申請().getShinseishaShimei());
        tmpEntity.setShinseishaShimeiKanaJoho(entity.get支給申請().getShinseishaShimeiKana());
        tmpEntity.setShinseishaJushoJoho(entity.get支給申請().getShinseishaJusho());
        tmpEntity.setShinseishaTelNoJoho(entity.get支給申請().getShinseishaTelNo());
        tmpEntity.setShinseiJigyoshaNoJoho(entity.get支給申請().getShinseiJigyoshaNo());
        tmpEntity.setShiharaiHohoKubunCodeJoho(entity.get支給申請().getShiharaiHohoKubunCode());
        tmpEntity.setShiharaiBashoJoho(entity.get支給申請().getShiharaiBasho());
        tmpEntity.setShiharaiKaishiYMDJoho(entity.get支給申請().getShiharaiKaishiYMD());
        tmpEntity.setShiharaiShuryoYMDJoho(entity.get支給申請().getShiharaiShuryoYMD());
        tmpEntity.setHeichoNaiyoJoho(entity.get支給申請().getHeichoNaiyo());
        tmpEntity.setShiharaiKaishiTimeJoho(entity.get支給申請().getShiharaiKaishiTime());
        tmpEntity.setShiharaiShuryoTimeJoho(entity.get支給申請().getShiharaiShuryoTime());
        tmpEntity.setKozaIDJoho(entity.get支給申請().getKozaID());
        tmpEntity.setJuryoininKeiyakuNoJoho(entity.get支給申請().getJuryoininKeiyakuNo());
        tmpEntity.setKetteiYMDJoho(entity.get支給判定結果().getKetteiYMD());
        tmpEntity.setHonninShiharaiGakuJoho(entity.get支給判定結果().getHonninShiharaiGaku());
        tmpEntity.setHanteiKekkaShikyuKubunCodeJoho(entity.get支給判定結果().getShiharaiKubunCode());
        tmpEntity.setShikyuKingakuJoho(entity.get支給判定結果().getShiharaiKingaku());
        tmpEntity.setFushikyuRiyuJoho(entity.get支給判定結果().getFushikyuRiyu());
        tmpEntity.setShinsaHohoKubunJoho(entity.get支給判定結果().getShinsaHohoKubun());
        tmpEntity.setHanteiKekkaSofuYMJoho(entity.get支給判定結果().getHanteiKekkaSofuYM());
        tmpEntity.setSaiSofuFlagJoho(entity.get支給判定結果().getSaiSofuFlag());
        tmpEntity.setHanteiKekkaSofuFuyoFlagJoho(entity.get支給判定結果().getHanteiKekkaSofuFuyoFlag());
        tmpEntity.setShinsaKekkaHaneiKubunJoho(entity.get支給判定結果().getShinsaKekkaHaneiKubun());
        tmpEntity.setKetteiTsuchishoSakuseiYMDJoho(entity.get支給判定結果().getKetteiTsuchishoSakuseiYMD());
        tmpEntity.setFurikomiMeisaishoSakuseiYMDJoho(entity.get支給判定結果().getFurikomiMeisaishoSakuseiYMD());
        tmpEntity.setServiceHiyoGokeiGakuGokeiJoho(entity.get給付対象者合計().getServiceHiyoGokeiGakuGokei());
        tmpEntity.setRiyoshaFutanGakuGokeiJoho(entity.get給付対象者合計().getRiyoshaFutanGakuGokei());
        tmpEntity.setSanteiKijunGakuJoho(entity.get給付対象者合計().getSanteiKijunGaku());
        tmpEntity.setShiharaiSumiKingakuGokeiJoho(entity.get給付対象者合計().getShiharaiSumiKingakuGokei());
        tmpEntity.setGokeiKogakuShikyuGakuJoho(entity.get給付対象者合計().getJigyoKogakuShikyuGaku());
        tmpEntity.setGokeiTashoshaUketoriYMJoho(entity.get給付対象者合計().getTashoshaUketoriYM());
        tmpEntity.setTaishoshaHanteiShinsaYMJoho(entity.get給付対象者合計().getTaishoshaHanteiShinsaYM());
        tmpEntity.setSetaiShuyakuNoJoho(entity.get給付対象者合計().getSetaiShuyakuNo());
        tmpEntity.setKyokaisoTaishoshaFlagJoho(entity.get給付対象者合計().getKyokaisoTaishoshaFlag());
        tmpEntity.setHojinKeigenTaishoFlagJoho(entity.get給付対象者合計().getHojinKeigenTaishoFlag());
        tmpEntity.setKogakuTaishoGaiFlagJoho(entity.get給付対象者合計().getKogakuTaishoGaiFlag());
        tmpEntity.setJidoShokanTaishoFlagJoho(entity.get給付対象者合計().getJidoShokanTaishoFlag());
        tmpEntity.setServiceHiyoGokeiGakuJoho(entity.get給付対象者明細().getServiceHiyoGokeiGaku());
        tmpEntity.setMeisaiRiyoshaFutanGakuJoho(entity.get給付対象者明細().getRiyoshaFutanGaku());
        tmpEntity.setKogakuKyufuKonkyoJoho(entity.get給付対象者明細().getJigyoKogakuKyufuKonkyo());
        tmpEntity.setMeisaiTaishoshaUketoriYMJoho(entity.get給付対象者明細().getTaishoshaUketoriYM());
        tmpEntity.setJigyoshaNoJoho(entity.get給付対象者明細().getJigyoshaNo());
        tmpEntity.setServiceShuruiCodeJoho(entity.get給付対象者明細().getServiceShuruiCode());
        tmpEntity.setKetteishaUketoriYMJoho(entity.get支給審査決定().getKetteishaUketoriYM());
        tmpEntity.setTsuchishoNoJoho(entity.get支給審査決定().getTsuchishoNo());
        tmpEntity.setKetteiRiyoshaFutanGakuJoho(entity.get支給審査決定().getRiyoshaFutanGaku());
        tmpEntity.setKetteiShikyuKubunCodeJoho(entity.get支給審査決定().getShikyuKubunCode());
        tmpEntity.setKetteiYMJoho(entity.get支給審査決定().getKetteiYM());
        tmpEntity.setKetteiKogakuShikyuGakuJoho(entity.get支給審査決定().getJigyoKogakuShikyuGaku());
        tempDbWriter.insert(tmpEntity);
    }
}
