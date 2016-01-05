/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.koikinaiJushochitokurei;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.koikinaiJushochitokurei.KoikinaiJushochiTokureiProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.koikinaiJushochitokurei.KoikinaiJushochiTokureiBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 広域内住所地特例者一覧表_処理クラスです。
 */
public class KoikinaiJushochiTokureiFlow extends BatchFlowBase<KoikinaiJushochiTokureiBatchParamter>{
    
    private static final String REPORT_PROCESS = "reportProcess";

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }
    
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return simpleBatch(KoikinaiJushochiTokureiProcess.class).define();
    }
}
