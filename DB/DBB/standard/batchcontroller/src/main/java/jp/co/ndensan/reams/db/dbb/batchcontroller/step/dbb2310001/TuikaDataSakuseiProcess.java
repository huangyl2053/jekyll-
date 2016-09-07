/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険年金特徴対象者情報追加用データ作成のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class TuikaDataSakuseiProcess extends BatchProcessBase<
        jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic."
            + "IUeT0511NenkinTokuchoKaifuJohoMapper.selectAllNoDeleted");
    private static final RString T_対象者情報追加TMP = new RString("KaigohokenNenkinTokuchoTaishoshaJohoTemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象者情報追加Temp;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        システム日時 = parameter.getシステム日時();
    }

    @Override
    protected void createWriter() {
        対象者情報追加Temp = new BatchEntityCreatedTempTableWriter(T_対象者情報追加TMP,
                UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(
            jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity entity) {
    }

    @Override
    protected void afterExecute() {
        TokuChoSoufuJohoSakuseiBatch sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> uet0515Entitys = sakuseiBatch.setTuikaData(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), システム日時);
        for (UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity : uet0515Entitys) {
            対象者情報追加Temp.insert(entity);
        }
    }
}
