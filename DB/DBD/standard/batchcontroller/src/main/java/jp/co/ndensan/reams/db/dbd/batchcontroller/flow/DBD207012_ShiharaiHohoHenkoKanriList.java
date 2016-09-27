/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoHaakuFourProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoHaakuOneProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoHaakuThreeProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoHaakuTwoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoKanrFiveProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoHenkoKanriTempTableInsertProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD207012.DBD207012_ShiharaiHohoHenkoKanriListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ「支払方法変更管理リスト作成」のフロークラスです．
 *
 * @reamsid_L DBD-3630-040 x_lilh
 */
public class DBD207012_ShiharaiHohoHenkoKanriList extends BatchFlowBase<DBD207012_ShiharaiHohoHenkoKanriListParameter> {

    private static final String 支払方法変更管理対象者抽出 = "shiharaiHohoHenkoKanri";
    private static final String 支払方法変更_収納情報テーブル_PROCESS = "shiharaiHohoHenkoHaakuOneProcess";
    private static final String 償還未払い情報一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuTwoProcess";
    private static final String 滞納者対策最大履歴一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuThreeProcess";
    private static final String 滞納者対策情報一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuFourProcess";
    private static final String 帳票印字用データ_PROCESS = "shiharaiHohoHenkoHaakuFiveProcess";

    @Override
    protected void defineFlow() {
        executeStep(支払方法変更管理対象者抽出);
        executeStep(支払方法変更_収納情報テーブル_PROCESS);
        executeStep(償還未払い情報一時テーブル_PROCESS);
        executeStep(滞納者対策最大履歴一時テーブル_PROCESS);
        executeStep(滞納者対策情報一時テーブル_PROCESS);
        executeStep(帳票印字用データ_PROCESS);

    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(支払方法変更管理対象者抽出)
    protected IBatchFlowCommand shiharaiHohoHenkoKanri() {
        return loopBatch(ShiharaiHohoHenkoKanriTempTableInsertProcess.class)
                .arguments(getParameter().toShiharaiHohoHenkoKanriProcessParameter()).define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(支払方法変更_収納情報テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuOneProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuOneProcess.class)
                .arguments(getParameter().toShiharaiHohoHenkoHaakuOneProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(償還未払い情報一時テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuTwoProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuTwoProcess.class)
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(滞納者対策最大履歴一時テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuThreeProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuThreeProcess.class)
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(滞納者対策情報一時テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuFourProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuFourProcess.class)
                .define();
    }

    /**
     * 帳票印字用データ_PROCESS
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票印字用データ_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuFiveProcess() {
        return loopBatch(ShiharaiHohoHenkoKanrFiveProcess.class)
                .arguments(getParameter().toShiharaiHohoHenkoHaakuFiveProcessParameter())
                .define();
    }
}
