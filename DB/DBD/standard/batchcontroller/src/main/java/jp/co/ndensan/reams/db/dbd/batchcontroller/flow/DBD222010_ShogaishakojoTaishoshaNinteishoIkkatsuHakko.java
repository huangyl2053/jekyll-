/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD222010.ShogaishaKoujoTaishoNinteiShoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD222010.DBD222010_ShogaishakojoTaishoshaNinteishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 障がい者控除対象者認定書リスト作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class DBD222010_ShogaishakojoTaishoshaNinteishoIkkatsuHakko
        extends BatchFlowBase<DBD222010_ShogaishakojoTaishoshaNinteishoIkkatsuHakkoParameter> {

    private static final String 障がい者控除対象者認定書 = "shogaishaKoujoTaishoNinteiSho";

    @Override
    protected void defineFlow() {
        executeStep(障がい者控除対象者認定書);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(障がい者控除対象者認定書)
    protected IBatchFlowCommand shogaishaKoujoTaishoNinteiSho() {
        return loopBatch(ShogaishaKoujoTaishoNinteiShoProcess.class).
                arguments(getParameter().toShogaishakojoTaishoshaListProcessParameter()).define();
    }

}
