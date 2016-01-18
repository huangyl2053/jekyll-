    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.kyokaisoggaitosha;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.kyokaisoggaitoshareportprocess.KyokaisogGaitoshaReportPageBreakProcess;
import jp.co.ndensan.reams.db.dbu.definition.core.kyokaisogaitoshabatchparameter.KyokaisoKanriMasterListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * バッチ設計_DBUMN52001_境界層管理マスタリストフロです。
 */
public class KyokaisogGaitoshaFlow extends BatchFlowBase<KyokaisoKanriMasterListBatchParameter> {

    private static final String KYOKAISOG_REPORT_PROCESS = "KyokaisoKanriMasterListBatchParameterSakusei";

    @Override
    protected void defineFlow() {
        executeStep(KYOKAISOG_REPORT_PROCESS);
    }

    /**
     * kyokaisogGaitoshaReportProcess。
     *
     * @return KyokaisogGaitoshaReportPageBreakProcesss
     */
    @Step(KYOKAISOG_REPORT_PROCESS)
    protected IBatchFlowCommand kyokaisogGaitoshaReportProcess() {
        return loopBatch(KyokaisogGaitoshaReportPageBreakProcess.class)
                .arguments(getParameter().toKyokaisoGaitoshaProcessParameter())
                .define();
    }
}
