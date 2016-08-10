/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.flow.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei.AtenaCheckReportProcess;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei.DaityouCheckReportProcess;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei.TempInsertReportBProcess;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei.TempInsertReportDProcess;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.seigoseichekkurisutosakusei.SeigoseiChekkuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 整合性チェックリストのバッチフロークラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
public class SeigoseiChekkuRisutoFlow extends BatchFlowBase<SeigoseiChekkuBatchParameter> {

    private static final String TEMP_INSERTB = "tempInsertReportB";
    private static final String TEMP_INSERTD = "tempInsertReportD";
    private static final String 宛名のエラーチェック = "atenaCheckReport";
    private static final String 被保険者台帳のエラーチェック = "daityouCheckReport";

    @Override
    protected void defineFlow() {
        executeStep(TEMP_INSERTB);
        executeStep(宛名のエラーチェック);
        executeStep(TEMP_INSERTD);
        executeStep(被保険者台帳のエラーチェック);
    }

    /**
     * 整合性チェック情報一時ファイルBを行います。
     *
     * @return バッチコマンド
     */
    @Step(TEMP_INSERTB)
    protected IBatchFlowCommand tempInsertReportB() {
        return loopBatch(TempInsertReportBProcess.class)
                .arguments(getParameter().toSeigoseiBatchProcessParamter())
                .define();
    }

    /**
     * 整合性チェック情報一時ファイルDを行います。
     *
     * @return バッチコマンド
     */
    @Step(TEMP_INSERTD)
    protected IBatchFlowCommand tempInsertReportD() {
        return loopBatch(TempInsertReportDProcess.class)
                .arguments(getParameter().toSeigoseiBatchProcessParamter())
                .define();
    }

    /**
     * 宛名のエラーチェックを行います。
     *
     * @return バッチコマンド
     */
    @Step(宛名のエラーチェック)
    protected IBatchFlowCommand atenaCheckReport() {
        return loopBatch(AtenaCheckReportProcess.class)
                .arguments(getParameter().toSeigoseiBatchProcessParamter())
                .define();
    }

    /**
     * 被保険者台帳のエラーチェックを行います。
     *
     * @return バッチコマンド
     */
    @Step(被保険者台帳のエラーチェック)
    protected IBatchFlowCommand daityouCheckReport() {
        return loopBatch(DaityouCheckReportProcess.class)
                .arguments(getParameter().toSeigoseiBatchProcessParamter())
                .define();
    }
}
