/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.DbT5301InsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.IkenshoSakuseiIraiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshi;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiUra;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSakuseiIraishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSakuseiRyoSeikyushoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSeikyuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkensho_DBE230004Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医意見書提出依頼書発行_バッチフロークラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class DBE240002_IkenshoIraisho extends BatchFlowBase<DBE220010_IraishoIkkatuParameter> {

    private final RDate 基準日 = RDate.getNowDate();
    private static final String SHUJIIIKENSHOSAKUSEIIRAISHO = "ShujiiIkenshoSakuseiIraishoProcess";
    private static final String IKENSHOSAKUSEIIRAIICHIRANHYO = "IkenshoSakuseiIraiIchiranhyoProcess";
    private static final String 主治医意見書記入用紙 = "KinyuYoshi";
    private static final String 主治医意見書記入用紙_裏 = "KinyuYoshiUra";
    private static final String IKENSHOSAKUSEIRYOSEIKYUSHO = "ShujiiIkenshoSakuseiRyoSeikyushoProcess";
    private static final String SHUJIIIKENSHOSEIKYUICHIRAN = "shujiiIkenshoSeikyuIchiranProcess";
    private static final String SHUJIIIKENSHO_DBE230004PROCESS = "ShujiiIkensho_DBE230004Process";
    private static final String DBT5301INSERTPROCESS = "DbT5301InsertProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isShujiiIkenshoSakuseiIraisho()) {
            executeStep(SHUJIIIKENSHOSAKUSEIIRAISHO);
        }
        if (getParameter().isIkenshoSakuseiIraiIchiran()) {
            executeStep(IKENSHOSAKUSEIIRAIICHIRANHYO);
        }
        if (getParameter().isIkenshoKinyu()) {
            call主治医意見書記入用紙();
        }
        if (getParameter().isIkenshoSakuseiSeikyusho()) {
            executeStep(IKENSHOSAKUSEIRYOSEIKYUSHO);
        }
        if (getParameter().isIkenshoSakuseiSeikyuIchiran()) {
            executeStep(SHUJIIIKENSHOSEIKYUICHIRAN);
        }
        if (getParameter().isIkenshoSakuseiRirekiIchiran()) {
            executeStep(SHUJIIIKENSHO_DBE230004PROCESS);
        }
        executeStep(DBT5301INSERTPROCESS);
    }

    private void call主治医意見書記入用紙() {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_表, 基準日, SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_裏, 基準日, SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        executeStep(主治医意見書記入用紙);
        if (!表_帳票ID.equals(裏_帳票ID)) {
            executeStep(主治医意見書記入用紙_裏);
        }
    }

    /**
     * 帳票「DBE230001_主治医意見書作成依頼書」を出力します。
     *
     * @return ShujiiIkenshoSakuseiIraishoProcess
     */
    @Step(SHUJIIIKENSHOSAKUSEIIRAISHO)
    protected IBatchFlowCommand shujiiIkenshoSakuseiIraishoProcess() {
        return loopBatch(ShujiiIkenshoSakuseiIraishoProcess.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 帳票「DBE230002_主治医意見書作成依頼一覧表」を出力します。
     *
     * @return IkenshoSakuseiIraiIchiranhyoProcess
     */
    @Step(IKENSHOSAKUSEIIRAIICHIRANHYO)
    protected IBatchFlowCommand ikenshoSakuseiIraiIchiranhyoProcess() {
        return loopBatch(IkenshoSakuseiIraiIchiranhyoProcess.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 主治医意見書記入用紙_片面を出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙)
    protected IBatchFlowCommand callKinyuYoshiKatamenProcess() {
        return loopBatch(KinyuYoshi.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 主治医意見書記入用紙_両面を出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_裏)
    protected IBatchFlowCommand callKinyuYoshiRyomenProcess() {
        return loopBatch(KinyuYoshiUra.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 帳票「DBE234001_主治医意見書作成料請求書」を出力します。
     *
     * @return ShujiiIkenshoSakuseiRyoSeikyushoProcess
     */
    @Step(IKENSHOSAKUSEIRYOSEIKYUSHO)
    protected IBatchFlowCommand shujiiIkenshoSakuseiRyoSeikyushoProcess() {
        return loopBatch(ShujiiIkenshoSakuseiRyoSeikyushoProcess.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 帳票「DBE013006_主治医意見書作成料請求一覧表」を出力します。
     *
     * @return ShujiiIkenshoSeikyuIchiranProcess
     */
    @Step(SHUJIIIKENSHOSEIKYUICHIRAN)
    protected IBatchFlowCommand callShujiiIkenshoSeikyuIchiranProcess() {
        return loopBatch(ShujiiIkenshoSeikyuIchiranProcess.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 帳票「DBE230004_主治医意見書作成依頼履歴一覧」を出力します。
     *
     * @return ShujiiIkensho_DBE230004Process
     */
    @Step(SHUJIIIKENSHO_DBE230004PROCESS)
    protected IBatchFlowCommand callShujiiIkensho_DBE230004Process() {
        return loopBatch(ShujiiIkensho_DBE230004Process.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

    /**
     * 主治医意見書作成依頼情報テーブルの更新処理です。
     *
     * @return DbT5301InsertProcess
     */
    @Step(DBT5301INSERTPROCESS)
    protected IBatchFlowCommand callDbT5301InsertProcess() {
        return loopBatch(DbT5301InsertProcess.class)
                .arguments(getParameter().toShujiiIkenshoProcessParamter()).define();
    }

}
