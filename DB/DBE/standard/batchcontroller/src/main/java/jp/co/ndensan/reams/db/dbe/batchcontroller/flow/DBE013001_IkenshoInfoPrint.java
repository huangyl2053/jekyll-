/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShijiiIkenshoIraiHenkoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShujiiIkensho5komokuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShujiiIkenshoIraiSumiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShujiiIkenshoMiIraiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShujiiIkenshoMiteishutsuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001.ShujiiIkenshoSeikyuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE013001.DBE013001_IkenshoInfoPrintParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 意見書情報印刷発行_バッチフロークラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 *
 */
public class DBE013001_IkenshoInfoPrint extends BatchFlowBase<DBE013001_IkenshoInfoPrintParameter> {

    private static final String SHUJIIIKENSHOMIIRAI_PROCESS = "ShujiiIkenshoMiIraiProcess";
    private static final String SHIJIIIKENSHOIRAIHENKO_ROCESS = "ShijiiIkenshoIraiHenkoProcess";
    private static final String SHUJIIIKENSHOMITEISHU_PROCESS = "ShujiiIkenshoMiteishutsuProcess";
    private static final String SHUJIIIKENSHOIRAISUMI_PROCESS = "ShujiiIkenshoIraiSumiProcess";
    private static final String SHUJIIIKENSHO5KOMOKU_PROCESS = "ShujiiIkensho5komokuProcess";
    private static final String SHUJIIIKENSHOSEIKYUIC_PROCESS = "ShujiiIkenshoSeikyuIchiranProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().is主治医意見書依頼未処理者一覧表フラグ()) {
            executeStep(SHUJIIIKENSHOMIIRAI_PROCESS);
        } 
        if (getParameter().is主治医意見書作成依頼変更者一覧表フラグ()) {
            executeStep(SHIJIIIKENSHOIRAIHENKO_ROCESS);
        } 
        if (getParameter().is主治医意見書未提出者一覧フラグ()) {
            executeStep(SHUJIIIKENSHOMITEISHU_PROCESS);
        } 
        if (getParameter().is主治医意見書依頼済み一覧表フラグ()) {
            executeStep(SHUJIIIKENSHOIRAISUMI_PROCESS);
        } 
        if (getParameter().is主治医意見書５項目確認一覧表フラグ()) {
            executeStep(SHUJIIIKENSHO5KOMOKU_PROCESS);
        } 
        if (getParameter().is主治医意見書作成料請求一覧表フラグ()) {
            executeStep(SHUJIIIKENSHOSEIKYUIC_PROCESS);
        }
    }

    /**
     * 帳票「DBE013001_主治医意見書依頼未処理者一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHUJIIIKENSHOMIIRAI_PROCESS)
    protected IBatchFlowCommand ikenshoJohoPrintProcess() {
        return loopBatch(ShujiiIkenshoMiIraiProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }

    /**
     * 帳票「DBE013002_主治医意見書作成依頼変更者一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHIJIIIKENSHOIRAIHENKO_ROCESS)
    protected IBatchFlowCommand shijiiIkenshoIraiHenkoProcess() {
        return loopBatch(ShijiiIkenshoIraiHenkoProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }

    /**
     * 帳票「DBE013003_主治医意見書未提出者一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHUJIIIKENSHOMITEISHU_PROCESS)
    protected IBatchFlowCommand shujiiIkenshoMiteishutsuProcess() {
        return loopBatch(ShujiiIkenshoMiteishutsuProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }

    /**
     * 帳票「DBE013004_主治医意見書依頼済み一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHUJIIIKENSHOIRAISUMI_PROCESS)
    protected IBatchFlowCommand shujiiIkenshoIraiSumiProcess() {
        return loopBatch(ShujiiIkenshoIraiSumiProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }

    /**
     * 帳票「DBE013005_主治医意見書5項目確認一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHUJIIIKENSHO5KOMOKU_PROCESS)
    protected IBatchFlowCommand shujiiIkensho5komokuProcess() {
        return loopBatch(ShujiiIkensho5komokuProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }

    /**
     * 帳票「DBE013006_主治医意見書作成料請求一覧表」を出力します。
     *
     * @return ShujiiIkenshoMiIraiProcess
     */
    @Step(SHUJIIIKENSHOSEIKYUIC_PROCESS)
    protected IBatchFlowCommand shujiiIkenshoSeikyuIchiranProcess() {
        return loopBatch(ShujiiIkenshoSeikyuIchiranProcess.class)
                .arguments(getParameter().toIkenshoJohoPrintProcessParameter()).define();
    }
}
