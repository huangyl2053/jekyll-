/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710100.HanyoListHikazeiNenkinTaishoshaProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710100.DBD710100_HanyoListHikazeiNenkinTaishoshaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * バッチ設計_DBD710100_汎用リスト出力(非課税年金対象者)フロークラスです．
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
public class DBD710100_HanyoListHikazeiNenkinTaishosha extends BatchFlowBase<DBD710100_HanyoListHikazeiNenkinTaishoshaParameter> {

    private static final String 非課税年金対象者 = "HikazeiNenkinTaishosha";
    private RDate date;

    @Override
    protected void defineFlow() {
        date = RDate.getNowDate();
        executeStep(非課税年金対象者);
    }

    @Step(非課税年金対象者)
    IBatchFlowCommand callHikazeiNenkinTaishosha() {
        return loopBatch(HanyoListHikazeiNenkinTaishoshaProcess.class).arguments(getParameter().toProcessParameter(date)).define();
    }
}
