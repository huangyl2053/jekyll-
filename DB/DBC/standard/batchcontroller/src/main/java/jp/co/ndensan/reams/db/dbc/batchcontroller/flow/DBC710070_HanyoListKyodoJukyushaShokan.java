/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710070.HanyoListKyodoJukyushaShokanProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710070.DBC710070_HanyoListKyodoJukyushaShokanParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト 共同処理用受給者情報（償還）のフロークラスです。
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
public class DBC710070_HanyoListKyodoJukyushaShokan extends BatchFlowBase<DBC710070_HanyoListKyodoJukyushaShokanParameter> {

    private static final String 共同処理用受給者情報_償還 = "hanyoListKyodoJukyushaShokanProcess";

    @Override
    protected void defineFlow() {
        executeStep(共同処理用受給者情報_償還);
    }

    @Step(共同処理用受給者情報_償還)
    IBatchFlowCommand hanyoListKyodoJukyushaOutputProcess() {
        return loopBatch(HanyoListKyodoJukyushaShokanProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

}
