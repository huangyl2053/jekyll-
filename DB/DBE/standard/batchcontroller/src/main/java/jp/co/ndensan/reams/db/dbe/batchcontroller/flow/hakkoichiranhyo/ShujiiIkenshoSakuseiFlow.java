/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshosakusei.ShujiiIkenshoSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 主治医意見書作成依頼発行一覧表_バッチフロークラスです。
 */
public class ShujiiIkenshoSakuseiFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * 帳票データ作成のProcessです。
     *
     * @return ShujiiIkenshoSakuseiProcess
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(ShujiiIkenshoSakuseiProcess.class)
                .arguments(getParameter().toShujiiIkenshoSakuseiProcessParamter()).define();
    }
}
