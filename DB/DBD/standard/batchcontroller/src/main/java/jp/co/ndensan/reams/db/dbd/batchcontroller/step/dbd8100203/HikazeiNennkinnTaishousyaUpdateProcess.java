/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100203.HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者更新_process処理クラスです。
 *
 * @author DBD-4910-050 x_xuliang
 */
public class HikazeiNennkinnTaishousyaUpdateProcess extends BatchProcessBase<HikazeNenkinTaishoshaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "sokyuhikazeinenkintaishousyadoutei.IHikazeiNennkinnTaishousyaUpdateMapper.get非課税年金対象者情報");

    @BatchWriter
    private BatchPermanentTableWriter<DbT4037HikazeNenkinTaishoshaEntity> hikazeNenkinTableEntity;

    @Override
    protected IBatchReader createReader() {
        hikazeNenkinTableEntity = new BatchPermanentTableWriter<>(DbT4037HikazeNenkinTaishoshaEntity.class);
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(HikazeNenkinTaishoshaEntity hikazeNenkinTaishoshaEntity) {
        edit非課税年金対象者更新情報(hikazeNenkinTaishoshaEntity);
        hikazeNenkinTableEntity.update(hikazeNenkinTaishoshaEntity.getHikazeNenkinTaishoshaEntity());
    }

    private void edit非課税年金対象者更新情報(HikazeNenkinTaishoshaEntity hikazeNenkinTaishoshaEntity) {
        hikazeNenkinTaishoshaEntity.getHikazeNenkinTaishoshaEntity().setGenkisonenkinno(hikazeNenkinTaishoshaEntity.getTemp_genKisoNennkinnNo());
        hikazeNenkinTaishoshaEntity.getHikazeNenkinTaishoshaEntity().setHihokenshano(hikazeNenkinTaishoshaEntity.getTemp_hihokenshano());
    }
}
