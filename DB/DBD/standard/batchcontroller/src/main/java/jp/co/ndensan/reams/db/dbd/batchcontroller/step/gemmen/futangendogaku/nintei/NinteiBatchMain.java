/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.RiyoshaFutanDankaiHanni;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.YochokinShinkokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchMainProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.ShoninShoriEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.temptable.ShoninKekkaTempEntity;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定申請一括承認（バッチ）_承認処理のprocess処理クラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public class NinteiBatchMain extends BatchProcessBase<ShoninShoriEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku."
                    + "INinteiBatchMainMapper.get承認処理データ");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter shoninKekkaTempWriter;
    private NinteiBatchMainProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shoninKekkaTempWriter = new BatchEntityCreatedTempTableWriter(ShoninKekkaTempEntity.TABLE_NAME,
                ShoninKekkaTempEntity.class);
    }

    @Override
    protected void process(ShoninShoriEntity entity) {
        ShoninKekkaTempEntity shoninKekkaTempEntity = new ShoninKekkaTempEntity();
        shoninKekkaTempEntity.setShoKisaiHokenshaNo(entity.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo());
        shoninKekkaTempEntity.setHihokenshaNo(entity.get介護保険負担限度額認定Entity().getHihokenshaNo());
        shoninKekkaTempEntity.setRirekiNo(entity.get介護保険負担限度額認定Entity().getRirekiNo());
        shoninKekkaTempEntity.setKyusochishaKubun(entity.get介護保険負担限度額認定Entity().getKyusochishaKubun());
        shoninKekkaTempEntity.setShinseiRiyuKubun(entity.get介護保険負担限度額認定Entity().getShinseiRiyuKubun());
        shoninKekkaTempEntity.setKyokaisoGaitoshaKubun(entity.get介護保険負担限度額認定Entity().getKyokaisoGaitoshaKubun());
        shoninKekkaTempEntity.setGekihenKanwaSochiTaishoshaKubun(entity.get介護保険負担限度額認定Entity().getGekihenKanwaSochiTaishoshaKubun());
        shoninKekkaTempEntity.setKyoshitsuShubetsu(entity.get介護保険負担限度額認定Entity().getKyoshitsuShubetsu());
        shoninKekkaTempEntity.setHaigushaUmuFlag(entity.get介護保険負担限度額認定Entity().getHaigushaUmuFlag());
        shoninKekkaTempEntity.setHaigushaShimei(entity.get介護保険負担限度額認定Entity().getHaigushaShimei());
        shoninKekkaTempEntity.setHaigushaShimeiKana(entity.get介護保険負担限度額認定Entity().getHaigushaShimeiKana());
        shoninKekkaTempEntity.setHaigushaSeinenGappiYMD(entity.get介護保険負担限度額認定Entity().getHaigushaSeinenGappiYMD());
        shoninKekkaTempEntity.setHaigushaJusho(entity.get介護保険負担限度額認定Entity().getHaigushaJusho());
        shoninKekkaTempEntity.setHaigushaRenrakusaki(entity.get介護保険負担限度額認定Entity().getHaigushaRenrakusaki());
        shoninKekkaTempEntity.setHaigushaJusho2(entity.get介護保険負担限度額認定Entity().getHaigushaJusho2());
        shoninKekkaTempEntity.setHaigushaKazeiKubun(entity.get介護保険負担限度額認定Entity().getHaigushaKazeiKubun());
        shoninKekkaTempEntity.setHaigushaShikibetsuCd(entity.get介護保険負担限度額認定Entity().getHaigushaShikibetsuCd());
        shoninKekkaTempEntity.setYochokinShinkokuKubun(entity.get介護保険負担限度額認定Entity().getYochokinShinkokuKubun());
        shoninKekkaTempEntity.setYochokinGaku(entity.get介護保険負担限度額認定Entity().getYochokinGaku());
        shoninKekkaTempEntity.setYukashoukenGaisangaku(entity.get介護保険負担限度額認定Entity().getYukashoukenGaisangaku());
        shoninKekkaTempEntity.setSonotaKingaku(entity.get介護保険負担限度額認定Entity().getSonotaKingaku());
        shoninKekkaTempEntity.setShinseiYMD(entity.get介護保険負担限度額認定Entity().getShinseiYMD());
        shoninKekkaTempEntity.setBatchShoriNitiji(parameter.getバッチ処理日時());
        shoninKekkaTempEntity.setIzokuNenkinJukyuFlag(entity.get介護保険負担限度額認定Entity().getIzokuNenkinJukyuFlag());
        shoninKekkaTempEntity.setShogaiNenkinJukyuFlag(entity.get介護保険負担限度額認定Entity().getShogaiNenkinJukyuFlag());
        決定区分と非承認理由と利用者負担段階の判定(shoninKekkaTempEntity, entity);
        決定日の判定(shoninKekkaTempEntity);
        適用開始日と適用終了日の判定(shoninKekkaTempEntity);
        負担限度額の判定(shoninKekkaTempEntity, entity);
        配偶者情報処理(shoninKekkaTempEntity, entity);
        shoninKekkaTempWriter.insert(shoninKekkaTempEntity);
    }

    private void 決定区分と非承認理由と利用者負担段階の判定(
            ShoninKekkaTempEntity shoninKekkaTempEntity,
            ShoninShoriEntity entity) {
        if (parameter.is非課税時_承認しないフラグ()
                && KazeiKubun.非課税.getコード().equals(entity.get減免減額対象者判定用根拠一時Entity().get本人課税区分())) {
            shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認しない.getコード());
            shoninKekkaTempEntity.setHiShoninRiyu(parameter.get非課税時_承認しない理由());
            shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
        } else if (parameter.is配偶者課税時_承認しないフラグ()) {
            if (KazeiKubun.課税.getコード().equals(entity.get減免減額対象者判定用根拠一時Entity().get配偶者課税区分())) {
                shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認しない.getコード());
                shoninKekkaTempEntity.setHiShoninRiyu(parameter.get配偶者課税時_承認しない理由());
                shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
            } else if ((entity.get減免減額対象者判定用根拠一時Entity().get配偶者課税区分() == null
                    || entity.get減免減額対象者判定用根拠一時Entity().get配偶者課税区分().isEmpty())
                    && entity.get介護保険負担限度額認定Entity().getHaigushaKazeiKubun() != null
                    && !RString.EMPTY.equals(entity.get介護保険負担限度額認定Entity().getHaigushaKazeiKubun())) {
                shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認しない.getコード());
                shoninKekkaTempEntity.setHiShoninRiyu(parameter.get配偶者課税時_承認しない理由());
                shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
            }
        } else if (parameter.is預貯金等超過時_承認しないフラグ()
                && YochokinShinkokuKubun.超過.getコード().equals(entity.get介護保険負担限度額認定Entity().getYochokinShinkokuKubun())) {
            shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認しない.getコード());
            shoninKekkaTempEntity.setHiShoninRiyu(parameter.get預貯金等超過時_理由());
            shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
        } else if (!entity.get減免減額対象者判定用根拠一時Entity().get利用者負担段階().isEmpty()
                && !entity.get減免減額対象者判定用根拠一時Entity().get利用者負担段階().equals(RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯.getコード())) {
            shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認する.getコード());
            shoninKekkaTempEntity.setHiShoninRiyu(RString.EMPTY);
            shoninKekkaTempEntity.setRiyoshaFutanDankai(entity.get減免減額対象者判定用根拠一時Entity().get利用者負担段階());
        } else if (entity.get減免減額対象者判定用根拠一時Entity().get利用者負担段階().equals(RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯.getコード())) {
            shoninKekkaTempEntity.setKetteiKubun(KetteiKubun.承認しない.getコード());
            shoninKekkaTempEntity.setHiShoninRiyu(RString.EMPTY);
            shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
        } else if (entity.get減免減額対象者判定用根拠一時Entity().get利用者負担段階().isEmpty()) {
            shoninKekkaTempEntity.setRiyoshaFutanDankai(RString.EMPTY);
            shoninKekkaTempEntity.setKetteiKubun(RString.EMPTY);
            shoninKekkaTempEntity.setHiShoninRiyu(RString.EMPTY);
        }

    }

    private void 決定日の判定(ShoninKekkaTempEntity shoninKekkaTempEntity) {
        if (shoninKekkaTempEntity.getKetteiKubun() != null && !shoninKekkaTempEntity.getKetteiKubun().isEmpty()) {
            shoninKekkaTempEntity.setKetteiYMD(parameter.get決定日());
        } else {
            shoninKekkaTempEntity.setKetteiYMD(FlexibleDate.EMPTY);
        }
    }

    private void 適用開始日と適用終了日の判定(ShoninKekkaTempEntity shoninKekkaTempEntity) {
        if (shoninKekkaTempEntity.getKetteiKubun() != null && shoninKekkaTempEntity.getKetteiKubun().equals(KetteiKubun.承認する.getコード())) {
            shoninKekkaTempEntity.setTekiyoKaishiYMD(parameter.get認定期間_開始日());
            shoninKekkaTempEntity.setTekiyoShuryoYMD(parameter.get認定期間_終了日());
        } else {
            shoninKekkaTempEntity.setTekiyoKaishiYMD(FlexibleDate.EMPTY);
            shoninKekkaTempEntity.setTekiyoShuryoYMD(FlexibleDate.EMPTY);
        }

    }

    private void 負担限度額の判定(ShoninKekkaTempEntity shoninKekkaTempEntity,
            ShoninShoriEntity entity) {
        if (shoninKekkaTempEntity.getKetteiKubun() != null && shoninKekkaTempEntity.getKetteiKubun().equals(KetteiKubun.承認する.getコード())) {
            FutangendogakuNinteiService service = FutangendogakuNinteiService.createInstance();
            RString 旧措置者区分 = entity.get介護保険負担限度額認定Entity().getKyusochishaKubun();
            RString 利用者負担段階 = entity.get介護保険負担限度額認定Entity().getRiyoshaFutanDankai();
            shoninKekkaTempEntity.setShokuhiFutanGendogaku(new Decimal(service.load食費負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
            shoninKekkaTempEntity.setUnitTypeKoshitsu(new Decimal(service.loadユニット型個室負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
            shoninKekkaTempEntity.setUnitTypeJunKoshitsu(new Decimal(
                    service.loadユニット型準個室負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
            shoninKekkaTempEntity.setJuraiTypeKoshitsu_Tokuyo(new Decimal(
                    service.load従来型個室特養等負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
            shoninKekkaTempEntity.setJuraiTypeKoshitsu_Roken_Ryoyo(new Decimal(
                    service.load従来型個室老健等負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
            shoninKekkaTempEntity.setTashoshitsu(new Decimal(service.load多床室負担限度額候補(旧措置者区分, parameter.get決定日(), 利用者負担段階).get(0).toString()));
        } else {
            shoninKekkaTempEntity.setShokuhiFutanGendogaku(Decimal.ZERO);
            shoninKekkaTempEntity.setUnitTypeKoshitsu(Decimal.ZERO);
            shoninKekkaTempEntity.setUnitTypeJunKoshitsu(Decimal.ZERO);
            shoninKekkaTempEntity.setJuraiTypeKoshitsu_Tokuyo(Decimal.ZERO);
            shoninKekkaTempEntity.setJuraiTypeKoshitsu_Roken_Ryoyo(Decimal.ZERO);
            shoninKekkaTempEntity.setTashoshitsu(Decimal.ZERO);
        }

    }

    private void 配偶者情報処理(ShoninKekkaTempEntity shoninKekkaTempEntity,
            ShoninShoriEntity entity) {
        if (!entity.get介護保険負担限度額認定Entity().getHaigushaUmuFlag()) {
            shoninKekkaTempEntity.setHaigushaShimei(AtenaMeisho.EMPTY);
            shoninKekkaTempEntity.setHaigushaShimeiKana(AtenaKanaMeisho.EMPTY);
            shoninKekkaTempEntity.setHaigushaSeinenGappiYMD(FlexibleDate.EMPTY);
            shoninKekkaTempEntity.setHaigushaJusho(AtenaJusho.EMPTY);
            shoninKekkaTempEntity.setHaigushaRenrakusaki(RString.EMPTY);
            shoninKekkaTempEntity.setHaigushaJusho2(AtenaJusho.EMPTY);
            shoninKekkaTempEntity.setHaigushaKazeiKubun(RString.EMPTY);
            shoninKekkaTempEntity.setHaigushaShikibetsuCd(ShikibetsuCode.EMPTY);
        }
    }
}
