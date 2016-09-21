    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.kyokaisoggaitoshareportprocess.KyokaisogGaitoshaReportPageBreakProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU060010.DBU060010_KyokaisoKanriMasterListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * バッチ設計_DBUMN52001_境界層管理マスタリストフロです。
 *
 * @reamsid_L DBU-1050-020 wanghui
 */
public class DBU060010_KyokaisoKanriMasterList extends BatchFlowBase<DBU060010_KyokaisoKanriMasterListParameter> {

    private static final String KYOKAISOG_REPORT_PROCESS = "KyokaisogGaitoshaReportPageBreakProcess";

    @Override
    protected void defineFlow() {
        executeStep(KYOKAISOG_REPORT_PROCESS);
    }

    /**
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(KYOKAISOG_REPORT_PROCESS)
    protected IBatchFlowCommand kyokaisogGaitoshaReportProcess() {
        return loopBatch(KyokaisogGaitoshaReportPageBreakProcess.class)
                .arguments(getParameter().toKyokaisoGaitoshaProcessParameter())
                .define();
    }
}
