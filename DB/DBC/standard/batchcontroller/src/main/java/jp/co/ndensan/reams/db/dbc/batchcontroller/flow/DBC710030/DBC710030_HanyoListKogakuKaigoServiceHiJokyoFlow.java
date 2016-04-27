/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC710030;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710030.HanyoListKogakuKaigoServiceHiJokyoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(高額介護サービス費状況)のバッチ処理フロー
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
public class DBC710030_HanyoListKogakuKaigoServiceHiJokyoFlow
        extends BatchFlowBase<HanyoListKogakuKaigoBatchParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(HanyoListKogakuKaigoServiceHiJokyoProcess.class).define();
    }
}
