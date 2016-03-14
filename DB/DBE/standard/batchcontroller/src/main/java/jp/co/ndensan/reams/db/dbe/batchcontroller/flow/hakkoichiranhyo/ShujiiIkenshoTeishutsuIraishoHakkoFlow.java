/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko.ShujiiIkenshoSakuseiIraishoProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 主治医意見書提出依頼書発行_バッチフロークラスです。
 */
public class ShujiiIkenshoTeishutsuIraishoHakkoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final String SHUJIIIKENSHOSAKUSEIIRAISHO = "ShujiiIkenshoSakuseiIraishoProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isShujiiIkenshoSakuseiIraisho()) {
            executeStep(SHUJIIIKENSHOSAKUSEIIRAISHO);
        }
        //TODO 対応帳票が未実装
//        if (印刷.equals(getParameter().getIkenshoKinyuu())) {
//            //Temp_主治医意見書記入用紙フォームID
//
//        }
//        if (印刷.equals(getParameter().getIkenshoKinyuuOCR())) {
//            //Temp_主治医意見書記入用紙OCR
//        }
//        if (印刷.equals(getParameter().getIkenshoSakuseiSeikyuusho())) {
//            //Temp_主治医意見書作成料依頼請求書
//        }
    }

    /**
     * 帳票データ作成のProcessです。
     *
     * @return 主治医意見書作成依頼書Process
     */
    @Step(SHUJIIIKENSHOSAKUSEIIRAISHO)
    protected IBatchFlowCommand shujiiIkenshoSakuseiIraishoProcess() {
        return loopBatch(ShujiiIkenshoSakuseiIraishoProcess.class)
                .arguments(getParameter().toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter()).define();
    }
}
