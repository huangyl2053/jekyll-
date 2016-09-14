/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd4010011;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBDMN41001_障がい者控除対象者把握のバッチフロークラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranFlow extends BatchFlowBase<ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter> {

    private static final String 減免減額申請更新 = "update減免減額申請List";
    private static final String CSV_PROCESS = "csvProcess";

    @Override
    protected void defineFlow() {
        executeStep(減免減額申請更新);
        executeStep(CSV_PROCESS);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額申請更新)
    protected IBatchFlowCommand update減免減額申請List() {
        return loopBatch(ShogaishaKojoTaishoshaHaakuKekkaIchiranProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_PROCESS)
    protected IBatchFlowCommand csvProcess() {
        return loopBatch(ShogaishaKojoTaishoshaHaakuKekkaIchiranCsvProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    private ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter createProcessParameter() {
        ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter parameter = getParameter();
        ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter processParameter = new ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set対象年度(parameter.get対象年度());
        processParameter.set決定年月日(parameter.get決定年月日());
        processParameter.set申請年月日(parameter.get申請年月日());
        processParameter.set基準日より後に資格喪失した者(parameter.is基準日より後に資格喪失した者());
        processParameter.set前回把握時の非該当者(parameter.is前回把握時の非該当者());
        return processParameter;
    }

}
