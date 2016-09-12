/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.kaigojuminhyotruku;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.kaigojuminhyotruku.KaigojuminHyotrukuDBUpdateProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyotruku.KaigojuminHyotrukuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class KaigojuminHyotrukufFlow extends BatchFlowBase<KaigojuminHyotrukuBatchParameter> {

    private static final String KAIGOJUMINHYO_DB_UPD_PROCESS = "KaigojuminHyotrukuDBUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
    }

    /**
     * DB登録またはDB更新です。
     *
     * @return 登録または更新件数
     */
    @Step(KAIGOJUMINHYO_DB_UPD_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoDBUpdateProcess() {
        return loopBatch(KaigojuminHyotrukuDBUpdateProcess.class).arguments(getParameter().toKaigoJuminhyoProcessParameter()).define();
    }
}
