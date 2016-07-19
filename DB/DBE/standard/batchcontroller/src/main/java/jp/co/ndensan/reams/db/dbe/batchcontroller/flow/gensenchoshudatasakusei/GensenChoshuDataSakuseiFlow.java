/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.gensenchoshudatasakusei;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.gensenchoshudatasakusei.GensenChoshuDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuDataSakuseiFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 「源泉徴収データ作成」のバッチフロークラスです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
public class GensenChoshuDataSakuseiFlow extends BatchFlowBase<GensenChoshuDataSakuseiFlowParameter> {

    private static final String データ作成 = "gensenchoshudatasakusei";

    @Override
    protected void defineFlow() {
        executeStep(データ作成);
    }

    /**
     * 源泉徴収データ作成データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(データ作成)
    protected IBatchFlowCommand ninteichosahoshushokai() {
        return loopBatch(GensenChoshuDataSakuseiProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
