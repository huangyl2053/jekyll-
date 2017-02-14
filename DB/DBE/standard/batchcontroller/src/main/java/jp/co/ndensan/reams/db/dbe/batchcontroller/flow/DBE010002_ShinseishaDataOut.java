/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002.ChosahyoJohoCsvOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002.IkenshoJohoCsvOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002.KihonJohoCsvOutputProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE010002.DBE010002_ShinseishaDataOutParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 申請データ出力のバッチフロークラスです。
 *
 * @author N3212 竹内 和紀
 */
public class DBE010002_ShinseishaDataOut extends BatchFlowBase<DBE010002_ShinseishaDataOutParameter> {

    private static final String KIHONJOHO_CSVOUTPUT = "kihonJohoCsvOutput";
    private static final String CHOSAHYOJOHO_CSVOUTPUT = "chosahyoJohoCsvOutput";
    private static final String IKENSHOJOHO_CSVOUTPUT = "ikenshoJohoCsvOutput";

    @Override
    protected void defineFlow() {
        if (getParameter().is基本情報出力()) {
            executeStep(KIHONJOHO_CSVOUTPUT);
        }
        if (getParameter().is調査票情報出力()) {
            executeStep(CHOSAHYOJOHO_CSVOUTPUT);
        }
        if (getParameter().is意見書情報出力()) {
            executeStep(IKENSHOJOHO_CSVOUTPUT);
        }
    }

    @Step(KIHONJOHO_CSVOUTPUT)
    protected IBatchFlowCommand kihonJohoCsvOutput() {
        return loopBatch(KihonJohoCsvOutputProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

    @Step(CHOSAHYOJOHO_CSVOUTPUT)
    protected IBatchFlowCommand chosahyoJohoCsvOutput() {
        return loopBatch(ChosahyoJohoCsvOutputProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

    @Step(IKENSHOJOHO_CSVOUTPUT)
    protected IBatchFlowCommand ikenshoJohoCsvOutput() {
        return loopBatch(IkenshoJohoCsvOutputProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }
}
