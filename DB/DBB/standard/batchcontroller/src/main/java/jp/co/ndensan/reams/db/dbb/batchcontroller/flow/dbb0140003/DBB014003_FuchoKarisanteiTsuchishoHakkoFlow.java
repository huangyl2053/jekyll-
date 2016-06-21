/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb0140003;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisanteitsuchishohakko.FuchoKarisanteiTsuchishoHakkoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 * 普徴仮算定通知書一括発行Flow
 *
 * @reamsid_L DBB-0710-030 gongliang
 */
public class DBB014003_FuchoKarisanteiTsuchishoHakkoFlow
        extends BatchFlowBase<FuchoKarisanteiTsuchishoHakkoBatchParameter> {

    private static final String FUCHOKARISANTEITSUCHIPROCESS = "FuchoKarisanteiTsuchishoHakkoProcess";

    @Override
    protected void defineFlow() {
        executeStep(FUCHOKARISANTEITSUCHIPROCESS);
    }

//    @Step(FUCHOKARISANTEITSUCHIPROCESS)
//    IBatchFlowCommand tableInsertProcess() {
//        return loopBatch(FuchoKarisanteiTsuchishoHakkoProcess.class).arguments(getParameter().toProcessParam()).define();
//    }
}
