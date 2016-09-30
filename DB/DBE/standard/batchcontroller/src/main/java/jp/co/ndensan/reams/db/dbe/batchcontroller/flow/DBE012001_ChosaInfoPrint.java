/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE012001.ChosahyoIkenshoCheckListProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE012001.NinteichosaIraiHenkoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE012001.NinteichosaYoteiMiteiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE012001.DBE012001_ChosaInfoPrintParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 調査情報印刷のバッチ処理クラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
public class DBE012001_ChosaInfoPrint extends BatchFlowBase<DBE012001_ChosaInfoPrintParameter> {

    private static final String NINTEICHOSA_YOTEIMITEI = "ninteichosaYoteiMitei";
    private static final String NINTEICHOSA_IRAIHENKO = "ninteichosaIraiHenko";
    private static final String CHOSAHYO_IKENSHOCHECKLIST = "chosahyoIkenshoCheckList";

    @Override
    protected void defineFlow() {
        if (getParameter().isNinteichosayoteimitei()) {
            executeStep(NINTEICHOSA_YOTEIMITEI);
        }
        if (getParameter().isNinteichosaijoken()) {
            executeStep(NINTEICHOSA_IRAIHENKO);
        }
        if (getParameter().isCheckListJoken()) {
            executeStep(CHOSAHYO_IKENSHOCHECKLIST);
        }
    }

    @Step(NINTEICHOSA_YOTEIMITEI)
    IBatchFlowCommand ninteichosaYoteiMitei() {
        return loopBatch(NinteichosaYoteiMiteiProcess.class)
                .arguments(getParameter().toNinteichosaYoteiMiteiParamter())
                .define();
    }

    @Step(NINTEICHOSA_IRAIHENKO)
    IBatchFlowCommand ninteichosaIraiHenko() {
        return loopBatch(NinteichosaIraiHenkoProcess.class)
                .arguments(getParameter().toNinteichosaIraiHenkoParamter())
                .define();
    }

    @Step(CHOSAHYO_IKENSHOCHECKLIST)
    IBatchFlowCommand chosahyoIkenshoCheckList() {
        return loopBatch(ChosahyoIkenshoCheckListProcess.class)
                .arguments(getParameter().toChosahyoIkenshoCheckListParamter())
                .define();
    }
}
