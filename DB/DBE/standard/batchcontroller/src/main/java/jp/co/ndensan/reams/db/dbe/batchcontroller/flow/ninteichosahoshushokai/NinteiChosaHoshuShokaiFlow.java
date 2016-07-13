/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosahoshushokai.NinteiChosaHoshuShokaiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定調査報酬照会のバッチフロークラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
public class NinteiChosaHoshuShokaiFlow extends BatchFlowBase<NinteiChosaHoshuShokaiFlowParameter> {

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
        return loopBatch(NinteiChosaHoshuShokaiProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
