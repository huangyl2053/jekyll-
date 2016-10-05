/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE525002.HanteiKekkaJohoShutsuryokuProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 判定結果情報出力(保険者)のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
public class DBE525002_HanteiKekkaHokensha extends BatchFlowBase<DBE525002_HanteiKekkaHokenshaParameter> {

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
