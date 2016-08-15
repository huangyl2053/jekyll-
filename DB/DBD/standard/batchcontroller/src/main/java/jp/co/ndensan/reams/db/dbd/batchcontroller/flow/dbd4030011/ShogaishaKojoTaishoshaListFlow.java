/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd4030011;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd4030011.ShogaishaKoujoTaishoNinteiShoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 障がい者控除対象者認定書リスト作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class ShogaishaKojoTaishoshaListFlow extends BatchFlowBase<ShogaishaKojoTaishoshaListParameter> {

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
