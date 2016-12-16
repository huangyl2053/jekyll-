/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE223001.NinteiChosaTokusokujoReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE223001.DBE223001_NinteichosaTokusokujyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定調査督促状発行のバッチフロークラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class DBE223001_NinteichosaTokusokujyo extends BatchFlowBase<DBE223001_NinteichosaTokusokujyoParameter> {

    private static final String 要介護認定調査督促状の作成 = "ninteiChosaTokusokujoReport";
    private static final String 認定調査督促対象者一覧表の作成 = "ninteiChosaTokusokuTaishoshaIchiranhyoReport";
    private static final String 要介護認定調査督促状_選択された = "1";
    private static final String 認定調査督促対象者一覧表_選択された = "1";

    @Override
    protected void defineFlow() {

        if (要介護認定調査督促状_選択された.equals(getParameter().getTemp_要介護認定調査督促状().toString())) {
            executeStep(要介護認定調査督促状の作成);
        }
        if (認定調査督促対象者一覧表_選択された.equals(getParameter().getTemp_認定調査督促対象者一覧表().toString())) {
            executeStep(認定調査督促対象者一覧表の作成);
        }
    }

    /**
     * 要介護認定調査督促状の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定調査督促状の作成)
    protected IBatchFlowCommand ninteiChosaTokusokujoReport() {
        return loopBatch(NinteiChosaTokusokujoReportProcess.class)
                .arguments(getParameter().toNinteiChosaTokusokujoProcessParameter())
                .define();
    }

    /**
     * 認定調査督促対象者一覧表の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表の作成)
    protected IBatchFlowCommand ninteiChosaTokusokuTaishoshaIchiranhyoReport() {
        return loopBatch(NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess.class)
                .arguments(getParameter().toNinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter())
                .define();
    }

}
