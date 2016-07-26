/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金特徴回付情報の抽出のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class NenkinTokuChoKaifuJohoSelectProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic."
            + "IUeT0511NenkinTokuchoKaifuJohoMapper.selectAllNoDeleted");
    private static final RString T_特徴回付情報TMP = new RString("NenkinTokuchoKaifuJohoTemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 特徴回付情報Temp;

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
    }

    @Override
    protected void createWriter() {
        特徴回付情報Temp = new BatchEntityCreatedTempTableWriter(T_特徴回付情報TMP,
                UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void afterExecute() {
        TokuChoSoufuJohoSakuseiBatch sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511Entitys = sakuseiBatch.selectNenkinTokuChoKaifuJoho(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), parameter.get遷移元メニュー());
        for (UeT0511NenkinTokuchoKaifuJohoEntity entity : uet0511Entitys) {
            特徴回付情報Temp.insert(entity);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
