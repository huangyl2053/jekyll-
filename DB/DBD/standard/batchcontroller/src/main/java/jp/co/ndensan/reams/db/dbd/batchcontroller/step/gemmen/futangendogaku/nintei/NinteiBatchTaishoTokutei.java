/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchTaishoTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatchEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.temptable.ShoriTaishoTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku.INinteiBatchTaishoTokuteiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請一括承認（バッチ）_処理対象の特定のprocess処理クラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public class NinteiBatchTaishoTokutei extends BatchProcessBase<DbT4018KaigoHokenFutanGendogakuNinteiEntity> {

    private NinteiBatchTaishoTokuteiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku."
                    + "INinteiBatchTaishoTokuteiMapper.selectAll");
    @BatchWriter
    private BatchPermanentTableWriter<DbT4035FutanGendogakuNinteiBatchEntity> dbT4035TableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter shoriTaishoTempWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter taishoshaHanteiyoTempWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinteiBatchTaishoTokuteiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT4035TableWriter = new BatchPermanentTableWriter<>(DbT4035FutanGendogakuNinteiBatchEntity.class);
        shoriTaishoTempWriter = new BatchEntityCreatedTempTableWriter(ShoriTaishoTempEntity.TABLE_NAME,
                ShoriTaishoTempEntity.class);
        taishoshaHanteiyoTempWriter
                = new BatchEntityCreatedTempTableWriter(GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.TABLE_NAME,
                        GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.class);
    }

    @Override
    protected void beforeExecute() {
        DbT4035FutanGendogakuNinteiBatchEntity t4035Entity = new DbT4035FutanGendogakuNinteiBatchEntity();
        t4035Entity.setNinteiBatchExecutedTimestamp(parameter.getバッチ処理日時());
        t4035Entity.setKetteiYmd(parameter.get決定日());
        t4035Entity.setSakuseiNendo(parameter.get作成年度());
        t4035Entity.setIsTest(parameter.isテスト処理());
        t4035Entity.setHadApproved(!parameter.isテスト処理());
        dbT4035TableWriter.insert(t4035Entity);
        getMapper(INinteiBatchTaishoTokuteiMapper.class).deleteAll();
    }

    @Override
    protected void process(DbT4018KaigoHokenFutanGendogakuNinteiEntity entity) {
        ShoriTaishoTempEntity shoriTaishoTempEntity = new ShoriTaishoTempEntity();
        GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity taishoshaHanteiyoTempEntity
                = new GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity();
        shoriTaishoTempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        shoriTaishoTempEntity.setRirekiNo(entity.getRirekiNo());
        shoriTaishoTempWriter.insert(shoriTaishoTempEntity);
        taishoshaHanteiyoTempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        taishoshaHanteiyoTempEntity.setKijunYMD(entity.getShinseiYMD());
        taishoshaHanteiyoTempWriter.insert(taishoshaHanteiyoTempEntity);
    }
}
