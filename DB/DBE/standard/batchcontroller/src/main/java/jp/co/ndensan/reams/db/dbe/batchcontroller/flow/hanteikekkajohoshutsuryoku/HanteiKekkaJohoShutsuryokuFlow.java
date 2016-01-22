/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hanteikekkajohoshutsuryoku;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 判定結果情報出力(保険者)のバッチ処理クラスです。
 */
public class HanteiKekkaJohoShutsuryokuFlow extends BatchFlowBase<HanteiKekkaJohoShutsuryokuBatchParamter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORTPROCESS);
    }

    private static final String REPORTPROCESS = "hanteikekkajohoshutsuryokuprocess";

    /**
     * 判定結果情報出力(保険者)帳票データを作成します。
     *
     * @return HanteiKekkaJohoShutsuryokuProcess
     */
    @Step(REPORTPROCESS)
    protected IBatchFlowCommand hanteiKekkaJohoShutsuryokuProcess() {
        return loopBatch(HanteiKekkaJohoShutsuryokuProcess.class)
                .arguments(getParameter().toHanteiKekkaJohoShutsuryokuProcessParamter()).define();
    }
}
