/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.IkenshoSakuseiIraiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSakuseiIraishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSakuseiRyoSeikyushoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoTeishutsuIraishoProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 主治医意見書提出依頼書発行_バッチフロークラスです。
 */
public class ShujiiIkenshoTeishutsuIraishoHakkoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final String IKENSHOSAKUSEIIRAIICHIRANHYO = "IkenshoSakuseiIraiIchiranhyoProcess";

    private static final String SHUJIIIKENSHOSAKUSEIIRAISHO = "ShujiiIkenshoSakuseiIraishoProcess";
    private static final String IKENSHOSAKUSEIRYOSEIKYUSHO = "ShujiiIkenshoSakuseiRyoSeikyushoProcess";
    private static final String SHUJIIIKENSHOTEISHUTSUIRAISHO = "ShujiiIkenshoTeishutsuIraishoProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isIkenshoSakuseiirai()) {
            executeStep(IKENSHOSAKUSEIIRAIICHIRANHYO);
            //主治医意見書作成依頼一覧表
        }
        //TODO 帳票を未実装するので、Process実装不可
        if (getParameter().isIkenshoSakuseiSeikyuu()) {
            //主治医意見書作成料請求一覧表
        }
        if (getParameter().isShujiiIkenshoSakuseiIraisho()) {
            executeStep(SHUJIIIKENSHOSAKUSEIIRAISHO);
        }
        //TODO 帳票を未実装するので、Process実装不可
        if (getParameter().isIkenshoKinyuu()) {
            //主治医意見書記入用紙
        }
        //TODO 帳票を未実装するので、Process実装不可
        if (getParameter().isIkenshoKinyuuOCR()) {
            //主治医意見書記入用紙OCR
        }
        if (getParameter().isIkenshoSakuseiSeikyuusho()) {
            executeStep(IKENSHOSAKUSEIRYOSEIKYUSHO);
            //Temp_主治医意見書作成料依頼請求書
        }
        if (getParameter().isIkenshoTeishutu()) {
            //介護保険指定医依頼兼主治医意見書提出意見依頼書
            executeStep(SHUJIIIKENSHOTEISHUTSUIRAISHO);
        }
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

}
