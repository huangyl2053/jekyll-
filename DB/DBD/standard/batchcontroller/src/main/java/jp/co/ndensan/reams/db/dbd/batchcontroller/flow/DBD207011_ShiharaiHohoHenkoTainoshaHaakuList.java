/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoHaakuPrintProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoHaakuTainouTaisakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoShunouStatusProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoHaakuMaxTainouTaisakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoHaakuShoukanProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011.ShiharaiHohoHenkoTainoTempTableInsertProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD207011.DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成フロークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
public class DBD207011_ShiharaiHohoHenkoTainoshaHaakuList extends BatchFlowBase<DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter> {

    private static final String 対象者情報一時テーブル_PROCESS = "taisyoJohoTempInsertProcess";
    private static final String 支払方法変更_収納情報テーブル_PROCESS = "shiharaiHohoHenkoHaakuOneProcess";
    private static final String 償還未払い情報一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuTwoProcess";
    private static final String 滞納者対策最大履歴一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuThreeProcess";
    private static final String 滞納者対策情報一時テーブル_PROCESS = "shiharaiHohoHenkoHaakuFourProcess";
    private static final String 帳票印字用データ_PROCESS = "shiharaiHohoHenkoHaakuFiveProcess";

    @Override
    protected void defineFlow() {
        executeStep(対象者情報一時テーブル_PROCESS);
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
    @Step(対象者情報一時テーブル_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(ShiharaiHohoHenkoTainoTempTableInsertProcess.class)
                .arguments(getParameter().toShiharaiHohoHenkoTainoProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(支払方法変更_収納情報テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuOneProcess() {
        return loopBatch(ShiharaiHohoHenkoShunouStatusProcess.class)
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
        return loopBatch(ShiharaiHohoHenkoHaakuShoukanProcess.class)
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(滞納者対策最大履歴一時テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuThreeProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuMaxTainouTaisakuProcess.class)
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(滞納者対策情報一時テーブル_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuFourProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuTainouTaisakuProcess.class)
                .define();
    }

    /**
     * 帳票印字用データ_PROCESS
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票印字用データ_PROCESS)
    protected IBatchFlowCommand shiharaiHohoHenkoHaakuFiveProcess() {
        return loopBatch(ShiharaiHohoHenkoHaakuPrintProcess.class).arguments(getParameter().toShiharaiHohoHenkoHaakoFiveProcessParameter())
                .define();
    }
}
