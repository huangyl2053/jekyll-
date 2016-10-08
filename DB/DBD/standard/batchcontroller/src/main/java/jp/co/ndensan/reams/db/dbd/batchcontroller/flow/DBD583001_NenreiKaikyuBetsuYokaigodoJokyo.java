/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD583001.NenreiKaikyubetsuYokaigodoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD583001.DBD583001_NenreiKaikyuBetsuYokaigodoJokyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 年齢階級別要介護度状況（統計表）のバッチフロークラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class DBD583001_NenreiKaikyuBetsuYokaigodoJokyo extends BatchFlowBase<DBD583001_NenreiKaikyuBetsuYokaigodoJokyoParameter> {

    private static final String 集計表出力 = "get集計表出力";

    @Override
    protected void defineFlow() {
        executeStep(集計表出力);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(集計表出力)
    protected IBatchFlowCommand get集計表出力() {
        return loopBatch(NenreiKaikyubetsuYokaigodoProcess.class).
                arguments(getParameter().toNenreiKaikyubetsuYokaigodoJokyoProcessParameter()).define();
    }

}
