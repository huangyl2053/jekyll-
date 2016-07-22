/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.DBDBT13011;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBDBT13011.GeneralPurposeListOutputExecProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT13011.GeneralPurposeListOutputParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.DBDBT13011.GeneralPurposeListOutputProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)フロークラスです．
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class GeneralPurposeListOutputFlow extends BatchFlowBase<GeneralPurposeListOutputParameter> {

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
        GeneralPurposeListOutputParameter parameter = getParameter();
        return parameter.toGeneralPurposeListOutputProcessParameter(parameter.get抽出方法区分(), parameter.get抽出項目区分(),
                parameter.get基準日(), parameter.get日付範囲From(),
                parameter.get日付範囲To(), parameter.is直近データ抽出(), parameter.get喪失区分(), parameter.is項目名付加(),
                parameter.is連番付加(), parameter.is日付スラッシュ付加(),
                parameter.get宛名抽出条件(), parameter.get出力順(), parameter.get出力項目());
    }
}
