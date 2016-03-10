/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.fuka;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.fuka.SetaiShotokuKazeiHanteiUpdateProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 世帯員把握（バッチ）のバッチフロークラスです。
 */
public class SetaiShotokuKazeiHanteiFlow extends BatchFlowBase<SetaiShotokuKazeiHanteiBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(Update_PROCESS);
    }
    private static final String Update_PROCESS = "updateProcess";

    /**
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(Update_PROCESS)
    protected IBatchFlowCommand updateProcess() {
        return simpleBatch(SetaiShotokuKazeiHanteiUpdateProcess.class).arguments(getParameter().
                toSetaiShotokuKazeiHanteiProcessParameter()).define();
    }
}
