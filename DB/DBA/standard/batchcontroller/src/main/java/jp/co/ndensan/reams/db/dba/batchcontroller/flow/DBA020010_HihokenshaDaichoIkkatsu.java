/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA020010.HihokenshaDaichoHakkoIchiranhyoProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA020010.HihokenshaDaichoProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA020010.DBA020010_HihokenshaDaichoIkkatsuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 被保険者台帳一括作成_バッチフロークラスです。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
public class DBA020010_HihokenshaDaichoIkkatsu extends BatchFlowBase<DBA020010_HihokenshaDaichoIkkatsuParameter> {

    private static final String HIHOKENSHADAICHOPROCESS = "hihokenshaDaichoProcess";
    private static final String HAKKOICHIRANHYOPROCESS = "hakkoIchiranhyoProcess";

    @Override
    protected void defineFlow() {
        executeStep(HIHOKENSHADAICHOPROCESS);
        if (getParameter().isShutsuryokuFlag()) {
            executeStep(HAKKOICHIRANHYOPROCESS);
        }
    }

    /**
     * 帳票「被保険者台帳」の出力Processです。
     *
     * @return hihokenshaDaichoProcess
     */
    @Step(HIHOKENSHADAICHOPROCESS)
    protected IBatchFlowCommand hihokenshaDaichoReportProcess() {
        return loopBatch(HihokenshaDaichoProcess.class)
                .arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 帳票「保険者台帳発行一覧表」の出力Processです。
     *
     * @return HihokenshaDaichoHakkoIchiranhyoProcess
     */
    @Step(HAKKOICHIRANHYOPROCESS)
    protected IBatchFlowCommand hakkoIchiranhyoReportProcess() {
        return loopBatch(HihokenshaDaichoHakkoIchiranhyoProcess.class)
                .arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }
}
