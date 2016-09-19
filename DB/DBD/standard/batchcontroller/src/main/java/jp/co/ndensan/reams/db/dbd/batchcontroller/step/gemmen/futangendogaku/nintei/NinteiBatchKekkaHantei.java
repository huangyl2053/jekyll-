/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchKekkaHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4036FutanGendogakuNinteiBatchTestResultsEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.temptable.ShoninKekkaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請一括承認（バッチ）_一括認定結果反映のprocess処理クラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public class NinteiBatchKekkaHantei extends BatchProcessBase<ShoninKekkaTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku."
                    + "INinteiBatchKekkaHanteiMapper.selectAll");
    private NinteiBatchKekkaHanteiProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT4018KaigoHokenFutanGendogakuNinteiEntity> dbT4018TableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4036FutanGendogakuNinteiBatchTestResultsEntity> dbT4036TableWriter;
    private DbT4018KaigoHokenFutanGendogakuNinteiEntity t4018Entity;
    private DbT4036FutanGendogakuNinteiBatchTestResultsEntity t4036Entity;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        dbT4018TableWriter = new BatchPermanentTableWriter<>(DbT4018KaigoHokenFutanGendogakuNinteiEntity.class);
        dbT4036TableWriter = new BatchPermanentTableWriter<>(DbT4036FutanGendogakuNinteiBatchTestResultsEntity.class);
    }

    @Override
    protected void process(ShoninKekkaTempEntity entity) {
        if (!parameter.isテスト処理()) {
            dbT4018TableWriter.update(updateDbT4018(entity));
        } else {
            dbT4036TableWriter.insert(insertDbT4036(entity));
        }
    }

    private DbT4018KaigoHokenFutanGendogakuNinteiEntity updateDbT4018(ShoninKekkaTempEntity tempEntity) {
        t4018Entity = new DbT4018KaigoHokenFutanGendogakuNinteiEntity();
        t4018Entity.setShoKisaiHokenshaNo(tempEntity.getShoKisaiHokenshaNo());
        t4018Entity.setHihokenshaNo(tempEntity.getHihokenshaNo());
        t4018Entity.setRirekiNo(tempEntity.getRirekiNo());
        t4018Entity.setKyusochishaKubun(tempEntity.getKyusochishaKubun());
        t4018Entity.setShinseiRiyuKubun(tempEntity.getShinseiRiyuKubun());
        t4018Entity.setRiyoshaFutanDankai(tempEntity.getRiyoshaFutanDankai());
        t4018Entity.setKyokaisoGaitoshaKubun(tempEntity.isKyokaisoGaitoshaKubun());
        t4018Entity.setGekihenKanwaSochiTaishoshaKubun(tempEntity.isGekihenKanwaSochiTaishoshaKubun());
        t4018Entity.setKyoshitsuShubetsu(tempEntity.getKyoshitsuShubetsu());
        t4018Entity.setShokuhiFutanGendogaku(tempEntity.getShokuhiFutanGendogaku());
        t4018Entity.setUnitTypeKoshitsu(tempEntity.getUnitTypeKoshitsu());
        t4018Entity.setUnitTypeJunKoshitsu(tempEntity.getUnitTypeJunKoshitsu());
        t4018Entity.setJuraiTypeKoshitsu_Tokuyo(tempEntity.getJuraiTypeKoshitsu_Tokuyo());
        t4018Entity.setJuraiTypeKoshitsu_Roken_Ryoyo(tempEntity.getJuraiTypeKoshitsu_Roken_Ryoyo());
        t4018Entity.setTashoshitsu(tempEntity.getTashoshitsu());
        t4018Entity.setHaigushaUmuFlag(tempEntity.isHaigushaUmuFlag());
        t4018Entity.setHaigushaShimei(tempEntity.getHaigushaShimei());
        t4018Entity.setHaigushaShimeiKana(tempEntity.getHaigushaShimeiKana());
        t4018Entity.setHaigushaSeinenGappiYMD(tempEntity.getHaigushaSeinenGappiYMD());
        t4018Entity.setHaigushaJusho(tempEntity.getHaigushaJusho());
        t4018Entity.setHaigushaRenrakusaki(tempEntity.getHaigushaRenrakusaki());
        t4018Entity.setHaigushaJusho2(tempEntity.getHaigushaJusho2());
        t4018Entity.setHaigushaKazeiKubun(tempEntity.getHaigushaKazeiKubun());
        t4018Entity.setHaigushaShikibetsuCd(tempEntity.getHaigushaShikibetsuCd());
        t4018Entity.setYochokinShinkokuKubun(tempEntity.getYochokinShinkokuKubun());
        t4018Entity.setYochokinGaku(tempEntity.getYochokinGaku());
        t4018Entity.setYukashoukenGaisangaku(tempEntity.getYukashoukenGaisangaku());
        t4018Entity.setSonotaKingaku(tempEntity.getSonotaKingaku());
        t4018Entity.setShinseiYMD(tempEntity.getShinseiYMD());
        t4018Entity.setKetteiYMD(tempEntity.getKetteiYMD());
        t4018Entity.setTekiyoKaishiYMD(tempEntity.getTekiyoKaishiYMD());
        t4018Entity.setTekiyoShuryoYMD(tempEntity.getTekiyoShuryoYMD());
        t4018Entity.setKetteiKubun(tempEntity.getKetteiKubun());
        t4018Entity.setHiShoninRiyu(tempEntity.getHiShoninRiyu());
        t4018Entity.setNinteiBatchExecutedTimestamp(tempEntity.getBatchShoriNitiji());
        return t4018Entity;
    }

    private DbT4036FutanGendogakuNinteiBatchTestResultsEntity insertDbT4036(ShoninKekkaTempEntity tempEntity) {
        t4036Entity = new DbT4036FutanGendogakuNinteiBatchTestResultsEntity();
        t4036Entity.setShoKisaiHokenshaNo(tempEntity.getShoKisaiHokenshaNo());
        t4036Entity.setHihokenshaNo(tempEntity.getHihokenshaNo());
        t4036Entity.setRirekiNo(tempEntity.getRirekiNo());
        t4036Entity.setKyusochishaKubun(tempEntity.getKyusochishaKubun());
        t4036Entity.setShinseiRiyuKubun(tempEntity.getShinseiRiyuKubun());
        t4036Entity.setRiyoshaFutanDankai(tempEntity.getRiyoshaFutanDankai());
        t4036Entity.setKyokaisoGaitoshaKubun(tempEntity.isKyokaisoGaitoshaKubun());
        t4036Entity.setGekihenKanwaSochiTaishoshaKubun(tempEntity.isGekihenKanwaSochiTaishoshaKubun());
        t4036Entity.setKyoshitsuShubetsu(tempEntity.getKyoshitsuShubetsu());
        t4036Entity.setShokuhiFutanGendogaku(tempEntity.getShokuhiFutanGendogaku());
        t4036Entity.setUnitTypeKoshitsu(tempEntity.getUnitTypeKoshitsu());
        t4036Entity.setUnitTypeJunKoshitsu(tempEntity.getUnitTypeJunKoshitsu());
        t4036Entity.setJuraiTypeKoshitsu_Tokuyo(tempEntity.getJuraiTypeKoshitsu_Tokuyo());
        t4036Entity.setJuraiTypeKoshitsu_Roken_Ryoyo(tempEntity.getJuraiTypeKoshitsu_Roken_Ryoyo());
        t4036Entity.setTashoshitsu(tempEntity.getTashoshitsu());
        t4036Entity.setHaigushaUmuFlag(tempEntity.isHaigushaUmuFlag());
        t4036Entity.setHaigushaShimei(tempEntity.getHaigushaShimei());
        t4036Entity.setHaigushaShimeiKana(tempEntity.getHaigushaShimeiKana());
        t4036Entity.setHaigushaSeinenGappiYMD(tempEntity.getHaigushaSeinenGappiYMD());
        t4036Entity.setHaigushaJusho(tempEntity.getHaigushaJusho());
        t4036Entity.setHaigushaRenrakusaki(tempEntity.getHaigushaRenrakusaki());
        t4036Entity.setHaigushaJusho2(tempEntity.getHaigushaJusho2());
        t4036Entity.setHaigushaKazeiKubun(tempEntity.getHaigushaKazeiKubun());
        t4036Entity.setHaigushaShikibetsuCd(tempEntity.getHaigushaShikibetsuCd());
        t4036Entity.setYochokinShinkokuKubun(tempEntity.getYochokinShinkokuKubun());
        t4036Entity.setYochokinGaku(tempEntity.getYochokinGaku());
        t4036Entity.setYukashoukenGaisangaku(tempEntity.getYukashoukenGaisangaku());
        t4036Entity.setSonotaKingaku(tempEntity.getSonotaKingaku());
        t4036Entity.setShinseiYMD(tempEntity.getShinseiYMD());
        t4036Entity.setKetteiYMD(tempEntity.getKetteiYMD());
        t4036Entity.setTekiyoKaishiYMD(tempEntity.getTekiyoKaishiYMD());
        t4036Entity.setTekiyoShuryoYMD(tempEntity.getTekiyoShuryoYMD());
        t4036Entity.setKetteiKubun(tempEntity.getKetteiKubun());
        t4036Entity.setHiShoninRiyu(tempEntity.getHiShoninRiyu());
        t4036Entity.setNinteiBatchExecutedTimestamp(tempEntity.getBatchShoriNitiji());
        return t4036Entity;
    }
}
