/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd581001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd581001.JissiJyokyohyoHakkouProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd581001.JissiJyokyohyoHakkouProcess2;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd581001.JissiJyokyohyoReportProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001.YokaigoJissiJyokyohyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 要介護認定実施状況表（統計表）のバッチフロークラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public class JissiJyokyohyoFlow extends BatchFlowBase<YokaigoJissiJyokyohyoParameter> {

    private static final String 実施状況表の作成 = "jissiJyokyohyoReport";
    private static final String 実施状況表の発行 = "jissiJyokyohyoHakkou";
    private static final String 実施状況表の発行2 = "jissiJyokyohyoHakkou2";

    @Override
    protected void defineFlow() {

        executeStep(実施状況表の作成);
        executeStep(実施状況表の発行);
        executeStep(実施状況表の発行2);
    }

    /**
     * 実施状況表の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(実施状況表の作成)
    protected IBatchFlowCommand jissiJyokyohyoReport() {
        return loopBatch(JissiJyokyohyoReportProcess.class)
                .arguments(getParameter().toYokaigoJissiJyokyohyoProcessParameter())
                .define();
    }

    /**
     * 実施状況表の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(実施状況表の発行)
    protected IBatchFlowCommand jissiJyokyohyoHakkou() {
        return loopBatch(JissiJyokyohyoHakkouProcess.class)
                .arguments(getParameter().toYokaigoJissiJyokyohyoProcessParameter())
                .define();
    }

    /**
     * 実施状況表の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(実施状況表の発行2)
    protected IBatchFlowCommand jissiJyokyohyoHakkou2() {
        return loopBatch(JissiJyokyohyoHakkouProcess2.class)
                .arguments(getParameter().toYokaigoJissiJyokyohyoProcessParameter())
                .define();
    }
}
