/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.DBB0120002;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB0120002.TokuchoHeinjunkaKakuteiDbUpdateProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunkakakutei.TokuchoHeijunkaKakuteiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT35004_特徴平準化確定
 *
 * @reamsid_L DBB-0830-030 xuhao
 */
public class DBB0120002_TokuchoHeinjunkaKakuteiFlow extends BatchFlowBase<TokuchoHeijunkaKakuteiBatchParameter> {

    private static final String DB_UPDATE = "dbUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(DB_UPDATE);
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(TokuchoHeinjunkaKakuteiDbUpdateProcess.PARAMETER, getParameter());
        return simpleBatch(TokuchoHeinjunkaKakuteiDbUpdateProcess.class).arguments(parameter).define();
    }
}
