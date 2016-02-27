/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.hiroshimadomain;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hiroshimadomain.HiroshimaDomainReportProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hiroshimadomain.HiroshimaDomainBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 広域内転居結果一覧表_バッチフ処理クラスです
 *
 * @author 陳奥奇
 */
public class HiroshimaDomainFlow extends BatchFlowBase<HiroshimaDomainBatchParameter> {

    private static final String REPORT_PROCESS = "hiroshimaDomainReportProcess";

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    /**
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(REPORT_PROCESS)
    private IBatchFlowCommand hiroshimaDomainReportProcess() {
        return loopBatch(HiroshimaDomainReportProcess.class).arguments(getParameter().toHiroshimaDomainProcessParameter()).define();
    }
}
