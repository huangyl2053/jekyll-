/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険年金特徴対象者情報登録のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class InsKaigoNenkinTokuchoProcess extends BatchProcessBase<
        UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> {

    private static final RString PATH
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei."
                    + "ITokuChoSoufuJohoSakuseiMapper.selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll");

    @BatchWriter
    private IBatchTableWriter<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> ueT0515Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void createWriter() {
        ueT0515Writer = new BatchPermanentTableWriter(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
    }

    @Override
    protected void process(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity) {
        ueT0515Writer.insert(entity);
    }
}
