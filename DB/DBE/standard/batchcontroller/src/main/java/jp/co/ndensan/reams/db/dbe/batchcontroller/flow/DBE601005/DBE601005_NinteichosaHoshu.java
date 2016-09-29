/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.DBE601005;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601005.NinteichosaHoshuProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.DBE601005_NinteichosaHoshuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定調査報酬照会のバッチフロークラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
public class DBE601005_NinteichosaHoshu extends BatchFlowBase<DBE601005_NinteichosaHoshuParameter> {

    private static final String データ作成 = "ninteichosahoshushokai";

    @Override
    protected void defineFlow() {
        executeStep(データ作成);
    }

    /**
     * 認定調査報酬照会データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(データ作成)
    protected IBatchFlowCommand ninteichosahoshushokai() {
        return loopBatch(NinteichosaHoshuProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
