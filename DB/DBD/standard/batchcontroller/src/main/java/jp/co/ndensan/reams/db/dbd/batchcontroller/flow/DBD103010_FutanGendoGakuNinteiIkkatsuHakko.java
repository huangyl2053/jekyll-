/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010.FutanGenndoGakuNinnteiListProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010.FutanGenndoGakuNinnteiShouProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010.FutanGenndoGakuNinnteiTsuuchishoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103010.DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 負担限度額認定証・通知書一括発行フロークラスです．
 *
 * @reamsid_L DBD-3981-040 x_lilh
 */
public class DBD103010_FutanGendoGakuNinteiIkkatsuHakko extends BatchFlowBase<DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter> {

    private static final String 負担限度額認定の認定証発行 = "負担限度額認定の認定証発行";
    private static final String 負担限度額認定の通知書発行 = "負担限度額認定の通知書発行";
    private static final String 負担額認定証_決定通知書発行一覧表発行 = "負担額認定証_決定通知書発行一覧表発行";

    @Override
    protected void defineFlow() {
        DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter parameter = getParameter();
        if (parameter.is認定証発行フラグ()) {
            executeStep(負担限度額認定の認定証発行);
        }
        if (parameter.is通知書発行フラグ()) {
            executeStep(負担限度額認定の通知書発行);
        }
        executeStep(負担額認定証_決定通知書発行一覧表発行);
    }

    /**
     * 負担限度額認定の認定証発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(負担限度額認定の認定証発行)
    protected IBatchFlowCommand futanGenndoGakuNinnteiShouProcess() {
        return loopBatch(FutanGenndoGakuNinnteiShouProcess.class)
                .arguments(getParameter().toFutanGenndoGakuNinnteiShouProcessParameter())
                .define();
    }

    /**
     * 負担限度額認定の通知書発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(負担限度額認定の通知書発行)
    protected IBatchFlowCommand futanGenndoGakuNinnteiTsuuchishoProcess() {
        return loopBatch(FutanGenndoGakuNinnteiTsuuchishoProcess.class)
                .arguments(getParameter().toFutanGenndoGakuNinnteiTsuuchishoProcessParameter())
                .define();
    }

    /**
     * 負担額認定証_決定通知書発行一覧表発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(負担額認定証_決定通知書発行一覧表発行)
    protected IBatchFlowCommand futanGenndoGakuNinnteiListProcess() {
        return loopBatch(FutanGenndoGakuNinnteiListProcess.class)
                .arguments(getParameter().toFutanGenndoGakuNinnteiListProcessParameter())
                .define();
    }
}
