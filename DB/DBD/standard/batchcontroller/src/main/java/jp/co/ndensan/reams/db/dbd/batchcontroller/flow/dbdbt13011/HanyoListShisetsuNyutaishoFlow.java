/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13011;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13011.GeneralPurposeListOutputExecProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt13011.HanyoListShisetsuNyutaishoBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt13011.GeneralPurposeListOutputProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)フロークラスです．
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class HanyoListShisetsuNyutaishoFlow extends BatchFlowBase<HanyoListShisetsuNyutaishoBatchParameter> {

    private static final String BATCH_PROCESS = "batchProcess";

    @Override
    protected void defineFlow() {
        executeStep(BATCH_PROCESS);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(BATCH_PROCESS)
    protected IBatchFlowCommand batchExecProcess() {
        return loopBatch(GeneralPurposeListOutputExecProcess.class)
                .arguments(createParameter()).define();
    }

    private GeneralPurposeListOutputProcessParameter createParameter() {
        HanyoListShisetsuNyutaishoBatchParameter parameter = getParameter();
        return parameter.toGeneralPurposeListOutputProcessParameter();
    }
}
