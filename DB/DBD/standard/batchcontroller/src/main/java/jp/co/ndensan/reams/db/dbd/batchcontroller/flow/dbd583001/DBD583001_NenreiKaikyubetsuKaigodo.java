/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd583001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd583001.NenreiKaikyubetsuYokaigodoJokyoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 年齢階級別要介護度状況（統計表）のバッチフロークラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class DBD583001_NenreiKaikyubetsuKaigodo extends BatchFlowBase<NenreiKaikyubetsuYokaigodoJokyoParameter> {

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
        return loopBatch(NenreiKaikyubetsuYokaigodoJokyoProcess.class).
                arguments(getParameter().toNenreiKaikyubetsuYokaigodoJokyoProcessParameter()).define();
    }

}
