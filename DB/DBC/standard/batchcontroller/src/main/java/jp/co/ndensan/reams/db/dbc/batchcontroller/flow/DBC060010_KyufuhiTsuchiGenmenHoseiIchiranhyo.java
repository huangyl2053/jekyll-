/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060010.KyufuhiTsuchiGenmenHoseiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060010.DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 給付費通知減免補正一覧表クラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
public class DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyo
        extends BatchFlowBase<DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter> {

    private static final String KYUFUTSUCHIGENMENHOSEI = "KyufuhiTsuchiGenmenHoseiIchiranhyoProcess";

    @Override
    protected void defineFlow() {
        executeStep(KYUFUTSUCHIGENMENHOSEI);
    }

    @Step(KYUFUTSUCHIGENMENHOSEI)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(KyufuhiTsuchiGenmenHoseiIchiranhyoProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

}
