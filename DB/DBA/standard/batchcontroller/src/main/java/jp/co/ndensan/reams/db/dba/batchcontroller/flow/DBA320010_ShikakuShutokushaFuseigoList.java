/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA320010.ShikakuShutokushaFuseigoListProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA320010.DBA320010_ShikakuShutokushaFuseigoListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 資格取得者不整合リストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
public class DBA320010_ShikakuShutokushaFuseigoList extends BatchFlowBase<DBA320010_ShikakuShutokushaFuseigoListParameter> {

    private static final String 資格取得者不整合 = "shikakuShutokushaFuseigo";

    @Override
    protected void defineFlow() {
        executeStep(資格取得者不整合);
    }

    /**
     * 資格取得者不整合データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(資格取得者不整合)
    protected IBatchFlowCommand createShikakuShutokushaFuseigoData() {
        return simpleBatch(ShikakuShutokushaFuseigoListProcess.class)
                .arguments(getParameter().toShikakuShutokushaFuseigoProcessParameter()).define();
    }
}
