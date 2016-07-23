/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.DbT5301InsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.IkenshoSakuseiIraiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSakuseiIraishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSakuseiRyoSeikyushoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSeikyuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoTeishutsuIraishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkensho_DBE231002Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkensho_DBE231012Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkensho_DBE231014Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
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
public class ShujiiIkenshoTeishutsuIraishoHakkoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final String IKENSHOSAKUSEIIRAIICHIRANHYO = "IkenshoSakuseiIraiIchiranhyoProcess";

    private static final String SHUJIIIKENSHOSAKUSEIIRAISHO = "ShujiiIkenshoSakuseiIraishoProcess";
    private static final String IKENSHOSAKUSEIRYOSEIKYUSHO = "ShujiiIkenshoSakuseiRyoSeikyushoProcess";
    private static final String SHUJIIIKENSHOTEISHUTSUIRAISHO = "ShujiiIkenshoTeishutsuIraishoProcess";
    private static final String SHUJIIIKENSHOSEIKYUICHIRAN = "shujiiIkenshoSeikyuIchiranProcess";
    private static final String SHUJIIIKENSHO_DBE231002PROCESS = "ShujiiIkensho_DBE231002Process";
    private static final String SHUJIIIKENSHO_DBE231014PROCESS = "ShujiiIkensho_DBE231014Process";
    private static final String SHUJIIIKENSHO_DBE231012PROCESS = "ShujiiIkensho_DBE231012Process";
    private static final String DBT5301INSERTPROCESS = "DbT5301InsertProcess";
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString DBE231012 = new RString("DBE231012_ikenshokinyuyoshiOCR.rse");
    private static final RString DBE231014 = new RString("DBE231014_ikenshokinyuyoshiOCR.rse");
    private static final RString DBE231002 = new RString("DBE231002_ikenshokinyuyoshi.rse");

    @Override
    protected void defineFlow() {
        executeStep(SHUJIIIKENSHOSEIKYUICHIRAN);
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
        if (getParameter().isIkenshoSakuseiSeikyuusho()) {
            executeStep(IKENSHOSAKUSEIRYOSEIKYUSHO);
        }
        if (getParameter().isIkenshoTeishutu()) {
            executeStep(SHUJIIIKENSHOTEISHUTSUIRAISHO);
        }
        executeStep(DBT5301INSERTPROCESS);
    }

    private void call主治医意見書記入用紙() {
        RDate 基準日 = RDate.getNowDate();
        if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面1枚目1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面1枚目2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面1枚目3, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面2枚目1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面2枚目2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面2枚目3, 基準日,
                        SubGyomuCode.DBE認定支援));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー両面1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー両面2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー両面3, 基準日,
                        SubGyomuCode.DBE認定支援));
            }
        }
        if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面1枚目1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面1枚目2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面1枚目3, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面2枚目1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面2枚目2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面2枚目3, 基準日,
                        SubGyomuCode.DBE認定支援));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ両面1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ両面2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ両面3, 基準日,
                        SubGyomuCode.DBE認定支援));
            }
        }
    }

    private void call主治医意見書記入用紙OCR() {
        RDate 基準日 = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面3, 基準日,
                        SubGyomuCode.DBE認定支援));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート両面1, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート両面2, 基準日,
                        SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート両面3, 基準日,
                        SubGyomuCode.DBE認定支援));
            }
        }
    }

    private void getExecuteStep(RString rseValue) {
        if (DBE231012.equals(rseValue)) {
            executeStep(SHUJIIIKENSHO_DBE231012PROCESS);
        }
        if (DBE231014.equals(rseValue)) {
            executeStep(SHUJIIIKENSHO_DBE231014PROCESS);
        }
        if (DBE231002.equals(rseValue)) {
            executeStep(SHUJIIIKENSHO_DBE231002PROCESS);
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

    /**
     * 帳票「DBE231002_主治医意見書記入用紙」を出力します。
     *
     * @return ShujiiIkensho_DBE231002Process
     */
    @Step(SHUJIIIKENSHO_DBE231002PROCESS)
    protected IBatchFlowCommand callShujiiIkensho_DBE231002Process() {
        return loopBatch(ShujiiIkensho_DBE231002Process.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE231014_主治医意見書記入用紙」を出力します。
     *
     * @return ShujiiIkensho_DBE231014Process
     */
    @Step(SHUJIIIKENSHO_DBE231014PROCESS)
    protected IBatchFlowCommand callShujiiIkensho_DBE231014Process() {
        return loopBatch(ShujiiIkensho_DBE231014Process.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }

    /**
     * 帳票「DBE231012_主治医意見書記入用紙」を出力します。
     *
     * @return ShujiiIkensho_DBE231012Process
     */
    @Step(SHUJIIIKENSHO_DBE231012PROCESS)
    protected IBatchFlowCommand callShujiiIkensho_DBE231012Process() {
        return loopBatch(ShujiiIkensho_DBE231012Process.class)
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

}
