/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsahoshuichiran.ShinsaHoshuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsahoshuichiran.ShinsaHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 介護認定審査会委員報酬一覧表の帳票のバッチフロークラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public class ShinsaHoshuIchiranFlow extends BatchFlowBase<ShinsaHoshuIchiranBatchParameter> {

    private static final String SHINSA_HOSHU_ICHIRAN = "shinsahoshuichiran";

    @Override
    protected void defineFlow() {
        executeStep(SHINSA_HOSHU_ICHIRAN);
    }

    /**
     * 介護認定審査会委員報酬一覧表データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSA_HOSHU_ICHIRAN)
    IBatchFlowCommand shinsaHoshuIchiran() {
        return loopBatch(ShinsaHoshuIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
