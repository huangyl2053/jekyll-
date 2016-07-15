/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc020010;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010.KogakuKaigoKyufuhiTaishoshaTorokuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 高額介護サービス費給付対象者登録のバッチフロークラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
public class KogakuKaigoServicehiKyufutaishoshaTorokuFlow extends BatchFlowBase<KogakuKaigoKyufuhiTaishoshaBatchParameter> {

    private static final String 高額介護費給付対象者登録 = "KogakuKaigoKyufuhiTaishoshaToroku";

    @Override
    protected void defineFlow() {
        executeStep(高額介護費給付対象者登録);
    }

    /**
     * 高額介護費給付対象者登録情報を取得するクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(高額介護費給付対象者登録)
    protected IBatchFlowCommand callGetMiDoteiJohoProcess() {
        return loopBatch(KogakuKaigoKyufuhiTaishoshaTorokuProcess.class).
                arguments(getParameter().toCreateGyomuHokenshaJohoGetsujiProcessParameter()).define();
    }

}
