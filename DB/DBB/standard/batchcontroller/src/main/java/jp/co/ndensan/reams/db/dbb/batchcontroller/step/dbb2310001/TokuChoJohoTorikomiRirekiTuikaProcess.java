/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護特別徴収情報取込履歴追加のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class TokuChoJohoTorikomiRirekiTuikaProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic."
            + "IUeT0511NenkinTokuchoKaifuJohoMapper.selectAllNoDeleted");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;

    @BatchWriter
    BatchPermanentTableWriter<UeT1704KaigoTokuchoTorikomiRirekiEntity> ueT1704Writer;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        システム日時 = parameter.getシステム日時();
    }

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

        UeT1704KaigoTokuchoTorikomiRirekiEntity uet1704Entity = sakuseiBatch.intTokuChoJohoTorikomiRireki(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), parameter.get遷移元メニュー(), システム日時);
        ueT1704Writer.insert(uet1704Entity);
    }
}
