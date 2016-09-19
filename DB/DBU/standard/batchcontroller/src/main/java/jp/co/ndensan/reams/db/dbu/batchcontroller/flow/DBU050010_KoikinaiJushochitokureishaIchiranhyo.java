/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU050010.KoikinaiJushochiTokureiProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050010.DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 広域内住所地特例者一覧表_処理クラスです。
 * @reamsid_L DBU-1140-020 dongyabin
 */
public class DBU050010_KoikinaiJushochitokureishaIchiranhyo extends BatchFlowBase<DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter> {
    
    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }
    
    private static final String REPORT_PROCESS = "reportProcess";
    
    /**
     * 広域内住所地特例者情報を取得します。
     * @return 広域内住所地特例者情報の設定クラス
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return simpleBatch(KoikinaiJushochiTokureiProcess.class).
                arguments(getParameter().toProcessParamter()).define();
    }
}
