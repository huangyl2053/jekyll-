/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100203;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.MiDouteiDataCreateProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203.SokyuHikazeiNenkinBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 遡及非課税年金対象者同定フロークラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public class SokyuHikazeiNenkinTaishousyaDouteiFlow extends BatchFlowBase<SokyuHikazeiNenkinBatchParameter> {

    private static final String 未同定データ作成 = "未同定データ作成";

    @Override
    protected void defineFlow() {
        executeStep(未同定データ作成);
    }

    /**
     * 実績データ一時作成.
     *
     * @return IBatchFlowCommand
     */
    @Step(未同定データ作成)
    protected IBatchFlowCommand jissekiDataIchijiSakuseiProcess() {
        return loopBatch(MiDouteiDataCreateProcess.class).define();
    }
}
