/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA010010.HihokenshaDaichoKoshinProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010.DBA010010_NenreitotatsuShikakuIdoParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * ６５歳年齢到達資格異動_バッチフロークラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public class DBA010010_NenreitotatsuShikakuIdo extends BatchFlowBase<DBA010010_NenreitotatsuShikakuIdoParameter> {

    private static final String 被保険者台帳管理と年齢到達条件の更新 = "updHihokenshaDaicho";

    @Override
    protected void defineFlow() {
        executeStep(被保険者台帳管理と年齢到達条件の更新);
    }

    /**
     * 資格異動対象者の取得と被保険者台帳の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(被保険者台帳管理と年齢到達条件の更新)
    protected IBatchFlowCommand updHihokenshaDaicho() {

        HihokenshaDaichoKoshinProcessParameter parameter;
        if (getParameter() == null || getParameter().getKaishiYMD() == null || getParameter().getKaishiYMD().isEmpty()
                || getParameter().getShuryoYMD() == null || getParameter().getShuryoYMD().isEmpty()) {
            parameter = setProccessParameter();
        } else {
            parameter = getParameter().toShikakuIdoTaishoshaShutokuProcessParameter();
        }
        return loopBatch(HihokenshaDaichoKoshinProcess.class)
                .arguments(parameter)
                .define();
    }

    private HihokenshaDaichoKoshinProcessParameter setProccessParameter() {
        HihokenshaDaichoKoshinProcessParameter param = new HihokenshaDaichoKoshinProcessParameter();
        param.set通常運用時(true);
        return param;
    }

}
