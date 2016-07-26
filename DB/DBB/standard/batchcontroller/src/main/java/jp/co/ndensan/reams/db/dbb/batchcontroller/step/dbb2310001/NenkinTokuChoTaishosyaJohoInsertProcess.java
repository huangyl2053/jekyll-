/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険年金特徴対象者情報登録のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class NenkinTokuChoTaishosyaJohoInsertProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic."
            + "IUeT0511NenkinTokuchoKaifuJohoMapper.selectAllNoDeleted");

    @BatchWriter
    BatchPermanentTableWriter<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> ueT0515Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
    }

    @Override
    protected void afterExecute() {
        TokuChoSoufuJohoSakuseiBatch sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> uet0515EntityList = sakuseiBatch.intNenkinTokuChoTaishosyaJoho();
        if (uet0515EntityList != null && !uet0515EntityList.isEmpty()) {
            for (UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity : uet0515EntityList) {
                ueT0515Writer.insert(entity);
            }
        }
    }
}
