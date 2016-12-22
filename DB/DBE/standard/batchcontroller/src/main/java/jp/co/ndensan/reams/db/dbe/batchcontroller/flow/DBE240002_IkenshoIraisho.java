/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.DbT5301InsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.IkenshoSakuseiIraiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiKatamenDesign;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiKatamenOCR;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiRyomen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiRyomenDesign;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.KinyuYoshiRyomenOCR;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSakuseiIraishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSakuseiRyoSeikyushoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoSeikyuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002.ShujiiIkenshoTeishutsuIraishoProcess;
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
    private static final String IKENSHOSAKUSEIIRAIICHIRANHYO = "IkenshoSakuseiIraiIchiranhyoProcess";
    private static final String SHUJIIIKENSHOSAKUSEIIRAISHO = "ShujiiIkenshoSakuseiIraishoProcess";
    private static final String IKENSHOSAKUSEIRYOSEIKYUSHO = "ShujiiIkenshoSakuseiRyoSeikyushoProcess";
    private static final String SHUJIIIKENSHOTEISHUTSUIRAISHO = "ShujiiIkenshoTeishutsuIraishoProcess";
    private static final String SHUJIIIKENSHOSEIKYUICHIRAN = "shujiiIkenshoSeikyuIchiranProcess";
    private static final String SHUJIIIKENSHO_DBE231002PROCESS = "ShujiiIkensho_DBE231002Process";
    private static final String SHUJIIIKENSHO_DBE231014PROCESS = "ShujiiIkensho_DBE231014Process";
    private static final String SHUJIIIKENSHO_DBE231012PROCESS = "ShujiiIkensho_DBE231012Process";
    private static final String SHUJIIIKENSHO_DBE230004PROCESS = "ShujiiIkensho_DBE230004Process";
    private static final String DBT5301INSERTPROCESS = "DbT5301InsertProcess";
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString DBE231012 = new RString("DBE231012_ikenshokinyuyoshiOCR.rse");
    private static final RString DBE231014 = new RString("DBE231014_ikenshokinyuyoshiOCR.rse");
    private static final RString DBE231002 = new RString("DBE231002_ikenshokinyuyoshi.rse");
    private static final String 主治医意見書記入用紙_片面 = "KinyuYoshiKatamen";
    private static final String 主治医意見書記入用紙_両面 = "KinyuYoshiRyomen";
    private static final String 主治医意見書記入用紙_片面_OCR = "KinyuYoshiKatamenOCR";
    private static final String 主治医意見書記入用紙_両面_OCR = "KinyuYoshiRyomenOCR";
    private static final String 主治医意見書記入用紙_片面_デザイン = "KinyuYoshiKatamenDesign";
    private static final String 主治医意見書記入用紙_両面_デザイン = "KinyuYoshiRyomenDesign";
    
    @Override
    protected void defineFlow() {
        if (getParameter().isIkenshoSakuseiirai()) {
            executeStep(IKENSHOSAKUSEIIRAIICHIRANHYO);
        }
        if (getParameter().isIkenshoSakuseiSeikyuu()) {
            executeStep(SHUJIIIKENSHOSEIKYUICHIRAN);
        }
        if (getParameter().isShujiiIkenshoSakuseiIraisho()) {
            executeStep(SHUJIIIKENSHOSAKUSEIIRAISHO);
        }
        if (getParameter().isIkenshoKinyuu()) {
            call主治医意見書記入用紙();
        }
        if (getParameter().isIkenshoKinyuuOCR()) {
            call主治医意見書記入用紙OCR();
        }
        if (getParameter().isIkenshoKinyuuDesign()) {
            call主治医意見書記入用紙デザイン();
        }
        if (getParameter().isIkenshoSakuseiSeikyuusho()) {
            executeStep(IKENSHOSAKUSEIRYOSEIKYUSHO);
        }
        if (getParameter().isIkenshoTeishutu()) {
            executeStep(SHUJIIIKENSHOTEISHUTSUIRAISHO);
        }
        if (getParameter().is主治医意見書依頼履歴一覧()) {
            executeStep(SHUJIIIKENSHO_DBE230004PROCESS);
        }
        executeStep(DBT5301INSERTPROCESS);
    }

    private void call主治医意見書記入用紙() {
        RString 業務コンフィグ意見書印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE1.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_片面);
        } else if (CONFIGVALUE2.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_両面);
        }
    }

    private void call主治医意見書記入用紙OCR() {
        RString 業務コンフィグ意見書印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE1.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_片面_OCR);
        } else if (CONFIGVALUE2.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_両面_OCR);
        }
    }

    private void call主治医意見書記入用紙デザイン() {
        RString 業務コンフィグ意見書印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE1.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_片面_デザイン);
        } else if (CONFIGVALUE2.equals(業務コンフィグ意見書印刷タイプ)) {
            executeStep(主治医意見書記入用紙_両面_デザイン);
        }
    }

    /**
     * 帳票「DBE013006_主治医意見書作成料請求一覧表」を出力します。
     *
     * @return ShujiiIkenshoSeikyuIchiranProcess
     */
    @Step(SHUJIIIKENSHOSEIKYUICHIRAN)
    protected IBatchFlowCommand callShujiiIkenshoSeikyuIchiranProcess() {
        return loopBatch(ShujiiIkenshoSeikyuIchiranProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE230002_主治医意見書作成依頼一覧表」を出力します。
     *
     * @return IkenshoSakuseiIraiIchiranhyoProcess
     */
    @Step(IKENSHOSAKUSEIIRAIICHIRANHYO)
    protected IBatchFlowCommand ikenshoSakuseiIraiIchiranhyoProcess() {
        return loopBatch(IkenshoSakuseiIraiIchiranhyoProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE230001_主治医意見書作成依頼書」を出力します。
     *
     * @return ShujiiIkenshoSakuseiIraishoProcess
     */
    @Step(SHUJIIIKENSHOSAKUSEIIRAISHO)
    protected IBatchFlowCommand shujiiIkenshoSakuseiIraishoProcess() {
        return loopBatch(ShujiiIkenshoSakuseiIraishoProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE234001_主治医意見書作成料請求書」を出力します。
     *
     * @return ShujiiIkenshoSakuseiRyoSeikyushoProcess
     */
    @Step(IKENSHOSAKUSEIRYOSEIKYUSHO)
    protected IBatchFlowCommand shujiiIkenshoSakuseiRyoSeikyushoProcess() {
        return loopBatch(ShujiiIkenshoSakuseiRyoSeikyushoProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE236001_介護保険指定医依頼兼主治医意見書提出依頼書」を出力します。
     *
     * @return ShujiiIkenshoTeishutsuIraishoProcess
     */
    @Step(SHUJIIIKENSHOTEISHUTSUIRAISHO)
    protected IBatchFlowCommand shujiiIkenshoTeishutsuIraishoProcess() {
        return loopBatch(ShujiiIkenshoTeishutsuIraishoProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
//
//    /**
//     * 帳票「DBE231002_主治医意見書記入用紙」を出力します。
//     *
//     * @return ShujiiIkensho_DBE231002Process
//     */
//    @Step(SHUJIIIKENSHO_DBE231002PROCESS)
//    protected IBatchFlowCommand callShujiiIkensho_DBE231002Process() {
//        return loopBatch(ShujiiIkensho_DBE231002Process.class)
//                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
//    }
//
//    /**
//     * 帳票「DBE231014_主治医意見書記入用紙」を出力します。
//     *
//     * @return ShujiiIkensho_DBE231014Process
//     */
//    @Step(SHUJIIIKENSHO_DBE231014PROCESS)
//    protected IBatchFlowCommand callShujiiIkensho_DBE231014Process() {
//        return loopBatch(ShujiiIkensho_DBE231014Process.class)
//                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
//    }
//
//    /**
//     * 帳票「DBE231012_主治医意見書記入用紙」を出力します。
//     *
//     * @return ShujiiIkensho_DBE231012Process
//     */
//    @Step(SHUJIIIKENSHO_DBE231012PROCESS)
//    protected IBatchFlowCommand callShujiiIkensho_DBE231012Process() {
//        return loopBatch(ShujiiIkensho_DBE231012Process.class)
//                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
//    }

    /**
     * 帳票「DBE230004_主治医意見書作成依頼履歴一覧」を出力します。
     *
     * @return ShujiiIkensho_DBE230004Process
     */
    @Step(SHUJIIIKENSHO_DBE230004PROCESS)
    protected IBatchFlowCommand callShujiiIkensho_DBE230004Process() {
        return loopBatch(ShujiiIkensho_DBE230004Process.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 主治医意見書作成依頼情報テーブルの更新処理です。
     *
     * @return DbT5301InsertProcess
     */
    @Step(DBT5301INSERTPROCESS)
    protected IBatchFlowCommand callDbT5301InsertProcess() {
        return loopBatch(DbT5301InsertProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 主治医意見書記入用紙_片面を出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_片面)
    protected IBatchFlowCommand callKinyuYoshiKatamenProcess() {
        return loopBatch(KinyuYoshiKatamen.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
    /**
     * 主治医意見書記入用紙_両面を出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_両面)
    protected IBatchFlowCommand callKinyuYoshiRyomenProcess() {
        return loopBatch(KinyuYoshiRyomen.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
    /**
     * 主治医意見書記入用紙_片面_OCRを出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_片面_OCR)
    protected IBatchFlowCommand callKinyuYoshiKatamenOCRProcess() {
        return loopBatch(KinyuYoshiKatamenOCR.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
    /**
     * 主治医意見書記入用紙_両面_OCRを出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_両面_OCR)
    protected IBatchFlowCommand callKinyuYoshiRyomenOCRProcess() {
        return loopBatch(KinyuYoshiRyomenOCR.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
    /**
     * 主治医意見書記入用紙_片面_デザインを出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_片面_デザイン)
    protected IBatchFlowCommand callKinyuYoshiKatamenDesignProcess() {
        return loopBatch(KinyuYoshiKatamenDesign.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
    /**
     * 主治医意見書記入用紙_両面_デザインを出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医意見書記入用紙_両面_デザイン)
    protected IBatchFlowCommand callKinyuYoshiRyomenDesignProcess() {
        return loopBatch(KinyuYoshiRyomenDesign.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
}
