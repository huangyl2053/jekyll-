/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE230003.ShujiiIkenshoSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 主治医意見書作成依頼発行一覧表_バッチフロークラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
public class DBE230003_IkenshoIraiHakko extends BatchFlowBase<DBE220010_IraishoIkkatuParameter> {

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
