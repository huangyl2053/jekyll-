/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 *
 * 訪問調査依頼書発行_バッチフロークラスです。
 */
public class HomonChosaIraishoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final String ICHIRANHYOREPORT_PROCESS = "ichiranhyoReport_Process";
    private static final String CHOSAIRAISHOREPORT_PROCESS = "chosaIraishoReport_Process";

    @Override
    protected void defineFlow() {

        if (getParameter().isNinteiChosaIraiChohyo()) {
            executeStep(CHOSAIRAISHOREPORT_PROCESS);
        }
        if (getParameter().isNinteiChosaIraisyo()) {
            executeStep(ICHIRANHYOREPORT_PROCESS);
        }
    }

    /**
     * 認定調査依頼一覧表のProcessです。
     *
     * @return IraishoReportProcess
     */
//    @Step(CHOSAIRAISHOREPORT_PROCESS)
//    protected IBatchFlowCommand ichiranhyoReportProcess() {
//        return loopBatch(IchiranhyoReportProcess.class)
//                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
//    }
//
//    /**
//     * 認定調査依頼書のReportProcessです。
//     *
//     * @return IraishoReportProcess
//     */
//    @Step(ICHIRANHYOREPORT_PROCESS)
//    protected IBatchFlowCommand iraishoReportProcess() {
//        return loopBatch(IraishoReportProcess.class)
//                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
//    }
}
